package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory  {
	private Object target;
	 
    public ProxyFactory(Object target) {
        this.target = target;
    }
 
    // 返回对目标对象(target)代理后的对象(proxy)
    public Object getProxyInstance() {
        Object proxy = Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new InvocationHandler() {            // 执行代理对象方法时候触发
                @Override
                public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
 
                    // 获取当前执行的方法的方法名
                    String methodName = method.getName();
                    // 方法返回值
                    Object result = null;
                    if ("find".equals(methodName)) {
                        // 直接调用目标对象方法
                        result = method.invoke(target, args);
                    } else {
                        System.out.println("开启事务...");
                        // 执行目标对象方法
                        result = method.invoke(target, args);
                        System.out.println("提交事务...");
                    }
                    return result;
                }
            }
        );
        return proxy;
    }

}
