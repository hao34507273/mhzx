/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.SMemberNameChangedBrd;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleRename
/*    */   extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     Long teamid = Role2team.select((Long)this.arg);
/* 20 */     if (teamid == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 25 */     if (xTeam == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     SMemberNameChangedBrd sMemberNameChangedBrd = new SMemberNameChangedBrd();
/* 30 */     sMemberNameChangedBrd.roleid = ((Long)this.arg).longValue();
/* 31 */     sMemberNameChangedBrd.name = RoleInterface.getName(((Long)this.arg).longValue());
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */