package org.eleusoft.jaxp.common;

import javax.xml.XMLConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFactoryConfigurationException;
import javax.xml.xpath.XPathFunctionResolver;
import javax.xml.xpath.XPathVariableResolver;

public abstract class AbstractXPathFactory extends XPathFactory
{
    /**
     * Per - factory resolver.
     */
    protected XPathVariableResolver variableResolver;
    /**
     * Per - factory resolver.
     */
    protected XPathFunctionResolver functionResolver;
    /**
     * Whether secure processing is on.
     */
    protected boolean secure;
    
    /**
     * Subclasses only constructor
     */
    protected AbstractXPathFactory()
    {
        // subclasses only constructor
    }
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPathFactory#getFeature(java.lang.String)
     */
    public boolean getFeature(final String name) throws XPathFactoryConfigurationException
    {
        if (name.equals(XMLConstants.FEATURE_SECURE_PROCESSING))
        {
            return this.secure;
        }
        else throw new  XPathFactoryConfigurationException("Unsupported feature:" + name);
    }
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPathFactory#setFeature(java.lang.String, boolean)
     */
    public void setFeature(final String name, final boolean arg1) throws XPathFactoryConfigurationException
    {
        if (name.equals(XMLConstants.FEATURE_SECURE_PROCESSING))
        {
            this.secure = arg1;
        }
        else throw new XPathFactoryConfigurationException("Unsupported feature:" + name);
    }
    
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPathFactory#setXPathFunctionResolver(javax.xml.xpath.XPathFunctionResolver)
     */
    public void setXPathFunctionResolver(final XPathFunctionResolver obj)
    {
        this.functionResolver = obj;
    }
    /*
     * (non-Javadoc)
     * @see javax.xml.xpath.XPathFactory#setXPathVariableResolver(javax.xml.xpath.XPathVariableResolver)
     */
    public void setXPathVariableResolver(final XPathVariableResolver obj)
    {
        this.variableResolver = obj;
    }
    

    

}