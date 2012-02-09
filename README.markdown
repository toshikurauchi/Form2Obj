# Form2Obj

*************************************************************************************************
## en_US

Form2Obj lets you write less code to read data from Android EditTexts to set your objects attributes. It is achieved through convention over configuration. You just have to set your EditTexts' ids with your objects attributes' names.

### Setup

1. Download the library jar [available here](https://github.com/downloads/toshikurauchi/Form2Obj/form2obj-v0.8.jar).
2. Create the *lib* folder (if you haven't done so yet).
3. Add the library jar to the *lib* folder and then add it to the project's build path.

### Usage

Create your EditTexts naming their ids after the attribute they represent. For example: for the attribute *name* you can create an EditText with *id/name* as its id.
You can alternatively create a prefix for all your ids that refer to some attribute: *id/myprefix_name* following our example.

In order to set your objects attributes you need an instance of Form2Obj. Then you just have to call *assign(yourFormsViewGroup, yourObject)*. 

### Example

Supose you have the following class:

    public class MyObject {
        private String myAttribute;
    }

And the layout xml:

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:id="@+id/form"
        android:orientation="vertical" >
    
        <TextView 
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="myAttribute Value:"
            />
        <EditText
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:id="@+id/myAttribute" />
    </LinearLayout>

You can read the form with the code below:

    MyObject myObj = new MyObject();
    new Form2Obj(activity.getResources())
                  .assign((ViewGroup) findViewById(R.id.form), myObj);
    
*************************************************************************************************
## pt_BR

TODO
