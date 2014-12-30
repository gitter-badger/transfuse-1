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
package org.androidtransfuse.integrationTest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.androidtransfuse.integrationTest.R;

/**
 * Tests and demonstrates that you may still use and mix the regular Android Activities with Transfuse.
 *
 * @author John Ericksen
 */
public class NotManagedActivity extends Activity {

    private static final String MANAGED_TEXT = "This Activity's Manifest entry is not added, but it is possible to add it yourself";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        TextView textView = (TextView) findViewById(R.id.displayText);

        textView.setText(MANAGED_TEXT);
    }
}
