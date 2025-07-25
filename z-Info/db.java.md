 # Preparación del contenido bases de datos en Java

Java: Object-relational mapping Essential Training
LinkedIn Learning by Mariona Nadal

- [Preparación del contenido bases de datos en Java](#preparación-del-contenido-bases-de-datos-en-java)
  - [Introducción](#introducción)
    - [Historia: Bases de datos](#historia-bases-de-datos)
    - [Historia: Java y bases de datos](#historia-java-y-bases-de-datos)
  - [Configuración](#configuración)
    - [Dependencias Maven](#dependencias-maven)
    - [Creación de la DB con MySQL Workbench](#creación-de-la-db-con-mysql-workbench)
    - [Configuración de Hibernate](#configuración-de-hibernate)
  - [Primera entidad: Entity, DAO y EntityManager](#primera-entidad-entity-dao-y-entitymanager)
    - [Entidades](#entidades)
    - [DAO: Interface](#dao-interface)
    - [Gestión de la conexión: EntityManager](#gestión-de-la-conexión-entitymanager)
    - [DAO: Implementación](#dao-implementación)
    - [Métodos específicos de un DAO concreto](#métodos-específicos-de-un-dao-concreto)
  - [Múltiple entidades](#múltiple-entidades)
    - [Entidad Room: Relaciones 1:N](#entidad-room-relaciones-1n)
      - [Implementación del DAO para Room](#implementación-del-dao-para-room)
    - [Entidad MeetingRecord: Relaciones 1:1](#entidad-meetingrecord-relaciones-11)
      - [Implementación del DAO para MeetingRecord](#implementación-del-dao-para-meetingrecord)
    - [Entidad Person: Relaciones N:M](#entidad-person-relaciones-nm)
      - [Implementación del DAO para Person](#implementación-del-dao-para-person)

## Introducción

A lo largo de los años, la integración de **bases de datos** en Java ha evolucionado significativamente. Inicialmente, el acceso a datos se realizaba mediante **SQL**, el lenguaje estándar para la gestión de bases de datos relacionales. Java introdujo **JDBC** (Java Database Connectivity) como su primera API para permitir la comunicación directa con bases de datos, proporcionando una interfaz para ejecutar consultas y gestionar conexiones.

Con el crecimiento de aplicaciones más complejas, surgió la necesidad de simplificar el manejo de datos y reducir el código repetitivo. Así nació **JPA** (Java Persistence API), una especificación que define el mapeo objeto-relacional (**ORM**), permitiendo trabajar con datos como objetos Java y abstraer gran parte de la lógica de persistencia. **Hibernate**, una de las implementaciones más populares de JPA, ofrece funcionalidades avanzadas para la gestión eficiente de entidades, transacciones y consultas, facilitando el desarrollo de aplicaciones robustas y escalables.

Esta evolución ha permitido a los desarrolladores Java trabajar de manera más productiva y segura con bases de datos, adaptándose a los cambios tecnológicos y a las necesidades de las aplicaciones modernas.

### Historia: Bases de datos

La informática desde siempre ha necesitado manejar datos, pero no fue hasta los años **60s** del siglo pasado que aparecieron los primeros sistemas de **bases de datos**, en los que había que ir recorriendo los registros uno a uno sin posibilidades de buscar datos concretos, como mucho, algunos sistemas conseguían guardarlos ordenados.

Ya la década de los **70s** aparecen los modelos relacionales; un trabajador de IBM tuvo la idea de usar tablas de forma que los datos se dividían en series de tablas, correlaciones, enlazados entre sí con claves. Pero no fue hasta finales de esa década que se estandarizó el uso de **SQL**, Structured Query Language, es decir, lenguaje de consulta estructurada. Ya había por entonces varios sistemas gestores de bases de datos, como Postgres u Oracle, que aún se usan hoy en día, con alguna evolución, claro.

Con el surgir de la programación orientada a objetos en los **80s**, se intentaron algunos sistemas de bases de datos también orientados a objetos, pero nunca llegaron a triunfar. Ya entrados en el siglo XXI, aparecieron los sistemas **no SQL**, como por ejemplo, MongoDB. Aunque estos sistemas se usan hoy en día en multitud de aplicaciones, los sistemas relacionados SQL siguen siendo los reyes del manejo de datos.

### Historia: Java y bases de datos

La interacción directa entre Java y sistemas de bases de datos anteriores a la programación orientada a objetos, no es sencilla.

Java nació en los **90s** y su primera API para acceder a bases de datos fue **JDBC**, Java Database Connectivity, que permitía conectarse a bases de datos relacionales y ejecutar sentencias SQL directamente. Aunque JDBC es potente, requiere mucho código repetitivo para manejar conexiones, consultas y resultados.
En este contexto se usaron los Enterprise JavaBeans, pero con la llegada del **nuevo siglo**, llegó **Hibernate** para desbancarlas; se trata de una herramienta que intenta hacer casar el modelo de datos que se usa durante la ejecución del programa, que está en memoria, y cuando programamos en Java es orientado a objetos con la base de datos, generalmente, almacenada en disco y con un modelo relacional.

La idea gustó, y en **2006** se lanzaron las especificaciones de la interfaz de programación API, de persistencia Java, conocida como **JPA**. Se llama persistencia a la capa de las aplicaciones que se encarga de gestionar los datos que se guardan, que persisten incluso cuando el programa no está funcionando, es decir, las bases de datos. Tras esa estandarización, Hibernate se adaptó a ella. **JPA + Hibernate**, son herramientas para resolver el **mapeo objeto-relacional** (**ORM**).

## Configuración

- Servidor de DB: MySQL
  - Instalar
  - Asignar puerto
  - Crear usuario y contraseña
- Dependencias Maven
  - Añadir dependencias de Hibernate (y JPA)
  - Añadir dependencias de MySQL Connector
- Cliente de DB: MySQL Workbench

### Dependencias Maven

Partimos de un proyecto Maven QuickStart
Dependencias en el `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>7.0.5.Final</version>
    </dependency>
</dependencies>
```

Vemos la gran cantidad de dependencia que se incorporan en el proyecto.

Quizás, si se usa JPA, también es necesario añadir la dependencia de `hibernate-entitymanager`:

```xml
<dependencies>
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-entitymanager</artifactId>
        <version>5.4.32.Final</version>
    </dependency>
</dependencies>
```

La dependencia de dotenv-java nos permite cargar las variables de entorno desde un fichero `.env`, lo que es útil para manejar configuraciones sensibles como contraseñas de bases de datos sin incluirlas directamente en el código fuente:

```xml
  <dependency>
      <groupId>io.github.cdimascio</groupId>
      <artifactId>dotenv-java</artifactId>
      <version>3.2.0</version>
  </dependency>
```

### Creación de la DB con MySQL Workbench

```sql
CREATE DATABASE mi_base_de_datos;

USE mi_base_de_datos;

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);
```

Añadimos algunos registros.

### Configuración de Hibernate

Usamos la forma de trabajar con Hibernate acorde con el estándar JPA, creando un fichero `persistence.xml` en la carpeta `src/main/.../resources/META-INF/` (en el paquete base del proyecto):

```xml
<?xml version="1.0" encoding="UTF-8"?>
    <persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
                version="2.2">
      <persistence-unit name="miUnidadDePersistencia">
          <!-- Proveedor de persistencia -->
          <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
          <!-- Clase de entidad principal -->
          <class>local.domain.Meeting</class>
          <properties>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.schemma-generation.database.action" value="update"/>
            <!-- Los siguientes valores pueden definirse desde la aplicación -->
            <!-- url, user, passwd" -->
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/demo_mvn1?useSSL=false&amp;serverTimezone=UTC"/>
            <property name="jakarta.persistence.jdbc.user" value=""/>
            <property name="jakarta.persistence.jdbc.password" value=""/>
            <!-- Hibernate properties -->
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
          </properties>
      </persistence-unit>
</persistence>
```

Ver ejemplo en el proyecto `demo-mvn1`.

## Primera entidad: Entity, DAO y EntityManager

Los DAOs (Data Access Objects) son patrones de diseño que proporcionan una forma de separar la lógica de acceso a datos del resto de la aplicación. En el contexto de JPA y Hibernate, los DAOs permiten interactuar con las entidades de la base de datos sin necesidad de escribir consultas SQL directamente.

### Entidades

Las entidades son clases Java que representan tablas en la base de datos. Cada instancia de una entidad corresponde a una fila en la tabla. Las entidades se anotan con `@Entity` y pueden tener relaciones entre ellas, como `@OneToMany`, `@ManyToOne`, etc. Es convenio incluirlas en la carpeta `domain` del proyecto.

```java

@Entity
@Table(name = "meetings")
public class Meeting {

    // @Column(name = "id")
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // @Column(name = "date", nullable = false)
    private LocalDateTime date;
    // @Column(name = "description", nullable = true)
    private String description;

    public Meeting() {
        // Default constructor for JPA
    }

    public Meeting(LocalDateTime date, String description) {fin
        this.date = date;
        this.description = description;
    }

  // Getters and Setters
  //  @Override toString() method
}
```

Las anotaciones JPA se utilizan para definir cómo se mapean las clases Java a las tablas de la base de datos. Por ejemplo, `@Entity` indica que la clase es una entidad persistente, `@Table` especifica el nombre de la tabla y `@Id` marca el campo que es la clave primaria.
El uso de `@GeneratedValue(strategy = GenerationType.IDENTITY)` indica que el valor del campo `id` se generará automáticamente por la base de datos, lo que es común para las claves primarias.
`@Column` solo es necesario si se quiere cambiar el nombre de la columna o añadir restricciones adicionales.

Por lo demas la clase incluye un constructor por defecto y otro que permite inicializar los campos `date` y `description`. También es recomendable incluir los métodos `getters` y `setters` para acceder a los atributos de la entidad, así como un método `toString()` para facilitar la visualización de los objetos.

### DAO: Interface

El patrón DAO proporciona una interfaz para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en las entidades. Es muy similar al patrón Repository de Spring Data y otros entornos.

Antes de crear un DAO específico para una entidad, es buena práctica definir una interfaz base que contenga los métodos comunes para todas las entidades. Esta interfaz puede incluir métodos como `save`, `findById`, `findAll`, `update` y `delete`.

```java
public interface GenericDAO<T> {
  List<T> findAll();
  <ID> Optional<T> findById(ID id);
  void save(T entity);
  void update(T entity);
  void delete(T entity);
}
```

### Gestión de la conexión: EntityManager

El `EntityManager` es la interfaz principal de JPA para interactuar con la base de datos. Se utiliza para crear, leer, actualizar y eliminar entidades. El `EntityManager` se obtiene a través de un `EntityManagerFactory`, que se configura con las propiedades de conexión a la base de datos.

````java
public class EntityManagerProvider {
    private static EntityManagerFactory entityManagerFactory;

    static {
       final String PERSISTENT_UNIT = "demo-mvn1";
       entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENT_UNIT);
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager entityManager) {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && !entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}

En este nivel es posible añadir configuraciones adicionales, como la carga de variables de entorno desde un fichero `.env` para manejar las credenciales de la base de datos de forma segura:

```java
    Dotenv dotEnv = Dotenv.load();
    Map<String, String> props = new HashMap<>();
    props.put("jakarta.persistence.jdbc.url", dotEnv.get("DB_URL"));
    props.put("jakarta.persistence.jdbc.user", dotEnv.get("DB_USER"));
    props.put("jakarta.persistence.jdbc.password", dotEnv.get("DB_PASS"));

    entityManagerFactory = Persistence.createEntityManagerFactory("demo-mvn1", props);
````

### DAO: Implementación

A partir de la interfaz `GenericDAO`, se puede crear una implementación específica para cada entidad. Esta implementación utilizará el `EntityManager` para realizar las operaciones CRUD.

Un DAO típico para la entidad `Meeting` podría verse así:

```java
public class MeetingDAO implements GenericDAO<Meeting> {
    private EntityManager entityManager;

    public MeetingDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Meeting meeting) {
        entityManager.getTransaction().begin();
        entityManager.persist(meeting);
        entityManager.getTransaction().commit();
    }
    @Override
    public <ID> Meeting findById(ID id) {
        return entityManager.find(Meeting.class, id);
    }
    @Override
    public List<Meeting> findAll() {
        TypedQuery<Meeting> query = entityManager.createQuery("SELECT m FROM Meeting m", Meeting.class);
        return query.getResultList();
    }
    @Override
    public void update(Meeting meeting) {
        entityManager.getTransaction().begin();
        entityManager.merge(meeting);
        entityManager.getTransaction().commit();
    }
    @Override
    public void delete(Meeting meeting) {
        entityManager.getTransaction().begin();
        if (!entityManager.contains(meeting)) {
            meeting = entityManager.merge(meeting);
        }
        entityManager.remove(meeting);
        entityManager.getTransaction().commit();
    }
}
```

Otra opción sería crear un DAO genérico que pueda manejar cualquier entidad, utilizando la interfaz `GenericDAO` en una clase base abstracta:

En el definimos un método privado que permita desstionarizar las transacciones de forma genérica:

```java
private void executeInTransaction(Consumer<EntityManager> action) {
    EntityTransaction tx = entityManager.getTransaction();
    try {
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    } catch (Exception e) {
        tx.rollback();
        throw e;
    }
}
```

Usando este método se facilita la implementación de los métodos `save`, `update` y `delete` definidos en la interfaz `GenericDAO`:

```java
public abstract class GenericDAO<T> {

    protected EntityManager entityManager;
    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityManager = EntityManagerProvider.getEntityManager();
        this.entityClass = entityClass;
    }

    @Override
    public List<T> findAll() {
        String finalQuery = " FROM " + entityClass.getCanonicalName();
        return entityManager.createQuery(finalQuery, entityClass).getResultList();
    }

    @Override
    public <ID> Optional<T> findById(ID id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public void save(T entity) {
    //     entityManager.getTransaction().begin();
    //     entityManager.merge(entity);
    //     entityManager.getTransaction().commit();
        executeInTransaction(entityManager -> {
            entityManager.persist(entity);
        });
    }

    @Override
    public void update(T entity) {
        executeInTransaction(entityManager -> {
            entityManager.merge(entity);
        });

    }

    @Override
    public void delete(T entity) {
        executeInTransaction(entityManager -> {
            entityManager.remove(entity);
        });

    }
}
```

Finalmente, se puede crear un DAO específico para la entidad `Meeting` que extienda de `GenericDAO`:

```java

public class MeetingDAO extends GenericDAO<Meeting> {
    public MeetingDao() {
    // public MeetingDAO(EntityManager entityManager) {
        super(Meeting.class);
        // super(entityManager);
    }
}
```

El EntityManager se puede inyectar directamente en el DAO o se puede pasar como parámetro al constructor, dependiendo de la arquitectura de la aplicación y las preferencias del desarrollador.

Probamos el resultado en Main:

```java

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Reuniones Maven Demo");
        // El EntityManager se puede haber preparado para una DI
        // EntityManager entityManager = EntityManagerProvider.getEntityManager();
        // MeetingDAO meetingDao = new MeetingDAO(entityManager);
        // O se puede crear directamente en el DAO
        MeetingDao meetingDao = new MeetingDao();

        // Crear una nueva reunión
        Meeting meeting = new Meeting(LocalDateTime.now(), "Reunión de prueba");
        meetingDao.save(meeting);

        // Buscar todas las reuniones
        List<Meeting> meetings = meetingDao.findAll();
        meetings.forEach(System.out::println);

        // Cerrar el EntityManager
        EntityManagerProvider.closeEntityManager(entityManager);
    }
}
```

Podemos mejorar la salida de la reunión añadiendo o refactorizando un método `toString()` en la clase `Meeting`:

```java
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("-".repeat(50)).append("\n").append("Meeting [id=").append(id).append("]")
                .append("\n").append("- date = ").append(date)
                .append("\n").append("- description = ").append(description)
                .append("\n").append("-".repeat(10));
        return sb.toString();

    }
```

### Métodos específicos de un DAO concreto

Además de los métodos genéricos definidos en la interfaz `GenericDAO`, es posible añadir métodos específicos para cada DAO concreto. Por ejemplo, si queremos buscar reuniones por fecha, podemos añadir un método `findByDate` en el `MeetingDAO`:

````java
public List<Meeting> findByDate(LocalDateTime date) {
    TypedQuery<Meeting> query = entityManager.createQuery("SELECT m FROM Meeting m WHERE m.date = :date", Meeting.class);
    query.setParameter("date", date);
    return query.getResultList();
}

Otros ejemplos de métodos específicos podría buscar la próxima reunión, como se ve en la siguiente implementación:

```java
  public Meeting nextMeetingBasic() {
      // Example method to find the next meeting
      // using a query to find the next meeting
      String finalQuery = " FROM " + Meeting.class.getCanonicalName()
              + " WHERE date > :currentDate ORDER BY date ASC";
      TypedQuery<Meeting> query = entityManager.createQuery(finalQuery, Meeting.class)
              .setParameter("currentDate", LocalDateTime.now());
      return query.getSingleResult();
  };

  public Meeting nextMeeting() {
      // Example method to find the next meeting
      // using a stream to find the next meeting
      return findAll().stream().filter(meeting -> meeting.getDate().isAfter(LocalDateTime.now())).findFirst()
              .orElse(null);
  };
````

En el AppMain, podemos probar estos métodos específicos:

```java
public class MainApp {
    public static void main(String[] args) {
      LocalDateTime date = LocalDateTime.now().plus(2, ChronoUnit.DAYS);

        Meeting meeting = new Meeting(date, "Reunión muy futura");
        meetingDao.save(meeting);

        System.out.println("Reunión guardada: " + meeting);

        try {
            Meeting nextMeeting = meetingDao.nextMeetingBasic();
            System.out.println("Próxima reunión: " + nextMeeting);
        } catch (NoResultException e) {
            System.out.println("No hay reuniones futuras.");
        }
    }
}
```

Gestionamos las excepciones adecuadamente, como `NoResultException`, para manejar casos en los que no se encuentren resultados.

Para probarlo podemos añadir una condición imposible en el método `nextMeetingBasic` para que no devuelva resultados aunque haya reuniones futuras

```java
public Meeting nextMeetingBasic() {
    // Example method to find the next meeting
    String finalQuery = " FROM " + Meeting.class.getCanonicalName()
            + " WHERE date > :currentDate AND id > 100 ORDER BY date ASC";
    TypedQuery<Meeting> query = entityManager.createQuery(finalQuery, Meeting.class)
            .setParameter("currentDate", LocalDateTime.now());
    return query.getSingleResult();
}
```

Un último ejemplo sería el de buscar reuniones para mañana, que podría implementarse en el DAO de la siguiente manera:

```java
public List<Meeting> findMeetingsForTomorrow() {
    // Example method to find meetings for tomorrow
    LocalDateTime tomorrow = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
    String finalQuery = " FROM " + Meeting.class.getCanonicalName()
            + " WHERE date >= ?1 AND date < :tomorrowEnd ORDER BY date ASC";
    TypedQuery<Meeting> query = entityManager.createQuery(finalQuery, Meeting.class)
            .setParameter(1, tomorrow)
            .setParameter("tomorrowEnd", tomorrow.plusDays(1));
    return query.getResultList();
}
```

Vemos en un método que se pueden usar parámetros posicionales y nombrados en las consultas JPA, lo que permite una mayor flexibilidad y claridad en la definición de las consultas.

El uso de parámetros posicionales (como `?1`) y nombrados (como `:tomorrowEnd`) es una característica de JPA que permite definir consultas de manera más legible y mantenible y tiene una gran importancia en la seguridad de las aplicaciones, ya que ayuda a prevenir ataques de inyección SQL al separar los parámetros de la consulta.

## Múltiple entidades

Para manejar múltiples entidades en un proyecto JPA, es necesario definir cada entidad como una clase Java separada y anotarla con `@Entity`. Al registrar cada entidad en el fichero `persistence.xml` como <class>, la proxima vez que se arraque el entityManager, JPA reconocerá todas las entidades y las gestionará adecuadamente, incluyendo la creación inicial de las tablas necesarias.

Cada entidad debe tener su propia tabla en la base de datos, y las relaciones entre entidades se pueden definir utilizando anotaciones como `@OneToMany`, `@ManyToOne`, `@ManyToMany`, etc.

### Entidad Room: Relaciones 1:N

Por ejemplo, si tenemos una entidad `Room` que representa una sala de reuniones, podríamos definirla de la siguiente manera:

```java
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @Column(length = 16)
    private String id;
    private String name;
    private int capacity;

    public Room() {
        // Default constructor for JPA
    }
    public Room(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    // Getters and Setters
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room{id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString()
    }
}
```

La relación en este caso es uno a muchos (1:N), ya que una sala puede tener múltiples reuniones, pero cada reunión solo puede estar en una sala.

Para definir esta relación, debemos añadir un campo `room` en la entidad `Meeting`:

```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "room_id")
private Room room;
```

Esto indica que cada reunión está asociada a una sala específica. La anotación `@JoinColumn` especifica la columna en la tabla `meetings` que se utilizará para almacenar la referencia a la sala. Si no se especifica el nombre de la columna, JPA utilizará el nombre del campo `room` seguido de `_id` por defecto.

En la otra dirección, la entidad `Room` no necesita una referencia a las reuniones, ya que la relación es unidireccional desde `Meeting` hacia `Room`. Sin embargo, si se quisiera tener acceso a las reuniones desde la sala, se podría añadir un campo `List<Meeting> meetings` en la entidad `Room` con la anotación `@OneToMany(mappedBy = "room")`.

```java
@OneToMany(mappedBy = "room")
private List<Meeting> meetings;
```

#### Implementación del DAO para Room

Para implementar el DAO de `Room`, se puede seguir un enfoque similar al del DAO de `Meeting`. Aquí hay un ejemplo básico:

```java
public class RoomDAO extends GenericDAO<Room> {
    public RoomDAO() {
        super(Room.class);
    }

    // Example method to find a room by its name
    public Room findByName(String name) {
        String finalQuery = " FROM " + Room.class.getCanonicalName() + " WHERE name = :name";
        TypedQuery<Room> query = entityManager.createQuery(finalQuery, Room.class)
                .setParameter("name", name);
        return query.getSingleResult();
    }

    // Example method to find rooms by capacity
    public List<Room> findByCapacity(int capacity) {
        String finalQuery = " FROM " + Room.class.getCanonicalName()
                + " WHERE capacity >= :capacity ORDER BY name ASC";
        TypedQuery<Room> query = entityManager.createQuery(finalQuery, Room.class)
                .setParameter("capacity", capacity);
        return query.getResultList();
    }
}
```

Esta implementación del DAO de `Room` hereda de `GenericDAO<Room>` y añade un método específico para buscar salas por capacidad. El método utiliza una consulta JPA para filtrar las salas según su capacidad.

Podemos probar el DAO de `Room` en el `MainApp`:

```java
public class MainApp {
    public static void main(String[] args) {
        System.out.println("Reuniones Maven Demo");

        // Crear el DAO de Room
        RoomDAO roomDao = new RoomDAO();

        // Crear una nueva sala
        Room room = new Room("R001", "Sala de Reuniones 1", 10);
        roomDao.save(room);

        // Buscar todas las salas
        List<Room> rooms = roomDao.findAll();
        rooms.forEach(System.out::println);

        // Buscar una sala por nombre
        Room foundRoom = roomDao.findByName("Sala de Reuniones 1");
        System.out.println("Sala encontrada: " + foundRoom);
    }
}
```

............................

Para completar la implementación, debemos actualizar el DAO de `Meeting` para manejar la relación con `Room`. Por ejemplo, al guardar una reunión, podemos establecer la sala asociada:

---

### Entidad MeetingRecord: Relaciones 1:1

La entidad `MeetingRecord` podría representar un registro asociado a una reunión, como un acta o un informe. En este caso, la relación entre `Meeting` y `MeetingRecord` sería de uno a uno (1:1), ya que cada reunión puede tener un único registro asociado.

```java
@Entity
@Table(name = "records")
public class MeetingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    @OneToOne()
    @JoinColumn(name = "meeting_id", unique = true)
    private Meeting meeting;

    public MeetingRecord() {
        // Default constructor for JPA
    }
    public MeetingRecord(String content, Meeting meeting) {
        this.content = content;
        this.meeting = meeting;
        // Establecer la relación bidireccional
        if (meeting != null) {
            this.meeting.setMeetingRecord(this);
        }
    }

    // Getters and Setters
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MeetingRecord{id=").append(id).append(", content='").append(content).append('\'');
        if (meeting != null) {
            sb.append(", meetingId=").append(meeting.getId());
        }
        sb.append('}');
        return sb.toString();
    }
}
```

Registramos la entidad en el fichero `persistence.xml` para que JPA la reconozca:

```xml
<class>local.domain.MeetingRecord</class>
```

Ya hemos añadido la anotación `@OneToOne` para indicar que cada registro está asociado a una única reunión. La anotación `@JoinColumn` especifica la columna en la tabla `records` que se utilizará para almacenar la referencia a la reunión, y el atributo `unique = true` asegura que cada reunión solo puede tener un registro asociado.

En la entidad `Meeting`, podemos añadir un campo `MeetingRecord record` para establecer la relación inversa:

```java
@OneToOne(mappedBy = "meeting", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private MeetingRecord record;
```

Esto indica que la relación es bidireccional y que el campo `record` en `Meeting` está mapeado por el campo `meeting` en `MeetingRecord`. La opción `cascade = CascadeType.ALL` permite que las operaciones de persistencia en `Meeting` también se apliquen a `MeetingRecord`.

#### Implementación del DAO para MeetingRecord

Para implementar el DAO de `MeetingRecord`, se puede seguir un enfoque similar al del DAO de `Meeting`. Aquí hay un ejemplo básico:

```java
public class MeetingRecordDAO extends GenericDAO<MeetingRecord> {
    public MeetingRecordDAO() {
        super(MeetingRecord.class);
    }
```

Como en los casos anteriores , se pueden añadir métodos específicos para buscar registros por reunión o por contenido:

```java
    // Example method to find a record by its meeting
    public MeetingRecord findByMeeting(Meeting meeting) {
        String finalQuery = " FROM " + MeetingRecord.class.getCanonicalName() + " WHERE meeting.id = :meetingId";
        TypedQuery<MeetingRecord> query = entityManager.createQuery(finalQuery, MeetingRecord.class)
                .setParameter("meetingId", meeting.getId());
        return query.getSingleResult();
    }

    // Example method to find records by content
    public List<MeetingRecord> findByContent(String content) {
        String finalQuery = " FROM " + MeetingRecord.class.getCanonicalName()
                + " WHERE content LIKE :content ORDER BY id ASC";
        TypedQuery<MeetingRecord> query = entityManager.createQuery(finalQuery, MeetingRecord.class)
                .setParameter("content", "%" + content + "%");
        return query.getResultList();
    }
}
```

### Entidad Person: Relaciones N:M

Creamos una entidad `Person` que representa a una persona que puede asistir a reuniones. En este caso, la relación entre `Person` y `Meeting` sería de muchos a muchos (N:M), ya que una persona puede asistir a múltiples reuniones y una reunión puede tener múltiples personas asistentes.

```java
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String surname;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    // @JoinColumn(name = "meeting_id")
    private Set<Meeting> meetings;


    public Person() {
        // Default constructor for JPA
    }

    public Person(String name, String email, Meeting meeting) {
        this.name = name;
        this.email = email;
        this.meeting = meeting;
    }

    // Getters and Setters
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{id=").append(id).append(", name='").append(name).append('\'')
          .append(", email='").append(email).append('\'');
        if (meeting != null) {
            sb.append(", meetingId=").append(meeting.getId());
        }
        sb.append('}');
        return sb.toString();
    }
}
```

Registramos la entidad en el fichero `persistence.xml` para que JPA la reconozca:

```xml
<class>local.domain.Person</class>
```

Para definir la relación N:M, necesitamos una tabla intermedia que almacene las asociaciones entre `Person` y `Meeting`. En JPA, esto se puede hacer utilizando la anotación `@ManyToMany` en ambas entidades.

En la entidad `Person`, hemos añadido un campo `Set<Meeting> meetings` para representar las reuniones a las que asiste la persona:

```java

    @ManyToMany(fetch = FetchType.LAZY)
    // @JoinColumn(name = "meeting_id")
    private Set<Meeting> meetings;
```

En la entidad `Meeting`, añadimos un campo `Set<Person> attendees` para representar las personas que asisten a la reunión:

```java
    @ManyToMany(mappedBy = "meetings", fetch = FetchType.LAZY)
    // @JoinColumn(name = "person_id")
    private Set<Person> participants;
```

En uno de los casos, la anotación `@ManyToMany` se usa con `mappedBy` para indicar que la relación está mapeada por el campo `meetings` en la entidad `Person`. Esto significa que la tabla intermedia se gestionará desde la entidad `Person`, llamando a la tabla intermedia `persons_meetings` por defecto.

#### Implementación del DAO para Person

Para implementar el DAO de `Person`, se puede seguir un enfoque similar al del DAO de `Meeting`. Aquí hay un ejemplo básico:

```java
public class PersonDAO extends GenericDAO<Person> {
    public PersonDAO() {
        super(Person.class);
    }
}
```
