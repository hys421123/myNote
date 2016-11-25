###1.谈谈final、finally、finalize的区别
<font color=red><strong>final</strong></font>：修饰符，<br>
修饰类，不能派生、不能被继承。<br>
修饰变量或方法，不能改变；变量在声明时要给定初值，方法则不能重载。<br>
<font color=red>**finally块**</font>：异常处理(catch匹配)<br>
<font color=red><b>finalize</b></font>：方法名。在垃圾收集器中删除对象之前对对象调用。<br>

###2.&和&&的区别
&是两个数相与，是位与运算符；&&是布尔逻辑运算符，左侧为false时，不会再执行，效率更高。<br>

###3.GC是什么？为什么GC？
GC(garbage collection)垃圾收集器，java程序员不用担心内存管理，因为GC会自动进行管理。<br>

###4.String s = new String("xyz");创建了几个String Object? 
创建了两个，一个是"xyz",另一个是指向"xyz"的对象。<br>

###5.编程题: 写一个Singleton出来。
<pre>
<code>
public class Singleton{
private Singleton();
private static Singleton instance=new Singleton();
public static Singleton getInstance(){
		if(instance==null)
			instance=new Singleton();
		return instance;

	}
}
</code>
</pre>

<br>
###6.面向对象的特征
抽象、继承、封装、多态。

###7.值传递与引用传递
把对象作为参数传递给一个方法，这个方法可改变对象的属性，返回变化后的结果，用哪种传递？<br>
方法接收的是对象的内存引用地址，而不是对象本身。这个引用地址是对象在内存中的位置，它不可能像对象内容那样被改变。所以java语言中没有引用传递，只有值传递。   将对象的引用拷贝一根传入函数里面，这时函数内外引用值是一样（两者指向同一对象)，但这两个引用是两个变量，改变一个指向，不会改变另一个。

###8. switch条件表达式类型
java1.6和之前版本不支持String,之后支持。

###9. overload,override
Override是重写：方法名称、参数个数，类型，顺序，返回值类型都是必须和父类方法一致的。也叫覆盖，指在子类中定义一个与父类中方法同名同参数列表的方法。它的关系是父子关系。是将从父类**<font color="red">继承</font>**过来的方法重新定义一次，重新填写方法中的代码。<br>
Overload是重载:方法名称不变，其余的都是可以变更的搜索。它的关系是同一个类，同一个方法名，不同的方法参数或返回值。
备注：它们都是<font color="red">Java<b>多态性</b>的不同表现</font>

重载举例(overload):
<pre>
class ChongZai{
   public void a(int a);
   public void a(Strting a);
   public void a(int a,int b);
}
如上就是一个重载了 而重载要满足一下条件：
1.必须是同一个类
2.方法名（也可以叫函数）一样
3.参数类型不一样或参数数量不一样
</pre>

重写(override)举例:  继承基类的子类使用的父类方法。