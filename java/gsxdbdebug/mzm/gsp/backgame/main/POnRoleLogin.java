/*     */ package mzm.gsp.backgame.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.backgame.SSyncBackGameInfo;
/*     */ import mzm.gsp.backgame.confbean.BackGameConsts;
/*     */ import mzm.gsp.backgame.confbean.SBackGameAwardCfg;
/*     */ import mzm.gsp.backgame.confbean.SBackGameAwardIndexCfg;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2BackGameInfo;
/*     */ import xtable.Role2backgame;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  28 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  30 */       return false;
/*     */     }
/*     */     
/*  33 */     String userId = RoleInterface.getUserId(roleId);
/*  34 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  37 */     int roleLevel = RoleInterface.getLevel(roleId);
/*  38 */     if (roleLevel < BackGameConsts.getInstance().minRoleLevel)
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  44 */     long lastLogOffTime = RoleInterface.getLastLogoffTime(roleId);
/*     */     
/*  46 */     long offLineTime = currentTimeMillis - lastLogOffTime;
/*  47 */     boolean isOffLineTimeEnough = offLineTime >= BackGameConsts.getInstance().needOffLineTime * 86400000L;
/*     */     
/*     */ 
/*  50 */     Role2BackGameInfo xRole2BackGameInfo = Role2backgame.get(Long.valueOf(roleId));
/*  51 */     if (xRole2BackGameInfo == null)
/*     */     {
/*  53 */       if (!isOffLineTimeEnough)
/*     */       {
/*  55 */         return true;
/*     */       }
/*     */       
/*  58 */       xRole2BackGameInfo = xbean.Pod.newRole2BackGameInfo();
/*  59 */       Role2backgame.add(Long.valueOf(roleId), xRole2BackGameInfo);
/*     */     }
/*     */     
/*  62 */     if (currentTimeMillis - xRole2BackGameInfo.getBack_state_start_time() > BackGameConsts.getInstance().limitDeltaDay * 86400000L)
/*     */     {
/*     */ 
/*  65 */       if (!isOffLineTimeEnough)
/*     */       {
/*  67 */         return true;
/*     */       }
/*     */       
/*  70 */       int offLineDays = (int)(offLineTime / 86400000L);
/*  71 */       xRole2BackGameInfo.setBack_game_level(roleLevel);
/*  72 */       xRole2BackGameInfo.setBack_state_start_time(currentTimeMillis);
/*  73 */       xRole2BackGameInfo.setClear_score_time(currentTimeMillis);
/*  74 */       xRole2BackGameInfo.setOffline_days(offLineDays);
/*  75 */       xRole2BackGameInfo.getAleardy_awarded_score_index_list().clear();
/*     */       
/*  77 */       long nowYuanBaoSaveAmtBaseValue = QingfuInterface.getSaveAmt(userId, true);
/*  78 */       int nowActiveBaseValue = ActiveInterface.getTotalActiveValue(roleId);
/*     */       
/*  80 */       xRole2BackGameInfo.setActive_base_value(nowActiveBaseValue);
/*  81 */       xRole2BackGameInfo.setYuan_bao_save_amt_base_value(nowYuanBaoSaveAmtBaseValue);
/*     */       
/*  83 */       BackGameManager.tlogBackGameStatis(roleId, roleLevel, userId, offLineDays);
/*     */     }
/*     */     
/*  86 */     long xBackGameStartTime = xRole2BackGameInfo.getBack_state_start_time();
/*  87 */     if (!BackGameManager.isInBackState(currentTimeMillis, xBackGameStartTime))
/*     */     {
/*  89 */       return true;
/*     */     }
/*     */     
/*  92 */     BackGameManager.checkAndClearBackGameScore(xRole2BackGameInfo, userId, roleId, -1L, -1, "POnRoleLogin.processImp");
/*     */     
/*  94 */     int awardDay = BackGameManager.getAwardReservedExpDayRatio(xRole2BackGameInfo.getOffline_days());
/*  95 */     int awardLevel = xRole2BackGameInfo.getBack_game_level();
/*     */     
/*  97 */     SSyncBackGameInfo sSyncBackGameInfo = new SSyncBackGameInfo();
/*  98 */     sSyncBackGameInfo.award_back_game_level = xRole2BackGameInfo.getBack_game_level();
/*  99 */     sSyncBackGameInfo.award_day = awardDay;
/* 100 */     sSyncBackGameInfo.current_score_value = BackGameManager.getNowBackGameScoreValue(userId, roleId, xRole2BackGameInfo);
/*     */     
/* 102 */     SBackGameAwardCfg sBackGameDayAwardCfg = SBackGameAwardCfg.get(awardLevel);
/*     */     
/* 104 */     if (sBackGameDayAwardCfg == null)
/*     */     {
/* 106 */       GameServer.logger().warn(String.format("[backgame]POnRoleLogin.processImp@back game award cfg is null|role_id=%d|award_level=%d|award_day=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardLevel), Integer.valueOf(awardDay) }));
/*     */       
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     List<Integer> aleardyAwardedScoreIndexList = xRole2BackGameInfo.getAleardy_awarded_score_index_list();
/* 114 */     int size = aleardyAwardedScoreIndexList.size();
/*     */     
/* 116 */     TreeMap<Integer, SBackGameAwardIndexCfg> sBackGameAwardIndexMap = (TreeMap)SBackGameAwardIndexCfg.getAll();
/*     */     
/* 118 */     if (size == SBackGameAwardIndexCfg.getAll().size())
/*     */     {
/* 120 */       sSyncBackGameInfo.current_award_score_index_id = -1;
/*     */     }
/* 122 */     else if (size == 0)
/*     */     {
/* 124 */       sSyncBackGameInfo.current_award_score_index_id = ((Integer)sBackGameAwardIndexMap.firstKey()).intValue();
/*     */     }
/*     */     else
/*     */     {
/* 128 */       Integer currentAwardScoreIndexId = (Integer)sBackGameAwardIndexMap.higherKey(aleardyAwardedScoreIndexList.get(size - 1));
/* 129 */       if (currentAwardScoreIndexId == null)
/*     */       {
/*     */ 
/* 132 */         GameServer.logger().warn(String.format("[backgame]POnRoleLogin.processImp@back game index award cfg is null|role_id=%d|award_level=%d|award_day=%d|alwardy_awarded_score_index_list=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardLevel), Integer.valueOf(awardDay), aleardyAwardedScoreIndexList.toString() }));
/*     */         
/*     */ 
/*     */ 
/* 136 */         return false;
/*     */       }
/* 138 */       sSyncBackGameInfo.current_award_score_index_id = currentAwardScoreIndexId.intValue();
/*     */     }
/* 140 */     long serviceTime = 86400000L * BackGameConsts.getInstance().lastTime;
/* 141 */     long elpasedTime = DateTimeUtils.getCurrTimeInMillis() - xBackGameStartTime;
/* 142 */     sSyncBackGameInfo.left_time = ((serviceTime - elpasedTime) / 1000L);
/* 143 */     OnlineManager.getInstance().send(roleId, sSyncBackGameInfo);
/*     */     
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */