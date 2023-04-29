/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVEFightStartArg;
/*    */ import mzm.gsp.fight.event.PVEFightStartProcedure;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class POnPveFightStart
/*    */   extends PVEFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     FightContext fightContext = ((PVEFightStartArg)this.arg).context;
/* 13 */     if (!(fightContext instanceof HulaFightContext))
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     HulaFightManager.getInstance().addFightId(((PVEFightStartArg)this.arg).fightid);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\POnPveFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */