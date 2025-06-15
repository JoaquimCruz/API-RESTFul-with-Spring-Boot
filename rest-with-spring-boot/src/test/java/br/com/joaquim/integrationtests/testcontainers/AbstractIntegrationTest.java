package br.com.joaquim.integrationtests.testcontainers;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:9.1.0");

        // O test container inicializa uma instancia do MySQL container. Ele vai pegar do parametro passado.
        private static void startContainer() {
            Startables.deepStart(Stream.of(mysql)).join();
        }

        // setando dinamicamente a URL do banco de dados, o usuário e a senha
        private static Map<String, String> createConnectionConfiguration() {
            // Se digitar errado a chave, o Spring Boot não vai conseguir ler a propriedade
            return Map.of(
                    "spring.datasource.url", mysql.getJdbcUrl(),
                    "spring.datasource.username", mysql.getUsername(),
                    "spring.datasource.password", mysql.getPassword()
            );
        }

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            // Inicia o container do MySQL
            startContainer();
            // Pegou o contexto do spring e adicionou as propriedades do banco de dados antes das outras propriedades
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            MapPropertySource testcontainers = new MapPropertySource("testcontainers",
                    (Map)createConnectionConfiguration());
            environment.getPropertySources().addFirst(testcontainers);
        }




    }
}
