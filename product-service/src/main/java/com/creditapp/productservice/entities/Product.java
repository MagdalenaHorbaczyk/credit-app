package com.creditapp.productservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS")
@Setter
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=12, fraction=2)
    BigDecimal value;

    @NotNull(message = "Please provide a credit number")
    @Digits(integer=15, fraction=0, message = "Please provide value in format: 0")
    @Column(unique = true, nullable = false)
    private Long creditId;

    @NotBlank(message = "Please provide a product name")
    @Size(min = 2, max = 255, message = "Minimum product name length: 2 characters, maximum: 255")
    private String productName;
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", creditId=" + creditId +
                ", productName='" + productName + '\'' +
                ", value=" + value +
                '}';
    }
}

