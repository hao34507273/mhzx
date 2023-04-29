/*    */ package mzm.gsp.task.enterFight;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.task.SCancelInvite;
/*    */ import mzm.gsp.task.condition.AbsCondition;
/*    */ import mzm.gsp.task.condition.Con_KillNpc_6;
/*    */ import mzm.gsp.task.confbean.STaskConkillNpc;
/*    */ import mzm.gsp.task.main.Task;
/*    */ import mzm.gsp.task.main.TaskManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.TaskConfBean;
/*    */ import xtable.Role2taskconf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinFightManager
/*    */ {
/*    */   static void cancelInvite(long leaderId, TaskConfBean xTaskConfBean)
/*    */   {
/* 27 */     List<Long> allTeamMember = new ArrayList(xTaskConfBean.getAllroles());
/* 28 */     allTeamMember.add(Long.valueOf(leaderId));
/*    */     
/* 30 */     OnlineManager.getInstance().sendMulti(new SCancelInvite(), allTeamMember);
/*    */     
/* 32 */     Role2taskconf.remove(Long.valueOf(leaderId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean checkAndExcuteFight(long leaderId, int graphId, int taskId, int battleId)
/*    */   {
/* 51 */     if (!isTaskNeedConf(taskId))
/*    */     {
/* 53 */       return false;
/*    */     }
/* 55 */     List<Long> teamMember_normal = TeamInterface.getNormalRoleList(leaderId);
/* 56 */     if ((teamMember_normal == null) || (teamMember_normal.size() <= 1))
/*    */     {
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     new PTryEnterTaskFight(leaderId, graphId, taskId, battleId).execute();
/* 62 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isTaskNeedConf(int taskId)
/*    */   {
/* 74 */     Task task = TaskManager.getTaskById(taskId);
/* 75 */     if (task == null)
/*    */     {
/* 77 */       return false;
/*    */     }
/* 79 */     List<AbsCondition> absConditions = task.getCondition(6, 2);
/* 80 */     if ((absConditions == null) || (absConditions.size() == 0))
/*    */     {
/* 82 */       return false;
/*    */     }
/* 84 */     for (AbsCondition con : absConditions)
/*    */     {
/* 86 */       if (!(con instanceof Con_KillNpc_6))
/*    */       {
/* 88 */         return false;
/*    */       }
/* 90 */       Con_KillNpc_6 condition = (Con_KillNpc_6)con;
/* 91 */       if (condition.getSConkillNpc().joinBattleConfirm)
/*    */       {
/* 93 */         return true;
/*    */       }
/*    */     }
/* 96 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\enterFight\JoinFightManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */