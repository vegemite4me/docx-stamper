package org.wickedsource.docxstamper;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.P;
import org.junit.Assert;
import org.junit.Test;
import org.wickedsource.docxstamper.api.coordinates.TableCellCoordinates;
import org.wickedsource.docxstamper.api.coordinates.TableRowCoordinates;
import org.wickedsource.docxstamper.context.Character;
import org.wickedsource.docxstamper.context.CharactersContext;
import org.wickedsource.docxstamper.context.functions.FormatBoolFunction;
import org.wickedsource.docxstamper.context.functions.FormatBoolFunctionImpl;
import org.wickedsource.docxstamper.util.ParagraphWrapper;
import org.wickedsource.docxstamper.util.walk.BaseCoordinatesWalker;
import org.wickedsource.docxstamper.util.walk.CoordinatesWalker;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RepeatTableRowTest extends AbstractDocx4jTest {

    @Test
    public void test() throws Docx4JException, IOException {
        CharactersContext context = new CharactersContext();
        context.getCharacters().add(new Character("Homer Simpson", "Dan Castellaneta", false));
        context.getCharacters().add(new Character("Marge Simpson", "Julie Kavner", false));
        context.getCharacters().add(new Character("Bart Simpson", "Nancy Cartwright", true));
        context.getCharacters().add(new Character("Kent Brockman", "Harry Shearer", false));
        context.getCharacters().add(new Character("Disco Stu", "Hank Azaria", false));
        context.getCharacters().add(new Character("Krusty the Clown", "Dan Castellaneta", false));
        InputStream template = getClass().getResourceAsStream("RepeatTableRowTest.docx");

        DocxStamperConfiguration conf = new DocxStamperConfiguration();
        conf.exposeInterfaceToExpressionLanguage(FormatBoolFunction.class, new FormatBoolFunctionImpl());

        WordprocessingMLPackage document = stampAndLoad(template, context, conf);

        final List<TableRowCoordinates> rowCoords = new ArrayList<>();
        CoordinatesWalker walker = new BaseCoordinatesWalker(document) {
            @Override
            protected void onTableRow(TableRowCoordinates tableRowCoordinates) {
                rowCoords.add(tableRowCoordinates);
            }
        };
        walker.walk();

        // 1 header row + 1 row per character in list
        Assert.assertEquals(7, rowCoords.size());


        final List<TableCellCoordinates> cells = new ArrayList<>();
        CoordinatesWalker cellWalker = new BaseCoordinatesWalker(document) {
            @Override
            protected void onTableCell(TableCellCoordinates tableCellCoordinates) {
                cells.add(tableCellCoordinates);
            }
        };
        cellWalker.walk();

        Assert.assertEquals("Homer Simpson", new ParagraphWrapper((P) cells.get(3).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Dan Castellaneta", new ParagraphWrapper((P) cells.get(4).getCell().getContent().get(0)).getText());
        Assert.assertEquals("No", new ParagraphWrapper((P) cells.get(5).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Marge Simpson", new ParagraphWrapper((P) cells.get(6).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Julie Kavner", new ParagraphWrapper((P) cells.get(7).getCell().getContent().get(0)).getText());
        Assert.assertEquals("No", new ParagraphWrapper((P) cells.get(8).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Bart Simpson", new ParagraphWrapper((P) cells.get(9).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Nancy Cartwright", new ParagraphWrapper((P) cells.get(10).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Yes", new ParagraphWrapper((P) cells.get(11).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Kent Brockman", new ParagraphWrapper((P) cells.get(12).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Harry Shearer", new ParagraphWrapper((P) cells.get(13).getCell().getContent().get(0)).getText());
        Assert.assertEquals("No", new ParagraphWrapper((P) cells.get(14).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Disco Stu", new ParagraphWrapper((P) cells.get(15).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Hank Azaria", new ParagraphWrapper((P) cells.get(16).getCell().getContent().get(0)).getText());
        Assert.assertEquals("No", new ParagraphWrapper((P) cells.get(17).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Krusty the Clown", new ParagraphWrapper((P) cells.get(18).getCell().getContent().get(0)).getText());
        Assert.assertEquals("Dan Castellaneta", new ParagraphWrapper((P) cells.get(19).getCell().getContent().get(0)).getText());
        Assert.assertEquals("No", new ParagraphWrapper((P) cells.get(20).getCell().getContent().get(0)).getText());
    }


}
