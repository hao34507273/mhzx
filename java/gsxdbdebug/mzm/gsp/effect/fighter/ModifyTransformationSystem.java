/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import xbean.FighterModelCard;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModifyTransformationSystem
/*    */   extends FighterEffect
/*    */ {
/*    */   private int mask;
/*    */   private int level;
/*    */   private static final int CARD_TYPECLASS_COUNT = 6;
/*    */   
/*    */   public ModifyTransformationSystem(int mask, int level)
/*    */   {
/* 24 */     this.mask = mask;
/* 25 */     this.level = level;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 31 */     int cardClassType = this.mask;
/* 32 */     if (this.mask < 0)
/*    */     {
/* 34 */       cardClassType = Xdb.random().nextInt(6) + 1;
/*    */     }
/*    */     
/* 37 */     fighter.getChangeModelCard().setTmpclassindex(cardClassType);
/* 38 */     fighter.getChangeModelCard().setTmplevel(this.level);
/* 39 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 45 */     fighter.getChangeModelCard().setTmpclassindex(-1);
/* 46 */     fighter.getChangeModelCard().setTmplevel(0);
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyTransformationSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */