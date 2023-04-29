/*     */ package mzm.gsp.mounts.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.List;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class MountsPassiveSkillBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*   9 */   public java.util.TreeMap<Integer, Integer> randomPassiveSkillRandomMap = new java.util.TreeMap();
/*  10 */   public java.util.HashMap<Integer, Integer> randomPassiveSkillProbMap = new java.util.HashMap();
/*     */   
/*     */   public int refreshCostItemType;
/*     */   public int refreshCostItemId;
/*     */   public int refreshCostItemNum;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  18 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "randomPassiveSkillRandomMap");
/*  19 */     if (mapTypeElement == null)
/*     */     {
/*  21 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  24 */     List<?> entryNodeList = mapTypeElement.elements();
/*  25 */     int entryLen = entryNodeList.size();
/*  26 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  28 */       Element entryElement = (Element)entryNodeList.get(i);
/*  29 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  34 */         Element keyElem = null;
/*  35 */         Element valueElem = null;
/*     */         
/*  37 */         List<?> _nodeList = entryElement.elements();
/*  38 */         int _len = _nodeList.size();
/*  39 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  41 */           Element elem = (Element)_nodeList.get(j);
/*  42 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  44 */             keyElem = elem;
/*     */           }
/*  46 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  48 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  52 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  54 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  61 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  62 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  69 */         this.randomPassiveSkillRandomMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  73 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "randomPassiveSkillProbMap");
/*  74 */     if (mapTypeElement == null)
/*     */     {
/*  76 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  79 */     List<?> entryNodeList = mapTypeElement.elements();
/*  80 */     int entryLen = entryNodeList.size();
/*  81 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  83 */       Element entryElement = (Element)entryNodeList.get(i);
/*  84 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  89 */         Element keyElem = null;
/*  90 */         Element valueElem = null;
/*     */         
/*  92 */         List<?> _nodeList = entryElement.elements();
/*  93 */         int _len = _nodeList.size();
/*  94 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  96 */           Element elem = (Element)_nodeList.get(j);
/*  97 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  99 */             keyElem = elem;
/*     */           }
/* 101 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 103 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 107 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 109 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 116 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 117 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 124 */         this.randomPassiveSkillProbMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 127 */     this.refreshCostItemType = Integer.valueOf(rootElement.attributeValue("refreshCostItemType")).intValue();
/* 128 */     this.refreshCostItemId = Integer.valueOf(rootElement.attributeValue("refreshCostItemId")).intValue();
/* 129 */     this.refreshCostItemNum = Integer.valueOf(rootElement.attributeValue("refreshCostItemNum")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 134 */     _os_.compact_uint32(this.randomPassiveSkillRandomMap.size());
/* 135 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.randomPassiveSkillRandomMap.entrySet())
/*     */     {
/* 137 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 138 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 140 */     _os_.compact_uint32(this.randomPassiveSkillProbMap.size());
/* 141 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.randomPassiveSkillProbMap.entrySet())
/*     */     {
/* 143 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 144 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 146 */     _os_.marshal(this.refreshCostItemType);
/* 147 */     _os_.marshal(this.refreshCostItemId);
/* 148 */     _os_.marshal(this.refreshCostItemNum);
/* 149 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 154 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 157 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 159 */       int _v_ = _os_.unmarshal_int();
/* 160 */       this.randomPassiveSkillRandomMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 162 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 165 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 167 */       int _v_ = _os_.unmarshal_int();
/* 168 */       this.randomPassiveSkillProbMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 170 */     this.refreshCostItemType = _os_.unmarshal_int();
/* 171 */     this.refreshCostItemId = _os_.unmarshal_int();
/* 172 */     this.refreshCostItemNum = _os_.unmarshal_int();
/* 173 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\confbean\MountsPassiveSkillBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */