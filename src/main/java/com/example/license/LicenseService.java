package com.example.license;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Fake access to persistence layer
 */
@Service
public class LicenseService {
    private static final Logger log = LogManager.getLogger(LicenseService.class);

    private final MessageSource src;

    public LicenseService(MessageSource src) {
        this.src = src;
    }

    public License get(Long id, String orgId) {
        log.traceEntry("get({}, {})", id, orgId);

        return License.demo(id, orgId);
    }

    public String create(License license, String orgId, Locale locale) {
        log.traceEntry("get({}, {}, {})", license, orgId, locale);

        // fake check before "storing"
        if (license.orgId().equals(orgId)) {
            return String.format(src.getMessage("license.create.message", null, locale), license);
        } else {
            return String.format(src.getMessage("license.existing.message", null, locale), license.id());
        }
    }

    public String update(License license, String orgId) {
        log.traceEntry("get({}, {})", license, orgId);

        // fake check before "updating"
        if (license.orgId().equals(orgId)) {
            return String.format(src.getMessage("license.update.message", null, null), license);
        } else {
            return String.format(src.getMessage("license.missing.message", null, null), license.id());
        }
    }

    public String delete(Long id, String orgId) {
        log.traceEntry("delete({}, {})", id, orgId);

        // fake check before "deleting"
        if (id > 0 && StringUtils.hasText(orgId)) {
            return String.format(src.getMessage("license.delete.message", null, null), id, orgId);
        } else {
            return String.format(src.getMessage("license.missing.message", null, null), id);
        }
    }
}
