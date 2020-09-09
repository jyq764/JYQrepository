# JYQrepository

estore项目：
1、需求分析：
	简单的购书电商网站，用户能够实现注册登录，管理个人信息，浏览商品详情，添加购物车，管理订单，二维码支付等操作。
2、概要及详细设计：
	明确数据库中应该存在具体的哪些表，（将来在项目中根据这些表用mybatis-generator会自动生成表对应的实体类和映射接口映射文件）
	图书表es_book，用户表es_customer，订单表es_orderform，订单项表es_orderline，目录表es_category，地址表es_address
	主要功能：（登录/注册模块   购物车模块   订单模块）
	1）用户注册登录功能
	2）主页中可以展示书籍目录、热点图书、相关资讯，对应的图书可以点击查看书籍详情，
	     主页中的每个按钮可以实现对应的功能如：去购物车结算，登录，退出，个人信息，我的订单等
	3）添加购物车功能
	4）提交订单，选择收货地址
	5）订单表页面展示所有提交的订单，然后对应的订单可查看明细、可删除、可支付
3、搭建环境：
	后台技术：
		三层架构   servlet   maven  mybatis-generator
		mysql数据库  log4j  xml
	前台技术：
		jsp  html/css   jquery   javascript
	sts3.9.6
	jdk1.8
	tomcat8.5
	mysql
	maven
	项目搭建流程：
	选择或新建一个工作空间，需要做或修改以下配置：
	1）配置JDK	
	     1.点击windows--Preferences--Java--Installed JRE。
	     2.点击右边的Add--next
	     3.找到你的java文件路径，先择进去
	     4.返回选中，点击apply即可
	2）配置tomcat
	     1.windows--Preferences--Server--Runtime
	     2.Add--Apache,选中本地已经有的Tomcat版本，加入进去，最后finish,
	     3.在下面工具栏中右键servers-->new-->server（切换右上角工作环境为Java EE）
	     4.选择合适的server type 和之前添加的Server runtime environment
 	     5.完成
	3）设置编码
	     1.windows--Preferences-workspace--UTF-8
	     修改字体
	     1.windows-perferences-General(常规)——Apprearance(外观)——Colors and Fonts(颜色和字体)
	     2.Basic(基本)——Text Font(文字字体)——Edit(编辑)
	     自动提示
	     1.window->preference->Java->Editor->Content Assist
	     2. .abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
	4）配置maven（maven就是通过pom.xml中配置依赖来管理第三方jar包，使得项目依赖于其他已经提供好的jar包）
	     F:\jd03\第六教室串讲\estore\estore项目资料\maven\maven教程.pdf中有详细的图文配置过程
	5）1、新建一个Maven Project-->next-->勾选Create a simple project-->next-->Group Id(公司域名倒写):com.briup
	          -->Artifact Id(项目名): JD03_estore-->Version默认-->Packaging(将来项目打包成什么):war
	     2、(项目报红色错误是因为没有web.xml文件)点击项目右键选择Java EE Tools-->Generate Deployment Descriptor Stub
	          (在src/main/webapp/WEB-INF下面就生成了web.xml,将来所有的servlet访问/listener监听/filter过滤配置都放在该文件中统一管理)
	     3、src/main/resources下面配置generator.xml文件（从上个项目中复制过来的）,
	          修改classPathEntry下的location="E:/graduation/repository/mysql/mysql-connector-java/5.1.47/mysql-connector-java-5.1.47.jar"
	          src/main/resources下还需要配置mybatis-config.xml,根据需要配置log4j.properties和database.properties
	     4、pom.xml文件中配置所需要依赖的jar包，修改为当前项目名<artifactId>JD03_estore2</artifactId>
	          <build>
		<!-- mvn mybatis-generator:generate -->
		<finalName>JD03_estore2</finalName>//修改finalName
	          </build>
	     5、将这个命令mybatis-generator:generate复制，项目右键Run As-->Maven Build...-->Goals:填写mybatis-generator:generate，
	          不用apply,直接run,根据generator.xml文件配置的路径生成对应的bean和mapper
		注意：如果数据库发生修改，需要重新执行mybatis-generator:generate，需要把之前的生成的实体类、映射接口映射文件删除，
		          因为会追加不会覆盖。只针对单表的crud。
	     6、(项目一直报红色错误提示Snapshots)项目右键-->Maven-->Update project-->选择Force Update of Snapshots/Releases--点击ok
	     7、至此，项目环境搭建完成。
		之后就是在src/main/java下面新建web包，service包，可能需要util包等，根据项目实际需要创建。另外jsp/html/css/js等都在
		src/main/webapp下。
		完善三层架构的包，在src/main/java下面新建包com.briup.web,com.briup.service,再在包下面新建包servlet、filter、listener。

4、编写功能模块
	首先功能模块的实现主要采用三层架构：
	web层：处理request请求，返回response响应，从前台页面中拿到参数parameter，调用service层处理逻辑，再将结果渲染到前台展示页面中
	service层：主要是处理逻辑，调用dao层操作数据库的方法。
	dao层：通过映射接口映射文件以及service层获取到的参数去实际的操作改变数据库数据。
	1）页面展示：
	     从数据库中拿到数据，通过页面jstl标签库获取值动态展示出来，比如书籍，目录等。
	     从页面拿到参数给servlet，再去调用dao层然后根据条件去操作数据库，将结果返回至web层，通过session或其他范围存放内容，写回给页面
	2）注册功能：
	     注册页面提交表单，表单地址为处理该逻辑的servlet的url地址，web层获取到参数，封装为一个对象调用service层去执行逻辑操作，
	     service层拿到数据调用dao层，根据映射接口和映射文件将对应的数据插入到数据库用户表中
	     注意：1、为什么要封装为一个对象去插入数据库？
	                因为插入的数据不确定，只写部分属性，像address这个属性这里就不需要写，写多个构造器又太麻烦，
		而且自动生成的bean对象中只有默认的无参构造器，set/get/tostring方法，所以对象中的参数只能通过set方法去赋值，
		另外映射文件中插入sql语句对于每个属性所对应的字段都是使用if判断是否为空，不为空则拼接该参数到sql语句中
		主要是如果将全部参数写出来一直传给下一个方法，写的太累。上面的可以理解为封装成一个对象去插入数据库的过程。
	               2、如何实现用户名不能重复？
		service层做逻辑处理，所以service层在拿到要插入到数据库中的对象之后先判断该对象的用户名是否和数据库中的有一样的，
		如果有则抛出异常提示用户名已存在，没有则执行插入语句。查询返回的list集合要判断list!=null||list.size()>0
	3）登录功能：
	     同样是操作用户表，通过拿到的参数用户名和密码去service层做逻辑判断，看是否有返回的用户对象，
	     如果没有返回值为空，web层通过session对象设置msg提醒没有该用户，
	     如果有，则返回一个对象，web层将对象存放到session范围中。
	     主页面通过jstl标签库语句判断${empty sessionScope.customer}来显示退出或重新登录，并通过超链接实现对应按钮的功能。
	4）购物车功能：
	     1、购物车在数据库中并不是一个实体，因为只是一个临时的功能，当用户退出浏览器之后购物车的内容就不在了，
	          因此也不需要存储到数据库中。
	     2、购物车不需要其他属性，只需要保存订单项，所以只需Map<Integer,OrderLine> map=null;声明一个map集合即可。
	     3、用户登录成功后才能使用购物车功能。所以在bean包下新建一个ShopCar类不需要映射接口和文件，登录成功后设置	          	          	          		session.setAttribute("cart", shopCar);
	     4、添加购物车，只需要将订单项添加到购物车，需要书的id和数量，然后计算cost，
	          注意订单项中需要设置根据书的id查询出来的书的信息，购物车中需要显示书的详情。
	     5、shopcar.jsp页面显示购物车中的订单项具体信息${sessionScope.cart.lines}
	5）提交订单功能：
	     是将购物车中的内容存储到数据库中保存，具体过程是获取参数地址id，通过session获取顾客信息和购物车中的订单项，
	     然后调用service层方法再调用dao层向数据库中的orderform表和orderline表根据具体的字段插入数据，将临时数据保存到数据库中，
	     然后根据顾客id查询orderform表中所有该顾客的订单信息并设值到session范围内渲染到orderlist.jsp页面。
	6）支付功能：
	     根据所选订单项的订单编号id去生成动态的二维码，使用支付宝提供的代码即可。具体在D:\Alipay\备注文档.txt
	     删除：根据orderform_id删除数据库中两个表里的相关字段，然后重新查询该页面并跳转，达到删除就移除的效果。
	     明细：根据orderform_id查询所有该订单项下的商品并显示到list.jsp页面中
5、项目启动测试
	处理问题的思路：
	判断问题出现的初始位置是在哪一层，定位到那一层去查看逻辑代码，看具体异常信息，404，500
	先看该拿到的值是否拿到，用输出语句输出一下。

思考：	
1、购物车的具体实现：主要是对map集合的value值增删改查
2、after目录：保证登录
3、支付页面：参考官方文档
4、订单和订单项：orderform和orderline,orderform的一条记录对应orderline的多条记录。

总结：
1、页面跳转使用重定向跳转，这样能在发生异常时方便在浏览器中查看进行到哪一步出问题。
2、路径一般使用绝对路径，因为如果跳转页面不在同一个文件夹下的话使用相对路径有可能因为这个文件夹导致路径不对。
3、如果需要session会话对象或application上下文对象尽量写在最前面或try语句块外面，保证将来设置到范围对象中的值时有效的。
