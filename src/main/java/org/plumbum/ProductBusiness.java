package org.plumbum;

import io.smallrye.mutiny.Multi;
import org.plumbum.rest.dto.ProductDTO;

public interface ProductBusiness {

    Multi<ProductDTO> getProducts();
}
