/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddQiLingRateEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int addQiLingRate;
/*    */   
/*    */   public AddQiLingRateEffect(int addQiLingRate)
/*    */   {
/* 16 */     this.addQiLingRate = addQiLingRate;
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
/*    */   public int getAddQiLingRate()
/*    */   {
/* 32 */     return this.addQiLingRate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\AddQiLingRateEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */