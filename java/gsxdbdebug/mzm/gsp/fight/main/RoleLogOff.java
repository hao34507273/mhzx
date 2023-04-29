/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.SFighterOnlineBrd;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ObserveFight;
/*    */ import xdb.Procedure;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2observefight;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RoleLogOff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   RoleLogOff(long roleid)
/*    */   {
/* 26 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 31 */     Fight fight = FightManager.getFightByRoleid(this.roleid);
/* 32 */     if (fight != null)
/*    */     {
/* 34 */       lock(Basic.getTable(), fight.getLockRoles());
/*    */       
/* 36 */       FightGroupRole fightGroupRole = fight.getActiveTeam().getGroupRole(this.roleid);
/* 37 */       if (fightGroupRole == null) {
/* 38 */         fightGroupRole = fight.getPassiveTeam().getGroupRole(this.roleid);
/*    */       }
/* 40 */       if (fightGroupRole != null) {
/* 41 */         int fighterid = fightGroupRole.getRoleFighterId(this.roleid);
/* 42 */         if (fighterid > 0) {
/* 43 */           SFighterOnlineBrd sFighterOnlineBrd = new SFighterOnlineBrd();
/* 44 */           sFighterOnlineBrd.fighterid = fighterid;
/* 45 */           sFighterOnlineBrd.status = 0;
/* 46 */           fightGroupRole.fightTeam.broadcast(sFighterOnlineBrd);
/*    */         }
/*    */       }
/* 49 */       if (fight.isCurRoundEnd()) {
/* 50 */         fight.onRoleRoundEnd(this.roleid);
/*    */       }
/*    */     }
/*    */     else {
/* 54 */       ObserveFight xObserveFight = Role2observefight.select(Long.valueOf(this.roleid));
/* 55 */       if (xObserveFight != null) {
/* 56 */         Procedure.execute(new PCObserveEndReq(this.roleid));
/*    */       }
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RoleLogOff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */