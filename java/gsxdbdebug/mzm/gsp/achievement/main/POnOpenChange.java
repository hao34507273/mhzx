/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*     */ import mzm.gsp.open.event.OpenChangeProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xtable.Role2achievement;
/*     */ 
/*     */ public class POnOpenChange extends OpenChangeProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  19 */     for (Map.Entry<Integer, AchievementActivityHandler> entry : AchievementManager.achievementModuleMap.entrySet())
/*     */     {
/*  21 */       activityCfgId = ((Integer)entry.getKey()).intValue();
/*  22 */       AchievementActivityHandler achievementActivityHandler = (AchievementActivityHandler)entry.getValue();
/*     */       
/*  24 */       if ((((OpenChangeComplexArg)this.arg).getType() == achievementActivityHandler.getSwitchModule(activityCfgId)) && (((OpenChangeComplexArg)this.arg).isOpen()))
/*     */       {
/*  26 */         List<Long> roleIdList = OnlineManager.getInstance().getAllRolesInWorld();
/*  27 */         for (i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/*  29 */           NoneRealTimeTaskManager.getInstance().addTask(new POnAchievementAcitivityOpen(activityCfgId, roleId));
/*     */         } } }
/*     */     int activityCfgId;
/*     */     Iterator i$;
/*  33 */     return true;
/*     */   }
/*     */   
/*     */   private static class POnAchievementAcitivityOpen extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final long roleId;
/*     */     
/*     */     public POnAchievementAcitivityOpen(int activityCfgId, long roleId)
/*     */     {
/*  43 */       this.activityCfgId = activityCfgId;
/*  44 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  50 */       String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  51 */       if (userId == null)
/*     */       {
/*  53 */         return false;
/*     */       }
/*     */       
/*  56 */       AchievementManager.collectLocksToCorrectAchievement(this.roleId);
/*     */       
/*  58 */       AchievementActivityHandler achievementActivityHandler = (AchievementActivityHandler)AchievementManager.achievementModuleMap.get(Integer.valueOf(this.activityCfgId));
/*  59 */       if (achievementActivityHandler == null)
/*     */       {
/*  61 */         return false;
/*     */       }
/*     */       
/*  64 */       mzm.gsp.activity.main.ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityCfgId);
/*     */       
/*  66 */       if (activityJoinResult == null)
/*     */       {
/*  68 */         return false;
/*     */       }
/*     */       
/*  71 */       if (!achievementActivityHandler.isCanTakePartIn(this.roleId, this.activityCfgId))
/*     */       {
/*  73 */         return false;
/*     */       }
/*     */       
/*  76 */       Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(this.roleId));
/*  77 */       if (xRole2AchievementInfo == null)
/*     */       {
/*  79 */         return false;
/*     */       }
/*     */       
/*  82 */       ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(this.activityCfgId));
/*     */       
/*  84 */       if (xActivityAchievementInfo == null)
/*     */       {
/*  86 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  90 */       if (AchievementManager.checkMutexStatus(this.roleId, false, true))
/*     */       {
/*  92 */         AchievementManager.correctAchievementGoalStateOnLogin(this.roleId, this.activityCfgId, xActivityAchievementInfo);
/*     */       }
/*     */       
/*  95 */       if (AchievementManager.isNeedSync(this.roleId, this.activityCfgId, xActivityAchievementInfo))
/*     */       {
/*     */ 
/*  98 */         AchievementManager.synAchievementInfo(this.roleId, this.activityCfgId, xActivityAchievementInfo);
/*     */       }
/*     */       
/* 101 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */