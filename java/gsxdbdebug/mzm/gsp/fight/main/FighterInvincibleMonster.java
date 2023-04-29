/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.handle.AddAngerHandle.OutputObj;
/*    */ 
/*    */ final class FighterInvincibleMonster extends FighterMonster
/*    */ {
/*    */   FighterInvincibleMonster(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*    */   {
/*  9 */     super(fighterid, xFighter, fightGroup);
/* 10 */     setInvincibleMonster();
/*    */   }
/*    */   
/*    */   public int addHp(int value)
/*    */   {
/* 15 */     if (value < 0) {
/* 16 */       double anger = FightFormulaHelp.getAnger(-value, getMaxHp());
/* 17 */       AddAngerHandle.OutputObj outputObj = new AddAngerHandle.OutputObj();
/* 18 */       outputObj.finalAddAnger = anger;
/* 19 */       handleOnAddAnger(outputObj);
/* 20 */       addAnger(outputObj.finalAddAnger);
/*    */     }
/* 22 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FighterInvincibleMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */