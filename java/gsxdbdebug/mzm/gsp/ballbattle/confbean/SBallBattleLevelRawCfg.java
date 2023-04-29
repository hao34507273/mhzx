/*     */ package mzm.gsp.ballbattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SBallBattleLevelRawCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBallBattleLevelRawCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBallBattleLevelRawCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int maxLevel;
/*  20 */   public ArrayList<Integer> modelIds = new ArrayList();
/*  21 */   public ArrayList<Integer> modelRatios = new ArrayList();
/*  22 */   public ArrayList<Integer> speedOffsets = new ArrayList();
/*  23 */   public ArrayList<Integer> radii = new ArrayList();
/*  24 */   public ArrayList<Integer> providedScores = new ArrayList();
/*  25 */   public ArrayList<Integer> providedGenes = new ArrayList();
/*  26 */   public ArrayList<Integer> requiredGenes = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.maxLevel = Integer.valueOf(rootElement.attributeValue("maxLevel")).intValue();
/*     */     
/*  33 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "modelIds");
/*  34 */     if (collectionElement == null)
/*     */     {
/*  36 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  39 */     List<?> _nodeList = collectionElement.elements();
/*  40 */     int _len = _nodeList.size();
/*  41 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  43 */       Element elem = (Element)_nodeList.get(i);
/*  44 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  51 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.modelIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  62 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "modelRatios");
/*  63 */     if (collectionElement == null)
/*     */     {
/*  65 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  68 */     List<?> _nodeList = collectionElement.elements();
/*  69 */     int _len = _nodeList.size();
/*  70 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  72 */       Element elem = (Element)_nodeList.get(i);
/*  73 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  80 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  87 */         this.modelRatios.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  91 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "speedOffsets");
/*  92 */     if (collectionElement == null)
/*     */     {
/*  94 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  97 */     List<?> _nodeList = collectionElement.elements();
/*  98 */     int _len = _nodeList.size();
/*  99 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 101 */       Element elem = (Element)_nodeList.get(i);
/* 102 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 109 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 116 */         this.speedOffsets.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 120 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "radii");
/* 121 */     if (collectionElement == null)
/*     */     {
/* 123 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 126 */     List<?> _nodeList = collectionElement.elements();
/* 127 */     int _len = _nodeList.size();
/* 128 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 130 */       Element elem = (Element)_nodeList.get(i);
/* 131 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 138 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 145 */         this.radii.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 149 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "providedScores");
/* 150 */     if (collectionElement == null)
/*     */     {
/* 152 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 155 */     List<?> _nodeList = collectionElement.elements();
/* 156 */     int _len = _nodeList.size();
/* 157 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 159 */       Element elem = (Element)_nodeList.get(i);
/* 160 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 167 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 174 */         this.providedScores.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 178 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "providedGenes");
/* 179 */     if (collectionElement == null)
/*     */     {
/* 181 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 184 */     List<?> _nodeList = collectionElement.elements();
/* 185 */     int _len = _nodeList.size();
/* 186 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 188 */       Element elem = (Element)_nodeList.get(i);
/* 189 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 196 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 203 */         this.providedGenes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 207 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "requiredGenes");
/* 208 */     if (collectionElement == null)
/*     */     {
/* 210 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 213 */     List<?> _nodeList = collectionElement.elements();
/* 214 */     int _len = _nodeList.size();
/* 215 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 217 */       Element elem = (Element)_nodeList.get(i);
/* 218 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 225 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 232 */         this.requiredGenes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 239 */     _os_.marshal(this.id);
/* 240 */     _os_.marshal(this.maxLevel);
/* 241 */     _os_.compact_uint32(this.modelIds.size());
/* 242 */     for (Integer _v_ : this.modelIds)
/*     */     {
/* 244 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 246 */     _os_.compact_uint32(this.modelRatios.size());
/* 247 */     for (Integer _v_ : this.modelRatios)
/*     */     {
/* 249 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 251 */     _os_.compact_uint32(this.speedOffsets.size());
/* 252 */     for (Integer _v_ : this.speedOffsets)
/*     */     {
/* 254 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 256 */     _os_.compact_uint32(this.radii.size());
/* 257 */     for (Integer _v_ : this.radii)
/*     */     {
/* 259 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 261 */     _os_.compact_uint32(this.providedScores.size());
/* 262 */     for (Integer _v_ : this.providedScores)
/*     */     {
/* 264 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 266 */     _os_.compact_uint32(this.providedGenes.size());
/* 267 */     for (Integer _v_ : this.providedGenes)
/*     */     {
/* 269 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 271 */     _os_.compact_uint32(this.requiredGenes.size());
/* 272 */     for (Integer _v_ : this.requiredGenes)
/*     */     {
/* 274 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 276 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 281 */     this.id = _os_.unmarshal_int();
/* 282 */     this.maxLevel = _os_.unmarshal_int();
/* 283 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 286 */       int _v_ = _os_.unmarshal_int();
/* 287 */       this.modelIds.add(Integer.valueOf(_v_));
/*     */     }
/* 289 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 292 */       int _v_ = _os_.unmarshal_int();
/* 293 */       this.modelRatios.add(Integer.valueOf(_v_));
/*     */     }
/* 295 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 298 */       int _v_ = _os_.unmarshal_int();
/* 299 */       this.speedOffsets.add(Integer.valueOf(_v_));
/*     */     }
/* 301 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 304 */       int _v_ = _os_.unmarshal_int();
/* 305 */       this.radii.add(Integer.valueOf(_v_));
/*     */     }
/* 307 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 310 */       int _v_ = _os_.unmarshal_int();
/* 311 */       this.providedScores.add(Integer.valueOf(_v_));
/*     */     }
/* 313 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 316 */       int _v_ = _os_.unmarshal_int();
/* 317 */       this.providedGenes.add(Integer.valueOf(_v_));
/*     */     }
/* 319 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 322 */       int _v_ = _os_.unmarshal_int();
/* 323 */       this.requiredGenes.add(Integer.valueOf(_v_));
/*     */     }
/* 325 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 330 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleLevelRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 334 */       all = new java.util.HashMap();
/* 335 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 336 */       org.dom4j.Document doc = reader.read(new File(path));
/* 337 */       Element root = doc.getRootElement();
/* 338 */       List<?> nodeList = root.elements();
/* 339 */       int len = nodeList.size();
/* 340 */       for (int i = 0; i < len; i++)
/*     */       {
/* 342 */         Element elem = (Element)nodeList.get(i);
/* 343 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ballbattle.confbean.SBallBattleLevelRawCfg"))
/*     */         {
/*     */ 
/* 346 */           SBallBattleLevelRawCfg obj = new SBallBattleLevelRawCfg();
/* 347 */           obj.loadFromXml(elem);
/* 348 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 349 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 354 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBallBattleLevelRawCfg> all)
/*     */   {
/* 360 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleLevelRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 364 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 365 */       org.dom4j.Document doc = reader.read(new File(path));
/* 366 */       Element root = doc.getRootElement();
/* 367 */       List<?> nodeList = root.elements();
/* 368 */       int len = nodeList.size();
/* 369 */       for (int i = 0; i < len; i++)
/*     */       {
/* 371 */         Element elem = (Element)nodeList.get(i);
/* 372 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ballbattle.confbean.SBallBattleLevelRawCfg"))
/*     */         {
/*     */ 
/* 375 */           SBallBattleLevelRawCfg obj = new SBallBattleLevelRawCfg();
/* 376 */           obj.loadFromXml(elem);
/* 377 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 378 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 383 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 389 */     all = new java.util.HashMap();
/*     */     
/* 391 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleLevelRawCfg.bny";
/*     */     try
/*     */     {
/* 394 */       File file = new File(path);
/* 395 */       if (file.exists())
/*     */       {
/* 397 */         byte[] bytes = new byte['Ѐ'];
/* 398 */         FileInputStream fis = new FileInputStream(file);
/* 399 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 400 */         int len = 0;
/* 401 */         while ((len = fis.read(bytes)) > 0)
/* 402 */           baos.write(bytes, 0, len);
/* 403 */         fis.close();
/* 404 */         bytes = baos.toByteArray();
/* 405 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 406 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 408 */           _os_.unmarshal_int();
/* 409 */           _os_.unmarshal_int();
/* 410 */           _os_.unmarshal_int();
/*     */         }
/* 412 */         _os_.unmarshal_int();
/* 413 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 416 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 418 */           SBallBattleLevelRawCfg _v_ = new SBallBattleLevelRawCfg();
/* 419 */           _v_.unmarshal(_os_);
/* 420 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 421 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 426 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 431 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBallBattleLevelRawCfg> all)
/*     */   {
/* 438 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleLevelRawCfg.bny";
/*     */     try
/*     */     {
/* 441 */       File file = new File(path);
/* 442 */       if (file.exists())
/*     */       {
/* 444 */         byte[] bytes = new byte['Ѐ'];
/* 445 */         FileInputStream fis = new FileInputStream(file);
/* 446 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 447 */         int len = 0;
/* 448 */         while ((len = fis.read(bytes)) > 0)
/* 449 */           baos.write(bytes, 0, len);
/* 450 */         fis.close();
/* 451 */         bytes = baos.toByteArray();
/* 452 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 453 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 455 */           _os_.unmarshal_int();
/* 456 */           _os_.unmarshal_int();
/* 457 */           _os_.unmarshal_int();
/*     */         }
/* 459 */         _os_.unmarshal_int();
/* 460 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 463 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 465 */           SBallBattleLevelRawCfg _v_ = new SBallBattleLevelRawCfg();
/* 466 */           _v_.unmarshal(_os_);
/* 467 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 468 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 473 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 478 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBallBattleLevelRawCfg getOld(int key)
/*     */   {
/* 486 */     return (SBallBattleLevelRawCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBallBattleLevelRawCfg get(int key)
/*     */   {
/* 491 */     return (SBallBattleLevelRawCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBallBattleLevelRawCfg> getOldAll()
/*     */   {
/* 496 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBallBattleLevelRawCfg> getAll()
/*     */   {
/* 501 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBallBattleLevelRawCfg> newAll)
/*     */   {
/* 506 */     oldAll = all;
/* 507 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 512 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\confbean\SBallBattleLevelRawCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */