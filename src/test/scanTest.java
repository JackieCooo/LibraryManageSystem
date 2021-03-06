package test;

import com.google.zxing.*;
import com.google.zxing.client.j2se.*;
import com.google.zxing.common.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.EnumMap;

/**
 * @brief 该类主要解析二维码
 *        步骤：
 *        1.读取二维码图片
 *        2.读取二维码图片中的二维码
 *        3.读取二维码中的信息
 */
public class scanTest {

    //二维码格式参数集合
    private static final EnumMap<DecodeHintType,Object> hints = new EnumMap<>(DecodeHintType.class);

    static {
        //设置解析二维码后信息的字符集
        hints.put(DecodeHintType.CHARACTER_SET,"UTF-8");
    }

    /**
     * @brief 解析二维码
     * @param path 二维码图片路径
     * @return 二维码中的文本内容
     */
    public static String decodeQRCodeForPath(String path){
        //该文件对象映射二维码图片
        File file = new File(path);
        if(file.exists()){
            try {
                return decodeQRCodeStreamForStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * @brief 解析二维码
     * @param ins 读取二维码图片的流
     * @return 二维码中的文本内容
     */
    public static String decodeQRCodeStreamForStream(InputStream ins) {
        if(ins != null){
            try {
                //将读取二维码图片的流转为图片对象
                BufferedImage image = ImageIO.read(ins);
                BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
                HybridBinarizer binarizer = new HybridBinarizer(source);
                BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
                MultiFormatReader reader = new MultiFormatReader();
                Result result = reader.decode(binaryBitmap, hints);
                //返回二维码中的文本内容
                String content = result.getText();
                System.out.println("二维码解析成功");
                return content;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * @brief 主方法测试二维码解析
     * @param args args
     */
    public static void main(String[] args) {
        String res = decodeQRCodeForPath("testFile/test1.jpg");
        System.out.println(res);
    }
}

