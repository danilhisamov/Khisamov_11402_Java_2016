package ru.kpfu.itis.pdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class pdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Table table = new Table(4);
        table.addCell("\t" + "\n\t");
        table.addCell("\tAll" + "\n\t");
        table.addCell("\tActive" + "\n\t");
        table.addCell("\tNot Active" + "\n\t");
        table.addCell("\tCars" + "\n\t");
        table.addCell("\t" + model.get("allCars").toString() + "\n\t");
        table.addCell("\t" + model.get("allActiveCars").toString() +"\n\t");
        table.addCell("\t" + model.get("allPassiveCars") + "\n\t");
        document.add(table);

        document.addTitle("Report");

        Paragraph paragraph = new Paragraph();
        String s = "All clients count: " + model.get("allClients");
        Chunk chunk = new Chunk(s);
        paragraph.add(chunk);

        Paragraph paragraph1 = new Paragraph();
        String s1 = "\nAll orders prices summary: " + model.get("allOrdersSum");
        Chunk chunk1 = new Chunk(s1);
        paragraph.add(chunk1);
        document.add(paragraph1);
        document.add(paragraph);
    }

}
