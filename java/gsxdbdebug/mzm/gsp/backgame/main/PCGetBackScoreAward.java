/*     */ package mzm.gsp.backgame.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.backgame.SGetBackScoreAwardFail;
/*     */ import mzm.gsp.backgame.SGetBackScoreAwardSuccess;
/*     */ import mzm.gsp.backgame.confbean.SBackGameAwardIndexCfg;
/*     */ import mzm.gsp.backgame.confbean.SBackGameAwardNewCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2BackGameInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2backgame;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetBackScoreAward extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetBackScoreAward(long roleId)
/*     */   {
/*  33 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!BackGameManager.isBackGameSwitchOpen(this.roleId, "PCGetBackScoreAward.processImp", true, true))
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     String userId = RoleInterface.getUserId(this.roleId);
/*  44 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  47 */     boolean result = mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 361, true, true);
/*     */     
/*  49 */     if (!result)
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     Role2BackGameInfo xRole2BackGameInfo = Role2backgame.get(Long.valueOf(this.roleId));
/*  55 */     if (xRole2BackGameInfo == null)
/*     */     {
/*  57 */       GameServer.logger().error(String.format("[backgame]PCGetBackScoreAward.processImp@role back game info is null|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     long xBackGameStartTime = xRole2BackGameInfo.getBack_state_start_time();
/*  64 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  65 */     if (!BackGameManager.isInBackState(currentTimeMillis, xBackGameStartTime))
/*     */     {
/*  67 */       SGetBackScoreAwardFail sGetBackScoreAwardFail = new SGetBackScoreAwardFail();
/*  68 */       sGetBackScoreAwardFail.result = 1;
/*     */       
/*  70 */       GameServer.logger().info(String.format("[backgame]PCGetBackScoreAward.processImp@role back game state not exist|role_id=%d|role_back_game_start_time=%d|current_time_millis=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(xBackGameStartTime), Long.valueOf(currentTimeMillis) }));
/*     */       
/*     */ 
/*     */ 
/*  74 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetBackScoreAwardFail);
/*     */       
/*  76 */       return false;
/*     */     }
/*  78 */     BackGameManager.checkAndClearBackGameScore(xRole2BackGameInfo, userId, this.roleId, -1L, -1, "PCGetBackScoreAward.processImp");
/*     */     
/*  80 */     int awardedDay = BackGameManager.getAwardReservedExpDayRatio(xRole2BackGameInfo.getOffline_days());
/*     */     
/*  82 */     List<Integer> xAwardedScoreIndexList = xRole2BackGameInfo.getAleardy_awarded_score_index_list();
/*  83 */     int size = xAwardedScoreIndexList.size();
/*  84 */     if (size == SBackGameAwardIndexCfg.getAll().size())
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[backgame]PCGetBackScoreAward.processImp@role has get all award|role_id=%d|awarded_score_index=%s", new Object[] { Long.valueOf(this.roleId), xAwardedScoreIndexList.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  90 */       return false;
/*     */     }
/*  92 */     TreeMap<Integer, SBackGameAwardIndexCfg> sBackGameAwardIndexCfgMap = (TreeMap)SBackGameAwardIndexCfg.getAll();
/*     */     
/*  94 */     Map.Entry<Integer, SBackGameAwardIndexCfg> entry = null;
/*  95 */     if (size == 0)
/*     */     {
/*  97 */       entry = sBackGameAwardIndexCfgMap.firstEntry();
/*     */     }
/*     */     else
/*     */     {
/* 101 */       int currentIndexId = ((Integer)xAwardedScoreIndexList.get(size - 1)).intValue();
/* 102 */       entry = sBackGameAwardIndexCfgMap.higherEntry(Integer.valueOf(currentIndexId));
/* 103 */       if (entry == null)
/*     */       {
/* 105 */         GameServer.logger().error(String.format("[backgame]PCGetBackScoreAward.processImp@score award index not exist|role_id=%d|current_awarded_score_index=%d|aleardy_awared_list=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(currentIndexId), xAwardedScoreIndexList.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 110 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 115 */     SBackGameAwardIndexCfg sBackGameAwardIndexCfg = (SBackGameAwardIndexCfg)entry.getValue();
/* 116 */     int nowScore = BackGameManager.getNowBackGameScoreValue(userId, this.roleId, xRole2BackGameInfo);
/* 117 */     if (nowScore < sBackGameAwardIndexCfg.score)
/*     */     {
/* 119 */       GameServer.logger().error(String.format("[backgame]PCGetBackScoreAward.processImp@score not enough for award|role_id=%d|need_score=%d|now_score=%d|aleardy_awared_list=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(sBackGameAwardIndexCfg.score), Integer.valueOf(nowScore), xAwardedScoreIndexList.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     SBackGameAwardNewCfg sBackGameAwardNewCfg = SBackGameAwardNewCfg.get(awardedDay);
/* 127 */     if (sBackGameAwardNewCfg == null)
/*     */     {
/* 129 */       GameServer.logger().error(String.format("[backgame]PCGetBackScoreAward.processImp@award day not exist|role_id=%d|aleardy_awared_list=%s|awarded_day=%d", new Object[] { Long.valueOf(this.roleId), xAwardedScoreIndexList.toString(), Integer.valueOf(awardedDay) }));
/*     */       
/*     */ 
/*     */ 
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     Integer awardId = (Integer)sBackGameAwardNewCfg.serial_award_map.get(entry.getKey());
/* 137 */     if (awardId == null)
/*     */     {
/* 139 */       GameServer.logger().error(String.format("[backgame]PCGetBackScoreAward.processImp@award id not exist|role_id=%d|aleardy_awared_list=%s|awarded_day=%d", new Object[] { Long.valueOf(this.roleId), xAwardedScoreIndexList.toString(), Integer.valueOf(awardedDay) }));
/*     */       
/*     */ 
/*     */ 
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     AwardModel awardModel = AwardInterface.award(awardId.intValue(), userId, this.roleId, true, true, new AwardReason(LogReason.BACK_GAME_SCORE_AWARD));
/*     */     
/* 148 */     if (awardModel == null)
/*     */     {
/* 150 */       GameServer.logger().error(String.format("[backgame]PCGetBackScoreAward.processImp@award failed|role_id=%d|aleardy_awared_list=%s|awarded_day=%d|award_id=%d", new Object[] { Long.valueOf(this.roleId), xAwardedScoreIndexList.toString(), Integer.valueOf(awardedDay), awardId }));
/*     */       
/*     */ 
/*     */ 
/* 154 */       return false;
/*     */     }
/*     */     
/* 157 */     xAwardedScoreIndexList.add(entry.getKey());
/*     */     
/* 159 */     SGetBackScoreAwardSuccess sGetBackScoreAwardSuccess = new SGetBackScoreAwardSuccess();
/* 160 */     OnlineManager.getInstance().send(this.roleId, sGetBackScoreAwardSuccess);
/*     */     
/* 162 */     BackGameManager.tlogBackGameScoreAward(this.roleId, userId, sBackGameAwardIndexCfg.indexId, sBackGameAwardIndexCfg.score, nowScore);
/*     */     
/* 164 */     GameServer.logger().info(String.format("[backgame]PCGetBackScoreAward.processImp@handle get back score award success|role_id=%d|award_index_id=%d|awarded_index=%s", new Object[] { Long.valueOf(this.roleId), entry.getKey(), xAwardedScoreIndexList.toString() }));
/*     */     
/*     */ 
/*     */ 
/* 168 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\main\PCGetBackScoreAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */