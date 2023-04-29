/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.JailProtectInfo;
/*    */ import xtable.Role2jailprotect;
/*    */ 
/*    */ 
/*    */ public class PGM_ClearJailProtect
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   
/*    */   public PGM_ClearJailProtect(long targetRoleId, long gmRoleId)
/*    */   {
/* 19 */     this.targetRoleId = targetRoleId;
/* 20 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     JailProtectInfo xJailProtectInfo = Role2jailprotect.get(Long.valueOf(this.targetRoleId));
/* 27 */     if (xJailProtectInfo == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     Session.removeSession(xJailProtectInfo.getSessionid(), this.targetRoleId);
/* 32 */     RoleStatusInterface.unsetStatus(this.targetRoleId, 1662);
/* 33 */     Role2jailprotect.remove(Long.valueOf(this.targetRoleId));
/* 34 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "清除出狱保护状态成功");
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PGM_ClearJailProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */