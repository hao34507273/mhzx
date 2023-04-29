/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.grow.SSynFunctionOpenSchedule;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LevelGuideInfo;
/*    */ import xbean.RoleLevelGuidesInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2levelguide;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGetFunctionOpenAward extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int goalId;
/*    */   
/*    */   public PGetFunctionOpenAward(long roleId, int goalId)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.goalId = goalId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!LevelGuideManager.isGoalCfgExist(this.goalId))
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     String userId = RoleInterface.getUserId(this.roleId);
/* 41 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 43 */     RoleLevelGuidesInfo xRoleLevelGuidesInfo = Role2levelguide.get(Long.valueOf(this.roleId));
/* 44 */     if (!LevelGuideManager.CanGetGoalAward(xRoleLevelGuidesInfo, this.goalId))
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     xRoleLevelGuidesInfo = Role2levelguide.get(Long.valueOf(this.roleId));
/* 49 */     if (xRoleLevelGuidesInfo == null)
/*    */     {
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 212, true))
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 60 */     int awardId = LevelGuideManager.getGoalAwardId(this.goalId);
/* 61 */     if (awardId < 0)
/*    */     {
/* 63 */       return false;
/*    */     }
/* 65 */     AwardReason awardReason = new AwardReason(LogReason.FUNCTION_OPEN_AWARD);
/* 66 */     AwardModel awardModel = AwardInterface.awardFixAward(awardId, userId, this.roleId, true, true, awardReason);
/* 67 */     if (awardModel == null)
/*    */     {
/* 69 */       if (GameServer.logger().isDebugEnabled())
/*    */       {
/* 71 */         GameServer.logger().debug(String.format("[PGetFunctionOpenAward]PGetFunctionOpenAward.processImp@get award failed|roleId=%d|awardId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(awardId) }));
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 76 */       return false;
/*    */     }
/*    */     
/* 79 */     ((LevelGuideInfo)xRoleLevelGuidesInfo.getTargets().get(Integer.valueOf(this.goalId))).setTargetstate(3);
/*    */     
/* 81 */     SSynFunctionOpenSchedule pro = new SSynFunctionOpenSchedule();
/* 82 */     pro.targetid = this.goalId;
/* 83 */     pro.targetstate = 3;
/* 84 */     OnlineManager.getInstance().send(this.roleId, pro);
/*    */     
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\PGetFunctionOpenAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */