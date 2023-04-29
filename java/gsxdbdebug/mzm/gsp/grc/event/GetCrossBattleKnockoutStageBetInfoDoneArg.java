/*     */ package mzm.gsp.grc.event;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ public class GetCrossBattleKnockoutStageBetInfoDoneArg
/*     */ {
/*     */   private final int retcode;
/*     */   private final int activityCfgid;
/*     */   private final int knockoutType;
/*     */   private final int fightZoneid;
/*     */   private final int stage;
/*     */   private final int fightNum;
/*     */   private final long roleid;
/*     */   private final int reason;
/*     */   private final Octets result;
/*     */   
/*     */   public GetCrossBattleKnockoutStageBetInfoDoneArg(int retcode, int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightNum, long roleid, int reason, Octets result)
/*     */   {
/*  20 */     this.retcode = retcode;
/*  21 */     this.activityCfgid = activityCfgid;
/*  22 */     this.knockoutType = knockoutType;
/*  23 */     this.fightZoneid = fightZoneid;
/*  24 */     this.stage = stage;
/*  25 */     this.fightNum = fightNum;
/*  26 */     this.roleid = roleid;
/*  27 */     this.reason = reason;
/*  28 */     this.result = result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isSucceed()
/*     */   {
/*  38 */     return this.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isTimeout()
/*     */   {
/*  48 */     return this.retcode == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getRetCode()
/*     */   {
/*  58 */     return this.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getActivityCfgid()
/*     */   {
/*  68 */     return this.activityCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getKnockoutType()
/*     */   {
/*  78 */     return this.knockoutType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getFightZoneid()
/*     */   {
/*  88 */     return this.fightZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getStage()
/*     */   {
/*  98 */     return this.stage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getFightNum()
/*     */   {
/* 108 */     return this.fightNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long getRoleid()
/*     */   {
/* 118 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getReason()
/*     */   {
/* 128 */     return this.reason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Octets getResult()
/*     */   {
/* 138 */     return this.result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetCrossBattleKnockoutStageBetInfoDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */