/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.SMemberModelChangedBrd;
/*    */ import mzm.gsp.wing.event.WingModelChangedArg;
/*    */ import mzm.gsp.wing.event.WingModelChangedEventProcedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnWingChangedEvent
/*    */   extends WingModelChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     long roleId = ((WingModelChangedArg)this.arg).getRoleId();
/*    */     
/* 20 */     Long teamid = Role2team.select(Long.valueOf(roleId));
/* 21 */     if (teamid == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 26 */     if (xTeam == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     SMemberModelChangedBrd sMemberModelChangedBrd = new SMemberModelChangedBrd();
/* 32 */     sMemberModelChangedBrd.roleid = roleId;
/* 33 */     RoleInterface.fillModelInfo(roleId, sMemberModelChangedBrd.model);
/* 34 */     TeamManager.broadcast(xTeam, sMemberModelChangedBrd);
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnWingChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */