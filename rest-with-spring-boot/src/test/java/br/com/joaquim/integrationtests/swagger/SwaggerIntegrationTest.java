package br.com.joaquim.integrationtests.swagger;

import br.com.joaquim.config.TestConfigs;
import br.com.joaquim.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerIntegrationTest extends AbstractIntegrationTest {
// This class is used to test the Swagger integration in the application.
// It extends AbstractIntegrationTest to inherit common test configurations and setups.

	@Test
	void shouldDisplaySwaggerUIPage(){
		var content = given()
				.baseUri("http://localhost")
					.port(TestConfigs.SERVER_PORT)
				    .basePath("/swagger-ui/index.html") // Caminho para a página do Swagger UI
				.when()
					.get()
				.then()
					.statusCode(200)
				.extract()
					.body()
						.asString();

		// Pega a URL defininida, na porta 8888, quando for executada uma operação GET
		// nesse caminho, deve retornar o código de status 200 (OK).
		// E nesse caso eu vou extrair o conteúdo do body como uma string.

		assertTrue(content.contains("Swagger UI"));
	}

}
