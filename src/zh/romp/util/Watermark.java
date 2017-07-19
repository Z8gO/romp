package zh.romp.util;

import java.awt.*; 
import java.awt.image.BufferedImage; 
import java.io.*; 

import javax.imageio.*; 
 /**
  * 
  * 类名:		Watermark
  * 描述:		TODO
  * @author 	ZHANGHUANG
  * @date 	2016年5月4日 下午2:34:59
  *
  */
public class Watermark{ 
    public Watermark(){}; 
    /** 在源图片上设置水印文字 */ 
    public void WordsToImage(String srcImagePath,float alpha, 
            String font,int fontStyle,int fontSize,Color color, 
            String inputWords,int x,int y,String imageFormat,String toPath) 
            		throws IOException{ 
        FileOutputStream fos=null; 
        try {  //读取图片 
            BufferedImage image = ImageIO.read
            		(new File(srcImagePath)); 
            //创建java2D对象 
            Graphics2D g2d=image.createGraphics(); 
            //用源图像填充背景 
            g2d.drawImage(image, 0, 0, image.getWidth(), 
            		image.getHeight(), null, null); 
            AlphaComposite ac = AlphaComposite.getInstance
            		(AlphaComposite.SRC_OVER, alpha); 
            //为 Graphics2D 上下文设置 Composite。 Composite 用于
            //所有绘制方法中，如 drawImage、drawString、draw 和 fill。  
            //它指定新的像素如何在呈现过程中与图形设备上的现有像素组合。  
            g2d.setComposite(ac);   
            //设置文字字体名称、样式、大小 
            g2d.setFont(new Font(font, fontStyle, fontSize)); 
            g2d.setColor(color);//设置字体颜色 
            g2d.drawString(inputWords, x, y); //输入水印文字及其起始x、y坐标 
            g2d.dispose(); 
            //将水印后的图片写入toPath路径中 
            fos=new FileOutputStream(toPath); 
            ImageIO.write(image, imageFormat, fos); 
        }  
        //文件操作错误抛出 
        catch (Exception e) { 
           e.printStackTrace(); 
        }finally{ 
            if(fos!=null){ 
                fos.close(); 
            } 
        } 
    } 
      
    /** 
       *  在源图像上设置图片水印   
     */ 
    public void ImageToImage(String srcImagePath,String appendImagePath, 
            float alpha,int x,int y,int width,int height, 
            String imageFormat,String toPath) throws IOException{ 
            FileOutputStream fos = null; 
        try { 
            //读图 
            BufferedImage image = ImageIO.read(new File(srcImagePath)); 
            //创建java2D对象 
            Graphics2D g2d=image.createGraphics(); 
            //用源图像填充背景 
            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null, null); 
             
            //关键地方 
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha); 
            g2d.setComposite(ac); 
             
            BufferedImage appendImage = ImageIO.read(new File(appendImagePath)); 
            g2d.drawImage(appendImage, x, y, width, height, null, null); 
            g2d.dispose(); 
            fos=new FileOutputStream(toPath); 
            ImageIO.write(image, imageFormat, fos); 
        } catch (Exception e) { 
           e.printStackTrace(); 
        }finally{ 
            if(fos!=null){ 
                fos.close(); 
            } 
        } 
    } 
     
  
}
