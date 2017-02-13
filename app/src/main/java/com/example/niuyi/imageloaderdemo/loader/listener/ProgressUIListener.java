package com.example.niuyi.imageloaderdemo.loader.listener;

/**
 * User: niuyi(牛毅)
 * Date: 2017-02-13
 * Time: 13:17
 * Desc: 通知UI进度
 */
public interface ProgressUIListener {

    void update(int bytesRead, int contentLength);

}
