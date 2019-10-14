package cglib;


import proxy.IProducer;

/**
 * @ClassName 一个生产者
 * @Author Jason
 * @Description //TODO proxy
 * @Date 15:15 2019/10/1
 * @Version 1.0
 */
public class Producer implements IProducer{
    
    /**
     * @Author Jason
     * @Description //TODO 销售
     * @Date 15:18 2019/10/1
     * @Param [money]
     * @return void
     */
    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱："+money);
    }

    /**
     * @Author Jason
     * @Description //TODO 售后服务
     * @Date 15:18 2019/10/1
     * @Param [money]
     * @return void
     */
    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
        
    }
}
