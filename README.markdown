# Form2Obj

*************************************************************************************************
## en_US

Form2Obj simplifies the object creation from Android EditTexts values and filling EditText based forms from an objects attributes. It is achieved through [convention over configuration](http://en.wikipedia.org/wiki/Convention_over_configuration). You just have to set your EditTexts' ids with your objects attributes' names.

### Setup

1. Download the library jar [available here](https://github.com/downloads/toshikurauchi/Form2Obj/form2obj-v0.9.jar).
2. Create the *lib* folder (if you haven't done so yet).
3. Add the library jar to the *lib* folder and then add it to the project's build path.

### Usage

Create your EditTexts naming their ids after the attribute they represent. For example: for the attribute *city* you can create an EditText with *id/city* as its id.
You can alternatively create a prefix for all ids that refer to some attribute: *id/myprefix_city* in our example.

You will need an instance of Form2Obj. In order to set your objects attributes you just have to call *toObj(yourFormsViewGroup, yourObject)* or *toObj(yourFormsViewGroup, yourObject, "yourPrefix")*. To fill EditTexts with an objects attributes call *toForm(yourObject, yourFormsViewGroup)* or *toForm(yourObject, yourFormsViewGroup, "yourPrefix")*.

You can also have nested attributes! To use them just use '_' to separate their names from their attributes. For example: *id/myprefix_state_city_name* will create (in case it still doesn't exist) an instance of *state*'s class and set it to your object's attribute *state*, doing the same with the *state*'s *city* and the *city*'s *name*.

### Example

Supose you have the following classes:

    public class MyObject {
        private MyNestedAttribute myNestedAttribute;
    }

    public class MyNestedAttribute {
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
            android:id="@+id/myNestedAttribute_myAttribute" />
    </LinearLayout>

You can read the form with the code below:

    MyObject myObj = new MyObject();
    new Form2Obj(activity.getResources())
                  .toObj((ViewGroup) findViewById(R.id.form), myObj);

In order to fill the EditText with you objects attributes:

    MyObject myObj = // get an instance of MyObject with nested attributes
    new Form2Obj(activity.getResources())
                  .toForm(myObj, (ViewGroup) findViewById(R.id.form));

You can also define prefixes:

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
            android:id="@+id/myPrefix_myNestedAttribute_myAttribute" />
    </LinearLayout>

And use the following methods:

    MyObject myObj = new MyObject();
    new Form2Obj(activity.getResources())
                  .toObj((ViewGroup) findViewById(R.id.form), myObj, "myPrefix");

Or:

    MyObject myObj = // get an instance of MyObject with nested attributes
    new Form2Obj(activity.getResources())
                  .toForm(myObj, (ViewGroup) findViewById(R.id.form), "myPrefix");

### Full example

Available [here](https://github.com/toshikurauchi/Form2Obj/tree/master/Form2ObjExample)

### More info & contact

andrew dot kurauchi at gmail dot com

*************************************************************************************************
## pt_BR

O Form2Obj simplifica a criação de objetos a partir de valores de EditTexts do Android e o preenchimento de formulários baseados em EditTexts a partir dos atributos de um objeto. Esse resultado é obtido através de [convenção sobre configuração](http://pt.wikipedia.org/wiki/Conven%C3%A7%C3%A3o_sobre_configura%C3%A7%C3%A3o). Basta criar os ids dos seus EditTexts com os mesmos nomes dos atributos de seu objeto.

### Configuração

1. Faça o download do jar da biblioteca [disponível aqui](https://github.com/downloads/toshikurauchi/Form2Obj/form2obj-v0.9.jar).
2. Crie o diretório *lib* (caso ainda não o tenha feito).
3. Adicione o jar da biblioteca ao diretório *lib* e então adicione-o no build path de seu projeto.

### Utilização

Crie os seus EditTexts utilizando o nome dos atributos que eles representam como seus ids. Por exemplo: para o atributo *cidade*, crie um EditText com *id/cidade* como seu id.
Você pode, alternativamente, utilizar um prefixo para todos os ids que se referem a algum atributo: *id/meuPrefixo_cidade* seguindo nosso exemplo.

Você vai precisar de uma instância de Form2Obj. Para setar os atributos de seu objeto basta chamar *toObj(viewGroupDoSeuForm, seuObjeto)* ou *toObj(viewGroupDoSeuForm, seuObjeto, "seuPrefixo")*. Para preencher os EditTexts com os atributos do seu objeto chame *toForm(seuObjeto, viewGroupDoSeuForm)* ou *toForm(seuObjeto, viewGroupDoSeuForm, "seuPrefixo")*.

Você pode também utilizar atributos encadeados! Para tal, use '_' para separar seus nomes dos seus respectivos atributos encadeados. Por exemplo: *id/meuPrefixo_estado_cidade_nome* criará (caso ainda não exista) uma instância da classe de *estado*, setando-o com o atributo *estado* de seu objeto, fazendo o mesmo com a *cidade* do *estado* e o *nome* da *cidade*.

### Exemplo

Suponha que temos as seguintes classes:

    public class MeuObjeto {
        private MeuAtributoEncadeado meuAtributoEncadeado;
    }

    public class MeuAtributoEncadeado {
        private String meuAtributo;
    }

And the layout xml:

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:id="@+id/formulario"
        android:orientation="vertical" >
    
        <TextView 
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="Valor do meu atributo:"
            />
        <EditText
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:id="@+id/meuAtributoEncadeado_meuAtributo" />
    </LinearLayout>

Você pode ler o formulário com o código abaixo:

    MeuObjeto meuObjeto = new MeuObjeto();
    new Form2Obj(activity.getResources())
                  .toObj((ViewGroup) findViewById(R.id.formulario), meuObjeto);

Para preencher o EditText com o atributo de seu objeto:

    MeuObjeto meuObjeto = // cria uma instância de MeuObjeto com seus atributos encadeados
    new Form2Obj(activity.getResources())
                  .toForm(meuObjeto, (ViewGroup) findViewById(R.id.formulario));

Você também pode definir prefixos:

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:id="@+id/formulario"
        android:orientation="vertical" >
    
        <TextView 
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="Valor do meu atributo:"
            />
        <EditText
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:id="@+id/meuPrefixo_meuAtributoEncadeado_meuAtributo" />
    </LinearLayout>

E utilizar os seguintes métodos:

    MeuObjeto meuObjeto = new MeuObjeto();
    new Form2Obj(activity.getResources())
                  .toObj((ViewGroup) findViewById(R.id.formulario), meuObjeto, "meuPrefixo");

Ou:

    MeuObjeto meuObjeto = // cria uma instância de MeuObjeto com seus atributos encadeados
    new Form2Obj(activity.getResources())
                  .toForm(meuObjeto, (ViewGroup) findViewById(R.id.formulario), "meuPrefixo");

### Exemplo completo

Disponível [aqui](https://github.com/toshikurauchi/Form2Obj/tree/master/Form2ObjExample)

### Mais informações e contato

andrew ponto kurauchi arroba gmail ponto com
