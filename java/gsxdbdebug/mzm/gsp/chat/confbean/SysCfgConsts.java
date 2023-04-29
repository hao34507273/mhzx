/*     */ package mzm.gsp.chat.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SysCfgConsts
/*     */ {
/*  13 */   private static volatile SysCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SysCfgConsts instance = new SysCfgConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SysCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SysCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int autoPlayVoiceMap = 1;
/*  32 */   public int autoPlayVoiceWorld = 1;
/*  33 */   public int autoPlayVoiceTeam = 1;
/*  34 */   public int autoPlayVoiceGang = 1;
/*  35 */   public int shieldMessageMap = -1;
/*  36 */   public int shieldMessageWorld = -1;
/*  37 */   public int shieldMessageTeam = -1;
/*  38 */   public int shieldMessageGang = -1;
/*  39 */   public int screenLv1 = 20;
/*  40 */   public int screenLv2 = 30;
/*  41 */   public int screenLv3 = 40;
/*     */   public int thresholdToShowMultiRoleMounts;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  46 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  51 */     String path = dir + "mzm.gsp.chat.confbean.SysCfgConsts.xml";
/*     */     try
/*     */     {
/*  54 */       SAXReader reader = new SAXReader();
/*  55 */       org.dom4j.Document doc = reader.read(new File(path));
/*  56 */       Element root = doc.getRootElement();
/*  57 */       Map<String, Element> data = new java.util.HashMap();
/*  58 */       java.util.List<?> nodeList = root.elements();
/*  59 */       int len = nodeList.size();
/*  60 */       for (int i = 0; i < len; i++)
/*     */       {
/*  62 */         Element element = (Element)nodeList.get(i);
/*  63 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  66 */           String name = element.attributeValue("name");
/*  67 */           if (data.put(name, element) != null)
/*  68 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  71 */       this.autoPlayVoiceMap = Integer.valueOf(((Element)data.get("autoPlayVoiceMap")).attributeValue("value")).intValue();
/*  72 */       this.autoPlayVoiceWorld = Integer.valueOf(((Element)data.get("autoPlayVoiceWorld")).attributeValue("value")).intValue();
/*  73 */       this.autoPlayVoiceTeam = Integer.valueOf(((Element)data.get("autoPlayVoiceTeam")).attributeValue("value")).intValue();
/*  74 */       this.autoPlayVoiceGang = Integer.valueOf(((Element)data.get("autoPlayVoiceGang")).attributeValue("value")).intValue();
/*  75 */       this.shieldMessageMap = Integer.valueOf(((Element)data.get("shieldMessageMap")).attributeValue("value")).intValue();
/*  76 */       this.shieldMessageWorld = Integer.valueOf(((Element)data.get("shieldMessageWorld")).attributeValue("value")).intValue();
/*  77 */       this.shieldMessageTeam = Integer.valueOf(((Element)data.get("shieldMessageTeam")).attributeValue("value")).intValue();
/*  78 */       this.shieldMessageGang = Integer.valueOf(((Element)data.get("shieldMessageGang")).attributeValue("value")).intValue();
/*  79 */       this.screenLv1 = Integer.valueOf(((Element)data.get("screenLv1")).attributeValue("value")).intValue();
/*  80 */       this.screenLv2 = Integer.valueOf(((Element)data.get("screenLv2")).attributeValue("value")).intValue();
/*  81 */       this.screenLv3 = Integer.valueOf(((Element)data.get("screenLv3")).attributeValue("value")).intValue();
/*  82 */       this.thresholdToShowMultiRoleMounts = Integer.valueOf(((Element)data.get("thresholdToShowMultiRoleMounts")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  86 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  91 */     String path = dir + "mzm.gsp.chat.confbean.SysCfgConsts.xml";
/*     */     try
/*     */     {
/*  94 */       SAXReader reader = new SAXReader();
/*  95 */       org.dom4j.Document doc = reader.read(new File(path));
/*  96 */       Element root = doc.getRootElement();
/*  97 */       Map<String, Element> data = new java.util.HashMap();
/*  98 */       java.util.List<?> nodeList = root.elements();
/*  99 */       int len = nodeList.size();
/* 100 */       for (int i = 0; i < len; i++)
/*     */       {
/* 102 */         Element element = (Element)nodeList.get(i);
/* 103 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 106 */           String name = element.attributeValue("name");
/* 107 */           if (data.put(name, element) != null)
/* 108 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 111 */       this.autoPlayVoiceMap = Integer.valueOf(((Element)data.get("autoPlayVoiceMap")).attributeValue("value")).intValue();
/* 112 */       this.autoPlayVoiceWorld = Integer.valueOf(((Element)data.get("autoPlayVoiceWorld")).attributeValue("value")).intValue();
/* 113 */       this.autoPlayVoiceTeam = Integer.valueOf(((Element)data.get("autoPlayVoiceTeam")).attributeValue("value")).intValue();
/* 114 */       this.autoPlayVoiceGang = Integer.valueOf(((Element)data.get("autoPlayVoiceGang")).attributeValue("value")).intValue();
/* 115 */       this.shieldMessageMap = Integer.valueOf(((Element)data.get("shieldMessageMap")).attributeValue("value")).intValue();
/* 116 */       this.shieldMessageWorld = Integer.valueOf(((Element)data.get("shieldMessageWorld")).attributeValue("value")).intValue();
/* 117 */       this.shieldMessageTeam = Integer.valueOf(((Element)data.get("shieldMessageTeam")).attributeValue("value")).intValue();
/* 118 */       this.shieldMessageGang = Integer.valueOf(((Element)data.get("shieldMessageGang")).attributeValue("value")).intValue();
/* 119 */       this.screenLv1 = Integer.valueOf(((Element)data.get("screenLv1")).attributeValue("value")).intValue();
/* 120 */       this.screenLv2 = Integer.valueOf(((Element)data.get("screenLv2")).attributeValue("value")).intValue();
/* 121 */       this.screenLv3 = Integer.valueOf(((Element)data.get("screenLv3")).attributeValue("value")).intValue();
/* 122 */       this.thresholdToShowMultiRoleMounts = Integer.valueOf(((Element)data.get("thresholdToShowMultiRoleMounts")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 126 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 130 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 133 */     String path = dir + "mzm.gsp.chat.confbean.SysCfgConsts.bny";
/*     */     try
/*     */     {
/* 136 */       File file = new File(path);
/* 137 */       if (file.exists())
/*     */       {
/* 139 */         byte[] bytes = new byte['Ѐ'];
/* 140 */         FileInputStream fis = new FileInputStream(file);
/* 141 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 142 */         int len = 0;
/* 143 */         while ((len = fis.read(bytes)) > 0)
/* 144 */           baos.write(bytes, 0, len);
/* 145 */         fis.close();
/* 146 */         bytes = baos.toByteArray();
/* 147 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 148 */         this.autoPlayVoiceMap = _os_.unmarshal_int();
/* 149 */         this.autoPlayVoiceWorld = _os_.unmarshal_int();
/* 150 */         this.autoPlayVoiceTeam = _os_.unmarshal_int();
/* 151 */         this.autoPlayVoiceGang = _os_.unmarshal_int();
/* 152 */         this.shieldMessageMap = _os_.unmarshal_int();
/* 153 */         this.shieldMessageWorld = _os_.unmarshal_int();
/* 154 */         this.shieldMessageTeam = _os_.unmarshal_int();
/* 155 */         this.shieldMessageGang = _os_.unmarshal_int();
/* 156 */         this.screenLv1 = _os_.unmarshal_int();
/* 157 */         this.screenLv2 = _os_.unmarshal_int();
/* 158 */         this.screenLv3 = _os_.unmarshal_int();
/* 159 */         this.thresholdToShowMultiRoleMounts = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 170 */     String path = dir + "mzm.gsp.chat.confbean.SysCfgConsts.bny";
/*     */     try
/*     */     {
/* 173 */       File file = new File(path);
/* 174 */       if (file.exists())
/*     */       {
/* 176 */         byte[] bytes = new byte['Ѐ'];
/* 177 */         FileInputStream fis = new FileInputStream(file);
/* 178 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 179 */         int len = 0;
/* 180 */         while ((len = fis.read(bytes)) > 0)
/* 181 */           baos.write(bytes, 0, len);
/* 182 */         fis.close();
/* 183 */         bytes = baos.toByteArray();
/* 184 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 185 */         this.autoPlayVoiceMap = _os_.unmarshal_int();
/* 186 */         this.autoPlayVoiceWorld = _os_.unmarshal_int();
/* 187 */         this.autoPlayVoiceTeam = _os_.unmarshal_int();
/* 188 */         this.autoPlayVoiceGang = _os_.unmarshal_int();
/* 189 */         this.shieldMessageMap = _os_.unmarshal_int();
/* 190 */         this.shieldMessageWorld = _os_.unmarshal_int();
/* 191 */         this.shieldMessageTeam = _os_.unmarshal_int();
/* 192 */         this.shieldMessageGang = _os_.unmarshal_int();
/* 193 */         this.screenLv1 = _os_.unmarshal_int();
/* 194 */         this.screenLv2 = _os_.unmarshal_int();
/* 195 */         this.screenLv3 = _os_.unmarshal_int();
/* 196 */         this.thresholdToShowMultiRoleMounts = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SysCfgConsts newInstance)
/*     */   {
/* 207 */     oldInstance = instance;
/* 208 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 213 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\confbean\SysCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */