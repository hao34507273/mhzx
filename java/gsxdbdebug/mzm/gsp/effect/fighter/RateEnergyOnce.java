/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class RateEnergyOnce
/*    */   extends FighterEffect implements OpOnce
/*    */ {
/*    */   private int energy;
/*    */   private int addrate;
/*    */   
/*    */   public RateEnergyOnce(int paramInt1, int paramInt2)
/*    */   {
/* 20 */     this.energy = paramInt1;
/* 21 */     this.addrate = paramInt2;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*    */   {
/* 26 */     int i = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 27 */     if (this.addrate < i) {
/* 28 */       return true;
/*    */     }
/*    */     
/* 31 */     paramFighter2.addEnergy(this.energy);
/*    */     
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RateEnergyOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */