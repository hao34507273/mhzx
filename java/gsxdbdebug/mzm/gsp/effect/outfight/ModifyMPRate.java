/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ public class ModifyMPRate
/*    */   extends OutFightEffect
/*    */   implements ActionEffect
/*    */ {
/*    */   private int modifyRate;
/*    */   
/*    */   public ModifyMPRate(int modifyRate)
/*    */   {
/* 15 */     this.modifyRate = modifyRate;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target) {
/* 19 */     return false;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 24 */     return false;
/*    */   }
/*    */   
/*    */   public boolean cast(IOutFightObject object)
/*    */   {
/* 29 */     int maxMP = object.getFinalMaxMP();
/* 30 */     int newMP = maxMP * this.modifyRate / 10000;
/* 31 */     newMP = Math.min(newMP, maxMP);
/* 32 */     object.setMP(newMP);
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ModifyMPRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */