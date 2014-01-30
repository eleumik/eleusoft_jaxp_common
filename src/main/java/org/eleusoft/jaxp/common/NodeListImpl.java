package org.eleusoft.jaxp.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Helper DOM NodeList implementation.
 * @author Michele Vivoda
 */
public class NodeListImpl implements NodeList
{
    public static final NodeList EMPTY = new NodeListImpl(Collections.EMPTY_LIST);
    private final List list;
    /**
     * Constructs a NodeList with a {@link Collection}.
     * If the passed collection is a {@link List} it is used
     * as model, otherwise is copied to an {@link ArrayList}.
     * @param o a List containing Node instances.
     */
    public NodeListImpl(Collection o)
    {
        if (o instanceof List)
            this.list = (List)o;
        else {
            this.list = new ArrayList();
            this.list.addAll(o);
        }
        
    }
    /*
     * (non-Javadoc)
     * @see org.w3c.dom.NodeList#getLength()
     */
    public int getLength()
    {
        return list.size();
    }
    /*
     * (non-Javadoc)
     * @see org.w3c.dom.NodeList#item(int)
     */
    public Node item(int index)
    {
        //  Returns the indexth item in the collection. 
        // If index is greater than or equal to the number of nodes in the list, this returns null.
        
        if (index <0 || index>=getLength() ) return null;
        
        final Object obj = list.get(index);
        if (obj instanceof Node)
        {
            return (Node)obj;
        }
        else if (obj instanceof String)
        {
            throw new RuntimeException("Unexpected string : " + obj);
        }
        else throw new RuntimeException("Unknown object:" + obj);
    }
}