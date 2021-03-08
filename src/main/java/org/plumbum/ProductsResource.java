package org.plumbum;

import io.smallrye.mutiny.Multi;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.plumbum.rest.dto.ProductDTO;

import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;

@ApplicationScoped
public class ProductsResource {

	@Inject
	ProductBusiness productBussisnes;

	@Route(path = "/products", methods = HttpMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Multi<ProductDTO> hello() {
		return productBussisnes.getProducts();
		//return ReactiveRoutes.asJsonArray(productBussisnes.getProducts());
	}

}