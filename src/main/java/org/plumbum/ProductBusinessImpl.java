package org.plumbum;

import io.smallrye.mutiny.Multi;
import java.sql.Time;
import java.time.LocalTime;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.plumbum.dao.ProductsEntity;
import org.plumbum.rest.dto.ProductDTO;

@ApplicationScoped
@Slf4j
public class ProductBusinessImpl implements ProductBusiness {

    private final ProductRepositoryImpl productRepository;

    public ProductBusinessImpl(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Multi<ProductDTO> getProducts() {
        return productRepository.getProducts()
            .onItem()
            .transform(this::map);
    }

    private  ProductDTO map(ProductsEntity productsEntity) {
        return  new ProductDTO(productsEntity.id, productsEntity.name,
            productsEntity.description);
    }
}
