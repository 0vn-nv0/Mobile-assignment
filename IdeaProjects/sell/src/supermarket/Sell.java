package supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class Sell {
    private ArrayList<Commodity> commoditiesList = new ArrayList<Commodity>();      //创建商品容器
    public void add(Commodity co){
        commoditiesList.add(co);
    }
    public void list(){
        for(Commodity co : commoditiesList) {
            co.show();
        }
    }
    public static Commodity first = new Commodity("1.农夫山泉", 3);
    public static Commodity second = new Commodity("2.草莓牛奶", 5);
    public static Commodity third = new Commodity("3.吹风机", 60);
    public static Commodity forth = new Commodity("4.Java核心技术卷", 69);
    public static Commodity fifth = new Commodity("5.一袋大米",70);
    public static Commodity sixth = new Commodity("6.浑元形意太极内功秘籍",200);
    public static Commodity seventh = new Commodity("7.摇摇杯",30);
    public static Commodity eighth = new Commodity("8.杂音四级听力耳机",20);
    public static Commodity ninth = new Commodity("9.内蒙风干牛肉500g",75);
    public static Commodity tenth = new Commodity("10.小番茄500g",7);
    public static Commodity eleventh = new Commodity("11.512KByte大容量U盘",398);
    public static Commodity twelfth = new Commodity("12.飞科剃须刀",130);
    public static Commodity option (int num){
        Commodity temp = null;
        switch (num) {                                       //↑
            case 1:                                         //这大段代码真的头疼  创建商品对象多起来就感觉代码非常冗长
                temp = first;                               //↓
                break;
            case 2:
                temp = second;
                break;
            case 3:
                temp = third;
                break;
            case 4:
                temp = forth;
                break;
            case 5:
                temp = fifth;
                break;
            case 6:
                temp = sixth;
                break;
            case 7:
                temp = seventh;
                break;
            case 8:
                temp = eighth;
                break;
            case 9:
                temp = ninth;
                break;
            case 10:
                temp = tenth;
                break;
            case 11:
                temp = eleventh;
                break;
            case 12:
                temp = twelfth;
                break;
            default:
                System.out.println("请输入正确编号！");
                break;
        }
        return temp;
    }
    public static void main(String[] args) {
        int amount = 0;
        Scanner in = new Scanner(System.in);
        Sell list = new Sell();
        ShoppingCart car = new ShoppingCart();
        Commodity temp,title;
        temp = new Commodity("",0);
        Discount dis = new Discount();
        list.add(title = new Commodity("商品列表：", 0));
        list.add(first);
        list.add(second);           //将上述初始化商品加入商品列表容器
        list.add(third);
        list.add(forth);
        list.add(fifth);
        list.add(sixth);
        list.add(seventh);
        list.add(eighth);
        list.add(ninth);
        list.add(tenth);
        list.add(eleventh);
        list.add(twelfth);
        while (true) {
            System.out.println("查看商品列表（输入1）或购物车（输入2），退出请输入-1：");
            int choose1 = in.nextInt();
            if (choose1 == 1) {
                list.list();                //陈列商品
                System.out.println("选择商品编号加入购物车:");
                int num = in.nextInt();
                if(num>=1&&num<=12)
                car.add(option(num));       //加入购物车操作
            } else if (choose1 == 2) {
                car.list();
                System.out.println("选择是否购买清空购物车商品（Y表示是，N表示否）：");
                String str1= in.next();             //Java没有读单个字符的函数只能用取字符串第一位这种方法...
                char choose2 = str1.charAt(0);
                if (choose2 == 'Y'){
                    if(car.emptyCarNeedMoney()>100)
                    {
                        System.out.println("您已达满100优惠条件请选择满100减20或满100超100部分打6折（输入M选满减输入Z选打折）");
                    }
                    String discountChoose = in.next();
                    char disChoose = discountChoose.charAt(0);
                    int needMoney=0;
                    needMoney = dis.discount(disChoose,car.emptyCarNeedMoney());
                    System.out.println("共需"+needMoney+"元，"+"请为商品输入支付金额：");
                    int pay = in.nextInt();
                    amount += pay;
                    if(amount<needMoney)
                    {
                        System.out.println("余额不足无法购买！");
                        System.out.println("您当前余额为："+amount+"元"+" "+"清空购物车所需金额为："+needMoney+"元");
                    }else {
                        amount -= needMoney;
                        car.emptyCar();
                        System.out.println("您当前余额为："+amount+"元");
                    }
                }
                else if (choose2 == 'N') {
                    System.out.println("请选择是否需要删除商品（Y表示是，N表示否）：");
                    String str2 = in.next();
                    char choose3 = str2.charAt(0);
                    if(choose3 == 'Y') {
                        System.out.println("请选择需要删除的商品编号：");
                        int num = in.nextInt();
                        if (num >= 1 && num <= 12)
                            car.delete(option(num));
                    }
                }
            }
            else if (choose1 == (-1))
                break;
        }
    }
}
