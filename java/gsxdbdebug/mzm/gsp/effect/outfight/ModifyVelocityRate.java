/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModifyVelocityRate
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int velocityRate;
/*    */   
/*    */   public ModifyVelocityRate(int velocityRate)
/*    */   {
/* 16 */     this.velocityRate = velocityRate;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 22 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ModifyVelocityRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */