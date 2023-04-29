/*     */ package mzm.gsp.superequipment.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SuperEquipmentLevelBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*   9 */   public ArrayList<SuperEquipmentPropertyImproveBean> improveBeans = new ArrayList();
/*     */   public int requiredStrengthLevel;
/*     */   public int requiredStage;
/*     */   public int requiredCurrencyType;
/*     */   public int requiredCurrencyNum;
/*  14 */   public ArrayList<SuperEquipmentLevelRequiredItem> requiredItems = new ArrayList();
/*     */   
/*     */ 
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  19 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "improveBeans");
/*  20 */     if (collectionElement == null)
/*     */     {
/*  22 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  25 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  26 */     int _len = _nodeList.size();
/*  27 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  29 */       Element elem = (Element)_nodeList.get(i);
/*  30 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.confbean.SuperEquipmentPropertyImproveBean"))
/*     */       {
/*     */         SuperEquipmentPropertyImproveBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  37 */           _v_ = new SuperEquipmentPropertyImproveBean();
/*  38 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  45 */         this.improveBeans.add(_v_);
/*     */       }
/*     */     }
/*  48 */     this.requiredStrengthLevel = Integer.valueOf(rootElement.attributeValue("requiredStrengthLevel")).intValue();
/*  49 */     this.requiredStage = Integer.valueOf(rootElement.attributeValue("requiredStage")).intValue();
/*  50 */     this.requiredCurrencyType = Integer.valueOf(rootElement.attributeValue("requiredCurrencyType")).intValue();
/*  51 */     this.requiredCurrencyNum = Integer.valueOf(rootElement.attributeValue("requiredCurrencyNum")).intValue();
/*     */     
/*  53 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "requiredItems");
/*  54 */     if (collectionElement == null)
/*     */     {
/*  56 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  59 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  60 */     int _len = _nodeList.size();
/*  61 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  63 */       Element elem = (Element)_nodeList.get(i);
/*  64 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.confbean.SuperEquipmentLevelRequiredItem"))
/*     */       {
/*     */         SuperEquipmentLevelRequiredItem _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  71 */           _v_ = new SuperEquipmentLevelRequiredItem();
/*  72 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  79 */         this.requiredItems.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  86 */     _os_.compact_uint32(this.improveBeans.size());
/*  87 */     for (SuperEquipmentPropertyImproveBean _v_ : this.improveBeans)
/*     */     {
/*  89 */       _os_.marshal(_v_);
/*     */     }
/*  91 */     _os_.marshal(this.requiredStrengthLevel);
/*  92 */     _os_.marshal(this.requiredStage);
/*  93 */     _os_.marshal(this.requiredCurrencyType);
/*  94 */     _os_.marshal(this.requiredCurrencyNum);
/*  95 */     _os_.compact_uint32(this.requiredItems.size());
/*  96 */     for (SuperEquipmentLevelRequiredItem _v_ : this.requiredItems)
/*     */     {
/*  98 */       _os_.marshal(_v_);
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 105 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 108 */       SuperEquipmentPropertyImproveBean _v_ = new SuperEquipmentPropertyImproveBean();
/* 109 */       _v_.unmarshal(_os_);
/* 110 */       this.improveBeans.add(_v_);
/*     */     }
/* 112 */     this.requiredStrengthLevel = _os_.unmarshal_int();
/* 113 */     this.requiredStage = _os_.unmarshal_int();
/* 114 */     this.requiredCurrencyType = _os_.unmarshal_int();
/* 115 */     this.requiredCurrencyNum = _os_.unmarshal_int();
/* 116 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 119 */       SuperEquipmentLevelRequiredItem _v_ = new SuperEquipmentLevelRequiredItem();
/* 120 */       _v_.unmarshal(_os_);
/* 121 */       this.requiredItems.add(_v_);
/*     */     }
/* 123 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\confbean\SuperEquipmentLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */