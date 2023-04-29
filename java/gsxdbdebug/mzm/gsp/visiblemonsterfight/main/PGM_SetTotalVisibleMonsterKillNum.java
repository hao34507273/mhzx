/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.GlobalVisibleMonsterInfo;
/*    */ import xbean.VisibleMonsterInfo;
/*    */ import xtable.Visiblemonster;
/*    */ 
/*    */ public class PGM_SetTotalVisibleMonsterKillNum extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityCfgId;
/*    */   private final int monsterType;
/*    */   private final int nowKillTimes;
/*    */   
/*    */   public PGM_SetTotalVisibleMonsterKillNum(long roleId, int activityCfgId, int monsterType, int nowKillTimes)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.activityCfgId = activityCfgId;
/* 21 */     this.monsterType = monsterType;
/* 22 */     this.nowKillTimes = nowKillTimes;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     GlobalVisibleMonsterInfo xGlobalVisibleMonsterInfo = Visiblemonster.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 29 */     if (xGlobalVisibleMonsterInfo == null)
/*    */     {
/* 31 */       xGlobalVisibleMonsterInfo = xbean.Pod.newGlobalVisibleMonsterInfo();
/* 32 */       Visiblemonster.add(Long.valueOf(GameServerInfoManager.getLocalId()), xGlobalVisibleMonsterInfo);
/*    */     }
/*    */     
/* 35 */     Map<Integer, VisibleMonsterInfo> xActivityCfgId2VisibleMonsterMap = xGlobalVisibleMonsterInfo.getActivity_visible_monster_map();
/* 36 */     VisibleMonsterInfo xVisibleMonsterInfo = (VisibleMonsterInfo)xActivityCfgId2VisibleMonsterMap.get(Integer.valueOf(this.activityCfgId));
/* 37 */     if (xVisibleMonsterInfo == null)
/*    */     {
/* 39 */       xVisibleMonsterInfo = xbean.Pod.newVisibleMonsterInfo();
/* 40 */       xActivityCfgId2VisibleMonsterMap.put(Integer.valueOf(this.activityCfgId), xVisibleMonsterInfo);
/*    */     }
/*    */     
/* 43 */     Map<Integer, Integer> xMonsterType2KillNumMap = xVisibleMonsterInfo.getMonster_type_times_map();
/* 44 */     xMonsterType2KillNumMap.put(Integer.valueOf(this.monsterType), Integer.valueOf(this.nowKillTimes));
/*    */     
/* 46 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("当前世界击杀总次数 %d 次!", new Object[] { Integer.valueOf(this.nowKillTimes) }));
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\PGM_SetTotalVisibleMonsterKillNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */