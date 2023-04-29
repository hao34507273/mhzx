/*     */ package mzm.gsp.skill.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.List;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class PosSortRule implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*   9 */   public java.util.ArrayList<Integer> sortPosList = new java.util.ArrayList();
/*  10 */   public java.util.HashMap<Integer, Integer> sortPosMap = new java.util.HashMap();
/*     */   
/*     */ 
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  15 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "sortPosList");
/*  16 */     if (collectionElement == null)
/*     */     {
/*  18 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  21 */     List<?> _nodeList = collectionElement.elements();
/*  22 */     int _len = _nodeList.size();
/*  23 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  25 */       Element elem = (Element)_nodeList.get(i);
/*  26 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  33 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  40 */         this.sortPosList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  44 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "sortPosMap");
/*  45 */     if (mapTypeElement == null)
/*     */     {
/*  47 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  50 */     List<?> entryNodeList = mapTypeElement.elements();
/*  51 */     int entryLen = entryNodeList.size();
/*  52 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  54 */       Element entryElement = (Element)entryNodeList.get(i);
/*  55 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  60 */         Element keyElem = null;
/*  61 */         Element valueElem = null;
/*     */         
/*  63 */         List<?> _nodeList = entryElement.elements();
/*  64 */         int _len = _nodeList.size();
/*  65 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  67 */           Element elem = (Element)_nodeList.get(j);
/*  68 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  70 */             keyElem = elem;
/*     */           }
/*  72 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  74 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  78 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  80 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  87 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  88 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  95 */         this.sortPosMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 102 */     _os_.compact_uint32(this.sortPosList.size());
/* 103 */     for (Integer _v_ : this.sortPosList)
/*     */     {
/* 105 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 107 */     _os_.compact_uint32(this.sortPosMap.size());
/* 108 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.sortPosMap.entrySet())
/*     */     {
/* 110 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 111 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 113 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 118 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 121 */       int _v_ = _os_.unmarshal_int();
/* 122 */       this.sortPosList.add(Integer.valueOf(_v_));
/*     */     }
/* 124 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 127 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 129 */       int _v_ = _os_.unmarshal_int();
/* 130 */       this.sortPosMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 132 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\PosSortRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */