/*     */ package mzm.gsp.changemodelcard.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SCardLevelBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int cardCfgId;
/*     */   public int level;
/*     */   public int useCostEssence;
/*     */   public int effectPersistMinute;
/*     */   public int effectPersistPVPFight;
/*     */   public int useCount;
/*     */   public int upgradeExp;
/*     */   public int provideExp;
/*     */   public int sellScore;
/*     */   public int unlockItemId;
/*  19 */   public HashMap<Integer, Integer> propMap = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.cardCfgId = Integer.valueOf(rootElement.attributeValue("cardCfgId")).intValue();
/*  24 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  25 */     this.useCostEssence = Integer.valueOf(rootElement.attributeValue("useCostEssence")).intValue();
/*  26 */     this.effectPersistMinute = Integer.valueOf(rootElement.attributeValue("effectPersistMinute")).intValue();
/*  27 */     this.effectPersistPVPFight = Integer.valueOf(rootElement.attributeValue("effectPersistPVPFight")).intValue();
/*  28 */     this.useCount = Integer.valueOf(rootElement.attributeValue("useCount")).intValue();
/*  29 */     this.upgradeExp = Integer.valueOf(rootElement.attributeValue("upgradeExp")).intValue();
/*  30 */     this.provideExp = Integer.valueOf(rootElement.attributeValue("provideExp")).intValue();
/*  31 */     this.sellScore = Integer.valueOf(rootElement.attributeValue("sellScore")).intValue();
/*  32 */     this.unlockItemId = Integer.valueOf(rootElement.attributeValue("unlockItemId")).intValue();
/*     */     
/*  34 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "propMap");
/*  35 */     if (mapTypeElement == null)
/*     */     {
/*  37 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  40 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/*  41 */     int entryLen = entryNodeList.size();
/*  42 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  44 */       Element entryElement = (Element)entryNodeList.get(i);
/*  45 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  50 */         Element keyElem = null;
/*  51 */         Element valueElem = null;
/*     */         
/*  53 */         java.util.List<?> _nodeList = entryElement.elements();
/*  54 */         int _len = _nodeList.size();
/*  55 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  57 */           Element elem = (Element)_nodeList.get(j);
/*  58 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  60 */             keyElem = elem;
/*     */           }
/*  62 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  64 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  68 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  70 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  77 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  78 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  85 */         this.propMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  92 */     _os_.marshal(this.cardCfgId);
/*  93 */     _os_.marshal(this.level);
/*  94 */     _os_.marshal(this.useCostEssence);
/*  95 */     _os_.marshal(this.effectPersistMinute);
/*  96 */     _os_.marshal(this.effectPersistPVPFight);
/*  97 */     _os_.marshal(this.useCount);
/*  98 */     _os_.marshal(this.upgradeExp);
/*  99 */     _os_.marshal(this.provideExp);
/* 100 */     _os_.marshal(this.sellScore);
/* 101 */     _os_.marshal(this.unlockItemId);
/* 102 */     _os_.compact_uint32(this.propMap.size());
/* 103 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.propMap.entrySet())
/*     */     {
/* 105 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 106 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 113 */     this.cardCfgId = _os_.unmarshal_int();
/* 114 */     this.level = _os_.unmarshal_int();
/* 115 */     this.useCostEssence = _os_.unmarshal_int();
/* 116 */     this.effectPersistMinute = _os_.unmarshal_int();
/* 117 */     this.effectPersistPVPFight = _os_.unmarshal_int();
/* 118 */     this.useCount = _os_.unmarshal_int();
/* 119 */     this.upgradeExp = _os_.unmarshal_int();
/* 120 */     this.provideExp = _os_.unmarshal_int();
/* 121 */     this.sellScore = _os_.unmarshal_int();
/* 122 */     this.unlockItemId = _os_.unmarshal_int();
/* 123 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 126 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 128 */       int _v_ = _os_.unmarshal_int();
/* 129 */       this.propMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 131 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\confbean\SCardLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */