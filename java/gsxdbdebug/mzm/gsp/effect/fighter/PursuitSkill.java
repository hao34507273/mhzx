/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.formula.fighter.EffectFormula;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.fight.Play;
/*     */ import mzm.gsp.fight.PlaySkill;
/*     */ import mzm.gsp.fight.handle.AftUseSkilHandle;
/*     */ import mzm.gsp.fight.handle.AftUseSkilHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.AftUseSkilHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle;
/*     */ import mzm.gsp.fight.handle.DamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupSubCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ public class PursuitSkill extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.RoundStartHandle, DamageHandle, AftUseSkilHandle
/*     */ {
/*     */   private int skillid1;
/*     */   private int skillid2;
/*     */   private int fighterId;
/*     */   private boolean isFirst;
/*     */   private boolean isDamage;
/*     */   private boolean isHeal;
/*     */   
/*     */   public PursuitSkill(int paramInt1, int paramInt2)
/*     */   {
/*  36 */     this.skillid1 = paramInt1;
/*  37 */     this.skillid2 = paramInt2;
/*  38 */     this.fighterId = 0;
/*  39 */     this.isFirst = true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter paramFighter) {
/*  43 */     this.fighterId = paramFighter.getid();
/*  44 */     paramFighter.addRoundStartHandle(this);
/*  45 */     paramFighter.addDamageHandle(this);
/*  46 */     paramFighter.addAftUseSkillHandle(this);
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter paramFighter) {
/*  51 */     this.fighterId = 0;
/*  52 */     paramFighter.remRoundStartHandle(this);
/*  53 */     paramFighter.remDamageHandle(this);
/*  54 */     paramFighter.remAftUseSkillHandle(this);
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public void onDamage(DamageHandle.InputObj paramInputObj, DamageHandle.OutputObj paramOutputObj) {
/*  59 */     Fighter localFighter = paramInputObj.getReleser();
/*  60 */     if (localFighter == null) {
/*  61 */       return;
/*     */     }
/*     */     
/*  64 */     if ((localFighter.getid() == this.fighterId) && (paramInputObj.getDamage() > 0))
/*  65 */       this.isDamage = true;
/*     */   }
/*     */   
/*     */   public void onRoundStart(Fighter paramFighter) {
/*  69 */     this.isFirst = true;
/*  70 */     this.isDamage = false;
/*  71 */     this.isHeal = false;
/*     */   }
/*     */   
/*     */   public void aftUseSkill(AftUseSkilHandle.InputObj paramInputObj, AftUseSkilHandle.OutputObj paramOutputObj)
/*     */   {
/*  76 */     Skill localSkill = paramInputObj.getSkill();
/*  77 */     if (localSkill == null)
/*  78 */       return;
/*  79 */     if (mzm.gsp.fight.main.FightInterface.isNormalAttackSkill(localSkill.getID()))
/*  80 */       return;
/*  81 */     Fighter localFighter = paramInputObj.getReleser();
/*  82 */     if (localFighter == null) {
/*  83 */       return;
/*     */     }
/*  85 */     if (localFighter.getid() != this.fighterId) {
/*  86 */       return;
/*     */     }
/*  88 */     if (!this.isFirst)
/*  89 */       return;
/*  90 */     this.isFirst = false;
/*     */     
/*  92 */     int i = 0;
/*  93 */     Object localObject1; Object localObject2; Object localObject3; Object localObject4; Object localObject5; Object localObject6; Object localObject7; if (this.isDamage)
/*     */     {
/*  95 */       i = this.skillid2;
/*     */     }
/*     */     else
/*     */     {
/*  99 */       localSkill.getSkillCfg(); for (Iterator localIterator1 = SSkillCfg.getAll().values().iterator(); localIterator1.hasNext();) { localObject1 = (SSkillCfg)localIterator1.next();
/* 100 */         for (localObject2 = ((SSkillCfg)localObject1).skillEffectGroupId.iterator(); ((Iterator)localObject2).hasNext();) {
/* 101 */           int j = ((Integer)((Iterator)localObject2).next()).intValue();
/* 102 */           localObject3 = SSkillEffectGroupCfg.get(j);
/* 103 */           for (localObject4 = ((SSkillEffectGroupCfg)localObject3).effectgroupsub.iterator(); ((Iterator)localObject4).hasNext();) {
/* 104 */             int i1 = ((Integer)((Iterator)localObject4).next()).intValue();
/* 105 */             localObject5 = SSkillEffectGroupSubCfg.get(i1);
/* 106 */             localObject6 = new ArrayList();
/* 107 */             for (localObject7 = ((SSkillEffectGroupSubCfg)localObject5).effectformula.iterator(); ((Iterator)localObject7).hasNext();) {
/* 108 */               int i2 = ((Integer)((Iterator)localObject7).next()).intValue();
/* 109 */               EffectFormula localEffectFormula = EffectInterface.getFighterEffectFormula(i2);
/* 110 */               if (localEffectFormula == null) {
/*     */                 break;
/*     */               }
/* 113 */               ((List)localObject6).add(Integer.valueOf(localEffectFormula.getParamConst()));
/*     */             }
/* 115 */             localObject7 = EffectInterface.getFighterEffectInstance(((SSkillEffectGroupSubCfg)localObject5).effectid, (List)localObject6);
/* 116 */             if ((localObject7 instanceof mzm.gsp.effect.fighter.Interface.HealType)) {
/* 117 */               this.isHeal = true;
/* 118 */               break;
/*     */             }
/*     */           }
/* 121 */           if (this.isHeal)
/*     */             break;
/*     */         }
/* 124 */         if (this.isHeal) {
/*     */           break;
/*     */         }
/*     */       }
/* 128 */       if (this.isHeal) {
/* 129 */         i = this.skillid1;
/*     */       }
/*     */     }
/* 132 */     boolean bool = localFighter.isRecordEnable();
/* 133 */     if (i != 0)
/*     */     {
/* 135 */       localObject1 = mzm.gsp.skill.main.SkillInterface.getSkill(i, localSkill.getLevel());
/* 136 */       localObject2 = new ArrayList();
/*     */       Iterator localIterator2;
/* 138 */       if (this.isDamage) {
/* 139 */         for (localIterator2 = localSkill.getTargets().iterator(); localIterator2.hasNext();) { localObject3 = (Integer)localIterator2.next();
/* 140 */           localObject4 = localFighter.getFighter(((Integer)localObject3).intValue());
/* 141 */           ((List)localObject2).add(localObject4);
/*     */         }
/*     */       } else {
/* 144 */         ((List)localObject2).add(localFighter);
/*     */       }
/*     */       
/* 147 */       if (!localFighter.canNormalUseSkillWithRestWeak((Skill)localObject1))
/* 148 */         return;
/* 149 */       if (((Skill)localObject1).canRun(localFighter, paramInputObj.getMainTargetId(), (List)localObject2, false)) {
/* 150 */         ((Skill)localObject1).setPlayType(3);
/* 151 */         localFighter.fillFighterStatus(((Skill)localObject1).getSkillUseFighterStatus());
/* 152 */         ((Skill)localObject1).skillOnTarget(localFighter, (List)localObject2);
/* 153 */         localFighter.addActionCount();
/* 154 */         localFighter.fillFighterStatus(((Skill)localObject1).getAfterSkillUseFighterStatus());
/* 155 */         localFighter.handleDeathSkill(localFighter, (Skill)localObject1);
/* 156 */         int k = localFighter.getid();
/* 157 */         localObject3 = new PlaySkill();
/* 158 */         Fighter.fillSkillResult((PlaySkill)localObject3, (Skill)localObject1, k);
/* 159 */         ((Skill)localObject1).addAllCounterAttackMultiPlayType(localFighter);
/* 160 */         if (localSkill.getActivePlays().size() < 1) {
/* 161 */           int m = localSkill.calSkillReliveTimeBetweenSkills(localFighter, (Skill)localObject1, localFighter);
/* 162 */           localSkill.addPlayTime(m); }
/*     */         Play localPlay;
/* 164 */         if (localFighter.canSeeOppsiteHpProp()) {
/* 165 */           localPlay = new Play();
/* 166 */           localPlay.play_type = 0;
/* 167 */           localPlay.content = ((PlaySkill)localObject3).marshal(new OctetsStream());
/* 168 */           localSkill.addPlay(localPlay, true);
/* 169 */           localSkill.addPlay(localPlay, false);
/* 170 */           if (bool)
/* 171 */             localSkill.addPlay(localPlay);
/*     */         } else {
/* 173 */           localPlay = new Play();
/* 174 */           PlaySkill localPlaySkill = localFighter.getOppsitePalySkill((PlaySkill)localObject3, true);
/* 175 */           localPlay.play_type = 0;
/* 176 */           localPlay.content = localPlaySkill.marshal(new OctetsStream());
/* 177 */           localSkill.addPlay(localPlay, true);
/* 178 */           localObject5 = new Play();
/* 179 */           localObject6 = localFighter.getOppsitePalySkill((PlaySkill)localObject3, false);
/* 180 */           ((Play)localObject5).play_type = 0;
/* 181 */           ((Play)localObject5).content = ((PlaySkill)localObject6).marshal(new OctetsStream());
/* 182 */           localSkill.addPlay((Play)localObject5, false);
/* 183 */           if (bool) {
/* 184 */             localObject7 = new Play();
/* 185 */             ((Play)localObject7).play_type = 0;
/* 186 */             ((Play)localObject7).content = ((PlaySkill)localObject3).marshal(new OctetsStream());
/* 187 */             localSkill.addPlay((Play)localObject7);
/*     */           }
/*     */         }
/* 190 */         localSkill.addAllPlay(((Skill)localObject1).getActivePlays(), true);
/* 191 */         localSkill.addAllPlay(((Skill)localObject1).getPassivePlays(), false);
/* 192 */         if (bool)
/* 193 */           localSkill.addAllPlay(((Skill)localObject1).getRecordPlays());
/* 194 */         localSkill.addPlayTime(((Skill)localObject1).getPlayTime());
/* 195 */         int n = getPassiveSkillid();
/* 196 */         if (n > 0) {
/* 197 */           paramOutputObj.releaserPassiveSkills.add(Integer.valueOf(n));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\PursuitSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */