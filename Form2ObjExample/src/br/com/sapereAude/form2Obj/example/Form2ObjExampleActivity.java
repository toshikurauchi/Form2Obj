package br.com.sapereAude.form2Obj.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import br.com.sapereAude.form2Obj.Form2Obj;

public class Form2ObjExampleActivity extends Activity {
	
	private Contact contact;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        
        contact = Contact.makeDefault();
        
        Button makeObj = (Button) findViewById(R.id.formToObj);
        makeObj.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new Form2Obj(getResources()).toObj((ViewGroup) findViewById(R.id.form), contact);
				
				TextView result = (TextView) findViewById(R.id.result);
				result.setText(contact.toString());
			}
		});
        
        Button makeForm = (Button) findViewById(R.id.objToForm);
        makeForm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new Form2Obj(getResources()).toForm(contact, (ViewGroup) findViewById(R.id.form));
			}
		});
        
        Button toExample = (Button) findViewById(R.id.toExample);
        toExample.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Form2ObjExampleActivity.this, Form2ObjExampleWithPrefix.class));
			}
		});
    }
}