package test.dome.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: ghj
 * @Date: 2020/4/13 22:52
 * @Version 1.0
 */
public class ProxyCGDome {
    public static void main(String[] args) {
        StudentCg studentCg = new StudentCg();
        ProxyFactory proxyFactory = new ProxyFactory(studentCg);
        StudentCg proxyInstance = (StudentCg) proxyFactory.getProxyInstance();
        proxyInstance.say("你好", 100);
        proxyInstance.play("篮球");
    }

    static class ProxyFactory implements MethodInterceptor {
        private Object target;

        public ProxyFactory(Object target) {
            this.target = target;
        }

        public Object getProxyInstance() {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(target.getClass());
            enhancer.setCallback(this);
            return enhancer.create();
        }


        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            if (method.getName().equals("say")) {
                System.out.println("proxy start...");
                System.out.println("proxy->更改参数");
                for (Object object : objects) {
                    System.out.println("原参数：" + object);
                }
                objects[0] = "cglib";
                objects[1] = 666;
                return method.invoke(target, objects);
            }
            if (method.getName().equals("play")) {
                return method.invoke(target, "双节棍");
            }
            return null;
        }
    }
}
