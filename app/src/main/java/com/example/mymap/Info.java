package com.example.mymap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang_zzheng on 2016/7/19
 * yangzhizheng2012@163.com
 */
public class Info implements Serializable
{
    private static final long serialVersionUID = -758459502806858414L;
    /**
     * 精度
     */
    private double latitude;
    /**
     * 纬度
     */
    private double longitude;
    /**
     * 图片ID，真实项目中可能是图片路径
     */
    private int imgId;
    /**
     * 商家名称
     */
    private String name;
    /**
     * 距离
     */
    private String distance;
    /**
     * 赞数量
     */
    private int zan;

    public static List<Info> infos = new ArrayList<Info>();

    static
    {
        infos.add(new Info( 30.692594, 103.81401,R.mipmap.a01, "成都中医药大学AED",
                "距离632米", 1456));
        infos.add(new Info(30.701907, 103.836862, R.mipmap.a02, "成都市第五人民医院AED",
                "距离897米", 456));
        infos.add(new Info(30.707101, 103.847778, R.mipmap.a03, "成都市温江区人民医院AED",
                "距离1521米", 1456));
        infos.add(new Info(30.709508, 103.845964, R.mipmap.a04, "成都市温江区妇幼保健院AED",
                "距离1650米", 1456));
    }

    public Info()
    {
    }

    public Info(double latitude, double longitude, int imgId, String name,
                String distance, int zan)
    {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.imgId = imgId;
        this.name = name;
        this.distance = distance;
        this.zan = zan;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public String getName()
    {
        return name;
    }

    public int getImgId()
    {
        return imgId;
    }

    public void setImgId(int imgId)
    {
        this.imgId = imgId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDistance()
    {
        return distance;
    }

    public void setDistance(String distance)
    {
        this.distance = distance;
    }

    public int getZan()
    {
        return zan;
    }

    public void setZan(int zan)
    {
        this.zan = zan;
    }

}
