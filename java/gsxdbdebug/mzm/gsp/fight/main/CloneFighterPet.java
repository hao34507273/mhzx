/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.common.IOutFightObject;
/*     */ import mzm.gsp.pet.confbean.SPetCfg;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.pet.main.PetOutFightObj;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ 
/*     */ class CloneFighterPet extends Fighter implements CloneFighter
/*     */ {
/*     */   CloneFighterPet(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*     */   {
/*  18 */     super(fighterid, xFighter, fightGroup);
/*  19 */     setExtra(FighterExtra.CLONE_MINI_TYPE, 4);
/*     */   }
/*     */   
/*     */   protected void init(Pet pet, int pos, Map<Integer, Integer> attrsMap, Map<Integer, Integer> exaAttrsMap)
/*     */   {
/*  24 */     setPos(pos);
/*     */     
/*  26 */     setUuid(pet.getId());
/*  27 */     setExtra(FighterExtra.PET_CFG_ID, pet.getCfgId());
/*     */     
/*  29 */     getAttrsMap().putAll(attrsMap);
/*     */     
/*  31 */     getExa_AttrsMap().putAll(exaAttrsMap);
/*     */     
/*  33 */     setHp((int)getMaxHp());
/*  34 */     setMp((int)getMaxMp());
/*  35 */     setAnger(0.0D);
/*  36 */     setOccupation(-1);
/*  37 */     PetOutFightObj outFightObj = PetInterface.getPetOutFightObjById(getOwnerid(), pet.getId());
/*  38 */     setGender(outFightObj);
/*     */     
/*     */ 
/*  41 */     List<Integer> skillsList = PetInterface.getPetSkillList(getOwnerid(), pet.getId());
/*     */     
/*     */ 
/*  44 */     for (Iterator i$ = skillsList.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*  45 */       addSkill(skillid, outFightObj.getLevel());
/*     */     }
/*     */     
/*  48 */     List<mzm.gsp.skill.main.PassiveSkill> passiveSkills = outFightObj.getPassiveSkills();
/*  49 */     installPassiveSkills(passiveSkills);
/*  50 */     initOutFightCommon(outFightObj);
/*     */   }
/*     */   
/*     */   protected long getOwnerid() {
/*  54 */     return this.fightGroup.getRoleid();
/*     */   }
/*     */   
/*     */   protected boolean canPlayerOperate()
/*     */   {
/*  59 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean isAuto()
/*     */   {
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   protected int getAutoSkill()
/*     */   {
/*  69 */     for (Iterator i$ = getActiveSkills().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*  70 */       int skillLV = getSkillLevel(skillid);
/*  71 */       Skill skill = SkillInterface.getSkill(skillid, skillLV);
/*  72 */       if (canChoiceSkill(skill)) {
/*  73 */         return skillid;
/*     */       }
/*     */     }
/*  76 */     return getNormalSkill();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void setAuto() {}
/*     */   
/*     */ 
/*     */   void onDead()
/*     */   {
/*  85 */     if (isNotLeave()) {
/*  86 */       setFakeDead();
/*     */     } else {
/*  88 */       setDead();
/*     */     }
/*  90 */     super.onFighterDead();
/*     */   }
/*     */   
/*     */   protected void onFightEnd()
/*     */   {
/*  95 */     this.fightGroup.addLeaveFightFighter(this);
/*  96 */     this.fightGroup.removeFighter(this.fighterid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected IOutFightObject getOutFightObj()
/*     */   {
/* 106 */     return PetInterface.getPetOutFightObjById(getOwnerid(), getUuid());
/*     */   }
/*     */   
/*     */ 
/*     */   void broadCastSelectOperInTeam() {}
/*     */   
/*     */ 
/*     */   public boolean isMyOwner(Fighter fighter)
/*     */   {
/* 115 */     if (this.fightGroup.groupid != fighter.fightGroup.groupid) {
/* 116 */       return false;
/*     */     }
/* 118 */     if ((fighter instanceof FighterRole)) {
/* 119 */       return true;
/*     */     }
/* 121 */     if ((fighter instanceof CloneFighterRole)) {
/* 122 */       return true;
/*     */     }
/* 124 */     return false;
/*     */   }
/*     */   
/*     */   void initChangeModelCard()
/*     */   {
/* 129 */     SPetCfg cfg = SPetCfg.get(getExtra(FighterExtra.PET_CFG_ID));
/* 130 */     int cardClassType = cfg.change_model_card_class_type;
/* 131 */     int cardLevel = cfg.change_model_card_level;
/* 132 */     initChangeModelCard(cardClassType, cardLevel);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\CloneFighterPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */