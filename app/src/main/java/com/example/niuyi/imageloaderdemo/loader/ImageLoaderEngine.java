package com.example.niuyi.imageloaderdemo.loader;

import android.content.Context;
import android.widget.ImageView;

import com.example.niuyi.imageloaderdemo.loader.listener.ImageSaveListener;
import com.example.niuyi.imageloaderdemo.loader.listener.ProgressLoadListener;
import com.example.niuyi.imageloaderdemo.loader.listener.SourceReadyListener;

/**
 * User: niuyi(牛毅)
 * Date: 2017-02-13
 * Time: 12:53
 * Desc: 单例模式的图片加载引擎
 */
public class ImageLoaderEngine {

    private static ImageLoaderEngine mInstance;

    private ImageLoaderInterface mStrategy;

    public ImageLoaderEngine() {
        mStrategy = new GlideImageLoaderStrategy();
    }

    public static ImageLoaderEngine getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoaderEngine.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderEngine();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    public void loadImage(String url, int placeholder, ImageView imageView) {
        mStrategy.loadImage(imageView.getContext(), url, placeholder, imageView);
    }

    public void loadGifImage(String url, int placeholder, ImageView imageView) {
        mStrategy.loadGifImage(url, placeholder, imageView);
    }

    public void loadImage(String url, ImageView imageView) {
        mStrategy.loadImage(url, imageView);
    }

    public void loadImageWithAppCxt(String url, ImageView imageView) {
        mStrategy.loadImageWithAppCxt(url, imageView);
    }

    public void loadImageWithProgress(String url, ImageView imageView, ProgressLoadListener listener) {
        mStrategy.loadImageWithProgress(url, imageView, listener);
    }

    public void loadGifWithPrepareCall(String url, ImageView imageView, SourceReadyListener listener) {
        mStrategy.loadGifWithPrepareCall(url, imageView, listener);
    }

    /**
     * 清除图片磁盘缓存
     *
     * @param context
     */
    public void clearImageDiskCache(final Context context) {
        mStrategy.clearImageDiskCache(context);
    }

    /**
     * 清除图片内存缓存
     *
     * @param context
     */
    public void clearImageMemoryCache(Context context) {
        mStrategy.clearImageMemoryCache(context);
    }

    /**
     * 根据不同的内存状态，来响应不同的内存释放策略
     *
     * @param context
     * @param level
     */
    public void trimMemory(Context context, int level) {
        mStrategy.trimMemory(context, level);
    }

    /**
     * 清除图片所有缓存
     *
     * @param context
     */
    public void clearImageAllCache(Context context) {
        clearImageDiskCache(context.getApplicationContext());
        clearImageMemoryCache(context.getApplicationContext());
    }

    /**
     * 获取缓存大小
     *
     * @return CacheSize
     */
    public String getCacheSize(Context context) {
        return mStrategy.getCacheSize(context);
    }

    /**
     * 保存图片
     *
     * @param context
     * @param url
     * @param savePath
     * @param saveFileName
     * @param listener
     */
    public void saveImage(Context context, String url, String savePath, String saveFileName, ImageSaveListener listener) {
        mStrategy.saveImage(context, url, savePath, saveFileName, listener);
    }
}
