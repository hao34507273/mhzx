/*    */ package mzm.gsp.circletask.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.SAcceptCircleTaskRes;
/*    */ import mzm.gsp.activity.SCurrentWeekCannotAccept;
/*    */ import mzm.gsp.activity.SSyncRenXingYiXiaCount;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CircleTask;
/*    */ import xbean.Pod;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2circletask;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAcceptTaskReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PAcceptTaskReq(long roleId)
/*    */   {
/* 39 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 45 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 206, true))
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     long openservertime = ServerInterface.getOpenServertime();
/* 50 */     if ((CircleTaskInterface.isShilianOpen()) && (DateTimeUtils.isInSameWeek(openservertime, DateTimeUtils.getCurrTimeInMillis())))
/*    */     {
/*    */ 
/* 53 */       SCurrentWeekCannotAccept res = new SCurrentWeekCannotAccept();
/* 54 */       OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     String userid = RoleInterface.getUserId(this.roleId);
/* 59 */     lock(Lockeys.get(User.getTable(), userid));
/* 60 */     Map<Long, String> roleidToUserid = new HashMap();
/* 61 */     roleidToUserid.put(Long.valueOf(this.roleId), userid);
/* 62 */     List<Long> roleIdList = new ArrayList();
/* 63 */     roleIdList.add(Long.valueOf(this.roleId));
/* 64 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, roleIdList, CircleTaskConsts.getInstance().TASK_ACTIVITY_ID);
/*    */     
/* 66 */     if (!result.isCanJoin())
/*    */     {
/* 68 */       GameServer.logger().info(String.format("[circle]PAcceptTaskReq.processImp@can not join activity!|roleId=%d|activityId=%d|res=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(CircleTaskConsts.getInstance().TASK_ACTIVITY_ID), Integer.valueOf(result.getReasonValue()) }));
/*    */       
/*    */ 
/* 71 */       return false;
/*    */     }
/* 73 */     if (!RoleInterface.cutSilver(this.roleId, CircleTaskConsts.getInstance().START_TASK_NEED_SILVER, new TLogArg(LogReason.PAOHUAN_START_SILVER_REM)))
/*    */     {
/*    */ 
/* 76 */       return false;
/*    */     }
/* 78 */     CircleTask xCircleTask = Role2circletask.get(Long.valueOf(this.roleId));
/* 79 */     if (xCircleTask == null)
/*    */     {
/* 81 */       xCircleTask = Pod.newCircleTask();
/* 82 */       Role2circletask.add(Long.valueOf(this.roleId), xCircleTask);
/*    */     }
/* 84 */     xCircleTask.setLegendendtime(0L);
/* 85 */     xCircleTask.setRenxingcounter(0);
/* 86 */     SAcceptCircleTaskRes res = new SAcceptCircleTaskRes();
/* 87 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 89 */     SSyncRenXingYiXiaCount sSyncRenXingYiXiaCount = new SSyncRenXingYiXiaCount();
/* 90 */     sSyncRenXingYiXiaCount.count = 0;
/* 91 */     OnlineManager.getInstance().send(this.roleId, sSyncRenXingYiXiaCount);
/* 92 */     ActivityInterface.addActivityCount(userid, this.roleId, CircleTaskConsts.getInstance().TASK_ACTIVITY_ID);
/* 93 */     return TaskInterface.activeGraph(Long.valueOf(this.roleId), CircleTaskConsts.getInstance().TASK_GRAPHIC_ID);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\PAcceptTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */