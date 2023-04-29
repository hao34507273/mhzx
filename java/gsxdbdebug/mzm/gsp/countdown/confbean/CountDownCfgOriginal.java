/*     */ package mzm.gsp.countdown.confbean;
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
/*     */ public class CountDownCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, CountDownCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, CountDownCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public String desc;
/*  21 */   public ArrayList<RemindMail> remaid_mails = new ArrayList();
/*     */   public int bulletin_begin_timestamp_year;
/*     */   public int bulletin_begin_timestamp_month;
/*     */   public int bulletin_begin_timestamp_day;
/*     */   public int bulletin_begin_timestamp_hour;
/*     */   public int bulletin_begin_timestamp_minute;
/*     */   public int bulletin_begin_timestamp_second;
/*     */   public int bulletin_interval;
/*     */   public int count_down_effect_id;
/*     */   public int count_down_time;
/*     */   public int festival_timestamp_year;
/*     */   public int festival_timestamp_month;
/*     */   public int festival_timestamp_day;
/*     */   public int festival_timestamp_hour;
/*     */   public int festival_timestamp_minute;
/*     */   public int festival_timestamp_second;
/*     */   public int festival_effect_id;
/*     */   public int festival_sound_id;
/*     */   public int festival_effect_play_time;
/*     */   public int red_packet_award_id;
/*     */   public int red_packet_icon_id;
/*     */   public String red_packet_desc;
/*     */   public int red_packet_valid_time;
/*     */   public int thank_mail_valid_time;
/*  45 */   public ArrayList<ThankMail> thanks_mails = new ArrayList();
/*     */   public int festival_to_start_play_interval;
/*     */   public int festival_to_stop_play_interval;
/*     */   public int map_effect_id;
/*  49 */   public ArrayList<Integer> map_cfg_ids = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  53 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  54 */     this.name = rootElement.attributeValue("name");
/*  55 */     this.desc = rootElement.attributeValue("desc");
/*     */     
/*  57 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "remaid_mails");
/*  58 */     if (collectionElement == null)
/*     */     {
/*  60 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  63 */     List<?> _nodeList = collectionElement.elements();
/*  64 */     int _len = _nodeList.size();
/*  65 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  67 */       Element elem = (Element)_nodeList.get(i);
/*  68 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.countdown.confbean.RemindMail"))
/*     */       {
/*     */         RemindMail _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  75 */           _v_ = new RemindMail();
/*  76 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.remaid_mails.add(_v_);
/*     */       }
/*     */     }
/*  86 */     this.bulletin_begin_timestamp_year = Integer.valueOf(rootElement.attributeValue("bulletin_begin_timestamp_year")).intValue();
/*  87 */     this.bulletin_begin_timestamp_month = Integer.valueOf(rootElement.attributeValue("bulletin_begin_timestamp_month")).intValue();
/*  88 */     this.bulletin_begin_timestamp_day = Integer.valueOf(rootElement.attributeValue("bulletin_begin_timestamp_day")).intValue();
/*  89 */     this.bulletin_begin_timestamp_hour = Integer.valueOf(rootElement.attributeValue("bulletin_begin_timestamp_hour")).intValue();
/*  90 */     this.bulletin_begin_timestamp_minute = Integer.valueOf(rootElement.attributeValue("bulletin_begin_timestamp_minute")).intValue();
/*  91 */     this.bulletin_begin_timestamp_second = Integer.valueOf(rootElement.attributeValue("bulletin_begin_timestamp_second")).intValue();
/*  92 */     this.bulletin_interval = Integer.valueOf(rootElement.attributeValue("bulletin_interval")).intValue();
/*  93 */     this.count_down_effect_id = Integer.valueOf(rootElement.attributeValue("count_down_effect_id")).intValue();
/*  94 */     this.count_down_time = Integer.valueOf(rootElement.attributeValue("count_down_time")).intValue();
/*  95 */     this.festival_timestamp_year = Integer.valueOf(rootElement.attributeValue("festival_timestamp_year")).intValue();
/*  96 */     this.festival_timestamp_month = Integer.valueOf(rootElement.attributeValue("festival_timestamp_month")).intValue();
/*  97 */     this.festival_timestamp_day = Integer.valueOf(rootElement.attributeValue("festival_timestamp_day")).intValue();
/*  98 */     this.festival_timestamp_hour = Integer.valueOf(rootElement.attributeValue("festival_timestamp_hour")).intValue();
/*  99 */     this.festival_timestamp_minute = Integer.valueOf(rootElement.attributeValue("festival_timestamp_minute")).intValue();
/* 100 */     this.festival_timestamp_second = Integer.valueOf(rootElement.attributeValue("festival_timestamp_second")).intValue();
/* 101 */     this.festival_effect_id = Integer.valueOf(rootElement.attributeValue("festival_effect_id")).intValue();
/* 102 */     this.festival_sound_id = Integer.valueOf(rootElement.attributeValue("festival_sound_id")).intValue();
/* 103 */     this.festival_effect_play_time = Integer.valueOf(rootElement.attributeValue("festival_effect_play_time")).intValue();
/* 104 */     this.red_packet_award_id = Integer.valueOf(rootElement.attributeValue("red_packet_award_id")).intValue();
/* 105 */     this.red_packet_icon_id = Integer.valueOf(rootElement.attributeValue("red_packet_icon_id")).intValue();
/* 106 */     this.red_packet_desc = rootElement.attributeValue("red_packet_desc");
/* 107 */     this.red_packet_valid_time = Integer.valueOf(rootElement.attributeValue("red_packet_valid_time")).intValue();
/* 108 */     this.thank_mail_valid_time = Integer.valueOf(rootElement.attributeValue("thank_mail_valid_time")).intValue();
/*     */     
/* 110 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "thanks_mails");
/* 111 */     if (collectionElement == null)
/*     */     {
/* 113 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 116 */     List<?> _nodeList = collectionElement.elements();
/* 117 */     int _len = _nodeList.size();
/* 118 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 120 */       Element elem = (Element)_nodeList.get(i);
/* 121 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.countdown.confbean.ThankMail"))
/*     */       {
/*     */         ThankMail _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 128 */           _v_ = new ThankMail();
/* 129 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 136 */         this.thanks_mails.add(_v_);
/*     */       }
/*     */     }
/* 139 */     this.festival_to_start_play_interval = Integer.valueOf(rootElement.attributeValue("festival_to_start_play_interval")).intValue();
/* 140 */     this.festival_to_stop_play_interval = Integer.valueOf(rootElement.attributeValue("festival_to_stop_play_interval")).intValue();
/* 141 */     this.map_effect_id = Integer.valueOf(rootElement.attributeValue("map_effect_id")).intValue();
/*     */     
/* 143 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "map_cfg_ids");
/* 144 */     if (collectionElement == null)
/*     */     {
/* 146 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 149 */     List<?> _nodeList = collectionElement.elements();
/* 150 */     int _len = _nodeList.size();
/* 151 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 153 */       Element elem = (Element)_nodeList.get(i);
/* 154 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 161 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 168 */         this.map_cfg_ids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 175 */     _os_.marshal(this.id);
/* 176 */     _os_.marshal(this.name, "UTF-8");
/* 177 */     _os_.marshal(this.desc, "UTF-8");
/* 178 */     _os_.compact_uint32(this.remaid_mails.size());
/* 179 */     for (RemindMail _v_ : this.remaid_mails)
/*     */     {
/* 181 */       _os_.marshal(_v_);
/*     */     }
/* 183 */     _os_.marshal(this.bulletin_begin_timestamp_year);
/* 184 */     _os_.marshal(this.bulletin_begin_timestamp_month);
/* 185 */     _os_.marshal(this.bulletin_begin_timestamp_day);
/* 186 */     _os_.marshal(this.bulletin_begin_timestamp_hour);
/* 187 */     _os_.marshal(this.bulletin_begin_timestamp_minute);
/* 188 */     _os_.marshal(this.bulletin_begin_timestamp_second);
/* 189 */     _os_.marshal(this.bulletin_interval);
/* 190 */     _os_.marshal(this.count_down_effect_id);
/* 191 */     _os_.marshal(this.count_down_time);
/* 192 */     _os_.marshal(this.festival_timestamp_year);
/* 193 */     _os_.marshal(this.festival_timestamp_month);
/* 194 */     _os_.marshal(this.festival_timestamp_day);
/* 195 */     _os_.marshal(this.festival_timestamp_hour);
/* 196 */     _os_.marshal(this.festival_timestamp_minute);
/* 197 */     _os_.marshal(this.festival_timestamp_second);
/* 198 */     _os_.marshal(this.festival_effect_id);
/* 199 */     _os_.marshal(this.festival_sound_id);
/* 200 */     _os_.marshal(this.festival_effect_play_time);
/* 201 */     _os_.marshal(this.red_packet_award_id);
/* 202 */     _os_.marshal(this.red_packet_icon_id);
/* 203 */     _os_.marshal(this.red_packet_desc, "UTF-8");
/* 204 */     _os_.marshal(this.red_packet_valid_time);
/* 205 */     _os_.marshal(this.thank_mail_valid_time);
/* 206 */     _os_.compact_uint32(this.thanks_mails.size());
/* 207 */     for (ThankMail _v_ : this.thanks_mails)
/*     */     {
/* 209 */       _os_.marshal(_v_);
/*     */     }
/* 211 */     _os_.marshal(this.festival_to_start_play_interval);
/* 212 */     _os_.marshal(this.festival_to_stop_play_interval);
/* 213 */     _os_.marshal(this.map_effect_id);
/* 214 */     _os_.compact_uint32(this.map_cfg_ids.size());
/* 215 */     for (Integer _v_ : this.map_cfg_ids)
/*     */     {
/* 217 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 219 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 224 */     this.id = _os_.unmarshal_int();
/* 225 */     this.name = _os_.unmarshal_String("UTF-8");
/* 226 */     this.desc = _os_.unmarshal_String("UTF-8");
/* 227 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 230 */       RemindMail _v_ = new RemindMail();
/* 231 */       _v_.unmarshal(_os_);
/* 232 */       this.remaid_mails.add(_v_);
/*     */     }
/* 234 */     this.bulletin_begin_timestamp_year = _os_.unmarshal_int();
/* 235 */     this.bulletin_begin_timestamp_month = _os_.unmarshal_int();
/* 236 */     this.bulletin_begin_timestamp_day = _os_.unmarshal_int();
/* 237 */     this.bulletin_begin_timestamp_hour = _os_.unmarshal_int();
/* 238 */     this.bulletin_begin_timestamp_minute = _os_.unmarshal_int();
/* 239 */     this.bulletin_begin_timestamp_second = _os_.unmarshal_int();
/* 240 */     this.bulletin_interval = _os_.unmarshal_int();
/* 241 */     this.count_down_effect_id = _os_.unmarshal_int();
/* 242 */     this.count_down_time = _os_.unmarshal_int();
/* 243 */     this.festival_timestamp_year = _os_.unmarshal_int();
/* 244 */     this.festival_timestamp_month = _os_.unmarshal_int();
/* 245 */     this.festival_timestamp_day = _os_.unmarshal_int();
/* 246 */     this.festival_timestamp_hour = _os_.unmarshal_int();
/* 247 */     this.festival_timestamp_minute = _os_.unmarshal_int();
/* 248 */     this.festival_timestamp_second = _os_.unmarshal_int();
/* 249 */     this.festival_effect_id = _os_.unmarshal_int();
/* 250 */     this.festival_sound_id = _os_.unmarshal_int();
/* 251 */     this.festival_effect_play_time = _os_.unmarshal_int();
/* 252 */     this.red_packet_award_id = _os_.unmarshal_int();
/* 253 */     this.red_packet_icon_id = _os_.unmarshal_int();
/* 254 */     this.red_packet_desc = _os_.unmarshal_String("UTF-8");
/* 255 */     this.red_packet_valid_time = _os_.unmarshal_int();
/* 256 */     this.thank_mail_valid_time = _os_.unmarshal_int();
/* 257 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 260 */       ThankMail _v_ = new ThankMail();
/* 261 */       _v_.unmarshal(_os_);
/* 262 */       this.thanks_mails.add(_v_);
/*     */     }
/* 264 */     this.festival_to_start_play_interval = _os_.unmarshal_int();
/* 265 */     this.festival_to_stop_play_interval = _os_.unmarshal_int();
/* 266 */     this.map_effect_id = _os_.unmarshal_int();
/* 267 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 270 */       int _v_ = _os_.unmarshal_int();
/* 271 */       this.map_cfg_ids.add(Integer.valueOf(_v_));
/*     */     }
/* 273 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 278 */     String path = dir + "mzm.gsp.countdown.confbean.CountDownCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 282 */       all = new java.util.HashMap();
/* 283 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 284 */       org.dom4j.Document doc = reader.read(new File(path));
/* 285 */       Element root = doc.getRootElement();
/* 286 */       List<?> nodeList = root.elements();
/* 287 */       int len = nodeList.size();
/* 288 */       for (int i = 0; i < len; i++)
/*     */       {
/* 290 */         Element elem = (Element)nodeList.get(i);
/* 291 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.countdown.confbean.CountDownCfgOriginal"))
/*     */         {
/*     */ 
/* 294 */           CountDownCfgOriginal obj = new CountDownCfgOriginal();
/* 295 */           obj.loadFromXml(elem);
/* 296 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 297 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 302 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, CountDownCfgOriginal> all)
/*     */   {
/* 308 */     String path = dir + "mzm.gsp.countdown.confbean.CountDownCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 312 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 313 */       org.dom4j.Document doc = reader.read(new File(path));
/* 314 */       Element root = doc.getRootElement();
/* 315 */       List<?> nodeList = root.elements();
/* 316 */       int len = nodeList.size();
/* 317 */       for (int i = 0; i < len; i++)
/*     */       {
/* 319 */         Element elem = (Element)nodeList.get(i);
/* 320 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.countdown.confbean.CountDownCfgOriginal"))
/*     */         {
/*     */ 
/* 323 */           CountDownCfgOriginal obj = new CountDownCfgOriginal();
/* 324 */           obj.loadFromXml(elem);
/* 325 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 326 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 331 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 337 */     all = new java.util.HashMap();
/*     */     
/* 339 */     String path = dir + "mzm.gsp.countdown.confbean.CountDownCfgOriginal.bny";
/*     */     try
/*     */     {
/* 342 */       File file = new File(path);
/* 343 */       if (file.exists())
/*     */       {
/* 345 */         byte[] bytes = new byte['Ѐ'];
/* 346 */         FileInputStream fis = new FileInputStream(file);
/* 347 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 348 */         int len = 0;
/* 349 */         while ((len = fis.read(bytes)) > 0)
/* 350 */           baos.write(bytes, 0, len);
/* 351 */         fis.close();
/* 352 */         bytes = baos.toByteArray();
/* 353 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 354 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 356 */           _os_.unmarshal_int();
/* 357 */           _os_.unmarshal_int();
/* 358 */           _os_.unmarshal_int();
/*     */         }
/* 360 */         _os_.unmarshal_int();
/* 361 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 364 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 366 */           CountDownCfgOriginal _v_ = new CountDownCfgOriginal();
/* 367 */           _v_.unmarshal(_os_);
/* 368 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 369 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 374 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 379 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, CountDownCfgOriginal> all)
/*     */   {
/* 386 */     String path = dir + "mzm.gsp.countdown.confbean.CountDownCfgOriginal.bny";
/*     */     try
/*     */     {
/* 389 */       File file = new File(path);
/* 390 */       if (file.exists())
/*     */       {
/* 392 */         byte[] bytes = new byte['Ѐ'];
/* 393 */         FileInputStream fis = new FileInputStream(file);
/* 394 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 395 */         int len = 0;
/* 396 */         while ((len = fis.read(bytes)) > 0)
/* 397 */           baos.write(bytes, 0, len);
/* 398 */         fis.close();
/* 399 */         bytes = baos.toByteArray();
/* 400 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 401 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 403 */           _os_.unmarshal_int();
/* 404 */           _os_.unmarshal_int();
/* 405 */           _os_.unmarshal_int();
/*     */         }
/* 407 */         _os_.unmarshal_int();
/* 408 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 411 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 413 */           CountDownCfgOriginal _v_ = new CountDownCfgOriginal();
/* 414 */           _v_.unmarshal(_os_);
/* 415 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 416 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 421 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 426 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static CountDownCfgOriginal getOld(int key)
/*     */   {
/* 434 */     return (CountDownCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static CountDownCfgOriginal get(int key)
/*     */   {
/* 439 */     return (CountDownCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, CountDownCfgOriginal> getOldAll()
/*     */   {
/* 444 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, CountDownCfgOriginal> getAll()
/*     */   {
/* 449 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, CountDownCfgOriginal> newAll)
/*     */   {
/* 454 */     oldAll = all;
/* 455 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 460 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\confbean\CountDownCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */