/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class PStartMenpaiPVPFight extends LogicProcedure
/*    */ {
/*    */   private final long r1;
/*    */   private final long r2;
/*    */   
/*    */   PStartMenpaiPVPFight(long r1, long r2)
/*    */   {
/* 14 */     this.r1 = r1;
/* 15 */     this.r2 = r2;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     FightInterface.startPVPFight(this.r1, this.r2, new MenpaiPVPFightContext(), 6, FightReason.MENPAI_PVP_FIGHT);
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\PStartMenpaiPVPFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */