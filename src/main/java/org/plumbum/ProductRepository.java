package org.plumbum;

import io.smallrye.mutiny.Multi;
import javax.enterprise.context.ApplicationScoped;
import org.plumbum.dao.ProductsEntity;


public interface ProductRepository {

    Multi<ProductsEntity> getProducts();
}
