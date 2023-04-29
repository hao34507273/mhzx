/*     */ package mzm.gsp.indiana.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SIndianaCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SIndianaCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SIndianaCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int lottery_item_cfg_id;
/*  20 */   public TreeMap<Integer, SIndianaTurnInfo> turn_infos = new TreeMap();
/*  21 */   public TreeMap<Integer, Integer> turn_time_infos = new TreeMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  26 */     this.lottery_item_cfg_id = Integer.valueOf(rootElement.attributeValue("lottery_item_cfg_id")).intValue();
/*     */     
/*  28 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "turn_infos");
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
/*  56 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.indiana.confbean.SIndianaTurnInfo")))
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
/*     */         SIndianaTurnInfo _v_;
/*     */         try
/*     */         {
/*  71 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  72 */           _v_ = new SIndianaTurnInfo();
/*  73 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  80 */         this.turn_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/*  84 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "turn_time_infos");
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
/* 112 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
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
/*     */         int _v_;
/*     */         try
/*     */         {
/* 127 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 128 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 135 */         this.turn_time_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 142 */     _os_.marshal(this.activity_cfg_id);
/* 143 */     _os_.marshal(this.lottery_item_cfg_id);
/* 144 */     _os_.compact_uint32(this.turn_infos.size());
/* 145 */     for (java.util.Map.Entry<Integer, SIndianaTurnInfo> _e_ : this.turn_infos.entrySet())
/*     */     {
/* 147 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 148 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 150 */     _os_.compact_uint32(this.turn_time_infos.size());
/* 151 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.turn_time_infos.entrySet())
/*     */     {
/* 153 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 154 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 156 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 161 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 162 */     this.lottery_item_cfg_id = _os_.unmarshal_int();
/* 163 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 166 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 168 */       SIndianaTurnInfo _v_ = new SIndianaTurnInfo();
/* 169 */       _v_.unmarshal(_os_);
/* 170 */       this.turn_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 172 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 175 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 177 */       int _v_ = _os_.unmarshal_int();
/* 178 */       this.turn_time_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 180 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 185 */     String path = dir + "mzm.gsp.indiana.confbean.SIndianaCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 189 */       all = new java.util.HashMap();
/* 190 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 191 */       org.dom4j.Document doc = reader.read(new File(path));
/* 192 */       Element root = doc.getRootElement();
/* 193 */       List<?> nodeList = root.elements();
/* 194 */       int len = nodeList.size();
/* 195 */       for (int i = 0; i < len; i++)
/*     */       {
/* 197 */         Element elem = (Element)nodeList.get(i);
/* 198 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.indiana.confbean.SIndianaCfg"))
/*     */         {
/*     */ 
/* 201 */           SIndianaCfg obj = new SIndianaCfg();
/* 202 */           obj.loadFromXml(elem);
/* 203 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 204 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 209 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SIndianaCfg> all)
/*     */   {
/* 215 */     String path = dir + "mzm.gsp.indiana.confbean.SIndianaCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 219 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 220 */       org.dom4j.Document doc = reader.read(new File(path));
/* 221 */       Element root = doc.getRootElement();
/* 222 */       List<?> nodeList = root.elements();
/* 223 */       int len = nodeList.size();
/* 224 */       for (int i = 0; i < len; i++)
/*     */       {
/* 226 */         Element elem = (Element)nodeList.get(i);
/* 227 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.indiana.confbean.SIndianaCfg"))
/*     */         {
/*     */ 
/* 230 */           SIndianaCfg obj = new SIndianaCfg();
/* 231 */           obj.loadFromXml(elem);
/* 232 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 233 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 238 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 244 */     all = new java.util.HashMap();
/*     */     
/* 246 */     String path = dir + "mzm.gsp.indiana.confbean.SIndianaCfg.bny";
/*     */     try
/*     */     {
/* 249 */       File file = new File(path);
/* 250 */       if (file.exists())
/*     */       {
/* 252 */         byte[] bytes = new byte['Ѐ'];
/* 253 */         FileInputStream fis = new FileInputStream(file);
/* 254 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 255 */         int len = 0;
/* 256 */         while ((len = fis.read(bytes)) > 0)
/* 257 */           baos.write(bytes, 0, len);
/* 258 */         fis.close();
/* 259 */         bytes = baos.toByteArray();
/* 260 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 261 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 263 */           _os_.unmarshal_int();
/* 264 */           _os_.unmarshal_int();
/* 265 */           _os_.unmarshal_int();
/*     */         }
/* 267 */         _os_.unmarshal_int();
/* 268 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 271 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 273 */           SIndianaCfg _v_ = new SIndianaCfg();
/* 274 */           _v_.unmarshal(_os_);
/* 275 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 276 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 281 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 286 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SIndianaCfg> all)
/*     */   {
/* 293 */     String path = dir + "mzm.gsp.indiana.confbean.SIndianaCfg.bny";
/*     */     try
/*     */     {
/* 296 */       File file = new File(path);
/* 297 */       if (file.exists())
/*     */       {
/* 299 */         byte[] bytes = new byte['Ѐ'];
/* 300 */         FileInputStream fis = new FileInputStream(file);
/* 301 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 302 */         int len = 0;
/* 303 */         while ((len = fis.read(bytes)) > 0)
/* 304 */           baos.write(bytes, 0, len);
/* 305 */         fis.close();
/* 306 */         bytes = baos.toByteArray();
/* 307 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 308 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 310 */           _os_.unmarshal_int();
/* 311 */           _os_.unmarshal_int();
/* 312 */           _os_.unmarshal_int();
/*     */         }
/* 314 */         _os_.unmarshal_int();
/* 315 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 318 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 320 */           SIndianaCfg _v_ = new SIndianaCfg();
/* 321 */           _v_.unmarshal(_os_);
/* 322 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 323 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 328 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 333 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SIndianaCfg getOld(int key)
/*     */   {
/* 341 */     return (SIndianaCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SIndianaCfg get(int key)
/*     */   {
/* 346 */     return (SIndianaCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SIndianaCfg> getOldAll()
/*     */   {
/* 351 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SIndianaCfg> getAll()
/*     */   {
/* 356 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SIndianaCfg> newAll)
/*     */   {
/* 361 */     oldAll = all;
/* 362 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 367 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\confbean\SIndianaCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */