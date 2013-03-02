/**
 * Copyright 2013 John Ericksen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.androidtransfuse.gen.variableBuilder;

import com.sun.codemodel.*;
import org.androidtransfuse.adapter.ASTType;
import org.androidtransfuse.gen.InjectionBuilderContext;
import org.androidtransfuse.gen.ProviderGenerator;
import org.androidtransfuse.gen.UniqueVariableNamer;
import org.androidtransfuse.gen.variableDecorator.TypedExpressionFactory;
import org.androidtransfuse.model.InjectionNode;
import org.androidtransfuse.model.TypedExpression;
import org.androidtransfuse.scope.Scope;
import org.androidtransfuse.scope.Scopes;

/**
 * @author John Ericksen
 */
public class CustomScopeVariableBuilder implements VariableBuilder {

    private final ASTType scopeKey;
    private final TypedExpressionFactory typedExpressionFactory;
    private final ProviderGenerator providerGenerator;
    private final JCodeModel codeModel;
    private final UniqueVariableNamer namer;

    public CustomScopeVariableBuilder(ASTType scopeKey,
                                      TypedExpressionFactory typedExpressionFactory,
                                      ProviderGenerator providerGenerator,
                                      JCodeModel codeModel,
                                      UniqueVariableNamer namer) {
        this.typedExpressionFactory = typedExpressionFactory;
        this.providerGenerator = providerGenerator;
        this.codeModel = codeModel;
        this.namer = namer;
        this.scopeKey = scopeKey;
    }

    @Override
    public TypedExpression buildVariable(InjectionBuilderContext injectionBuilderContext, InjectionNode injectionNode) {

        //build provider
        JDefinedClass providerClass = providerGenerator.generateProvider(injectionNode, true);
        JExpression provider = JExpr._new(providerClass).arg(injectionBuilderContext.getScopeVar());

        //build scope call
        // <T> T getScopedObject(Class<T> clazz, Provider<T> provider);
        JExpression injectionNodeClassRef = codeModel.ref(injectionNode.getClassName()).dotclass();
        JExpression scopesVar = injectionBuilderContext.getScopeVar();
        JExpression scopeVar = scopesVar.invoke(Scopes.GET_SCOPE).arg(codeModel.ref(scopeKey.getName()).dotclass());

        JExpression expression = scopeVar.invoke(Scope.GET_SCOPED_OBJECT).arg(injectionNodeClassRef).arg(provider);

        JVar decl = injectionBuilderContext.getBlock().decl(codeModel.ref(injectionNode.getClassName()),
                namer.generateName(injectionNode), expression);

        return typedExpressionFactory.build(injectionNode.getASTType(), decl);
    }
}