/*     */ package mzm.gsp.shimen.main;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.DayPerfectRingCout;
/*     */ import xbean.Pod;
/*     */ import xbean.WeekPerfectRingCout;
/*     */ import xtable.Role2dayperfectringcount;
/*     */ import xtable.Role2weekperfectringcount;
/*     */ 
/*     */ 
/*     */ public class PerfectRingActivityInit
/*     */   implements ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  27 */     DayPerfectRingCout dayPerfectRingCout = Role2dayperfectringcount.get(Long.valueOf(roleId));
/*  28 */     int shimenCount = -1;
/*  29 */     if (dayPerfectRingCout == null)
/*     */     {
/*  31 */       dayPerfectRingCout = Pod.newDayPerfectRingCout();
/*  32 */       Role2dayperfectringcount.insert(Long.valueOf(roleId), dayPerfectRingCout);
/*     */     }
/*     */     else
/*     */     {
/*  36 */       shimenCount = dayPerfectRingCout.getShimencount();
/*     */     }
/*     */     
/*  39 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  41 */     ShimenManager.computeReserveExp(userid, roleId, shimenCount, turn);
/*  42 */     clearDayPerfectRingCount(dayPerfectRingCout, now);
/*  43 */     clearWeekPerfectRingCount(roleId, now);
/*     */     
/*  45 */     int ocp = RoleInterface.getOccupationId(roleId);
/*  46 */     int graphid = ShimenManager.getShimenGraphIdByMenpai(ocp);
/*     */     
/*  48 */     if (ShimenManager.isShimenSwitchOpenForRole(roleId))
/*     */     {
/*  50 */       if (TaskInterface.isHaveGraphId(roleId, graphid))
/*     */       {
/*  52 */         TaskInterface.clearGraph(graphid, roleId);
/*     */       }
/*     */       
/*  55 */       goNextTask(roleId, graphid);
/*     */ 
/*     */ 
/*     */     }
/*  59 */     else if (TaskInterface.isHaveGraphId(roleId, graphid))
/*     */     {
/*  61 */       TaskInterface.closeActivityGraph(roleId, graphid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void goNextTask(final long roleId, int graphid)
/*     */   {
/*  69 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  75 */         return TaskInterface.synGoNextTask(roleId, this.val$graphid);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void clearDayPerfectRingCount(DayPerfectRingCout dayPerfectRingCout, long cleanTime)
/*     */   {
/*  88 */     dayPerfectRingCout.setCleantime(cleanTime);
/*  89 */     dayPerfectRingCout.setHasgiveup(false);
/*  90 */     dayPerfectRingCout.setCurrentring(0);
/*  91 */     dayPerfectRingCout.setShimencount(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void clearWeekPerfectRingCount(long roleId, long now)
/*     */   {
/* 103 */     Calendar cal = DateTimeUtils.getCalendar();
/* 104 */     cal.setTimeInMillis(now);
/*     */     
/* 106 */     if (cal.get(7) == 2)
/*     */     {
/*     */ 
/* 109 */       WeekPerfectRingCout weekPerfectRingCout = Role2weekperfectringcount.get(Long.valueOf(roleId));
/* 110 */       if (weekPerfectRingCout == null)
/*     */       {
/* 112 */         weekPerfectRingCout = Pod.newWeekPerfectRingCout();
/* 113 */         Role2weekperfectringcount.add(Long.valueOf(roleId), weekPerfectRingCout);
/*     */       }
/* 115 */       weekPerfectRingCout.setCleantime(now);
/* 116 */       weekPerfectRingCout.setWeekperfectringcount(0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/* 124 */     return new AwardReason(LogReason.SHIMEN_ACTIVITY_RECOMMEND_ADD);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/* 131 */     return null;
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*     */   
/*     */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*     */   
/*     */   public void onActivityEnd(int activityid) {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\PerfectRingActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */