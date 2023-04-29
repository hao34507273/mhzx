/*    */ package mzm.gsp.confConverter;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class XMLFileFilter
/*    */   implements FileFilter
/*    */ {
/*    */   private String name;
/*    */   
/*    */   public XMLFileFilter(String name)
/*    */   {
/* 28 */     this.name = name;
/*    */   }
/*    */   
/*    */   public boolean filter(File file)
/*    */   {
/* 33 */     return file.getName().endsWith(this.name);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confConverter\XMLFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */