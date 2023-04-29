/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fight.OpSummonMonster;
/*    */ 
/*    */ class Operator_SummonMonsterFixPosition extends FighterAIOperator
/*    */ {
/*    */   private int fid;
/*    */   private boolean sameSide;
/*    */   private int level;
/*    */   private Map<Integer, List<Integer>> monsteridToPositionsMap;
/*    */   private boolean immidiately;
/*    */   
/*    */   Operator_SummonMonsterFixPosition(int fid, boolean sameSide, int level, Map<Integer, List<Integer>> monsteridToPositionsMap, boolean immidiately)
/*    */   {
/* 18 */     super(!immidiately);
/* 19 */     this.fid = fid;
/* 20 */     this.sameSide = sameSide;
/* 21 */     this.level = level;
/* 22 */     this.monsteridToPositionsMap = monsteridToPositionsMap;
/* 23 */     this.immidiately = immidiately;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 28 */     Fighter fighter = fight.getFighter(this.fid);
/* 29 */     if ((fighter == null) || (fighter.isFakeDead()) || (fighter.isDead())) {
/* 30 */       return;
/*    */     }
/* 32 */     if ((this.monsteridToPositionsMap == null) || (this.monsteridToPositionsMap.size() <= 0)) {
/* 33 */       return;
/*    */     }
/* 35 */     OpSummonMonster opSummonMonster = new OpSummonMonster();
/* 36 */     if (this.sameSide) {
/* 37 */       opSummonMonster.sameteam = 0;
/*    */     } else {
/* 39 */       opSummonMonster.sameteam = 1;
/*    */     }
/* 41 */     opSummonMonster.level = this.level;
/* 42 */     for (java.util.Map.Entry<Integer, List<Integer>> entry : this.monsteridToPositionsMap.entrySet()) {
/* 43 */       monsterid = ((Integer)entry.getKey()).intValue();
/* 44 */       List<Integer> positionsList = (List)entry.getValue();
/* 45 */       for (i$ = positionsList.iterator(); i$.hasNext();) { int pos = ((Integer)i$.next()).intValue();
/* 46 */         opSummonMonster.monsterids.add(Integer.valueOf(monsterid));
/* 47 */         opSummonMonster.positions.add(Integer.valueOf(pos)); } }
/*    */     int monsterid;
/*    */     Iterator i$;
/* 50 */     if (this.immidiately) {
/* 51 */       ExcuteCmdResult excuteCmdResult = new ExcuteCmdResult();
/* 52 */       fighter.excuteOpSummonMonster(opSummonMonster, excuteCmdResult);
/* 53 */       fight.addCmdResult(excuteCmdResult);
/*    */     } else {
/* 55 */       fight.addFightCmd(this.fid, 7, opSummonMonster);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_SummonMonsterFixPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */