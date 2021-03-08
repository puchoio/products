package org.plumbum;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.plumbum.rest.dto.ProductDTO;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductsResourceTest {

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetProducts() throws Exception {
		given()
			.when()
				.get("/products")
			.then()
				.statusCode(200)
			.body(
					containsString("id"),
					containsString("name"),
					containsString("desc")

				);
	}



	public List<ProductDTO> map(Response response){
		String values = response.asString();

		return Arrays.stream(StringUtils.substringsBetween(values, "{", "}"))
			.map(s -> "{"+ s + "}")
			.collect(Collectors.toList())
			.stream().map(this::getProductDTO)
			.collect(Collectors.toList());
	}

	private ProductDTO getProductDTO(String s) {
		try {
			return mapper.readValue(s, ProductDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}