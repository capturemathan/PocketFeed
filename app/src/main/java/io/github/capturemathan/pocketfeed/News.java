package io.github.capturemathan.pocketfeed;

class News {

    private String mTitle;
    private String mDesc;
    private String mUrl;
    private String mImgUrl;

    public News(String title, String desc, String url, String imgurl) {
        mTitle = title;
        mDesc = desc;
        mUrl = url;
        mImgUrl = imgurl;
    }


    public String getUrl() {
        return mUrl;
    }

    public String getDesc() {
        return mDesc;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getImgUrl() {
        return mImgUrl;
    }
}
