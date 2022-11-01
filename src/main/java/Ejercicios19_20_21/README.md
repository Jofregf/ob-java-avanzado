*****2º Identifica las características principales de la arquitectura limpia, indica en que casos se tendría que
utilizar la arquitectura limpia y como lo harías.

Los principios de la arquitectura limpia nos instan a estructurar nuestro software en  4 capas principales:
-1º Entidades: Define la capa de negocio (Servicios, modelos de datos, gestión de cachés, ...)
-2º Casos de uso: Es donde debe estar la lógica o las reglas de la aplicación. Ej: los métodos concretos de cada clase
-3º Controladores: Es donde se incluiría la implementación de los métodos generales que podríamos usar con cualquier objeto.
-4º Todo lo demás: Frameworks, drivers, ...

La arquitectura limpia se asocia a los principios SOLID.
-S = Single Responsibility Principle (SRP)

-O = Open/Closed Principle (OCP)
(Las entidades tienen que estar abiertas a la hora de responder, pero cerradas a la hora de modificarlas)

-L = Liskov Substitution Principle (LSP)
Principio de sustitución (Una clase se tiene que poder sustituir Y, si falla, es que se está violando el principio)

-I – Interface Segregation Principle (ISP)
Una clase no debe depender de una interfaz que no va a utilizar:
La clase solo debe implementar la interfaz o interfaces que sean coherentes con su clase,
*Ej: Un perro no implementaría una interfaz que incluya el método volar. Lo ideal sería una interfaz que implemente
métodos generales para animales, otra que implemente métodos (animales voladores), otra (animales que naden), ...

D – Dependency Inversion Principle (DIP)
Las dependencias se tienen que abstraer. Un módulo de alto nivel no debe depender de un módulo de bajo nivel.
(Vamos a intentar implementar métodos abstractos de forma genérica en lugar de acceder a un método concreto de la clase hija)

--La arquitectura limpia debe ser implementada siempre en la medida de lo posible, intentando cumplir todos los principios
SOLID.
Con ello, conseguiremos un código mínimamente acoplado, que será mucho más fácil de leer, reparar, mantener y mejorar,
aunque no sea por el mismo programador, o incluso siéndolo, facilitará sustancialmente el trabajo del mismo.
