package com.mythoughts.helper;

import android.content.Context;
import android.widget.EditText;

public class InputValidation {
    Context context;
    public InputValidation(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilled(EditText textInputEditText, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
           textInputEditText.setError(message);
        textInputEditText.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    public boolean isInputEditTextEmail(EditText textInputEditText, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputEditText.setError(message);
            textInputEditText.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    public boolean isInputEditTextMatches( EditText textInputEditText1, EditText textInputEditText2,  String message) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            textInputEditText2.setError(message);
            return false;
        } else {
            return true;
        }

    }

    /**
     * method to Hide keyboard
     *
     * @param view
     */

}