/*     */ package mzm.gsp.chinesevalentine.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity3.confbean.ChineseValentineConstCfg;
/*     */ import mzm.gsp.activity3.confbean.SChineseValentineCfg;
/*     */ import mzm.gsp.chinesevalentine.SChineseValentinePrepare;
/*     */ import mzm.gsp.chinesevalentine.SChineseValentineRound;
/*     */ import mzm.gsp.chinesevalentine.SChineseValentineRoundResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliSession;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChineseValentineAwardRecord;
/*     */ import xbean.ChineseValentineCage;
/*     */ import xbean.ChineseValentineGame;
/*     */ import xbean.ChineseValentineRound;
/*     */ import xdb.Procedure;
/*     */ import xtable.Chinesevalentine;
/*     */ 
/*     */ public class ChineseValentineManager
/*     */ {
/*     */   public static final int PLAYER_COUNT = 2;
/*     */   public static final int PLAYER_CAGE_COUNT = 3;
/*     */   
/*     */   public static void init()
/*     */   {
/*  37 */     ActivityInterface.registerActivityByLogicType(121, new ChineseValentineActivityHandler(), false);
/*     */     
/*  39 */     mzm.gsp.confirm.main.TeamConfirmInterface.registerConfirmHandler(7, new ChineseValentineConfirmHandler());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isOpen(long roleId)
/*     */   {
/*  51 */     int switchId = 459;
/*  52 */     if (!OpenInterface.getOpenStatus(459)) {
/*  53 */       return false;
/*     */     }
/*  55 */     if (OpenInterface.isBanPlay(roleId, 459)) {
/*  56 */       OpenInterface.sendBanPlayMsg(roleId, 459);
/*  57 */       return false;
/*     */     }
/*  59 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInGame(long roleId)
/*     */   {
/*  69 */     Long gameId = xtable.Role2chinesevalentine.select(Long.valueOf(roleId));
/*  70 */     return gameId != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getGameLeftRoundCount(long gameId)
/*     */   {
/*  80 */     ChineseValentineGame xGame = Chinesevalentine.get(Long.valueOf(gameId));
/*  81 */     if (xGame == null) {
/*  82 */       return 0;
/*     */     }
/*  84 */     int maxCount = getCfg().roundMax;
/*  85 */     int leftRoundCount = maxCount - xGame.getWrongcount() - xGame.getRightcount();
/*  86 */     return leftRoundCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startGame(List<Long> roleIdList, int activityId)
/*     */   {
/*  96 */     new ChineseValentineNewGame(roleIdList, activityId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPrepare(long gameId)
/*     */   {
/* 106 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception {
/* 109 */         ChineseValentineGame xChineseValentineGame = Chinesevalentine.get(Long.valueOf(this.val$gameId));
/* 110 */         if (xChineseValentineGame == null) {
/* 111 */           return false;
/*     */         }
/* 113 */         long nowTimeInMillons = DateTimeUtils.getCurrTimeInMillis();
/* 114 */         ChineseValentineRound xRound = xChineseValentineGame.getRoundinfo();
/* 115 */         xRound.setRoundnumber(xRound.getRoundnumber() + 1);
/* 116 */         xRound.setRoundstarttime(nowTimeInMillons);
/* 117 */         xRound.setState(0);
/*     */         
/*     */ 
/* 120 */         List<ChineseValentineCage> xCageList = xRound.getCageinfolist();
/* 121 */         if (2 != xCageList.size()) {
/* 122 */           xCageList.clear();
/* 123 */           for (int i = 0; i < 2; i++) {
/* 124 */             ChineseValentineCage xCage = xbean.Pod.newChineseValentineCage();
/* 125 */             xCageList.add(xCage);
/*     */           }
/*     */         } else {
/* 128 */           for (int i = 0; i < 2; i++) {
/* 129 */             ChineseValentineCage xCage = (ChineseValentineCage)xCageList.get(i);
/* 130 */             xCage.setHighlightindex(0);
/* 131 */             xCage.setPressindex(0);
/* 132 */             xCage.setPresstime(0L);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 137 */         GameServer.logger().info(String.format("[chinesevalentine]ChineseValentineManager.startPrepare@prepared|gameid=%d|roundnum=%d", new Object[] { Long.valueOf(this.val$gameId), Integer.valueOf(xRound.getRoundnumber()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 144 */         MilliSession session = new ChineseValentineSessionPrepare(ChineseValentineManager.getCfg().prepareTime, this.val$gameId);
/* 145 */         xRound.setSessionid(session.getSessionId());
/*     */         
/*     */ 
/* 148 */         List<Long> roleIdList = xChineseValentineGame.getRoleidlist();
/* 149 */         SChineseValentinePrepare protocol = new SChineseValentinePrepare();
/* 150 */         OnlineManager.getInstance().sendMulti(protocol, roleIdList);
/* 151 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startCommand(long gameId)
/*     */   {
/* 163 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception {
/* 166 */         ChineseValentineGame xChineseValentineGame = Chinesevalentine.get(Long.valueOf(this.val$gameId));
/* 167 */         if (xChineseValentineGame == null) {
/* 168 */           return false;
/*     */         }
/* 170 */         ChineseValentineRound xRound = xChineseValentineGame.getRoundinfo();
/* 171 */         xRound.setState(1);
/*     */         
/*     */ 
/* 174 */         List<ChineseValentineCage> cageList = xRound.getCageinfolist();
/* 175 */         int cageListSize = cageList.size();
/* 176 */         for (int i = 0; i < cageListSize; i++) {
/* 177 */           ChineseValentineCage xCage = (ChineseValentineCage)cageList.get(i);
/* 178 */           int highlightIndex = xdb.Xdb.random().nextInt(3) + 1;
/* 179 */           xCage.setHighlightindex(highlightIndex);
/* 180 */           xCage.setPressindex(0);
/* 181 */           xCage.setPresstime(0L);
/*     */           
/*     */ 
/* 184 */           GameServer.logger().info(String.format("[chinesevalentine]ChineseValentineManager.startCommand@command random highlight index in cage|gameid=%d|cageindex=%d|hightindex=%d", new Object[] { Long.valueOf(this.val$gameId), Integer.valueOf(i + 1), Integer.valueOf(highlightIndex) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 192 */         List<Long> roleIdList = xChineseValentineGame.getRoleidlist();
/* 193 */         SChineseValentineRound protocol = new SChineseValentineRound();
/* 194 */         protocol.roundnumber = xRound.getRoundnumber();
/* 195 */         for (int i = 0; i < cageListSize; i++) {
/* 196 */           long roleId = ((Long)xChineseValentineGame.getRoleidlist().get(i)).longValue();
/* 197 */           ChineseValentineCage xCage = (ChineseValentineCage)cageList.get(i);
/* 198 */           protocol.highlightmap.put(Long.valueOf(roleId), Integer.valueOf(xCage.getHighlightindex()));
/*     */         }
/* 200 */         OnlineManager.getInstance().sendMulti(protocol, roleIdList);
/*     */         
/*     */ 
/* 203 */         MilliSession session = new ChineseValentineSessionCommand(ChineseValentineManager.getCfg().highLightTime, this.val$gameId);
/* 204 */         xRound.setSessionid(session.getSessionId());
/* 205 */         return true;
/*     */       }
/*     */     });
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
/*     */   public static void startSettlement(long gameId)
/*     */   {
/* 225 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception {
/* 228 */         ChineseValentineGame xGame = Chinesevalentine.select(Long.valueOf(this.val$gameId));
/* 229 */         if (xGame == null) {
/* 230 */           return false;
/*     */         }
/* 232 */         List<Long> roleIds = xGame.getRoleidlist();
/* 233 */         Map<Long, String> roleId2Userid = new HashMap();
/* 234 */         for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/* 235 */           roleId2Userid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */         }
/*     */         
/* 238 */         lock(xtable.User.getTable(), roleId2Userid.values());
/* 239 */         lock(xtable.Basic.getTable(), roleIds);
/*     */         
/* 241 */         int activityId = ChineseValentineConstCfg.getInstance().activityId;
/*     */         
/* 243 */         ChineseValentineGame xChineseValentineGame = Chinesevalentine.get(Long.valueOf(this.val$gameId));
/* 244 */         ChineseValentineRound xRound = xChineseValentineGame.getRoundinfo();
/* 245 */         xRound.setState(2);
/*     */         
/*     */ 
/* 248 */         List<ChineseValentineCage> xCageList = xRound.getCageinfolist();
/* 249 */         boolean allIsRight = true;
/* 250 */         for (int i = 0; i < xCageList.size(); i++) {
/* 251 */           ChineseValentineCage xCage = (ChineseValentineCage)xCageList.get(i);
/* 252 */           if ((xCage.getPresstime() == 0L) || (xCage.getPressindex() != xCage.getHighlightindex())) {
/* 253 */             allIsRight = false;
/* 254 */             break;
/*     */           }
/*     */         }
/* 257 */         int oldRight = xChineseValentineGame.getRightcount();
/* 258 */         int oldWrong = xChineseValentineGame.getWrongcount();
/* 259 */         if (allIsRight) {
/* 260 */           xChineseValentineGame.setRightcount(oldRight + 1);
/*     */         } else {
/* 262 */           xChineseValentineGame.setWrongcount(oldWrong + 1);
/*     */         }
/*     */         
/*     */ 
/* 266 */         List<Long> roleIdList = xChineseValentineGame.getRoleidlist();
/* 267 */         SChineseValentineRoundResult protocol = new SChineseValentineRoundResult();
/* 268 */         protocol.code = (allIsRight ? 1 : 2);
/* 269 */         protocol.roundnumber = xRound.getRoundnumber();
/* 270 */         OnlineManager.getInstance().sendMulti(protocol, roleIdList);
/*     */         
/*     */ 
/* 273 */         if (allIsRight) {
/* 274 */           java.util.Set<Map.Entry<Long, String>> entryset = roleId2Userid.entrySet();
/* 275 */           for (Map.Entry<Long, String> entry : entryset) {
/* 276 */             String userid = (String)entry.getValue();
/* 277 */             Long roleId = (Long)entry.getKey();
/* 278 */             ChineseValentineAwardRecord xChineseValentineAwardRecord = xtable.Role2chinesevalentineaward.get(roleId);
/*     */             
/* 280 */             if (xChineseValentineAwardRecord == null) {
/* 281 */               xChineseValentineAwardRecord = xbean.Pod.newChineseValentineAwardRecord();
/* 282 */               xtable.Role2chinesevalentineaward.insert(roleId, xChineseValentineAwardRecord);
/*     */             }
/*     */             
/* 285 */             int awardCount = xChineseValentineAwardRecord.getAwardcount();
/* 286 */             if (awardCount < ChineseValentineManager.getCfg().awardCount) {
/* 287 */               int awardId = ChineseValentineManager.getCfg().awardId;
/* 288 */               mzm.gsp.award.main.AwardReason awardReason = new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.CHINESE_VALENTINE, awardId);
/* 289 */               mzm.gsp.award.main.AwardInterface.award(awardId, userid, roleId.longValue(), false, true, awardReason);
/* 290 */               int newAwardCount = awardCount + 1;
/* 291 */               xChineseValentineAwardRecord.setAwardcount(newAwardCount);
/* 292 */               xChineseValentineAwardRecord.setTimestamp(DateTimeUtils.getCurrTimeInMillis());
/*     */               
/*     */ 
/* 295 */               GameServer.logger().info(String.format("[chinesevalentine]ChineseValentineManager.startSettlement@settle role info|gameid=%d|roleid=%d|awardId=%d|newAwardCount=%d|round=%d", new Object[] { Long.valueOf(this.val$gameId), roleId, Integer.valueOf(awardId), Integer.valueOf(newAwardCount), Integer.valueOf(xRound.getRoundnumber()) }));
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 301 */               ChineseValentineManager.tLogChineseValentineAward(this.val$gameId, roleId.longValue(), xRound.getRoundnumber(), awardId, newAwardCount);
/*     */               
/*     */ 
/*     */ 
/* 305 */               boolean isSameDay = DateTimeUtils.isInSameDay(DateTimeUtils.getCurrTimeInMillis(), xChineseValentineGame.getStarttime());
/*     */               
/* 307 */               if (isSameDay) {
/* 308 */                 ActivityInterface.addActivityCount(userid, roleId.longValue(), activityId);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 317 */         for (int i = 0; i < xCageList.size(); i++) {
/* 318 */           ChineseValentineCage xCage = (ChineseValentineCage)xCageList.get(i);
/* 319 */           GameServer.logger().info(String.format("[chinesevalentine]ChineseValentineManager.startSettlement@settle role info|gameid=%d|roleid=%d|cageindex=%d|hightindex=%d|pressindex=%d|round=%d", new Object[] { Long.valueOf(this.val$gameId), roleIdList.get(i), Integer.valueOf(i + 1), Integer.valueOf(xCage.getHighlightindex()), Integer.valueOf(xCage.getPressindex()), Integer.valueOf(xRound.getRoundnumber()) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 326 */           ChineseValentineManager.tLogChineseValentineRoleRoundSettleInfo(this.val$gameId, ((Long)roleIdList.get(i)).longValue(), xRound.getRoundnumber(), xCage.getHighlightindex(), xCage.getPressindex());
/*     */         }
/*     */         
/*     */ 
/* 330 */         GameServer.logger().info(String.format("[chinesevalentine]ChineseValentineManager.startSettlement@settle info|gameid=%d|roleidlist=%s|round=%d|right=%d|wrong=%d|isroundallright=%b", new Object[] { Long.valueOf(this.val$gameId), roleIdList.toString(), Integer.valueOf(xRound.getRoundnumber()), Integer.valueOf(xChineseValentineGame.getRightcount()), Integer.valueOf(xChineseValentineGame.getWrongcount()), Boolean.valueOf(allIsRight) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 339 */         int leftRound = ChineseValentineManager.getGameLeftRoundCount(this.val$gameId);
/* 340 */         if (leftRound > 0)
/*     */         {
/* 342 */           int settleTime = ChineseValentineManager.getCfg().endRoundEffectTime;
/* 343 */           if (allIsRight) {
/* 344 */             long minPressTime = 0L;
/* 345 */             long maxPressTime = 0L;
/* 346 */             for (int i = 0; i < xCageList.size(); i++) {
/* 347 */               ChineseValentineCage xCage = (ChineseValentineCage)xCageList.get(i);
/* 348 */               long pressTime = xCage.getPresstime();
/* 349 */               if ((pressTime < minPressTime) || (minPressTime == 0L)) {
/* 350 */                 minPressTime = pressTime;
/*     */               }
/* 352 */               if ((pressTime > maxPressTime) || (maxPressTime == 0L)) {
/* 353 */                 maxPressTime = pressTime;
/*     */               }
/*     */             }
/*     */             
/*     */ 
/* 358 */             long flyContinueTime = ChineseValentineManager.getCfg().roadMaxTime - (maxPressTime - minPressTime);
/* 359 */             if (flyContinueTime > 0L) {
/* 360 */               settleTime = (int)(settleTime + flyContinueTime);
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 365 */           MilliSession session = new ChineseValentineSessionSettlement(settleTime, this.val$gameId);
/* 366 */           xRound.setSessionid(session.getSessionId());
/*     */         }
/*     */         else
/*     */         {
/* 370 */           for (Long roleId : roleIds) {
/* 371 */             xtable.Role2chinesevalentine.remove(roleId);
/*     */           }
/* 373 */           Chinesevalentine.remove(Long.valueOf(this.val$gameId));
/*     */         }
/*     */         
/* 376 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   protected static SChineseValentineCfg getCfg()
/*     */   {
/* 384 */     return SChineseValentineCfg.get(ChineseValentineConstCfg.getInstance().activityId);
/*     */   }
/*     */   
/*     */   public static void tLogChineseValentineAward(long gameId, long roleId, int round, int awardId, int awardCount)
/*     */   {
/* 389 */     String userid = RoleInterface.getUserId(roleId);
/* 390 */     Object[] columnns = { userid, Long.valueOf(roleId), Long.valueOf(gameId), Integer.valueOf(round), Integer.valueOf(awardId), Integer.valueOf(awardCount) };
/* 391 */     TLogManager.getInstance().addLog(roleId, "ChineseValentineAward", columnns);
/*     */   }
/*     */   
/*     */   public static void tLogChineseValentineNewGame(long gameId, long roleId)
/*     */   {
/* 396 */     String userid = RoleInterface.getUserId(roleId);
/* 397 */     Object[] columnns = { userid, Long.valueOf(roleId), Long.valueOf(gameId) };
/* 398 */     TLogManager.getInstance().addLog(roleId, "ChineseValentineNewGame", columnns);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void tLogChineseValentineRoleRoundSettleInfo(long gameId, long roleId, int round, int highlight, int press)
/*     */   {
/* 404 */     String userid = RoleInterface.getUserId(roleId);
/* 405 */     Object[] columnns = { userid, Long.valueOf(roleId), Long.valueOf(gameId), Integer.valueOf(round), Integer.valueOf(highlight), Integer.valueOf(press) };
/* 406 */     TLogManager.getInstance().addLog(roleId, "ChineseValentineRoleRoundSettle", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\ChineseValentineManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */