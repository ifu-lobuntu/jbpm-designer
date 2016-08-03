package org.jbpm.designer.web.profile;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.uberfire.backend.vfs.Path;

/**
 * An interface representing DiagramProfiles from an extension to avoid having to modify core code
 * 
 * @author ampie
 *
 */
public interface IExtensionDiagramProfile extends IDiagramProfile {
    String getModelStub(Path path);

    IDiagramMarshaller createMarshaller(URI uri);
    
    IDiagramUnmarshaller createUnmarshaller(URI uri);


    boolean processRequestForPotentialReferences(HttpServletRequest req, HttpServletResponse resp, String action, String processId) throws IOException;

    String getFormId(XMLResource resource, String elementId, String formType);

    Map<String, Object> buildDefaultResourceOptions();

}
