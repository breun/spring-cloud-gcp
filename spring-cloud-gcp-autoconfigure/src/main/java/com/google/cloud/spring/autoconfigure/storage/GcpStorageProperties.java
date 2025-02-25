/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spring.autoconfigure.storage;

import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.GcpScope;
import com.google.cloud.spring.storage.GoogleStorageProtocolResolverSettings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/** Settings for Storage. */
@ConfigurationProperties("spring.cloud.gcp.storage")
public class GcpStorageProperties extends GoogleStorageProtocolResolverSettings
    implements CredentialsSupplier {

  /** Overrides the GCP OAuth2 credentials specified in the Core module. */
  @NestedConfigurationProperty
  private final Credentials credentials = new Credentials(GcpScope.STORAGE_READ_WRITE.getUrl());

  public Credentials getCredentials() {
    return this.credentials;
  }

  private String projectId;

  /**
   * Universe domain of the client which is part of the host that is formatted as
   * `https://${service}.${universeDomain}/`.
   */
  private String universeDomain;

  /** Host of the Storage client that is formatted as `https://${service}.${universeDomain}/`. */
  private String host;

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getUniverseDomain() {
    return universeDomain;
  }

  public void setUniverseDomain(String universeDomain) {
    this.universeDomain = universeDomain;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }
}
