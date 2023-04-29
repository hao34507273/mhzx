/*     */ package mzm.gsp.musicgame.main;
/*     */ 
/*     */ import mzm.gsp.musicgame.confbean.SMusicGameCfg;
/*     */ import mzm.gsp.musicgame.event.MusicGameContext;
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
/*     */ public class MusicGameInterface
/*     */ {
/*     */   public static void startMusicGame(long roleid, int gameid, boolean isRestartGame, int currentPoint, MusicGameContext context)
/*     */   {
/*  25 */     new PStartMusicGame(roleid, gameid, isRestartGame, currentPoint, context).execute();
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
/*     */   public static void stopMusicGame(long roleid, int gameid, boolean isPauseGame, boolean isRoleActive)
/*     */   {
/*  42 */     new PStopMusicGame(roleid, gameid, isPauseGame, isRoleActive).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMusicGameExist(int gameid)
/*     */   {
/*  54 */     return SMusicGameCfg.get(gameid) != null;
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
/*     */   public static int getMusicGamePointUpperLimit(int gameid)
/*     */   {
/*  67 */     SMusicGameCfg cfg = SMusicGameCfg.get(gameid);
/*  68 */     if (cfg == null)
/*     */     {
/*  70 */       return -1;
/*     */     }
/*  72 */     return cfg.point_upper_limit;
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
/*     */   public static int getMusicGameRightPoint(int gameid)
/*     */   {
/*  85 */     SMusicGameCfg cfg = SMusicGameCfg.get(gameid);
/*  86 */     if (cfg == null)
/*     */     {
/*  88 */       return -1;
/*     */     }
/*  90 */     return cfg.right_point;
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
/*     */   public static int getMusicGameWrongPoint(int gameid)
/*     */   {
/* 103 */     SMusicGameCfg cfg = SMusicGameCfg.get(gameid);
/* 104 */     if (cfg == null)
/*     */     {
/* 106 */       return -1;
/*     */     }
/* 108 */     return cfg.wrong_point;
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
/*     */   public static long getRoleLastMusicGameStartTimestamp(long roleid, int gameid)
/*     */   {
/* 125 */     return MusicGameManager.getRoleLastMusicGameStartTimestamp(roleid, gameid);
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
/*     */   public static MusicGameContext getRoleLastMusicGameContext(long roleid, int gameid)
/*     */   {
/* 142 */     return MusicGameManager.getRoleLastMusicGameContext(roleid, gameid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\main\MusicGameInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */