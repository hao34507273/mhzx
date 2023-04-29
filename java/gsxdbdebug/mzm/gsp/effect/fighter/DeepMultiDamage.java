/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.GameServer;
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
/*     */ 
/*     */ public class DeepMultiDamage extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*     */ {
/*     */   private int damagetimes;
/*     */   private int damagerate;
/*     */   private int multiple;
/*     */   
/*     */   public DeepMultiDamage(int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/*  32 */     this.damagetimes = paramInt1;
/*  33 */     this.damagerate = paramInt2;
/*  34 */     this.multiple = paramInt3;
/*     */   }
/*     */   
/*     */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*     */   {
/*  39 */     boolean bool1 = false;
/*  40 */     int i = 0;
/*  41 */     int j = 0;
/*  42 */     int k = 0;
/*  43 */     int m; boolean bool2; BeforeAttackHandle.OutputObj localOutputObj1; BeforeAttackHandle.OutputObj localOutputObj2; DamageHandle.OutputObj localOutputObj; BeDamageHandle.OutputObj localOutputObj3; boolean bool3; int n; Object localObject; AfterAttackHandle.OutPutObj localOutPutObj; if (paramFighterEffectGroup.getDamageType() == 2)
/*     */     {
/*  45 */       for (m = 0; m < this.damagetimes; m++)
/*     */       {
/*  47 */         if ((paramFighter2.isDead()) || (paramFighter2.isFakeDead()) || (paramFighter1.isDead()) || (paramFighter1.isFakeDead())) {
/*     */           break;
/*     */         }
/*     */         
/*  51 */         bool2 = true;
/*  52 */         if (m != 0)
/*     */         {
/*  54 */           bool2 = FightFormulaHelp.isMagHit(paramFighter1, paramFighter2, 0);
/*     */         }
/*     */         
/*  57 */         if ((!bool2) && (paramFighter2.isAlive()))
/*     */         {
/*  59 */           paramSkill.addDodge(paramFighter1, paramFighter2);
/*     */         }
/*     */         else
/*     */         {
/*  63 */           localOutputObj1 = paramFighter1.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*  64 */           localOutputObj2 = paramFighter2.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*     */           
/*  66 */           bool1 = FightFormulaHelp.isMagCrt(paramFighter1, paramFighter2, localOutputObj1, localOutputObj2);
/*  67 */           i = FightFormulaHelp.calMAGDamage(paramFighter1, paramFighter2, paramSkill.getTargetSize(), bool1, localOutputObj1, localOutputObj2);
/*  68 */           i = (int)(i * (this.damagerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*  69 */           if (i < 1) {
/*  70 */             i = 1;
/*     */           }
/*  72 */           localOutputObj = paramFighter1.handleOnDamage(new DamageHandle.InputObj(paramFighter1, paramFighter2, paramSkill, i));
/*  73 */           i = localOutputObj.damage;
/*  74 */           localOutputObj3 = paramFighter2.handleBeDamage(new BeDamageHandle.InputObj(paramFighter1, paramFighter2, paramSkill, i, paramFighterEffectGroup.getDamageType()));
/*     */           
/*  76 */           bool3 = false;
/*  77 */           n = 0;
/*  78 */           if (m == 0)
/*     */           {
/*  80 */             ReboundHandle.OutPutObj localOutPutObj1 = paramFighter2.handleOnRebound(2, i);
/*  81 */             j = localOutPutObj1.reboundDamage;
/*  82 */             n = localOutputObj3.damage2heal > 0 ? -localOutputObj3.damage2heal : localOutputObj3.nowDamage;
/*  83 */             bool3 = localOutputObj3.absorb;
/*     */           }
/*     */           else
/*     */           {
/*  87 */             j = 0;
/*  88 */             n = (int)(k * (this.multiple * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           }
/*     */           
/*     */ 
/*  92 */           int i1 = 0;
/*  93 */           if (localOutputObj1.vampire)
/*     */           {
/*  95 */             i1 = (int)((localOutputObj3.nowDamage + localOutputObj3.shareDamage) * ((localOutputObj1.magVampirerate + localOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */             
/*  97 */             paramFighter1.addHp(i1);
/*     */           }
/*  99 */           if ((n > 0) && (localOutputObj1.isStealHp))
/*     */           {
/* 101 */             int i3 = (int)(n * (localOutputObj1.stealDamageRate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */             
/* 103 */             paramFighter1.addHp(i3);
/* 104 */             i1 += i3;
/*     */           }
/* 106 */           paramFighter2.addHp(paramFighter1, -n);
/* 107 */           paramFighter1.addDamageToFighter(paramFighter2, i);
/*     */           
/* 109 */           localObject = paramSkill.addDamageRet(n, i1, bool1, bool3, paramFighter1, paramFighter2);
/*     */           
/* 111 */           ((AttackResultBean)localObject).attackerstatus.triggerpassiveskills.addAll(localOutputObj1.releasertriggerPassiveSkillids);
/*     */           
/* 113 */           ((AttackResultBean)localObject).attackerstatus.triggerpassiveskills.addAll(localOutputObj.releaserPassiveSkillids);
/* 114 */           ((AttackResultBean)localObject).targetstatus.triggerpassiveskills.addAll(localOutputObj2.targetPassiveSkillids);
/* 115 */           ((AttackResultBean)localObject).targetstatus.triggerpassiveskills.addAll(localOutputObj3.targetPassiveSkillids);
/* 116 */           paramSkill.handleShareDamage(paramFighter1, localOutputObj3, (AttackResultBean)localObject);
/* 117 */           paramSkill.afterTargetDamage(paramFighter1, paramFighter2, j, (AttackResultBean)localObject, n);
/*     */           
/* 119 */           localOutPutObj = paramFighter1.handleAfterAttack(paramSkill, paramFighter1, paramFighter2);
/* 120 */           ((AttackResultBean)localObject).attackerstatus.triggerpassiveskills.addAll(localOutPutObj.releaserPassiveSkills);
/*     */           
/* 122 */           if ((m == 0) && ((j > 0) || (bool3) || (n <= 0)))
/*     */           {
/* 124 */             GameServer.logger().info("[DeepMultiDamage]无后续伤害");
/* 125 */             break;
/*     */           }
/*     */           
/*     */ 
/* 129 */           k = n;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 134 */     else if (paramFighterEffectGroup.getDamageType() == 1)
/*     */     {
/* 136 */       for (m = 0; m < this.damagetimes; m++)
/*     */       {
/* 138 */         if ((paramFighter2.isDead()) || (paramFighter2.isFakeDead()) || (paramFighter1.isDead()) || (paramFighter1.isFakeDead())) {
/*     */           break;
/*     */         }
/*     */         
/* 142 */         bool2 = true;
/* 143 */         if (m != 0)
/*     */         {
/* 145 */           bool2 = FightFormulaHelp.isPhyHit(paramFighter1, paramFighter2, 0);
/*     */         }
/*     */         
/* 148 */         if ((!bool2) && (paramFighter2.isAlive()))
/*     */         {
/* 150 */           paramSkill.addDodge(paramFighter1, paramFighter2);
/*     */         }
/*     */         else
/*     */         {
/* 154 */           localOutputObj1 = paramFighter1.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*     */           
/* 156 */           localOutputObj2 = paramFighter2.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*     */           
/* 158 */           bool1 = FightFormulaHelp.isPHyCrt(paramFighter1, paramFighter2, localOutputObj1, localOutputObj2);
/*     */           
/* 160 */           i = FightFormulaHelp.calPHYDamage(paramFighter1, paramFighter2, paramSkill.getTargetSize(), bool1, localOutputObj1, localOutputObj2);
/*     */           
/* 162 */           i = (int)(i * (this.damagerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 163 */           if (i < 1) {
/* 164 */             i = 1;
/*     */           }
/* 166 */           localOutputObj = paramFighter1.handleOnDamage(new DamageHandle.InputObj(paramFighter1, paramFighter2, paramSkill, i));
/*     */           
/* 168 */           i = localOutputObj.damage;
/*     */           
/* 170 */           localOutputObj3 = paramFighter2.handleBeDamage(new BeDamageHandle.InputObj(paramFighter1, paramFighter2, paramSkill, i, paramFighterEffectGroup.getDamageType()));
/*     */           
/* 172 */           bool3 = false;
/* 173 */           n = 0;
/* 174 */           if (m == 0)
/*     */           {
/* 176 */             ReboundHandle.OutPutObj localOutPutObj2 = paramFighter2.handleOnRebound(1, i);
/* 177 */             j = localOutPutObj2.reboundDamage;
/* 178 */             n = localOutputObj3.damage2heal > 0 ? -localOutputObj3.damage2heal : localOutputObj3.nowDamage;
/* 179 */             bool3 = localOutputObj3.absorb;
/* 180 */             if (paramSkill.canBeProtect())
/*     */             {
/* 182 */               localObject = paramFighter2.handleProtect(n);
/* 183 */               paramSkill.handleProtectResult(paramFighter1, paramFighter2, (Fighter.ProtectResult)localObject);
/* 184 */               n = ((Fighter.ProtectResult)localObject).getFinalDamage();
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 189 */             j = 0;
/* 190 */             n = (int)(k * (this.multiple * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           }
/*     */           
/*     */ 
/* 194 */           int i2 = 0;
/* 195 */           if (localOutputObj1.vampire)
/*     */           {
/* 197 */             i2 = (int)((localOutputObj3.nowDamage + localOutputObj3.shareDamage) * ((localOutputObj1.phyVampirerate + localOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */             
/* 199 */             paramFighter1.addHp(i2);
/*     */           }
/* 201 */           if ((n > 0) && (localOutputObj1.isStealHp))
/*     */           {
/* 203 */             int i4 = (int)(n * (localOutputObj1.stealDamageRate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */             
/* 205 */             paramFighter1.addHp(i4);
/* 206 */             i2 += i4;
/*     */           }
/* 208 */           paramFighter2.addHp(paramFighter1, -n);
/* 209 */           paramFighter1.addDamageToFighter(paramFighter2, i);
/*     */           
/* 211 */           AttackResultBean localAttackResultBean = paramSkill.addDamageRet(n, i2, bool1, bool3, paramFighter1, paramFighter2);
/*     */           
/* 213 */           localAttackResultBean.attackerstatus.triggerpassiveskills.addAll(localOutputObj1.releasertriggerPassiveSkillids);
/*     */           
/* 215 */           localAttackResultBean.attackerstatus.triggerpassiveskills.addAll(localOutputObj.releaserPassiveSkillids);
/* 216 */           localAttackResultBean.targetstatus.triggerpassiveskills.addAll(localOutputObj2.targetPassiveSkillids);
/* 217 */           localAttackResultBean.targetstatus.triggerpassiveskills.addAll(localOutputObj3.targetPassiveSkillids);
/* 218 */           paramSkill.handleShareDamage(paramFighter1, localOutputObj3, localAttackResultBean);
/* 219 */           if ((paramFighter2.isDefense()) && (paramFighterEffectGroup.getDamageType() == 1)) {
/* 220 */             localAttackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */           }
/* 222 */           paramSkill.afterTargetDamage(paramFighter1, paramFighter2, j, localAttackResultBean, n);
/*     */           
/* 224 */           localOutPutObj = paramFighter1.handleAfterAttack(paramSkill, paramFighter1, paramFighter2);
/* 225 */           localAttackResultBean.attackerstatus.triggerpassiveskills.addAll(localOutPutObj.releaserPassiveSkills);
/*     */           
/* 227 */           if ((m == 0) && ((j > 0) || (bool3) || (n <= 0)))
/*     */           {
/* 229 */             GameServer.logger().info("[DeepMultiDamage]无后续伤害");
/* 230 */             break;
/*     */           }
/*     */           
/*     */ 
/* 234 */           k = n;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 241 */       GameServer.logger().error("[DeepMultiDamage]效果组伤害类型不是法术和物理,但是效果组配置了伤害效果!!");
/* 242 */       return false;
/*     */     }
/* 244 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter paramFighter)
/*     */   {
/* 249 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter paramFighter)
/*     */   {
/* 254 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DeepMultiDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */