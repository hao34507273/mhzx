/*    */ package mzm.gsp.timeflow.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.TimeFlowInfo;
/*    */ import xbean.TimeFlowInfos;
/*    */ import xdb.Table;
/*    */ import xtable.Timeflows;
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
/*    */ public class TimeFlowModule
/*    */   implements Module, PostModuleInitListner, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 39 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 45 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 51 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 57 */     TimeFlowManager.getInstance().onPostInit();
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 63 */     List<Table> tables = new ArrayList();
/* 64 */     tables.add(Timeflows.getTable());
/*    */     
/* 66 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 72 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 77 */         List<Long> allKeys = new ArrayList();
/* 78 */         List<Long> mainKeys = new ArrayList();
/* 79 */         List<Long> viceKeys = new ArrayList();
/* 80 */         long mainZoneid = MergeMain.getMainZoneid();
/* 81 */         long viceZoneid = MergeMain.getViceZoneid();
/* 82 */         for (TimeFlowType type : TimeFlowType.values())
/*    */         {
/* 84 */           long mainKey = GameServerInfoManager.toGlobalId(type.ordinal(), mainZoneid);
/* 85 */           allKeys.add(Long.valueOf(mainKey));
/* 86 */           mainKeys.add(Long.valueOf(mainKey));
/*    */           
/* 88 */           long viceKey = GameServerInfoManager.toGlobalId(type.ordinal(), viceZoneid);
/* 89 */           allKeys.add(Long.valueOf(viceKey));
/* 90 */           viceKeys.add(Long.valueOf(viceKey));
/*    */         }
/* 92 */         lock(Timeflows.getTable(), allKeys);
/*    */         
/* 94 */         int size = mainKeys.size();
/* 95 */         TimeFlowInfos xMainTimeFlowInfos; for (int i = 0; i < size; i++)
/*    */         {
/* 97 */           long viceKey = ((Long)viceKeys.get(i)).longValue();
/* 98 */           TimeFlowInfos xViceTimeFlowInfos = Timeflows.get(Long.valueOf(viceKey));
/* 99 */           if (xViceTimeFlowInfos != null)
/*    */           {
/*    */ 
/*    */ 
/*    */ 
/* :4 */             long mainKey = ((Long)mainKeys.get(i)).longValue();
/* :5 */             xMainTimeFlowInfos = Timeflows.get(Long.valueOf(mainKey));
/* :6 */             if (xMainTimeFlowInfos == null)
/*    */             {
/* :8 */               Timeflows.add(Long.valueOf(mainKey), xViceTimeFlowInfos.copy());
/*    */             }
/*    */             else
/*    */             {
/* ;2 */               for (Map.Entry<Integer, TimeFlowInfo> entry : xViceTimeFlowInfos.getFlows().entrySet())
/*    */               {
/* ;4 */                 int subType = ((Integer)entry.getKey()).intValue();
/* ;5 */                 TimeFlowInfo xViceTimeFlowInfo = (TimeFlowInfo)entry.getValue();
/*    */                 
/* ;7 */                 TimeFlowInfo xMainTimeFlowInfo = (TimeFlowInfo)xMainTimeFlowInfos.getFlows().get(Integer.valueOf(subType));
/* ;8 */                 if (xMainTimeFlowInfo == null)
/*    */                 {
/* <0 */                   xMainTimeFlowInfos.getFlows().put(Integer.valueOf(subType), xViceTimeFlowInfo.copy());
/*    */                 }
/*    */                 else
/*    */                 {
/* <4 */                   xMainTimeFlowInfo.setStep(Math.max(xMainTimeFlowInfo.getStep(), xViceTimeFlowInfo.getStep())); }
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/* <9 */         for (Long viceKey : viceKeys)
/*    */         {
/* =1 */           Timeflows.remove(viceKey);
/*    */         }
/*    */         
/* =4 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timeflow\main\TimeFlowModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */