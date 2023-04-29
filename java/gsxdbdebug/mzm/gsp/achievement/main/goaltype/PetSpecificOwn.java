/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 5403;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 27 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 34 */     int petCfgId = ((Integer)context).intValue();
/* 35 */     int goalPetCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 36 */     if ((goalPetCfgId != 0) && (goalPetCfgId != petCfgId))
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/*    */     int newNum;
/*    */     int newNum;
/* 43 */     if (goalPetCfgId == 0)
/*    */     {
/* 45 */       newNum = PetInterface.getTotalOwnPetNum(roleId, true);
/*    */     }
/*    */     else
/*    */     {
/* 49 */       newNum = PetInterface.getPetNumInBagAndDepotByPetCfgId(roleId, goalPetCfgId, true);
/*    */     }
/* 51 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(newNum));
/*    */     
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 59 */     int goalPetCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*    */     int petNum;
/* 61 */     int petNum; if (goalPetCfgId == 0)
/*    */     {
/* 63 */       petNum = PetInterface.getTotalOwnPetNum(roleId, true);
/*    */     }
/*    */     else
/*    */     {
/* 67 */       petNum = PetInterface.getPetNumInBagAndDepotByPetCfgId(roleId, goalPetCfgId, true);
/*    */     }
/*    */     
/*    */ 
/* 71 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 72 */     if (petNum == oldNum)
/*    */     {
/* 74 */       return false;
/*    */     }
/* 76 */     int goalNum = ((Integer)goalParameters.get(0)).intValue();
/* 77 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalNum, petNum)));
/*    */     
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PetSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */