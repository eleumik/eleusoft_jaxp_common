package org.eleusoft.jaxp.common;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPathFunctionResolver;
import javax.xml.xpath.XPathVariableResolver;

public class AbstractResolvers
{
    protected XPathVariableResolver variableResolver;
    protected XPathFunctionResolver functionResolver;
    protected NamespaceContext nsContext;
    protected final boolean secure;

    /**
     * Constructor for subclasses.
     * @param vr optional {@link XPathVariableResolver}
     * @param fr optional {@link XPathFunctionResolver}
     * @param secure secure mode flag.
     */
    protected AbstractResolvers(final XPathVariableResolver vr,
                               final XPathFunctionResolver fr,
                               final boolean secure)
    {
        this.variableResolver = vr;
        this.functionResolver = fr;
        this.secure = secure;
    }
    
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPath#getNamespaceContext()
     */
    public NamespaceContext getNamespaceContext()
    {
        return nsContext;
    }
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPath#getXPathFunctionResolver()
     */
    public XPathFunctionResolver getXPathFunctionResolver()
    {
        return this.functionResolver;
    }
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPath#getXPathVariableResolver()
     */
    public XPathVariableResolver getXPathVariableResolver()
    {
        return this.variableResolver;
    }
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPath#setNamespaceContext(javax.xml.namespace.NamespaceContext)
     */
    public void setNamespaceContext(final NamespaceContext ns)
    {
        if (ns==null) throw new NullPointerException("Null namespace context");
        this.nsContext = ns;
    }
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPath#setXPathFunctionResolver(javax.xml.xpath.XPathFunctionResolver)
     */
    public void setXPathFunctionResolver(final XPathFunctionResolver resolver)
    {
        if (resolver==null) throw new NullPointerException("Null function resolver");
        this.functionResolver = resolver;
    }
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPath#setXPathVariableResolver(javax.xml.xpath.XPathVariableResolver)
     */
    public void setXPathVariableResolver(final XPathVariableResolver resolver)
    {
        if (resolver==null) throw new NullPointerException("Null variable resolver");
        this.variableResolver= resolver;

    }
    
}