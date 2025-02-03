package com.iaxis.cloud.limits_service.controller;

import com.iaxis.cloud.limits_service.configuration.LimitsConfiguration;
import com.iaxis.cloud.limits_service.dto.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aditya.chakma
 * @since 15 Jan, 2025
 */
@RestController
@RequestMapping("/limits")
public class LimitsController {

    private final LimitsConfiguration limitsConfiguration;

    @Autowired
    public LimitsController(LimitsConfiguration limitsConfiguration) {
        this.limitsConfiguration = limitsConfiguration;
    }

    @GetMapping
    public Limits getLimits() {
        return new Limits(limitsConfiguration.getMinimum(), limitsConfiguration.getMaximum());
    }

}
