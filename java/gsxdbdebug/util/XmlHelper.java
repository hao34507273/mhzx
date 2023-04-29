/*    */ package util;
/*    */ 
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class XmlHelper {
/*    */   public static org.dom4j.Element getVariableElement(org.dom4j.Element rootElement, String varName) {
/*  7 */     return rootElement.element(varName);
/*    */   }
/*    */   
/*    */   public static org.w3c.dom.Element getVariableElement(org.w3c.dom.Element rootElement, String varName)
/*    */   {
/* 12 */     org.w3c.dom.Element retElement = null;
/* 13 */     NodeList nodeList = rootElement.getChildNodes();
/* 14 */     int len = nodeList.getLength();
/* 15 */     for (int i = 0; i < len; i++)
/*    */     {
/* 17 */       org.w3c.dom.Node node = nodeList.item(i);
/*    */       
/* 19 */       if (node.getNodeType() == 1)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 24 */         org.w3c.dom.Element elem = (org.w3c.dom.Element)node;
/* 25 */         if (elem.getNodeName().equalsIgnoreCase(varName))
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 30 */           retElement = elem;
/* 31 */           break;
/*    */         }
/*    */       } }
/* 34 */     return retElement;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\util\XmlHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */