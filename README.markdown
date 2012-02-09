# Form2Obj

*************************************************************************************************
## en_US

Form2Obj lets you write less code to read data from Android EditTexts to set your objects attributes. It is achieved through convention over configuration. You just have to set your EditTexts' ids with your objects attributes' names.

### Setup

1. TODO

### Usage

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
