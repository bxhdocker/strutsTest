# strutsTest
基于Struts框架实现员工管理系统

1.导入struts包
[java] view plain copy
c3p0-0.9.1.2.jar  
commons-beanutils-1.8.3.jar  
commons-dbutils-1.6.jar  
commons-fileupload-1.2.2.jar  
commons-io-2.0.1.jar  
commons-lang3-3.1.jar  
freemarker-2.3.19.jar  
javassist-3.11.0.GA.jar  
mysql-connector-java-5.1.12-bin.jar  
ognl-3.0.5.jar  
struts2-core-2.3.4.1.jar  
xwork-core-2.3.4.1.jar  
2.web.xml配置
[html] view plain copy
<?xml version="1.0" encoding="UTF-8"?>  
<web-app version="2.5"   
    xmlns="http://java.sun.com/xml/ns/javaee"   
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"   
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee   
    http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">  
    
  <filter>  
    <filter-name>struts2</filter-name>  
    <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>  
  </filter>  
  <filter-mapping>  
    <filter-name>struts2</filter-name>  
    <url-pattern>/*</url-pattern>  
  </filter-mapping>  
  
</web-app>  

3.stuts.xml配置
[java] view plain copy
<?xml version="1.0" encoding="UTF-8" ?>  
  
<!DOCTYPE struts PUBLIC  
    "-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"  
    "http://struts.apache.org/dtds/struts-2.3.dtd">  
  
<!-- START SNIPPET: xworkSample -->  
<struts>  
  
    <!-- 更改主题 -->  
    <constant name="struts.ui.theme" value="simple"></constant>  
    <package name="emp" extends="struts-default">  
        <global-results>  
            <result name="error">/error/error.jsp</result>  
        </global-results>  
          
        <action name="emp_*" class="com.bxh.action.EmployeeAction" method="{1}">  
            <!--一、 防表单重复提交，二、配置防表单重复提交拦截器 -->  
            <interceptor-ref name="defaultStack"></interceptor-ref>  
            <interceptor-ref name="token">  
                <!-- 三、指定拦截器那些方法需要 -->  
                <param name="includeMethods">save</param>  
            </interceptor-ref>  
              
            <result name="invalid.token" type="redirectAction">emp_list</result>  
              
            <result name="list">/WEB-INF/list.jsp</result>  
            <result name="update">/WEB-INF/update.jsp</result>  
            <result name="addsuccess" type="redirectAction">emp_list</result>  
        </action>  
      
    </package>  
  
</struts>  
  
<!-- END SNIPPET: xworkSample -->  

3./src/c3p0-config.xml
[html] view plain copy
<c3p0-config>  
  <default-config>  
     <property name="driverClass">com.mysql.jdbc.Driver</property>   
     <property name="jdbcUrl">jdbc:mysql:///hib_demo</property>   
     <property name="user">root</property>   
     <property name="password">123456</property>   
     <property name="initialPoolSize">5</property>   
     <property name="maxPoolSize">10</property>   
  
  </default-config>  
  
  
  <named-config name="oracleConfig">  
    <property name="driverClass">com.mysql.jdbc.Driver</property>   
     <property name="jdbcUrl">jdbc:mysql:///hib_demo</property>   
     <property name="user">root</property>   
     <property name="password">root</property>   
     <property name="initialPoolSize">5</property>   
     <property name="maxPoolSize">10</property>   
   </named-config>  
  
</c3p0-config>  

5.原码目录结构：
