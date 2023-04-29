/*    */ package mzm.gsp.gangrace.main.game;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ public class RaceBaseAction
/*    */ {
/*    */   private static final int ACTIONCODE_NOACTION = 0;
/* 10 */   private static Random rand = new Random();
/*    */   private final int actionCode;
/*    */   private final int moveStep;
/*    */   private final int minRound;
/*    */   private final int maxRound;
/*    */   
/*    */   public RaceBaseAction(int _actionCode, int _moveStep, int _minRound, int _maxRound)
/*    */   {
/* 18 */     this.actionCode = _actionCode;
/* 19 */     this.moveStep = _moveStep;
/* 20 */     this.minRound = _minRound;
/* 21 */     this.maxRound = _maxRound;
/*    */   }
/*    */   
/*    */   public void action(ArrayList<RaceObj.ActionInfo> _actionList, int _curStep) {
/* 25 */     if (_curStep >= 320) {
/* 26 */       RaceObj.ActionInfo actionInfo = new RaceObj.ActionInfo(0, 500);
/* 27 */       _actionList.add(actionInfo);
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     RaceObj.ActionInfo actionInfo = new RaceObj.ActionInfo(this.actionCode, this.moveStep);
/* 32 */     _actionList.add(actionInfo);
/*    */     
/* 34 */     int roundCount = this.maxRound > this.minRound ? rand.nextInt(this.maxRound - this.minRound) + this.minRound : this.maxRound;
/* 35 */     if (roundCount <= 1)
/* 36 */       return;
/* 37 */     actionInfo = new RaceObj.ActionInfo(0, this.moveStep);
/* 38 */     for (int i = 1; i < roundCount; i++) {
/* 39 */       if (_curStep + i * this.moveStep >= 320)
/*    */         break;
/* 41 */       _actionList.add(actionInfo);
/*    */     }
/*    */   }
/*    */   
/*    */   public int getActionCode() {
/* 46 */     return this.actionCode;
/*    */   }
/*    */   
/*    */   public int getMoveStep() {
/* 50 */     return this.moveStep;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\game\RaceBaseAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */