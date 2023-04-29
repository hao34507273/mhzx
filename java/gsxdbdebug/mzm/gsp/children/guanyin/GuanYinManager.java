/*    */ package mzm.gsp.children.guanyin;
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
/*    */ public class GuanYinManager
/*    */ {
/* 17 */   static Logger logger = Logger.getLogger("guanyin");
/*    */   
/*    */   static void init()
/*    */   {
/* 21 */     ActivityInterface.registerActivityByLogicType(71, new GuanYinShangGongActivityHandler());
/*    */     
/* 23 */     ActivityInterface.registerActivityByLogicType(72, new GuanYinQiuQianActivityHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isGuanYinQiuQianSwitchOpenForRole(long roleid)
/*    */   {
/* 34 */     if (!OpenInterface.getOpenStatus(216))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (OpenInterface.isBanPlay(roleid, 216))
/*    */     {
/* 40 */       OpenInterface.sendBanPlayMsg(roleid, 216);
/* 41 */       return false;
/*    */     }
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isGuanYinShangGongSwitchOpenForRole(long roleid)
/*    */   {
/* 54 */     if (!OpenInterface.getOpenStatus(215))
/*    */     {
/* 56 */       return false;
/*    */     }
/* 58 */     if (OpenInterface.isBanPlay(roleid, 215))
/*    */     {
/* 60 */       OpenInterface.sendBanPlayMsg(roleid, 215);
/* 61 */       return false;
/*    */     }
/* 63 */     return true;
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
/* 74 */     return RoleStatusInterface.checkCanSetStatus(roleid, status, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\guanyin\GuanYinManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */