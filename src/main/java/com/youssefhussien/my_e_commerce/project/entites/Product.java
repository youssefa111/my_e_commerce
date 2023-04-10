package com.youssefhussien.my_e_commerce.project.entites;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

//    @Lob
    @Column(name = "`desc`")
    private String desc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory category;


    @OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    private ProductInventory inventory;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Transient
    private BigDecimal afterDiscount;

    public void calcPriceAfterDiscount() {
       if (discount != null && discount.getActive() != 0) {
           afterDiscount = price.subtract(discount.getDiscountPercent());
           System.out.println("after discount ===================");
       }
    }

    public Product(){

    }

    @Column(name = "price", precision = 10)
    private BigDecimal price;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private Date modifiedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

}