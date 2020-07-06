package cn.edu.ldu.grad.utils;

import java.io.OutputStream;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.itextpdf.text.pdf.BaseFont;


/**
 * 导出PDF文件转换工具
 */
public class PDFUtil {
  public static void createPDF(OutputStream out, String html) throws Exception {
    ITextRenderer renderer = new ITextRenderer();
    renderer.setDocumentFromString(html);
    ITextFontResolver fontResolver = renderer.getFontResolver();
    fontResolver.addFont("pdf/font/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    renderer.layout();
    renderer.createPDF(out);
  }
}
