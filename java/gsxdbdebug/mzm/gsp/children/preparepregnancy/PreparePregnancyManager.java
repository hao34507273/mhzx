/*    */ package mzm.gsp.children.preparepregnancy;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
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
/*    */ public class PreparePregnancyManager
/*    */ {
/* 17 */   static Logger logger = Logger.getLogger("prepare_pregnancy");
/*    */   
/*    */   static void init()
/*    */   {
/* 21 */     PreparePregnancyActivityHandler handler = new PreparePregnancyActivityHandler();
/* 22 */     ActivityInterface.registerActivityByLogicType(70, handler);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isPreparePregnancySwitchOpenForRole(long roleid)
/*    */   {
/* 33 */     if (!OpenInterface.getOpenStatus(211))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (OpenInterface.isBanPlay(roleid, 211))
/*    */     {
/* 39 */       OpenInterface.sendBanPlayMsg(roleid, 211);
/* 40 */       return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean checkRoleStatus(long roleid, int status)
/*    */   {
/* 53 */     return RoleStatusInterface.checkCanSetStatus(roleid, status, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\PreparePregnancyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */