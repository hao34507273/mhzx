/*     */ package mzm.gsp.gangrace.main.game;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gangrace.PlayerInfo;
/*     */ import mzm.gsp.gangrace.RunningInfo;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ 
/*     */ public class RaceGame
/*     */ {
/*     */   public static final int DEST_COURSE = 320;
/*     */   public static final int MAX_MOVE_STEP = 500;
/*     */   private static final int ROUND_TIME = 2;
/*  19 */   private static Random rand = new Random();
/*     */   
/*     */   private final int gameId;
/*  22 */   private ArrayList<RaceObj> raceObjs = new ArrayList();
/*  23 */   volatile int winnerIdx = -1;
/*  24 */   volatile long winnerRoleId = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */   public RaceGame(int _gameId, RaceBaseManager _raceBaseManager, List<Long> _roleIds, Map<Integer, String> _npcInfos)
/*     */   {
/*  30 */     this.gameId = _gameId;
/*     */     
/*  32 */     RaceBase raceBase = _raceBaseManager.getRaceBase();
/*  33 */     for (int i = 0; i < _roleIds.size(); i++) {
/*  34 */       long roleid = ((Long)_roleIds.get(i)).longValue();
/*  35 */       int roleGender = RoleInterface.getGender(roleid);
/*  36 */       int roleOccupationId = RoleInterface.getOccupationId(roleid);
/*  37 */       int avatarId = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(roleid, false);
/*  38 */       int frameId = mzm.gsp.avatar.frame.AvatarFrameInterface.getCurrentAvatarFrameId(roleid, false);
/*  39 */       String roleName = RoleInterface.getName(roleid);
/*  40 */       RaceObj raceObj = new RaceObj(raceBase, i + 1, roleid, roleGender, roleOccupationId, avatarId, frameId, roleName);
/*  41 */       this.raceObjs.add(raceObj);
/*     */     }
/*     */     Iterator i$;
/*  44 */     if (this.raceObjs.size() < 5) {
/*  45 */       List<Integer> npcids = randomNpcId(_npcInfos.keySet(), 5 - this.raceObjs.size());
/*     */       
/*  47 */       for (i$ = npcids.iterator(); i$.hasNext();) { int npcModelId = ((Integer)i$.next()).intValue();
/*  48 */         RaceObj raceObj = new RaceObj(raceBase, this.raceObjs.size() + 1, 0L, -1, npcModelId, -1, 0, (String)_npcInfos.get(Integer.valueOf(npcModelId)));
/*  49 */         this.raceObjs.add(raceObj);
/*     */       }
/*     */     }
/*     */     
/*  53 */     runGame();
/*     */   }
/*     */   
/*     */   public int getGameId() {
/*  57 */     return this.gameId;
/*     */   }
/*     */   
/*     */   public RaceObj getRaceObj(int _index) {
/*  61 */     return (RaceObj)this.raceObjs.get(_index);
/*     */   }
/*     */   
/*     */   public int getRaceObjCount() {
/*  65 */     return this.raceObjs.size();
/*     */   }
/*     */   
/*     */   public List<PlayerInfo> getPlayerInfo() {
/*  69 */     List<PlayerInfo> ret = new ArrayList();
/*  70 */     for (int i = 0; i < this.raceObjs.size(); i++) {
/*  71 */       RaceObj obj = (RaceObj)this.raceObjs.get(i);
/*  72 */       PlayerInfo playerInfo = obj.getPlayerInfo();
/*  73 */       ret.add(playerInfo);
/*     */     }
/*     */     
/*  76 */     return ret;
/*     */   }
/*     */   
/*     */   public List<RunningInfo> getRunningInfo() {
/*  80 */     List<RunningInfo> ret = new ArrayList(1);
/*  81 */     for (int i = 0; i < this.raceObjs.size(); i++) {
/*  82 */       RaceObj obj = (RaceObj)this.raceObjs.get(i);
/*  83 */       RunningInfo runningInfo = obj.getRunningInfo();
/*  84 */       ret.add(runningInfo);
/*     */     }
/*  86 */     return ret;
/*     */   }
/*     */   
/*     */   public int getWinIndex() {
/*  90 */     return this.winnerIdx;
/*     */   }
/*     */   
/*     */   public long getWinRoleId() {
/*  94 */     return this.winnerRoleId;
/*     */   }
/*     */   
/*     */   public int getActionTime() {
/*  98 */     if (!this.raceObjs.isEmpty()) {
/*  99 */       RaceObj obj = (RaceObj)this.raceObjs.get(0);
/* 100 */       return obj.getRunningInfo().actioninfos.size() * 2;
/*     */     }
/*     */     
/* 103 */     return 0;
/*     */   }
/*     */   
/*     */   public Map<Integer, String> getRaceObjName() {
/* 107 */     Map<Integer, String> names = new HashMap();
/*     */     
/* 109 */     for (int i = 0; i < this.raceObjs.size(); i++) {
/* 110 */       RaceObj obj = (RaceObj)this.raceObjs.get(i);
/* 111 */       names.put(Integer.valueOf(obj.getId()), obj.getRoleName());
/*     */     }
/*     */     
/* 114 */     return names;
/*     */   }
/*     */   
/*     */   public int runGame() {
/* 118 */     int curRound = 0;
/* 119 */     int maxCourse = 0;
/* 120 */     boolean gameOver = false;
/*     */     
/* 122 */     while (!gameOver) {
/* 123 */       gameOver = true;
/* 124 */       for (RaceObj obj : this.raceObjs) {
/* 125 */         if (obj.onAction(curRound) < 320)
/* 126 */           gameOver = false;
/*     */       }
/* 128 */       curRound++;
/*     */     }
/*     */     
/* 131 */     this.winnerIdx = -1;
/* 132 */     this.winnerRoleId = 0L;
/* 133 */     for (RaceObj obj : this.raceObjs) {
/* 134 */       obj.cleanAction(curRound);
/* 135 */       int raceCourse = obj.getCurStep();
/* 136 */       if (maxCourse < raceCourse) {
/* 137 */         maxCourse = raceCourse;
/* 138 */         this.winnerIdx = obj.getId();
/* 139 */         this.winnerRoleId = obj.getRoleId();
/*     */       }
/*     */     }
/*     */     
/* 143 */     return curRound;
/*     */   }
/*     */   
/*     */   private List<Integer> randomNpcId(Set<Integer> _npcModels, int _count) {
/* 147 */     List<Integer> npcs = new ArrayList();
/* 148 */     npcs.addAll(_npcModels);
/*     */     
/* 150 */     List<Integer> ret = new ArrayList();
/* 151 */     for (int i = 0; (i < _count) && (!npcs.isEmpty()); i++) {
/* 152 */       int idx = rand.nextInt(npcs.size());
/* 153 */       ret.add(npcs.get(idx));
/* 154 */       npcs.remove(idx);
/*     */     }
/*     */     
/* 157 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\game\RaceGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */