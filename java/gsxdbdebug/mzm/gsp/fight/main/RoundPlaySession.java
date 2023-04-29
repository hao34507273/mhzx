/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ 
/*    */ class RoundPlaySession extends FightSession
/*    */ {
/*    */   RoundPlaySession(long fightid, int interval)
/*    */   {
/* 13 */     super(fightid, interval);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 18 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 22 */         Fight fight = FightManager.getFight(RoundPlaySession.this.getFightid());
/* 23 */         if (fight == null) {
/* 24 */           return false;
/*    */         }
/* 26 */         if (GameServer.logger().isDebugEnabled()) {
/* 27 */           GameServer.logger().debug("play 完成的执行时间为:" + mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */         }
/* 29 */         java.util.Set<Long> lockRoles = fight.getLockRoles();
/* 30 */         lock(Basic.getTable(), lockRoles);
/*    */         
/* 32 */         int round = fight.getRound();
/* 33 */         if ((!fight.isAllSendRoundEnd()) && (SFightConsts.getInstance().EXTRA_PLAY_TIME_MAX_PER_ROUND > 0)) {
/* 34 */           new MilliSession(SFightConsts.getInstance().EXTRA_PLAY_TIME_MAX_PER_ROUND, RoundPlaySession.this.getFightid())
/*    */           {
/*    */             protected void onTimeOut() {
/* 37 */               xdb.Procedure.execute(new RoundPlaySession.DelayRoundEndProcedure(RoundPlaySession.this, this.val$round));
/*    */             }
/* 39 */           };
/* 40 */           fight.setCurRoundPlayEnd();
/* 41 */           if (GameServer.logger().isDebugEnabled())
/* 42 */             GameServer.logger().debug("客户端没有播完，执行冗余时间!!round:" + round);
/* 43 */           return true;
/*    */         }
/*    */         
/* 46 */         fight.onRoundEnd();
/*    */         
/* 48 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   class DelayRoundEndProcedure extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private int round;
/*    */     
/*    */     public DelayRoundEndProcedure(int round) {
/* 58 */       this.round = round;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 63 */       Fight fight = FightManager.getFight(RoundPlaySession.this.getFightid());
/* 64 */       if (fight == null) {
/* 65 */         return false;
/*    */       }
/* 67 */       if (fight.getRound() != this.round) {
/* 68 */         if (GameServer.logger().isDebugEnabled()) {
/* 69 */           GameServer.logger().debug("冗余时间timer到时，但是回合已经执行了 curRound:" + fight.getRound() + " 已经执行的round:" + this.round);
/*    */         }
/* 71 */         return false;
/*    */       }
/*    */       
/* 74 */       java.util.Set<Long> lockRoles = fight.getLockRoles();
/*    */       
/* 76 */       lock(Basic.getTable(), lockRoles);
/*    */       
/* 78 */       fight.onRoundEnd();
/*    */       
/* 80 */       if (GameServer.logger().isDebugEnabled()) {
/* 81 */         GameServer.logger().debug("冗余时间timer到时,执行回合round:" + this.round);
/*    */       }
/* 83 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RoundPlaySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */