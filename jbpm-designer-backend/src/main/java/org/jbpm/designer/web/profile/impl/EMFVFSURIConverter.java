package org.jbpm.designer.web.profile.impl;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.emf.common.util.URI;
import org.jbpm.designer.repository.UriUtils;

public class EMFVFSURIConverter {

    public static URI toPlatformResourceURI(String uniqueId) {
        return URI.createPlatformResourceURI(toPlatformRelativeString(uniqueId), true);
    }

    public static String toPlatformRelativeString(String uniqueId) {
        String id = null;
        if (Base64.isBase64(uniqueId)) {
            byte[] decoded = Base64.decodeBase64(uniqueId);
            try {
                String uri = new String(decoded, "UTF-8");
                id = UriUtils.encode(uri);
            } catch (UnsupportedEncodingException e) {
    
            }
        }
        if (id == null) {
            id = UriUtils.encode(uniqueId);
        }
        return id.substring(id.indexOf("/", id.indexOf("@")) + 1);
    }
    public static void main(String[] args) {
        System.out.println(getRepositoryInfo("git@github.com:repository/project/src/main/resources/test.uml"));
        System.out.println(getProjectName(URI.createPlatformResourceURI("/project/src/main/resources/test.uml",true)));
    }
    public static String getRepositoryInfo(String id){
        return id.substring(0, id.indexOf("/", id.indexOf("@")));
    }
    public static URI toPlatformResourceURI(org.uberfire.backend.vfs.Path uniqueId) {
        return URI.createPlatformResourceURI(toPlatformRelativeString(uniqueId.toURI()),true);
    }

    public static String toPlatformRelativeString(org.uberfire.backend.vfs.Path uniqueId) {
        return toPlatformRelativeString(uniqueId.toURI());
    }

    public static String getProjectName(URI uri) {
        String projectName = uri.toPlatformString(true);
        projectName=projectName.substring(0, projectName.indexOf('/',1)+1);
        return projectName;
    }
    

//    public static org.uberfire.backend.vfs.Path toVFSPath(URI uri) {
//        return null;
//    }

}
