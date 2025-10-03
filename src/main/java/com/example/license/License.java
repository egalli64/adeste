package com.example.license;

import java.util.concurrent.ThreadLocalRandom;

public class License {
    private Long id;
    private String description;
    private String orgId;
    private String product;
    private String type;

    public License() {
        this.id = ThreadLocalRandom.current().nextLong();
    }

    public License(Long id, String description, String orgId, String product, String type) {
        this.id = id;
        this.description = description;
        this.orgId = orgId;
        this.product = product;
        this.type = type;
    }

    public License(LicenseDTO that, String orgId) {
        this(that.id(), that.description(), orgId, that.product(), that.type());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "License [id=" + id + ", description=" + description + ", orgId=" + orgId + ", product=" + product
                + ", type=" + type + "]";
    }
}
