/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.LadderActivity;
/*     */ import xtable.Ladderactivity;
/*     */ import xtable.User;
/*     */ 
/*     */ public class LadderHandler implements ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*     */   
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  31 */     return null;
/*     */   }
/*     */   
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  36 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/*  51 */     LadderActivity xLadderActivity = Ladderactivity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  52 */     if (xLadderActivity == null) {
/*  53 */       return;
/*     */     }
/*  55 */     Set<Long> allAttendRoles = new HashSet();
/*  56 */     allAttendRoles.addAll(xLadderActivity.getRoleids());
/*  57 */     xLadderActivity.getRoleids().clear();
/*  58 */     NoneRealTimeTaskManager.getInstance().addTask(new LeaveLadderProcedure(allAttendRoles));
/*     */   }
/*     */   
/*     */   static class LeaveLadderProcedure extends LogicProcedure
/*     */   {
/*     */     private Set<Long> allAttendRoles;
/*     */     
/*     */     public LeaveLadderProcedure(Set<Long> allAttendRoles) {
/*  66 */       this.allAttendRoles = allAttendRoles;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  71 */       Set<Long> handleRoles = new HashSet();
/*  72 */       for (Iterator i$ = this.allAttendRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  73 */         if (!handleRoles.contains(Long.valueOf(roleid)))
/*     */         {
/*     */ 
/*  76 */           TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(roleid);
/*  77 */           if (teamInfo != null) {
/*  78 */             List<Long> memberList = teamInfo.getTeamMemberList();
/*  79 */             handleRoles.addAll(memberList);
/*  80 */             NoneRealTimeTaskManager.getInstance().addTask(new LadderHandler.TeamLeaveLadderProcedure(teamInfo.getTeamId(), memberList));
/*     */           }
/*     */         }
/*     */       }
/*  84 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static class TeamLeaveLadderProcedure
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long teamid;
/*     */     private List<Long> memberList;
/*     */     
/*     */     public TeamLeaveLadderProcedure(long teamid, List<Long> memberList)
/*     */     {
/*  96 */       this.memberList = memberList;
/*  97 */       this.teamid = teamid;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 102 */       if (this.memberList.size() <= 0) {
/* 103 */         return false;
/*     */       }
/* 105 */       Map<Long, String> role2UserMap = new HashMap();
/* 106 */       for (Iterator i$ = this.memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 107 */         String userid = RoleInterface.getUserId(roleid);
/* 108 */         role2UserMap.put(Long.valueOf(roleid), userid);
/*     */       }
/* 110 */       lock(User.getTable(), role2UserMap.values());
/* 111 */       lock(xtable.Role2properties.getTable(), this.memberList);
/* 112 */       long leaderRoleid = ((Long)this.memberList.get(0)).longValue();
/* 113 */       Iterator i$; if (RoleStatusInterface.containsStatus(leaderRoleid, 42)) {
/* 114 */         if (LadderManager.isInCancelMatch(this.memberList)) {
/* 115 */           return false;
/*     */         }
/* 117 */         if (LoginManager.isInCrossServer((String)role2UserMap.get(this.memberList.get(0)))) {
/* 118 */           return false;
/*     */         }
/* 120 */         int cancelid = LadderManager.getNextId();
/* 121 */         CancelMatchContext cancelMatchContext = new CancelMatchContext(this.teamid, cancelid, this.memberList);
/* 122 */         boolean result = LadderManager.tryDoUnMatch(role2UserMap, this.memberList, cancelMatchContext);
/* 123 */         if (!result) {
/* 124 */           return false;
/*     */         }
/*     */       } else {
/* 127 */         for (i$ = this.memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 128 */           LadderManager.doCancelReady(roleid, this.memberList);
/*     */         }
/*     */       }
/* 131 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */