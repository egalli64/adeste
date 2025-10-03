package com.example.license;

import java.util.concurrent.ThreadLocalRandom;

public record LicenseDTO(Long id, String description, String product, String type) {
    public static LicenseDTO demo() {
        return new LicenseDTO(ThreadLocalRandom.current().nextLong(), "Stub", "All", "Demo");
    }

    public static LicenseDTO of(License that) {
        return new LicenseDTO(that.getId(), that.getDescription(), that.getProduct(), that.getType());
    }
}
