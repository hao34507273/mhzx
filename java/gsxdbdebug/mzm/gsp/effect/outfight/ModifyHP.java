/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModifyHP
/*    */   extends OutFightEffect
/*    */   implements ActionEffect
/*    */ {
/*    */   private int addValue;
/*    */   
/*    */   public ModifyHP(int addValue)
/*    */   {
/* 16 */     this.addValue = addValue;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 21 */     return false;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 26 */     return false;
/*    */   }
/*    */   
/*    */   public boolean cast(IOutFightObject object)
/*    */   {
/* 31 */     int maxHP = object.getFinalMaxHP();
/* 32 */     int newHP = object.getHP() + this.addValue;
/* 33 */     newHP = Math.min(newHP, maxHP);
/* 34 */     object.setHP(newHP);
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ModifyHP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */