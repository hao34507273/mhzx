/*     */ package mzm.gsp.map.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SMapItemConfig implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMapItemConfig> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMapItemConfig> all = null;
/*     */   
/*     */   public int id;
/*     */   public int mapCfgid;
/*  20 */   public HashMap<Integer, StateSet> visibleByTaskState = new HashMap();
/*  21 */   public ArrayList<Loc> locations = new ArrayList();
/*  22 */   public ArrayList<Integer> regions = new ArrayList();
/*     */   public int randomRegionProbBase;
/*  24 */   public java.util.TreeMap<Integer, Integer> randomRegions = new java.util.TreeMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.mapCfgid = Integer.valueOf(rootElement.attributeValue("mapCfgid")).intValue();
/*     */     
/*  31 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "visibleByTaskState");
/*  32 */     if (mapTypeElement == null)
/*     */     {
/*  34 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  37 */     List<?> entryNodeList = mapTypeElement.elements();
/*  38 */     int entryLen = entryNodeList.size();
/*  39 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  41 */       Element entryElement = (Element)entryNodeList.get(i);
/*  42 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  47 */         Element keyElem = null;
/*  48 */         Element valueElem = null;
/*     */         
/*  50 */         List<?> _nodeList = entryElement.elements();
/*  51 */         int _len = _nodeList.size();
/*  52 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  54 */           Element elem = (Element)_nodeList.get(j);
/*  55 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  57 */             keyElem = elem;
/*     */           }
/*  59 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.StateSet")))
/*     */           {
/*  61 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  65 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  67 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         StateSet _v_;
/*     */         try
/*     */         {
/*  74 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  75 */           _v_ = new StateSet();
/*  76 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.visibleByTaskState.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/*  87 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "locations");
/*  88 */     if (collectionElement == null)
/*     */     {
/*  90 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  93 */     List<?> _nodeList = collectionElement.elements();
/*  94 */     int _len = _nodeList.size();
/*  95 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  97 */       Element elem = (Element)_nodeList.get(i);
/*  98 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.Loc"))
/*     */       {
/*     */         Loc _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 105 */           _v_ = new Loc();
/* 106 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 113 */         this.locations.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 117 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "regions");
/* 118 */     if (collectionElement == null)
/*     */     {
/* 120 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 123 */     List<?> _nodeList = collectionElement.elements();
/* 124 */     int _len = _nodeList.size();
/* 125 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 127 */       Element elem = (Element)_nodeList.get(i);
/* 128 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 135 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 142 */         this.regions.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 145 */     this.randomRegionProbBase = Integer.valueOf(rootElement.attributeValue("randomRegionProbBase")).intValue();
/*     */     
/* 147 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "randomRegions");
/* 148 */     if (mapTypeElement == null)
/*     */     {
/* 150 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 153 */     List<?> entryNodeList = mapTypeElement.elements();
/* 154 */     int entryLen = entryNodeList.size();
/* 155 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 157 */       Element entryElement = (Element)entryNodeList.get(i);
/* 158 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 163 */         Element keyElem = null;
/* 164 */         Element valueElem = null;
/*     */         
/* 166 */         List<?> _nodeList = entryElement.elements();
/* 167 */         int _len = _nodeList.size();
/* 168 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 170 */           Element elem = (Element)_nodeList.get(j);
/* 171 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 173 */             keyElem = elem;
/*     */           }
/* 175 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 177 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 181 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 183 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 190 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 191 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 198 */         this.randomRegions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 205 */     _os_.marshal(this.id);
/* 206 */     _os_.marshal(this.mapCfgid);
/* 207 */     _os_.compact_uint32(this.visibleByTaskState.size());
/* 208 */     for (java.util.Map.Entry<Integer, StateSet> _e_ : this.visibleByTaskState.entrySet())
/*     */     {
/* 210 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 211 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 213 */     _os_.compact_uint32(this.locations.size());
/* 214 */     for (Loc _v_ : this.locations)
/*     */     {
/* 216 */       _os_.marshal(_v_);
/*     */     }
/* 218 */     _os_.compact_uint32(this.regions.size());
/* 219 */     for (Integer _v_ : this.regions)
/*     */     {
/* 221 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 223 */     _os_.marshal(this.randomRegionProbBase);
/* 224 */     _os_.compact_uint32(this.randomRegions.size());
/* 225 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.randomRegions.entrySet())
/*     */     {
/* 227 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 228 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 230 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 235 */     this.id = _os_.unmarshal_int();
/* 236 */     this.mapCfgid = _os_.unmarshal_int();
/* 237 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 240 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 242 */       StateSet _v_ = new StateSet();
/* 243 */       _v_.unmarshal(_os_);
/* 244 */       this.visibleByTaskState.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 246 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 249 */       Loc _v_ = new Loc();
/* 250 */       _v_.unmarshal(_os_);
/* 251 */       this.locations.add(_v_);
/*     */     }
/* 253 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 256 */       int _v_ = _os_.unmarshal_int();
/* 257 */       this.regions.add(Integer.valueOf(_v_));
/*     */     }
/* 259 */     this.randomRegionProbBase = _os_.unmarshal_int();
/* 260 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 263 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 265 */       int _v_ = _os_.unmarshal_int();
/* 266 */       this.randomRegions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 268 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 273 */     String path = dir + "mzm.gsp.map.confbean.SMapItemConfig.xml";
/*     */     
/*     */     try
/*     */     {
/* 277 */       all = new HashMap();
/* 278 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 279 */       org.dom4j.Document doc = reader.read(new File(path));
/* 280 */       Element root = doc.getRootElement();
/* 281 */       List<?> nodeList = root.elements();
/* 282 */       int len = nodeList.size();
/* 283 */       for (int i = 0; i < len; i++)
/*     */       {
/* 285 */         Element elem = (Element)nodeList.get(i);
/* 286 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapItemConfig"))
/*     */         {
/*     */ 
/* 289 */           SMapItemConfig obj = new SMapItemConfig();
/* 290 */           obj.loadFromXml(elem);
/* 291 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 292 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 297 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMapItemConfig> all)
/*     */   {
/* 303 */     String path = dir + "mzm.gsp.map.confbean.SMapItemConfig.xml";
/*     */     
/*     */     try
/*     */     {
/* 307 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 308 */       org.dom4j.Document doc = reader.read(new File(path));
/* 309 */       Element root = doc.getRootElement();
/* 310 */       List<?> nodeList = root.elements();
/* 311 */       int len = nodeList.size();
/* 312 */       for (int i = 0; i < len; i++)
/*     */       {
/* 314 */         Element elem = (Element)nodeList.get(i);
/* 315 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapItemConfig"))
/*     */         {
/*     */ 
/* 318 */           SMapItemConfig obj = new SMapItemConfig();
/* 319 */           obj.loadFromXml(elem);
/* 320 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 321 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 326 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 332 */     all = new HashMap();
/*     */     
/* 334 */     String path = dir + "mzm.gsp.map.confbean.SMapItemConfig.bny";
/*     */     try
/*     */     {
/* 337 */       File file = new File(path);
/* 338 */       if (file.exists())
/*     */       {
/* 340 */         byte[] bytes = new byte['Ѐ'];
/* 341 */         FileInputStream fis = new FileInputStream(file);
/* 342 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 343 */         int len = 0;
/* 344 */         while ((len = fis.read(bytes)) > 0)
/* 345 */           baos.write(bytes, 0, len);
/* 346 */         fis.close();
/* 347 */         bytes = baos.toByteArray();
/* 348 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 349 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 351 */           _os_.unmarshal_int();
/* 352 */           _os_.unmarshal_int();
/* 353 */           _os_.unmarshal_int();
/*     */         }
/* 355 */         _os_.unmarshal_int();
/* 356 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 359 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 361 */           SMapItemConfig _v_ = new SMapItemConfig();
/* 362 */           _v_.unmarshal(_os_);
/* 363 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 364 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 369 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 374 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMapItemConfig> all)
/*     */   {
/* 381 */     String path = dir + "mzm.gsp.map.confbean.SMapItemConfig.bny";
/*     */     try
/*     */     {
/* 384 */       File file = new File(path);
/* 385 */       if (file.exists())
/*     */       {
/* 387 */         byte[] bytes = new byte['Ѐ'];
/* 388 */         FileInputStream fis = new FileInputStream(file);
/* 389 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 390 */         int len = 0;
/* 391 */         while ((len = fis.read(bytes)) > 0)
/* 392 */           baos.write(bytes, 0, len);
/* 393 */         fis.close();
/* 394 */         bytes = baos.toByteArray();
/* 395 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 396 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 398 */           _os_.unmarshal_int();
/* 399 */           _os_.unmarshal_int();
/* 400 */           _os_.unmarshal_int();
/*     */         }
/* 402 */         _os_.unmarshal_int();
/* 403 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 406 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 408 */           SMapItemConfig _v_ = new SMapItemConfig();
/* 409 */           _v_.unmarshal(_os_);
/* 410 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 411 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 416 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 421 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMapItemConfig getOld(int key)
/*     */   {
/* 429 */     return (SMapItemConfig)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMapItemConfig get(int key)
/*     */   {
/* 434 */     return (SMapItemConfig)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapItemConfig> getOldAll()
/*     */   {
/* 439 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapItemConfig> getAll()
/*     */   {
/* 444 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMapItemConfig> newAll)
/*     */   {
/* 449 */     oldAll = all;
/* 450 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 455 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapItemConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */