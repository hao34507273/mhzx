/*     */ package mzm.gsp.multicommontask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.activity3.confbean.SMultiLineTaskCfg;
/*     */ import mzm.gsp.activity3.confbean.STGraphId2ActivityId;
/*     */ import mzm.gsp.activity3.confbean.STMultiLineTaskModCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import xbean.AllMultiTaskInfo;
/*     */ import xbean.CommonMultiTaskInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnTaskStateChange extends mzm.gsp.task.event.TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     long roleId = ((TaskEventArg)this.arg).roleId;
/*  32 */     int graphId = ((TaskEventArg)this.arg).graphId;
/*     */     
/*  34 */     STGraphId2ActivityId sTCfg = STGraphId2ActivityId.get(((TaskEventArg)this.arg).graphId);
/*  35 */     if (sTCfg == null)
/*     */     {
/*  37 */       return false;
/*     */     }
/*  39 */     SMultiLineTaskCfg activityTaskCfg = SMultiLineTaskCfg.get(sTCfg.activityId);
/*  40 */     if (activityTaskCfg == null)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!MultiTaskManager.isActivityValid(sTCfg.activityId, activityTaskCfg.openId))
/*     */     {
/*  47 */       TaskInterface.closeActivityGraphWithoutEvent(roleId, ((TaskEventArg)this.arg).graphId);
/*  48 */       return true;
/*     */     }
/*  50 */     int activityId = activityTaskCfg.activityId;
/*  51 */     switch (((TaskEventArg)this.arg).taskState)
/*     */     {
/*     */     case 8: 
/*  54 */       List<Long> allRoleList = new ArrayList(((TaskEventArg)this.arg).getAllRoleList());
/*  55 */       List<Long> finishRoleList = ((TaskEventArg)this.arg).getRoleList();
/*  56 */       int curRing = ((TaskEventArg)this.arg).taskNo;
/*  57 */       int needAwardTurn = activityTaskCfg.awardCircleSum;
/*  58 */       AwardReason reason = new AwardReason(mzm.gsp.tlog.LogReason.COMMON_MULTI_LINE_TASK_ADD, activityId);
/*  59 */       int awardId = activityTaskCfg.awardId;
/*  60 */       int modId = getAwardModId(activityId, activityTaskCfg, curRing);
/*     */       
/*  62 */       int roleLevel = RoleInterface.getLevel(roleId);
/*  63 */       int minJoinLevel = MultiTaskManager.getJoinMinLevel(activityId);
/*  64 */       if (roleLevel < minJoinLevel)
/*     */       {
/*     */ 
/*  67 */         return false;
/*     */       }
/*  69 */       if ((allRoleList.size() > 0) && (finishRoleList.size() > 0))
/*     */       {
/*     */ 
/*  72 */         Map<Long, String> roleidToUserid = lockAllUser(allRoleList);
/*  73 */         lock(Lockeys.get(Basic.getTable(), allRoleList));
/*  74 */         if (!allRoleList.contains(Long.valueOf(roleId)))
/*     */         {
/*  76 */           return false;
/*     */         }
/*  78 */         getAwardRoleIds(allRoleList, minJoinLevel);
/*  79 */         if (allRoleList.size() <= 0)
/*     */         {
/*  81 */           return false;
/*     */         }
/*  83 */         ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, allRoleList, activityId);
/*     */         
/*  85 */         if (!res.isCanJoin())
/*     */         {
/*  87 */           MultiTaskManager.loggerError("POnSeasonTaskStateChanged.multiTaskPro@ forbid join!|roleId=%d|activityId=%d|errcode=%d ", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(res.getReasonValue()) });
/*     */           
/*     */ 
/*  90 */           return false;
/*     */         }
/*  92 */         if (!newStepHand(roleId, activityId, graphId, reason, curRing, AwardInterface.getRoleAwardModel(awardId, roleId, modId, finishRoleList, allRoleList, reason), needAwardTurn))
/*     */         {
/*     */ 
/*     */ 
/*  96 */           MultiTaskManager.loggerError("POnSeasonTaskStateChanged.multiTaskPro@ new step err!|roleId=%d|activityId=%d|graphId=%d ", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(graphId) });
/*     */           
/*     */ 
/*  99 */           return false;
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 107 */         String userId = RoleInterface.getUserId(roleId);
/* 108 */         lock(Lockeys.get(User.getTable(), userId));
/*     */         
/* 110 */         if (!newStepHand(roleId, activityId, graphId, reason, curRing, AwardInterface.getRoleAwardModel(awardId, roleId, modId, reason), needAwardTurn))
/*     */         {
/*     */ 
/* 113 */           return false;
/*     */         }
/*     */       }
/* 116 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.FINISH);
/* 117 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.FINISH);
/*     */       
/* 119 */       return true;
/*     */     
/*     */     case 2: 
/* 122 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/* 123 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/*     */       
/* 125 */       return true;
/*     */     
/*     */     case 9: 
/* 128 */       return false;
/*     */     }
/* 130 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getAwardModId(int activityId, SMultiLineTaskCfg activityCfg, int ringNum)
/*     */   {
/* 137 */     if (!activityCfg.needMod)
/*     */     {
/* 139 */       return -1;
/*     */     }
/* 141 */     STMultiLineTaskModCfg modCfg = STMultiLineTaskModCfg.get(activityId);
/* 142 */     if (modCfg == null)
/*     */     {
/* 144 */       return activityCfg.defaultModId;
/*     */     }
/* 146 */     Integer tmpModId = (Integer)modCfg.circle2modId.get(Integer.valueOf(ringNum));
/* 147 */     return tmpModId == null ? activityCfg.defaultModId : tmpModId.intValue();
/*     */   }
/*     */   
/*     */   private void getAwardRoleIds(List<Long> allRoleList, int minLevel)
/*     */   {
/* 152 */     Iterator<Long> it = allRoleList.iterator();
/* 153 */     while (it.hasNext())
/*     */     {
/* 155 */       if (RoleInterface.getLevel(((Long)it.next()).longValue()) < minLevel)
/*     */       {
/* 157 */         it.remove();
/*     */       }
/*     */     }
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
/*     */ 
/*     */   private boolean newStepHand(long roleId, int activityId, int graphId, AwardReason reason, int curRing, AwardModel am, int needAwardTurn)
/*     */   {
/* 176 */     AllMultiTaskInfo xAllInfos = xtable.Role2commonmultiinfo.get(Long.valueOf(roleId));
/* 177 */     if (xAllInfos == null)
/*     */     {
/* 179 */       return false;
/*     */     }
/* 181 */     CommonMultiTaskInfo xInfo = (CommonMultiTaskInfo)xAllInfos.getActivity2info().get(Integer.valueOf(activityId));
/* 182 */     if (xInfo == null)
/*     */     {
/* 184 */       return false;
/*     */     }
/* 186 */     if (xInfo.getTurn() >= needAwardTurn)
/*     */     {
/*     */ 
/* 189 */       return true;
/*     */     }
/* 191 */     Set<Integer> steps = xInfo.getFinishsteps();
/* 192 */     if (!steps.contains(Integer.valueOf(curRing)))
/*     */     {
/* 194 */       steps.add(Integer.valueOf(curRing));
/* 195 */       String userId = RoleInterface.getUserId(roleId);
/* 196 */       if (!AwardInterface.awardToRoleByAwardModel(userId, roleId, am, false, true, reason))
/*     */       {
/* 198 */         return false;
/*     */       }
/* 200 */       if (TaskInterface.getAllTaskNumInGraph(graphId) == steps.size())
/*     */       {
/* 202 */         steps.clear();
/* 203 */         xInfo.setTurn(xInfo.getTurn() + 1);
/* 204 */         ActivityInterface.addActivityCount(userId, roleId, activityId);
/*     */       }
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Long, String> lockAllUser(List<Long> members)
/*     */   {
/* 218 */     if ((members == null) || (members.size() == 0))
/*     */     {
/* 220 */       return null;
/*     */     }
/* 222 */     Map<Long, String> roleId2userId = new HashMap();
/* 223 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 225 */       String userid = RoleInterface.getUserId(roleId);
/* 226 */       roleId2userId.put(Long.valueOf(roleId), userid);
/*     */     }
/* 228 */     if (roleId2userId.size() == 0)
/*     */     {
/* 230 */       return null;
/*     */     }
/*     */     
/* 233 */     lock(User.getTable(), roleId2userId.values());
/* 234 */     return roleId2userId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multicommontask\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */