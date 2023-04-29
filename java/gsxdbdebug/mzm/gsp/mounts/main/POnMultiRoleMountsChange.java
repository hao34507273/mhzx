/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import mzm.gsp.mounts.SSyncRolesOnMultiRoleMounts;
/*    */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg;
/*    */ import mzm.gsp.mounts.event.MultiRoleMountsChangeProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class POnMultiRoleMountsChange extends MultiRoleMountsChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 12 */     SSyncRolesOnMultiRoleMounts protocol = MultiRoleMountsManager.getRolesOnMultiRoleProto(((MultiRoleMountsChangeArg)this.arg).teamId, ((MultiRoleMountsChangeArg)this.arg).mountsCfgId, ((MultiRoleMountsChangeArg)this.arg).roleIds);
/*    */     
/* 14 */     TeamInterface.broadcastInTeam(((MultiRoleMountsChangeArg)this.arg).teamId, protocol);
/*    */     
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnMultiRoleMountsChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */