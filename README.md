# ContentViewAnnotation

[ ![Download](https://api.bintray.com/packages/drkcore/maven/ContentViewAnnotation/images/download.svg?version=1.0.0) ](https://bintray.com/drkcore/maven/ContentViewAnnotation/1.0.0/link)

[中文版](./README_zh.md)

ContentViewAnnotation is a tiny annotation processing lib for getting ContentView layout id.

Many of you may use [ButterKnife][1] for field and method binding in Android app development. It's a powerful lib but you may be wondering why there is no ContentView annotation to help dealing with boilerplate code like `setContentView(R.layout.activity_main)` in Activity or `return inflater.inflate(R.layout.fragment, container, fase)` in fragment. Click [HERE](https://github.com/JakeWharton/butterknife/issues/8) to know.

Yes, there is no ContentView annotation and won't be one in the future, so I decided to make my own one, and this is it.

# How to use

And add dependencies in module build.gradle:

```groovy
dependencies {
    compile 'core.mate:contentview-annotation:1.0.0'
    annotationProcessor 'core.mate:contentview-compiler:1.0.0'
}
```

Then add @ContentView annotation in your class:

```java
@ContentView(R.layout.activity_first)
public class FirstActivity extends BaseActivity {
}
```

Annotation processor will auto generate `ContentViews` class after build. Use `ContentViews.get(this)` to get layout id and inflate it in your BaseXXX.

In BaseActivity:

```java
import core.annotation.view.ContentViews;

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ContentViews.get(this));
    }
}
```

In BaseFragment:

```java
public abstract class BaseFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(ContentViews.get(this), container, false);
    }
}
```

# Performance

Here is a sample of auto generated class `ContentViews`:

```java
public class ContentViews {

    private static final Map<Class, Integer> map = new HashMap<>(10);

    public static int get(Object obj) {
        Integer id = map.get(obj.getClass());
        if (id == null) {
            Class clz = obj.getClass();
            Class parent = clz;
            while (id == null && (parent = parent.getSuperclass()) != null) {
                id = map.get(parent);
            }
            if (id == null) {
                id = 0;
            }
            map.put(clz, id);
        }
        return id;
    }

    static {
        map.put(core.demo.app.MainActivity.class, 2130968616);
        // Some more bind code...
    }
}
```

It nearly only costs o(1) time for finding in a small HashMap, so we can say that **IT DO NO HARM FOR PERFORMANCE**.

# Tips

- ContentViewAnnotation is only designed for getting ContentView id, you are suggested to using this combiles with [ButterKnife][1] for field and methon binding.
- Be sure add at least one ContentView annotation and build your project when you setup and after clean, or there is no `ContentViews` class will be found.
- Yes, it works totally ok after proguard even you don't add any rules to keep it.

**Fork** or **STAR** me if this inspires you or just makes your code a little bit cleaner, ^_^.

# License

        Copyright 2017 DrkCore

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.

[1]: https://github.com/JakeWharton/butterknife
