/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.IOutFightObject;
/*     */ import mzm.gsp.common.IOutFightObject.FighterState;
/*     */ import mzm.gsp.common.PropertyFormula;
/*     */ import mzm.gsp.effect.main.OutFightEffect;
/*     */ import mzm.gsp.partner.confbean.SPartnerCfg;
/*     */ import mzm.gsp.partneryuanshen.main.PartnerYuanshenInterface;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.role.main.PropertyManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PartnerOutFightBean;
/*     */ import xbean.Pod;
/*     */ import xbean.Property;
/*     */ import xbean.Role2PartnerBean;
/*     */ import xtable.Role2partneroutfightbean;
/*     */ 
/*     */ public class PartnerOutFightObj
/*     */   extends Partner
/*     */   implements IOutFightObject
/*     */ {
/*     */   private PartnerOutFightBean xOutFightBean;
/*     */   
/*     */   PartnerOutFightObj(long roleId, Property xProperty)
/*     */   {
/*  39 */     super(roleId, xProperty);
/*     */     
/*  41 */     Role2PartnerBean xRole2Partner = Role2partneroutfightbean.get(Long.valueOf(roleId));
/*  42 */     if (xRole2Partner == null)
/*     */     {
/*  44 */       xRole2Partner = Pod.newRole2PartnerBean();
/*  45 */       Role2partneroutfightbean.add(Long.valueOf(roleId), xRole2Partner);
/*     */     }
/*  47 */     this.xOutFightBean = ((PartnerOutFightBean)xRole2Partner.getBeanmap().get(Integer.valueOf(xProperty.getPartnercfgid())));
/*  48 */     if (this.xOutFightBean == null)
/*     */     {
/*  50 */       this.xOutFightBean = Pod.newPartnerOutFightBean();
/*  51 */       xRole2Partner.getBeanmap().put(Integer.valueOf(xProperty.getPartnercfgid()), this.xOutFightBean);
/*  52 */       updateOutFightProperty();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getPartnerLevel()
/*     */   {
/*  63 */     return RoleInterface.getLevel(this.roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateOutFightProperty()
/*     */   {
/*  73 */     int beforeFinalhp = getFinalMaxHP();
/*  74 */     int beforeFinalmp = getFinalMaxMP();
/*     */     
/*  76 */     updatePassiveSkill();
/*  77 */     updateYuanshenExtraProperties();
/*     */     
/*  79 */     int changeHP = getFinalMaxHP() - beforeFinalhp;
/*  80 */     int changeMP = getFinalMaxMP() - beforeFinalmp;
/*  81 */     setHP(getHP() + changeHP);
/*  82 */     setMP(getMP() + changeMP);
/*  83 */     onPropertyChange();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updatePassiveSkill()
/*     */   {
/*  92 */     Set<OutFightEffect> effectSet = this.xOutFightBean.getSkilleffectset();
/*  93 */     for (OutFightEffect effect : effectSet)
/*     */     {
/*  95 */       effect.detach(this);
/*     */     }
/*  97 */     this.xOutFightBean.getSkilleffectset().clear();
/*     */     
/*  99 */     List<PassiveSkill> allPassiveSkills = getPassiveSkills();
/* 100 */     for (PassiveSkill pSkill : allPassiveSkills)
/*     */     {
/* 102 */       if (pSkill != null)
/*     */       {
/*     */ 
/*     */ 
/* 106 */         installSkill(pSkill);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void updateYuanshenExtraProperties()
/*     */   {
/* 115 */     Map<Integer, Integer> yuanshenPropMap = this.xOutFightBean.getYuanshenpropmap();
/* 116 */     yuanshenPropMap.clear();
/* 117 */     Map<Integer, Integer> extraPropertyMap = PartnerYuanshenInterface.getPartnerExtraPropertyRatioMap(this.roleId, getId());
/*     */     
/* 119 */     for (Map.Entry<Integer, Integer> entry : extraPropertyMap.entrySet())
/*     */     {
/* 121 */       int baseValue = calculateType(((Integer)entry.getKey()).intValue());
/* 122 */       yuanshenPropMap.put(entry.getKey(), Integer.valueOf((int)Math.round(baseValue * ((Integer)entry.getValue()).intValue() / 10000.0D)));
/*     */     }
/*     */   }
/*     */   
/*     */   private void installSkill(PassiveSkill skill)
/*     */   {
/* 128 */     List<OutFightEffect> outFightEffects = skill.getEffectList(this);
/* 129 */     for (OutFightEffect effect : outFightEffects)
/*     */     {
/* 131 */       this.xOutFightBean.getSkilleffectset().add(effect);
/* 132 */       effect.attach(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private void onPropertyChange()
/*     */   {
/* 138 */     int maxHp = getFinalMaxHP();
/* 139 */     int maxMp = getFinalMaxMP();
/* 140 */     setHP(maxHp);
/* 141 */     setMP(maxMp);
/* 142 */     setFightScore();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int calculateType(int propertyType)
/*     */   {
/* 153 */     PartnerCfg partnerCfg = (PartnerCfg)PartnerInitManager.getInstance().getPartnerCfgMap().get(Integer.valueOf(this.xProperty.getPartnercfgid()));
/* 154 */     if (partnerCfg == null)
/*     */     {
/* 156 */       GameServer.logger().error(String.format("[partner]PartnerOutFightObj.calculateType@ partnerCfg is null!|partnerCfgId=%d", new Object[] { Integer.valueOf(this.xProperty.getPartnercfgid()) }));
/*     */       
/*     */ 
/* 159 */       return 0;
/*     */     }
/* 161 */     return partnerCfg.calculateType(getPartnerLevel(), propertyType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getClassType()
/*     */   {
/* 171 */     return super.getClassType();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getClassLevel()
/*     */   {
/* 181 */     return super.getClassLevel();
/*     */   }
/*     */   
/*     */ 
/*     */   public String getName()
/*     */   {
/* 187 */     return super.getName();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSex()
/*     */   {
/* 193 */     return super.getSex();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 199 */     return getPartnerLevel();
/*     */   }
/*     */   
/*     */ 
/*     */   public void fillSelfFixFightProperty(Map<Integer, Integer> propMap)
/*     */   {
/* 205 */     for (Integer propertyType : PropertyFormula.PROP_LIST)
/*     */     {
/* 207 */       fillDefaultInnverProperty(propertyType.intValue(), propMap);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void fillDefaultInnverProperty(int propertyType, Map<Integer, Integer> propMap)
/*     */   {
/* 214 */     int innerValue = calculateType(propertyType);
/* 215 */     propMap.put(Integer.valueOf(propertyType), Integer.valueOf(innerValue));
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<Integer, Integer> getSelfFixFightProperty()
/*     */   {
/* 221 */     Map<Integer, Integer> propMap = new HashMap();
/* 222 */     fillSelfFixFightProperty(propMap);
/* 223 */     return propMap;
/*     */   }
/*     */   
/*     */ 
/*     */   public void fillOtherFightProperty(Map<Integer, Integer> propMap)
/*     */   {
/* 229 */     for (Integer propertyType : PropertyFormula.PROP_LIST)
/*     */     {
/* 231 */       fillDefaultOutProperty(propertyType.intValue(), propMap);
/*     */     }
/*     */   }
/*     */   
/*     */   private void fillDefaultOutProperty(int propertyType, Map<Integer, Integer> propMap)
/*     */   {
/* 237 */     Integer propValue = Integer.valueOf(getOuterValue(propertyType));
/* 238 */     if (propValue == null)
/*     */     {
/* 240 */       propValue = Integer.valueOf(0);
/*     */     }
/* 242 */     propMap.put(Integer.valueOf(propertyType), propValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getOutFightBeanProperty(int propertyType)
/*     */   {
/* 253 */     int propValue = 0;
/* 254 */     Integer outfightPropValue = (Integer)this.xOutFightBean.getEquipstaticaddpropmap().get(Integer.valueOf(propertyType));
/* 255 */     if (outfightPropValue != null)
/*     */     {
/* 257 */       propValue += outfightPropValue.intValue();
/*     */     }
/* 259 */     Integer effectProp = (Integer)this.xOutFightBean.getEffectaddpropmap().get(Integer.valueOf(propertyType));
/* 260 */     if (effectProp != null)
/*     */     {
/* 262 */       propValue += effectProp.intValue();
/*     */     }
/* 264 */     Integer yuanshenProp = (Integer)this.xOutFightBean.getYuanshenpropmap().get(Integer.valueOf(propertyType));
/* 265 */     if (yuanshenProp != null)
/*     */     {
/* 267 */       propValue += yuanshenProp.intValue();
/*     */     }
/* 269 */     return propValue;
/*     */   }
/*     */   
/*     */   int getOuterValue(int propertyType)
/*     */   {
/* 274 */     int propValue = 0;
/*     */     
/* 276 */     Integer outfightPropValue = Integer.valueOf(getOutFightBeanProperty(propertyType));
/* 277 */     if (outfightPropValue != null)
/*     */     {
/* 279 */       propValue += outfightPropValue.intValue();
/*     */     }
/* 281 */     return propValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getBaseValue(int propertyType)
/*     */   {
/* 292 */     int level = getLevel();
/* 293 */     PartnerCfg partnerCfg = PartnerInitManager.getInstance().getPartnerCfg(this.xProperty.getPartnercfgid());
/* 294 */     int value = 0;
/* 295 */     value = (int)(value + partnerCfg.getProperty(propertyType, level));
/*     */     
/* 297 */     Integer outfightp = Integer.valueOf(getOutFightBeanProperty(propertyType));
/* 298 */     value += outfightp.intValue();
/* 299 */     return value;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<Integer, Integer> getOtherFightProperty()
/*     */   {
/* 305 */     Map<Integer, Integer> propMap = new HashMap();
/* 306 */     fillOtherFightProperty(propMap);
/* 307 */     return propMap;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<Integer, Integer> getFinalPropertyMap()
/*     */   {
/* 313 */     Map<Integer, Integer> propMap = new HashMap();
/* 314 */     fillFinalPropertyMap(propMap);
/* 315 */     return propMap;
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
/*     */   public void fillFinalPropertyMap(Map<Integer, Integer> propMap)
/*     */   {
/* 343 */     Map<Integer, Integer> pro2Ret = PropertyManager.getPro2Ret();
/* 344 */     Iterator<Map.Entry<Integer, Integer>> it = pro2Ret.entrySet().iterator();
/* 345 */     while (it.hasNext())
/*     */     {
/* 347 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 348 */       int propType = ((Integer)entry.getKey()).intValue();
/* 349 */       int finalValue = getFinalProperty(propType, ((Integer)entry.getValue()).intValue());
/* 350 */       propMap.put(Integer.valueOf(propType), Integer.valueOf(finalValue));
/*     */     }
/*     */     
/* 353 */     propMap.put(Integer.valueOf(2), Integer.valueOf(getHP()));
/* 354 */     propMap.put(Integer.valueOf(4), Integer.valueOf(getMP()));
/*     */   }
/*     */   
/*     */   private int getFinalProperty(int properType, int addPercentType)
/*     */   {
/* 359 */     int innerValue = calculateType(properType);
/* 360 */     Integer innerAddRate = Integer.valueOf(getOutFightBeanProperty(addPercentType));
/* 361 */     int outerValue = getOuterValue(properType);
/* 362 */     return (int)PropertyFormula.petFormulaFinalProperty(innerValue, outerValue, innerAddRate.intValue());
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMaxHP()
/*     */   {
/* 368 */     return getFinalProperty(1, 30);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMaxMP()
/*     */   {
/* 374 */     return getFinalProperty(3, 31);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalPHYATK()
/*     */   {
/* 380 */     return getFinalProperty(7, 33);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMAGATK()
/*     */   {
/* 386 */     return getFinalProperty(9, 35);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalPHYDEF()
/*     */   {
/* 392 */     return getFinalProperty(8, 34);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMAGDEF()
/*     */   {
/* 398 */     return getFinalProperty(10, 36);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalPHYCRTRate()
/*     */   {
/* 404 */     return getFinalProperty(11, -1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFinalPHYCRITLEVEL()
/*     */   {
/* 414 */     return getFinalProperty(85, -1);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMAGCRTRate()
/*     */   {
/* 420 */     return getFinalProperty(12, -1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFinalMAGCRTLEVEL()
/*     */   {
/* 430 */     return getFinalProperty(86, -1);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalPHYCRTVALUE()
/*     */   {
/* 436 */     return getFinalProperty(14, 37);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalMAGCRTVALUE()
/*     */   {
/* 442 */     return getFinalProperty(15, 38);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalSpeed()
/*     */   {
/* 448 */     return getFinalProperty(24, 47);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalSeal()
/*     */   {
/* 454 */     return getFinalProperty(16, 39);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getFinalSealRst()
/*     */   {
/* 460 */     return getFinalProperty(17, 40);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addPropertyValue(int type, int value)
/*     */   {
/* 466 */     Integer effectProp = (Integer)this.xOutFightBean.getEffectaddpropmap().get(Integer.valueOf(type));
/* 467 */     if (effectProp != null)
/*     */     {
/* 469 */       value += effectProp.intValue();
/*     */     }
/* 471 */     this.xOutFightBean.getEffectaddpropmap().put(Integer.valueOf(type), Integer.valueOf(value));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void fillModelInfo(ModelInfo modelInfo)
/*     */   {
/* 478 */     getModel(modelInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SOutFightEffectGroup> getFighterEffect()
/*     */   {
/* 484 */     List<SOutFightEffectGroup> effectList = new ArrayList();
/* 485 */     List<PassiveSkill> skillList = getPassiveSkills();
/* 486 */     for (PassiveSkill skill : skillList)
/*     */     {
/* 488 */       effectList.addAll(skill.getFighterEffectList());
/*     */     }
/* 490 */     return effectList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFightValue()
/*     */   {
/* 498 */     return this.xProperty.getFightvalue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<PassiveSkill> getPassiveSkills()
/*     */   {
/* 508 */     List<PassiveSkill> passiveSkills = new ArrayList();
/*     */     
/* 510 */     passiveSkills.addAll(getPassiveSkillsInOwnSkills());
/*     */     
/* 512 */     passiveSkills.addAll(XiuLianSkillInterface.getXiuLianPassiveSkills(this.roleId, 4, true));
/* 513 */     return passiveSkills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<PassiveSkill> getPassiveSkillsInOwnSkills()
/*     */   {
/* 523 */     List<PassiveSkill> passiveSkills = new ArrayList();
/*     */     
/* 525 */     Map<Integer, Integer> allSkills = getPartnerSkills();
/* 526 */     Iterator<Map.Entry<Integer, Integer>> it = allSkills.entrySet().iterator();
/* 527 */     while (it.hasNext())
/*     */     {
/* 529 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 530 */       int skillId = ((Integer)entry.getKey()).intValue();
/* 531 */       int lv = ((Integer)entry.getValue()).intValue();
/*     */       
/* 533 */       PassiveSkill passiveSkill = SkillInterface.getPassiveSkillById2Lv(skillId, lv);
/* 534 */       if (passiveSkill != null)
/*     */       {
/*     */ 
/*     */ 
/* 538 */         passiveSkills.add(passiveSkill);
/*     */       }
/*     */     }
/*     */     
/* 542 */     passiveSkills.addAll(getSubYuanPasSkills());
/*     */     
/* 544 */     return passiveSkills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Integer, Integer> getPartnerSkills()
/*     */   {
/* 554 */     Map<Integer, Integer> allSkills = new HashMap();
/* 555 */     Iterator<Map.Entry<Integer, Integer>> it = this.xProperty.getOwnskills().entrySet().iterator();
/* 556 */     while (it.hasNext())
/*     */     {
/* 558 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 559 */       int pSkillId = ((Integer)entry.getKey()).intValue();
/* 560 */       int lv = ((Integer)entry.getValue()).intValue();
/*     */       
/* 562 */       int skillId = PartnerInitManager.getInstance().getRealSkillId(pSkillId);
/* 563 */       if (skillId > 0)
/*     */       {
/*     */ 
/*     */ 
/* 567 */         allSkills.put(Integer.valueOf(skillId), Integer.valueOf(lv)); }
/*     */     }
/* 569 */     return allSkills;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getOccupationId()
/*     */   {
/* 575 */     SPartnerCfg sPartnerCfg = PartnerInterface.getSPartnerCfgById(getId());
/* 576 */     if (sPartnerCfg != null)
/*     */     {
/* 578 */       return sPartnerCfg.faction;
/*     */     }
/*     */     
/*     */ 
/* 582 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public IOutFightObject.FighterState getFighterState()
/*     */   {
/* 589 */     if (getOccupationId() == 9)
/*     */     {
/* 591 */       return new IOutFightObject.FighterState(1000, 1000);
/*     */     }
/* 593 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PartnerOutFightObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */