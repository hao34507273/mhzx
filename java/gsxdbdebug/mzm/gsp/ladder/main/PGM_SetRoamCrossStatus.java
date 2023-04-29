/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetRoamCrossStatus extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_SetRoamCrossStatus(long gmRoleid, long roleid)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     boolean ret = RoleStatusInterface.setStatus(this.roleid, 44, true);
/* 21 */     if (ret) {
/* 22 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "设置中心服状态成功");
/*    */     } else {
/* 24 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "设置中心服状态失败");
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PGM_SetRoamCrossStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */