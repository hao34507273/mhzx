/*     */ package mzm.gsp.effect.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*     */ import mzm.gsp.effect.fighter.Interface.OpPrepare;
/*     */ import mzm.gsp.effect.formula.fighter.EffectFormula;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.handle.AddBuffHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupSubCfg;
/*     */ import mzm.gsp.skill.formula.fighter.SkillFormula;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FighterEffectGroup
/*     */ {
/*  33 */   protected static ThreadLocal<FighterBuff> replaceBuffContext = new ThreadLocal();
/*     */   
/*     */   private static final int FROM_SKILL = 1;
/*     */   
/*     */   private static final int FROM_DRAG = 2;
/*  38 */   private int from = 1;
/*     */   private final SSkillEffectGroupCfg effectGroupCfg;
/*     */   
/*     */   public FighterEffectGroup(SSkillEffectGroupCfg effectGroupCfg)
/*     */   {
/*  43 */     this.effectGroupCfg = effectGroupCfg;
/*     */   }
/*     */   
/*     */   public SSkillEffectGroupCfg getEffectGroupCfg() {
/*  47 */     return this.effectGroupCfg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getDamageType()
/*     */   {
/*  56 */     return this.effectGroupCfg.damagetype;
/*     */   }
/*     */   
/*     */   public int getEffectGroupType() {
/*  60 */     return this.effectGroupCfg.effectgrouptype;
/*     */   }
/*     */   
/*     */   public boolean isFromDrag() {
/*  64 */     return this.from == 2;
/*     */   }
/*     */   
/*     */   public void setFromDrag() {
/*  68 */     this.from = 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean canBeTarget(Fighter releaser, Fighter target, int mainTargetid)
/*     */   {
/* 114 */     switch (this.effectGroupCfg.targettype) {
/*     */     case 3: 
/* 116 */       return target.getid() == mainTargetid;
/*     */     case 4: 
/* 118 */       return target.getid() != mainTargetid;
/*     */     case 2: 
/* 120 */       return releaser.getid() == target.getid();
/*     */     case 1: 
/* 122 */       return true;
/*     */     }
/* 124 */     return false;
/*     */   }
/*     */   
/*     */   public static FighterBuff getReplaceContext()
/*     */   {
/* 129 */     return (FighterBuff)replaceBuffContext.get();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public FighterBuff run(Skill skill, Fighter releaser, Fighter target, int mainTargetid)
/*     */   {
/* 143 */     if (releaser == null) {
/* 144 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */     Fighter trueTargetFighter = null;
/* 162 */     if (isTargetReleaser()) {
/* 163 */       trueTargetFighter = releaser;
/*     */     }
/* 165 */     if (trueTargetFighter == null) {
/* 166 */       if (!canBeTarget(releaser, target, mainTargetid)) {
/* 167 */         return null;
/*     */       }
/* 169 */       trueTargetFighter = target;
/*     */     }
/* 171 */     int round = 0;
/* 172 */     if (this.effectGroupCfg.roundsformula != 0) {
/* 173 */       SkillFormula formulaEffectGroupRound = SkillInterface.getSkillFormula(this.effectGroupCfg.roundsformula);
/* 174 */       if (formulaEffectGroupRound == null) {
/* 175 */         EffectManager.logger.error("效果组回合公式没找到， 技能id： " + skill.getSkillCfg().id + " formula：" + this.effectGroupCfg.roundsformula);
/*     */         
/* 177 */         return null;
/*     */       }
/* 179 */       round = formulaEffectGroupRound.calc(skill, releaser);
/*     */     }
/*     */     
/* 182 */     FighterBuff fighterBuff = new FighterBuff(releaser, round, this, skill);
/* 183 */     boolean attachbuff = true;
/* 184 */     for (Iterator i$ = this.effectGroupCfg.effectgroupsub.iterator(); i$.hasNext();) { int effectId = ((Integer)i$.next()).intValue();
/* 185 */       List<Integer> params = new ArrayList();
/* 186 */       SSkillEffectGroupSubCfg skillEffectGroupSubCfg = SSkillEffectGroupSubCfg.get(effectId);
/* 187 */       if (skillEffectGroupSubCfg == null) {
/* 188 */         GameServer.logger().error("效果组中配置的效果在效果子表中不存在,效果组id:" + this.effectGroupCfg.id);
/*     */       }
/*     */       else {
/* 191 */         for (Iterator i$ = skillEffectGroupSubCfg.effectformula.iterator(); i$.hasNext();) { int effectformula = ((Integer)i$.next()).intValue();
/* 192 */           EffectFormula formula = EffectInterface.getFighterEffectFormula(effectformula);
/* 193 */           if (formula == null) {
/* 194 */             GameServer.logger().error("效果子表中配置的公式不存在,效果子表id:" + skillEffectGroupSubCfg.id);
/* 195 */             break;
/*     */           }
/* 197 */           int value = formula.calc(skill, releaser, trueTargetFighter);
/* 198 */           params.add(Integer.valueOf(value));
/*     */         }
/* 200 */         FighterEffect fighterEffect = EffectInterface.getFighterEffectInstance(skillEffectGroupSubCfg.effectid, params);
/*     */         
/* 202 */         if ((fighterEffect instanceof OpPrepare)) {
/* 203 */           ((OpPrepare)fighterEffect).prepare(skill, this, releaser, trueTargetFighter, target);
/*     */         }
/* 205 */         if (((fighterEffect instanceof OpOnce)) && 
/* 206 */           (!((OpOnce)fighterEffect).perform(skill, this, releaser, trueTargetFighter))) {
/* 207 */           attachbuff = false;
/*     */         }
/*     */         
/* 210 */         if ((fighterEffect instanceof FighterEffect)) {
/* 211 */           fighterBuff.addEffect(fighterEffect);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */     if ((attachbuff) && (round > 0)) {
/* 224 */       int status = fighterBuff.getEffectGroupStatus();
/* 225 */       int metux = fighterBuff.getMutex();
/* 226 */       AddBuffHandle.OutPutObj addBuffOutPutObj = trueTargetFighter.isCanAddBuff(fighterBuff);
/* 227 */       boolean attached = false;
/* 228 */       switch (metux) {
/*     */       case 1: 
/* 230 */         if (trueTargetFighter.hasGroupStatus(status)) {
/* 231 */           if (fighterBuff.getEffectGroupType() == 8)
/*     */           {
/* 233 */             skill.addNotSealRet(releaser, trueTargetFighter);
/*     */           }
/* 235 */         } else if (!addBuffOutPutObj.canAddBuff) {
/* 236 */           if (fighterBuff.getEffectGroupType() == 8)
/*     */           {
/* 238 */             skill.addImmuneRet(releaser, trueTargetFighter); }
/*     */         } else {
/* 240 */           attached = trueTargetFighter.attachBuff(fighterBuff);
/*     */         }
/*     */         
/* 243 */         break;
/*     */       case 2: 
/* 245 */         if (addBuffOutPutObj.canAddBuff) {
/* 246 */           replaceBuffContext.set(fighterBuff);
/* 247 */           trueTargetFighter.removeBuff(status);
/* 248 */           attached = trueTargetFighter.attachBuff(fighterBuff);
/* 249 */           replaceBuffContext.set(null);
/*     */         }
/*     */         
/*     */         break;
/*     */       case 3: 
/* 254 */         int count = trueTargetFighter.getBuffSize(status);
/* 255 */         int additionMax = 0;
/* 256 */         SkillFormula formula = SkillInterface.getSkillFormula(this.effectGroupCfg.additionFormula);
/* 257 */         if (formula == null) {
/* 258 */           EffectManager.logger.error("效果组数量叠加公式没找到， 技能id： " + skill.getSkillCfg().id + " formula：" + this.effectGroupCfg.additionFormula);
/*     */         }
/*     */         else {
/* 261 */           additionMax = formula.calc(skill, releaser);
/*     */         }
/*     */         
/* 264 */         if (count >= additionMax) {
/* 265 */           switch (this.effectGroupCfg.additionMaxOPER)
/*     */           {
/*     */           case 1: 
/*     */             break;
/*     */           case 2: 
/* 270 */             if (!addBuffOutPutObj.canAddBuff) break;
/* 271 */             trueTargetFighter.removeFirstBuff(status);
/* 272 */             attached = trueTargetFighter.attachBuff(fighterBuff); break;
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*     */           
/* 280 */         } else if (addBuffOutPutObj.canAddBuff) {
/* 281 */           attached = trueTargetFighter.attachBuff(fighterBuff);
/*     */         }
/*     */         else {
/* 284 */           skill.addImmuneRet(releaser, trueTargetFighter);
/*     */         }
/*     */         
/*     */ 
/*     */         break;
/*     */       }
/*     */       
/*     */       
/* 292 */       int trueFighterid = trueTargetFighter.getid();
/* 293 */       if (skill.getTargets().contains(Integer.valueOf(trueFighterid))) {
/* 294 */         AttackResult attackResult = skill.getAttackResult(trueTargetFighter.getid());
/* 295 */         if (attackResult.attackresultbeans.size() > 0) {
/* 296 */           ((AttackResultBean)attackResult.attackresultbeans.get(0)).targetstatus.triggerpassiveskills.addAll(addBuffOutPutObj.targetTiggerPassiveSkills);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 301 */       if ((attached) && (fighterBuff.getEffectGroupType() == 8)) {
/* 302 */         trueTargetFighter.afterSealed(skill, releaser);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 307 */     return fighterBuff;
/*     */   }
/*     */   
/*     */   public FighterBuff run(int skillLv, Fighter releaser, Fighter target, int mainTargetid) {
/* 311 */     Skill skill = SkillInterface.getSkill(SFightConsts.getInstance().ATTACK_SKILL, skillLv);
/* 312 */     return run(skill, releaser, target, mainTargetid);
/*     */   }
/*     */   
/*     */   public boolean isTargetReleaser() {
/* 316 */     return this.effectGroupCfg.targettype == 2;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\main\FighterEffectGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */