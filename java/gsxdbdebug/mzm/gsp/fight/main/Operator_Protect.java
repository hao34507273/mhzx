/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.OpProtect;
/*    */ 
/*    */ class Operator_Protect extends FighterAIOperator {
/*    */   private int fid;
/*    */   private int tfid;
/*    */   
/*  9 */   Operator_Protect(int fid, int tfid) { super(true);
/* 10 */     this.fid = fid;
/* 11 */     this.tfid = tfid;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 16 */     if (fight.hasFightCmd(this.fid)) {
/* 17 */       return;
/*    */     }
/* 19 */     OpProtect protect = new OpProtect();
/* 20 */     protect.target = this.tfid;
/* 21 */     fight.addFightCmd(this.fid, 3, protect);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_Protect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */