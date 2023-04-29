/*     */ package mzm.gsp.gangrace.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.gangrace.SRaceStart;
/*     */ import mzm.gsp.gangrace.SRaceStatusRes;
/*     */ import mzm.gsp.gangrace.main.game.RaceGame;
/*     */ import mzm.gsp.gangrace.main.game.RaceGameManager;
/*     */ import mzm.gsp.gangrace.main.game.RaceGameManager.RaceGameWinInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangRaceGameInfo;
/*     */ import xbean.GangRaceRoleInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Gangrace2gameinfo;
/*     */ import xtable.Role2gangraceinfo;
/*     */ 
/*     */ public class GangRaceManager
/*     */ {
/*  29 */   public static Logger logger = Logger.getLogger("GangRace");
/*  30 */   public static int MONEY_FOR_VOTE = 1000;
/*  31 */   private static GangRaceManager instance = new GangRaceManager();
/*     */   
/*  33 */   private RaceGameManager gameMgr = null;
/*  34 */   private int gameStage = -1;
/*  35 */   private int stageTime = 0;
/*     */   
/*  37 */   private int maxGameRound = 1;
/*  38 */   private int curGameRound = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   public static GangRaceManager getInstance()
/*     */   {
/*  44 */     return instance;
/*     */   }
/*     */   
/*     */   public static void debugLog(String format, Object... args) {
/*  48 */     if (GameServer.logger().isDebugEnabled())
/*  49 */       GameServer.logger().debug(String.format(format, args));
/*     */   }
/*     */   
/*     */   public static void errorLog(String format, Object... args) {
/*  53 */     logger.error(String.format(format, args));
/*     */   }
/*     */   
/*     */   public static void logInfo(String format, Object... args) {
/*  57 */     logger.info(String.format(format, args));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tLog(long roleId, int logType, long gangId, int voteIdex, int money)
/*     */   {
/*  72 */     String vGameIP = mzm.gsp.GameServerInfoManager.getHostIP();
/*  73 */     String userid = RoleInterface.getUserId(roleId);
/*  74 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  80 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(logType), Long.valueOf(gangId), Integer.valueOf(voteIdex), Integer.valueOf(money) };
/*     */     
/*  82 */     TLogManager.getInstance().addLog(roleId, "GangRace", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanJoinGangRaceActivity(long roleid)
/*     */   {
/*  93 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, 151, true);
/*     */   }
/*     */   
/*     */   static GangRaceRoleInfo getXGangRaceRoleInfo(long roleid) {
/*  97 */     GangRaceRoleInfo xGangRaceRoleInfoBean = Role2gangraceinfo.get(Long.valueOf(roleid));
/*  98 */     if (xGangRaceRoleInfoBean == null) {
/*  99 */       xGangRaceRoleInfoBean = Pod.newGangRaceRoleInfo();
/* 100 */       Role2gangraceinfo.add(Long.valueOf(roleid), xGangRaceRoleInfoBean);
/*     */     }
/*     */     
/* 103 */     return xGangRaceRoleInfoBean;
/*     */   }
/*     */   
/*     */   static GangRaceGameInfo getXGangRaceGameInfo(long gangid) {
/* 107 */     GangRaceGameInfo xGangRaceGameInfoBean = Gangrace2gameinfo.get(Long.valueOf(gangid));
/* 108 */     if (xGangRaceGameInfoBean == null) {
/* 109 */       xGangRaceGameInfoBean = Pod.newGangRaceGameInfo();
/* 110 */       Map<Integer, Integer> id2money = xGangRaceGameInfoBean.getRaceid2money();
/* 111 */       for (int i = 1; i <= 5; i++) {
/* 112 */         id2money.put(Integer.valueOf(i), Integer.valueOf(0));
/*     */       }
/* 114 */       xGangRaceGameInfoBean.setGameid(0);
/* 115 */       Gangrace2gameinfo.add(Long.valueOf(gangid), xGangRaceGameInfoBean);
/*     */     }
/*     */     
/* 118 */     return xGangRaceGameInfoBean;
/*     */   }
/*     */   
/*     */   static boolean resetRoleGangRaceGameInfo(RaceGame game, GangRaceRoleInfo xGangRaceRoleInfoBean, GangRaceGameInfo xGangRaceGameInfoBean) {
/* 122 */     int gameId = game.getGameId();
/*     */     
/* 124 */     if ((xGangRaceRoleInfoBean != null) && (xGangRaceRoleInfoBean.getGameid() != gameId)) {
/* 125 */       xGangRaceRoleInfoBean.getRaceid2money().clear();
/* 126 */       xGangRaceRoleInfoBean.setGameid(gameId);
/*     */     }
/*     */     
/* 129 */     if ((xGangRaceGameInfoBean != null) && (xGangRaceGameInfoBean.getGameid() != gameId)) {
/* 130 */       if (xGangRaceGameInfoBean.getGameid() != 0) {
/* 131 */         xGangRaceGameInfoBean.getCurgameroleids().clear();
/* 132 */         Map<Integer, Integer> id2money = xGangRaceGameInfoBean.getRaceid2money();
/* 133 */         for (int i = 1; i <= 5; i++) {
/* 134 */           id2money.put(Integer.valueOf(i), Integer.valueOf(0));
/*     */         }
/*     */       }
/* 137 */       xGangRaceGameInfoBean.setGameid(gameId);
/*     */     }
/*     */     
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   static void sendErrorInfo(long roleid, int result) {
/* 144 */     OnlineManager.getInstance().sendAtOnce(roleid, new mzm.gsp.gangrace.SErrorInfoRes(result));
/*     */   }
/*     */   
/*     */   void init() {
/* 148 */     this.gameMgr = RaceGameManager.getInstance();
/* 149 */     this.gameMgr.init();
/* 150 */     ActivityInterface.registerActivityByLogicType(36, new GangRaceActivityHandler());
/*     */   }
/*     */   
/*     */   int getGameStage() {
/* 154 */     return this.gameStage;
/*     */   }
/*     */   
/*     */   int getMaxGameRound()
/*     */   {
/* 159 */     return this.maxGameRound;
/*     */   }
/*     */   
/*     */   int getCurGameRound()
/*     */   {
/* 164 */     return this.curGameRound;
/*     */   }
/*     */   
/*     */   int getGameStageTime() {
/* 168 */     return this.stageTime;
/*     */   }
/*     */   
/*     */   RaceGame getGame(long _gandid) {
/* 172 */     if (-1 == this.gameStage)
/* 173 */       return null;
/* 174 */     return RaceGameManager.getInstance().getRaceGame(_gandid);
/*     */   }
/*     */   
/*     */   void activityBegin(int _maxGameCount) {
/* 178 */     this.maxGameRound = _maxGameCount;
/* 179 */     this.curGameRound = 0;
/* 180 */     this.gameMgr.reset();
/* 181 */     new AwardObserver();
/* 182 */     changeStage(0, 0);
/*     */   }
/*     */   
/*     */   void activityEnd() {
/* 186 */     changeStage(-1, -1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void changeStage(int _round, int _stage)
/*     */   {
/* 208 */     logInfo("GangRaceManager.changeStage@begin|roundid=%d|stage=%d", new Object[] { Integer.valueOf(_round), Integer.valueOf(_stage) });
/* 209 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 210 */     this.curGameRound = _round;
/* 211 */     this.stageTime = ((int)TimeUnit.MILLISECONDS.toSeconds(now));
/*     */     
/* 213 */     if (_stage == 0) {
/* 214 */       this.gameMgr.reset();
/* 215 */       this.gameStage = 0;
/* 216 */       OnlineManager.getInstance().sendAll(new SRaceStart(this.curGameRound, this.maxGameRound));
/*     */     } else { Iterator i$;
/* 218 */       if (_stage == 1) {
/* 219 */         this.gameStage = 2;
/*     */         
/* 221 */         for (i$ = this.gameMgr.getGameIds().iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/* 222 */           GangRaceGameInfo xGangRaceGameInfoBean = Gangrace2gameinfo.select(Long.valueOf(gangid));
/* 223 */           if ((xGangRaceGameInfoBean != null) && (!xGangRaceGameInfoBean.getCurgameroleids().isEmpty())) {
/* 224 */             RaceGameManager.RaceGameWinInfo winInfo = this.gameMgr.getGameWinInfo(gangid);
/*     */             
/* 226 */             int gameId = xGangRaceGameInfoBean.getGameid();
/* 227 */             int winIndex = winInfo.getWinIndex();
/* 228 */             long winRoleId = winInfo.getWinRoleId();
/* 229 */             Map<Integer, String> raceObjNames = winInfo.getRaceObjNames();
/*     */             
/* 231 */             Map<Integer, Integer> raceid2Money = new HashMap();
/* 232 */             raceid2Money.putAll(xGangRaceGameInfoBean.getRaceid2money());
/* 233 */             Set<Long> voteRoles = new HashSet();
/* 234 */             voteRoles.addAll(xGangRaceGameInfoBean.getCurgameroleids());
/* 235 */             new GangRaceActionSession(gangid, gameId, winInfo.getActionTime() + 10, winIndex, winRoleId, voteRoles, raceid2Money, raceObjNames);
/* 236 */             logInfo("GangRaceManager.changeStage@add GangRaceActionSession|gangid=%d|gameId=%d|winIndex=%d|winRoleId=%d", new Object[] { Long.valueOf(gangid), Integer.valueOf(gameId), Integer.valueOf(winIndex), Long.valueOf(winRoleId) });
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 241 */         this.gameStage = -1;
/*     */       }
/*     */     }
/* 244 */     OnlineManager.getInstance().sendAll(new SRaceStatusRes(this.gameStage, this.stageTime, this.curGameRound, this.maxGameRound));
/*     */   }
/*     */   
/*     */   RaceGameManager.RaceGameWinInfo getGameWinInfo(long _gameId) {
/* 248 */     return this.gameMgr.getGameWinInfo(_gameId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\GangRaceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */