/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.corps.main.CorpsInfo;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.CrossBattleKnockoutActivityLocalInfo;
/*    */ import xbean.CrossBattleKnockoutLocalInfo;
/*    */ import xbean.FightZoneLocalInfo;
/*    */ 
/*    */ public class PGM_QueryAwardCorpsName extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityCfgId;
/*    */   private final int knockOutType;
/*    */   private final int fightZoneId;
/*    */   
/*    */   public PGM_QueryAwardCorpsName(long roleId, int activityCfgId, int knockOutType, int fightZoneId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.activityCfgId = activityCfgId;
/* 23 */     this.knockOutType = knockOutType;
/* 24 */     this.fightZoneId = fightZoneId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     long globalActivityCfgId = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgId);
/*    */     
/* 32 */     CrossBattleKnockoutActivityLocalInfo xCrossBattleKnockoutActivityLocalInfo = xtable.Cross_battle_knockout_local.select(Long.valueOf(globalActivityCfgId));
/* 33 */     if (xCrossBattleKnockoutActivityLocalInfo == null)
/*    */     {
/* 35 */       GmManager.getInstance().sendResultToGM(this.roleId, "当前没有活动数据,没有已经发过奖的战队");
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     CrossBattleKnockoutLocalInfo xCrossBattleKnockoutLocalInfo = (CrossBattleKnockoutLocalInfo)xCrossBattleKnockoutActivityLocalInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*    */     
/* 41 */     if (xCrossBattleKnockoutLocalInfo == null)
/*    */     {
/* 43 */       GmManager.getInstance().sendResultToGM(this.roleId, "当前没有淘汰赛数据");
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     FightZoneLocalInfo xFightZoneLocalInfo = (FightZoneLocalInfo)xCrossBattleKnockoutLocalInfo.getFight_zone_info_map().get(Integer.valueOf(this.fightZoneId));
/*    */     
/* 49 */     if (xFightZoneLocalInfo == null)
/*    */     {
/* 51 */       GmManager.getInstance().sendResultToGM(this.roleId, "找不到战区数据");
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     Set<Long> corpsIdSet = xFightZoneLocalInfo.getAward_corps_id_set();
/* 56 */     lock(xtable.Corps.getTable(), corpsIdSet);
/* 57 */     java.util.List<String> corpsStrList = new java.util.ArrayList();
/* 58 */     for (Iterator i$ = corpsIdSet.iterator(); i$.hasNext();) { long corpsId = ((Long)i$.next()).longValue();
/*    */       
/* 60 */       CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByCorpsId(corpsId, true);
/* 61 */       if (corpsInfo == null)
/*    */       {
/* 63 */         GmManager.getInstance().sendResultToGM(this.roleId, "战队数据找不到");
/*    */       }
/*    */       else {
/* 66 */         corpsStrList.add(corpsInfo.getCorpsName());
/*    */       }
/*    */     }
/* 69 */     GmManager.getInstance().sendResultToGM(this.roleId, corpsStrList.toString());
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_QueryAwardCorpsName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */