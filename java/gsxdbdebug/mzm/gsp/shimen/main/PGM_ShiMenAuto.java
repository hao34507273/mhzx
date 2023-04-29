/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PGM_ShiMenAuto extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   
/*    */   public PGM_ShiMenAuto(long targetRoleId, long gmRoleId)
/*    */   {
/* 14 */     this.targetRoleId = targetRoleId;
/* 15 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.targetRoleId);
/* 22 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/* 23 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.targetRoleId)));
/* 24 */     boolean ret = ShimenInterface.autoFinishShiMen(userId, this.targetRoleId);
/* 25 */     if (!ret)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "一键完成师门任务失败");
/* 28 */       return false;
/*    */     }
/* 30 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "一键完成师门任务成功");
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\PGM_ShiMenAuto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */