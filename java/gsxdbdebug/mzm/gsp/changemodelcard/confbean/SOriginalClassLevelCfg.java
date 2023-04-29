/*     */ package mzm.gsp.changemodelcard.confbean;
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
/*     */ public class SOriginalClassLevelCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SOriginalClassLevelCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SOriginalClassLevelCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int classType;
/*     */   public int level;
/*  21 */   public ArrayList<Integer> restrictClasses = new ArrayList();
/*  22 */   public ArrayList<Integer> damageAddRates = new ArrayList();
/*  23 */   public ArrayList<Integer> damageReduceRates = new ArrayList();
/*  24 */   public ArrayList<Integer> sealAddRates = new ArrayList();
/*  25 */   public ArrayList<Integer> sealReduceRates = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  30 */     this.classType = Integer.valueOf(rootElement.attributeValue("classType")).intValue();
/*  31 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*     */     
/*  33 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "restrictClasses");
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
/*  58 */         this.restrictClasses.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  62 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "damageAddRates");
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
/*  87 */         this.damageAddRates.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  91 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "damageReduceRates");
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
/* 116 */         this.damageReduceRates.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 120 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "sealAddRates");
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
/* 145 */         this.sealAddRates.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 149 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "sealReduceRates");
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
/* 174 */         this.sealReduceRates.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 181 */     _os_.marshal(this.id);
/* 182 */     _os_.marshal(this.classType);
/* 183 */     _os_.marshal(this.level);
/* 184 */     _os_.compact_uint32(this.restrictClasses.size());
/* 185 */     for (Integer _v_ : this.restrictClasses)
/*     */     {
/* 187 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 189 */     _os_.compact_uint32(this.damageAddRates.size());
/* 190 */     for (Integer _v_ : this.damageAddRates)
/*     */     {
/* 192 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 194 */     _os_.compact_uint32(this.damageReduceRates.size());
/* 195 */     for (Integer _v_ : this.damageReduceRates)
/*     */     {
/* 197 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 199 */     _os_.compact_uint32(this.sealAddRates.size());
/* 200 */     for (Integer _v_ : this.sealAddRates)
/*     */     {
/* 202 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 204 */     _os_.compact_uint32(this.sealReduceRates.size());
/* 205 */     for (Integer _v_ : this.sealReduceRates)
/*     */     {
/* 207 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 209 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 214 */     this.id = _os_.unmarshal_int();
/* 215 */     this.classType = _os_.unmarshal_int();
/* 216 */     this.level = _os_.unmarshal_int();
/* 217 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 220 */       int _v_ = _os_.unmarshal_int();
/* 221 */       this.restrictClasses.add(Integer.valueOf(_v_));
/*     */     }
/* 223 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 226 */       int _v_ = _os_.unmarshal_int();
/* 227 */       this.damageAddRates.add(Integer.valueOf(_v_));
/*     */     }
/* 229 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 232 */       int _v_ = _os_.unmarshal_int();
/* 233 */       this.damageReduceRates.add(Integer.valueOf(_v_));
/*     */     }
/* 235 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 238 */       int _v_ = _os_.unmarshal_int();
/* 239 */       this.sealAddRates.add(Integer.valueOf(_v_));
/*     */     }
/* 241 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 244 */       int _v_ = _os_.unmarshal_int();
/* 245 */       this.sealReduceRates.add(Integer.valueOf(_v_));
/*     */     }
/* 247 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 252 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SOriginalClassLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 256 */       all = new java.util.HashMap();
/* 257 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 258 */       org.dom4j.Document doc = reader.read(new File(path));
/* 259 */       Element root = doc.getRootElement();
/* 260 */       List<?> nodeList = root.elements();
/* 261 */       int len = nodeList.size();
/* 262 */       for (int i = 0; i < len; i++)
/*     */       {
/* 264 */         Element elem = (Element)nodeList.get(i);
/* 265 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.changemodelcard.confbean.SOriginalClassLevelCfg"))
/*     */         {
/*     */ 
/* 268 */           SOriginalClassLevelCfg obj = new SOriginalClassLevelCfg();
/* 269 */           obj.loadFromXml(elem);
/* 270 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 271 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 276 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SOriginalClassLevelCfg> all)
/*     */   {
/* 282 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SOriginalClassLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 286 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 287 */       org.dom4j.Document doc = reader.read(new File(path));
/* 288 */       Element root = doc.getRootElement();
/* 289 */       List<?> nodeList = root.elements();
/* 290 */       int len = nodeList.size();
/* 291 */       for (int i = 0; i < len; i++)
/*     */       {
/* 293 */         Element elem = (Element)nodeList.get(i);
/* 294 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.changemodelcard.confbean.SOriginalClassLevelCfg"))
/*     */         {
/*     */ 
/* 297 */           SOriginalClassLevelCfg obj = new SOriginalClassLevelCfg();
/* 298 */           obj.loadFromXml(elem);
/* 299 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 300 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 305 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 311 */     all = new java.util.HashMap();
/*     */     
/* 313 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SOriginalClassLevelCfg.bny";
/*     */     try
/*     */     {
/* 316 */       File file = new File(path);
/* 317 */       if (file.exists())
/*     */       {
/* 319 */         byte[] bytes = new byte['Ѐ'];
/* 320 */         FileInputStream fis = new FileInputStream(file);
/* 321 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 322 */         int len = 0;
/* 323 */         while ((len = fis.read(bytes)) > 0)
/* 324 */           baos.write(bytes, 0, len);
/* 325 */         fis.close();
/* 326 */         bytes = baos.toByteArray();
/* 327 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 328 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 330 */           _os_.unmarshal_int();
/* 331 */           _os_.unmarshal_int();
/* 332 */           _os_.unmarshal_int();
/*     */         }
/* 334 */         _os_.unmarshal_int();
/* 335 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 338 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 340 */           SOriginalClassLevelCfg _v_ = new SOriginalClassLevelCfg();
/* 341 */           _v_.unmarshal(_os_);
/* 342 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 343 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 348 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 353 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SOriginalClassLevelCfg> all)
/*     */   {
/* 360 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SOriginalClassLevelCfg.bny";
/*     */     try
/*     */     {
/* 363 */       File file = new File(path);
/* 364 */       if (file.exists())
/*     */       {
/* 366 */         byte[] bytes = new byte['Ѐ'];
/* 367 */         FileInputStream fis = new FileInputStream(file);
/* 368 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 369 */         int len = 0;
/* 370 */         while ((len = fis.read(bytes)) > 0)
/* 371 */           baos.write(bytes, 0, len);
/* 372 */         fis.close();
/* 373 */         bytes = baos.toByteArray();
/* 374 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 375 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 377 */           _os_.unmarshal_int();
/* 378 */           _os_.unmarshal_int();
/* 379 */           _os_.unmarshal_int();
/*     */         }
/* 381 */         _os_.unmarshal_int();
/* 382 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 385 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 387 */           SOriginalClassLevelCfg _v_ = new SOriginalClassLevelCfg();
/* 388 */           _v_.unmarshal(_os_);
/* 389 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 390 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 395 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 400 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SOriginalClassLevelCfg getOld(int key)
/*     */   {
/* 408 */     return (SOriginalClassLevelCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SOriginalClassLevelCfg get(int key)
/*     */   {
/* 413 */     return (SOriginalClassLevelCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalClassLevelCfg> getOldAll()
/*     */   {
/* 418 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalClassLevelCfg> getAll()
/*     */   {
/* 423 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SOriginalClassLevelCfg> newAll)
/*     */   {
/* 428 */     oldAll = all;
/* 429 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 434 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\confbean\SOriginalClassLevelCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */