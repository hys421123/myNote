##1.关于selector失效的问题
<pre>
&lt;item android:drawable="@drawable/pop_ico_delete_normal"/>
&lt;item android:drawable="@drawable/pop_ico_delete_press" android:state_pressed="true"/>
</pre>
这样的代码，打死都没有效果，没有效果，<b>没有效果</b>。

<b>注意：</b>press状态要放在selector 的<font color="red"><b>第一行</b></font><br>
将两个文件修改如下：
<pre>
&lt;item android:drawable="@drawable/pop_ico_delete_press" android:state_pressed="true"/>
&lt;item android:drawable="@drawable/pop_ico_delete_normal"/>
</selector>
</pre>
这样，效果就有了~

同样的道理，   state_selected一项也要放到最前面，而原始状态放置<b>最后面！！</b>
<pre>
&lt;item android:drawable="@android:color/white"  android:state_selected="true"/>
&lt;item android:drawable="@android:color/holo_blue_bright"/>
</pre>
&lt;
##2.selector引用规范问题
正确的写法：
<pre>
&lt;item android:drawable="@android:color/white"  android:state_selected="true"/>
</pre>
容易犯的错误:<br>
1.  &lt;item android:<font color="red">color</font>="@android:color/white"  android:state_selected="true"/><br>
<font color="blue">把item后面的drawable写成 color </font> <br>
2.  selector.xml可以放置到color文件夹中，此时  android:background="@color/selector" <font color="blue">没有错误的！！</font><br>
3. 有的控件需要设置<font color="blue">clickable="true"</font>才能使selector生效!!<br>
4. 针对自定义控件，<br>
  有些部分被  app:pubLayoutClickable="true"给屏蔽clickable了，<br>
  有些部分则在view布局中已经写上relativelayout，屏蔽掉外面的clickable了。<br>
  这些都能导致selector失效！！

