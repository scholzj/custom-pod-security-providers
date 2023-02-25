package cz.scholz.providers;

import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.PodSecurityContextBuilder;
import io.fabric8.kubernetes.api.model.SecurityContext;
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
     * Returns custom Pod Security Context
     */
    private PodSecurityContext customPodSecurityContext()   {
        return new PodSecurityContextBuilder()
                .withRunAsUser(1874L)
                .withRunAsGroup(1874L)
                .withFsGroup(1874L)
                .build();
    }

    @Override
    public PodSecurityContext zooKeeperPodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext zooKeeperContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public PodSecurityContext kafkaPodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext kafkaContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext kafkaInitContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public PodSecurityContext entityOperatorPodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext entityTopicOperatorContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext entityUserOperatorContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext entityOperatorTlsSidecarContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public PodSecurityContext kafkaExporterPodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext kafkaExporterContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public PodSecurityContext cruiseControlPodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext cruiseControlContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public PodSecurityContext jmxTransPodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext jmxTransContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public PodSecurityContext kafkaConnectPodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext kafkaConnectContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext kafkaConnectInitContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public PodSecurityContext kafkaConnectBuildPodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext kafkaConnectBuildContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public PodSecurityContext kafkaMirrorMakerPodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext kafkaMirrorMakerContainerSecurityContext(ContainerSecurityProviderContext context) {
        return PodSecurityProvider.super.kafkaMirrorMakerContainerSecurityContext(context);
    }

    @Override
    public PodSecurityContext bridgePodSecurityContext(PodSecurityProviderContext context) {
        return customPodSecurityContext();
    }

    @Override
    public SecurityContext bridgeContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }

    @Override
    public SecurityContext bridgeInitContainerSecurityContext(ContainerSecurityProviderContext context) {
        return null;
    }
}
