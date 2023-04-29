/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RReportCVC extends LogicRunnable
/*    */ {
/*    */   private final long worldid;
/*    */   
/*    */   public RReportCVC(long worldid)
/*    */   {
/* 11 */     this.worldid = worldid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 17 */     CrossBattlePointManager.reportPointRaceCorpsCVC(this.worldid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\RReportCVC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */