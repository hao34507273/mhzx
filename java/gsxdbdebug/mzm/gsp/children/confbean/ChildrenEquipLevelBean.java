/*     */ package mzm.gsp.children.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.List;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class ChildrenEquipLevelBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int needStage;
/*     */   public int levelUpExp;
/*  11 */   public java.util.HashMap<Integer, Integer> proMap = new java.util.HashMap();
/*  12 */   public java.util.ArrayList<Integer> itemids = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  16 */     this.needStage = Integer.valueOf(rootElement.attributeValue("needStage")).intValue();
/*  17 */     this.levelUpExp = Integer.valueOf(rootElement.attributeValue("levelUpExp")).intValue();
/*     */     
/*  19 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "proMap");
/*  20 */     if (mapTypeElement == null)
/*     */     {
/*  22 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  25 */     List<?> entryNodeList = mapTypeElement.elements();
/*  26 */     int entryLen = entryNodeList.size();
/*  27 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  29 */       Element entryElement = (Element)entryNodeList.get(i);
/*  30 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  35 */         Element keyElem = null;
/*  36 */         Element valueElem = null;
/*     */         
/*  38 */         List<?> _nodeList = entryElement.elements();
/*  39 */         int _len = _nodeList.size();
/*  40 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  42 */           Element elem = (Element)_nodeList.get(j);
/*  43 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  45 */             keyElem = elem;
/*     */           }
/*  47 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  49 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  53 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  55 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  62 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  63 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  70 */         this.proMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  74 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemids");
/*  75 */     if (collectionElement == null)
/*     */     {
/*  77 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  80 */     List<?> _nodeList = collectionElement.elements();
/*  81 */     int _len = _nodeList.size();
/*  82 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  84 */       Element elem = (Element)_nodeList.get(i);
/*  85 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  92 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  99 */         this.itemids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 106 */     _os_.marshal(this.needStage);
/* 107 */     _os_.marshal(this.levelUpExp);
/* 108 */     _os_.compact_uint32(this.proMap.size());
/* 109 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.proMap.entrySet())
/*     */     {
/* 111 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 112 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 114 */     _os_.compact_uint32(this.itemids.size());
/* 115 */     for (Integer _v_ : this.itemids)
/*     */     {
/* 117 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 124 */     this.needStage = _os_.unmarshal_int();
/* 125 */     this.levelUpExp = _os_.unmarshal_int();
/* 126 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 129 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 131 */       int _v_ = _os_.unmarshal_int();
/* 132 */       this.proMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 134 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 137 */       int _v_ = _os_.unmarshal_int();
/* 138 */       this.itemids.add(Integer.valueOf(_v_));
/*     */     }
/* 140 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\ChildrenEquipLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */