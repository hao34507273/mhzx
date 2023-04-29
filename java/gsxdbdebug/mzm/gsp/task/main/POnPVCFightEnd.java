/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVCFightEndArg;
/*    */ import mzm.gsp.fight.event.PVCFightEndProcedure;
/*    */ import mzm.gsp.task.conParamObj.PvcParamObj;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.GraphBean;
/*    */ import xbean.TaskDataBean;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2task;
/*    */ 
/*    */ 
/*    */ public class POnPVCFightEnd
/*    */   extends PVCFightEndProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     PVCFightEndArg pvcFightEndArg = (PVCFightEndArg)this.arg;
/* 26 */     if (!pvcFightEndArg.isActiveWin)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (!(pvcFightEndArg.context instanceof TaskPvcContext))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     TaskPvcContext context = (TaskPvcContext)pvcFightEndArg.context;
/*    */     
/* 38 */     PvcParamObj obj = new PvcParamObj();
/* 39 */     obj.setTaskUseId(context.getTaskUseId());
/* 40 */     obj.getTargetRoleIds().addAll(((PVCFightEndArg)this.arg).passiveRoleList);
/* 41 */     Map<Integer, Object> params = new HashMap();
/* 42 */     params.put(Integer.valueOf(6), obj);
/*    */     
/* 44 */     Set<Long> allRole = new HashSet();
/* 45 */     Set<Long> allNoEcapedRoles = new HashSet();
/*    */     
/* 47 */     allNoEcapedRoles.addAll(pvcFightEndArg.activeAlivedRoles);
/* 48 */     allNoEcapedRoles.addAll(pvcFightEndArg.activeDeadRoles);
/* 49 */     allRole.addAll(pvcFightEndArg.activeEscapedRoles);
/* 50 */     allRole.addAll(allNoEcapedRoles);
/*    */     
/*    */ 
/* 53 */     long leaderId = TeamInterface.getTeamLeaderByRoleid(((Long)new ArrayList(allNoEcapedRoles).get(0)).longValue(), false, false);
/* 54 */     if (leaderId <= 0L)
/*    */     {
/* 56 */       leaderId = ((Long)new ArrayList(allNoEcapedRoles).get(0)).longValue();
/*    */     }
/*    */     
/* 59 */     Lockeys.lock(Role2task.getTable(), allRole);
/*    */     
/* 61 */     List<Long> noEcapedTeamList = new ArrayList();
/* 62 */     List<Long> tempList = new ArrayList();
/* 63 */     tempList.addAll(pvcFightEndArg.activeRoleList);
/* 64 */     tempList.removeAll(pvcFightEndArg.activeEscapedRoles);
/* 65 */     if (leaderId > 0L)
/*    */     {
/* 67 */       tempList.remove(Long.valueOf(leaderId));
/* 68 */       noEcapedTeamList.add(Long.valueOf(leaderId));
/*    */     }
/* 70 */     noEcapedTeamList.addAll(tempList);
/*    */     
/* 72 */     for (Long roleId : allRole)
/*    */     {
/* 74 */       RoleTask roleTask = RoleTaskManager.getRoleTask(roleId.longValue(), true);
/* 75 */       if (roleTask.getTaskDataBean() != null)
/*    */       {
/*    */ 
/*    */ 
/* 79 */         List<GraphBean> graphBeans = new ArrayList(roleTask.getTaskDataBean().getGraphbeans().values());
/* 80 */         for (int i = 0; i < graphBeans.size(); i++)
/*    */         {
/* 82 */           GraphBean graphBean = (GraphBean)graphBeans.get(i);
/* 83 */           RoleTaskManager.graphBeanProc(null, leaderId, noEcapedTeamList, params, roleId, graphBean);
/*    */         }
/*    */       } }
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnPVCFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */