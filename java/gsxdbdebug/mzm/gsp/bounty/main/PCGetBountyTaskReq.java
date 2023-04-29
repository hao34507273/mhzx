/*     */ package mzm.gsp.bounty.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.BountyConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BTaskInfo;
/*     */ import xbean.BountyInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2bounty;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetBountyTaskReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int graphId;
/*     */   private final int taskId;
/*     */   
/*     */   public PCGetBountyTaskReq(long roleId, int graphId, int taskId)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.graphId = graphId;
/*  39 */     this.taskId = taskId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!BountyManager.isBountyOpen(this.roleId))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 204, true))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userid = RoleInterface.getUserId(this.roleId);
/*  55 */     lock(Lockeys.get(User.getTable(), userid));
/*  56 */     Map<Long, String> roleidToUserid = new HashMap();
/*     */     
/*  58 */     BountyInfo xBountyInfo = Role2bounty.get(Long.valueOf(this.roleId));
/*  59 */     if (xBountyInfo == null)
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), BountyConsts.getInstance().ACTIVITYID);
/*     */     
/*  65 */     if (!res.isCanJoin())
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[bounty]PCGetBountyTaskReq.processImp@ can not join activity!|roleId=%d|activityId=%d|errCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(BountyConsts.getInstance().ACTIVITYID), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     if (xBountyInfo.getBountycount() >= BountyConsts.getInstance().DAY_UPPER_LIMIT)
/*     */     {
/*  77 */       BountyManager.sendNormalResult(this.roleId, 3, new String[0]);
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     if (TeamInterface.isRoleInTeam(this.roleId, false))
/*     */     {
/*  84 */       BountyManager.sendNormalResult(this.roleId, 2, new String[0]);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     BTaskInfo xBTaskInfo = (BTaskInfo)xBountyInfo.getTaskinfos().get(Integer.valueOf(this.graphId));
/*  90 */     if (xBTaskInfo == null)
/*     */     {
/*     */ 
/*  93 */       return false;
/*     */     }
/*  95 */     if (this.taskId != xBTaskInfo.getTaskid())
/*     */     {
/*     */ 
/*  98 */       return false;
/*     */     }
/* 100 */     if (0 != xBTaskInfo.getTaskstate())
/*     */     {
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 107 */     if (BountyManager.isHaveBGraph(this.roleId))
/*     */     {
/* 109 */       int state = TaskInterface.getTaskState(this.roleId, this.graphId, this.taskId);
/* 110 */       if ((state == 2) || (state == 3) || (state == 5))
/*     */       {
/*     */ 
/* 113 */         GameServer.logger().info(String.format("[bounty]PCGetBountyTaskReq.processImp@own bounty graph, get new task fail!|roleId=%d|graphId=%d|taskId=%d|taskState=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.graphId), Integer.valueOf(this.taskId), Integer.valueOf(state) }));
/*     */         
/*     */ 
/*     */ 
/* 117 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 121 */     BountyManager.tryGetTask(this.roleId, this.graphId, this.taskId);
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\PCGetBountyTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */