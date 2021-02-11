package org.plumbum;

import static io.restassured.RestAssured.given;

import io.quarkus.test.Mock;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Multi;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.plumbum.rest.dto.Product;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductsResourceTest {

	@InjectMock
	private ProductBusiness productBusiness;

	@Test
	public void testGetProducts() throws JsonProcessingException {
		final Product product1 = new Product("1234", "putito");
		Mockito.when(productBusiness.getProducts()).thenReturn(Multi.createFrom().item(product1));

		final List<Product> result = given().when().get("/products").then().statusCode(200).extract().body().jsonPath()
				.getList(".", Product.class);
		Assertions.assertEquals(product1, result.get(0));
	}
}