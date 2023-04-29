/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import xbean.CrossbattleDrawLots;
/*    */ 
/*    */ public class PReportFightValueDone extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PReportFightValueDone(int activityCfgid)
/*    */   {
/* 11 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     CrossbattleDrawLots xCrossbattleDrawLots = CrossBattlePointManager.getAndInitCrossbattleDrawLots(this.activityCfgid);
/* 18 */     xCrossbattleDrawLots.setReported(true);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PReportFightValueDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */