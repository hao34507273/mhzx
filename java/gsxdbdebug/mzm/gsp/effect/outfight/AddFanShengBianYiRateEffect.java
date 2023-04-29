/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddFanShengBianYiRateEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int addFanShengBianYiRate;
/*    */   
/*    */   public AddFanShengBianYiRateEffect(int addFanShengBianYiRate)
/*    */   {
/* 16 */     this.addFanShengBianYiRate = addFanShengBianYiRate;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target) {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target) {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getAddFanShengBianYiRate()
/*    */   {
/* 32 */     return this.addFanShengBianYiRate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\AddFanShengBianYiRateEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */