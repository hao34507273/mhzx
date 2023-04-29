/*     */ package mzm.gsp.grc.event;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GetIndianaNumberDoneArg
/*     */ {
/*     */   private final int retcode;
/*     */   private final int activityCfgid;
/*     */   private final int turn;
/*     */   private final int sortid;
/*     */   private final long roleid;
/*     */   private final Octets result;
/*     */   
/*     */   public GetIndianaNumberDoneArg(int retcode, int activityCfgid, int turn, int sortid, long roleid, Octets result)
/*     */   {
/*  21 */     this.retcode = retcode;
/*  22 */     this.activityCfgid = activityCfgid;
/*  23 */     this.turn = turn;
/*  24 */     this.sortid = sortid;
/*  25 */     this.roleid = roleid;
/*  26 */     this.result = result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isSucceed()
/*     */   {
/*  36 */     return this.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isTimeout()
/*     */   {
/*  46 */     return this.retcode == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getRetCode()
/*     */   {
/*  56 */     return this.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getActivityCfgid()
/*     */   {
/*  66 */     return this.activityCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getTurn()
/*     */   {
/*  76 */     return this.turn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getSortid()
/*     */   {
/*  86 */     return this.sortid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long getRoleid()
/*     */   {
/*  96 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Octets getResult()
/*     */   {
/* 106 */     return this.result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetIndianaNumberDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */