/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.FightAgainstInfo;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_BetInKnockout;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_GetStageBetInfo;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_SettleStageBet;
/*     */ import mzm.gsp.crossbattle.SBetInFinalFail;
/*     */ import mzm.gsp.crossbattle.SBetInSelectionFail;
/*     */ import mzm.gsp.crossbattle.SGetFinalStageBetInfoFail;
/*     */ import mzm.gsp.crossbattle.SGetSelectionStageBetInfoFail;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetInfo;
/*     */ import mzm.gsp.crossbattle.event.GetKnockOutInfoArg;
/*     */ import mzm.gsp.crossbattle.event.GetKnockOutInfoProcedure;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleFightZoneInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnGetKnockoutInfo
/*     */   extends GetKnockOutInfoProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     SCrossBattleKnockoutBetInfo cfg = CrossBattleBetManager.getCrossBattleKnockoutBetInfo(((GetKnockOutInfoArg)this.arg).activityCfgId, ((GetKnockOutInfoArg)this.arg).knockOutType);
/*     */     
/*  39 */     if (cfg == null)
/*     */     {
/*     */ 
/*  42 */       return false;
/*     */     }
/*  44 */     int activityCfgid = ((GetKnockOutInfoArg)this.arg).activityCfgId;
/*  45 */     int knockoutType = ((GetKnockOutInfoArg)this.arg).knockOutType;
/*  46 */     int fightZoneid = ((GetKnockOutInfoArg)this.arg).fightZoneId;
/*  47 */     GetKnockOutContext context = new GetKnockOutContext();
/*  48 */     context.unmarshal(OctetsStream.wrap(((GetKnockOutInfoArg)this.arg).octets));
/*  49 */     switch (context.oper_type)
/*     */     {
/*     */ 
/*     */     case 3: 
/*  53 */       GetKnockOutContext_GetStageBetInfo content = new GetKnockOutContext_GetStageBetInfo();
/*  54 */       content.unmarshal(OctetsStream.wrap(context.content));
/*  55 */       long roleid = content.role_id;
/*  56 */       int stage = content.stage;
/*  57 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/*     */ 
/*  60 */         onGetSelectionStageBetInfoFail(2, null, roleid, activityCfgid, knockoutType, fightZoneid, stage);
/*     */         
/*  62 */         return false;
/*     */       }
/*     */       
/*  65 */       CrossBattleFightZoneInfo fightZoneInfo = CrossBattleKnockoutInterface.getCrossBattleKnockOutFightZoneInfo(activityCfgid, knockoutType, fightZoneid);
/*     */       
/*  67 */       if (fightZoneInfo == null)
/*     */       {
/*     */ 
/*  70 */         onGetSelectionStageBetInfoFail(2, null, roleid, activityCfgid, knockoutType, fightZoneid, stage);
/*     */         
/*  72 */         return false;
/*     */       }
/*  74 */       List<FightAgainstInfo> fightInfos = fightZoneInfo.getStagefightAgainstList(stage);
/*  75 */       CrossBattleBetManager.refreshXKnockoutStageBetInfo(activityCfgid, knockoutType, fightZoneid, stage, fightInfos);
/*     */       
/*  77 */       if (!GrcInterface.getCrossBattleKnockoutStageBetInfo(activityCfgid, knockoutType, fightZoneid, stage, fightInfos.size(), roleid, 0))
/*     */       {
/*     */ 
/*     */ 
/*  81 */         onGetSelectionStageBetInfoFail(1, null, roleid, activityCfgid, knockoutType, fightZoneid, stage);
/*     */         
/*  83 */         return false;
/*     */       }
/*     */       
/*  86 */       StringBuilder sb = new StringBuilder();
/*  87 */       sb.append(String.format("[crossbattle_bet]POnGetKnockoutInfo.processImp@get knockout stage bet info from grc|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage) }));
/*     */       
/*     */ 
/*  90 */       CrossBattleBetManager.logger.info(sb.toString());
/*  91 */       return true;
/*     */     
/*     */ 
/*     */     case 5: 
/*  95 */       GetKnockOutContext_BetInKnockout content = new GetKnockOutContext_BetInKnockout();
/*  96 */       content.unmarshal(OctetsStream.wrap(context.content));
/*  97 */       long roleid = content.role_id;
/*  98 */       int stage = content.stage;
/*  99 */       int fightIndex = content.fight_index;
/* 100 */       long betCorpsid = content.bet_corps_id;
/* 101 */       int sortid = content.sortid;
/* 102 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/*     */ 
/* 105 */         onBetInSelectionFail(2, null, roleid, activityCfgid, knockoutType, fightZoneid, stage, fightIndex, betCorpsid, sortid);
/*     */         
/* 107 */         return false;
/*     */       }
/* 109 */       String userid = RoleInterface.getUserId(roleid);
/*     */       
/* 111 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/* 113 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*     */       
/* 115 */       CrossBattleFightZoneInfo fightZoneInfo = CrossBattleKnockoutInterface.getCrossBattleKnockOutFightZoneInfo(activityCfgid, knockoutType, fightZoneid);
/*     */       
/* 117 */       if (fightZoneInfo == null)
/*     */       {
/*     */ 
/* 120 */         onBetInSelectionFail(2, null, roleid, activityCfgid, knockoutType, fightZoneid, stage, fightIndex, betCorpsid, sortid);
/*     */         
/* 122 */         return false;
/*     */       }
/* 124 */       int res = CrossBattleBetManager.betInKnockout(roleid, activityCfgid, knockoutType, fightZoneid, stage, fightIndex, betCorpsid, sortid, fightZoneInfo);
/*     */       
/* 126 */       if (res != 0)
/*     */       {
/* 128 */         onBetInSelectionFail(res, null, roleid, activityCfgid, knockoutType, fightZoneid, stage, fightIndex, betCorpsid, sortid);
/*     */         
/* 130 */         return false;
/*     */       }
/*     */       
/* 133 */       StringBuilder sb = new StringBuilder();
/* 134 */       sb.append(String.format("[crossbattle_bet]POnGetKnockoutInfo.processImp@bet in knockout success|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corpsid=%d|sortid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage), Integer.valueOf(fightIndex), Long.valueOf(betCorpsid), Integer.valueOf(sortid) }));
/*     */       
/*     */ 
/* 137 */       CrossBattleBetManager.logger.info(sb.toString());
/* 138 */       return true;
/*     */     
/*     */ 
/*     */     case 6: 
/* 142 */       GetKnockOutContext_SettleStageBet content = new GetKnockOutContext_SettleStageBet();
/* 143 */       content.unmarshal(OctetsStream.wrap(context.content));
/* 144 */       int stage = content.stage;
/* 145 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/*     */ 
/* 148 */         onSettleSelectionStageBetFail(11, null, activityCfgid, knockoutType, fightZoneid, stage);
/*     */         
/* 150 */         return false;
/*     */       }
/*     */       
/* 153 */       CrossBattleFightZoneInfo fightZoneInfo = CrossBattleKnockoutInterface.getCrossBattleKnockOutFightZoneInfo(activityCfgid, knockoutType, fightZoneid);
/*     */       
/* 155 */       if (fightZoneInfo == null)
/*     */       {
/*     */ 
/* 158 */         onSettleSelectionStageBetFail(11, null, activityCfgid, knockoutType, fightZoneid, stage);
/*     */         
/* 160 */         return false;
/*     */       }
/* 162 */       int res = CrossBattleBetManager.settleKnockoutStageBet(activityCfgid, knockoutType, fightZoneid, stage, fightZoneInfo);
/*     */       
/* 164 */       if (res != 0)
/*     */       {
/* 166 */         onSettleSelectionStageBetFail(res, null, activityCfgid, knockoutType, fightZoneid, stage);
/* 167 */         return false;
/*     */       }
/* 169 */       StringBuilder sb = new StringBuilder();
/* 170 */       sb.append(String.format("[crossbattle_bet]POnGetKnockoutInfo.processImp@settle knockout stage bet success|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage) }));
/*     */       
/*     */ 
/* 173 */       CrossBattleBetManager.logger.info(sb.toString());
/* 174 */       return true;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 179 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onGetSelectionStageBetInfoFail(int res, Map<String, Object> extraInfo, long roleid, int activityCfgid, int knockoutType, int fightZoneid, int stage)
/*     */   {
/* 185 */     StringBuilder sb = new StringBuilder();
/* 186 */     sb.append(String.format("[crossbattle_bet]POnGetKnockoutInfo.processImp@get knockout stage bet info fail|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|res=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 189 */     if (extraInfo != null)
/*     */     {
/* 191 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 193 */         sb.append("|").append((String)entry.getKey());
/* 194 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 197 */     CrossBattleBetManager.logger.info(sb.toString());
/* 198 */     if (res > 0)
/*     */     {
/* 200 */       switch (knockoutType)
/*     */       {
/*     */ 
/*     */       case 1: 
/* 204 */         SGetSelectionStageBetInfoFail protocol = new SGetSelectionStageBetInfoFail();
/* 205 */         protocol.res = res;
/* 206 */         OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*     */         
/* 208 */         break;
/*     */       
/*     */       case 2: 
/* 211 */         SGetFinalStageBetInfoFail protocol = new SGetFinalStageBetInfoFail();
/* 212 */         protocol.res = res;
/* 213 */         OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*     */         
/* 215 */         break;
/*     */       }
/*     */       
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onBetInSelectionFail(int res, Map<String, Object> extraInfo, long roleid, int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightIndex, long betCorpsid, int sortid)
/*     */   {
/* 226 */     StringBuilder sb = new StringBuilder();
/* 227 */     sb.append(String.format("[crossbattle_bet]POnGetKnockoutInfo.processImp@bet in knockout fail|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corpsid=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage), Integer.valueOf(fightIndex), Long.valueOf(betCorpsid), Integer.valueOf(sortid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 230 */     if (extraInfo != null)
/*     */     {
/* 232 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 234 */         sb.append("|").append((String)entry.getKey());
/* 235 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 238 */     CrossBattleBetManager.logger.info(sb.toString());
/* 239 */     if (res > 0)
/*     */     {
/* 241 */       switch (knockoutType)
/*     */       {
/*     */ 
/*     */       case 1: 
/* 245 */         SBetInSelectionFail protocol = new SBetInSelectionFail();
/* 246 */         protocol.res = res;
/* 247 */         OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*     */         
/* 249 */         break;
/*     */       
/*     */       case 2: 
/* 252 */         SBetInFinalFail protocol = new SBetInFinalFail();
/* 253 */         protocol.res = res;
/* 254 */         OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*     */         
/* 256 */         break;
/*     */       }
/*     */       
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onSettleSelectionStageBetFail(int res, Map<String, Object> extraInfo, int activityCfgid, int knockoutType, int fightZoneid, int stage)
/*     */   {
/* 266 */     StringBuilder sb = new StringBuilder();
/* 267 */     sb.append(String.format("[crossbattle_bet]POnGetKnockoutInfo.processImp@settle knockout stage bet fail|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|res=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 270 */     if (extraInfo != null)
/*     */     {
/* 272 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 274 */         sb.append("|").append((String)entry.getKey());
/* 275 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 278 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnGetKnockoutInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */