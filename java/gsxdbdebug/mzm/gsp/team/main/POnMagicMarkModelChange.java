/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.magicmark.event.MagicMarkModelChangeEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.SMemberModelChangedBrd;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ public class POnMagicMarkModelChange extends MagicMarkModelChangeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     Long teamid = Role2team.select((Long)this.arg);
/* 13 */     if (teamid == null)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 18 */     if (xTeam == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     SMemberModelChangedBrd sMemberModelChangedBrd = new SMemberModelChangedBrd();
/* 24 */     sMemberModelChangedBrd.roleid = ((Long)this.arg).longValue();
/* 25 */     RoleInterface.fillModelInfo(((Long)this.arg).longValue(), sMemberModelChangedBrd.model);
/* 26 */     TeamManager.broadcast(xTeam, sMemberModelChangedBrd);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnMagicMarkModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */