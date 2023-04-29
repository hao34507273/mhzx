/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ public class IdipInterface
/*    */ {
/*    */   public static void banPlayAll(long roleid, int seconds, String reason)
/*    */   {
/*  7 */     IdipManager.banPlayAll(roleid, seconds, reason);
/*    */   }
/*    */   
/*    */   public static void addBanPlay(long roleid, int playType, int seconds, String reason)
/*    */   {
/* 12 */     IdipManager.addBanPlay(roleid, playType, seconds, reason);
/*    */   }
/*    */   
/*    */   public static void removeBanPlayAll(long roleid)
/*    */   {
/* 17 */     IdipManager.removeBanPlayAll(roleid);
/*    */   }
/*    */   
/*    */   public static void removeBanPlay(long roleid, int playType)
/*    */   {
/* 22 */     IdipManager.removeBanPlay(roleid, playType);
/*    */   }
/*    */   
/*    */   public static boolean addZeroProfit(long roleid, int seconds, String reason)
/*    */   {
/* 27 */     return IdipManager.addZeroProfit(roleid, seconds, reason);
/*    */   }
/*    */   
/*    */   public static void relieveZeroProfit(long roleid)
/*    */   {
/* 32 */     IdipManager.relieveZeroProfit(roleid);
/*    */   }
/*    */   
/*    */ 
/*    */   public static void addLockRoleInfo(long roleid, int type, long time, String content)
/*    */   {
/* 38 */     IdipManager.addLockRoleInfo(roleid, type, time, content);
/*    */   }
/*    */   
/*    */   public static void banRankAll(long roleid, long seconds, String reason)
/*    */   {
/* 43 */     IdipManager.banRankAll(roleid, seconds, reason);
/*    */   }
/*    */   
/*    */   public static void addBanRank(long roleid, int rankType, long seconds, String reason)
/*    */   {
/* 48 */     IdipManager.addBanRank(roleid, rankType, seconds, reason);
/*    */   }
/*    */   
/*    */   public static void removeBanRankAll(long roleid)
/*    */   {
/* 53 */     IdipManager.removeBanRankAll(roleid);
/*    */   }
/*    */   
/*    */   public static void removeBanRank(long roleid, int rankType)
/*    */   {
/* 58 */     IdipManager.removeBanRank(roleid, rankType);
/*    */   }
/*    */   
/*    */   public static void removeLockRoleInfo(long roleid, int infoType)
/*    */   {
/* 63 */     IdipManager.removeLockRoleInfo(roleid, infoType);
/*    */   }
/*    */   
/*    */   public static int getBigBossChartType(long roleid)
/*    */   {
/* 68 */     return IdipManager.getBigBossChartType(roleid);
/*    */   }
/*    */   
/*    */   public static void globalNTimesFinalServerAwardInstall(long roleId)
/*    */   {
/* 73 */     NTimesAwardManager.globalNTimesFinalServerAwardInstall(roleId);
/*    */   }
/*    */   
/*    */   public static void globalNTimesFinalServerAwardUnInstall(long roleId)
/*    */   {
/* 78 */     NTimesAwardManager.globalNTimesFinalServerAwardUnInstall(roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\IdipInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */