/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.effect.fighter.Interface.Validate;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.DamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class DamageResult extends FighterEffect implements mzm.gsp.fight.handle.DamageHandle, Validate
/*    */ {
/*    */   private int mask;
/*    */   private int vampirerate;
/*    */   private int effectid;
/*    */   
/*    */   public DamageResult(int mask, int vampirerate, int effectid)
/*    */   {
/* 20 */     this.mask = mask;
/* 21 */     this.vampirerate = vampirerate;
/* 22 */     this.effectid = effectid;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 27 */     fighter.addDamageHandle(this);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 33 */     fighter.remDamageHandle(this);
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public void onDamage(DamageHandle.InputObj inputObj, DamageHandle.OutputObj outputObj)
/*    */   {
/* 39 */     int damage = inputObj.getDamage();
/* 40 */     int mod = damage % 10;
/* 41 */     int x2y = 1;
/* 42 */     if (mod > 0) {
/* 43 */       x2y = 2 << mod - 1;
/*    */     }
/* 45 */     if ((this.mask & x2y) > 0)
/*    */     {
/* 47 */       outputObj.vampirerate += this.vampirerate;
/*    */       
/* 49 */       Fighter releser = inputObj.getReleser();
/* 50 */       if (releser != null) {
/* 51 */         FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 52 */         if (addGroup != null) {
/* 53 */           int level = super.getSkillLevel();
/* 54 */           addGroup.run(level, releser, releser, releser.getid());
/*    */         }
/* 56 */         int passiveSkillid = getPassiveSkillid();
/* 57 */         if (passiveSkillid > 0) {
/* 58 */           outputObj.releaserPassiveSkillids.add(Integer.valueOf(passiveSkillid));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean validate()
/*    */   {
/* 67 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 68 */     if ((effectGroup == null) && (this.effectid != 0)) {
/* 69 */       throw new RuntimeException("DamageResult中配置的效果组id不存在:效果组id" + this.effectid);
/*    */     }
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DamageResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */