/*     */ package mzm.gsp.common;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.common.confbean.ProRatebean;
/*     */ import mzm.gsp.common.confbean.Range2weight;
/*     */ import mzm.gsp.common.confbean.SProRandomCountCfg;
/*     */ import mzm.gsp.common.confbean.SProRandomRangeCfg;
/*     */ import mzm.gsp.common.confbean.SProRandomValueCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class PropertyRandomUtil
/*     */ {
/*     */   private static final int TEN_THOUSAND = 10000;
/*  18 */   private static final Logger logger = Logger.getLogger(PropertyRandomUtil.class);
/*     */   
/*     */   public static final class KeyValuePair
/*     */   {
/*     */     private final int key;
/*     */     private final int value;
/*     */     
/*     */     public KeyValuePair(int key, int value) {
/*  26 */       this.value = value;
/*  27 */       this.key = key;
/*     */     }
/*     */     
/*     */     public int getKey() {
/*  31 */       return this.key;
/*     */     }
/*     */     
/*     */     public int getValue() {
/*  35 */       return this.value;
/*     */     }
/*     */   }
/*     */   
/*     */   static void init()
/*     */   {
/*  41 */     for (SProRandomValueCfg proRandomValueCfg : SProRandomValueCfg.getAll().values())
/*     */     {
/*  43 */       if (SProRandomRangeCfg.get(proRandomValueCfg.proRandomId) == null) {
/*  44 */         throw new RuntimeException("6003_属性数值表.xlsx 属性区间随机id不存在  id=" + proRandomValueCfg.id + " 属性随机id=" + proRandomValueCfg.proRandomId);
/*     */       }
/*  46 */       if (proRandomValueCfg.extraProMin > proRandomValueCfg.extraProMax) {
/*  47 */         throw new RuntimeException("6003_属性数值表.xlsx 附加属性值下限 大于附加属性值上限  id=" + proRandomValueCfg.id);
/*     */       }
/*     */     }
/*     */     
/*  51 */     for (SProRandomRangeCfg proRandomRangeCfg : SProRandomRangeCfg.getAll().values())
/*     */     {
/*  53 */       if ((proRandomRangeCfg.range2weights == null) || (proRandomRangeCfg.range2weights.size() == 0))
/*     */       {
/*  55 */         throw new RuntimeException("6008_附加属性区间概率表.xlsx 区间、权重不能为空 id=" + proRandomRangeCfg.id);
/*     */       }
/*     */       
/*  58 */       Range2weight rw = (Range2weight)proRandomRangeCfg.range2weights.get(0);
/*  59 */       int weight = rw.weight;
/*  60 */       for (int i = 1; i < proRandomRangeCfg.range2weights.size(); i++) {
/*  61 */         if (rw.range >= ((Range2weight)proRandomRangeCfg.range2weights.get(i)).range) {
/*  62 */           throw new RuntimeException("6008_附加属性区间概率表.xlsx 属性区间重叠 id=" + proRandomRangeCfg.id);
/*     */         }
/*  64 */         rw = (Range2weight)proRandomRangeCfg.range2weights.get(i);
/*  65 */         weight += rw.weight;
/*     */       }
/*  67 */       if ((rw.range != 10000) && 
/*  68 */         (weight <= 0)) {
/*  69 */         throw new RuntimeException("6008_附加属性区间概率表.xlsx 属性区间5必须为 10000 id=" + proRandomRangeCfg.id);
/*     */       }
/*     */       
/*  72 */       if (weight <= 0) {
/*  73 */         throw new RuntimeException("6008_附加属性区间概率表.xlsx 权重总和必须大于0 id=" + proRandomRangeCfg.id);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<KeyValuePair> randomPropertyList(int randomProCountId, int hunnum)
/*     */   {
/*  87 */     List<KeyValuePair> keyValuePairs = new ArrayList();
/*  88 */     SProRandomCountCfg sProRandomCountCfg = SProRandomCountCfg.get(randomProCountId);
/*     */     
/*  90 */     if (sProRandomCountCfg == null) {
/*  91 */       if (logger.isDebugEnabled())
/*  92 */         logger.debug("属性个数随机表中配置不存在id:" + randomProCountId);
/*  93 */       return keyValuePairs;
/*     */     }
/*  95 */     int totalweight = 0;
/*  96 */     for (ProRatebean proRatebean : sProRandomCountCfg.proRates)
/*  97 */       totalweight += proRatebean.proRate;
/*     */     int randomnum;
/*  99 */     int sum; for (int i = 0; i < hunnum; i++) {
/* 100 */       randomnum = Xdb.random().nextInt(totalweight);
/* 101 */       sum = 0;
/* 102 */       for (ProRatebean proRatebean : sProRandomCountCfg.proRates) {
/* 103 */         if (!isSelected(keyValuePairs, proRatebean.proCfgId))
/*     */         {
/*     */ 
/* 106 */           sum += proRatebean.proRate;
/* 107 */           if (randomnum < sum) {
/* 108 */             KeyValuePair keyValuePair = randomProperty(proRatebean.proCfgId);
/* 109 */             if (keyValuePair != null) {
/* 110 */               keyValuePairs.add(keyValuePair);
/*     */             }
/* 112 */             totalweight -= proRatebean.proRate;
/* 113 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 118 */     return keyValuePairs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<KeyValuePair> randomFixPropertyList(int randomProCountId, int hunnum)
/*     */   {
/* 129 */     List<KeyValuePair> keyValuePairs = new ArrayList();
/* 130 */     if (hunnum <= 0) {
/* 131 */       return keyValuePairs;
/*     */     }
/* 133 */     SProRandomCountCfg sProRandomCountCfg = SProRandomCountCfg.get(randomProCountId);
/*     */     
/* 135 */     if (sProRandomCountCfg == null) {
/* 136 */       if (logger.isDebugEnabled())
/* 137 */         logger.debug("属性个数随机表中配置不存在id:" + randomProCountId);
/* 138 */       return keyValuePairs;
/*     */     }
/*     */     
/* 141 */     for (ProRatebean proRatebean : sProRandomCountCfg.proRates)
/*     */     {
/* 143 */       if ((proRatebean.proRate > 0) && (keyValuePairs.size() < hunnum))
/*     */       {
/* 145 */         KeyValuePair keyValuePair = randomFixProperty(proRatebean.proCfgId);
/* 146 */         if (keyValuePair != null) {
/* 147 */           keyValuePairs.add(keyValuePair);
/*     */         }
/*     */       }
/*     */     }
/* 151 */     return keyValuePairs;
/*     */   }
/*     */   
/*     */   private static boolean isSelected(List<KeyValuePair> kvs, int id)
/*     */   {
/* 156 */     for (KeyValuePair kp : kvs) {
/* 157 */       if (kp.key == id) {
/* 158 */         return true;
/*     */       }
/*     */     }
/* 161 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private static KeyValuePair randomProperty(int proRandomId)
/*     */   {
/* 167 */     SProRandomValueCfg randomValueCfg = SProRandomValueCfg.get(proRandomId);
/* 168 */     if (randomValueCfg == null) {
/* 169 */       logger.error("6003_属性值表 中不存在id：" + proRandomId);
/* 170 */       return null;
/*     */     }
/* 172 */     SProRandomRangeCfg randomRangeCfg = SProRandomRangeCfg.get(randomValueCfg.proRandomId);
/* 173 */     if (randomRangeCfg == null) {
/* 174 */       logger.error("6008_附加属性区间概率表 中不存在id：" + randomValueCfg.proRandomId);
/* 175 */       return null;
/*     */     }
/* 177 */     int weight = 0;
/* 178 */     for (int i = 0; i < randomRangeCfg.range2weights.size(); i++) {
/* 179 */       weight += ((Range2weight)randomRangeCfg.range2weights.get(i)).weight;
/*     */     }
/* 181 */     int r = Xdb.random().nextInt(weight);
/* 182 */     int s = 0;
/* 183 */     int index = 0;
/* 184 */     for (int i = 0; i < randomRangeCfg.range2weights.size(); i++) {
/* 185 */       s += ((Range2weight)randomRangeCfg.range2weights.get(i)).weight;
/* 186 */       if (r < s) {
/* 187 */         index = i;
/* 188 */         break;
/*     */       }
/*     */     }
/* 191 */     if (index <= 0) {
/* 192 */       int result = Xdb.random().nextInt(((Range2weight)randomRangeCfg.range2weights.get(0)).range);
/*     */       
/* 194 */       KeyValuePair keyValuePair = new KeyValuePair(randomValueCfg.id, result);
/* 195 */       return keyValuePair;
/*     */     }
/*     */     
/* 198 */     int delta = ((Range2weight)randomRangeCfg.range2weights.get(index)).range - ((Range2weight)randomRangeCfg.range2weights.get(index - 1)).range;
/* 199 */     int result = ((Range2weight)randomRangeCfg.range2weights.get(index - 1)).range;
/* 200 */     if (delta > 0) {
/* 201 */       result += Xdb.random().nextInt(delta);
/*     */     }
/*     */     
/* 204 */     KeyValuePair keyValuePair = new KeyValuePair(randomValueCfg.id, result);
/* 205 */     return keyValuePair;
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
/*     */ 
/*     */   private static KeyValuePair randomFixProperty(int proRandomId)
/*     */   {
/* 219 */     SProRandomValueCfg randomValueCfg = SProRandomValueCfg.get(proRandomId);
/* 220 */     if (randomValueCfg == null) {
/* 221 */       logger.error("6003_属性值表 中不存在id：" + proRandomId);
/* 222 */       return null;
/*     */     }
/* 224 */     SProRandomRangeCfg randomRangeCfg = SProRandomRangeCfg.get(randomValueCfg.proRandomId);
/* 225 */     if (randomRangeCfg == null) {
/* 226 */       logger.error("6008_附加属性区间概率表 中不存在id：" + randomValueCfg.proRandomId);
/* 227 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 232 */     int index = 0;
/* 233 */     for (int i = 0; i < randomRangeCfg.range2weights.size(); i++)
/*     */     {
/* 235 */       if (((Range2weight)randomRangeCfg.range2weights.get(i)).weight > 0) {
/* 236 */         index = i;
/* 237 */         break;
/*     */       }
/*     */     }
/* 240 */     if (index <= 0) {
/* 241 */       int result = (((Range2weight)randomRangeCfg.range2weights.get(0)).range + 1) / 2;
/*     */       
/* 243 */       KeyValuePair keyValuePair = new KeyValuePair(randomValueCfg.id, result);
/* 244 */       return keyValuePair;
/*     */     }
/*     */     
/* 247 */     int delta = ((Range2weight)randomRangeCfg.range2weights.get(index)).range - ((Range2weight)randomRangeCfg.range2weights.get(index - 1)).range;
/* 248 */     int result = ((Range2weight)randomRangeCfg.range2weights.get(index - 1)).range;
/*     */     
/* 250 */     result += (delta + 1) / 2;
/*     */     
/*     */ 
/* 253 */     KeyValuePair keyValuePair = new KeyValuePair(randomValueCfg.id, result);
/* 254 */     return keyValuePair;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\PropertyRandomUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */