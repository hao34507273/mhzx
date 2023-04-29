/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.SMemberModelChangedBrd;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ public class POnRoleWuShiAppearanceChanged
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public POnRoleWuShiAppearanceChanged(long roleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     Long teamid = Role2team.select(Long.valueOf(this.roleId));
/* 24 */     if (teamid == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 29 */     if (xTeam == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     SMemberModelChangedBrd memberModelChangedBrd = new SMemberModelChangedBrd();
/* 35 */     memberModelChangedBrd.roleid = this.roleId;
/* 36 */     RoleInterface.fillModelInfo(this.roleId, memberModelChangedBrd.model);
/* 37 */     TeamManager.broadcast(xTeam, memberModelChangedBrd);
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleWuShiAppearanceChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */