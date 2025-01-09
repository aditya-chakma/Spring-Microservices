package com.iaxis.Spring.microsevices.configuration;

import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author aditya.chakma
 * @since 09 Jan, 2025 11:04 AM
 */
public class ApiVersionHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected void registerHandlerMethod(Object handler, java.lang.reflect.Method method, RequestMappingInfo mapping) {
        String path = mapping.getPatternsCondition().getPatterns().iterator().next();
        String versionedPath = applyVersioningToPath(path);

        // Register the versioned path
        super.registerHandlerMethod(handler, method, mapping.combine(RequestMappingInfo.paths(versionedPath).build()));


        if (!path.startsWith("/v1") && !path.startsWith("/v2")) {
            super.registerHandlerMethod(handler, method, mapping);
        }
    }

    private String applyVersioningToPath(String path) {
        if (path.startsWith("/v1")) {
            return "/v1" + path;
        } else if (path.startsWith("/v2")) {
            return "/v2" + path;
        }
        return path; // Non-versioned path remains unchanged
    }

}
