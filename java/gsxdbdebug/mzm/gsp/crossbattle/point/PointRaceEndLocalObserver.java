/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class PointRaceEndLocalObserver extends Observer
/*    */ {
/*    */   private final int activtyCfgid;
/*    */   private final int timePointCfgid;
/*    */   
/*    */   public PointRaceEndLocalObserver(long intervalSeconds, int activityCfgid, int timePointCfgid)
/*    */   {
/* 13 */     super(intervalSeconds);
/* 14 */     this.activtyCfgid = activityCfgid;
/* 15 */     this.timePointCfgid = timePointCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 21 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activtyCfgid), new PPointRaceCheck(this.activtyCfgid, this.timePointCfgid, true));
/*    */     
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceEndLocalObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */