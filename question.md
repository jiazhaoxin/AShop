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
        
**使用tomcat运行项目**

    1. 点击菜单run-->edit configurations
    2. 点击左上角加号tomcat server-->local
    3. 点击deployment-->加号-->artifact-->war
    
**资源提供**

    1. search.maven.org提供的中央仓库地址