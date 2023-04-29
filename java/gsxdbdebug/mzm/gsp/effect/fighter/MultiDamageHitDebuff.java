/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.Fighter.ProtectResult;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class MultiDamageHitDebuff extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*     */ {
/*     */   private int damagetimes;
/*     */   private int damagerate;
/*     */   private int modifyrate;
/*     */   private int hitdebuffrate;
/*     */   private int debuffid;
/*     */   
/*     */   public MultiDamageHitDebuff(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
/*     */   {
/*  37 */     this.damagetimes = paramInt1;
/*  38 */     this.damagerate = paramInt2;
/*  39 */     this.modifyrate = paramInt3;
/*  40 */     this.hitdebuffrate = paramInt4;
/*  41 */     this.debuffid = paramInt5;
/*     */   }
/*     */   
/*     */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*     */   {
/*  46 */     boolean bool1 = false;
/*  47 */     int i = 0;
/*  48 */     int j = 0;
/*  49 */     int k = 0;
/*  50 */     int m; boolean bool2; BeforeAttackHandle.OutputObj localOutputObj1; BeforeAttackHandle.OutputObj localOutputObj2; DamageHandle.OutputObj localOutputObj; BeDamageHandle.OutputObj localOutputObj3; ReboundHandle.OutPutObj localOutPutObj; int n; boolean bool3; int i1; Object localObject; AfterAttackHandle.OutPutObj localOutPutObj1; if (paramFighterEffectGroup.getDamageType() == 2)
/*     */     {
/*  52 */       for (m = 0; m < this.damagetimes; m++)
/*     */       {
/*  54 */         bool2 = FightFormulaHelp.isMagHit(paramFighter1, paramFighter2, 0);
/*  55 */         if ((!bool2) && (paramFighter2.isAlive()))
/*     */         {
/*  57 */           paramSkill.addDodge(paramFighter1, paramFighter2);
/*     */         }
/*     */         else
/*     */         {
/*  61 */           localOutputObj1 = paramFighter1.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*     */           
/*  63 */           localOutputObj2 = paramFighter2.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*     */           
/*  65 */           bool1 = FightFormulaHelp.isMagCrt(paramFighter1, paramFighter2, localOutputObj1, localOutputObj2);
/*     */           
/*  67 */           i = FightFormulaHelp.calMAGDamage(paramFighter1, paramFighter2, paramSkill.getTargetSize(), bool1, localOutputObj1, localOutputObj2);
/*     */           
/*  69 */           i = (int)(i * ((this.damagerate + this.modifyrate * m) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*  70 */           if (i < 1) {
/*  71 */             i = 1;
/*     */           }
/*  73 */           localOutputObj = paramFighter1.handleOnDamage(new DamageHandle.InputObj(paramFighter1, paramFighter2, paramSkill, i));
/*     */           
/*  75 */           i = localOutputObj.damage;
/*     */           
/*  77 */           localOutputObj3 = paramFighter2.handleBeDamage(new BeDamageHandle.InputObj(paramFighter1, paramFighter2, paramSkill, i, paramFighterEffectGroup.getDamageType()));
/*     */           
/*  79 */           localOutPutObj = paramFighter2.handleOnRebound(2, i);
/*  80 */           j += localOutPutObj.reboundDamage;
/*  81 */           n = localOutputObj3.damage2heal > 0 ? -localOutputObj3.damage2heal : localOutputObj3.nowDamage;
/*  82 */           bool3 = localOutputObj3.absorb;
/*     */           
/*  84 */           i1 = (int)((localOutputObj3.nowDamage + localOutputObj3.shareDamage) * ((localOutputObj1.magVampirerate + localOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           
/*  86 */           paramFighter1.addHp(i1);
/*     */           
/*  88 */           paramFighter2.addHp(paramFighter1, -n);
/*     */           
/*  90 */           if (n > 0)
/*     */           {
/*  92 */             int i2 = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  93 */             if (i2 < this.hitdebuffrate)
/*     */             {
/*  95 */               k++;
/*     */             }
/*     */           }
/*     */           
/*  99 */           paramFighter1.addDamageToFighter(paramFighter2, i);
/*     */           
/* 101 */           localObject = paramSkill.addDamageRet(n, i1, bool1, bool3, paramFighter1, paramFighter2);
/* 102 */           if (m == 0) {
/* 103 */             ((AttackResultBean)localObject).attackerstatus.triggerpassiveskills.addAll(localOutputObj1.releasertriggerPassiveSkillids);
/*     */           }
/* 105 */           ((AttackResultBean)localObject).attackerstatus.triggerpassiveskills.addAll(localOutputObj.releaserPassiveSkillids);
/* 106 */           ((AttackResultBean)localObject).targetstatus.triggerpassiveskills.addAll(localOutputObj2.targetPassiveSkillids);
/* 107 */           ((AttackResultBean)localObject).targetstatus.triggerpassiveskills.addAll(localOutputObj3.targetPassiveSkillids);
/* 108 */           paramSkill.handleShareDamage(paramFighter1, localOutputObj3, (AttackResultBean)localObject);
/* 109 */           if (m == this.damagetimes - 1)
/*     */           {
/* 111 */             paramSkill.afterTargetDamage(paramFighter1, paramFighter2, j, (AttackResultBean)localObject, n);
/*     */             
/* 113 */             localOutPutObj1 = paramFighter1.handleAfterAttack(paramSkill, paramFighter1, paramFighter2);
/*     */             
/* 115 */             ((AttackResultBean)localObject).attackerstatus.triggerpassiveskills.addAll(localOutPutObj1.releaserPassiveSkills);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 120 */     else if (paramFighterEffectGroup.getDamageType() == 1)
/*     */     {
/* 122 */       for (m = 0; m < this.damagetimes; m++)
/*     */       {
/* 124 */         bool2 = FightFormulaHelp.isPhyHit(paramFighter1, paramFighter2, 0);
/* 125 */         if ((!bool2) && (paramFighter2.isAlive()))
/*     */         {
/* 127 */           paramSkill.addDodge(paramFighter1, paramFighter2);
/*     */         }
/*     */         else
/*     */         {
/* 131 */           localOutputObj1 = paramFighter1.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*     */           
/* 133 */           localOutputObj2 = paramFighter2.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*     */           
/* 135 */           bool1 = FightFormulaHelp.isPHyCrt(paramFighter1, paramFighter2, localOutputObj1, localOutputObj2);
/*     */           
/* 137 */           i = FightFormulaHelp.calPHYDamage(paramFighter1, paramFighter2, paramSkill.getTargetSize(), bool1, localOutputObj1, localOutputObj2);
/*     */           
/* 139 */           i = (int)(i * ((this.damagerate + this.modifyrate * m) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 140 */           if (i < 1) {
/* 141 */             i = 1;
/*     */           }
/* 143 */           localOutputObj = paramFighter1.handleOnDamage(new DamageHandle.InputObj(paramFighter1, paramFighter2, paramSkill, i));
/*     */           
/* 145 */           i = localOutputObj.damage;
/*     */           
/* 147 */           localOutputObj3 = paramFighter2.handleBeDamage(new BeDamageHandle.InputObj(paramFighter1, paramFighter2, paramSkill, i, paramFighterEffectGroup.getDamageType()));
/*     */           
/* 149 */           localOutPutObj = paramFighter2.handleOnRebound(1, i);
/* 150 */           j += localOutPutObj.reboundDamage;
/* 151 */           n = localOutputObj3.damage2heal > 0 ? -localOutputObj3.damage2heal : localOutputObj3.nowDamage;
/* 152 */           bool3 = localOutputObj3.absorb;
/*     */           
/* 154 */           i1 = (int)((localOutputObj3.nowDamage + localOutputObj3.shareDamage) * ((localOutputObj1.phyVampirerate + localOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           
/* 156 */           paramFighter1.addHp(i1);
/* 157 */           if ((m == 0) && (paramSkill.canBeProtect()))
/*     */           {
/* 159 */             localObject = paramFighter2.handleProtect(n);
/* 160 */             paramSkill.handleProtectResult(paramFighter1, paramFighter2, (Fighter.ProtectResult)localObject);
/* 161 */             n = ((Fighter.ProtectResult)localObject).getFinalDamage();
/*     */           }
/* 163 */           paramFighter2.addHp(paramFighter1, -n);
/*     */           
/* 165 */           if (n > 0)
/*     */           {
/* 167 */             int i3 = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 168 */             if (i3 < this.hitdebuffrate)
/*     */             {
/* 170 */               k++;
/*     */             }
/*     */           }
/*     */           
/* 174 */           paramFighter1.addDamageToFighter(paramFighter2, i);
/*     */           
/* 176 */           AttackResultBean localAttackResultBean = paramSkill.addDamageRet(n, i1, bool1, bool3, paramFighter1, paramFighter2);
/* 177 */           if (m == 0) {
/* 178 */             localAttackResultBean.attackerstatus.triggerpassiveskills.addAll(localOutputObj1.releasertriggerPassiveSkillids);
/*     */           }
/* 180 */           localAttackResultBean.attackerstatus.triggerpassiveskills.addAll(localOutputObj.releaserPassiveSkillids);
/* 181 */           localAttackResultBean.targetstatus.triggerpassiveskills.addAll(localOutputObj2.targetPassiveSkillids);
/* 182 */           localAttackResultBean.targetstatus.triggerpassiveskills.addAll(localOutputObj3.targetPassiveSkillids);
/* 183 */           paramSkill.handleShareDamage(paramFighter1, localOutputObj3, localAttackResultBean);
/* 184 */           if ((paramFighter2.isDefense()) && (paramFighterEffectGroup.getDamageType() == 1)) {
/* 185 */             localAttackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */           }
/* 187 */           if (m == this.damagetimes - 1)
/*     */           {
/* 189 */             paramSkill.afterTargetDamage(paramFighter1, paramFighter2, j, localAttackResultBean, n);
/*     */             
/* 191 */             localOutPutObj1 = paramFighter1.handleAfterAttack(paramSkill, paramFighter1, paramFighter2);
/*     */             
/* 193 */             localAttackResultBean.attackerstatus.triggerpassiveskills.addAll(localOutPutObj1.releaserPassiveSkills);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 200 */       GameServer.logger().error("效果组伤害类型不是法术和物理,但是效果组配置了伤害效果!!");
/* 201 */       return false;
/*     */     }
/*     */     
/* 204 */     if (k > 0)
/*     */     {
/* 206 */       FighterEffectGroup localFighterEffectGroup = EffectInterface.getEffectGroup(this.debuffid);
/* 207 */       if (localFighterEffectGroup != null)
/*     */       {
/* 209 */         localFighterEffectGroup.run(k, paramFighter1, paramFighter2, paramFighter2.getid());
/*     */       }
/*     */       else
/*     */       {
/* 213 */         GameServer.logger().error("不存在效果组id" + this.debuffid);
/*     */       }
/*     */     }
/*     */     
/* 217 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter paramFighter)
/*     */   {
/* 222 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter paramFighter)
/*     */   {
/* 227 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MultiDamageHitDebuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */