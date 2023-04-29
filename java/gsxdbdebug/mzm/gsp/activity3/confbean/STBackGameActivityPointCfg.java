/*     */ package mzm.gsp.activity3.confbean;
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
/*     */ public class STBackGameActivityPointCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STBackGameActivityPointCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STBackGameActivityPointCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int pointExchangeCountResetTime;
/*     */   public int manualRefreshCountResetTime;
/*  21 */   public HashMap<Integer, BackGameActivityPointGet> activityId2pointGetCfg = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.pointExchangeCountResetTime = Integer.valueOf(rootElement.attributeValue("pointExchangeCountResetTime")).intValue();
/*  27 */     this.manualRefreshCountResetTime = Integer.valueOf(rootElement.attributeValue("manualRefreshCountResetTime")).intValue();
/*     */     
/*  29 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "activityId2pointGetCfg");
/*  30 */     if (mapTypeElement == null)
/*     */     {
/*  32 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  35 */     List<?> entryNodeList = mapTypeElement.elements();
/*  36 */     int entryLen = entryNodeList.size();
/*  37 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  39 */       Element entryElement = (Element)entryNodeList.get(i);
/*  40 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  45 */         Element keyElem = null;
/*  46 */         Element valueElem = null;
/*     */         
/*  48 */         List<?> _nodeList = entryElement.elements();
/*  49 */         int _len = _nodeList.size();
/*  50 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  52 */           Element elem = (Element)_nodeList.get(j);
/*  53 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  55 */             keyElem = elem;
/*     */           }
/*  57 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.BackGameActivityPointGet")))
/*     */           {
/*  59 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  63 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  65 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         BackGameActivityPointGet _v_;
/*     */         try
/*     */         {
/*  72 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  73 */           _v_ = new BackGameActivityPointGet();
/*  74 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  81 */         this.activityId2pointGetCfg.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  88 */     _os_.marshal(this.id);
/*  89 */     _os_.marshal(this.pointExchangeCountResetTime);
/*  90 */     _os_.marshal(this.manualRefreshCountResetTime);
/*  91 */     _os_.compact_uint32(this.activityId2pointGetCfg.size());
/*  92 */     for (java.util.Map.Entry<Integer, BackGameActivityPointGet> _e_ : this.activityId2pointGetCfg.entrySet())
/*     */     {
/*  94 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  95 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 102 */     this.id = _os_.unmarshal_int();
/* 103 */     this.pointExchangeCountResetTime = _os_.unmarshal_int();
/* 104 */     this.manualRefreshCountResetTime = _os_.unmarshal_int();
/* 105 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 108 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 110 */       BackGameActivityPointGet _v_ = new BackGameActivityPointGet();
/* 111 */       _v_.unmarshal(_os_);
/* 112 */       this.activityId2pointGetCfg.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 119 */     String path = dir + "mzm.gsp.activity3.confbean.STBackGameActivityPointCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 123 */       all = new HashMap();
/* 124 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 125 */       org.dom4j.Document doc = reader.read(new File(path));
/* 126 */       Element root = doc.getRootElement();
/* 127 */       List<?> nodeList = root.elements();
/* 128 */       int len = nodeList.size();
/* 129 */       for (int i = 0; i < len; i++)
/*     */       {
/* 131 */         Element elem = (Element)nodeList.get(i);
/* 132 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.STBackGameActivityPointCfg"))
/*     */         {
/*     */ 
/* 135 */           STBackGameActivityPointCfg obj = new STBackGameActivityPointCfg();
/* 136 */           obj.loadFromXml(elem);
/* 137 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 138 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 143 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STBackGameActivityPointCfg> all)
/*     */   {
/* 149 */     String path = dir + "mzm.gsp.activity3.confbean.STBackGameActivityPointCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 153 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 154 */       org.dom4j.Document doc = reader.read(new File(path));
/* 155 */       Element root = doc.getRootElement();
/* 156 */       List<?> nodeList = root.elements();
/* 157 */       int len = nodeList.size();
/* 158 */       for (int i = 0; i < len; i++)
/*     */       {
/* 160 */         Element elem = (Element)nodeList.get(i);
/* 161 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.STBackGameActivityPointCfg"))
/*     */         {
/*     */ 
/* 164 */           STBackGameActivityPointCfg obj = new STBackGameActivityPointCfg();
/* 165 */           obj.loadFromXml(elem);
/* 166 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 167 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 178 */     all = new HashMap();
/*     */     
/* 180 */     String path = dir + "mzm.gsp.activity3.confbean.STBackGameActivityPointCfg.bny";
/*     */     try
/*     */     {
/* 183 */       File file = new File(path);
/* 184 */       if (file.exists())
/*     */       {
/* 186 */         byte[] bytes = new byte['Ѐ'];
/* 187 */         FileInputStream fis = new FileInputStream(file);
/* 188 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 189 */         int len = 0;
/* 190 */         while ((len = fis.read(bytes)) > 0)
/* 191 */           baos.write(bytes, 0, len);
/* 192 */         fis.close();
/* 193 */         bytes = baos.toByteArray();
/* 194 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 195 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 197 */           _os_.unmarshal_int();
/* 198 */           _os_.unmarshal_int();
/* 199 */           _os_.unmarshal_int();
/*     */         }
/* 201 */         _os_.unmarshal_int();
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 205 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 207 */           STBackGameActivityPointCfg _v_ = new STBackGameActivityPointCfg();
/* 208 */           _v_.unmarshal(_os_);
/* 209 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 210 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 215 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 220 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STBackGameActivityPointCfg> all)
/*     */   {
/* 227 */     String path = dir + "mzm.gsp.activity3.confbean.STBackGameActivityPointCfg.bny";
/*     */     try
/*     */     {
/* 230 */       File file = new File(path);
/* 231 */       if (file.exists())
/*     */       {
/* 233 */         byte[] bytes = new byte['Ѐ'];
/* 234 */         FileInputStream fis = new FileInputStream(file);
/* 235 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 236 */         int len = 0;
/* 237 */         while ((len = fis.read(bytes)) > 0)
/* 238 */           baos.write(bytes, 0, len);
/* 239 */         fis.close();
/* 240 */         bytes = baos.toByteArray();
/* 241 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 244 */           _os_.unmarshal_int();
/* 245 */           _os_.unmarshal_int();
/* 246 */           _os_.unmarshal_int();
/*     */         }
/* 248 */         _os_.unmarshal_int();
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 252 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 254 */           STBackGameActivityPointCfg _v_ = new STBackGameActivityPointCfg();
/* 255 */           _v_.unmarshal(_os_);
/* 256 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 257 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 262 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 267 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STBackGameActivityPointCfg getOld(int key)
/*     */   {
/* 275 */     return (STBackGameActivityPointCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STBackGameActivityPointCfg get(int key)
/*     */   {
/* 280 */     return (STBackGameActivityPointCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STBackGameActivityPointCfg> getOldAll()
/*     */   {
/* 285 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STBackGameActivityPointCfg> getAll()
/*     */   {
/* 290 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STBackGameActivityPointCfg> newAll)
/*     */   {
/* 295 */     oldAll = all;
/* 296 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 301 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\STBackGameActivityPointCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */