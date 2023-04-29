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
/*    */ public class RefreshItemObserver
/*    */   extends Observer
/*    */ {
/*    */   private final long worldid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public RefreshItemObserver(long worldid, int activityCfgid)
/*    */   {
/* 20 */     super(SWorldGoalCfg.get(activityCfgid).item_refresh_interval);
/* 21 */     this.worldid = worldid;
/* 22 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 28 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(this.activityCfgid);
/* 29 */     if (cfg.item_controller_id > 0)
/*    */     {
/* 31 */       ControllerInterface.collectController(cfg.item_controller_id);
/* 32 */       ControllerInterface.triggerWorldControllerWithMaxSpawnNum(this.worldid, cfg.item_controller_id, cfg.item_refresh_num);
/*    */     }
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\RefreshItemObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */