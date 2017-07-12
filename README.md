# ContentViewAnnotation

[ ![Download](https://api.bintray.com/packages/drkcore/maven/ContentViewAnnotation/images/download.svg?version=1.0.0) ](https://bintray.com/drkcore/maven/ContentViewAnnotation/1.0.0/link)

ContentViewAnnotation is a tiny annotation processing lib for getting ContentView layout id.

Many of you may use [ButterKnife][1] for field and method binding in Android app development, and wonder why there is no ContentView annotation to help dealing with boilerplate code like `setContentView(R.layout.activity_main)` in Activity or `return inflater.inflate(R.layout.fragment, container, fase)` in fragment.

And According to [ISSUE#8](https://github.com/JakeWharton/butterknife/issues/8) of ButterKnife, it seems that there still won't be a ContentView annotation in the future.

So I decided to develop my own one, and this is it.

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

Annotation processor will auto generate `ContentViews` class after build,  use it to get layout id and inflate it in BaseActivity:

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

**TIP: ContentViewAnnotation is only designed for getting ContentView id, you are suggested to using this combile with [ButterKnife][1] for field and methon binding.**



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
