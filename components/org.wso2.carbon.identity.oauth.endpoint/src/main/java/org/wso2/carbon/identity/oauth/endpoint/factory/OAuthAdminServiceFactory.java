/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.oauth.endpoint.factory;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.identity.oauth.OAuthAdminServiceImpl;

/**
 * Factory Beans serves as a factory for creating other beans within the IOC container. This factory bean is used to
 * instantiate the OAuthAdminService type of object inside the container.
 */
public class OAuthAdminServiceFactory extends AbstractFactoryBean<OAuthAdminServiceImpl> {

    private OAuthAdminServiceImpl oAuthAdminService;

    @Override
    public Class<OAuthAdminServiceImpl> getObjectType() {

        return OAuthAdminServiceImpl.class;
    }

    @Override
    protected OAuthAdminServiceImpl createInstance() throws Exception {

        if (this.oAuthAdminService != null) {
            return this.oAuthAdminService;
        } else {
            OAuthAdminServiceImpl oAuthAdminService = (OAuthAdminServiceImpl) PrivilegedCarbonContext
                    .getThreadLocalCarbonContext().getOSGiService(OAuthAdminServiceImpl.class, null);
            if (oAuthAdminService != null) {
                this.oAuthAdminService = oAuthAdminService;
            }
            return oAuthAdminService;
        }
    }
}
