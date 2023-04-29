/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import xbean.Fighter;
/*    */ 
/*    */ final class FighterNpcMonster extends FighterMonster
/*    */ {
/*    */   FighterNpcMonster(int fighterid, Fighter xFighter, FightGroup fightGroup) {
/*  8 */     super(fighterid, xFighter, fightGroup);
/*  9 */     setNpcMonster();
/*    */   }
/*    */   
/*    */   protected void onDead()
/*    */   {
/* 14 */     setFakeDead();
/* 15 */     super.onFighterDead();
/*    */   }
/*    */   
/*    */   protected void setDead()
/*    */   {
/* 20 */     super.setFakeDead();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FighterNpcMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */