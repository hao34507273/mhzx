/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.OpCapture;
/*    */ 
/*    */ class Operator_Capture extends FighterAIOperator {
/*    */   private int fid;
/*    */   private int capturedfid;
/*    */   
/*  9 */   Operator_Capture(int fid, int capturedfid) { super(true);
/* 10 */     this.fid = fid;
/* 11 */     this.capturedfid = capturedfid;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 16 */     if (fight.hasFightCmd(this.fid)) {
/* 17 */       return;
/*    */     }
/* 19 */     OpCapture opCapture = new OpCapture();
/* 20 */     opCapture.target = this.capturedfid;
/* 21 */     fight.addFightCmd(this.fid, 2, opCapture);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_Capture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */