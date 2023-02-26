package cz.scholz.providers;

import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.SecurityContext;
import io.fabric8.kubernetes.api.model.SecurityContextBuilder;
import io.strimzi.platform.PlatformFeatures;
import io.strimzi.plugin.security.profiles.ContainerSecurityProviderContext;
import io.strimzi.plugin.security.profiles.PodSecurityProvider;
import io.strimzi.plugin.security.profiles.PodSecurityProviderContext;

public class CustomPodSecurityProvider implements PodSecurityProvider {
    @Override
    public void configure(PlatformFeatures platformFeatures) {
        // Nothing to configure
    }

    /**
     * Returns custom Container Security Context
     */
    private SecurityContext customContainerSecurityContext()   {
        return new SecurityContextBuilder()
                .withReadOnlyRootFilesystem()
                .build();
    }

    @Override
    public PodSecurityContext zooKeeperPodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext zooKeeperContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public PodSecurityContext kafkaPodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext kafkaContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public SecurityContext kafkaInitContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public PodSecurityContext entityOperatorPodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext entityTopicOperatorContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public SecurityContext entityUserOperatorContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public SecurityContext entityOperatorTlsSidecarContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public PodSecurityContext kafkaExporterPodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext kafkaExporterContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public PodSecurityContext cruiseControlPodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext cruiseControlContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public PodSecurityContext jmxTransPodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext jmxTransContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public PodSecurityContext kafkaConnectPodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext kafkaConnectContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public SecurityContext kafkaConnectInitContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public PodSecurityContext kafkaConnectBuildPodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext kafkaConnectBuildContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public PodSecurityContext kafkaMirrorMakerPodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext kafkaMirrorMakerContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public PodSecurityContext bridgePodSecurityContext(PodSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext bridgeContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }

    @Override
    public SecurityContext bridgeInitContainerSecurityContext(ContainerSecurityProviderContext context) {
        return customContainerSecurityContext();
    }
}
