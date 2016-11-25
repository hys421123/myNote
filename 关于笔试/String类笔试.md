
###1.String s = new String("xyz");创建了几个String Object? 
创建了两个，一个是"xyz",另一个是指向"xyz"的对象。<br>

<br>
###2.在Java中String是什么？String是一种数据类型？
String是在java和在java.lang包中定义的一个类，不像基本数据类型int和long。String是不可变的，final的，在Java和JVM使用字符串池(String pool)来存储所有的String对象。 <br>

<br>
###3.写一个方法来检查输入的字符串是否是回文（对称）？
<pre>
private static boolean isPalindrome(String str){
	if(str==null)
		return false;
	StringBuilder builder=new StringBuilder(str);
	builder.reverse();
	return builder.toString().equals(str);
}


private static boolean isPalindromeString(String str) {
	if (str == null)
		return false;
	int length = str.length();
	System.out.println(length / 2);
	for (int i = 0; i < length / 2; i++) {
		if (str.charAt(i) != str.charAt(length – i – 1))
			return false;
	}
	return true;
}
</pre>

<br>
###4.写一个方法从字符串中删除给定字符
<pre>
private static String removeChar(String str,char c){
	if(str==null)
		return null;
	return str.replaceAll(Character.toString(c),"");

}
</pre>

<br>
###5.怎么才能转换字符串大写或小写？
String.toUpperCase
String.toLowerCase

<br>
###6.比较两个字符串
str1.compareTo(str2);<br>
<font color="blue"><b>注：比较==,equals,compareTo的区别</b></font><br>
**1. ==主要是两个变量值的比较,返回值为true 或者是false。**<br>
<pre>
String  a=new String("abc");
String  b=new String("abc");
</pre>
a==b; 返回的则是一个false。这是因为，对于对象的比较是对对象引用的比较，对于a和b ，他们在内存中对应的地址是不一样的，所以 a==b 返回的值是一个false。==操作符并不涉及对象内容的比较。若要对对象内容进行比较，则用equals。<br>
**2. equals,与compareTo**<br>
equals只返回 true or false。
compareTo 返回的是 int 型，根据字母顺序进行比较。
<pre>
if(a.compareTo(b)==0)
if(a.equals(b))
</pre>

<br>
###7.可否在switch中使用字符串
java7可以，之前版本不行。

<br>
###<font color=red>8.编写程序，打印所有字符串的所有排列。如：AAB,ABA,BAA(难)</font>
<pre>
package com.jd.first;

import java.util.HashSet;
import java.util.Set;

/**
* Java Program to find all permutations of a String
* @author pankaj
*
*/
public class StringHelper {
public static Set<String> permutationFinder(String str) {
Set<String> perm = new HashSet<String>();
//Handling error scenarios
if (str == null) {
return null;
} else if (str.length() == 0) {
perm.add(“”);
return perm;
}
char initial = str.charAt(0); // first character
String rem = str.substring(1); // Full string without first character
Set<String> words = permutationFinder(rem);
for (String strNew : words) {
for (int i = 0;i<=strNew.length();i++){
perm.add(charInsert(strNew, initial, i));
}
}
return perm;
}

public static String charInsert(String str, char c, int j) {
String begin = str.substring(0, j);
String end = str.substring(j);
return begin + c + end;
}

public static void main(String[] args) {
String s = “AAC”;
String s1 = “ABC”;
String s2 = “ABCD”;
System.out.println(“\nPermutations for ” + s + ” are: \n” + permutationFinder(s));
System.out.println(“\nPermutations for ” + s1 + ” are: \n” + permutationFinder(s1));
System.out.println(“\nPermutations for ” + s2 + ” are: \n” + permutationFinder(s2));
}
}
</pre><br>

<br>
###9.String和StringBuilder的区别
1. 简单地说，就是一个变量和常量的关系。StringBuffer对象的内容可以修改；而String对象一旦产生后就不可以被修改，重新赋值其实是两个对象。
2. StringBuffer的内部实现方式和String不同，StringBuffer在进行字符串处理时，不生成新的对象，在内存使用上要优于String类。所以在实际使用时，如果经常需要对一个字符串进行修改，<b>例如插入、删除等操作</b>，使用StringBuffer要更加适合一些。
