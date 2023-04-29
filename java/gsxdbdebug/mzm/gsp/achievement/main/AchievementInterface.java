/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.achievement.confbean.AchievementConsts;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalParameterCfg;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AchievementInfo;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xtable.Role2achievement;
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
/*     */ public class AchievementInterface
/*     */ {
/*     */   public static int getAchievementGoalState(long roleId, int activityCfgId, int goalCfgId, boolean isRemainRolelock)
/*     */   {
/*  34 */     Role2AchievementInfo xRole2AchievementInfo = null;
/*  35 */     if (isRemainRolelock)
/*     */     {
/*  37 */       xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  41 */       xRole2AchievementInfo = Role2achievement.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  44 */     if (xRole2AchievementInfo == null)
/*     */     {
/*  46 */       return 1;
/*     */     }
/*     */     
/*  49 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(activityCfgId));
/*     */     
/*  51 */     if (xActivityAchievementInfo == null)
/*     */     {
/*  53 */       return 1;
/*     */     }
/*     */     
/*  56 */     AchievementInfo xAchievementInfo = (AchievementInfo)xActivityAchievementInfo.getGoal_info().get(Integer.valueOf(goalCfgId));
/*  57 */     if (xAchievementInfo == null)
/*     */     {
/*  59 */       return 1;
/*     */     }
/*     */     
/*  62 */     return xAchievementInfo.getGoal_state();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getAchievementScore(long roleId, int activityCfgId, boolean retainLock)
/*     */   {
/*     */     Role2AchievementInfo xRole2AchievementInfo;
/*     */     
/*     */ 
/*     */     Role2AchievementInfo xRole2AchievementInfo;
/*     */     
/*     */ 
/*  76 */     if (retainLock)
/*     */     {
/*  78 */       xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  82 */       xRole2AchievementInfo = Role2achievement.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  85 */     if (null == xRole2AchievementInfo)
/*     */     {
/*  87 */       return 0;
/*     */     }
/*     */     
/*  90 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(activityCfgId));
/*     */     
/*  92 */     if (null == xActivityAchievementInfo)
/*     */     {
/*  94 */       return 0;
/*     */     }
/*     */     
/*  97 */     return xActivityAchievementInfo.getScore_value();
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
/*     */   public static void updateGoalTypeState(long roleId, int goalType, Object context, String logStr)
/*     */   {
/* 111 */     AchievementManager.updateGoalTypeState(roleId, goalType, context, logStr);
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
/*     */   public static Pair<Integer, Map<Integer, Integer>> getMultiAchievementState(long roleId, Collection<Integer> achievementGoalCfgIds, boolean retainLock)
/*     */   {
/* 128 */     Map<Integer, Integer> goalCfgId2State = new HashMap();
/* 129 */     Pair<Integer, Map<Integer, Integer>> result = new Pair(Integer.valueOf(0), goalCfgId2State);
/* 130 */     for (Iterator i$ = achievementGoalCfgIds.iterator(); i$.hasNext();) { int goalCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 132 */       goalCfgId2State.put(Integer.valueOf(goalCfgId), Integer.valueOf(1));
/*     */     }
/*     */     
/*     */ 
/* 136 */     int achievementActivityId = AchievementConsts.getInstance().activityId;
/*     */     Role2AchievementInfo xRole2AchievementInfo;
/* 138 */     Role2AchievementInfo xRole2AchievementInfo; if (retainLock)
/*     */     {
/* 140 */       xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 144 */       xRole2AchievementInfo = Role2achievement.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 147 */     if (null == xRole2AchievementInfo)
/*     */     {
/* 149 */       return result;
/*     */     }
/*     */     
/* 152 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(achievementActivityId));
/*     */     
/* 154 */     if (null == xActivityAchievementInfo)
/*     */     {
/* 156 */       return result;
/*     */     }
/*     */     
/* 159 */     int totalScore = 0;
/* 160 */     for (Iterator i$ = achievementGoalCfgIds.iterator(); i$.hasNext();) { int goalCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 162 */       AchievementInfo xAchievementInfo = (AchievementInfo)xActivityAchievementInfo.getGoal_info().get(Integer.valueOf(goalCfgId));
/* 163 */       if (null != xAchievementInfo)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 169 */         int goalState = xAchievementInfo.getGoal_state();
/* 170 */         goalCfgId2State.put(Integer.valueOf(goalCfgId), Integer.valueOf(goalState));
/*     */         
/*     */ 
/* 173 */         if ((goalState == 3) || (goalState == 2))
/*     */         {
/*     */ 
/*     */ 
/* 177 */           SAchievementGoalCfg sAchievementGoalCfg = SAchievementGoalCfg.get(goalCfgId);
/* 178 */           if (null == sAchievementGoalCfg)
/*     */           {
/* 180 */             GameServer.logger().warn(String.format("[achievement]AchievementInterface.getMultiAchievementState@finished achievement cfg not exists!|role_id=%d,goal_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(goalCfgId) }));
/*     */ 
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 187 */             totalScore += sAchievementGoalCfg.score; }
/*     */         }
/*     */       }
/*     */     }
/* 191 */     result.first = Integer.valueOf(totalScore);
/* 192 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum ChangeParamResult
/*     */   {
/* 200 */     SUCCESS(0), 
/* 201 */     ROLE_NOT_EXIST(1), 
/* 202 */     ACHIEVEMENT_NOT_EXIST(2), 
/* 203 */     PARAM_NUM_WRONG(3), 
/* 204 */     NOT_ON_GOING(4), 
/* 205 */     PARAM_INVALID(5);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private ChangeParamResult(int value)
/*     */     {
/* 211 */       this.value = value;
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
/*     */   public static ChangeParamResult changeAchievementParam(long roleId, int goalCfgId, List<Integer> newParams)
/*     */   {
/* 229 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/* 230 */     if (null == xRole2AchievementInfo)
/*     */     {
/* 232 */       return ChangeParamResult.ROLE_NOT_EXIST;
/*     */     }
/*     */     
/* 235 */     SAchievementGoalCfg sAchievementGoalCfg = SAchievementGoalCfg.get(goalCfgId);
/* 236 */     if (null == sAchievementGoalCfg)
/*     */     {
/* 238 */       return ChangeParamResult.ACHIEVEMENT_NOT_EXIST;
/*     */     }
/*     */     
/* 241 */     int activityCfgId = sAchievementGoalCfg.activityCfgId;
/* 242 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(activityCfgId));
/*     */     
/* 244 */     if (null == xActivityAchievementInfo)
/*     */     {
/* 246 */       return ChangeParamResult.ACHIEVEMENT_NOT_EXIST;
/*     */     }
/*     */     
/*     */ 
/* 250 */     AchievementInfo xAchievementInfo = (AchievementInfo)xActivityAchievementInfo.getGoal_info().get(Integer.valueOf(goalCfgId));
/* 251 */     if (null == xAchievementInfo)
/*     */     {
/* 253 */       return ChangeParamResult.ACHIEVEMENT_NOT_EXIST;
/*     */     }
/*     */     
/* 256 */     if (xAchievementInfo.getGoal_state() != 1)
/*     */     {
/* 258 */       return ChangeParamResult.NOT_ON_GOING;
/*     */     }
/*     */     
/* 261 */     List<Integer> goalParams = xAchievementInfo.getGoal_parameters();
/* 262 */     if (goalParams.size() != newParams.size())
/*     */     {
/* 264 */       return ChangeParamResult.PARAM_NUM_WRONG;
/*     */     }
/*     */     
/* 267 */     for (int i = 0; i < goalParams.size(); i++)
/*     */     {
/* 269 */       Integer newParam = (Integer)newParams.get(i);
/* 270 */       if ((null == newParam) || (newParam.intValue() < 0))
/*     */       {
/* 272 */         return ChangeParamResult.PARAM_INVALID;
/*     */       }
/* 274 */       goalParams.set(i, newParams.get(i));
/*     */     }
/*     */     
/*     */ 
/* 278 */     String logStr = "AchievementInterface.changeAchievementParam@changeAchievementParam by idip success";
/* 279 */     SAchievementGoalParameterCfg sAchievementGoalParameterCfg = SAchievementGoalParameterCfg.get(goalCfgId);
/* 280 */     List<Integer> cfgGoalParams = sAchievementGoalParameterCfg.parameterList;
/* 281 */     AchievementManager.sSyncGoalRefreshInfo(roleId, activityCfgId, goalCfgId, xActivityAchievementInfo, xAchievementInfo, cfgGoalParams, "AchievementInterface.changeAchievementParam@changeAchievementParam by idip success");
/*     */     
/*     */ 
/* 284 */     return ChangeParamResult.SUCCESS;
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
/*     */   public static Pair<Integer, Integer> getFinishedAchievementNumAndScore(long roleId, boolean retainLock)
/*     */   {
/* 298 */     Pair<Integer, Integer> result = new Pair(Integer.valueOf(0), Integer.valueOf(0));
/*     */     
/*     */ 
/* 301 */     int achievementActivityId = AchievementConsts.getInstance().activityId;
/*     */     Role2AchievementInfo xRole2AchievementInfo;
/* 303 */     Role2AchievementInfo xRole2AchievementInfo; if (retainLock)
/*     */     {
/* 305 */       xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 309 */       xRole2AchievementInfo = Role2achievement.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 312 */     if (null == xRole2AchievementInfo)
/*     */     {
/* 314 */       return result;
/*     */     }
/*     */     
/* 317 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(achievementActivityId));
/*     */     
/* 319 */     if (null == xActivityAchievementInfo)
/*     */     {
/* 321 */       return result;
/*     */     }
/*     */     
/* 324 */     int finishedGoalNum = 0;
/* 325 */     for (AchievementInfo xAchievementInfo : xActivityAchievementInfo.getGoal_info().values())
/*     */     {
/* 327 */       int state = xAchievementInfo.getGoal_state();
/* 328 */       if ((state == 2) || (state == 3))
/*     */       {
/* 330 */         finishedGoalNum++;
/*     */       }
/*     */     }
/*     */     
/* 334 */     result.first = Integer.valueOf(finishedGoalNum);
/* 335 */     result.second = Integer.valueOf(xActivityAchievementInfo.getScore_value());
/*     */     
/* 337 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\AchievementInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */