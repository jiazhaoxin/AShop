**问题：intellij idea刚装的时候，创建maven项目没有resource文件夹**

    解决：
        1. 点击File-->project structure
        2. Modules-->Sources-->main右键-->New Folder, 输入resources
        3. 选择resources右键，点击Resources（选择文件资源类型），然后Apply，OK即可（添加test也一样）
        
**1. 初始化web空白项目**

        1. main文件夹下webapp同级新建java文件夹，java文件夹右键点击mark directory as-->source root
        建立测试文件夹由于单元测试
        1. src文件夹下main同级新建test文件夹
        2. test文件夹下新建java文件夹，java文件夹右键点击mark directory as-->test source root
        
**2. 项目结构包初始化**

        java文件夹下生成com.shop文件夹在此文件夹下生成
        1.dao文件夹
        2.service文件夹
        3.controller文件夹
        4.vo文件夹
        5.pojo文件夹
        6.util文件夹
        7.common文件夹
        
**使用tomcat运行项目**

    1. 点击菜单run-->edit configurations
    2. 点击左上角加号tomcat server-->local
    3. 点击deployment-->加号-->artifact-->war
    
**mybatis-generator配置和生成**

    1.导入generator
    <plugin>
       <groupId>org.mybatis.generator</groupId>
       <artifactId>mybatis-generator-maven-plugin</artifactId>
       <version>1.3.2</version>
       <configuration>
         <verbose>true</verbose>
         <overwrite>true</overwrite>
       </configuration>
    </plugin>
    2.复制generator配置文件generatorConfig.xml到resources资源文件夹下
    3.复制属性配置文件datasource.properties到resources资源文件夹下
    ps:generatorConfig.xml文件中定义datasource.properties文件路径
    4.点击idea右侧mawenprojects->plugins双击mybatis-generator->mybatis-generator:generate生成文件
    ps:如果plugins下没有mybatis-generator对照pom.xml文件
    5.在生成的xml文件中修改生成时间和修改时间时间字段
    
**安装mybatis-plugin插件**
    
    1.点击file->settings->plugins搜索mybatis-plugins安装
    
**mybatis-pagehelper分页插件**

    1.导入依赖
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper</artifactId>
      <version>4.1.0</version>
    </dependency>
    <dependency>
      <groupId>com.github.miemiedev</groupId>
      <artifactId>mybatis-paginator</artifactId>
      <version>1.2.17</version>
    </dependency>
    <dependency>
      <groupId>com.github.jsqlparser</groupId>
      <artifactId>jsqlparser</artifactId>
      <version>0.9.4</version>
    </dependency>
    ps:可在github上查看使用详情
        
**springmvc配置**

    复制一下文件到指定文件夹下
    resources文件夹下
    1.applicationContext.xml(在web.xml中指定此配置文件)
    2.applicationContext-datasource.xml（在applicationContext.xml中指定此文件）
    3.mmall.properties
    webapp->WEB-INF文件夹下
    4.dispatcher-servlet.xml(web.xml中指定此文件，如果没指定则使用默认此路径下的此文件名，此示例没指定)
    5.web.xml
    
    
**资源提供**

    1. search.maven.org提供的中央仓库地址