/*     */ package mzm.gsp.pet.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class STPet2Prop implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STPet2Prop> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STPet2Prop> all = null;
/*     */   
/*     */   public int petId;
/*  19 */   public HashMap<Integer, Double> bornPropMap = new HashMap();
/*  20 */   public HashMap<Integer, Integer> maxZiZhiLimit = new HashMap();
/*  21 */   public HashMap<Integer, Integer> minZiZhiLimit = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.petId = Integer.valueOf(rootElement.attributeValue("petId")).intValue();
/*     */     
/*  27 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "bornPropMap");
/*  28 */     if (mapTypeElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  33 */     List<?> entryNodeList = mapTypeElement.elements();
/*  34 */     int entryLen = entryNodeList.size();
/*  35 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  37 */       Element entryElement = (Element)entryNodeList.get(i);
/*  38 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  43 */         Element keyElem = null;
/*  44 */         Element valueElem = null;
/*     */         
/*  46 */         List<?> _nodeList = entryElement.elements();
/*  47 */         int _len = _nodeList.size();
/*  48 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  50 */           Element elem = (Element)_nodeList.get(j);
/*  51 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  53 */             keyElem = elem;
/*     */           }
/*  55 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("float")))
/*     */           {
/*  57 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  61 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  63 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         double _v_;
/*     */         try
/*     */         {
/*  70 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  71 */           _v_ = Double.valueOf(valueElem.getText()).doubleValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  78 */         this.bornPropMap.put(Integer.valueOf(_k_), Double.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  82 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "maxZiZhiLimit");
/*  83 */     if (mapTypeElement == null)
/*     */     {
/*  85 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  88 */     List<?> entryNodeList = mapTypeElement.elements();
/*  89 */     int entryLen = entryNodeList.size();
/*  90 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  92 */       Element entryElement = (Element)entryNodeList.get(i);
/*  93 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  98 */         Element keyElem = null;
/*  99 */         Element valueElem = null;
/*     */         
/* 101 */         List<?> _nodeList = entryElement.elements();
/* 102 */         int _len = _nodeList.size();
/* 103 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 105 */           Element elem = (Element)_nodeList.get(j);
/* 106 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 108 */             keyElem = elem;
/*     */           }
/* 110 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 112 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 116 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 118 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 125 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 126 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 133 */         this.maxZiZhiLimit.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 137 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "minZiZhiLimit");
/* 138 */     if (mapTypeElement == null)
/*     */     {
/* 140 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 143 */     List<?> entryNodeList = mapTypeElement.elements();
/* 144 */     int entryLen = entryNodeList.size();
/* 145 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 147 */       Element entryElement = (Element)entryNodeList.get(i);
/* 148 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 153 */         Element keyElem = null;
/* 154 */         Element valueElem = null;
/*     */         
/* 156 */         List<?> _nodeList = entryElement.elements();
/* 157 */         int _len = _nodeList.size();
/* 158 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 160 */           Element elem = (Element)_nodeList.get(j);
/* 161 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 163 */             keyElem = elem;
/*     */           }
/* 165 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 167 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 171 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 173 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 180 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 181 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 188 */         this.minZiZhiLimit.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 195 */     _os_.marshal(this.petId);
/* 196 */     _os_.compact_uint32(this.bornPropMap.size());
/* 197 */     for (Map.Entry<Integer, Double> _e_ : this.bornPropMap.entrySet())
/*     */     {
/* 199 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 200 */       _os_.marshal(((Double)_e_.getValue()).doubleValue());
/*     */     }
/* 202 */     _os_.compact_uint32(this.maxZiZhiLimit.size());
/* 203 */     for (Map.Entry<Integer, Integer> _e_ : this.maxZiZhiLimit.entrySet())
/*     */     {
/* 205 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 206 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 208 */     _os_.compact_uint32(this.minZiZhiLimit.size());
/* 209 */     for (Map.Entry<Integer, Integer> _e_ : this.minZiZhiLimit.entrySet())
/*     */     {
/* 211 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 212 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 214 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 219 */     this.petId = _os_.unmarshal_int();
/* 220 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 223 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 225 */       double _v_ = _os_.unmarshal_float();
/* 226 */       this.bornPropMap.put(Integer.valueOf(_k_), Double.valueOf(_v_));
/*     */     }
/* 228 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 231 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 233 */       int _v_ = _os_.unmarshal_int();
/* 234 */       this.maxZiZhiLimit.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 236 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 239 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 241 */       int _v_ = _os_.unmarshal_int();
/* 242 */       this.minZiZhiLimit.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 244 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 249 */     String path = dir + "mzm.gsp.pet.confbean.STPet2Prop.xml";
/*     */     
/*     */     try
/*     */     {
/* 253 */       all = new HashMap();
/* 254 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 255 */       org.dom4j.Document doc = reader.read(new File(path));
/* 256 */       Element root = doc.getRootElement();
/* 257 */       List<?> nodeList = root.elements();
/* 258 */       int len = nodeList.size();
/* 259 */       for (int i = 0; i < len; i++)
/*     */       {
/* 261 */         Element elem = (Element)nodeList.get(i);
/* 262 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.STPet2Prop"))
/*     */         {
/*     */ 
/* 265 */           STPet2Prop obj = new STPet2Prop();
/* 266 */           obj.loadFromXml(elem);
/* 267 */           if (all.put(Integer.valueOf(obj.petId), obj) != null) {
/* 268 */             throw new RuntimeException("duplicate key : " + obj.petId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 273 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STPet2Prop> all)
/*     */   {
/* 279 */     String path = dir + "mzm.gsp.pet.confbean.STPet2Prop.xml";
/*     */     
/*     */     try
/*     */     {
/* 283 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 284 */       org.dom4j.Document doc = reader.read(new File(path));
/* 285 */       Element root = doc.getRootElement();
/* 286 */       List<?> nodeList = root.elements();
/* 287 */       int len = nodeList.size();
/* 288 */       for (int i = 0; i < len; i++)
/*     */       {
/* 290 */         Element elem = (Element)nodeList.get(i);
/* 291 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.STPet2Prop"))
/*     */         {
/*     */ 
/* 294 */           STPet2Prop obj = new STPet2Prop();
/* 295 */           obj.loadFromXml(elem);
/* 296 */           if (all.put(Integer.valueOf(obj.petId), obj) != null) {
/* 297 */             throw new RuntimeException("duplicate key : " + obj.petId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 302 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 308 */     all = new HashMap();
/*     */     
/* 310 */     String path = dir + "mzm.gsp.pet.confbean.STPet2Prop.bny";
/*     */     try
/*     */     {
/* 313 */       File file = new File(path);
/* 314 */       if (file.exists())
/*     */       {
/* 316 */         byte[] bytes = new byte['Ѐ'];
/* 317 */         FileInputStream fis = new FileInputStream(file);
/* 318 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 319 */         int len = 0;
/* 320 */         while ((len = fis.read(bytes)) > 0)
/* 321 */           baos.write(bytes, 0, len);
/* 322 */         fis.close();
/* 323 */         bytes = baos.toByteArray();
/* 324 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 325 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 327 */           _os_.unmarshal_int();
/* 328 */           _os_.unmarshal_int();
/* 329 */           _os_.unmarshal_int();
/*     */         }
/* 331 */         _os_.unmarshal_int();
/* 332 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 335 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 337 */           STPet2Prop _v_ = new STPet2Prop();
/* 338 */           _v_.unmarshal(_os_);
/* 339 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 340 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 345 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 350 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STPet2Prop> all)
/*     */   {
/* 357 */     String path = dir + "mzm.gsp.pet.confbean.STPet2Prop.bny";
/*     */     try
/*     */     {
/* 360 */       File file = new File(path);
/* 361 */       if (file.exists())
/*     */       {
/* 363 */         byte[] bytes = new byte['Ѐ'];
/* 364 */         FileInputStream fis = new FileInputStream(file);
/* 365 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 366 */         int len = 0;
/* 367 */         while ((len = fis.read(bytes)) > 0)
/* 368 */           baos.write(bytes, 0, len);
/* 369 */         fis.close();
/* 370 */         bytes = baos.toByteArray();
/* 371 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 372 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 374 */           _os_.unmarshal_int();
/* 375 */           _os_.unmarshal_int();
/* 376 */           _os_.unmarshal_int();
/*     */         }
/* 378 */         _os_.unmarshal_int();
/* 379 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 382 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 384 */           STPet2Prop _v_ = new STPet2Prop();
/* 385 */           _v_.unmarshal(_os_);
/* 386 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 387 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 392 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 397 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STPet2Prop getOld(int key)
/*     */   {
/* 405 */     return (STPet2Prop)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STPet2Prop get(int key)
/*     */   {
/* 410 */     return (STPet2Prop)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STPet2Prop> getOldAll()
/*     */   {
/* 415 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STPet2Prop> getAll()
/*     */   {
/* 420 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STPet2Prop> newAll)
/*     */   {
/* 425 */     oldAll = all;
/* 426 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 431 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\STPet2Prop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */