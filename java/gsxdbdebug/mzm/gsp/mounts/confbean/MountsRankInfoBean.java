/*     */ package mzm.gsp.mounts.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class MountsRankInfoBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int rankUpCostMountsNum;
/*  10 */   public HashMap<Integer, Integer> propertyMap = new HashMap();
/*     */   public int activeSkillCfgId;
/*     */   public int activeSkillLevel;
/*     */   public int needRoleLevel;
/*     */   public int rankUpCostItemId;
/*     */   public int rankUpcostItemType;
/*     */   public int rankUpCostItemIdNum;
/*     */   public int rankUpNeedScoreNum;
/*     */   public int rankUpConvertScore;
/*     */   public int unlockItemId;
/*     */   public int unlockItemIdNum;
/*     */   public int speed;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.rankUpCostMountsNum = Integer.valueOf(rootElement.attributeValue("rankUpCostMountsNum")).intValue();
/*     */     
/*  27 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "propertyMap");
/*  28 */     if (mapTypeElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  33 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/*  34 */     int entryLen = entryNodeList.size();
/*  35 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  37 */       Element entryElement = (Element)entryNodeList.get(i);
/*  38 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  43 */         Element keyElem = null;
/*  44 */         Element valueElem = null;
/*     */         
/*  46 */         java.util.List<?> _nodeList = entryElement.elements();
/*  47 */         int _len = _nodeList.size();
/*  48 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  50 */           Element elem = (Element)_nodeList.get(j);
/*  51 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  53 */             keyElem = elem;
/*     */           }
/*  55 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  57 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  61 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  63 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  70 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  71 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  78 */         this.propertyMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  81 */     this.activeSkillCfgId = Integer.valueOf(rootElement.attributeValue("activeSkillCfgId")).intValue();
/*  82 */     this.activeSkillLevel = Integer.valueOf(rootElement.attributeValue("activeSkillLevel")).intValue();
/*  83 */     this.needRoleLevel = Integer.valueOf(rootElement.attributeValue("needRoleLevel")).intValue();
/*  84 */     this.rankUpCostItemId = Integer.valueOf(rootElement.attributeValue("rankUpCostItemId")).intValue();
/*  85 */     this.rankUpcostItemType = Integer.valueOf(rootElement.attributeValue("rankUpcostItemType")).intValue();
/*  86 */     this.rankUpCostItemIdNum = Integer.valueOf(rootElement.attributeValue("rankUpCostItemIdNum")).intValue();
/*  87 */     this.rankUpNeedScoreNum = Integer.valueOf(rootElement.attributeValue("rankUpNeedScoreNum")).intValue();
/*  88 */     this.rankUpConvertScore = Integer.valueOf(rootElement.attributeValue("rankUpConvertScore")).intValue();
/*  89 */     this.unlockItemId = Integer.valueOf(rootElement.attributeValue("unlockItemId")).intValue();
/*  90 */     this.unlockItemIdNum = Integer.valueOf(rootElement.attributeValue("unlockItemIdNum")).intValue();
/*  91 */     this.speed = Integer.valueOf(rootElement.attributeValue("speed")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  96 */     _os_.marshal(this.rankUpCostMountsNum);
/*  97 */     _os_.compact_uint32(this.propertyMap.size());
/*  98 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.propertyMap.entrySet())
/*     */     {
/* 100 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 101 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 103 */     _os_.marshal(this.activeSkillCfgId);
/* 104 */     _os_.marshal(this.activeSkillLevel);
/* 105 */     _os_.marshal(this.needRoleLevel);
/* 106 */     _os_.marshal(this.rankUpCostItemId);
/* 107 */     _os_.marshal(this.rankUpcostItemType);
/* 108 */     _os_.marshal(this.rankUpCostItemIdNum);
/* 109 */     _os_.marshal(this.rankUpNeedScoreNum);
/* 110 */     _os_.marshal(this.rankUpConvertScore);
/* 111 */     _os_.marshal(this.unlockItemId);
/* 112 */     _os_.marshal(this.unlockItemIdNum);
/* 113 */     _os_.marshal(this.speed);
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 119 */     this.rankUpCostMountsNum = _os_.unmarshal_int();
/* 120 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 123 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 125 */       int _v_ = _os_.unmarshal_int();
/* 126 */       this.propertyMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 128 */     this.activeSkillCfgId = _os_.unmarshal_int();
/* 129 */     this.activeSkillLevel = _os_.unmarshal_int();
/* 130 */     this.needRoleLevel = _os_.unmarshal_int();
/* 131 */     this.rankUpCostItemId = _os_.unmarshal_int();
/* 132 */     this.rankUpcostItemType = _os_.unmarshal_int();
/* 133 */     this.rankUpCostItemIdNum = _os_.unmarshal_int();
/* 134 */     this.rankUpNeedScoreNum = _os_.unmarshal_int();
/* 135 */     this.rankUpConvertScore = _os_.unmarshal_int();
/* 136 */     this.unlockItemId = _os_.unmarshal_int();
/* 137 */     this.unlockItemIdNum = _os_.unmarshal_int();
/* 138 */     this.speed = _os_.unmarshal_int();
/* 139 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\confbean\MountsRankInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */