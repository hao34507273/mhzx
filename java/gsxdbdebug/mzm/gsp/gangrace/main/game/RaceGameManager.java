/*     */ package mzm.gsp.gangrace.main.game;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.gangrace.main.GangRaceManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ 
/*     */ public class RaceGameManager
/*     */ {
/*     */   public static final int RACE_OBJ_COUNT = 5;
/*  18 */   private static Random rand = new Random();
/*     */   
/*  20 */   static RaceGameManager instance = new RaceGameManager();
/*  21 */   private RaceBaseManager raceBaseManager = new RaceBaseManager();
/*  22 */   private Map<Long, RaceGame> raceGames = new HashMap();
/*  23 */   private Map<Integer, String> npcInfos = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */   public static RaceGameManager getInstance()
/*     */   {
/*  29 */     return instance;
/*     */   }
/*     */   
/*     */   public void init() {
/*  33 */     this.raceBaseManager.init();
/*  34 */     this.npcInfos.put(Integer.valueOf(700300126), "碧瑶");
/*  35 */     this.npcInfos.put(Integer.valueOf(700301048), "林惊羽");
/*  36 */     this.npcInfos.put(Integer.valueOf(700301060), "田灵儿");
/*  37 */     this.npcInfos.put(Integer.valueOf(700300122), "张小凡");
/*  38 */     this.npcInfos.put(Integer.valueOf(700300123), "陆雪琪");
/*     */   }
/*     */   
/*     */   public void reset() {
/*  42 */     this.raceGames.clear();
/*     */   }
/*     */   
/*     */   public RaceGame getRaceGame(long _gangId) {
/*  46 */     RaceGame game = null;
/*  47 */     game = (RaceGame)this.raceGames.get(Long.valueOf(_gangId));
/*  48 */     int gameId; if (game == null)
/*     */     {
/*  50 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  51 */       gameId = (int)TimeUnit.MILLISECONDS.toSeconds(now);
/*  52 */       List<Long> roleIds = randomGangMember(_gangId);
/*  53 */       game = new RaceGame(gameId, this.raceBaseManager, roleIds, this.npcInfos);
/*  54 */       this.raceGames.put(Long.valueOf(_gangId), game);
/*     */       
/*  56 */       int winIdx = game.getWinIndex();
/*  57 */       long roleId = game.getWinRoleId();
/*  58 */       GangRaceManager.logInfo("RaceGameManager.getRaceGame@new racegame|gangid=%d|gameid=%d|winIdx=%d|winroleid=%d", new Object[] { Long.valueOf(_gangId), Integer.valueOf(gameId), Integer.valueOf(winIdx), Long.valueOf(roleId) });
/*     */       
/*  60 */       Map<Integer, String> raceObjNames = game.getRaceObjName();
/*  61 */       for (Map.Entry<Integer, String> entry : raceObjNames.entrySet()) {
/*  62 */         GangRaceManager.logInfo("RaceGameManager.getRaceGame@raceobject name|gangid=%d|gameid=%d|idx=%d|%s", new Object[] { Long.valueOf(_gangId), Integer.valueOf(gameId), entry.getKey(), entry.getValue() });
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  67 */     return game;
/*     */   }
/*     */   
/*     */   public Set<Long> getGameIds() {
/*  71 */     return this.raceGames.keySet();
/*     */   }
/*     */   
/*     */   public RaceGameWinInfo getGameWinInfo(long _gameId) {
/*  75 */     RaceGameWinInfo ret = null;
/*  76 */     RaceGame game = (RaceGame)this.raceGames.get(Long.valueOf(_gameId));
/*  77 */     if (game != null) {
/*  78 */       ret = new RaceGameWinInfo(game.getWinIndex(), game.getWinRoleId(), game.getActionTime(), game.getRaceObjName());
/*     */     }
/*     */     
/*  81 */     return ret;
/*     */   }
/*     */   
/*     */   private List<Long> randomGangMember(long _gangId)
/*     */   {
/*  86 */     ArrayList<Long> roleIds = new ArrayList();
/*  87 */     Set<Long> members = mzm.gsp.gang.main.GangInterface.getGangMemberList(_gangId);
/*  88 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*  89 */       if (OnlineManager.getInstance().isOnline(id))
/*  90 */         roleIds.add(Long.valueOf(id));
/*     */     }
/*  92 */     if (roleIds.size() <= 5) {
/*  93 */       return roleIds;
/*     */     }
/*  95 */     ArrayList<Long> ret = new ArrayList();
/*  96 */     while ((!roleIds.isEmpty()) && (ret.size() < 5)) {
/*  97 */       int idx = rand.nextInt(roleIds.size() - 1);
/*  98 */       ret.add(roleIds.get(idx));
/*  99 */       roleIds.remove(idx);
/*     */     }
/*     */     
/* 102 */     return ret;
/*     */   }
/*     */   
/*     */   public static class RaceGameWinInfo
/*     */   {
/*     */     private final int winIndex;
/*     */     private final int actionTime;
/*     */     private final long winRoleId;
/*     */     private final Map<Integer, String> raceObjNames;
/*     */     
/*     */     RaceGameWinInfo(int _winIndex, long _winRoleId, int _actionTime, Map<Integer, String> _names) {
/* 113 */       this.winIndex = _winIndex;
/* 114 */       this.actionTime = _actionTime;
/* 115 */       this.winRoleId = _winRoleId;
/* 116 */       this.raceObjNames = _names;
/*     */     }
/*     */     
/*     */     public int getWinIndex() {
/* 120 */       return this.winIndex;
/*     */     }
/*     */     
/*     */     public long getWinRoleId() {
/* 124 */       return this.winRoleId;
/*     */     }
/*     */     
/*     */     public int getActionTime() {
/* 128 */       return this.actionTime;
/*     */     }
/*     */     
/*     */     public Map<Integer, String> getRaceObjNames() {
/* 132 */       return this.raceObjNames;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\game\RaceGameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */