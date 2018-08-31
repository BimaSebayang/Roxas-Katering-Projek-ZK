package Master.SharingInformation;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageCaptureDto {
    
	private byte[] imageByte;
	private String imageTitle;
//	 int imageSizeX;
//	public int imageSizeY;
//	public double imageScaledX;
//	public double imageScaledY;
//	public BufferedImage ImageBufferedImage;
	
	public ImageCaptureDto(byte[] imageByte, String imageTitle) {
		this.imageByte = imageByte;
		this.imageTitle = imageTitle;
	}
	
	public byte[] getByte() {
		return imageByte;
	}
	
	public int getHeight() {
		ByteArrayInputStream bisImage = new ByteArrayInputStream(imageByte);
		Image image = null;
		try {
			image = ImageIO.read(bisImage);
		} catch (IOException e) {
			System.err.println("File Ini Mengandung CMYK " + bisImage);
			e.printStackTrace();
		}
	    return image.getHeight(null);
	}
	
	public int getWidth(){
		ByteArrayInputStream bisImage = new ByteArrayInputStream(imageByte);
		Image image = null;
		try {
			image = ImageIO.read(bisImage);
		} catch (IOException e) {
			System.err.println("File Ini Mengandung CMYK " + bisImage);
			e.printStackTrace();
		}
	    return image.getWidth(null);
	}
	
	public BufferedImage getBuffImage() {
		try {
			return ImageIO.read(new ByteArrayInputStream(imageByte));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
