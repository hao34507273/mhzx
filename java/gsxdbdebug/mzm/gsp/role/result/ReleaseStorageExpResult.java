/*     */ package mzm.gsp.role.result;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReleaseStorageExpResult
/*     */ {
/*     */   private boolean releaseSuc;
/*     */   
/*     */ 
/*     */   private int totalReleaseExp;
/*     */   
/*     */ 
/*     */   private int convert2exp;
/*     */   
/*     */ 
/*     */   private int convert2xiu;
/*     */   
/*     */ 
/*     */   private int orgLv;
/*     */   
/*     */ 
/*     */   private int curLv;
/*     */   
/*     */ 
/*     */   private Reason reason;
/*     */   
/*     */ 
/*     */ 
/*     */   public void fillSucResult(int orgLv, int curLv, int totalReleaseExp, int convert2exp, int convert2xiu)
/*     */   {
/*  31 */     this.releaseSuc = true;
/*  32 */     this.orgLv = orgLv;
/*  33 */     this.curLv = curLv;
/*  34 */     this.totalReleaseExp = totalReleaseExp;
/*  35 */     this.convert2exp = convert2exp;
/*  36 */     this.convert2xiu = convert2xiu;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void fillErrResult(Reason reason)
/*     */   {
/*  46 */     this.releaseSuc = false;
/*  47 */     this.reason = reason;
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
/*     */   public static enum Reason
/*     */   {
/*  61 */     NOT_FLY_POINT, 
/*  62 */     ROLE_LV_TOO_HIGH, 
/*  63 */     CAL_EXP_ERR, 
/*  64 */     OPEN_FORBID;
/*     */     
/*     */ 
/*     */ 
/*     */     private Reason() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isReleaseSuc()
/*     */   {
/*  75 */     return this.releaseSuc;
/*     */   }
/*     */   
/*     */   public int getReasonValue()
/*     */   {
/*  80 */     return this.reason.ordinal();
/*     */   }
/*     */   
/*     */   public int getTotalReleaseExp()
/*     */   {
/*  85 */     return this.totalReleaseExp;
/*     */   }
/*     */   
/*     */   public int getConvert2exp()
/*     */   {
/*  90 */     return this.convert2exp;
/*     */   }
/*     */   
/*     */   public int getConvert2xiu()
/*     */   {
/*  95 */     return this.convert2xiu;
/*     */   }
/*     */   
/*     */   public int getOrgLv()
/*     */   {
/* 100 */     return this.orgLv;
/*     */   }
/*     */   
/*     */   public int getCurLv()
/*     */   {
/* 105 */     return this.curLv;
/*     */   }
/*     */   
/*     */   public Reason getReason()
/*     */   {
/* 110 */     return this.reason;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\result\ReleaseStorageExpResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */