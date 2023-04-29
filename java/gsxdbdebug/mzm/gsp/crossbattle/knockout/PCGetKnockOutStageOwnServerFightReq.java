/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*    */ import mzm.gsp.util.Pair;
/*    */ import xbean.CrossBattleKnockoutOwnServerActivityInfo;
/*    */ import xbean.CrossBattleOwnServerKnockoutInfo;
/*    */ import xtable.Cross_battle_knockout_own_server;
/*    */ 
/*    */ public class PCGetKnockOutStageOwnServerFightReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityCfgId;
/*    */   private final int fightStage;
/*    */   private final int knockOutType;
/*    */   
/*    */   public PCGetKnockOutStageOwnServerFightReq(long roleId, int activityCfgId, int fightStage, int knockOutType)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.activityCfgId = activityCfgId;
/* 23 */     this.fightStage = fightStage;
/* 24 */     this.knockOutType = knockOutType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 31 */     if (sCrossBattleKnockOutCfg == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 37 */     if (knockOutCfg == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1559, true, true))
/*    */     {
/*    */ 
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     long globalActivityCfgId = GameServerInfoManager.toGlobalId(this.activityCfgId);
/* 49 */     CrossBattleKnockoutOwnServerActivityInfo xKnockoutOwnServerActivityInfo = Cross_battle_knockout_own_server.get(Long.valueOf(globalActivityCfgId));
/*    */     
/* 51 */     CrossBattleOwnServerKnockoutInfo xOwnServerKnockoutInfo = null;
/* 52 */     if (xKnockoutOwnServerActivityInfo != null)
/*    */     {
/* 54 */       xOwnServerKnockoutInfo = (CrossBattleOwnServerKnockoutInfo)xKnockoutOwnServerActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*    */     }
/*    */     
/*    */ 
/* 58 */     Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.knockOutType);
/* 59 */     if (nowFightStagePair == null)
/*    */     {
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     int maxFightZoneId = CrossBattleKnockoutManager.getMaxFightZone(this.activityCfgId, this.knockOutType);
/* 65 */     if (maxFightZoneId < 0)
/*    */     {
/* 67 */       return false;
/*    */     }
/* 69 */     int maxFightIndexId = CrossBattleKnockoutManager.getMaxFightIndexId(knockOutCfg.need_team_size, this.fightStage, knockOutCfg.fight_times_every_stage);
/*    */     
/*    */ 
/* 72 */     if ((xKnockoutOwnServerActivityInfo == null) || (xOwnServerKnockoutInfo == null) || (((Boolean)nowFightStagePair.second).booleanValue()))
/*    */     {
/* 74 */       return mzm.gsp.grc.main.GrcInterface.getCrossBattleKnockOutOwnServerInfo(this.roleId, this.activityCfgId, this.knockOutType, this.fightStage, maxFightZoneId, maxFightIndexId, GameServerInfoManager.getZoneIds());
/*    */     }
/*    */     
/*    */ 
/* 78 */     new PNotifyKnockOutOwnServerFight(this.roleId, this.activityCfgId, this.fightStage, this.knockOutType).execute();
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PCGetKnockOutStageOwnServerFightReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */