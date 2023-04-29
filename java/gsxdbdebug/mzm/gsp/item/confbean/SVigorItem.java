/*     */ package mzm.gsp.item.confbean;
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
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SVigorItem extends SItemCfg implements Marshal
/*     */ {
/*  19 */   private static volatile Map<Integer, SVigorItem> oldAll = null;
/*  20 */   private static Map<Integer, SVigorItem> all = null;
/*     */   public int addVigorNum;
/*     */   public String MapName;
/*     */   public String Notice;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  29 */     this.name = rootElement.attributeValue("name");
/*  30 */     this.MapName = rootElement.attributeValue("MapName");
/*  31 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  32 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  33 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  34 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  35 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  36 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  37 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  38 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  39 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  40 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  41 */     this.addVigorNum = Integer.valueOf(rootElement.attributeValue("addVigorNum")).intValue();
/*  42 */     this.Notice = rootElement.attributeValue("Notice");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.type);
/*  49 */     _os_.marshal(this.name, "UTF-8");
/*  50 */     _os_.marshal(this.MapName, "UTF-8");
/*  51 */     _os_.marshal(this.namecolor);
/*  52 */     _os_.marshal(this.icon);
/*  53 */     _os_.marshal(this.pilemax);
/*  54 */     _os_.marshal(this.sellSilver);
/*  55 */     _os_.marshal(this.isProprietary);
/*  56 */     _os_.marshal(this.canSellAndThrow);
/*  57 */     _os_.marshal(this.awardRoleLevelMin);
/*  58 */     _os_.marshal(this.awardRoleLevelMax);
/*  59 */     _os_.marshal(this.useLevel);
/*  60 */     _os_.marshal(this.sort);
/*  61 */     _os_.marshal(this.addVigorNum);
/*  62 */     _os_.marshal(this.Notice, "UTF-8");
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     this.id = _os_.unmarshal_int();
/*  69 */     this.type = _os_.unmarshal_int();
/*  70 */     this.name = _os_.unmarshal_String("UTF-8");
/*  71 */     this.MapName = _os_.unmarshal_String("UTF-8");
/*  72 */     this.namecolor = _os_.unmarshal_int();
/*  73 */     this.icon = _os_.unmarshal_int();
/*  74 */     this.pilemax = _os_.unmarshal_int();
/*  75 */     this.sellSilver = _os_.unmarshal_int();
/*  76 */     this.isProprietary = _os_.unmarshal_boolean();
/*  77 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  78 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  79 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  80 */     this.useLevel = _os_.unmarshal_int();
/*  81 */     this.sort = _os_.unmarshal_int();
/*  82 */     this.addVigorNum = _os_.unmarshal_int();
/*  83 */     this.Notice = _os_.unmarshal_String("UTF-8");
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir) {
/*  88 */     String path = dir + "mzm.gsp.item.confbean.SVigorItem.xml";
/*     */     try {
/*  90 */       all = new HashMap();
/*  91 */       SAXReader reader = new SAXReader();
/*  92 */       Document doc = reader.read(new File(path));
/*  93 */       Element root = doc.getRootElement();
/*  94 */       List<?> nodeList = root.elements();
/*  95 */       int len = nodeList.size();
/*  96 */       for (int i = 0; i < len; i++) {
/*  97 */         Element elem = (Element)nodeList.get(i);
/*  98 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SVigorItem")) {
/*  99 */           SVigorItem obj = new SVigorItem();
/* 100 */           obj.loadFromXml(elem);
/* 101 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 102 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception var10) {
/* 107 */       throw new RuntimeException("load " + path + " failed", var10);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SVigorItem> all2) {
/* 112 */     String path = dir + "mzm.gsp.item.confbean.SVigorItem.xml";
/*     */     try {
/* 114 */       SAXReader reader = new SAXReader();
/* 115 */       Document doc = reader.read(new File(path));
/* 116 */       Element root = doc.getRootElement();
/* 117 */       List<?> nodeList = root.elements();
/* 118 */       int len = nodeList.size();
/* 119 */       for (int i = 0; i < len; i++) {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SVigorItem")) {
/* 122 */           SVigorItem obj = new SVigorItem();
/* 123 */           obj.loadFromXml(elem);
/* 124 */           if (all2.put(Integer.valueOf(obj.id), obj) != null) {
/* 125 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception var11) {
/* 130 */       throw new RuntimeException("load " + path + " failed", var11);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir) {
/* 135 */     all = new HashMap();
/* 136 */     String path = dir + "mzm.gsp.item.confbean.SVigorItem.bny";
/*     */     try {
/* 138 */       File file = new File(path);
/* 139 */       if (!file.exists()) {
/* 140 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/* 142 */       byte[] bytes = new byte['Ѐ'];
/* 143 */       FileInputStream fis = new FileInputStream(file);
/* 144 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */       for (;;) {
/* 146 */         int len = fis.read(bytes);
/* 147 */         if (len <= 0) {
/*     */           break;
/*     */         }
/* 150 */         baos.write(bytes, 0, len);
/*     */       }
/* 152 */       fis.close();
/* 153 */       OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 154 */       for (int i = _os_.uncompact_uint32(); i > 0; i--) {
/* 155 */         _os_.unmarshal_int();
/* 156 */         _os_.unmarshal_int();
/* 157 */         _os_.unmarshal_int();
/*     */       }
/* 159 */       _os_.unmarshal_int();
/* 160 */       for (int i2 = _os_.uncompact_uint32(); i2 > 0; i2--) {
/* 161 */         int _k_ = _os_.unmarshal_int();
/* 162 */         SVigorItem _v_ = new SVigorItem();
/* 163 */         _v_.unmarshal(_os_);
/* 164 */         if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 165 */           throw new RuntimeException("duplicate key : " + _k_);
/*     */         }
/*     */       }
/*     */     } catch (Exception var11) {
/* 169 */       throw new RuntimeException("load " + path + " failed", var11);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadBny(String dir, Map<Integer, SVigorItem> all2) {
/* 174 */     String path = dir + "mzm.gsp.item.confbean.SVigorItem.bny";
/*     */     try {
/* 176 */       File file = new File(path);
/* 177 */       if (!file.exists()) {
/* 178 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/* 180 */       byte[] bytes = new byte['Ѐ'];
/* 181 */       FileInputStream fis = new FileInputStream(file);
/* 182 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */       for (;;) {
/* 184 */         int len = fis.read(bytes);
/* 185 */         if (len <= 0) {
/*     */           break;
/*     */         }
/* 188 */         baos.write(bytes, 0, len);
/*     */       }
/* 190 */       fis.close();
/* 191 */       OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 192 */       for (int i = _os_.uncompact_uint32(); i > 0; i--) {
/* 193 */         _os_.unmarshal_int();
/* 194 */         _os_.unmarshal_int();
/* 195 */         _os_.unmarshal_int();
/*     */       }
/* 197 */       _os_.unmarshal_int();
/* 198 */       for (int i2 = _os_.uncompact_uint32(); i2 > 0; i2--) {
/* 199 */         int _k_ = _os_.unmarshal_int();
/* 200 */         SVigorItem _v_ = new SVigorItem();
/* 201 */         _v_.unmarshal(_os_);
/* 202 */         if (all2.put(Integer.valueOf(_k_), _v_) != null) {
/* 203 */           throw new RuntimeException("duplicate key : " + _k_);
/*     */         }
/*     */       }
/*     */     } catch (Exception var12) {
/* 207 */       throw new RuntimeException("load " + path + " failed", var12);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData() {
/* 212 */     for (Map.Entry<Integer, SVigorItem> entry : all.entrySet()) {
/* 213 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null) {
/* 214 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/* 216 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData(Map<Integer, SVigorItem> all2, Map<Integer, SItemCfg> parent) {
/* 221 */     for (Map.Entry<Integer, SVigorItem> entry : all2.entrySet()) {
/* 222 */       if (parent.get(entry.getKey()) != null) {
/* 223 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/* 225 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public static SVigorItem getOld(int key) {
/* 230 */     return (SVigorItem)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SVigorItem get(int key) {
/* 234 */     return (SVigorItem)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SVigorItem> getOldAllSelf() {
/* 238 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SVigorItem> getAllSelf() {
/* 242 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SVigorItem> newAll) {
/* 246 */     oldAll = all;
/* 247 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll() {
/* 251 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SVigorItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */