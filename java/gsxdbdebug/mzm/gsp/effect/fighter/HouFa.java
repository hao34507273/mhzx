/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.fighter.Interface.Validate;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.confbean.SSkillCfg;
/*    */ 
/*    */ public class HouFa extends FighterEffect implements Validate
/*    */ {
/*    */   private int addatkrate;
/*    */   private int addphydefrate;
/*    */   private int addmagdefrate;
/*    */   private int skillid;
/*    */   
/*    */   public HouFa(int addatkrate, int addphydefrate, int addmagdefrate, int skillid)
/*    */   {
/* 19 */     this.addatkrate = addatkrate;
/* 20 */     this.addphydefrate = addphydefrate;
/* 21 */     this.addmagdefrate = addmagdefrate;
/* 22 */     this.skillid = skillid;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 27 */     fighter.addPHYATKHITRate(this.addatkrate);
/* 28 */     fighter.addMAGATKRate(this.addatkrate);
/* 29 */     fighter.addPHYDEFRate(this.addphydefrate);
/* 30 */     fighter.addMAGDEFRate(this.addmagdefrate);
/* 31 */     fighter.addBuffState(105);
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 37 */     fighter.addPHYATKHITRate(-this.addatkrate);
/* 38 */     fighter.addMAGATKRate(-this.addatkrate);
/* 39 */     fighter.addPHYDEFRate(-this.addphydefrate);
/* 40 */     fighter.addMAGDEFRate(-this.addmagdefrate);
/* 41 */     fighter.remBuffState(105);
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getskillid()
/*    */   {
/* 51 */     if (SSkillCfg.get(this.skillid) == null) {
/* 52 */       GameServer.logger().error("后发技能的技能的技能id不存在:skillid:" + this.skillid);
/* 53 */       return SFightConsts.getInstance().ATTACK_SKILL;
/*    */     }
/* 55 */     return this.skillid;
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 60 */     if (SSkillCfg.get(this.skillid) == null) {
/* 61 */       throw new RuntimeException("HouFa效果的技能id不存在:skillid:" + this.skillid);
/*    */     }
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HouFa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */