/*     */ package mzm.gsp.mounts.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class MountsStarLifePropertyBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*   9 */   public HashMap<Integer, Integer> propertyMap = new HashMap();
/*     */   
/*     */   public int costItemId;
/*     */   public int costItemType;
/*     */   public int costItemNum;
/*     */   public int unLockRank;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  18 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "propertyMap");
/*  19 */     if (mapTypeElement == null)
/*     */     {
/*  21 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  24 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
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
/*  37 */         java.util.List<?> _nodeList = entryElement.elements();
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
/*  69 */         this.propertyMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  72 */     this.costItemId = Integer.valueOf(rootElement.attributeValue("costItemId")).intValue();
/*  73 */     this.costItemType = Integer.valueOf(rootElement.attributeValue("costItemType")).intValue();
/*  74 */     this.costItemNum = Integer.valueOf(rootElement.attributeValue("costItemNum")).intValue();
/*  75 */     this.unLockRank = Integer.valueOf(rootElement.attributeValue("unLockRank")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _os_.compact_uint32(this.propertyMap.size());
/*  81 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.propertyMap.entrySet())
/*     */     {
/*  83 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  84 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  86 */     _os_.marshal(this.costItemId);
/*  87 */     _os_.marshal(this.costItemType);
/*  88 */     _os_.marshal(this.costItemNum);
/*  89 */     _os_.marshal(this.unLockRank);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  98 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 100 */       int _v_ = _os_.unmarshal_int();
/* 101 */       this.propertyMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 103 */     this.costItemId = _os_.unmarshal_int();
/* 104 */     this.costItemType = _os_.unmarshal_int();
/* 105 */     this.costItemNum = _os_.unmarshal_int();
/* 106 */     this.unLockRank = _os_.unmarshal_int();
/* 107 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\confbean\MountsStarLifePropertyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */