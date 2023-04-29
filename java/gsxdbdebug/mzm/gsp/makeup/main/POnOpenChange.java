/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.SMakeUpActivityCfg;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.GlobalMakeUpInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     for (Iterator i$ = getSwitchActivityIds().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*    */       
/* 24 */       handEachActivity(activityId);
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private Set<Integer> getSwitchActivityIds()
/*    */   {
/* 36 */     Set<Integer> activityIds = new HashSet();
/* 37 */     for (SMakeUpActivityCfg cfg : SMakeUpActivityCfg.getAll().values())
/*    */     {
/* 39 */       if (cfg.switchId == ((OpenChangeComplexArg)this.arg).getType())
/*    */       {
/* 41 */         activityIds.add(Integer.valueOf(cfg.activityId));
/*    */       }
/*    */     }
/* 44 */     return activityIds;
/*    */   }
/*    */   
/*    */   private void handEachActivity(int activityId)
/*    */   {
/* 49 */     SMakeUpActivityCfg cfg = SMakeUpActivityCfg.get(activityId);
/* 50 */     if (cfg == null)
/*    */     {
/* 52 */       MakeUpManager.loggerError("StartQuestion.processImp@SMakeUpActivityCfg is null!|activityId=%d", new Object[] { Integer.valueOf(activityId) });
/* 53 */       return;
/*    */     }
/* 55 */     if (!ActivityInterface.isActivityOpen(activityId))
/*    */     {
/* 57 */       return;
/*    */     }
/* 59 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 61 */       MakeUpManager.reStartMakeup(activityId, cfg);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 66 */       GlobalMakeUpInfo xGlobalMakeupInfo = MakeUpManager.getGlobalMakeupInfo(activityId);
/* 67 */       if (xGlobalMakeupInfo == null)
/*    */       {
/* 69 */         return;
/*    */       }
/* 71 */       if ((xGlobalMakeupInfo.getTurn() >= cfg.turn) || (!OpenInterface.getOpenStatus(cfg.switchId)))
/*    */       {
/*    */ 
/* 74 */         MakeUpObserverManager.getInstance().stopObserver(activityId);
/*    */         
/* 76 */         xGlobalMakeupInfo.setQuetioning(false);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */