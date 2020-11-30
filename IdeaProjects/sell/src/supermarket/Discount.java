package supermarket;

public class Discount {                     //折扣类
    public int discount(char choose,int needMoney){     //如果有新优惠可以直接加一个新的if表示新的优惠方式而不需要再写一个函数
        int result = needMoney;
        if(choose == 'M') {                            //满减优惠
            if (needMoney >= 100)
                result = needMoney - 20;
        }
        else if(choose == 'Z'){                         //超出100部分打折优惠
            if(needMoney>100)
                result = (int)((needMoney-100)*0.6)+100;
        }
        return result;
    }
}
