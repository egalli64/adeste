package com.example.license;

public record License(Long id, String description, String orgId, String product, String type) {
    public static License demo(Long id, String orgId) {
        return new License(id, "Software product", orgId, "Ostock", "full");
    }
}
