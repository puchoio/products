package org.plumbum;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Multi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.plumbum.dao.ProductsEntity;
import org.plumbum.rest.dto.ProductDTO;

public class ProductDTOBusinessImplTest {

    private ProductBusiness sut;
    @Mock
    private ProductRepositoryImpl productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut =  new ProductBusinessImpl(productRepository);
    }

    //@Test
    public void getAllProductsTest(){
        //given
        ProductsEntity productEntity =  new ProductsEntity() ;
      // productEntity.setDescription("desc");
      // productEntity.setId("id");
      // productEntity.setName("name");
        Multi<ProductsEntity> products = Multi.createFrom().item(productEntity);
        //when
        Mockito.when(productRepository.getProducts()).thenReturn(products);
        Multi<ProductDTO> result = sut.getProducts();

        //TODO: ver como hacer test con elementos reactivos
        result.subscribe().asStream().forEach(this::asserts);
    }

    private void asserts(ProductDTO productDTO) {
        Assertions.assertEquals("name",productDTO.name);
        Assertions.assertEquals("id",productDTO.id);
        Assertions.assertEquals("desc",productDTO.description);
    }
}