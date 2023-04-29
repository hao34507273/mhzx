/*    */ package mzm.gsp.task.enterFight;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.task.SJoinFightReq;
/*    */ import mzm.gsp.task.SLeaderWaitMemberRep;
/*    */ import mzm.gsp.task.confbean.TaskConsts;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pod;
/*    */ import xbean.TaskConfBean;
/*    */ import xtable.Role2taskconf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PTryEnterTaskFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long leaderId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   private final int battleId;
/*    */   
/*    */   public PTryEnterTaskFight(long leaderId, int graphId, int taskId, int battleId)
/*    */   {
/* 29 */     this.leaderId = leaderId;
/* 30 */     this.graphId = graphId;
/* 31 */     this.taskId = taskId;
/* 32 */     this.battleId = battleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 40 */     long leaderIdNow = TeamInterface.getTeamLeaderByRoleid(this.leaderId, false, false);
/* 41 */     if (leaderIdNow != this.leaderId)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 47 */     int taskState = TaskInterface.getTaskState(this.leaderId, this.graphId, this.taskId);
/* 48 */     if (taskState != 2)
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 54 */     List<Long> allRoles = TeamInterface.getNormalRoleList(this.leaderId);
/* 55 */     if (allRoles.size() <= 1)
/*    */     {
/* 57 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 61 */     if (Role2taskconf.get(Long.valueOf(this.leaderId)) != null)
/*    */     {
/* 63 */       return false;
/*    */     }
/* 65 */     allRoles.remove(Long.valueOf(this.leaderId));
/* 66 */     TaskConfBean xTaskConfBean = Pod.newTaskConfBean();
/* 67 */     xTaskConfBean.setLeaderid(this.leaderId);
/* 68 */     xTaskConfBean.setGraphid(this.graphId);
/* 69 */     xTaskConfBean.setTaskid(this.taskId);
/* 70 */     xTaskConfBean.setBattleid(this.battleId);
/* 71 */     xTaskConfBean.getAllroles().addAll(allRoles);
/*    */     
/* 73 */     if (!Role2taskconf.add(Long.valueOf(this.leaderId), xTaskConfBean))
/*    */     {
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     int waitTime = TaskConsts.getInstance().ENTER_FIGHT_WAITING_TIME;
/*    */     
/* 80 */     InviteJoinFightSession session = new InviteJoinFightSession(waitTime, this.leaderId);
/*    */     
/* 82 */     SLeaderWaitMemberRep sLeaderWaitMemberRep = new SLeaderWaitMemberRep();
/* 83 */     OnlineManager.getInstance().send(this.leaderId, sLeaderWaitMemberRep);
/*    */     
/* 85 */     SJoinFightReq sJoinFightReq = new SJoinFightReq();
/* 86 */     sJoinFightReq.taskid = this.taskId;
/* 87 */     sJoinFightReq.sessionid = session.getSessionId();
/* 88 */     OnlineManager.getInstance().sendMulti(sJoinFightReq, allRoles);
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\enterFight\PTryEnterTaskFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */