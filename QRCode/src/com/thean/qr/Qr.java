package com.thean.qr;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 *
 * @author DAVISY
 */
public class Qr {

    public String createQR(String data) {
        try {
            //Lấy đường dẫn lưu mã QR
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn đường dẫn lưu văn bản!");

            int userSelection = fileChooser.showSaveDialog(fileChooser);
            //System.out.println(fileChooser.getSelectedFile().getAbsoluteFile());

            //String filePath = /*qr.getPath()*/ " " + hoTen + ".png";
            String filePath = fileChooser.getSelectedFile().getAbsoluteFile().toString();
            
            if (!filePath.contains(".png") && !filePath.contains(".jpg") && !filePath.contains(".jpeg")) {
                filePath = fileChooser.getSelectedFile().getAbsoluteFile() + ".png";
            }
            
            
            //Trình tạo mã QR
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map< EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap< EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(data.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                    .lastIndexOf('.') + 1), new File(filePath));
            return data;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        Qr qr = new Qr();
        System.out.println(qr.createQR("bvc"));;
    }

}
