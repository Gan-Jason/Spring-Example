package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Consumer {


    public static void main(String[] args) {
        final Producer producer=new Producer();


        /**
         * ��̬����
         *
         */
        IProducer proxyProducer= (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //�ṩ��ǿ����
                        Object returnValue=null;
                        //1.��ȡ����ִ�еĲ���
                        Float money=(Float)args[0];
                        //2.�жϵ�ǰ�����ǲ�������
                        if("saleProduct".equals(method.getName())){
                            returnValue=method.invoke(producer,money*0.8f);
                        }

                        return returnValue;
                    }
                });
        proxyProducer.saleProduct(10000f);
    }
}
