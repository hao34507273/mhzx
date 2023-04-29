/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.grow.SSynLevelGuideSchedule;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LevelGuideInfo;
/*    */ import xbean.RoleLevelGuidesInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2levelguide;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGetGoalAward
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int goalId;
/*    */   
/*    */   public PGetGoalAward(long roleId, int goalId)
/*    */   {
/* 31 */     this.roleId = roleId;
/* 32 */     this.goalId = goalId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     if (!LevelGuideManager.isGoalCfgExist(this.goalId))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     String userId = RoleInterface.getUserId(this.roleId);
/* 45 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 47 */     RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.get(Long.valueOf(this.roleId));
/* 48 */     if (!LevelGuideManager.CanGetGoalAward(xGuidesInfo, this.goalId))
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 213, true))
/*    */     {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     ((LevelGuideInfo)xGuidesInfo.getTargets().get(Integer.valueOf(this.goalId))).setTargetstate(3);
/*    */     
/*    */ 
/* 60 */     int awardId = LevelGuideManager.getGoalAwardId(this.goalId);
/* 61 */     if (awardId < 0)
/*    */     {
/* 63 */       return false;
/*    */     }
/* 65 */     AwardReason awardReason = new AwardReason(LogReason.LEVEL_GUIDE_AWARD);
/* 66 */     AwardModel awardModel = AwardInterface.awardFixAward(awardId, userId, this.roleId, true, true, awardReason);
/* 67 */     if (awardModel == null)
/*    */     {
/* 69 */       if (GameServer.logger().isDebugEnabled())
/*    */       {
/* 71 */         GameServer.logger().debug(String.format("[LevelGuide]PGetGoalAward.processImp@get award failed|roleId=%d|awardId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(awardId) }));
/*    */       }
/*    */       
/*    */ 
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     SSynLevelGuideSchedule pro = new SSynLevelGuideSchedule();
/* 79 */     pro.targetid = this.goalId;
/* 80 */     pro.targetstate = 3;
/* 81 */     OnlineManager.getInstance().send(this.roleId, pro);
/*    */     
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\PGetGoalAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */