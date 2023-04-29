/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PUpdatePointRaceCorps extends LogicProcedure
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int timePointCfgid;
/*    */   private final PointRaceCorpsInfo corpsInfo;
/*    */   
/*    */   public PUpdatePointRaceCorps(int activityCfgid, int timePointCfgid, PointRaceCorpsInfo corpsInfo)
/*    */   {
/* 13 */     this.activityCfgid = activityCfgid;
/* 14 */     this.timePointCfgid = timePointCfgid;
/* 15 */     this.corpsInfo = corpsInfo;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return CrossBattlePointManager.updatePointRaceCorps(this.activityCfgid, this.timePointCfgid, this.corpsInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PUpdatePointRaceCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */