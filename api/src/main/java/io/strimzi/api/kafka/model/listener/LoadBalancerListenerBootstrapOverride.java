/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.api.kafka.model.listener;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.strimzi.crdgenerator.annotations.Description;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Configures external bootstrap service for LoadBalancer listeners
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Buildable(
    editableEnabled = false,
    generateBuilderPackage = false,
    builderPackage = "io.fabric8.kubernetes.api.builder"
)
@EqualsAndHashCode(callSuper = true)
public class LoadBalancerListenerBootstrapOverride extends ExternalListenerBootstrapOverride {
    private static final long serialVersionUID = 1L;

    private Map<String, String> dnsAnnotations = new HashMap<>(0);

    @Description("Annotations which will be added to the Service resource. " +
            "You can use this field to instrument DNS providers such as External DNS.")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getDnsAnnotations() {
        return dnsAnnotations;
    }

    public void setDnsAnnotations(Map<String, String> dnsAnnotations) {
        this.dnsAnnotations = dnsAnnotations;
    }
}
