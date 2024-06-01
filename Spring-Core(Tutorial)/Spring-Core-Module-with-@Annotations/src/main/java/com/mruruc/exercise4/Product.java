package com.mruruc.exercise4;

public class Product {
    private Long productId;
    private String productTitle;

    public Product(Long productId, String productTitle) {
        this.productId = productId;
        this.productTitle = productTitle;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                '}';
    }
}
