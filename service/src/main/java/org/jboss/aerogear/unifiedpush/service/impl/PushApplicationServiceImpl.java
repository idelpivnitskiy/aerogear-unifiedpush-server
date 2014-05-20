/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.aerogear.unifiedpush.service.impl;

import org.jboss.aerogear.unifiedpush.api.*;
import org.jboss.aerogear.unifiedpush.dao.PushApplicationDao;
import org.jboss.aerogear.unifiedpush.service.PushApplicationService;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class PushApplicationServiceImpl implements PushApplicationService {

    @Inject
    private PushApplicationDao pushApplicationDao;

    @Override
    public void addPushApplication(PushApplication pushApp) {
        pushApplicationDao.create(pushApp);
    }

    public List<PushApplication> findAllPushApplicationsForDeveloper(String loginName) {
        return pushApplicationDao.findAllForDeveloper(loginName);
    }

    @Override
    public PushApplication findByPushApplicationIDForDeveloper(String pushApplicationID, String loginName) {
        return pushApplicationDao.findByPushApplicationIDForDeveloper(pushApplicationID, loginName);
    }

    @Override
    public PushApplication findByPushApplicationID(String pushApplicationID) {
        return pushApplicationDao.findByPushApplicationID(pushApplicationID);
    }

    @Override
    public void addiOSVariant(PushApplication pushApp, iOSVariant iOVariant) {
        pushApp.getIOSVariants().add(iOVariant);
        pushApplicationDao.update(pushApp);
    }

    @Override
    public void addAndroidVariant(PushApplication pushApp, AndroidVariant androidVariant) {
        pushApp.getAndroidVariants().add(androidVariant);
        pushApplicationDao.update(pushApp);
    }

    @Override
    public void addSimplePushVariant(PushApplication pushApp,
            SimplePushVariant simplePushVariant) {
        pushApp.getSimplePushVariants().add(simplePushVariant);

        pushApplicationDao.update(pushApp);
    }

    @Override
    public void addChromePackagedAppVariant(PushApplication pushApp,
            ChromePackagedAppVariant chromePackagedAppVariant) {
        pushApp.getChromePackagedAppVariants().add(chromePackagedAppVariant);

        pushApplicationDao.update(pushApp);
    }

    @Override
    public Map<VariantType, Long> countInstallationsByType(String pushApplicationID) {
        return pushApplicationDao.countInstallationsByType(pushApplicationID);
    }

    @Override
    public void updatePushApplication(PushApplication pushApp) {
        pushApplicationDao.update(pushApp);
    }

    @Override
    public void removePushApplication(PushApplication pushApp) {
        pushApplicationDao.delete(pushApp);
    }
}
