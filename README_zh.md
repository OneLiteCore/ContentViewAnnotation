# ContentViewAnnotation

[ ![Download](https://api.bintray.com/packages/drkcore/maven/ContentViewAnnotation/images/download.svg?version=1.0.0) ](https://bintray.com/drkcore/maven/ContentViewAnnotation/1.0.0/link)

ContentViewAnnotation 是用于查找 ContentView id 的编译时注解框架。

你可能使用过 [ButterKnife][1] 来处理视图和事件的注解，但你仍然需要一遍又一遍地在 Activity 和 Fragment 中编写 `setContentView(R.layout.activity_main)` 和 `return inflater.inflate(R.layout.fragment, container, fase)`，究其原因是因为缺少了 ContentView 注解。各种缘由可以点[这里](https://github.com/JakeWharton/butterknife/issues/8)进行了解。

总之 ContentView 注解就是没有，以后也不可能会有。没有轮子就只能自己造，于是就有了你现在看到的这个框架。

# 如何使用

在 Module 的 build.gradle 文件中添加如下依赖:

```groovy
dependencies {
    compile 'core.mate:contentview-annotation:1.0.0'
    annotationProcessor 'core.mate:contentview-compiler:1.0.0'
}
```

在类中使用 @ContentView 注解:

```java
@ContentView(R.layout.activity_first)
public class FirstActivity extends BaseActivity {
}
```

Build 后注解处理器会自动生成可以用于获取 layout id 的辅助类 `ContentViews` ，接着在你的 BaseActivity 实例化布局即可:

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

**如你所见，ContentViewAnnotation 只能用于获取 layout id，其他的视图和事件的注解依然推荐你使用 [ButterKnife][1]。**

如果你觉得这个框架也是极好的，或者确实帮你省下了几行代码，别客气地给个 **STAR** 可好？

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
