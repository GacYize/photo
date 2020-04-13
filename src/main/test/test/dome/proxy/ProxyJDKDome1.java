package test.dome.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ghj
 * @Description
 * @date 2020/4/13 16:35
 */
public class ProxyJDKDome1 {
    public static void main(String[] args) {
        IPeople student = new Student();
        ProxyFactory proxyFactory = new ProxyFactory(student);
        IPeople people = (IPeople) proxyFactory.getProxyInstance();
        people.work();
        people.say("aaa");
    }


    static class ProxyFactory {
        private Object target;

        public ProxyFactory(Object target) {
            this.target = target;
        }

        public Object getProxyInstance() {
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    if(method.getName().equals("work")){
                        System.out.println("proxy start...");
                        Object obj = method.invoke(target, objects);
                        System.out.println("proxy end!");
                        return obj;
                    }
                    if(method.getName().equals("say")){
                        return method.invoke(target, "123456");
                    }
                    return method.invoke(target, objects);
                }
            });
        }
    }

}
