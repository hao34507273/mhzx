/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ public class ModifyHPRate
/*    */   extends OutFightEffect
/*    */   implements ActionEffect
/*    */ {
/*    */   private int modifyRate;
/*    */   
/*    */   public ModifyHPRate(int modifyRate)
/*    */   {
/* 15 */     this.modifyRate = modifyRate;
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
/* 30 */     int maxHP = object.getFinalMaxHP();
/* 31 */     int newHP = maxHP * this.modifyRate / 10000;
/* 32 */     newHP = Math.min(newHP, maxHP);
/* 33 */     object.setHP(newHP);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ModifyHPRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */