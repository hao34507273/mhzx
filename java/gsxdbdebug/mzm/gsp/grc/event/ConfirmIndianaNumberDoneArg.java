/*     */ package mzm.gsp.grc.event;
/*     */ 
/*     */ 
/*     */ public class ConfirmIndianaNumberDoneArg
/*     */ {
/*     */   private final int retcode;
/*     */   
/*     */   private final int activityCfgid;
/*     */   
/*     */   private final int turn;
/*     */   
/*     */   private final int sortid;
/*     */   
/*     */   private final long roleid;
/*     */   private final int number;
/*     */   
/*     */   public ConfirmIndianaNumberDoneArg(int retcode, int activityCfgid, int turn, int sortid, long roleid, int number)
/*     */   {
/*  19 */     this.retcode = retcode;
/*  20 */     this.activityCfgid = activityCfgid;
/*  21 */     this.turn = turn;
/*  22 */     this.sortid = sortid;
/*  23 */     this.roleid = roleid;
/*  24 */     this.number = number;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isSucceed()
/*     */   {
/*  34 */     return this.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isTimeout()
/*     */   {
/*  44 */     return this.retcode == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getRetCode()
/*     */   {
/*  54 */     return this.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getActivityCfgid()
/*     */   {
/*  64 */     return this.activityCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getTurn()
/*     */   {
/*  74 */     return this.turn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getSortid()
/*     */   {
/*  84 */     return this.sortid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long getRoleid()
/*     */   {
/*  94 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getNumber()
/*     */   {
/* 104 */     return this.number;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\ConfirmIndianaNumberDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */