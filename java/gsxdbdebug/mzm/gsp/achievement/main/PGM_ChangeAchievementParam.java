/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PGM_ChangeAchievementParam
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int goalCfgId;
/*    */   private final int param;
/*    */   
/*    */   public PGM_ChangeAchievementParam(long roleId, int goalCfgId, int param)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.goalCfgId = goalCfgId;
/* 19 */     this.param = param;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     AchievementInterface.ChangeParamResult res = AchievementInterface.changeAchievementParam(this.roleId, this.goalCfgId, Arrays.asList(new Integer[] { Integer.valueOf(this.param) }));
/*    */     
/* 27 */     if (res != AchievementInterface.ChangeParamResult.SUCCESS)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("修改进度失败，错误码为%d", new Object[] { Integer.valueOf(res.value) }));
/* 30 */       return false;
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\PGM_ChangeAchievementParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */