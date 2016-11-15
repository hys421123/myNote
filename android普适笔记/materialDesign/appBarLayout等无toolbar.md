AppBarLayout 是继承LinerLayout实现的一个ViewGroup容器组件，它是为了Material Design设计的App Bar，支持手势滑动操作。

##coordinatorLayou
CoordinatorLayout作为“super-powered FrameLayout”基本实现两个功能： <br>
1. 作为顶层布局<br>
2. 调度协调子布局

Design Support Library包含8个控件，
<table border="1">
	<tr>
		<th>Widget Name</th>	
		<th>Description</th>
	</tr>

	<tr>
		<td>android.support.design.widget.DrawerLayout </td>
		<td>是Support Library包中实现了侧滑菜单效果的控件</td>
	</tr>

	<tr>
		<td>android.support.design.widget.CoordinatorLayout</td>
		<td>超级FrameLayout</td>
	</tr>

	<tr>
		<td>android.support.design.widget.AppBarLayout</td>
		<td>AppBarLayout继承自LinearLayout，布局方向为垂直方向。所以你可以把它当成垂直布局的LinearLayout来使用。</td>
	</tr>

	<tr>
		<td>android.support.design.widget.TextInputLayout </td>
		<td>强大带提示的MD风格的EditText </td>
	</tr>

	<tr>
		<td>android.support.design.widget.FloatingActionButton </td>
		<td>MD风格的圆形按钮，来自于ImageView,跟button的功能类似</td>
	</tr>

	<tr>
		<td>android.support.design.widget.Snackbar</td>
		<td>类似Toast，添加了简单的单个Action</td>
	</tr>

	<tr>
		<td>android.support.design.widget.TabLayout</td>
		<td>选项卡</td>
	</tr>

	<tr>
		<td>android.support.design.widget.NavigationView</td>
		<td>DrawerLayout的SlideMenu</td>
	</tr>

	<tr>
		<td>android.support.design.widget.CollapsingToolbarLayout</td>
		<td>可折叠MD风格ToolbarLayout,继承至FrameLayout</td>
	</tr>
</table> <br>
**下面详细说说这些控件的特性和使用注意项。**<br>
###<font color="red">1. Snackbar被看作是比Toast更强大的快速反馈机制。</font>
* FloatingActionButton 利用CoordinatorLayout提供的回调方法，在Snackbar以动画效果进入的时候自动向上移动让出位置，并且在Snackbar动画地消失的时候回到原来的位置，不需要额外的代码。
* 可以自定义action-可选操作
* swiping it off the screen可以让FAB消失
* 显示在所有屏幕其它元素之上(屏幕最顶层)，并不是像Toast一样覆盖在屏幕上
* 同一时间只能显示一个snackbar
<pre>
Snackbar.make(view, message, duration)
       .setAction(action message, click listener)
       .show();
</pre>

<br><br>

###<font color="red">2. AppBarLayout extends LinearLayout</font>
AppBarLayout is a vertical LinearLayout which implements many of the features of material designs app bar concept, namely scrolling gestures.

 <android.support.design.widget.CoordinatorLayout>       

     <android.support.v4.widget.NestedScrollView
            ......>
         <!-- Your scrolling content -->
     </android.support.v4.widget.NestedScrollView>

     <android.support.design.widget.AppBarLayout
           .....>
         <android.support.v7.widget.Toolbar
            	 ....../>
         <android.support.design.widget.TabLayout
         	 ....../>
     </android.support.design.widget.AppBarLayout>
 </android.support.design.widget.CoordinatorLayout>

AppBarLayout配合ToolBar与CollapsingToolbarLayout等使用。就是一个纯容器类。<br>
AppBarLayout是在LinearLayou上加了一些材料设计的概念，它可以让你定制当某个可滚动View的滚动手势发生变化时，其内部的子View实现何种动作。<br>
请注意：上面提到的某个可滚动View，可以理解为某个ScrollView。怎么理解上面的话呢？就是说，当某个ScrollView发生滚动时，你可以定制你的“顶部栏”应该执行哪些动作（如跟着一起滚动、保持不动等等）。那某个可移动的View到底是哪个可移动的View呢？这是由你自己指定的！如何指定，我们后面说。<br>
  文／huachao1001（简书作者）
<a href="http://www.jianshu.com/p/d159f0176576">原文链接</a>


<br><br>

###<font color="red">3. 关于Toolbar的设置问题</font>
toolbar<b>左边</b>图标是navigationIcon: <br>
 Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
 toolbar.setNavigationIcon(R.drawable.ic_back);<br>
其中toolbar有一个toolbartitle,默认为app的命名，去掉赋值"",即toolbar.setTitle("");<br>
<font color="blue">**注意：**</font>navigationIcon的点击事件设置如下所示<br>
<pre>
 在onOptionsItemSelected方法中判断
  if(id==android.R.id.home){
 //Toast.makeText(MainActivity.this, "You Clicked Lock Icon", Toast.LENGTH_SHORT).show();
 }
</pre>


<br>
<b>右边</b>图标或文字则是
<pre>
//这里创建右边图标，图标样式来自R.menu.menu_main
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    
// 这里是对应的点击后出现的item选项
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                MyLog.i("setting");
            break;
            case R.id.action_nightmode:
                MyLog.i("nightmode");
                int theme = NightModeUtils.getDayNightMode(MainActivity.this);
                Context context = getApplicationContext();
                if (theme == NightModeUtils.THEME_SUN) {
                    NightModeUtils.setDayNightMode(context,
                            NightModeUtils.THEME_NIGHT);
                    setTheme(R.style.AppSunTheme);
                    recreate();
                }
                else {
                    NightModeUtils.setDayNightMode(context,
                            NightModeUtils.THEME_SUN);
                    setTheme(R.style.AppNightTheme);
                    recreate();
                }
                return true;
        }//switch
		
		return super.onOptionsItemSelected(item);
	}

//menu的xml如下
menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context="com.example.materialdesign.MainActivity"

//这是添加文字
    item
        android:id="@+id/action_search"
        android:orderInCategory="100"
        android:title="忘记密码？"
        app:showAsAction="always"
        />

//这是在菜单上添加选项
//对应menu图标(三个点)点击后出现的选项
   item
        android:id="@+id/action_settings"
        android:orderInCategory="100"
        android:title="@string/action_settings"
        app:showAsAction="never" />
    item
        android:id="@+id/action_nightmode"
        android:orderInCategory="100"
        android:title="NightMode"
        app:showAsAction="never"
        />

//这是对应的搜索图标
   item
        android:id="@+id/action_search"
        android:icon="@drawable/ic_search_white_24dp"
        android:orderInCategory="100"
        android:title="@string/action_search"
        app:actionViewClass="android.support.v7.widget.SearchView"
        app:showAsAction="always" />
</pre>


###<font color="red">4. 关于DrawerLayout</font>
可以说drawerLayout是因为第三方控件如MenuDrawer等的出现之后，google借鉴而出现的产物。drawerLayout分为侧边菜单和主内容区两部分，侧边菜单可以根据手势展开与隐藏（drawerLayout自身特性），主内容区的内容可以随着菜单的点击而变化（这需要使用者自己实现）。
<a href="http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/0925/1713.html">链接知识点</a>

###<font color="red">5. 关于CollapsingToolbarLayout</font>
CollapsingToolbarLayout是用来对Toolbar进行再次包装的ViewGroup，主要是用于实现折叠（其实就是看起来像伸缩~）的App Bar效果。<font color="red">它需要放在AppBarLayout布局里面</font>，并且作为AppBarLayout的直接子View。

<a href="http://www.open-open.com/lib/view/open1438265746378.html">链接知识点</a>


