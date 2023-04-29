/*    */ package mzm.gsp.task.surprise;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import xbean.GlobalSurpriseScheduleInfo;
/*    */ import xbean.SurpriseScheduleInfo;
/*    */ import xtable.Surpriseschedule;
/*    */ 
/*    */ public class RoleCheckSurpriseGraph
/*    */ {
/*    */   static boolean checkRoleSurpriseSchedule(long roleId)
/*    */   {
/* 14 */     SurpriseScheduleInfo xSurpriseScheduleInfo = Surpriseschedule.get(Long.valueOf(roleId));
/* 15 */     if (xSurpriseScheduleInfo == null)
/*    */     {
/* 17 */       Surpriseschedule.insert(Long.valueOf(roleId), xSurpriseScheduleInfo = xbean.Pod.newSurpriseScheduleInfo());
/*    */     }
/*    */     
/* 20 */     GlobalSurpriseScheduleInfo xGlobalSurpriseScheduleInfo = xtable.Globalsurpriseschedule.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 21 */     if (xGlobalSurpriseScheduleInfo == null)
/*    */     {
/*    */ 
/* 24 */       return false;
/*    */     }
/* 26 */     Set<Integer> newGraphIds = new HashSet();
/* 27 */     Set<Integer> needRmGraphIds = new HashSet();
/*    */     
/* 29 */     getDiffGraphIds(xGlobalSurpriseScheduleInfo.getOpenedgraphids(), xSurpriseScheduleInfo.getOpenedgraphids(), newGraphIds, needRmGraphIds);
/*    */     
/*    */ 
/* 32 */     removeSelfExtraGraph(xSurpriseScheduleInfo, needRmGraphIds);
/*    */     
/* 34 */     SurpriseScheduleManager.newGraphNotice(roleId, newGraphIds);
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static void removeSelfExtraGraph(SurpriseScheduleInfo xSurpriseScheduleInfo, Set<Integer> needRmGraphIds)
/*    */   {
/* 46 */     if (needRmGraphIds.isEmpty())
/*    */     {
/* 48 */       return;
/*    */     }
/* 50 */     xSurpriseScheduleInfo.getOpenedgraphids().removeAll(needRmGraphIds);
/*    */   }
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
/*    */   private static void getDiffGraphIds(Set<Integer> globalGraphIds, Set<Integer> selfGraphIds, Set<Integer> newGraphIds, Set<Integer> needRmGraphIds)
/*    */   {
/* 64 */     if (globalGraphIds.isEmpty())
/*    */     {
/* 66 */       needRmGraphIds.addAll(selfGraphIds);
/* 67 */       return;
/*    */     }
/* 69 */     if (selfGraphIds.isEmpty())
/*    */     {
/* 71 */       newGraphIds.addAll(globalGraphIds);
/* 72 */       return;
/*    */     }
/* 74 */     needRmGraphIds.addAll(selfGraphIds);
/* 75 */     for (Iterator i$ = globalGraphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*    */       
/* 77 */       if (selfGraphIds.contains(Integer.valueOf(graphId)))
/*    */       {
/* 79 */         needRmGraphIds.remove(Integer.valueOf(graphId));
/*    */       }
/*    */       else {
/* 82 */         newGraphIds.add(Integer.valueOf(graphId));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\RoleCheckSurpriseGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */