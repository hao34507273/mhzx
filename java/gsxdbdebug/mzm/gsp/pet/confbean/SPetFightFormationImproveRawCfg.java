/*     */ package mzm.gsp.pet.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import util.XmlHelper;
/*     */ 
/*     */ public class SPetFightFormationImproveRawCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPetFightFormationImproveRawCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPetFightFormationImproveRawCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int formationId;
/*     */   public int level;
/*     */   public int expToNextLevel;
/*  22 */   public ArrayList<Integer> position1Attrs = new ArrayList();
/*  23 */   public ArrayList<Integer> position1Values = new ArrayList();
/*  24 */   public ArrayList<Integer> position2Attrs = new ArrayList();
/*  25 */   public ArrayList<Integer> position2Values = new ArrayList();
/*  26 */   public ArrayList<Integer> position3Attrs = new ArrayList();
/*  27 */   public ArrayList<Integer> position3Values = new ArrayList();
/*  28 */   public ArrayList<Integer> position4Attrs = new ArrayList();
/*  29 */   public ArrayList<Integer> position4Values = new ArrayList();
/*  30 */   public ArrayList<Integer> position5Attrs = new ArrayList();
/*  31 */   public ArrayList<Integer> position5Values = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.formationId = Integer.valueOf(rootElement.attributeValue("formationId")).intValue();
/*  37 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  38 */     this.expToNextLevel = Integer.valueOf(rootElement.attributeValue("expToNextLevel")).intValue();
/*     */     
/*  40 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position1Attrs");
/*  41 */     if (collectionElement == null)
/*     */     {
/*  43 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  46 */     List<?> _nodeList = collectionElement.elements();
/*  47 */     int _len = _nodeList.size();
/*  48 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  50 */       Element elem = (Element)_nodeList.get(i);
/*  51 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  58 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  65 */         this.position1Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  69 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position1Values");
/*  70 */     if (collectionElement == null)
/*     */     {
/*  72 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  75 */     List<?> _nodeList = collectionElement.elements();
/*  76 */     int _len = _nodeList.size();
/*  77 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  79 */       Element elem = (Element)_nodeList.get(i);
/*  80 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  87 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  94 */         this.position1Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  98 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position2Attrs");
/*  99 */     if (collectionElement == null)
/*     */     {
/* 101 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 104 */     List<?> _nodeList = collectionElement.elements();
/* 105 */     int _len = _nodeList.size();
/* 106 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 108 */       Element elem = (Element)_nodeList.get(i);
/* 109 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 116 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 123 */         this.position2Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 127 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position2Values");
/* 128 */     if (collectionElement == null)
/*     */     {
/* 130 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 133 */     List<?> _nodeList = collectionElement.elements();
/* 134 */     int _len = _nodeList.size();
/* 135 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 137 */       Element elem = (Element)_nodeList.get(i);
/* 138 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 145 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 152 */         this.position2Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 156 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position3Attrs");
/* 157 */     if (collectionElement == null)
/*     */     {
/* 159 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 162 */     List<?> _nodeList = collectionElement.elements();
/* 163 */     int _len = _nodeList.size();
/* 164 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 166 */       Element elem = (Element)_nodeList.get(i);
/* 167 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 174 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 181 */         this.position3Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 185 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position3Values");
/* 186 */     if (collectionElement == null)
/*     */     {
/* 188 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 191 */     List<?> _nodeList = collectionElement.elements();
/* 192 */     int _len = _nodeList.size();
/* 193 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 195 */       Element elem = (Element)_nodeList.get(i);
/* 196 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 203 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 210 */         this.position3Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 214 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position4Attrs");
/* 215 */     if (collectionElement == null)
/*     */     {
/* 217 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 220 */     List<?> _nodeList = collectionElement.elements();
/* 221 */     int _len = _nodeList.size();
/* 222 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 224 */       Element elem = (Element)_nodeList.get(i);
/* 225 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 232 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 239 */         this.position4Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 243 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position4Values");
/* 244 */     if (collectionElement == null)
/*     */     {
/* 246 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 249 */     List<?> _nodeList = collectionElement.elements();
/* 250 */     int _len = _nodeList.size();
/* 251 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 253 */       Element elem = (Element)_nodeList.get(i);
/* 254 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 261 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 268 */         this.position4Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 272 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position5Attrs");
/* 273 */     if (collectionElement == null)
/*     */     {
/* 275 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 278 */     List<?> _nodeList = collectionElement.elements();
/* 279 */     int _len = _nodeList.size();
/* 280 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 282 */       Element elem = (Element)_nodeList.get(i);
/* 283 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 290 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 297 */         this.position5Attrs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 301 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "position5Values");
/* 302 */     if (collectionElement == null)
/*     */     {
/* 304 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 307 */     List<?> _nodeList = collectionElement.elements();
/* 308 */     int _len = _nodeList.size();
/* 309 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 311 */       Element elem = (Element)_nodeList.get(i);
/* 312 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 319 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 326 */         this.position5Values.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 333 */     _os_.marshal(this.id);
/* 334 */     _os_.marshal(this.formationId);
/* 335 */     _os_.marshal(this.level);
/* 336 */     _os_.marshal(this.expToNextLevel);
/* 337 */     _os_.compact_uint32(this.position1Attrs.size());
/* 338 */     for (Integer _v_ : this.position1Attrs)
/*     */     {
/* 340 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 342 */     _os_.compact_uint32(this.position1Values.size());
/* 343 */     for (Integer _v_ : this.position1Values)
/*     */     {
/* 345 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 347 */     _os_.compact_uint32(this.position2Attrs.size());
/* 348 */     for (Integer _v_ : this.position2Attrs)
/*     */     {
/* 350 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 352 */     _os_.compact_uint32(this.position2Values.size());
/* 353 */     for (Integer _v_ : this.position2Values)
/*     */     {
/* 355 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 357 */     _os_.compact_uint32(this.position3Attrs.size());
/* 358 */     for (Integer _v_ : this.position3Attrs)
/*     */     {
/* 360 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 362 */     _os_.compact_uint32(this.position3Values.size());
/* 363 */     for (Integer _v_ : this.position3Values)
/*     */     {
/* 365 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 367 */     _os_.compact_uint32(this.position4Attrs.size());
/* 368 */     for (Integer _v_ : this.position4Attrs)
/*     */     {
/* 370 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 372 */     _os_.compact_uint32(this.position4Values.size());
/* 373 */     for (Integer _v_ : this.position4Values)
/*     */     {
/* 375 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 377 */     _os_.compact_uint32(this.position5Attrs.size());
/* 378 */     for (Integer _v_ : this.position5Attrs)
/*     */     {
/* 380 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 382 */     _os_.compact_uint32(this.position5Values.size());
/* 383 */     for (Integer _v_ : this.position5Values)
/*     */     {
/* 385 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 387 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 392 */     this.id = _os_.unmarshal_int();
/* 393 */     this.formationId = _os_.unmarshal_int();
/* 394 */     this.level = _os_.unmarshal_int();
/* 395 */     this.expToNextLevel = _os_.unmarshal_int();
/* 396 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 399 */       int _v_ = _os_.unmarshal_int();
/* 400 */       this.position1Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 402 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 405 */       int _v_ = _os_.unmarshal_int();
/* 406 */       this.position1Values.add(Integer.valueOf(_v_));
/*     */     }
/* 408 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 411 */       int _v_ = _os_.unmarshal_int();
/* 412 */       this.position2Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 414 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 417 */       int _v_ = _os_.unmarshal_int();
/* 418 */       this.position2Values.add(Integer.valueOf(_v_));
/*     */     }
/* 420 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 423 */       int _v_ = _os_.unmarshal_int();
/* 424 */       this.position3Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 426 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 429 */       int _v_ = _os_.unmarshal_int();
/* 430 */       this.position3Values.add(Integer.valueOf(_v_));
/*     */     }
/* 432 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 435 */       int _v_ = _os_.unmarshal_int();
/* 436 */       this.position4Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 438 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 441 */       int _v_ = _os_.unmarshal_int();
/* 442 */       this.position4Values.add(Integer.valueOf(_v_));
/*     */     }
/* 444 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 447 */       int _v_ = _os_.unmarshal_int();
/* 448 */       this.position5Attrs.add(Integer.valueOf(_v_));
/*     */     }
/* 450 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 453 */       int _v_ = _os_.unmarshal_int();
/* 454 */       this.position5Values.add(Integer.valueOf(_v_));
/*     */     }
/* 456 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 461 */     String path = dir + "mzm.gsp.pet.confbean.SPetFightFormationImproveRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 465 */       all = new java.util.HashMap();
/* 466 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 467 */       org.dom4j.Document doc = reader.read(new File(path));
/* 468 */       Element root = doc.getRootElement();
/* 469 */       List<?> nodeList = root.elements();
/* 470 */       int len = nodeList.size();
/* 471 */       for (int i = 0; i < len; i++)
/*     */       {
/* 473 */         Element elem = (Element)nodeList.get(i);
/* 474 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.SPetFightFormationImproveRawCfg"))
/*     */         {
/*     */ 
/* 477 */           SPetFightFormationImproveRawCfg obj = new SPetFightFormationImproveRawCfg();
/* 478 */           obj.loadFromXml(elem);
/* 479 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 480 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 485 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPetFightFormationImproveRawCfg> all)
/*     */   {
/* 491 */     String path = dir + "mzm.gsp.pet.confbean.SPetFightFormationImproveRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 495 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 496 */       org.dom4j.Document doc = reader.read(new File(path));
/* 497 */       Element root = doc.getRootElement();
/* 498 */       List<?> nodeList = root.elements();
/* 499 */       int len = nodeList.size();
/* 500 */       for (int i = 0; i < len; i++)
/*     */       {
/* 502 */         Element elem = (Element)nodeList.get(i);
/* 503 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.SPetFightFormationImproveRawCfg"))
/*     */         {
/*     */ 
/* 506 */           SPetFightFormationImproveRawCfg obj = new SPetFightFormationImproveRawCfg();
/* 507 */           obj.loadFromXml(elem);
/* 508 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 509 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 514 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 520 */     all = new java.util.HashMap();
/*     */     
/* 522 */     String path = dir + "mzm.gsp.pet.confbean.SPetFightFormationImproveRawCfg.bny";
/*     */     try
/*     */     {
/* 525 */       File file = new File(path);
/* 526 */       if (file.exists())
/*     */       {
/* 528 */         byte[] bytes = new byte['Ѐ'];
/* 529 */         FileInputStream fis = new FileInputStream(file);
/* 530 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 531 */         int len = 0;
/* 532 */         while ((len = fis.read(bytes)) > 0)
/* 533 */           baos.write(bytes, 0, len);
/* 534 */         fis.close();
/* 535 */         bytes = baos.toByteArray();
/* 536 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 537 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 539 */           _os_.unmarshal_int();
/* 540 */           _os_.unmarshal_int();
/* 541 */           _os_.unmarshal_int();
/*     */         }
/* 543 */         _os_.unmarshal_int();
/* 544 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 547 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 549 */           SPetFightFormationImproveRawCfg _v_ = new SPetFightFormationImproveRawCfg();
/* 550 */           _v_.unmarshal(_os_);
/* 551 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 552 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 557 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 562 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPetFightFormationImproveRawCfg> all)
/*     */   {
/* 569 */     String path = dir + "mzm.gsp.pet.confbean.SPetFightFormationImproveRawCfg.bny";
/*     */     try
/*     */     {
/* 572 */       File file = new File(path);
/* 573 */       if (file.exists())
/*     */       {
/* 575 */         byte[] bytes = new byte['Ѐ'];
/* 576 */         FileInputStream fis = new FileInputStream(file);
/* 577 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 578 */         int len = 0;
/* 579 */         while ((len = fis.read(bytes)) > 0)
/* 580 */           baos.write(bytes, 0, len);
/* 581 */         fis.close();
/* 582 */         bytes = baos.toByteArray();
/* 583 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 584 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 586 */           _os_.unmarshal_int();
/* 587 */           _os_.unmarshal_int();
/* 588 */           _os_.unmarshal_int();
/*     */         }
/* 590 */         _os_.unmarshal_int();
/* 591 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 594 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 596 */           SPetFightFormationImproveRawCfg _v_ = new SPetFightFormationImproveRawCfg();
/* 597 */           _v_.unmarshal(_os_);
/* 598 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 599 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 604 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 609 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPetFightFormationImproveRawCfg getOld(int key)
/*     */   {
/* 617 */     return (SPetFightFormationImproveRawCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPetFightFormationImproveRawCfg get(int key)
/*     */   {
/* 622 */     return (SPetFightFormationImproveRawCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetFightFormationImproveRawCfg> getOldAll()
/*     */   {
/* 627 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetFightFormationImproveRawCfg> getAll()
/*     */   {
/* 632 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPetFightFormationImproveRawCfg> newAll)
/*     */   {
/* 637 */     oldAll = all;
/* 638 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 643 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\SPetFightFormationImproveRawCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */