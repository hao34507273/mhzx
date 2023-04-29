/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ 
/*    */ class RoundPrapare2Session extends FightSession
/*    */ {
/*    */   RoundPrapare2Session(long fightid, int interval)
/*    */   {
/* 11 */     super(fightid, interval);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 16 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 20 */         if (GameServer.logger().isDebugEnabled()) {
/* 21 */           GameServer.logger().debug("第二阶段的执行时间是:time:" + mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */         }
/* 23 */         Fight fight = FightManager.getFight(RoundPrapare2Session.this.getFightid());
/* 24 */         if (fight == null) {
/* 25 */           return false;
/*    */         }
/*    */         
/* 28 */         java.util.Set<Long> lockRoles = fight.getLockRoles();
/* 29 */         lock(Basic.getTable(), lockRoles);
/*    */         
/* 31 */         fight.clearRoundPrapare2Data();
/*    */         
/* 33 */         fight.onPlayBefore();
/*    */         
/* 35 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RoundPrapare2Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */