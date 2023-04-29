/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleRoundRobinBet;
/*     */ import xbean.RoleRoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinRoundBetInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Cross_battle_round_robin_bets;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendRoundRobinBetMail extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int roundIndex;
/*     */   private final long corpsAid;
/*     */   private final long corpsBid;
/*     */   
/*     */   public PSendRoundRobinBetMail(long roleid, int activityCfgid, int roundIndex, long corpsAid, long corpsBid)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.activityCfgid = activityCfgid;
/*  39 */     this.roundIndex = roundIndex;
/*  40 */     this.corpsAid = corpsAid;
/*  41 */     this.corpsBid = corpsBid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     SCrossBattleRoundRobinBetCfg cfg = SCrossBattleRoundRobinBetCfg.get(this.activityCfgid);
/*  48 */     if (cfg == null)
/*     */     {
/*     */ 
/*  51 */       onFail(-3, null);
/*  52 */       return false;
/*     */     }
/*  54 */     if (!CrossBattleBetManager.isCrossBattleRoundRobinBetSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  57 */       onFail(-1, null);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  63 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  65 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  68 */     CrossBattleOwnInfo crossBattleOwnInfo = CrossBattleOwnInterface.getCrossBattleOwnInfo(this.activityCfgid, true);
/*  69 */     if (crossBattleOwnInfo == null)
/*     */     {
/*     */ 
/*  72 */       onFail(1, null);
/*  73 */       return false;
/*     */     }
/*  75 */     CrossBattleBetManager.initXCrossBattleRoundRobinBet(this.activityCfgid);
/*  76 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  77 */     CrossBattleRoundRobinBet xCrossBattleRoundRobinBet = Cross_battle_round_robin_bets.get(Long.valueOf(globalActivityCfgid));
/*  78 */     if (xCrossBattleRoundRobinBet == null)
/*     */     {
/*     */ 
/*  81 */       onFail(2, null);
/*  82 */       return false;
/*     */     }
/*  84 */     if ((this.roundIndex <= 0) || (this.roundIndex > xCrossBattleRoundRobinBet.getRound_bet_infos().size()) || (this.roundIndex > crossBattleOwnInfo.getRoundRobinRoundInfoList().size()))
/*     */     {
/*     */ 
/*     */ 
/*  88 */       onFail(-3, null);
/*  89 */       return false;
/*     */     }
/*  91 */     RoundRobinRoundBetInfo xRoundRobinRoundBetInfo = (RoundRobinRoundBetInfo)xCrossBattleRoundRobinBet.getRound_bet_infos().get(this.roundIndex - 1);
/*     */     
/*  93 */     boolean isFightExist = false;
/*  94 */     for (RoundRobinFightBetInfo xRoundRobinFightBetInfo : xRoundRobinRoundBetInfo.getFight_bet_infos())
/*     */     {
/*  96 */       if ((xRoundRobinFightBetInfo.getCorps_a_id() == this.corpsAid) && (xRoundRobinFightBetInfo.getCorps_b_id() == this.corpsBid))
/*     */       {
/*     */ 
/*  99 */         isFightExist = true;
/* 100 */         if (!CrossBattleBetManager.isRoundRobinFightEnd(xRoundRobinFightBetInfo.getState()))
/*     */         {
/*     */ 
/* 103 */           onFail(3, null);
/* 104 */           return false;
/*     */         }
/* 106 */         RoleRoundRobinFightBetInfo xRoleRoundRobinFightBetInfo = (RoleRoundRobinFightBetInfo)xRoundRobinFightBetInfo.getRole_bet_infos().get(Long.valueOf(this.roleid));
/*     */         
/* 108 */         if (xRoleRoundRobinFightBetInfo == null)
/*     */         {
/*     */ 
/* 111 */           onFail(6, null);
/* 112 */           return false;
/*     */         }
/* 114 */         if (xRoleRoundRobinFightBetInfo.getHas_got_mail())
/*     */         {
/*     */ 
/* 117 */           onFail(7, null);
/* 118 */           return false;
/*     */         }
/* 120 */         if (CrossBattleBetManager.isRoundRobinFightTie(xRoundRobinFightBetInfo.getState()))
/*     */         {
/* 122 */           int returnMoneyNum = (int)(cfg.tie_rate_of_return * xRoleRoundRobinFightBetInfo.getMoney_num());
/* 123 */           MailAttachment mailAttachment = new MailAttachment();
/* 124 */           switch (cfg.bet_cost_type)
/*     */           {
/*     */           case 2: 
/* 127 */             mailAttachment.setGold(returnMoneyNum);
/* 128 */             break;
/*     */           
/*     */           default: 
/* 131 */             onFail(-3, null);
/* 132 */             return false;
/*     */           }
/* 134 */           SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleid, cfg.tie_notice_mail_cfg_id, new ArrayList(), Arrays.asList(new String[] { String.valueOf(this.roundIndex), crossBattleOwnInfo.getCorpsName(this.corpsAid), String.valueOf(this.corpsAid), crossBattleOwnInfo.getCorpsName(this.corpsBid), String.valueOf(this.corpsBid), crossBattleOwnInfo.getCorpsName(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getMoney_num()) }), mailAttachment, new TLogArg(LogReason.CROSS_BATTLE_ROUND_ROBIN_STAGE_BET_MAIL, this.activityCfgid));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */           if (!sendMailRet.isOK())
/*     */           {
/*     */ 
/* 145 */             onFail(8, null);
/* 146 */             return false;
/*     */           }
/* 148 */           xRoleRoundRobinFightBetInfo.setHas_got_mail(true);
/*     */         }
/* 150 */         else if (CrossBattleBetManager.isRoundRobinFightAWin(xRoundRobinFightBetInfo.getState()))
/*     */         {
/* 152 */           if (xRoleRoundRobinFightBetInfo.getBet_corps_id() == xRoundRobinFightBetInfo.getCorps_a_id())
/*     */           {
/* 154 */             int returnMoneyNum = (int)(cfg.win_rate_of_return * xRoleRoundRobinFightBetInfo.getMoney_num());
/* 155 */             MailAttachment mailAttachment = new MailAttachment();
/* 156 */             switch (cfg.bet_cost_type)
/*     */             {
/*     */             case 2: 
/* 159 */               mailAttachment.setGold(returnMoneyNum);
/* 160 */               break;
/*     */             
/*     */             default: 
/* 163 */               onFail(-3, null);
/* 164 */               return false;
/*     */             }
/* 166 */             SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleid, cfg.win_notice_mail_cfg_id, new ArrayList(), Arrays.asList(new String[] { String.valueOf(this.roundIndex), crossBattleOwnInfo.getCorpsName(this.corpsAid), String.valueOf(this.corpsAid), crossBattleOwnInfo.getCorpsName(this.corpsBid), String.valueOf(this.corpsBid), crossBattleOwnInfo.getCorpsName(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getMoney_num()), String.valueOf(returnMoneyNum) }), mailAttachment, new TLogArg(LogReason.CROSS_BATTLE_ROUND_ROBIN_STAGE_BET_MAIL, this.activityCfgid));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 176 */             if (!sendMailRet.isOK())
/*     */             {
/*     */ 
/* 179 */               onFail(8, null);
/* 180 */               return false;
/*     */             }
/* 182 */             xRoleRoundRobinFightBetInfo.setHas_got_mail(true);
/*     */           }
/*     */           else
/*     */           {
/* 186 */             int returnMoneyNum = (int)(cfg.lose_rate_of_return * xRoleRoundRobinFightBetInfo.getMoney_num());
/* 187 */             MailAttachment mailAttachment = new MailAttachment();
/* 188 */             switch (cfg.bet_cost_type)
/*     */             {
/*     */             case 2: 
/* 191 */               mailAttachment.setGold(returnMoneyNum);
/* 192 */               break;
/*     */             
/*     */             default: 
/* 195 */               onFail(-3, null);
/* 196 */               return false;
/*     */             }
/* 198 */             SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleid, cfg.lose_notice_mail_cfg_id, new ArrayList(), Arrays.asList(new String[] { String.valueOf(this.roundIndex), crossBattleOwnInfo.getCorpsName(this.corpsAid), String.valueOf(this.corpsAid), crossBattleOwnInfo.getCorpsName(this.corpsBid), String.valueOf(this.corpsBid), crossBattleOwnInfo.getCorpsName(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getMoney_num()), String.valueOf((int)(cfg.lose_rate_of_return * 100.0D)) + "%" }), mailAttachment, new TLogArg(LogReason.CROSS_BATTLE_ROUND_ROBIN_STAGE_BET_MAIL, this.activityCfgid));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 208 */             if (!sendMailRet.isOK())
/*     */             {
/*     */ 
/* 211 */               onFail(8, null);
/* 212 */               return false;
/*     */             }
/* 214 */             xRoleRoundRobinFightBetInfo.setHas_got_mail(true);
/*     */           }
/*     */           
/*     */ 
/*     */         }
/* 219 */         else if (xRoleRoundRobinFightBetInfo.getBet_corps_id() == xRoundRobinFightBetInfo.getCorps_b_id())
/*     */         {
/* 221 */           int returnMoneyNum = (int)(cfg.win_rate_of_return * xRoleRoundRobinFightBetInfo.getMoney_num());
/* 222 */           MailAttachment mailAttachment = new MailAttachment();
/* 223 */           switch (cfg.bet_cost_type)
/*     */           {
/*     */           case 2: 
/* 226 */             mailAttachment.setGold(returnMoneyNum);
/* 227 */             break;
/*     */           
/*     */           default: 
/* 230 */             onFail(-3, null);
/* 231 */             return false;
/*     */           }
/* 233 */           SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleid, cfg.win_notice_mail_cfg_id, new ArrayList(), Arrays.asList(new String[] { String.valueOf(this.roundIndex), crossBattleOwnInfo.getCorpsName(this.corpsAid), String.valueOf(this.corpsAid), crossBattleOwnInfo.getCorpsName(this.corpsBid), String.valueOf(this.corpsBid), crossBattleOwnInfo.getCorpsName(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getMoney_num()), String.valueOf(returnMoneyNum) }), mailAttachment, new TLogArg(LogReason.CROSS_BATTLE_ROUND_ROBIN_STAGE_BET_MAIL, this.activityCfgid));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 243 */           if (!sendMailRet.isOK())
/*     */           {
/*     */ 
/* 246 */             onFail(8, null);
/* 247 */             return false;
/*     */           }
/* 249 */           xRoleRoundRobinFightBetInfo.setHas_got_mail(true);
/*     */         }
/*     */         else
/*     */         {
/* 253 */           int returnMoneyNum = (int)(cfg.lose_rate_of_return * xRoleRoundRobinFightBetInfo.getMoney_num());
/* 254 */           MailAttachment mailAttachment = new MailAttachment();
/* 255 */           switch (cfg.bet_cost_type)
/*     */           {
/*     */           case 2: 
/* 258 */             mailAttachment.setGold(returnMoneyNum);
/* 259 */             break;
/*     */           
/*     */           default: 
/* 262 */             onFail(-3, null);
/* 263 */             return false;
/*     */           }
/* 265 */           SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleid, cfg.lose_notice_mail_cfg_id, new ArrayList(), Arrays.asList(new String[] { String.valueOf(this.roundIndex), crossBattleOwnInfo.getCorpsName(this.corpsAid), String.valueOf(this.corpsAid), crossBattleOwnInfo.getCorpsName(this.corpsBid), String.valueOf(this.corpsBid), crossBattleOwnInfo.getCorpsName(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getBet_corps_id()), String.valueOf(xRoleRoundRobinFightBetInfo.getMoney_num()), String.valueOf((int)(cfg.lose_rate_of_return * 100.0D)) + "%" }), mailAttachment, new TLogArg(LogReason.CROSS_BATTLE_ROUND_ROBIN_STAGE_BET_MAIL, this.activityCfgid));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 275 */           if (!sendMailRet.isOK())
/*     */           {
/*     */ 
/* 278 */             onFail(8, null);
/* 279 */             return false;
/*     */           }
/* 281 */           xRoleRoundRobinFightBetInfo.setHas_got_mail(true);
/*     */         }
/*     */         
/* 284 */         StringBuilder sb = new StringBuilder();
/* 285 */         sb.append(String.format("[crossbattle_bet]PSendRoundRobinBetMail.processImp@send round robin bet mail success|roleid=%d|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|state=%d|bet_corps_id=%d|money_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Long.valueOf(xRoundRobinFightBetInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightBetInfo.getCorps_b_id()), Integer.valueOf(xRoundRobinFightBetInfo.getState()), Long.valueOf(xRoleRoundRobinFightBetInfo.getBet_corps_id()), Integer.valueOf(xRoleRoundRobinFightBetInfo.getMoney_num()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 290 */         CrossBattleBetManager.logger.info(sb.toString());
/* 291 */         CrossBattleBetTLogManager.addRoundRobinBetTLog(this.roleid, this.activityCfgid, 2, this.roundIndex, xRoundRobinFightBetInfo.getCorps_a_id(), xRoundRobinFightBetInfo.getCorps_b_id(), xRoundRobinFightBetInfo.getState(), xRoleRoundRobinFightBetInfo.getBet_corps_id(), xRoleRoundRobinFightBetInfo.getMoney_num());
/*     */         
/*     */ 
/*     */ 
/* 295 */         break;
/*     */       }
/*     */     }
/* 298 */     if (!isFightExist)
/*     */     {
/*     */ 
/* 301 */       onFail(4, null);
/* 302 */       return false;
/*     */     }
/* 304 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 309 */     StringBuilder sb = new StringBuilder();
/* 310 */     sb.append(String.format("[crossbattle_bet]PSendRoundRobinBetMail.processImp@send round robin bet mail process|roleid=%d|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Long.valueOf(this.corpsAid), Long.valueOf(this.corpsBid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 313 */     if (extraInfo != null)
/*     */     {
/* 315 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 317 */         sb.append("|").append((String)entry.getKey());
/* 318 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 321 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PSendRoundRobinBetMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */