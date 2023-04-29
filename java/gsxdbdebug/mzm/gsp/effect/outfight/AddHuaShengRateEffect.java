/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddHuaShengRateEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int addHuaShengRate;
/*    */   
/*    */   public AddHuaShengRateEffect(int addHuaShengRate)
/*    */   {
/* 16 */     this.addHuaShengRate = addHuaShengRate;
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
/*    */ 
/*    */   public int getAddHuaShengRate()
/*    */   {
/* 33 */     return this.addHuaShengRate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\AddHuaShengRateEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */