/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class ReportCVCObserver extends Observer
/*    */ {
/*    */   private final long worldid;
/*    */   
/*    */   public ReportCVCObserver(long intervalSeconds, long worldid)
/*    */   {
/* 13 */     super(intervalSeconds);
/* 14 */     this.worldid = worldid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 20 */     Executor.getInstance().execute(new RReportCVC(this.worldid));
/* 21 */     setIntervalSeconds(TimeUnit.MINUTES.toSeconds(2L));
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\ReportCVCObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */