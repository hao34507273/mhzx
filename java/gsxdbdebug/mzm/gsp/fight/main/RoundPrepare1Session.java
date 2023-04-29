/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xtable.Basic;
/*    */ 
/*    */ class RoundPrepare1Session extends FightSession
/*    */ {
/*    */   RoundPrepare1Session(long fightid, int interval)
/*    */   {
/* 10 */     super(fightid, interval);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 15 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 19 */         Fight fight = FightManager.getFight(RoundPrepare1Session.this.getFightid());
/* 20 */         if (fight == null) {
/* 21 */           return false;
/*    */         }
/*    */         
/* 24 */         Set<Long> lockRoles = fight.getLockRoles();
/* 25 */         lock(Basic.getTable(), lockRoles);
/*    */         
/* 27 */         fight.onRoundPrapare2();
/*    */         
/* 29 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RoundPrepare1Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */