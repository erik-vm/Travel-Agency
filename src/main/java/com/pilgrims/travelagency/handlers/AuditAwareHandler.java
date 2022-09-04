package com.pilgrims.travelagency.handlers;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static com.pilgrims.travelagency.utils.Constants.Audit.DEFAULT_AUDITOR;

/**
 * Custom handler to implement AuditorAware
 *
 * @author Ott Pikk
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null ? Optional.of(authentication.getName()) : Optional.of(DEFAULT_AUDITOR);
    }
}