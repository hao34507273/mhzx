/*     */ package mzm.gsp.mall.main;
/*     */ 
/*     */ public class JifenOperateResult
/*     */ {
/*     */   private JifenOperateResultEnum resultEnum;
/*     */   private long changenum;
/*     */   
/*     */   public static enum JifenOperateResultEnum
/*     */   {
/*  10 */     Success(0), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  15 */     TypeInvalid(-1), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  20 */     UserNotFound(-2), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  25 */     JifenToMax(-3), 
/*     */     
/*     */ 
/*     */ 
/*  29 */     ParamError(-4), 
/*     */     
/*     */ 
/*     */ 
/*  33 */     Others(-5);
/*     */     
/*     */ 
/*     */ 
/*     */     public final int code;
/*     */     
/*     */ 
/*     */     private JifenOperateResultEnum(int code)
/*     */     {
/*  42 */       this.code = code;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public JifenOperateResult(JifenOperateResultEnum resultEnum, long changenum)
/*     */   {
/*  53 */     this.resultEnum = resultEnum;
/*  54 */     this.changenum = changenum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getChangenum()
/*     */   {
/*  64 */     return this.changenum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSuccess()
/*     */   {
/*  74 */     return this.resultEnum.equals(JifenOperateResultEnum.Success);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isToMax()
/*     */   {
/*  84 */     return this.resultEnum.equals(JifenOperateResultEnum.JifenToMax);
/*     */   }
/*     */   
/*     */   public boolean typeInvalid()
/*     */   {
/*  89 */     return this.resultEnum.equals(JifenOperateResultEnum.TypeInvalid);
/*     */   }
/*     */   
/*     */   public boolean userNotFound()
/*     */   {
/*  94 */     return this.resultEnum.equals(JifenOperateResultEnum.UserNotFound);
/*     */   }
/*     */   
/*     */   public boolean paramError()
/*     */   {
/*  99 */     return this.resultEnum.equals(JifenOperateResultEnum.ParamError);
/*     */   }
/*     */   
/*     */   public boolean otherError()
/*     */   {
/* 104 */     return this.resultEnum.equals(JifenOperateResultEnum.Others);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\JifenOperateResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */