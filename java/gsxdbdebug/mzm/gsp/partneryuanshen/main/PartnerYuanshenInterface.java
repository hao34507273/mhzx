/*     */ package mzm.gsp.partneryuanshen.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.PartnerYuanshenPositionInfo;
/*     */ 
/*     */ 
/*     */ public class PartnerYuanshenInterface
/*     */ {
/*     */   public static Map<Integer, Integer> getPartnerExtraPropertyRatioMap(long roleId, int partnerId)
/*     */   {
/*  18 */     if (PartnerYuanshenManager.isNotEnable())
/*     */     {
/*  20 */       return new HashMap();
/*     */     }
/*  22 */     Map<Integer, PartnerYuanshenPositionInfo> yuanshenInfoMap = PartnerYuanshenManager.getPartnerYuanshenPositionInfoMap(roleId, true);
/*     */     
/*  24 */     if (yuanshenInfoMap == null)
/*     */     {
/*  26 */       return new HashMap();
/*     */     }
/*  28 */     for (Map.Entry<Integer, PartnerYuanshenPositionInfo> entry : yuanshenInfoMap.entrySet())
/*     */     {
/*  30 */       if (((PartnerYuanshenPositionInfo)entry.getValue()).getAttached_partner_id() == partnerId)
/*     */       {
/*  32 */         return PartnerYuanshenManager.getExtraPropertyRatioMap(((Integer)entry.getKey()).intValue(), ((PartnerYuanshenPositionInfo)entry.getValue()).getLevel(), ((PartnerYuanshenPositionInfo)entry.getValue()).getProperty_num());
/*     */       }
/*     */     }
/*     */     
/*  36 */     return new HashMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getFightScoreFromPartnerYuanshen(long roleId, boolean holdLock)
/*     */   {
/*  44 */     if (PartnerYuanshenManager.isNotEnable())
/*     */     {
/*  46 */       return 0;
/*     */     }
/*  48 */     return PartnerYuanshenManager.getFightScoreFromPartnerYuanshen(roleId, holdLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getPartnerYuanshenLevelSortedByImprovement(long roleId, int _sort, boolean holdLock)
/*     */   {
/*  57 */     int MAX_POSITION = 6;
/*  58 */     int MAX_PROPERTY_NUM_PER_LEVEL = 10;
/*     */     int sort;
/*  60 */     int sort; if (_sort < 1) {
/*  61 */       sort = 1; } else { int sort;
/*  62 */       if (_sort > 6) {
/*  63 */         sort = 6;
/*     */       } else
/*  65 */         sort = _sort;
/*     */     }
/*  67 */     Map<Integer, PartnerYuanshenPositionInfo> xPositionInfoMap = PartnerYuanshenManager.getPartnerYuanshenPositionInfoMap(roleId, holdLock);
/*     */     
/*  69 */     if (xPositionInfoMap == null) {
/*  70 */       return 0;
/*     */     }
/*     */     
/*  73 */     List<Pair<Integer, Integer>> list = new ArrayList(6);
/*  74 */     for (int i = 1; i <= 6; i++)
/*     */     {
/*  76 */       PartnerYuanshenPositionInfo xPositionInfo = (PartnerYuanshenPositionInfo)xPositionInfoMap.get(Integer.valueOf(i));
/*  77 */       if (xPositionInfo == null)
/*     */       {
/*  79 */         list.add(new Pair(Integer.valueOf(i), Integer.valueOf(0)));
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*  84 */       else if (xPositionInfo.getProperty_num() >= 10)
/*     */       {
/*  86 */         list.add(new Pair(Integer.valueOf(i), Integer.valueOf(xPositionInfo.getLevel())));
/*     */       }
/*     */       else
/*     */       {
/*  90 */         list.add(new Pair(Integer.valueOf(i), Integer.valueOf(xPositionInfo.getLevel() - 1)));
/*     */       }
/*     */     }
/*     */     
/*  94 */     Collections.sort(list, new Comparator()
/*     */     {
/*     */ 
/*     */       public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2)
/*     */       {
/*  99 */         if (((Integer)o1.second).intValue() > ((Integer)o2.second).intValue())
/* 100 */           return -1;
/* 101 */         if (((Integer)o1.second).intValue() < ((Integer)o2.second).intValue())
/* 102 */           return 1;
/* 103 */         return 0;
/*     */       }
/* 105 */     });
/* 106 */     return ((Integer)((Pair)list.get(sort - 1)).second).intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\main\PartnerYuanshenInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */