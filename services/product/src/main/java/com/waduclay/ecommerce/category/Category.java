package com.waduclay.ecommerce.category;


import com.fasterxml.classmate.AnnotationOverrides;
import com.waduclay.ecommerce.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;

    public static Category of(@NotNull(message = "Product category is required") Integer integer) {
        return Category.builder().id(integer).build();
    }
}
