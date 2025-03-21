package com.waduclay.ecommerce.customer;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Getter
@Setter
@Builder
@Document
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
