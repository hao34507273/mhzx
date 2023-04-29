/*     */ package mzm.gsp.map.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ import util.XmlHelper;
/*     */ 
/*     */ public class SMapGlobalConfig implements Marshal
/*     */ {
/*  22 */   private static volatile Map<Integer, SMapGlobalConfig> oldAll = null;
/*  23 */   private static Map<Integer, SMapGlobalConfig> all = null;
/*     */   public int id;
/*  25 */   public HashSet<Integer> worldMapCfgids = new HashSet();
/*  26 */   public Map<Integer, Boolean> pkFailTrans = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement) {
/*  29 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  30 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "worldMapCfgids");
/*  31 */     if (collectionElement == null) {
/*  32 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*  34 */     List<?> _nodeList = collectionElement.elements();
/*  35 */     int _len = _nodeList.size();
/*  36 */     for (int i = 0; i < _len; i++) {
/*  37 */       Element elem = (Element)_nodeList.get(i);
/*  38 */       if (elem.getName().equalsIgnoreCase("int")) {
/*     */         try {
/*  40 */           int _v_ = Integer.valueOf(elem.getText()).intValue();
/*  41 */           this.worldMapCfgids.add(Integer.valueOf(_v_));
/*     */         }
/*     */         catch (Exception e) {}
/*     */       }
/*     */     }
/*  46 */     Element collectionElement1 = XmlHelper.getVariableElement(rootElement, "PKFailTrans");
/*  47 */     if (collectionElement == null) {
/*  48 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*  50 */     List<?> _nodeList1 = collectionElement1.elements();
/*  51 */     int _len1 = _nodeList1.size();
/*  52 */     for (int i = 0; i < _len1; i++) {
/*  53 */       Element elem = (Element)_nodeList1.get(i);
/*  54 */       if (elem.getName().equalsIgnoreCase("TransData")) {
/*     */         try {
/*  56 */           int _v_ = Integer.valueOf(elem.attributeValue("mapid")).intValue();
/*  57 */           boolean _c = Boolean.valueOf(elem.attributeValue("trans")).booleanValue();
/*  58 */           this.pkFailTrans.put(Integer.valueOf(_v_), Boolean.valueOf(_c));
/*     */         }
/*     */         catch (Exception e) {}
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  66 */     _os_.marshal(this.id);
/*  67 */     _os_.compact_uint32(this.worldMapCfgids.size());
/*  68 */     Iterator<Integer> i$ = this.worldMapCfgids.iterator();
/*  69 */     while (i$.hasNext()) {
/*  70 */       Integer _v_ = (Integer)i$.next();
/*  71 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  73 */     _os_.compact_uint32(this.pkFailTrans.size());
/*  74 */     for (Map.Entry<Integer, Boolean> entry : this.pkFailTrans.entrySet()) {
/*  75 */       _os_.marshal(((Integer)entry.getKey()).intValue());
/*  76 */       _os_.marshal(((Boolean)entry.getValue()).booleanValue());
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  82 */     this.id = _os_.unmarshal_int();
/*  83 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  84 */       int _v_ = _os_.unmarshal_int();
/*  85 */       this.worldMapCfgids.add(Integer.valueOf(_v_));
/*     */     }
/*  87 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  88 */       int _v_ = _os_.unmarshal_int();
/*  89 */       boolean x = _os_.unmarshal_boolean();
/*  90 */       this.pkFailTrans.put(Integer.valueOf(_v_), Boolean.valueOf(x));
/*     */     }
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir) {
/*  96 */     String path = dir + "mzm.gsp.map.confbean.SMapGlobalConfig.xml";
/*     */     try {
/*  98 */       all = new HashMap();
/*  99 */       SAXReader reader = new SAXReader();
/* 100 */       Document doc = reader.read(new File(path));
/* 101 */       Element root = doc.getRootElement();
/* 102 */       List<?> nodeList = root.elements();
/* 103 */       int len = nodeList.size();
/* 104 */       for (int i = 0; i < len; i++) {
/* 105 */         Element elem = (Element)nodeList.get(i);
/* 106 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapGlobalConfig")) {
/* 107 */           SMapGlobalConfig obj = new SMapGlobalConfig();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMapGlobalConfig> all2) {
/* 120 */     String path = dir + "mzm.gsp.map.confbean.SMapGlobalConfig.xml";
/*     */     try {
/* 122 */       SAXReader reader = new SAXReader();
/* 123 */       Document doc = reader.read(new File(path));
/* 124 */       Element root = doc.getRootElement();
/* 125 */       List<?> nodeList = root.elements();
/* 126 */       int len = nodeList.size();
/* 127 */       for (int i = 0; i < len; i++) {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapGlobalConfig")) {
/* 130 */           SMapGlobalConfig obj = new SMapGlobalConfig();
/* 131 */           obj.loadFromXml(elem);
/* 132 */           if (all2.put(Integer.valueOf(obj.id), obj) != null) {
/* 133 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 138 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir) {
/* 143 */     all = new HashMap();
/* 144 */     String path = dir + "mzm.gsp.map.confbean.SMapGlobalConfig.bny";
/*     */     try {
/* 146 */       File file = new File(path);
/* 147 */       if (file.exists()) {
/* 148 */         byte[] bytes = new byte['Ѐ'];
/* 149 */         FileInputStream fis = new FileInputStream(file);
/* 150 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 152 */           int len = fis.read(bytes);
/* 153 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 156 */           baos.write(bytes, 0, len);
/*     */         }
/* 158 */         fis.close();
/* 159 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 160 */         for (int i = _os_.uncompact_uint32(); i > 0; i--) {
/* 161 */           _os_.unmarshal_int();
/* 162 */           _os_.unmarshal_int();
/* 163 */           _os_.unmarshal_int();
/*     */         }
/* 165 */         _os_.unmarshal_int();
/* 166 */         for (int i2 = _os_.uncompact_uint32(); i2 > 0; i2--) {
/* 167 */           int _k_ = _os_.unmarshal_int();
/* 168 */           SMapGlobalConfig _v_ = new SMapGlobalConfig();
/* 169 */           _v_.unmarshal(_os_);
/* 170 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 171 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/* 174 */         return;
/*     */       }
/* 176 */       throw new RuntimeException("file not exist : " + path);
/*     */     } catch (Exception e) {
/* 178 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadBny(String dir, Map<Integer, SMapGlobalConfig> all2) {
/* 183 */     String path = dir + "mzm.gsp.map.confbean.SMapGlobalConfig.bny";
/*     */     try {
/* 185 */       File file = new File(path);
/* 186 */       if (file.exists()) {
/* 187 */         byte[] bytes = new byte['Ѐ'];
/* 188 */         FileInputStream fis = new FileInputStream(file);
/* 189 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 191 */           int len = fis.read(bytes);
/* 192 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 195 */           baos.write(bytes, 0, len);
/*     */         }
/* 197 */         fis.close();
/* 198 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 199 */         for (int i = _os_.uncompact_uint32(); i > 0; i--) {
/* 200 */           _os_.unmarshal_int();
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/*     */         }
/* 204 */         _os_.unmarshal_int();
/* 205 */         for (int i2 = _os_.uncompact_uint32(); i2 > 0; i2--) {
/* 206 */           int _k_ = _os_.unmarshal_int();
/* 207 */           SMapGlobalConfig _v_ = new SMapGlobalConfig();
/* 208 */           _v_.unmarshal(_os_);
/* 209 */           if (all2.put(Integer.valueOf(_k_), _v_) != null) {
/* 210 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/* 213 */         return;
/*     */       }
/* 215 */       throw new RuntimeException("file not exist : " + path);
/*     */     } catch (Exception e) {
/* 217 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static SMapGlobalConfig getOld(int key) {
/* 222 */     return (SMapGlobalConfig)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMapGlobalConfig get(int key) {
/* 226 */     return (SMapGlobalConfig)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapGlobalConfig> getOldAll() {
/* 230 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapGlobalConfig> getAll() {
/* 234 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMapGlobalConfig> newAll) {
/* 238 */     oldAll = all;
/* 239 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll() {
/* 243 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapGlobalConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */