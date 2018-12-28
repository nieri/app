package br.com.munieri.desafio.cielo.integration;

import br.com.munieri.desafio.cielo.DesafioCieloApplication;
import br.com.munieri.desafio.cielo.repository.LancamentoRepository;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DesafioCieloApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LancamentoControllerIT {

    @Autowired
    LancamentoRepository repository;

    @LocalServerPort
    private Integer port;

    @Test
    public void deve_retornar_lista_boletos() {

        given()
                .when()
                .get("http://127.0.0.1:" + port + "/api/lancamentos")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
