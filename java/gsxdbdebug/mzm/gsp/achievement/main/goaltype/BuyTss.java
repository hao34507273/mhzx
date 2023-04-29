/*     */ package mzm.gsp.achievement.main.goaltype;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.achievement.confbean.GoalParameter;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.AchievementInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BuyTss
/*     */   extends AbstractGoalType
/*     */ {
/*     */   public int getType()
/*     */   {
/*  24 */     return 5300;
/*     */   }
/*     */   
/*     */ 
/*     */   public void initParams(AchievementInfo xAchievementInfo)
/*     */   {
/*  30 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*     */   {
/*  37 */     String userId = RoleInterface.getUserId(roleId);
/*  38 */     List<Integer> tssServiceIds = getTSSServiceIds(sAchievementGoalCfg);
/*  39 */     if (tssServiceIds != null)
/*     */     {
/*  41 */       int times = 0;
/*  42 */       for (Iterator i$ = tssServiceIds.iterator(); i$.hasNext();) { int sId = ((Integer)i$.next()).intValue();
/*     */         
/*  44 */         times = (int)(times + QingfuInterface.getTssBuyTimes(userId, sId, false));
/*     */       }
/*  46 */       int cfgTssTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*  47 */       List<Integer> xTssGoalParameter = xAchievementInfo.getGoal_parameters();
/*  48 */       if (((Integer)xTssGoalParameter.get(0)).intValue() != times)
/*     */       {
/*  50 */         xTssGoalParameter.set(0, Integer.valueOf(times > cfgTssTimes ? cfgTssTimes : times));
/*  51 */         return true;
/*     */       }
/*     */     }
/*  54 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*     */   {
/*  61 */     Context context = (Context)ctx;
/*  62 */     List<Integer> goalParameterTypes = getTSSServiceIds(sAchievementGoalCfg);
/*  63 */     if (goalParameterTypes == null)
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     if (!goalParameterTypes.contains(Integer.valueOf(context.serviceId)))
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     int oldTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  73 */     int goalTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*  74 */     if (oldTimes == goalTimes)
/*     */     {
/*  76 */       return false;
/*     */     }
/*  78 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(context.buyNum, goalTimes)));
/*     */     
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   public static List<Integer> getTSSServiceIds(SAchievementGoalCfg sAchievementGoalCfg)
/*     */   {
/*  85 */     if (sAchievementGoalCfg.goalType != 5300)
/*     */     {
/*  87 */       return null;
/*     */     }
/*  89 */     ArrayList<GoalParameter> goalParameters = sAchievementGoalCfg.goalParameters;
/*  90 */     if ((goalParameters == null) || (goalParameters.size() == 0))
/*     */     {
/*  92 */       return null;
/*     */     }
/*  94 */     List<Integer> result = new ArrayList();
/*     */     
/*  96 */     for (int i = 1; i < goalParameters.size(); i++)
/*     */     {
/*  98 */       if (((GoalParameter)goalParameters.get(i)).parameter != 0)
/*     */       {
/*     */ 
/*     */ 
/* 102 */         result.add(Integer.valueOf(((GoalParameter)goalParameters.get(i)).parameter)); }
/*     */     }
/* 104 */     return result;
/*     */   }
/*     */   
/*     */   public static class Context
/*     */   {
/*     */     private final int serviceId;
/*     */     private final int buyNum;
/*     */     
/*     */     public Context(int serviceId, int buyNum)
/*     */     {
/* 114 */       this.serviceId = serviceId;
/* 115 */       this.buyNum = buyNum;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\BuyTss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */