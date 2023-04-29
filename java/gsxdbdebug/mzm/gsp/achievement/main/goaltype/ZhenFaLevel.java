/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.zhenfa.main.RoleZhenfaInfo;
/*    */ import mzm.gsp.zhenfa.main.RoleZhenfaInfo.ZhenfaBeanInfo;
/*    */ import mzm.gsp.zhenfa.main.ZhenfaInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZhenFaLevel
/*    */   extends AbstractDoneOneEventLevelTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 24 */     return 4901;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 31 */     RoleZhenfaInfo roleZhenfaInfo = ZhenfaInterface.getRoleZhenfaInfo(roleId);
/* 32 */     Collection<RoleZhenfaInfo.ZhenfaBeanInfo> zhenfaInfos = roleZhenfaInfo.getAllZhenfaBeans();
/*    */     
/*    */ 
/* 35 */     int goalLevel = ((Integer)goalParameters.get(1)).intValue();
/* 36 */     int maxLevel = 0;
/* 37 */     Map<Long, String> goalParameterExtraMap = xAchievementInfo.getGoal_parameters_extra();
/* 38 */     for (RoleZhenfaInfo.ZhenfaBeanInfo zhenfaInfo : zhenfaInfos)
/*    */     {
/* 40 */       int zhenfaLevel = zhenfaInfo.getZhenfalevel();
/* 41 */       if (zhenfaLevel >= goalLevel)
/*    */       {
/* 43 */         int zhenfaId = zhenfaInfo.getZhenfaId();
/* 44 */         goalParameterExtraMap.put(Long.valueOf(zhenfaId), String.valueOf(zhenfaId));
/*    */       }
/* 46 */       maxLevel = Math.max(maxLevel, zhenfaLevel);
/*    */     }
/*    */     
/*    */ 
/* 50 */     List<Integer> parameters = xAchievementInfo.getGoal_parameters();
/* 51 */     if ((maxLevel == ((Integer)parameters.get(0)).intValue()) && (goalParameterExtraMap.size() == ((Integer)parameters.get(1)).intValue()))
/*    */     {
/*    */ 
/* 54 */       return false;
/*    */     }
/* 56 */     int goalNum = ((Integer)goalParameters.get(0)).intValue();
/* 57 */     parameters.set(0, Integer.valueOf(Math.min(goalNum, goalParameterExtraMap.size())));
/* 58 */     parameters.set(1, Integer.valueOf(Math.min(goalLevel, maxLevel)));
/*    */     
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ZhenFaLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */