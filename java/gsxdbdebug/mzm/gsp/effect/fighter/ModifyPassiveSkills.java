/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.InstallPassiveSkillInit;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPassiveSkills extends FighterEffect implements InstallPassiveSkillInit
/*    */ {
/*    */   private final int skill1;
/*    */   private final int skill2;
/*    */   
/*    */   public ModifyPassiveSkills(int skillOld, int skillNew)
/*    */   {
/* 15 */     this.skill1 = skillOld;
/* 16 */     this.skill2 = skillNew;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 21 */     fighter.getPassiveSkillsReplace().put(Integer.valueOf(this.skill1), Integer.valueOf(this.skill2));
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPassiveSkills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */