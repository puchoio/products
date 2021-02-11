package org.plumbum;

import io.smallrye.mutiny.Multi;
import javax.enterprise.context.ApplicationScoped;
import org.plumbum.rest.dto.Product;

@ApplicationScoped
public class ProductBusinessImpl implements ProductBusiness {

    @Override
    public Multi<Product> getProducts() {
        return Multi.createFrom().items(new Product("1234", "putito"), new Product("1235", "putito"));
    }
}
