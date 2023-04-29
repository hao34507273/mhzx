/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*    */ import mzm.gsp.mounts.event.RideMountsModelChangeProcedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRideMountsModelChange
/*    */   extends RideMountsModelChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     Long teamid = Role2team.select(Long.valueOf(((RideMountsModelChangeArg)this.arg).getRoleId()));
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
/* 26 */     TeamManager.synModelChange(xTeam, ((RideMountsModelChangeArg)this.arg).getRoleId());
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRideMountsModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */