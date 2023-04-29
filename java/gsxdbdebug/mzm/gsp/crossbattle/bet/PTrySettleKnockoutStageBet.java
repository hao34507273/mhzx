/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_SettleStageBet;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleFightZoneInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PTrySettleKnockoutStageBet
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int knockoutType;
/*     */   private final int fightZoneid;
/*     */   private final int stage;
/*     */   private final int tryTimes;
/*     */   
/*     */   public PTrySettleKnockoutStageBet(int activityCfgid, int knockoutType, int fightZoneid, int stage, int tryTimes)
/*     */   {
/*  31 */     this.activityCfgid = activityCfgid;
/*  32 */     this.knockoutType = knockoutType;
/*  33 */     this.fightZoneid = fightZoneid;
/*  34 */     this.stage = stage;
/*  35 */     this.tryTimes = tryTimes;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (this.tryTimes > CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*     */     {
/*     */ 
/*  44 */       return false;
/*     */     }
/*  46 */     SCrossBattleKnockoutBetInfo cfg = CrossBattleBetManager.getCrossBattleKnockoutBetInfo(this.activityCfgid, this.knockoutType);
/*     */     
/*  48 */     if (cfg == null)
/*     */     {
/*     */ 
/*  51 */       onFail(-3, null);
/*  52 */       return false;
/*     */     }
/*  54 */     if ((this.fightZoneid <= 0) || (this.fightZoneid > CrossBattleBetManager.getKnockoutFightZoneNum(this.knockoutType)))
/*     */     {
/*     */ 
/*  57 */       onFail(-3, null);
/*  58 */       return false;
/*     */     }
/*  60 */     if ((this.stage <= 0) || (this.stage > CrossBattleKnockoutInterface.getKnockOutStageSize(this.activityCfgid, this.knockoutType)))
/*     */     {
/*     */ 
/*     */ 
/*  64 */       onFail(-3, null);
/*  65 */       return false;
/*     */     }
/*  67 */     if (DateTimeUtils.getCurrTimeInMillis() < CrossBattleKnockoutInterface.getCrossBattleKnockOutStageCalTime(this.activityCfgid, this.knockoutType, this.stage))
/*     */     {
/*     */ 
/*     */ 
/*  71 */       onFail(9, null);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     CrossBattleFightZoneInfo fightZoneInfo = CrossBattleKnockoutInterface.getCrossBattleKnockOutFightZoneInfo(this.activityCfgid, this.knockoutType, this.fightZoneid);
/*     */     
/*  78 */     if (fightZoneInfo == null)
/*     */     {
/*     */ 
/*  81 */       GetKnockOutContext context = new GetKnockOutContext();
/*  82 */       context.oper_type = 6;
/*  83 */       context.content.replace(new GetKnockOutContext_SettleStageBet(this.stage).marshal(new OctetsStream()));
/*  84 */       if (!CrossBattleKnockoutInterface.getCrossBattleKnockOutInfo(this.activityCfgid, this.knockoutType, this.fightZoneid, context.marshal(new OctetsStream())))
/*     */       {
/*     */ 
/*     */ 
/*  88 */         onFail(10, null);
/*  89 */         if (this.tryTimes + 1 <= CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*     */         {
/*  91 */           new TrySettleKnockoutStageBetSession(CrossBattleBetManager.GRC_RETRY_INTERVAL, 0L, this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, this.tryTimes + 1);
/*     */         }
/*     */         
/*  94 */         return false;
/*     */       }
/*  96 */       StringBuilder sb = new StringBuilder();
/*  97 */       sb.append(String.format("[crossbattle_bet]PTrySettleKnockoutStageBet.processImp@gs has no knockout data|activity_cfg_id=%d|knockout_type=%d|fight_zoneid=%d|stage=%d|try_times=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.tryTimes) }));
/*     */       
/*     */ 
/* 100 */       CrossBattleBetManager.logger.info(sb.toString());
/* 101 */       return true;
/*     */     }
/*     */     
/* 104 */     int res = CrossBattleBetManager.settleKnockoutStageBet(this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, fightZoneInfo);
/*     */     
/* 106 */     if (res != 0)
/*     */     {
/* 108 */       onFail(res, null);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     StringBuilder sb = new StringBuilder();
/* 113 */     sb.append(String.format("[crossbattle_bet]PTrySettleKnockoutStageBet.processImp@try settle knockout stage bet success|activity_cfg_id=%d|knockout_type=%d|fight_zoneid=%d|stage=%d|try_times=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.tryTimes) }));
/*     */     
/*     */ 
/* 116 */     CrossBattleBetManager.logger.info(sb.toString());
/* 117 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 122 */     StringBuilder sb = new StringBuilder();
/* 123 */     sb.append(String.format("[crossbattle_bet]PTrySettleKnockoutStageBet.processImp@try settle knockout stage bet fail|activity_cfg_id=%d|knockout_type=%d|fight_zoneid=%d|stage=%d|try_times=%d|res=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.tryTimes), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 126 */     if (extraInfo != null)
/*     */     {
/* 128 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 130 */         sb.append("|").append((String)entry.getKey());
/* 131 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 134 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PTrySettleKnockoutStageBet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */