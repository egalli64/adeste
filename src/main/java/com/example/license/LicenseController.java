package com.example.license;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Plus the implicit endpoint added by Actuator
 * 
 * <pre>
    curl -X GET localhost:8080/actuator
 * </pre>
 */
@RestController
@RequestMapping("/api/v1/organizations/{orgId}/licenses")
public class LicenseController {
    private static final Logger log = LogManager.getLogger(LicenseController.class);

    private final LicenseService svc;

    public LicenseController(LicenseService licenseService) {
        this.svc = licenseService;
    }

    /**
     * <pre>
        curl -X GET localhost:8080/api/v1/organizations/123/licenses/42
     * </pre>
     */
    @GetMapping("/{id}")
    public License get(@PathVariable Long id, @PathVariable String orgId) {
        log.traceEntry("get({}, {})", id, orgId);

        return svc.get(id, orgId);
    }

    /**
     * <pre>
        curl -X PUT -H "Content-Type: application/json" ^
        -d "{\"id\":42,\"description\":\"Extra\",\"orgId\":\"84\",\"product\":\"PK 99\",\"type\":\"platinum\"}" ^
         localhost:8080/api/v1/organizations/123/licenses
     * </pre>
     */
    @PutMapping
    public String update(@RequestBody License license, @PathVariable String orgId) {
        log.traceEntry("update({}, {})", license, orgId);
        return svc.update(license, orgId);
    }

    /**
     * <pre>
        curl -X POST -H "Content-Type: application/json" ^
        -d "{\"id\":42,\"description\":\"Enterprise\",\"orgId\":\"123\",\"product\":\"PK 42\",\"type\":\"silver\"}" ^
        localhost:8080/api/v1/organizations/123/licenses
     * </pre>
     */
    @PostMapping
    public String create(@RequestBody License license, @PathVariable String orgId,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        log.traceEntry("create({}, {}, {})", license, orgId, locale);

        return svc.create(license, orgId, locale);
    }

    /**
     * <pre>
        curl -X DELETE localhost:8080/api/v1/organizations/123/licenses/42
     * </pre>
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, @PathVariable String orgId) {
        log.traceEntry("delete({}, {})", id, orgId);

        return svc.delete(id, orgId);
    }
}
