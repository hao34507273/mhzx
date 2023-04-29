/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.item.confbean.STokenType;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.SAcceptMoralValueTaskFail;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAcceptMoralValueTask
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PAcceptMoralValueTask(long roleId)
/*    */   {
/* 29 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     if (PKManager.isNotEnable()) {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1627, true))
/*    */     {
/* 40 */       PKLogManager.error(String.format("PAcceptMoralValueTask.processImp()@status conflict|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     String userId = RoleInterface.getUserId(this.roleId);
/* 45 */     if (userId == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     Lockeys.lock(User.getTable(), Collections.singleton(userId));
/* 49 */     Lockeys.lock(Basic.getTable(), Collections.singleton(Long.valueOf(this.roleId)));
/*    */     
/*    */ 
/* 52 */     STokenType tokenCfg = STokenType.get(7);
/* 53 */     int moralValue = (int)MallInterface.getJifen(this.roleId, 7);
/* 54 */     if (moralValue >= tokenCfg.ownMax)
/*    */     {
/* 56 */       notifyFail(1);
/* 57 */       PKLogManager.error(String.format("PAcceptMoralValueTask.processImp()@moral value full|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 58 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 62 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, SPKConsts.getInstance().MORAL_TASK_ACTIVITY_ID);
/*    */     
/* 64 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/* 66 */       PKLogManager.error(String.format("PAcceptMoralValueTask.processImp()@all task accepted|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 67 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 71 */     boolean result = TaskInterface.goNextTask(this.roleId, SPKConsts.getInstance().MORAL_TASK_GRAPH_ID);
/* 72 */     if (!result)
/*    */     {
/* 74 */       PKLogManager.error(String.format("PAcceptMoralValueTask.processImp()@start task failed|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     PKLogManager.tlogAcceptMoralValueTask(this.roleId);
/* 79 */     PKLogManager.info(String.format("PAcceptMoralValueTask.processImp()@done|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 80 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyFail(int retcode)
/*    */   {
/* 85 */     SAcceptMoralValueTaskFail sAcceptMoralValueTaskFail = new SAcceptMoralValueTaskFail();
/* 86 */     sAcceptMoralValueTaskFail.retcode = retcode;
/* 87 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sAcceptMoralValueTaskFail);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PAcceptMoralValueTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */