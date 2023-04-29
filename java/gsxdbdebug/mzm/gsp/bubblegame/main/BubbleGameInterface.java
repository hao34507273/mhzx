/*     */ package mzm.gsp.bubblegame.main;
/*     */ 
/*     */ import mzm.gsp.bubblegame.confbean.SBubbleGameCfg;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameContext;
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
/*     */ public class BubbleGameInterface
/*     */ {
/*     */   public static void startBubbleGame(long roleid, int gameid, boolean isRestartGame, int currentPoint, BubbleGameContext context)
/*     */   {
/*  25 */     new PStartBubbleGame(roleid, gameid, isRestartGame, currentPoint, context).execute();
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
/*     */   public static void resumeBubbleGame(long roleid, int gameid, int currentPoint)
/*     */   {
/*  40 */     new PResumeBubbleGame(roleid, gameid, currentPoint).execute();
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
/*     */   public static void stopBubbleGame(long roleid, int gameid, boolean isRoleActive)
/*     */   {
/*  55 */     new PStopBubbleGame(roleid, gameid, isRoleActive).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isBubbleGameExist(int gameid)
/*     */   {
/*  67 */     return SBubbleGameCfg.get(gameid) != null;
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
/*     */   public static int getBubbleGamePointUpperLimit(int gameid)
/*     */   {
/*  80 */     SBubbleGameCfg cfg = SBubbleGameCfg.get(gameid);
/*  81 */     if (cfg == null)
/*     */     {
/*  83 */       return -1;
/*     */     }
/*  85 */     return cfg.point_upper_limit;
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
/*     */   public static int getBubbleGameRightPoint(int gameid)
/*     */   {
/*  98 */     SBubbleGameCfg cfg = SBubbleGameCfg.get(gameid);
/*  99 */     if (cfg == null)
/*     */     {
/* 101 */       return -1;
/*     */     }
/* 103 */     return cfg.right_point;
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
/*     */   public static int getBubbleGameWrongPoint(int gameid)
/*     */   {
/* 116 */     SBubbleGameCfg cfg = SBubbleGameCfg.get(gameid);
/* 117 */     if (cfg == null)
/*     */     {
/* 119 */       return -1;
/*     */     }
/* 121 */     return cfg.wrong_point;
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
/*     */   public static long getRoleLastBubbleGameStartTimestamp(long roleid, int gameid)
/*     */   {
/* 138 */     return BubbleGameManager.getRoleLastBubbleGameStartTimestamp(roleid, gameid);
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
/*     */   public static BubbleGameContext getRoleLastBubbleGameContext(long roleid, int gameid)
/*     */   {
/* 155 */     return BubbleGameManager.getRoleLastBubbleGameContext(roleid, gameid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\main\BubbleGameInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */