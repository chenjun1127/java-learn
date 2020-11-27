1.如果想使用@ Resource 、@ PostConstruct、@ PreDestroy等注解就必须声明CommonAnnotationBeanPostProcessor。

2.如果想使用@PersistenceContext注解，就必须声明PersistenceAnnotationBeanPostProcessor的Bean。

3.如果想使用@Autowired注解，那么就必须事先在 Spring 容器中声明 AutowiredAnnotationBeanPostProcessor Bean。

4.如果想使用 @Required的注解，就必须声明RequiredAnnotationBeanPostProcessor的Bean。

而使用context:annotation-config/ 就可以隐式地自动向Spring容器注册4个BeanPostProcessor：
```
<context:component-scan base-package="com.**.impl"/>
```

Spring给我们提供了context:annotation-config 的简化的配置方式，自动帮助你完成声明，并且还自动搜索@Component , @Controller , @Service , @Repository等标注的类。

注：
xsi:schemaLocation，它定义了XML Namespace和对应的XSD（Xml Schema Definition）文档的位置的关系。它的值由一个或多个URI引用对组成，两个URI之间以空白符分隔（空格和换行均可）。第一个URI是定义的XML Namespace的值，第二个URI给出Schema文档的位置，Schema处理器将从这个位置读取Schema文档，该文档的targetNamespace必须与第一个URI相匹配。

Spring中到底有几种依赖注入方式？
##### 一、手动注入

* set方法
* 构造方法
##### 二、自动注入
* xml自动注入（set方法、构造方法）
* @Autowired注解的自动注入（属性、构造方法、普通方法）
