/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipmentLevelVary
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int varyLevel;
/*    */   
/*    */   public EquipmentLevelVary(int varyLevel)
/*    */   {
/* 15 */     this.varyLevel = varyLevel;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target) {
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target) {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getVaryLevel()
/*    */   {
/* 31 */     return this.varyLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\EquipmentLevelVary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */