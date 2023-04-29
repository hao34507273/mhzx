/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackOtherBean;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.InfluenceOther;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.KillOtherHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.KillOtherHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.Fighter.ProtectResult;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class IndiscriminateMultiDamage extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*     */ {
/*     */   private int times;
/*     */   private int damagerate;
/*     */   private int modifyrate;
/*     */   private int enemyrate;
/*     */   
/*     */   public IndiscriminateMultiDamage(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
/*     */   {
/*  46 */     this.times = paramInt1;
/*  47 */     this.damagerate = paramInt2;
/*  48 */     this.modifyrate = paramInt3;
/*  49 */     this.enemyrate = paramInt4;
/*     */   }
/*     */   
/*     */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*     */   {
/*  54 */     AttackResult localAttackResult = paramSkill.getAttackResult(paramFighter2.getid());
/*  55 */     AttackResultBean localAttackResultBean1 = new AttackResultBean();
/*  56 */     localAttackResult.attackresultbeans.add(localAttackResultBean1);
/*  57 */     int i = Math.max(paramSkill.getTargetSize(), 1);
/*     */     
/*  59 */     Fighter localFighter = null;
/*  60 */     for (int j = 0; j < this.times; j++)
/*     */     {
/*  62 */       if (((paramFighter1.isDead()) || (paramFighter1.isFakeDead())) && (j > 0)) {
/*  63 */         return true;
/*     */       }
/*     */       
/*  66 */       if (j != 0)
/*     */       {
/*  68 */         k = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  69 */         if (this.enemyrate < k) {
/*  70 */           localFighter = randomFriend(paramFighter1);
/*     */         } else {
/*  72 */           localFighter = randomEnemy(paramFighter1);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  77 */         localFighter = paramFighter2;
/*     */       }
/*     */       
/*  80 */       if (localFighter == null) {
/*  81 */         return true;
/*     */       }
/*  83 */       int k = 0;
/*  84 */       int m = 0;
/*  85 */       int n = 0;
/*  86 */       int i1 = 0;
/*  87 */       boolean bool2 = false;
/*  88 */       int i2 = 0;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  93 */       BeforeAttackHandle.OutputObj localOutputObj2 = paramFighter1.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, localFighter, paramSkill));
/*  94 */       BeforeAttackHandle.OutputObj localOutputObj3 = localFighter.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, localFighter, paramSkill));
/*  95 */       AttackOtherBean localAttackOtherBean = null;
/*  96 */       boolean bool3; boolean bool1; DamageHandle.OutputObj localOutputObj; BeDamageHandle.OutputObj localOutputObj1; ReboundHandle.OutPutObj localOutPutObj; if (paramFighterEffectGroup.getDamageType() == 2)
/*     */       {
/*  98 */         bool3 = FightFormulaHelp.isMagHit(paramFighter1, localFighter, 0);
/*  99 */         if (!bool3)
/*     */         {
/* 101 */           if (j == 0)
/*     */           {
/* 103 */             paramSkill.addDodge(paramFighter1, localFighter, localAttackResultBean1); continue;
/*     */           }
/* 105 */           localAttackOtherBean = new AttackOtherBean();
/* 106 */           paramSkill.addDodge(paramFighter1, localFighter, localAttackOtherBean.attackinnerbean);
/* 107 */           localAttackOtherBean.targetid = localFighter.getid();
/* 108 */           localAttackResultBean1.attackothers.add(localAttackOtherBean);
/*     */           
/* 110 */           continue;
/*     */         }
/* 112 */         bool1 = FightFormulaHelp.isMagCrt(paramFighter1, localFighter, localOutputObj2, localOutputObj3);
/*     */         
/* 114 */         m = FightFormulaHelp.calMAGDamage(paramFighter1, localFighter, i, bool1, localOutputObj2, localOutputObj3);
/*     */         
/* 116 */         m = (int)(m * ((this.damagerate + this.modifyrate * j) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 117 */         if (m < 1) {
/* 118 */           m = 1;
/*     */         }
/* 120 */         localOutputObj = paramFighter1.handleOnDamage(new DamageHandle.InputObj(paramFighter1, localFighter, paramSkill, m));
/*     */         
/* 122 */         m = localOutputObj.damage;
/* 123 */         localOutputObj1 = localFighter.handleBeDamage(new BeDamageHandle.InputObj(paramFighter1, localFighter, paramSkill, m, paramFighterEffectGroup.getDamageType()));
/*     */         
/* 125 */         localOutPutObj = localFighter.handleOnRebound(2, m);
/* 126 */         i2 = localOutPutObj.reboundDamage;
/* 127 */         n = localOutputObj1.damage2heal > 0 ? -localOutputObj1.damage2heal : localOutputObj1.nowDamage;
/* 128 */         bool2 = localOutputObj1.absorb;
/*     */         
/* 130 */         i1 = (int)((localOutputObj1.nowDamage + localOutputObj1.shareDamage) * ((localOutputObj2.magVampirerate + localOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/* 132 */         paramFighter1.addHp(i1);
/*     */       }
/* 134 */       else if (paramFighterEffectGroup.getDamageType() == 1)
/*     */       {
/* 136 */         bool3 = FightFormulaHelp.isPhyHit(paramFighter1, localFighter, 0);
/* 137 */         if (!bool3)
/*     */         {
/* 139 */           if (j == 0)
/*     */           {
/* 141 */             paramSkill.addDodge(paramFighter1, localFighter, localAttackResultBean1); continue;
/*     */           }
/* 143 */           localAttackOtherBean = new AttackOtherBean();
/* 144 */           paramSkill.addDodge(paramFighter1, localFighter, localAttackOtherBean.attackinnerbean);
/* 145 */           localAttackResultBean1.attackothers.add(localAttackOtherBean);
/* 146 */           localAttackOtherBean.targetid = localFighter.getid();
/*     */           
/* 148 */           continue;
/*     */         }
/* 150 */         bool1 = FightFormulaHelp.isPHyCrt(paramFighter1, localFighter, localOutputObj2, localOutputObj3);
/*     */         
/* 152 */         m = FightFormulaHelp.calPHYDamage(paramFighter1, localFighter, i, bool1, localOutputObj2, localOutputObj3);
/*     */         
/* 154 */         m = (int)(m * ((this.damagerate + this.modifyrate * j) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 155 */         if (m < 1) {
/* 156 */           m = 1;
/*     */         }
/* 158 */         localOutputObj = paramFighter1.handleOnDamage(new DamageHandle.InputObj(paramFighter1, localFighter, paramSkill, m));
/*     */         
/* 160 */         m = localOutputObj.damage;
/* 161 */         localOutputObj1 = localFighter.handleBeDamage(new BeDamageHandle.InputObj(paramFighter1, localFighter, paramSkill, m, paramFighterEffectGroup.getDamageType()));
/*     */         
/* 163 */         localOutPutObj = localFighter.handleOnRebound(1, m);
/* 164 */         i2 = localOutPutObj.reboundDamage;
/* 165 */         n = localOutputObj1.damage2heal > 0 ? -localOutputObj1.damage2heal : localOutputObj1.nowDamage;
/* 166 */         bool2 = localOutputObj1.absorb;
/*     */         
/* 168 */         i1 = (int)((localOutputObj1.nowDamage + localOutputObj1.shareDamage) * ((localOutputObj2.phyVampirerate + localOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/* 170 */         paramFighter1.addHp(i1);
/* 171 */         if (paramSkill.canBeProtect())
/*     */         {
/* 173 */           localObject1 = localFighter.handleProtect(n);
/* 174 */           if (j == 0)
/*     */           {
/* 176 */             paramSkill.handleProtectResult(paramFighter1, localFighter, (Fighter.ProtectResult)localObject1);
/* 177 */             n = ((Fighter.ProtectResult)localObject1).getFinalDamage();
/*     */           }
/*     */           else
/*     */           {
/* 181 */             if (localAttackOtherBean == null)
/*     */             {
/* 183 */               localAttackOtherBean = new AttackOtherBean();
/* 184 */               localAttackOtherBean.targetid = localFighter.getid();
/* 185 */               localAttackResultBean1.attackothers.add(localAttackOtherBean);
/*     */             }
/* 187 */             paramSkill.handleProtectResult(paramFighter1, localFighter, (Fighter.ProtectResult)localObject1, localAttackOtherBean.protect);
/* 188 */             n = ((Fighter.ProtectResult)localObject1).getFinalDamage();
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 194 */         GameServer.logger().error(String.format("MultiDamageCombo.perform@效果组不是伤害类型，但是确配置了伤害类型的效果|efffectgroupid=%d", new Object[] { Integer.valueOf(paramFighterEffectGroup.getEffectGroupCfg().id) }));
/*     */         
/* 196 */         return false;
/*     */       }
/*     */       
/* 199 */       localFighter.addHp(paramFighter1, -n);
/* 200 */       paramFighter1.addDamageToFighter(localFighter, m);
/* 201 */       AttackResultBean localAttackResultBean2 = null;
/* 202 */       if (j == 0)
/*     */       {
/* 204 */         localAttackResultBean2 = paramSkill.addDamageRet(n, i1, bool1, bool2, paramFighter1, localFighter, localAttackResultBean1);
/*     */       }
/*     */       else
/*     */       {
/* 208 */         if (localAttackOtherBean == null)
/*     */         {
/* 210 */           localAttackOtherBean = new AttackOtherBean();
/* 211 */           localAttackOtherBean.targetid = localFighter.getid();
/* 212 */           localAttackResultBean1.attackothers.add(localAttackOtherBean);
/*     */         }
/* 214 */         localAttackResultBean2 = new AttackResultBean();
/* 215 */         paramSkill.addDamageRet(n, i1, bool1, bool2, paramFighter1, localFighter, localAttackResultBean2);
/*     */       }
/* 217 */       localAttackResultBean2.attackerstatus.triggerpassiveskills.addAll(localOutputObj2.releasertriggerPassiveSkillids);
/* 218 */       localAttackResultBean2.attackerstatus.triggerpassiveskills.addAll(localOutputObj.releaserPassiveSkillids);
/* 219 */       localAttackResultBean2.targetstatus.triggerpassiveskills.addAll(localOutPutObj.targetPassiveSkillids);
/* 220 */       localAttackResultBean2.targetstatus.triggerpassiveskills.addAll(localOutputObj3.targetPassiveSkillids);
/* 221 */       localAttackResultBean2.targetstatus.triggerpassiveskills.addAll(localOutputObj1.targetPassiveSkillids);
/* 222 */       paramSkill.handleShareDamage(paramFighter1, localOutputObj1, localAttackResultBean2);
/* 223 */       Object localObject3; FighterStatus localFighterStatus; if ((localFighter.isDead()) || (localFighter.isFakeDead()))
/*     */       {
/* 225 */         localObject1 = new KillOtherHandle.InputObj(paramFighter1, localFighter, localFighter, paramSkill);
/* 226 */         ((KillOtherHandle.InputObj)localObject1).hitAagin = false;
/* 227 */         localObject2 = new KillOtherHandle.OutputObj();
/* 228 */         paramFighter1.handleKillOther((KillOtherHandle.InputObj)localObject1, (KillOtherHandle.OutputObj)localObject2);
/* 229 */         localAttackResultBean2.attackerstatus.hpchange += ((KillOtherHandle.OutputObj)localObject2).addHp;
/* 230 */         localAttackResultBean2.attackerstatus.mpchange += ((KillOtherHandle.OutputObj)localObject2).addMp;
/* 231 */         localObject3 = localFighter.handleBeKilled(new BeKilledHandle.InputObj(paramFighter1, localFighter, paramSkill, n));
/* 232 */         if (localAttackOtherBean != null) {
/* 233 */           localAttackOtherBean.influenceothers.othermap.putAll(localFighter.getInfluenceMap());
/*     */         } else {
/* 235 */           paramSkill.addTargetInfluenceMap(localFighter, localFighter.getInfluenceMap());
/*     */         }
/* 237 */         localFighter.clearInfluenceTarget();
/* 238 */         localAttackResultBean2.targetstatus.triggerpassiveskills.addAll(((BeKilledHandle.OutPutObj)localObject3).targetPassiveSkillids);
/* 239 */         if (localFighter.isAlive())
/*     */         {
/* 241 */           localAttackResultBean2.targetstatus.status_set.remove(Integer.valueOf(1));
/* 242 */           localAttackResultBean2.targetstatus.status_set.add(Integer.valueOf(3));
/* 243 */           localFighterStatus = new FighterStatus();
/* 244 */           localFighterStatus.status_set.add(Integer.valueOf(23));
/* 245 */           localFighterStatus.hpchange += localFighter.getHp();
/* 246 */           localFighter.fillFighterStatus(localFighterStatus);
/* 247 */           localAttackResultBean2.statusmap.put(Integer.valueOf(1), localFighterStatus);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 252 */         if ((i2 > 0) && (paramFighter1.isAlive()))
/*     */         {
/* 254 */           paramFighter1.addHp(localFighter, -i2);
/* 255 */           localFighter.addDamageToFighter(paramFighter1, i2);
/* 256 */           localObject1 = new FighterStatus();
/* 257 */           ((FighterStatus)localObject1).status_set.add(Integer.valueOf(20));
/* 258 */           paramFighter1.fillFighterStatus((FighterStatus)localObject1);
/* 259 */           localObject1.hpchange -= i2;
/* 260 */           localAttackResultBean2.statusmap.put(Integer.valueOf(0), localObject1);
/* 261 */           if ((paramFighter1.isDead()) || (paramFighter1.isFakeDead()))
/*     */           {
/* 263 */             localObject2 = paramFighter1.handleBeKilled(new BeKilledHandle.InputObj(localFighter, paramFighter1, paramSkill, i2));
/* 264 */             if (localAttackOtherBean != null) {
/* 265 */               localAttackOtherBean.influenceothers.othermap.putAll(paramFighter1.getInfluenceMap());
/*     */             } else {
/* 267 */               paramSkill.addTargetInfluenceMap(localFighter, paramFighter1.getInfluenceMap());
/*     */             }
/* 269 */             paramFighter1.clearInfluenceTarget();
/* 270 */             localObject3 = (FighterStatus)localAttackResultBean2.statusmap.get(Integer.valueOf(0));
/* 271 */             ((FighterStatus)localObject3).triggerpassiveskills.addAll(((BeKilledHandle.OutPutObj)localObject2).targetPassiveSkillids);
/* 272 */             if (paramFighter1.isAlive())
/*     */             {
/* 274 */               ((FighterStatus)localObject3).status_set.remove(Integer.valueOf(1));
/* 275 */               ((FighterStatus)localObject3).status_set.add(Integer.valueOf(3));
/*     */               
/* 277 */               localFighterStatus = new FighterStatus();
/* 278 */               localFighterStatus.hpchange += paramFighter1.getHp();
/* 279 */               localFighterStatus.status_set.add(Integer.valueOf(23));
/* 280 */               paramFighter1.fillFighterStatus(localFighterStatus);
/* 281 */               localAttackResultBean2.statusmap.put(Integer.valueOf(2), localFighterStatus);
/*     */             }
/*     */           }
/*     */         }
/* 285 */         paramSkill.addCounterAttack(paramFighter1, localFighter, localAttackResultBean2);
/*     */       }
/* 287 */       if ((localFighter.isDefense()) && (paramFighterEffectGroup.getDamageType() == 1)) {
/* 288 */         localAttackResultBean2.targetstatus.status_set.add(Integer.valueOf(29));
/*     */       }
/* 290 */       Object localObject1 = new AfterAttackHandle.InputObj(paramSkill, paramFighter1, localFighter);
/* 291 */       ((AfterAttackHandle.InputObj)localObject1).canCombo = false;
/* 292 */       Object localObject2 = paramFighter1.handleAfterAttack((AfterAttackHandle.InputObj)localObject1);
/* 293 */       localAttackResultBean2.attackerstatus.triggerpassiveskills.addAll(((AfterAttackHandle.OutPutObj)localObject2).releaserPassiveSkills);
/* 294 */       if ((j != 0) && (localAttackOtherBean != null)) {
/* 295 */         Skill.fillInAttackOtherBeanResult(localAttackResultBean2, localAttackOtherBean.attackinnerbean);
/*     */       }
/*     */     }
/* 298 */     return true;
/*     */   }
/*     */   
/*     */   protected Fighter randomFriend(Fighter paramFighter)
/*     */   {
/* 303 */     Set localSet = paramFighter.getFriendLiveFighters();
/* 304 */     if (localSet.size() == 0) {
/* 305 */       return paramFighter;
/*     */     }
/* 307 */     ArrayList localArrayList = new ArrayList();
/* 308 */     for (Fighter localFighter : localSet) {
/* 309 */       if ((paramFighter.isVisible()) || (!localFighter.isInvisible())) {
/* 310 */         localArrayList.add(localFighter);
/*     */       }
/*     */     }
/* 313 */     if (localArrayList.size() == 0) {
/* 314 */       return paramFighter;
/*     */     }
/* 316 */     int i = Xdb.random().nextInt(localArrayList.size());
/* 317 */     return (Fighter)localArrayList.get(i);
/*     */   }
/*     */   
/*     */   protected Fighter randomEnemy(Fighter paramFighter)
/*     */   {
/* 322 */     Set localSet = paramFighter.getEnermyLiveFighters();
/* 323 */     if (localSet.size() == 0) {
/* 324 */       return null;
/*     */     }
/* 326 */     ArrayList localArrayList = new ArrayList();
/* 327 */     for (Fighter localFighter : localSet) {
/* 328 */       if ((paramFighter.isVisible()) || (!localFighter.isInvisible())) {
/* 329 */         localArrayList.add(localFighter);
/*     */       }
/*     */     }
/* 332 */     if (localArrayList.size() == 0) {
/* 333 */       return null;
/*     */     }
/* 335 */     int i = Xdb.random().nextInt(localArrayList.size());
/* 336 */     return (Fighter)localArrayList.get(i);
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter paramFighter)
/*     */   {
/* 341 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter paramFighter)
/*     */   {
/* 346 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\IndiscriminateMultiDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */