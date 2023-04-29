/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity2.confbean.SVisibleMonsterSwitchCfg;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public class ROnOpenChange extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 13 */     int idipModuleSwitchId = ((OpenChangeComplexArg)this.arg).getType();
/* 14 */     SVisibleMonsterSwitchCfg sVisibleMonsterSwitchCfg = SVisibleMonsterSwitchCfg.get(idipModuleSwitchId);
/* 15 */     if (sVisibleMonsterSwitchCfg == null)
/*    */     {
/* 17 */       return;
/*    */     }
/* 19 */     int activityCfgId = sVisibleMonsterSwitchCfg.activity_cfg_id;
/* 20 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 21 */     long startTime = ActivityInterface.getActivityStartTime(activityCfgId);
/* 22 */     long endTime = ActivityInterface.getActivityEndTime(activityCfgId);
/*    */     
/* 24 */     if ((startTime > now) || (now > endTime))
/*    */     {
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 30 */     if (isOpen)
/*    */     {
/* 32 */       VisibleMonsterActivityHandler.startActivity(activityCfgId);
/*    */     }
/*    */     else
/*    */     {
/* 36 */       VisibleMonsterActivityHandler.stopActivity(activityCfgId);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */