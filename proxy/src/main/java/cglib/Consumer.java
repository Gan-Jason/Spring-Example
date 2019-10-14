package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.IProducer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Consumer {


    public static void main(String[] args) {
        final Producer producer=new Producer();


        /**
         * 动态代理：
         * proxy
         * method
         * args
         * 以上三个参数和基于接口的动态代理中的invoke方法的参数是一样的
         * methodProxy：当前执行方法的代理对象
         *
         */
        Producer cglib=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                        //提供增强代码
                        Object returnValue=null;
                        //1.获取方法执行的参数
                        Float money=(Float)args[0];
                        //2.判断当前方法是不是销售
                        if("saleProduct".equals(method.getName())){
                            returnValue=method.invoke(producer,money*0.8f);
                        }

                        return returnValue;
            }
        });
        cglib.saleProduct(110000f);
    }
}
