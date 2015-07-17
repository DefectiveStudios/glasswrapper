/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.defective.BotBlaster;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;

/**
 * An implementation of the game that acts as a tutorial, restricting certain gestures to match
 * the instruction phrases on the screen.
 */
public class TutorialActivity extends Activity {

	private GestureDetector mGestureDetector;
    private TextView mTextView;
    
    List<String> tutorialPhrases;
    int cardIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_gameplay);

        //mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Hide the status bar in tutorial mode.
        mTextView = (TextView)findViewById(R.id.phrase_primary);
        tutorialPhrases = Arrays.asList(getResources().getStringArray(
                R.array.tutorial_phrases));

        mTextView.setText(tutorialPhrases.get(cardIndex));


        mGestureDetector = new GestureDetector(this).setBaseListener(mBaseListener);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return mGestureDetector.onMotionEvent(event);
    }
    private final GestureDetector.BaseListener mBaseListener = new GestureDetector.BaseListener() {
        @Override
        public boolean onGesture(Gesture gesture) {
        switch (gesture) {
            case SWIPE_LEFT:
                cardIndex--;
                if (cardIndex == tutorialPhrases.size() - 1) {
                    finish();
                }
                if(cardIndex < 0)
                    cardIndex = 0;
                mTextView.setText(tutorialPhrases.get(cardIndex));
                return true;
            case SWIPE_RIGHT:
                cardIndex++;
                if (cardIndex == tutorialPhrases.size()) {
                    finish();
                    return true;
                }
                mTextView.setText(tutorialPhrases.get(cardIndex));
                return true;
            default:
                return false;
        }
        }
    };
}
