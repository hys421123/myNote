    
##1.Tint 
tint翻译为**着色**<br>
<pre>
&lt;ImageView
		.....
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_person_white"
        android:tint="@color/black"
        />
</pre>
tint着色，是定义图片的alpha遮罩，并且可以轻松的使用android:tint属性去调整色调。
相当于上面罩上某色面板。

##2.Tint与background上色
<img src="tint1.png"/>
以上分别是原图、background="red"、tint="black"的设置，可以清楚的发现两者的区别！

##3.Tint着色


<table border="1">
	<tr>
		<th>android属性</th>	
		<th>method</th>
		<th>注释</th>
	</tr>

	<tr>
		<td>android:tint</td>
		<td>setImageTintList(ColorStateList) </td>
		<td>为图片设置渲染颜色 </td>
	</tr>


	<tr>
		<td>android:tintMode</td>
		<td>setImageTintMode(PorterDuff.Mode)</td>
		<td>BS图片渲染的混合模式</td>
	</tr>
</table>
	
	 .