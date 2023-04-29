/*     */ package mzm.gsp.bubblegame.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.bubblegame.confbean.SBubbleGameCfg;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameContext;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BubbleGameInfo;
/*     */ import xbean.RoleBubbleGameInfo;
/*     */ import xtable.Role_bubble_game_infos;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BubbleGameManager
/*     */ {
/*  17 */   static Logger logger = Logger.getLogger("bubble");
/*  18 */   static int GAME_PROTECT_TIME = 5;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBubblecGameSwitchOpenForRole(long roleid, int gameid)
/*     */   {
/*  28 */     if (!OpenInterface.getOpenStatus(210))
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     SBubbleGameCfg cfg = SBubbleGameCfg.get(gameid);
/*  33 */     if (cfg == null)
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (OpenInterface.isBanPlay(roleid, 210))
/*     */     {
/*  43 */       OpenInterface.sendBanPlayMsg(roleid, 210);
/*  44 */       return false;
/*     */     }
/*  46 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/*  48 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  49 */       return false;
/*     */     }
/*  51 */     return true;
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
/*  62 */     return RoleStatusInterface.checkCanSetStatus(roleid, status, true);
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
/*     */   static long getRoleLastBubbleGameStartTimestamp(long roleid, int gameid)
/*     */   {
/*  79 */     RoleBubbleGameInfo xRoleBubbleGameInfo = Role_bubble_game_infos.get(Long.valueOf(roleid));
/*  80 */     if (xRoleBubbleGameInfo == null)
/*     */     {
/*  82 */       return -1L;
/*     */     }
/*  84 */     BubbleGameInfo xBubbleGameInfo = (BubbleGameInfo)xRoleBubbleGameInfo.getBubble_game_infos().get(Integer.valueOf(gameid));
/*  85 */     if (xBubbleGameInfo == null)
/*     */     {
/*  87 */       return -1L;
/*     */     }
/*  89 */     return xBubbleGameInfo.getStart_timestamp();
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
/*     */   static BubbleGameContext getRoleLastBubbleGameContext(long roleid, int gameid)
/*     */   {
/* 106 */     RoleBubbleGameInfo xRoleBubbleGameInfo = Role_bubble_game_infos.get(Long.valueOf(roleid));
/* 107 */     if (xRoleBubbleGameInfo == null)
/*     */     {
/* 109 */       return null;
/*     */     }
/* 111 */     BubbleGameInfo xBubbleGameInfo = (BubbleGameInfo)xRoleBubbleGameInfo.getBubble_game_infos().get(Integer.valueOf(gameid));
/* 112 */     if (xBubbleGameInfo == null)
/*     */     {
/* 114 */       return null;
/*     */     }
/* 116 */     return xBubbleGameInfo.getContext();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\main\BubbleGameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */