/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossbattlePointRaceInfo;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PPointRaceBackupMail extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final long corpsid;
/*     */   private final int index;
/*     */   
/*     */   public PPointRaceBackupMail(int activityCfgid, long corpsid, int index)
/*     */   {
/*  29 */     this.activityCfgid = activityCfgid;
/*  30 */     this.corpsid = corpsid;
/*  31 */     this.index = index;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  38 */     if (cfg == null)
/*     */     {
/*  40 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceBackupMail.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     TimePointInfo timePointInfo = (TimePointInfo)cfg.timePoints.get(this.index - 1);
/*  47 */     int timePointCfgid = timePointInfo.timePoint;
/*  48 */     int backupTimePointCfgid = timePointInfo.backupTimePoint;
/*     */     
/*  50 */     STimePointCommonCfg backupTimePointCommonCfg = STimePointCommonCfg.get(backupTimePointCfgid);
/*  51 */     if (backupTimePointCommonCfg == null)
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceBackupMail.processImp@time point cfg is null|activity_cfgid=%d|corpsid=%d|time_point_index=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.index) }));
/*     */       
/*     */ 
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     if (!CrossBattlePointManager.isFunOpen(cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  63 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceBackupMail.processImp@fun not open|activity_cfgid=%d|corpsid=%d|time_point_index=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.index) }));
/*     */       
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = CrossBattlePointManager.getCrossbattlePointRaceInfo(this.activityCfgid, timePointCfgid, false);
/*     */     
/*  72 */     if (xCrossbattlePointRaceInfo == null)
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     List<Long> members = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(this.corpsid, this.activityCfgid, false);
/*     */     
/*  79 */     if (members == null)
/*     */     {
/*  81 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceBackupMail.processImp@register role list is null|activity_cfgid=%d|corpsid=%d|time_point_index=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.index) }));
/*     */       
/*     */ 
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     lock(Basic.getTable(), members);
/*     */     
/*  90 */     long prepareTime = TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute);
/*  91 */     long startTime = TimeCommonUtil.getTimePoint(backupTimePointCommonCfg) - prepareTime;
/*  92 */     Calendar calendar = DateTimeUtils.getCalendar();
/*  93 */     calendar.setTimeInMillis(startTime);
/*  94 */     int year = calendar.get(1);
/*  95 */     int month = calendar.get(2) + 1;
/*  96 */     int day = calendar.get(5);
/*  97 */     int hour = calendar.get(11);
/*  98 */     int minute = calendar.get(12);
/*     */     
/* 100 */     List<String> contentArgs = new ArrayList();
/* 101 */     contentArgs.add(String.valueOf(this.index));
/* 102 */     contentArgs.add(String.valueOf(year));
/* 103 */     if (month < 10)
/*     */     {
/* 105 */       contentArgs.add(String.format("0%d", new Object[] { Integer.valueOf(month) }));
/*     */     }
/*     */     else
/*     */     {
/* 109 */       contentArgs.add(String.valueOf(month));
/*     */     }
/* 111 */     contentArgs.add(String.valueOf(day));
/* 112 */     contentArgs.add(String.valueOf(hour));
/* 113 */     if (minute < 10)
/*     */     {
/* 115 */       contentArgs.add(String.format("0%d", new Object[] { Integer.valueOf(minute) }));
/*     */     }
/*     */     else
/*     */     {
/* 119 */       contentArgs.add(String.valueOf(minute));
/*     */     }
/*     */     
/* 122 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.CROSS_BATTLE_POINT_RACE_PREPARE_MAIL);
/* 123 */     int mailCfgid = cfg.changeMailCfgid;
/*     */     
/* 125 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 127 */       SendMailRet sendMailRet = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleid, mailCfgid, null, contentArgs, tLogArg);
/* 128 */       if (!sendMailRet.isOK())
/*     */       {
/* 130 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRacePrepareMail.processImp@send mail fail|activity_cfgid=%d|corpsid=%d|time_point_index=%d|mail_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.index), Integer.valueOf(mailCfgid), Long.valueOf(roleid) }));
/*     */         
/*     */ 
/*     */ 
/* 134 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 139 */     int zone = CrossBattlePointManager.getCorpsZone(this.activityCfgid, this.corpsid);
/* 140 */     CrossBattlePointManager.syncPointRaceStage(members, zone, this.index, (byte)1, -1, 0L);
/*     */     
/* 142 */     GameServer.logger().info(String.format("[crossbattlepoint]PPointRacePrepareMail.processImp@send mail success|activity_cfgid=%d|corpsid=%d|time_point_index=%d|mail_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.index), Integer.valueOf(mailCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 146 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRaceBackupMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */