/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.corps.main.CorpsInfo;
/*    */ import mzm.gsp.corps.main.CorpsInterface;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.crossbattle.point.CrossBattlePointInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CrossBattleOwn;
/*    */ import xtable.Cross_battle_owns;
/*    */ 
/*    */ public class PGM_SetSelectionCoprs extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int rank;
/*    */   
/*    */   public PGM_SetSelectionCoprs(long roleId, int rank)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.rank = rank;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     long corpsId = CorpsInterface.getRoleCorpsId(this.roleId, true);
/* 30 */     if (corpsId < 0L)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有战队");
/* 33 */       return false;
/*    */     }
/* 35 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(corpsId, true);
/* 36 */     if (corpsInfo == null)
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.roleId, "战队信息获取错误");
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     int nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/* 43 */     int fightZoneId = CrossBattleKnockoutManager.getFightZone(corpsId, nowActivityCfgId, 1);
/* 44 */     if (fightZoneId < 0)
/*    */     {
/* 46 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有划分战区");
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(nowActivityCfgId);
/* 51 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 52 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*    */     {
/* 54 */       GmManager.getInstance().sendResultToGM(this.roleId, "战队未报名循环赛");
/* 55 */       return false;
/*    */     }
/* 57 */     xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().add(Long.valueOf(corpsId));
/*    */     
/* 59 */     int nowFightZoneId = CrossBattlePointInterface.getCorpsZone(nowActivityCfgId, corpsId);
/*    */     
/* 61 */     int zoneId = GameServerInfoManager.getZoneId();
/* 62 */     String corpsName = corpsInfo.getCorpsName();
/* 63 */     int badgeId = corpsInfo.getCorpsBadgeId();
/*    */     
/* 65 */     boolean grcSend = GrcInterface.gmSetSelectionCorpsInfo(nowActivityCfgId, nowFightZoneId, corpsId, this.rank, corpsName, badgeId, zoneId);
/*    */     
/*    */ 
/* 68 */     if (!grcSend)
/*    */     {
/* 70 */       GmManager.getInstance().sendResultToGM(this.roleId, "grc通信失败");
/* 71 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 75 */     GmManager.getInstance().sendResultToGM(this.roleId, "grc通信成功,成功写入数据");
/*    */     
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_SetSelectionCoprs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */