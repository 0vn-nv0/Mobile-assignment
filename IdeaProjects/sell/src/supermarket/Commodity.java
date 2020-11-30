package supermarket;

public class Commodity {            //商品信息类
    private String goodsName;
    private int value;

    public Commodity(String goodsName,int value) {      //构造商品信息   商品名称  商品价格
        this.goodsName = goodsName;
        this.value=value;
    }
    public String getName(){
        return goodsName;
    }

    public int getValue(){ return  value; }


    public void show() {                //陈列商品列表
        if(goodsName=="商品列表：")
        System.out.println(goodsName);
        else
            System.out.println(goodsName+" "+value+"元");
    }
}
