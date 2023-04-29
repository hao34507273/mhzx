/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ class CloseFightProcedure extends LogicProcedure
/*    */ {
/*    */   private long fightid;
/*    */   
/*    */   public CloseFightProcedure(long fightid)
/*    */   {
/* 13 */     this.fightid = fightid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     Fight fight = FightManager.getFight(this.fightid);
/* 19 */     if (fight == null) {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     Set<Long> lockRoles = fight.getLockRoles();
/* 24 */     lock(Basic.getTable(), lockRoles);
/*    */     
/* 26 */     fight.fightEndOnForceEnd(104);
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\CloseFightProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */