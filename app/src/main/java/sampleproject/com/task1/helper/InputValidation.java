package sampleproject.com.task1.helper;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

public class InputValidation {
    Context context;
    public InputValidation(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilled(EditText textInputEditText) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isInputEditTextEmail(EditText textInputEditText) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            return false;
        } else {
            return true;
        }

    }
    public boolean isInputEditTextName(EditText textInputEditText)
    {  String value = textInputEditText.getText().toString().trim();
        String pattern="^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$";
        if (value.matches(pattern))
            return  true;
        else return false;
    }
    public boolean isInputEditTextPassword(EditText textInputEditText)
    {  String value = textInputEditText.getText().toString().trim();

        if (value.length()>6)
            return  true;
        else return false;
    }

    public boolean isInputEditTextMatches( EditText textInputEditText1, EditText textInputEditText2  ) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
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