
package local.connections;

//import java.util.HashMap;
//import java.util.Map;

//import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/*
public class EntityManagerProvider {

     private final static String PERSISTENCE_UNIT= "demos-q";
     private static  EntityManagerFactory entityManagerFactory;

     static  Map<String, String> getProps() {
             Map<String, String> props = new HashMap<>();
             Dotenv dotEnv = Dotenv.load();
             props.put("jakarta.persistence.jdbc.url", dotEnv.get("DB_URL"));
             props.put("jakarta.persistence.jdbc.user", dotEnv.get("DB_USER"));
             props.put("jakarta.persistence.jdbc.password", dotEnv.get("DB_PASSWD"));
             return props;
     }

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory(
            PERSISTENCE_UNIT,
            getProps());
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }


    public static void main(String[] args) {
        getEntityManager();

    }

}
*/

public class EntityManagerProvider {

    private final static String PERSISTENCE_UNIT = "demos-q";
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void main(String[] args) {
        getEntityManager();
    }
}

/* 
a\Local\Temp\cp_9utyuyzgj4nq8hotfuai9gj0o.argfile' 'local.connections.EntityManagerProvider' 
jul 22, 2025 6:56:53 P. M. org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: demos-q]
jul 22, 2025 6:56:53 P. M. org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 7.0.5.Final
jul 22, 2025 6:56:54 P. M. org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using built-in connection pool (not intended for production use)
jul 22, 2025 6:56:55 P. M. org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator logConnectionInfo
INFO: HHH10001005: Database info:
        Database JDBC URL [jdbc:mysql://localhost:3306/world]
        Database driver: com.mysql.cj.jdbc.Driver
        Database version: 8.0.42
        Autocommit mode: false
        Isolation level: undefined/unknown
        Pool: DriverManagerConnectionProviderImpl
        Minimum pool size: 1
        Maximum pool size: 20
jul 22, 2025 6:56:56 P. M. org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
PS C:\Users\hola\java-course> 
*/