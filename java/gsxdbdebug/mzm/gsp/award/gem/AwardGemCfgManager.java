/*     */ package mzm.gsp.award.gem;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.confbean.STGemCfg;
/*     */ import mzm.gsp.award.confbean.STGemTable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AwardGemCfgManager
/*     */ {
/*     */   static Set<Integer> getAllGemAwardId()
/*     */   {
/*  31 */     return new HashSet(STGemCfg.getAll().keySet());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static STGemCfg getSTGemCfg(int awardId)
/*     */   {
/*  43 */     return STGemCfg.get(awardId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int ranOneItem(STGemTable cfg)
/*     */   {
/*  54 */     if (cfg == null)
/*     */     {
/*  56 */       GameServer.logger().error(String.format("[award]AwardCfgManager.ranOneItem@ cfg is null", new Object[0]));
/*  57 */       return -1;
/*     */     }
/*  59 */     int weightSum = cfg.weightSum;
/*  60 */     if (weightSum <= 0)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[award]AwardCfgManager.ranOneItem@ weightSum is illegal!|awardId=%d", new Object[] { Integer.valueOf(cfg.gemCfgId) }));
/*     */       
/*  64 */       return -1;
/*     */     }
/*     */     
/*  67 */     return ranOneItem(cfg.itemId2weight, weightSum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getCountUp(STGemCfg cfg, int alAwardNum)
/*     */   {
/*  80 */     return alAwardNum <= 0 ? cfg.littleCount : cfg.bigCount;
/*     */   }
/*     */   
/*     */   private static int ranOneItem(Map<Integer, Integer> itemId2weight, int weightSum)
/*     */   {
/*  85 */     Random random = Xdb.random();
/*  86 */     int ran = random.nextInt(weightSum);
/*     */     
/*  88 */     int sum = 0;
/*  89 */     Iterator<Map.Entry<Integer, Integer>> it = itemId2weight.entrySet().iterator();
/*     */     
/*  91 */     while (it.hasNext())
/*     */     {
/*  93 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/*  94 */       int itemId = ((Integer)entry.getKey()).intValue();
/*  95 */       int weight = ((Integer)entry.getValue()).intValue();
/*     */       
/*  97 */       sum += weight;
/*  98 */       if (sum > ran)
/*     */       {
/* 100 */         return itemId;
/*     */       }
/*     */     }
/* 103 */     GameServer.logger().error(String.format("[awardGem]AwardGemCfgManager.ranOneItem@ not ran item!|itemId2weight=%s|weightSum=%d", new Object[] { itemId2weight.toString(), Integer.valueOf(weightSum) }));
/*     */     
/*     */ 
/* 106 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\AwardGemCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */