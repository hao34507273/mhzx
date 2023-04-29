/*     */ package mzm.gsp.monster.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.common.IOutFightObject;
/*     */ import mzm.gsp.common.IOutFightObject.FighterState;
/*     */ import mzm.gsp.effect.main.OutFightEffect;
/*     */ import mzm.gsp.monster.confbean.BasicMonsterConfigInfo;
/*     */ import mzm.gsp.monster.confbean.SMonsterCfg;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Monster
/*     */   implements IOutFightObject
/*     */ {
/*     */   private final SMonsterCfg monsterCfg;
/*     */   private final BasicMonsterConfigInfo basicMonsterConfigInfo;
/*  32 */   private final List<Integer> skillList = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  37 */   private final List<Integer> passiveSKillList = new ArrayList();
/*     */   
/*  39 */   private final Map<Integer, Integer> propMap = new HashMap();
/*     */   
/*     */   public Monster(SMonsterCfg cfg, BasicMonsterConfigInfo basicMonsterConfigInfo)
/*     */   {
/*  43 */     this.monsterCfg = cfg;
/*  44 */     this.basicMonsterConfigInfo = basicMonsterConfigInfo;
/*     */     
/*  46 */     if (cfg.monsterSkillProbBase <= 0)
/*     */     {
/*  48 */       return;
/*     */     }
/*     */     
/*  51 */     int monsterSkillId = 0;
/*  52 */     int prob = Xdb.random().nextInt(cfg.monsterSkillProbBase);
/*  53 */     Map.Entry<Integer, Integer> entry = cfg.monsterSkillProbs.ceilingEntry(Integer.valueOf(prob));
/*  54 */     if (entry != null)
/*     */     {
/*  56 */       monsterSkillId = ((Integer)entry.getValue()).intValue();
/*     */     }
/*     */     
/*  59 */     List<Integer> randomSkillList = SkillInterface.getMonsterRandomSkill(monsterSkillId);
/*  60 */     for (Integer skillId : randomSkillList)
/*     */     {
/*  62 */       if (SkillInterface.isPassiveSkill(skillId.intValue()))
/*     */       {
/*  64 */         this.passiveSKillList.add(skillId);
/*     */       }
/*     */       else
/*     */       {
/*  68 */         this.skillList.add(skillId);
/*     */       }
/*     */     }
/*     */     
/*  72 */     updatePassiveSkill();
/*     */   }
/*     */   
/*     */   private void updatePassiveSkill()
/*     */   {
/*  77 */     this.propMap.clear();
/*     */     
/*  79 */     int level = getLevel();
/*  80 */     for (Iterator i$ = this.passiveSKillList.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */       
/*  82 */       PassiveSkill passiveSkill = SkillInterface.getPassiveSkillById2Lv(skillId, level);
/*  83 */       if (passiveSkill != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  88 */         List<OutFightEffect> outFightEffectList = passiveSkill.getEffectList(this);
/*  89 */         for (OutFightEffect outFightEffect : outFightEffectList)
/*     */         {
/*  91 */           outFightEffect.attach(this);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getModelId()
/*     */   {
/* 103 */     return this.monsterCfg.monsterModelId;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 109 */     return this.basicMonsterConfigInfo.level;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getHP()
/*     */   {
/* 115 */     return getPropertyType(1) + getPassiveProperty(1);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getMP()
/*     */   {
/* 121 */     return getPropertyType(3) + getPassiveProperty(3);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setHP(int hp)
/*     */   {
/* 127 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public void setMP(int mp)
/*     */   {
/* 133 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public void fillSelfFixFightProperty(Map<Integer, Integer> retPropMap)
/*     */   {
/* 139 */     calculate(1, retPropMap);
/* 140 */     calculate(3, retPropMap);
/* 141 */     calculate(7, retPropMap);
/* 142 */     calculate(9, retPropMap);
/* 143 */     calculate(8, retPropMap);
/* 144 */     calculate(10, retPropMap);
/* 145 */     calculate(11, retPropMap);
/* 146 */     calculate(12, retPropMap);
/* 147 */     calculate(14, retPropMap);
/* 148 */     calculate(15, retPropMap);
/* 149 */     calculate(16, retPropMap);
/* 150 */     calculate(17, retPropMap);
/* 151 */     calculate(18, retPropMap);
/* 152 */     calculate(19, retPropMap);
/* 153 */     calculate(20, retPropMap);
/* 154 */     calculate(21, retPropMap);
/* 155 */     calculate(24, retPropMap);
/* 156 */     calculate(22, retPropMap);
/* 157 */     calculate(23, retPropMap);
/* 158 */     calculate(85, retPropMap);
/* 159 */     calculate(87, retPropMap);
/* 160 */     calculate(86, retPropMap);
/* 161 */     calculate(88, retPropMap);
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<Integer, Integer> getSelfFixFightProperty()
/*     */   {
/* 167 */     return new HashMap();
/*     */   }
/*     */   
/*     */ 
/*     */   public void fillOtherFightProperty(Map<Integer, Integer> retPropMap)
/*     */   {
/* 173 */     retPropMap.putAll(this.propMap);
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<Integer, Integer> getOtherFightProperty()
/*     */   {
/* 179 */     Map<Integer, Integer> retPropMap = new HashMap();
/* 180 */     fillOtherFightProperty(retPropMap);
/* 181 */     return retPropMap;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<Integer, Integer> getFinalPropertyMap()
/*     */   {
/* 187 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void fillFinalPropertyMap(Map<Integer, Integer> retPropMap) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFinalMaxHP()
/*     */   {
/* 199 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMaxMP()
/*     */   {
/* 205 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalPHYATK()
/*     */   {
/* 211 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMAGATK()
/*     */   {
/* 217 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalPHYDEF()
/*     */   {
/* 223 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMAGDEF()
/*     */   {
/* 229 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalPHYCRTRate()
/*     */   {
/* 235 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMAGCRTRate()
/*     */   {
/* 241 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalPHYCRTVALUE()
/*     */   {
/* 247 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMAGCRTVALUE()
/*     */   {
/* 253 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalSpeed()
/*     */   {
/* 259 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalSeal()
/*     */   {
/* 265 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalSealRst()
/*     */   {
/* 271 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addPropertyValue(int type, int value)
/*     */   {
/* 277 */     Integer propValue = (Integer)this.propMap.get(Integer.valueOf(type));
/* 278 */     if (propValue == null)
/*     */     {
/* 280 */       propValue = Integer.valueOf(0);
/*     */     }
/* 282 */     this.propMap.put(Integer.valueOf(type), Integer.valueOf(propValue.intValue() + value));
/*     */   }
/*     */   
/*     */ 
/*     */   public void fillModelInfo(ModelInfo modelInfo)
/*     */   {
/* 288 */     modelInfo.modelid = this.monsterCfg.monsterModelId;
/*     */     
/* 290 */     int outLookId = this.monsterCfg.modelFigureId;
/* 291 */     if (outLookId > 0)
/*     */     {
/* 293 */       modelInfo.extramap.put(Integer.valueOf(11), Integer.valueOf(outLookId));
/*     */     }
/*     */     
/* 296 */     int colorId = this.monsterCfg.modelColorId;
/* 297 */     if (colorId > 0)
/*     */     {
/* 299 */       modelInfo.extramap.put(Integer.valueOf(12), Integer.valueOf(colorId));
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Integer> getMonsterSkillIdList()
/*     */   {
/* 305 */     return this.skillList;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SOutFightEffectGroup> getFighterEffect()
/*     */   {
/* 311 */     List<SOutFightEffectGroup> groups = new ArrayList();
/* 312 */     for (Iterator i$ = this.passiveSKillList.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */       
/* 314 */       PassiveSkill skill = SkillInterface.getPassiveSkillById2Lv(skillId, getLevel());
/* 315 */       if (skill != null)
/*     */       {
/* 317 */         groups.addAll(skill.getFighterEffectList());
/*     */       }
/*     */     }
/* 320 */     return groups;
/*     */   }
/*     */   
/*     */   public int getId()
/*     */   {
/* 325 */     return this.monsterCfg.id;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getName()
/*     */   {
/* 331 */     return this.monsterCfg.name;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSex()
/*     */   {
/* 337 */     return this.monsterCfg.gender;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getClassType()
/*     */   {
/* 347 */     return this.monsterCfg.classType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getClassLevel()
/*     */   {
/* 357 */     return this.monsterCfg.classLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCatchProp()
/*     */   {
/* 367 */     return this.monsterCfg.catchRate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCatchedId()
/*     */   {
/* 377 */     return this.monsterCfg.catchedMonsterId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRewardId()
/*     */   {
/* 387 */     return this.monsterCfg.rewardTableId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getStrategy()
/*     */   {
/* 397 */     return this.monsterCfg.monsterStrategy;
/*     */   }
/*     */   
/*     */   private int getPropertyType(int type)
/*     */   {
/* 402 */     Double ratio = (Double)this.monsterCfg.props.get(Integer.valueOf(type));
/* 403 */     if (ratio == null)
/*     */     {
/* 405 */       return 0;
/*     */     }
/*     */     
/* 408 */     Integer propVal = (Integer)this.basicMonsterConfigInfo.props.get(Integer.valueOf(type));
/* 409 */     if (propVal == null)
/*     */     {
/* 411 */       return 0;
/*     */     }
/*     */     
/* 414 */     return (int)(ratio.doubleValue() * propVal.intValue());
/*     */   }
/*     */   
/*     */   private int getPassiveProperty(int type)
/*     */   {
/* 419 */     Integer val = (Integer)this.propMap.get(Integer.valueOf(type));
/* 420 */     if (val == null)
/*     */     {
/* 422 */       return 0;
/*     */     }
/* 424 */     return val.intValue();
/*     */   }
/*     */   
/*     */   protected void calculate(int type, Map<Integer, Integer> retPropMap)
/*     */   {
/* 429 */     int value = getPropertyType(type);
/*     */     
/* 431 */     if ((value == 0) && (type == 1))
/*     */     {
/* 433 */       value = 1;
/*     */     }
/*     */     
/* 436 */     retPropMap.put(Integer.valueOf(type), Integer.valueOf(value));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMaxAnger()
/*     */   {
/* 446 */     return getPropertyType(5);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getOccupationId()
/*     */   {
/* 452 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */   public IOutFightObject.FighterState getFighterState()
/*     */   {
/* 458 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\main\Monster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */