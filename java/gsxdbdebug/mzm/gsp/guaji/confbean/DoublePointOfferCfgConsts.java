/*     */ package mzm.gsp.guaji.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class DoublePointOfferCfgConsts
/*     */ {
/*  13 */   private static volatile DoublePointOfferCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static DoublePointOfferCfgConsts instance = new DoublePointOfferCfgConsts();
/*     */   
/*     */   public int OFFER_TIME;
/*     */   public int OFFER_NUM;
/*     */   public int REST_POINT_MAX_NUM;
/*     */   
/*     */   public static DoublePointOfferCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static DoublePointOfferCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int ONCE_GET_MAX_NUM;
/*     */   
/*     */   public int ROLE_CARRY_MAX_NUM;
/*     */   
/*     */   public int NEWER_COMPENSATION_NUM;
/*     */   
/*     */   public int REST_POINT_DISCOUNT;
/*     */   public int REST_POINT_DISCOUNT_BASE;
/*     */   public int ITEM_MAX_USE_COUNT;
/*     */   public int FROZEN_DEC_NUM;
/*     */   public int MIN_NUM_FOR_BOUND_TIP;
/*     */   public int TIPS;
/*     */   public int doublePointItem;
/*     */   public int ITEM_USE_TIMES_RESET_TIME;
/*     */   public int DOUBLE_POINT_ITEM_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  49 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  54 */     String path = dir + "mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts.xml";
/*     */     try
/*     */     {
/*  57 */       SAXReader reader = new SAXReader();
/*  58 */       org.dom4j.Document doc = reader.read(new File(path));
/*  59 */       Element root = doc.getRootElement();
/*  60 */       Map<String, Element> data = new java.util.HashMap();
/*  61 */       java.util.List<?> nodeList = root.elements();
/*  62 */       int len = nodeList.size();
/*  63 */       for (int i = 0; i < len; i++)
/*     */       {
/*  65 */         Element element = (Element)nodeList.get(i);
/*  66 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  69 */           String name = element.attributeValue("name");
/*  70 */           if (data.put(name, element) != null)
/*  71 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  74 */       this.OFFER_TIME = Integer.valueOf(((Element)data.get("OFFER_TIME")).attributeValue("value")).intValue();
/*  75 */       this.OFFER_NUM = Integer.valueOf(((Element)data.get("OFFER_NUM")).attributeValue("value")).intValue();
/*  76 */       this.REST_POINT_MAX_NUM = Integer.valueOf(((Element)data.get("REST_POINT_MAX_NUM")).attributeValue("value")).intValue();
/*  77 */       this.ONCE_GET_MAX_NUM = Integer.valueOf(((Element)data.get("ONCE_GET_MAX_NUM")).attributeValue("value")).intValue();
/*  78 */       this.ROLE_CARRY_MAX_NUM = Integer.valueOf(((Element)data.get("ROLE_CARRY_MAX_NUM")).attributeValue("value")).intValue();
/*  79 */       this.NEWER_COMPENSATION_NUM = Integer.valueOf(((Element)data.get("NEWER_COMPENSATION_NUM")).attributeValue("value")).intValue();
/*  80 */       this.REST_POINT_DISCOUNT = Integer.valueOf(((Element)data.get("REST_POINT_DISCOUNT")).attributeValue("value")).intValue();
/*  81 */       this.REST_POINT_DISCOUNT_BASE = Integer.valueOf(((Element)data.get("REST_POINT_DISCOUNT_BASE")).attributeValue("value")).intValue();
/*  82 */       this.ITEM_MAX_USE_COUNT = Integer.valueOf(((Element)data.get("ITEM_MAX_USE_COUNT")).attributeValue("value")).intValue();
/*  83 */       this.FROZEN_DEC_NUM = Integer.valueOf(((Element)data.get("FROZEN_DEC_NUM")).attributeValue("value")).intValue();
/*  84 */       this.MIN_NUM_FOR_BOUND_TIP = Integer.valueOf(((Element)data.get("MIN_NUM_FOR_BOUND_TIP")).attributeValue("value")).intValue();
/*  85 */       this.TIPS = Integer.valueOf(((Element)data.get("TIPS")).attributeValue("value")).intValue();
/*  86 */       this.doublePointItem = Integer.valueOf(((Element)data.get("doublePointItem")).attributeValue("value")).intValue();
/*  87 */       this.ITEM_USE_TIMES_RESET_TIME = Integer.valueOf(((Element)data.get("ITEM_USE_TIMES_RESET_TIME")).attributeValue("value")).intValue();
/*  88 */       this.DOUBLE_POINT_ITEM_ID = Integer.valueOf(((Element)data.get("DOUBLE_POINT_ITEM_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  92 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  97 */     String path = dir + "mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts.xml";
/*     */     try
/*     */     {
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       Map<String, Element> data = new java.util.HashMap();
/* 104 */       java.util.List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element element = (Element)nodeList.get(i);
/* 109 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 112 */           String name = element.attributeValue("name");
/* 113 */           if (data.put(name, element) != null)
/* 114 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 117 */       this.OFFER_TIME = Integer.valueOf(((Element)data.get("OFFER_TIME")).attributeValue("value")).intValue();
/* 118 */       this.OFFER_NUM = Integer.valueOf(((Element)data.get("OFFER_NUM")).attributeValue("value")).intValue();
/* 119 */       this.REST_POINT_MAX_NUM = Integer.valueOf(((Element)data.get("REST_POINT_MAX_NUM")).attributeValue("value")).intValue();
/* 120 */       this.ONCE_GET_MAX_NUM = Integer.valueOf(((Element)data.get("ONCE_GET_MAX_NUM")).attributeValue("value")).intValue();
/* 121 */       this.ROLE_CARRY_MAX_NUM = Integer.valueOf(((Element)data.get("ROLE_CARRY_MAX_NUM")).attributeValue("value")).intValue();
/* 122 */       this.NEWER_COMPENSATION_NUM = Integer.valueOf(((Element)data.get("NEWER_COMPENSATION_NUM")).attributeValue("value")).intValue();
/* 123 */       this.REST_POINT_DISCOUNT = Integer.valueOf(((Element)data.get("REST_POINT_DISCOUNT")).attributeValue("value")).intValue();
/* 124 */       this.REST_POINT_DISCOUNT_BASE = Integer.valueOf(((Element)data.get("REST_POINT_DISCOUNT_BASE")).attributeValue("value")).intValue();
/* 125 */       this.ITEM_MAX_USE_COUNT = Integer.valueOf(((Element)data.get("ITEM_MAX_USE_COUNT")).attributeValue("value")).intValue();
/* 126 */       this.FROZEN_DEC_NUM = Integer.valueOf(((Element)data.get("FROZEN_DEC_NUM")).attributeValue("value")).intValue();
/* 127 */       this.MIN_NUM_FOR_BOUND_TIP = Integer.valueOf(((Element)data.get("MIN_NUM_FOR_BOUND_TIP")).attributeValue("value")).intValue();
/* 128 */       this.TIPS = Integer.valueOf(((Element)data.get("TIPS")).attributeValue("value")).intValue();
/* 129 */       this.doublePointItem = Integer.valueOf(((Element)data.get("doublePointItem")).attributeValue("value")).intValue();
/* 130 */       this.ITEM_USE_TIMES_RESET_TIME = Integer.valueOf(((Element)data.get("ITEM_USE_TIMES_RESET_TIME")).attributeValue("value")).intValue();
/* 131 */       this.DOUBLE_POINT_ITEM_ID = Integer.valueOf(((Element)data.get("DOUBLE_POINT_ITEM_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 135 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 139 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 142 */     String path = dir + "mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts.bny";
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
/* 157 */         this.OFFER_TIME = _os_.unmarshal_int();
/* 158 */         this.OFFER_NUM = _os_.unmarshal_int();
/* 159 */         this.REST_POINT_MAX_NUM = _os_.unmarshal_int();
/* 160 */         this.ONCE_GET_MAX_NUM = _os_.unmarshal_int();
/* 161 */         this.ROLE_CARRY_MAX_NUM = _os_.unmarshal_int();
/* 162 */         this.NEWER_COMPENSATION_NUM = _os_.unmarshal_int();
/* 163 */         this.REST_POINT_DISCOUNT = _os_.unmarshal_int();
/* 164 */         this.REST_POINT_DISCOUNT_BASE = _os_.unmarshal_int();
/* 165 */         this.ITEM_MAX_USE_COUNT = _os_.unmarshal_int();
/* 166 */         this.FROZEN_DEC_NUM = _os_.unmarshal_int();
/* 167 */         this.MIN_NUM_FOR_BOUND_TIP = _os_.unmarshal_int();
/* 168 */         this.TIPS = _os_.unmarshal_int();
/* 169 */         this.doublePointItem = _os_.unmarshal_int();
/* 170 */         this.ITEM_USE_TIMES_RESET_TIME = _os_.unmarshal_int();
/* 171 */         this.DOUBLE_POINT_ITEM_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 182 */     String path = dir + "mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts.bny";
/*     */     try
/*     */     {
/* 185 */       File file = new File(path);
/* 186 */       if (file.exists())
/*     */       {
/* 188 */         byte[] bytes = new byte['Ѐ'];
/* 189 */         FileInputStream fis = new FileInputStream(file);
/* 190 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 191 */         int len = 0;
/* 192 */         while ((len = fis.read(bytes)) > 0)
/* 193 */           baos.write(bytes, 0, len);
/* 194 */         fis.close();
/* 195 */         bytes = baos.toByteArray();
/* 196 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 197 */         this.OFFER_TIME = _os_.unmarshal_int();
/* 198 */         this.OFFER_NUM = _os_.unmarshal_int();
/* 199 */         this.REST_POINT_MAX_NUM = _os_.unmarshal_int();
/* 200 */         this.ONCE_GET_MAX_NUM = _os_.unmarshal_int();
/* 201 */         this.ROLE_CARRY_MAX_NUM = _os_.unmarshal_int();
/* 202 */         this.NEWER_COMPENSATION_NUM = _os_.unmarshal_int();
/* 203 */         this.REST_POINT_DISCOUNT = _os_.unmarshal_int();
/* 204 */         this.REST_POINT_DISCOUNT_BASE = _os_.unmarshal_int();
/* 205 */         this.ITEM_MAX_USE_COUNT = _os_.unmarshal_int();
/* 206 */         this.FROZEN_DEC_NUM = _os_.unmarshal_int();
/* 207 */         this.MIN_NUM_FOR_BOUND_TIP = _os_.unmarshal_int();
/* 208 */         this.TIPS = _os_.unmarshal_int();
/* 209 */         this.doublePointItem = _os_.unmarshal_int();
/* 210 */         this.ITEM_USE_TIMES_RESET_TIME = _os_.unmarshal_int();
/* 211 */         this.DOUBLE_POINT_ITEM_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(DoublePointOfferCfgConsts newInstance)
/*     */   {
/* 222 */     oldInstance = instance;
/* 223 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 228 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\confbean\DoublePointOfferCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */