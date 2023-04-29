/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.fashiondress.event.FashionDressModelArg;
/*    */ import mzm.gsp.fashiondress.event.FashionDressModelChangeProcedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ public class POnRoleFashionDressModelChange
/*    */   extends FashionDressModelChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     Long teamid = Role2team.select(Long.valueOf(((FashionDressModelArg)this.arg).roleId));
/* 15 */     if (teamid == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 20 */     if (xTeam == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     TeamManager.synModelChange(xTeam, ((FashionDressModelArg)this.arg).roleId);
/*    */     
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleFashionDressModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */