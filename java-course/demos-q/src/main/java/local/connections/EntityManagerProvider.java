package local.connections;

import java.util.HashMap;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {

     private final static String PERSISTENCE_UNIT= "demos-q";
     private static EntityManagerFactory entityManagerFactory;

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
