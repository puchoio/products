package org.plumbum;

import io.smallrye.mutiny.Multi;
import org.plumbum.rest.dto.Product;

public interface ProductBusiness {

    Multi<Product> getProducts();
}
