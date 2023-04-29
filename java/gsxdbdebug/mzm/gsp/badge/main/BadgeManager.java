/*    */ package mzm.gsp.badge.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.title.confbean.SBadgeCfg;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.BadgeInfo;
/*    */ import xbean.RoleBadgesInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BadgeManager
/*    */ {
/*    */   static boolean isBadgeIdExist(int badgeId)
/*    */   {
/* 23 */     return SBadgeCfg.get(badgeId) != null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getBadgeTimeCfg(int badgeId)
/*    */   {
/* 34 */     SBadgeCfg cfg = SBadgeCfg.get(badgeId);
/* 35 */     if (cfg == null)
/*    */     {
/* 37 */       return -1;
/*    */     }
/* 39 */     return cfg.badgeLimit * 60;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static long getRoleBadgeEndTime(int badgeId)
/*    */   {
/* 50 */     int cfgTime = getBadgeTimeCfg(badgeId);
/* 51 */     if (cfgTime < 0)
/*    */     {
/* 53 */       return -1L;
/*    */     }
/*    */     
/* 56 */     long timeNow = DateTimeUtils.getCurrTimeInMillis();
/* 57 */     return timeNow + cfgTime * 1000;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static Map<Integer, Long> getRoleBadgeInfo(RoleBadgesInfo xRoleBadgesInfo)
/*    */   {
/* 68 */     if (xRoleBadgesInfo == null)
/*    */     {
/* 70 */       return Collections.emptyMap();
/*    */     }
/* 72 */     Map<Integer, Long> badgeId2timeOut = new HashMap();
/* 73 */     for (Map.Entry<Integer, BadgeInfo> entry : xRoleBadgesInfo.getBadgesinfo().entrySet())
/*    */     {
/* 75 */       badgeId2timeOut.put(entry.getKey(), Long.valueOf(((BadgeInfo)entry.getValue()).getTimelimit()));
/*    */     }
/* 77 */     return badgeId2timeOut;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void tlogHandBadge(long roleId, Map<Integer, Long> badgeId2timeOut, int badgeId, int action, long timeOut)
/*    */   {
/* 91 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 92 */     String userid = RoleInterface.getUserId(roleId);
/* 93 */     int rolelevel = RoleInterface.getLevel(roleId);
/*    */     
/* 95 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(badgeId), Long.valueOf(timeOut), Integer.valueOf(action), badgeId2timeOut.toString() };
/*    */     
/*    */ 
/* 98 */     TLogManager.getInstance().addLog(roleId, "Badge", colums);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\badge\main\BadgeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */