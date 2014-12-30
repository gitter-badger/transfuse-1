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
package org.androidtransfuse.event;

/**
 * Interface defining a triggerable Event Observer.  This interface will be used by the EventManager to call when
 * the associated Event is raised.
 *
 * @see EventManager
 *
 * @author John Ericksen
 */
public interface EventObserver<T> {

    String TRIGGER = "trigger";

    /**
     * Triggers when a T event is triggered on the EventManager which this Observer is registered with.
     * @param object event
     */
    void trigger(T object);
}
