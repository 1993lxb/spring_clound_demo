package cn.itcast.order.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Long id;
    private String productName;
    private Integer status;
    private BigDecimal price;
    private String productDesc;
    private String caption;
    private Integer inventory;

    public void setId(long l) {
        this.id=l;
    }

    public void setProductName(String s) {
        this.productName=s;
    }
}
