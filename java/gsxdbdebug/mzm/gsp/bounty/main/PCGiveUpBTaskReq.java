/*    */ package mzm.gsp.bounty.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.BountyConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGiveUpBTaskReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   
/*    */   public PCGiveUpBTaskReq(long roleId, int graphId, int taskId)
/*    */   {
/* 29 */     this.roleId = roleId;
/* 30 */     this.graphId = graphId;
/* 31 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     if (!BountyManager.isBountyOpen(this.roleId))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     String userid = RoleInterface.getUserId(this.roleId);
/* 44 */     lock(Lockeys.get(User.getTable(), userid));
/* 45 */     Map<Long, String> roleidToUserid = new HashMap();
/*    */     
/* 47 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 49 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), BountyConsts.getInstance().ACTIVITYID).isCanJoin())
/*    */     {
/*    */ 
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     if (!BountyManager.isCanGiveUp(this.roleId, this.graphId, this.taskId))
/*    */     {
/* 57 */       return false;
/*    */     }
/* 59 */     TaskInterface.giveUpTaskImpl(this.roleId, this.graphId, this.taskId);
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\PCGiveUpBTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */