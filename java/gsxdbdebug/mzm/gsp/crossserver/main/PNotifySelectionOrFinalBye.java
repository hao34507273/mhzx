/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutManager;
/*     */ import mzm.gsp.crossbattle.knockout.KnockOutTLogManager;
/*     */ import mzm.gsp.crossbattle.knockout.PQueryToNotifyFightResult;
/*     */ import mzm.gsp.crossbattle.knockout.RRepeatReportCrossBattleKnockOutFightResult;
/*     */ import mzm.gsp.crossbattle.knockout.SignalFightResultEnum;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PNotifySelectionOrFinalBye
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final KnockOutContext knockOutContext;
/*     */   
/*     */   public PNotifySelectionOrFinalBye(KnockOutContext knockOutContext)
/*     */   {
/*  36 */     this.knockOutContext = knockOutContext;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     long corpsId = this.knockOutContext.crossBattleTeamInfo.getCorpsId();
/*  43 */     int activityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*  44 */     List<Long> corpsRoleIdList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(corpsId, activityCfgId, false);
/*     */     
/*  46 */     List<String> userIdList = new ArrayList();
/*  47 */     for (Iterator i$ = corpsRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  49 */       String userId = RoleInterface.getUserId(roleId);
/*  50 */       userIdList.add(userId);
/*     */     }
/*     */     
/*  53 */     lock(User.getTable(), userIdList);
/*  54 */     lock(Role2properties.getTable(), corpsRoleIdList);
/*     */     
/*  56 */     for (Iterator i$ = corpsRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  58 */       RoleStatusInterface.unsetStatus(roleId, 1551);
/*     */     }
/*  60 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/*  61 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutContext.fightType));
/*  67 */     if (knockOutCfg == null)
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     KnockOutTeamInfo knockOutTeamInfo = this.knockOutContext.crossBattleTeamInfo;
/*  73 */     final long opponentCorpsId = knockOutTeamInfo.getOpponentCorpsId();
/*  74 */     int knockOutType = this.knockOutContext.fightType;
/*  75 */     final int fightStage = this.knockOutContext.fightStage;
/*  76 */     int fightIndexId = this.knockOutContext.fightIndexId;
/*     */     
/*  78 */     int fightZoneId = CrossBattleKnockoutManager.getFightZone(corpsId, activityCfgId, this.knockOutContext.fightType);
/*  79 */     if (fightZoneId < 0)
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     boolean isSendSuccess = GrcInterface.reportCrossBattleKnockOutFightResult(activityCfgId, this.knockOutContext.fightType, fightZoneId, this.knockOutContext.fightStage, knockOutTeamInfo.getCorpsId(), knockOutTeamInfo.getCorpsName(), knockOutTeamInfo.getOpponentCorpsId(), knockOutTeamInfo.getOpponentCorpsName(), this.knockOutContext.fightIndexId, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, String.valueOf(SignalFightResultEnum.ABSTAIN_WIN.fightResult));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  89 */     if (!isSendSuccess)
/*     */     {
/*  91 */       Xdb.executor().schedule(new RRepeatReportCrossBattleKnockOutFightResult(activityCfgId, this.knockOutContext.fightType, fightZoneId, this.knockOutContext.fightStage, knockOutTeamInfo.getCorpsId(), knockOutTeamInfo.getCorpsName(), knockOutTeamInfo.getOpponentCorpsId(), knockOutTeamInfo.getOpponentCorpsName(), this.knockOutContext.fightIndexId, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, String.valueOf(SignalFightResultEnum.ABSTAIN_WIN.fightResult), 1), 60L, TimeUnit.MILLISECONDS);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */       StringBuilder sBuilder = new StringBuilder();
/* 107 */       sBuilder.append("[crossbattle_knockout]PNotifySelectionOrFinalBye.processImp@notify bye fail");
/* 108 */       sBuilder.append("|knock_out_context=").append(this.knockOutContext);
/* 109 */       sBuilder.append("|is_send_success=").append(isSendSuccess);
/*     */       
/* 111 */       GameServer.logger().info(sBuilder.toString());
/*     */     }
/*     */     else
/*     */     {
/* 115 */       StringBuilder sBuilder = new StringBuilder();
/* 116 */       sBuilder.append("[crossbattle_knockout]PNotifySelectionOrFinalBye.processImp@notify bye success");
/* 117 */       sBuilder.append("|knock_out_context=").append(this.knockOutContext);
/* 118 */       sBuilder.append("|is_send_success=").append(isSendSuccess);
/*     */       
/* 120 */       GameServer.logger().info(sBuilder.toString());
/*     */     }
/*     */     Iterator i$;
/* 123 */     if ((corpsRoleIdList != null) && (!corpsRoleIdList.isEmpty()))
/*     */     {
/* 125 */       for (i$ = corpsRoleIdList.iterator(); i$.hasNext();) { final long corpsRoleId = ((Long)i$.next()).longValue();
/*     */         
/* 127 */         Xdb.executor().schedule(new Runnable()
/*     */         {
/*     */ 
/*     */ 
/*     */           public void run() {
/* 132 */             new PQueryToNotifyFightResult(corpsRoleId, opponentCorpsId, fightStage, this.val$knockOutType, this.val$fightStage, this.val$fightIndexId, 1).execute(); } }, 2000L, TimeUnit.MILLISECONDS);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 139 */     KnockOutTLogManager.tlogKnockOutFightResult(activityCfgId, knockOutType, fightZoneId, this.knockOutContext.fightStage, fightIndexId, corpsId, knockOutTeamInfo.getCorpsName(), knockOutTeamInfo.getOpponentCorpsId(), knockOutTeamInfo.getOpponentCorpsName(), SignalFightResultEnum.ABSTAIN_WIN.fightResult);
/*     */     
/*     */ 
/*     */ 
/* 143 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PNotifySelectionOrFinalBye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */