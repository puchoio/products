package org.plumbum;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.plumbum.rest.dto.Product;

import io.quarkus.vertx.web.ReactiveRoutes;
import io.quarkus.vertx.web.Route;
import io.smallrye.mutiny.Multi;
import io.vertx.core.http.HttpMethod;

@ApplicationScoped
public class ProductsResource {

	@Inject
	ProductBusiness productBussisnes;

	@Route(path = "/products", methods = HttpMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Multi<Product> hello() {
		return ReactiveRoutes.asJsonArray(productBussisnes.getProducts());
	}

}