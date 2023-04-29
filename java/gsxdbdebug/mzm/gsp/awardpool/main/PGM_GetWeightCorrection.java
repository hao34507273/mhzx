/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ import java.util.NavigableMap;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*    */ import mzm.gsp.awardpool.confbean.SRandomTextTableCfg;
/*    */ import mzm.gsp.awardpool.confbean.SWeightCorrectionCfg;
/*    */ import mzm.gsp.awardpool.confbean.SWeightCorrectionTypeCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.WeightCorrectionCounter;
/*    */ 
/*    */ public class PGM_GetWeightCorrection extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int weightCorrectionType;
/*    */   private final int itemSubId;
/*    */   
/*    */   public PGM_GetWeightCorrection(long roleId, int weightCorrectionType, int itemSubId)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.weightCorrectionType = weightCorrectionType;
/* 25 */     this.itemSubId = itemSubId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */   {
/* 31 */     if (!OpenInterface.getOpenStatus(380))
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.roleId, "功能开关未打开");
/* 34 */       return false;
/*    */     }
/* 36 */     SWeightCorrectionTypeCfg sWeightCorrectionTypeCfg = SWeightCorrectionTypeCfg.get(this.weightCorrectionType);
/* 37 */     if (null == sWeightCorrectionTypeCfg)
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.roleId, "第一个参数错误：权重修正类不存在");
/* 40 */       return false;
/*    */     }
/* 42 */     WeightCorrectionCounter xCounter = WeightCorrectionManager.getRefreshedWeightCorrectionCounter(this.roleId, sWeightCorrectionTypeCfg);
/*    */     
/* 44 */     int currentCount = xCounter.getCount();
/* 45 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("权重修正类 %d，当前次数为 %d", new Object[] { Integer.valueOf(this.weightCorrectionType), Integer.valueOf(currentCount) }));
/*    */     
/*    */ 
/*    */ 
/* 49 */     if (this.itemSubId == 0)
/*    */     {
/*    */ 
/* 52 */       return true; }
/*    */     int weightCorrectionCfgId;
/*    */     int weightCorrectionCfgId;
/* 55 */     if (null != SRandomTextTableCfg.get(this.itemSubId))
/*    */     {
/* 57 */       SRandomTextTableCfg sRandomTextTableCfg = SRandomTextTableCfg.get(this.itemSubId);
/* 58 */       weightCorrectionCfgId = sRandomTextTableCfg.weightCorrectionCfgId;
/*    */     } else { int weightCorrectionCfgId;
/* 60 */       if (null != SItemPoolSub.get(this.itemSubId))
/*    */       {
/* 62 */         SItemPoolSub sItemPoolSub = SItemPoolSub.get(this.itemSubId);
/* 63 */         weightCorrectionCfgId = sItemPoolSub.weightCorrectionCfgId;
/*    */       }
/*    */       else
/*    */       {
/* 67 */         weightCorrectionCfgId = this.itemSubId;
/*    */       } }
/* 69 */     if (weightCorrectionCfgId == 0)
/*    */     {
/* 71 */       GmManager.getInstance().sendResultToGM(this.roleId, "权重修正次数配置参数错误");
/* 72 */       return false;
/*    */     }
/* 74 */     SWeightCorrectionCfg weightCorrectionCfg = SWeightCorrectionCfg.get(weightCorrectionCfgId);
/* 75 */     if (weightCorrectionCfg == null)
/*    */     {
/* 77 */       GmManager.getInstance().sendResultToGM(this.roleId, "权重修正次数配置参数错误");
/* 78 */       return false;
/*    */     }
/* 80 */     NavigableMap<Integer, Integer> count2WeightMap = new TreeMap();
/* 81 */     count2WeightMap.putAll(weightCorrectionCfg.count2WeightMap);
/* 82 */     int currectedWeight = ((Integer)count2WeightMap.floorEntry(Integer.valueOf(currentCount)).getValue()).intValue();
/* 83 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("修正后权重为：%d", new Object[] { Integer.valueOf(currectedWeight) }));
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\PGM_GetWeightCorrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */