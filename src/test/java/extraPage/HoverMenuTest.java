package extraPage;

import extraPagesForHelpUs.NotebooksPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import setUp.TestBase;

public class HoverMenuTest extends TestBase {
    NotebooksPage notebooksPageObj;
@Test
    public void testHoverOnComputerMenuThenHoverOnNotebookMenuSuccessful(){

     notebooksPageObj = homePageObj.openNoteBookUsingHoverMenu();
     String title = notebooksPageObj.getNotebookPageTitle();
    Assert.assertTrue(title.contains("Notebooks"),"notebook page not opened");

}
}
