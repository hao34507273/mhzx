/*     */ package mzm.gsp.alllotto.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SAllLottoCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAllLottoCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAllLottoCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int server_level_limit;
/*     */   public int award_mail_cfg_id;
/*  21 */   public HashMap<Integer, SAllLottoWarmUpInfo> warm_up_infos = new HashMap();
/*  22 */   public TreeMap<Integer, SAllLottoTurnInfo> turn_infos = new TreeMap();
/*  23 */   public TreeMap<Integer, Integer> turn_time_infos = new TreeMap();
/*  24 */   public TreeMap<Integer, SAllLottoConditionInfo> condition_infos = new TreeMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  29 */     this.server_level_limit = Integer.valueOf(rootElement.attributeValue("server_level_limit")).intValue();
/*  30 */     this.award_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("award_mail_cfg_id")).intValue();
/*     */     
/*  32 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "warm_up_infos");
/*  33 */     if (mapTypeElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  38 */     List<?> entryNodeList = mapTypeElement.elements();
/*  39 */     int entryLen = entryNodeList.size();
/*  40 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  42 */       Element entryElement = (Element)entryNodeList.get(i);
/*  43 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  48 */         Element keyElem = null;
/*  49 */         Element valueElem = null;
/*     */         
/*  51 */         List<?> _nodeList = entryElement.elements();
/*  52 */         int _len = _nodeList.size();
/*  53 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  55 */           Element elem = (Element)_nodeList.get(j);
/*  56 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  58 */             keyElem = elem;
/*     */           }
/*  60 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.alllotto.confbean.SAllLottoWarmUpInfo")))
/*     */           {
/*  62 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  66 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  68 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SAllLottoWarmUpInfo _v_;
/*     */         try
/*     */         {
/*  75 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  76 */           _v_ = new SAllLottoWarmUpInfo();
/*  77 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  84 */         this.warm_up_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/*  88 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "turn_infos");
/*  89 */     if (mapTypeElement == null)
/*     */     {
/*  91 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  94 */     List<?> entryNodeList = mapTypeElement.elements();
/*  95 */     int entryLen = entryNodeList.size();
/*  96 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  98 */       Element entryElement = (Element)entryNodeList.get(i);
/*  99 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 104 */         Element keyElem = null;
/* 105 */         Element valueElem = null;
/*     */         
/* 107 */         List<?> _nodeList = entryElement.elements();
/* 108 */         int _len = _nodeList.size();
/* 109 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 111 */           Element elem = (Element)_nodeList.get(j);
/* 112 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 114 */             keyElem = elem;
/*     */           }
/* 116 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.alllotto.confbean.SAllLottoTurnInfo")))
/*     */           {
/* 118 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 122 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 124 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SAllLottoTurnInfo _v_;
/*     */         try
/*     */         {
/* 131 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 132 */           _v_ = new SAllLottoTurnInfo();
/* 133 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 140 */         this.turn_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/* 144 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "turn_time_infos");
/* 145 */     if (mapTypeElement == null)
/*     */     {
/* 147 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 150 */     List<?> entryNodeList = mapTypeElement.elements();
/* 151 */     int entryLen = entryNodeList.size();
/* 152 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 154 */       Element entryElement = (Element)entryNodeList.get(i);
/* 155 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 160 */         Element keyElem = null;
/* 161 */         Element valueElem = null;
/*     */         
/* 163 */         List<?> _nodeList = entryElement.elements();
/* 164 */         int _len = _nodeList.size();
/* 165 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 167 */           Element elem = (Element)_nodeList.get(j);
/* 168 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 170 */             keyElem = elem;
/*     */           }
/* 172 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 174 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 178 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 180 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 187 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 188 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 195 */         this.turn_time_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 199 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "condition_infos");
/* 200 */     if (mapTypeElement == null)
/*     */     {
/* 202 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 205 */     List<?> entryNodeList = mapTypeElement.elements();
/* 206 */     int entryLen = entryNodeList.size();
/* 207 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 209 */       Element entryElement = (Element)entryNodeList.get(i);
/* 210 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 215 */         Element keyElem = null;
/* 216 */         Element valueElem = null;
/*     */         
/* 218 */         List<?> _nodeList = entryElement.elements();
/* 219 */         int _len = _nodeList.size();
/* 220 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 222 */           Element elem = (Element)_nodeList.get(j);
/* 223 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 225 */             keyElem = elem;
/*     */           }
/* 227 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.alllotto.confbean.SAllLottoConditionInfo")))
/*     */           {
/* 229 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 233 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 235 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SAllLottoConditionInfo _v_;
/*     */         try
/*     */         {
/* 242 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 243 */           _v_ = new SAllLottoConditionInfo();
/* 244 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 251 */         this.condition_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 258 */     _os_.marshal(this.activity_cfg_id);
/* 259 */     _os_.marshal(this.server_level_limit);
/* 260 */     _os_.marshal(this.award_mail_cfg_id);
/* 261 */     _os_.compact_uint32(this.warm_up_infos.size());
/* 262 */     for (Map.Entry<Integer, SAllLottoWarmUpInfo> _e_ : this.warm_up_infos.entrySet())
/*     */     {
/* 264 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 265 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 267 */     _os_.compact_uint32(this.turn_infos.size());
/* 268 */     for (Map.Entry<Integer, SAllLottoTurnInfo> _e_ : this.turn_infos.entrySet())
/*     */     {
/* 270 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 271 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 273 */     _os_.compact_uint32(this.turn_time_infos.size());
/* 274 */     for (Map.Entry<Integer, Integer> _e_ : this.turn_time_infos.entrySet())
/*     */     {
/* 276 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 277 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 279 */     _os_.compact_uint32(this.condition_infos.size());
/* 280 */     for (Map.Entry<Integer, SAllLottoConditionInfo> _e_ : this.condition_infos.entrySet())
/*     */     {
/* 282 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 283 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 285 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 290 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 291 */     this.server_level_limit = _os_.unmarshal_int();
/* 292 */     this.award_mail_cfg_id = _os_.unmarshal_int();
/* 293 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 296 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 298 */       SAllLottoWarmUpInfo _v_ = new SAllLottoWarmUpInfo();
/* 299 */       _v_.unmarshal(_os_);
/* 300 */       this.warm_up_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 302 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 305 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 307 */       SAllLottoTurnInfo _v_ = new SAllLottoTurnInfo();
/* 308 */       _v_.unmarshal(_os_);
/* 309 */       this.turn_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 311 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 314 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 316 */       int _v_ = _os_.unmarshal_int();
/* 317 */       this.turn_time_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 319 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 322 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 324 */       SAllLottoConditionInfo _v_ = new SAllLottoConditionInfo();
/* 325 */       _v_.unmarshal(_os_);
/* 326 */       this.condition_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 328 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 333 */     String path = dir + "mzm.gsp.alllotto.confbean.SAllLottoCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 337 */       all = new HashMap();
/* 338 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 339 */       org.dom4j.Document doc = reader.read(new java.io.File(path));
/* 340 */       Element root = doc.getRootElement();
/* 341 */       List<?> nodeList = root.elements();
/* 342 */       int len = nodeList.size();
/* 343 */       for (int i = 0; i < len; i++)
/*     */       {
/* 345 */         Element elem = (Element)nodeList.get(i);
/* 346 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.alllotto.confbean.SAllLottoCfg"))
/*     */         {
/*     */ 
/* 349 */           SAllLottoCfg obj = new SAllLottoCfg();
/* 350 */           obj.loadFromXml(elem);
/* 351 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 352 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 357 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAllLottoCfg> all)
/*     */   {
/* 363 */     String path = dir + "mzm.gsp.alllotto.confbean.SAllLottoCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 367 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 368 */       org.dom4j.Document doc = reader.read(new java.io.File(path));
/* 369 */       Element root = doc.getRootElement();
/* 370 */       List<?> nodeList = root.elements();
/* 371 */       int len = nodeList.size();
/* 372 */       for (int i = 0; i < len; i++)
/*     */       {
/* 374 */         Element elem = (Element)nodeList.get(i);
/* 375 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.alllotto.confbean.SAllLottoCfg"))
/*     */         {
/*     */ 
/* 378 */           SAllLottoCfg obj = new SAllLottoCfg();
/* 379 */           obj.loadFromXml(elem);
/* 380 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 381 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 386 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 392 */     all = new HashMap();
/*     */     
/* 394 */     String path = dir + "mzm.gsp.alllotto.confbean.SAllLottoCfg.bny";
/*     */     try
/*     */     {
/* 397 */       java.io.File file = new java.io.File(path);
/* 398 */       if (file.exists())
/*     */       {
/* 400 */         byte[] bytes = new byte['Ѐ'];
/* 401 */         FileInputStream fis = new FileInputStream(file);
/* 402 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 403 */         int len = 0;
/* 404 */         while ((len = fis.read(bytes)) > 0)
/* 405 */           baos.write(bytes, 0, len);
/* 406 */         fis.close();
/* 407 */         bytes = baos.toByteArray();
/* 408 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 409 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 411 */           _os_.unmarshal_int();
/* 412 */           _os_.unmarshal_int();
/* 413 */           _os_.unmarshal_int();
/*     */         }
/* 415 */         _os_.unmarshal_int();
/* 416 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 419 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 421 */           SAllLottoCfg _v_ = new SAllLottoCfg();
/* 422 */           _v_.unmarshal(_os_);
/* 423 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 424 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 429 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 434 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAllLottoCfg> all)
/*     */   {
/* 441 */     String path = dir + "mzm.gsp.alllotto.confbean.SAllLottoCfg.bny";
/*     */     try
/*     */     {
/* 444 */       java.io.File file = new java.io.File(path);
/* 445 */       if (file.exists())
/*     */       {
/* 447 */         byte[] bytes = new byte['Ѐ'];
/* 448 */         FileInputStream fis = new FileInputStream(file);
/* 449 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 450 */         int len = 0;
/* 451 */         while ((len = fis.read(bytes)) > 0)
/* 452 */           baos.write(bytes, 0, len);
/* 453 */         fis.close();
/* 454 */         bytes = baos.toByteArray();
/* 455 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 456 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 458 */           _os_.unmarshal_int();
/* 459 */           _os_.unmarshal_int();
/* 460 */           _os_.unmarshal_int();
/*     */         }
/* 462 */         _os_.unmarshal_int();
/* 463 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 466 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 468 */           SAllLottoCfg _v_ = new SAllLottoCfg();
/* 469 */           _v_.unmarshal(_os_);
/* 470 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 471 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 476 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 481 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAllLottoCfg getOld(int key)
/*     */   {
/* 489 */     return (SAllLottoCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAllLottoCfg get(int key)
/*     */   {
/* 494 */     return (SAllLottoCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAllLottoCfg> getOldAll()
/*     */   {
/* 499 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAllLottoCfg> getAll()
/*     */   {
/* 504 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAllLottoCfg> newAll)
/*     */   {
/* 509 */     oldAll = all;
/* 510 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 515 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\confbean\SAllLottoCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */