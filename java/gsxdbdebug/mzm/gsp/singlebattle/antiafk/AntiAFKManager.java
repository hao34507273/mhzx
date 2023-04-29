/*     */ package mzm.gsp.singlebattle.antiafk;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.afk.main.AFKInterface;
/*     */ import mzm.gsp.singlebattle.confbean.AntiAFKCfg;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class AntiAFKManager
/*     */ {
/*     */   static boolean startAFKDetect(long roleid)
/*     */   {
/*  25 */     int afkDetectCfgid = getAFKDetectCfgid(roleid);
/*  26 */     if (afkDetectCfgid <= 0)
/*     */     {
/*  28 */       return false;
/*     */     }
/*  30 */     AFKInterface.startAFKDetect(roleid, afkDetectCfgid);
/*  31 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean resetAFKDetect(long roleid)
/*     */   {
/*  43 */     int afkDetectCfgid = getAFKDetectCfgid(roleid);
/*  44 */     if (afkDetectCfgid <= 0)
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     AFKInterface.resetAFKDetect(roleid, afkDetectCfgid);
/*  49 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean stopAFKDetect(long roleid)
/*     */   {
/*  61 */     int afkDetectCfgid = getAFKDetectCfgid(roleid);
/*  62 */     if (afkDetectCfgid <= 0)
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     AFKInterface.stopAFKDetect(roleid, afkDetectCfgid);
/*  67 */     return true;
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
/*     */   static int getAFKDetectCfgid(long roleid)
/*     */   {
/*  81 */     long battleid = SingleBattleInterface.getBattleId(roleid, false);
/*  82 */     if (battleid < 0L)
/*     */     {
/*  84 */       GameServer.logger().info(String.format("[singlebattle]AntiAFKManager.getAFKDetectCfgid@role is not in single battle|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*  87 */       return -1;
/*     */     }
/*  89 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(battleid, true);
/*  90 */     if (globalInfo == null)
/*     */     {
/*     */ 
/*  93 */       return -1;
/*     */     }
/*  95 */     int playCfgid = globalInfo.getPlayCfgId(6);
/*  96 */     if (playCfgid < 0)
/*     */     {
/*  98 */       GameServer.logger().info(String.format("[singlebattle]AntiAFKManager.getAFKDetectCfgid@single battle do not have anti afk|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*     */ 
/* 102 */       return -1;
/*     */     }
/* 104 */     AntiAFKCfg cfg = AntiAFKCfg.get(playCfgid);
/* 105 */     if (cfg == null)
/*     */     {
/*     */ 
/* 108 */       return -1;
/*     */     }
/* 110 */     return cfg.afk_detect_cfg_id;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\antiafk\AntiAFKManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */