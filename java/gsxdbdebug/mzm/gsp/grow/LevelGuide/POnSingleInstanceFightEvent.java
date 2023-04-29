/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.instance.event.SingleFightArg;
/*    */ import mzm.gsp.instance.event.SingleInstanceFightEventProcedure;
/*    */ import mzm.gsp.instance.main.InstanceInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.Pair;
/*    */ 
/*    */ public class POnSingleInstanceFightEvent extends SingleInstanceFightEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (!((SingleFightArg)this.arg).win)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     for (Iterator i$ = getNeedCheckInstanceCfgIds(((SingleFightArg)this.arg).instancecfgid).iterator(); i$.hasNext();) { final int instanceId = ((Integer)i$.next()).intValue();
/*    */       
/* 24 */       xdb.Procedure.execute(new LogicProcedure()
/*    */       {
/*    */ 
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 30 */           return LevelGuideManager.finishActivity(((SingleFightArg)POnSingleInstanceFightEvent.this.arg).roleid, instanceId);
/*    */         }
/*    */       });
/*    */     }
/*    */     
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   private Set<Integer> getNeedCheckInstanceCfgIds(int instanceCfgId)
/*    */   {
/* 40 */     Map<Integer, Pair<Integer, Integer>> allInstanceInfos = InstanceInterface.getAllSingleInstanceLevelLimit();
/* 41 */     Pair<Integer, Integer> nowInstanceInfo = (Pair)allInstanceInfos.get(Integer.valueOf(instanceCfgId));
/* 42 */     if (nowInstanceInfo == null)
/*    */     {
/* 44 */       return Collections.emptySet();
/*    */     }
/* 46 */     Set<Integer> needCheckInstanceIds = new java.util.HashSet();
/* 47 */     for (Map.Entry<Integer, Pair<Integer, Integer>> entry : allInstanceInfos.entrySet())
/*    */     {
/* 49 */       int tmpOpenLevel = ((Integer)((Pair)entry.getValue()).first).intValue();
/* 50 */       if ((tmpOpenLevel <= ((Integer)nowInstanceInfo.first).intValue()) && (
/*    */       
/*    */ 
/*    */ 
/* 54 */         (tmpOpenLevel != ((Integer)nowInstanceInfo.first).intValue()) || (((Integer)entry.getKey()).intValue() == instanceCfgId)))
/*    */       {
/*    */ 
/*    */ 
/* 58 */         needCheckInstanceIds.add(entry.getKey()); }
/*    */     }
/* 60 */     return needCheckInstanceIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnSingleInstanceFightEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */