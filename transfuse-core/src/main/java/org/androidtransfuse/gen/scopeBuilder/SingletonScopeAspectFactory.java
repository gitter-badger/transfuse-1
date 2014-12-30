/**
 * Copyright 2011-2015 John Ericksen
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
package org.androidtransfuse.gen.scopeBuilder;

import org.androidtransfuse.adapter.classes.ASTClassFactory;
import org.androidtransfuse.analysis.AnalysisContext;
import org.androidtransfuse.analysis.astAnalyzer.ScopeAspect;
import org.androidtransfuse.gen.variableBuilder.VariableFactoryBuilderFactory2;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author John Ericksen
 */
public class SingletonScopeAspectFactory implements ScopeAspectFactory {

    private final VariableFactoryBuilderFactory2 variableFactoryBuilderFactory;
    private final ASTClassFactory astClassFactory;

    @Inject
    public SingletonScopeAspectFactory(VariableFactoryBuilderFactory2 variableFactoryBuilderFactory, ASTClassFactory astClassFactory) {
        this.variableFactoryBuilderFactory = variableFactoryBuilderFactory;
        this.astClassFactory = astClassFactory;
    }

    @Override
    public ScopeAspect buildAspect(AnalysisContext context) {
        return new ScopeAspect(variableFactoryBuilderFactory.buildScopeVariableBuilder(astClassFactory.getType(Singleton.class)));
    }
}
