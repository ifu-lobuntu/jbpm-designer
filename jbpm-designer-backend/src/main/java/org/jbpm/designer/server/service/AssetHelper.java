package org.jbpm.designer.server.service;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jbpm.designer.web.profile.IExtensionDiagramProfile;
import org.uberfire.backend.vfs.Path;

public class AssetHelper {
    @Inject
    Instance<IExtensionDiagramProfile> extensionProfiles;

    public String getProfileNameFor(Path path) {
        if (path.getFileName().endsWith(".bpmn2")) {
            return "jbpm";
        } else {
            for (IExtensionDiagramProfile p : this.extensionProfiles) {
                if (path.getFileName().endsWith(p.getSerializedModelExtension())) {
                    return p.getName();
                }
            }
            return "jbpm";
        }
    }

    public String getDefaultContentFor(Path path) {
        if (path.getFileName().endsWith(".bpmn2")) {
            return DefaultDesignerAssetService.PROCESS_STUB;
        } else {
            for (IExtensionDiagramProfile p : this.extensionProfiles) {
                if (path.getFileName().endsWith(p.getSerializedModelExtension())) {
                    return p.getModelStub(path);
                }
            }
            return DefaultDesignerAssetService.PROCESS_STUB;
        }
    }
}