/*     */ package mzm.gsp.activity2.confbean;
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
/*     */ public class SVisibleMonsterKillMonsterTriggerCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SVisibleMonsterKillMonsterTriggerCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SVisibleMonsterKillMonsterTriggerCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*  19 */   public HashMap<Integer, MonsterTypeBean> monsters_type_map = new HashMap();
/*  20 */   public HashMap<Integer, Integer> monsters_category_id2type_map = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*     */     
/*  26 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "monsters_type_map");
/*  27 */     if (mapTypeElement == null)
/*     */     {
/*  29 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  32 */     List<?> entryNodeList = mapTypeElement.elements();
/*  33 */     int entryLen = entryNodeList.size();
/*  34 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  36 */       Element entryElement = (Element)entryNodeList.get(i);
/*  37 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  42 */         Element keyElem = null;
/*  43 */         Element valueElem = null;
/*     */         
/*  45 */         List<?> _nodeList = entryElement.elements();
/*  46 */         int _len = _nodeList.size();
/*  47 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  49 */           Element elem = (Element)_nodeList.get(j);
/*  50 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  52 */             keyElem = elem;
/*     */           }
/*  54 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.MonsterTypeBean")))
/*     */           {
/*  56 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  60 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  62 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         MonsterTypeBean _v_;
/*     */         try
/*     */         {
/*  69 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  70 */           _v_ = new MonsterTypeBean();
/*  71 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  78 */         this.monsters_type_map.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/*  82 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "monsters_category_id2type_map");
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
/* 133 */         this.monsters_category_id2type_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 140 */     _os_.marshal(this.activity_cfg_id);
/* 141 */     _os_.compact_uint32(this.monsters_type_map.size());
/* 142 */     for (java.util.Map.Entry<Integer, MonsterTypeBean> _e_ : this.monsters_type_map.entrySet())
/*     */     {
/* 144 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 145 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 147 */     _os_.compact_uint32(this.monsters_category_id2type_map.size());
/* 148 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.monsters_category_id2type_map.entrySet())
/*     */     {
/* 150 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 151 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 153 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 158 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 159 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 162 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 164 */       MonsterTypeBean _v_ = new MonsterTypeBean();
/* 165 */       _v_.unmarshal(_os_);
/* 166 */       this.monsters_type_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 168 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 171 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 173 */       int _v_ = _os_.unmarshal_int();
/* 174 */       this.monsters_category_id2type_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 176 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 181 */     String path = dir + "mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 185 */       all = new HashMap();
/* 186 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 187 */       org.dom4j.Document doc = reader.read(new File(path));
/* 188 */       Element root = doc.getRootElement();
/* 189 */       List<?> nodeList = root.elements();
/* 190 */       int len = nodeList.size();
/* 191 */       for (int i = 0; i < len; i++)
/*     */       {
/* 193 */         Element elem = (Element)nodeList.get(i);
/* 194 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerCfg"))
/*     */         {
/*     */ 
/* 197 */           SVisibleMonsterKillMonsterTriggerCfg obj = new SVisibleMonsterKillMonsterTriggerCfg();
/* 198 */           obj.loadFromXml(elem);
/* 199 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 200 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 205 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SVisibleMonsterKillMonsterTriggerCfg> all)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 215 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 216 */       org.dom4j.Document doc = reader.read(new File(path));
/* 217 */       Element root = doc.getRootElement();
/* 218 */       List<?> nodeList = root.elements();
/* 219 */       int len = nodeList.size();
/* 220 */       for (int i = 0; i < len; i++)
/*     */       {
/* 222 */         Element elem = (Element)nodeList.get(i);
/* 223 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerCfg"))
/*     */         {
/*     */ 
/* 226 */           SVisibleMonsterKillMonsterTriggerCfg obj = new SVisibleMonsterKillMonsterTriggerCfg();
/* 227 */           obj.loadFromXml(elem);
/* 228 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 234 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 240 */     all = new HashMap();
/*     */     
/* 242 */     String path = dir + "mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerCfg.bny";
/*     */     try
/*     */     {
/* 245 */       File file = new File(path);
/* 246 */       if (file.exists())
/*     */       {
/* 248 */         byte[] bytes = new byte['Ѐ'];
/* 249 */         FileInputStream fis = new FileInputStream(file);
/* 250 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 251 */         int len = 0;
/* 252 */         while ((len = fis.read(bytes)) > 0)
/* 253 */           baos.write(bytes, 0, len);
/* 254 */         fis.close();
/* 255 */         bytes = baos.toByteArray();
/* 256 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 257 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 259 */           _os_.unmarshal_int();
/* 260 */           _os_.unmarshal_int();
/* 261 */           _os_.unmarshal_int();
/*     */         }
/* 263 */         _os_.unmarshal_int();
/* 264 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 267 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 269 */           SVisibleMonsterKillMonsterTriggerCfg _v_ = new SVisibleMonsterKillMonsterTriggerCfg();
/* 270 */           _v_.unmarshal(_os_);
/* 271 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 272 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 277 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 282 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SVisibleMonsterKillMonsterTriggerCfg> all)
/*     */   {
/* 289 */     String path = dir + "mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerCfg.bny";
/*     */     try
/*     */     {
/* 292 */       File file = new File(path);
/* 293 */       if (file.exists())
/*     */       {
/* 295 */         byte[] bytes = new byte['Ѐ'];
/* 296 */         FileInputStream fis = new FileInputStream(file);
/* 297 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 298 */         int len = 0;
/* 299 */         while ((len = fis.read(bytes)) > 0)
/* 300 */           baos.write(bytes, 0, len);
/* 301 */         fis.close();
/* 302 */         bytes = baos.toByteArray();
/* 303 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 304 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 306 */           _os_.unmarshal_int();
/* 307 */           _os_.unmarshal_int();
/* 308 */           _os_.unmarshal_int();
/*     */         }
/* 310 */         _os_.unmarshal_int();
/* 311 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 314 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 316 */           SVisibleMonsterKillMonsterTriggerCfg _v_ = new SVisibleMonsterKillMonsterTriggerCfg();
/* 317 */           _v_.unmarshal(_os_);
/* 318 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 319 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 324 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 329 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SVisibleMonsterKillMonsterTriggerCfg getOld(int key)
/*     */   {
/* 337 */     return (SVisibleMonsterKillMonsterTriggerCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SVisibleMonsterKillMonsterTriggerCfg get(int key)
/*     */   {
/* 342 */     return (SVisibleMonsterKillMonsterTriggerCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SVisibleMonsterKillMonsterTriggerCfg> getOldAll()
/*     */   {
/* 347 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SVisibleMonsterKillMonsterTriggerCfg> getAll()
/*     */   {
/* 352 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SVisibleMonsterKillMonsterTriggerCfg> newAll)
/*     */   {
/* 357 */     oldAll = all;
/* 358 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 363 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity2\confbean\SVisibleMonsterKillMonsterTriggerCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */