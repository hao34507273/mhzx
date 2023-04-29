/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ 
/*    */ public class POnTaskStateChanged
/*    */   extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (((TaskEventArg)this.arg).graphId != SPKConsts.getInstance().MORAL_TASK_GRAPH_ID)
/* 23 */       return false;
/* 24 */     if (((TaskEventArg)this.arg).taskState != 8) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     String userId = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/* 29 */     if (userId == null)
/* 30 */       return false;
/* 31 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, ((TaskEventArg)this.arg).roleId, SPKConsts.getInstance().MORAL_TASK_ACTIVITY_ID).isCanJoin())
/*    */     {
/*    */ 
/* 34 */       PKLogManager.error(String.format("POnTaskStateChanged.processImp()@all tasks already done|roleid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId) }));
/* 35 */       return false;
/*    */     }
/* 37 */     ActivityInterface.addActivityCount(userId, ((TaskEventArg)this.arg).roleId, SPKConsts.getInstance().MORAL_TASK_ACTIVITY_ID);
/* 38 */     AwardModel awardResult = AwardInterface.awardFixAward(SPKConsts.getInstance().MORAL_TASK_AWARD_ID, userId, ((TaskEventArg)this.arg).roleId, false, true, new AwardReason(LogReason.FINISH_MORAL_VALUE_TASK));
/*    */     
/*    */ 
/* 41 */     if (awardResult == null)
/*    */     {
/* 43 */       PKLogManager.error(String.format("POnTaskStateChanged.processImp()@send award fail|roleid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId) }));
/* 44 */       return false;
/*    */     }
/* 46 */     Integer awardedMoralValue = (Integer)awardResult.getTokenMap().get(Integer.valueOf(7));
/* 47 */     int finishedTaskNum = ActivityInterface.getActivityCount(userId, ((TaskEventArg)this.arg).roleId, SPKConsts.getInstance().MORAL_TASK_ACTIVITY_ID, true);
/*    */     
/* 49 */     if (awardedMoralValue == null)
/*    */     {
/* 51 */       PKLogManager.error(String.format("POnTaskStateChanged.processImp()@moral value not change|roleid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId) }));
/*    */       
/* 53 */       return false;
/*    */     }
/* 55 */     int newMoralValue = (int)MallInterface.getJifen(((TaskEventArg)this.arg).roleId, 7);
/* 56 */     PKManager.triggerMoralValueChangeEvent(((TaskEventArg)this.arg).roleId, newMoralValue - awardedMoralValue.intValue(), newMoralValue);
/* 57 */     PKLogManager.tlogFinishMoralValueTask(((TaskEventArg)this.arg).roleId);
/* 58 */     PKLogManager.info(String.format("POnTaskStateChanged.processImp()@finish task|roleid=%d|finished_task_num=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(finishedTaskNum) }));
/*    */     
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\POnTaskStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */