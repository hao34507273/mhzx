/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliSession;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FactionPVE;
/*     */ import xbean.FactionPVETmp;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class PSetStartTimeReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int date;
/*     */   private final int hour;
/*     */   private final int minute;
/*     */   
/*     */   public PSetStartTimeReq(long roleid, int date, int hour, int minute)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.date = date;
/*  36 */     this.hour = hour;
/*  37 */     this.minute = minute;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!OpenInterface.getOpenStatus(334)) {
/*  44 */       FactionPVEManager.logError("PSetStartTimeReq.processImp@not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, true);
/*     */     
/*  51 */     if (faction == null) {
/*  52 */       return false;
/*     */     }
/*  54 */     long factionid = faction.getGangId();
/*     */     
/*     */ 
/*  57 */     if ((this.date < 1) || (this.date > 7)) {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if ((this.hour < SFactionPVEConsts.getInstance().ActivateValidHourMin) || (this.hour > SFactionPVEConsts.getInstance().ActivateValidHourMax))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!SFactionPVEConsts.getInstance().ActivateValidMinutes.contains(Integer.valueOf(this.minute))) {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  71 */     Calendar calendar = DateTimeUtils.getCalendar();
/*     */     
/*  73 */     calendar.setTimeInMillis(now);
/*  74 */     calendar.set(14, 0);
/*  75 */     calendar.set(13, 0);
/*     */     
/*  77 */     calendar.set(7, this.date);
/*  78 */     calendar.set(11, this.hour);
/*  79 */     calendar.set(12, this.minute);
/*     */     
/*  81 */     long startTime = calendar.getTimeInMillis();
/*     */     
/*     */ 
/*  84 */     long delta = startTime - now;
/*  85 */     if (delta < 0L) {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     long activityStartTime = ActivityInterface.getActivityStartTime(SFactionPVEConsts.getInstance().Activityid);
/*     */     
/*  91 */     long activityEndTime = ActivityInterface.getActivityEndTime(SFactionPVEConsts.getInstance().Activityid);
/*     */     
/*     */ 
/*     */ 
/*  95 */     if (startTime > activityEndTime - TimeUnit.MINUTES.toMillis(SFactionPVEConsts.getInstance().ForbidActivateBeforeEndMinutes))
/*     */     {
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     if (!GangInterface.canActivePVE(this.roleid)) {
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 107 */     if (now - faction.getCreateTime() < TimeUnit.HOURS.toMillis(SFactionPVEConsts.getInstance().NeedJoinHours))
/*     */     {
/* 109 */       FactionPVEManager.sendNormalResult(this.roleid, 43, new String[] { Integer.toString(SFactionPVEConsts.getInstance().NeedJoinHours) });
/*     */       
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     FactionPVE xFactionPVE = FactionPVEManager.getXFactionPVEIfNotExist(factionid);
/* 117 */     FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(factionid);
/*     */     
/*     */ 
/* 120 */     if ((xFactionPVE.getStart_timestamp() > 0L) && (xFactionPVE.getStart_timestamp() < activityStartTime)) {
/* 121 */       FactionPVEManager.initXFactionPVEAndXFactionPVETmp(xFactionPVE, xFactionPVETmp);
/*     */     }
/*     */     
/*     */ 
/* 125 */     if (xFactionPVE.getActivate_times() >= SFactionPVEConsts.getInstance().ActivateTimes) {
/* 126 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 130 */     long leftMillis = xFactionPVE.getStart_timestamp() - now;
/* 131 */     if ((leftMillis > 0L) && (leftMillis < TimeUnit.MINUTES.toMillis(SFactionPVEConsts.getInstance().ChangeBeforeStartMinutes)))
/*     */     {
/* 133 */       FactionPVEManager.sendNormalResult(this.roleid, 44, new String[0]);
/*     */       
/* 135 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 139 */     int curTimes = xFactionPVE.getSet_times();
/*     */     
/* 141 */     if (curTimes > SFactionPVEConsts.getInstance().ModifyTimes) {
/* 142 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 146 */     if ((xFactionPVETmp.getStage() != 0) && (xFactionPVETmp.getStage() != 6))
/*     */     {
/* 148 */       FactionPVEManager.sendNormalResult(this.roleid, 41, new String[0]);
/*     */       
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     if (leftMillis < 0L)
/*     */     {
/*     */ 
/* 156 */       if ((SFactionPVEConsts.getInstance().CostFactionMoney > 0) && 
/* 157 */         (!GangInterface.costGangMoney(factionid, SFactionPVEConsts.getInstance().CostFactionMoney))) {
/* 158 */         FactionPVEManager.sendNormalResult(this.roleid, 42, new String[0]);
/*     */         
/* 160 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 165 */     xFactionPVE.setSet_times(curTimes + 1);
/* 166 */     xFactionPVE.setStart_timestamp(startTime);
/*     */     
/*     */ 
/* 169 */     String timeStr = FactionPVEManager.DATE_FORMAT.format(Long.valueOf(startTime));
/* 170 */     if (curTimes == 0) {
/* 171 */       TLogArg tLogArg = new TLogArg(LogReason.FACTION_PVE_SET_TIME);
/*     */       
/* 173 */       GangInterface.sendGangMail(factionid, SFactionPVEConsts.getInstance().SetTimeMail, Arrays.asList(new String[] { timeStr }), null, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 177 */       TLogArg tLogArg = new TLogArg(LogReason.FACTION_PVE_MODIFY_TIME);
/*     */       
/* 179 */       GangInterface.sendGangMail(factionid, SFactionPVEConsts.getInstance().ModifyTimeMail, Arrays.asList(new String[] { timeStr }), null, tLogArg);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 185 */     String name = RoleInterface.getName(this.roleid);
/*     */     
/* 187 */     String duty = GangInterface.getGangDutyName(this.roleid);
/* 188 */     Protocol startTimeBrd = FactionPVEManager.getStartTimeBrdProtocol(xFactionPVE, this.roleid, name, duty);
/*     */     
/* 190 */     faction.broadcast(startTimeBrd);
/*     */     
/*     */ 
/* 193 */     Protocol pveTimesbrd = FactionPVEManager.getFactionPVETimesBrdProtocol(xFactionPVE);
/* 194 */     faction.broadcast(pveTimesbrd);
/*     */     
/*     */ 
/* 197 */     MilliSession.removeSession(xFactionPVETmp.getSessionid(), factionid);
/*     */     
/* 199 */     FactionPVEStartSession session = new FactionPVEStartSession(factionid, delta);
/*     */     
/*     */ 
/* 202 */     FactionPVEManager.setStageAndBroadcast(factionid, faction, xFactionPVETmp, 0, session);
/*     */     
/*     */ 
/*     */ 
/* 206 */     FactionPVEManager.logInfo("PSetStartTimeReq.processImp|roleid=%d|factionid=%d|activate_times=%d|start_time=%d|stage=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid), Integer.valueOf(xFactionPVE.getActivate_times()), Long.valueOf(xFactionPVE.getStart_timestamp()), Integer.valueOf(xFactionPVETmp.getStage()) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 213 */     Role role = RoleInterface.getRole(this.roleid, true);
/* 214 */     FactionPVEManager.tlogSetStartTime(role, faction, this.date, this.hour, this.minute, xFactionPVE.getActivate_times());
/*     */     
/*     */ 
/* 217 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\PSetStartTimeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */