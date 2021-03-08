package org.plumbum.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "Product")
@Entity
@Data
public class ProductsEntity {

    @Id
    public String id;
    public String name;
    public String description;
}
