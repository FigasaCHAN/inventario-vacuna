# Inventario de vacunas - Kruger

Este proyecto fue creado como prueba técnica, fue un verdadero desafío.

## Proceso:
Fue mi primer APIRest utilizando Java y Spring Boot, desde el primer commit hasta el ultimo fui implementando distintas estrategias pero todas partiendo desde un primer análisis.

Primero realicé un análisis de las distintas clases que pertenecen al modelo, abstrayéndome del cómo implementarlo.

### Análisis de clases, con su invariante de representación:
```java
public class Usuario { 
//Pensé que lo mejor era representar a un usuario como un solo objeto, ya que en algún futuro un Empleado se vuelva Administrador y no perder sus datos.
   private String nombre; //no puede estar vacio & distinto de null & no caracteres especiales & primera letra en mayus & un leng maximo
   private String apellido; //no puede estar vacio & distinto de null & no caracteres especiales & primera letra en mayus & un leng maximo
   private String cedula; //no puede estar vacio & distinto de null & leng == 10 & solo numeros && es UNICO
   private String email; //formato de email valido "ejemplo@ejemplo.com"
   private String usuario; //no puede estar vacio & distinto de null 
   private String contraseña; //no puede estar vacio & distinto de null & 
   private DatosPersonales; 
   Rol rolDelUsuario;

  public Usuario(String cedula, String nombre, String apellido, String email); //Constructor que representa correctamente a un usuario. Para cumplir el IREP aqui es donde asigno un usuario y una contraseña. 
}
```  

```java
 public abstract class Rol:
   String nombreDelRol; //para este modelo solo permito que sea igual a "Administrador" o "Empleado"
```

```java
 public class RolAdmin extends Rol {
   private static HashMap<String,Usuario> diccionarioUsuarios; //diccionario con todos los usuarios, Key= cedula y Value = Usuario. Es Static porque será unico para todos los Administradores

   public void agregarUsuario(Usuario nuevo);
   public void modificaUsuario(String cedula, DatosPersonales nuevo); 
   public void eliminarUsuario(String cedula);
   public List <Usuario> filtrarPorEstadoDeVacunacion(boolean estado); 
   public List <Usuario> filtrarPorTipoDeVacuna(String nombreDeVacuna); 
   public List <Usuario> filtrarPorRangoDeFecha(Fecha inicio, Fecha final); //obj Fecha es orientativo
}
```

```java
public class RolEmpleado extends Rol{
   private DatosPersonales datosPersonales;

   //Los metodos interactúan sobre la variable datos personales
   public void modificarFechaDeNacimiento(Fecha fechaDeNacimiento);
   public void modificarDomicilio(String nuevoDomicilio);
   public void modificarTelefonoMovil(String nuevoTelefonoMovil);
   public void modificarEstadoDeVacunacion(boolean nuevoEstado);
} 
```  
```java
public class DatosPersonales {
     String fechaDeNacimiento;
     String domicilio;
     String telefonoMovil;
     String estadoDeVacunacion;
     Vacuna vacuna; //si es distinto de null, entonces estaDoDeVacunacion debe ser true

   //Los metodos interactúan sobre la variable datos personales
   public void modificarFechaDeNacimiento(Fecha fechaDeNacimiento);
   public void modificarDomicilio(String nuevoDomicilio);
   public void modificarTelefonoMovil(String nuevoTelefonoMovil);
   public void modificarEstadoDeVacunacion(boolean nuevoEstado);
} 
```  
## Implementacion:
Durante el proceso de implementación tuve distintas estrategia, y admito que todavía le queda pulir al proyecto, sobre todo la SEGURIDAD. 
En un principio creé el proyecto con solo tres capas (paquetes), las cuales son:
* Model: La cual se encarga de contener el modelo
* Repository: El repositorio es nuestro acceso a los datos externos (como una Base de Datos)
* Service: El servico es quien se encarga de la lógica 
Luego de esto, necesitaba una más para alojar a quienes se encargarían de las peticiones, el paquete Rest.

Por otro lado, después de leer varios post y ver distintos videos con respeto al tema de buenas practica, implementé la practica de dividir el paquete Service en Interfaces e Implementaciones. Por qué? para abstraerme de la implementación del servicio... Esto hace un código más sustentable, ya que la interfaz es lo que define al servico, en otra palabras es lo que sabe realizar el servicio. Con esta interfaz, si se agrega alguna funcionabilidad nueva, obligaría a las implementaciones a realizarlas.
En un proyecto podemos tener varias implementaciones de un mismo servicio, podríamos realizar varias implementaciones con distintos repositorios. 

Un punto que me hubiese gustado agregar, y es donde falla mi actual diseño, es utilizar un objeto DAO para proteger ciertos datos como la contraseña del usuario, por ejemplo. Con esto, los Rest solo expondrán los datos que YO quiera. Actualmente la contraseña del usuario está expuesta.

Un problema que tuve fue relacionar un objeto con otro, por ejemplo el objeto DatosPersonales según nuestro modelo contiene una Vacuna. Para solucionar esto, se utiliza una base de datos relacional, con esto presente para implementar los filtros he utilizado las query por propiedad que me brinda JPA en el repositorio.
Como regla, los ID de los objetos DatosPersonales y Vacuna tienen que ser iguales a los del objeto Usuario. (Actualmente se debe escribir manualmente el id, no pude solucionar eso)

### Filtro segun el estado de vacunacion
Para el filtro de Estado de Vacunacion, accedo al repositorio de DatosPersonales, obtengo todos los ID y luego retorno una lista de usuarios.
```java
    @Override
    public List<Usuario> getVacunados(boolean vacunado) {
        List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
        List<DatosPersonales> listaDeVacunas = vacunado? datosPersonalesRepository.findByVacunaIsNotNull() :datosPersonalesRepository.findByVacunaIsNull() ;

        for(DatosPersonales elem : listaDeVacunas){
            String idABuscar= elem.getId();
            Usuario usuarioEncontrado = this.findById(idABuscar);
            listaDeUsuarios.add(usuarioEncontrado);
        }
        return listaDeUsuarios;
    }
```  
### Filtro según el tipo de vacuna
Para este filtro se utiliza la misma estrategia, obtengo la lista de vacunas segun el tipo, recojo su id y luego creo una lista con los usuarios.
```java
    @Override
    public List<Usuario> getVacunados(String vacuna) {
        List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
        List<Vacuna> listaDeVacunas = vacunasRepository.findByTipo(vacuna);

        for(Vacuna elem : listaDeVacunas){
            String idABuscar= elem.getId();
            Usuario usuarioEncontrado = this.findById(idABuscar);
            listaDeUsuarios.add(usuarioEncontrado);
        }

        return listaDeUsuarios;
    }
```  
### Filtro entre rango de Fecha
Por cuestión de tiempo, no he implementado esta funcionalidad. Pero se me ocurre una manera, primero debería cambiar el tipo de dato utilizado para la Fecha y luego crear una query para saber el rango.

#
### Respetar IREP del modelo
Para esto he utilizado las etiquetas Validation, las cuales permitió poner limites con expresiones regulares utilizado, por ejemplo, en el campo fecha guardado como string.  
Comentario: Si bien los datos se pueden validar en el FrontEnd, lo ideal es que el backend tambien tenga ese escudo porque sino podríamos tener datos incorrectos en la base de datos.
