/*     */ package mzm.gsp.musicgame.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.musicgame.confbean.SMusicGameCfg;
/*     */ import mzm.gsp.musicgame.event.MusicGameContext;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MusicGameInfo;
/*     */ import xbean.RoleMusicGameInfo;
/*     */ import xtable.Role_music_game_infos;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MusicGameManager
/*     */ {
/*  17 */   static Logger logger = Logger.getLogger("musicgame");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMusicGameSwitchOpenForRole(long roleid, int gameid)
/*     */   {
/*  27 */     if (!OpenInterface.getOpenStatus(204))
/*     */     {
/*  29 */       return false;
/*     */     }
/*  31 */     SMusicGameCfg cfg = SMusicGameCfg.get(gameid);
/*  32 */     if (cfg == null)
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     if (OpenInterface.isBanPlay(roleid, 204))
/*     */     {
/*  42 */       OpenInterface.sendBanPlayMsg(roleid, 204);
/*  43 */       return false;
/*     */     }
/*  45 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/*  47 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  48 */       return false;
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkRoleStatus(long roleid, int status)
/*     */   {
/*  61 */     return RoleStatusInterface.checkCanSetStatus(roleid, status, true);
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
/*     */   static long getRoleLastMusicGameStartTimestamp(long roleid, int gameid)
/*     */   {
/*  78 */     RoleMusicGameInfo xRoleMusicGameInfo = Role_music_game_infos.get(Long.valueOf(roleid));
/*  79 */     if (xRoleMusicGameInfo == null)
/*     */     {
/*  81 */       return -1L;
/*     */     }
/*  83 */     MusicGameInfo xMusicGameInfo = (MusicGameInfo)xRoleMusicGameInfo.getMusic_game_infos().get(Integer.valueOf(gameid));
/*  84 */     if (xMusicGameInfo == null)
/*     */     {
/*  86 */       return -1L;
/*     */     }
/*  88 */     return xMusicGameInfo.getStart_timestamp();
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
/*     */   static MusicGameContext getRoleLastMusicGameContext(long roleid, int gameid)
/*     */   {
/* 105 */     RoleMusicGameInfo xRoleMusicGameInfo = Role_music_game_infos.get(Long.valueOf(roleid));
/* 106 */     if (xRoleMusicGameInfo == null)
/*     */     {
/* 108 */       return null;
/*     */     }
/* 110 */     MusicGameInfo xMusicGameInfo = (MusicGameInfo)xRoleMusicGameInfo.getMusic_game_infos().get(Integer.valueOf(gameid));
/* 111 */     if (xMusicGameInfo == null)
/*     */     {
/* 113 */       return null;
/*     */     }
/* 115 */     return xMusicGameInfo.getContext();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\main\MusicGameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */