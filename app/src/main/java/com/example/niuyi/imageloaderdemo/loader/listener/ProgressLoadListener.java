package com.example.niuyi.imageloaderdemo.loader.listener;

/**
 * User: niuyi(牛毅)
 * Date: 2017-02-13
 * Time: 13:03
 * Desc: 加载进度监听
 */
public interface ProgressLoadListener {

    void update(int bytesRead, int contentLength);

    void onException();

    void onResourceReady();

}
