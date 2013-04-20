PLA(PinterestLikeAdapterView)
==================================
-

修复了setloadmorelistener 的bug

基于[PinterestLikeAdapterView](https://github.com/huewu/PinterestLikeAdapterView)开源项目的瀑布流控件。



 **非原创项目**，基于[PinterestLikeAdapterView](https://github.com/huewu/PinterestLikeAdapterView)开源项目的瀑布流控件。

 * 1、修正[PinterestLikeAdapterView](https://github.com/huewu/PinterestLikeAdapterView)下拉刷新的Bug。
 * 2、添加到列表底部自动添加更多数据的接口：setLoadMoreListener(...)
  	


特性
-----------
 * **纯组件** 像原生ListView一样使用。
  
  > 类，就应该有其明确的职责。不要把无相关的功能都死命的往这个类里塞塞塞塞塞塞。
  图片加载不是瀑布流组件的功能！
  判断网络是否正常不是瀑布流组件的功能!
  怎么创建瀑布流组件Item的View，也不是瀑布流组件的功能！

 * 自定义瀑布流列数

 * 支持到列表底部自动加载更多数据

 * 支持下拉刷新：MultiColumnPullToRefreshListView

## License

    Copyright 2012 huewu.yang
    Copyright 2012 chenyoca

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
