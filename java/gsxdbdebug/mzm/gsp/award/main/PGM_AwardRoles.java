/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGM_AwardRoles
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int awardId;
/*     */   private final int modifyId;
/*     */   private final String awardTime;
/*     */   
/*     */   public PGM_AwardRoles(long roleId, int awardId, int modifyId, String awardTime)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.awardId = awardId;
/*  34 */     this.modifyId = modifyId;
/*  35 */     this.awardTime = awardTime;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     List<String> lockUers = new ArrayList();
/*  42 */     List<Long> lockRoles = new ArrayList();
/*     */     
/*  44 */     long teamId = -1L;
/*  45 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  46 */     if ((teamInfo == null) || (!teamInfo.getTeamNormalList().contains(Long.valueOf(this.roleId))))
/*     */     {
/*     */ 
/*  49 */       lockRoles.add(Long.valueOf(this.roleId));
/*     */     }
/*     */     else
/*     */     {
/*  53 */       teamId = teamInfo.getTeamId();
/*  54 */       lockRoles.addAll(teamInfo.getTeamNormalList());
/*     */     }
/*  56 */     for (Iterator i$ = lockRoles.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/*  58 */       lockUers.add(RoleInterface.getUserId(member));
/*     */     }
/*     */     
/*  61 */     Lockeys.lock(User.getTable(), lockUers);
/*     */     
/*  63 */     Lockeys.lock(Basic.getTable(), lockRoles);
/*     */     
/*  65 */     if (teamId > 0L)
/*     */     {
/*  67 */       Lockeys.lock(Team.getTable(), Arrays.asList(new Long[] { Long.valueOf(teamId) }));
/*     */     }
/*     */     
/*  70 */     if (!recheckTeamLock(lockRoles, teamId))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     long awardTimeMills = getAwardTimeMills();
/*  75 */     if (awardTimeMills <= 0L)
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     AwardReason awardReason = new AwardReason(LogReason.AWARD_GM_NORMAL_ADD);
/*  80 */     awardReason.setAwardTime(awardTimeMills);
/*  81 */     AwardInterface.award(this.awardId, lockUers, lockRoles, lockRoles, this.modifyId, false, true, awardReason);
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   private boolean recheckTeamLock(List<Long> lockRoles, long teamId)
/*     */   {
/*  87 */     if (teamId <= 0L)
/*     */     {
/*  89 */       return true;
/*     */     }
/*  91 */     TeamInfo teamInfoTmp = TeamInterface.getTeamInfo(teamId, true);
/*  92 */     if (teamInfoTmp == null)
/*     */     {
/*  94 */       return false;
/*     */     }
/*  96 */     List<Long> members = teamInfoTmp.getTeamNormalList();
/*  97 */     if ((members.size() != lockRoles.size()) || (!members.containsAll(lockRoles)))
/*     */     {
/*  99 */       return false;
/*     */     }
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   private long getAwardTimeMills()
/*     */   {
/* 106 */     if (this.awardTime.isEmpty())
/*     */     {
/* 108 */       return DateTimeUtils.getCurrTimeInMillis();
/*     */     }
/* 110 */     if (this.awardTime.length() != 14)
/*     */     {
/* 112 */       if (this.roleId > 0L)
/*     */       {
/* 114 */         GmManager.getInstance().sendResultToGM(this.roleId, "时间格式错误(yyyymmddhhMMss).");
/*     */       }
/* 116 */       return -1L;
/*     */     }
/*     */     try
/*     */     {
/* 120 */       int year = Integer.parseInt(this.awardTime.substring(0, 4));
/* 121 */       int month = Integer.parseInt(this.awardTime.substring(4, 6)) - 1;
/* 122 */       int day = Integer.parseInt(this.awardTime.substring(6, 8));
/* 123 */       int hour = Integer.parseInt(this.awardTime.substring(8, 10));
/* 124 */       int minute = Integer.parseInt(this.awardTime.substring(10, 12));
/* 125 */       int second = Integer.parseInt(this.awardTime.substring(12, 14));
/* 126 */       Calendar calendar = DateTimeUtils.getCalendar();
/* 127 */       calendar.clear();
/* 128 */       calendar.set(year, month, day, hour, minute, second);
/* 129 */       return calendar.getTimeInMillis();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 133 */       GmManager.getInstance().sendResultToGM(this.roleId, "出错啦！"); }
/* 134 */     return -1L;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PGM_AwardRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */