/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2instance;
/*    */ import xtable.Team;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnTaskStateChange extends mzm.gsp.task.event.TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     int graphid = ((TaskEventArg)this.arg).graphId;
/* 20 */     int taskid = ((TaskEventArg)this.arg).taskId;
/* 21 */     long roleid = ((TaskEventArg)this.arg).roleId;
/* 22 */     if (((TaskEventArg)this.arg).taskState == 8) {
/* 23 */       int instanceid = InstanceCfgManager.getInstanceidByGraphid(graphid);
/* 24 */       if (instanceid < 0) {
/* 25 */         return false;
/*    */       }
/* 27 */       SInstanceCfg instanceCfg = SInstanceCfg.get(instanceid);
/* 28 */       switch (instanceCfg.instanceType)
/*    */       {
/*    */       case 2: 
/* 31 */         String userid = RoleInterface.getUserId(roleid);
/* 32 */         Long teamid = TeamInterface.getTeamidByRoleid(roleid, false);
/* 33 */         if (teamid != null) {
/* 34 */           List<Long> teamRoleids = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/* 35 */           if (teamRoleids.size() > 0)
/*    */           {
/* 37 */             Set<String> allUsers = new java.util.HashSet();
/* 38 */             allUsers.add(userid);
/* 39 */             for (Long tmpRoleId : teamRoleids) {
/* 40 */               String tempUserid = RoleInterface.getUserId(tmpRoleId.longValue());
/* 41 */               allUsers.add(tempUserid);
/*    */             }
/*    */             
/* 44 */             lock(User.getTable(), allUsers);
/* 45 */             if (!teamRoleids.contains(Long.valueOf(roleid))) {
/* 46 */               teamRoleids.add(Long.valueOf(roleid));
/*    */             }
/* 48 */             lock(Role2instance.getTable(), teamRoleids);
/*    */             
/*    */ 
/* 51 */             lock(Team.getTable(), java.util.Arrays.asList(new Long[] { teamid }));
/*    */           }
/*    */         }
/*    */         
/*    */ 
/* 56 */         lock(Lockeys.get(User.getTable(), userid));
/*    */         
/*    */ 
/* 59 */         Long instanceUuid = xtable.Role2instanceuuid.get(Long.valueOf(roleid));
/* 60 */         if (instanceUuid == null) {
/* 61 */           return false;
/*    */         }
/* 63 */         xbean.InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(roleid));
/*    */         
/* 65 */         InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/* 66 */         return TeamInstance.onTaskFinish(graphid, taskid, userid, roleid, instanceid, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*    */       }
/*    */       
/*    */     }
/*    */     
/*    */ 
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */