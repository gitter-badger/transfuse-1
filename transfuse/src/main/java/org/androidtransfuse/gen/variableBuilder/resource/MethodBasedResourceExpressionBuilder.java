package org.androidtransfuse.gen.variableBuilder.resource;

import com.google.inject.assistedinject.Assisted;
import com.sun.codemodel.JExpression;
import org.androidtransfuse.gen.InjectionBuilderContext;
import org.androidtransfuse.model.InjectionNode;

import javax.inject.Inject;

public class MethodBasedResourceExpressionBuilder implements ResourceExpressionBuilder {

    private String accessMethod;
    private InjectionNode resourcesInjectionNode;

    @Inject
    public MethodBasedResourceExpressionBuilder(@Assisted String accessMethod,
                                                @Assisted InjectionNode resourcesInjectionNode) {
        this.accessMethod = accessMethod;
        this.resourcesInjectionNode = resourcesInjectionNode;
    }

    @Override
    public JExpression buildExpression(InjectionBuilderContext context, JExpression resourceIdExpr) {
        JExpression resourcesVar = context.buildVariable(resourcesInjectionNode);

        return resourcesVar.invoke(accessMethod).arg(resourceIdExpr);
    }
}