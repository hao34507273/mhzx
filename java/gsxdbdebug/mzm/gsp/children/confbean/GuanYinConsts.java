/*     */ package mzm.gsp.children.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class GuanYinConsts
/*     */ {
/*  13 */   private static volatile GuanYinConsts oldInstance = null;
/*     */   
/*  15 */   private static GuanYinConsts instance = new GuanYinConsts();
/*     */   public int SHANGGONG_ACTIVITY_CFG_ID;
/*     */   public int QIUQIAN_ACTIVITY_CFG_ID;
/*     */   public int SHANGGONG_ID;
/*     */   public int QIUQIAN_ID;
/*     */   public int POINT_UPPER_LIMIT;
/*     */   public int TIPS_ID;
/*     */   
/*  23 */   public static GuanYinConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static GuanYinConsts getInstance()
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
/*     */ 
/*     */   public static void loadXml(String dir)
/*     */   {
/*  40 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  45 */     String path = dir + "mzm.gsp.children.confbean.GuanYinConsts.xml";
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
/*  65 */       this.SHANGGONG_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("SHANGGONG_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  66 */       this.QIUQIAN_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("QIUQIAN_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  67 */       this.SHANGGONG_ID = Integer.valueOf(((Element)data.get("SHANGGONG_ID")).attributeValue("value")).intValue();
/*  68 */       this.QIUQIAN_ID = Integer.valueOf(((Element)data.get("QIUQIAN_ID")).attributeValue("value")).intValue();
/*  69 */       this.POINT_UPPER_LIMIT = Integer.valueOf(((Element)data.get("POINT_UPPER_LIMIT")).attributeValue("value")).intValue();
/*  70 */       this.TIPS_ID = Integer.valueOf(((Element)data.get("TIPS_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  74 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  79 */     String path = dir + "mzm.gsp.children.confbean.GuanYinConsts.xml";
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
/*  99 */       this.SHANGGONG_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("SHANGGONG_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 100 */       this.QIUQIAN_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("QIUQIAN_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 101 */       this.SHANGGONG_ID = Integer.valueOf(((Element)data.get("SHANGGONG_ID")).attributeValue("value")).intValue();
/* 102 */       this.QIUQIAN_ID = Integer.valueOf(((Element)data.get("QIUQIAN_ID")).attributeValue("value")).intValue();
/* 103 */       this.POINT_UPPER_LIMIT = Integer.valueOf(((Element)data.get("POINT_UPPER_LIMIT")).attributeValue("value")).intValue();
/* 104 */       this.TIPS_ID = Integer.valueOf(((Element)data.get("TIPS_ID")).attributeValue("value")).intValue();
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
/* 115 */     String path = dir + "mzm.gsp.children.confbean.GuanYinConsts.bny";
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
/* 130 */         this.SHANGGONG_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 131 */         this.QIUQIAN_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 132 */         this.SHANGGONG_ID = _os_.unmarshal_int();
/* 133 */         this.QIUQIAN_ID = _os_.unmarshal_int();
/* 134 */         this.POINT_UPPER_LIMIT = _os_.unmarshal_int();
/* 135 */         this.TIPS_ID = _os_.unmarshal_int();
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
/* 146 */     String path = dir + "mzm.gsp.children.confbean.GuanYinConsts.bny";
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
/* 161 */         this.SHANGGONG_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 162 */         this.QIUQIAN_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 163 */         this.SHANGGONG_ID = _os_.unmarshal_int();
/* 164 */         this.QIUQIAN_ID = _os_.unmarshal_int();
/* 165 */         this.POINT_UPPER_LIMIT = _os_.unmarshal_int();
/* 166 */         this.TIPS_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 171 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(GuanYinConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\GuanYinConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */