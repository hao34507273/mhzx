/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalModuleidCfg;
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 20 */     if (!WorldGoalManager.postInitFlag)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 25 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 26 */     if ((type != 168) && (SWorldGoalModuleidCfg.get(type) == null))
/*    */     {
/* 28 */       return;
/*    */     }
/* 30 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 32 */     if (type == 168) { Iterator i$;
/*    */       Iterator i$;
/* 34 */       if (isOpen)
/*    */       {
/* 36 */         for (i$ = SWorldGoalCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*    */           
/* 38 */           if ((WorldGoalManager.isWorldGoalSwitchOpen(activityCfgid)) && 
/*    */           
/*    */ 
/*    */ 
/* 42 */             (ActivityInterface.getActivityLimitTimeStage(activityCfgid, now) == ActivityLimitTimeStageEnum.LIMIT_TIME_NOW))
/*    */           {
/*    */ 
/*    */ 
/* 46 */             new PInitActivityOnModuleOpen(activityCfgid).call();
/*    */           }
/*    */           
/*    */         }
/*    */       } else {
/* 51 */         for (i$ = SWorldGoalCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*    */           
/* 53 */           if ((OpenInterface.getOpenStatus(SWorldGoalCfg.get(activityCfgid).moduleid)) && 
/*    */           
/*    */ 
/*    */ 
/* 57 */             (ActivityInterface.getActivityLimitTimeStage(activityCfgid, now) == ActivityLimitTimeStageEnum.LIMIT_TIME_NOW))
/*    */           {
/*    */ 
/*    */ 
/* 61 */             new PStopActivityOnModuleClose(activityCfgid).call(); }
/*    */         }
/*    */       }
/* 64 */       return;
/*    */     }
/*    */     
/* 67 */     int activityCfgid = SWorldGoalModuleidCfg.get(type).activity_cfg_id;
/* 68 */     if (isOpen)
/*    */     {
/* 70 */       if (!WorldGoalManager.isWorldGoalSwitchOpen(168))
/*    */       {
/* 72 */         return;
/*    */       }
/* 74 */       if (ActivityInterface.getActivityLimitTimeStage(activityCfgid, now) != ActivityLimitTimeStageEnum.LIMIT_TIME_NOW)
/*    */       {
/* 76 */         return;
/*    */       }
/* 78 */       new PInitActivityOnModuleOpen(activityCfgid).call();
/*    */     }
/*    */     else
/*    */     {
/* 82 */       if (!OpenInterface.getOpenStatus(168))
/*    */       {
/* 84 */         return;
/*    */       }
/* 86 */       if (ActivityInterface.getActivityLimitTimeStage(activityCfgid, now) != ActivityLimitTimeStageEnum.LIMIT_TIME_NOW)
/*    */       {
/* 88 */         return;
/*    */       }
/* 90 */       new PStopActivityOnModuleClose(activityCfgid).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */