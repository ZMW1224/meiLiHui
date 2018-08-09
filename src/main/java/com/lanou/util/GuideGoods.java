package com.lanou.util;

import com.lanou.model.Goods;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/8/7.
 */
public class GuideGoods {
    private List goodsThirdtitle;
    private List goodsBrand;
    private String goodsPrimarytitle;
    private String goodsSecondtitle;
    private String keyword;

    // 共几页
    private Integer pages;
    // 总共的数据量
    private Long total;

    private List<Goods> goodsList;

    public List getGoodsThirdtitle() {
        return goodsThirdtitle;
    }

    public void setGoodsThirdtitle(List goodsThirdtitle) {
        this.goodsThirdtitle = goodsThirdtitle;
    }

    public List getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(List goodsBrand) {
        this.goodsBrand = goodsBrand;
    }


    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public GuideGoods() {
    }

    public String getGoodsPrimarytitle() {
        return goodsPrimarytitle;
    }

    public void setGoodsPrimarytitle(String goodsPrimarytitle) {
        this.goodsPrimarytitle = goodsPrimarytitle;
    }

    public String getGoodsSecondtitle() {
        return goodsSecondtitle;
    }

    public void setGoodsSecondtitle(String goodsSecondtitle) {
        this.goodsSecondtitle = goodsSecondtitle;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "GuideGoods{" +
                "goodsThirdtitle=" + goodsThirdtitle +
                ", goodsBrand=" + goodsBrand +
                ", goodsPrimarytitle='" + goodsPrimarytitle + '\'' +
                ", goodsSecondtitle='" + goodsSecondtitle + '\'' +
                ", keyword='" + keyword + '\'' +
                ", pages=" + pages +
                ", total=" + total +
                ", goodsList=" + goodsList +
                '}';
    }
}
