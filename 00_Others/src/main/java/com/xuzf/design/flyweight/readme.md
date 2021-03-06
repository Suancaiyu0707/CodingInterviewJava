### 享元模式
定义：
    运用共享技术有效地支持大量细粒度的对象。
    
角色：
    （1）享元工厂（WebsiteFactory）：用于创建具体享元类，维护相同的享元对象。当请求对象已经存在时，直接返回对象，不存在时，在创建对象。
    （2）抽象享元（Website）：定义需要共享的对象业务接口。享元类被创建出来总是为了实现某些特定的业务逻辑.
    （3）具体享元（ConcreteWebsite）：实现抽象享元类的接口，完成某一具体逻辑。
    
优点：
    （1）节省内存空间，对于可重复的对象只会被创建一次，对象比较多时，就会极大的节省空间。
    （2）提高效率，由于创建对象的数量减少，所以对系统内存的需求也减小，使得速度更快，效率更高。
    
缺点：
    （1）其实对于享元类有内部状态和外部状态，其区分就是图书馆的书一部分可以外借（外部状态），一部分不可外借（内部状态），两个状态的划分对于书籍管理来说优点复杂化了。
    
享元模式与单例模式的区别：
（1）享元设计模式是一个类有很多对象，而单例是一个类仅一个对象。
（2）享元模式是为了节约内存空间，提升程序性能，而单例模式则主要是出于共享状态的目的。