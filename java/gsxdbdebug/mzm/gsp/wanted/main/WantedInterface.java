/*    */ package mzm.gsp.wanted.main;
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
/*    */ public class WantedInterface
/*    */ {
/*    */   public static boolean isHongMing(long roleId)
/*    */   {
/* 16 */     return WantedManager.isHongMing(roleId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void removeRoleWantedInfo(long roleId)
/*    */     throws Exception
/*    */   {
/* 27 */     WantedPageManager.getInstance().deleteRecord(Long.valueOf(roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void addRoleWantedInfo(long roleId)
/*    */     throws Exception
/*    */   {
/* 38 */     WantedPageManager.getInstance().addRecord(Long.valueOf(roleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\WantedInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */