/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class ModifyHpMax extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int modifyhpmax;
/*    */   
/*    */   public ModifyHpMax(int modifyhpmax)
/*    */   {
/* 12 */     this.modifyhpmax = modifyhpmax;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 17 */     fighter.addMaxFixHp(this.modifyhpmax);
/*    */     
/* 19 */     if (getGroup() != null) {
/* 20 */       Skill skill = getGroup().getSkill();
/* 21 */       if (skill != null) {
/* 22 */         skill.updateBuffHp(fighter);
/*    */       }
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 30 */     fighter.addMaxFixHp(-this.modifyhpmax);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyHpMax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */