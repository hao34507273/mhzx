/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.confbean.AddCfgBean;
/*     */ import mzm.gsp.award.confbean.AwardBuffCfg;
/*     */ import mzm.gsp.award.confbean.SAddModEffect;
/*     */ import mzm.gsp.award.confbean.SBuffEffectCfg;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.buff.main.ProfitResult;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PBuffEffect
/*     */ {
/*  23 */   static Map<Integer, Map<Integer, Map<Integer, Integer>>> awardAddCfg = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getConIds(int sAddEffId, int awardType)
/*     */   {
/*  34 */     Map<Integer, Map<Integer, Integer>> awardTypeMap = (Map)awardAddCfg.get(Integer.valueOf(sAddEffId));
/*  35 */     if (awardTypeMap == null)
/*     */     {
/*  37 */       return new HashMap();
/*     */     }
/*  39 */     Map<Integer, Integer> effMap = (Map)awardTypeMap.get(Integer.valueOf(awardType));
/*  40 */     if (effMap == null)
/*     */     {
/*  42 */       return new HashMap();
/*     */     }
/*  44 */     return effMap;
/*     */   }
/*     */   
/*     */   static ConValue getConIdsValue(long roleId, int buffNeedType, Map<Integer, Integer> conIds)
/*     */   {
/*  49 */     if ((conIds == null) || (conIds.size() == 0))
/*     */     {
/*  51 */       return null;
/*     */     }
/*  53 */     ProfitResult res = BuffInterface.getProfitEffect(roleId, buffNeedType, new HashSet(conIds.values()));
/*  54 */     ConValue conValue = new ConValue();
/*  55 */     conValue.setRes(res, conIds);
/*  56 */     return conValue;
/*     */   }
/*     */   
/*     */   static void init()
/*     */   {
/*  61 */     for (SAddModEffect each : SAddModEffect.getAll().values())
/*     */     {
/*  63 */       getEachAwardTypeAddCfg(each.id);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void getEachAwardTypeAddCfg(int addEffCfgId)
/*     */   {
/*  70 */     for (int awardType = 1; awardType < 26; awardType++)
/*     */     {
/*  72 */       Map<Integer, Integer> conIds = getConIdsOfAwardType(addEffCfgId, awardType);
/*  73 */       if ((conIds != null) && (conIds.size() != 0))
/*     */       {
/*     */ 
/*     */ 
/*  77 */         Map<Integer, Map<Integer, Integer>> awardTypeMap = (Map)awardAddCfg.get(Integer.valueOf(addEffCfgId));
/*  78 */         if (awardTypeMap == null)
/*     */         {
/*  80 */           awardTypeMap = new HashMap();
/*  81 */           awardAddCfg.put(Integer.valueOf(addEffCfgId), awardTypeMap);
/*     */         }
/*  83 */         awardTypeMap.put(Integer.valueOf(awardType), conIds);
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
/*     */   private static Map<Integer, Integer> getConIdsOfAwardType(int sAddEffId, int awardType)
/*     */   {
/*  96 */     Map<Integer, Integer> conIds = new HashMap();
/*  97 */     SAddModEffect addModEffCfg = SAddModEffect.get(sAddEffId);
/*  98 */     if (addModEffCfg == null)
/*     */     {
/*     */ 
/* 101 */       return conIds;
/*     */     }
/* 103 */     List<AwardBuffCfg> buffAddCfgs = addModEffCfg.AwardBuffCfgList;
/* 104 */     for (AwardBuffCfg buffAddCfg : buffAddCfgs)
/*     */     {
/* 106 */       int conId = getAwardTypeConId(buffAddCfg.buffEffId, awardType);
/* 107 */       if (conId > 0)
/*     */       {
/*     */ 
/*     */ 
/* 111 */         conIds.put(Integer.valueOf(buffAddCfg.awardBuffType), Integer.valueOf(conId)); }
/*     */     }
/* 113 */     return conIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getAwardTypeConId(int sBuffEffId, int awardType)
/*     */   {
/* 125 */     SBuffEffectCfg buffEffectCfg = SBuffEffectCfg.get(sBuffEffId);
/* 126 */     if (buffEffectCfg == null)
/*     */     {
/* 128 */       return -1;
/*     */     }
/* 130 */     List<AddCfgBean> addCfgBeans = buffEffectCfg.addCfgBeanList;
/* 131 */     for (AddCfgBean each : addCfgBeans)
/*     */     {
/* 133 */       if ((each.awardType == awardType) && 
/*     */       
/*     */ 
/*     */ 
/* 137 */         (each.isEff))
/*     */       {
/*     */ 
/*     */ 
/* 141 */         return each.effConId; }
/*     */     }
/* 143 */     return 0;
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
/*     */   static Map<Integer, Integer> getAwardType2ConId(int sBuffEffId)
/*     */   {
/* 157 */     Map<Integer, Integer> awardType2ConId = new HashMap();
/* 158 */     SBuffEffectCfg buffEffectCfg = SBuffEffectCfg.get(sBuffEffId);
/* 159 */     if (buffEffectCfg == null)
/*     */     {
/* 161 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 163 */         GameServer.logger().debug(String.format("[award]PBuffEffect.getAwardType2ConId@ no sBuffEffId 2 cfgData!|sBuffEffId=%d", new Object[] { Integer.valueOf(sBuffEffId) }));
/*     */       }
/*     */       
/*     */ 
/* 167 */       return awardType2ConId;
/*     */     }
/* 169 */     for (AddCfgBean each : buffEffectCfg.addCfgBeanList)
/*     */     {
/* 171 */       if (each.isEff)
/*     */       {
/* 173 */         awardType2ConId.put(Integer.valueOf(each.awardType), Integer.valueOf(each.effConId));
/*     */       }
/*     */     }
/* 176 */     return awardType2ConId;
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
/*     */   static Map<Integer, Set<Integer>> getAwardType2ConIds(Set<Integer> sBuffEffIds)
/*     */   {
/* 190 */     Map<Integer, Set<Integer>> awardType2ConIds = new HashMap();
/* 191 */     if ((sBuffEffIds == null) || (sBuffEffIds.size() == 0))
/*     */     {
/* 193 */       return awardType2ConIds;
/*     */     }
/* 195 */     for (Iterator i$ = sBuffEffIds.iterator(); i$.hasNext();) { int sBuffEffId = ((Integer)i$.next()).intValue();
/*     */       
/* 197 */       SBuffEffectCfg buffEffectCfg = SBuffEffectCfg.get(sBuffEffId);
/* 198 */       if (buffEffectCfg == null)
/*     */       {
/* 200 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/* 202 */           GameServer.logger().debug(String.format("[award]PBuffEffect.getAwardType2ConId@ no sBuffEffId 2 cfgData!|sBuffEffId=%d", new Object[] { Integer.valueOf(sBuffEffId) }));
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/* 208 */         for (AddCfgBean each : buffEffectCfg.addCfgBeanList)
/*     */         {
/* 210 */           if (each.isEff)
/*     */           {
/*     */ 
/*     */ 
/* 214 */             Set<Integer> conIds = (Set)awardType2ConIds.get(Integer.valueOf(each.awardType));
/* 215 */             if (conIds == null)
/*     */             {
/* 217 */               conIds = new HashSet();
/* 218 */               awardType2ConIds.put(Integer.valueOf(each.awardType), conIds);
/*     */             }
/* 220 */             conIds.add(Integer.valueOf(each.effConId));
/*     */           } }
/*     */     }
/* 223 */     return awardType2ConIds;
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
/*     */ 
/*     */   static boolean calBuffAdd(int addModifyCnfId, long roleId, AwardAddParam addParam, int awardType, int buffNeedType)
/*     */   {
/* 238 */     Map<Integer, Integer> conIds = getConIds(addModifyCnfId, awardType);
/* 239 */     if ((conIds == null) || (conIds.size() == 0))
/*     */     {
/* 241 */       return true;
/*     */     }
/* 243 */     ConValue conValue = getConIdsValue(roleId, buffNeedType, conIds);
/* 244 */     if (conValue == null)
/*     */     {
/* 246 */       return true;
/*     */     }
/* 248 */     if (conValue.isZero())
/*     */     {
/* 250 */       return false;
/*     */     }
/* 252 */     for (Iterator i$ = conIds.keySet().iterator(); i$.hasNext();) { int buffType = ((Integer)i$.next()).intValue();
/*     */       
/* 254 */       double value = conValue.getBuffTypeValue(buffType);
/* 255 */       if (value > 0.0D)
/*     */       {
/*     */ 
/*     */ 
/* 259 */         addParam.addAllAddParam(value);
/* 260 */         recordAddMsg(addParam, buffType, value);
/*     */       }
/*     */     }
/* 263 */     recordBuffIdAdd(addParam, conValue);
/*     */     
/* 265 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void recordBuffIdAdd(AwardAddParam addParam, ConValue conValue)
/*     */   {
/* 276 */     Set<Integer> addBuffIds = conValue.getAllAddBuffId();
/* 277 */     if (addBuffIds.size() == 0)
/*     */     {
/* 279 */       return;
/*     */     }
/* 281 */     for (Iterator i$ = addBuffIds.iterator(); i$.hasNext();) { int buffId = ((Integer)i$.next()).intValue();
/*     */       
/* 283 */       int addType = BuffAwardTipRegManager.getBuffType(buffId);
/* 284 */       if (addType >= 0)
/*     */       {
/*     */ 
/*     */ 
/* 288 */         double v = conValue.getBuffIdValue(buffId);
/* 289 */         if (v > 0.0D)
/*     */         {
/*     */ 
/*     */ 
/* 293 */           addParam.addAddType2Num(addType, v);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void recordAddMsg(AwardAddParam addParam, int buffType, double addRet)
/*     */   {
/* 306 */     if (buffType == 1)
/*     */     {
/* 308 */       addParam.addAddType2Num(3, addRet);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PBuffEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */