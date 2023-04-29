/*      */ package mzm.gsp.role.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.aircraft.main.AircraftInterface;
/*      */ import mzm.gsp.avatar.main.AvatarInterface;
/*      */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*      */ import mzm.gsp.common.IOutFightObject;
/*      */ import mzm.gsp.common.IOutFightObject.FighterState;
/*      */ import mzm.gsp.common.PropertyFormula;
/*      */ import mzm.gsp.common.confbean.SFightValueConst;
/*      */ import mzm.gsp.common.confbean.STPropertyScoreCfg;
/*      */ import mzm.gsp.effect.main.OutFightEffect;
/*      */ import mzm.gsp.fabao.main.FabaoInterface;
/*      */ import mzm.gsp.fabaolingqi.main.FabaoArtifactInterface;
/*      */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*      */ import mzm.gsp.gangskill.main.GangSkillInterface;
/*      */ import mzm.gsp.genius.main.GeniusInterface;
/*      */ import mzm.gsp.item.main.EquipmentItem;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.magicmark.main.MagicMarkInterface;
/*      */ import mzm.gsp.mounts.main.MountsInterface;
/*      */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.PropSys;
/*      */ import mzm.gsp.role.SSyncHeroProp;
/*      */ import mzm.gsp.role.event.FightValueChange;
/*      */ import mzm.gsp.role.event.RoleXFightValueChangeArg;
/*      */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*      */ import mzm.gsp.skill.main.PassiveSkill;
/*      */ import mzm.gsp.skill.main.Skill;
/*      */ import mzm.gsp.skill.main.SkillInterface;
/*      */ import mzm.gsp.title.main.TitleInterface;
/*      */ import mzm.gsp.wing.main2.WingInterface;
/*      */ import mzm.gsp.xiulian.main.XiuLianSkill;
/*      */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*      */ import xbean.BasicPropertiesSystem;
/*      */ import xbean.Pod;
/*      */ import xbean.Properties;
/*      */ import xbean.RoleBaseProBean;
/*      */ import xbean.RoleOutFightBean;
/*      */ import xbean.RoleProBean;
/*      */ import xbean.RoleReviseProBean;
/*      */ import xtable.Role2outfightbean;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class RoleOutFightObj
/*      */   extends Role
/*      */   implements IOutFightObject
/*      */ {
/*      */   RoleOutFightBean xRoleOutFightBean;
/*      */   
/*      */   RoleOutFightObj(long roleId)
/*      */   {
/*   70 */     super(roleId, true);
/*   71 */     this.xRoleOutFightBean = Role2outfightbean.get(Long.valueOf(roleId));
/*   72 */     if (this.xRoleOutFightBean == null)
/*      */     {
/*   74 */       this.xRoleOutFightBean = Pod.newRoleOutFightBean();
/*   75 */       Role2outfightbean.add(Long.valueOf(roleId), this.xRoleOutFightBean);
/*   76 */       initOuterValue();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void initOuterValue()
/*      */   {
/*   83 */     setEquipPro(ItemInterface.getAllEquipmentProMap(this.roleId));
/*      */     
/*   85 */     setAppellationPro(TitleInterface.getNowPropertyMap(this.roleId));
/*      */     
/*   87 */     setWingPro(WingInterface.getCurWingPlanPros(this.roleId, true));
/*      */     
/*   89 */     setFabaoPro(FabaoInterface.getFabaoSysPro(this.roleId, true));
/*      */     
/*   91 */     setRidePro(MountsInterface.getCurrentMountsRoleProperty(this.roleId, true));
/*      */     
/*   93 */     setAvatarPro(AvatarInterface.getRoleAvatarProperties(this.roleId));
/*      */     
/*   95 */     setFationPro(FashionDressInterface.getThemeFashionDressRoleProperty(this.roleId, true));
/*      */     
/*   97 */     setFaBaoLingQiPro(FabaoArtifactInterface.getArtifactProperties(this.roleId, true));
/*      */     
/*   99 */     setBianShenCardPro(ChangeModelCardInterface.getCurChangeModelCardProp(this.roleId, true));
/*      */     
/*  101 */     setAircraftPro(AircraftInterface.getAircraftPropertyMap(this.roleId, true));
/*      */     
/*  103 */     installPassiveSkill();
/*      */   }
/*      */   
/*      */   private int floor(double value)
/*      */   {
/*  108 */     return (int)Math.floor(Math.round(value * 100.0D) / 100.0D);
/*      */   }
/*      */   
/*      */   public void syncClientRoleProperty()
/*      */   {
/*  113 */     SSyncHeroProp heroPropProtocol = new SSyncHeroProp();
/*  114 */     heroPropProtocol.propmap.put(Integer.valueOf(1), Integer.valueOf(getFinalMaxHP()));
/*  115 */     heroPropProtocol.propmap.put(Integer.valueOf(3), Integer.valueOf(getFinalMaxMP()));
/*  116 */     heroPropProtocol.propmap.put(Integer.valueOf(7), Integer.valueOf(getFinalPHYATK()));
/*  117 */     heroPropProtocol.propmap.put(Integer.valueOf(9), Integer.valueOf(getFinalMAGATK()));
/*  118 */     heroPropProtocol.propmap.put(Integer.valueOf(8), Integer.valueOf(getFinalPHYDEF()));
/*  119 */     heroPropProtocol.propmap.put(Integer.valueOf(10), Integer.valueOf(getFinalMAGDEF()));
/*  120 */     heroPropProtocol.propmap.put(Integer.valueOf(24), Integer.valueOf(getFinalSpeed()));
/*  121 */     heroPropProtocol.propmap.put(Integer.valueOf(17), Integer.valueOf(getFinalSealRst()));
/*  122 */     heroPropProtocol.propmap.put(Integer.valueOf(16), Integer.valueOf(getFinalSeal()));
/*  123 */     heroPropProtocol.propmap.put(Integer.valueOf(85), Integer.valueOf((int)getFinalProperty(85, -1, this.xProperties.getActivitybpsys())));
/*      */     
/*  125 */     heroPropProtocol.propmap.put(Integer.valueOf(87), Integer.valueOf((int)getFinalProperty(87, -1, this.xProperties.getActivitybpsys())));
/*      */     
/*  127 */     heroPropProtocol.propmap.put(Integer.valueOf(86), Integer.valueOf((int)getFinalProperty(86, -1, this.xProperties.getActivitybpsys())));
/*      */     
/*  129 */     heroPropProtocol.propmap.put(Integer.valueOf(88), Integer.valueOf((int)getFinalProperty(88, -1, this.xProperties.getActivitybpsys())));
/*      */     
/*  131 */     heroPropProtocol.exp = getExp();
/*  132 */     heroPropProtocol.gender = getGender();
/*  133 */     heroPropProtocol.activitypropsys = this.xProperties.getActivitybpsys();
/*  134 */     heroPropProtocol.hp = getHP();
/*  135 */     heroPropProtocol.mp = getMP();
/*  136 */     heroPropProtocol.roleid = getId();
/*  137 */     heroPropProtocol.level = getLevel();
/*  138 */     heroPropProtocol.name = getName();
/*  139 */     heroPropProtocol.occupation = getOccupationId();
/*  140 */     heroPropProtocol.vigor = getVigor();
/*  141 */     heroPropProtocol.fightvalue = getFightValue();
/*  142 */     heroPropProtocol.anger = getAnger();
/*  143 */     heroPropProtocol.createtime = (getCreateTime() / 1000L);
/*  144 */     Map<Integer, BasicPropertiesSystem> xBPSysMap = this.xProperties.getPropertysysmap();
/*  145 */     for (Map.Entry<Integer, BasicPropertiesSystem> bpsEntry : xBPSysMap.entrySet())
/*      */     {
/*  147 */       BasicPropertiesSystem xBPSys = (BasicPropertiesSystem)bpsEntry.getValue();
/*  148 */       PropSys propSys = new PropSys();
/*  149 */       propSys.isautoassign = (xBPSys.getIsautospecialpoint() ? 1 : 0);
/*  150 */       propSys.potential_point = xBPSys.getPotentialpoint();
/*  151 */       Map<Integer, Integer> autoAssignMap = xBPSys.getAutoassignpointpref();
/*  152 */       for (Map.Entry<Integer, Integer> propEntry : autoAssignMap.entrySet())
/*      */       {
/*  154 */         propSys.autoassignmap.put(propEntry.getKey(), propEntry.getValue());
/*      */       }
/*  156 */       Map<Integer, Integer> propMap = xBPSys.getBasicpropertymap();
/*  157 */       propSys.iscanrefreshprop = 0;
/*  158 */       for (Map.Entry<Integer, Integer> propEntry : propMap.entrySet())
/*      */       {
/*  160 */         propSys.propmap.put(propEntry.getKey(), propEntry.getValue());
/*  161 */         propSys.iscanrefreshprop = 1;
/*      */       }
/*  163 */       for (int i = 25; i <= 29; i++)
/*      */       {
/*  165 */         propSys.basepropmap.put(Integer.valueOf(i), Float.valueOf((float)getBasicProperty(i, ((Integer)bpsEntry.getKey()).intValue())));
/*      */       }
/*  167 */       heroPropProtocol.propsysmap.put(bpsEntry.getKey(), propSys);
/*      */     }
/*  169 */     dayUpdate();
/*  170 */     heroPropProtocol.todayactivitycount = this.xProperties.getTodaypropsysswitchcount();
/*  171 */     OnlineManager.getInstance().send(this.roleId, heroPropProtocol);
/*      */   }
/*      */   
/*      */   public void installBuffEffect(OutFightEffect effect)
/*      */   {
/*  176 */     effect.attach(this);
/*  177 */     onPropertyChange();
/*      */   }
/*      */   
/*      */   public void uninstallBuffEffect(OutFightEffect effect)
/*      */   {
/*  182 */     effect.detach(this);
/*  183 */     onPropertyChange();
/*      */   }
/*      */   
/*      */ 
/*      */   private void setEquipmentPropMap(Map<Integer, Integer> propMap)
/*      */   {
/*  189 */     int beforeFinalhp = getFinalMaxHP();
/*  190 */     int beforeFinalmp = getFinalMaxMP();
/*  191 */     Map<Integer, Integer> equipPropMap = this.xRoleOutFightBean.getEquipstaticaddpropmap();
/*  192 */     equipPropMap.clear();
/*  193 */     for (Map.Entry<Integer, Integer> propEntry : propMap.entrySet())
/*      */     {
/*  195 */       equipPropMap.put(propEntry.getKey(), propEntry.getValue());
/*      */     }
/*  197 */     int changeHP = getFinalMaxHP() - beforeFinalhp;
/*  198 */     int changeMP = getFinalMaxMP() - beforeFinalmp;
/*  199 */     setHP(getHP() + changeHP);
/*  200 */     setMP(getMP() + changeMP);
/*  201 */     onPropertyChange();
/*      */   }
/*      */   
/*      */ 
/*      */   private void setWingPropMap(Map<Integer, Integer> propMap)
/*      */   {
/*  207 */     int beforeFinalhp = getFinalMaxHP();
/*  208 */     int beforeFinalmp = getFinalMaxMP();
/*  209 */     Map<Integer, Integer> equipPropMap = this.xRoleOutFightBean.getWingstaticaddpropmap();
/*  210 */     equipPropMap.clear();
/*  211 */     for (Map.Entry<Integer, Integer> propEntry : propMap.entrySet())
/*      */     {
/*  213 */       equipPropMap.put(propEntry.getKey(), propEntry.getValue());
/*      */     }
/*  215 */     int changeHP = getFinalMaxHP() - beforeFinalhp;
/*  216 */     int changeMP = getFinalMaxMP() - beforeFinalmp;
/*  217 */     setHP(getHP() + changeHP);
/*  218 */     setMP(getMP() + changeMP);
/*  219 */     onPropertyChange();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void setAppellationPropMap(Map<Integer, Integer> propMap)
/*      */   {
/*  227 */     Map<Integer, Integer> equipPropMap = this.xRoleOutFightBean.getAppellationaddpropmap();
/*  228 */     equipPropMap.clear();
/*  229 */     for (Map.Entry<Integer, Integer> propEntry : propMap.entrySet())
/*      */     {
/*  231 */       equipPropMap.put(propEntry.getKey(), propEntry.getValue());
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  237 */     setMP(getFinalMaxMP());
/*  238 */     setHP(getFinalMaxHP());
/*  239 */     onPropertyChange();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void setProMap(Map<Integer, Integer> newPros, Map<Integer, Integer> xPros)
/*      */   {
/*  253 */     xPros.clear();
/*  254 */     for (Map.Entry<Integer, Integer> propEntry : newPros.entrySet())
/*      */     {
/*  256 */       xPros.put(propEntry.getKey(), propEntry.getValue());
/*      */     }
/*  258 */     setMP(getFinalMaxMP());
/*  259 */     setHP(getFinalMaxHP());
/*  260 */     onPropertyChange();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setPros(int type, Map<Integer, Integer> newPros)
/*      */   {
/*  271 */     RoleProBean xPro = getXProBean(type);
/*  272 */     xPro.getPropmap().clear();
/*  273 */     if ((newPros != null) && (newPros.size() > 0))
/*      */     {
/*  275 */       for (Map.Entry<Integer, Integer> propEntry : newPros.entrySet())
/*      */       {
/*  277 */         xPro.getPropmap().put(propEntry.getKey(), propEntry.getValue());
/*      */       }
/*      */     }
/*  280 */     if (this.xProperties.getBaoshidu() > 0)
/*      */     {
/*      */ 
/*  283 */       setMP(getFinalMaxMP());
/*  284 */       setHP(getFinalMaxHP());
/*      */     }
/*  286 */     onPropertyChange();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private RoleProBean getXProBean(int type)
/*      */   {
/*  298 */     Map<Integer, RoleProBean> xPros = this.xRoleOutFightBean.getExtroprop();
/*  299 */     RoleProBean xPro = (RoleProBean)xPros.get(Integer.valueOf(type));
/*  300 */     if (xPro == null)
/*      */     {
/*  302 */       xPro = Pod.newRoleProBean();
/*  303 */       xPros.put(Integer.valueOf(type), xPro);
/*      */     }
/*  305 */     return xPro;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setEquipPro(Map<Integer, Integer> newPros)
/*      */   {
/*  315 */     setPros(1, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setWingPro(Map<Integer, Integer> newPros)
/*      */   {
/*  325 */     setPros(2, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setFabaoPro(Map<Integer, Integer> newPros)
/*      */   {
/*  335 */     setPros(3, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setAppellationPro(Map<Integer, Integer> newPros)
/*      */   {
/*  345 */     setPros(4, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setRidePro(Map<Integer, Integer> newPros)
/*      */   {
/*  355 */     setPros(6, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setFationPro(Map<Integer, Integer> newPros)
/*      */   {
/*  365 */     setPros(5, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setAvatarPro(Map<Integer, Integer> newPros)
/*      */   {
/*  375 */     setPros(7, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setFaBaoLingQiPro(Map<Integer, Integer> newPros)
/*      */   {
/*  385 */     setPros(8, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setBianShenCardPro(Map<Integer, Integer> newPros)
/*      */   {
/*  395 */     setPros(9, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setAircraftPro(Map<Integer, Integer> newPros)
/*      */   {
/*  405 */     setPros(10, newPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addEffectPro(int type, int value)
/*      */   {
/*  416 */     RoleProBean xEffect = getXProBean(0);
/*  417 */     Integer oldValue = (Integer)xEffect.getPropmap().get(Integer.valueOf(type));
/*  418 */     if (oldValue == null)
/*      */     {
/*  420 */       oldValue = Integer.valueOf(0);
/*      */     }
/*  422 */     xEffect.getPropmap().put(Integer.valueOf(type), Integer.valueOf(oldValue.intValue() + value));
/*      */   }
/*      */   
/*      */   private void installSkill(PassiveSkill skill)
/*      */   {
/*  427 */     List<OutFightEffect> outFightEffects = skill.getEffectList(this);
/*  428 */     for (OutFightEffect effect : outFightEffects)
/*      */     {
/*  430 */       this.xRoleOutFightBean.getSkilleffectset().add(effect);
/*  431 */       effect.attach(this);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void installPassiveSkill()
/*      */   {
/*  440 */     int beforeFinalhp = getFinalMaxHP();
/*  441 */     int beforeFinalmp = getFinalMaxMP();
/*  442 */     for (OutFightEffect oldEffect : this.xRoleOutFightBean.getSkilleffectset())
/*      */     {
/*  444 */       oldEffect.detach(this);
/*      */     }
/*  446 */     this.xRoleOutFightBean.getSkilleffectset().clear();
/*      */     
/*  448 */     List<PassiveSkill> allPassiveSkills = getPassiveSkills();
/*  449 */     for (PassiveSkill skill : allPassiveSkills)
/*      */     {
/*  451 */       if (skill != null)
/*      */       {
/*      */ 
/*      */ 
/*  455 */         installSkill(skill);
/*      */       }
/*      */     }
/*  458 */     int changeHP = getFinalMaxHP() - beforeFinalhp;
/*  459 */     int changeMP = getFinalMaxMP() - beforeFinalmp;
/*  460 */     setHP(getHP() + changeHP);
/*  461 */     setMP(getMP() + changeMP);
/*  462 */     onPropertyChange();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<PassiveSkill> getPassiveSkills()
/*      */   {
/*  474 */     List<PassiveSkill> allPassiveSkills = new ArrayList();
/*  475 */     allPassiveSkills.addAll(SkillInterface.getPassiveSkill(this.roleId));
/*  476 */     return allPassiveSkills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<Skill> getActiveSkills()
/*      */   {
/*  488 */     List<Skill> allActiveSkills = new ArrayList();
/*  489 */     allActiveSkills.addAll(SkillInterface.getRoleSKills(this.roleId, true));
/*      */     
/*  491 */     return allActiveSkills;
/*      */   }
/*      */   
/*      */   void onPropertyChange()
/*      */   {
/*  496 */     int hp = getHP();
/*  497 */     int mp = getMP();
/*  498 */     int maxHp = getFinalMaxHP();
/*  499 */     int maxMp = getFinalMaxMP();
/*  500 */     if (hp > maxHp)
/*      */     {
/*  502 */       setHP(maxHp);
/*      */     }
/*  504 */     if (mp > maxMp)
/*      */     {
/*  506 */       setMP(maxMp);
/*      */     }
/*  508 */     changeFightValue();
/*      */   }
/*      */   
/*      */   private void changeFightValue()
/*      */   {
/*  513 */     int oldValue = this.xProperties.getFightvalue();
/*  514 */     int newValue = getFightValue();
/*  515 */     this.xProperties.setFightvalue(newValue);
/*  516 */     if (oldValue != newValue)
/*      */     {
/*  518 */       RoleXFightValueChangeArg arg = new RoleXFightValueChangeArg(this.roleId, oldValue, newValue);
/*  519 */       TriggerEventsManger.getInstance().triggerEvent(new FightValueChange(), arg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getFightValue()
/*      */   {
/*  528 */     double totalValue = 0.0D;
/*  529 */     totalValue += getOccupation().getBasicFightValue(getLevel());
/*  530 */     totalValue += getBaseProScore();
/*  531 */     totalValue += getExtroPropScore();
/*  532 */     totalValue += getAllSkillScore();
/*      */     
/*  534 */     int fightValue = (int)totalValue;
/*  535 */     return fightValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getBaseProScore()
/*      */   {
/*  545 */     double score = 0.0D;
/*  546 */     BasicPropertiesSystem baseProSys = (BasicPropertiesSystem)this.xProperties.getPropertysysmap().get(Integer.valueOf(this.xProperties.getActivitybpsys()));
/*  547 */     if (baseProSys == null)
/*      */     {
/*  549 */       return 0;
/*      */     }
/*  551 */     for (Map.Entry<Integer, Integer> entry : baseProSys.getBasicpropertymap().entrySet())
/*      */     {
/*  553 */       score += ((Integer)entry.getValue()).intValue() * SFightValueConst.getInstance().BASIC_PRO_SCORE;
/*      */     }
/*  555 */     return (int)score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private double getPropScore(List<Map<Integer, Integer>> props, int proType, double factor)
/*      */   {
/*  568 */     double equipScore = 0.0D;
/*  569 */     for (Map<Integer, Integer> equipPropMap : props)
/*      */     {
/*  571 */       Integer eVal = (Integer)equipPropMap.get(Integer.valueOf(proType));
/*  572 */       if (eVal != null)
/*      */       {
/*      */ 
/*      */ 
/*  576 */         equipScore += eVal.intValue() * factor; }
/*      */     }
/*  578 */     return equipScore;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getAppScore(int proType, double factor)
/*      */   {
/*  591 */     int appScore = 0;
/*  592 */     Integer baseValue = (Integer)this.xRoleOutFightBean.getAppellationaddpropmap().get(Integer.valueOf(proType));
/*  593 */     if (baseValue == null)
/*      */     {
/*  595 */       return 0;
/*      */     }
/*  597 */     appScore = (int)(appScore + baseValue.intValue() * factor);
/*  598 */     return appScore;
/*      */   }
/*      */   
/*      */   int getProScore(Map<Integer, Integer> propertyMap)
/*      */   {
/*  603 */     int totalValue = 0;
/*  604 */     for (STPropertyScoreCfg cfg : STPropertyScoreCfg.getAll().values())
/*      */     {
/*  606 */       Integer val = (Integer)propertyMap.get(Integer.valueOf(cfg.propertyType));
/*  607 */       if (val != null)
/*      */       {
/*      */ 
/*      */ 
/*  611 */         Double factor = (Double)cfg.occ2factor.get(getOccupation());
/*  612 */         if ((factor != null) && (factor.doubleValue() >= 0.0D))
/*      */         {
/*      */ 
/*      */ 
/*  616 */           totalValue = (int)(totalValue + val.intValue() * factor.doubleValue()); }
/*      */       } }
/*  618 */     return totalValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public double getInnerValue(int properType, int bpSysIdx)
/*      */   {
/*  634 */     Occupation occupation = getOccupation();
/*  635 */     Integer intPropValue = (Integer)((Map)occupation.getPropMap().get(Integer.valueOf(getLevel()))).get(Integer.valueOf(properType));
/*  636 */     double propValue = intPropValue == null ? 0.0D : intPropValue.intValue();
/*  637 */     BasicPropertiesSystem xBpsys = (BasicPropertiesSystem)this.xProperties.getPropertysysmap().get(Integer.valueOf(bpSysIdx));
/*  638 */     Integer xPropValue = (Integer)xBpsys.getBasicpropertymap().get(Integer.valueOf(properType));
/*  639 */     if (xPropValue != null)
/*      */     {
/*  641 */       propValue += xPropValue.intValue();
/*      */     }
/*  643 */     Map<Integer, Float> transferMap = (Map)Occupation.getTransformPropMap().get(Integer.valueOf(properType));
/*      */     
/*  645 */     if (transferMap != null)
/*      */     {
/*  647 */       Iterator<Integer> it = transferMap.keySet().iterator();
/*  648 */       while (it.hasNext())
/*      */       {
/*  650 */         int baseType = ((Integer)it.next()).intValue();
/*  651 */         double finalBaseValue = getBasicProperty(baseType, bpSysIdx);
/*  652 */         propValue += ((Float)transferMap.get(Integer.valueOf(baseType))).floatValue() * finalBaseValue;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  658 */     RoleBaseProBean xRoleBaseProBean = (RoleBaseProBean)this.xRoleOutFightBean.getExtro_revise_pro().getProps().get(Integer.valueOf(properType));
/*      */     
/*  660 */     if (xRoleBaseProBean != null)
/*      */     {
/*  662 */       for (Map.Entry<Integer, Float> xEntry : xRoleBaseProBean.getBase_props().entrySet())
/*      */       {
/*  664 */         int baseType = ((Integer)xEntry.getKey()).intValue();
/*  665 */         double finalBaseValue = getBasicProperty(baseType, bpSysIdx);
/*  666 */         propValue += ((Float)xEntry.getValue()).floatValue() * finalBaseValue;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  671 */     return propValue;
/*      */   }
/*      */   
/*      */   private Occupation getOccupation()
/*      */   {
/*  676 */     return OccupationManager.getOccupationById(getOccupationId(), getGender());
/*      */   }
/*      */   
/*      */   private int getOuterValue(int propertyType)
/*      */   {
/*  681 */     return getExtroProValue(propertyType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private double getFinalProperty(int propertyType, int addPercentType, int sysIdx)
/*      */   {
/*  694 */     double innerValue = getInnerValue(propertyType, sysIdx);
/*  695 */     int innerAddRate = getInnerAddRate(addPercentType);
/*  696 */     int outerValue = getOuterValue(propertyType);
/*  697 */     double propValue = PropertyFormula.roleFormulaFinalProperty(innerValue, outerValue, innerAddRate);
/*  698 */     return propValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getInnerAddRate(int addPercentType)
/*      */   {
/*  709 */     return getExtroProValue(addPercentType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getExtroProValue(int proType)
/*      */   {
/*  720 */     int rate = 0;
/*  721 */     for (RoleProBean xProBean : this.xRoleOutFightBean.getExtroprop().values())
/*      */     {
/*  723 */       rate += getEachAddRate(proType, xProBean);
/*      */     }
/*  725 */     return rate;
/*      */   }
/*      */   
/*      */   private int getEachAddRate(int addPercentType, RoleProBean xProBean)
/*      */   {
/*  730 */     if (addPercentType == 0)
/*      */     {
/*  732 */       return 0;
/*      */     }
/*  734 */     int eachAdd = 0;
/*  735 */     Map<Integer, Integer> pro = xProBean.getPropmap();
/*  736 */     Integer addRate = (Integer)pro.get(Integer.valueOf(addPercentType));
/*  737 */     if (addRate != null)
/*      */     {
/*  739 */       eachAdd = addRate.intValue();
/*      */     }
/*  741 */     return eachAdd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getFinalProValue(int propertyType)
/*      */   {
/*  752 */     return floor(getFinalProperty(propertyType, PropertyManager.getAddRet(propertyType), this.xProperties.getActivitybpsys()));
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMaxHP()
/*      */   {
/*  758 */     return getFinalMaxHP(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalMaxHP(int sysIdx)
/*      */   {
/*  763 */     double propValue = getFinalProperty(1, 30, sysIdx);
/*  764 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMaxMP()
/*      */   {
/*  770 */     return getFinalMaxMP(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalMaxMP(int sysIdx)
/*      */   {
/*  775 */     double propValue = getFinalProperty(3, 31, sysIdx);
/*  776 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalPHYATK()
/*      */   {
/*  782 */     return getFinalPHYATK(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalPHYATK(int sysIdx)
/*      */   {
/*  787 */     double propValue = getFinalProperty(7, 33, sysIdx);
/*  788 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMAGATK()
/*      */   {
/*  794 */     return getFinalMAGATK(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalMAGATK(int sysIdx)
/*      */   {
/*  799 */     double propValue = getFinalProperty(9, 35, sysIdx);
/*  800 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalPHYDEF()
/*      */   {
/*  806 */     return getFinalPHYDEF(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalPHYDEF(int sysIdx)
/*      */   {
/*  811 */     double propValue = getFinalProperty(8, 34, sysIdx);
/*  812 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMAGDEF()
/*      */   {
/*  818 */     return getFinalMAGDEF(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalMAGDEF(int sysIdx)
/*      */   {
/*  823 */     double propValue = getFinalProperty(10, 36, sysIdx);
/*  824 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalPHYCRTRate()
/*      */   {
/*  830 */     return getFinalPHYCRTRate(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalPHYCRTRate(int sysIdx)
/*      */   {
/*  835 */     double propValue = getFinalProperty(11, -1, sysIdx);
/*  836 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMAGCRTRate()
/*      */   {
/*  842 */     return getFinalMAGCRTRate(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalMAGCRTRate(int sysIdx)
/*      */   {
/*  847 */     double propValue = getFinalProperty(12, -1, sysIdx);
/*  848 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalPHYCRTVALUE()
/*      */   {
/*  854 */     return getFinalPHYCRTVALUE(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalPHYCRTVALUE(int sysIdx)
/*      */   {
/*  859 */     double propValue = getFinalProperty(14, 37, sysIdx);
/*  860 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMAGCRTVALUE()
/*      */   {
/*  866 */     return getFinalMAGCRTVALUE(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalMAGCRTVALUE(int sysIdx)
/*      */   {
/*  871 */     double propValue = getFinalProperty(15, 38, sysIdx);
/*  872 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalSpeed()
/*      */   {
/*  878 */     return getFinalSpeed(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalSpeed(int sysIdx)
/*      */   {
/*  883 */     double propValue = getFinalProperty(24, 47, sysIdx);
/*  884 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalSeal()
/*      */   {
/*  890 */     return getFinalSeal(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalSeal(int sysIdx)
/*      */   {
/*  895 */     double propValue = getFinalProperty(16, 39, sysIdx);
/*  896 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalSealRst()
/*      */   {
/*  902 */     return getFinalSealRst(this.xProperties.getActivitybpsys());
/*      */   }
/*      */   
/*      */   int getFinalSealRst(int sysIdx)
/*      */   {
/*  907 */     double propValue = getFinalProperty(17, 40, sysIdx);
/*  908 */     return floor(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   double getBasicProperty(int propertyType, int bpSys)
/*      */   {
/*  921 */     double basicProp = getInnerValue(propertyType, bpSys);
/*  922 */     Integer propValue = Integer.valueOf(getOuterValue(propertyType));
/*  923 */     if (propValue == null)
/*      */     {
/*  925 */       propValue = Integer.valueOf(0);
/*      */     }
/*  927 */     return basicProp + propValue.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addPropertyValue(int type, int value)
/*      */   {
/*  939 */     addEffectPro(type, value);
/*      */   }
/*      */   
/*      */   public void addRevisePropertyValue(int baseType, int propertyType, float value)
/*      */   {
/*  944 */     RoleReviseProBean xRoleReviseProBean = this.xRoleOutFightBean.getExtro_revise_pro();
/*  945 */     RoleBaseProBean xRoleBaseProBean = (RoleBaseProBean)xRoleReviseProBean.getProps().get(Integer.valueOf(propertyType));
/*  946 */     if (xRoleBaseProBean == null)
/*      */     {
/*  948 */       xRoleBaseProBean = Pod.newRoleBaseProBean();
/*  949 */       xRoleReviseProBean.getProps().put(Integer.valueOf(propertyType), xRoleBaseProBean);
/*      */     }
/*  951 */     Float oldValue = (Float)xRoleBaseProBean.getBase_props().get(Integer.valueOf(baseType));
/*  952 */     if (oldValue == null)
/*      */     {
/*  954 */       oldValue = Float.valueOf(0.0F);
/*      */     }
/*  956 */     xRoleBaseProBean.getBase_props().put(Integer.valueOf(baseType), Float.valueOf(oldValue.floatValue() + value));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setHpAndMpFull()
/*      */   {
/*  964 */     int finalMaxHp = getFinalMaxHP();
/*  965 */     int finalMaxMp = getFinalMaxMP();
/*  966 */     if ((getHP() != finalMaxHp) || (getMP() != finalMaxMp))
/*      */     {
/*  968 */       setHP(finalMaxHp);
/*  969 */       setMP(finalMaxMp);
/*  970 */       syncClientRoleProperty();
/*      */     }
/*      */   }
/*      */   
/*      */   void fillDefaultInnverProperty(int type, Map<Integer, Integer> propMap)
/*      */   {
/*  976 */     propMap.put(Integer.valueOf(type), Integer.valueOf(floor(getInnerValue(type, this.xProperties.getActivitybpsys()))));
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSex()
/*      */   {
/*  982 */     return getGender();
/*      */   }
/*      */   
/*      */ 
/*      */   public void fillSelfFixFightProperty(Map<Integer, Integer> propMap)
/*      */   {
/*  988 */     for (Integer propertyType : PropertyFormula.PROP_LIST)
/*      */     {
/*  990 */       fillDefaultInnverProperty(propertyType.intValue(), propMap);
/*      */     }
/*  992 */     propMap.put(Integer.valueOf(5), Integer.valueOf(RoleCommonConstants.getInstance().ANGER_LIMIT));
/*      */   }
/*      */   
/*      */ 
/*      */   public Map<Integer, Integer> getSelfFixFightProperty()
/*      */   {
/*  998 */     Map<Integer, Integer> propMap = new HashMap();
/*  999 */     fillSelfFixFightProperty(propMap);
/* 1000 */     return propMap;
/*      */   }
/*      */   
/*      */   void fillDefaultOuterProperty(int type, Map<Integer, Integer> propMap)
/*      */   {
/* 1005 */     Integer xProp = Integer.valueOf(getOuterValue(type));
/* 1006 */     propMap.put(Integer.valueOf(type), xProp);
/*      */   }
/*      */   
/*      */ 
/*      */   public void fillOtherFightProperty(Map<Integer, Integer> propMap)
/*      */   {
/* 1012 */     for (Integer propertyType : PropertyFormula.PROP_LIST)
/*      */     {
/* 1014 */       fillDefaultOuterProperty(propertyType.intValue(), propMap);
/*      */     }
/* 1016 */     propMap.put(Integer.valueOf(5), Integer.valueOf(RoleCommonConstants.getInstance().ANGER_LIMIT));
/*      */   }
/*      */   
/*      */ 
/*      */   public Map<Integer, Integer> getOtherFightProperty()
/*      */   {
/* 1022 */     Map<Integer, Integer> propMap = new HashMap();
/* 1023 */     fillOtherFightProperty(propMap);
/* 1024 */     return propMap;
/*      */   }
/*      */   
/*      */ 
/*      */   public Map<Integer, Integer> getFinalPropertyMap()
/*      */   {
/* 1030 */     Map<Integer, Integer> propMap = new HashMap();
/* 1031 */     fillFinalPropertyMap(propMap);
/* 1032 */     return propMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void fillFinalPropertyMap(Map<Integer, Integer> propMap)
/*      */   {
/* 1052 */     int bpsys = this.xProperties.getActivitybpsys();
/* 1053 */     Map<Integer, Integer> rolePro2Ret = PropertyManager.getPro2Ret();
/* 1054 */     Iterator<Map.Entry<Integer, Integer>> it = rolePro2Ret.entrySet().iterator();
/* 1055 */     while (it.hasNext())
/*      */     {
/* 1057 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 1058 */       int propType = ((Integer)entry.getKey()).intValue();
/* 1059 */       int finalValue = floor(getFinalProperty(propType, ((Integer)entry.getValue()).intValue(), bpsys));
/* 1060 */       propMap.put(Integer.valueOf(propType), Integer.valueOf(finalValue));
/*      */     }
/*      */     
/* 1063 */     propMap.put(Integer.valueOf(2), Integer.valueOf(getHP()));
/* 1064 */     propMap.put(Integer.valueOf(4), Integer.valueOf(getMP()));
/* 1065 */     propMap.put(Integer.valueOf(6), Integer.valueOf(getAnger()));
/* 1066 */     propMap.put(Integer.valueOf(5), Integer.valueOf(RoleCommonConstants.getInstance().ANGER_LIMIT));
/*      */   }
/*      */   
/*      */ 
/*      */   public List<SOutFightEffectGroup> getFighterEffect()
/*      */   {
/* 1072 */     List<SOutFightEffectGroup> effectList = new ArrayList();
/* 1073 */     List<PassiveSkill> skillList = getPassiveSkills();
/* 1074 */     for (PassiveSkill skill : skillList)
/*      */     {
/* 1076 */       effectList.addAll(skill.getFighterEffectList());
/*      */     }
/* 1078 */     return effectList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setAnger(int anger)
/*      */   {
/* 1088 */     if (anger < 0)
/*      */     {
/* 1090 */       return;
/*      */     }
/* 1092 */     this.xProperties.setAnger(Math.min(anger, getMaxAnger()));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   double getExtroPropScore()
/*      */   {
/* 1102 */     List<Map<Integer, Integer>> pros = getAllExtroScoreProp();
/* 1103 */     if ((pros == null) || (pros.size() == 0))
/*      */     {
/* 1105 */       return 0.0D;
/*      */     }
/* 1107 */     return getXProScore(pros);
/*      */   }
/*      */   
/*      */   private double getXProScore(List<Map<Integer, Integer>> pros)
/*      */   {
/* 1112 */     double score = 0.0D;
/* 1113 */     for (STPropertyScoreCfg cfg : STPropertyScoreCfg.getAll().values())
/*      */     {
/* 1115 */       Double factor = (Double)cfg.occ2factor.get(Integer.valueOf(getOccupation().getId()));
/* 1116 */       if (factor != null)
/*      */       {
/*      */ 
/*      */ 
/* 1120 */         score += getPropScore(pros, cfg.propertyType, factor.doubleValue()); }
/*      */     }
/* 1122 */     return score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   double getAllSkillScore()
/*      */   {
/* 1132 */     double score = 0.0D;
/* 1133 */     score += getExtroSkillsScore();
/* 1134 */     score += getAllSkillEffectScore();
/* 1135 */     score += getXiuSkillScore();
/* 1136 */     score += GangSkillInterface.getGangSkillScore(this.roleId, false);
/* 1137 */     return score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getXiuSkillScore()
/*      */   {
/* 1147 */     int score = 0;
/* 1148 */     List<XiuLianSkill> xiuLianSkills = XiuLianSkillInterface.getXiuLianSkill(this.roleId, -1, true);
/* 1149 */     for (XiuLianSkill xiuLianSkill : xiuLianSkills)
/*      */     {
/* 1151 */       score += xiuLianSkill.getScore();
/*      */     }
/* 1153 */     return score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getAllSkillEffectScore()
/*      */   {
/* 1163 */     int score = 0;
/* 1164 */     for (OutFightEffect effect : this.xRoleOutFightBean.getSkilleffectset())
/*      */     {
/* 1166 */       score += effect.getScore(getOccupationId());
/*      */     }
/* 1168 */     return score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private double getExtroSkillsScore()
/*      */   {
/* 1178 */     double score = 0.0D;
/* 1179 */     List<Integer> skills = getAllExtroSkills();
/* 1180 */     if ((skills == null) || (skills.size() == 0))
/*      */     {
/* 1182 */       return score;
/*      */     }
/* 1184 */     for (Iterator i$ = skills.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*      */       
/* 1186 */       score += RoleManager.getScoreForSkill(skillId);
/*      */     }
/* 1188 */     return score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private List<Integer> getAllExtroSkills()
/*      */   {
/* 1198 */     List<Integer> skills = new ArrayList();
/* 1199 */     skills.addAll(getFabaoSkills());
/* 1200 */     skills.addAll(WingInterface.getCurWingPlanSkills(this.roleId, true).keySet());
/* 1201 */     skills.addAll(FashionDressInterface.getFashionDressPassiveSkillMap(this.roleId, true).keySet());
/* 1202 */     List<Integer> itemSkillIds = ItemInterface.getEquipSkillList(this.roleId, false);
/* 1203 */     if ((itemSkillIds != null) && (itemSkillIds.size() > 0))
/*      */     {
/* 1205 */       skills.addAll(itemSkillIds);
/*      */     }
/* 1207 */     skills.addAll(MagicMarkInterface.getMagicMarkPassiveSkillMap(this.roleId, true).keySet());
/* 1208 */     List<Integer> geniusPassiveSkills = GeniusInterface.getPassiveSkillList(this.roleId, true);
/* 1209 */     if ((geniusPassiveSkills != null) && (geniusPassiveSkills.size() > 0))
/*      */     {
/* 1211 */       skills.addAll(geniusPassiveSkills);
/*      */     }
/*      */     
/* 1214 */     Map<Integer, Integer> geniusActiveSkills = GeniusInterface.getActiveSkills(this.roleId, true);
/* 1215 */     if ((geniusActiveSkills != null) && (geniusActiveSkills.size() > 0))
/*      */     {
/*      */ 
/* 1218 */       skills.addAll(geniusActiveSkills.values());
/*      */     }
/*      */     
/* 1221 */     Set<Integer> lingQiSkillIds = FabaoArtifactInterface.getArtifactSkills(this.roleId, true);
/* 1222 */     if ((lingQiSkillIds != null) && (lingQiSkillIds.size() > 0))
/*      */     {
/* 1224 */       skills.addAll(lingQiSkillIds);
/*      */     }
/* 1226 */     return skills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private List<Integer> getFabaoSkills()
/*      */   {
/* 1236 */     Set<Integer> skills = new HashSet();
/* 1237 */     List<Skill> fabaoSkills = FabaoInterface.getFaBaoSysSkills(this.roleId, true);
/* 1238 */     if ((fabaoSkills == null) || (fabaoSkills.size() == 0))
/*      */     {
/* 1240 */       return new ArrayList();
/*      */     }
/* 1242 */     for (Skill each : fabaoSkills)
/*      */     {
/* 1244 */       skills.add(Integer.valueOf(each.getID()));
/*      */     }
/* 1246 */     return new ArrayList(skills);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private List<Map<Integer, Integer>> getAllExtroScoreProp()
/*      */   {
/* 1256 */     List<Map<Integer, Integer>> pros = new ArrayList();
/*      */     
/* 1258 */     addProp(pros, ItemInterface.getAllEquipmentScoreProMap(this.roleId, true));
/* 1259 */     addProp(pros, FabaoInterface.getFabaoSysPro(this.roleId, true));
/* 1260 */     addProp(pros, WingInterface.getCurWingPlanPros(this.roleId, true));
/* 1261 */     addProp(pros, TitleInterface.getNowPropertyMap(this.roleId));
/* 1262 */     addProp(pros, MountsInterface.getCurrentMountsRoleProperty(this.roleId, true));
/* 1263 */     addProp(pros, AvatarInterface.getRoleAvatarProperties(this.roleId));
/* 1264 */     addProp(pros, FashionDressInterface.getThemeFashionDressRoleProperty(this.roleId, true));
/* 1265 */     addProp(pros, FabaoArtifactInterface.getArtifactProperties(this.roleId, true));
/*      */     
/* 1267 */     addProp(pros, AircraftInterface.getAircraftPropertyMap(this.roleId, true));
/* 1268 */     return pros;
/*      */   }
/*      */   
/*      */   private void addProp(List<Map<Integer, Integer>> pros, Map<Integer, Integer> addPros)
/*      */   {
/* 1273 */     if ((addPros == null) || (addPros.size() == 0))
/*      */     {
/* 1275 */       return;
/*      */     }
/* 1277 */     pros.add(addPros);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private List<Map<Integer, Integer>> getEquipPros()
/*      */   {
/* 1288 */     List<Map<Integer, Integer>> equipProps = new ArrayList();
/* 1289 */     EquipmentItem item = ItemInterface.getRoleEquipByWearPos(this.roleId, 3);
/* 1290 */     if (item != null)
/*      */     {
/* 1292 */       equipProps.add(item.getProperty2Value());
/*      */     }
/* 1294 */     item = ItemInterface.getRoleEquipByWearPos(this.roleId, 1);
/* 1295 */     if (item != null)
/*      */     {
/* 1297 */       equipProps.add(item.getProperty2Value());
/*      */     }
/* 1299 */     item = ItemInterface.getRoleEquipByWearPos(this.roleId, 2);
/* 1300 */     if (item != null)
/*      */     {
/* 1302 */       equipProps.add(item.getProperty2Value());
/*      */     }
/* 1304 */     item = ItemInterface.getRoleEquipByWearPos(this.roleId, 5);
/* 1305 */     if (item != null)
/*      */     {
/* 1307 */       equipProps.add(item.getProperty2Value());
/*      */     }
/* 1309 */     item = ItemInterface.getRoleEquipByWearPos(this.roleId, 0);
/* 1310 */     if (item != null)
/*      */     {
/* 1312 */       equipProps.add(item.getProperty2Value());
/*      */     }
/* 1314 */     item = ItemInterface.getRoleEquipByWearPos(this.roleId, 4);
/* 1315 */     if (item != null)
/*      */     {
/* 1317 */       equipProps.add(item.getProperty2Value());
/*      */     }
/* 1319 */     return equipProps;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSimpleInfo()
/*      */   {
/* 1329 */     StringBuilder sbSimpleInfo = new StringBuilder();
/* 1330 */     sbSimpleInfo.append("roleid=").append(getId());
/* 1331 */     sbSimpleInfo.append("|name=").append(getName());
/* 1332 */     sbSimpleInfo.append("|create_time=").append(getCreateTime() / 1000L);
/* 1333 */     sbSimpleInfo.append("|gender=").append(getGender());
/* 1334 */     sbSimpleInfo.append("|occupation=").append(getOccupationId());
/* 1335 */     sbSimpleInfo.append("|level=").append(getLevel());
/* 1336 */     sbSimpleInfo.append("|exp=").append(getExp());
/* 1337 */     sbSimpleInfo.append("|vigor=").append(getVigor());
/* 1338 */     sbSimpleInfo.append("|anger=").append(getAnger());
/* 1339 */     sbSimpleInfo.append("|activity_prop_sys=").append(this.xProperties.getActivitybpsys());
/* 1340 */     sbSimpleInfo.append("|hp=").append(getHP());
/* 1341 */     sbSimpleInfo.append("|mp=").append(getMP());
/* 1342 */     sbSimpleInfo.append("|max_hp=").append(getFinalMaxHP());
/* 1343 */     sbSimpleInfo.append("|max_mp=").append(getFinalMaxMP());
/* 1344 */     sbSimpleInfo.append("|phy_atk=").append(getFinalPHYATK());
/* 1345 */     sbSimpleInfo.append("|mag_atk=").append(getFinalMAGATK());
/* 1346 */     sbSimpleInfo.append("|phy_def=").append(getFinalPHYDEF());
/* 1347 */     sbSimpleInfo.append("|mag_def=").append(getFinalMAGDEF());
/* 1348 */     sbSimpleInfo.append("|speed=").append(getFinalSpeed());
/* 1349 */     sbSimpleInfo.append("|resist=").append(getFinalSealRst());
/* 1350 */     sbSimpleInfo.append("|seal_hit=").append(getFinalSeal());
/* 1351 */     sbSimpleInfo.append("|phy_crit_level=").append((int)getFinalProperty(85, -1, this.xProperties.getActivitybpsys()));
/*      */     
/* 1353 */     sbSimpleInfo.append("|phy_crit_def_level=").append((int)getFinalProperty(87, -1, this.xProperties.getActivitybpsys()));
/*      */     
/* 1355 */     sbSimpleInfo.append("|mag_crit_level=").append((int)getFinalProperty(86, -1, this.xProperties.getActivitybpsys()));
/*      */     
/* 1357 */     sbSimpleInfo.append("|mag_crit_def_level=").append((int)getFinalProperty(88, -1, this.xProperties.getActivitybpsys()));
/*      */     
/*      */ 
/* 1360 */     return sbSimpleInfo.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public IOutFightObject.FighterState getFighterState()
/*      */   {
/* 1366 */     if (getOccupationId() == 9)
/*      */     {
/* 1368 */       return new IOutFightObject.FighterState(1000, 1000);
/*      */     }
/* 1370 */     return null;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleOutFightObj1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */