/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ClearCrossBattleOwnResult
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PGM_ClearCrossBattleOwnResult(long gmRoleid, int activityCfgid)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     ClearResult result = CrossBattleOwnManager.clearCrossBattleOwnResultByIdip(this.activityCfgid);
/* 25 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("清除跨服战本服阶段结果|%s", new Object[] { result.desc }));
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PGM_ClearCrossBattleOwnResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */