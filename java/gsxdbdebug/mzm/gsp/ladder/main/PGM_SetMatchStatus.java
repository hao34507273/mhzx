/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetMatchStatus extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_SetMatchStatus(long gmRoleid, long roleid)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     boolean ret = RoleStatusInterface.setStatus(this.roleid, 42, true);
/* 21 */     if (ret) {
/* 22 */       ret = RoleStatusInterface.setStatus(this.roleid, 40, true);
/*    */     }
/* 24 */     if (ret) {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "设置天梯匹配状态成功");
/*    */     } else {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "设置天梯匹配状态失败");
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PGM_SetMatchStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */