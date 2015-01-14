/*
 * Copyright (C) 2011 JFrog Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jfrog.build.api.builder;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.jfrog.build.api.*;
import org.jfrog.build.api.release.PromotionStatus;

import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * A temporary builder for the build class specifically for Maven extractor.
 * <P><B>NOTE!</B> This class should be merged to {@link BuildInfoBuilder} once fully tested.
 *
 * @author Noam Y. Tenne
 */
public class BuildInfoMavenBuilder extends BuildInfoBuilder {

    public BuildInfoMavenBuilder(String name) {
        super(name);
    }

    /**
     * Assembles the build class
     *
     * @return Assembled build
     */
    public Build build() {
        return super.build();
    }

    /**
     * Sets the version of the build
     *
     * @param version Build version
     * @return Builder instance
     */
    public BuildInfoMavenBuilder version(String version) {
        super.version(version);
        return this;
    }

    /**
     * Sets the name of the build
     *
     * @param name Build name
     * @return Builder instance
     */
    public BuildInfoMavenBuilder name(String name) {
        super.name(name);
        return this;
    }

    /**
     * Sets the number of the build
     *
     * @param number Build number
     * @return Builder instance
     */
    public BuildInfoMavenBuilder number(String number) {
        super.number(number);
        return this;
    }

    /**
     * Sets the type of the build
     *
     * @param type Build type
     * @return Builder instance
     */
    public BuildInfoMavenBuilder type(BuildType type) {
        super.type(type);
        return this;
    }

    /**
     * Sets the agent of the build
     *
     * @param agent Build agent
     * @return Builder instance
     */
    public BuildInfoMavenBuilder agent(Agent agent) {
        super.agent(agent);
        return this;
    }

    /**
     * Sets the build agent of the build
     *
     * @param buildAgent The build agent
     * @return Builder instance
     */
    public BuildInfoMavenBuilder buildAgent(BuildAgent buildAgent) {
        super.buildAgent(buildAgent);
        return this;
    }

    /**
     * Sets the started time of the build
     *
     * @param started Build started time
     * @return Builder instance
     */
    public BuildInfoMavenBuilder started(String started) {
        super.started(started);
        return this;
    }

    /**
     * Sets the started time of the build
     *
     * @param startedDate Build started date
     * @return Builder instance
     */
    public BuildInfoMavenBuilder startedDate(Date startedDate) {
        super.startedDate(startedDate);
        return this;
    }

    /**
     * Sets the duration milliseconds of the build
     *
     * @param durationMillis Build duration milliseconds
     * @return Builder instance
     */
    public BuildInfoMavenBuilder durationMillis(long durationMillis) {
        super.durationMillis(durationMillis);
        return this;
    }

    /**
     * Sets the principal of the build
     *
     * @param principal Build principal
     * @return Builder instance
     */
    public BuildInfoMavenBuilder principal(String principal) {
        super.principal(principal);
        return this;
    }

    /**
     * Sets the Artifactory principal of the build
     *
     * @param artifactoryPrincipal Build Artifactory principal
     * @return Builder instance
     */
    public BuildInfoMavenBuilder artifactoryPrincipal(String artifactoryPrincipal) {
        super.artifactoryPrincipal(artifactoryPrincipal);
        return this;
    }

    /**
     * Sets the URL of the build
     *
     * @param url Build URL
     * @return Builder instance
     */
    public BuildInfoMavenBuilder url(String url) {
        super.url(url);
        return this;
    }


    /**
     * Sets the parent build name of the build
     *
     * @param parentName Build parent build name
     * @return Builder instance
     */
    public BuildInfoMavenBuilder parentName(String parentName) {
        super.parentName(parentName);
        return this;
    }

    /**
     * Sets the parent build number of the build
     *
     * @param parentNumber Build parent build number
     * @return Builder instance
     */
    public BuildInfoMavenBuilder parentNumber(String parentNumber) {
        super.parentNumber(parentNumber);
        return this;
    }

    /**
     * Sets the vcs revision (format is vcs specific)
     *
     * @param vcsRevision The vcs revision
     * @return Builder instance
     */
    public BuildInfoMavenBuilder vcsRevision(String vcsRevision) {
        super.vcsRevision(vcsRevision);
        return this;
    }

    /**
     * Sets the vcs URL (format is vcs specific)
     *
     * @param vcsUrl The vcs revision
     * @return Builder instance
     */
    public BuildInfoMavenBuilder vcsUrl(String vcsUrl) {
        super.vcsUrl(vcsUrl);
        return this;
    }

    /**
     * Sets the modules of the build
     *
     * @param modules Build modules
     * @return Builder instance
     */
    public BuildInfoMavenBuilder modules(List<Module> modules) {
        super.modules(modules);
        return this;
    }

    public BuildInfoMavenBuilder statuses(List<PromotionStatus> statuses) {
        super.statuses(statuses);
        return this;
    }

    public BuildInfoMavenBuilder addStatus(PromotionStatus promotionStatus) {
        super.addStatus(promotionStatus);
        return this;
    }

    /**
     * Sets the violation notifications of the build
     *
     * @param licenseControl Build violation  recipients.
     * @return Builder instance
     */
    public BuildInfoMavenBuilder licenseControl(LicenseControl licenseControl) {
        super.licenseControl(licenseControl);
        return this;
    }

    /**
     * Sets the post build retention period
     *
     * @return Builder instance
     */
    public BuildInfoMavenBuilder buildRetention(BuildRetention buildRetention) {
        super.buildRetention(buildRetention);
        return this;
    }

    /**
     * Adds the given module to the modules list
     *
     * @param module Module to add
     * @return Builder instance
     */
    @Override
    public BuildInfoMavenBuilder addModule(Module module) {
        if (modules == null) {
            modules = Lists.newArrayList();
            modules.add(module);
            return this;
        }
        mergeModule(module);
        return this;
    }

    /**
     * Sets the properties of the build
     *
     * @param properties Build properties
     * @return Builder instance
     */
    public BuildInfoMavenBuilder properties(Properties properties) {
        super.properties(properties);
        return this;
    }

    /**
     * Adds the given property to the properties object
     *
     * @param key   Key of property to add
     * @param value Value of property to add
     * @return Builder instance
     */
    public BuildInfoMavenBuilder addProperty(Object key, Object value) {
        super.addProperty(key, value);
        return this;
    }

    public BuildInfoMavenBuilder issues(Issues issues) {
        super.issues(issues);
        return this;
    }

    public BuildInfoMavenBuilder governance(Governance governance) {
        super.governance(governance);
        return this;
    }

    private void mergeModule(Module moduleToMerge) {
        Module existingModule = findModule(moduleToMerge.getId());
        if (existingModule == null) {
            modules.add(moduleToMerge);
            return;
        }

        mergeModuleArtifacts(existingModule, moduleToMerge);
        mergeModuleDependencies(existingModule, moduleToMerge);
    }

    private Module findModule(final String moduleKey) {
        return Iterables.find(modules, new Predicate<Module>() {
            public boolean apply(Module input) {
                return input.getId().equals(moduleKey);
            }
        }, null);
    }

    private void mergeModuleArtifacts(Module existingModule, Module moduleToMerge) {
        List<Artifact> existingArtifacts = existingModule.getArtifacts();
        List<Artifact> artifactsToMerge = moduleToMerge.getArtifacts();
        if (existingArtifacts == null || existingArtifacts.isEmpty()) {
            existingModule.setArtifacts(artifactsToMerge);
            return;
        }

        if (artifactsToMerge == null || artifactsToMerge.isEmpty()) {
            return;
        }

        for (Artifact artifactToMerge : artifactsToMerge) {
            Artifact foundArtifact = findArtifact(existingArtifacts, artifactToMerge.getName());
            if (foundArtifact == null) {
                existingArtifacts.add(artifactToMerge);
            } else {
                if (StringUtils.isBlank(foundArtifact.getMd5()) && StringUtils.isBlank(foundArtifact.getSha1())) {
                    foundArtifact.setType(artifactToMerge.getType());
                    foundArtifact.setMd5(artifactToMerge.getMd5());
                    foundArtifact.setSha1(artifactToMerge.getSha1());
                    foundArtifact.setProperties(artifactToMerge.getProperties());
                }
            }
        }
    }

    private Artifact findArtifact(List<Artifact> existingArtifacts, final String artifactKey) {
        return Iterables.find(existingArtifacts, new Predicate<Artifact>() {
            public boolean apply(Artifact input) {
                return input.getName().equals(artifactKey);
            }
        }, null);
    }

    private void mergeModuleDependencies(Module existingModule, Module moduleToMerge) {
        List<Dependency> existingDependencies = existingModule.getDependencies();
        List<Dependency> dependenciesToMerge = moduleToMerge.getDependencies();
        if (existingDependencies == null || existingDependencies.isEmpty()) {
            existingModule.setDependencies(dependenciesToMerge);
            return;
        }

        if (dependenciesToMerge == null || dependenciesToMerge.isEmpty()) {
            return;
        }

        for (Dependency dependencyToMarge : dependenciesToMerge) {
            Dependency foundDependency = findDependency(existingDependencies, dependencyToMarge.getId());
            if (foundDependency == null) {
                existingDependencies.add(dependencyToMarge);
            } else {
                List<String> existingScopes = foundDependency.getScopes();
                List<String> scopesToMerge = dependencyToMarge.getScopes();
                for (String scopeToMerge : scopesToMerge) {
                    if (!existingScopes.contains(scopeToMerge)) {
                        existingScopes.add(scopeToMerge);
                    }
                }
            }
        }
    }

    private Dependency findDependency(List<Dependency> existingDependencies, final String dependencyId) {
        return Iterables.find(existingDependencies, new Predicate<Dependency>() {
            public boolean apply(Dependency input) {
                return input.getId().equals(dependencyId);
            }
        }, null);
    }

}