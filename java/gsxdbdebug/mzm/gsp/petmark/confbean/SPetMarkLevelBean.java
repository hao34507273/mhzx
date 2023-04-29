/*     */ package mzm.gsp.petmark.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SPetMarkLevelBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int markCfgId;
/*     */   public int level;
/*     */   public int upgradeExp;
/*     */   public int provideExp;
/*     */   public int smeltScoreType;
/*     */   public int smeltScore;
/*     */   public int unlockItemId;
/*     */   public int passiveSkillId;
/*  17 */   public HashMap<Integer, Integer> propMap = new HashMap();
/*     */   public int addYaoli;
/*     */   public int needRoleLevel;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.markCfgId = Integer.valueOf(rootElement.attributeValue("markCfgId")).intValue();
/*  24 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  25 */     this.upgradeExp = Integer.valueOf(rootElement.attributeValue("upgradeExp")).intValue();
/*  26 */     this.provideExp = Integer.valueOf(rootElement.attributeValue("provideExp")).intValue();
/*  27 */     this.smeltScoreType = Integer.valueOf(rootElement.attributeValue("smeltScoreType")).intValue();
/*  28 */     this.smeltScore = Integer.valueOf(rootElement.attributeValue("smeltScore")).intValue();
/*  29 */     this.unlockItemId = Integer.valueOf(rootElement.attributeValue("unlockItemId")).intValue();
/*  30 */     this.passiveSkillId = Integer.valueOf(rootElement.attributeValue("passiveSkillId")).intValue();
/*     */     
/*  32 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "propMap");
/*  33 */     if (mapTypeElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  38 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/*  39 */     int entryLen = entryNodeList.size();
/*  40 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  42 */       Element entryElement = (Element)entryNodeList.get(i);
/*  43 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  48 */         Element keyElem = null;
/*  49 */         Element valueElem = null;
/*     */         
/*  51 */         java.util.List<?> _nodeList = entryElement.elements();
/*  52 */         int _len = _nodeList.size();
/*  53 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  55 */           Element elem = (Element)_nodeList.get(j);
/*  56 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  58 */             keyElem = elem;
/*     */           }
/*  60 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  62 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  66 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  68 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  75 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  76 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.propMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  86 */     this.addYaoli = Integer.valueOf(rootElement.attributeValue("addYaoli")).intValue();
/*  87 */     this.needRoleLevel = Integer.valueOf(rootElement.attributeValue("needRoleLevel")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  92 */     _os_.marshal(this.markCfgId);
/*  93 */     _os_.marshal(this.level);
/*  94 */     _os_.marshal(this.upgradeExp);
/*  95 */     _os_.marshal(this.provideExp);
/*  96 */     _os_.marshal(this.smeltScoreType);
/*  97 */     _os_.marshal(this.smeltScore);
/*  98 */     _os_.marshal(this.unlockItemId);
/*  99 */     _os_.marshal(this.passiveSkillId);
/* 100 */     _os_.compact_uint32(this.propMap.size());
/* 101 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.propMap.entrySet())
/*     */     {
/* 103 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 104 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 106 */     _os_.marshal(this.addYaoli);
/* 107 */     _os_.marshal(this.needRoleLevel);
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 113 */     this.markCfgId = _os_.unmarshal_int();
/* 114 */     this.level = _os_.unmarshal_int();
/* 115 */     this.upgradeExp = _os_.unmarshal_int();
/* 116 */     this.provideExp = _os_.unmarshal_int();
/* 117 */     this.smeltScoreType = _os_.unmarshal_int();
/* 118 */     this.smeltScore = _os_.unmarshal_int();
/* 119 */     this.unlockItemId = _os_.unmarshal_int();
/* 120 */     this.passiveSkillId = _os_.unmarshal_int();
/* 121 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 124 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 126 */       int _v_ = _os_.unmarshal_int();
/* 127 */       this.propMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 129 */     this.addYaoli = _os_.unmarshal_int();
/* 130 */     this.needRoleLevel = _os_.unmarshal_int();
/* 131 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\confbean\SPetMarkLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */