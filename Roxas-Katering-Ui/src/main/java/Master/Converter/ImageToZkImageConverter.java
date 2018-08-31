package Master.Converter;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.image.AImage;
import org.zkoss.zul.Image;

public class ImageToZkImageConverter implements Converter<AImage, byte[], Image>, Serializable{
	private static final long serialVersionUID = 1L;
	private Log logger = LogFactory.getLog(ImageToZkImageConverter.class);
	
	@Override
	public AImage coerceToUi(byte[] beanProp, Image component, BindContext ctx) {
	    try {
            if (beanProp != null && beanProp.length > 0) {
                AImage im = new AImage("", beanProp);
                component.setContent(im);
                return im;
            }
            logger.debug("Return null => image is empty");
            return null;
        } catch (IOException e) {
            logger.error("Error occured, returning null", e);
            return null;
        }
	}

	@Override
	public byte[] coerceToBean(AImage compAttr, Image component, BindContext ctx) {
		logger.debug("Converting the image");
        return compAttr.getByteData();
	}

}
