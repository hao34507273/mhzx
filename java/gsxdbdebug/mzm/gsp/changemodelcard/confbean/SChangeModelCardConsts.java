/*     */ package mzm.gsp.changemodelcard.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SChangeModelCardConsts
/*     */ {
/*  13 */   private static volatile SChangeModelCardConsts oldInstance = null;
/*     */   
/*  15 */   private static SChangeModelCardConsts instance = new SChangeModelCardConsts();
/*     */   public int OPEN_LEVEL;
/*     */   public int DEFAULT_CLASS;
/*     */   public int DEFAULT_CLASS_LEVEL;
/*     */   public int INIT_ESSENCE;
/*     */   public int INIT_SCORE;
/*     */   public int MAX_OVERLAY_COUNT;
/*     */   
/*  23 */   public static SChangeModelCardConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static SChangeModelCardConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int LOTTERY_COST;
/*     */   
/*     */   public int TEN_LOTTERY_COST;
/*     */   
/*     */   public int LOTTERY_AWARD_POOL_TYPE_ID;
/*     */   
/*     */   public int LOTTERY_ANIMATION_DURATION;
/*     */   
/*     */   public int EXPIRE_NOTIFY_REMAIN_PVP_COUNT;
/*     */   
/*     */   public int EXPIRE_NOTIFY_REMAIN_MINUTES;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  46 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  51 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts.xml";
/*     */     try
/*     */     {
/*  54 */       SAXReader reader = new SAXReader();
/*  55 */       org.dom4j.Document doc = reader.read(new File(path));
/*  56 */       Element root = doc.getRootElement();
/*  57 */       Map<String, Element> data = new java.util.HashMap();
/*  58 */       java.util.List<?> nodeList = root.elements();
/*  59 */       int len = nodeList.size();
/*  60 */       for (int i = 0; i < len; i++)
/*     */       {
/*  62 */         Element element = (Element)nodeList.get(i);
/*  63 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  66 */           String name = element.attributeValue("name");
/*  67 */           if (data.put(name, element) != null)
/*  68 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  71 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/*  72 */       this.DEFAULT_CLASS = Integer.valueOf(((Element)data.get("DEFAULT_CLASS")).attributeValue("value")).intValue();
/*  73 */       this.DEFAULT_CLASS_LEVEL = Integer.valueOf(((Element)data.get("DEFAULT_CLASS_LEVEL")).attributeValue("value")).intValue();
/*  74 */       this.INIT_ESSENCE = Integer.valueOf(((Element)data.get("INIT_ESSENCE")).attributeValue("value")).intValue();
/*  75 */       this.INIT_SCORE = Integer.valueOf(((Element)data.get("INIT_SCORE")).attributeValue("value")).intValue();
/*  76 */       this.MAX_OVERLAY_COUNT = Integer.valueOf(((Element)data.get("MAX_OVERLAY_COUNT")).attributeValue("value")).intValue();
/*  77 */       this.LOTTERY_COST = Integer.valueOf(((Element)data.get("LOTTERY_COST")).attributeValue("value")).intValue();
/*  78 */       this.TEN_LOTTERY_COST = Integer.valueOf(((Element)data.get("TEN_LOTTERY_COST")).attributeValue("value")).intValue();
/*  79 */       this.LOTTERY_AWARD_POOL_TYPE_ID = Integer.valueOf(((Element)data.get("LOTTERY_AWARD_POOL_TYPE_ID")).attributeValue("value")).intValue();
/*  80 */       this.LOTTERY_ANIMATION_DURATION = Integer.valueOf(((Element)data.get("LOTTERY_ANIMATION_DURATION")).attributeValue("value")).intValue();
/*  81 */       this.EXPIRE_NOTIFY_REMAIN_PVP_COUNT = Integer.valueOf(((Element)data.get("EXPIRE_NOTIFY_REMAIN_PVP_COUNT")).attributeValue("value")).intValue();
/*  82 */       this.EXPIRE_NOTIFY_REMAIN_MINUTES = Integer.valueOf(((Element)data.get("EXPIRE_NOTIFY_REMAIN_MINUTES")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  86 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  91 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts.xml";
/*     */     try
/*     */     {
/*  94 */       SAXReader reader = new SAXReader();
/*  95 */       org.dom4j.Document doc = reader.read(new File(path));
/*  96 */       Element root = doc.getRootElement();
/*  97 */       Map<String, Element> data = new java.util.HashMap();
/*  98 */       java.util.List<?> nodeList = root.elements();
/*  99 */       int len = nodeList.size();
/* 100 */       for (int i = 0; i < len; i++)
/*     */       {
/* 102 */         Element element = (Element)nodeList.get(i);
/* 103 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 106 */           String name = element.attributeValue("name");
/* 107 */           if (data.put(name, element) != null)
/* 108 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 111 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/* 112 */       this.DEFAULT_CLASS = Integer.valueOf(((Element)data.get("DEFAULT_CLASS")).attributeValue("value")).intValue();
/* 113 */       this.DEFAULT_CLASS_LEVEL = Integer.valueOf(((Element)data.get("DEFAULT_CLASS_LEVEL")).attributeValue("value")).intValue();
/* 114 */       this.INIT_ESSENCE = Integer.valueOf(((Element)data.get("INIT_ESSENCE")).attributeValue("value")).intValue();
/* 115 */       this.INIT_SCORE = Integer.valueOf(((Element)data.get("INIT_SCORE")).attributeValue("value")).intValue();
/* 116 */       this.MAX_OVERLAY_COUNT = Integer.valueOf(((Element)data.get("MAX_OVERLAY_COUNT")).attributeValue("value")).intValue();
/* 117 */       this.LOTTERY_COST = Integer.valueOf(((Element)data.get("LOTTERY_COST")).attributeValue("value")).intValue();
/* 118 */       this.TEN_LOTTERY_COST = Integer.valueOf(((Element)data.get("TEN_LOTTERY_COST")).attributeValue("value")).intValue();
/* 119 */       this.LOTTERY_AWARD_POOL_TYPE_ID = Integer.valueOf(((Element)data.get("LOTTERY_AWARD_POOL_TYPE_ID")).attributeValue("value")).intValue();
/* 120 */       this.LOTTERY_ANIMATION_DURATION = Integer.valueOf(((Element)data.get("LOTTERY_ANIMATION_DURATION")).attributeValue("value")).intValue();
/* 121 */       this.EXPIRE_NOTIFY_REMAIN_PVP_COUNT = Integer.valueOf(((Element)data.get("EXPIRE_NOTIFY_REMAIN_PVP_COUNT")).attributeValue("value")).intValue();
/* 122 */       this.EXPIRE_NOTIFY_REMAIN_MINUTES = Integer.valueOf(((Element)data.get("EXPIRE_NOTIFY_REMAIN_MINUTES")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 126 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 130 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 133 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts.bny";
/*     */     try
/*     */     {
/* 136 */       File file = new File(path);
/* 137 */       if (file.exists())
/*     */       {
/* 139 */         byte[] bytes = new byte['Ѐ'];
/* 140 */         FileInputStream fis = new FileInputStream(file);
/* 141 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 142 */         int len = 0;
/* 143 */         while ((len = fis.read(bytes)) > 0)
/* 144 */           baos.write(bytes, 0, len);
/* 145 */         fis.close();
/* 146 */         bytes = baos.toByteArray();
/* 147 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 148 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 149 */         this.DEFAULT_CLASS = _os_.unmarshal_int();
/* 150 */         this.DEFAULT_CLASS_LEVEL = _os_.unmarshal_int();
/* 151 */         this.INIT_ESSENCE = _os_.unmarshal_int();
/* 152 */         this.INIT_SCORE = _os_.unmarshal_int();
/* 153 */         this.MAX_OVERLAY_COUNT = _os_.unmarshal_int();
/* 154 */         this.LOTTERY_COST = _os_.unmarshal_int();
/* 155 */         this.TEN_LOTTERY_COST = _os_.unmarshal_int();
/* 156 */         this.LOTTERY_AWARD_POOL_TYPE_ID = _os_.unmarshal_int();
/* 157 */         this.LOTTERY_ANIMATION_DURATION = _os_.unmarshal_int();
/* 158 */         this.EXPIRE_NOTIFY_REMAIN_PVP_COUNT = _os_.unmarshal_int();
/* 159 */         this.EXPIRE_NOTIFY_REMAIN_MINUTES = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 170 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts.bny";
/*     */     try
/*     */     {
/* 173 */       File file = new File(path);
/* 174 */       if (file.exists())
/*     */       {
/* 176 */         byte[] bytes = new byte['Ѐ'];
/* 177 */         FileInputStream fis = new FileInputStream(file);
/* 178 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 179 */         int len = 0;
/* 180 */         while ((len = fis.read(bytes)) > 0)
/* 181 */           baos.write(bytes, 0, len);
/* 182 */         fis.close();
/* 183 */         bytes = baos.toByteArray();
/* 184 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 185 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 186 */         this.DEFAULT_CLASS = _os_.unmarshal_int();
/* 187 */         this.DEFAULT_CLASS_LEVEL = _os_.unmarshal_int();
/* 188 */         this.INIT_ESSENCE = _os_.unmarshal_int();
/* 189 */         this.INIT_SCORE = _os_.unmarshal_int();
/* 190 */         this.MAX_OVERLAY_COUNT = _os_.unmarshal_int();
/* 191 */         this.LOTTERY_COST = _os_.unmarshal_int();
/* 192 */         this.TEN_LOTTERY_COST = _os_.unmarshal_int();
/* 193 */         this.LOTTERY_AWARD_POOL_TYPE_ID = _os_.unmarshal_int();
/* 194 */         this.LOTTERY_ANIMATION_DURATION = _os_.unmarshal_int();
/* 195 */         this.EXPIRE_NOTIFY_REMAIN_PVP_COUNT = _os_.unmarshal_int();
/* 196 */         this.EXPIRE_NOTIFY_REMAIN_MINUTES = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SChangeModelCardConsts newInstance)
/*     */   {
/* 207 */     oldInstance = instance;
/* 208 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 213 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\confbean\SChangeModelCardConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */