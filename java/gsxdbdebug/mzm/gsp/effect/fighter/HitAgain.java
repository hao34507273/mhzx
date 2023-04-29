/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.InfluenceOther;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.KillOtherHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.KillOtherHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ public class HitAgain extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.KillOtherHandle
/*     */ {
/*     */   private int damagerate;
/*     */   private int maxtimes;
/*     */   private int curRound;
/*     */   private int times;
/*     */   private int activite;
/*     */   
/*     */   public HitAgain(int damagerate, int maxtimes, int activite)
/*     */   {
/*  39 */     this.damagerate = damagerate;
/*  40 */     this.maxtimes = maxtimes;
/*  41 */     this.activite = activite;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  46 */     fighter.addKillOtherHandle(this);
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  52 */     fighter.remKillOtherHandle(this);
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public void killOther(KillOtherHandle.InputObj inputObj, KillOtherHandle.OutputObj outputObj)
/*     */   {
/*  58 */     if ((inputObj.skill == null) || (inputObj.attacker == null) || (inputObj.skillTarget == null) || (inputObj.killedTarget == null))
/*     */     {
/*  60 */       return;
/*     */     }
/*  62 */     if (!inputObj.hitAagin) {
/*  63 */       return;
/*     */     }
/*  65 */     Skill skill = inputObj.skill;
/*  66 */     boolean isNormalSkill = mzm.gsp.fight.main.FightInterface.isNormalAttackSkill(skill.getID());
/*  67 */     if ((this.activite <= 0) && (!isNormalSkill)) {
/*  68 */       return;
/*     */     }
/*  70 */     if ((this.activite > 0) && (isNormalSkill)) {
/*  71 */       return;
/*     */     }
/*  73 */     Fighter fighter = getHitAgainFighter(inputObj.attacker);
/*  74 */     if (fighter == null) {
/*  75 */       return;
/*     */     }
/*  77 */     Fighter killedTarget = inputObj.killedTarget;
/*  78 */     Fighter attacker = inputObj.attacker;
/*  79 */     if ((attacker.isDead()) || (attacker.isFakeDead())) {
/*  80 */       return;
/*     */     }
/*  82 */     int round = fighter.getRound();
/*     */     
/*  84 */     if (this.curRound == round) {
/*  85 */       if (this.times < this.maxtimes) {}
/*     */     }
/*     */     else
/*     */     {
/*  89 */       this.curRound = round;
/*  90 */       this.times = 0;
/*     */     }
/*  92 */     this.times += 1;
/*     */     
/*  94 */     boolean isphyHit = FightFormulaHelp.isPhyHit(attacker, fighter, 0);
/*  95 */     mzm.gsp.fight.HitAgain hitAgain = outputObj.hitAgain;
/*  96 */     if (hitAgain == null) {
/*  97 */       hitAgain = new mzm.gsp.fight.HitAgain();
/*  98 */       outputObj.hitAgain = hitAgain;
/*     */     }
/*     */     
/* 101 */     int hitAgainTargetid = fighter.getid();
/* 102 */     AttackResult attackResult = null;
/* 103 */     if (hitAgain.status_map.containsKey(Integer.valueOf(hitAgainTargetid))) {
/* 104 */       attackResult = (AttackResult)hitAgain.status_map.get(Integer.valueOf(hitAgainTargetid));
/*     */     } else {
/* 106 */       hitAgain.targets.add(Integer.valueOf(hitAgainTargetid));
/* 107 */       attackResult = new AttackResult();
/* 108 */       hitAgain.status_map.put(Integer.valueOf(hitAgainTargetid), attackResult);
/*     */     }
/* 110 */     AttackResultBean attackResultBean = new AttackResultBean();
/* 111 */     BeforeAttackHandle.OutputObj attackOutputObj = attacker.handleBeforeAttack(new BeforeAttackHandle.InputObj(attacker, fighter, skill));
/*     */     
/* 113 */     BeforeAttackHandle.OutputObj targetOutputObj = fighter.handleBeforeAttack(new BeforeAttackHandle.InputObj(attacker, fighter, skill));
/*     */     
/* 115 */     int reboundDamage = 0;
/* 116 */     int trueDamage = 0;
/* 117 */     if (isphyHit)
/*     */     {
/* 119 */       boolean iscrt = FightFormulaHelp.isPHyCrt(attacker, fighter, attackOutputObj, targetOutputObj);
/*     */       
/* 121 */       int damage = FightFormulaHelp.calPHYDamage(attacker, fighter, 1, iscrt, attackOutputObj, targetOutputObj);
/* 122 */       damage = (int)(damage * (this.damagerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 123 */       DamageHandle.OutputObj damageOutputObj = attacker.handleOnDamage(new mzm.gsp.fight.handle.DamageHandle.InputObj(attacker, fighter, skill, damage));
/*     */       
/*     */ 
/* 126 */       damage = damageOutputObj.damage;
/* 127 */       BeDamageHandle.OutputObj beDamageRet = fighter.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(attacker, fighter, skill, damage, 1));
/*     */       
/* 129 */       ReboundHandle.OutPutObj reboundOutPutObj = fighter.handleOnRebound(1, damage);
/* 130 */       reboundDamage = reboundOutPutObj.reboundDamage;
/* 131 */       boolean isAbsorbDamage = false;
/* 132 */       trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 133 */       isAbsorbDamage = beDamageRet.absorb;
/* 134 */       fighter.addHp(attacker, -trueDamage);
/* 135 */       attacker.addDamageToFighter(fighter, damage);
/* 136 */       if (iscrt) {
/* 137 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(21));
/* 138 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(20));
/*     */       } else {
/* 140 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(20));
/*     */       }
/* 142 */       attackResultBean.targetstatus.hpchange = (-trueDamage);
/* 143 */       if (isAbsorbDamage) {
/* 144 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(26));
/*     */       }
/* 146 */       attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/* 147 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(reboundOutPutObj.targetPassiveSkillids);
/* 148 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(targetOutputObj.targetPassiveSkillids);
/* 149 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/*     */       
/* 151 */       int attackerHpChange = (int)((trueDamage + beDamageRet.shareDamage) * (attackOutputObj.phyVampirerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */       
/* 153 */       attacker.addHp(attackerHpChange);
/* 154 */       attackResultBean.attackerstatus.hpchange += attackerHpChange;
/* 155 */       if (fighter.isDefense()) {
/* 156 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */       }
/* 158 */       InfluenceOther influenceOther = (InfluenceOther)hitAgain.influencemap.get(Integer.valueOf(killedTarget.getid()));
/* 159 */       int size = killedTarget.getInfluenceMap().size();
/* 160 */       if (size > 0) {
/* 161 */         if (influenceOther == null) {
/* 162 */           influenceOther = new InfluenceOther();
/* 163 */           hitAgain.influencemap.put(Integer.valueOf(killedTarget.getid()), influenceOther);
/*     */         }
/* 165 */         influenceOther.othermap.putAll(killedTarget.getInfluenceMap());
/* 166 */         killedTarget.clearInfluenceTarget();
/*     */       }
/*     */     }
/*     */     else {
/* 170 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(22));
/*     */     }
/* 172 */     attackResultBean.attackerstatus.triggerpassiveskills.addAll(attackOutputObj.releasertriggerPassiveSkillids);
/*     */     
/* 174 */     attacker.fillFighterStatus(attackResultBean.attackerstatus);
/* 175 */     fighter.fillFighterStatus(attackResultBean.targetstatus);
/*     */     
/* 177 */     attackResult.attackresultbeans.add(attackResultBean);
/*     */     
/* 179 */     if ((fighter.isDead()) || (fighter.isFakeDead())) {
/* 180 */       KillOtherHandle.OutputObj tempOutputObj = new KillOtherHandle.OutputObj();
/* 181 */       attacker.handleKillOther(new KillOtherHandle.InputObj(attacker, inputObj.skillTarget, fighter, skill), tempOutputObj);
/* 182 */       attackResultBean.attackerstatus.hpchange += tempOutputObj.addHp;
/* 183 */       attackResultBean.attackerstatus.mpchange += tempOutputObj.addMp;
/* 184 */       if (tempOutputObj.hitAgain != null) {
/* 185 */         hitAgain.targets.addAll(tempOutputObj.hitAgain.targets);
/* 186 */         for (Map.Entry<Integer, InfluenceOther> entry : tempOutputObj.hitAgain.influencemap.entrySet())
/*     */         {
/* 188 */           InfluenceOther influenceOther = (InfluenceOther)hitAgain.influencemap.get(entry.getKey());
/* 189 */           if (influenceOther == null) {
/* 190 */             hitAgain.influencemap.put(entry.getKey(), entry.getValue());
/*     */           } else {
/* 192 */             influenceOther.othermap.putAll(((InfluenceOther)entry.getValue()).othermap);
/*     */           }
/*     */         }
/* 195 */         for (Map.Entry<Integer, AttackResult> entry : tempOutputObj.hitAgain.status_map.entrySet())
/*     */         {
/* 197 */           int targetid = ((Integer)entry.getKey()).intValue();
/* 198 */           AttackResult tempAttackResult = (AttackResult)hitAgain.status_map.get(Integer.valueOf(targetid));
/* 199 */           if (tempAttackResult == null) {
/* 200 */             hitAgain.status_map.put(Integer.valueOf(targetid), entry.getValue());
/*     */           } else {
/* 202 */             tempAttackResult.attackresultbeans.addAll(((AttackResult)entry.getValue()).attackresultbeans);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 207 */       BeKilledHandle.OutPutObj outPutObj = fighter.handleBeKilled(new BeKilledHandle.InputObj(attacker, fighter, skill, trueDamage));
/*     */       
/*     */ 
/* 210 */       if (fighter.isAlive()) {
/* 211 */         attackResultBean.targetstatus.status_set.remove(Integer.valueOf(1));
/* 212 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(3));
/* 213 */         attackResultBean.targetstatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/* 214 */         FighterStatus fighterStatus = new FighterStatus();
/* 215 */         fighterStatus.status_set.add(Integer.valueOf(23));
/* 216 */         fighterStatus.hpchange += fighter.getHp();
/* 217 */         fighter.fillFighterStatus(fighterStatus);
/* 218 */         attackResultBean.statusmap.put(Integer.valueOf(1), fighterStatus);
/*     */       }
/*     */     } else {
/* 221 */       if (reboundDamage > 0) {
/* 222 */         attacker.addHp(-reboundDamage);
/* 223 */         FighterStatus fighterStatus = new FighterStatus();
/* 224 */         fighterStatus.status_set.add(Integer.valueOf(20));
/* 225 */         attacker.fillFighterStatus(fighterStatus);
/* 226 */         fighterStatus.hpchange -= reboundDamage;
/* 227 */         attackResultBean.statusmap.put(Integer.valueOf(0), fighterStatus);
/* 228 */         if ((attacker.isDead()) || (attacker.isFakeDead())) {
/* 229 */           attacker.handleBeKilled(new BeKilledHandle.InputObj(fighter, attacker, skill, reboundDamage));
/*     */           
/* 231 */           InfluenceOther influenceOther = (InfluenceOther)hitAgain.influencemap.get(Integer.valueOf(killedTarget.getid()));
/* 232 */           int size = attacker.getInfluenceMap().size();
/* 233 */           if (size > 0) {
/* 234 */             if (influenceOther == null) {
/* 235 */               influenceOther = new InfluenceOther();
/* 236 */               hitAgain.influencemap.put(Integer.valueOf(killedTarget.getid()), influenceOther);
/*     */             }
/* 238 */             influenceOther.othermap.putAll(attacker.getInfluenceMap());
/* 239 */             attacker.clearInfluenceTarget();
/*     */           }
/*     */           
/* 242 */           if (attacker.isAlive()) {
/* 243 */             FighterStatus status = (FighterStatus)attackResultBean.statusmap.get(Integer.valueOf(0));
/* 244 */             status.status_set.remove(Integer.valueOf(1));
/* 245 */             status.status_set.add(Integer.valueOf(3));
/*     */             
/* 247 */             FighterStatus releaserReliveStatus = new FighterStatus();
/* 248 */             releaserReliveStatus.hpchange += attacker.getHp();
/* 249 */             releaserReliveStatus.status_set.add(Integer.valueOf(23));
/* 250 */             attacker.fillFighterStatus(releaserReliveStatus);
/* 251 */             attackResultBean.statusmap.put(Integer.valueOf(2), releaserReliveStatus);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 256 */       if (fighter.isAlive()) {
/* 257 */         SSkillCfg cfg = skill.getSkillCfg();
/* 258 */         if ((cfg != null) && (cfg.canBeCounterAttack)) {
/* 259 */           mzm.gsp.fight.CounterAttack counterAttack = fighter.handleCounterAttack(attacker);
/* 260 */           if (counterAttack != null) {
/* 261 */             attackResultBean.counterattack = counterAttack;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Fighter getHitAgainFighter(Fighter attacker)
/*     */   {
/* 274 */     Set<Fighter> fighters = attacker.getEnermyLiveFighters();
/* 275 */     if (!attacker.isVisible())
/*     */     {
/* 277 */       Iterator<Fighter> iterator = fighters.iterator();
/* 278 */       while (iterator.hasNext()) {
/* 279 */         Fighter targetFighter = (Fighter)iterator.next();
/* 280 */         if (targetFighter.isInvisible()) {
/* 281 */           iterator.remove();
/*     */         }
/*     */       }
/*     */     }
/* 285 */     int size = fighters.size();
/* 286 */     if (size <= 0) {
/* 287 */       return null;
/*     */     }
/* 289 */     int index = xdb.Xdb.random().nextInt(size);
/* 290 */     int i = 0;
/* 291 */     for (Fighter fighter : fighters) {
/* 292 */       if (i == index) {
/* 293 */         return fighter;
/*     */       }
/* 295 */       i++;
/*     */     }
/* 297 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HitAgain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */