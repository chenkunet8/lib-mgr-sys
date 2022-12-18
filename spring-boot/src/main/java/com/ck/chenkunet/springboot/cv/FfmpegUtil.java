package com.ck.chenkunet.springboot.cv;

import com.alibaba.fastjson.JSONObject;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class FfmpegUtil {

    /**
     * 获取视频帧率
     *
     * @param videoPath 视频路径
     * @return
     */
    public static double getVideoRate(String videoPath) {
        double rate = 0L;
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoPath);
        try {
            grabber.start();
            rate = grabber.getFrameRate();
            grabber.stop();
        } catch (FFmpegFrameGrabber.Exception e) {
            e.printStackTrace();
        }
        return rate;
    }

    /**
     * 视频截帧
     * @param videoPath 视频路径
     * @param imgPath  图像保存路径
     * @param sampleRate 每秒截帧频率
     */
    public static void getVideoFileFrame(String videoPath, String imgPath, double sampleRate) {
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoPath);
        try {
            grabber.start();
            int len = grabber.getLengthInFrames();
            double rate = grabber.getFrameRate();
            int flag = 1;
            Frame frame;
            while (flag <= len) {
                frame = grabber.grabImage();
                if (flag % (rate / sampleRate) == 0) {
                    //保存图片
                    ImageIO.write(new Java2DFrameConverter().convert(frame),"jpg",new File(imgPath+"\\images-"+flag+".jpg"));
                }
                flag++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 截取视频帧，调用AI接口进行目标检测，绘制识别框
     * @param videoPath 视频路径
     * @param imgPath  图像保存路径
     * @param sampleRate 每秒截帧频率
     */
    public static void getVideoFileFrameDetect(String videoPath, String imgPath, double sampleRate) {
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoPath);
        try {
            grabber.start();
            int len = grabber.getLengthInFrames();
            double rate = grabber.getFrameRate();
            int flag = 1;
            Frame frame;
            while (flag <= len) {
                frame = grabber.grabImage();
                if (flag % (rate / sampleRate) == 0) {
                    //保存图片
                    BufferedImage image = new Java2DFrameConverter().convert(frame);
                    image = drawImage(image);
                    ImageIO.write(image,"jpg",new File(imgPath+"\\images-"+flag+".jpg"));
                }
                flag++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static BufferedImage drawImage(BufferedImage image) {
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(image,0,0,null);
        Stroke dash = new BasicStroke(3f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[]{15, 0,}, 0f);
        graphics.setStroke(dash);
        graphics.setColor(Color.RED);
        graphics.drawRect(100,100,300,300);
        graphics.dispose();
        return image;
    }

    public static JSONObject requestDetect(BufferedImage image,String url) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", stream);
        String base64 = Base64.getEncoder().encodeToString(stream.toByteArray());
        JSONObject content = new JSONObject();
        content.put("img_input",base64);
        return HttpUtil.doPost(url,content.toString());
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(getVideoRate("http://10.13.16.22/action/live.flv?stream=0&audio=0"));
//        System.out.println(getVideoRate("D:\\software\\ffmpeg\\ffmpeg-5.1.2-full_build\\bin\\2022-11-24-10.mp4"));
        String videoPath = "D:\\software\\ffmpeg\\ffmpeg-5.1.2-full_build\\bin\\2022-11-24-10.mp4";
        String imaPath = "D:\\software\\ffmpeg\\ffmpeg-5.1.2-full_build\\bin\\new";
//        getVideoFileFrameDetect(videoPath,imaPath,0.1);
        String url = "http://127.0.0.1:15000/todo/api/v1.5/control/online/IMAGE/PREDICT";
        BufferedImage image = ImageIO.read(new File("D:\\software\\ffmpeg\\ffmpeg-5.1.2-full_build\\bin\\train-night-center\\image-00013.jpg"));
        System.out.println(requestDetect(image,url).toString());
    }
}
