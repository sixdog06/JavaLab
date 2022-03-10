package com.punchcode.java_concurrency_in_practice.chapter6.common;

import java.util.Collections;
import java.util.List;

/**
 * 图像信息
 * @author huanruiz
 * @since 2022/3/9
 */
public class ImageInfo {
    
    public static void renderText(CharSequence source) {
    
    }
    
    public static List<ImageInfo> scanForImageInfo(CharSequence source) {
        return Collections.singletonList(new ImageInfo());
    }
    
    public ImageData downloadImage() {
        return new ImageData();
    }
}
