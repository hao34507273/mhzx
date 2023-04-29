/*     */ package mzm.gsp.crossbattle.confbean;
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
/*     */ public class SCrossBattleFinalServerAwardOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCrossBattleFinalServerAwardOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCrossBattleFinalServerAwardOriginalCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int open_interval_day_after_activity_end;
/*     */   public int gift_item_min_level;
/*     */   public int champion_buff_last_day;
/*     */   public int second_place_buff_last_day;
/*     */   public int third_place_buff_last_day;
/*     */   public int champion_award_item_mail_cfg_id;
/*     */   public int second_place_award_item_mail_cfg_id;
/*     */   public int third_place_award_item_mail_cfg_id;
/*  27 */   public ArrayList<ChampionBuffBean> champion_buff_list = new ArrayList();
/*  28 */   public ArrayList<ChampionItemBean> champion_item_list = new ArrayList();
/*  29 */   public ArrayList<SecondPlaceBuffBean> second_place_buff_list = new ArrayList();
/*  30 */   public ArrayList<SecondPlaceItemBean> second_place_item_list = new ArrayList();
/*  31 */   public ArrayList<ThirdPlaceBuffBean> third_place_buff_list = new ArrayList();
/*  32 */   public ArrayList<ThirdPlaceItemBean> third_place_item_list = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  37 */     this.open_interval_day_after_activity_end = Integer.valueOf(rootElement.attributeValue("open_interval_day_after_activity_end")).intValue();
/*  38 */     this.gift_item_min_level = Integer.valueOf(rootElement.attributeValue("gift_item_min_level")).intValue();
/*  39 */     this.champion_buff_last_day = Integer.valueOf(rootElement.attributeValue("champion_buff_last_day")).intValue();
/*  40 */     this.second_place_buff_last_day = Integer.valueOf(rootElement.attributeValue("second_place_buff_last_day")).intValue();
/*  41 */     this.third_place_buff_last_day = Integer.valueOf(rootElement.attributeValue("third_place_buff_last_day")).intValue();
/*  42 */     this.champion_award_item_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("champion_award_item_mail_cfg_id")).intValue();
/*  43 */     this.second_place_award_item_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("second_place_award_item_mail_cfg_id")).intValue();
/*  44 */     this.third_place_award_item_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("third_place_award_item_mail_cfg_id")).intValue();
/*     */     
/*  46 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "champion_buff_list");
/*  47 */     if (collectionElement == null)
/*     */     {
/*  49 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  52 */     List<?> _nodeList = collectionElement.elements();
/*  53 */     int _len = _nodeList.size();
/*  54 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  56 */       Element elem = (Element)_nodeList.get(i);
/*  57 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.ChampionBuffBean"))
/*     */       {
/*     */         ChampionBuffBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  64 */           _v_ = new ChampionBuffBean();
/*  65 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  72 */         this.champion_buff_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  76 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "champion_item_list");
/*  77 */     if (collectionElement == null)
/*     */     {
/*  79 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  82 */     List<?> _nodeList = collectionElement.elements();
/*  83 */     int _len = _nodeList.size();
/*  84 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  86 */       Element elem = (Element)_nodeList.get(i);
/*  87 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.ChampionItemBean"))
/*     */       {
/*     */         ChampionItemBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  94 */           _v_ = new ChampionItemBean();
/*  95 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 102 */         this.champion_item_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 106 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "second_place_buff_list");
/* 107 */     if (collectionElement == null)
/*     */     {
/* 109 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 112 */     List<?> _nodeList = collectionElement.elements();
/* 113 */     int _len = _nodeList.size();
/* 114 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 116 */       Element elem = (Element)_nodeList.get(i);
/* 117 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SecondPlaceBuffBean"))
/*     */       {
/*     */         SecondPlaceBuffBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 124 */           _v_ = new SecondPlaceBuffBean();
/* 125 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 132 */         this.second_place_buff_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 136 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "second_place_item_list");
/* 137 */     if (collectionElement == null)
/*     */     {
/* 139 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 142 */     List<?> _nodeList = collectionElement.elements();
/* 143 */     int _len = _nodeList.size();
/* 144 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 146 */       Element elem = (Element)_nodeList.get(i);
/* 147 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SecondPlaceItemBean"))
/*     */       {
/*     */         SecondPlaceItemBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 154 */           _v_ = new SecondPlaceItemBean();
/* 155 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 162 */         this.second_place_item_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 166 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "third_place_buff_list");
/* 167 */     if (collectionElement == null)
/*     */     {
/* 169 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 172 */     List<?> _nodeList = collectionElement.elements();
/* 173 */     int _len = _nodeList.size();
/* 174 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 176 */       Element elem = (Element)_nodeList.get(i);
/* 177 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.ThirdPlaceBuffBean"))
/*     */       {
/*     */         ThirdPlaceBuffBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 184 */           _v_ = new ThirdPlaceBuffBean();
/* 185 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 192 */         this.third_place_buff_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 196 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "third_place_item_list");
/* 197 */     if (collectionElement == null)
/*     */     {
/* 199 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 202 */     List<?> _nodeList = collectionElement.elements();
/* 203 */     int _len = _nodeList.size();
/* 204 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 206 */       Element elem = (Element)_nodeList.get(i);
/* 207 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.ThirdPlaceItemBean"))
/*     */       {
/*     */         ThirdPlaceItemBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 214 */           _v_ = new ThirdPlaceItemBean();
/* 215 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 222 */         this.third_place_item_list.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 229 */     _os_.marshal(this.activity_cfg_id);
/* 230 */     _os_.marshal(this.open_interval_day_after_activity_end);
/* 231 */     _os_.marshal(this.gift_item_min_level);
/* 232 */     _os_.marshal(this.champion_buff_last_day);
/* 233 */     _os_.marshal(this.second_place_buff_last_day);
/* 234 */     _os_.marshal(this.third_place_buff_last_day);
/* 235 */     _os_.marshal(this.champion_award_item_mail_cfg_id);
/* 236 */     _os_.marshal(this.second_place_award_item_mail_cfg_id);
/* 237 */     _os_.marshal(this.third_place_award_item_mail_cfg_id);
/* 238 */     _os_.compact_uint32(this.champion_buff_list.size());
/* 239 */     for (ChampionBuffBean _v_ : this.champion_buff_list)
/*     */     {
/* 241 */       _os_.marshal(_v_);
/*     */     }
/* 243 */     _os_.compact_uint32(this.champion_item_list.size());
/* 244 */     for (ChampionItemBean _v_ : this.champion_item_list)
/*     */     {
/* 246 */       _os_.marshal(_v_);
/*     */     }
/* 248 */     _os_.compact_uint32(this.second_place_buff_list.size());
/* 249 */     for (SecondPlaceBuffBean _v_ : this.second_place_buff_list)
/*     */     {
/* 251 */       _os_.marshal(_v_);
/*     */     }
/* 253 */     _os_.compact_uint32(this.second_place_item_list.size());
/* 254 */     for (SecondPlaceItemBean _v_ : this.second_place_item_list)
/*     */     {
/* 256 */       _os_.marshal(_v_);
/*     */     }
/* 258 */     _os_.compact_uint32(this.third_place_buff_list.size());
/* 259 */     for (ThirdPlaceBuffBean _v_ : this.third_place_buff_list)
/*     */     {
/* 261 */       _os_.marshal(_v_);
/*     */     }
/* 263 */     _os_.compact_uint32(this.third_place_item_list.size());
/* 264 */     for (ThirdPlaceItemBean _v_ : this.third_place_item_list)
/*     */     {
/* 266 */       _os_.marshal(_v_);
/*     */     }
/* 268 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 273 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 274 */     this.open_interval_day_after_activity_end = _os_.unmarshal_int();
/* 275 */     this.gift_item_min_level = _os_.unmarshal_int();
/* 276 */     this.champion_buff_last_day = _os_.unmarshal_int();
/* 277 */     this.second_place_buff_last_day = _os_.unmarshal_int();
/* 278 */     this.third_place_buff_last_day = _os_.unmarshal_int();
/* 279 */     this.champion_award_item_mail_cfg_id = _os_.unmarshal_int();
/* 280 */     this.second_place_award_item_mail_cfg_id = _os_.unmarshal_int();
/* 281 */     this.third_place_award_item_mail_cfg_id = _os_.unmarshal_int();
/* 282 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 285 */       ChampionBuffBean _v_ = new ChampionBuffBean();
/* 286 */       _v_.unmarshal(_os_);
/* 287 */       this.champion_buff_list.add(_v_);
/*     */     }
/* 289 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 292 */       ChampionItemBean _v_ = new ChampionItemBean();
/* 293 */       _v_.unmarshal(_os_);
/* 294 */       this.champion_item_list.add(_v_);
/*     */     }
/* 296 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 299 */       SecondPlaceBuffBean _v_ = new SecondPlaceBuffBean();
/* 300 */       _v_.unmarshal(_os_);
/* 301 */       this.second_place_buff_list.add(_v_);
/*     */     }
/* 303 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 306 */       SecondPlaceItemBean _v_ = new SecondPlaceItemBean();
/* 307 */       _v_.unmarshal(_os_);
/* 308 */       this.second_place_item_list.add(_v_);
/*     */     }
/* 310 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 313 */       ThirdPlaceBuffBean _v_ = new ThirdPlaceBuffBean();
/* 314 */       _v_.unmarshal(_os_);
/* 315 */       this.third_place_buff_list.add(_v_);
/*     */     }
/* 317 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 320 */       ThirdPlaceItemBean _v_ = new ThirdPlaceItemBean();
/* 321 */       _v_.unmarshal(_os_);
/* 322 */       this.third_place_item_list.add(_v_);
/*     */     }
/* 324 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 329 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 333 */       all = new java.util.HashMap();
/* 334 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 335 */       org.dom4j.Document doc = reader.read(new File(path));
/* 336 */       Element root = doc.getRootElement();
/* 337 */       List<?> nodeList = root.elements();
/* 338 */       int len = nodeList.size();
/* 339 */       for (int i = 0; i < len; i++)
/*     */       {
/* 341 */         Element elem = (Element)nodeList.get(i);
/* 342 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardOriginalCfg"))
/*     */         {
/*     */ 
/* 345 */           SCrossBattleFinalServerAwardOriginalCfg obj = new SCrossBattleFinalServerAwardOriginalCfg();
/* 346 */           obj.loadFromXml(elem);
/* 347 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 348 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 353 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCrossBattleFinalServerAwardOriginalCfg> all)
/*     */   {
/* 359 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 363 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 364 */       org.dom4j.Document doc = reader.read(new File(path));
/* 365 */       Element root = doc.getRootElement();
/* 366 */       List<?> nodeList = root.elements();
/* 367 */       int len = nodeList.size();
/* 368 */       for (int i = 0; i < len; i++)
/*     */       {
/* 370 */         Element elem = (Element)nodeList.get(i);
/* 371 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardOriginalCfg"))
/*     */         {
/*     */ 
/* 374 */           SCrossBattleFinalServerAwardOriginalCfg obj = new SCrossBattleFinalServerAwardOriginalCfg();
/* 375 */           obj.loadFromXml(elem);
/* 376 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 377 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 382 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 388 */     all = new java.util.HashMap();
/*     */     
/* 390 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardOriginalCfg.bny";
/*     */     try
/*     */     {
/* 393 */       File file = new File(path);
/* 394 */       if (file.exists())
/*     */       {
/* 396 */         byte[] bytes = new byte['Ѐ'];
/* 397 */         FileInputStream fis = new FileInputStream(file);
/* 398 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 399 */         int len = 0;
/* 400 */         while ((len = fis.read(bytes)) > 0)
/* 401 */           baos.write(bytes, 0, len);
/* 402 */         fis.close();
/* 403 */         bytes = baos.toByteArray();
/* 404 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 405 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 407 */           _os_.unmarshal_int();
/* 408 */           _os_.unmarshal_int();
/* 409 */           _os_.unmarshal_int();
/*     */         }
/* 411 */         _os_.unmarshal_int();
/* 412 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 415 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 417 */           SCrossBattleFinalServerAwardOriginalCfg _v_ = new SCrossBattleFinalServerAwardOriginalCfg();
/* 418 */           _v_.unmarshal(_os_);
/* 419 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 420 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 425 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 430 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCrossBattleFinalServerAwardOriginalCfg> all)
/*     */   {
/* 437 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardOriginalCfg.bny";
/*     */     try
/*     */     {
/* 440 */       File file = new File(path);
/* 441 */       if (file.exists())
/*     */       {
/* 443 */         byte[] bytes = new byte['Ѐ'];
/* 444 */         FileInputStream fis = new FileInputStream(file);
/* 445 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 446 */         int len = 0;
/* 447 */         while ((len = fis.read(bytes)) > 0)
/* 448 */           baos.write(bytes, 0, len);
/* 449 */         fis.close();
/* 450 */         bytes = baos.toByteArray();
/* 451 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 452 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 454 */           _os_.unmarshal_int();
/* 455 */           _os_.unmarshal_int();
/* 456 */           _os_.unmarshal_int();
/*     */         }
/* 458 */         _os_.unmarshal_int();
/* 459 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 462 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 464 */           SCrossBattleFinalServerAwardOriginalCfg _v_ = new SCrossBattleFinalServerAwardOriginalCfg();
/* 465 */           _v_.unmarshal(_os_);
/* 466 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 467 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 472 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 477 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCrossBattleFinalServerAwardOriginalCfg getOld(int key)
/*     */   {
/* 485 */     return (SCrossBattleFinalServerAwardOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCrossBattleFinalServerAwardOriginalCfg get(int key)
/*     */   {
/* 490 */     return (SCrossBattleFinalServerAwardOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleFinalServerAwardOriginalCfg> getOldAll()
/*     */   {
/* 495 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleFinalServerAwardOriginalCfg> getAll()
/*     */   {
/* 500 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCrossBattleFinalServerAwardOriginalCfg> newAll)
/*     */   {
/* 505 */     oldAll = all;
/* 506 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 511 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattleFinalServerAwardOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */