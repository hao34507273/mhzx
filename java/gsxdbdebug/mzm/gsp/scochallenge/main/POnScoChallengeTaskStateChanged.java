/*     */ package mzm.gsp.scochallenge.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.SIsContinueScoChallenge;
/*     */ import mzm.gsp.activity.SScoChallengeAward;
/*     */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnScoChallengeTaskStateChanged
/*     */   extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!isScoChallengeActivity())
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     switch (((TaskEventArg)this.arg).taskState)
/*     */     {
/*     */     case 8: 
/*  48 */       if ((((TaskEventArg)this.arg).getAllRoleList() == null) || (((TaskEventArg)this.arg).getAllRoleList().size() == 0))
/*     */       {
/*  50 */         String logstr = String.format("[soc]POnScoChallengeTaskStateChanged.processImp@SchoolChallenge Activity getAllRoleList empty|roleid=%d|taskid=%d|graphid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(((TaskEventArg)this.arg).graphId) });
/*     */         
/*     */ 
/*  53 */         ScoChallengeManager.logger.error(logstr);
/*  54 */         return false;
/*     */       }
/*  56 */       Long teamId = TeamInterface.getTeamidByRoleid(((TaskEventArg)this.arg).roleId, false);
/*  57 */       if ((teamId == null) || (!TeamInterface.isTeamLeader(teamId.longValue(), ((TaskEventArg)this.arg).roleId, false)))
/*     */       {
/*  59 */         String logstr = String.format("[soc]POnScoChallengeTaskStateChanged.processImp@not leader or teamid null|roleid=%d|teamid=%d|taskid=%d|graphid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Long.valueOf(teamId == null ? 0L : teamId.longValue()), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(((TaskEventArg)this.arg).graphId) });
/*     */         
/*     */ 
/*  62 */         ScoChallengeManager.logger.info(logstr);
/*  63 */         return false;
/*     */       }
/*     */       
/*  66 */       TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), false);
/*  67 */       Set<Long> allRoleList = new HashSet(((TaskEventArg)this.arg).getAllRoleList());
/*  68 */       if (!allRoleList.containsAll(teamInfo.getTeamNormalList()))
/*     */       {
/*  70 */         allRoleList.addAll(teamInfo.getTeamNormalList());
/*     */       }
/*     */       
/*  73 */       Map<Long, String> allUsers = new HashMap();
/*     */       
/*  75 */       for (Long roleid : allRoleList)
/*     */       {
/*  77 */         String userid = RoleInterface.getUserId(roleid.longValue());
/*  78 */         allUsers.put(roleid, userid);
/*     */       }
/*  80 */       lock(User.getTable(), allUsers.values());
/*  81 */       lock(Role2properties.getTable(), allRoleList);
/*     */       
/*  83 */       if (!ScoChallengeManager.isSocSwitchOpenForRole(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).getAllRoleList()))
/*     */       {
/*  85 */         String logstr = String.format("[soc]POnScoChallengeTaskStateChanged.processImp@some one is ban for this activity or activity switch is closed|roleid=%d|roles=%s", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), ((TaskEventArg)this.arg).getAllRoleList().toString() });
/*     */         
/*     */ 
/*  88 */         ScoChallengeManager.logger.info(logstr);
/*  89 */         for (Iterator i$ = ((TaskEventArg)this.arg).getAllRoleList().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/*  91 */           TaskInterface.closeActivityGraphWithoutEvent(roleid, SSchoolChallengeCfgConsts.getInstance().GRAPH_ID);
/*     */         }
/*     */         
/*  94 */         return true;
/*     */       }
/*     */       
/*  97 */       if (!ScoChallengeManager.isRoleStateCanJoinScoActivity(new ArrayList(allRoleList)))
/*     */       {
/*  99 */         String logStr = String.format("[soc]POnScoChallengeTaskStateChanged.processImp@role state can not join sco activity|roleid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId) });
/*     */         
/*     */ 
/* 102 */         ScoChallengeManager.logger.info(logStr);
/* 103 */         return false;
/*     */       }
/*     */       
/* 106 */       Map<Long, String> roleidToUserid = new HashMap();
/* 107 */       for (Iterator i$ = teamInfo.getTeamNormalList().iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */         
/* 109 */         roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */       }
/* 111 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, teamInfo.getTeamNormalList(), SSchoolChallengeCfgConsts.getInstance().ACTIVITYID);
/*     */       
/* 113 */       if (!res.isCanJoin())
/*     */       {
/* 115 */         String logstr = String.format("[soc]POnScoChallengeTaskStateChanged.processImp@can join error|roleid=%d|teamid=%d|taskid=%d|graphid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Long.valueOf(teamId == null ? 0L : teamId.longValue()), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(((TaskEventArg)this.arg).graphId) });
/*     */         
/*     */ 
/* 118 */         ScoChallengeManager.logger.info(logstr);
/* 119 */         return false;
/*     */       }
/* 121 */       List<Long> roleList = ((TaskEventArg)this.arg).getRoleList();
/*     */       
/* 123 */       offerRingAward(allUsers);
/* 124 */       ScoChallengeManager.addScoRingTask(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).taskId);
/* 125 */       Iterator i$; if (((TaskEventArg)this.arg).isToEnd)
/*     */       {
/*     */ 
/* 128 */         offerCircleAward(allUsers);
/* 129 */         ScoChallengeManager.clearScoRingTask(((TaskEventArg)this.arg).roleId);
/* 130 */         SIsContinueScoChallenge isContinue = new SIsContinueScoChallenge();
/* 131 */         OnlineManager.getInstance().send(((TaskEventArg)this.arg).roleId, isContinue);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 138 */       else if (ActivityInterface.isActivityOpen(SSchoolChallengeCfgConsts.getInstance().ACTIVITYID))
/*     */       {
/* 140 */         boolean ret = TaskInterface.goNextTask(((TaskEventArg)this.arg).roleId, SSchoolChallengeCfgConsts.getInstance().GRAPH_ID, new HashSet(ScoChallengeManager.getTaskids(((TaskEventArg)this.arg).roleId)));
/*     */         
/*     */ 
/* 143 */         if (!ret)
/*     */         {
/* 145 */           String logstr = String.format("[soc]POnScoChallengeTaskStateChanged.processImp@SchoolChallenge activity go next task  failed|roleid=%d|teamid=%d|taskid=%d|graphid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), teamId, Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(((TaskEventArg)this.arg).graphId) });
/*     */           
/*     */ 
/* 148 */           ScoChallengeManager.logger.error(logstr);
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 154 */         for (i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 156 */           TaskInterface.closeActivityGraphWithoutEvent(roleid, SSchoolChallengeCfgConsts.getInstance().GRAPH_ID);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 163 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*     */ 
/* 166 */         boolean ret = ActivityInterface.addActivityCount((String)allUsers.get(Long.valueOf(roleid)), roleid, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID);
/*     */         
/* 168 */         if (!ret)
/*     */         {
/* 170 */           String logstr = String.format("[soc]POnScoChallengeTaskStateChanged.processImp@Activity add count failed|roleid=%d|teamid=%d|taskid=%d|graphid=%d", new Object[] { Long.valueOf(roleid), teamId, Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(((TaskEventArg)this.arg).graphId) });
/*     */           
/*     */ 
/* 173 */           ScoChallengeManager.logger.error(logstr);
/*     */         }
/*     */       }
/*     */       
/* 177 */       logActivity(roleList, ActivityLogStatus.FINISH);
/* 178 */       return true;
/*     */     
/*     */     case 2: 
/* 181 */       ActivityInterface.logActivity(((TaskEventArg)this.arg).roleId, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */       
/* 183 */       ActivityInterface.tlogActivity(((TaskEventArg)this.arg).roleId, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */       
/*     */ 
/* 186 */       return true;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 191 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isScoChallengeActivity()
/*     */   {
/* 202 */     return ((TaskEventArg)this.arg).graphId == SSchoolChallengeCfgConsts.getInstance().GRAPH_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void offerRingAward(Map<Long, String> allUsers)
/*     */   {
/* 212 */     List<String> users = new ArrayList();
/* 213 */     List<Long> roles = new ArrayList();
/* 214 */     int maxCount = SSchoolChallengeCfgConsts.getInstance().RING_TO_COIRCLE * SSchoolChallengeCfgConsts.getInstance().MAX_AWARD_COUNT;
/*     */     
/* 216 */     for (Iterator i$ = ((TaskEventArg)this.arg).getRoleList().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 218 */       int activityCount = ActivityInterface.getActivityCount((String)allUsers.get(Long.valueOf(roleid)), roleid, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID, true);
/*     */       
/*     */ 
/* 221 */       if (activityCount < maxCount)
/*     */       {
/* 223 */         roles.add(Long.valueOf(roleid));
/* 224 */         users.add(allUsers.get(Long.valueOf(roleid)));
/*     */       }
/*     */     }
/* 227 */     int ring = ((TaskEventArg)this.arg).taskNo;
/* 228 */     int modifyid = ScoChallengeManager.getModifyId(ring);
/* 229 */     if (modifyid != -1)
/*     */     {
/* 231 */       AwardInterface.award(SSchoolChallengeCfgConsts.getInstance().RING_REWARDID, users, roles, ((TaskEventArg)this.arg).getAllRoleList(), modifyid, false, true, new AwardReason(LogReason.SCO_RING_ACTIVITY_ADD, SSchoolChallengeCfgConsts.getInstance().RING_REWARDID));
/*     */       
/*     */ 
/* 234 */       String logStr = String.format("[soc]POnScoChallengeTaskStateChanged.offerRingAward@award roles success|ring=%d|awardedroleids=%s|allroles=%s|finishtaskroles=%s|modifyid=%d|rewardid=%d", new Object[] { Integer.valueOf(ring), roles.toString(), ((TaskEventArg)this.arg).getAllRoleList().toString(), ((TaskEventArg)this.arg).getRoleList().toString(), Integer.valueOf(modifyid), Integer.valueOf(SSchoolChallengeCfgConsts.getInstance().RING_REWARDID) });
/*     */       
/*     */ 
/*     */ 
/* 238 */       ScoChallengeManager.logger.info(logStr);
/*     */     }
/*     */     else
/*     */     {
/* 242 */       String logStr = String.format("[soc]POnScoChallengeTaskStateChanged.offerRingAward@award modifyid error|teamleaderroleid=%d|ring=%d|toawardroleids=%s|allroles=%s|finishtaskroles=%s|modifyid=%d|rewardid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(ring), roles.toString(), ((TaskEventArg)this.arg).getAllRoleList().toString(), ((TaskEventArg)this.arg).getRoleList().toString(), Integer.valueOf(modifyid), Integer.valueOf(SSchoolChallengeCfgConsts.getInstance().RING_REWARDID) });
/*     */       
/*     */ 
/*     */ 
/* 246 */       ScoChallengeManager.logger.error(logStr);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void offerCircleAward(Map<Long, String> allUsers)
/*     */   {
/* 258 */     List<Long> roles = new ArrayList();
/* 259 */     for (Iterator i$ = ((TaskEventArg)this.arg).getRoleList().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 261 */       int circle = ScoChallengeManager.getAwardCircleCount(roleid);
/* 262 */       if (circle < SSchoolChallengeCfgConsts.getInstance().MAX_AWARD_COUNT)
/*     */       {
/*     */ 
/* 265 */         int rewradid = ScoChallengeManager.getCircleRewardId(circle);
/* 266 */         if (rewradid == -1)
/*     */         {
/* 268 */           String logStr = String.format("[soc]POnScoChallengeTaskStateChanged.offerCircleAward@rewradid error|roleid=%d|rewradid=%d|circle=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(rewradid), Integer.valueOf(circle) });
/*     */           
/*     */ 
/* 271 */           ScoChallengeManager.logger.error(logStr);
/*     */         }
/*     */         else {
/* 274 */           AwardModel awardRes = AwardInterface.award(rewradid, (String)allUsers.get(Long.valueOf(roleid)), roleid, false, false, new AwardReason(LogReason.SCO_CIRCLE_ACTIVITY_ADD, rewradid));
/*     */           
/* 276 */           if (awardRes != null)
/*     */           {
/* 278 */             roles.add(Long.valueOf(roleid));
/* 279 */             SScoChallengeAward s = new SScoChallengeAward();
/* 280 */             s.circle = (circle + 1);
/* 281 */             AwardInterface.fillAwardBean(s.awardbean, awardRes);
/* 282 */             OnlineManager.getInstance().send(roleid, s);
/* 283 */             ScoChallengeManager.addAwardCircleCount(roleid);
/*     */           }
/*     */           else
/*     */           {
/* 287 */             String logStr = String.format("[soc]POnScoChallengeTaskStateChanged.offerCircleAward@rewradid error,null|roleid=%d|rewradid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(rewradid) });
/*     */             
/*     */ 
/* 290 */             ScoChallengeManager.logger.error(logStr);
/*     */           }
/*     */         }
/*     */       } }
/* 294 */     String logStr = String.format("[soc]POnScoChallengeTaskStateChanged.offerCircleAward@ring award roles log|awardedroleids=%s|allroles=%s|finishtaskroles=%s", new Object[] { roles.toString(), ((TaskEventArg)this.arg).getAllRoleList().toString(), ((TaskEventArg)this.arg).getRoleList().toString() });
/*     */     
/*     */ 
/* 297 */     ScoChallengeManager.logger.info(logStr);
/*     */   }
/*     */   
/*     */   private void logActivity(List<Long> roleids, ActivityLogStatus status)
/*     */   {
/* 302 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 304 */       ActivityInterface.logActivity(roleid, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID, status);
/* 305 */       ActivityInterface.tlogActivity(roleid, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID, status);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\POnScoChallengeTaskStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */