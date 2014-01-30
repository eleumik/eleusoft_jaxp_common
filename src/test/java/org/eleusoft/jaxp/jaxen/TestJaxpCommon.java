package org.eleusoft.jaxp.jaxen;

import java.io.StringReader;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.eleusoft.jaxp.common.NodeListImpl;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Just a minimal test, for a bigger test
 * see the <code>eleusoft_xpath_test</code>
 * project.
 * 
 * @author mik
 *
 */
public class TestJaxpCommon extends TestCase
{
    public void testNodeList() throws Exception
    {
        Document doc = getDocument("<xml>a</xml>");
        final ArrayList list = new ArrayList();
        list.add(doc);
        list.add(doc.getDocumentElement());
        list.add(doc.getDocumentElement());
        list.add(doc.getDocumentElement().getFirstChild());
        
        NodeList nl = new NodeListImpl(list);
        
        assertEquals(4, nl.getLength());
        assertEquals(doc, nl.item(0));
        assertEquals(doc.getDocumentElement(), nl.item(1));
        assertEquals(doc.getDocumentElement(), nl.item(2));
        assertEquals(doc.getDocumentElement().getFirstChild(), nl.item(3));
        
        //  Returns the indexth item in the collection. 
        // If index is greater than or equal to the number of nodes in the list, this returns null.
        assertNull(nl.item(-1));
        assertNull(nl.item(999));
        
    }
    private Document getDocument(String string) throws Exception
    {
        InputSource is = new InputSource(new StringReader(string));
        return JAXP.getDocument(is);
        
        
    }
    

}
