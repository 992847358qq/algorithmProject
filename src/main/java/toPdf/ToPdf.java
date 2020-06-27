package toPdf;
import com.spire.doc.*;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/4/13 22:15
 **/
public class ToPdf {
    public static void main(String[] args) {

        //加载Word示例文档
        Document document = new Document();
        document.loadFromFile("D:\\wordToPdf\\test\\学而思.docx");

        //保存结果文档
        document.saveToFile("D:\\wordToPdf\\test\\学而思.pdf", FileFormat.PDF);
    }
}
