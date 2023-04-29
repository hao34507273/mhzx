/*    */ package mzm.gsp.tmpactivity.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLogStatus;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTaskStateChanged
/*    */   extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (((TaskEventArg)this.arg).graphId != TmpActivityManager.getGraphId())
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     String userid = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/* 33 */     lock(Lockeys.get(User.getTable(), userid));
/* 34 */     Map<Long, String> roleidToUserid = new HashMap();
/* 35 */     roleidToUserid.put(Long.valueOf(((TaskEventArg)this.arg).roleId), userid);
/*    */     
/* 37 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((TaskEventArg)this.arg).roleId) }));
/* 38 */     return tmpActivityPro(userid);
/*    */   }
/*    */   
/*    */   private boolean tmpActivityPro(String userid)
/*    */   {
/* 43 */     int graphId = ((TaskEventArg)this.arg).graphId;
/* 44 */     long roleId = ((TaskEventArg)this.arg).roleId;
/* 45 */     int activityId = TmpActivityManager.getActivityId();
/*    */     
/* 47 */     switch (((TaskEventArg)this.arg).taskState)
/*    */     {
/*    */ 
/*    */     case 8: 
/* 51 */       if (!ActivityInterface.addActivityCount(userid, roleId, activityId))
/*    */       {
/* 53 */         return false;
/*    */       }
/* 55 */       checkActivityFinish(userid, graphId, roleId, activityId);
/* 56 */       return true;
/*    */     
/*    */     case 2: 
/* 59 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/* 60 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/*    */       
/* 62 */       return true;
/*    */     
/*    */ 
/*    */     case 9: 
/* 66 */       if (!ActivityInterface.addActivityCount(userid, roleId, activityId))
/*    */       {
/* 68 */         return false;
/*    */       }
/* 70 */       return true;
/*    */     }
/*    */     
/* 73 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private boolean checkActivityFinish(String userId, int graphId, long roleId, int activityId)
/*    */   {
/* 80 */     int ringNum = ActivityInterface.getActivityCount(userId, roleId, activityId, false);
/* 81 */     if (ringNum < 0)
/*    */     {
/* 83 */       return false;
/*    */     }
/* 85 */     if (ringNum < TmpActivityManager.finishCount())
/*    */     {
/* 87 */       return true;
/*    */     }
/* 89 */     if (!TaskInterface.closeActivityGraphWithoutEvent(roleId, graphId))
/*    */     {
/* 91 */       GameServer.logger().error(String.format("[tmpactivity]POnTaskStateChanged.checkActivityFinish@ close graph error!|roleId=%d|graphId=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) }));
/*    */       
/*    */ 
/*    */ 
/* 95 */       return false;
/*    */     }
/* 97 */     ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.FINISH);
/* 98 */     ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.FINISH);
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tmpactivity\main\POnTaskStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */