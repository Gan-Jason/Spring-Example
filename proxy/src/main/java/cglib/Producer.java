package cglib;


import proxy.IProducer;

/**
 * @ClassName һ��������
 * @Author Jason
 * @Description //TODO proxy
 * @Date 15:15 2019/10/1
 * @Version 1.0
 */
public class Producer implements IProducer{
    
    /**
     * @Author Jason
     * @Description //TODO ����
     * @Date 15:18 2019/10/1
     * @Param [money]
     * @return void
     */
    public void saleProduct(float money){
        System.out.println("���۲�Ʒ�����õ�Ǯ��"+money);
    }

    /**
     * @Author Jason
     * @Description //TODO �ۺ����
     * @Date 15:18 2019/10/1
     * @Param [money]
     * @return void
     */
    public void afterService(float money){
        System.out.println("�ṩ�ۺ���񣬲��õ�Ǯ��"+money);
        
    }
}
