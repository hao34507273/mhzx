/*     */ package mzm.gsp.qingfu.confbean;
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
/*     */ public class SChannelToProductsCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SChannelToProductsCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SChannelToProductsCfg> all = null;
/*     */   
/*     */   public int id;
/*  19 */   public HashMap<String, Integer> products = new HashMap();
/*  20 */   public HashMap<Integer, SPlatServiceInfo> platServiceInfos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*     */     
/*  26 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "products");
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
/*  50 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("string")))
/*     */           {
/*  52 */             keyElem = elem;
/*     */           }
/*  54 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
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
/*     */         String _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  69 */           _k_ = keyElem.getText();
/*  70 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  77 */         this.products.put(_k_, Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  81 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "platServiceInfos");
/*  82 */     if (mapTypeElement == null)
/*     */     {
/*  84 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  87 */     List<?> entryNodeList = mapTypeElement.elements();
/*  88 */     int entryLen = entryNodeList.size();
/*  89 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  91 */       Element entryElement = (Element)entryNodeList.get(i);
/*  92 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  97 */         Element keyElem = null;
/*  98 */         Element valueElem = null;
/*     */         
/* 100 */         List<?> _nodeList = entryElement.elements();
/* 101 */         int _len = _nodeList.size();
/* 102 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 104 */           Element elem = (Element)_nodeList.get(j);
/* 105 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 107 */             keyElem = elem;
/*     */           }
/* 109 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.SPlatServiceInfo")))
/*     */           {
/* 111 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 115 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 117 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SPlatServiceInfo _v_;
/*     */         try
/*     */         {
/* 124 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 125 */           _v_ = new SPlatServiceInfo();
/* 126 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 133 */         this.platServiceInfos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 140 */     _os_.marshal(this.id);
/* 141 */     _os_.compact_uint32(this.products.size());
/* 142 */     for (java.util.Map.Entry<String, Integer> _e_ : this.products.entrySet())
/*     */     {
/* 144 */       _os_.marshal((String)_e_.getKey(), "UTF-8");
/* 145 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 147 */     _os_.compact_uint32(this.platServiceInfos.size());
/* 148 */     for (java.util.Map.Entry<Integer, SPlatServiceInfo> _e_ : this.platServiceInfos.entrySet())
/*     */     {
/* 150 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 151 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 153 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 158 */     this.id = _os_.unmarshal_int();
/* 159 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 162 */       String _k_ = _os_.unmarshal_String("UTF-8");
/*     */       
/* 164 */       int _v_ = _os_.unmarshal_int();
/* 165 */       this.products.put(_k_, Integer.valueOf(_v_));
/*     */     }
/* 167 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 170 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 172 */       SPlatServiceInfo _v_ = new SPlatServiceInfo();
/* 173 */       _v_.unmarshal(_os_);
/* 174 */       this.platServiceInfos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 176 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 181 */     String path = dir + "mzm.gsp.qingfu.confbean.SChannelToProductsCfg.xml";
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
/* 194 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.SChannelToProductsCfg"))
/*     */         {
/*     */ 
/* 197 */           SChannelToProductsCfg obj = new SChannelToProductsCfg();
/* 198 */           obj.loadFromXml(elem);
/* 199 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 200 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 205 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SChannelToProductsCfg> all)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.qingfu.confbean.SChannelToProductsCfg.xml";
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
/* 223 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.SChannelToProductsCfg"))
/*     */         {
/*     */ 
/* 226 */           SChannelToProductsCfg obj = new SChannelToProductsCfg();
/* 227 */           obj.loadFromXml(elem);
/* 228 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 242 */     String path = dir + "mzm.gsp.qingfu.confbean.SChannelToProductsCfg.bny";
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
/* 269 */           SChannelToProductsCfg _v_ = new SChannelToProductsCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SChannelToProductsCfg> all)
/*     */   {
/* 289 */     String path = dir + "mzm.gsp.qingfu.confbean.SChannelToProductsCfg.bny";
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
/* 316 */           SChannelToProductsCfg _v_ = new SChannelToProductsCfg();
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
/*     */   public static SChannelToProductsCfg getOld(int key)
/*     */   {
/* 337 */     return (SChannelToProductsCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SChannelToProductsCfg get(int key)
/*     */   {
/* 342 */     return (SChannelToProductsCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChannelToProductsCfg> getOldAll()
/*     */   {
/* 347 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChannelToProductsCfg> getAll()
/*     */   {
/* 352 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SChannelToProductsCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\confbean\SChannelToProductsCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */