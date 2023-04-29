/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.award.confbean.STAwardGemCfgIds;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AwarGiftInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Award2countinfo;
/*     */ import xtable.Awardgift;
/*     */ import xtable.Gem2countinfo;
/*     */ import xtable.Role2drop;
/*     */ import xtable.Role2xawardinfo;
/*     */ 
/*     */ public class AwardMerge
/*     */   implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  31 */     List<Table> tables = new ArrayList();
/*     */     
/*  33 */     tables.add(Award2countinfo.getTable());
/*  34 */     tables.add(Gem2countinfo.getTable());
/*  35 */     tables.add(Role2xawardinfo.getTable());
/*  36 */     tables.add(Awardgift.getTable());
/*  37 */     tables.add(Role2drop.getTable());
/*     */     
/*  39 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  45 */     if (!new AwardXTimeMerge(null).call())
/*     */     {
/*  47 */       MergeMain.logger().error(String.format("[AwardMerge]AwardMerge.handleMerge@ AwardXTimeMerge err!", new Object[0]));
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!new AwardGemMerge(null).call())
/*     */     {
/*  53 */       MergeMain.logger().error(String.format("[AwardMerge]AwardMerge.handleMerge@ AwardGemMerge err!", new Object[0]));
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   private class AwardXTimeMerge extends LogicProcedure
/*     */   {
/*     */     private AwardXTimeMerge() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  66 */       long mainKey = MergeMain.getMainZoneid();
/*  67 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  69 */       lock(Awardgift.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  71 */       AwarGiftInfo xViceGiftInfo = Awardgift.get(Long.valueOf(viceKey));
/*     */       
/*  73 */       if (xViceGiftInfo == null)
/*     */       {
/*  75 */         MergeMain.logger().warn("AwardXTimeMerge.processImp@vice record null");
/*  76 */         return true;
/*     */       }
/*     */       
/*  79 */       AwarGiftInfo xMainGiftInfo = Awardgift.get(Long.valueOf(mainKey));
/*  80 */       if (xMainGiftInfo == null)
/*     */       {
/*  82 */         MergeMain.logger().warn("AwardXTimeMerge.processImp@vice record is not null but main record is null");
/*  83 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  87 */       Map<Integer, Integer> mainTypeInfo = xMainGiftInfo.getType2global();
/*  88 */       Map<Integer, Integer> viceTypeInfo = xViceGiftInfo.getType2global();
/*  89 */       Map<Integer, Integer> finalTypeInfo = new HashMap();
/*  90 */       Iterator<Map.Entry<Integer, Integer>> it = mainTypeInfo.entrySet().iterator();
/*  91 */       while (it.hasNext())
/*     */       {
/*  93 */         Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/*  94 */         int useType = ((Integer)entry.getKey()).intValue();
/*  95 */         int mainGlobal = ((Integer)entry.getValue()).intValue();
/*     */         
/*  97 */         Integer viceGlobal = (Integer)viceTypeInfo.get(Integer.valueOf(useType));
/*  98 */         if (viceGlobal == null)
/*     */         {
/* 100 */           MergeMain.logger().error(String.format("AwardXTimeMerge.processImp@vice type data is null|type=%d", new Object[] { Integer.valueOf(useType) }));
/*     */           
/* 102 */           return false;
/*     */         }
/*     */         
/* 105 */         int finalGlobal = Math.max(mainGlobal, viceGlobal.intValue());
/* 106 */         finalTypeInfo.put(Integer.valueOf(useType), Integer.valueOf(finalGlobal));
/*     */       }
/* 108 */       xMainGiftInfo.getType2global().clear();
/* 109 */       xMainGiftInfo.getType2global().putAll(finalTypeInfo);
/*     */       
/*     */ 
/* 112 */       Awardgift.remove(Long.valueOf(viceKey));
/*     */       
/* 114 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private class AwardGemMerge
/*     */     extends LogicProcedure
/*     */   {
/*     */     private AwardGemMerge() {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 132 */       Set<Long> mainGemKeys = new HashSet();
/* 133 */       Set<Long> viceGemKeys = new HashSet();
/*     */       
/* 135 */       fillGemKeys(mainGemKeys, viceGemKeys);
/* 136 */       List<Long> totalKeys = getAllGemKeys(mainGemKeys, viceGemKeys);
/*     */       
/*     */ 
/* 139 */       lock(Gem2countinfo.getTable(), totalKeys);
/*     */       
/*     */ 
/* 142 */       rmXData(viceGemKeys);
/*     */       
/* 144 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private List<Long> getAllGemKeys(Set<Long> mainGemKeys, Set<Long> viceGemKeys)
/*     */     {
/* 156 */       List<Long> totalKeys = new ArrayList(mainGemKeys.size() + viceGemKeys.size());
/* 157 */       totalKeys.addAll(mainGemKeys);
/* 158 */       totalKeys.addAll(viceGemKeys);
/* 159 */       return totalKeys;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void fillGemKeys(Set<Long> mainGemKeys, Set<Long> viceGemKeys)
/*     */     {
/* 170 */       for (Iterator i$ = STAwardGemCfgIds.getAll().keySet().iterator(); i$.hasNext();) { int gemCfgId = ((Integer)i$.next()).intValue();
/*     */         
/* 172 */         long mainKey = GameServerInfoManager.toGlobalId(gemCfgId, MergeMain.getMainZoneid());
/* 173 */         mainGemKeys.add(Long.valueOf(mainKey));
/* 174 */         long viceKey = GameServerInfoManager.toGlobalId(gemCfgId, MergeMain.getViceZoneid());
/* 175 */         viceGemKeys.add(Long.valueOf(viceKey));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void rmXData(Set<Long> gemKeys)
/*     */     {
/* 186 */       if ((gemKeys == null) || (gemKeys.size() == 0))
/*     */       {
/* 188 */         return;
/*     */       }
/* 190 */       for (Iterator i$ = gemKeys.iterator(); i$.hasNext();) { long gemKey = ((Long)i$.next()).longValue();
/*     */         
/* 192 */         Gem2countinfo.remove(Long.valueOf(gemKey));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\AwardMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */