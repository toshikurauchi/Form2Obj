package br.com.sapereAude.form2Obj.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import br.com.sapereAude.form2Obj.example.Address;
import br.com.sapereAude.form2Obj.example.Contact;
import br.com.sapereAude.form2Obj.example.Form2ObjExampleActivity;
import br.com.sapereAude.form2Obj.example.R;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class Form2ObjExampleActivityTest {
	private static final String PHONE = "12345678";
	private static final String NAME = "Toshi Kurauchi";
	private static final String AGE = "25";
	private static final String STREET = "1st street";
	private static final String NUMBER = "1234";
	private static final String CITY = "Random City";
	
	private Form2ObjExampleActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = new Form2ObjExampleActivity();
		activity.onCreate(null);
//		ShadowActivity shadowActivity = Robolectric.shadowOf(activity);
//		shadowActivity.getResourceLoader().getResourceExtractor().getResourceName(R.id.address_city);
	}
	
	@Test
	public void ContactShouldBeFilledWithFormValues() throws Exception {
		fillForm();
		Contact contact = createExpectedContact();
		
		TextView result = (TextView) activity.findViewById(R.id.result);
		Button makeObj = (Button) activity.findViewById(R.id.formToObj);
		
		makeObj.performClick();
		
		assertEquals(contact.toString(), result.getText());
	}

	private Contact createExpectedContact() {
		Contact contact = new Contact();
		Address address = new Address();
		contact.setAddress(address);
		address.setCity(CITY);
		address.setNumber(Integer.valueOf(NUMBER));
		address.setStreet(STREET);
		contact.setAge(Integer.valueOf(AGE));
		contact.setName(NAME);
		contact.setPhone(PHONE);
		
		return contact;
	}

	private void fillForm() {
		fillEditTextWithValue(R.id.address_city, CITY);
		fillEditTextWithValue(R.id.address_number, NUMBER);
		fillEditTextWithValue(R.id.address_street, STREET);
		fillEditTextWithValue(R.id.age, AGE);
		fillEditTextWithValue(R.id.name, NAME);
		fillEditTextWithValue(R.id.phone, PHONE);
	}

	private void fillEditTextWithValue(int id, String value) {
		EditText editText = (EditText) activity.findViewById(id);
		editText.setText(value);
	}
}
