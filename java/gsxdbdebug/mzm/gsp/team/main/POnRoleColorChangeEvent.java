/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleColorChangeEventProcedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleColorChangeEvent
/*    */   extends RoleColorChangeEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     Long teamid = Role2team.select((Long)this.arg);
/* 16 */     if (teamid == null)
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 21 */     if (xTeam == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     TeamManager.synModelChange(xTeam, ((Long)this.arg).longValue());
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleColorChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */