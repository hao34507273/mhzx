/*    */ package mzm.gsp.crossbattle.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleStageDurationCfg;
/*    */ import mzm.gsp.timeflow.main.TimeFlowManager;
/*    */ import mzm.gsp.timeflow.main.TimeFlowType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossBattleManager
/*    */ {
/*    */   static void init()
/*    */   {
/* 23 */     for (Iterator i$ = SCrossBattleOwnCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 25 */       SActivityCfg activityCfg = ActivityInterface.getActivityCfg(activityCfgid);
/* 26 */       if (activityCfg != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 32 */         SCrossBattleStageDurationCfg stageDurationCfg = SCrossBattleStageDurationCfg.get(activityCfgid);
/* 33 */         if (stageDurationCfg == null)
/*    */         {
/* 35 */           throw new RuntimeException(String.format("[crossbattle]CrossBattleManager.init@stage duration cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*    */         }
/*    */         
/*    */ 
/* 39 */         long activityStartTimestamp = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/* 40 */         long activityEndTimestamp = TimeCommonUtil.getLimitTimeEnd(activityCfg.activityLimitTimeid);
/* 41 */         List<Long> steps = Arrays.asList(new Long[] { Long.valueOf(activityStartTimestamp + stageDurationCfg.registerStageDurationInDay * 86400000L), Long.valueOf(activityStartTimestamp + (stageDurationCfg.registerStageDurationInDay + stageDurationCfg.voteStageDurationInDay) * 86400000L), Long.valueOf(activityStartTimestamp + (stageDurationCfg.registerStageDurationInDay + stageDurationCfg.voteStageDurationInDay + stageDurationCfg.roundRobinStageDurationInDay) * 86400000L), Long.valueOf(activityStartTimestamp + (stageDurationCfg.registerStageDurationInDay + stageDurationCfg.voteStageDurationInDay + stageDurationCfg.roundRobinStageDurationInDay + stageDurationCfg.zoneDivideStageDurationInDay) * 86400000L), Long.valueOf(activityStartTimestamp + (stageDurationCfg.registerStageDurationInDay + stageDurationCfg.voteStageDurationInDay + stageDurationCfg.roundRobinStageDurationInDay + stageDurationCfg.zoneDivideStageDurationInDay + stageDurationCfg.zonePointStageDurationInDay) * 86400000L), Long.valueOf(activityStartTimestamp + (stageDurationCfg.registerStageDurationInDay + stageDurationCfg.voteStageDurationInDay + stageDurationCfg.roundRobinStageDurationInDay + stageDurationCfg.zoneDivideStageDurationInDay + stageDurationCfg.zonePointStageDurationInDay + stageDurationCfg.roundSelectionStageDurationInDay) * 86400000L) });
/*    */         
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 64 */         TimeFlowManager.getInstance().addTimeFlow(TimeFlowType.ACTIVITY, activityCfgid, activityEndTimestamp, steps);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\main\CrossBattleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */