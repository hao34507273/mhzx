/*     */ package mzm.gsp.pet.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class PetFightFormationLevelInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int expToNextLevel;
/*  10 */   public ArrayList<Integer> position1Attrs = new ArrayList();
/*  11 */   public ArrayList<Integer> position1Values = new ArrayList();
/*  12 */   public ArrayList<Integer> position2Attrs = new ArrayList();
/*  13 */   public ArrayList<Integer> position2Values = new ArrayList();
/*  14 */   public ArrayList<Integer> position3Attrs = new ArrayList();
/*  15 */   public ArrayList<Integer> position3Values = new ArrayList();
/*  16 */   public ArrayList<Integer> position4Attrs = new ArrayList();
/*  17 */   public ArrayList<Integer> position4Values = new ArrayList();
/*  18 */   public ArrayList<Integer> position5Attrs = new ArrayList();
/*  19 */   public ArrayList<Integer> position5Values = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.expToNextLevel = Integer.valueOf(rootElement.attributeValue("expToNextLevel")).intValue();
/*     */     
/*  25 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position1Attrs");
/*  26 */     if (collectionElement == null)
/*     */     {
/*  28 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  31 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  32 */     int _len = _nodeList.size();
/*  33 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  35 */       Element elem = (Element)_nodeList.get(i);
/*  36 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  43 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  50 */         this.position1Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  54 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position1Values");
/*  55 */     if (collectionElement == null)
/*     */     {
/*  57 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  60 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  61 */     int _len = _nodeList.size();
/*  62 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  64 */       Element elem = (Element)_nodeList.get(i);
/*  65 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  72 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  79 */         this.position1Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  83 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position2Attrs");
/*  84 */     if (collectionElement == null)
/*     */     {
/*  86 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  89 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  90 */     int _len = _nodeList.size();
/*  91 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  93 */       Element elem = (Element)_nodeList.get(i);
/*  94 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 101 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 108 */         this.position2Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 112 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position2Values");
/* 113 */     if (collectionElement == null)
/*     */     {
/* 115 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 118 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 119 */     int _len = _nodeList.size();
/* 120 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 122 */       Element elem = (Element)_nodeList.get(i);
/* 123 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 130 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 137 */         this.position2Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 141 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position3Attrs");
/* 142 */     if (collectionElement == null)
/*     */     {
/* 144 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 147 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 148 */     int _len = _nodeList.size();
/* 149 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 151 */       Element elem = (Element)_nodeList.get(i);
/* 152 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 159 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 166 */         this.position3Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 170 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position3Values");
/* 171 */     if (collectionElement == null)
/*     */     {
/* 173 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 176 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 177 */     int _len = _nodeList.size();
/* 178 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 180 */       Element elem = (Element)_nodeList.get(i);
/* 181 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 188 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 195 */         this.position3Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 199 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position4Attrs");
/* 200 */     if (collectionElement == null)
/*     */     {
/* 202 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 205 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 206 */     int _len = _nodeList.size();
/* 207 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 209 */       Element elem = (Element)_nodeList.get(i);
/* 210 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 217 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 224 */         this.position4Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 228 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position4Values");
/* 229 */     if (collectionElement == null)
/*     */     {
/* 231 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 234 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 235 */     int _len = _nodeList.size();
/* 236 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 238 */       Element elem = (Element)_nodeList.get(i);
/* 239 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 246 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 253 */         this.position4Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 257 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position5Attrs");
/* 258 */     if (collectionElement == null)
/*     */     {
/* 260 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 263 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 264 */     int _len = _nodeList.size();
/* 265 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 267 */       Element elem = (Element)_nodeList.get(i);
/* 268 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 275 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 282 */         this.position5Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 286 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "position5Values");
/* 287 */     if (collectionElement == null)
/*     */     {
/* 289 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 292 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 293 */     int _len = _nodeList.size();
/* 294 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 296 */       Element elem = (Element)_nodeList.get(i);
/* 297 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 304 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 311 */         this.position5Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 318 */     _os_.marshal(this.expToNextLevel);
/* 319 */     _os_.compact_uint32(this.position1Attrs.size());
/* 320 */     for (Integer _v_ : this.position1Attrs)
/*     */     {
/* 322 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 324 */     _os_.compact_uint32(this.position1Values.size());
/* 325 */     for (Integer _v_ : this.position1Values)
/*     */     {
/* 327 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 329 */     _os_.compact_uint32(this.position2Attrs.size());
/* 330 */     for (Integer _v_ : this.position2Attrs)
/*     */     {
/* 332 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 334 */     _os_.compact_uint32(this.position2Values.size());
/* 335 */     for (Integer _v_ : this.position2Values)
/*     */     {
/* 337 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 339 */     _os_.compact_uint32(this.position3Attrs.size());
/* 340 */     for (Integer _v_ : this.position3Attrs)
/*     */     {
/* 342 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 344 */     _os_.compact_uint32(this.position3Values.size());
/* 345 */     for (Integer _v_ : this.position3Values)
/*     */     {
/* 347 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 349 */     _os_.compact_uint32(this.position4Attrs.size());
/* 350 */     for (Integer _v_ : this.position4Attrs)
/*     */     {
/* 352 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 354 */     _os_.compact_uint32(this.position4Values.size());
/* 355 */     for (Integer _v_ : this.position4Values)
/*     */     {
/* 357 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 359 */     _os_.compact_uint32(this.position5Attrs.size());
/* 360 */     for (Integer _v_ : this.position5Attrs)
/*     */     {
/* 362 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 364 */     _os_.compact_uint32(this.position5Values.size());
/* 365 */     for (Integer _v_ : this.position5Values)
/*     */     {
/* 367 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 369 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 374 */     this.expToNextLevel = _os_.unmarshal_int();
/* 375 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 378 */       int _v_ = _os_.unmarshal_int();
/* 379 */       this.position1Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 381 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 384 */       int _v_ = _os_.unmarshal_int();
/* 385 */       this.position1Values.add(Integer.valueOf(_v_));
/*     */     }
/* 387 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 390 */       int _v_ = _os_.unmarshal_int();
/* 391 */       this.position2Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 393 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 396 */       int _v_ = _os_.unmarshal_int();
/* 397 */       this.position2Values.add(Integer.valueOf(_v_));
/*     */     }
/* 399 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 402 */       int _v_ = _os_.unmarshal_int();
/* 403 */       this.position3Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 405 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 408 */       int _v_ = _os_.unmarshal_int();
/* 409 */       this.position3Values.add(Integer.valueOf(_v_));
/*     */     }
/* 411 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 414 */       int _v_ = _os_.unmarshal_int();
/* 415 */       this.position4Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 417 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 420 */       int _v_ = _os_.unmarshal_int();
/* 421 */       this.position4Values.add(Integer.valueOf(_v_));
/*     */     }
/* 423 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 426 */       int _v_ = _os_.unmarshal_int();
/* 427 */       this.position5Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 429 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 432 */       int _v_ = _os_.unmarshal_int();
/* 433 */       this.position5Values.add(Integer.valueOf(_v_));
/*     */     }
/* 435 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\PetFightFormationLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */