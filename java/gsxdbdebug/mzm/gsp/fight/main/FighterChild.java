/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.children.main.ChildrenOutFightObj;
/*     */ import mzm.gsp.common.IOutFightObject;
/*     */ import mzm.gsp.fight.SSelectOperateBrd;
/*     */ import mzm.gsp.fight.SSynRoleChildSkillInfo;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightCache;
/*     */ import xbean.FightCmd;
/*     */ 
/*     */ final class FighterChild extends Fighter
/*     */ {
/*     */   FighterChild(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*     */   {
/*  32 */     super(fighterid, xFighter, fightGroup);
/*     */   }
/*     */   
/*     */   protected boolean canPlayerOperate()
/*     */   {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   protected void init(ChildrenOutFightObj child, int pos)
/*     */   {
/*  42 */     setPos(pos);
/*     */     
/*  44 */     long childid = child.getId();
/*     */     
/*     */ 
/*  47 */     setUuid(childid);
/*     */     
/*     */ 
/*  50 */     setHp(Math.min(child.getHP(), child.getFinalMaxHP()));
/*  51 */     setMp(Math.min(child.getMP(), child.getFinalMaxMP()));
/*  52 */     setAnger(0.0D);
/*  53 */     setGender(child);
/*  54 */     setOccupation(child.getOccupationId());
/*     */     
/*  56 */     child.fillFinalPropertyMap(getAttrsMap());
/*     */     
/*  58 */     Map<Integer, Integer> skill2LvMap = child.getActiveSkillMap();
/*  59 */     addAllSkill(skill2LvMap);
/*     */     
/*  61 */     child.setFightFlag(true);
/*     */     
/*     */ 
/*  64 */     SSynRoleChildSkillInfo synRoleChildSkillInfo = new SSynRoleChildSkillInfo();
/*  65 */     synRoleChildSkillInfo.fight_uuid = this.fightGroup.fightTeam.getFight().fightid;
/*  66 */     synRoleChildSkillInfo.childrenuuid = childid;
/*  67 */     synRoleChildSkillInfo.skillmap.putAll(skill2LvMap);
/*  68 */     OnlineManager.getInstance().send(getOwnerid(), synRoleChildSkillInfo);
/*     */     
/*     */ 
/*  71 */     FightCache xFightCache = getFightCache();
/*  72 */     validateAutoSkill(childid, xFightCache, skill2LvMap.keySet());
/*  73 */     boolean needSetAutoSkill = (xFightCache == null) || (!xFightCache.getChild_default_skills().containsKey(Long.valueOf(childid)));
/*  74 */     Iterator i$; if (needSetAutoSkill) {
/*  75 */       for (i$ = skill2LvMap.keySet().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*  76 */         SSkillCfg skillCfg = SSkillCfg.get(skillid);
/*  77 */         if (skillCfg.canAuto)
/*     */         {
/*     */ 
/*  80 */           setLastCanAutoSkill(skillid);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  85 */     if (!xFightCache.getChild_default_skills().containsKey(Long.valueOf(childid))) {
/*  86 */       setLastCanAutoSkill(getNormalSkill());
/*     */     }
/*  88 */     if ((needSetAutoSkill) && (xFightCache != null) && 
/*  89 */       (xFightCache.getIsauto())) {
/*  90 */       FightInterface.syncAutoState(getOwnerid(), xFightCache);
/*     */     }
/*     */     
/*     */ 
/*  94 */     List<PassiveSkill> passiveSkills = child.getPassiveSkills();
/*  95 */     installPassiveSkills(passiveSkills);
/*  96 */     initOutFightCommon(child);
/*     */   }
/*     */   
/*     */   private void validateAutoSkill(long childid, FightCache xFightCache, Collection<Integer> skills) {
/* 100 */     if (xFightCache != null)
/*     */     {
/* 102 */       Integer autoSkill = (Integer)xFightCache.getChild_default_skills().get(Long.valueOf(childid));
/* 103 */       if (autoSkill != null) {
/* 104 */         if (FightManager.isCommonSkill(autoSkill.intValue(), getOccupation())) {
/* 105 */           return;
/*     */         }
/* 107 */         if (!skills.contains(autoSkill)) {
/* 108 */           xFightCache.getChild_default_skills().remove(Long.valueOf(childid));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final long getOwnerid()
/*     */   {
/* 120 */     return this.fightGroup.getRoleid();
/*     */   }
/*     */   
/*     */   protected IOutFightObject getOutFightObj()
/*     */   {
/* 125 */     return ChildrenInterface.getChildrenOutFightObj(getOwnerid(), getUuid(), false);
/*     */   }
/*     */   
/*     */   protected boolean isAuto()
/*     */   {
/* 130 */     FightCache fightCache = getFightCache();
/* 131 */     if (fightCache != null) {
/* 132 */       return fightCache.getIsauto();
/*     */     }
/* 134 */     return false;
/*     */   }
/*     */   
/*     */   protected int getAutoSkill()
/*     */   {
/* 139 */     FightCache fightCache = getFightCache();
/* 140 */     if (fightCache == null) {
/* 141 */       return getCfgDefaultSkill();
/*     */     }
/* 143 */     long childid = getUuid();
/* 144 */     if (fightCache.getChild_default_skills().containsKey(Long.valueOf(childid))) {
/* 145 */       return ((Integer)fightCache.getChild_default_skills().get(Long.valueOf(childid))).intValue();
/*     */     }
/* 147 */     int skill = getCfgDefaultSkill();
/* 148 */     fightCache.getChild_default_skills().put(Long.valueOf(childid), Integer.valueOf(skill));
/*     */     
/* 150 */     FightInterface.syncAutoState(getOwnerid());
/* 151 */     return skill;
/*     */   }
/*     */   
/*     */   protected void setAutoSkill(int skillid)
/*     */   {
/* 156 */     if (hasSkill(skillid)) {
/* 157 */       FightCache fightCache = getFightCache();
/* 158 */       if (fightCache == null) {
/* 159 */         return;
/*     */       }
/* 161 */       long childid = getUuid();
/* 162 */       fightCache.getChild_default_skills().put(Long.valueOf(childid), Integer.valueOf(skillid));
/*     */       
/* 164 */       sendDefalutSkillChangeRes(getOwnerid(), skillid, childid, 16);
/*     */     } else {
/* 166 */       sendDefalutSkillChangeRes(getOwnerid(), getAutoSkill(), getUuid(), 16);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setLastCanAutoSkill(int skillid)
/*     */   {
/* 179 */     SSkillCfg skillCfg = SSkillCfg.get(skillid);
/* 180 */     if (skillCfg == null) {
/* 181 */       return;
/*     */     }
/* 183 */     if ((skillCfg.canAuto) && 
/* 184 */       (hasSkill(skillid))) {
/* 185 */       FightCache fightCache = getFightCache();
/* 186 */       if (fightCache == null) {
/* 187 */         return;
/*     */       }
/* 189 */       fightCache.getChild_default_skills().put(Long.valueOf(getUuid()), Integer.valueOf(skillid));
/*     */     }
/*     */   }
/*     */   
/*     */   private FightCache getFightCache()
/*     */   {
/* 195 */     if ((this.fightGroup instanceof FightGroupRole)) {
/* 196 */       return ((FightGroupRole)this.fightGroup).createXFightCacheIfNotExist();
/*     */     }
/* 198 */     return null;
/*     */   }
/*     */   
/*     */   protected void setAuto()
/*     */   {
/* 203 */     if ((this.fightGroup instanceof FightGroupRole)) {
/* 204 */       ((FightGroupRole)this.fightGroup).setAuto(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setDefautOper()
/*     */   {
/* 216 */     if (!isExisted()) {
/* 217 */       return;
/*     */     }
/* 219 */     AI ai = getAI();
/* 220 */     if (ai != null) {
/* 221 */       ai.onRoundBegin(this.fightGroup.getFight(), this);
/*     */     }
/* 223 */     if (!this.fightGroup.getFight().hasFightCmd(this.fighterid))
/*     */     {
/* 225 */       long roleid = this.fightGroup.getRoleid();
/*     */       
/* 227 */       if (!PetInterface.isPetBagFull(roleid)) {
/* 228 */         for (Fighter fighter : getEnermyLiveFighters()) {
/* 229 */           if ((fighter instanceof FighterMonster)) {
/* 230 */             FighterMonster fighterMonster = (FighterMonster)fighter;
/* 231 */             if (MonsterInterface.isMonsterCanAutoCatch(fighterMonster.getMonsterid(), getOwnerLevel()))
/*     */             {
/* 233 */               Op_UseSkill opUseSkill = new Op_UseSkill();
/* 234 */               opUseSkill.main_target = this.fighterid;
/* 235 */               opUseSkill.skill = SFightConsts.getInstance().DEFENCE_SKILL;
/* 236 */               if (hasSkill(opUseSkill.skill)) {
/* 237 */                 opUseSkill.skillLv = fighter.getSkillLevel(opUseSkill.skill);
/*     */               }
/* 239 */               this.fightGroup.getFight().addFightCmd(this.fighterid, 0, opUseSkill);
/*     */               
/* 241 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 249 */     if (!this.fightGroup.getFight().hasFightCmd(this.fighterid))
/*     */     {
/* 251 */       super.setDefautOper();
/*     */     }
/*     */   }
/*     */   
/*     */   int getOwnerLevel()
/*     */   {
/* 257 */     for (Fighter fighter : this.fightGroup.getFighters()) {
/* 258 */       if (fighter.isRoleType()) {
/* 259 */         return fighter.getLevel();
/*     */       }
/*     */     }
/* 262 */     return getLevel();
/*     */   }
/*     */   
/*     */   protected void onFightEnd()
/*     */   {
/* 267 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightGroup.getFight().getCfgType());
/*     */     
/* 269 */     ChildrenOutFightObj childrenOutFightObj = null;
/* 270 */     long roleid = getOwnerid();
/* 271 */     long childid = getUuid();
/* 272 */     FightCache xFightCache = getFightCache();
/*     */     try {
/* 274 */       childrenOutFightObj = ChildrenInterface.getChildrenOutFightObj(roleid, childid, false);
/* 275 */       validateAutoSkill(childid, xFightCache, childrenOutFightObj.getActiveSkillMap().keySet());
/*     */     } catch (Exception e) {
/* 277 */       GameServer.logger().error(String.format("FighterChild.onFightEnd@get child outfight object exception|roleid=%d|childid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 282 */     if (childrenOutFightObj != null) {
/* 283 */       int cutCharacterValue = fightTypeCfg.childAliveLostCharater;
/* 284 */       if ((isDead()) || (isFakeDead())) {
/* 285 */         cutCharacterValue = fightTypeCfg.childDeadLostCharacter;
/*     */       }
/* 287 */       ChildrenTaskOneByOneManager.asyncChildOutFight(roleid, childid, cutCharacterValue);
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
/* 316 */     this.fightGroup.addLeaveFightFighter(this);
/* 317 */     this.fightGroup.removeFighter(this.fighterid);
/*     */   }
/*     */   
/*     */   void broadCastSelectOperInTeam()
/*     */   {
/* 322 */     if (!OnlineManager.getInstance().isOnline(getOwnerid()))
/* 323 */       return;
/* 324 */     SSelectOperateBrd operateBrd = new SSelectOperateBrd();
/* 325 */     operateBrd.fighterid = this.fighterid;
/* 326 */     operateBrd.auto = (isAuto() ? 1 : 0);
/* 327 */     FightCmd xCmd = getFight().getFightCmd(this.fighterid);
/* 328 */     operateBrd.op_type = xCmd.getOp_type();
/* 329 */     operateBrd.content.replace(xCmd.getContentCopy());
/* 330 */     this.fightGroup.fightTeam.broadcast(operateBrd);
/*     */   }
/*     */   
/*     */   void onDead()
/*     */   {
/* 335 */     if (isNotLeave()) {
/* 336 */       setFakeDead();
/*     */     } else {
/* 338 */       setDead();
/*     */     }
/* 340 */     super.onFighterDead();
/*     */   }
/*     */   
/*     */   public boolean isMyOwner(Fighter fighter)
/*     */   {
/* 345 */     if (this.fightGroup.groupid != fighter.fightGroup.groupid) {
/* 346 */       return false;
/*     */     }
/* 348 */     if ((fighter instanceof FighterRole)) {
/* 349 */       FighterRole fighterRole = (FighterRole)fighter;
/* 350 */       return fighterRole.getRoleid() == getOwnerid();
/*     */     }
/* 352 */     return false;
/*     */   }
/*     */   
/*     */   protected void onEnterFight()
/*     */   {
/* 357 */     super.onEnterFight();
/*     */     
/* 359 */     FightGroup fightGroup = this.fightGroup;
/* 360 */     if ((fightGroup instanceof FightGroupRole)) {
/* 361 */       FightGroupRole fightGroupRole = (FightGroupRole)fightGroup;
/* 362 */       FighterRole fighterRole = fightGroupRole.getFighterRole();
/* 363 */       if (fighterRole != null) {
/* 364 */         fighterRole.handleOnChildEnterFight(this);
/*     */       }
/*     */     } else {
/* 367 */       GameServer.logger().error(String.format("pet is not in fightGruopRole", new Object[0]));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void initChangeModelCard()
/*     */   {
/* 375 */     initChangeModelCard(SChildrenConsts.getInstance().cardClassType, SChildrenConsts.getInstance().cardLevel);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FighterChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */