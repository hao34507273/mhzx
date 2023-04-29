/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.item.event.EquipQiLinProcedure;
/*    */ import mzm.gsp.item.main.EquipQiLinArg;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnEquipQiLin
/*    */   extends EquipQiLinProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (((EquipQiLinArg)this.arg).bagid != 340600001)
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     Long teamid = Role2team.select(Long.valueOf(((EquipQiLinArg)this.arg).roleid));
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
/* 34 */     TeamManager.synModelChange(xTeam, ((EquipQiLinArg)this.arg).roleid);
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnEquipQiLin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */