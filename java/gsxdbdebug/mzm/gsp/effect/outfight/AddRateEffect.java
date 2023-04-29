/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddRateEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int propType;
/*    */   private int addRate;
/*    */   
/*    */   public AddRateEffect(int propType, int addRate)
/*    */   {
/* 16 */     this.propType = propType;
/* 17 */     this.addRate = addRate;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target) {
/* 21 */     target.addPropertyValue(this.propType, this.addRate);
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target) {
/* 26 */     target.addPropertyValue(this.propType, -this.addRate);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\AddRateEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */