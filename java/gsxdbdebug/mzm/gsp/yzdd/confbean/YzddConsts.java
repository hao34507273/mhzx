/*     */ package mzm.gsp.yzdd.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class YzddConsts
/*     */ {
/*  16 */   private static volatile YzddConsts oldInstance = null;
/*  17 */   private static YzddConsts instance = new YzddConsts();
/*     */   public int ActivityId;
/*     */   public int PerpareMapId;
/*     */   public int PerpareMinute;
/*     */   public int PKMinute;
/*     */   public int EndMinute;
/*     */   public int LogicType;
/*     */   public int MapId1;
/*     */   public int MapId2;
/*     */   public int MapId3;
/*     */   public int ControllerId;
/*     */   public int ModelId;
/*     */   public String GuanJunAward;
/*     */   public String YaJunAward;
/*     */   public String JiJunAward;
/*     */   public String CanyuAward;
/*     */   public String RoleName;
/*     */   
/*     */   public static YzddConsts getOldInstance()
/*     */   {
/*  37 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static YzddConsts getInstance() {
/*  41 */     return instance;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir) {
/*  45 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  50 */     String path = dir + "mzm.gsp.yzdd.confbean.YzddConsts.xml";
/*     */     try {
/*  52 */       Element root = new SAXReader().read(new File(path)).getRootElement();
/*  53 */       Map<String, Element> data = new java.util.HashMap();
/*  54 */       List<?> nodeList = root.elements();
/*  55 */       int len = nodeList.size();
/*  56 */       for (int i = 0; i < len; i++) {
/*  57 */         Element element = (Element)nodeList.get(i);
/*  58 */         if (element.getName().equalsIgnoreCase("row")) {
/*  59 */           String name = element.attributeValue("name");
/*  60 */           if (data.put(name, element) != null) {
/*  61 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/*  65 */       this.ActivityId = Integer.valueOf(((Element)data.get("ActivityId")).attributeValue("value")).intValue();
/*  66 */       this.LogicType = Integer.valueOf(((Element)data.get("LogicType")).attributeValue("value")).intValue();
/*  67 */       this.MapId1 = Integer.valueOf(((Element)data.get("MapId1")).attributeValue("value")).intValue();
/*  68 */       this.MapId2 = Integer.valueOf(((Element)data.get("MapId2")).attributeValue("value")).intValue();
/*  69 */       this.MapId3 = Integer.valueOf(((Element)data.get("MapId3")).attributeValue("value")).intValue();
/*  70 */       this.GuanJunAward = ((Element)data.get("GuanJunAward")).attributeValue("value");
/*  71 */       this.YaJunAward = ((Element)data.get("YaJunAward")).attributeValue("value");
/*  72 */       this.JiJunAward = ((Element)data.get("JiJunAward")).attributeValue("value");
/*  73 */       this.CanyuAward = ((Element)data.get("CanyuAward")).attributeValue("value");
/*  74 */       this.RoleName = ((Element)data.get("RoleName")).attributeValue("value");
/*  75 */       this.PerpareMapId = Integer.valueOf(((Element)data.get("PerpareMapId")).attributeValue("value")).intValue();
/*  76 */       this.PerpareMinute = Integer.valueOf(((Element)data.get("PerpareMinute")).attributeValue("value")).intValue();
/*  77 */       this.PKMinute = Integer.valueOf(((Element)data.get("PKMinute")).attributeValue("value")).intValue();
/*  78 */       this.EndMinute = Integer.valueOf(((Element)data.get("EndMinute")).attributeValue("value")).intValue();
/*  79 */       this.ControllerId = Integer.valueOf(((Element)data.get("ControllerId")).attributeValue("value")).intValue();
/*  80 */       this.ModelId = Integer.valueOf(((Element)data.get("ModelId")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e) {
/*  83 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  88 */     String path = dir + "mzm.gsp.yzdd.confbean.YzddConsts.xml";
/*     */     try {
/*  90 */       Element root = new SAXReader().read(new File(path)).getRootElement();
/*  91 */       Map<String, Element> data = new java.util.HashMap();
/*  92 */       List<?> nodeList = root.elements();
/*  93 */       int len = nodeList.size();
/*  94 */       for (int i = 0; i < len; i++) {
/*  95 */         Element element = (Element)nodeList.get(i);
/*  96 */         if (element.getName().equalsIgnoreCase("row")) {
/*  97 */           String name = element.attributeValue("name");
/*  98 */           if (data.put(name, element) != null) {
/*  99 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/* 103 */       this.ActivityId = Integer.valueOf(((Element)data.get("ActivityId")).attributeValue("value")).intValue();
/* 104 */       this.LogicType = Integer.valueOf(((Element)data.get("LogicType")).attributeValue("value")).intValue();
/* 105 */       this.MapId1 = Integer.valueOf(((Element)data.get("MapId1")).attributeValue("value")).intValue();
/* 106 */       this.MapId2 = Integer.valueOf(((Element)data.get("MapId2")).attributeValue("value")).intValue();
/* 107 */       this.MapId3 = Integer.valueOf(((Element)data.get("MapId3")).attributeValue("value")).intValue();
/* 108 */       this.GuanJunAward = ((Element)data.get("GuanJunAward")).attributeValue("value");
/* 109 */       this.YaJunAward = ((Element)data.get("YaJunAward")).attributeValue("value");
/* 110 */       this.JiJunAward = ((Element)data.get("JiJunAward")).attributeValue("value");
/* 111 */       this.CanyuAward = ((Element)data.get("CanyuAward")).attributeValue("value");
/* 112 */       this.RoleName = ((Element)data.get("RoleName")).attributeValue("value");
/* 113 */       this.PerpareMapId = Integer.valueOf(((Element)data.get("PerpareMapId")).attributeValue("value")).intValue();
/* 114 */       this.PerpareMinute = Integer.valueOf(((Element)data.get("PerpareMinute")).attributeValue("value")).intValue();
/* 115 */       this.PKMinute = Integer.valueOf(((Element)data.get("PKMinute")).attributeValue("value")).intValue();
/* 116 */       this.EndMinute = Integer.valueOf(((Element)data.get("EndMinute")).attributeValue("value")).intValue();
/* 117 */       this.ControllerId = Integer.valueOf(((Element)data.get("ControllerId")).attributeValue("value")).intValue();
/* 118 */       this.ModelId = Integer.valueOf(((Element)data.get("ModelId")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e) {
/* 121 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir) {
/* 126 */     instance._loadBny(dir);
/*     */   }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 130 */     String path = dir + "mzm.gsp.yzdd.confbean.YzddConsts.bny";
/*     */     try {
/* 132 */       File file = new File(path);
/* 133 */       if (file.exists()) {
/* 134 */         byte[] bytes = new byte['Ѐ'];
/* 135 */         FileInputStream fis = new FileInputStream(file);
/* 136 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 138 */           int len = fis.read(bytes);
/* 139 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 142 */           baos.write(bytes, 0, len);
/*     */         }
/* 144 */         fis.close();
/* 145 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 146 */         this.ActivityId = _os_.unmarshal_int();
/* 147 */         this.LogicType = _os_.unmarshal_int();
/* 148 */         this.MapId1 = _os_.unmarshal_int();
/* 149 */         this.MapId2 = _os_.unmarshal_int();
/* 150 */         this.MapId3 = _os_.unmarshal_int();
/* 151 */         this.GuanJunAward = _os_.unmarshal_String("UTF-8");
/* 152 */         this.YaJunAward = _os_.unmarshal_String("UTF-8");
/* 153 */         this.JiJunAward = _os_.unmarshal_String("UTF-8");
/* 154 */         this.CanyuAward = _os_.unmarshal_String("UTF-8");
/* 155 */         this.RoleName = _os_.unmarshal_String("UTF-8");
/* 156 */         this.PerpareMapId = _os_.unmarshal_int();
/* 157 */         this.PerpareMinute = _os_.unmarshal_int();
/* 158 */         this.PKMinute = _os_.unmarshal_int();
/* 159 */         this.EndMinute = _os_.unmarshal_int();
/* 160 */         this.ControllerId = _os_.unmarshal_int();
/* 161 */         this.ModelId = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 166 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir) {
/* 171 */     String path = dir + "mzm.gsp.yzdd.confbean.YzddConsts.bny";
/*     */     try {
/* 173 */       File file = new File(path);
/* 174 */       if (file.exists()) {
/* 175 */         byte[] bytes = new byte['Ѐ'];
/* 176 */         FileInputStream fis = new FileInputStream(file);
/* 177 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 179 */           int len = fis.read(bytes);
/* 180 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 183 */           baos.write(bytes, 0, len);
/*     */         }
/* 185 */         fis.close();
/* 186 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 187 */         this.ActivityId = _os_.unmarshal_int();
/* 188 */         this.LogicType = _os_.unmarshal_int();
/* 189 */         this.MapId1 = _os_.unmarshal_int();
/* 190 */         this.MapId2 = _os_.unmarshal_int();
/* 191 */         this.MapId3 = _os_.unmarshal_int();
/* 192 */         this.GuanJunAward = _os_.unmarshal_String("UTF-8");
/* 193 */         this.YaJunAward = _os_.unmarshal_String("UTF-8");
/* 194 */         this.JiJunAward = _os_.unmarshal_String("UTF-8");
/* 195 */         this.CanyuAward = _os_.unmarshal_String("UTF-8");
/* 196 */         this.RoleName = _os_.unmarshal_String("UTF-8");
/* 197 */         this.PerpareMapId = _os_.unmarshal_int();
/* 198 */         this.PerpareMinute = _os_.unmarshal_int();
/* 199 */         this.PKMinute = _os_.unmarshal_int();
/* 200 */         this.EndMinute = _os_.unmarshal_int();
/* 201 */         this.ControllerId = _os_.unmarshal_int();
/* 202 */         this.ModelId = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 206 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(YzddConsts newInstance) {
/* 211 */     oldInstance = instance;
/* 212 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 217 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yzdd\confbean\YzddConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */