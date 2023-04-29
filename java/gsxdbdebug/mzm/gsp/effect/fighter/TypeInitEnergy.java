/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class TypeInitEnergy
/*    */   extends FighterEffect
/*    */ {
/*    */   private int pvpenergy;
/*    */   private int pveenergy;
/*    */   
/*    */   public TypeInitEnergy(int paramInt1, int paramInt2)
/*    */   {
/* 14 */     this.pvpenergy = paramInt1;
/* 15 */     this.pveenergy = paramInt2;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 20 */     if (paramFighter.isPVE()) {
/* 21 */       paramFighter.addEnergy(this.pveenergy);
/* 22 */     } else if (paramFighter.isPVP()) {
/* 23 */       paramFighter.addEnergy(this.pvpenergy);
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\TypeInitEnergy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */