/*     */ package mzm.gsp.map.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMapXLSConf implements Marshal
/*     */ {
/*  18 */   private static volatile Map<Integer, SMapXLSConf> oldAll = null;
/*  19 */   private static Map<Integer, SMapXLSConf> all = null;
/*     */   public int id;
/*     */   public String mapResPath;
/*     */   public String mapName;
/*     */   public int width;
/*     */   public int height;
/*     */   public String miniMapPath;
/*     */   public int mapType;
/*     */   public int mapMarkValue;
/*     */   public int minMeetMonsterGrids;
/*     */   public double meetMonsterProp;
/*     */   public int darkMonsterTableId;
/*     */   public int defaultTransposX;
/*     */   public int defaultTransposy;
/*     */   public boolean canFly;
/*     */   public int channelCapacity;
/*     */   public boolean canPK;
/*     */   public boolean canArrestWanted;
/*     */   public boolean canDirectTransfer;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  41 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  42 */     this.mapResPath = rootElement.attributeValue("mapResPath");
/*  43 */     this.mapName = rootElement.attributeValue("mapName");
/*  44 */     this.width = Integer.valueOf(rootElement.attributeValue("width")).intValue();
/*  45 */     this.height = Integer.valueOf(rootElement.attributeValue("height")).intValue();
/*  46 */     this.miniMapPath = rootElement.attributeValue("miniMapPath");
/*  47 */     this.mapType = Integer.valueOf(rootElement.attributeValue("mapType")).intValue();
/*  48 */     this.mapMarkValue = Integer.valueOf(rootElement.attributeValue("mapMarkValue")).intValue();
/*  49 */     this.minMeetMonsterGrids = Integer.valueOf(rootElement.attributeValue("minMeetMonsterGrids")).intValue();
/*  50 */     this.meetMonsterProp = Double.valueOf(rootElement.attributeValue("meetMonsterProp")).doubleValue();
/*  51 */     this.darkMonsterTableId = Integer.valueOf(rootElement.attributeValue("darkMonsterTableId")).intValue();
/*  52 */     this.defaultTransposX = Integer.valueOf(rootElement.attributeValue("defaultTransposX")).intValue();
/*  53 */     this.defaultTransposy = Integer.valueOf(rootElement.attributeValue("defaultTransposy")).intValue();
/*  54 */     this.canFly = Boolean.valueOf(rootElement.attributeValue("canFly")).booleanValue();
/*  55 */     this.channelCapacity = Integer.valueOf(rootElement.attributeValue("channelCapacity")).intValue();
/*  56 */     this.canPK = Boolean.valueOf(rootElement.attributeValue("canPK")).booleanValue();
/*  57 */     this.canArrestWanted = Boolean.valueOf(rootElement.attributeValue("canArrestWanted")).booleanValue();
/*  58 */     this.canDirectTransfer = Boolean.valueOf(rootElement.attributeValue("canDirectTransfer")).booleanValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  63 */     _os_.marshal(this.id);
/*  64 */     _os_.marshal(this.mapResPath, "UTF-8");
/*  65 */     _os_.marshal(this.mapName, "UTF-8");
/*  66 */     _os_.marshal(this.width);
/*  67 */     _os_.marshal(this.height);
/*  68 */     _os_.marshal(this.miniMapPath, "UTF-8");
/*  69 */     _os_.marshal(this.mapType);
/*  70 */     _os_.marshal(this.mapMarkValue);
/*  71 */     _os_.marshal(this.minMeetMonsterGrids);
/*  72 */     _os_.marshal(this.meetMonsterProp);
/*  73 */     _os_.marshal(this.darkMonsterTableId);
/*  74 */     _os_.marshal(this.defaultTransposX);
/*  75 */     _os_.marshal(this.defaultTransposy);
/*  76 */     _os_.marshal(this.canFly);
/*  77 */     _os_.marshal(this.channelCapacity);
/*  78 */     _os_.marshal(this.canPK);
/*  79 */     _os_.marshal(this.canArrestWanted);
/*  80 */     _os_.marshal(this.canDirectTransfer);
/*     */     
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  86 */     this.id = _os_.unmarshal_int();
/*  87 */     this.mapResPath = _os_.unmarshal_String("UTF-8");
/*  88 */     this.mapName = _os_.unmarshal_String("UTF-8");
/*  89 */     this.width = _os_.unmarshal_int();
/*  90 */     this.height = _os_.unmarshal_int();
/*  91 */     this.miniMapPath = _os_.unmarshal_String("UTF-8");
/*  92 */     this.mapType = _os_.unmarshal_int();
/*  93 */     this.mapMarkValue = _os_.unmarshal_int();
/*  94 */     this.minMeetMonsterGrids = _os_.unmarshal_int();
/*  95 */     this.meetMonsterProp = _os_.unmarshal_float();
/*  96 */     this.darkMonsterTableId = _os_.unmarshal_int();
/*  97 */     this.defaultTransposX = _os_.unmarshal_int();
/*  98 */     this.defaultTransposy = _os_.unmarshal_int();
/*  99 */     this.canFly = _os_.unmarshal_boolean();
/* 100 */     this.channelCapacity = _os_.unmarshal_int();
/* 101 */     this.canPK = _os_.unmarshal_boolean();
/* 102 */     this.canArrestWanted = _os_.unmarshal_boolean();
/* 103 */     this.canDirectTransfer = _os_.unmarshal_boolean();
/*     */     
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir) {
/* 109 */     String path = dir + "mzm.gsp.map.confbean.SMapXLSConf.xml";
/*     */     try {
/* 111 */       all = new HashMap();
/* 112 */       SAXReader reader = new SAXReader();
/* 113 */       Document doc = reader.read(new File(path));
/* 114 */       Element root = doc.getRootElement();
/* 115 */       List<?> nodeList = root.elements();
/* 116 */       int len = nodeList.size();
/* 117 */       for (int i = 0; i < len; i++) {
/* 118 */         Element elem = (Element)nodeList.get(i);
/* 119 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapXLSConf")) {
/* 120 */           SMapXLSConf obj = new SMapXLSConf();
/* 121 */           obj.loadFromXml(elem);
/* 122 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 123 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 128 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMapXLSConf> all2) {
/* 133 */     String path = dir + "mzm.gsp.map.confbean.SMapXLSConf.xml";
/*     */     try {
/* 135 */       SAXReader reader = new SAXReader();
/* 136 */       Document doc = reader.read(new File(path));
/* 137 */       Element root = doc.getRootElement();
/* 138 */       List<?> nodeList = root.elements();
/* 139 */       int len = nodeList.size();
/* 140 */       for (int i = 0; i < len; i++) {
/* 141 */         Element elem = (Element)nodeList.get(i);
/* 142 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapXLSConf")) {
/* 143 */           SMapXLSConf obj = new SMapXLSConf();
/* 144 */           obj.loadFromXml(elem);
/* 145 */           if (all2.put(Integer.valueOf(obj.id), obj) != null) {
/* 146 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 151 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir) {
/* 156 */     all = new HashMap();
/* 157 */     String path = dir + "mzm.gsp.map.confbean.SMapXLSConf.bny";
/*     */     try {
/* 159 */       File file = new File(path);
/* 160 */       if (file.exists()) {
/* 161 */         byte[] bytes = new byte['Ѐ'];
/* 162 */         FileInputStream fis = new FileInputStream(file);
/* 163 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 165 */           int len = fis.read(bytes);
/* 166 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 169 */           baos.write(bytes, 0, len);
/*     */         }
/* 171 */         fis.close();
/* 172 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 173 */         for (int i = _os_.uncompact_uint32(); i > 0; i--) {
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/* 176 */           _os_.unmarshal_int();
/*     */         }
/* 178 */         _os_.unmarshal_int();
/* 179 */         for (int i2 = _os_.uncompact_uint32(); i2 > 0; i2--) {
/* 180 */           int _k_ = _os_.unmarshal_int();
/* 181 */           SMapXLSConf _v_ = new SMapXLSConf();
/* 182 */           _v_.unmarshal(_os_);
/* 183 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 184 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/* 187 */         return;
/*     */       }
/* 189 */       throw new RuntimeException("file not exist : " + path);
/*     */     } catch (Exception e) {
/* 191 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadBny(String dir, Map<Integer, SMapXLSConf> all2) {
/* 196 */     String path = dir + "mzm.gsp.map.confbean.SMapXLSConf.bny";
/*     */     try {
/* 198 */       File file = new File(path);
/* 199 */       if (file.exists()) {
/* 200 */         byte[] bytes = new byte['Ѐ'];
/* 201 */         FileInputStream fis = new FileInputStream(file);
/* 202 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 204 */           int len = fis.read(bytes);
/* 205 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 208 */           baos.write(bytes, 0, len);
/*     */         }
/* 210 */         fis.close();
/* 211 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 212 */         for (int i = _os_.uncompact_uint32(); i > 0; i--) {
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/* 215 */           _os_.unmarshal_int();
/*     */         }
/* 217 */         _os_.unmarshal_int();
/* 218 */         for (int i2 = _os_.uncompact_uint32(); i2 > 0; i2--) {
/* 219 */           int _k_ = _os_.unmarshal_int();
/* 220 */           SMapXLSConf _v_ = new SMapXLSConf();
/* 221 */           _v_.unmarshal(_os_);
/* 222 */           if (all2.put(Integer.valueOf(_k_), _v_) != null) {
/* 223 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/* 226 */         return;
/*     */       }
/* 228 */       throw new RuntimeException("file not exist : " + path);
/*     */     } catch (Exception e) {
/* 230 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static SMapXLSConf getOld(int key) {
/* 235 */     return (SMapXLSConf)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMapXLSConf get(int key) {
/* 239 */     return (SMapXLSConf)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapXLSConf> getOldAll() {
/* 243 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapXLSConf> getAll() {
/* 247 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMapXLSConf> newAll) {
/* 251 */     oldAll = all;
/* 252 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll() {
/* 256 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapXLSConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */