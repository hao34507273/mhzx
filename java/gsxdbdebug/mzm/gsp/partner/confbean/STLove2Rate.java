/*     */ package mzm.gsp.partner.confbean;
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
/*     */ public class STLove2Rate implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STLove2Rate> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STLove2Rate> all = null;
/*     */   
/*     */   public int sPartnerLoveCfgId;
/*  19 */   public HashMap<Integer, Integer> love2rate = new HashMap();
/*     */   public int weightSum;
/*  21 */   public HashMap<Integer, LibInfo> libId2info = new HashMap();
/*  22 */   public HashMap<Integer, Integer> contentId2loveId = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.sPartnerLoveCfgId = Integer.valueOf(rootElement.attributeValue("sPartnerLoveCfgId")).intValue();
/*     */     
/*  28 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "love2rate");
/*  29 */     if (mapTypeElement == null)
/*     */     {
/*  31 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  34 */     List<?> entryNodeList = mapTypeElement.elements();
/*  35 */     int entryLen = entryNodeList.size();
/*  36 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  38 */       Element entryElement = (Element)entryNodeList.get(i);
/*  39 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  44 */         Element keyElem = null;
/*  45 */         Element valueElem = null;
/*     */         
/*  47 */         List<?> _nodeList = entryElement.elements();
/*  48 */         int _len = _nodeList.size();
/*  49 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  51 */           Element elem = (Element)_nodeList.get(j);
/*  52 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  54 */             keyElem = elem;
/*     */           }
/*  56 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  58 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  62 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  64 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  71 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  72 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  79 */         this.love2rate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  82 */     this.weightSum = Integer.valueOf(rootElement.attributeValue("weightSum")).intValue();
/*     */     
/*  84 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "libId2info");
/*  85 */     if (mapTypeElement == null)
/*     */     {
/*  87 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  90 */     List<?> entryNodeList = mapTypeElement.elements();
/*  91 */     int entryLen = entryNodeList.size();
/*  92 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  94 */       Element entryElement = (Element)entryNodeList.get(i);
/*  95 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 100 */         Element keyElem = null;
/* 101 */         Element valueElem = null;
/*     */         
/* 103 */         List<?> _nodeList = entryElement.elements();
/* 104 */         int _len = _nodeList.size();
/* 105 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 107 */           Element elem = (Element)_nodeList.get(j);
/* 108 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 110 */             keyElem = elem;
/*     */           }
/* 112 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.partner.confbean.LibInfo")))
/*     */           {
/* 114 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 118 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 120 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         LibInfo _v_;
/*     */         try
/*     */         {
/* 127 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 128 */           _v_ = new LibInfo();
/* 129 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 136 */         this.libId2info.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/* 140 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "contentId2loveId");
/* 141 */     if (mapTypeElement == null)
/*     */     {
/* 143 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 146 */     List<?> entryNodeList = mapTypeElement.elements();
/* 147 */     int entryLen = entryNodeList.size();
/* 148 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 150 */       Element entryElement = (Element)entryNodeList.get(i);
/* 151 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 156 */         Element keyElem = null;
/* 157 */         Element valueElem = null;
/*     */         
/* 159 */         List<?> _nodeList = entryElement.elements();
/* 160 */         int _len = _nodeList.size();
/* 161 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 163 */           Element elem = (Element)_nodeList.get(j);
/* 164 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 166 */             keyElem = elem;
/*     */           }
/* 168 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 170 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 174 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 176 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 183 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 184 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 191 */         this.contentId2loveId.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 198 */     _os_.marshal(this.sPartnerLoveCfgId);
/* 199 */     _os_.compact_uint32(this.love2rate.size());
/* 200 */     for (Map.Entry<Integer, Integer> _e_ : this.love2rate.entrySet())
/*     */     {
/* 202 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 203 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 205 */     _os_.marshal(this.weightSum);
/* 206 */     _os_.compact_uint32(this.libId2info.size());
/* 207 */     for (Map.Entry<Integer, LibInfo> _e_ : this.libId2info.entrySet())
/*     */     {
/* 209 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 210 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 212 */     _os_.compact_uint32(this.contentId2loveId.size());
/* 213 */     for (Map.Entry<Integer, Integer> _e_ : this.contentId2loveId.entrySet())
/*     */     {
/* 215 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 216 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 218 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 223 */     this.sPartnerLoveCfgId = _os_.unmarshal_int();
/* 224 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 227 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 229 */       int _v_ = _os_.unmarshal_int();
/* 230 */       this.love2rate.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 232 */     this.weightSum = _os_.unmarshal_int();
/* 233 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 236 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 238 */       LibInfo _v_ = new LibInfo();
/* 239 */       _v_.unmarshal(_os_);
/* 240 */       this.libId2info.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 242 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 245 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 247 */       int _v_ = _os_.unmarshal_int();
/* 248 */       this.contentId2loveId.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 250 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 255 */     String path = dir + "mzm.gsp.partner.confbean.STLove2Rate.xml";
/*     */     
/*     */     try
/*     */     {
/* 259 */       all = new HashMap();
/* 260 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 261 */       org.dom4j.Document doc = reader.read(new File(path));
/* 262 */       Element root = doc.getRootElement();
/* 263 */       List<?> nodeList = root.elements();
/* 264 */       int len = nodeList.size();
/* 265 */       for (int i = 0; i < len; i++)
/*     */       {
/* 267 */         Element elem = (Element)nodeList.get(i);
/* 268 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partner.confbean.STLove2Rate"))
/*     */         {
/*     */ 
/* 271 */           STLove2Rate obj = new STLove2Rate();
/* 272 */           obj.loadFromXml(elem);
/* 273 */           if (all.put(Integer.valueOf(obj.sPartnerLoveCfgId), obj) != null) {
/* 274 */             throw new RuntimeException("duplicate key : " + obj.sPartnerLoveCfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 279 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STLove2Rate> all)
/*     */   {
/* 285 */     String path = dir + "mzm.gsp.partner.confbean.STLove2Rate.xml";
/*     */     
/*     */     try
/*     */     {
/* 289 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 290 */       org.dom4j.Document doc = reader.read(new File(path));
/* 291 */       Element root = doc.getRootElement();
/* 292 */       List<?> nodeList = root.elements();
/* 293 */       int len = nodeList.size();
/* 294 */       for (int i = 0; i < len; i++)
/*     */       {
/* 296 */         Element elem = (Element)nodeList.get(i);
/* 297 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partner.confbean.STLove2Rate"))
/*     */         {
/*     */ 
/* 300 */           STLove2Rate obj = new STLove2Rate();
/* 301 */           obj.loadFromXml(elem);
/* 302 */           if (all.put(Integer.valueOf(obj.sPartnerLoveCfgId), obj) != null) {
/* 303 */             throw new RuntimeException("duplicate key : " + obj.sPartnerLoveCfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 308 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 314 */     all = new HashMap();
/*     */     
/* 316 */     String path = dir + "mzm.gsp.partner.confbean.STLove2Rate.bny";
/*     */     try
/*     */     {
/* 319 */       File file = new File(path);
/* 320 */       if (file.exists())
/*     */       {
/* 322 */         byte[] bytes = new byte['Ѐ'];
/* 323 */         FileInputStream fis = new FileInputStream(file);
/* 324 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 325 */         int len = 0;
/* 326 */         while ((len = fis.read(bytes)) > 0)
/* 327 */           baos.write(bytes, 0, len);
/* 328 */         fis.close();
/* 329 */         bytes = baos.toByteArray();
/* 330 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 331 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 333 */           _os_.unmarshal_int();
/* 334 */           _os_.unmarshal_int();
/* 335 */           _os_.unmarshal_int();
/*     */         }
/* 337 */         _os_.unmarshal_int();
/* 338 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 341 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 343 */           STLove2Rate _v_ = new STLove2Rate();
/* 344 */           _v_.unmarshal(_os_);
/* 345 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 346 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 351 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 356 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STLove2Rate> all)
/*     */   {
/* 363 */     String path = dir + "mzm.gsp.partner.confbean.STLove2Rate.bny";
/*     */     try
/*     */     {
/* 366 */       File file = new File(path);
/* 367 */       if (file.exists())
/*     */       {
/* 369 */         byte[] bytes = new byte['Ѐ'];
/* 370 */         FileInputStream fis = new FileInputStream(file);
/* 371 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 372 */         int len = 0;
/* 373 */         while ((len = fis.read(bytes)) > 0)
/* 374 */           baos.write(bytes, 0, len);
/* 375 */         fis.close();
/* 376 */         bytes = baos.toByteArray();
/* 377 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 378 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 380 */           _os_.unmarshal_int();
/* 381 */           _os_.unmarshal_int();
/* 382 */           _os_.unmarshal_int();
/*     */         }
/* 384 */         _os_.unmarshal_int();
/* 385 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 388 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 390 */           STLove2Rate _v_ = new STLove2Rate();
/* 391 */           _v_.unmarshal(_os_);
/* 392 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 393 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 398 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 403 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STLove2Rate getOld(int key)
/*     */   {
/* 411 */     return (STLove2Rate)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STLove2Rate get(int key)
/*     */   {
/* 416 */     return (STLove2Rate)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STLove2Rate> getOldAll()
/*     */   {
/* 421 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STLove2Rate> getAll()
/*     */   {
/* 426 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STLove2Rate> newAll)
/*     */   {
/* 431 */     oldAll = all;
/* 432 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 437 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\confbean\STLove2Rate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */