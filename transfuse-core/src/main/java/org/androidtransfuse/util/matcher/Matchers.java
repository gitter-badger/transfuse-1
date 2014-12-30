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
package org.androidtransfuse.util.matcher;

import org.androidtransfuse.adapter.ASTType;
import org.androidtransfuse.model.InjectionSignature;

/**
 * Matcher builder utility class.
 *
 * @author John Ericksen
 */
public final class Matchers {

    private Matchers(){
        //empty static utility class constructor
    }

    public static ASTTypeMatcherBuilder type(ASTType astType) {
        return new ASTTypeMatcherBuilder(astType);
    }

    public static InjectionSignatureMatcherBuilder annotated(){
        return new InjectionSignatureMatcherBuilder(new MatchAny());
    }

    public static Matcher<InjectionSignature> signature(InjectionSignature injectionSignature) {
        return type(injectionSignature.getType()).annotated().byAnnotation(injectionSignature.getAnnotations()).build();
    }
}
