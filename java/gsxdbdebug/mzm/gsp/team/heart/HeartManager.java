/*     */ package mzm.gsp.team.heart;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.SGetHeart;
/*     */ import mzm.gsp.team.confbean.STeamHeartSeedCfg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HeartInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2heart;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeartManager
/*     */ {
/*     */   static int getTriggerTimeAndCheck(long roleId, long curTime)
/*     */   {
/*  29 */     HeartInfo xHeartInfo = Role2heart.get(Long.valueOf(roleId));
/*  30 */     if (xHeartInfo == null)
/*     */     {
/*  32 */       xHeartInfo = Pod.newHeartInfo();
/*  33 */       xHeartInfo.setLastchecktime(curTime);
/*  34 */       Role2heart.insert(Long.valueOf(roleId), xHeartInfo);
/*     */     }
/*  36 */     long lastCheckTime = xHeartInfo.getLastchecktime();
/*  37 */     if (!DateTimeUtils.isInSameDay(lastCheckTime, curTime))
/*     */     {
/*  39 */       xHeartInfo.setLastchecktime(curTime);
/*  40 */       xHeartInfo.setTriggertime(0);
/*     */     }
/*  42 */     return xHeartInfo.getTriggertime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRanSeedByLv(int level)
/*     */   {
/*  54 */     for (STeamHeartSeedCfg cfg : STeamHeartSeedCfg.getAll().values())
/*     */     {
/*  56 */       if ((level >= cfg.lvMin) && 
/*     */       
/*     */ 
/*     */ 
/*  60 */         (level <= cfg.lvMax))
/*     */       {
/*     */ 
/*     */ 
/*  64 */         return cfg.ranSeed; }
/*     */     }
/*  66 */     GameServer.logger().error(String.format("[heart]HeartManager.getRanSeedByLv@ no lv seed cfg!|lv=%d", new Object[] { Integer.valueOf(level) }));
/*  67 */     return -1;
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
/*     */   static void sendBothSGetHeart(long roleId1, long roleId2)
/*     */   {
/*  80 */     sendSGetHeart(roleId1, roleId2);
/*  81 */     sendSGetHeart(roleId2, roleId1);
/*     */   }
/*     */   
/*     */   private static void sendSGetHeart(long roleId, long otherId)
/*     */   {
/*  86 */     SGetHeart p = new SGetHeart();
/*  87 */     fillOtherInfo(otherId, p);
/*  88 */     OnlineManager.getInstance().send(roleId, p);
/*     */   }
/*     */   
/*     */   private static void fillOtherInfo(long otherId, SGetHeart p)
/*     */   {
/*  93 */     Role other = RoleInterface.getRole(otherId, false);
/*  94 */     p.otherroleid = otherId;
/*  95 */     p.othername = other.getName();
/*  96 */     p.otherlv = other.getLevel();
/*  97 */     p.othergender = other.getGender();
/*  98 */     p.othermenpai = other.getOccupationId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isHeartModuleOpen()
/*     */   {
/* 108 */     if (!OpenInterface.getOpenStatus(136))
/*     */     {
/* 110 */       return false;
/*     */     }
/* 112 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\heart\HeartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */