/*     */ package mzm.gsp.tlog;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TLogArg
/*     */ {
/*  19 */   public long sequence = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public LogReason logReason;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int subReason;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  34 */   public Map<CurrencyType, Integer> currencytype2num = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  39 */   private Map<Integer, Integer> itemid2num = new HashMap();
/*     */   
/*     */   public TLogArg(LogReason logReason)
/*     */   {
/*  43 */     this(logReason, 0);
/*     */   }
/*     */   
/*     */   public TLogArg(LogReason logReason, int subReason)
/*     */   {
/*  48 */     this.logReason = logReason;
/*  49 */     this.subReason = subReason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public TLogArg() {}
/*     */   
/*     */ 
/*     */   public long getSequence()
/*     */   {
/*  59 */     return this.sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(long sequence)
/*     */   {
/*  64 */     this.sequence = sequence;
/*     */   }
/*     */   
/*     */   public LogReason getLogReason()
/*     */   {
/*  69 */     return this.logReason;
/*     */   }
/*     */   
/*     */   public void setLogReason(LogReason logReason)
/*     */   {
/*  74 */     this.logReason = logReason;
/*     */   }
/*     */   
/*     */   public int getSubReason()
/*     */   {
/*  79 */     return this.subReason;
/*     */   }
/*     */   
/*     */   public void setSubReason(int subReason)
/*     */   {
/*  84 */     this.subReason = subReason;
/*     */   }
/*     */   
/*     */   public Map<CurrencyType, Integer> getCurrencytype2num()
/*     */   {
/*  89 */     return this.currencytype2num;
/*     */   }
/*     */   
/*     */   public void setCurrencytype2num(Map<CurrencyType, Integer> currencytype2num)
/*     */   {
/*  94 */     this.currencytype2num = currencytype2num;
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
/*     */   public void addCurrencytype2num(CurrencyType currencyType, Integer num)
/*     */   {
/* 107 */     this.currencytype2num.put(currencyType, num);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addItem2num(int itemid, int num)
/*     */   {
/* 119 */     this.itemid2num.put(Integer.valueOf(itemid), Integer.valueOf(num));
/*     */   }
/*     */   
/*     */   public int getItemChangeCount()
/*     */   {
/* 124 */     if ((this.itemid2num == null) || (this.itemid2num.isEmpty()))
/*     */     {
/* 126 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 130 */     Integer i = (Integer)this.itemid2num.values().iterator().next();
/* 131 */     if (i == null)
/*     */     {
/* 133 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 137 */     return i.intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tlog\TLogArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */