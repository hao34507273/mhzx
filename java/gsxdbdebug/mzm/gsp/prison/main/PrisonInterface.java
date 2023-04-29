/*     */ package mzm.gsp.prison.main;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JailProtectInfo;
/*     */ import xbean.JailStatInfo;
/*     */ import xbean.PrisonInfo;
/*     */ import xtable.Role2jailstatinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrisonInterface
/*     */ {
/*     */   public static boolean isRoleInJail(long roleId)
/*     */   {
/*  30 */     return PrisonPageManager.getInstance().containsRecord(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getRoleJailProtectTimeLeft(JailProtectInfo xJailProtectInfo)
/*     */   {
/*  41 */     if (xJailProtectInfo == null)
/*     */     {
/*  43 */       return -1L;
/*     */     }
/*  45 */     return TimeUnit.MILLISECONDS.toSeconds(xJailProtectInfo.getLeavejailtimestamp()) + TimeUnit.MINUTES.toSeconds(SPKConsts.getInstance().LEAVE_PRISON_FORBIDDEN_PK_MINUTES) - TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void putRoleInJail(long roleId)
/*     */     throws Exception
/*     */   {
/*  58 */     PrisonPageManager.getInstance().addRecord(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void letRoleOutOfJail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, TLogArg tLogArg)
/*     */     throws Exception
/*     */   {
/*  70 */     PrisonPageManager.getInstance().deleteRecord(Long.valueOf(roleId));
/*     */     
/*  72 */     MailInterface.asynBuildAndSendMail(roleId, mailCfgId, titleArgs, contentArgs, tLogArg);
/*     */   }
/*     */   
/*     */   public static boolean checkRoleCanGetOutFromPrisonMap(int oldMapId, long roleId)
/*     */   {
/*  77 */     if ((oldMapId == SPKConsts.getInstance().PRISON_MAP_ID) && (isRoleInJail(roleId)))
/*     */     {
/*  79 */       return false;
/*     */     }
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static RoleJailStat checkCanLetRoleOutOfJail(long roleId, PrisonInfo xPrisonInfo)
/*     */     throws Exception
/*     */   {
/*  93 */     RoleJailStat roleJailStat = new RoleJailStat();
/*  94 */     roleJailStat.canGetOutOfJail = false;
/*     */     
/*  96 */     if (xPrisonInfo == null)
/*     */     {
/*  98 */       letRoleOutOfJail(roleId, SPKConsts.getInstance().JAIL_OUT_MAIL_ID, new ArrayList(), new ArrayList(), new TLogArg(LogReason.JAIL_OUT_MAIL));
/*     */       
/* 100 */       roleJailStat.canGetOutOfJail = true;
/* 101 */       return roleJailStat;
/*     */     }
/*     */     
/*     */ 
/* 105 */     long roleLastLogOffTimeStamp = RoleInterface.getLastLogoffTime(roleId);
/*     */     
/* 107 */     long roleLastInJailTimeStamp = roleLastLogOffTimeStamp > xPrisonInfo.getEnterjailtimestamp() ? roleLastLogOffTimeStamp : DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 112 */     roleJailStat.inJailOnlineTime = (xPrisonInfo.getInjailonlinetime() + roleLastInJailTimeStamp - xPrisonInfo.getEnterjailtimestamp());
/*     */     
/*     */ 
/*     */ 
/* 116 */     roleJailStat.inJailLeftTime = (TimeUnit.MINUTES.toSeconds(SPKConsts.getInstance().PRISON_SERVE_MINUTES) - TimeUnit.MILLISECONDS.toSeconds(roleJailStat.inJailOnlineTime));
/*     */     
/*     */ 
/* 119 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */     
/* 121 */     GameServer.logger().info(String.format("[prison]PrisonInterface.checkCanLetRoleOutOfJail 上次下线时间:%s|上次在狱中时间:%s|已经在狱中时间(分钟):%s|狱中剩余时间(分钟):%s", new Object[] { simpleDateFormat.format(Long.valueOf(roleLastLogOffTimeStamp)), simpleDateFormat.format(Long.valueOf(roleLastInJailTimeStamp)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(roleJailStat.inJailOnlineTime)), Long.valueOf(TimeUnit.SECONDS.toMinutes(roleJailStat.inJailLeftTime)) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 127 */     if (roleJailStat.inJailLeftTime <= 0L)
/*     */     {
/* 129 */       letRoleOutOfJail(roleId, SPKConsts.getInstance().JAIL_OUT_MAIL_ID, new ArrayList(), new ArrayList(), new TLogArg(LogReason.JAIL_OUT_MAIL));
/*     */       
/* 131 */       roleJailStat.canGetOutOfJail = true;
/* 132 */       return roleJailStat;
/*     */     }
/* 134 */     return roleJailStat;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isRoleInJailMap(long roleId)
/*     */   {
/* 145 */     int mapId = MapInterface.getRoleMapId(roleId);
/* 146 */     return JailWorldManager.getInstance().isJailMap(mapId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getRoleTotalJailCount(long roleId, boolean isHoldRoleLock)
/*     */   {
/* 158 */     JailStatInfo xJailStatInfo = isHoldRoleLock ? Role2jailstatinfo.get(Long.valueOf(roleId)) : Role2jailstatinfo.select(Long.valueOf(roleId));
/*     */     
/*     */ 
/* 161 */     if (xJailStatInfo == null)
/*     */     {
/* 163 */       return 0;
/*     */     }
/* 165 */     return xJailStatInfo.getJailcount();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PrisonInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */