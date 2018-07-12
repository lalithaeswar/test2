package sampleproject.com.task1.helper;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public abstract class TextValidator implements TextWatcher {
    private final TextView textView;
    private final EditText editText;

    public TextValidator(TextView textView ,EditText editText) {
        this.textView = textView;
        this.editText=editText;
    }

    public abstract void validate(TextView textView, EditText editText);

    @Override
    final public void afterTextChanged(Editable s) {
        Log.d("afterTextChanged", "afterTextChanged: "+s);
        validate(textView, editText);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d("beforeTextChanged", "beforeTextChanged: "+s);

        /* Don't care */ }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("onTextChanged", "onTextChanged: "+s);
        /* Don't care */ }

}
