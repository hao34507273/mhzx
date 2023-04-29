/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.SMemberLevelChangedBrd;
/*    */ import xbean.Team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     Team xTeam = TeamManager.getXTeamByRoleid(((RoleLevelUpArg)this.arg).roleId, false);
/* 20 */     if (xTeam == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     int level = RoleInterface.getLevel(((RoleLevelUpArg)this.arg).roleId);
/*    */     
/* 27 */     SMemberLevelChangedBrd brd = new SMemberLevelChangedBrd();
/* 28 */     brd.member = ((RoleLevelUpArg)this.arg).roleId;
/* 29 */     brd.level = level;
/* 30 */     TeamManager.broadcast(xTeam, brd);
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */