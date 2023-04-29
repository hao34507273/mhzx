/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVIMonsterFightStartArg;
/*    */ import mzm.gsp.fight.event.PVIMonsterFightStartProcedure;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ 
/*    */ public class POnPVIMonsterFightStart extends PVIMonsterFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     mzm.gsp.fight.main.FightContext fightContext = ((PVIMonsterFightStartArg)this.arg).context;
/* 12 */     if ((fightContext == null) || (!(fightContext instanceof PVEBossFightContex)))
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     PVEBossFightContex pveBossFightContex = (PVEBossFightContex)fightContext;
/* 17 */     if (pveBossFightContex.getFightReson().value != FightReason.BIG_BOSS_ACTIVITY_FIGHT.value)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     BigBossFightManager.getInstance().onFightStart(((PVIMonsterFightStartArg)this.arg).fightid);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\POnPVIMonsterFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */