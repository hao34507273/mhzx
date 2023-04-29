/*     */ package mzm.gsp.countdown.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SCountDownCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCountDownCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCountDownCfg> all = null;
/*     */   
/*     */   public int cfg_id;
/*  19 */   public HashMap<Integer, MailInfo> remind_mail_infos = new HashMap();
/*     */   public int festival_timestamp;
/*     */   public int festival_effect_play_time;
/*     */   public int red_packet_award_id;
/*     */   public int red_packet_valid_time;
/*     */   public int thank_mail_valid_time;
/*  25 */   public HashMap<Integer, MailInfo> thank_mail_infos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.cfg_id = Integer.valueOf(rootElement.attributeValue("cfg_id")).intValue();
/*     */     
/*  31 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "remind_mail_infos");
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
/*  59 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.countdown.confbean.MailInfo")))
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
/*     */         MailInfo _v_;
/*     */         try
/*     */         {
/*  74 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  75 */           _v_ = new MailInfo();
/*  76 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.remind_mail_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*  86 */     this.festival_timestamp = Integer.valueOf(rootElement.attributeValue("festival_timestamp")).intValue();
/*  87 */     this.festival_effect_play_time = Integer.valueOf(rootElement.attributeValue("festival_effect_play_time")).intValue();
/*  88 */     this.red_packet_award_id = Integer.valueOf(rootElement.attributeValue("red_packet_award_id")).intValue();
/*  89 */     this.red_packet_valid_time = Integer.valueOf(rootElement.attributeValue("red_packet_valid_time")).intValue();
/*  90 */     this.thank_mail_valid_time = Integer.valueOf(rootElement.attributeValue("thank_mail_valid_time")).intValue();
/*     */     
/*  92 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "thank_mail_infos");
/*  93 */     if (mapTypeElement == null)
/*     */     {
/*  95 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  98 */     List<?> entryNodeList = mapTypeElement.elements();
/*  99 */     int entryLen = entryNodeList.size();
/* 100 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 102 */       Element entryElement = (Element)entryNodeList.get(i);
/* 103 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 108 */         Element keyElem = null;
/* 109 */         Element valueElem = null;
/*     */         
/* 111 */         List<?> _nodeList = entryElement.elements();
/* 112 */         int _len = _nodeList.size();
/* 113 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 115 */           Element elem = (Element)_nodeList.get(j);
/* 116 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 118 */             keyElem = elem;
/*     */           }
/* 120 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.countdown.confbean.MailInfo")))
/*     */           {
/* 122 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 126 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 128 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         MailInfo _v_;
/*     */         try
/*     */         {
/* 135 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 136 */           _v_ = new MailInfo();
/* 137 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 144 */         this.thank_mail_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 151 */     _os_.marshal(this.cfg_id);
/* 152 */     _os_.compact_uint32(this.remind_mail_infos.size());
/* 153 */     for (java.util.Map.Entry<Integer, MailInfo> _e_ : this.remind_mail_infos.entrySet())
/*     */     {
/* 155 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 156 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 158 */     _os_.marshal(this.festival_timestamp);
/* 159 */     _os_.marshal(this.festival_effect_play_time);
/* 160 */     _os_.marshal(this.red_packet_award_id);
/* 161 */     _os_.marshal(this.red_packet_valid_time);
/* 162 */     _os_.marshal(this.thank_mail_valid_time);
/* 163 */     _os_.compact_uint32(this.thank_mail_infos.size());
/* 164 */     for (java.util.Map.Entry<Integer, MailInfo> _e_ : this.thank_mail_infos.entrySet())
/*     */     {
/* 166 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 167 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 169 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 174 */     this.cfg_id = _os_.unmarshal_int();
/* 175 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 178 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 180 */       MailInfo _v_ = new MailInfo();
/* 181 */       _v_.unmarshal(_os_);
/* 182 */       this.remind_mail_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 184 */     this.festival_timestamp = _os_.unmarshal_int();
/* 185 */     this.festival_effect_play_time = _os_.unmarshal_int();
/* 186 */     this.red_packet_award_id = _os_.unmarshal_int();
/* 187 */     this.red_packet_valid_time = _os_.unmarshal_int();
/* 188 */     this.thank_mail_valid_time = _os_.unmarshal_int();
/* 189 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 192 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 194 */       MailInfo _v_ = new MailInfo();
/* 195 */       _v_.unmarshal(_os_);
/* 196 */       this.thank_mail_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 198 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.countdown.confbean.SCountDownCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 207 */       all = new HashMap();
/* 208 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 209 */       org.dom4j.Document doc = reader.read(new File(path));
/* 210 */       Element root = doc.getRootElement();
/* 211 */       List<?> nodeList = root.elements();
/* 212 */       int len = nodeList.size();
/* 213 */       for (int i = 0; i < len; i++)
/*     */       {
/* 215 */         Element elem = (Element)nodeList.get(i);
/* 216 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.countdown.confbean.SCountDownCfg"))
/*     */         {
/*     */ 
/* 219 */           SCountDownCfg obj = new SCountDownCfg();
/* 220 */           obj.loadFromXml(elem);
/* 221 */           if (all.put(Integer.valueOf(obj.cfg_id), obj) != null) {
/* 222 */             throw new RuntimeException("duplicate key : " + obj.cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCountDownCfg> all)
/*     */   {
/* 233 */     String path = dir + "mzm.gsp.countdown.confbean.SCountDownCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 237 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 238 */       org.dom4j.Document doc = reader.read(new File(path));
/* 239 */       Element root = doc.getRootElement();
/* 240 */       List<?> nodeList = root.elements();
/* 241 */       int len = nodeList.size();
/* 242 */       for (int i = 0; i < len; i++)
/*     */       {
/* 244 */         Element elem = (Element)nodeList.get(i);
/* 245 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.countdown.confbean.SCountDownCfg"))
/*     */         {
/*     */ 
/* 248 */           SCountDownCfg obj = new SCountDownCfg();
/* 249 */           obj.loadFromXml(elem);
/* 250 */           if (all.put(Integer.valueOf(obj.cfg_id), obj) != null) {
/* 251 */             throw new RuntimeException("duplicate key : " + obj.cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 262 */     all = new HashMap();
/*     */     
/* 264 */     String path = dir + "mzm.gsp.countdown.confbean.SCountDownCfg.bny";
/*     */     try
/*     */     {
/* 267 */       File file = new File(path);
/* 268 */       if (file.exists())
/*     */       {
/* 270 */         byte[] bytes = new byte['Ѐ'];
/* 271 */         FileInputStream fis = new FileInputStream(file);
/* 272 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 273 */         int len = 0;
/* 274 */         while ((len = fis.read(bytes)) > 0)
/* 275 */           baos.write(bytes, 0, len);
/* 276 */         fis.close();
/* 277 */         bytes = baos.toByteArray();
/* 278 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 279 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 281 */           _os_.unmarshal_int();
/* 282 */           _os_.unmarshal_int();
/* 283 */           _os_.unmarshal_int();
/*     */         }
/* 285 */         _os_.unmarshal_int();
/* 286 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 289 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 291 */           SCountDownCfg _v_ = new SCountDownCfg();
/* 292 */           _v_.unmarshal(_os_);
/* 293 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 294 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 299 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 304 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCountDownCfg> all)
/*     */   {
/* 311 */     String path = dir + "mzm.gsp.countdown.confbean.SCountDownCfg.bny";
/*     */     try
/*     */     {
/* 314 */       File file = new File(path);
/* 315 */       if (file.exists())
/*     */       {
/* 317 */         byte[] bytes = new byte['Ѐ'];
/* 318 */         FileInputStream fis = new FileInputStream(file);
/* 319 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 320 */         int len = 0;
/* 321 */         while ((len = fis.read(bytes)) > 0)
/* 322 */           baos.write(bytes, 0, len);
/* 323 */         fis.close();
/* 324 */         bytes = baos.toByteArray();
/* 325 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 326 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 328 */           _os_.unmarshal_int();
/* 329 */           _os_.unmarshal_int();
/* 330 */           _os_.unmarshal_int();
/*     */         }
/* 332 */         _os_.unmarshal_int();
/* 333 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 336 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 338 */           SCountDownCfg _v_ = new SCountDownCfg();
/* 339 */           _v_.unmarshal(_os_);
/* 340 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 341 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 346 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 351 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCountDownCfg getOld(int key)
/*     */   {
/* 359 */     return (SCountDownCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCountDownCfg get(int key)
/*     */   {
/* 364 */     return (SCountDownCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCountDownCfg> getOldAll()
/*     */   {
/* 369 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCountDownCfg> getAll()
/*     */   {
/* 374 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCountDownCfg> newAll)
/*     */   {
/* 379 */     oldAll = all;
/* 380 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 385 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\confbean\SCountDownCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */