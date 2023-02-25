package cz.scholz.providers;

import io.fabric8.kubernetes.api.model.SecurityContext;
import io.strimzi.plugin.security.profiles.ContainerSecurityProviderContext;
import io.strimzi.plugin.security.profiles.impl.RestrictedPodSecurityProvider;

public class CustomPodSecurityProvider2 extends RestrictedPodSecurityProvider {
    @Override
    public SecurityContext kafkaConnectBuildContainerSecurityContext(ContainerSecurityProviderContext context) {
        if (context != null
                && context.userSuppliedSecurityContext() != null)    {
            return context.userSuppliedSecurityContext();
        } else {
            return null;
        }
    }
}
