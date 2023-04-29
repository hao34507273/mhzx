/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveProcedure;
/*    */ import xtable.Role2task;
/*    */ 
/*    */ public class POnTeamDissolve extends TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     List<String> userList = new ArrayList();
/* 15 */     List<Long> roleList = new ArrayList(((TeamDissolveArg)this.arg).members);
/* 16 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 18 */       userList.add(mzm.gsp.role.main.RoleInterface.getUserId(tmpRoleId));
/*    */     }
/* 20 */     lock(xtable.User.getTable(), userList);
/* 21 */     lock(Role2task.getTable(), roleList);
/* 22 */     for (Long roleId : roleList)
/*    */     {
/* 24 */       RoleTaskManager.remTeamGraph(roleId.longValue());
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */