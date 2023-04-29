/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.Module;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GlobalVisibleMonsterInfo;
/*     */ import xbean.VisibleMonsterInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Role2visiblemonster;
/*     */ import xtable.Visiblemonster;
/*     */ 
/*     */ public class VisibleMonsterFightModule implements Module, PostModuleInitListner, MergeModule
/*     */ {
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*     */     try
/*     */     {
/*  25 */       VisibleMonsterFightManager.getInstance().init();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  29 */       e.printStackTrace();
/*  30 */       return -1;
/*     */     }
/*  32 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/*  38 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/*  44 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/*  50 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void postInit()
/*     */   {
/*  56 */     VisibleMonsterFightManager.getInstance().postInit();
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  62 */     return Arrays.asList(new Table[] { Visiblemonster.getTable(), Role2visiblemonster.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  68 */     new PVisibleMonsterMerge(null).call();
/*  69 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class PVisibleMonsterMerge
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  80 */       long mainZoneId = MergeMain.getMainZoneid();
/*  81 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/*  83 */       lock(Visiblemonster.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainZoneId), Long.valueOf(viceZoneId) }));
/*     */       
/*  85 */       GlobalVisibleMonsterInfo xViceGlobalVisibleMonsterInfo = Visiblemonster.get(Long.valueOf(viceZoneId));
/*  86 */       if (xViceGlobalVisibleMonsterInfo == null)
/*     */       {
/*  88 */         return true;
/*     */       }
/*     */       
/*  91 */       GlobalVisibleMonsterInfo xMainGlobalVisibleMonsterInfo = Visiblemonster.get(Long.valueOf(mainZoneId));
/*  92 */       if (xMainGlobalVisibleMonsterInfo == null)
/*     */       {
/*  94 */         Visiblemonster.add(Long.valueOf(mainZoneId), xViceGlobalVisibleMonsterInfo.copy());
/*  95 */         Visiblemonster.remove(Long.valueOf(viceZoneId));
/*  96 */         return true;
/*     */       }
/*     */       
/*  99 */       Map<Integer, VisibleMonsterInfo> xMainGlobalVisibleMonsterInfoMap = xMainGlobalVisibleMonsterInfo.getActivity_visible_monster_map();
/* 100 */       Map<Integer, VisibleMonsterInfo> xViceGlobalVisibleMonsterInfoMap = xViceGlobalVisibleMonsterInfo.getActivity_visible_monster_map();
/* 101 */       for (Map.Entry<Integer, VisibleMonsterInfo> entry : xMainGlobalVisibleMonsterInfoMap.entrySet())
/*     */       {
/* 103 */         int activityCfgId = ((Integer)entry.getKey()).intValue();
/* 104 */         VisibleMonsterInfo xMainVisibleMonsterInfo = (VisibleMonsterInfo)entry.getValue();
/*     */         
/* 106 */         VisibleMonsterInfo xViceVisibleMonsterInfo = (VisibleMonsterInfo)xViceGlobalVisibleMonsterInfoMap.get(Integer.valueOf(activityCfgId));
/* 107 */         if (xViceVisibleMonsterInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 112 */           Map<Integer, Integer> xMainTypeMap = xMainVisibleMonsterInfo.getMonster_type_times_map();
/* 113 */           Map<Integer, Integer> xViceTypeMap = xViceVisibleMonsterInfo.getMonster_type_times_map();
/*     */           
/* 115 */           Map<Integer, Integer> tempMap = new HashMap();
/* 116 */           for (Map.Entry<Integer, Integer> entry2 : xMainTypeMap.entrySet())
/*     */           {
/* 118 */             int xMainType = ((Integer)entry2.getKey()).intValue();
/* 119 */             int xMainTimes = ((Integer)entry2.getValue()).intValue();
/*     */             
/* 121 */             Integer xViceTimes = (Integer)xViceTypeMap.get(Integer.valueOf(xMainType));
/* 122 */             if (xViceTimes != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 127 */               if (xViceTimes.intValue() > xMainTimes)
/*     */               {
/* 129 */                 tempMap.put(Integer.valueOf(xMainType), xViceTimes);
/*     */               }
/*     */             }
/*     */           }
/* 133 */           xMainTypeMap.putAll(tempMap);
/*     */         }
/*     */       }
/* 136 */       Visiblemonster.remove(Long.valueOf(viceZoneId));
/* 137 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\VisibleMonsterFightModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */