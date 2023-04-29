/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.role.changemodel.ExteriorReplaceArg;
/*    */ 
/*    */ public class POnRoleExteriorReplace extends mzm.gsp.role.event.RoleExteriorReplaceProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     Long teamid = xtable.Role2team.select(Long.valueOf(((ExteriorReplaceArg)this.arg).getRoleId()));
/* 10 */     if (teamid == null)
/*    */     {
/* 12 */       return false;
/*    */     }
/* 14 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 15 */     if (xTeam == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     TeamManager.synModelChange(xTeam, ((ExteriorReplaceArg)this.arg).getRoleId());
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleExteriorReplace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */