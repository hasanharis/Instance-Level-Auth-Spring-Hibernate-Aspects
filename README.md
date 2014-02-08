Demonstrates a technique to do instance level authorization in a Spring-Hibernate app using AOP

--------------------

Domain instance level authorization can be a huge pain in large web apps. One straight forward solution is to embedd authorization code into business logic but its not very neat. Another option is to use built-in frameworks like Apache-Shiro or Spring ACLs but both introduce quite a bit of complexity in your exisiting codebase.

This project proposes another technique to solve the problem. It uses Aspect Oriented Programming to separate authorization logic from rest of your business logic. In this way your existing code base remains clean and you implement authorization as a separate concern. This approach uses AOP, some interfaces and base classes to introduce authroization without making any change to underlying databases as you need to in case of Spring ACL.
