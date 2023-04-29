/*    */ package mzm.gsp.multicommontask.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity3.confbean.SMultiLineTaskCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 23 */     Map<Integer, SMultiLineTaskCfg> cfgs = getActivityCfgs(((OpenChangeComplexArg)this.arg).getType());
/* 24 */     if ((cfgs == null) || (cfgs.size() == 0))
/*    */     {
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     handControllers(getAllControllers(cfgs));
/*    */   }
/*    */   
/*    */   private Map<Integer, SMultiLineTaskCfg> getActivityCfgs(int openId)
/*    */   {
/* 34 */     Set<Integer> activityIds = MultiTaskManager.getActivityIdsBy(openId);
/* 35 */     if ((activityIds == null) || (activityIds.size() == 0))
/*    */     {
/* 37 */       return null;
/*    */     }
/* 39 */     Map<Integer, SMultiLineTaskCfg> cfgs = new HashMap();
/* 40 */     for (Iterator i$ = activityIds.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*    */       
/* 42 */       SMultiLineTaskCfg cfg = SMultiLineTaskCfg.get(activityId);
/* 43 */       if (cfg != null)
/*    */       {
/*    */ 
/*    */ 
/* 47 */         cfgs.put(Integer.valueOf(activityId), cfg); }
/*    */     }
/* 49 */     return cfgs;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private Map<Integer, Integer> getAllControllers(Map<Integer, SMultiLineTaskCfg> cfgs)
/*    */   {
/* 60 */     Map<Integer, Integer> activityId2ControllerId = new HashMap();
/* 61 */     for (Map.Entry<Integer, SMultiLineTaskCfg> entry : cfgs.entrySet())
/*    */     {
/* 63 */       activityId2ControllerId.put(entry.getKey(), Integer.valueOf(((SMultiLineTaskCfg)entry.getValue()).controller));
/*    */     }
/* 65 */     return activityId2ControllerId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void handControllers(Map<Integer, Integer> allControllerIds)
/*    */   {
/* 75 */     if ((allControllerIds == null) || (allControllerIds.size() == 0))
/*    */     {
/* 77 */       return;
/*    */     }
/* 79 */     for (Map.Entry<Integer, Integer> entry : allControllerIds.entrySet())
/*    */     {
/* 81 */       int controllerId = ((Integer)entry.getValue()).intValue();
/* 82 */       if ((((OpenChangeComplexArg)this.arg).isOpen()) && (ActivityInterface.isActivityOpen(((Integer)entry.getKey()).intValue())))
/*    */       {
/*    */ 
/* 85 */         ControllerInterface.triggerController(controllerId);
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 90 */         ControllerInterface.collectController(controllerId);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multicommontask\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */