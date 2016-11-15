##Git与GitHub

###1.Git、GitHub简介
Git 是一款免费、开源的分布式版本控制系统，版本控制是一种记录一个或若干文件内容变化，以便将来查阅特定版本修订情况的系统，对于软件开发领域来说版本控制是最重要的一环，而 Git 毫无疑问是当下最流行、最好用的版本控制系统。

 GitHub 主要提供基于 git 的版本托管服务。也就是说现在 GitHub 上托管的所有项目代码都是基于 Git 来进行版本控制的。<br>
git push origin master       意思就是把本地代码推到远程 master 分支；<br>
 git pull origin maste      意思就是把远程最新的代码更新到本地。一般我们在 push 之前都会先 pull ，这样不容易冲突。

###2.GitHub网站操作
1.repository 仓库  一个项目对应一个仓库。<br>
issue 提的问题、bug等；<br>
fork  分叉  本质上是在原有项目的基础上新建了一个分支，分支的概念后面会在讲解Git的时候说到），他就可以随心所欲的去改进，但是丝毫不会影响原有项目的代码与结构；<br>
watch 观察，  那么以后只要这个项目有任何更新，你都会第一时间收到关于这个项目的通知提醒；<br><br>
2.删除GitHub仓库<br>
进入仓库，右侧中进入Setting选项。

###3.关于GitHub客户端操作
向 GitHub提交项目<br>
<a href="http://www.cocoachina.com/ios/20160212/15024.html">链接</a><br>
提交更新，直接在本地仓库的项目中修改代码即可。<br>
1.<font color="red">先要在github上创建个人仓库</font><br>
2.然后在客户端上<font color="red">clone</font>刚创建的仓库到本地<br>
3.接着打开clone到本地的文件夹 将需要上传的项目添加进去这里以FirstRespository文件夹为例，里面放你想要上传的项目<br>
4.添加之后回到github客户端,<font color="red"><b>先要commit(只有在changes变化完之后才能sync)</b></font>，然后点击右上角的sync按钮同步提交即可。  <font color="blue">注意，有的commit，还要先去掉.git文件夹,是任何文件中都不能有这个!!才能commit。</font>

###4.AS提交代码<br>
<a href="http://www.cnblogs.com/shiwei-bai/archive/2015/11/24/4991132.html"> 整个过程的链接</a><br>

1. 从as中下载github代码，
先要设置ssh 
<a href="http://stormzhang.com/github/2016/06/04/learn-github-from-zero4/">链接</a>
2. 检查AS setting 中的Git.exe是否运行正常。
3. AndroidStudio中<font color="red">从云端导入项目 </font> setting-> Version Control-> GitHub-> 登录账户即可
然后，File->New-> Projects from Version Control-> GitHub-> 
Clone Repository-> 选择你需要的GitHub仓库工程-> Test Successful之后，点击Clone即可。
<font color="red"> 可能 AS中会显示unregistered vcs root detected,add root即可。</font>
4. 把云端代码向as中更新，  VCS-> Git-> Pull
5. 将as更新的代码向 云端提交   Git->Push

###5.其他注意的
提交更新时，说明用英文写出 所做的一些修改,因为时间github上默认有标出，因此不用以时间作为修改说明。