##1.流程：
 1、普通写法（Retrofit）点击，调用 loadDataByRetrofit方法；

2、loadDataByRetrofit方法第一句，创建call对象，传入 cityId参数。
<pre>
 Call<MainModel> call =apiStores.loadDataByRetrofit("101190201");
</pre>

3.ApiStores接口中包含 天气API网址。  利用了Retrofit的方式请求网络。 ApiStores就是Retrofit请求所需要的接口。 <br>
 在BaseActivity中用Retrofit对象创建一个RequestSerives接口对象: 
<pre>
public ApiStores apiStores = AppClient.retrofit().create(ApiStores.class);
</pre>
 其中，AppClient.retrofit()是创建 Retrofit对象的。

4.接下来，利用call对象发出网络请求: call.enqueue(new RetrofitCallback<MainModel>() {...}<br>
请求成功,调用 public void onSuccess(MainModel model) {dataSuccess(model);}  通过model.getWeatherinfo()得到具体的数据，展示数据，完成整个过程。

###RxJava+Retrofit写法
<pre>
  mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
</pre>

##2.Retrofit
&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;与Okhttp不同的是，Retrofit需要定义一个接口 (接口中可以放入访问请求的网址参数等) ，用来返回我们的Call对象。  Retrofit提供的请求方式注解有@GET和@POST，参数注解有@PATH和@Query等。<br>
相关知识点链接， <a href="http://www.cnblogs.com/wondertwo/p/5838528.html">Retrofit基础知识点</a> &nbsp;&nbsp;&nbsp;<a href="http://blog.csdn.net/bitian123/article/details/51899716">Retrofit实例</a><br>
 加入Converter可以将返回的数据直接格式化成你需要的样子,


##3、MainModel里面有 weatherinfo(WeaherinfoBean类)获取和设置
	weatherinfoBean里有天气的各种信息，包括city,cityid,temp等。


http://www.weather.com.cn/adat/sk/101190201.html

	