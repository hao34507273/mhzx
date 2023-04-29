/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class PointRaceReturnOriginalObserver
/*    */   extends Observer
/*    */ {
/*    */   private final int zoneid;
/* 11 */   private final List<Long> roleids = new ArrayList();
/*    */   
/*    */   private final int activityCfgid;
/*    */   private final int timePointCfgid;
/*    */   private final PointRaceCorpsInfo corpsInfo;
/*    */   private final int pvps;
/*    */   
/*    */   public PointRaceReturnOriginalObserver(long intervalSeconds, int zoneid, List<Long> roleids, int activityCfgid, int timePointCfgid, PointRaceCorpsInfo corpsInfo, int pvps)
/*    */   {
/* 20 */     super(intervalSeconds);
/* 21 */     this.zoneid = zoneid;
/* 22 */     this.roleids.addAll(roleids);
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.timePointCfgid = timePointCfgid;
/* 25 */     this.corpsInfo = corpsInfo;
/* 26 */     this.pvps = pvps;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 32 */     new PPointRaceReturnOriginal(this.zoneid, this.roleids, this.activityCfgid, this.timePointCfgid, this.corpsInfo, this.pvps).execute();
/*    */     
/* 34 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceReturnOriginalObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */