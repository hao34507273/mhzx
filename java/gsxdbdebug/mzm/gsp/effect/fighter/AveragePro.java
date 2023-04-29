/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class AveragePro extends FighterEffect implements OpOnce
/*    */ {
/*    */   private int mask;
/*    */   private static final int HP = 1;
/*    */   private static final int MP = 2;
/*    */   
/*    */   public AveragePro(int mask)
/*    */   {
/* 17 */     this.mask = mask;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 32 */     if ((this.mask & 0x1) > 0) {
/* 33 */       releaser.averageHpRate(target);
/*    */     }
/* 35 */     if ((this.mask & 0x2) > 0) {
/* 36 */       releaser.averageMpRate(target);
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\AveragePro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */