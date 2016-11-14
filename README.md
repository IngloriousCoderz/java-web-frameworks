# FormaReTe

An Eclipse/NetBeans workspace used as teaching material for a course I'm teaching about Servlets, JSPs, Struts2, Hibernate and Spring with Maven.

As reference documentation I mainly used and adapted tutorials I found online, which are listed at the end of this document. The projects described below are entirely made by me.

## dynamic

Default Eclipse project made through the "Create dynamic web project" wizard. Note how web content goes in a custom directory called WebContent.

## quickstart

Our first Maven project, made with the Quickstart Archetype and then modified to our needs. We still use JUnit 3.x, but we'll change it in later projects.

## servlet

Two different ways to implement authentication logic: through a login servlet and with an authentication filter. We also add a cookie manager filter because we assume that this project will be run in an environment that cannot keep sessions between server instances.

## mvc

A small digression on how the Publisher/Subscriber pattern works, and how it integrates in an MVC project. In the tests we can see the difference between updating the View directly from the Controller and doing it indirectly by subscribing to changes in the Model.

## struts

Our first Struts2 webapp. It basically just implements what we have done in the servlet project, but using Struts Actions. Filtering is implemented here by using the Preparable interface: although it doesn't allow much flexibility, it keeps the authentication logic testable.

## sessionaware

Two different ways to access servlet-specific content: through the ServletActionContext class or using the SessionAware interface. The latter keeps the Action a POJO. We also show Struts' i18n.

## todos

A recap on Struts actions by implementing a simple TodoMVC webapp.

## auth-todos

Putting it all together we create a TodoMVC app with authentication support. This time however we try to introduce Interceptors as a mean to prevent unauthorized access. This creates a lot of problems and makes authentication untestable, but improves cohesion and modularity.

## spruts

Spring + Struts. We inject Actions in the struts.xml as Spring beans and prove how flexible it is to inject a property without specifying how it is constructed or which implementation is chosen.

## springmvc

An exercise on SpringMVC, both as an MVC architecture for JSP-based websites and RESTful web services.

## hiberstruts

Next we introduce Hibernate and integrate it with Struts2. We show two different ways of marking objects as persistent entities (through XML or annotations) and provide a ServletContextListener as a best practice to initialize Hibernate at startup.

## join

A small digression on relationships between entities and cascade strategies when removing an object that has references. It is also an exercise on how to use Hibernate with Spring without the need of a webapp context.

## hiberspruts

This project puts all the bits together: A full-stack webapp with Struts and Hibernate, all managed by Spring, all built with Maven.

## mytodos

As a final exam for the course I asked to create a multi-user TodosMVC application with authentication support and real persistence.

## feisbuc

Another use case, to make things more complex: we modeled a rough Facebook-like webapp with very few features available, but it challenged us to perform a join from a Java class to itself in the user -> friends relationship.

# Reference

* https://it.wikipedia.org/wiki/Hypertext_Transfer_Protocol
* https://it.wikipedia.org/wiki/Suite_di_protocolli_Internet
* http://www.tutorialspoint.com/struts_2/
* http://www.javatpoint.com/struts-2-aware-interfaces-tutorial
* http://stackoverflow.com/questions/8406840/is-it-a-good-idea-to-put-jsp-pages-inside-the-web-inf-folder-in-an-apache-struts
* http://www.journaldev.com/2210/struts-2-interceptor-tutorial-with-custom-authentication-interceptor-example
* http://stackoverflow.com/questions/3350554/using-cookies-with-struts-2-and-struts
* http://omkarp.blogspot.it/2007/08/working-with-cookies-in-struts-2-part-2.html
* http://struts.apache.org/docs/convention-plugin.html
* http://www.tutorialspoint.com/hibernate/hibernate_or_mappings.htm
* http://www.mkyong.com/tutorials/hibernate-tutorials/
* http://what-when-how.com/hibernate/legacy-databases-and-custom-sql-hibernate/
* http://www.onjava.com/pub/a/onjava/2004/03/31/clustering.html
* https://developer.jboss.org/wiki/UsingHibernateWithTomcat
* http://www.mkyong.com/spring/maven-spring-hibernate-mysql-example/
* http://www.mkyong.com/struts2/struts-2-spring-integration-example/
* https://docs.jboss.org/hibernate/orm/3.6/reference/en-US/html/collections.html
* https://cwiki.apache.org/confluence/display/WW/Multiple+Submit+Buttons
* http://www.mkyong.com/hibernate/cascade-jpa-hibernate-annotation-common-mistake/
