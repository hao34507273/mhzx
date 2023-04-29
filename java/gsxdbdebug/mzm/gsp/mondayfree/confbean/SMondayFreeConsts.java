/*     */ package mzm.gsp.mondayfree.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMondayFreeConsts
/*     */ {
/*  13 */   private static volatile SMondayFreeConsts oldInstance = null;
/*     */   
/*  15 */   private static SMondayFreeConsts instance = new SMondayFreeConsts();
/*     */   public int SundayTimeDurationCfgid;
/*     */   public int MondayTimeDurationCfgid;
/*     */   public int SundayAward;
/*     */   public int MondayAward;
/*     */   public int NeedServerLevel;
/*     */   
/*     */   public static SMondayFreeConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SMondayFreeConsts getInstance()
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
/*  44 */     String path = dir + "mzm.gsp.mondayfree.confbean.SMondayFreeConsts.xml";
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
/*  64 */       this.SundayTimeDurationCfgid = Integer.valueOf(((Element)data.get("SundayTimeDurationCfgid")).attributeValue("value")).intValue();
/*  65 */       this.MondayTimeDurationCfgid = Integer.valueOf(((Element)data.get("MondayTimeDurationCfgid")).attributeValue("value")).intValue();
/*  66 */       this.SundayAward = Integer.valueOf(((Element)data.get("SundayAward")).attributeValue("value")).intValue();
/*  67 */       this.MondayAward = Integer.valueOf(((Element)data.get("MondayAward")).attributeValue("value")).intValue();
/*  68 */       this.NeedServerLevel = Integer.valueOf(((Element)data.get("NeedServerLevel")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  72 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  77 */     String path = dir + "mzm.gsp.mondayfree.confbean.SMondayFreeConsts.xml";
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
/*  97 */       this.SundayTimeDurationCfgid = Integer.valueOf(((Element)data.get("SundayTimeDurationCfgid")).attributeValue("value")).intValue();
/*  98 */       this.MondayTimeDurationCfgid = Integer.valueOf(((Element)data.get("MondayTimeDurationCfgid")).attributeValue("value")).intValue();
/*  99 */       this.SundayAward = Integer.valueOf(((Element)data.get("SundayAward")).attributeValue("value")).intValue();
/* 100 */       this.MondayAward = Integer.valueOf(((Element)data.get("MondayAward")).attributeValue("value")).intValue();
/* 101 */       this.NeedServerLevel = Integer.valueOf(((Element)data.get("NeedServerLevel")).attributeValue("value")).intValue();
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
/* 112 */     String path = dir + "mzm.gsp.mondayfree.confbean.SMondayFreeConsts.bny";
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
/* 127 */         this.SundayTimeDurationCfgid = _os_.unmarshal_int();
/* 128 */         this.MondayTimeDurationCfgid = _os_.unmarshal_int();
/* 129 */         this.SundayAward = _os_.unmarshal_int();
/* 130 */         this.MondayAward = _os_.unmarshal_int();
/* 131 */         this.NeedServerLevel = _os_.unmarshal_int();
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
/* 142 */     String path = dir + "mzm.gsp.mondayfree.confbean.SMondayFreeConsts.bny";
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
/* 157 */         this.SundayTimeDurationCfgid = _os_.unmarshal_int();
/* 158 */         this.MondayTimeDurationCfgid = _os_.unmarshal_int();
/* 159 */         this.SundayAward = _os_.unmarshal_int();
/* 160 */         this.MondayAward = _os_.unmarshal_int();
/* 161 */         this.NeedServerLevel = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 166 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMondayFreeConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mondayfree\confbean\SMondayFreeConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */