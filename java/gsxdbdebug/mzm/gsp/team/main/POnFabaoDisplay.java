/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.fabao.event.FabaoDisplayArg;
/*    */ import mzm.gsp.fabao.event.FabaoDisplayProcedure;
/*    */ import mzm.gsp.team.SMemberModelChangedBrd;
/*    */ 
/*    */ public class POnFabaoDisplay extends FabaoDisplayProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     Long teamid = xtable.Role2team.select(Long.valueOf(((FabaoDisplayArg)this.arg).roleid));
/* 12 */     if (teamid == null)
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 17 */     if (xTeam == null)
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     SMemberModelChangedBrd sMemberModelChangedBrd = new SMemberModelChangedBrd();
/* 23 */     sMemberModelChangedBrd.roleid = ((FabaoDisplayArg)this.arg).roleid;
/* 24 */     mzm.gsp.role.main.RoleInterface.fillModelInfo(((FabaoDisplayArg)this.arg).roleid, sMemberModelChangedBrd.model);
/* 25 */     TeamManager.broadcast(xTeam, sMemberModelChangedBrd);
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnFabaoDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */