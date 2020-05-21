**一些重要的文档**

    1.沙箱登录：https://openhome.alipay.com/platform/appDaily.htm
    2.沙箱环境使用说明：https://opendocs.alipay.com/open/200/105311/

**支付宝开发**
    
    1.复制支付宝demo里的支付宝sdk jar包到项目里（maven项目到webapp/WEB-INF/lib下）
        配置本地jar
            1.点击project structure->modules->AShop->dependencies->+->jars or directories选择到jar包点击ok
            2.pom.xml增加以下内容
            <build>
                <finalName>AShop</finalName>
                <plugins>
                    <!-- geelynote maven的核心插件之-complier插件默认只支持编译Java 1.4，因此需要加上支持高版本jre的配置，在pom.xml里面加上 增加编译插件 -->
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <configuration>
                            <source>1.8</source>
                            <target>1.8</target>
                            <encoding>UTF-8</encoding>
                            <compilerArguments>
                                <extdirs>${project.basedir}/src/main/webapp/WEB-INF/lib</extdirs>
                            </compilerArguments>
                      </configuration>
                    </plugin>
                </plugins>
            </build>
            3.需要的jar包
                1.alipay-sdk-java-3.3.0.jar
                2.alipay-trade-sdk-20161215.jar
            4.复制支付宝demo里的DemoHbRunner.java和Main.java里的方法测试是否可支付（java包放的路径需与demo里一样如：co/alipay/demo/trade）
            5.测试成功后集成到项目里
    2.导入支付宝sdk依赖的jar包（maven项可以使用pom.xml导入，注意版本，尽量保持一致）
        1.commons-codec-1.10.jar
        2.commons-configuration-1.10.jar
        3.commons-lang-2.6.jar
        4.commons-logging-1.1.1.jar
        5.core-2.1.jar
        6.gson-2.3.1.jar
        7.hamcrest-core-1.3.jar
    3.复制支付宝demo里的zfbinfo.properties配置文件到资源目录resources(修改里面的配置)