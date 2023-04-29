/*    */ package mzm.gsp.sensitive.main;
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
/*    */ public class SensitiveInterface
/*    */ {
/*    */   public static boolean isNameSensitive(String name)
/*    */   {
/* 19 */     return SensitiveManager.getInstance().isNameSensitive(name);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isContentSensitive(String content)
/*    */   {
/* 31 */     return SensitiveManager.getInstance().isContentSensitive(content);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sensitive\main\SensitiveInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */