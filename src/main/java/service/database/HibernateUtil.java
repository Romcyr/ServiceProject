package service.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    //  - jedno pole statyczne i finalne:
    //  - nikt tego pola nie nadpisze
    //  - każdy może go używać wszędzie
    //  - wywołujemy konstruktor który jest prywatny
    //  - konstruktora nie da się wywołać nigdzie indziej

        public final static HibernateUtil INSTANCE = new HibernateUtil();
        private final SessionFactory sessionFactory;

        private HibernateUtil() {
            this.sessionFactory = loadConfigFile();
        }

        private SessionFactory loadConfigFile() {
            // Załaduj plik konfiguracyjny: hibernate.cfg.xml
            StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            // Metadane -> dane które opisują dane
            Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

            // Na podstawie metadanych z pliku konfiguracyjnego tworzy fabrykę sesji
            return metadata.getSessionFactoryBuilder().build();
        }

        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }
