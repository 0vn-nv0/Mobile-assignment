package supermarket;

import supermarket.Commodity;

import java.util.ArrayList;

public class ShoppingCart {             //购物车类
    private ArrayList<Commodity> car = new ArrayList<Commodity>();      //购物车容器
    public void add(Commodity co){                  //增加商品至购物车函数
        car.add(co);
        System.out.println(co.getName()+"已加入购物车！");
    }
    public void delete(Commodity co){               //删除部分购物车商品函数
        car.remove(co);
        System.out.println(co.getName()+"已从购物车中删除！");
    }
    public int emptyCarNeedMoney(){                 //计算清空购物车需要的原始价格（打折前）
        int amount=0;
        for(Commodity co: car)
            amount+=co.getValue();
        return amount;
    }
    public void emptyCar(){                        //清空购物车内商品这里用for each循环会抛异常
        for(int i = car.size()-1;i >= 0;i--) {     //用这种方式可以删除容器内元素
            Commodity s = car.get(i);
            car.remove(s);
        }
        System.out.println("您已清空购物车！");
    }
    public void list(){                     //陈列购物车商品
        for(Commodity co : car)
            co.show();
    }
}
