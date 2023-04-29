/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GlobalVisibleMonsterInfo;
/*    */ import xbean.VisibleMonsterInfo;
/*    */ 
/*    */ public class PGM_GetTotalVisibleMonsterKillNum extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityCfgId;
/*    */   private final int monsterType;
/*    */   
/*    */   public PGM_GetTotalVisibleMonsterKillNum(long roleId, int activityCfgId, int monsterType)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.activityCfgId = activityCfgId;
/* 20 */     this.monsterType = monsterType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     GlobalVisibleMonsterInfo xGlobalVisibleMonsterInfo = xtable.Visiblemonster.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 27 */     if (xGlobalVisibleMonsterInfo == null)
/*    */     {
/* 29 */       sendKillNumMessage(0);
/* 30 */       return true;
/*    */     }
/*    */     
/* 33 */     Map<Integer, VisibleMonsterInfo> xActivityCfgId2VisibleMonsterMap = xGlobalVisibleMonsterInfo.getActivity_visible_monster_map();
/* 34 */     VisibleMonsterInfo xVisibleMonsterInfo = (VisibleMonsterInfo)xActivityCfgId2VisibleMonsterMap.get(Integer.valueOf(this.activityCfgId));
/* 35 */     if (xVisibleMonsterInfo == null)
/*    */     {
/* 37 */       sendKillNumMessage(0);
/* 38 */       return true;
/*    */     }
/*    */     
/* 41 */     Map<Integer, Integer> xMonsterType2KillNumMap = xVisibleMonsterInfo.getMonster_type_times_map();
/* 42 */     Integer killMonsterTimes = (Integer)xMonsterType2KillNumMap.get(Integer.valueOf(this.monsterType));
/* 43 */     if (killMonsterTimes == null)
/*    */     {
/* 45 */       sendKillNumMessage(0);
/* 46 */       return true;
/*    */     }
/*    */     
/* 49 */     sendKillNumMessage(killMonsterTimes.intValue());
/*    */     
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   private void sendKillNumMessage(int killTimes)
/*    */   {
/* 56 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 57 */     messagetip.result = Integer.MAX_VALUE;
/* 58 */     messagetip.args.add(String.format("当前世界击杀总次数 %d 次!", new Object[] { Integer.valueOf(killTimes) }));
/* 59 */     OnlineManager.getInstance().sendAtOnce(this.roleId, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\PGM_GetTotalVisibleMonsterKillNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */