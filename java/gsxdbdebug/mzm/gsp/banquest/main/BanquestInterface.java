/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
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
/*    */ public class BanquestInterface
/*    */ {
/*    */   public static boolean isHoldBanquesting(long roleId)
/*    */   {
/* 18 */     return RoleStatusInterface.containsStatus(roleId, 35);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\BanquestInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */