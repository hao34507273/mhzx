/*    */ package mzm.gsp.grow.daytarget;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.grow.confbean.TargetConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetInitTargets
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetInitTargets(long roleId)
/*    */   {
/* 26 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     String userId = RoleInterface.getUserId(this.roleId);
/*    */     
/* 34 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 36 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 38 */     RoleDayInfo roleDayInfo = new RoleDayInfo(this.roleId, true);
/*    */     
/* 40 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, TargetConsts.getInstance().ACTIVITYID);
/*    */     
/*    */ 
/* 43 */     if (!res.isCanJoin())
/*    */     {
/* 45 */       GameServer.logger().error(String.format("[dayTarget]PCGetInitTargets.processImp@canJoinAndCheckInitActivityData error!res.reason=%d", new Object[] { Integer.valueOf(res.getReasonValue()) }));
/*    */       
/*    */ 
/* 48 */       return false;
/*    */     }
/* 50 */     DayTargetManager.synAllTargets(roleDayInfo);
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\PCGetInitTargets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */