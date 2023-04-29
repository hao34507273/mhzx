/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModifyCatchPetRate
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int modifyrate;
/*    */   private int propType;
/*    */   
/*    */   public ModifyCatchPetRate(int propType, int modifyrate)
/*    */   {
/* 18 */     this.propType = propType;
/* 19 */     this.modifyrate = modifyrate;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ModifyCatchPetRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */