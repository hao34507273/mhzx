/*     */ package mzm.gsp.changemodelcard.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.List;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SClassLevelBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int classType;
/*     */   public int level;
/*  11 */   public java.util.HashMap<Integer, Integer> restrictClass2DamageAddRate = new java.util.HashMap();
/*  12 */   public java.util.HashMap<Integer, Integer> restrictClass2DamageReduceRate = new java.util.HashMap();
/*  13 */   public java.util.HashMap<Integer, Integer> restrictClass2SealAddRate = new java.util.HashMap();
/*  14 */   public java.util.HashMap<Integer, Integer> restrictClass2SealReduceRate = new java.util.HashMap();
/*  15 */   public java.util.ArrayList<Integer> beRestrictedClasses = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  19 */     this.classType = Integer.valueOf(rootElement.attributeValue("classType")).intValue();
/*  20 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*     */     
/*  22 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "restrictClass2DamageAddRate");
/*  23 */     if (mapTypeElement == null)
/*     */     {
/*  25 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  28 */     List<?> entryNodeList = mapTypeElement.elements();
/*  29 */     int entryLen = entryNodeList.size();
/*  30 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  32 */       Element entryElement = (Element)entryNodeList.get(i);
/*  33 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  38 */         Element keyElem = null;
/*  39 */         Element valueElem = null;
/*     */         
/*  41 */         List<?> _nodeList = entryElement.elements();
/*  42 */         int _len = _nodeList.size();
/*  43 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  45 */           Element elem = (Element)_nodeList.get(j);
/*  46 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  48 */             keyElem = elem;
/*     */           }
/*  50 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  52 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  56 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  58 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  65 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  66 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  73 */         this.restrictClass2DamageAddRate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  77 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "restrictClass2DamageReduceRate");
/*  78 */     if (mapTypeElement == null)
/*     */     {
/*  80 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  83 */     List<?> entryNodeList = mapTypeElement.elements();
/*  84 */     int entryLen = entryNodeList.size();
/*  85 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  87 */       Element entryElement = (Element)entryNodeList.get(i);
/*  88 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  93 */         Element keyElem = null;
/*  94 */         Element valueElem = null;
/*     */         
/*  96 */         List<?> _nodeList = entryElement.elements();
/*  97 */         int _len = _nodeList.size();
/*  98 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 100 */           Element elem = (Element)_nodeList.get(j);
/* 101 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 103 */             keyElem = elem;
/*     */           }
/* 105 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 107 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 111 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 113 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 120 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 121 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 128 */         this.restrictClass2DamageReduceRate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 132 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "restrictClass2SealAddRate");
/* 133 */     if (mapTypeElement == null)
/*     */     {
/* 135 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 138 */     List<?> entryNodeList = mapTypeElement.elements();
/* 139 */     int entryLen = entryNodeList.size();
/* 140 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 142 */       Element entryElement = (Element)entryNodeList.get(i);
/* 143 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 148 */         Element keyElem = null;
/* 149 */         Element valueElem = null;
/*     */         
/* 151 */         List<?> _nodeList = entryElement.elements();
/* 152 */         int _len = _nodeList.size();
/* 153 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 155 */           Element elem = (Element)_nodeList.get(j);
/* 156 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 158 */             keyElem = elem;
/*     */           }
/* 160 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 162 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 166 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 168 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 175 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 176 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 183 */         this.restrictClass2SealAddRate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 187 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "restrictClass2SealReduceRate");
/* 188 */     if (mapTypeElement == null)
/*     */     {
/* 190 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 193 */     List<?> entryNodeList = mapTypeElement.elements();
/* 194 */     int entryLen = entryNodeList.size();
/* 195 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 197 */       Element entryElement = (Element)entryNodeList.get(i);
/* 198 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 203 */         Element keyElem = null;
/* 204 */         Element valueElem = null;
/*     */         
/* 206 */         List<?> _nodeList = entryElement.elements();
/* 207 */         int _len = _nodeList.size();
/* 208 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 210 */           Element elem = (Element)_nodeList.get(j);
/* 211 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 213 */             keyElem = elem;
/*     */           }
/* 215 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 217 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 221 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 223 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 230 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 231 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 238 */         this.restrictClass2SealReduceRate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 242 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "beRestrictedClasses");
/* 243 */     if (collectionElement == null)
/*     */     {
/* 245 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 248 */     List<?> _nodeList = collectionElement.elements();
/* 249 */     int _len = _nodeList.size();
/* 250 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 252 */       Element elem = (Element)_nodeList.get(i);
/* 253 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 260 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 267 */         this.beRestrictedClasses.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 274 */     _os_.marshal(this.classType);
/* 275 */     _os_.marshal(this.level);
/* 276 */     _os_.compact_uint32(this.restrictClass2DamageAddRate.size());
/* 277 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.restrictClass2DamageAddRate.entrySet())
/*     */     {
/* 279 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 280 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 282 */     _os_.compact_uint32(this.restrictClass2DamageReduceRate.size());
/* 283 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.restrictClass2DamageReduceRate.entrySet())
/*     */     {
/* 285 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 286 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 288 */     _os_.compact_uint32(this.restrictClass2SealAddRate.size());
/* 289 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.restrictClass2SealAddRate.entrySet())
/*     */     {
/* 291 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 292 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 294 */     _os_.compact_uint32(this.restrictClass2SealReduceRate.size());
/* 295 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.restrictClass2SealReduceRate.entrySet())
/*     */     {
/* 297 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 298 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 300 */     _os_.compact_uint32(this.beRestrictedClasses.size());
/* 301 */     for (Integer _v_ : this.beRestrictedClasses)
/*     */     {
/* 303 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 305 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 310 */     this.classType = _os_.unmarshal_int();
/* 311 */     this.level = _os_.unmarshal_int();
/* 312 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 315 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 317 */       int _v_ = _os_.unmarshal_int();
/* 318 */       this.restrictClass2DamageAddRate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 320 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 323 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 325 */       int _v_ = _os_.unmarshal_int();
/* 326 */       this.restrictClass2DamageReduceRate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 328 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 331 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 333 */       int _v_ = _os_.unmarshal_int();
/* 334 */       this.restrictClass2SealAddRate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 336 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 339 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 341 */       int _v_ = _os_.unmarshal_int();
/* 342 */       this.restrictClass2SealReduceRate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 344 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 347 */       int _v_ = _os_.unmarshal_int();
/* 348 */       this.beRestrictedClasses.add(Integer.valueOf(_v_));
/*     */     }
/* 350 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\confbean\SClassLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */