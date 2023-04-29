/*     */ package mzm.gsp.util.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class MoneyExchangeCfgConsts
/*     */ {
/*  13 */   private static volatile MoneyExchangeCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static MoneyExchangeCfgConsts instance = new MoneyExchangeCfgConsts();
/*     */   public int YUANBAO_TO_GOLD_NUM;
/*     */   public int YUANBAO_TO_SILVER_NUM;
/*     */   public int GOLD_TO_SILVER_NUM;
/*     */   public double INGOT_TO_GOLD_NUM;
/*     */   
/*     */   public static MoneyExchangeCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static MoneyExchangeCfgConsts getInstance()
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
/*  43 */     String path = dir + "mzm.gsp.util.confbean.MoneyExchangeCfgConsts.xml";
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
/*  63 */       this.YUANBAO_TO_GOLD_NUM = Integer.valueOf(((Element)data.get("YUANBAO_TO_GOLD_NUM")).attributeValue("value")).intValue();
/*  64 */       this.YUANBAO_TO_SILVER_NUM = Integer.valueOf(((Element)data.get("YUANBAO_TO_SILVER_NUM")).attributeValue("value")).intValue();
/*  65 */       this.GOLD_TO_SILVER_NUM = Integer.valueOf(((Element)data.get("GOLD_TO_SILVER_NUM")).attributeValue("value")).intValue();
/*  66 */       this.INGOT_TO_GOLD_NUM = Double.valueOf(((Element)data.get("INGOT_TO_GOLD_NUM")).attributeValue("value")).doubleValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  70 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  75 */     String path = dir + "mzm.gsp.util.confbean.MoneyExchangeCfgConsts.xml";
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
/*  95 */       this.YUANBAO_TO_GOLD_NUM = Integer.valueOf(((Element)data.get("YUANBAO_TO_GOLD_NUM")).attributeValue("value")).intValue();
/*  96 */       this.YUANBAO_TO_SILVER_NUM = Integer.valueOf(((Element)data.get("YUANBAO_TO_SILVER_NUM")).attributeValue("value")).intValue();
/*  97 */       this.GOLD_TO_SILVER_NUM = Integer.valueOf(((Element)data.get("GOLD_TO_SILVER_NUM")).attributeValue("value")).intValue();
/*  98 */       this.INGOT_TO_GOLD_NUM = Double.valueOf(((Element)data.get("INGOT_TO_GOLD_NUM")).attributeValue("value")).doubleValue();
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
/* 109 */     String path = dir + "mzm.gsp.util.confbean.MoneyExchangeCfgConsts.bny";
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
/* 124 */         this.YUANBAO_TO_GOLD_NUM = _os_.unmarshal_int();
/* 125 */         this.YUANBAO_TO_SILVER_NUM = _os_.unmarshal_int();
/* 126 */         this.GOLD_TO_SILVER_NUM = _os_.unmarshal_int();
/* 127 */         this.INGOT_TO_GOLD_NUM = _os_.unmarshal_float();
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
/* 138 */     String path = dir + "mzm.gsp.util.confbean.MoneyExchangeCfgConsts.bny";
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
/* 153 */         this.YUANBAO_TO_GOLD_NUM = _os_.unmarshal_int();
/* 154 */         this.YUANBAO_TO_SILVER_NUM = _os_.unmarshal_int();
/* 155 */         this.GOLD_TO_SILVER_NUM = _os_.unmarshal_int();
/* 156 */         this.INGOT_TO_GOLD_NUM = _os_.unmarshal_float();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 161 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(MoneyExchangeCfgConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\confbean\MoneyExchangeCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */