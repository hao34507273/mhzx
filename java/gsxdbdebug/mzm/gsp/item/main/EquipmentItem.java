/*      */ package mzm.gsp.item.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.gsp.common.PropertyRandomUtil;
/*      */ import mzm.gsp.common.PropertyRandomUtil.KeyValuePair;
/*      */ import mzm.gsp.common.confbean.SEquipHunColorCfg;
/*      */ import mzm.gsp.common.confbean.SProRandomCountCfg;
/*      */ import mzm.gsp.common.confbean.SProRandomValueCfg;
/*      */ import mzm.gsp.item.confbean.SEquipQiLinCfg;
/*      */ import mzm.gsp.item.confbean.SEquipTransferInherit;
/*      */ import mzm.gsp.item.confbean.SEquipmentInitialQilingLevelCfg;
/*      */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*      */ import mzm.gsp.skill.confbean.SPassiveSkillCfg;
/*      */ import mzm.gsp.skill.main.PassiveSkill;
/*      */ import mzm.gsp.skill.main.SkillInterface;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.UuidUtils;
/*      */ import mzm.gsp.util.UuidUtils.UuidType;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FumoInfo;
/*      */ import xbean.Item;
/*      */ import xbean.Pod;
/*      */ import xbean.SuperEquipmentCostBean;
/*      */ import xbean.TempExtraProInfo;
/*      */ import xbean.XExtraProBean;
/*      */ import xdb.Xdb;
/*      */ 
/*      */ public final class EquipmentItem extends BasicItem
/*      */ {
/*      */   public EquipmentItem(Item item)
/*      */   {
/*   40 */     super(item);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean onCreateItem()
/*      */   {
/*   48 */     int itemId = getCfgId();
/*      */     
/*   50 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(itemId);
/*   51 */     if (sItemEquipCfg == null)
/*      */     {
/*   53 */       String logStr = String.format("[item]EquipmentItem.onCreateItem@equip itemid error|itemid=%d", new Object[] { Integer.valueOf(itemId) });
/*   54 */       ItemManager.logger.error(logStr);
/*   55 */       return false;
/*      */     }
/*      */     
/*   58 */     SProRandomCountCfg sProRandomCountCfg = SProRandomCountCfg.get(sItemEquipCfg.exattrprobId);
/*   59 */     if (sProRandomCountCfg != null)
/*      */     {
/*   61 */       int hunnum = computeHunNum(sItemEquipCfg);
/*   62 */       List<PropertyRandomUtil.KeyValuePair> listKeyValuePairs = PropertyRandomUtil.randomPropertyList(sItemEquipCfg.exattrprobId, hunnum);
/*   63 */       for (PropertyRandomUtil.KeyValuePair keyValuePair : listKeyValuePairs)
/*      */       {
/*   65 */         XExtraProBean extraProBean = Pod.newXExtraProBean();
/*   66 */         extraProBean.setProtype(keyValuePair.getKey());
/*   67 */         extraProBean.setProvalue(keyValuePair.getValue());
/*   68 */         addExtraPro(extraProBean);
/*      */       }
/*      */     }
/*      */     
/*   72 */     int usePoiont = ItemConfigManager.getSEquipTransferHun(sItemEquipCfg.useLevel).usePoint;
/*   73 */     setExtra(ItemStoreEnum.USE_POINT_VALUE, usePoiont);
/*      */     
/*   75 */     int randomAttriAValue = Xdb.random().nextInt(10000);
/*   76 */     setExtra(ItemStoreEnum.ATTRI_A, randomAttriAValue);
/*      */     
/*   78 */     int randomAttriBValue = Xdb.random().nextInt(10000);
/*   79 */     setExtra(ItemStoreEnum.ATTRI_B, randomAttriBValue);
/*      */     
/*      */ 
/*   82 */     SEquipmentInitialQilingLevelCfg equipmentInitialQilingLevelCfg = SEquipmentInitialQilingLevelCfg.get(getCfgId());
/*      */     
/*   84 */     if (equipmentInitialQilingLevelCfg == null)
/*      */     {
/*   86 */       setExtra(ItemStoreEnum.STRENGTH_LEVEL, 0);
/*      */     }
/*      */     else
/*      */     {
/*   90 */       setExtra(ItemStoreEnum.STRENGTH_LEVEL, equipmentInitialQilingLevelCfg.initialQilingLevel);
/*      */     }
/*      */     
/*      */ 
/*   94 */     if (sItemEquipCfg.skillid > 0)
/*      */     {
/*   96 */       int p = Xdb.random().nextInt(10000);
/*   97 */       if (p < sItemEquipCfg.skillProb)
/*      */       {
/*   99 */         int skillid = ItemConfigManager.randomEquipSkill(sItemEquipCfg.skillid);
/*  100 */         if (skillid > 0)
/*      */         {
/*  102 */           setExtra(ItemStoreEnum.EQUIP_SKILL, skillid);
/*  103 */           String logStr = String.format("[item]EquipmentItem.onCreateItem@equip generate skill|itemid=%d|skillid=%d|weight=%d|p=%d", new Object[] { Integer.valueOf(itemId), Integer.valueOf(skillid), Integer.valueOf(sItemEquipCfg.skillProb), Integer.valueOf(p) });
/*      */           
/*      */ 
/*  106 */           ItemManager.logger.info(logStr);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  112 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int refreshHun()
/*      */   {
/*  123 */     Map<Integer, TempExtraProInfo> xTempExtraProInfos = getTempExtraPropInfos();
/*  124 */     if (!xTempExtraProInfos.isEmpty())
/*      */     {
/*      */ 
/*  127 */       xTempExtraProInfos.clear();
/*      */     }
/*  129 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(getCfgId());
/*      */     
/*  131 */     SProRandomCountCfg proRandomCountCfg = SProRandomCountCfg.get(itemEquipCfg.exattrprobId);
/*  132 */     if (proRandomCountCfg == null)
/*      */     {
/*  134 */       return -2;
/*      */     }
/*  136 */     List<XExtraProBean> xXExtraProBeans = this.xItem.getExtraprolist();
/*  137 */     int hunNum = xXExtraProBeans.size();
/*  138 */     List<PropertyRandomUtil.KeyValuePair> pairs = PropertyRandomUtil.randomPropertyList(itemEquipCfg.exattrprobId, hunNum);
/*  139 */     int size = Math.min(pairs.size(), xXExtraProBeans.size());
/*  140 */     for (int i = 0; i < size; i++)
/*      */     {
/*  142 */       PropertyRandomUtil.KeyValuePair pair = null;
/*  143 */       if (1 == ((XExtraProBean)xXExtraProBeans.get(i)).getIslock())
/*      */       {
/*  145 */         pair = new PropertyRandomUtil.KeyValuePair(((XExtraProBean)xXExtraProBeans.get(i)).getProtype(), ((XExtraProBean)xXExtraProBeans.get(i)).getProvalue());
/*      */       }
/*      */       else
/*      */       {
/*  149 */         pair = (PropertyRandomUtil.KeyValuePair)pairs.get(i);
/*      */       }
/*      */       
/*  152 */       TempExtraProInfo xTempExtraProInfo = Pod.newTempExtraProInfo();
/*  153 */       xTempExtraProInfo.setProtype(pair.getKey());
/*  154 */       xTempExtraProInfo.setProvalue(pair.getValue());
/*      */       
/*  156 */       xTempExtraProInfos.put(Integer.valueOf(i + 1), xTempExtraProInfo);
/*      */     }
/*      */     
/*  159 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int confirmRefreshHun(boolean isReplace)
/*      */   {
/*  171 */     Map<Integer, TempExtraProInfo> xTempExtraProInfos = getTempExtraPropInfos();
/*  172 */     if (xTempExtraProInfos.isEmpty())
/*      */     {
/*  174 */       return -1;
/*      */     }
/*      */     
/*      */ 
/*  178 */     if (!isReplace)
/*      */     {
/*  180 */       xTempExtraProInfos.clear();
/*  181 */       return 0;
/*      */     }
/*      */     
/*  184 */     List<XExtraProBean> xXExtraProBeans = this.xItem.getExtraprolist();
/*  185 */     int hunNum = xXExtraProBeans.size();
/*  186 */     for (Map.Entry<Integer, TempExtraProInfo> entry : xTempExtraProInfos.entrySet())
/*      */     {
/*  188 */       int hunIndex = ((Integer)entry.getKey()).intValue();
/*  189 */       if (hunIndex > hunNum)
/*      */       {
/*  191 */         return -2;
/*      */       }
/*      */       
/*  194 */       XExtraProBean xXExtraProBean = (XExtraProBean)xXExtraProBeans.get(hunIndex - 1);
/*  195 */       if (1 != xXExtraProBean.getIslock())
/*      */       {
/*      */ 
/*      */ 
/*  199 */         TempExtraProInfo xTempExtraProInfo = (TempExtraProInfo)entry.getValue();
/*  200 */         xXExtraProBean.setProtype(xTempExtraProInfo.getProtype());
/*  201 */         xXExtraProBean.setProvalue(xTempExtraProInfo.getProvalue());
/*      */       }
/*      */     }
/*  204 */     xTempExtraProInfos.clear();
/*      */     
/*  206 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int computeNeedSilver()
/*      */   {
/*  218 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(getCfgId());
/*  219 */     SEquipTransferInherit equipTransferInherit = ItemConfigManager.getSEquipTransferHun(itemEquipCfg.useLevel);
/*      */     
/*  221 */     int currentUsePoint = getUsePointValue();
/*      */     
/*  223 */     int maxUsePoint = getUsePointMaxValue();
/*      */     
/*  225 */     int deltaUsePoint = maxUsePoint - currentUsePoint;
/*  226 */     if (deltaUsePoint <= 0)
/*      */     {
/*  228 */       return 0;
/*      */     }
/*      */     
/*  231 */     return deltaUsePoint * equipTransferInherit.fixOnePointNeedSilver;
/*      */   }
/*      */   
/*      */ 
/*      */   boolean fix()
/*      */   {
/*  237 */     int currentUsePoint = getUsePointValue();
/*      */     
/*  239 */     int maxUsePoint = getUsePointMaxValue();
/*  240 */     if (currentUsePoint == maxUsePoint)
/*      */     {
/*  242 */       return false;
/*      */     }
/*      */     
/*  245 */     setExtra(ItemStoreEnum.USE_POINT_VALUE, maxUsePoint);
/*      */     
/*  247 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Map<Integer, TempExtraProInfo> getTempExtraPropInfos()
/*      */   {
/*  257 */     return this.xItem.getTempextrapropinfos();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private int computeHunNum(SItemEquipCfg equipCfg)
/*      */   {
/*  264 */     int totalweight = 0;
/*  265 */     for (int i = 0; i < equipCfg.hunNumberRates.size(); i++)
/*      */     {
/*  267 */       totalweight += ((Integer)equipCfg.hunNumberRates.get(i)).intValue();
/*      */     }
/*  269 */     int random = Xdb.random().nextInt(totalweight);
/*  270 */     int sum = 0;
/*  271 */     int hunnum = 0;
/*  272 */     for (int i = 0; i < equipCfg.hunNumberRates.size(); i++)
/*      */     {
/*  274 */       sum += ((Integer)equipCfg.hunNumberRates.get(i)).intValue();
/*  275 */       if (random < sum)
/*      */       {
/*  277 */         hunnum = i;
/*  278 */         break;
/*      */       }
/*      */     }
/*  281 */     hunnum = Math.min(equipCfg.extraHunMaxNum, hunnum);
/*  282 */     return hunnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addExtraPro(XExtraProBean extraProBean)
/*      */   {
/*  292 */     this.xItem.getExtraprolist().add(extraProBean);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean replaceExtraPro(XExtraProBean extraProBean, int replaceIndex)
/*      */   {
/*  304 */     if (extraProBean == null)
/*      */     {
/*  306 */       return false;
/*      */     }
/*  308 */     if ((this.xItem.getExtraprolist().size() <= replaceIndex) || (replaceIndex < 0))
/*      */     {
/*  310 */       return false;
/*      */     }
/*      */     
/*  313 */     XExtraProBean xExtraProBean = (XExtraProBean)this.xItem.getExtraprolist().get(replaceIndex);
/*      */     
/*  315 */     xExtraProBean.setProtype(extraProBean.getProtype());
/*  316 */     xExtraProBean.setProvalue(extraProBean.getProvalue());
/*  317 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean resetExtraPro(List<XExtraProBean> extraProBeans)
/*      */   {
/*  328 */     if (extraProBeans == null)
/*      */     {
/*  330 */       return false;
/*      */     }
/*  332 */     List<XExtraProBean> xExtraProBeanList = new ArrayList();
/*  333 */     for (XExtraProBean xExtraProBean : this.xItem.getExtraprolist())
/*      */     {
/*  335 */       xExtraProBeanList.add(xExtraProBean);
/*      */     }
/*  337 */     this.xItem.getExtraprolist().clear();
/*      */     
/*  339 */     int minSize = Math.min(extraProBeans.size(), xExtraProBeanList.size());
/*  340 */     for (int i = 0; i < minSize; i++)
/*      */     {
/*  342 */       XExtraProBean xExtraProBean2 = Pod.newXExtraProBean();
/*      */       
/*  344 */       xExtraProBean2.setProtype(((XExtraProBean)extraProBeans.get(i)).getProtype());
/*  345 */       xExtraProBean2.setProvalue(((XExtraProBean)extraProBeans.get(i)).getProvalue());
/*      */       
/*  347 */       this.xItem.getExtraprolist().add(xExtraProBean2);
/*      */     }
/*  349 */     for (int i = minSize; i < xExtraProBeanList.size(); i++)
/*      */     {
/*  351 */       XExtraProBean xExtraProBean2 = Pod.newXExtraProBean();
/*      */       
/*  353 */       xExtraProBean2.setProtype(0);
/*  354 */       xExtraProBean2.setProvalue(0);
/*  355 */       xExtraProBean2.setIslock(0);
/*      */       
/*  357 */       this.xItem.getExtraprolist().add(xExtraProBean2);
/*      */     }
/*      */     
/*  360 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean removeExtraPro(int removeIndex)
/*      */   {
/*  371 */     if ((this.xItem.getExtraprolist().size() <= removeIndex) || (removeIndex < 0))
/*      */     {
/*  373 */       return false;
/*      */     }
/*  375 */     this.xItem.getExtraprolist().remove(removeIndex);
/*  376 */     return true;
/*      */   }
/*      */   
/*      */   void clearExtraPro()
/*      */   {
/*  381 */     this.xItem.getExtraprolist().clear();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setStrengthScore(int strengthScore)
/*      */   {
/*  391 */     setExtra(ItemStoreEnum.STRENGTHEN_SCORE, strengthScore);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setStrengthLevel(int strengthLevel)
/*      */   {
/*  401 */     setExtra(ItemStoreEnum.STRENGTH_LEVEL, strengthLevel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isUsePointNormal()
/*      */   {
/*  411 */     return getUsePointValue() > 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getStoreAttriAValue()
/*      */   {
/*  421 */     if (!isUsePointNormal())
/*      */     {
/*  423 */       return 0;
/*      */     }
/*  425 */     Integer attriA = getExtra(ItemStoreEnum.ATTRI_A);
/*  426 */     if (attriA == null)
/*      */     {
/*  428 */       return 0;
/*      */     }
/*  430 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(getCfgId());
/*  431 */     float ret = (sItemEquipCfg.attrAvaluemax - sItemEquipCfg.attrAvaluemin) * attriA.intValue() * 1.0F / 10000.0F + sItemEquipCfg.attrAvaluemin;
/*      */     
/*      */ 
/*  434 */     return (int)(ret * (1.0F + getAttriExtraAddRate() / 10000.0F));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getStrenghenAttriAValue()
/*      */   {
/*  445 */     if (!isUsePointNormal())
/*      */     {
/*  447 */       return 0;
/*      */     }
/*  449 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(getCfgId());
/*      */     
/*  451 */     SEquipQiLinCfg sEquipQiLin = ItemConfigManager.getSEquipQiLin(sItemEquipCfg.qilinTypeid, getStrengthLevel());
/*  452 */     if (sEquipQiLin == null)
/*      */     {
/*  454 */       return 0;
/*      */     }
/*  456 */     return (int)(sEquipQiLin.strengthAttrA * (1.0F + getStrengthAttriExtraAddRate() / 10000.0F));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getStoreAttriBValue()
/*      */   {
/*  466 */     if (!isUsePointNormal())
/*      */     {
/*  468 */       return 0;
/*      */     }
/*  470 */     Integer attriB = getExtra(ItemStoreEnum.ATTRI_B);
/*  471 */     if (attriB == null)
/*      */     {
/*  473 */       return 0;
/*      */     }
/*      */     
/*  476 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(getCfgId());
/*  477 */     float ret = (sItemEquipCfg.attrBvaluemax - sItemEquipCfg.attrBvaluemin) * attriB.intValue() * 1.0F / 10000.0F + sItemEquipCfg.attrBvaluemin;
/*      */     
/*  479 */     return (int)(ret * (1.0F + getAttriExtraAddRate() / 10000.0F));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getStrenghenAttriBValue()
/*      */   {
/*  489 */     if (!isUsePointNormal())
/*      */     {
/*  491 */       return 0;
/*      */     }
/*  493 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(getCfgId());
/*      */     
/*  495 */     SEquipQiLinCfg sEquipQiLin = ItemConfigManager.getSEquipQiLin(sItemEquipCfg.qilinTypeid, getStrengthLevel());
/*  496 */     if (sEquipQiLin == null)
/*      */     {
/*  498 */       return 0;
/*      */     }
/*  500 */     return (int)(sEquipQiLin.strengthAttrB * (1.0F + getStrengthAttriExtraAddRate() / 10000.0F));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getAttriAValue()
/*      */   {
/*  510 */     return getStoreAttriAValue() + getStrenghenAttriAValue();
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
/*      */   public void setFumoValue(int propertyType, int value, long timeout)
/*      */   {
/*  523 */     for (FumoInfo f : this.xItem.getFumoprolist())
/*      */     {
/*  525 */       if (f.getProtype() == propertyType)
/*      */       {
/*  527 */         f.setAddvalue(value);
/*  528 */         f.setTimeout(timeout);
/*  529 */         return;
/*      */       }
/*      */     }
/*  532 */     FumoInfo fumoInfo = Pod.newFumoInfo();
/*  533 */     fumoInfo.setAddvalue(value);
/*  534 */     fumoInfo.setTimeout(timeout);
/*  535 */     fumoInfo.setProtype(propertyType);
/*  536 */     this.xItem.getFumoprolist().add(fumoInfo);
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
/*      */   long getFumoTimeout(int propertyType)
/*      */   {
/*  549 */     for (FumoInfo f : this.xItem.getFumoprolist())
/*      */     {
/*  551 */       if (f.getProtype() == propertyType)
/*      */       {
/*  553 */         return f.getTimeout();
/*      */       }
/*      */     }
/*      */     
/*  557 */     return Long.MAX_VALUE;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void removeFumoProperty(int propertyType)
/*      */   {
/*  568 */     FumoInfo fu = null;
/*  569 */     for (FumoInfo f : this.xItem.getFumoprolist())
/*      */     {
/*  571 */       if (f.getProtype() == propertyType)
/*      */       {
/*  573 */         fu = f;
/*  574 */         break;
/*      */       }
/*      */     }
/*  577 */     this.xItem.getFumoprolist().remove(fu);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   List<FumoInfo> getFumoInfos()
/*      */   {
/*  588 */     return this.xItem.getFumoprolist();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private List<PropertyRandomUtil.KeyValuePair> getFumoValuePair()
/*      */   {
/*  599 */     long now = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*      */     
/*  601 */     List<PropertyRandomUtil.KeyValuePair> keyValuePairs = new ArrayList();
/*  602 */     if (!isUsePointNormal())
/*      */     {
/*  604 */       return keyValuePairs;
/*      */     }
/*  606 */     for (FumoInfo f : this.xItem.getFumoprolist())
/*      */     {
/*  608 */       if (f.getTimeout() > now)
/*      */       {
/*      */ 
/*      */ 
/*  612 */         keyValuePairs.add(new PropertyRandomUtil.KeyValuePair(f.getProtype(), f.getAddvalue()));
/*      */       }
/*      */     }
/*  615 */     return keyValuePairs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getAttriBValue()
/*      */   {
/*  625 */     return getStoreAttriBValue() + getStrenghenAttriBValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getStrengthLevel()
/*      */   {
/*  635 */     Integer strengthLevel = getExtra(ItemStoreEnum.STRENGTH_LEVEL);
/*  636 */     return strengthLevel == null ? 0 : strengthLevel.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getUsePointValue()
/*      */   {
/*  646 */     Integer usePoiont = getExtra(ItemStoreEnum.USE_POINT_VALUE);
/*  647 */     if (usePoiont == null)
/*      */     {
/*  649 */       return 0;
/*      */     }
/*      */     
/*  652 */     return usePoiont.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int reduceUsePointByRatio(int ratio)
/*      */   {
/*  660 */     int reduceValue = Math.min(getUsePointMaxValue() * ratio / 10000, getUsePointValue());
/*  661 */     setExtra(ItemStoreEnum.USE_POINT_VALUE, getUsePointValue() - reduceValue);
/*  662 */     return reduceValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getUsePointMaxValue()
/*      */   {
/*  672 */     int cfgId = getCfgId();
/*  673 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(cfgId);
/*  674 */     if (sItemEquipCfg == null)
/*      */     {
/*  676 */       String logStr = String.format("[item]EquipmentItem.getUsePointMaxValue@equip itemid error|itemid=%d", new Object[] { Integer.valueOf(getCfgId()) });
/*  677 */       ItemManager.logger.error(logStr);
/*      */       
/*  679 */       return 0;
/*      */     }
/*      */     
/*  682 */     int usePoiont = ItemConfigManager.getSEquipTransferHun(sItemEquipCfg.useLevel).usePoint;
/*  683 */     return usePoiont;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getStrengthScore()
/*      */   {
/*  694 */     Integer strengthScore = getExtra(ItemStoreEnum.STRENGTHEN_SCORE);
/*  695 */     return strengthScore == null ? 0 : strengthScore.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   PropertyRandomUtil.KeyValuePair getEquipmentExtraProBean(XExtraProBean xExtraProBean)
/*      */   {
/*  706 */     SProRandomValueCfg randomValueCfg = SProRandomValueCfg.get(xExtraProBean.getProtype());
/*  707 */     if (randomValueCfg == null)
/*      */     {
/*  709 */       String logStr = String.format("[item]EquipmentItem.getEquipmentExtraProBean@equip hun property error|itemid=%d|propertyid=%d", new Object[] { Integer.valueOf(getCfgId()), Integer.valueOf(xExtraProBean.getProtype()) });
/*      */       
/*      */ 
/*  712 */       ItemManager.logger.info(logStr);
/*      */       
/*  714 */       return null;
/*      */     }
/*  716 */     int proType = randomValueCfg.exaProCfgId;
/*  717 */     int proValue = (int)(xExtraProBean.getProvalue() * 1.0F / 10000.0F * (randomValueCfg.extraProMax - randomValueCfg.extraProMin) + randomValueCfg.extraProMin);
/*      */     
/*  719 */     return new PropertyRandomUtil.KeyValuePair(proType, proValue);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Map<Integer, Integer> getProTypeValueMap()
/*      */   {
/*  729 */     return getProTypeValueMap(true);
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
/*      */   Map<Integer, Integer> getProTypeValueMap(boolean needFuMo)
/*      */   {
/*  742 */     if (!isUsePointNormal())
/*      */     {
/*  744 */       return new HashMap();
/*      */     }
/*  746 */     Map<Integer, Integer> proTypeValueMap = getProperty2Value();
/*      */     Map<Integer, Integer> fumo;
/*  748 */     Iterator i$; if (needFuMo)
/*      */     {
/*  750 */       fumo = getFumoPropertyValue();
/*      */       
/*  752 */       for (i$ = fumo.keySet().iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/*  754 */         if (proTypeValueMap.containsKey(Integer.valueOf(key)))
/*      */         {
/*  756 */           int proValue = ((Integer)proTypeValueMap.get(Integer.valueOf(key))).intValue() + ((Integer)fumo.get(Integer.valueOf(key))).intValue();
/*  757 */           proTypeValueMap.put(Integer.valueOf(key), Integer.valueOf(proValue));
/*      */         }
/*      */         else
/*      */         {
/*  761 */           proTypeValueMap.put(Integer.valueOf(key), fumo.get(Integer.valueOf(key)));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  766 */     return proTypeValueMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Map<Integer, Integer> getFumoPropertyValue()
/*      */   {
/*  776 */     Map<Integer, Integer> proTypeValueMap = new HashMap();
/*      */     
/*  778 */     for (PropertyRandomUtil.KeyValuePair kp : getFumoValuePair())
/*      */     {
/*  780 */       if (proTypeValueMap.containsKey(Integer.valueOf(kp.getKey())))
/*      */       {
/*  782 */         int proValue = ((Integer)proTypeValueMap.get(Integer.valueOf(kp.getKey()))).intValue() + kp.getValue();
/*  783 */         proTypeValueMap.put(Integer.valueOf(kp.getKey()), Integer.valueOf(proValue));
/*      */       }
/*      */       else
/*      */       {
/*  787 */         proTypeValueMap.put(Integer.valueOf(kp.getKey()), Integer.valueOf(kp.getValue()));
/*      */       }
/*      */     }
/*  790 */     return proTypeValueMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getProperty2Value()
/*      */   {
/*  802 */     if (!isUsePointNormal())
/*      */     {
/*  804 */       return new HashMap();
/*      */     }
/*  806 */     Map<Integer, Integer> proTypeValueMap = getHunPropertyValue();
/*  807 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(getCfgId());
/*  808 */     Integer attriAValue = (Integer)proTypeValueMap.get(Integer.valueOf(sItemEquipCfg.attrA));
/*  809 */     if (attriAValue == null)
/*      */     {
/*  811 */       attriAValue = Integer.valueOf(0);
/*      */     }
/*      */     
/*  814 */     proTypeValueMap.put(Integer.valueOf(sItemEquipCfg.attrA), Integer.valueOf(attriAValue.intValue() + getAttriAValue()));
/*  815 */     Integer attriBValue = (Integer)proTypeValueMap.get(Integer.valueOf(sItemEquipCfg.attrB));
/*  816 */     if (attriBValue == null)
/*      */     {
/*  818 */       attriBValue = Integer.valueOf(0);
/*      */     }
/*      */     
/*  821 */     proTypeValueMap.put(Integer.valueOf(sItemEquipCfg.attrB), Integer.valueOf(attriBValue.intValue() + getAttriBValue()));
/*      */     
/*  823 */     return proTypeValueMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Map<Integer, Integer> getHunPropertyValue()
/*      */   {
/*  833 */     Map<Integer, Integer> proTypeValueMap = new HashMap();
/*      */     
/*  835 */     for (XExtraProBean xExtraProBean : getCopyXExtraProBeans())
/*      */     {
/*  837 */       PropertyRandomUtil.KeyValuePair keyValuePair = getEquipmentExtraProBean(xExtraProBean);
/*  838 */       if (keyValuePair != null)
/*      */       {
/*      */ 
/*      */ 
/*  842 */         if (proTypeValueMap.containsKey(Integer.valueOf(keyValuePair.getKey())))
/*      */         {
/*  844 */           int proValue = ((Integer)proTypeValueMap.get(Integer.valueOf(keyValuePair.getKey()))).intValue() + keyValuePair.getValue();
/*  845 */           proTypeValueMap.put(Integer.valueOf(keyValuePair.getKey()), Integer.valueOf(proValue));
/*      */         }
/*      */         else
/*      */         {
/*  849 */           proTypeValueMap.put(Integer.valueOf(keyValuePair.getKey()), Integer.valueOf(keyValuePair.getValue()));
/*      */         } }
/*      */     }
/*  852 */     for (Iterator i$ = proTypeValueMap.keySet().iterator(); i$.hasNext();) { int property = ((Integer)i$.next()).intValue();
/*      */       
/*  854 */       int newValue = (int)(((Integer)proTypeValueMap.get(Integer.valueOf(property))).intValue() * (1.0F + getHunAttriExtraAddRate() / 10000.0F));
/*      */       
/*  856 */       proTypeValueMap.put(Integer.valueOf(property), Integer.valueOf(newValue));
/*      */     }
/*      */     
/*  859 */     return proTypeValueMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   List<XExtraProBean> getCopyXExtraProBeans()
/*      */   {
/*  870 */     List<XExtraProBean> xExtraProBeans = new ArrayList();
/*  871 */     for (XExtraProBean xExtraProBean : this.xItem.getExtraprolist())
/*      */     {
/*  873 */       xExtraProBeans.add(xExtraProBean.copy());
/*      */     }
/*  875 */     return xExtraProBeans;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   XExtraProBean getXExtraProBean(int hunIndex)
/*      */   {
/*  885 */     if ((hunIndex < 0) || (hunIndex >= this.xItem.getExtraprolist().size()))
/*      */     {
/*  887 */       return null;
/*      */     }
/*  889 */     return (XExtraProBean)this.xItem.getExtraprolist().get(hunIndex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getHunNum()
/*      */   {
/*  899 */     if (this.xItem.getExtraprolist() == null)
/*      */     {
/*  901 */       return 0;
/*      */     }
/*  903 */     return this.xItem.getExtraprolist().size();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getLockedHunNum()
/*      */   {
/*  914 */     if (this.xItem.getExtraprolist() == null)
/*      */     {
/*  916 */       return 0;
/*      */     }
/*  918 */     int i = 0;
/*  919 */     for (XExtraProBean x : this.xItem.getExtraprolist())
/*      */     {
/*  921 */       if (x.getIslock() == 1)
/*      */       {
/*  923 */         i++;
/*      */       }
/*      */     }
/*  926 */     return i;
/*      */   }
/*      */   
/*      */   int getUnLockedHunNum()
/*      */   {
/*  931 */     if (this.xItem.getExtraprolist() == null)
/*      */     {
/*  933 */       return 0;
/*      */     }
/*  935 */     int i = 0;
/*  936 */     for (XExtraProBean x : this.xItem.getExtraprolist())
/*      */     {
/*  938 */       if (x.getIslock() == 0)
/*      */       {
/*  940 */         i++;
/*      */       }
/*      */     }
/*  943 */     return i;
/*      */   }
/*      */   
/*      */   List<Integer> getUnLockedHunIndexList()
/*      */   {
/*  948 */     List<Integer> resuList = new ArrayList();
/*  949 */     if (this.xItem.getExtraprolist() == null)
/*      */     {
/*  951 */       return resuList;
/*      */     }
/*      */     
/*  954 */     for (int i = 0; i < this.xItem.getExtraprolist().size(); i++)
/*      */     {
/*  956 */       if (((XExtraProBean)this.xItem.getExtraprolist().get(i)).getIslock() == 0)
/*      */       {
/*  958 */         resuList.add(Integer.valueOf(i));
/*      */       }
/*      */     }
/*  961 */     return resuList;
/*      */   }
/*      */   
/*      */   List<Integer> getLockedHunIndexList()
/*      */   {
/*  966 */     List<Integer> resuList = new ArrayList();
/*  967 */     if (this.xItem.getExtraprolist() == null)
/*      */     {
/*  969 */       return resuList;
/*      */     }
/*      */     
/*  972 */     for (int i = 0; i < this.xItem.getExtraprolist().size(); i++)
/*      */     {
/*  974 */       if (((XExtraProBean)this.xItem.getExtraprolist().get(i)).getIslock() == 1)
/*      */       {
/*  976 */         resuList.add(Integer.valueOf(i));
/*      */       }
/*      */     }
/*  979 */     return resuList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean isLockedHun(int hunIndex)
/*      */   {
/*  990 */     if (this.xItem.getExtraprolist() == null)
/*      */     {
/*  992 */       return false;
/*      */     }
/*  994 */     if ((hunIndex < 0) || (hunIndex >= this.xItem.getExtraprolist().size()))
/*      */     {
/*  996 */       return false;
/*      */     }
/*  998 */     return ((XExtraProBean)this.xItem.getExtraprolist().get(hunIndex)).getIslock() == 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean lockHun(int hunindex)
/*      */   {
/* 1009 */     if (this.xItem.getExtraprolist() == null)
/*      */     {
/* 1011 */       return false;
/*      */     }
/* 1013 */     if ((hunindex < 0) || (hunindex >= this.xItem.getExtraprolist().size()))
/*      */     {
/* 1015 */       return false;
/*      */     }
/* 1017 */     ((XExtraProBean)this.xItem.getExtraprolist().get(hunindex)).setIslock(1);
/* 1018 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean unLockHun(int hunindex)
/*      */   {
/* 1029 */     if (this.xItem.getExtraprolist() == null)
/*      */     {
/* 1031 */       return false;
/*      */     }
/* 1033 */     if ((hunindex < 0) || (hunindex >= this.xItem.getExtraprolist().size()))
/*      */     {
/* 1035 */       return false;
/*      */     }
/* 1037 */     ((XExtraProBean)this.xItem.getExtraprolist().get(hunindex)).setIslock(0);
/* 1038 */     return true;
/*      */   }
/*      */   
/*      */   void unLockAllHun()
/*      */   {
/* 1043 */     for (int i = 0; i < this.xItem.getExtraprolist().size(); i++)
/*      */     {
/* 1045 */       ((XExtraProBean)this.xItem.getExtraprolist().get(i)).setIslock(0);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean canUse(long roleid)
/*      */   {
/* 1057 */     if (!isUsePointNormal())
/*      */     {
/* 1059 */       return false;
/*      */     }
/* 1061 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(getCfgId());
/* 1062 */     if (!ItemManager.useItemLevel(roleid, sItemEquipCfg.useLevel))
/*      */     {
/* 1064 */       return false;
/*      */     }
/* 1066 */     if (!ItemManager.useItemOccupation(mzm.gsp.role.main.RoleInterface.getOccupationId(roleid), sItemEquipCfg.menpai))
/*      */     {
/* 1068 */       return false;
/*      */     }
/* 1070 */     if (!ItemManager.useItemSex(roleid, sItemEquipCfg.sex))
/*      */     {
/* 1072 */       return false;
/*      */     }
/* 1074 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getHunColor(int index)
/*      */   {
/* 1085 */     if ((index < 0) || (this.xItem.getExtraprolist() == null) || (index >= this.xItem.getExtraprolist().size()))
/*      */     {
/* 1087 */       return -1;
/*      */     }
/* 1089 */     XExtraProBean xExtraProBean = (XExtraProBean)this.xItem.getExtraprolist().get(index);
/*      */     
/* 1091 */     int rate = xExtraProBean.getProvalue();
/* 1092 */     for (SEquipHunColorCfg equipHunColorCfg : SEquipHunColorCfg.getAll().values())
/*      */     {
/* 1094 */       if ((equipHunColorCfg.minRate <= rate) && (rate < equipHunColorCfg.maxRate))
/*      */       {
/* 1096 */         return equipHunColorCfg.color;
/*      */       }
/*      */     }
/* 1099 */     return -1;
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
/*      */   public static EquipmentItem createFixEquipItem(int itemid, int hunnum, int proARate, int proBrate, boolean isbind, boolean isgenerateUuid)
/*      */   {
/* 1118 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(itemid);
/* 1119 */     if (sItemEquipCfg == null)
/*      */     {
/* 1121 */       return null;
/*      */     }
/* 1123 */     Item xiItem = Pod.newItem();
/* 1124 */     xiItem.setCfgid(itemid);
/* 1125 */     xiItem.setNumber(1);
/* 1126 */     if (isgenerateUuid)
/*      */     {
/* 1128 */       xiItem.getUuid().addAll(UuidUtils.generateUuids(UuidUtils.UuidType.Item, 1));
/*      */     }
/*      */     
/* 1131 */     EquipmentItem equipmentItem = new EquipmentItem(xiItem);
/* 1132 */     if (isbind)
/*      */     {
/* 1134 */       equipmentItem.setState(1);
/*      */     }
/*      */     
/* 1137 */     SProRandomCountCfg sProRandomCountCfg = SProRandomCountCfg.get(sItemEquipCfg.exattrprobId);
/* 1138 */     if (sProRandomCountCfg != null)
/*      */     {
/*      */ 
/* 1141 */       List<PropertyRandomUtil.KeyValuePair> listKeyValuePairs = PropertyRandomUtil.randomFixPropertyList(sItemEquipCfg.exattrprobId, hunnum);
/* 1142 */       for (PropertyRandomUtil.KeyValuePair keyValuePair : listKeyValuePairs)
/*      */       {
/* 1144 */         XExtraProBean extraProBean = Pod.newXExtraProBean();
/* 1145 */         extraProBean.setProtype(keyValuePair.getKey());
/* 1146 */         extraProBean.setProvalue(keyValuePair.getValue());
/* 1147 */         equipmentItem.addExtraPro(extraProBean);
/*      */       }
/*      */     }
/*      */     
/* 1151 */     int usePoiont = ItemConfigManager.getSEquipTransferHun(sItemEquipCfg.useLevel).usePoint;
/* 1152 */     equipmentItem.setExtra(ItemStoreEnum.USE_POINT_VALUE, usePoiont);
/*      */     
/* 1154 */     equipmentItem.setExtra(ItemStoreEnum.ATTRI_A, proARate);
/*      */     
/* 1156 */     equipmentItem.setExtra(ItemStoreEnum.ATTRI_B, proBrate);
/*      */     
/*      */ 
/* 1159 */     equipmentItem.setExtra(ItemStoreEnum.STRENGTH_LEVEL, 0);
/*      */     
/*      */ 
/*      */ 
/* 1163 */     return equipmentItem;
/*      */   }
/*      */   
/*      */   public PassiveSkill getSkill()
/*      */   {
/* 1168 */     Integer skillid = getExtra(ItemStoreEnum.EQUIP_SKILL);
/* 1169 */     if (skillid == null)
/*      */     {
/* 1171 */       return null;
/*      */     }
/* 1173 */     SItemEquipCfg equipCfg = SItemEquipCfg.get(getCfgId());
/* 1174 */     int skillLevel = equipCfg.useLevel;
/* 1175 */     SPassiveSkillCfg skillCfg = SPassiveSkillCfg.get(skillid.intValue());
/* 1176 */     if (skillCfg == null)
/*      */     {
/* 1178 */       return null;
/*      */     }
/* 1180 */     PassiveSkill skill = new PassiveSkill(skillCfg, skillLevel);
/* 1181 */     return skill;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Map<Integer, Integer> getSkillId2LevelMap()
/*      */   {
/* 1191 */     Map<Integer, Integer> skillId2LevelMap = new HashMap();
/* 1192 */     PassiveSkill passiveSkill = getSkill();
/* 1193 */     if (passiveSkill != null)
/*      */     {
/* 1195 */       skillId2LevelMap.put(Integer.valueOf(passiveSkill.getPassiveSkillCfgId()), Integer.valueOf(passiveSkill.getLevel()));
/*      */     }
/* 1197 */     return skillId2LevelMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isUsePointNeverDec()
/*      */   {
/* 1208 */     return SkillInterface.getEquipmentDurableSkills(getSkillId2LevelMap());
/*      */   }
/*      */   
/*      */   public Map<Integer, Integer> getPropertyMap()
/*      */   {
/* 1213 */     return SkillInterface.getEquipAddRateWithSkills(getSkillId2LevelMap());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getEquipWearModifyLevel()
/*      */   {
/* 1223 */     return SkillInterface.getEquipLevelChangeWithSkills(getSkillId2LevelMap());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getAttriExtraAddRate()
/*      */   {
/* 1233 */     Map<Integer, Integer> proMap = SkillInterface.getEquipAddRateWithSkills(getSkillId2LevelMap());
/* 1234 */     if ((proMap == null) || (proMap.get(Integer.valueOf(1)) == null))
/*      */     {
/* 1236 */       return 0;
/*      */     }
/*      */     
/*      */ 
/* 1240 */     return ((Integer)proMap.get(Integer.valueOf(1))).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getStrengthAttriExtraAddRate()
/*      */   {
/* 1252 */     Map<Integer, Integer> proMap = SkillInterface.getEquipAddRateWithSkills(getSkillId2LevelMap());
/* 1253 */     if ((proMap == null) || (proMap.get(Integer.valueOf(2)) == null))
/*      */     {
/* 1255 */       return 0;
/*      */     }
/*      */     
/*      */ 
/* 1259 */     return ((Integer)proMap.get(Integer.valueOf(2))).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getHunAttriExtraAddRate()
/*      */   {
/* 1271 */     Map<Integer, Integer> proMap = SkillInterface.getEquipAddRateWithSkills(getSkillId2LevelMap());
/* 1272 */     if ((proMap == null) || (proMap.get(Integer.valueOf(4)) == null))
/*      */     {
/* 1274 */       return 0;
/*      */     }
/*      */     
/*      */ 
/* 1278 */     return ((Integer)proMap.get(Integer.valueOf(4))).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   void clearQilinAccumulationPoint()
/*      */   {
/* 1285 */     this.xItem.getExtra().remove(Integer.valueOf(ItemStoreEnum.QILINZHU_USE_COUNT.getStoreType()));
/* 1286 */     this.xItem.getExtra().remove(Integer.valueOf(ItemStoreEnum.ZHENGLINSHI_USE_COUNT.getStoreType()));
/* 1287 */     this.xItem.getExtra().remove(Integer.valueOf(ItemStoreEnum.XINGYUNSHI_USE_COUNT.getStoreType()));
/* 1288 */     this.xItem.getExtra().remove(Integer.valueOf(ItemStoreEnum.ACCUMULATION_QILIN_SCORE.getStoreType()));
/*      */   }
/*      */   
/*      */   void setCanNotUseQiLinInitPoint()
/*      */   {
/* 1293 */     this.xItem.getExtra().put(Integer.valueOf(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE.getStoreType()), Integer.valueOf(1));
/*      */   }
/*      */   
/*      */   void clearCanNotUseQiLinInitPoint()
/*      */   {
/* 1298 */     this.xItem.getExtra().remove(Integer.valueOf(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE.getStoreType()));
/*      */   }
/*      */   
/*      */   public String getAccumulationQiLinExtraString()
/*      */   {
/* 1303 */     StringBuffer sb = new StringBuffer();
/* 1304 */     sb.append(ItemStoreEnum.QILINZHU_USE_COUNT.getStoreType()).append("=");
/* 1305 */     Integer qiLinzhu = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.QILINZHU_USE_COUNT.getStoreType()));
/* 1306 */     if (qiLinzhu == null)
/*      */     {
/* 1308 */       qiLinzhu = Integer.valueOf(0);
/*      */     }
/* 1310 */     sb.append(qiLinzhu.intValue()).append("#");
/*      */     
/* 1312 */     sb.append(ItemStoreEnum.ZHENGLINSHI_USE_COUNT.getStoreType()).append("=");
/* 1313 */     Integer zhengLinShi = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.ZHENGLINSHI_USE_COUNT.getStoreType()));
/* 1314 */     if (zhengLinShi == null)
/*      */     {
/* 1316 */       zhengLinShi = Integer.valueOf(0);
/*      */     }
/* 1318 */     sb.append(zhengLinShi.intValue()).append("#");
/*      */     
/* 1320 */     sb.append(ItemStoreEnum.XINGYUNSHI_USE_COUNT.getStoreType()).append("=");
/* 1321 */     Integer xingYunShi = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.XINGYUNSHI_USE_COUNT.getStoreType()));
/* 1322 */     if (xingYunShi == null)
/*      */     {
/* 1324 */       xingYunShi = Integer.valueOf(0);
/*      */     }
/* 1326 */     sb.append(xingYunShi.intValue()).append("#");
/*      */     
/* 1328 */     sb.append(ItemStoreEnum.ACCUMULATION_QILIN_SCORE.getStoreType()).append("=");
/* 1329 */     Integer accumulationScore = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.ACCUMULATION_QILIN_SCORE.getStoreType()));
/* 1330 */     if (accumulationScore == null)
/*      */     {
/* 1332 */       accumulationScore = Integer.valueOf(0);
/*      */     }
/* 1334 */     sb.append(accumulationScore.intValue()).append("#");
/*      */     
/* 1336 */     sb.append(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE.getStoreType()).append("=");
/* 1337 */     Integer can_add_init_qilin_scoure = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE.getStoreType()));
/* 1338 */     if (can_add_init_qilin_scoure == null)
/*      */     {
/* 1340 */       can_add_init_qilin_scoure = Integer.valueOf(0);
/*      */     }
/* 1342 */     sb.append(can_add_init_qilin_scoure.intValue());
/*      */     
/* 1344 */     return sb.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean canSell(long roleid)
/*      */   {
/* 1351 */     if (getSuperEquipmentStage() > 0) {
/* 1352 */       return false;
/*      */     }
/* 1354 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSuperEquipmentStage()
/*      */   {
/* 1360 */     Integer stage = getExtra(ItemStoreEnum.SUPER_EQUIPMENT_STAGE);
/* 1361 */     return stage == null ? 0 : stage.intValue();
/*      */   }
/*      */   
/*      */   public void setSuperEquipmentStage(int stage)
/*      */   {
/* 1366 */     setExtra(ItemStoreEnum.SUPER_EQUIPMENT_STAGE, stage);
/*      */   }
/*      */   
/*      */   public int getSuperEquipmentLevel()
/*      */   {
/* 1371 */     Integer level = getExtra(ItemStoreEnum.SUPER_EQUIPMENT_LEVEL);
/* 1372 */     return level == null ? 0 : level.intValue();
/*      */   }
/*      */   
/*      */   public void setSuperEquipmentLevel(int level)
/*      */   {
/* 1377 */     setExtra(ItemStoreEnum.SUPER_EQUIPMENT_LEVEL, level);
/*      */   }
/*      */   
/*      */   public Map<Integer, Integer> getSuperEquipmentImproveStageCostMap()
/*      */   {
/* 1382 */     return this.xItem.getSuperequipmentcostbean().getStage_cost_map();
/*      */   }
/*      */   
/*      */   public Map<Integer, Integer> getSuperEquipmentImproveLevelCostMap()
/*      */   {
/* 1387 */     return this.xItem.getSuperequipmentcostbean().getLevel_cost_map();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public float getRawValueOfAttrA()
/*      */   {
/* 1396 */     if (!isUsePointNormal())
/*      */     {
/* 1398 */       return 0.0F;
/*      */     }
/* 1400 */     Integer attrA = getExtra(ItemStoreEnum.ATTRI_A);
/* 1401 */     if (attrA == null)
/*      */     {
/* 1403 */       return 0.0F;
/*      */     }
/* 1405 */     SItemEquipCfg cfg = SItemEquipCfg.get(getCfgId());
/* 1406 */     if (cfg == null)
/*      */     {
/* 1408 */       return 0.0F;
/*      */     }
/* 1410 */     float rawValue = (cfg.attrAvaluemax - cfg.attrAvaluemin) * attrA.intValue() * 1.0F / 10000.0F + cfg.attrAvaluemin;
/*      */     
/* 1412 */     return rawValue * (1.0F + getAttriExtraAddRate() / 10000.0F);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public float getRawValueOfAttrB()
/*      */   {
/* 1420 */     if (!isUsePointNormal())
/*      */     {
/* 1422 */       return 0.0F;
/*      */     }
/* 1424 */     Integer attrB = getExtra(ItemStoreEnum.ATTRI_B);
/* 1425 */     if (attrB == null)
/*      */     {
/* 1427 */       return 0.0F;
/*      */     }
/* 1429 */     SItemEquipCfg cfg = SItemEquipCfg.get(getCfgId());
/* 1430 */     if (cfg == null)
/*      */     {
/* 1432 */       return 0.0F;
/*      */     }
/* 1434 */     float rawValue = (cfg.attrBvaluemax - cfg.attrBvaluemin) * attrB.intValue() * 1.0F / 10000.0F + cfg.attrBvaluemin;
/*      */     
/* 1436 */     return rawValue * (1.0F + getAttriExtraAddRate() / 10000.0F);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getBlessLevel()
/*      */   {
/* 1444 */     Integer level = getExtra(ItemStoreEnum.EQUIPMENT_BLESS_LEVEL);
/* 1445 */     return level != null ? level.intValue() : 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBlessLevel(int level)
/*      */   {
/* 1453 */     setExtra(ItemStoreEnum.EQUIPMENT_BLESS_LEVEL, level);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getBlessExp()
/*      */   {
/* 1461 */     Integer exp = getExtra(ItemStoreEnum.EQUIPMENT_BLESS_EXP);
/* 1462 */     return exp != null ? exp.intValue() : 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBlessExp(int exp)
/*      */   {
/* 1470 */     setExtra(ItemStoreEnum.EQUIPMENT_BLESS_EXP, exp);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\EquipmentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */