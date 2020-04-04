# SeaHouse

#### 项目介绍
SeaHouse是一个基于蚂蚁信用的租房项目。
#### 功能模块
主要功能模块包括：  
* 注册、登录模块  
    登录主要分为三种： 密码登录、手机快捷登录、第三方登录
    注册主要分为两种： 用户手机号注册和第三方登录注册
    
* 个人中心：  
    主要包括上传图像、修改个人资料、绑定邮箱、绑定第三方账号、解除第三方账号、修改密码、实名认证、
    
    芝麻信用认证、会员认证、收藏、足迹、我的预约
    
* 租房模块：

    主要包括发布出租房屋信息、推荐房屋信息、查询房屋信息详情、预约看房、线上签订合同

* 首页模块：

    主要包括城市选择、消息

* 找房模块：

    主要包括地图找房、搜索功能

* 房东模块：

    主要包括添加房屋



#### 软件架构
核心框架：Spring Boot 2.0.3.RELEASE

安全框架：Spring Security 5.0.6.RELEASE

视图框架：Spring MVC 5.0.7.RELEASE

持久层框架：Mybatis Spring Boot 1.3.1 + Mapper Spring Boot 2.0.4

Token模式：JsonWebToken 0.7.0

开发工具：Intellij IDEA 

缓存框架：Spring Data Redis 2.0.8.RELEASE

### 开发环境
Intellij IDEA 2017.2.5

MySql 5.0+

MAVEN 3.5.0

JDK 1.8

Tomcat 8.0


#### 安装教程

1. git clone本项目

2. 使用Idea打开项目

3. 打开SeaHouseApplication.java运行项目

