package com.lrf.adapter;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 11:27
 * 功能介绍:  原理：通过抽象类来实现适配，这种适配稍别于上面所述的适配。
 * <p>
 * 　　当存在这样一个接口，其中定义了N多的方法，而我们现在却只想使用其中的一个到几个方法，如果我们直接实现接口，
 * 那么我们要对所有的方法进行实现，哪怕我们仅仅是对不需要的方法进行置空（只写一对大括号，不做具体方法实现）也会导致这个类变得臃肿，
 * 调用也不方便，这时我们可以使用一个抽象类作为中间件，即适配器，用这个抽象类实现接口，而在抽象类中所有的方法都进行置空，那么我们在创建抽象类的继承类，
 * 而且重写我们需要使用的那几个方法即可。
 */
public interface UsbN {
    public void a();

    public void b();

    public void c();

    public void d();

    public void e();

    public void f();

    public void g();

}
