/*     */ package mzm.gsp.midautumnholiday.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SCreateCostInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int createItemId;
/*     */   public int createItemNum;
/*     */   public int isBind;
/*  12 */   public HashMap<Integer, Integer> costItemId2costItemNum = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  16 */     this.createItemId = Integer.valueOf(rootElement.attributeValue("createItemId")).intValue();
/*  17 */     this.createItemNum = Integer.valueOf(rootElement.attributeValue("createItemNum")).intValue();
/*  18 */     this.isBind = Integer.valueOf(rootElement.attributeValue("isBind")).intValue();
/*     */     
/*  20 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "costItemId2costItemNum");
/*  21 */     if (mapTypeElement == null)
/*     */     {
/*  23 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  26 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/*  27 */     int entryLen = entryNodeList.size();
/*  28 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  30 */       Element entryElement = (Element)entryNodeList.get(i);
/*  31 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  36 */         Element keyElem = null;
/*  37 */         Element valueElem = null;
/*     */         
/*  39 */         java.util.List<?> _nodeList = entryElement.elements();
/*  40 */         int _len = _nodeList.size();
/*  41 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  43 */           Element elem = (Element)_nodeList.get(j);
/*  44 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  46 */             keyElem = elem;
/*     */           }
/*  48 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  50 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  54 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  56 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  63 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  64 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  71 */         this.costItemId2costItemNum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _os_.marshal(this.createItemId);
/*  79 */     _os_.marshal(this.createItemNum);
/*  80 */     _os_.marshal(this.isBind);
/*  81 */     _os_.compact_uint32(this.costItemId2costItemNum.size());
/*  82 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.costItemId2costItemNum.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     this.createItemId = _os_.unmarshal_int();
/*  93 */     this.createItemNum = _os_.unmarshal_int();
/*  94 */     this.isBind = _os_.unmarshal_int();
/*  95 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  98 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 100 */       int _v_ = _os_.unmarshal_int();
/* 101 */       this.costItemId2costItemNum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 103 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\midautumnholiday\confbean\SCreateCostInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */