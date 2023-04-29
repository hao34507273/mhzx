/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogManager;
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
/*     */ public class PartnerLogManager
/*     */ {
/*     */   private static final String TLOG_PARTNER = "Partner";
/*     */   private static final String TLOG_PARTNER_OWN = "PartnerOwn";
/*     */   private static final String TLOG_PARTNER_STATUE = "PartnerStatue";
/*     */   private static final String TLOG_PARTNER_SQUAD = "PartnerDefaultSquad";
/*     */   
/*     */   public static boolean addPatnerShuffleLog(long roleId, int partnerId, int status)
/*     */   {
/*  28 */     zLogPartner(roleId, partnerId, status);
/*     */     
/*  30 */     tlogPartner(roleId, partnerId, status);
/*     */     
/*  32 */     return true;
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
/*     */   public static boolean addPatnerOwnLog(long roleId, int partnerId)
/*     */   {
/*  45 */     tlogPartnerOwn(roleId, partnerId);
/*     */     
/*  47 */     return true;
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
/*     */   public static boolean partnerStatueChangeLog(long roleId, int partnerId, int squadId, int statue)
/*     */   {
/*  63 */     tlogPartnerStatueChange(roleId, partnerId, squadId, statue);
/*     */     
/*  65 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean partnerDefaultSquadChangeLog(long roleId, int squadId)
/*     */   {
/*  77 */     tlogPartnerDefaultSquadChange(roleId, squadId);
/*     */     
/*  79 */     return true;
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
/*     */   static boolean zLogPartner(long roleId, int partnerId, int status)
/*     */   {
/*  92 */     int platform = RoleInterface.getPlatform(roleId);
/*  93 */     String channel = RoleInterface.getChannel(roleId);
/*  94 */     String mac = RoleInterface.getMac(roleId);
/*  95 */     String userId = RoleInterface.getUserId(roleId);
/*  96 */     int level = RoleInterface.getLevel(roleId);
/*     */     
/*  98 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%d|%d", new Object[] { Integer.valueOf(platform), channel, mac, userId, Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(partnerId), Integer.valueOf(status) });
/*     */     
/* 100 */     LogManager.getInstance().addLog("fellow", logStr);
/*     */     
/* 102 */     return true;
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
/*     */   public static void tlogPartner(long roleId, int partnerId, int status)
/*     */   {
/* 115 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 116 */     String userid = RoleInterface.getUserId(roleId);
/* 117 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 119 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(partnerId), Integer.valueOf(status) });
/* 120 */     TLogManager.getInstance().addLog(roleId, "Partner", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogPartnerOwn(long roleId, int partnerId)
/*     */   {
/* 131 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 132 */     String userid = RoleInterface.getUserId(roleId);
/* 133 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 135 */     String logStr = String.format("%s|%s|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(partnerId) });
/* 136 */     TLogManager.getInstance().addLog(roleId, "PartnerOwn", logStr);
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
/*     */   public static void tlogPartnerStatueChange(long roleId, int partnerId, int squadId, int statue)
/*     */   {
/* 149 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 150 */     String userid = RoleInterface.getUserId(roleId);
/* 151 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 153 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(squadId), Integer.valueOf(partnerId), Integer.valueOf(statue) });
/* 154 */     TLogManager.getInstance().addLog(roleId, "PartnerStatue", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogPartnerDefaultSquadChange(long roleId, int squadId)
/*     */   {
/* 165 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 166 */     String userid = RoleInterface.getUserId(roleId);
/* 167 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 169 */     String logStr = String.format("%s|%s|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(squadId) });
/* 170 */     TLogManager.getInstance().addLog(roleId, "PartnerDefaultSquad", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PartnerLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */