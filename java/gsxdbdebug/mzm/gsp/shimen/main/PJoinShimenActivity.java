/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PJoinShimenActivity
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PJoinShimenActivity(long roleId)
/*    */   {
/* 24 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (!ShimenManager.isRoleStateCanJoinShimenActivity(this.roleId))
/*    */     {
/* 34 */       String logStr = String.format("[shimen]PJoinShimenActivity.processImp@role state can not join shimen activity|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 36 */       ShimenManager.logger.info(logStr);
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (!ShimenManager.isShimenSwitchOpenForRole(this.roleId))
/*    */     {
/* 42 */       String logstr = String.format("[shimen]PJoinShimenActivity.processImp@shimen switch closed", new Object[0]);
/* 43 */       ShimenManager.logger.info(logstr);
/* 44 */       return false;
/*    */     }
/* 46 */     String userId = RoleInterface.getUserId(this.roleId);
/*    */     
/* 48 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId }));
/* 49 */     Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 51 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID);
/*    */     
/*    */ 
/* 54 */     if (!res.isCanJoin())
/*    */     {
/* 56 */       return false;
/*    */     }
/* 58 */     int ocp = RoleInterface.getOccupationId(this.roleId);
/* 59 */     int graphid = ShimenManager.getShimenGraphIdByMenpai(ocp);
/*    */     
/* 61 */     boolean ret = TaskInterface.goNextTask(this.roleId, graphid);
/* 62 */     if (!ret)
/*    */     {
/* 64 */       String logstr = String.format("[shimen]PJoinShimenActivity.processImp@Shimen go next task error|roleid=%d|graphid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(graphid) });
/*    */       
/*    */ 
/* 67 */       ShimenManager.logger.error(logstr);
/* 68 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\PJoinShimenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */