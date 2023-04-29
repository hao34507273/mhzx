/*     */ package mzm.gsp.mail.confbean;
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
/*     */ public class SMailCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMailCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMailCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int mailType;
/*     */   public String title;
/*     */   public String content;
/*     */   public int yuanbao;
/*     */   public int gold;
/*     */   public int silver;
/*     */   public int goldIngot;
/*  27 */   public HashMap<Integer, Integer> tokenMap = new HashMap();
/*  28 */   public HashMap<Integer, Integer> itemMap = new HashMap();
/*     */   public int minLevel;
/*     */   public int maxLevel;
/*     */   public int timeLimitid;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.templatename = rootElement.attributeValue("templatename");
/*  37 */     this.mailType = Integer.valueOf(rootElement.attributeValue("mailType")).intValue();
/*  38 */     this.title = rootElement.attributeValue("title");
/*  39 */     this.content = rootElement.attributeValue("content");
/*  40 */     this.yuanbao = Integer.valueOf(rootElement.attributeValue("yuanbao")).intValue();
/*  41 */     this.gold = Integer.valueOf(rootElement.attributeValue("gold")).intValue();
/*  42 */     this.silver = Integer.valueOf(rootElement.attributeValue("silver")).intValue();
/*  43 */     this.goldIngot = Integer.valueOf(rootElement.attributeValue("goldIngot")).intValue();
/*     */     
/*  45 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "tokenMap");
/*  46 */     if (mapTypeElement == null)
/*     */     {
/*  48 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  51 */     List<?> entryNodeList = mapTypeElement.elements();
/*  52 */     int entryLen = entryNodeList.size();
/*  53 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  55 */       Element entryElement = (Element)entryNodeList.get(i);
/*  56 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  61 */         Element keyElem = null;
/*  62 */         Element valueElem = null;
/*     */         
/*  64 */         List<?> _nodeList = entryElement.elements();
/*  65 */         int _len = _nodeList.size();
/*  66 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  68 */           Element elem = (Element)_nodeList.get(j);
/*  69 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  71 */             keyElem = elem;
/*     */           }
/*  73 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  75 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  79 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  81 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  88 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  89 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  96 */         this.tokenMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 100 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "itemMap");
/* 101 */     if (mapTypeElement == null)
/*     */     {
/* 103 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 106 */     List<?> entryNodeList = mapTypeElement.elements();
/* 107 */     int entryLen = entryNodeList.size();
/* 108 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 110 */       Element entryElement = (Element)entryNodeList.get(i);
/* 111 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 116 */         Element keyElem = null;
/* 117 */         Element valueElem = null;
/*     */         
/* 119 */         List<?> _nodeList = entryElement.elements();
/* 120 */         int _len = _nodeList.size();
/* 121 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 123 */           Element elem = (Element)_nodeList.get(j);
/* 124 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 126 */             keyElem = elem;
/*     */           }
/* 128 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 130 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 134 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 136 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 143 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 144 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 151 */         this.itemMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 154 */     this.minLevel = Integer.valueOf(rootElement.attributeValue("minLevel")).intValue();
/* 155 */     this.maxLevel = Integer.valueOf(rootElement.attributeValue("maxLevel")).intValue();
/* 156 */     this.timeLimitid = Integer.valueOf(rootElement.attributeValue("timeLimitid")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 161 */     _os_.marshal(this.id);
/* 162 */     _os_.marshal(this.templatename, "UTF-8");
/* 163 */     _os_.marshal(this.mailType);
/* 164 */     _os_.marshal(this.title, "UTF-8");
/* 165 */     _os_.marshal(this.content, "UTF-8");
/* 166 */     _os_.marshal(this.yuanbao);
/* 167 */     _os_.marshal(this.gold);
/* 168 */     _os_.marshal(this.silver);
/* 169 */     _os_.marshal(this.goldIngot);
/* 170 */     _os_.compact_uint32(this.tokenMap.size());
/* 171 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.tokenMap.entrySet())
/*     */     {
/* 173 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 174 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 176 */     _os_.compact_uint32(this.itemMap.size());
/* 177 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.itemMap.entrySet())
/*     */     {
/* 179 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 180 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 182 */     _os_.marshal(this.minLevel);
/* 183 */     _os_.marshal(this.maxLevel);
/* 184 */     _os_.marshal(this.timeLimitid);
/* 185 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 190 */     this.id = _os_.unmarshal_int();
/* 191 */     this.templatename = _os_.unmarshal_String("UTF-8");
/* 192 */     this.mailType = _os_.unmarshal_int();
/* 193 */     this.title = _os_.unmarshal_String("UTF-8");
/* 194 */     this.content = _os_.unmarshal_String("UTF-8");
/* 195 */     this.yuanbao = _os_.unmarshal_int();
/* 196 */     this.gold = _os_.unmarshal_int();
/* 197 */     this.silver = _os_.unmarshal_int();
/* 198 */     this.goldIngot = _os_.unmarshal_int();
/* 199 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 202 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 204 */       int _v_ = _os_.unmarshal_int();
/* 205 */       this.tokenMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 207 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 210 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 212 */       int _v_ = _os_.unmarshal_int();
/* 213 */       this.itemMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 215 */     this.minLevel = _os_.unmarshal_int();
/* 216 */     this.maxLevel = _os_.unmarshal_int();
/* 217 */     this.timeLimitid = _os_.unmarshal_int();
/* 218 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 223 */     String path = dir + "mzm.gsp.mail.confbean.SMailCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 227 */       all = new HashMap();
/* 228 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 229 */       org.dom4j.Document doc = reader.read(new File(path));
/* 230 */       Element root = doc.getRootElement();
/* 231 */       List<?> nodeList = root.elements();
/* 232 */       int len = nodeList.size();
/* 233 */       for (int i = 0; i < len; i++)
/*     */       {
/* 235 */         Element elem = (Element)nodeList.get(i);
/* 236 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.mail.confbean.SMailCfg"))
/*     */         {
/*     */ 
/* 239 */           SMailCfg obj = new SMailCfg();
/* 240 */           obj.loadFromXml(elem);
/* 241 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 242 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 247 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMailCfg> all)
/*     */   {
/* 253 */     String path = dir + "mzm.gsp.mail.confbean.SMailCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 257 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 258 */       org.dom4j.Document doc = reader.read(new File(path));
/* 259 */       Element root = doc.getRootElement();
/* 260 */       List<?> nodeList = root.elements();
/* 261 */       int len = nodeList.size();
/* 262 */       for (int i = 0; i < len; i++)
/*     */       {
/* 264 */         Element elem = (Element)nodeList.get(i);
/* 265 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.mail.confbean.SMailCfg"))
/*     */         {
/*     */ 
/* 268 */           SMailCfg obj = new SMailCfg();
/* 269 */           obj.loadFromXml(elem);
/* 270 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 271 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 276 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 282 */     all = new HashMap();
/*     */     
/* 284 */     String path = dir + "mzm.gsp.mail.confbean.SMailCfg.bny";
/*     */     try
/*     */     {
/* 287 */       File file = new File(path);
/* 288 */       if (file.exists())
/*     */       {
/* 290 */         byte[] bytes = new byte['Ѐ'];
/* 291 */         FileInputStream fis = new FileInputStream(file);
/* 292 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 293 */         int len = 0;
/* 294 */         while ((len = fis.read(bytes)) > 0)
/* 295 */           baos.write(bytes, 0, len);
/* 296 */         fis.close();
/* 297 */         bytes = baos.toByteArray();
/* 298 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 299 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 301 */           _os_.unmarshal_int();
/* 302 */           _os_.unmarshal_int();
/* 303 */           _os_.unmarshal_int();
/*     */         }
/* 305 */         _os_.unmarshal_int();
/* 306 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 309 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 311 */           SMailCfg _v_ = new SMailCfg();
/* 312 */           _v_.unmarshal(_os_);
/* 313 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 314 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 319 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 324 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMailCfg> all)
/*     */   {
/* 331 */     String path = dir + "mzm.gsp.mail.confbean.SMailCfg.bny";
/*     */     try
/*     */     {
/* 334 */       File file = new File(path);
/* 335 */       if (file.exists())
/*     */       {
/* 337 */         byte[] bytes = new byte['Ѐ'];
/* 338 */         FileInputStream fis = new FileInputStream(file);
/* 339 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 340 */         int len = 0;
/* 341 */         while ((len = fis.read(bytes)) > 0)
/* 342 */           baos.write(bytes, 0, len);
/* 343 */         fis.close();
/* 344 */         bytes = baos.toByteArray();
/* 345 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 346 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 348 */           _os_.unmarshal_int();
/* 349 */           _os_.unmarshal_int();
/* 350 */           _os_.unmarshal_int();
/*     */         }
/* 352 */         _os_.unmarshal_int();
/* 353 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 356 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 358 */           SMailCfg _v_ = new SMailCfg();
/* 359 */           _v_.unmarshal(_os_);
/* 360 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 361 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 366 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 371 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMailCfg getOld(int key)
/*     */   {
/* 379 */     return (SMailCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMailCfg get(int key)
/*     */   {
/* 384 */     return (SMailCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMailCfg> getOldAll()
/*     */   {
/* 389 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMailCfg> getAll()
/*     */   {
/* 394 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMailCfg> newAll)
/*     */   {
/* 399 */     oldAll = all;
/* 400 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 405 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\confbean\SMailCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */