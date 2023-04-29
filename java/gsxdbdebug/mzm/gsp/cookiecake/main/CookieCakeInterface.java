/*    */ package mzm.gsp.cookiecake.main;
/*    */ 
/*    */ import mzm.gsp.midautumnholiday.confbean.SCreateCostInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CookieCakeInterface
/*    */ {
/*    */   public static boolean createItem(long roleid, SCreateCostInfo sCreateCostInfo, int createNum)
/*    */   {
/* 16 */     return CookieCakeManager.createItem(roleid, sCreateCostInfo, createNum);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cookiecake\main\CookieCakeInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */