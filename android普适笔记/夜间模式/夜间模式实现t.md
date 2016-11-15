#夜间模式实现
*******
###1.Theme方式实现
具体方法如下：

1. 在工程 res/values/attrs.xml 文件中，增加自定义属性。
2. 在工程增加自定义属性用到的颜色和引用。
3. 在工程 res/values/styles.xml 文件中，增加“AppSunTheme” 和“AppNightTheme”,parent 均为AppBaseTheme. 同时在这两个styles中一一对应的加入attrs.xml文件中的属性。
4. 将layout中.xml中需要根据主题改变的元素的background 和 color 设为自定义styles中的属性。
5. 在工程中加入NightModeUtils类来配置应用主题。因为这里要改变整个APP的主题，所以传给NightModeUtils的Context应该是Application的Context。
6. 在每个Activity中增加调用nightModeUtils类的设置主题方法。注意要加在setContentView方法之前。
7. 将Mainfest配置文件中Application 的theme设为默认的AppSunTheme.
8. 最后需要注意一点，settheme方法只能在onCreate方法中实现，所以如果要改变当前Activity的注意要将当前Activity先finish再重新启动Activity。

<a href="http://blog.csdn.net/u012572538/article/details/38726549">**网页链接**</a>
<br><a href="https://github.com/JessicaDong/Captcha-and-Night-Mode">**源代码**</a>