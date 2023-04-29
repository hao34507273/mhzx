/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.SRefreshFinalFightBetInfo;
/*     */ import mzm.gsp.crossbattle.SRefreshSelectionFightBetInfo;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetInfo;
/*     */ import mzm.gsp.grc.event.ReportRoleCrossBattleKnockoutBetInfoDoneArg;
/*     */ import mzm.gsp.grc.event.ReportRoleCrossBattleKnockoutBetInfoDoneProcedure;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.KnockoutFightBetInfo;
/*     */ import xbean.KnockoutStageBetInfo;
/*     */ import xbean.RoleKnockoutFightBetInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class POnReportRoleCrossBattleKnockoutBetInfoDone
/*     */   extends ReportRoleCrossBattleKnockoutBetInfoDoneProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     SCrossBattleKnockoutBetInfo cfg = CrossBattleBetManager.getCrossBattleKnockoutBetInfo(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getActivityCfgid(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getKnockoutType());
/*     */     
/*  36 */     if (cfg == null)
/*     */     {
/*     */ 
/*  39 */       return false;
/*     */     }
/*  41 */     String userid = RoleInterface.getUserId(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid());
/*     */     
/*  43 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  45 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid()) }));
/*     */     
/*  47 */     KnockoutStageBetInfo xKnockoutStageBetInfo = CrossBattleBetManager.getXKnockoutStageBetInfo(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getActivityCfgid(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getKnockoutType(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightZoneid(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getStage());
/*     */     
/*  49 */     if (xKnockoutStageBetInfo == null)
/*     */     {
/*     */ 
/*  52 */       return false;
/*     */     }
/*  54 */     KnockoutFightBetInfo xKnockoutFightBetInfo = (KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightIndex()));
/*     */     
/*  56 */     if (xKnockoutFightBetInfo == null)
/*     */     {
/*     */ 
/*  59 */       return false;
/*     */     }
/*  61 */     RoleKnockoutFightBetInfo xRoleKnockoutFightBetInfo = (RoleKnockoutFightBetInfo)xKnockoutFightBetInfo.getRole_bet_infos().get(Long.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid()));
/*     */     
/*  63 */     if ((xRoleKnockoutFightBetInfo == null) || (xRoleKnockoutFightBetInfo.getBet_corps_id() != ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getBetCorpsid()) || (xRoleKnockoutFightBetInfo.getBet_money_num() != ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getBetMoneyNum()))
/*     */     {
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     if (!((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).isSucceed())
/*     */     {
/*     */ 
/*  72 */       if (!xRoleKnockoutFightBetInfo.getHas_got_mail())
/*     */       {
/*  74 */         int returnMoneyNum = xRoleKnockoutFightBetInfo.getBet_money_num();
/*  75 */         MailAttachment mailAttachment = new MailAttachment();
/*  76 */         switch (cfg.bet_cost_type)
/*     */         {
/*     */         case 2: 
/*  79 */           mailAttachment.setGold(returnMoneyNum);
/*  80 */           break;
/*     */         
/*     */         default: 
/*  83 */           onFail(-3, null);
/*  84 */           return false;
/*     */         }
/*  86 */         SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid(), cfg.bet_fail_notice_mail_cfg_id, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getKnockoutType() == 1 ? LogReason.CROSS_BATTLE_SELECTION_STAGE_BET_MAIL : LogReason.CROSS_BATTLE_FINAL_STAGE_BET_MAIL, ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getActivityCfgid()));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */         if (!sendMailRet.isOK())
/*     */         {
/*     */ 
/*  98 */           onFail(8, null);
/*  99 */           return false;
/*     */         }
/* 101 */         xRoleKnockoutFightBetInfo.setHas_got_mail(true);
/* 102 */         xKnockoutFightBetInfo.getRole_bet_infos().remove(Long.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid()));
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 108 */       OctetsStream result = OctetsStream.wrap(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getResult());
/* 109 */       long corpsABetMoneySum = result.unmarshal_long();
/* 110 */       long corpsBBetMoneySum = result.unmarshal_long();
/* 111 */       switch (((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getKnockoutType())
/*     */       {
/*     */ 
/*     */       case 1: 
/* 115 */         SRefreshSelectionFightBetInfo protocol = new SRefreshSelectionFightBetInfo();
/* 116 */         protocol.activity_cfg_id = ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getActivityCfgid();
/* 117 */         protocol.fight_zone_id = ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightZoneid();
/* 118 */         protocol.selection_stage = ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getStage();
/* 119 */         protocol.fight_index = ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightIndex();
/* 120 */         protocol.corps_a_bet_money_sum = corpsABetMoneySum;
/* 121 */         protocol.corps_b_bet_money_sum = corpsBBetMoneySum;
/* 122 */         OnlineManager.getInstance().send(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid(), protocol);
/*     */         
/* 124 */         break;
/*     */       
/*     */       case 2: 
/* 127 */         SRefreshFinalFightBetInfo protocol = new SRefreshFinalFightBetInfo();
/* 128 */         protocol.activity_cfg_id = ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getActivityCfgid();
/* 129 */         protocol.stage = ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getStage();
/* 130 */         protocol.fight_index = ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightIndex();
/* 131 */         protocol.corps_a_bet_money_sum = corpsABetMoneySum;
/* 132 */         protocol.corps_b_bet_money_sum = corpsBBetMoneySum;
/* 133 */         OnlineManager.getInstance().send(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid(), protocol);
/*     */         
/* 135 */         break;
/*     */       }
/*     */       
/*     */     }
/*     */     
/* 140 */     StringBuilder sb = new StringBuilder();
/* 141 */     sb.append(String.format("[crossbattle_bet]POnReportRoleCrossBattleKnockoutBetInfoDone.processImp@report role knockout bet info done process success|roleid=%d|is_success=%b|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corps_id=%d|bet_money_num=%d", new Object[] { Long.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid()), Boolean.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).isSucceed()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getKnockoutType()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightZoneid()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getStage()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightIndex()), Long.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getBetCorpsid()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getBetMoneyNum()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 146 */     CrossBattleBetManager.logger.info(sb.toString());
/* 147 */     CrossBattleBetTLogManager.addKnockoutBetTLog(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getActivityCfgid(), 1, ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getKnockoutType(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightZoneid(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getStage(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightIndex(), xKnockoutFightBetInfo.getA_corps_id(), xKnockoutFightBetInfo.getB_corps_id(), xKnockoutFightBetInfo.getCal_fight_result(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getBetCorpsid(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getBetMoneyNum(), ((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).isSucceed(), 0);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 152 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 157 */     StringBuilder sb = new StringBuilder();
/* 158 */     sb.append(String.format("[crossbattle_bet]POnReportRoleCrossBattleKnockoutBetInfoDone.processImp@report role knockout bet info done process fail|roleid=%d|is_success=%b|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corps_id=%d|bet_money_num=%d|res=%d", new Object[] { Long.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getRoleid()), Boolean.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).isSucceed()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getKnockoutType()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightZoneid()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getStage()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getFightIndex()), Long.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getBetCorpsid()), Integer.valueOf(((ReportRoleCrossBattleKnockoutBetInfoDoneArg)this.arg).getBetMoneyNum()), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 163 */     if (extraInfo != null)
/*     */     {
/* 165 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 167 */         sb.append("|").append((String)entry.getKey());
/* 168 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 171 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnReportRoleCrossBattleKnockoutBetInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */