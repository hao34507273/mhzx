/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ public class ModifyMP
/*    */   extends OutFightEffect
/*    */   implements ActionEffect
/*    */ {
/*    */   private int addValue;
/*    */   
/*    */   public ModifyMP(int addValue)
/*    */   {
/* 15 */     this.addValue = addValue;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 20 */     return false;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 25 */     return false;
/*    */   }
/*    */   
/*    */   public boolean cast(IOutFightObject object)
/*    */   {
/* 30 */     int maxMP = object.getFinalMaxMP();
/* 31 */     int newMP = object.getMP() + this.addValue;
/* 32 */     newMP = Math.min(newMP, maxMP);
/* 33 */     object.setMP(newMP);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ModifyMP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */