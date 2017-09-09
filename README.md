# Game
1.1	开发背景
-------------

对于广大的网民和学生，在工作之余能够玩玩游戏也是一种不错的选择的休闲的方式，并且伴随着网络的普及化，越来越多的人们开始加入到游戏的大军中来，所以开发一款适合的游戏显的尤为重要。

1.2 开发环境
-------------

Windos系统，JDK1.8，jre7E，eclipse。

1.3 游戏功能简介
--------------

本游戏在不限定时间的情况下，玩家操控战机，尽可能多的击落敌机获取来获取高分。当己方飞机的生命值消耗完时，游戏结束。

2.1 系统需求分析
---------------

 1、功能需求
对于游戏结果的记录，判断是否有子弹击中飞机，判断是否2架飞机相撞。
2、可靠性可用性需求
能够在在程序异常的时候提示，在断电的情况下自动保存游戏数据。
3、出错处理需求
当游戏出错是，能够弹出一个对话框来提醒用户。
4、游戏数据的处理
对于生成的游戏数据，能够存入数据库的不同字段中。能够记录游戏数据插入数据库中的时间。

2.2 系统性能分析
-----------------

为了保证系统能够长期、安全、稳定、可靠、高效地运行，本系统应该满足以下的性能需求。
(1)	准确性和及时性
程序采用的是坐标定位的方式，对于碰撞检测还是比较全面，能够在一定的范围内检测，并提供了飞机碰撞检测和子弹碰撞检测这2种不同的检测方式。

2.3 系统模块分析
---------------

1、子弹模块：
(1)	用来管理自己的飞机所需要发出的子弹，放在Bulletlist的List类型的数组中。并提供了draw()函数，用来画出不同位置的子弹并利用重画功能，实现子弹的移动。
(2)	敌机子弹功能，也是相应的重画功能，并能够通过EnemyBullet()功能初始化敌机子弹的位置。通过isLive()判读子弹是否有效。getY()，getX()获取子弹的横坐标和纵坐标，为碰撞检测提供依据。
2、飞机模块：
(1)敌机管理
(2)我机管理
添加了键盘监听器，能够对键盘的按钮做出响应。

3.1类的详细设计
--------------

MyPlane 类
-------
1.UML类图

![MyPlane 类](https://github.com/xujianhui1995/Game/blob/master/MyPlane.jpg)

2.详细分析

 (1). 成员变量

-  x，y是int类型的变量，用来记录我方战机的当前位置，进行位图绘制。
- dl，du，dr，dd是Boolean类型的变量，用来判断我方战机正在向那一个方向前进，一直按下某一个方向，将会向那个方向一直行进，直到边界。
- MYPLANE_XSPEED，MYPLANE_XSPEED是int类型的变量，作用是控制我方战机横向和纵向的运行速度，保证一定的速率移动。
- live是Boolean类型的变量，作用是判断我方战机是否死亡

(2). 成员方法

-   MYPlane(int x,int y)构造函数，初始化我方战机的位置，使其位于中央 
-   draw(Graphics g)绘图方法，我方战机位置改变时重新绘制
-   keyPressed(KeyEvent e)按键方法，键盘上按下相应的键码进行相应的移动
-   keyReleased(KeyEvent e)按键释放方法，按键释放使之不再移动
-   move()战机移动方法，键按下后进行移动
-   getX()获得战机的横向位置
-   getY()获得战机的纵向位置
-   isLive()战机是否存活
-   setLive(boolean live)设置飞机存活状态。

Bullet 类
-------
1．UML类图

![Bullet类][1]


  [1]: https://github.com/xujianhui1995/Game/blob/master/Bullet.jpg

2.详细分析

(1) 成员变量

  -   BULLET_SPEED为int类型变量，初始为15.战机发射子弹的速率。
    -   x,y为int类型变量，记录子弹的位置。
    -   live为boolean类型的变量，判断子弹是否为有效状态。
    -   bullet为Image类型变量，加载的子弹类图。 
 
(2) 成员方法

   -   Bullet(int x,int y)构造方法，子弹位图绘制的位置。
    -   draw(Graphics g)绘制子弹位图的方法。
    -   isLive()判断子弹是否为有效状态。
    -   setLive(boolean live)设置子弹是否有效。
-   getX(),getY()获得子弹的位置坐标。

EnemyBullet 类
-----------
1．UML类图

![EnemyBullet 类][1]


  [1]: https://github.com/xujianhui1995/Game/blob/master/EnemyBullet.jpg

2. 详细分析    
    
(1)	成员变量
    
   -   x,y为int类型变量，记录敌机位置坐标。
    -   bulletspeed为int类型变量，初始值为15，用来设置子弹速度的变量。
    -   live为boolean类型变量，判断子弹是否为有效状态。
    -   enemyplanebullet为Image类型变量，敌机子弹所加载的位图。
    (2)	成员方法
    
    -   EnemyBullet(int x,int y)构造方法，初始敌机子弹的位置。
    -   draw(Graphics g)绘制敌机子弹的方法，用来重新绘制。
    -   isLive()敌机子弹是否为存活状态。
    -   setLive(boolean live)设置子弹的状态。
- getX(),getY()获取敌机子弹的坐标，用来重新绘制

Explode 类
-------
1．UML类图

![Explode 类][1]


  [1]: https://github.com/xujianhui1995/Game/blob/master/Explode.jpg
 
2. 详细分析

(1)	成员变量       

-    x,y为int类型变量，记录爆炸位置。        	
-    live 为boolean类型变量，判断爆炸状态。        
-    Explode1为Image类型对象，用来加载爆炸的位图。

(2)	成员方法

-   Explode(int x,int y)构造方法，初始化爆炸位置及位图。
-   draw(Graphics g)绘制方法，用来绘制爆炸位图。
-   isLive()是否为存活状态。
-   setLive(boolean live)设置是否为存活状态。
-   getCount()得到爆炸次数。
-   setCount()设置爆炸次数。

PlayMusic 类
------------
1．UML类图

![EnemyBullet 类][1]


[1]: https://github.com/xujianhui1995/Game/blob/master/PlayMusic.jpg
2. 详细分析

(1)	成员变量

-  musicFile为File类型对象，用来播放的文件。
-  clip为 AudioClip类型对象，进行播放的对象。
-  fileURI 为URI类型对象，文件的URI路径。
-   fileURL 为URL类型对象，文件的URL路径

(2)	成员方法

-   PlayMusic(String music)构造方法，初始化播放的音频文件。
-   play()播放方法，进行音频播放。
-   stop()停止方法，音频停止方法。
-   loop()循环方法，使音频循环播放。
 
GameBox 类
-------------

1．UML类图

![](https://github.com/xujianhui1995/Game/blob/master/GameBox.jpg)

2. 详细分析

(1)	成员变量

- GAME_WIDTH是int型变量 设置游戏面板的宽度为800。
- GAME_HEIGHT 是int型变量设置面板的高度为600。
-  f1I Image类型的对象，用来设置字体的颜色大小和行间距。
- backgroundimage 用来加载背景图片。
- plane Image类型变量，用来设置加载飞机的图片。
- PLANE_WIDTH int类型变量，用来设置飞机的高度。
- PLANE_HEIGHT int类型变量 用来设置飞机的宽度。
- Explode1 Image类型的对象。用来加载爆炸的图片。
- EXPLODE1_WIDTH int类型变量，用来设置爆炸的范围的高度。
- EXPLODE1_HEIGHT int类型变量，用来设置爆炸范围的宽度。
- Bullet Image类型的对象，用来设置子弹需要加载的图片。
- BULLET_WIDTH int型变量，用来设置子弹的宽度。
- BULLET_HEIGHT int 型变量，用来设置子弹的高度。
- enemy1 Image类型的对象，用来设置敌机的宽度。
- enemy2 Image类型的对象，用来设置敌机的高度。
- enemybullet Image类型的对象，用来加载敌机发出的子弹。
- ENEMYBULLET_WIDTH int类型的变量，用来设置子弹的大小。
- ENEMYBULLET_HEIGHT int 类型的变量，用来设置子弹的大小。
- back_music 字符串类型变量，加载背景音乐。
- bomb_music字符串类型变量，加载子弹爆炸音乐。

DB 类
---------

1．UML类图

![](https://github.com/xujianhui1995/Game/blob/master/DB.jpg)

2. 详细分析

(1)	成员变量

- url为String类型对象，数据库URL路径。用来连接数据库。
- driver为String类型对象，加载数据库的驱动。
- conn为Connection类型对象，用来与数据库进行连接。
- stmt为Statement类型对象，用来操作Sql语句从而操纵数据库。

(2)	成员方法

- DB()构造方法，加载数据库驱动，实现数据库连接。
- excuteWrite(String name,String score)将数据写入数据库方法。
- excuteRead()从数据库中读取数据方法。

StartFrame 类
-----
1．UML类图



2. 详细分析
(1)	成员变量

- bk为Image类型对象，用来加载游戏的背景位图。
- myplane为MyPlane类型对象，建立我方战机。
- sourse 为float类型变量，存储分数。
- death, life为我方战机死亡次数和生命值。
- bulletlist为 ArrayList<Bullet>对象，用来存储子弹的线性表。
-  	explodelist 为ArrayList<Explode>对象，用来存储爆炸对象的线性表。
- enemybulletlist为 ArrayList<EnemyBullet>对象，用来存储敌机子弹对象的线性表。
- exItem,score为Jmenu类型对象，菜单条目。
- jp为Jpanel对象，框架类的面板对象。
- db为DB对象，用来进行数据库操作。
- musicBackground musicBomb为PlayMusic对象，用来播放背景音乐。
(2)	成员方法
- StartFrame()构造方法，初始化面板及位图。加载游戏界面。
- queryRecord()查询分数记录方法。
- void run()游戏进行线程方法，实现游戏的运行。
- clearEnemyBullet()清除无效的敌机子弹。
- clearBullet()清除无效的子弹。
- createBullet()创建子弹。
- clearEnemyplane()清除敌机状态为False的对象。
- clearExplode()清除爆炸状态为False的对象。
- hitPlane()攻击敌机的方法。
- impactMyplane()判断是否碰撞。
- hitMyplane()我方战机被攻击的方法。
- endGame()结束游戏，扫尾方法。
- recored()记录成绩方法。
- ifEnd()判断是否结束。
- actionPerformed(ActionEvent e)菜单条目的动作事件实现方法。
 
小结
-------
在本次课程设计中，我们小组采用分工合作方式。在程序代码和设计报告书写中，小组两人均分工占比达到的50%左右，在代码的设计以及调试中，互相学习交流，对程序代码中有迷糊时，通过讨论、查阅资料来解决这些问题，从而保证了进度。这次课程设计遇到了许多问题，这也充分暴露了Java知识存储量的不够，在一些Java基础知识上比较薄弱，不明以。通过了课程设计的问题出现，重新学习了Java的基础知识，对Java知识又有了一个重新的理解。另外一个主要的问题就是在代码的书写中，有许多Java类以及函数不知道，以至于绕了很多弯路。在课程设计的代码书写过程中养成了查阅JavaAPI的好习惯，相信会在以后的程序设计中起到重要作用。针对这一次的课程设计，我做了以下总结：(1)Java是一门面向对象的语言，在程序设计中要有面向对象的思想，相比于代码。我认为面向对象的思想更加重要，在以后的学习中，要持续培养这种思维。(2)Java程序中查阅JavaAPI是一种比较好的方法，通过不断的查阅学习过程，能够累积许多新知识，久而久之就是一份巨大的财富。(3)Java程序中要学会设计，最好是能够懂得设计模式的相关知识，这在程序各个方面都是比较重要的。

