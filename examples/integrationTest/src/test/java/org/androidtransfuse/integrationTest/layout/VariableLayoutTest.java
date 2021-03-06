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
package org.androidtransfuse.integrationTest.layout;

import android.os.Bundle;
import org.androidtransfuse.integrationTest.DelegateUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * @author John Ericksen
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml")
public class VariableLayoutTest {

    private VariableLayoutHandler variableLayoutHandler;
    private VariableLayoutActivity variableLayoutActivity;

    @Before
    public void setup() {
        variableLayoutActivity = Robolectric.buildActivity(VariableLayoutActivity.class).create(new Bundle()).get();

        variableLayoutHandler = DelegateUtil.getDelegate(variableLayoutActivity, VariableLayoutHandler.class);
    }

    @Test
    public void testHandlerDependencyInjection() {
        assertNotNull(variableLayoutHandler.getDependency());
    }

    @Test
    public void testActivityInjection() {
        assertSame(variableLayoutActivity, variableLayoutHandler.getActivity());
    }

    @Test
    public void testGetLayoutCall() {
        assertTrue(variableLayoutHandler.isGetLayoutCalled());
    }
}
