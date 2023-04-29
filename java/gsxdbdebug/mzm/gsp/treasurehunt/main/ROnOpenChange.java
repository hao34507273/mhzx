/*    */ package mzm.gsp.treasurehunt.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.treasurehunt.confbean.STreasureHuntCfg;
/*    */ import mzm.gsp.treasurehunt.confbean.STreasureHuntSwitchCfg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public class ROnOpenChange extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 15 */     STreasureHuntSwitchCfg sTreasureHuntSwitchCfg = STreasureHuntSwitchCfg.get(((OpenChangeComplexArg)this.arg).getType());
/* 16 */     if (sTreasureHuntSwitchCfg == null)
/*    */     {
/* 18 */       return;
/*    */     }
/*    */     
/* 21 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 22 */     long startTime = ActivityInterface.getActivityLimitTimeBegin(sTreasureHuntSwitchCfg.activity_cfg_id);
/* 23 */     long endTime = ActivityInterface.getActivityLimitTimeEnd(sTreasureHuntSwitchCfg.activity_cfg_id);
/*    */     
/* 25 */     if ((startTime > now) || (now > endTime))
/*    */     {
/* 27 */       return;
/*    */     }
/*    */     
/* 30 */     STreasureHuntCfg sTreasureHuntCfg = STreasureHuntCfg.get(sTreasureHuntSwitchCfg.activity_cfg_id);
/* 31 */     if (sTreasureHuntCfg == null)
/*    */     {
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 37 */     if (isOpen)
/*    */     {
/*    */ 
/* 40 */       ControllerInterface.triggerController(sTreasureHuntCfg.npc_controller_id);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 45 */       ControllerInterface.collectController(sTreasureHuntCfg.npc_controller_id);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */