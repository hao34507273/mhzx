/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModifyPetLife
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int petlife;
/*    */   
/*    */   public ModifyPetLife(int petlife)
/*    */   {
/* 16 */     this.petlife = petlife;
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ModifyPetLife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */