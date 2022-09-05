package com.pilgrims.travelagency.handlers;

import com.pilgrims.travelagency.utils.Constants;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Custom handler to implement AuditorAware
 *
 * @author Erik Vainumäe
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(Constants.Audit.DEFAULT_AUDITOR);
    }
}