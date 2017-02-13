package com.example.niuyi.imageloaderdemo.loader.listener;

/**
 * User: niuyi(牛毅)
 * Date: 2017-02-13
 * Time: 13:19
 * Desc:
 */
public interface ProgressListener {

    void update(long bytesRead, long contentLength, boolean done);

}
