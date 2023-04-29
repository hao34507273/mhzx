/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.corps.main.CorpsInfo;
/*    */ import mzm.gsp.corps.main.CorpsInterface;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ import xbean.CrossBattleOwn;
/*    */ 
/*    */ public class PGM_SetFinalCorpsInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int fightZoneId;
/*    */   private final int rank;
/*    */   
/*    */   public PGM_SetFinalCorpsInfo(long roleId, int fightZoneId, int rank)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.fightZoneId = fightZoneId;
/* 25 */     this.rank = rank;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     long corpsId = CorpsInterface.getRoleCorpsId(this.roleId, true);
/* 32 */     if (corpsId < 0L)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有战队");
/* 35 */       return false;
/*    */     }
/* 37 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(corpsId, true);
/* 38 */     if (corpsInfo == null)
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.roleId, "战队信息获取错误");
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     int nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*    */     
/* 46 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(nowActivityCfgId);
/* 47 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 48 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*    */     {
/* 50 */       GmManager.getInstance().sendResultToGM(this.roleId, "战队未报名循环赛");
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().add(Long.valueOf(corpsId));
/*    */     
/* 56 */     int zoneId = GameServerInfoManager.getZoneId();
/* 57 */     String corpsName = corpsInfo.getCorpsName();
/* 58 */     int badgeId = corpsInfo.getCorpsBadgeId();
/*    */     
/* 60 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/* 61 */     if (sCrossBattleKnockOutCfg == null)
/*    */     {
/* 63 */       GmManager.getInstance().sendResultToGM(this.roleId, "淘汰赛配置不存在");
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(1));
/* 68 */     if (knockOutCfg == null)
/*    */     {
/* 70 */       GmManager.getInstance().sendResultToGM(this.roleId, "选拔赛配置不存在");
/* 71 */       return false;
/*    */     }
/*    */     
/* 74 */     boolean grcSend = GrcInterface.gmSetFinalCorpsInfo(nowActivityCfgId, this.fightZoneId, this.rank, corpsId, corpsName, badgeId, zoneId, knockOutCfg.stage_name_list.size());
/*    */     
/*    */ 
/* 77 */     if (!grcSend)
/*    */     {
/* 79 */       GmManager.getInstance().sendResultToGM(this.roleId, "grc通信失败");
/* 80 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 84 */     GmManager.getInstance().sendResultToGM(this.roleId, "grc通信成功,成功写入数据");
/*    */     
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_SetFinalCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */