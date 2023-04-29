/*     */ package mzm.gsp.pvc.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SPVCConsts
/*     */ {
/*  13 */   private static volatile SPVCConsts oldInstance = null;
/*     */   
/*  15 */   private static SPVCConsts instance = new SPVCConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SPVCConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SPVCConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public String GUI_WANG = "";
/*  32 */   public String QING_YUN = "";
/*  33 */   public String TIAN_YIN = "";
/*  34 */   public String FEN_XIANG = "";
/*  35 */   public String HE_HUAN = "";
/*  36 */   public String SHENG_WU = "";
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  40 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  45 */     String path = dir + "mzm.gsp.pvc.confbean.SPVCConsts.xml";
/*     */     try
/*     */     {
/*  48 */       SAXReader reader = new SAXReader();
/*  49 */       org.dom4j.Document doc = reader.read(new File(path));
/*  50 */       Element root = doc.getRootElement();
/*  51 */       Map<String, Element> data = new java.util.HashMap();
/*  52 */       java.util.List<?> nodeList = root.elements();
/*  53 */       int len = nodeList.size();
/*  54 */       for (int i = 0; i < len; i++)
/*     */       {
/*  56 */         Element element = (Element)nodeList.get(i);
/*  57 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  60 */           String name = element.attributeValue("name");
/*  61 */           if (data.put(name, element) != null)
/*  62 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  65 */       this.GUI_WANG = String.valueOf(((Element)data.get("GUI_WANG")).attributeValue("value"));
/*  66 */       this.QING_YUN = String.valueOf(((Element)data.get("QING_YUN")).attributeValue("value"));
/*  67 */       this.TIAN_YIN = String.valueOf(((Element)data.get("TIAN_YIN")).attributeValue("value"));
/*  68 */       this.FEN_XIANG = String.valueOf(((Element)data.get("FEN_XIANG")).attributeValue("value"));
/*  69 */       this.HE_HUAN = String.valueOf(((Element)data.get("HE_HUAN")).attributeValue("value"));
/*  70 */       this.SHENG_WU = String.valueOf(((Element)data.get("SHENG_WU")).attributeValue("value"));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  74 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  79 */     String path = dir + "mzm.gsp.pvc.confbean.SPVCConsts.xml";
/*     */     try
/*     */     {
/*  82 */       SAXReader reader = new SAXReader();
/*  83 */       org.dom4j.Document doc = reader.read(new File(path));
/*  84 */       Element root = doc.getRootElement();
/*  85 */       Map<String, Element> data = new java.util.HashMap();
/*  86 */       java.util.List<?> nodeList = root.elements();
/*  87 */       int len = nodeList.size();
/*  88 */       for (int i = 0; i < len; i++)
/*     */       {
/*  90 */         Element element = (Element)nodeList.get(i);
/*  91 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  94 */           String name = element.attributeValue("name");
/*  95 */           if (data.put(name, element) != null)
/*  96 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  99 */       this.GUI_WANG = String.valueOf(((Element)data.get("GUI_WANG")).attributeValue("value"));
/* 100 */       this.QING_YUN = String.valueOf(((Element)data.get("QING_YUN")).attributeValue("value"));
/* 101 */       this.TIAN_YIN = String.valueOf(((Element)data.get("TIAN_YIN")).attributeValue("value"));
/* 102 */       this.FEN_XIANG = String.valueOf(((Element)data.get("FEN_XIANG")).attributeValue("value"));
/* 103 */       this.HE_HUAN = String.valueOf(((Element)data.get("HE_HUAN")).attributeValue("value"));
/* 104 */       this.SHENG_WU = String.valueOf(((Element)data.get("SHENG_WU")).attributeValue("value"));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 112 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 115 */     String path = dir + "mzm.gsp.pvc.confbean.SPVCConsts.bny";
/*     */     try
/*     */     {
/* 118 */       File file = new File(path);
/* 119 */       if (file.exists())
/*     */       {
/* 121 */         byte[] bytes = new byte['Ѐ'];
/* 122 */         FileInputStream fis = new FileInputStream(file);
/* 123 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 124 */         int len = 0;
/* 125 */         while ((len = fis.read(bytes)) > 0)
/* 126 */           baos.write(bytes, 0, len);
/* 127 */         fis.close();
/* 128 */         bytes = baos.toByteArray();
/* 129 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 130 */         this.GUI_WANG = _os_.unmarshal_String("UTF-8");
/* 131 */         this.QING_YUN = _os_.unmarshal_String("UTF-8");
/* 132 */         this.TIAN_YIN = _os_.unmarshal_String("UTF-8");
/* 133 */         this.FEN_XIANG = _os_.unmarshal_String("UTF-8");
/* 134 */         this.HE_HUAN = _os_.unmarshal_String("UTF-8");
/* 135 */         this.SHENG_WU = _os_.unmarshal_String("UTF-8");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 146 */     String path = dir + "mzm.gsp.pvc.confbean.SPVCConsts.bny";
/*     */     try
/*     */     {
/* 149 */       File file = new File(path);
/* 150 */       if (file.exists())
/*     */       {
/* 152 */         byte[] bytes = new byte['Ѐ'];
/* 153 */         FileInputStream fis = new FileInputStream(file);
/* 154 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 155 */         int len = 0;
/* 156 */         while ((len = fis.read(bytes)) > 0)
/* 157 */           baos.write(bytes, 0, len);
/* 158 */         fis.close();
/* 159 */         bytes = baos.toByteArray();
/* 160 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 161 */         this.GUI_WANG = _os_.unmarshal_String("UTF-8");
/* 162 */         this.QING_YUN = _os_.unmarshal_String("UTF-8");
/* 163 */         this.TIAN_YIN = _os_.unmarshal_String("UTF-8");
/* 164 */         this.FEN_XIANG = _os_.unmarshal_String("UTF-8");
/* 165 */         this.HE_HUAN = _os_.unmarshal_String("UTF-8");
/* 166 */         this.SHENG_WU = _os_.unmarshal_String("UTF-8");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 171 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SPVCConsts newInstance)
/*     */   {
/* 177 */     oldInstance = instance;
/* 178 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 183 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pvc\confbean\SPVCConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */