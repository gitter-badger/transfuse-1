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
package org.androidtransfuse.gen.componentBuilder;

import org.androidtransfuse.adapter.ASTMethod;
import org.androidtransfuse.gen.ClassGenerationUtil;
import org.androidtransfuse.gen.UniqueVariableNamer;

import javax.inject.Inject;

/**
 * @author John Ericksen
 */
public class MirroredMethodGeneratorFactory {

    private final ClassGenerationUtil generationUtil;
    private final UniqueVariableNamer variableNamer;

    @Inject
    public MirroredMethodGeneratorFactory(UniqueVariableNamer variableNamer, ClassGenerationUtil generationUtil) {
        this.variableNamer = variableNamer;
        this.generationUtil = generationUtil;
    }

    public MirroredMethodGenerator buildMirroredMethodGenerator(ASTMethod interfaceMethod, boolean superCall) {
        return new MirroredMethodGenerator(interfaceMethod, superCall, generationUtil, variableNamer);
    }
}
