/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.fighter.Interface.Validate;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class PetBornBuff extends FighterEffect implements mzm.gsp.fight.handle.PetEnterFightHandle, Validate
/*    */ {
/*    */   private int hitdebuffrate;
/*    */   private int debuffid;
/*    */   
/*    */   public PetBornBuff(int hitdebuffrate, int debuffid)
/*    */   {
/* 21 */     this.hitdebuffrate = hitdebuffrate;
/* 22 */     this.debuffid = debuffid;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 27 */     fighter.addPetEnterFightHandle(this);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 33 */     fighter.remPetEnterFightHandle(this);
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 39 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.debuffid);
/* 40 */     if (effectGroup == null) {
/* 41 */       throw new RuntimeException("BattleLove中配置的效果组id不存在:效果组id" + this.debuffid);
/*    */     }
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public void onPetEnterFight(Fighter releaser, Fighter pet)
/*    */   {
/* 48 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 49 */     if (random > this.hitdebuffrate) {
/* 50 */       return;
/*    */     }
/* 52 */     FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.debuffid);
/* 53 */     if (addGroup != null) {
/* 54 */       int level = super.getSkillLevel();
/* 55 */       addGroup.run(level, releaser, pet, pet.getid());
/*    */     } else {
/* 57 */       GameServer.logger().error("不存在的效果组id" + this.debuffid);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\PetBornBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */