/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.buff.main.ProfitArg;
/*     */ import mzm.gsp.buff.main.ProfitResult;
/*     */ 
/*     */ 
/*     */ public class ConValue
/*     */ {
/*     */   boolean zero;
/*     */   Map<Integer, BuffAddInfo> values;
/*     */   private Map<Integer, BuffAddInfo> buffId2AddInfo;
/*     */   ProfitResult res;
/*  19 */   private static int WAN = 10000;
/*     */   
/*     */   public ConValue()
/*     */   {
/*  23 */     this.zero = false;
/*  24 */     this.values = new HashMap();
/*  25 */     this.buffId2AddInfo = new HashMap();
/*     */   }
/*     */   
/*     */   public boolean isZero()
/*     */   {
/*  30 */     return this.zero;
/*     */   }
/*     */   
/*     */   public void setZero(boolean zero)
/*     */   {
/*  35 */     this.zero = zero;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, BuffAddInfo> getBuffIdAddInfo()
/*     */   {
/*  45 */     return new HashMap(this.buffId2AddInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getAllAddBuffId()
/*     */   {
/*  55 */     if (this.buffId2AddInfo.size() == 0)
/*     */     {
/*  57 */       return new HashSet();
/*     */     }
/*  59 */     return this.buffId2AddInfo.keySet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   double getBuffTypeValue(int buffType)
/*     */   {
/*  70 */     BuffAddInfo addInfo = (BuffAddInfo)this.values.get(Integer.valueOf(buffType));
/*  71 */     if (addInfo == null)
/*     */     {
/*  73 */       return -1.0D;
/*     */     }
/*     */     
/*  76 */     return addInfo.getFinalRate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   double getBuffIdValue(int buffId)
/*     */   {
/*  87 */     BuffAddInfo addInfo = (BuffAddInfo)this.buffId2AddInfo.get(Integer.valueOf(buffId));
/*  88 */     if (addInfo == null)
/*     */     {
/*  90 */       return -1.0D;
/*     */     }
/*     */     
/*  93 */     return addInfo.getFinalRate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRes(ProfitResult res, Map<Integer, Integer> conIds)
/*     */   {
/* 104 */     this.res = res;
/* 105 */     this.zero = res.isZeroProfit();
/* 106 */     if (this.zero)
/*     */     {
/* 108 */       return;
/*     */     }
/* 110 */     Map<Integer, Integer> conId2buffType = getConId2buffType(conIds);
/* 111 */     Set<ProfitArg> rates = res.getRateList();
/* 112 */     if ((rates == null) || (rates.size() == 0))
/*     */     {
/* 114 */       return;
/*     */     }
/* 116 */     for (ProfitArg each : rates)
/*     */     {
/*     */ 
/* 119 */       this.buffId2AddInfo.put(Integer.valueOf(each.getBuffId()), new BuffAddInfo(each.getValue(), each.getNTimes()));
/*     */       
/* 121 */       int type = getAwardBuffType(conId2buffType, each.getConditionId());
/* 122 */       if (type >= 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 127 */         this.values.put(Integer.valueOf(type), new BuffAddInfo(each.getValue(), each.getNTimes()));
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
/*     */   int getAwardBuffType(Map<Integer, Integer> conId2buffType, int conId)
/*     */   {
/* 140 */     Integer buffType = (Integer)conId2buffType.get(Integer.valueOf(conId));
/* 141 */     if (buffType == null)
/*     */     {
/* 143 */       return -1;
/*     */     }
/* 145 */     return buffType.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Integer, Integer> getConId2buffType(Map<Integer, Integer> conIds)
/*     */   {
/* 156 */     Map<Integer, Integer> conId2buffType = new HashMap();
/* 157 */     Iterator<Map.Entry<Integer, Integer>> it = conIds.entrySet().iterator();
/* 158 */     while (it.hasNext())
/*     */     {
/* 160 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 161 */       conId2buffType.put(entry.getValue(), entry.getKey());
/*     */     }
/* 163 */     return conId2buffType;
/*     */   }
/*     */   
/*     */   class BuffAddInfo
/*     */   {
/*     */     private int value;
/*     */     private int nRate;
/*     */     
/*     */     public BuffAddInfo(int value, int nRate)
/*     */     {
/* 173 */       this.value = value;
/* 174 */       this.nRate = nRate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     double getFinalRate()
/*     */     {
/* 185 */       return this.value / ConValue.WAN * (this.nRate / ConValue.WAN);
/*     */     }
/*     */     
/*     */     int getValue()
/*     */     {
/* 190 */       return this.value;
/*     */     }
/*     */     
/*     */     void setValue(int value)
/*     */     {
/* 195 */       this.value = value;
/*     */     }
/*     */     
/*     */     int getnRate()
/*     */     {
/* 200 */       return this.nRate;
/*     */     }
/*     */     
/*     */     void setnRate(int nRate)
/*     */     {
/* 205 */       this.nRate = nRate;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\ConValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */