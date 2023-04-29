/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.FightAgainstInfo;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleFightZoneInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PSendKnockoutStageBetMail
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int knockoutType;
/*     */   private final int fightZoneid;
/*     */   private final int stage;
/*     */   
/*     */   public PSendKnockoutStageBetMail(long roleid, int activityCfgid, int knockoutType, int fightZoneid, int stage)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.activityCfgid = activityCfgid;
/*  31 */     this.knockoutType = knockoutType;
/*  32 */     this.fightZoneid = fightZoneid;
/*  33 */     this.stage = stage;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     SCrossBattleKnockoutBetInfo cfg = CrossBattleBetManager.getCrossBattleKnockoutBetInfo(this.activityCfgid, this.knockoutType);
/*     */     
/*  41 */     if (cfg == null)
/*     */     {
/*     */ 
/*  44 */       onFail(-3, null);
/*  45 */       return false;
/*     */     }
/*  47 */     if ((this.fightZoneid <= 0) || (this.fightZoneid > CrossBattleBetManager.getKnockoutFightZoneNum(this.knockoutType)))
/*     */     {
/*     */ 
/*  50 */       onFail(-3, null);
/*  51 */       return false;
/*     */     }
/*  53 */     if ((this.stage <= 0) || (this.stage > CrossBattleKnockoutInterface.getKnockOutStageSize(this.activityCfgid, this.knockoutType)))
/*     */     {
/*     */ 
/*     */ 
/*  57 */       onFail(-3, null);
/*  58 */       return false;
/*     */     }
/*  60 */     if (!CrossBattleBetManager.isCrossBattleKnockoutBetSwitchOpenForRole(this.roleid, this.activityCfgid, this.knockoutType))
/*     */     {
/*     */ 
/*  63 */       onFail(-1, null);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     CrossBattleFightZoneInfo fightZoneInfo = CrossBattleKnockoutInterface.getCrossBattleKnockOutFightZoneInfo(this.activityCfgid, this.knockoutType, this.fightZoneid);
/*     */     
/*  69 */     if (fightZoneInfo == null)
/*     */     {
/*     */ 
/*  72 */       onFail(11, null);
/*  73 */       return false;
/*     */     }
/*  75 */     List<FightAgainstInfo> fightInfos = fightZoneInfo.getStagefightAgainstList(this.stage);
/*  76 */     CrossBattleBetManager.refreshXKnockoutStageBetInfo(this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, fightInfos);
/*     */     
/*  78 */     if (!GrcInterface.getCrossBattleKnockoutStageBetInfo(this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, fightInfos.size(), this.roleid, 1))
/*     */     {
/*     */ 
/*     */ 
/*  82 */       onFail(10, null);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     StringBuilder sb = new StringBuilder();
/*  87 */     sb.append(String.format("[crossbattle_bet]PSendKnockoutStageBetMail.processImp@get knockout stage bet info from grc|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zoneid=%d|stage=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage) }));
/*     */     
/*     */ 
/*  90 */     CrossBattleBetManager.logger.info(sb.toString());
/*  91 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  96 */     StringBuilder sb = new StringBuilder();
/*  97 */     sb.append(String.format("[crossbattle_bet]PSendKnockoutStageBetMail.processImp@send knockout stage bet mail fail|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zoneid=%d|stage=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 100 */     if (extraInfo != null)
/*     */     {
/* 102 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 104 */         sb.append("|").append((String)entry.getKey());
/* 105 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 108 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PSendKnockoutStageBetMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */