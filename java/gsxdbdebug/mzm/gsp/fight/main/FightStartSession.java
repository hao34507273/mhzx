/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ class FightStartSession
/*    */   extends FightSession
/*    */ {
/*    */   public FightStartSession(long fightid, int interval)
/*    */   {
/* 15 */     super(fightid, interval);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 20 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 24 */         Fight fight = FightManager.getFight(FightStartSession.this.getFightid());
/* 25 */         if (fight == null) {
/* 26 */           return false;
/*    */         }
/*    */         
/* 29 */         Set<Long> lockRoles = fight.getLockRoles();
/* 30 */         lock(Basic.getTable(), lockRoles);
/*    */         
/* 32 */         fight.onNextRound();
/*    */         
/* 34 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightStartSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */