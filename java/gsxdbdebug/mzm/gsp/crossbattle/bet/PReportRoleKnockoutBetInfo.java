/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetInfo;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.KnockoutFightBetInfo;
/*     */ import xbean.KnockoutStageBetInfo;
/*     */ import xbean.RoleKnockoutFightBetInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PReportRoleKnockoutBetInfo
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int knockoutType;
/*     */   private final int fightZoneid;
/*     */   private final int stage;
/*     */   private final int fightIndex;
/*     */   private final long betCorpsid;
/*     */   private final int betMoneyNum;
/*     */   private final int tryTimes;
/*     */   
/*     */   public PReportRoleKnockoutBetInfo(long roleid, int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightIndex, long betCorpsid, int betMoneyNum, int tryTimes)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.activityCfgid = activityCfgid;
/*  42 */     this.knockoutType = knockoutType;
/*  43 */     this.fightZoneid = fightZoneid;
/*  44 */     this.stage = stage;
/*  45 */     this.fightIndex = fightIndex;
/*  46 */     this.betCorpsid = betCorpsid;
/*  47 */     this.betMoneyNum = betMoneyNum;
/*  48 */     this.tryTimes = tryTimes;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  54 */     if (this.tryTimes > CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*     */     {
/*     */ 
/*  57 */       return false;
/*     */     }
/*  59 */     if (!GrcInterface.reportRoleCrossBattleKnockoutBetInfo(this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, this.fightIndex, this.roleid, this.betCorpsid, this.betMoneyNum))
/*     */     {
/*     */ 
/*  62 */       CrossBattleBetManager.logger.info(String.format("[crossbattle_bet]PReportRoleKnockoutBetInfo.processImp@try report role knockout bet info fail|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corps_id=%d|bet_money_num=%d|try_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.fightIndex), Long.valueOf(this.betCorpsid), Integer.valueOf(this.betMoneyNum), Integer.valueOf(this.tryTimes) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       if (this.tryTimes + 1 <= CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*     */       {
/*     */ 
/*  69 */         new ReportRoleKnockoutBetInfoSession(CrossBattleBetManager.GRC_RETRY_INTERVAL, this.roleid, this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, this.fightIndex, this.betCorpsid, this.betMoneyNum, this.tryTimes + 1);
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  76 */         SCrossBattleKnockoutBetInfo cfg = CrossBattleBetManager.getCrossBattleKnockoutBetInfo(this.activityCfgid, this.knockoutType);
/*     */         
/*  78 */         if (cfg == null)
/*     */         {
/*     */ 
/*  81 */           return false;
/*     */         }
/*  83 */         String userid = RoleInterface.getUserId(this.roleid);
/*     */         
/*  85 */         lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */         
/*  87 */         lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */         
/*  89 */         KnockoutStageBetInfo xKnockoutStageBetInfo = CrossBattleBetManager.getXKnockoutStageBetInfo(this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage);
/*     */         
/*  91 */         if (xKnockoutStageBetInfo == null)
/*     */         {
/*     */ 
/*  94 */           return false;
/*     */         }
/*  96 */         KnockoutFightBetInfo xKnockoutFightBetInfo = (KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(this.fightIndex));
/*     */         
/*  98 */         if (xKnockoutFightBetInfo == null)
/*     */         {
/*     */ 
/* 101 */           return false;
/*     */         }
/* 103 */         RoleKnockoutFightBetInfo xRoleKnockoutFightBetInfo = (RoleKnockoutFightBetInfo)xKnockoutFightBetInfo.getRole_bet_infos().get(Long.valueOf(this.roleid));
/*     */         
/* 105 */         if ((xRoleKnockoutFightBetInfo == null) || (xRoleKnockoutFightBetInfo.getBet_corps_id() != this.betCorpsid) || (xRoleKnockoutFightBetInfo.getBet_money_num() != this.betMoneyNum))
/*     */         {
/*     */ 
/*     */ 
/* 109 */           return false;
/*     */         }
/* 111 */         if (!xRoleKnockoutFightBetInfo.getHas_got_mail())
/*     */         {
/* 113 */           int returnMoneyNum = xRoleKnockoutFightBetInfo.getBet_money_num();
/* 114 */           MailAttachment mailAttachment = new MailAttachment();
/* 115 */           switch (cfg.bet_cost_type)
/*     */           {
/*     */           case 2: 
/* 118 */             mailAttachment.setGold(returnMoneyNum);
/* 119 */             break;
/*     */           
/*     */           default: 
/* 122 */             onFail(-3, null);
/* 123 */             return false;
/*     */           }
/* 125 */           SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleid, cfg.bet_fail_notice_mail_cfg_id, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(this.knockoutType == 1 ? LogReason.CROSS_BATTLE_SELECTION_STAGE_BET_MAIL : LogReason.CROSS_BATTLE_FINAL_STAGE_BET_MAIL, this.activityCfgid));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 134 */           if (!sendMailRet.isOK())
/*     */           {
/*     */ 
/* 137 */             onFail(8, null);
/* 138 */             return false;
/*     */           }
/* 140 */           xRoleKnockoutFightBetInfo.setHas_got_mail(true);
/* 141 */           xKnockoutFightBetInfo.getRole_bet_infos().remove(Long.valueOf(this.roleid));
/*     */         }
/* 143 */         StringBuilder sb = new StringBuilder();
/* 144 */         sb.append(String.format("[crossbattle_bet]PReportRoleKnockoutBetInfo.processImp@try report role knockout bet info times to limit process success|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corps_id=%d|bet_money_num=%d|try_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.fightIndex), Long.valueOf(this.betCorpsid), Integer.valueOf(this.betMoneyNum), Integer.valueOf(this.tryTimes) }));
/*     */         
/*     */ 
/*     */ 
/* 148 */         CrossBattleBetManager.logger.info(sb.toString());
/* 149 */         CrossBattleBetTLogManager.addKnockoutBetTLog(this.roleid, this.activityCfgid, 1, this.knockoutType, this.fightZoneid, this.stage, this.fightIndex, xKnockoutFightBetInfo.getA_corps_id(), xKnockoutFightBetInfo.getB_corps_id(), xKnockoutFightBetInfo.getCal_fight_result(), this.betCorpsid, this.betMoneyNum, false, 0);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 157 */       StringBuilder sb = new StringBuilder();
/* 158 */       sb.append(String.format("[crossbattle_bet]PReportRoleKnockoutBetInfo.processImp@try report role knockout bet info success|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corps_id=%d|bet_money_num=%d|try_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.fightIndex), Long.valueOf(this.betCorpsid), Integer.valueOf(this.betMoneyNum), Integer.valueOf(this.tryTimes) }));
/*     */       
/*     */ 
/*     */ 
/* 162 */       CrossBattleBetManager.logger.info(sb.toString());
/*     */     }
/* 164 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 169 */     StringBuilder sb = new StringBuilder();
/* 170 */     sb.append(String.format("[crossbattle_bet]PReportRoleKnockoutBetInfo.processImp@try report role knockout bet info times to limit process fail|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corps_id=%d|bet_money_num=%d|try_times=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.fightIndex), Long.valueOf(this.betCorpsid), Integer.valueOf(this.betMoneyNum), Integer.valueOf(this.tryTimes), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*     */ 
/* 174 */     if (extraInfo != null)
/*     */     {
/* 176 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 178 */         sb.append("|").append((String)entry.getKey());
/* 179 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 182 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PReportRoleKnockoutBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */