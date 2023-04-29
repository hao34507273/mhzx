/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetHuanHunReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetHuanHunReq(long roleId)
/*    */   {
/* 23 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!HuanhunManager.isHunOpen(this.roleId))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     String userid = RoleInterface.getUserId(this.roleId);
/* 35 */     lock(Lockeys.get(User.getTable(), userid));
/* 36 */     Map<Long, String> roleId2UserId = new HashMap();
/* 37 */     roleId2UserId.put(Long.valueOf(this.roleId), userid);
/*    */     
/* 39 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleId2UserId, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), HuanHunMiShuConsts.getInstance().ACTIVITYID);
/*    */     
/* 41 */     if (!res.isCanJoin())
/*    */     {
/* 43 */       GameServer.logger().error(String.format("[hun]PCGetHuanHunReq.processImp@can not join activity!|roleId=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(res.getReasonValue()) }));
/*    */       
/*    */ 
/* 46 */       return false;
/*    */     }
/* 48 */     return TaskInterface.activeGraph(Long.valueOf(this.roleId), HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PCGetHuanHunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */