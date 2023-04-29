/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.FightAgainstInfo;
/*     */ import mzm.gsp.crossbattle.KnockOutStageFightInfo;
/*     */ import mzm.gsp.crossbattle.SGetFinalStageBetInfoFail;
/*     */ import mzm.gsp.crossbattle.SGetFinalStageBetInfoSuccess;
/*     */ import mzm.gsp.crossbattle.SGetSelectionStageBetInfoFail;
/*     */ import mzm.gsp.crossbattle.SGetSelectionStageBetInfoSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleFightZoneInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.grc.event.GetCrossBattleKnockoutStageBetInfoDoneArg;
/*     */ import mzm.gsp.grc.event.GetCrossBattleKnockoutStageBetInfoDoneProcedure;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ import xbean.KnockoutStageBetInfo;
/*     */ import xbean.RoleKnockoutFightBetInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class POnGetCrossBattleKnockoutStageBetInfoDone
/*     */   extends GetCrossBattleKnockoutStageBetInfoDoneProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     SCrossBattleKnockoutBetInfo cfg = CrossBattleBetManager.getCrossBattleKnockoutBetInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType());
/*     */     
/*  47 */     if (cfg == null)
/*     */     {
/*     */ 
/*  50 */       return false;
/*     */     }
/*  52 */     switch (((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getReason())
/*     */     {
/*     */ 
/*     */     case 0: 
/*  56 */       if (!((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).isSucceed())
/*     */       {
/*  58 */         onGetKnockoutStageBetInfoFail(3, null);
/*  59 */         return false;
/*     */       }
/*     */       
/*  62 */       CrossBattleFightZoneInfo fightZoneInfo = CrossBattleKnockoutInterface.getCrossBattleKnockOutFightZoneInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid());
/*     */       
/*  64 */       if (fightZoneInfo == null)
/*     */       {
/*     */ 
/*  67 */         onGetKnockoutStageBetInfoFail(2, null);
/*  68 */         return false;
/*     */       }
/*  70 */       List<FightAgainstInfo> fightInfos = fightZoneInfo.getStagefightAgainstList(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage());
/*  71 */       CrossBattleBetManager.refreshXKnockoutStageBetInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage(), fightInfos);
/*     */       
/*  73 */       KnockoutStageBetInfo xKnockoutStageBetInfo = CrossBattleBetManager.getXKnockoutStageBetInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage());
/*     */       
/*     */ 
/*  76 */       if (xKnockoutStageBetInfo == null)
/*     */       {
/*     */ 
/*  79 */         return false;
/*     */       }
/*  81 */       Map<Integer, GrcStageBetInfo> grcStageBetInfos = parseGrcResult(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getResult());
/*  82 */       switch (((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType())
/*     */       {
/*     */ 
/*     */       case 1: 
/*  86 */         SGetSelectionStageBetInfoSuccess protocol = new SGetSelectionStageBetInfoSuccess();
/*  87 */         protocol.activity_cfg_id = ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid();
/*  88 */         protocol.fight_zone_id = ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid();
/*  89 */         protocol.selection_stage = ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage();
/*  90 */         fightZoneInfo.fillKnockOutFightCorpsInfo(protocol.corps_infos);
/*  91 */         fightZoneInfo.fillFightZoneInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage(), protocol.fight_infos.fight_info_list);
/*  92 */         for (int fightIndex = 1; fightIndex <= grcStageBetInfos.size(); fightIndex++)
/*     */         {
/*  94 */           ((FightAgainstInfo)protocol.fight_infos.fight_info_list.get(fightIndex - 1)).cal_fight_result = ((xbean.KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex))).getCal_fight_result();
/*     */           
/*  96 */           GrcStageBetInfo grcStageBetInfo = (GrcStageBetInfo)grcStageBetInfos.get(Integer.valueOf(fightIndex));
/*  97 */           if (grcStageBetInfo != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 102 */             mzm.gsp.crossbattle.KnockoutFightBetInfo fightBetInfo = new mzm.gsp.crossbattle.KnockoutFightBetInfo();
/* 103 */             fightBetInfo.corps_a_bet_money_sum = grcStageBetInfo.getCorpsABetMoneySum();
/* 104 */             fightBetInfo.corps_b_bet_money_sum = grcStageBetInfo.getCorpsBBetMoneySum();
/* 105 */             RoleKnockoutFightBetInfo xRoleKnockoutFightBetInfo = (RoleKnockoutFightBetInfo)((xbean.KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex))).getRole_bet_infos().get(Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()));
/*     */             
/* 107 */             if (xRoleKnockoutFightBetInfo == null)
/*     */             {
/* 109 */               fightBetInfo.role_bet_corps_id = -1L;
/* 110 */               fightBetInfo.role_bet_money_num = -1;
/*     */             }
/*     */             else
/*     */             {
/* 114 */               fightBetInfo.role_bet_corps_id = xRoleKnockoutFightBetInfo.getBet_corps_id();
/* 115 */               fightBetInfo.role_bet_money_num = xRoleKnockoutFightBetInfo.getBet_money_num();
/*     */             }
/* 117 */             protocol.fight_bet_infos.add(fightBetInfo);
/*     */           } }
/* 119 */         OnlineManager.getInstance().send(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), protocol);
/*     */         
/* 121 */         break;
/*     */       
/*     */       case 2: 
/* 124 */         SGetFinalStageBetInfoSuccess protocol = new SGetFinalStageBetInfoSuccess();
/* 125 */         protocol.activity_cfg_id = ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid();
/* 126 */         protocol.stage = ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage();
/* 127 */         fightZoneInfo.fillKnockOutFightCorpsInfo(protocol.corps_infos);
/* 128 */         fightZoneInfo.fillFightZoneInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage(), protocol.fight_infos.fight_info_list);
/* 129 */         for (int fightIndex = 1; fightIndex <= grcStageBetInfos.size(); fightIndex++)
/*     */         {
/* 131 */           ((FightAgainstInfo)protocol.fight_infos.fight_info_list.get(fightIndex - 1)).cal_fight_result = ((xbean.KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex))).getCal_fight_result();
/*     */           
/* 133 */           GrcStageBetInfo grcStageBetInfo = (GrcStageBetInfo)grcStageBetInfos.get(Integer.valueOf(fightIndex));
/* 134 */           if (grcStageBetInfo != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 139 */             mzm.gsp.crossbattle.KnockoutFightBetInfo fightBetInfo = new mzm.gsp.crossbattle.KnockoutFightBetInfo();
/* 140 */             fightBetInfo.corps_a_bet_money_sum = grcStageBetInfo.getCorpsABetMoneySum();
/* 141 */             fightBetInfo.corps_b_bet_money_sum = grcStageBetInfo.getCorpsBBetMoneySum();
/* 142 */             RoleKnockoutFightBetInfo xRoleKnockoutFightBetInfo = (RoleKnockoutFightBetInfo)((xbean.KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex))).getRole_bet_infos().get(Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()));
/*     */             
/* 144 */             if (xRoleKnockoutFightBetInfo == null)
/*     */             {
/* 146 */               fightBetInfo.role_bet_corps_id = -1L;
/* 147 */               fightBetInfo.role_bet_money_num = -1;
/*     */             }
/*     */             else
/*     */             {
/* 151 */               fightBetInfo.role_bet_corps_id = xRoleKnockoutFightBetInfo.getBet_corps_id();
/* 152 */               fightBetInfo.role_bet_money_num = xRoleKnockoutFightBetInfo.getBet_money_num();
/*     */             }
/* 154 */             protocol.fight_bet_infos.add(fightBetInfo);
/*     */           } }
/* 156 */         OnlineManager.getInstance().send(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), protocol);
/*     */         
/* 158 */         break;
/*     */       
/*     */       default: 
/* 161 */         return false; }
/*     */       
/* 163 */       StringBuilder sb = new StringBuilder();
/* 164 */       sb.append(String.format("[crossbattle_bet]POnGetCrossBattleKnockoutStageBetInfoDone.processImp@get knockout stage bet info success|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d", new Object[] { Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()) }));
/*     */       
/*     */ 
/*     */ 
/* 168 */       CrossBattleBetManager.logger.info(sb.toString());
/* 169 */       return true;
/*     */     
/*     */ 
/*     */     case 1: 
/* 173 */       if (!((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).isSucceed())
/*     */       {
/* 175 */         onSendKnockoutStageBetMailFail(12, null);
/* 176 */         return false;
/*     */       }
/* 178 */       String userid = RoleInterface.getUserId(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid());
/*     */       
/* 180 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/* 182 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()) }));
/*     */       
/* 184 */       CrossBattleFightZoneInfo fightZoneInfo = CrossBattleKnockoutInterface.getCrossBattleKnockOutFightZoneInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid());
/*     */       
/* 186 */       if (fightZoneInfo == null)
/*     */       {
/*     */ 
/* 189 */         onSendKnockoutStageBetMailFail(11, null);
/* 190 */         return false;
/*     */       }
/* 192 */       List<FightAgainstInfo> fightInfos = fightZoneInfo.getStagefightAgainstList(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage());
/* 193 */       CrossBattleBetManager.refreshXKnockoutStageBetInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage(), fightInfos);
/*     */       
/* 195 */       KnockoutStageBetInfo xKnockoutStageBetInfo = CrossBattleBetManager.getXKnockoutStageBetInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage());
/*     */       
/*     */ 
/* 198 */       if (xKnockoutStageBetInfo == null)
/*     */       {
/*     */ 
/* 201 */         return false;
/*     */       }
/* 203 */       long addProfit = 0L;
/* 204 */       Map<Integer, GrcStageBetInfo> grcStageBetInfos = parseGrcResult(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getResult());
/* 205 */       for (int fightIndex = 1; fightIndex <= grcStageBetInfos.size(); fightIndex++)
/*     */       {
/* 207 */         xbean.KnockoutFightBetInfo xKnockoutFightBetInfo = (xbean.KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex));
/*     */         
/* 209 */         if (!xKnockoutFightBetInfo.getHas_set_cal_fight_result())
/*     */         {
/*     */ 
/* 212 */           onSendKnockoutStageBetMailFail(9, null);
/*     */         }
/*     */         else {
/* 215 */           GrcStageBetInfo grcStageBetInfo = (GrcStageBetInfo)grcStageBetInfos.get(Integer.valueOf(fightIndex));
/* 216 */           RoleKnockoutFightBetInfo xRoleKnockoutFightBetInfo = (RoleKnockoutFightBetInfo)xKnockoutFightBetInfo.getRole_bet_infos().get(Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()));
/*     */           
/* 218 */           if (xRoleKnockoutFightBetInfo == null)
/*     */           {
/*     */ 
/* 221 */             Map<String, Object> extraInfo = new HashMap();
/* 222 */             extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 223 */             onSendKnockoutStageBetMailFail(6, extraInfo);
/*     */ 
/*     */           }
/* 226 */           else if (xRoleKnockoutFightBetInfo.getHas_got_mail())
/*     */           {
/*     */ 
/* 229 */             Map<String, Object> extraInfo = new HashMap();
/* 230 */             extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 231 */             onSendKnockoutStageBetMailFail(7, extraInfo);
/*     */           }
/*     */           else {
/* 234 */             int returnMoneyNum = 0;
/* 235 */             boolean isBetSuccess = (xRoleKnockoutFightBetInfo.getBet_corps_id() == grcStageBetInfo.getRoleBetCorpsid()) && (xRoleKnockoutFightBetInfo.getBet_money_num() == grcStageBetInfo.getRoleBetMoneyNum());
/*     */             
/* 237 */             if (!isBetSuccess)
/*     */             {
/*     */ 
/* 240 */               returnMoneyNum = xRoleKnockoutFightBetInfo.getBet_money_num();
/* 241 */               MailAttachment mailAttachment = new MailAttachment();
/* 242 */               switch (cfg.bet_cost_type)
/*     */               {
/*     */               case 2: 
/* 245 */                 mailAttachment.setGold(returnMoneyNum);
/* 246 */                 break;
/*     */               
/*     */               default: 
/* 249 */                 Map<String, Object> extraInfo = new HashMap();
/* 250 */                 extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 251 */                 onSendKnockoutStageBetMailFail(-3, extraInfo);
/* 252 */                 return false;
/*     */               }
/* 254 */               List<String> contentArgs = new ArrayList();
/* 255 */               if (((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1)
/*     */               {
/* 257 */                 contentArgs.add(String.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()));
/*     */               }
/* 259 */               contentArgs.add(CrossBattleKnockoutInterface.getCrossBattleKnockOutStageName(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()));
/*     */               
/* 261 */               SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), cfg.bet_fail_notice_mail_cfg_id, new ArrayList(), contentArgs, mailAttachment, new TLogArg(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1 ? LogReason.CROSS_BATTLE_SELECTION_STAGE_BET_MAIL : LogReason.CROSS_BATTLE_FINAL_STAGE_BET_MAIL, ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()));
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 271 */               if (!sendMailRet.isOK())
/*     */               {
/*     */ 
/* 274 */                 Map<String, Object> extraInfo = new HashMap();
/* 275 */                 extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 276 */                 onSendKnockoutStageBetMailFail(8, extraInfo);
/* 277 */                 return false;
/*     */               }
/* 279 */               xRoleKnockoutFightBetInfo.setHas_got_mail(true);
/* 280 */               xKnockoutFightBetInfo.getRole_bet_infos().remove(Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()));
/*     */             }
/* 282 */             else if (CrossBattleBetManager.isKnockoutFightAWin(xKnockoutFightBetInfo.getCal_fight_result()))
/*     */             {
/*     */ 
/* 285 */               if (xRoleKnockoutFightBetInfo.getBet_corps_id() == xKnockoutFightBetInfo.getA_corps_id())
/*     */               {
/*     */ 
/* 288 */                 returnMoneyNum = CrossBattleBetManager.calculateReturnMoneyNum(grcStageBetInfo.getCorpsABetMoneySum(), grcStageBetInfo.getCorpsBBetMoneySum(), true, xRoleKnockoutFightBetInfo.getBet_money_num(), true, cfg.win_multiple, cfg.max_return_money_num);
/*     */                 
/*     */ 
/*     */ 
/* 292 */                 MailAttachment mailAttachment = new MailAttachment();
/* 293 */                 switch (cfg.bet_cost_type)
/*     */                 {
/*     */                 case 2: 
/* 296 */                   mailAttachment.setGold(returnMoneyNum);
/* 297 */                   break;
/*     */                 
/*     */                 default: 
/* 300 */                   Map<String, Object> extraInfo = new HashMap();
/* 301 */                   extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 302 */                   onSendKnockoutStageBetMailFail(-3, extraInfo);
/* 303 */                   return false;
/*     */                 }
/* 305 */                 List<String> contentArgs = new ArrayList();
/* 306 */                 if (((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1)
/*     */                 {
/* 308 */                   contentArgs.add(String.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()));
/*     */                 }
/* 310 */                 contentArgs.add(CrossBattleKnockoutInterface.getCrossBattleKnockOutStageName(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()));
/*     */                 
/* 312 */                 contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getA_corps_id()));
/* 313 */                 contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getA_corps_id()));
/* 314 */                 contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getB_corps_id()));
/* 315 */                 contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getB_corps_id()));
/* 316 */                 contentArgs.add(fightZoneInfo.getCorpsName(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 317 */                 contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 318 */                 contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_money_num()));
/* 319 */                 contentArgs.add(String.valueOf(returnMoneyNum));
/* 320 */                 SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), cfg.win_notice_mail_cfg_id, new ArrayList(), contentArgs, mailAttachment, new TLogArg(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1 ? LogReason.CROSS_BATTLE_SELECTION_STAGE_BET_MAIL : LogReason.CROSS_BATTLE_FINAL_STAGE_BET_MAIL, ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()));
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 330 */                 if (!sendMailRet.isOK())
/*     */                 {
/*     */ 
/* 333 */                   Map<String, Object> extraInfo = new HashMap();
/* 334 */                   extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 335 */                   onSendKnockoutStageBetMailFail(8, extraInfo);
/* 336 */                   return false;
/*     */                 }
/* 338 */                 xRoleKnockoutFightBetInfo.setHas_got_mail(true);
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/* 343 */                 returnMoneyNum = CrossBattleBetManager.calculateReturnMoneyNum(grcStageBetInfo.getCorpsABetMoneySum(), grcStageBetInfo.getCorpsBBetMoneySum(), false, xRoleKnockoutFightBetInfo.getBet_money_num(), true, cfg.win_multiple, cfg.max_return_money_num);
/*     */                 
/*     */ 
/*     */ 
/* 347 */                 MailAttachment mailAttachment = new MailAttachment();
/* 348 */                 switch (cfg.bet_cost_type)
/*     */                 {
/*     */                 case 2: 
/* 351 */                   mailAttachment.setGold(returnMoneyNum);
/* 352 */                   break;
/*     */                 
/*     */                 default: 
/* 355 */                   Map<String, Object> extraInfo = new HashMap();
/* 356 */                   extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 357 */                   onSendKnockoutStageBetMailFail(-3, extraInfo);
/* 358 */                   return false;
/*     */                 }
/* 360 */                 List<String> contentArgs = new ArrayList();
/* 361 */                 if (((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1)
/*     */                 {
/* 363 */                   contentArgs.add(String.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()));
/*     */                 }
/* 365 */                 contentArgs.add(CrossBattleKnockoutInterface.getCrossBattleKnockOutStageName(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()));
/*     */                 
/* 367 */                 contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getA_corps_id()));
/* 368 */                 contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getA_corps_id()));
/* 369 */                 contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getB_corps_id()));
/* 370 */                 contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getB_corps_id()));
/* 371 */                 contentArgs.add(fightZoneInfo.getCorpsName(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 372 */                 contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 373 */                 contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_money_num()));
/* 374 */                 SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), cfg.lose_notice_mail_cfg_id, new ArrayList(), contentArgs, mailAttachment, new TLogArg(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1 ? LogReason.CROSS_BATTLE_SELECTION_STAGE_BET_MAIL : LogReason.CROSS_BATTLE_FINAL_STAGE_BET_MAIL, ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()));
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 384 */                 if (!sendMailRet.isOK())
/*     */                 {
/*     */ 
/* 387 */                   Map<String, Object> extraInfo = new HashMap();
/* 388 */                   extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 389 */                   onSendKnockoutStageBetMailFail(8, extraInfo);
/* 390 */                   return false;
/*     */                 }
/* 392 */                 xRoleKnockoutFightBetInfo.setHas_got_mail(true);
/*     */               }
/*     */             }
/* 395 */             else if (CrossBattleBetManager.isKnockoutFightBWin(xKnockoutFightBetInfo.getCal_fight_result()))
/*     */             {
/*     */ 
/* 398 */               if (xRoleKnockoutFightBetInfo.getBet_corps_id() == xKnockoutFightBetInfo.getB_corps_id())
/*     */               {
/*     */ 
/* 401 */                 returnMoneyNum = CrossBattleBetManager.calculateReturnMoneyNum(grcStageBetInfo.getCorpsABetMoneySum(), grcStageBetInfo.getCorpsBBetMoneySum(), false, xRoleKnockoutFightBetInfo.getBet_money_num(), false, cfg.win_multiple, cfg.max_return_money_num);
/*     */                 
/*     */ 
/*     */ 
/* 405 */                 MailAttachment mailAttachment = new MailAttachment();
/* 406 */                 switch (cfg.bet_cost_type)
/*     */                 {
/*     */                 case 2: 
/* 409 */                   mailAttachment.setGold(returnMoneyNum);
/* 410 */                   break;
/*     */                 
/*     */                 default: 
/* 413 */                   Map<String, Object> extraInfo = new HashMap();
/* 414 */                   extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 415 */                   onSendKnockoutStageBetMailFail(-3, extraInfo);
/* 416 */                   return false;
/*     */                 }
/* 418 */                 List<String> contentArgs = new ArrayList();
/* 419 */                 if (((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1)
/*     */                 {
/* 421 */                   contentArgs.add(String.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()));
/*     */                 }
/* 423 */                 contentArgs.add(CrossBattleKnockoutInterface.getCrossBattleKnockOutStageName(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()));
/*     */                 
/* 425 */                 contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getA_corps_id()));
/* 426 */                 contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getA_corps_id()));
/* 427 */                 contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getB_corps_id()));
/* 428 */                 contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getB_corps_id()));
/* 429 */                 contentArgs.add(fightZoneInfo.getCorpsName(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 430 */                 contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 431 */                 contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_money_num()));
/* 432 */                 contentArgs.add(String.valueOf(returnMoneyNum));
/* 433 */                 SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), cfg.win_notice_mail_cfg_id, new ArrayList(), contentArgs, mailAttachment, new TLogArg(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1 ? LogReason.CROSS_BATTLE_SELECTION_STAGE_BET_MAIL : LogReason.CROSS_BATTLE_FINAL_STAGE_BET_MAIL, ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()));
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 443 */                 if (!sendMailRet.isOK())
/*     */                 {
/*     */ 
/* 446 */                   Map<String, Object> extraInfo = new HashMap();
/* 447 */                   extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 448 */                   onSendKnockoutStageBetMailFail(8, extraInfo);
/* 449 */                   return false;
/*     */                 }
/* 451 */                 xRoleKnockoutFightBetInfo.setHas_got_mail(true);
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/* 456 */                 returnMoneyNum = CrossBattleBetManager.calculateReturnMoneyNum(grcStageBetInfo.getCorpsABetMoneySum(), grcStageBetInfo.getCorpsBBetMoneySum(), true, xRoleKnockoutFightBetInfo.getBet_money_num(), false, cfg.win_multiple, cfg.max_return_money_num);
/*     */                 
/*     */ 
/*     */ 
/* 460 */                 MailAttachment mailAttachment = new MailAttachment();
/* 461 */                 switch (cfg.bet_cost_type)
/*     */                 {
/*     */                 case 2: 
/* 464 */                   mailAttachment.setGold(returnMoneyNum);
/* 465 */                   break;
/*     */                 
/*     */                 default: 
/* 468 */                   Map<String, Object> extraInfo = new HashMap();
/* 469 */                   extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 470 */                   onSendKnockoutStageBetMailFail(-3, extraInfo);
/* 471 */                   return false;
/*     */                 }
/* 473 */                 List<String> contentArgs = new ArrayList();
/* 474 */                 if (((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1)
/*     */                 {
/* 476 */                   contentArgs.add(String.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()));
/*     */                 }
/* 478 */                 contentArgs.add(CrossBattleKnockoutInterface.getCrossBattleKnockOutStageName(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()));
/*     */                 
/* 480 */                 contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getA_corps_id()));
/* 481 */                 contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getA_corps_id()));
/* 482 */                 contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getB_corps_id()));
/* 483 */                 contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getB_corps_id()));
/* 484 */                 contentArgs.add(fightZoneInfo.getCorpsName(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 485 */                 contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 486 */                 contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_money_num()));
/* 487 */                 SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), cfg.lose_notice_mail_cfg_id, new ArrayList(), contentArgs, mailAttachment, new TLogArg(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1 ? LogReason.CROSS_BATTLE_SELECTION_STAGE_BET_MAIL : LogReason.CROSS_BATTLE_FINAL_STAGE_BET_MAIL, ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()));
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 497 */                 if (!sendMailRet.isOK())
/*     */                 {
/*     */ 
/* 500 */                   Map<String, Object> extraInfo = new HashMap();
/* 501 */                   extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 502 */                   onSendKnockoutStageBetMailFail(8, extraInfo);
/* 503 */                   return false;
/*     */                 }
/* 505 */                 xRoleKnockoutFightBetInfo.setHas_got_mail(true);
/*     */               }
/*     */             }
/* 508 */             else if (CrossBattleBetManager.isKnockoutFightTie(xKnockoutFightBetInfo.getCal_fight_result()))
/*     */             {
/*     */ 
/* 511 */               returnMoneyNum = xRoleKnockoutFightBetInfo.getBet_money_num();
/* 512 */               MailAttachment mailAttachment = new MailAttachment();
/* 513 */               switch (cfg.bet_cost_type)
/*     */               {
/*     */               case 2: 
/* 516 */                 mailAttachment.setGold(returnMoneyNum);
/* 517 */                 break;
/*     */               
/*     */               default: 
/* 520 */                 Map<String, Object> extraInfo = new HashMap();
/* 521 */                 extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 522 */                 onSendKnockoutStageBetMailFail(-3, extraInfo);
/* 523 */                 return false;
/*     */               }
/* 525 */               List<String> contentArgs = new ArrayList();
/* 526 */               if (((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1)
/*     */               {
/* 528 */                 contentArgs.add(String.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()));
/*     */               }
/* 530 */               contentArgs.add(CrossBattleKnockoutInterface.getCrossBattleKnockOutStageName(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()));
/*     */               
/* 532 */               contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getA_corps_id()));
/* 533 */               contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getA_corps_id()));
/* 534 */               contentArgs.add(fightZoneInfo.getCorpsName(xKnockoutFightBetInfo.getB_corps_id()));
/* 535 */               contentArgs.add(String.valueOf(xKnockoutFightBetInfo.getB_corps_id()));
/* 536 */               contentArgs.add(fightZoneInfo.getCorpsName(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 537 */               contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_corps_id()));
/* 538 */               contentArgs.add(String.valueOf(xRoleKnockoutFightBetInfo.getBet_money_num()));
/* 539 */               SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), cfg.tie_notice_mail_cfg_id, new ArrayList(), contentArgs, mailAttachment, new TLogArg(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType() == 1 ? LogReason.CROSS_BATTLE_SELECTION_STAGE_BET_MAIL : LogReason.CROSS_BATTLE_FINAL_STAGE_BET_MAIL, ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()));
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 549 */               if (!sendMailRet.isOK())
/*     */               {
/*     */ 
/* 552 */                 Map<String, Object> extraInfo = new HashMap();
/* 553 */                 extraInfo.put("fight_index", Integer.valueOf(fightIndex));
/* 554 */                 onSendKnockoutStageBetMailFail(8, extraInfo);
/* 555 */                 return false;
/*     */               }
/* 557 */               xRoleKnockoutFightBetInfo.setHas_got_mail(true);
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/* 562 */               StringBuilder sb = new StringBuilder();
/* 563 */               sb.append(String.format("[crossbattle_bet]POnGetCrossBattleKnockoutStageBetInfoDone.processImp@send knockout stage bet mail error|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d", new Object[] { Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()), Integer.valueOf(fightIndex) }));
/*     */               
/*     */ 
/*     */ 
/* 567 */               CrossBattleBetManager.logger.error(sb.toString());
/* 568 */               continue;
/*     */             }
/* 570 */             StringBuilder sb = new StringBuilder();
/* 571 */             sb.append(String.format("[crossbattle_bet]POnGetCrossBattleKnockoutStageBetInfoDone.processImp@send knockout stage bet mail success|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|is_bet_success=%b|return_money_num=%d", new Object[] { Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()), Integer.valueOf(fightIndex), Boolean.valueOf(isBetSuccess), Integer.valueOf(returnMoneyNum) }));
/*     */             
/*     */ 
/*     */ 
/* 575 */             CrossBattleBetManager.logger.info(sb.toString());
/* 576 */             CrossBattleBetTLogManager.addKnockoutBetTLog(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), 2, ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage(), fightIndex, xKnockoutFightBetInfo.getA_corps_id(), xKnockoutFightBetInfo.getB_corps_id(), xKnockoutFightBetInfo.getCal_fight_result(), xRoleKnockoutFightBetInfo.getBet_corps_id(), xRoleKnockoutFightBetInfo.getBet_money_num(), isBetSuccess, returnMoneyNum);
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 582 */             addProfit += returnMoneyNum - xRoleKnockoutFightBetInfo.getBet_money_num();
/*     */           } } }
/* 584 */       CrossBattleBetManager.updateRoleBetProfitInfo(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid(), ((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), addProfit);
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 589 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetKnockoutStageBetInfoFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 594 */     StringBuilder sb = new StringBuilder();
/* 595 */     sb.append(String.format("[crossbattle_bet]POnGetCrossBattleKnockoutStageBetInfoDone.processImp@get knockout stage bet info fail|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|res=%d", new Object[] { Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*     */ 
/* 599 */     if (extraInfo != null)
/*     */     {
/* 601 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 603 */         sb.append("|").append((String)entry.getKey());
/* 604 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 607 */     CrossBattleBetManager.logger.info(sb.toString());
/* 608 */     if (res > 0)
/*     */     {
/* 610 */       switch (((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType())
/*     */       {
/*     */ 
/*     */       case 1: 
/* 614 */         SGetSelectionStageBetInfoFail protocol = new SGetSelectionStageBetInfoFail();
/* 615 */         protocol.res = res;
/* 616 */         OnlineManager.getInstance().sendAtOnce(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), protocol);
/*     */         
/* 618 */         break;
/*     */       
/*     */       case 2: 
/* 621 */         SGetFinalStageBetInfoFail protocol = new SGetFinalStageBetInfoFail();
/* 622 */         protocol.res = res;
/* 623 */         OnlineManager.getInstance().sendAtOnce(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid(), protocol);
/*     */         
/* 625 */         break;
/*     */       }
/*     */       
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSendKnockoutStageBetMailFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 634 */     StringBuilder sb = new StringBuilder();
/* 635 */     sb.append(String.format("[crossbattle_bet]POnGetCrossBattleKnockoutStageBetInfoDone.processImp@send knockout stage bet mail fail|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|res=%d", new Object[] { Long.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getKnockoutType()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getFightZoneid()), Integer.valueOf(((GetCrossBattleKnockoutStageBetInfoDoneArg)this.arg).getStage()), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*     */ 
/* 639 */     if (extraInfo != null)
/*     */     {
/* 641 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 643 */         sb.append("|").append((String)entry.getKey());
/* 644 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 647 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */   
/*     */   private Map<Integer, GrcStageBetInfo> parseGrcResult(Octets result)
/*     */   {
/* 652 */     Map<Integer, GrcStageBetInfo> grcStageBetInfos = new HashMap();
/*     */     try
/*     */     {
/* 655 */       String jsonStr = OctetsStream.wrap(result).unmarshal_String("UTF-8");
/* 656 */       JSONObject jsonObject = new JSONObject(jsonStr);
/* 657 */       JSONArray stageBetInfo = jsonObject.getJSONArray("stage_bet_info");
/* 658 */       int length = stageBetInfo.length();
/* 659 */       for (int fightIndex = 1; fightIndex <= length; fightIndex++)
/*     */       {
/* 661 */         JSONObject fightBetInfo = stageBetInfo.getJSONObject(fightIndex - 1);
/* 662 */         grcStageBetInfos.put(Integer.valueOf(fightIndex), new GrcStageBetInfo(fightBetInfo.getLong("corps_a_bet_money_sum"), fightBetInfo.getLong("corps_b_bet_money_sum"), fightBetInfo.getLong("role_bet_corps_id"), fightBetInfo.getInt("role_bet_money_num")));
/*     */       }
/*     */     }
/*     */     catch (MarshalException e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 672 */     return grcStageBetInfos;
/*     */   }
/*     */   
/*     */ 
/*     */   private class GrcStageBetInfo
/*     */   {
/*     */     private final long corpsABetMoneySum;
/*     */     private final long corpsBBetMoneySum;
/*     */     private final long roleBetCorpsid;
/*     */     private final int roleBetMoneyNum;
/*     */     
/*     */     public GrcStageBetInfo(long corpsABetMoneySum, long corpsBBetMoneySum, long roleBetCorpsid, int roleBetMoneyNum)
/*     */     {
/* 685 */       this.corpsABetMoneySum = corpsABetMoneySum;
/* 686 */       this.corpsBBetMoneySum = corpsBBetMoneySum;
/* 687 */       this.roleBetCorpsid = roleBetCorpsid;
/* 688 */       this.roleBetMoneyNum = roleBetMoneyNum;
/*     */     }
/*     */     
/*     */     public long getCorpsABetMoneySum()
/*     */     {
/* 693 */       return this.corpsABetMoneySum;
/*     */     }
/*     */     
/*     */     public long getCorpsBBetMoneySum()
/*     */     {
/* 698 */       return this.corpsBBetMoneySum;
/*     */     }
/*     */     
/*     */     public long getRoleBetCorpsid()
/*     */     {
/* 703 */       return this.roleBetCorpsid;
/*     */     }
/*     */     
/*     */     public int getRoleBetMoneyNum()
/*     */     {
/* 708 */       return this.roleBetMoneyNum;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnGetCrossBattleKnockoutStageBetInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */