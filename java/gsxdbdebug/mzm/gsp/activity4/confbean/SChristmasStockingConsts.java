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
/*     */ public class SChristmasStockingConsts
/*     */ {
/*  13 */   private static volatile SChristmasStockingConsts oldInstance = null;
/*     */   
/*  15 */   private static SChristmasStockingConsts instance = new SChristmasStockingConsts();
/*     */   public int AWARD_ID;
/*     */   public int ACTIVITY_ID;
/*     */   public int OFFER_AWARD_COMMON_TIME_CFG_ID;
/*     */   public int ROLE_HANG_ON_ONE_TREE_MAX_NUM;
/*     */   
/*     */   public static SChristmasStockingConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SChristmasStockingConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int ROLE_HANG_MAX_NUM;
/*     */   
/*     */   public int ROLE_HANG_ON_OWN_TREE_NUM;
/*     */   
/*     */   public int TREE_HANG_MAX_NUM;
/*     */   
/*     */   public int AFTER_ACTIVITY_RETAIN_MINUTES;
/*     */   
/*     */   public int CONSUME_ITEM_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  43 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  48 */     String path = dir + "mzm.gsp.activity4.confbean.SChristmasStockingConsts.xml";
/*     */     try
/*     */     {
/*  51 */       SAXReader reader = new SAXReader();
/*  52 */       org.dom4j.Document doc = reader.read(new File(path));
/*  53 */       Element root = doc.getRootElement();
/*  54 */       Map<String, Element> data = new java.util.HashMap();
/*  55 */       java.util.List<?> nodeList = root.elements();
/*  56 */       int len = nodeList.size();
/*  57 */       for (int i = 0; i < len; i++)
/*     */       {
/*  59 */         Element element = (Element)nodeList.get(i);
/*  60 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  63 */           String name = element.attributeValue("name");
/*  64 */           if (data.put(name, element) != null)
/*  65 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  68 */       this.AWARD_ID = Integer.valueOf(((Element)data.get("AWARD_ID")).attributeValue("value")).intValue();
/*  69 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/*  70 */       this.OFFER_AWARD_COMMON_TIME_CFG_ID = Integer.valueOf(((Element)data.get("OFFER_AWARD_COMMON_TIME_CFG_ID")).attributeValue("value")).intValue();
/*  71 */       this.ROLE_HANG_ON_ONE_TREE_MAX_NUM = Integer.valueOf(((Element)data.get("ROLE_HANG_ON_ONE_TREE_MAX_NUM")).attributeValue("value")).intValue();
/*  72 */       this.ROLE_HANG_MAX_NUM = Integer.valueOf(((Element)data.get("ROLE_HANG_MAX_NUM")).attributeValue("value")).intValue();
/*  73 */       this.ROLE_HANG_ON_OWN_TREE_NUM = Integer.valueOf(((Element)data.get("ROLE_HANG_ON_OWN_TREE_NUM")).attributeValue("value")).intValue();
/*  74 */       this.TREE_HANG_MAX_NUM = Integer.valueOf(((Element)data.get("TREE_HANG_MAX_NUM")).attributeValue("value")).intValue();
/*  75 */       this.AFTER_ACTIVITY_RETAIN_MINUTES = Integer.valueOf(((Element)data.get("AFTER_ACTIVITY_RETAIN_MINUTES")).attributeValue("value")).intValue();
/*  76 */       this.CONSUME_ITEM_ID = Integer.valueOf(((Element)data.get("CONSUME_ITEM_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  80 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  85 */     String path = dir + "mzm.gsp.activity4.confbean.SChristmasStockingConsts.xml";
/*     */     try
/*     */     {
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       Map<String, Element> data = new java.util.HashMap();
/*  92 */       java.util.List<?> nodeList = root.elements();
/*  93 */       int len = nodeList.size();
/*  94 */       for (int i = 0; i < len; i++)
/*     */       {
/*  96 */         Element element = (Element)nodeList.get(i);
/*  97 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 100 */           String name = element.attributeValue("name");
/* 101 */           if (data.put(name, element) != null)
/* 102 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 105 */       this.AWARD_ID = Integer.valueOf(((Element)data.get("AWARD_ID")).attributeValue("value")).intValue();
/* 106 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/* 107 */       this.OFFER_AWARD_COMMON_TIME_CFG_ID = Integer.valueOf(((Element)data.get("OFFER_AWARD_COMMON_TIME_CFG_ID")).attributeValue("value")).intValue();
/* 108 */       this.ROLE_HANG_ON_ONE_TREE_MAX_NUM = Integer.valueOf(((Element)data.get("ROLE_HANG_ON_ONE_TREE_MAX_NUM")).attributeValue("value")).intValue();
/* 109 */       this.ROLE_HANG_MAX_NUM = Integer.valueOf(((Element)data.get("ROLE_HANG_MAX_NUM")).attributeValue("value")).intValue();
/* 110 */       this.ROLE_HANG_ON_OWN_TREE_NUM = Integer.valueOf(((Element)data.get("ROLE_HANG_ON_OWN_TREE_NUM")).attributeValue("value")).intValue();
/* 111 */       this.TREE_HANG_MAX_NUM = Integer.valueOf(((Element)data.get("TREE_HANG_MAX_NUM")).attributeValue("value")).intValue();
/* 112 */       this.AFTER_ACTIVITY_RETAIN_MINUTES = Integer.valueOf(((Element)data.get("AFTER_ACTIVITY_RETAIN_MINUTES")).attributeValue("value")).intValue();
/* 113 */       this.CONSUME_ITEM_ID = Integer.valueOf(((Element)data.get("CONSUME_ITEM_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 117 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 121 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 124 */     String path = dir + "mzm.gsp.activity4.confbean.SChristmasStockingConsts.bny";
/*     */     try
/*     */     {
/* 127 */       File file = new File(path);
/* 128 */       if (file.exists())
/*     */       {
/* 130 */         byte[] bytes = new byte['Ѐ'];
/* 131 */         FileInputStream fis = new FileInputStream(file);
/* 132 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 133 */         int len = 0;
/* 134 */         while ((len = fis.read(bytes)) > 0)
/* 135 */           baos.write(bytes, 0, len);
/* 136 */         fis.close();
/* 137 */         bytes = baos.toByteArray();
/* 138 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 139 */         this.AWARD_ID = _os_.unmarshal_int();
/* 140 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 141 */         this.OFFER_AWARD_COMMON_TIME_CFG_ID = _os_.unmarshal_int();
/* 142 */         this.ROLE_HANG_ON_ONE_TREE_MAX_NUM = _os_.unmarshal_int();
/* 143 */         this.ROLE_HANG_MAX_NUM = _os_.unmarshal_int();
/* 144 */         this.ROLE_HANG_ON_OWN_TREE_NUM = _os_.unmarshal_int();
/* 145 */         this.TREE_HANG_MAX_NUM = _os_.unmarshal_int();
/* 146 */         this.AFTER_ACTIVITY_RETAIN_MINUTES = _os_.unmarshal_int();
/* 147 */         this.CONSUME_ITEM_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 158 */     String path = dir + "mzm.gsp.activity4.confbean.SChristmasStockingConsts.bny";
/*     */     try
/*     */     {
/* 161 */       File file = new File(path);
/* 162 */       if (file.exists())
/*     */       {
/* 164 */         byte[] bytes = new byte['Ѐ'];
/* 165 */         FileInputStream fis = new FileInputStream(file);
/* 166 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 167 */         int len = 0;
/* 168 */         while ((len = fis.read(bytes)) > 0)
/* 169 */           baos.write(bytes, 0, len);
/* 170 */         fis.close();
/* 171 */         bytes = baos.toByteArray();
/* 172 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 173 */         this.AWARD_ID = _os_.unmarshal_int();
/* 174 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 175 */         this.OFFER_AWARD_COMMON_TIME_CFG_ID = _os_.unmarshal_int();
/* 176 */         this.ROLE_HANG_ON_ONE_TREE_MAX_NUM = _os_.unmarshal_int();
/* 177 */         this.ROLE_HANG_MAX_NUM = _os_.unmarshal_int();
/* 178 */         this.ROLE_HANG_ON_OWN_TREE_NUM = _os_.unmarshal_int();
/* 179 */         this.TREE_HANG_MAX_NUM = _os_.unmarshal_int();
/* 180 */         this.AFTER_ACTIVITY_RETAIN_MINUTES = _os_.unmarshal_int();
/* 181 */         this.CONSUME_ITEM_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SChristmasStockingConsts newInstance)
/*     */   {
/* 192 */     oldInstance = instance;
/* 193 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 198 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SChristmasStockingConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */