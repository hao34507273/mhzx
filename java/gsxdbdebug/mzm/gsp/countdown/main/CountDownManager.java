/*    */ package mzm.gsp.countdown.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CountDownManager
/*    */ {
/* 16 */   static Logger logger = Logger.getLogger("countdown");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isCountDownSwitchOpen()
/*    */   {
/* 25 */     if (!OpenInterface.getOpenStatus(172))
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isCountDownSwitchOpenForRole(long roleid, boolean isSendTips)
/*    */   {
/* 40 */     if (!OpenInterface.getOpenStatus(172))
/*    */     {
/* 42 */       if (isSendTips) {
/* 43 */         OpenInterface.sendCloseProtocol(roleid, 172, null);
/*    */       }
/* 45 */       return false;
/*    */     }
/* 47 */     if (OpenInterface.isBanPlay(roleid, 172))
/*    */     {
/* 49 */       if (isSendTips)
/* 50 */         OpenInterface.sendBanPlayMsg(roleid, 172);
/* 51 */       return false;
/*    */     }
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean checkRoleStatus(long roleid)
/*    */   {
/* 64 */     return RoleStatusInterface.checkCanSetStatus(roleid, 71, false);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\CountDownManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */