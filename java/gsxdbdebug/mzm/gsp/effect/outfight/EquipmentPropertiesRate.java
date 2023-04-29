/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ public class EquipmentPropertiesRate
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int addType;
/*    */   private int addValue;
/*    */   
/*    */   public EquipmentPropertiesRate(int addType, int addValue)
/*    */   {
/* 15 */     this.addType = addType;
/* 16 */     this.addValue = addValue;
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
/*    */   public int getAddType()
/*    */   {
/* 32 */     return this.addType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getAddValue()
/*    */   {
/* 40 */     return this.addValue;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\EquipmentPropertiesRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */