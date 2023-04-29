/*     */ package mzm.gsp.crossbattle.confbean;
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
/*     */ public class SCrossBattleFinalServerAwardCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCrossBattleFinalServerAwardCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCrossBattleFinalServerAwardCfg> all = null;
/*     */   
/*     */   public int activityCfgId;
/*     */   public int open_interval_day_after_activity_end;
/*     */   public int gift_item_min_level;
/*  21 */   public HashMap<Integer, RankAwardMailItemList> rank_2_award_item_map = new HashMap();
/*  22 */   public HashMap<Integer, RankAwardBuffList> rank_2_award_buff_map = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.activityCfgId = Integer.valueOf(rootElement.attributeValue("activityCfgId")).intValue();
/*  27 */     this.open_interval_day_after_activity_end = Integer.valueOf(rootElement.attributeValue("open_interval_day_after_activity_end")).intValue();
/*  28 */     this.gift_item_min_level = Integer.valueOf(rootElement.attributeValue("gift_item_min_level")).intValue();
/*     */     
/*  30 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "rank_2_award_item_map");
/*  31 */     if (mapTypeElement == null)
/*     */     {
/*  33 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  36 */     List<?> entryNodeList = mapTypeElement.elements();
/*  37 */     int entryLen = entryNodeList.size();
/*  38 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  40 */       Element entryElement = (Element)entryNodeList.get(i);
/*  41 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  46 */         Element keyElem = null;
/*  47 */         Element valueElem = null;
/*     */         
/*  49 */         List<?> _nodeList = entryElement.elements();
/*  50 */         int _len = _nodeList.size();
/*  51 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  53 */           Element elem = (Element)_nodeList.get(j);
/*  54 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  56 */             keyElem = elem;
/*     */           }
/*  58 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.RankAwardMailItemList")))
/*     */           {
/*  60 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  64 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  66 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         RankAwardMailItemList _v_;
/*     */         try
/*     */         {
/*  73 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  74 */           _v_ = new RankAwardMailItemList();
/*  75 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  82 */         this.rank_2_award_item_map.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/*  86 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "rank_2_award_buff_map");
/*  87 */     if (mapTypeElement == null)
/*     */     {
/*  89 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  92 */     List<?> entryNodeList = mapTypeElement.elements();
/*  93 */     int entryLen = entryNodeList.size();
/*  94 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  96 */       Element entryElement = (Element)entryNodeList.get(i);
/*  97 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 102 */         Element keyElem = null;
/* 103 */         Element valueElem = null;
/*     */         
/* 105 */         List<?> _nodeList = entryElement.elements();
/* 106 */         int _len = _nodeList.size();
/* 107 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 109 */           Element elem = (Element)_nodeList.get(j);
/* 110 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 112 */             keyElem = elem;
/*     */           }
/* 114 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.RankAwardBuffList")))
/*     */           {
/* 116 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 120 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 122 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         RankAwardBuffList _v_;
/*     */         try
/*     */         {
/* 129 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 130 */           _v_ = new RankAwardBuffList();
/* 131 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 138 */         this.rank_2_award_buff_map.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 145 */     _os_.marshal(this.activityCfgId);
/* 146 */     _os_.marshal(this.open_interval_day_after_activity_end);
/* 147 */     _os_.marshal(this.gift_item_min_level);
/* 148 */     _os_.compact_uint32(this.rank_2_award_item_map.size());
/* 149 */     for (java.util.Map.Entry<Integer, RankAwardMailItemList> _e_ : this.rank_2_award_item_map.entrySet())
/*     */     {
/* 151 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 152 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 154 */     _os_.compact_uint32(this.rank_2_award_buff_map.size());
/* 155 */     for (java.util.Map.Entry<Integer, RankAwardBuffList> _e_ : this.rank_2_award_buff_map.entrySet())
/*     */     {
/* 157 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 158 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 160 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 165 */     this.activityCfgId = _os_.unmarshal_int();
/* 166 */     this.open_interval_day_after_activity_end = _os_.unmarshal_int();
/* 167 */     this.gift_item_min_level = _os_.unmarshal_int();
/* 168 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 171 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 173 */       RankAwardMailItemList _v_ = new RankAwardMailItemList();
/* 174 */       _v_.unmarshal(_os_);
/* 175 */       this.rank_2_award_item_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 177 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 180 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 182 */       RankAwardBuffList _v_ = new RankAwardBuffList();
/* 183 */       _v_.unmarshal(_os_);
/* 184 */       this.rank_2_award_buff_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 186 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 195 */       all = new HashMap();
/* 196 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 197 */       org.dom4j.Document doc = reader.read(new File(path));
/* 198 */       Element root = doc.getRootElement();
/* 199 */       List<?> nodeList = root.elements();
/* 200 */       int len = nodeList.size();
/* 201 */       for (int i = 0; i < len; i++)
/*     */       {
/* 203 */         Element elem = (Element)nodeList.get(i);
/* 204 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardCfg"))
/*     */         {
/*     */ 
/* 207 */           SCrossBattleFinalServerAwardCfg obj = new SCrossBattleFinalServerAwardCfg();
/* 208 */           obj.loadFromXml(elem);
/* 209 */           if (all.put(Integer.valueOf(obj.activityCfgId), obj) != null) {
/* 210 */             throw new RuntimeException("duplicate key : " + obj.activityCfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 215 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCrossBattleFinalServerAwardCfg> all)
/*     */   {
/* 221 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 225 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 226 */       org.dom4j.Document doc = reader.read(new File(path));
/* 227 */       Element root = doc.getRootElement();
/* 228 */       List<?> nodeList = root.elements();
/* 229 */       int len = nodeList.size();
/* 230 */       for (int i = 0; i < len; i++)
/*     */       {
/* 232 */         Element elem = (Element)nodeList.get(i);
/* 233 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardCfg"))
/*     */         {
/*     */ 
/* 236 */           SCrossBattleFinalServerAwardCfg obj = new SCrossBattleFinalServerAwardCfg();
/* 237 */           obj.loadFromXml(elem);
/* 238 */           if (all.put(Integer.valueOf(obj.activityCfgId), obj) != null) {
/* 239 */             throw new RuntimeException("duplicate key : " + obj.activityCfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 244 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 250 */     all = new HashMap();
/*     */     
/* 252 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardCfg.bny";
/*     */     try
/*     */     {
/* 255 */       File file = new File(path);
/* 256 */       if (file.exists())
/*     */       {
/* 258 */         byte[] bytes = new byte['Ѐ'];
/* 259 */         FileInputStream fis = new FileInputStream(file);
/* 260 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 261 */         int len = 0;
/* 262 */         while ((len = fis.read(bytes)) > 0)
/* 263 */           baos.write(bytes, 0, len);
/* 264 */         fis.close();
/* 265 */         bytes = baos.toByteArray();
/* 266 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 267 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 269 */           _os_.unmarshal_int();
/* 270 */           _os_.unmarshal_int();
/* 271 */           _os_.unmarshal_int();
/*     */         }
/* 273 */         _os_.unmarshal_int();
/* 274 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 277 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 279 */           SCrossBattleFinalServerAwardCfg _v_ = new SCrossBattleFinalServerAwardCfg();
/* 280 */           _v_.unmarshal(_os_);
/* 281 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 282 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 287 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 292 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCrossBattleFinalServerAwardCfg> all)
/*     */   {
/* 299 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardCfg.bny";
/*     */     try
/*     */     {
/* 302 */       File file = new File(path);
/* 303 */       if (file.exists())
/*     */       {
/* 305 */         byte[] bytes = new byte['Ѐ'];
/* 306 */         FileInputStream fis = new FileInputStream(file);
/* 307 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 308 */         int len = 0;
/* 309 */         while ((len = fis.read(bytes)) > 0)
/* 310 */           baos.write(bytes, 0, len);
/* 311 */         fis.close();
/* 312 */         bytes = baos.toByteArray();
/* 313 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 314 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 316 */           _os_.unmarshal_int();
/* 317 */           _os_.unmarshal_int();
/* 318 */           _os_.unmarshal_int();
/*     */         }
/* 320 */         _os_.unmarshal_int();
/* 321 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 324 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 326 */           SCrossBattleFinalServerAwardCfg _v_ = new SCrossBattleFinalServerAwardCfg();
/* 327 */           _v_.unmarshal(_os_);
/* 328 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 329 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 334 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 339 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCrossBattleFinalServerAwardCfg getOld(int key)
/*     */   {
/* 347 */     return (SCrossBattleFinalServerAwardCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCrossBattleFinalServerAwardCfg get(int key)
/*     */   {
/* 352 */     return (SCrossBattleFinalServerAwardCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleFinalServerAwardCfg> getOldAll()
/*     */   {
/* 357 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleFinalServerAwardCfg> getAll()
/*     */   {
/* 362 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCrossBattleFinalServerAwardCfg> newAll)
/*     */   {
/* 367 */     oldAll = all;
/* 368 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 373 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattleFinalServerAwardCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */