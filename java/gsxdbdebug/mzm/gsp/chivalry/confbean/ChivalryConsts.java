/*     */ package mzm.gsp.chivalry.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class ChivalryConsts
/*     */ {
/*  13 */   private static volatile ChivalryConsts oldInstance = null;
/*     */   
/*  15 */   private static ChivalryConsts instance = new ChivalryConsts();
/*     */   
/*     */   public int NEED_LEVEL_LOW;
/*     */   public int ADD_COUNT_PER_DAY_UPPER;
/*     */   public int FLUSH_TIME;
/*     */   
/*     */   public static ChivalryConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static ChivalryConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int MAIN_ADD_COUNT_PER_TIME_UPPER;
/*     */   
/*     */   public int FACTION_ADD_COUNT_PER_DAY_UPPER;
/*     */   
/*     */   public int SHUA_YE_FACTION_ADD_PER_ONE_NEW_GUY;
/*     */   
/*     */   public int ZHEN_YAO_FACTION_ADD_PER_ONE_NEW_GUY;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  41 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  46 */     String path = dir + "mzm.gsp.chivalry.confbean.ChivalryConsts.xml";
/*     */     try
/*     */     {
/*  49 */       SAXReader reader = new SAXReader();
/*  50 */       org.dom4j.Document doc = reader.read(new File(path));
/*  51 */       Element root = doc.getRootElement();
/*  52 */       Map<String, Element> data = new java.util.HashMap();
/*  53 */       java.util.List<?> nodeList = root.elements();
/*  54 */       int len = nodeList.size();
/*  55 */       for (int i = 0; i < len; i++)
/*     */       {
/*  57 */         Element element = (Element)nodeList.get(i);
/*  58 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  61 */           String name = element.attributeValue("name");
/*  62 */           if (data.put(name, element) != null)
/*  63 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  66 */       this.NEED_LEVEL_LOW = Integer.valueOf(((Element)data.get("NEED_LEVEL_LOW")).attributeValue("value")).intValue();
/*  67 */       this.ADD_COUNT_PER_DAY_UPPER = Integer.valueOf(((Element)data.get("ADD_COUNT_PER_DAY_UPPER")).attributeValue("value")).intValue();
/*  68 */       this.FLUSH_TIME = Integer.valueOf(((Element)data.get("FLUSH_TIME")).attributeValue("value")).intValue();
/*  69 */       this.MAIN_ADD_COUNT_PER_TIME_UPPER = Integer.valueOf(((Element)data.get("MAIN_ADD_COUNT_PER_TIME_UPPER")).attributeValue("value")).intValue();
/*  70 */       this.FACTION_ADD_COUNT_PER_DAY_UPPER = Integer.valueOf(((Element)data.get("FACTION_ADD_COUNT_PER_DAY_UPPER")).attributeValue("value")).intValue();
/*  71 */       this.SHUA_YE_FACTION_ADD_PER_ONE_NEW_GUY = Integer.valueOf(((Element)data.get("SHUA_YE_FACTION_ADD_PER_ONE_NEW_GUY")).attributeValue("value")).intValue();
/*  72 */       this.ZHEN_YAO_FACTION_ADD_PER_ONE_NEW_GUY = Integer.valueOf(((Element)data.get("ZHEN_YAO_FACTION_ADD_PER_ONE_NEW_GUY")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  76 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  81 */     String path = dir + "mzm.gsp.chivalry.confbean.ChivalryConsts.xml";
/*     */     try
/*     */     {
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       Map<String, Element> data = new java.util.HashMap();
/*  88 */       java.util.List<?> nodeList = root.elements();
/*  89 */       int len = nodeList.size();
/*  90 */       for (int i = 0; i < len; i++)
/*     */       {
/*  92 */         Element element = (Element)nodeList.get(i);
/*  93 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  96 */           String name = element.attributeValue("name");
/*  97 */           if (data.put(name, element) != null)
/*  98 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 101 */       this.NEED_LEVEL_LOW = Integer.valueOf(((Element)data.get("NEED_LEVEL_LOW")).attributeValue("value")).intValue();
/* 102 */       this.ADD_COUNT_PER_DAY_UPPER = Integer.valueOf(((Element)data.get("ADD_COUNT_PER_DAY_UPPER")).attributeValue("value")).intValue();
/* 103 */       this.FLUSH_TIME = Integer.valueOf(((Element)data.get("FLUSH_TIME")).attributeValue("value")).intValue();
/* 104 */       this.MAIN_ADD_COUNT_PER_TIME_UPPER = Integer.valueOf(((Element)data.get("MAIN_ADD_COUNT_PER_TIME_UPPER")).attributeValue("value")).intValue();
/* 105 */       this.FACTION_ADD_COUNT_PER_DAY_UPPER = Integer.valueOf(((Element)data.get("FACTION_ADD_COUNT_PER_DAY_UPPER")).attributeValue("value")).intValue();
/* 106 */       this.SHUA_YE_FACTION_ADD_PER_ONE_NEW_GUY = Integer.valueOf(((Element)data.get("SHUA_YE_FACTION_ADD_PER_ONE_NEW_GUY")).attributeValue("value")).intValue();
/* 107 */       this.ZHEN_YAO_FACTION_ADD_PER_ONE_NEW_GUY = Integer.valueOf(((Element)data.get("ZHEN_YAO_FACTION_ADD_PER_ONE_NEW_GUY")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 111 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 115 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 118 */     String path = dir + "mzm.gsp.chivalry.confbean.ChivalryConsts.bny";
/*     */     try
/*     */     {
/* 121 */       File file = new File(path);
/* 122 */       if (file.exists())
/*     */       {
/* 124 */         byte[] bytes = new byte['Ѐ'];
/* 125 */         FileInputStream fis = new FileInputStream(file);
/* 126 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 127 */         int len = 0;
/* 128 */         while ((len = fis.read(bytes)) > 0)
/* 129 */           baos.write(bytes, 0, len);
/* 130 */         fis.close();
/* 131 */         bytes = baos.toByteArray();
/* 132 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 133 */         this.NEED_LEVEL_LOW = _os_.unmarshal_int();
/* 134 */         this.ADD_COUNT_PER_DAY_UPPER = _os_.unmarshal_int();
/* 135 */         this.FLUSH_TIME = _os_.unmarshal_int();
/* 136 */         this.MAIN_ADD_COUNT_PER_TIME_UPPER = _os_.unmarshal_int();
/* 137 */         this.FACTION_ADD_COUNT_PER_DAY_UPPER = _os_.unmarshal_int();
/* 138 */         this.SHUA_YE_FACTION_ADD_PER_ONE_NEW_GUY = _os_.unmarshal_int();
/* 139 */         this.ZHEN_YAO_FACTION_ADD_PER_ONE_NEW_GUY = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 150 */     String path = dir + "mzm.gsp.chivalry.confbean.ChivalryConsts.bny";
/*     */     try
/*     */     {
/* 153 */       File file = new File(path);
/* 154 */       if (file.exists())
/*     */       {
/* 156 */         byte[] bytes = new byte['Ѐ'];
/* 157 */         FileInputStream fis = new FileInputStream(file);
/* 158 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 159 */         int len = 0;
/* 160 */         while ((len = fis.read(bytes)) > 0)
/* 161 */           baos.write(bytes, 0, len);
/* 162 */         fis.close();
/* 163 */         bytes = baos.toByteArray();
/* 164 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 165 */         this.NEED_LEVEL_LOW = _os_.unmarshal_int();
/* 166 */         this.ADD_COUNT_PER_DAY_UPPER = _os_.unmarshal_int();
/* 167 */         this.FLUSH_TIME = _os_.unmarshal_int();
/* 168 */         this.MAIN_ADD_COUNT_PER_TIME_UPPER = _os_.unmarshal_int();
/* 169 */         this.FACTION_ADD_COUNT_PER_DAY_UPPER = _os_.unmarshal_int();
/* 170 */         this.SHUA_YE_FACTION_ADD_PER_ONE_NEW_GUY = _os_.unmarshal_int();
/* 171 */         this.ZHEN_YAO_FACTION_ADD_PER_ONE_NEW_GUY = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(ChivalryConsts newInstance)
/*     */   {
/* 182 */     oldInstance = instance;
/* 183 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 188 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\confbean\ChivalryConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */