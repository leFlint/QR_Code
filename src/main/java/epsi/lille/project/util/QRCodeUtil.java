package epsi.lille.project.util;

import java.util.Base64;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

public class QRCodeUtil {
	private QRCodeUtil() {
	}

	public static final String generate(String url) {
		return "data:image/png;base64," + Base64.getEncoder().encodeToString(QRCode
				.from(url).to(ImageType.PNG).withCharset("UTF-8").stream().toByteArray());
	}
}
