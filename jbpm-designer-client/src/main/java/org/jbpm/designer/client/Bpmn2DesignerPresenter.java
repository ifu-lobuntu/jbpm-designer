package org.jbpm.designer.client;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jbpm.designer.client.type.Bpmn2Type;
import org.uberfire.client.annotations.WorkbenchEditor;

@Dependent
@WorkbenchEditor(identifier = "jbpm.designer", supportedTypes = { Bpmn2Type.class })
public class Bpmn2DesignerPresenter extends DesignerPresenter {
    @Inject
    private Bpmn2Type resourceType;

    @Inject
    public Bpmn2DesignerPresenter(final DesignerView view) {
        super(view);
    }

    public Bpmn2Type getResourceType() {
        return resourceType;
    }
}
