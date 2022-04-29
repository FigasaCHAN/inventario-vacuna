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
   Vacuna vacuna; //si es distinto de null, entonces DatosPersonales.estaVacunado debe ser true
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
### Implementacion:
Durante el proceso de implementación tuve distintas estrategia, y admito que todavía le queda pulir al proyecto, sobre todo la SEGURIDAD. 
En un principio creé el proyecto con solo tres capas (paquetes), las cuales son:
* Model: La cual se encarga de contener el modelo
* Repository: El repositorio es nuestro acceso a los datos externos (como una Base de Datos)
* Service: El servico es quien se encarga de la lógica 
Luego de esto, necesitaba una más para alojar a quienes se encargarían de las peticiones, el paquete Rest.

Por otro lado, después de leer varios post y ver distintos videos con respeto al tema de buenas practica, implementé la practica de dividir el paquete Service en Interfaces e Implementaciones. Por qué? para abstraerme de la implementación del servicio... Esto hace un código más sustentable, ya que la interfaz es lo que define al servico, en otra palabras es lo que sabe realizar el servicio. Con esta interfaz, si se agrega alguna funcionabilidad nueva, obligaría a las implementaciones a realizarlas.
En un proyecto podemos tener varias implementaciones de un mismo servicio, podríamos realizar varias implementaciones con distintos repositorios. 

Un punto que me hubiese gustado agregar, y es donde falla mi actual diseño, es utilizar un objeto DAO para proteger ciertos datos como la contraseña del usuario, por ejemplo. Con esto, los Rest solo expondrán los datos que YO quiera. Actualmente la contraseña del usuario está expuesta.
