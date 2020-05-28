package test.demo;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.collections.map.AbstractMapDecorator;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ghj
 * @Description
 * @date 2020/5/27 11:16
 */
public class QrcodeDemo {

    private static final String QR_CODE_IMAGE_PATH = "D:\\Pictures\\二维码2.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> map = new HashMap<>();
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        Map<EncodeHintType, ?> map1 = new HashMap<>(map);

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, map1);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    public static void main(String[] args) {
        try {
            generateQRCodeImage("你好", 500, 500, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }


}
