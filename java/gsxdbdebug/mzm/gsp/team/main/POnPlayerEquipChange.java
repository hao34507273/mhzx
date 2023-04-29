/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.item.event.PlayerEquipChangeProcedure;
/*    */ import mzm.gsp.item.main.EquipChangeArg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnPlayerEquipChange
/*    */   extends PlayerEquipChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     int equipMinLingLevel = ItemInterface.getWholeBodyMinQilinLevel(((EquipChangeArg)this.arg).roleId, false);
/* 19 */     if (equipMinLingLevel < 0)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 25 */     Long teamid = Role2team.select(Long.valueOf(((EquipChangeArg)this.arg).roleId));
/* 26 */     if (teamid == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 31 */     if (xTeam == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     TeamManager.synModelChange(xTeam, ((EquipChangeArg)this.arg).roleId);
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnPlayerEquipChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */