/*     */ package mzm.gsp.activity4.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SChristmasStockingHidingConsts
/*     */ {
/*  13 */   private static volatile SChristmasStockingHidingConsts oldInstance = null;
/*     */   
/*  15 */   private static SChristmasStockingHidingConsts instance = new SChristmasStockingHidingConsts();
/*     */   public int ACTIVITY_ID;
/*     */   public int MAP_ITEM_REFRESH_COMMON_TIME_CFG_ID;
/*     */   public int NOTIFY_MAIL_CFG_ID;
/*     */   public int HANDLER_TYPE;
/*     */   public int CONTROLLER_ID;
/*     */   
/*     */   public static SChristmasStockingHidingConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SChristmasStockingHidingConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void loadXml(String dir)
/*     */   {
/*  39 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  44 */     String path = dir + "mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts.xml";
/*     */     try
/*     */     {
/*  47 */       SAXReader reader = new SAXReader();
/*  48 */       org.dom4j.Document doc = reader.read(new File(path));
/*  49 */       Element root = doc.getRootElement();
/*  50 */       Map<String, Element> data = new java.util.HashMap();
/*  51 */       java.util.List<?> nodeList = root.elements();
/*  52 */       int len = nodeList.size();
/*  53 */       for (int i = 0; i < len; i++)
/*     */       {
/*  55 */         Element element = (Element)nodeList.get(i);
/*  56 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  59 */           String name = element.attributeValue("name");
/*  60 */           if (data.put(name, element) != null)
/*  61 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  64 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/*  65 */       this.MAP_ITEM_REFRESH_COMMON_TIME_CFG_ID = Integer.valueOf(((Element)data.get("MAP_ITEM_REFRESH_COMMON_TIME_CFG_ID")).attributeValue("value")).intValue();
/*  66 */       this.NOTIFY_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("NOTIFY_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  67 */       this.HANDLER_TYPE = Integer.valueOf(((Element)data.get("HANDLER_TYPE")).attributeValue("value")).intValue();
/*  68 */       this.CONTROLLER_ID = Integer.valueOf(((Element)data.get("CONTROLLER_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  72 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  77 */     String path = dir + "mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts.xml";
/*     */     try
/*     */     {
/*  80 */       SAXReader reader = new SAXReader();
/*  81 */       org.dom4j.Document doc = reader.read(new File(path));
/*  82 */       Element root = doc.getRootElement();
/*  83 */       Map<String, Element> data = new java.util.HashMap();
/*  84 */       java.util.List<?> nodeList = root.elements();
/*  85 */       int len = nodeList.size();
/*  86 */       for (int i = 0; i < len; i++)
/*     */       {
/*  88 */         Element element = (Element)nodeList.get(i);
/*  89 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  92 */           String name = element.attributeValue("name");
/*  93 */           if (data.put(name, element) != null)
/*  94 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  97 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/*  98 */       this.MAP_ITEM_REFRESH_COMMON_TIME_CFG_ID = Integer.valueOf(((Element)data.get("MAP_ITEM_REFRESH_COMMON_TIME_CFG_ID")).attributeValue("value")).intValue();
/*  99 */       this.NOTIFY_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("NOTIFY_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 100 */       this.HANDLER_TYPE = Integer.valueOf(((Element)data.get("HANDLER_TYPE")).attributeValue("value")).intValue();
/* 101 */       this.CONTROLLER_ID = Integer.valueOf(((Element)data.get("CONTROLLER_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 105 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 109 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 112 */     String path = dir + "mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts.bny";
/*     */     try
/*     */     {
/* 115 */       File file = new File(path);
/* 116 */       if (file.exists())
/*     */       {
/* 118 */         byte[] bytes = new byte['Ѐ'];
/* 119 */         FileInputStream fis = new FileInputStream(file);
/* 120 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 121 */         int len = 0;
/* 122 */         while ((len = fis.read(bytes)) > 0)
/* 123 */           baos.write(bytes, 0, len);
/* 124 */         fis.close();
/* 125 */         bytes = baos.toByteArray();
/* 126 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 127 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 128 */         this.MAP_ITEM_REFRESH_COMMON_TIME_CFG_ID = _os_.unmarshal_int();
/* 129 */         this.NOTIFY_MAIL_CFG_ID = _os_.unmarshal_int();
/* 130 */         this.HANDLER_TYPE = _os_.unmarshal_int();
/* 131 */         this.CONTROLLER_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 142 */     String path = dir + "mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts.bny";
/*     */     try
/*     */     {
/* 145 */       File file = new File(path);
/* 146 */       if (file.exists())
/*     */       {
/* 148 */         byte[] bytes = new byte['Ѐ'];
/* 149 */         FileInputStream fis = new FileInputStream(file);
/* 150 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 151 */         int len = 0;
/* 152 */         while ((len = fis.read(bytes)) > 0)
/* 153 */           baos.write(bytes, 0, len);
/* 154 */         fis.close();
/* 155 */         bytes = baos.toByteArray();
/* 156 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 157 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 158 */         this.MAP_ITEM_REFRESH_COMMON_TIME_CFG_ID = _os_.unmarshal_int();
/* 159 */         this.NOTIFY_MAIL_CFG_ID = _os_.unmarshal_int();
/* 160 */         this.HANDLER_TYPE = _os_.unmarshal_int();
/* 161 */         this.CONTROLLER_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 166 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SChristmasStockingHidingConsts newInstance)
/*     */   {
/* 172 */     oldInstance = instance;
/* 173 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 178 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SChristmasStockingHidingConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */