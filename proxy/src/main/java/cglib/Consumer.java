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
         * ��̬����
         * proxy
         * method
         * args
         * �������������ͻ��ڽӿڵĶ�̬�����е�invoke�����Ĳ�����һ����
         * methodProxy����ǰִ�з����Ĵ������
         *
         */
        Producer cglib=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
        cglib.saleProduct(110000f);
    }
}
