/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.map.main.message.MMH_JoinTeamMsg;
/*    */ import mzm.gsp.mounts.main.MountsInterface;
/*    */ import mzm.gsp.mounts.main.MultiRoleMountsInfo;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamProcedure;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ 
/*    */ public class POnJoinTeam extends JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if (((JoinTeamArg)this.arg).member.status != 0)
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     MultiRoleMountsInfo multiMountsInfo = MountsInterface.getMultiRoleMountsInfo(((JoinTeamArg)this.arg).teamid, false);
/*    */     
/* 23 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(((JoinTeamArg)this.arg).leaderid), Long.valueOf(((JoinTeamArg)this.arg).member.roleid) }));
/*    */     
/* 25 */     boolean fly = RoleStatusInterface.containsStatus(((JoinTeamArg)this.arg).leaderid, 2);
/* 26 */     if (fly)
/*    */     {
/*    */ 
/* 29 */       RoleStatusInterface.setStatus(((JoinTeamArg)this.arg).member.roleid, 2, false);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 34 */       RoleStatusInterface.unsetStatus(((JoinTeamArg)this.arg).member.roleid, 2);
/*    */     }
/*    */     
/* 37 */     if (multiMountsInfo == null)
/*    */     {
/* 39 */       new MMH_JoinTeamMsg(((JoinTeamArg)this.arg).teamid, ((JoinTeamArg)this.arg).member.roleid).execute();
/*    */     }
/*    */     else
/*    */     {
/* 43 */       new MMH_JoinTeamMsg(((JoinTeamArg)this.arg).teamid, ((JoinTeamArg)this.arg).member.roleid, multiMountsInfo.mountsCfgId, multiMountsInfo.roleIds).execute();
/*    */     }
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */