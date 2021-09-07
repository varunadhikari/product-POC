package com.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail {

    @Id
    @GeneratedValue(generator="ORDER_DETAIL_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="ORDER_DETAIL_SEQ",sequenceName="ORDER_DETAIL_SEQ", allocationSize = 1)
    @Column(name = "ORDER_DETAIL_ID")
    private Integer id;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "AMOUNT")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Transient
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
