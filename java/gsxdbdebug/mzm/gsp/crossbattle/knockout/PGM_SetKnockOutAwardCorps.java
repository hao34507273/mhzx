/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.CrossBattleKnockoutActivityLocalInfo;
/*    */ import xbean.CrossBattleKnockoutLocalInfo;
/*    */ import xbean.FightZoneLocalInfo;
/*    */ 
/*    */ public class PGM_SetKnockOutAwardCorps extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int activityCfgId;
/*    */   private final int knockOutType;
/*    */   private final int fightZoneId;
/*    */   
/*    */   public PGM_SetKnockOutAwardCorps(long gmRoleId, int activityCfgId, int knockOutType, int fightZoneId)
/*    */   {
/* 18 */     this.gmRoleId = gmRoleId;
/* 19 */     this.activityCfgId = activityCfgId;
/* 20 */     this.knockOutType = knockOutType;
/* 21 */     this.fightZoneId = fightZoneId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     mzm.gsp.corps.main.CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByRoleId(this.gmRoleId, false, false);
/* 28 */     if (corpsInfo == null)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "没有战队");
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     long globalActivityCfgId = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgId);
/* 35 */     CrossBattleKnockoutActivityLocalInfo xCrossBattleKnockoutActivityLocalInfo = xtable.Cross_battle_knockout_local.get(Long.valueOf(globalActivityCfgId));
/* 36 */     if (xCrossBattleKnockoutActivityLocalInfo == null)
/*    */     {
/* 38 */       xCrossBattleKnockoutActivityLocalInfo = xbean.Pod.newCrossBattleKnockoutActivityLocalInfo();
/* 39 */       xtable.Cross_battle_knockout_local.add(Long.valueOf(globalActivityCfgId), xCrossBattleKnockoutActivityLocalInfo);
/*    */     }
/*    */     
/* 42 */     CrossBattleKnockoutLocalInfo xCrossBattleKnockoutLocalInfo = (CrossBattleKnockoutLocalInfo)xCrossBattleKnockoutActivityLocalInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*    */     
/* 44 */     if (xCrossBattleKnockoutLocalInfo == null)
/*    */     {
/* 46 */       xCrossBattleKnockoutLocalInfo = xbean.Pod.newCrossBattleKnockoutLocalInfo();
/* 47 */       xCrossBattleKnockoutActivityLocalInfo.getKnockout_info_map().put(Integer.valueOf(this.knockOutType), xCrossBattleKnockoutLocalInfo);
/*    */     }
/*    */     
/* 50 */     FightZoneLocalInfo xFightZoneLocalInfo = (FightZoneLocalInfo)xCrossBattleKnockoutLocalInfo.getFight_zone_info_map().get(Integer.valueOf(this.fightZoneId));
/*    */     
/* 52 */     if (xFightZoneLocalInfo == null)
/*    */     {
/* 54 */       xFightZoneLocalInfo = xbean.Pod.newFightZoneLocalInfo();
/* 55 */       xCrossBattleKnockoutLocalInfo.getFight_zone_info_map().put(Integer.valueOf(this.fightZoneId), xFightZoneLocalInfo);
/*    */     }
/*    */     
/* 58 */     boolean isSuccess = xFightZoneLocalInfo.getAward_corps_id_set().add(Long.valueOf(corpsInfo.getCorpsId()));
/* 59 */     if (!isSuccess)
/*    */     {
/* 61 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "已经有该战队了");
/* 62 */       return false;
/*    */     }
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_SetKnockOutAwardCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */