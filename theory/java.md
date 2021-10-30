## Singleton (싱글톤) class란?

In OOP, Singleton class is a class that can have only one object at a time. 
Singleton pattern is useful in saving memory because object is not created at each request. Only single instance is reused again. And it is mostly used in multi-threads


## What is Java’s benefit

Java is simple programming language since it is easy to learn and understand. Its syntax is based on C++ and uses automatic garbage collection. Therefore, we don’t need to remove the unreferenced object from the memory. 
Java is also well known as an object-oriented paradigm. It uses object-oriented concepts like class, object, inheritance, encapsulation, polymorphism and abstraction.

= Simple, OO, Secured, Robust, Platform independent
= Disadvantage : slow, programmers can’t handle garbage collector, require more memory space

## What is JVM

It is Java Virtual Machine which provides the runtime environment which Java byte code can be executed. Byte code is the instruction set of the JVM, when JIT compiler compiles, it generate an object code that is understandable for JVM

## How Java enabled High performance

Java use JIT compiler to enable high performance. JIT compile same functionality byte code in same time. The Java program takes lead time to compile than other programming language’s complier 

## 자바의 Garbage Collector에 대해 설명해 줄 수 있나요

Garbage collection collects memory occupied the objects hose are no longer in use of program, so that memory can be reclaimed or reused

## Class와 Object 차이점

Class is the blueprint from which we can create the instance, such as object
Object is the instance of the class, which helps programmers to use variables and methods from inside the class

Class is the building block that leads to OOP. It is user-defined data type, that holds its own data members and member functions, which can be accessed and used by creating an instance of that class. So basically class is used as a template for declaring and creating the objects

Object is an instance of a class. All data members and member functions of the class can be accessed with the help of objects. Unlike class, object is allocated with memory space whenever they are created. Objects can be created as many times as needed

## Inheritance

Inheritance is an important pillar of OOP(Object Oriented Programming). It is the mechanism in java by which one class is allow to inherit the features(fields and methods) of another class. 

## Override와 Overload의 차이점

Overriding = 상위 class의 method를 하위 class에서 재정의하는 것; 리턴 타입이 같아야 한다 (ft. 상속에서 나온 개념)
Overloading = 같은 이름의 Method를 여러 개 정의하는 것; parameter의 타입이 다르거나 개수가 달라야 한다

## What is Abstraction

Abstraction is key feature of Object-orientated programming, which allows user to hide implementation complexities by providing functionality via simpler interface. In Java 8, abstraction is achieved by interface and abstract class

## Interface and Abstract Class

Abstract class = allows users to create functionalities that users can implement and override through subclasses.  Abstract class can be both abstract and concrete, so it provides us flexibilities. It can have constructor, and this is the one major difference between an abstract class and interface.

Interface = only allow us to define functionality, not implement it. But while class can extend only one abstract class, it can take advantage of multiple interfaces. It can only have empty static methods


## What is Serialization?

It is the mechanism that can save the state of an object by converting it to a byte stream. 

## Wrapper Class

Int - Integer | char - Character

Wrapper class provides a mechanism to convert primitive type to object and object to primitive type. The wrapper class is included in java.lang package and also provide auto boxing and unboxing feature; where auto-boxing allows automatic conversion from primitive type to the object of its corresponding wrapper class

## Define Collection?

Collection is a group of elements like integer values or objects like arrays and java.util classes (Stack, Queue, Linked List)

## Differentiate return and system.exit(0)?

Return is a jumping statement which is used to transfer control from called method to calling method, whereas System.exit(0) is a method, which is used to come out of the program

## Java8에서의 변경 사항

Lambda Expression = 함수형 프로그래밍
Also known as anonymous function
Efficiently reduce unnecessary codes and increase the readability of written codes
Lambda expression allowed java users to do functional programming in java

Stream API = 데이터의 추상화

java.time 패키지 = Joda-Time을 이용한 새로운 날짜와 시간 API
Previously used Calendar class had some problems like; it doesn’t consider leap second, and calendar instance value could be modified because it is not immutable object.

Nashorn = 자바스크립트 새로운 엔진
Mozilla’s ‘Rhino’ was used as default Javascript engine. 
Nashorn is created by Oracle, with great improvement on performance and memory management
