/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleZoneCfg;
/*     */ import mzm.gsp.crossbattle.event.PointRaceResult;
/*     */ import mzm.gsp.crossbattle.event.PointRaceResultArg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossbattlePoint;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PPointRaceResult extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final long corpsid;
/*     */   private final CorpsPointRaceInfo corpsPointRaceInfo;
/*     */   
/*     */   public PPointRaceResult(int activityCfgid, long corpsid, CorpsPointRaceInfo corpsPointRaceInfo)
/*     */   {
/*  33 */     this.activityCfgid = activityCfgid;
/*  34 */     this.corpsid = corpsid;
/*  35 */     this.corpsPointRaceInfo = corpsPointRaceInfo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  42 */     if (cfg == null)
/*     */     {
/*  44 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceResult.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (!CrossBattlePointManager.isFunOpen(cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceResult.processImp@fun not open|activity_cfgid=%d|corpsid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid) }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     CrossbattlePoint xCrossbattlePoint = CrossBattlePointManager.getCrossbattlePoint(this.activityCfgid, false);
/*  60 */     if (xCrossbattlePoint == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceResult.processImp@xbean cross battle point is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*  68 */     Integer rankResult = (Integer)xCrossbattlePoint.getCorps_result().get(Long.valueOf(this.corpsid));
/*  69 */     if ((rankResult != null) && (rankResult.intValue() != 0))
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByCorpsId(this.corpsid, false);
/*  75 */     if (corpsInfo == null)
/*     */     {
/*  77 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceResult.processImp@corps info is null|activity_cfgid=%d|corpsid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid) }));
/*     */       
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     int zone = CrossBattlePointManager.getCorpsZone(this.activityCfgid, this.corpsid, false);
/*  85 */     if (zone <= 0)
/*     */     {
/*  87 */       GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceResult.processImp@corps zone invalid|activity_cfgid=%d|corpsid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid) }));
/*     */       
/*     */ 
/*     */ 
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     Set<Long> members = corpsInfo.getAllMemberIds();
/*  95 */     lock(Basic.getTable(), members);
/*     */     
/*  97 */     int promotionNum = cfg.promotionCorpsNum;
/*  98 */     int mailCfgid = 0;
/*  99 */     int rank = this.corpsPointRaceInfo.getRank();
/* 100 */     boolean promotion = false;
/* 101 */     if ((rank >= 0) && (rank < promotionNum))
/*     */     {
/* 103 */       promotion = true;
/* 104 */       mailCfgid = cfg.winMailCfgid;
/*     */     }
/*     */     else
/*     */     {
/* 108 */       mailCfgid = cfg.loseMailCfgid;
/*     */     }
/*     */     
/* 111 */     List<String> contentArgs = new ArrayList();
/*     */     
/* 113 */     SCrossBattleZoneCfg zoneCfg = SCrossBattleZoneCfg.get(zone);
/* 114 */     if (zoneCfg == null)
/*     */     {
/* 116 */       contentArgs.add(String.valueOf(zone));
/*     */     }
/*     */     else
/*     */     {
/* 120 */       contentArgs.add(zoneCfg.name);
/*     */     }
/* 122 */     contentArgs.add(String.valueOf(this.corpsPointRaceInfo.getPoint()));
/* 123 */     contentArgs.add(String.valueOf(rank + 1));
/*     */     
/* 125 */     if (promotion)
/*     */     {
/* 127 */       long selectionStartTime = mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface.getCrossBattleKnockOutStageTime(this.activityCfgid, 1, 1);
/*     */       
/* 129 */       Calendar calendar = DateTimeUtils.getCalendar();
/* 130 */       calendar.setTimeInMillis(selectionStartTime);
/* 131 */       int year = calendar.get(1);
/* 132 */       int month = calendar.get(2) + 1;
/* 133 */       int day = calendar.get(5);
/* 134 */       int hour = calendar.get(11);
/* 135 */       int minute = calendar.get(12);
/*     */       
/* 137 */       contentArgs.add(String.valueOf(year));
/* 138 */       if (month < 10)
/*     */       {
/* 140 */         contentArgs.add(String.format("0%d", new Object[] { Integer.valueOf(month) }));
/*     */       }
/*     */       else
/*     */       {
/* 144 */         contentArgs.add(String.valueOf(month));
/*     */       }
/* 146 */       contentArgs.add(String.valueOf(day));
/* 147 */       contentArgs.add(String.valueOf(hour));
/* 148 */       if (minute < 10)
/*     */       {
/* 150 */         contentArgs.add(String.format("0%d", new Object[] { Integer.valueOf(minute) }));
/*     */       }
/*     */       else
/*     */       {
/* 154 */         contentArgs.add(String.valueOf(minute));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 159 */     TLogArg tLogArg = new TLogArg(LogReason.CROSS_BATTLE_POINT_RACE_RESULT_MAIL);
/* 160 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 162 */       SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, mailCfgid, null, contentArgs, tLogArg);
/* 163 */       if (!sendMailRet.isOK())
/*     */       {
/* 165 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceResult.processImp@send mail fail|activity_cfgid=%d|corpsid=%d|mail_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(mailCfgid), Long.valueOf(roleid) }));
/*     */         
/*     */ 
/*     */ 
/* 169 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 173 */     xCrossbattlePoint = CrossBattlePointManager.getCrossbattlePoint(this.activityCfgid, true);
/* 174 */     xCrossbattlePoint.getCorps_result().put(Long.valueOf(this.corpsid), Integer.valueOf(rank + 1));
/*     */     
/*     */ 
/* 177 */     PointRaceResultArg arg = new PointRaceResultArg(this.corpsid, rank + 1, promotion);
/* 178 */     PointRaceResult event = new PointRaceResult();
/* 179 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */     
/*     */ 
/* 182 */     CrossBattlePointManager.pointRaceResultTLog(this.corpsid, corpsInfo.getCorpsName(), rank + 1);
/*     */     
/* 184 */     GameServer.logger().info(String.format("[crossbattlepoint]PPointRaceResult.processImp@send mail success|activity_cfgid=%d|corpsid=%d|mail_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(mailCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 188 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRaceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */