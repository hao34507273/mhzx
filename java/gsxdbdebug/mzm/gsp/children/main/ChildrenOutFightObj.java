/*      */ package mzm.gsp.children.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.children.SSynChildrenCharacterRes;
/*      */ import mzm.gsp.children.SSynChildrenPotentialPointRes;
/*      */ import mzm.gsp.children.SSynChildrenPropMapRes;
/*      */ import mzm.gsp.children.confbean.SChildrenCharacterCfg;
/*      */ import mzm.gsp.children.confbean.SChildrenConsts;
/*      */ import mzm.gsp.children.confbean.SChildrenFightProp2BasePropTransform;
/*      */ import mzm.gsp.common.IOutFightObject;
/*      */ import mzm.gsp.common.IOutFightObject.FighterState;
/*      */ import mzm.gsp.common.PropertyFormula;
/*      */ import mzm.gsp.effect.main.OutFightEffect;
/*      */ import mzm.gsp.item.main.ChildrenEquipItem;
/*      */ import mzm.gsp.item.main.PetEquipmentItem;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.property.confbean.SLevelToPropertyCfg;
/*      */ import mzm.gsp.property.confbean.SOwnLevelToPropertyCfg;
/*      */ import mzm.gsp.pubdata.ModelInfo;
/*      */ import mzm.gsp.role.main.PropertyManager;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*      */ import mzm.gsp.skill.confbean.SXiuLianSkillCfg;
/*      */ import mzm.gsp.skill.main.PassiveSkill;
/*      */ import mzm.gsp.skill.main.SkillInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.AdulthoodInfo;
/*      */ import xbean.ChildInfo;
/*      */ import xbean.ChildrenOutFightBean;
/*      */ import xbean.ChildrenOutFightBeans;
/*      */ import xbean.Item;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleXiuLian;
/*      */ import xbean.XiuLianSkill;
/*      */ import xtable.Role2childoutfightbean;
/*      */ import xtable.Role2xiulianskill;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ChildrenOutFightObj
/*      */   extends Children
/*      */   implements IOutFightObject
/*      */ {
/*      */   private ChildrenOutFightBean xOutFightBean;
/*      */   private static final int GROW_APT_RATE = 1000;
/*      */   
/*      */   ChildrenOutFightObj(long roleid, long childid, ChildInfo xChildInfo)
/*      */   {
/*   62 */     super(roleid, childid, xChildInfo);
/*   63 */     ChildrenOutFightBeans xChildrenOutFightBeans = Role2childoutfightbean.get(Long.valueOf(roleid));
/*   64 */     if (xChildrenOutFightBeans == null)
/*      */     {
/*   66 */       xChildrenOutFightBeans = Pod.newChildrenOutFightBeans();
/*   67 */       Role2childoutfightbean.add(Long.valueOf(roleid), xChildrenOutFightBeans);
/*      */     }
/*   69 */     this.xOutFightBean = ((ChildrenOutFightBean)xChildrenOutFightBeans.getOutfigthchilds().get(Long.valueOf(childid)));
/*   70 */     if (this.xOutFightBean == null)
/*      */     {
/*   72 */       this.xOutFightBean = Pod.newChildrenOutFightBean();
/*   73 */       xChildrenOutFightBeans.getOutfigthchilds().put(Long.valueOf(childid), this.xOutFightBean);
/*      */     }
/*   75 */     int level = RoleInterface.getLevel(roleid);
/*   76 */     if (level != this.xOutFightBean.getLevel())
/*      */     {
/*   78 */       _updateOutFightProperty();
/*   79 */       onPropertyChange();
/*      */     }
/*      */   }
/*      */   
/*      */   private void _updateOutFightProperty()
/*      */   {
/*   85 */     _updateEquipment(false);
/*   86 */     _updatePassiveSkill(false);
/*   87 */     this.xOutFightBean.setLevel(RoleInterface.getLevel(this.roleid));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void updateOutFightProperty()
/*      */   {
/*   94 */     _updateOutFightProperty();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  101 */     onPropertyChange();
/*      */   }
/*      */   
/*      */ 
/*      */   private void onPropertyChange()
/*      */   {
/*  107 */     setHP(getFinalMaxHP());
/*  108 */     setMP(getFinalMaxMP());
/*      */   }
/*      */   
/*      */   public int getLevel()
/*      */   {
/*  113 */     return RoleInterface.getLevel(this.roleid);
/*      */   }
/*      */   
/*      */   void initOwner()
/*      */   {
/*  118 */     if (this.roleid != this.xChildInfo.getOwn_role_id())
/*      */     {
/*  120 */       return;
/*      */     }
/*  122 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  123 */     if (xAdulthoodInfo == null)
/*      */     {
/*  125 */       GameServer.logger().error(String.format("[Children]Children.onOwnerChanged@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  128 */       return;
/*      */     }
/*  130 */     int newLevel = RoleInterface.getLevel(this.roleid);
/*  131 */     if (newLevel != this.xOutFightBean.getLevel())
/*      */     {
/*  133 */       this.xOutFightBean.setLevel(newLevel);
/*      */       
/*  135 */       xAdulthoodInfo.getBasepropmap().clear();
/*      */       
/*  137 */       xAdulthoodInfo.setPotentialpoint(SChildrenConsts.getInstance().child_level_up_add_potential_num * newLevel);
/*      */       
/*  139 */       autoSetPotentialPoint();
/*      */     }
/*      */     
/*  142 */     _updateOutFightProperty();
/*  143 */     setHP(getFinalMaxHP());
/*  144 */     setMP(getFinalMaxMP());
/*      */   }
/*      */   
/*      */   void onLevelUp()
/*      */   {
/*  149 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  150 */     if (xAdulthoodInfo == null)
/*      */     {
/*  152 */       GameServer.logger().error(String.format("[Children]Children.onLevelUp@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*  154 */       return;
/*      */     }
/*  156 */     int nowLevel = RoleInterface.getLevel(this.roleid);
/*      */     
/*  158 */     if (nowLevel <= this.xOutFightBean.getLevel())
/*      */     {
/*  160 */       return;
/*      */     }
/*  162 */     int addLevel = nowLevel - this.xOutFightBean.getLevel();
/*  163 */     this.xOutFightBean.setLevel(nowLevel);
/*  164 */     int oldPotentialPoint = xAdulthoodInfo.getPotentialpoint();
/*  165 */     xAdulthoodInfo.setPotentialpoint(oldPotentialPoint + addLevel * SChildrenConsts.getInstance().child_level_up_add_potential_num);
/*      */     
/*  167 */     autoSetPotentialPoint();
/*      */     
/*  169 */     _updateOutFightProperty();
/*  170 */     setHP(getFinalMaxHP());
/*  171 */     setMP(getFinalMaxMP());
/*      */   }
/*      */   
/*      */   void autoSetPotentialPoint()
/*      */   {
/*  176 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  177 */     if (xAdulthoodInfo == null)
/*      */     {
/*  179 */       GameServer.logger().error(String.format("[Children]Children.autoSetPotentialPoint@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  182 */       return;
/*      */     }
/*  184 */     if (xAdulthoodInfo.getOccupation() <= 0)
/*      */     {
/*      */ 
/*  187 */       GameServer.logger().info(String.format("[Children]Children.autoSetPotentialPoint@do not has occupation|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*      */       
/*      */ 
/*  190 */       return;
/*      */     }
/*  192 */     int totalPotentialPoint = xAdulthoodInfo.getPotentialpoint();
/*  193 */     int totalPref = 0;
/*  194 */     for (Map.Entry<Integer, Integer> entry : xAdulthoodInfo.getBasepropset().entrySet())
/*      */     {
/*  196 */       totalPref += ((Integer)entry.getValue()).intValue();
/*      */     }
/*  198 */     if (totalPref <= 0)
/*      */     {
/*  200 */       GameServer.logger().info(String.format("[Children]Children.autoSetPotentialPoint@totalPref error|roleid=%d|childid=%d|totalPref=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(totalPref) }));
/*      */       
/*      */ 
/*  203 */       return;
/*      */     }
/*  205 */     int ret = totalPotentialPoint / totalPref;
/*  206 */     if (ret <= 0)
/*      */     {
/*  208 */       GameServer.logger().info(String.format("[Children]Children.autoSetPotentialPoint@totalPref error|roleid=%d|childid=%d|totalPref=%d|totalPotentialPoint=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(totalPref), Integer.valueOf(totalPotentialPoint) }));
/*      */       
/*      */ 
/*      */ 
/*  212 */       return;
/*      */     }
/*  214 */     for (Map.Entry<Integer, Integer> entry : xAdulthoodInfo.getBasepropset().entrySet())
/*      */     {
/*  216 */       int addValue = ((Integer)entry.getValue()).intValue() * ret;
/*  217 */       addBaseProp(((Integer)entry.getKey()).intValue(), addValue);
/*      */     }
/*  219 */     xAdulthoodInfo.setPotentialpoint(totalPotentialPoint - ret * totalPref);
/*      */   }
/*      */   
/*      */   private void addBaseProp(int propType, int addValue)
/*      */   {
/*  224 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  225 */     if (xAdulthoodInfo == null)
/*      */     {
/*  227 */       return;
/*      */     }
/*  229 */     Integer value = (Integer)xAdulthoodInfo.getBasepropmap().get(Integer.valueOf(propType));
/*  230 */     if (value != null)
/*      */     {
/*  232 */       xAdulthoodInfo.getBasepropmap().put(Integer.valueOf(propType), Integer.valueOf(value.intValue() + addValue));
/*      */     }
/*      */     else
/*      */     {
/*  236 */       xAdulthoodInfo.getBasepropmap().put(Integer.valueOf(propType), Integer.valueOf(addValue));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getAptValue(int aptType)
/*      */   {
/*  248 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  249 */     if (xAdulthoodInfo == null)
/*      */     {
/*  251 */       GameServer.logger().error(String.format("[Children]ChildrenOutFightObj.getAptValue@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  254 */       return 0;
/*      */     }
/*  256 */     Integer initValueInteger = (Integer)xAdulthoodInfo.getAptitudeinitmap().get(Integer.valueOf(aptType));
/*  257 */     Integer changeValueInteger = (Integer)xAdulthoodInfo.getAptitudechangemap().get(Integer.valueOf(aptType));
/*  258 */     int totalValue = 0;
/*  259 */     if (initValueInteger != null)
/*      */     {
/*  261 */       totalValue += initValueInteger.intValue();
/*      */     }
/*  263 */     if (changeValueInteger != null)
/*      */     {
/*  265 */       totalValue += changeValueInteger.intValue();
/*      */     }
/*  267 */     return totalValue;
/*      */   }
/*      */   
/*      */   void addAptValue(int aptType, int value)
/*      */   {
/*  272 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  273 */     if (xAdulthoodInfo == null)
/*      */     {
/*  275 */       GameServer.logger().error(String.format("[Children]ChildrenOutFightObj.addAptValue@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  278 */       return;
/*      */     }
/*  280 */     Integer changeValueInteger = (Integer)xAdulthoodInfo.getAptitudechangemap().get(Integer.valueOf(aptType));
/*  281 */     if (changeValueInteger != null)
/*      */     {
/*  283 */       value += changeValueInteger.intValue();
/*      */     }
/*  285 */     xAdulthoodInfo.getAptitudechangemap().put(Integer.valueOf(aptType), Integer.valueOf(value));
/*      */   }
/*      */   
/*      */   SLevelToPropertyCfg getLevelToPropertyCfg(int level)
/*      */   {
/*  290 */     int levelKey = SChildrenConsts.getInstance().child_base_prop_type_id * 1000 + level;
/*  291 */     SOwnLevelToPropertyCfg cfg = SOwnLevelToPropertyCfg.get(levelKey);
/*  292 */     if (cfg == null)
/*      */     {
/*  294 */       GameServer.logger().error(String.format("[Child]ChildrenOutFightObj.getOwnLevelToPropertyCfg@ no levelKey data!|levelKey=%d|roleid=%d", new Object[] { Integer.valueOf(levelKey), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*      */ 
/*  298 */       return null;
/*      */     }
/*  300 */     return SLevelToPropertyCfg.get(cfg.SLevelToPropertyCfgId);
/*      */   }
/*      */   
/*      */   Map<Integer, Double> getGrowProMap(int level)
/*      */   {
/*  305 */     SLevelToPropertyCfg levelToPropertyCfg = getLevelToPropertyCfg(level);
/*  306 */     if (levelToPropertyCfg == null)
/*      */     {
/*  308 */       GameServer.logger().error(String.format("[Child]ChildrenOutFightObj.getGrowProMap@ no SLevelToPropertyCfg data!|level=%d|roleid=%d", new Object[] { Integer.valueOf(level), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  311 */       return new HashMap();
/*      */     }
/*  313 */     Map<Integer, Double> proMap = new HashMap();
/*  314 */     fillProMap(levelToPropertyCfg, proMap);
/*  315 */     return proMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillProMap(SLevelToPropertyCfg cfg, Map<Integer, Double> proMap)
/*      */   {
/*  326 */     proMap.put(Integer.valueOf(1), Double.valueOf(cfg.addMaxHpPerLevel));
/*  327 */     proMap.put(Integer.valueOf(3), Double.valueOf(cfg.addMaxMpPerLevel));
/*  328 */     proMap.put(Integer.valueOf(7), Double.valueOf(cfg.addPhyAtkPerLevel));
/*  329 */     proMap.put(Integer.valueOf(8), Double.valueOf(cfg.addPhyDefPerLevel));
/*  330 */     proMap.put(Integer.valueOf(9), Double.valueOf(cfg.addMagAtkPerLevel));
/*  331 */     proMap.put(Integer.valueOf(10), Double.valueOf(cfg.addMagDefPerLevel));
/*  332 */     proMap.put(Integer.valueOf(11), Double.valueOf(cfg.addPhyCrtRatePerLevel));
/*  333 */     proMap.put(Integer.valueOf(12), Double.valueOf(cfg.addMagCrtRatePerLevel));
/*  334 */     proMap.put(Integer.valueOf(14), Double.valueOf(cfg.addPhyCrtValuePerLevel));
/*  335 */     proMap.put(Integer.valueOf(15), Double.valueOf(cfg.addMagCrtValuePerLevel));
/*  336 */     proMap.put(Integer.valueOf(16), Double.valueOf(cfg.addSealHitLevelPerLevel));
/*  337 */     proMap.put(Integer.valueOf(17), Double.valueOf(cfg.addSealResLevelPerLevel));
/*  338 */     proMap.put(Integer.valueOf(18), Double.valueOf(cfg.addPhyHitLevelPerLevel));
/*  339 */     proMap.put(Integer.valueOf(19), Double.valueOf(cfg.addPhyDodgeLevelPerLevel));
/*  340 */     proMap.put(Integer.valueOf(20), Double.valueOf(cfg.addMagHitLevelPerLevel));
/*  341 */     proMap.put(Integer.valueOf(21), Double.valueOf(cfg.addMagDodgeLevelPerLevel));
/*  342 */     proMap.put(Integer.valueOf(24), Double.valueOf(cfg.addSpeedPerLevelPerLevel));
/*  343 */     proMap.put(Integer.valueOf(85), Double.valueOf(cfg.addPhyCrtLevelPerLevel));
/*  344 */     proMap.put(Integer.valueOf(87), Double.valueOf(cfg.addPhyCrtLevelDefPerLevel));
/*  345 */     proMap.put(Integer.valueOf(86), Double.valueOf(cfg.addMagCrtLevelPerLevel));
/*  346 */     proMap.put(Integer.valueOf(88), Double.valueOf(cfg.addMagCrtLevelDefPerLevel));
/*      */   }
/*      */   
/*      */   private double calculateTypeAfterApt(int propertyType, double growPropValue)
/*      */   {
/*  351 */     int aptValue = 0;
/*  352 */     switch (propertyType)
/*      */     {
/*      */     case 1: 
/*  355 */       aptValue = getAptValue(1);
/*  356 */       break;
/*      */     case 7: 
/*  358 */       aptValue = getAptValue(2);
/*  359 */       break;
/*      */     case 8: 
/*  361 */       aptValue = getAptValue(4);
/*  362 */       break;
/*      */     case 9: 
/*  364 */       aptValue = getAptValue(3);
/*  365 */       break;
/*      */     case 10: 
/*  367 */       aptValue = getAptValue(5);
/*  368 */       break;
/*      */     case 24: 
/*  370 */       aptValue = getAptValue(6);
/*  371 */       break;
/*      */     default: 
/*  373 */       return growPropValue;
/*      */     }
/*  375 */     if (aptValue <= 0)
/*      */     {
/*  377 */       return growPropValue;
/*      */     }
/*  379 */     growPropValue *= aptValue * 1.0D / 1000.0D;
/*  380 */     return growPropValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int calculateType(int propertyType)
/*      */   {
/*  391 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  392 */     if (xAdulthoodInfo == null)
/*      */     {
/*  394 */       GameServer.logger().error(String.format("[Children]ChildrenOutFightObj.calculateType@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  397 */       return 0;
/*      */     }
/*  399 */     double propValue = 0.0D;
/*  400 */     int level = getLevel();
/*      */     
/*  402 */     Map<Integer, Double> growProMap = getGrowProMap(level);
/*  403 */     double growPropValue = 0.0D;
/*  404 */     Double finalGrowPropValue = (Double)growProMap.get(Integer.valueOf(propertyType));
/*  405 */     if (finalGrowPropValue != null)
/*      */     {
/*  407 */       growPropValue = finalGrowPropValue.doubleValue();
/*      */     }
/*      */     
/*  410 */     growPropValue = calculateTypeAfterApt(propertyType, growPropValue);
/*      */     
/*  412 */     propValue += growPropValue;
/*      */     
/*      */ 
/*  415 */     SChildrenFightProp2BasePropTransform stTransformProp = SChildrenFightProp2BasePropTransform.get(propertyType);
/*  416 */     if (stTransformProp != null)
/*      */     {
/*  418 */       for (Map.Entry<Integer, Double> entry : stTransformProp.baseProp2Factor.entrySet())
/*      */       {
/*  420 */         double baseValueTransform = getBaseValue(((Integer)entry.getKey()).intValue(), level) * ((Double)entry.getValue()).doubleValue();
/*  421 */         float grow = xAdulthoodInfo.getGrow();
/*  422 */         if (grow > 0.0F)
/*      */         {
/*  424 */           baseValueTransform *= grow;
/*      */         }
/*  426 */         propValue += baseValueTransform;
/*      */       }
/*      */     }
/*      */     
/*  430 */     return (int)Math.round(propValue);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getBaseValue(int propType, int level)
/*      */   {
/*  440 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  441 */     if (xAdulthoodInfo == null)
/*      */     {
/*  443 */       GameServer.logger().error(String.format("[Children]ChildrenOutFightObj.getBaseValue@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  446 */       return 0;
/*      */     }
/*  448 */     int ret = 0;
/*  449 */     Integer baseValue = (Integer)xAdulthoodInfo.getBasepropmap().get(Integer.valueOf(propType));
/*  450 */     if (baseValue != null)
/*      */     {
/*  452 */       ret += baseValue.intValue();
/*      */     }
/*  454 */     switch (propType)
/*      */     {
/*      */     case 25: 
/*  457 */       ret += SChildrenConsts.getInstance().child_level_up_add_STR * level + SChildrenConsts.getInstance().child_init_STR;
/*      */       
/*  459 */       break;
/*      */     case 26: 
/*  461 */       ret += SChildrenConsts.getInstance().child_level_up_add_DEX * level + SChildrenConsts.getInstance().child_init_DEX;
/*      */       
/*  463 */       break;
/*      */     case 27: 
/*  465 */       ret += SChildrenConsts.getInstance().child_level_up_add_SPR * level + SChildrenConsts.getInstance().child_init_SPR;
/*      */       
/*  467 */       break;
/*      */     case 28: 
/*  469 */       ret += SChildrenConsts.getInstance().child_level_up_add_CON * level + SChildrenConsts.getInstance().child_init_CON;
/*      */       
/*  471 */       break;
/*      */     case 29: 
/*  473 */       ret += SChildrenConsts.getInstance().child_level_up_add_STA * level + SChildrenConsts.getInstance().child_init_STA;
/*      */       
/*  475 */       break;
/*      */     default: 
/*  477 */       GameServer.logger().error(String.format("[Child]ChildrenOutFightObj.do not exist base property|propType=%d|roleid=%d", new Object[] { Integer.valueOf(propType), Long.valueOf(this.roleid) }));
/*      */     }
/*      */     
/*      */     
/*      */ 
/*  482 */     return ret;
/*      */   }
/*      */   
/*      */   private void addEquipmentProp(Map<Integer, Integer> propMap)
/*      */   {
/*  487 */     for (Map.Entry<Integer, Integer> entry : propMap.entrySet())
/*      */     {
/*  489 */       addEquipmentProp(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addEquipmentProp(int propType, int propValue)
/*      */   {
/*  501 */     Integer propVal = (Integer)this.xOutFightBean.getEquipstaticaddpropmap().get(Integer.valueOf(propType));
/*  502 */     if (propVal == null)
/*      */     {
/*  504 */       propVal = Integer.valueOf(0);
/*      */     }
/*  506 */     this.xOutFightBean.getEquipstaticaddpropmap().put(Integer.valueOf(propType), Integer.valueOf(propVal.intValue() + propValue));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void updateEquipment()
/*      */   {
/*  514 */     _updateEquipment(true);
/*      */   }
/*      */   
/*      */   private void _updateEquipment(boolean triggerChange)
/*      */   {
/*  519 */     this.xOutFightBean.getEquipstaticaddpropmap().clear();
/*  520 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  521 */     if (xAdulthoodInfo == null)
/*      */     {
/*  523 */       GameServer.logger().error(String.format("[Children]ChildrenOutFightObj.getActiveSkillMap@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  526 */       return;
/*      */     }
/*      */     
/*  529 */     for (Item xItem : xAdulthoodInfo.getEquipitem().values())
/*      */     {
/*  531 */       ChildrenEquipItem childrenEquipItem = new ChildrenEquipItem(xItem);
/*  532 */       addEquipmentProp(childrenEquipItem.getProMap());
/*      */     }
/*  534 */     for (Item xPetItem : xAdulthoodInfo.getEquippetitem().values())
/*      */     {
/*  536 */       PetEquipmentItem petEquipmentItem = new PetEquipmentItem(xPetItem);
/*  537 */       addEquipmentProp(petEquipmentItem.getPropMap());
/*      */     }
/*  539 */     if (triggerChange)
/*      */     {
/*  541 */       onPropertyChange();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getOutFightBeanProperty(int propertyType)
/*      */   {
/*  553 */     int propValue = 0;
/*  554 */     Integer outfightPropValue = (Integer)this.xOutFightBean.getEquipstaticaddpropmap().get(Integer.valueOf(propertyType));
/*  555 */     if (outfightPropValue != null)
/*      */     {
/*  557 */       propValue += outfightPropValue.intValue();
/*      */     }
/*  559 */     Integer effectProp = (Integer)this.xOutFightBean.getEffectaddpropmap().get(Integer.valueOf(propertyType));
/*  560 */     if (effectProp != null)
/*      */     {
/*  562 */       propValue += effectProp.intValue();
/*      */     }
/*  564 */     return propValue;
/*      */   }
/*      */   
/*      */   int getOuterValue(int propertyType)
/*      */   {
/*  569 */     int propValue = 0;
/*      */     
/*  571 */     Integer outfightPropValue = Integer.valueOf(getOutFightBeanProperty(propertyType));
/*  572 */     if (outfightPropValue != null)
/*      */     {
/*  574 */       propValue += outfightPropValue.intValue();
/*      */     }
/*  576 */     return propValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void updatePassiveSkill()
/*      */   {
/*  584 */     _updatePassiveSkill(true);
/*      */   }
/*      */   
/*      */   private void _updatePassiveSkill(boolean triggerChange)
/*      */   {
/*  589 */     Set<OutFightEffect> effectSet = this.xOutFightBean.getSkilleffectset();
/*  590 */     for (OutFightEffect effect : effectSet)
/*      */     {
/*  592 */       effect.detach(this);
/*      */     }
/*  594 */     this.xOutFightBean.getSkilleffectset().clear();
/*  595 */     this.xOutFightBean.getEffectaddpropmap().clear();
/*  596 */     for (PassiveSkill passiveSkill : getPassiveSkills())
/*      */     {
/*  598 */       List<OutFightEffect> outFightEffects = passiveSkill.getEffectList(this);
/*  599 */       for (OutFightEffect effect : outFightEffects)
/*      */       {
/*  601 */         effect.attach(this);
/*  602 */         this.xOutFightBean.getSkilleffectset().add(effect);
/*      */       }
/*      */     }
/*  605 */     if (triggerChange)
/*      */     {
/*  607 */       onPropertyChange();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSex()
/*      */   {
/*  614 */     return this.xChildInfo.getChild_gender();
/*      */   }
/*      */   
/*      */ 
/*      */   public void fillSelfFixFightProperty(Map<Integer, Integer> propMap)
/*      */   {
/*  620 */     for (Integer prop : PropertyFormula.PROP_LIST)
/*      */     {
/*  622 */       fillDefaultInnverProperty(prop.intValue(), propMap);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public Map<Integer, Integer> getSelfFixFightProperty()
/*      */   {
/*  629 */     Map<Integer, Integer> propMap = new HashMap();
/*  630 */     fillSelfFixFightProperty(propMap);
/*  631 */     return propMap;
/*      */   }
/*      */   
/*      */ 
/*      */   public void fillOtherFightProperty(Map<Integer, Integer> propMap)
/*      */   {
/*  637 */     for (Integer prop : PropertyFormula.PROP_LIST)
/*      */     {
/*  639 */       fillDefaultOutProperty(prop.intValue(), propMap);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public Map<Integer, Integer> getOtherFightProperty()
/*      */   {
/*  646 */     Map<Integer, Integer> propMap = new HashMap();
/*  647 */     fillOtherFightProperty(propMap);
/*  648 */     return propMap;
/*      */   }
/*      */   
/*      */ 
/*      */   public Map<Integer, Integer> getFinalPropertyMap()
/*      */   {
/*  654 */     Map<Integer, Integer> propMap = new HashMap();
/*  655 */     fillFinalPropertyMap(propMap);
/*  656 */     return propMap;
/*      */   }
/*      */   
/*      */ 
/*      */   public void fillFinalPropertyMap(Map<Integer, Integer> propMap)
/*      */   {
/*  662 */     Map<Integer, Integer> pro2Ret = PropertyManager.getPro2Ret();
/*  663 */     Iterator<Map.Entry<Integer, Integer>> it = pro2Ret.entrySet().iterator();
/*  664 */     while (it.hasNext())
/*      */     {
/*  666 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/*  667 */       int propType = ((Integer)entry.getKey()).intValue();
/*  668 */       int finalValue = getFinalProperty(propType, ((Integer)entry.getValue()).intValue());
/*  669 */       propMap.put(Integer.valueOf(propType), Integer.valueOf(finalValue));
/*      */     }
/*      */     
/*  672 */     propMap.put(Integer.valueOf(2), Integer.valueOf(getHP()));
/*  673 */     propMap.put(Integer.valueOf(4), Integer.valueOf(getMP()));
/*      */   }
/*      */   
/*      */   private void fillDefaultOutProperty(int propertyType, Map<Integer, Integer> propMap)
/*      */   {
/*  678 */     Integer propValue = Integer.valueOf(getOuterValue(propertyType));
/*  679 */     if (propValue == null)
/*      */     {
/*  681 */       propValue = Integer.valueOf(0);
/*      */     }
/*  683 */     propMap.put(Integer.valueOf(propertyType), propValue);
/*      */   }
/*      */   
/*      */   private void fillDefaultInnverProperty(int propertyType, Map<Integer, Integer> propMap)
/*      */   {
/*  688 */     int innerValue = calculateType(propertyType);
/*  689 */     propMap.put(Integer.valueOf(propertyType), Integer.valueOf(innerValue));
/*      */   }
/*      */   
/*      */   private int getFinalProperty(int properType, int addPercentType)
/*      */   {
/*  694 */     int innerValue = calculateType(properType);
/*  695 */     Integer innerAddRate = Integer.valueOf(getOutFightBeanProperty(addPercentType));
/*  696 */     int outerValue = getOuterValue(properType);
/*  697 */     return (int)PropertyFormula.petFormulaFinalProperty(innerValue, outerValue, innerAddRate.intValue());
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMaxHP()
/*      */   {
/*  703 */     return getFinalProperty(1, 30);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMaxMP()
/*      */   {
/*  709 */     return getFinalProperty(3, 31);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalPHYATK()
/*      */   {
/*  715 */     return getFinalProperty(7, 33);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMAGATK()
/*      */   {
/*  721 */     return getFinalProperty(9, 35);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalPHYDEF()
/*      */   {
/*  727 */     return getFinalProperty(8, 34);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMAGDEF()
/*      */   {
/*  733 */     return getFinalProperty(10, 36);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalPHYCRTRate()
/*      */   {
/*  739 */     return getFinalProperty(11, -1);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMAGCRTRate()
/*      */   {
/*  745 */     return getFinalProperty(12, -1);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalPHYCRTVALUE()
/*      */   {
/*  751 */     return getFinalProperty(14, 37);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalMAGCRTVALUE()
/*      */   {
/*  757 */     return getFinalProperty(15, 38);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalSpeed()
/*      */   {
/*  763 */     return getFinalProperty(24, 47);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalSeal()
/*      */   {
/*  769 */     return getFinalProperty(16, 39);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFinalSealRst()
/*      */   {
/*  775 */     return getFinalProperty(17, 40);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void addPropertyValue(int type, int value)
/*      */   {
/*  782 */     Integer effectProp = (Integer)this.xOutFightBean.getEffectaddpropmap().get(Integer.valueOf(type));
/*  783 */     if (effectProp != null)
/*      */     {
/*  785 */       value += effectProp.intValue();
/*      */     }
/*  787 */     this.xOutFightBean.getEffectaddpropmap().put(Integer.valueOf(type), Integer.valueOf(value));
/*      */   }
/*      */   
/*      */ 
/*      */   public void fillModelInfo(ModelInfo modelInfo)
/*      */   {
/*  793 */     getModel(modelInfo);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<SOutFightEffectGroup> getFighterEffect()
/*      */   {
/*  799 */     List<SOutFightEffectGroup> effectList = new ArrayList();
/*  800 */     List<PassiveSkill> passiveSkills = getPassiveSkills();
/*  801 */     for (PassiveSkill passiveSkill : passiveSkills)
/*      */     {
/*  803 */       effectList.addAll(passiveSkill.getFighterEffectList());
/*      */     }
/*  805 */     return effectList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<PassiveSkill> getPassiveSkills()
/*      */   {
/*  816 */     List<PassiveSkill> passiveSkills = new ArrayList();
/*      */     
/*  818 */     Map<Integer, Integer> passiveSkill2Lv = new HashMap();
/*  819 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  820 */     if (xAdulthoodInfo == null)
/*      */     {
/*  822 */       GameServer.logger().error(String.format("[Children]ChildrenOutFightObj.getPassiveSkills@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  825 */       return passiveSkills;
/*      */     }
/*      */     
/*  828 */     for (Iterator i$ = xAdulthoodInfo.getSkillbookskills().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*      */       
/*  830 */       if (SkillInterface.isPassiveSkill(skillid))
/*      */       {
/*  832 */         passiveSkill2Lv.put(Integer.valueOf(skillid), Integer.valueOf(1));
/*      */       }
/*      */     }
/*  835 */     passiveSkill2Lv.put(Integer.valueOf(xAdulthoodInfo.getSpecialskillid()), Integer.valueOf(1));
/*      */     
/*      */ 
/*  838 */     Map<Integer, SChildrenCharacterCfg> characterMap = SChildrenCharacterCfg.getAll();
/*  839 */     if ((characterMap instanceof TreeMap))
/*      */     {
/*  841 */       TreeMap<Integer, SChildrenCharacterCfg> map = (TreeMap)characterMap;
/*  842 */       Map.Entry<Integer, SChildrenCharacterCfg> entry = map.floorEntry(Integer.valueOf(xAdulthoodInfo.getCharacter()));
/*  843 */       if (entry != null)
/*      */       {
/*  845 */         int passiveSkillid = ((SChildrenCharacterCfg)entry.getValue()).passiveSkillid;
/*  846 */         passiveSkill2Lv.put(Integer.valueOf(passiveSkillid), Integer.valueOf(1));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  851 */     Item xItem = (Item)xAdulthoodInfo.getEquippetitem().get(Integer.valueOf(2));
/*  852 */     Iterator i$; if (xItem != null)
/*      */     {
/*  854 */       PetEquipmentItem petEquipmentItem = new PetEquipmentItem(xItem);
/*  855 */       for (i$ = petEquipmentItem.getSkills().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*      */         
/*  857 */         if (SkillInterface.isPassiveSkill(skillid))
/*      */         {
/*  859 */           passiveSkill2Lv.put(Integer.valueOf(skillid), Integer.valueOf(1));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  865 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(this.roleid));
/*  866 */     if (xRoleXiuLian != null)
/*      */     {
/*  868 */       for (Map.Entry<Integer, XiuLianSkill> xXiuLianSkillEntry : xRoleXiuLian.getSkillmap().entrySet())
/*      */       {
/*  870 */         XiuLianSkill xXiuLianSkill = (XiuLianSkill)xXiuLianSkillEntry.getValue();
/*  871 */         if (xXiuLianSkill.getLevel() != 0)
/*      */         {
/*      */ 
/*      */ 
/*  875 */           SXiuLianSkillCfg sXiuLianSkillCfg = SXiuLianSkillCfg.get(((Integer)xXiuLianSkillEntry.getKey()).intValue());
/*  876 */           if ((sXiuLianSkillCfg.target & 0x8) != 0)
/*      */           {
/*      */ 
/*      */ 
/*  880 */             passiveSkill2Lv.put(Integer.valueOf(sXiuLianSkillCfg.skillId), Integer.valueOf(xXiuLianSkill.getLevel())); }
/*      */         }
/*      */       }
/*      */     }
/*  884 */     Iterator<Map.Entry<Integer, Integer>> iterator = passiveSkill2Lv.entrySet().iterator();
/*  885 */     Iterator i$; while (iterator.hasNext())
/*      */     {
/*  887 */       Map.Entry<Integer, Integer> entry = (Map.Entry)iterator.next();
/*  888 */       int skillid = ((Integer)entry.getKey()).intValue();
/*  889 */       List<Integer> skillList = SkillInterface.getHigherSkillId(skillid);
/*  890 */       if (!skillList.isEmpty())
/*      */       {
/*      */ 
/*      */ 
/*  894 */         for (i$ = skillList.iterator(); i$.hasNext();) { int highId = ((Integer)i$.next()).intValue();
/*      */           
/*  896 */           if (passiveSkill2Lv.containsKey(Integer.valueOf(highId)))
/*      */           {
/*  898 */             iterator.remove();
/*  899 */             break;
/*      */           }
/*      */         } }
/*      */     }
/*  903 */     SkillInterface.removeMutexSkill(passiveSkill2Lv);
/*  904 */     for (Map.Entry<Integer, Integer> entry : passiveSkill2Lv.entrySet())
/*      */     {
/*  906 */       PassiveSkill passiveSkill = SkillInterface.getPassiveSkillById2Lv(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*  907 */       if (passiveSkill != null)
/*      */       {
/*      */ 
/*      */ 
/*  911 */         passiveSkills.add(passiveSkill); }
/*      */     }
/*  913 */     return passiveSkills;
/*      */   }
/*      */   
/*      */ 
/*      */   public Map<Integer, Integer> getActiveSkillMap()
/*      */   {
/*  919 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  920 */     if (xAdulthoodInfo == null)
/*      */     {
/*  922 */       GameServer.logger().error(String.format("[Children]ChildrenOutFightObj.getActiveSkillMap@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  925 */       return Collections.EMPTY_MAP;
/*      */     }
/*  927 */     return getActive2LvSkillMap(xAdulthoodInfo);
/*      */   }
/*      */   
/*      */   private static Map<Integer, Integer> getActive2LvSkillMap(AdulthoodInfo xAdulthoodInfo)
/*      */   {
/*  932 */     Map<Integer, Integer> skill2LvMap = new HashMap();
/*  933 */     for (Iterator i$ = xAdulthoodInfo.getSkillbookskills().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*      */       
/*  935 */       if (SkillInterface.isActiveSkill(skillid))
/*      */       {
/*  937 */         skill2LvMap.put(Integer.valueOf(skillid), Integer.valueOf(1));
/*      */       }
/*      */     }
/*  940 */     for (Iterator i$ = xAdulthoodInfo.getFightskills().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*      */       
/*  942 */       Integer lv = (Integer)xAdulthoodInfo.getOccupationskill2value().get(Integer.valueOf(skillid));
/*  943 */       if (lv == null)
/*      */       {
/*  945 */         lv = Integer.valueOf(1);
/*      */       }
/*  947 */       skill2LvMap.put(Integer.valueOf(skillid), lv);
/*      */     }
/*      */     
/*  950 */     Item xItem = (Item)xAdulthoodInfo.getEquippetitem().get(Integer.valueOf(2));
/*  951 */     Iterator i$; if (xItem != null)
/*      */     {
/*  953 */       PetEquipmentItem petEquipmentItem = new PetEquipmentItem(xItem);
/*  954 */       for (i$ = petEquipmentItem.getSkills().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*      */         
/*  956 */         if (SkillInterface.isActiveSkill(skillid))
/*      */         {
/*  958 */           skill2LvMap.put(Integer.valueOf(skillid), Integer.valueOf(1));
/*      */         }
/*      */       }
/*      */     }
/*  962 */     return skill2LvMap;
/*      */   }
/*      */   
/*      */   static Set<Integer> getActiveSkills(AdulthoodInfo xAdulthoodInfo)
/*      */   {
/*  967 */     return getActive2LvSkillMap(xAdulthoodInfo).keySet();
/*      */   }
/*      */   
/*      */   public void setFightFlag(boolean inFight)
/*      */   {
/*  972 */     this.xOutFightBean.setFightflag(inFight);
/*      */   }
/*      */   
/*      */   public boolean isInFight()
/*      */   {
/*  977 */     return this.xOutFightBean.getFightflag();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int addCharater(int addValue, int tipType)
/*      */   {
/*  989 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  990 */     if (xAdulthoodInfo == null)
/*      */     {
/*  992 */       GameServer.logger().error(String.format("[Children]ChildrenOutFightObj.addCharater@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*      */       
/*      */ 
/*  995 */       return 0;
/*      */     }
/*  997 */     int character = xAdulthoodInfo.getCharacter();
/*  998 */     character += addValue;
/*  999 */     character = Math.max(0, character);
/* 1000 */     character = Math.min(character, SChildrenConsts.getInstance().child_grow_character_max);
/* 1001 */     xAdulthoodInfo.setCharacter(character);
/*      */     
/* 1003 */     SSynChildrenCharacterRes synChildrenCharacterRes = new SSynChildrenCharacterRes();
/* 1004 */     synChildrenCharacterRes.childrenid = this.childid;
/* 1005 */     synChildrenCharacterRes.character = character;
/* 1006 */     synChildrenCharacterRes.tiptype = tipType;
/* 1007 */     OnlineManager.getInstance().send(this.roleid, synChildrenCharacterRes);
/* 1008 */     return character;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int addCharater(int addValue)
/*      */   {
/* 1019 */     return addCharater(addValue, 0);
/*      */   }
/*      */   
/*      */   public void synPropertyChange(long roleid)
/*      */   {
/* 1024 */     SSynChildrenPropMapRes synChildrenPropMapRes = new SSynChildrenPropMapRes();
/* 1025 */     synChildrenPropMapRes.childrenid = getId();
/* 1026 */     fillFinalPropertyMap(synChildrenPropMapRes.propmap);
/* 1027 */     OnlineManager.getInstance().send(roleid, synChildrenPropMapRes);
/*      */   }
/*      */   
/*      */   public void synPotentialPoint(long roleid)
/*      */   {
/* 1032 */     SSynChildrenPotentialPointRes synChildrenPotentialPointRes = new SSynChildrenPotentialPointRes();
/* 1033 */     synChildrenPotentialPointRes.childrenid = getId();
/* 1034 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/* 1035 */     if (xAdulthoodInfo != null)
/*      */     {
/* 1037 */       synChildrenPotentialPointRes.potentialpoint = xAdulthoodInfo.getPotentialpoint();
/*      */     }
/* 1039 */     OnlineManager.getInstance().send(roleid, synChildrenPotentialPointRes);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getOccupationId()
/*      */   {
/* 1045 */     if (this.xChildInfo == null)
/*      */     {
/* 1047 */       return -1;
/*      */     }
/* 1049 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/* 1050 */     if (xAdulthoodInfo == null)
/*      */     {
/* 1052 */       return -1;
/*      */     }
/* 1054 */     return xAdulthoodInfo.getOccupation();
/*      */   }
/*      */   
/*      */ 
/*      */   public IOutFightObject.FighterState getFighterState()
/*      */   {
/* 1060 */     if (getOccupationId() == 9)
/*      */     {
/* 1062 */       return new IOutFightObject.FighterState(1000, 1000);
/*      */     }
/* 1064 */     return null;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\ChildrenOutFightObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */