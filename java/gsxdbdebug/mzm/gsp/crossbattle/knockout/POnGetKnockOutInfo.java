/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_Award;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_CheckPanelReq;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_CreatePrepareWorld;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_FinalServerAward;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_GetFinalChampionCorpsInfo;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_GetFinalHistoryFightInfo;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_GetSpecialFightZoneStage;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_NotifyFightResult;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_ReportFightResult;
/*     */ import mzm.gsp.crossbattle.SCrossBattleHistoryNormalRes;
/*     */ import mzm.gsp.crossbattle.SCrossBattleSelectionNormalRes;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.event.GetFinalChampionMapStatue;
/*     */ import mzm.gsp.crossbattle.event.GetFinalChampionMapStatueArg;
/*     */ import mzm.gsp.crossbattle.event.GetKnockOutInfoArg;
/*     */ import mzm.gsp.crossbattle.event.GetKnockOutInfoProcedure;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnGetKnockOutInfo
/*     */   extends GetKnockOutInfoProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     OctetsStream octetsStream = new OctetsStream(((GetKnockOutInfoArg)this.arg).octets);
/*     */     
/*  40 */     GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/*  41 */     getKnockOutContext.unmarshal(octetsStream);
/*     */     
/*  43 */     OctetsStream contextStream = new OctetsStream(getKnockOutContext.content);
/*  44 */     int reqType = getKnockOutContext.oper_type;
/*     */     
/*  46 */     switch (reqType)
/*     */     {
/*     */     case 0: 
/*  49 */       GetKnockOutContext_CheckPanelReq checkPanelReq = new GetKnockOutContext_CheckPanelReq();
/*  50 */       checkPanelReq.unmarshal(contextStream);
/*     */       
/*  52 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/*  54 */         StringBuilder sb = new StringBuilder();
/*  55 */         sb.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@get fight selection stage  get knock out info failed");
/*  56 */         sb.append("|role_id=").append(checkPanelReq.role_id);
/*  57 */         sb.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/*  58 */         sb.append("|activity_cfg_id=").append(((GetKnockOutInfoArg)this.arg).activityCfgId);
/*  59 */         sb.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/*  60 */         sb.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/*  62 */         GameServer.logger().error(sb.toString());
/*     */         
/*  64 */         SCrossBattleSelectionNormalRes selectionNormalRes = new SCrossBattleSelectionNormalRes();
/*  65 */         selectionNormalRes.ret = 10;
/*     */         
/*  67 */         OnlineManager.getInstance().sendAtOnce(checkPanelReq.role_id, selectionNormalRes);
/*  68 */         return false;
/*     */       }
/*     */       
/*  71 */       return new PCGetCrossBattleKnockOutPanelInfo.PNotifyCrossBattleKnockOutPanelInfo(checkPanelReq.role_id, ((GetKnockOutInfoArg)this.arg).knockOutType).call();
/*     */     
/*     */     case 1: 
/*  74 */       GetKnockOutContext_GetSpecialFightZoneStage getSpecialFightZoneStage = new GetKnockOutContext_GetSpecialFightZoneStage();
/*  75 */       getSpecialFightZoneStage.unmarshal(contextStream);
/*     */       
/*  77 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/*  79 */         StringBuilder sb = new StringBuilder();
/*  80 */         sb.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@get fight selection stage  get knock out info failed");
/*  81 */         sb.append("|role_id=").append(getSpecialFightZoneStage.role_id);
/*  82 */         sb.append("|stage=").append(getSpecialFightZoneStage.fight_stage);
/*  83 */         sb.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/*  84 */         sb.append("|activity_cfg_id=").append(((GetKnockOutInfoArg)this.arg).activityCfgId);
/*  85 */         sb.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/*  86 */         sb.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/*  88 */         GameServer.logger().error(sb.toString());
/*     */         
/*  90 */         SCrossBattleSelectionNormalRes selectionNormalRes = new SCrossBattleSelectionNormalRes();
/*  91 */         selectionNormalRes.ret = 10;
/*     */         
/*  93 */         OnlineManager.getInstance().sendAtOnce(getSpecialFightZoneStage.role_id, selectionNormalRes);
/*  94 */         return false;
/*     */       }
/*     */       
/*  97 */       return new PCGetCrossBattleKnockOutFightStageReq.PNotifyGetCrossBattleKnockOutFightStageReq(getSpecialFightZoneStage.role_id, ((GetKnockOutInfoArg)this.arg).activityCfgId, ((GetKnockOutInfoArg)this.arg).knockOutType, ((GetKnockOutInfoArg)this.arg).fightZoneId, getSpecialFightZoneStage.fight_stage).call();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case 2: 
/* 104 */       GetKnockOutContext_CreatePrepareWorld createPrepareWorld = new GetKnockOutContext_CreatePrepareWorld();
/* 105 */       createPrepareWorld.unmarshal(contextStream);
/* 106 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/* 108 */         StringBuilder sb = new StringBuilder();
/* 109 */         sb.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@create prepare world corps get knock out info failed");
/* 110 */         sb.append("|corps_id=").append(createPrepareWorld.corps_id);
/* 111 */         sb.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/* 112 */         sb.append("|activity_cfg_id=").append(((GetKnockOutInfoArg)this.arg).activityCfgId);
/* 113 */         sb.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/* 114 */         sb.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/* 116 */         GameServer.logger().error(sb.toString());
/*     */         
/* 118 */         return false;
/*     */       }
/*     */       
/* 121 */       return new PNotifyCorpsKnockOutStageBegin(createPrepareWorld.corps_id, createPrepareWorld.fight_stage, ((GetKnockOutInfoArg)this.arg).knockOutType).call();
/*     */     
/*     */ 
/*     */     case 8: 
/* 125 */       GetKnockOutContext_ReportFightResult reportFightResult = new GetKnockOutContext_ReportFightResult();
/* 126 */       reportFightResult.unmarshal(contextStream);
/* 127 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/* 129 */         StringBuilder sBuilder = new StringBuilder();
/* 130 */         sBuilder.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@report fight result fail");
/* 131 */         sBuilder.append("|report_fight_result=").append(reportFightResult);
/* 132 */         sBuilder.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/* 133 */         sBuilder.append("|activity_cfg_id=").append(((GetKnockOutInfoArg)this.arg).activityCfgId);
/* 134 */         sBuilder.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/* 135 */         sBuilder.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/* 137 */         GameServer.logger().error(sBuilder.toString());
/*     */         
/* 139 */         return false;
/*     */       }
/*     */       
/* 142 */       return new POnReportKnockOutFightResult(((GetKnockOutInfoArg)this.arg).activityCfgId, ((GetKnockOutInfoArg)this.arg).knockOutType, ((GetKnockOutInfoArg)this.arg).fightZoneId, reportFightResult.fight_stage, reportFightResult.fight_index_id, reportFightResult.corps_id, reportFightResult.corps_name.getString("UTF-8"), reportFightResult.opponent_corps_id, reportFightResult.opponent_corps_name.getString("UTF-8"), reportFightResult.corps_fight_result, reportFightResult.repeat_times).call();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case 9: 
/* 151 */       GetKnockOutContext_NotifyFightResult notifyFightResult = new GetKnockOutContext_NotifyFightResult();
/* 152 */       notifyFightResult.unmarshal(contextStream);
/* 153 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/* 155 */         StringBuilder sb = new StringBuilder();
/* 156 */         sb.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@notify fight result failed");
/* 157 */         sb.append("|context=").append(notifyFightResult.toString());
/* 158 */         sb.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/* 159 */         sb.append("|activity_cfg_id=").append(((GetKnockOutInfoArg)this.arg).activityCfgId);
/* 160 */         sb.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/* 161 */         sb.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/* 163 */         GameServer.logger().error(sb.toString());
/* 164 */         return false;
/*     */       }
/*     */       
/* 167 */       return new PNotifyFightResult(notifyFightResult.role_id, notifyFightResult.corps_id, notifyFightResult.opponent_corps_id, notifyFightResult.knock_out_type, notifyFightResult.fight_stage, notifyFightResult.fight_index_id, notifyFightResult.win_or_lose, notifyFightResult.repeat_times).call();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case 10: 
/* 174 */       GetKnockOutContext_Award getKnockOutContext_award = new GetKnockOutContext_Award();
/* 175 */       getKnockOutContext_award.unmarshal(contextStream);
/* 176 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/* 178 */         StringBuilder sb = new StringBuilder();
/* 179 */         sb.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@knock out award");
/* 180 */         sb.append("|corps_id=").append(getKnockOutContext_award.corps_id);
/* 181 */         sb.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/* 182 */         sb.append("|activity_cfg_id=").append(((GetKnockOutInfoArg)this.arg).activityCfgId);
/* 183 */         sb.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/* 184 */         sb.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/* 186 */         GameServer.logger().error(sb.toString());
/*     */         
/* 188 */         return false;
/*     */       }
/*     */       
/* 191 */       return new PTryKnockOutAward.PKnockOutAward(((GetKnockOutInfoArg)this.arg).activityCfgId, ((GetKnockOutInfoArg)this.arg).knockOutType, getKnockOutContext_award.corps_id).call();
/*     */     
/*     */ 
/*     */     case 11: 
/* 195 */       GetKnockOutContext_GetFinalHistoryFightInfo getFinalHistoryFightInfo = new GetKnockOutContext_GetFinalHistoryFightInfo();
/* 196 */       getFinalHistoryFightInfo.unmarshal(contextStream);
/* 197 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/* 199 */         StringBuilder sb = new StringBuilder();
/* 200 */         sb.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@oper history get fight");
/* 201 */         sb.append("|session=").append(getFinalHistoryFightInfo.session);
/* 202 */         sb.append("|role_id=").append(getFinalHistoryFightInfo.role_id);
/* 203 */         sb.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/* 204 */         sb.append("|activity_cfg_id=").append(((GetKnockOutInfoArg)this.arg).activityCfgId);
/* 205 */         sb.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/* 206 */         sb.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/* 208 */         GameServer.logger().error(sb.toString());
/*     */         
/* 210 */         SCrossBattleHistoryNormalRes sCrossBattleHistoryNormalRes = new SCrossBattleHistoryNormalRes();
/* 211 */         sCrossBattleHistoryNormalRes.ret = 12;
/*     */         
/* 213 */         OnlineManager.getInstance().sendAtOnce(getFinalHistoryFightInfo.role_id, sCrossBattleHistoryNormalRes);
/* 214 */         return false;
/*     */       }
/*     */       
/* 217 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new PCGetCrossBattleFinalHistoryFightReq.PNotifyCrossBattleFinalHistoryFight(getFinalHistoryFightInfo.role_id, getFinalHistoryFightInfo.session, getFinalHistoryFightInfo.req_type));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */       break;
/*     */     case 12: 
/* 225 */       GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo getFinalHistoryTopThreeCorpsInfo = new GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo();
/* 226 */       getFinalHistoryTopThreeCorpsInfo.unmarshal(contextStream);
/* 227 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/* 229 */         StringBuilder sb = new StringBuilder();
/* 230 */         sb.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@oper history get fight");
/* 231 */         sb.append("|session=").append(getFinalHistoryTopThreeCorpsInfo.session);
/* 232 */         sb.append("|role_id=").append(getFinalHistoryTopThreeCorpsInfo.role_id);
/* 233 */         sb.append("|rank=").append(getFinalHistoryTopThreeCorpsInfo.rank);
/* 234 */         sb.append("|corps_id=").append(getFinalHistoryTopThreeCorpsInfo.corps_id);
/* 235 */         sb.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/* 236 */         sb.append("|activity_cfg_id=").append(((GetKnockOutInfoArg)this.arg).activityCfgId);
/* 237 */         sb.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/* 238 */         sb.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/* 240 */         GameServer.logger().info(sb.toString());
/*     */         
/* 242 */         SCrossBattleHistoryNormalRes sCrossBattleHistoryNormalRes = new SCrossBattleHistoryNormalRes();
/* 243 */         sCrossBattleHistoryNormalRes.ret = 12;
/*     */         
/* 245 */         OnlineManager.getInstance().sendAtOnce(getFinalHistoryTopThreeCorpsInfo.role_id, sCrossBattleHistoryNormalRes);
/*     */         
/* 247 */         return false;
/*     */       }
/*     */       
/* 250 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new PCGetCrossBattleFinalHistoryCorpsReq.PNotifyCrossBattleFinalHistoryCorps(getFinalHistoryTopThreeCorpsInfo.role_id, getFinalHistoryTopThreeCorpsInfo.session, getFinalHistoryTopThreeCorpsInfo.rank, getFinalHistoryTopThreeCorpsInfo.corps_id));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 257 */       break;
/*     */     case 13: 
/* 259 */       GetKnockOutContext_GetFinalChampionCorpsInfo getFinalChampionCorpsInfo = new GetKnockOutContext_GetFinalChampionCorpsInfo();
/* 260 */       getFinalChampionCorpsInfo.unmarshal(contextStream);
/* 261 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/*     */ 
/* 264 */         GetFinalChampionMapStatueArg getFinalChampionMapStatueArg = new GetFinalChampionMapStatueArg(false, true, getFinalChampionCorpsInfo.session, new FightStageEndCorpsInfo());
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 269 */         TriggerEventsManger.getInstance().triggerEvent(new GetFinalChampionMapStatue(), getFinalChampionMapStatueArg);
/*     */         
/* 271 */         StringBuilder sb = new StringBuilder();
/* 272 */         sb.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@get final champion corps info error");
/* 273 */         sb.append("|session=").append(getFinalChampionCorpsInfo.session);
/* 274 */         sb.append("|activity_cfg_id=").append(getFinalChampionCorpsInfo.activity_cfg_id);
/* 275 */         sb.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/* 276 */         sb.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/* 277 */         sb.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/* 279 */         GameServer.logger().error(sb.toString());
/* 280 */         return false;
/*     */       }
/* 282 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new PQueryCrossBattleFinalChampion.PNotifyCrossBattleFinalChampionCorpsInfo(getFinalChampionCorpsInfo.session, getFinalChampionCorpsInfo.activity_cfg_id));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 287 */       break;
/*     */     case 14: 
/* 289 */       GetKnockOutContext_FinalServerAward finalServerAward = new GetKnockOutContext_FinalServerAward();
/* 290 */       finalServerAward.unmarshal(contextStream);
/* 291 */       if (!((GetKnockOutInfoArg)this.arg).isSucceed())
/*     */       {
/* 293 */         StringBuilder sBuilder = new StringBuilder();
/* 294 */         sBuilder.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@get final server award info error");
/* 295 */         sBuilder.append("|ret_code=").append(((GetKnockOutInfoArg)this.arg).retcode);
/* 296 */         sBuilder.append("|activity_cfg_id=").append(((GetKnockOutInfoArg)this.arg).activityCfgId);
/* 297 */         sBuilder.append("|knock_out_type=").append(((GetKnockOutInfoArg)this.arg).knockOutType);
/* 298 */         sBuilder.append("|fight_zone_id=").append(((GetKnockOutInfoArg)this.arg).fightZoneId);
/*     */         
/* 300 */         GameServer.logger().error(sBuilder.toString());
/*     */       }
/* 302 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(((GetKnockOutInfoArg)this.arg).activityCfgId), new POnCrossBattleActivityEnd.PInitCrossBattleFinalServerAwardInfo(((GetKnockOutInfoArg)this.arg).activityCfgId));
/*     */       
/* 304 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/* 310 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnGetKnockOutInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */