1.如果想使用@Resource 、@PostConstruct、@PreDestroy等注解就必须声明CommonAnnotationBeanPostProcessor。

2.如果想使用@PersistenceContext注解，就必须声明PersistenceAnnotationBeanPostProcessor的Bean。

3.如果想使用@Autowired注解，那么就必须事先在 Spring 容器中声明 AutowiredAnnotationBeanPostProcessor Bean。

4.如果想使用@Required的注解，就必须声明RequiredAnnotationBeanPostProcessor的Bean。

而使用<context:annotation-config/> 就可以隐式地自动向Spring容器注册4个BeanPostProcessor：
```
# 开启注解支持（要使用注解，必须开启）
<context:annotation-config/>
```
```
# 指定要扫描的包，包里的类就会生效
<context:component-scan base-package="com.**.impl"/> 
```

Spring给我们提供了context:annotation-config 的简化的配置方式，自动帮助你完成声明，并且还自动搜索@Component , @Controller , @Service , @Repository等标注的类。

注：
xsi:schemaLocation，它定义了XML Namespace和对应的XSD（Xml Schema Definition）文档的位置的关系。它的值由一个或多个URI引用对组成，两个URI之间以空白符分隔（空格和换行均可）。第一个URI是定义的XML Namespace的值，第二个URI给出Schema文档的位置，Schema处理器将从这个位置读取Schema文档，该文档的targetNamespace必须与第一个URI相匹配。

注意：
* byName的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致！
* byType的时候，需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致！

@Resource和@Autowired的区别：
* 都是自动装配的，都可以放在属性字段上
* @Autowired通过byType方式实现，而且必须要求这个对象存在！
* @Resource通过默认byName方式实现，如果找不到名字，则通过byType实现，如果两个都找不到，则报错！

Spring中到底有几种依赖注入方式？
##### 一、手动注入

* set方法
* 构造方法
##### 二、自动注入
* xml自动注入（set方法、构造方法）
* @Autowired注解的自动注入（属性、构造方法、普通方法）

### 注解说明 
* @Autowired：自动装配通过类型（名字），如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")。
* @Nullable：字段标注了这个注解，说明这个字段可以为null；
* @Resource：自动装配通过名字（类型）；
* @Component：组件，放在类上，说明这个类被Spring管理了，就是bean ! 
 
@Component有几个衍生注解，我们在web开发中，会按照mvc三层架构分层！
* dao：[@Repository]
* service：[@Service]
* controller：[@Controller]

这四个注解功能都是一样的，都是代表将某个类注册到Spring中，装配Bean！




