/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RefreshMonsterObserver
/*    */   extends Observer
/*    */ {
/*    */   private final long worldid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public RefreshMonsterObserver(long worldid, int activityCfgid)
/*    */   {
/* 20 */     super(SWorldGoalCfg.get(activityCfgid).monster_refresh_interval);
/* 21 */     this.worldid = worldid;
/* 22 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 28 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(this.activityCfgid);
/* 29 */     if (cfg.monster_controller_id > 0)
/*    */     {
/* 31 */       ControllerInterface.collectController(cfg.monster_controller_id);
/* 32 */       ControllerInterface.triggerOrReSpawn(this.worldid, cfg.monster_controller_id);
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\RefreshMonsterObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */