package org.plumbum;

import io.quarkus.hibernate.orm.PersistenceUnit;
import io.smallrye.mutiny.Multi;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.mutiny.Mutiny.Query;
import org.hibernate.reactive.mutiny.Mutiny.Session;
import org.plumbum.dao.ProductsEntity;

@ApplicationScoped
public class ProductRepositoryImpl {

    @Inject
    Mutiny.Session session;

    public Multi<ProductsEntity> getProducts() {
        return session
            .createNativeQuery("select * from Product", ProductsEntity.class)
            .getResults();

    }
}
