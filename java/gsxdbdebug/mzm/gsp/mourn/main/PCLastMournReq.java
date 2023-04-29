/*    */ package mzm.gsp.mourn.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.activity2.confbean.MournConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.XMournInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2mourn;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCLastMournReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCLastMournReq(long roleId)
/*    */   {
/* 27 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!MournManager.isMournOpen())
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     String userId = RoleInterface.getUserId(this.roleId);
/* 39 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 41 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 43 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, MournConsts.getInstance().activityId);
/*    */     
/* 45 */     if (!res.isCanJoin())
/*    */     {
/* 47 */       GameServer.logger().error(String.format("[mourn]PCLastMournReq.processImp@ activity is forbid!|roleId=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(res.getReasonValue()) }));
/*    */       
/*    */ 
/* 50 */       return false;
/*    */     }
/* 52 */     XMournInfo xMournInfo = Role2mourn.get(Long.valueOf(this.roleId));
/* 53 */     if (xMournInfo == null)
/*    */     {
/* 55 */       GameServer.logger().error(String.format("[mourn]PCLastMournReq.processImp@ xMournInfo is null!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 56 */       return false;
/*    */     }
/* 58 */     if (!MournManager.canDoLastTask(this.roleId, xMournInfo))
/*    */     {
/* 60 */       GameServer.logger().error(String.format("[mourn]PCLastMournReq.processImp@ can not do last task!!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 62 */       return false;
/*    */     }
/* 64 */     TaskInterface.goNextTask(this.roleId, MournConsts.getInstance().questionGraphId);
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\main\PCLastMournReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */