/*     */ package mzm.gsp.singlebattle.confbean;
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
/*     */ public class SBuffPlayCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBuffPlayCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBuffPlayCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int disappear_interval_in_minute;
/*     */   public int max_refresh_interval_in_minute;
/*     */   public int min_refresh_interval_in_minute;
/*  22 */   public HashMap<Integer, BuffInfo> buff_infos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  27 */     this.disappear_interval_in_minute = Integer.valueOf(rootElement.attributeValue("disappear_interval_in_minute")).intValue();
/*  28 */     this.max_refresh_interval_in_minute = Integer.valueOf(rootElement.attributeValue("max_refresh_interval_in_minute")).intValue();
/*  29 */     this.min_refresh_interval_in_minute = Integer.valueOf(rootElement.attributeValue("min_refresh_interval_in_minute")).intValue();
/*     */     
/*  31 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "buff_infos");
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
/*  59 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.singlebattle.confbean.BuffInfo")))
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
/*     */         BuffInfo _v_;
/*     */         try
/*     */         {
/*  74 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  75 */           _v_ = new BuffInfo();
/*  76 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.buff_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  90 */     _os_.marshal(this.id);
/*  91 */     _os_.marshal(this.disappear_interval_in_minute);
/*  92 */     _os_.marshal(this.max_refresh_interval_in_minute);
/*  93 */     _os_.marshal(this.min_refresh_interval_in_minute);
/*  94 */     _os_.compact_uint32(this.buff_infos.size());
/*  95 */     for (java.util.Map.Entry<Integer, BuffInfo> _e_ : this.buff_infos.entrySet())
/*     */     {
/*  97 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  98 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 105 */     this.id = _os_.unmarshal_int();
/* 106 */     this.disappear_interval_in_minute = _os_.unmarshal_int();
/* 107 */     this.max_refresh_interval_in_minute = _os_.unmarshal_int();
/* 108 */     this.min_refresh_interval_in_minute = _os_.unmarshal_int();
/* 109 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 112 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 114 */       BuffInfo _v_ = new BuffInfo();
/* 115 */       _v_.unmarshal(_os_);
/* 116 */       this.buff_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 118 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 123 */     String path = dir + "mzm.gsp.singlebattle.confbean.SBuffPlayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 127 */       all = new HashMap();
/* 128 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 129 */       org.dom4j.Document doc = reader.read(new File(path));
/* 130 */       Element root = doc.getRootElement();
/* 131 */       List<?> nodeList = root.elements();
/* 132 */       int len = nodeList.size();
/* 133 */       for (int i = 0; i < len; i++)
/*     */       {
/* 135 */         Element elem = (Element)nodeList.get(i);
/* 136 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.singlebattle.confbean.SBuffPlayCfg"))
/*     */         {
/*     */ 
/* 139 */           SBuffPlayCfg obj = new SBuffPlayCfg();
/* 140 */           obj.loadFromXml(elem);
/* 141 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 142 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 147 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBuffPlayCfg> all)
/*     */   {
/* 153 */     String path = dir + "mzm.gsp.singlebattle.confbean.SBuffPlayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 157 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 158 */       org.dom4j.Document doc = reader.read(new File(path));
/* 159 */       Element root = doc.getRootElement();
/* 160 */       List<?> nodeList = root.elements();
/* 161 */       int len = nodeList.size();
/* 162 */       for (int i = 0; i < len; i++)
/*     */       {
/* 164 */         Element elem = (Element)nodeList.get(i);
/* 165 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.singlebattle.confbean.SBuffPlayCfg"))
/*     */         {
/*     */ 
/* 168 */           SBuffPlayCfg obj = new SBuffPlayCfg();
/* 169 */           obj.loadFromXml(elem);
/* 170 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 171 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 182 */     all = new HashMap();
/*     */     
/* 184 */     String path = dir + "mzm.gsp.singlebattle.confbean.SBuffPlayCfg.bny";
/*     */     try
/*     */     {
/* 187 */       File file = new File(path);
/* 188 */       if (file.exists())
/*     */       {
/* 190 */         byte[] bytes = new byte['Ѐ'];
/* 191 */         FileInputStream fis = new FileInputStream(file);
/* 192 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 193 */         int len = 0;
/* 194 */         while ((len = fis.read(bytes)) > 0)
/* 195 */           baos.write(bytes, 0, len);
/* 196 */         fis.close();
/* 197 */         bytes = baos.toByteArray();
/* 198 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 199 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/* 203 */           _os_.unmarshal_int();
/*     */         }
/* 205 */         _os_.unmarshal_int();
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 209 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 211 */           SBuffPlayCfg _v_ = new SBuffPlayCfg();
/* 212 */           _v_.unmarshal(_os_);
/* 213 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 219 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 224 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBuffPlayCfg> all)
/*     */   {
/* 231 */     String path = dir + "mzm.gsp.singlebattle.confbean.SBuffPlayCfg.bny";
/*     */     try
/*     */     {
/* 234 */       File file = new File(path);
/* 235 */       if (file.exists())
/*     */       {
/* 237 */         byte[] bytes = new byte['Ѐ'];
/* 238 */         FileInputStream fis = new FileInputStream(file);
/* 239 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 240 */         int len = 0;
/* 241 */         while ((len = fis.read(bytes)) > 0)
/* 242 */           baos.write(bytes, 0, len);
/* 243 */         fis.close();
/* 244 */         bytes = baos.toByteArray();
/* 245 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 246 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 248 */           _os_.unmarshal_int();
/* 249 */           _os_.unmarshal_int();
/* 250 */           _os_.unmarshal_int();
/*     */         }
/* 252 */         _os_.unmarshal_int();
/* 253 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 256 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 258 */           SBuffPlayCfg _v_ = new SBuffPlayCfg();
/* 259 */           _v_.unmarshal(_os_);
/* 260 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 261 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 266 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 271 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBuffPlayCfg getOld(int key)
/*     */   {
/* 279 */     return (SBuffPlayCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBuffPlayCfg get(int key)
/*     */   {
/* 284 */     return (SBuffPlayCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBuffPlayCfg> getOldAll()
/*     */   {
/* 289 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBuffPlayCfg> getAll()
/*     */   {
/* 294 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBuffPlayCfg> newAll)
/*     */   {
/* 299 */     oldAll = all;
/* 300 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 305 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\confbean\SBuffPlayCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */