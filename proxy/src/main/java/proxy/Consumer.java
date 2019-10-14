package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Consumer {


    public static void main(String[] args) {
        final Producer producer=new Producer();


        /**
         * 动态代理：
         *
         */
        IProducer proxyProducer= (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

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
        proxyProducer.saleProduct(10000f);
    }
}
