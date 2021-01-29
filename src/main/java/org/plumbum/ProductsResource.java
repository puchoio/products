package org.plumbum;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MediaType;

import org.plumbum.rest.dto.Product;

import io.quarkus.vertx.web.ReactiveRoutes;
import io.quarkus.vertx.web.Route;
import io.smallrye.mutiny.Multi;
import io.vertx.core.http.HttpMethod;

@ApplicationScoped
public class ProductsResource {

	@Route(path = "/products", methods = HttpMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Multi<Product> hello() throws InterruptedException {
		return ReactiveRoutes.asJsonArray(
				Multi.createFrom().items(createProduct(), createProduct(), createProduct(), createProduct()));
	}

	private Product createProduct() throws InterruptedException {
		return new Product("1234", "putito");
	}

}