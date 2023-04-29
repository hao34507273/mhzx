/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossbattlePointRaceInfo;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PPointRacePrepareMail extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final long corpsid;
/*     */   private final int timePointCfgid;
/*     */   
/*     */   public PPointRacePrepareMail(int activityCfgid, long corpsid, int timePointCfgid)
/*     */   {
/*  28 */     this.activityCfgid = activityCfgid;
/*  29 */     this.corpsid = corpsid;
/*  30 */     this.timePointCfgid = timePointCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  37 */     if (cfg == null)
/*     */     {
/*  39 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRacePrepareMail.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (!CrossBattlePointManager.isFunOpen(cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  48 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRacePrepareMail.processImp@fun not open|activity_cfgid=%d|corpsid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.timePointCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = CrossBattlePointManager.getCrossbattlePointRaceInfo(this.activityCfgid, this.timePointCfgid, false);
/*     */     
/*  57 */     if (xCrossbattlePointRaceInfo != null)
/*     */     {
/*  59 */       Boolean send = (Boolean)xCrossbattlePointRaceInfo.getNext_mailed().get(Long.valueOf(this.corpsid));
/*  60 */       if ((send != null) && (send.booleanValue()))
/*     */       {
/*  62 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  66 */     List<Long> members = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(this.corpsid, this.activityCfgid, false);
/*     */     
/*  68 */     if (members == null)
/*     */     {
/*  70 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRacePrepareMail.processImp@register role list is null|activity_cfgid=%d|corpsid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.timePointCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     int zone = CrossBattlePointManager.getCorpsZone(this.activityCfgid, this.corpsid, false);
/*  78 */     if (zone <= 0)
/*     */     {
/*  80 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRacePrepareMail.processImp@zone invalid|activity_cfgid=%d|corpsid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.timePointCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     lock(Basic.getTable(), members);
/*     */     
/*  90 */     STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(this.timePointCfgid);
/*  91 */     if (timePointCommonCfg == null)
/*     */     {
/*  93 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRacePrepareMail.processImp@time point cfg is null|activity_cfgid=%d|corpsid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.timePointCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     long prepareTime = TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute);
/* 101 */     long startTime = TimeCommonUtil.getTimePoint(timePointCommonCfg) - prepareTime;
/* 102 */     Calendar calendar = mzm.gsp.util.DateTimeUtils.getCalendar();
/* 103 */     calendar.setTimeInMillis(startTime);
/* 104 */     int year = calendar.get(1);
/* 105 */     int month = calendar.get(2) + 1;
/* 106 */     int day = calendar.get(5);
/* 107 */     int hour = calendar.get(11);
/* 108 */     int minute = calendar.get(12);
/*     */     
/* 110 */     List<String> contentArgs = new ArrayList();
/* 111 */     contentArgs.add(String.valueOf(year));
/* 112 */     if (month < 10)
/*     */     {
/* 114 */       contentArgs.add(String.format("0%d", new Object[] { Integer.valueOf(month) }));
/*     */     }
/*     */     else
/*     */     {
/* 118 */       contentArgs.add(String.valueOf(month));
/*     */     }
/* 120 */     contentArgs.add(String.valueOf(day));
/* 121 */     contentArgs.add(String.valueOf(hour));
/* 122 */     if (minute < 10)
/*     */     {
/* 124 */       contentArgs.add(String.format("0%d", new Object[] { Integer.valueOf(minute) }));
/*     */     }
/*     */     else
/*     */     {
/* 128 */       contentArgs.add(String.valueOf(minute));
/*     */     }
/*     */     
/* 131 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.CROSS_BATTLE_POINT_RACE_PREPARE_MAIL);
/* 132 */     int mailCfgid = cfg.nextMailCfgid;
/*     */     
/* 134 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 136 */       SendMailRet sendMailRet = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleid, mailCfgid, null, contentArgs, tLogArg);
/* 137 */       if (!sendMailRet.isOK())
/*     */       {
/* 139 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRacePrepareMail.processImp@send mail fail|activity_cfgid=%d|corpsid=%d|time_point_cfgid=%d|mail_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.timePointCfgid), Integer.valueOf(mailCfgid), Long.valueOf(roleid) }));
/*     */         
/*     */ 
/*     */ 
/* 143 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 147 */     xCrossbattlePointRaceInfo = CrossBattlePointManager.getAndInitCrossbattlePointRaceInfo(this.activityCfgid, this.timePointCfgid);
/*     */     
/* 149 */     xCrossbattlePointRaceInfo.getNext_mailed().put(Long.valueOf(this.corpsid), Boolean.valueOf(true));
/*     */     
/* 151 */     GameServer.logger().info(String.format("[crossbattlepoint]PPointRacePrepareMail.processImp@send mail success|activity_cfgid=%d|corpsid=%d|time_point_cfgid=%d|mail_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(this.timePointCfgid), Integer.valueOf(mailCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRacePrepareMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */