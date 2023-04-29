/*     */ package mzm.gsp.backgame.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.backgame.SSyncBackGameInfo;
/*     */ import mzm.gsp.backgame.confbean.BackGameConsts;
/*     */ import mzm.gsp.backgame.confbean.SBackGameAwardCfg;
/*     */ import mzm.gsp.backgame.confbean.SBackGameAwardIndexCfg;
/*     */ import mzm.gsp.online.event.PlayerLoginProtectProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2BackGameInfo;
/*     */ import xtable.Role2backgame;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleProtectLogin extends PlayerLoginProtectProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  26 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  28 */       return false;
/*     */     }
/*     */     
/*  31 */     String userId = RoleInterface.getUserId(roleId);
/*  32 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  35 */     int roleLevel = RoleInterface.getLevel(roleId);
/*  36 */     if (roleLevel < BackGameConsts.getInstance().minRoleLevel)
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     Role2BackGameInfo xRole2BackGameInfo = Role2backgame.get(Long.valueOf(roleId));
/*  41 */     if (xRole2BackGameInfo == null)
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  48 */     long xBackGameStartTime = xRole2BackGameInfo.getBack_state_start_time();
/*  49 */     if (!BackGameManager.isInBackState(currentTimeMillis, xBackGameStartTime))
/*     */     {
/*  51 */       return true;
/*     */     }
/*     */     
/*  54 */     BackGameManager.checkAndClearBackGameScore(xRole2BackGameInfo, userId, roleId, -1L, -1, "POnRoleLogin.processImp");
/*     */     
/*  56 */     int awardDay = BackGameManager.getAwardReservedExpDayRatio(xRole2BackGameInfo.getOffline_days());
/*  57 */     int awardLevel = xRole2BackGameInfo.getBack_game_level();
/*     */     
/*  59 */     SSyncBackGameInfo sSyncBackGameInfo = new SSyncBackGameInfo();
/*  60 */     sSyncBackGameInfo.award_back_game_level = xRole2BackGameInfo.getBack_game_level();
/*  61 */     sSyncBackGameInfo.award_day = awardDay;
/*  62 */     sSyncBackGameInfo.current_score_value = BackGameManager.getNowBackGameScoreValue(userId, roleId, xRole2BackGameInfo);
/*     */     
/*  64 */     SBackGameAwardCfg sBackGameDayAwardCfg = SBackGameAwardCfg.get(awardLevel);
/*     */     
/*  66 */     if (sBackGameDayAwardCfg == null)
/*     */     {
/*  68 */       GameServer.logger().warn(String.format("[backgame]POnRoleLogin.processImp@back game award cfg is null|role_id=%d|award_level=%d|award_day=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardLevel), Integer.valueOf(awardDay) }));
/*     */       
/*     */ 
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     List<Integer> aleardyAwardedScoreIndexList = xRole2BackGameInfo.getAleardy_awarded_score_index_list();
/*  76 */     int size = aleardyAwardedScoreIndexList.size();
/*     */     
/*  78 */     TreeMap<Integer, SBackGameAwardIndexCfg> sBackGameAwardIndexMap = (TreeMap)SBackGameAwardIndexCfg.getAll();
/*     */     
/*  80 */     if (size == SBackGameAwardIndexCfg.getAll().size())
/*     */     {
/*  82 */       sSyncBackGameInfo.current_award_score_index_id = -1;
/*     */     }
/*  84 */     else if (size == 0)
/*     */     {
/*  86 */       sSyncBackGameInfo.current_award_score_index_id = ((Integer)sBackGameAwardIndexMap.firstKey()).intValue();
/*     */     }
/*     */     else
/*     */     {
/*  90 */       Integer currentAwardScoreIndexId = (Integer)sBackGameAwardIndexMap.higherKey(aleardyAwardedScoreIndexList.get(size - 1));
/*  91 */       if (currentAwardScoreIndexId == null)
/*     */       {
/*     */ 
/*  94 */         GameServer.logger().warn(String.format("[backgame]POnRoleLogin.processImp@back game index award cfg is null|role_id=%d|award_level=%d|award_day=%d|alwardy_awarded_score_index_list=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardLevel), Integer.valueOf(awardDay), aleardyAwardedScoreIndexList.toString() }));
/*     */         
/*     */ 
/*     */ 
/*  98 */         return false;
/*     */       }
/* 100 */       sSyncBackGameInfo.current_award_score_index_id = currentAwardScoreIndexId.intValue();
/*     */     }
/* 102 */     long serviceTime = 86400000L * BackGameConsts.getInstance().lastTime;
/* 103 */     long elpasedTime = DateTimeUtils.getCurrTimeInMillis() - xBackGameStartTime;
/* 104 */     sSyncBackGameInfo.left_time = ((serviceTime - elpasedTime) / 1000L);
/* 105 */     OnlineManager.getInstance().send(roleId, sSyncBackGameInfo);
/*     */     
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\main\POnRoleProtectLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */