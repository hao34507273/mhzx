/*     */ package mzm.gsp.backgame.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.backgame.SGetBackScoreAwardFail;
/*     */ import mzm.gsp.backgame.SGetBackScoreAwardInfo;
/*     */ import mzm.gsp.backgame.confbean.SBackGameAwardNewCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2BackGameInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2backgame;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetBackScoreAwardInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetBackScoreAwardInfo(long roleId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!BackGameManager.isBackGameSwitchOpen(this.roleId, "PCGetBackGameScoreAwardInfo.processImp", true, true))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  40 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  43 */     boolean result = mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 362, true, true);
/*     */     
/*  45 */     if (!result)
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     Role2BackGameInfo xRole2BackGameInfo = Role2backgame.get(Long.valueOf(this.roleId));
/*  51 */     if (xRole2BackGameInfo == null)
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[backgame]PCGetBackGameScoreAwardInfo.processImp@role back game info is null|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     long xBackGameStartTime = xRole2BackGameInfo.getBack_state_start_time();
/*  60 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  61 */     if (!BackGameManager.isInBackState(currentTimeMillis, xBackGameStartTime))
/*     */     {
/*  63 */       SGetBackScoreAwardFail sGetBackScoreAwardFail = new SGetBackScoreAwardFail();
/*  64 */       sGetBackScoreAwardFail.result = 1;
/*     */       
/*  66 */       GameServer.logger().info(String.format("[backgame]PCGetBackGameScoreAwardInfo.processImp@role back game state not exist|role_id=%d|role_back_game_start_time=%d|current_time_millis=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(xBackGameStartTime), Long.valueOf(currentTimeMillis) }));
/*     */       
/*     */ 
/*     */ 
/*  70 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetBackScoreAwardFail);
/*     */       
/*  72 */       return false;
/*     */     }
/*  74 */     BackGameManager.checkAndClearBackGameScore(xRole2BackGameInfo, userId, this.roleId, -1L, -1, "PCGetBackGameScoreAwardInfo.processImp");
/*     */     
/*     */ 
/*  77 */     int awardedDay = BackGameManager.getAwardReservedExpDayRatio(xRole2BackGameInfo.getOffline_days());
/*     */     
/*  79 */     List<Integer> xAwardedScoreIndexList = xRole2BackGameInfo.getAleardy_awarded_score_index_list();
/*  80 */     int size = xAwardedScoreIndexList.size();
/*  81 */     if (size == mzm.gsp.backgame.confbean.SBackGameAwardIndexCfg.getAll().size())
/*     */     {
/*  83 */       GameServer.logger().error(String.format("[backgame]PCGetBackGameScoreAwardInfo.processImp@role has get all award|role_id=%d|awarded_score_index=%s", new Object[] { Long.valueOf(this.roleId), xAwardedScoreIndexList.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     int nextSerialIndexId = 1;
/*  91 */     if (size != 0)
/*     */     {
/*  93 */       nextSerialIndexId = ((Integer)xAwardedScoreIndexList.get(size - 1)).intValue() + 1;
/*     */     }
/*     */     
/*  96 */     SBackGameAwardNewCfg sBackGameAwardNewCfg = SBackGameAwardNewCfg.get(awardedDay);
/*  97 */     if (sBackGameAwardNewCfg == null)
/*     */     {
/*  99 */       GameServer.logger().error(String.format("[backgame]PCGetBackGameScoreAwardInfo.processImp@award day not exist|role_id=%d|awarded_score_index=%s|next_serial_index_id=%d", new Object[] { Long.valueOf(this.roleId), xAwardedScoreIndexList.toString(), Integer.valueOf(awardedDay) }));
/*     */       
/*     */ 
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     Integer awardId = (Integer)sBackGameAwardNewCfg.serial_award_map.get(Integer.valueOf(nextSerialIndexId));
/* 107 */     if (awardId == null)
/*     */     {
/* 109 */       GameServer.logger().error(String.format("[backgame]PCGetBackGameScoreAwardInfo.processImp@award id not exist|role_id=%d|awarded_score_index=%s|next_serial_index_id=%d", new Object[] { Long.valueOf(this.roleId), xAwardedScoreIndexList.toString(), Integer.valueOf(nextSerialIndexId) }));
/*     */       
/*     */ 
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     AwardReason reason = new AwardReason(LogReason.BACK_GAME_SCORE_AWARD);
/* 117 */     reason.setJustQuery(true);
/* 118 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(awardId.intValue(), this.roleId, -1, reason);
/*     */     
/* 120 */     SGetBackScoreAwardInfo sGetBackScoreAwardInfo = new SGetBackScoreAwardInfo();
/* 121 */     sGetBackScoreAwardInfo.exp_value = awardModel.getRoleExp();
/* 122 */     sGetBackScoreAwardInfo.silver_value = awardModel.getSilver();
/*     */     
/* 124 */     OnlineManager.getInstance().send(this.roleId, sGetBackScoreAwardInfo);
/*     */     
/* 126 */     GameServer.logger().info(String.format("[backgame]PCGetBackGameScoreAwardInfo.processImp@handle get back score award info success|role_id=%d|award_index_id=%d|awarded_index=%s|exp_value=%d|silver_value=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(nextSerialIndexId), xAwardedScoreIndexList.toString(), Integer.valueOf(sGetBackScoreAwardInfo.exp_value), Long.valueOf(sGetBackScoreAwardInfo.silver_value) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 131 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\main\PCGetBackScoreAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */