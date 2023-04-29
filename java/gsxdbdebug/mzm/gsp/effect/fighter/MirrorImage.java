/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.Buff;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import xbean.FighterOutFightInfo;
/*     */ 
/*     */ public class MirrorImage extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.RoundEndHandle, mzm.gsp.effect.fighter.Interface.OpPrepare
/*     */ {
/*     */   private int mirrorTargetFid;
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  26 */     fighter.addRoundEndHandle(this);
/*     */     
/*  28 */     Fighter releaser = fighter;
/*  29 */     Fighter target = fighter.getFighterFromAll(this.mirrorTargetFid);
/*  30 */     if (target == null) {
/*  31 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  36 */     releaser.setGender(target.getGender());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  41 */     releaser.setOccupation(target.getOccupation());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  46 */     Set<Map.Entry<Integer, Integer>> releaserEntrySet = releaser.getActiveSkillMap().entrySet();
/*  47 */     Iterator<Map.Entry<Integer, Integer>> it = releaserEntrySet.iterator();
/*     */     
/*  49 */     while (it.hasNext()) {
/*  50 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/*  51 */       int skillId = Fighter.convertToSourceSkill(((Integer)entry.getKey()).intValue()).intValue();
/*  52 */       boolean isMenpaiSkill = SkillInterface.isMenpaiSkill(skillId);
/*  53 */       boolean isUltimateSkill = SkillInterface.isUltimateSkill(skillId);
/*     */       
/*  55 */       if (((isMenpaiSkill) && (!isUltimateSkill)) || (FightInterface.isNormalAttackSkill(skillId))) {
/*  56 */         it.remove();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  61 */     Set<Map.Entry<Integer, Integer>> entrySet = target.getActiveSkillMap().entrySet();
/*  62 */     for (Map.Entry<Integer, Integer> entry : entrySet) {
/*  63 */       int skillId = Fighter.convertToSourceSkill(((Integer)entry.getKey()).intValue()).intValue();
/*  64 */       int skillLevel = ((Integer)entry.getValue()).intValue();
/*  65 */       boolean isMenpaiSkill = SkillInterface.isMenpaiSkill(skillId);
/*  66 */       boolean isUltimateSkill = SkillInterface.isUltimateSkill(skillId);
/*  67 */       if (((isMenpaiSkill) && (!isUltimateSkill)) || (FightInterface.isNormalAttackSkill(skillId))) {
/*  68 */         releaser.addSkill(((Integer)entry.getKey()).intValue(), skillLevel);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  74 */     int fightGroup = target.getDefaultFightStateGroup();
/*  75 */     if (fightGroup != 0) {
/*  76 */       mzm.gsp.fight.main.Fighter.FightState fightState = releaser.getFightState(fightGroup);
/*  77 */       if (fightState == null) {
/*  78 */         int fightGroupState = target.getDefaultFightStateGroup();
/*  79 */         releaser.addFightStateGroupIfGroupNotExsit(fightGroup, fightGroupState);
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
/*  90 */     Fighter rootMirrorFighter = target.getMirrorFighter();
/*  91 */     int mirrorFighterId = 0;
/*  92 */     if (rootMirrorFighter == null) {
/*  93 */       mirrorFighterId = target.getid();
/*     */     } else {
/*  95 */       mirrorFighterId = rootMirrorFighter.getid();
/*     */     }
/*  97 */     releaser.addMirrorFighter(mirrorFighterId);
/*  98 */     releaser.addBuffState(135);
/*     */     
/*     */ 
/* 101 */     FighterBuff buff = getGroup();
/* 102 */     if (buff != null) {
/* 103 */       Skill skill = buff.getSkill();
/* 104 */       if (skill != null) {
/* 105 */         AttackResult attackResult = skill.getAttackResult(target.getid());
/* 106 */         if (attackResult != null) {
/* 107 */           AttackResultBean attackResultBean = null;
/* 108 */           int size = attackResult.attackresultbeans.size();
/* 109 */           if (size > 0) {
/* 110 */             attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(size - 1);
/*     */           } else {
/* 112 */             attackResultBean = new AttackResultBean();
/* 113 */             releaser.fillFighterStatus(attackResultBean.attackerstatus);
/* 114 */             target.fillFighterStatus(attackResultBean.targetstatus);
/* 115 */             attackResult.attackresultbeans.add(attackResultBean);
/*     */           }
/*     */           
/* 118 */           Buff mirrorInfo = new Buff();
/* 119 */           mirrorInfo.buffid = -60;
/* 120 */           mirrorInfo.round = mirrorFighterId;
/* 121 */           Fighter.addFighterStatusBuffbean(attackResultBean.attackerstatus, mirrorInfo);
/*     */           
/* 123 */           attackResultBean.attackerstatus.buff_status_set.add(Integer.valueOf(135));
/*     */           
/*     */ 
/* 126 */           int code = releaser.synSkill(true);
/* 127 */           Buff skillRefresh = new Buff();
/* 128 */           skillRefresh.buffid = -61;
/* 129 */           skillRefresh.round = code;
/* 130 */           Fighter.addFighterStatusBuffbean(attackResultBean.attackerstatus, skillRefresh);
/*     */         }
/* 132 */         if ((null != skill.getTargets()) && (!skill.getTargets().contains(Integer.valueOf(this.mirrorTargetFid)))) {
/* 133 */           skill.getTargets().add(Integer.valueOf(this.mirrorTargetFid));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 138 */     releaser.refreshAuto();
/*     */     
/* 140 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 146 */     fighter.remRoundEndHandle(this);
/* 147 */     clearMirror(fighter);
/*     */     
/* 149 */     FighterBuff buff = getGroup();
/* 150 */     if (buff == null) {
/* 151 */       return true;
/*     */     }
/*     */     
/* 154 */     FighterBuff replaceBuff = FighterEffectGroup.getReplaceContext();
/* 155 */     if (null != replaceBuff)
/*     */     {
/* 157 */       Fighter replaceBuffReleaser = replaceBuff.getReleaser(fighter);
/* 158 */       Fighter releaser = buff.getReleaser(fighter);
/* 159 */       if ((null != releaser) && (null != replaceBuffReleaser) && (replaceBuffReleaser.getid() == releaser.getid())) {
/* 160 */         Skill replaceBuffSkill = replaceBuff.getSkill();
/* 161 */         if (replaceBuffSkill != null) {
/* 162 */           int code = releaser.synSkill(true);
/* 163 */           FighterStatus fighterStatus = replaceBuffSkill.getSkillUseFighterStatus();
/* 164 */           releaser.fillFighterStatus(fighterStatus);
/*     */           
/* 166 */           Buff mirrorInfo = new Buff();
/* 167 */           mirrorInfo.buffid = -60;
/* 168 */           mirrorInfo.round = releaser.getid();
/* 169 */           Fighter.addFighterStatusBuffbean(fighterStatus, mirrorInfo);
/*     */           
/* 171 */           Buff skillRefresh = new Buff();
/* 172 */           skillRefresh.buffid = -61;
/* 173 */           skillRefresh.round = code;
/* 174 */           Fighter.addFighterStatusBuffbean(fighterStatus, skillRefresh);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 179 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void onRoundEnd(Fighter fighter)
/*     */   {
/* 185 */     if (getLeftRound() > 1) {
/* 186 */       return;
/*     */     }
/* 188 */     FighterBuff buff = getGroup();
/* 189 */     if (buff == null) {
/* 190 */       return;
/*     */     }
/* 192 */     Fighter releaser = buff.getReleaser(fighter);
/* 193 */     if (releaser == null) {
/* 194 */       return;
/*     */     }
/* 196 */     clearMirror(fighter);
/*     */     
/* 198 */     Skill skill = getGroup().getSkill();
/* 199 */     if (skill != null) {
/* 200 */       int code = releaser.synSkill(true);
/* 201 */       FighterStatus fighterStatus = releaser.getAndAddRoundStatus();
/* 202 */       releaser.fillFighterStatus(fighterStatus);
/*     */       
/* 204 */       Buff mirrorInfo = new Buff();
/* 205 */       mirrorInfo.buffid = -60;
/* 206 */       mirrorInfo.round = releaser.getid();
/*     */       
/* 208 */       Buff skillRefresh = new Buff();
/* 209 */       skillRefresh.buffid = -61;
/* 210 */       skillRefresh.round = code;
/* 211 */       releaser.addRoundFighterStatusBuff(mirrorInfo);
/* 212 */       releaser.addRoundFighterStatusBuff(skillRefresh);
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean clearMirror(Fighter fighter)
/*     */   {
/* 218 */     FighterBuff buff = getGroup();
/* 219 */     if (buff == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     Fighter releaser = buff.getReleaser(fighter);
/* 223 */     if (releaser == null) {
/* 224 */       return false;
/*     */     }
/*     */     
/* 227 */     Fighter mirrorFighter = releaser.getMirrorFighter();
/* 228 */     if (null == mirrorFighter) {
/* 229 */       return false;
/*     */     }
/*     */     
/* 232 */     FighterOutFightInfo xOutFight = releaser.getOutFight();
/*     */     
/*     */ 
/* 235 */     releaser.getActiveSkillMap().clear();
/* 236 */     releaser.getActiveSkillMap().putAll(xOutFight.getSkills());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 241 */     releaser.setGender(xOutFight.getGender());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 246 */     releaser.setOccupation(xOutFight.getOcp());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 251 */     int defaultGroup = releaser.getDefaultFightStateGroup();
/* 252 */     int state = releaser.getDefaultFightState();
/* 253 */     releaser.removeAllFightState();
/* 254 */     releaser.updateFightStateGroup(defaultGroup, state);
/*     */     
/* 256 */     releaser.removeMirrorFighter();
/*     */     
/*     */ 
/* 259 */     releaser.remBuffState(135);
/*     */     
/*     */ 
/* 262 */     FighterBuff houfaBuff = releaser.getHouFaBuff();
/* 263 */     if (null != houfaBuff) {
/* 264 */       releaser.removeBuff(houfaBuff);
/*     */     }
/*     */     
/* 267 */     releaser.refreshAuto();
/* 268 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean prepare(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter trueTarget, Fighter target)
/*     */   {
/* 274 */     this.mirrorTargetFid = target.getid();
/* 275 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MirrorImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */