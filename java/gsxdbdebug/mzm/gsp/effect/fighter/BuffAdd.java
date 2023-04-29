/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class BuffAdd extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce, mzm.gsp.effect.fighter.Interface.PassiveOnce, mzm.gsp.effect.fighter.Interface.Validate
/*    */ {
/*    */   private int effectid;
/*    */   private int effectrate;
/*    */   
/*    */   public BuffAdd(int effectid, int effectrate)
/*    */   {
/* 21 */     this.effectid = effectid;
/* 22 */     this.effectrate = effectrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 37 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 38 */     if (random > this.effectrate) {
/* 39 */       return true;
/*    */     }
/* 41 */     FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 42 */     if (addGroup != null) {
/* 43 */       addGroup.run(skill, releaser, target, target.getid());
/*    */     } else {
/* 45 */       GameServer.logger().error("不存在的效果组id" + this.effectid);
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Fighter target)
/*    */   {
/* 52 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 53 */     if (random >= this.effectrate) {
/* 54 */       return true;
/*    */     }
/* 56 */     FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 57 */     if (addGroup != null) {
/* 58 */       int level = super.getSkillLevel();
/* 59 */       addGroup.run(level, target, target, target.getid());
/*    */     } else {
/* 61 */       GameServer.logger().error("不存在的效果组id" + this.effectid);
/*    */     }
/* 63 */     return true;
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 68 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 69 */     if (effectGroup == null) {
/* 70 */       throw new RuntimeException("BuffAdd中配置的效果组id不存在:效果组id" + this.effectid);
/*    */     }
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BuffAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */