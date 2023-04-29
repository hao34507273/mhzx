/*    */ package mzm.gsp.tlog;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.w3c.dom.Element;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ class TLogStruct
/*    */ {
/* 11 */   private String structName = "";
/* 12 */   private boolean secidip = false;
/* 13 */   private List<String> columnList = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */   TLogStruct(Node node)
/*    */   {
/* 19 */     Element element = (Element)node;
/*    */     
/*    */     try
/*    */     {
/* 23 */       this.structName = element.getAttribute("name");
/*    */       
/* 25 */       String strSecidip = element.getAttribute("secidip");
/* 26 */       this.secidip = (strSecidip == null ? false : strSecidip.equals("true"));
/*    */       
/* 28 */       NodeList nodeList = element.getElementsByTagName("entry");
/* 29 */       for (int i = 0; i < nodeList.getLength(); i++) {
/* 30 */         Element entryNode = (Element)nodeList.item(i);
/* 31 */         String columnName = entryNode.getAttribute("name");
/* 32 */         this.columnList.add(columnName);
/*    */       }
/*    */     }
/*    */     catch (Exception e) {
/* 36 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getStructName()
/*    */   {
/* 45 */     return this.structName;
/*    */   }
/*    */   
/*    */   public List<String> getColumnList()
/*    */   {
/* 50 */     return this.columnList;
/*    */   }
/*    */   
/*    */   public boolean isSecIdip() {
/* 54 */     return this.secidip;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tlog\TLogStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */