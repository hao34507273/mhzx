/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class ReportCorpsFightValueObserver extends Observer
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public ReportCorpsFightValueObserver(long intervalSeconds, int activityCfgid)
/*    */   {
/* 12 */     super(intervalSeconds);
/* 13 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 19 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PReportCorpsFightValue(this.activityCfgid, false));
/*    */     
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\ReportCorpsFightValueObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */