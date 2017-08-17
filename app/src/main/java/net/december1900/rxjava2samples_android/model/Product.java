package net.december1900.rxjava2samples_android.model;

import java.util.List;

/**
 * Created by december on 2017/8/16.
 */

public class Product {

    /**
     * update : 1501400947
     * _product : [{"name":"学而","icon":"http://static.muxixyz.com/ic_xueer.png","url":"https://xueer.muxixyz.com","intro":"华师课程经验挖掘机!"}]
     */

    public int update;
    public List<ProductEntity> _product;

    public static class ProductEntity {
        /**
         * name : 学而
         * icon : http://static.muxixyz.com/ic_xueer.png
         * url : https://xueer.muxixyz.com
         * intro : 华师课程经验挖掘机!
         */

        public String name;
        public String icon;
        public String url;
        public String intro;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }
    }
}
