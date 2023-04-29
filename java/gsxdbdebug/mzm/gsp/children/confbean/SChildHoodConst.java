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
/*     */ public class SChildHoodConst
/*     */ {
/*  13 */   private static volatile SChildHoodConst oldInstance = null;
/*     */   
/*  15 */   private static SChildHoodConst instance = new SChildHoodConst();
/*     */   
/*     */   public int TOTAL_NUM;
/*     */   public int DAILY_NUM;
/*     */   public int RESET_TIME_CFG_ID;
/*     */   
/*     */   public static SChildHoodConst getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SChildHoodConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int CRIT_NUM;
/*     */   
/*     */   public int YUAN_BAO_PER_MINUTE;
/*     */   
/*     */   public int RESET_INTEREST_COST;
/*     */   
/*     */   public int COURSE_MAIL_CFG_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  41 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  46 */     String path = dir + "mzm.gsp.children.confbean.SChildHoodConst.xml";
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
/*  66 */       this.TOTAL_NUM = Integer.valueOf(((Element)data.get("TOTAL_NUM")).attributeValue("value")).intValue();
/*  67 */       this.DAILY_NUM = Integer.valueOf(((Element)data.get("DAILY_NUM")).attributeValue("value")).intValue();
/*  68 */       this.RESET_TIME_CFG_ID = Integer.valueOf(((Element)data.get("RESET_TIME_CFG_ID")).attributeValue("value")).intValue();
/*  69 */       this.CRIT_NUM = Integer.valueOf(((Element)data.get("CRIT_NUM")).attributeValue("value")).intValue();
/*  70 */       this.YUAN_BAO_PER_MINUTE = Integer.valueOf(((Element)data.get("YUAN_BAO_PER_MINUTE")).attributeValue("value")).intValue();
/*  71 */       this.RESET_INTEREST_COST = Integer.valueOf(((Element)data.get("RESET_INTEREST_COST")).attributeValue("value")).intValue();
/*  72 */       this.COURSE_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("COURSE_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  76 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  81 */     String path = dir + "mzm.gsp.children.confbean.SChildHoodConst.xml";
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
/* 101 */       this.TOTAL_NUM = Integer.valueOf(((Element)data.get("TOTAL_NUM")).attributeValue("value")).intValue();
/* 102 */       this.DAILY_NUM = Integer.valueOf(((Element)data.get("DAILY_NUM")).attributeValue("value")).intValue();
/* 103 */       this.RESET_TIME_CFG_ID = Integer.valueOf(((Element)data.get("RESET_TIME_CFG_ID")).attributeValue("value")).intValue();
/* 104 */       this.CRIT_NUM = Integer.valueOf(((Element)data.get("CRIT_NUM")).attributeValue("value")).intValue();
/* 105 */       this.YUAN_BAO_PER_MINUTE = Integer.valueOf(((Element)data.get("YUAN_BAO_PER_MINUTE")).attributeValue("value")).intValue();
/* 106 */       this.RESET_INTEREST_COST = Integer.valueOf(((Element)data.get("RESET_INTEREST_COST")).attributeValue("value")).intValue();
/* 107 */       this.COURSE_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("COURSE_MAIL_CFG_ID")).attributeValue("value")).intValue();
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
/* 118 */     String path = dir + "mzm.gsp.children.confbean.SChildHoodConst.bny";
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
/* 133 */         this.TOTAL_NUM = _os_.unmarshal_int();
/* 134 */         this.DAILY_NUM = _os_.unmarshal_int();
/* 135 */         this.RESET_TIME_CFG_ID = _os_.unmarshal_int();
/* 136 */         this.CRIT_NUM = _os_.unmarshal_int();
/* 137 */         this.YUAN_BAO_PER_MINUTE = _os_.unmarshal_int();
/* 138 */         this.RESET_INTEREST_COST = _os_.unmarshal_int();
/* 139 */         this.COURSE_MAIL_CFG_ID = _os_.unmarshal_int();
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
/* 150 */     String path = dir + "mzm.gsp.children.confbean.SChildHoodConst.bny";
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
/* 165 */         this.TOTAL_NUM = _os_.unmarshal_int();
/* 166 */         this.DAILY_NUM = _os_.unmarshal_int();
/* 167 */         this.RESET_TIME_CFG_ID = _os_.unmarshal_int();
/* 168 */         this.CRIT_NUM = _os_.unmarshal_int();
/* 169 */         this.YUAN_BAO_PER_MINUTE = _os_.unmarshal_int();
/* 170 */         this.RESET_INTEREST_COST = _os_.unmarshal_int();
/* 171 */         this.COURSE_MAIL_CFG_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SChildHoodConst newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\SChildHoodConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */