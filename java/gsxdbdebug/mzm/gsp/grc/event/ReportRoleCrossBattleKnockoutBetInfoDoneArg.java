/*     */ package mzm.gsp.grc.event;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReportRoleCrossBattleKnockoutBetInfoDoneArg
/*     */ {
/*     */   private final int retcode;
/*     */   private final int activityCfgid;
/*     */   private final int knockoutType;
/*     */   private final int fightZoneid;
/*     */   private final int stage;
/*     */   private final int fightIndex;
/*     */   private final long roleid;
/*     */   private final long betCorpsid;
/*     */   private final int betMoneyNum;
/*     */   private final Octets result;
/*     */   
/*     */   public ReportRoleCrossBattleKnockoutBetInfoDoneArg(int retcode, int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightIndex, long roleid, long betCorpsid, int betMoneyNum, Octets result)
/*     */   {
/*  22 */     this.retcode = retcode;
/*  23 */     this.activityCfgid = activityCfgid;
/*  24 */     this.knockoutType = knockoutType;
/*  25 */     this.fightZoneid = fightZoneid;
/*  26 */     this.stage = stage;
/*  27 */     this.fightIndex = fightIndex;
/*  28 */     this.roleid = roleid;
/*  29 */     this.betCorpsid = betCorpsid;
/*  30 */     this.betMoneyNum = betMoneyNum;
/*  31 */     this.result = result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isSucceed()
/*     */   {
/*  41 */     return this.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isTimeout()
/*     */   {
/*  51 */     return this.retcode == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getRetCode()
/*     */   {
/*  61 */     return this.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getActivityCfgid()
/*     */   {
/*  71 */     return this.activityCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getKnockoutType()
/*     */   {
/*  81 */     return this.knockoutType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getFightZoneid()
/*     */   {
/*  91 */     return this.fightZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getStage()
/*     */   {
/* 101 */     return this.stage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getFightIndex()
/*     */   {
/* 111 */     return this.fightIndex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long getRoleid()
/*     */   {
/* 121 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long getBetCorpsid()
/*     */   {
/* 131 */     return this.betCorpsid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getBetMoneyNum()
/*     */   {
/* 141 */     return this.betMoneyNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Octets getResult()
/*     */   {
/* 151 */     return this.result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\ReportRoleCrossBattleKnockoutBetInfoDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */