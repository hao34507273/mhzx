/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.Play;
/*    */ 
/*    */ class Operator_ChangeFightMap extends FighterAIOperator {
/*    */   private int mapResource;
/*    */   
/*  8 */   Operator_ChangeFightMap(int mapResource) { super(false);
/*  9 */     this.mapResource = mapResource;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 14 */     ExcuteCmdResult excuteCmdResult = new ExcuteCmdResult();
/* 15 */     Play play = new Play();
/* 16 */     fight.fillPlayChangeFightMap(play, this.mapResource);
/* 17 */     excuteCmdResult.addPlay(play, false);
/* 18 */     excuteCmdResult.addPlay(play, true);
/* 19 */     if (fight.isRecordEnable()) {
/* 20 */       excuteCmdResult.addPlay(play);
/*    */     }
/* 22 */     fight.addCmdResult(excuteCmdResult);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_ChangeFightMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */