/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_QueryReportCrossBattleOwnResultInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PGM_QueryReportCrossBattleOwnResultInfo(long gmRoleid, int activityCfgid)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     QueryResult result = CrossBattleOwnManager.queryReportCrossBattleOwnResultInfoByIdip(this.activityCfgid);
/* 25 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("查询是否已经上报跨服战本服阶段结果|%s", new Object[] { result.desc }));
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PGM_QueryReportCrossBattleOwnResultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */