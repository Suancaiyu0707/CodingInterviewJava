### 工厂方法模式
和普通工厂模式不一样，它是通过不同的工厂，由不同工厂创建自己的对象。但是逻辑会丢给客户端来判断(这里是Main类)
普通工厂模式是由一种工厂生厂不同的对象,它的逻辑是在工厂类里，这等于修改一个实现，要修改Factory，违背了开放-封闭原则