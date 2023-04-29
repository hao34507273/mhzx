/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.children.main.ChildrenOutFightObj;
/*     */ import mzm.gsp.common.IOutFightObject;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ 
/*     */ class CloneFighterChild extends Fighter implements CloneFighter
/*     */ {
/*     */   CloneFighterChild(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*     */   {
/*  18 */     super(fighterid, xFighter, fightGroup);
/*  19 */     setExtra(FighterExtra.CLONE_MINI_TYPE, 16);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void init(ChildrenOutFightObj child, int pos, Map<Integer, Integer> attrsMap, Map<Integer, Integer> exaAttrsMap)
/*     */   {
/*  26 */     setPos(pos);
/*  27 */     long childid = child.getId();
/*     */     
/*  29 */     setUuid(childid);
/*     */     
/*  31 */     getAttrsMap().putAll(attrsMap);
/*     */     
/*  33 */     getExa_AttrsMap().putAll(exaAttrsMap);
/*     */     
/*  35 */     setHp((int)getMaxHp());
/*  36 */     setMp((int)getMaxMp());
/*  37 */     setAnger(0.0D);
/*  38 */     setGender(child);
/*  39 */     setOccupation(-1);
/*     */     
/*  41 */     Map<Integer, Integer> skill2LvMap = child.getActiveSkillMap();
/*  42 */     addAllSkill(skill2LvMap);
/*     */     
/*  44 */     java.util.List<PassiveSkill> passiveSkills = child.getPassiveSkills();
/*  45 */     installPassiveSkills(passiveSkills);
/*  46 */     initOutFightCommon(child);
/*     */   }
/*     */   
/*     */   private long getOwnerid()
/*     */   {
/*  51 */     return this.fightGroup.getRoleid();
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean canPlayerOperate()
/*     */   {
/*  57 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean isAuto()
/*     */   {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected int getAutoSkill()
/*     */   {
/*  69 */     for (Iterator i$ = getActiveSkills().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */       
/*  71 */       int skillLV = getSkillLevel(skillid);
/*  72 */       Skill skill = SkillInterface.getSkill(skillid, skillLV);
/*  73 */       if (canChoiceSkill(skill))
/*     */       {
/*  75 */         return skillid;
/*     */       }
/*     */     }
/*  78 */     return getNormalSkill();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void setAuto() {}
/*     */   
/*     */ 
/*     */ 
/*     */   void onDead()
/*     */   {
/*  89 */     if (isNotLeave())
/*     */     {
/*  91 */       setFakeDead();
/*     */     }
/*     */     else
/*     */     {
/*  95 */       setDead();
/*     */     }
/*  97 */     super.onFighterDead();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onFightEnd()
/*     */   {
/* 103 */     this.fightGroup.addLeaveFightFighter(this);
/* 104 */     this.fightGroup.removeFighter(this.fighterid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected IOutFightObject getOutFightObj()
/*     */   {
/* 116 */     return ChildrenInterface.getChildrenOutFightObj(getOwnerid(), getUuid(), false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void broadCastSelectOperInTeam() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isMyOwner(Fighter fighter)
/*     */   {
/* 127 */     if (this.fightGroup.groupid != fighter.fightGroup.groupid)
/*     */     {
/* 129 */       return false;
/*     */     }
/* 131 */     if ((fighter instanceof FighterRole))
/*     */     {
/* 133 */       return true;
/*     */     }
/* 135 */     if ((fighter instanceof CloneFighterRole))
/*     */     {
/* 137 */       return true;
/*     */     }
/* 139 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   void initChangeModelCard()
/*     */   {
/* 145 */     initChangeModelCard(SChildrenConsts.getInstance().cardClassType, SChildrenConsts.getInstance().cardLevel);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\CloneFighterChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */