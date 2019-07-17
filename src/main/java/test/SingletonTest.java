package test;

/**
 *
 * 双重检查实现单例模式
 * @author qiaoxin
 * @Date 2019/7/17
 */
public class SingletonTest {
    private volatile static SingletonTest instance = null;

    private SingletonTest() {}

    public static SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }
}
