/*     */ package mzm.gsp.qingfu.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SOpenWelfareConst
/*     */ {
/*  13 */   private static volatile SOpenWelfareConst oldInstance = null;
/*     */   
/*  15 */   private static SOpenWelfareConst instance = new SOpenWelfareConst();
/*     */   public int activity_cfg_id;
/*     */   public int hour_after_activity_start;
/*     */   public int mail_id;
/*     */   public int persist_hour;
/*     */   
/*     */   public static SOpenWelfareConst getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SOpenWelfareConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void loadXml(String dir)
/*     */   {
/*  38 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  43 */     String path = dir + "mzm.gsp.qingfu.confbean.SOpenWelfareConst.xml";
/*     */     try
/*     */     {
/*  46 */       SAXReader reader = new SAXReader();
/*  47 */       org.dom4j.Document doc = reader.read(new File(path));
/*  48 */       Element root = doc.getRootElement();
/*  49 */       Map<String, Element> data = new java.util.HashMap();
/*  50 */       java.util.List<?> nodeList = root.elements();
/*  51 */       int len = nodeList.size();
/*  52 */       for (int i = 0; i < len; i++)
/*     */       {
/*  54 */         Element element = (Element)nodeList.get(i);
/*  55 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  58 */           String name = element.attributeValue("name");
/*  59 */           if (data.put(name, element) != null)
/*  60 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  63 */       this.activity_cfg_id = Integer.valueOf(((Element)data.get("activity_cfg_id")).attributeValue("value")).intValue();
/*  64 */       this.hour_after_activity_start = Integer.valueOf(((Element)data.get("hour_after_activity_start")).attributeValue("value")).intValue();
/*  65 */       this.mail_id = Integer.valueOf(((Element)data.get("mail_id")).attributeValue("value")).intValue();
/*  66 */       this.persist_hour = Integer.valueOf(((Element)data.get("persist_hour")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  70 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  75 */     String path = dir + "mzm.gsp.qingfu.confbean.SOpenWelfareConst.xml";
/*     */     try
/*     */     {
/*  78 */       SAXReader reader = new SAXReader();
/*  79 */       org.dom4j.Document doc = reader.read(new File(path));
/*  80 */       Element root = doc.getRootElement();
/*  81 */       Map<String, Element> data = new java.util.HashMap();
/*  82 */       java.util.List<?> nodeList = root.elements();
/*  83 */       int len = nodeList.size();
/*  84 */       for (int i = 0; i < len; i++)
/*     */       {
/*  86 */         Element element = (Element)nodeList.get(i);
/*  87 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  90 */           String name = element.attributeValue("name");
/*  91 */           if (data.put(name, element) != null)
/*  92 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  95 */       this.activity_cfg_id = Integer.valueOf(((Element)data.get("activity_cfg_id")).attributeValue("value")).intValue();
/*  96 */       this.hour_after_activity_start = Integer.valueOf(((Element)data.get("hour_after_activity_start")).attributeValue("value")).intValue();
/*  97 */       this.mail_id = Integer.valueOf(((Element)data.get("mail_id")).attributeValue("value")).intValue();
/*  98 */       this.persist_hour = Integer.valueOf(((Element)data.get("persist_hour")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 102 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 106 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 109 */     String path = dir + "mzm.gsp.qingfu.confbean.SOpenWelfareConst.bny";
/*     */     try
/*     */     {
/* 112 */       File file = new File(path);
/* 113 */       if (file.exists())
/*     */       {
/* 115 */         byte[] bytes = new byte['Ѐ'];
/* 116 */         FileInputStream fis = new FileInputStream(file);
/* 117 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 118 */         int len = 0;
/* 119 */         while ((len = fis.read(bytes)) > 0)
/* 120 */           baos.write(bytes, 0, len);
/* 121 */         fis.close();
/* 122 */         bytes = baos.toByteArray();
/* 123 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 124 */         this.activity_cfg_id = _os_.unmarshal_int();
/* 125 */         this.hour_after_activity_start = _os_.unmarshal_int();
/* 126 */         this.mail_id = _os_.unmarshal_int();
/* 127 */         this.persist_hour = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 138 */     String path = dir + "mzm.gsp.qingfu.confbean.SOpenWelfareConst.bny";
/*     */     try
/*     */     {
/* 141 */       File file = new File(path);
/* 142 */       if (file.exists())
/*     */       {
/* 144 */         byte[] bytes = new byte['Ѐ'];
/* 145 */         FileInputStream fis = new FileInputStream(file);
/* 146 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 147 */         int len = 0;
/* 148 */         while ((len = fis.read(bytes)) > 0)
/* 149 */           baos.write(bytes, 0, len);
/* 150 */         fis.close();
/* 151 */         bytes = baos.toByteArray();
/* 152 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 153 */         this.activity_cfg_id = _os_.unmarshal_int();
/* 154 */         this.hour_after_activity_start = _os_.unmarshal_int();
/* 155 */         this.mail_id = _os_.unmarshal_int();
/* 156 */         this.persist_hour = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 161 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SOpenWelfareConst newInstance)
/*     */   {
/* 167 */     oldInstance = instance;
/* 168 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 173 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\confbean\SOpenWelfareConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */