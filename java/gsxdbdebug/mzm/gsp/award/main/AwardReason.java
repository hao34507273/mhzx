/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
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
/*     */ public class AwardReason
/*     */ {
/*     */   private LogReason logReason;
/*     */   private int subReason;
/*     */   private PresentType presentType;
/*     */   private boolean isAwardItemBind;
/*     */   private long awardTime;
/*  38 */   private boolean isJustQuery = false;
/*     */   
/*     */   public AwardReason(LogReason logReason)
/*     */   {
/*  42 */     this.logReason = logReason;
/*     */   }
/*     */   
/*     */   public AwardReason(LogReason logReason, int subReason)
/*     */   {
/*  47 */     this.logReason = logReason;
/*  48 */     this.subReason = subReason;
/*     */   }
/*     */   
/*     */   public AwardReason(LogReason logReason, PresentType presentType)
/*     */   {
/*  53 */     this.logReason = logReason;
/*  54 */     this.presentType = presentType;
/*     */   }
/*     */   
/*     */   public AwardReason(LogReason logReason, int subReason, PresentType presentType)
/*     */   {
/*  59 */     this.logReason = logReason;
/*  60 */     this.subReason = subReason;
/*  61 */     this.presentType = presentType;
/*     */   }
/*     */   
/*     */   public LogReason getLogReason()
/*     */   {
/*  66 */     return this.logReason;
/*     */   }
/*     */   
/*     */   public void setLogReason(LogReason logReason)
/*     */   {
/*  71 */     this.logReason = logReason;
/*     */   }
/*     */   
/*     */   public int getSubReason()
/*     */   {
/*  76 */     return this.subReason;
/*     */   }
/*     */   
/*     */   public void setPresentType(PresentType presentType)
/*     */   {
/*  81 */     this.presentType = presentType;
/*     */   }
/*     */   
/*     */   public PresentType getPresentType()
/*     */   {
/*  86 */     if (this.presentType == null)
/*     */     {
/*  88 */       return PresentType.PRSENT_BIND_ROLE_AWARD;
/*     */     }
/*  90 */     return this.presentType;
/*     */   }
/*     */   
/*     */   public void setSubReason(int subReason)
/*     */   {
/*  95 */     this.subReason = subReason;
/*     */   }
/*     */   
/*     */   public boolean isAwardItemBind()
/*     */   {
/* 100 */     return this.isAwardItemBind;
/*     */   }
/*     */   
/*     */   public void setAwardItemBind(boolean isAwardItemBind)
/*     */   {
/* 105 */     this.isAwardItemBind = isAwardItemBind;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isJustQuery()
/*     */   {
/* 111 */     return this.isJustQuery;
/*     */   }
/*     */   
/*     */   public void setJustQuery(boolean isJustQuery)
/*     */   {
/* 116 */     this.isJustQuery = isJustQuery;
/*     */   }
/*     */   
/*     */ 
/*     */   long getAwardTime()
/*     */   {
/* 122 */     return this.awardTime;
/*     */   }
/*     */   
/*     */   void setAwardTime(long awardTime)
/*     */   {
/* 127 */     this.awardTime = awardTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   TLogArg getTLogArg()
/*     */   {
/* 137 */     return new TLogArg(this.logReason, this.subReason);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\AwardReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */