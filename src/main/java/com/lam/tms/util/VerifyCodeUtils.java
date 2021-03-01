package com.lam.tms.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * 生成图形验证码的工具类
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

public class VerifyCodeUtils {

    private final static VerifyCode VERIFY_CODE = new VerifyCode(10);

    /**
     * 获取验证码
     *
     * @return BufferedImage
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    public static ImageVerifyCode getImage() {
        BufferedImage image = VERIFY_CODE.getImage();
        String codeText = VERIFY_CODE.getText();
        return new ImageVerifyCode(codeText, image);
    }

    @Getter
    @AllArgsConstructor
    public static class ImageVerifyCode {

        private String codeText;

        private BufferedImage image;

    }

    private static class VerifyCode {
        private int w = 120;

        private int h = 50;

        private Random r = new Random();

        /**
         * 验证码的字体
         *
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        private final static String[] FONT_NAMES = {"宋体", "微软雅黑"};

        /**
         * 可选字符
         *
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        private final static String CODES = "13456789abcdefghjkmnpqrstuvwxyABCDEFGHJKMNPQRSTUVWXY";

        /**
         * 背景色
         *
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        private Color bgColor = new Color(255, 255, 255);

        /**
         * 验证码上的文本
         *
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        private String text;

        public VerifyCode(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public VerifyCode(int minute) {
            // 多少 分钟 后
            this.localDateTime = LocalDateTime.now().plusMinutes(minute);
        }

        //过期时间
        private LocalDateTime localDateTime;

        /**
         * 生成随机的颜色
         *
         * @return Color
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        private Color randomColor() {
            int red = r.nextInt(150);
            int green = r.nextInt(150);
            int blue = r.nextInt(150);
            return new Color(red, green, blue);
        }

        /**
         * 生成随机的字体
         *
         * @return Font
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        private Font randomFont() {
            int index = r.nextInt(FONT_NAMES.length);
            //生成随机的字体名称
            String fontName = FONT_NAMES[index];
            //生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
            int style = r.nextInt(4);
            //生成随机字号, 26 ~ 30
            int size = r.nextInt(5) + 26;
            return new Font(fontName, style, size);
        }

        /**
         * 画干扰线
         *
         * @param image
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        private void drawLine(BufferedImage image) {
            //一共画3条
            int num = 3;
            Graphics2D g2 = (Graphics2D) image.getGraphics();
            //生成两个点的坐标，即4个值
            for (int i = 0; i < num; i++) {
                int x1 = r.nextInt(w);
                int y1 = r.nextInt(h);
                int x2 = r.nextInt(w);
                int y2 = r.nextInt(h);
                g2.setStroke(new BasicStroke(1.5F));
                //干扰线是蓝色
                g2.setColor(Color.BLUE);
                //画线
                g2.drawLine(x1, y1, x2, y2);
            }
        }

        /**
         * 随机生成一个字符
         *
         * @return char
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        private char randomChar() {
            int index = r.nextInt(CODES.length());
            return CODES.charAt(index);
        }

        /**
         * 创建BufferedImage
         *
         * @return java.awt.image.BufferedImage
         * @throws
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        private BufferedImage createImage() {
            BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = (Graphics2D) image.getGraphics();
            g2.setColor(this.bgColor);
            g2.fillRect(0, 0, w, h);
            return image;
        }

        /**
         * 调用这个方法得到验证码
         *
         * @return java.awt.image.BufferedImage
         * @throws
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        public BufferedImage getImage() {
            //创建图片缓冲区
            BufferedImage image = createImage();
            //得到绘制环境
            Graphics2D g2 = (Graphics2D) image.getGraphics();
            //用来装载生成的验证码文本
            StringBuilder sb = new StringBuilder();
            // 向图片中画4个字符
            //循环四次，每次生成一个字符
            for (int i = 0; i < 4; i++) {
                //随机生成一个字母
                String s = randomChar() + "";
                //把字母添加到sb中
                sb.append(s);
                //设置当前字符的x轴坐标
                float x = i * 1.0F * w / 4;
                //设置随机字体
                g2.setFont(randomFont());
                //设置随机颜色
                g2.setColor(randomColor());
                //画图
                g2.drawString(s, x, h - 5);
            }
            //把生成的字符串赋给了this.text
            this.text = sb.toString();
            //添加干扰线
            drawLine(image);
            return image;
        }

        /**
         * 返回验证码图片上的文本
         *
         * @return String
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        public String getText() {
            return text;
        }

        /**
         * 保存图片到指定的输出流
         *
         * @param image
         * @param out
         * @return void
         * @author lamlados
         * @date 2021/2/20 15:26
         */
        public static void output(BufferedImage image, OutputStream out)
                throws IOException {
            ImageIO.write(image, "JPEG", out);
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public void setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public boolean isExpired() {
            return LocalDateTime.now().isAfter(localDateTime);
        }


    }

}
