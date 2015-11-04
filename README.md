# GridViewPager

GridView in ViewPager

<img src="https://github.com/MasonLiuChn/GridViewPager/raw/master/example/doc/1.png"  width="320" height="520"/>
<img src="https://github.com/MasonLiuChn/GridViewPager/raw/master/example/doc/2.png"  width="320" height="520"/>
<img src="https://github.com/MasonLiuChn/GridViewPager/raw/master/example/doc/3.png"  width="320"/>

#Usage: 
example：
```java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<String> list= Arrays.asList(mStrs);
        mViewPager = (GridViewPager) findViewById(R.id.myviewpager);
        mViewPager.setGridViewPagerDataAdapter(new GridViewPagerDataAdapter<String>(list, 2, 4) {
            @Override
            public BaseAdapter getGridViewAdapter(List<String> currentList,int pageIndex) {
                return new MyGridViewAdapter(getApplicationContext(), currentList);
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id, int pageIndex) {

            }
        });
    }
 ```   
 ```java
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.MasonLiuChn:GridViewPager:1.0.2'
}
```

#Contact me:

Blog:http://blog.csdn.net/masonblog

Email:MasonLiuChn@gmail.com

#License:
    Copyright 2013 MasonLiu, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


