/*     */ package mzm.gsp.visiblemonsterfight.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SShengXiaoFightConsts
/*     */ {
/*  13 */   private static volatile SShengXiaoFightConsts oldInstance = null;
/*     */   
/*  15 */   private static SShengXiaoFightConsts instance = new SShengXiaoFightConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SShengXiaoFightConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SShengXiaoFightConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int ACTIVITYID = 0;
/*  32 */   public int VISIBLE_MONSTER_ID1 = 0;
/*  33 */   public int AWARD_ID1 = 500000000;
/*  34 */   public int VISIBLE_MONSTER_ID2 = 0;
/*  35 */   public int AWARD_ID2 = 500000000;
/*  36 */   public int REWARD_LIMIT = 2;
/*  37 */   public int CONTROLLERID = 0;
/*  38 */   public int REFRESH_TIME_CFG = 0;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  42 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  47 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SShengXiaoFightConsts.xml";
/*     */     try
/*     */     {
/*  50 */       SAXReader reader = new SAXReader();
/*  51 */       org.dom4j.Document doc = reader.read(new File(path));
/*  52 */       Element root = doc.getRootElement();
/*  53 */       Map<String, Element> data = new java.util.HashMap();
/*  54 */       java.util.List<?> nodeList = root.elements();
/*  55 */       int len = nodeList.size();
/*  56 */       for (int i = 0; i < len; i++)
/*     */       {
/*  58 */         Element element = (Element)nodeList.get(i);
/*  59 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  62 */           String name = element.attributeValue("name");
/*  63 */           if (data.put(name, element) != null)
/*  64 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  67 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  68 */       this.VISIBLE_MONSTER_ID1 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID1")).attributeValue("value")).intValue();
/*  69 */       this.AWARD_ID1 = Integer.valueOf(((Element)data.get("AWARD_ID1")).attributeValue("value")).intValue();
/*  70 */       this.VISIBLE_MONSTER_ID2 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID2")).attributeValue("value")).intValue();
/*  71 */       this.AWARD_ID2 = Integer.valueOf(((Element)data.get("AWARD_ID2")).attributeValue("value")).intValue();
/*  72 */       this.REWARD_LIMIT = Integer.valueOf(((Element)data.get("REWARD_LIMIT")).attributeValue("value")).intValue();
/*  73 */       this.CONTROLLERID = Integer.valueOf(((Element)data.get("CONTROLLERID")).attributeValue("value")).intValue();
/*  74 */       this.REFRESH_TIME_CFG = Integer.valueOf(((Element)data.get("REFRESH_TIME_CFG")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  78 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  83 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SShengXiaoFightConsts.xml";
/*     */     try
/*     */     {
/*  86 */       SAXReader reader = new SAXReader();
/*  87 */       org.dom4j.Document doc = reader.read(new File(path));
/*  88 */       Element root = doc.getRootElement();
/*  89 */       Map<String, Element> data = new java.util.HashMap();
/*  90 */       java.util.List<?> nodeList = root.elements();
/*  91 */       int len = nodeList.size();
/*  92 */       for (int i = 0; i < len; i++)
/*     */       {
/*  94 */         Element element = (Element)nodeList.get(i);
/*  95 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  98 */           String name = element.attributeValue("name");
/*  99 */           if (data.put(name, element) != null)
/* 100 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 103 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 104 */       this.VISIBLE_MONSTER_ID1 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID1")).attributeValue("value")).intValue();
/* 105 */       this.AWARD_ID1 = Integer.valueOf(((Element)data.get("AWARD_ID1")).attributeValue("value")).intValue();
/* 106 */       this.VISIBLE_MONSTER_ID2 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID2")).attributeValue("value")).intValue();
/* 107 */       this.AWARD_ID2 = Integer.valueOf(((Element)data.get("AWARD_ID2")).attributeValue("value")).intValue();
/* 108 */       this.REWARD_LIMIT = Integer.valueOf(((Element)data.get("REWARD_LIMIT")).attributeValue("value")).intValue();
/* 109 */       this.CONTROLLERID = Integer.valueOf(((Element)data.get("CONTROLLERID")).attributeValue("value")).intValue();
/* 110 */       this.REFRESH_TIME_CFG = Integer.valueOf(((Element)data.get("REFRESH_TIME_CFG")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 114 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 118 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 121 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SShengXiaoFightConsts.bny";
/*     */     try
/*     */     {
/* 124 */       File file = new File(path);
/* 125 */       if (file.exists())
/*     */       {
/* 127 */         byte[] bytes = new byte['Ѐ'];
/* 128 */         FileInputStream fis = new FileInputStream(file);
/* 129 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 130 */         int len = 0;
/* 131 */         while ((len = fis.read(bytes)) > 0)
/* 132 */           baos.write(bytes, 0, len);
/* 133 */         fis.close();
/* 134 */         bytes = baos.toByteArray();
/* 135 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 136 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 137 */         this.VISIBLE_MONSTER_ID1 = _os_.unmarshal_int();
/* 138 */         this.AWARD_ID1 = _os_.unmarshal_int();
/* 139 */         this.VISIBLE_MONSTER_ID2 = _os_.unmarshal_int();
/* 140 */         this.AWARD_ID2 = _os_.unmarshal_int();
/* 141 */         this.REWARD_LIMIT = _os_.unmarshal_int();
/* 142 */         this.CONTROLLERID = _os_.unmarshal_int();
/* 143 */         this.REFRESH_TIME_CFG = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 154 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SShengXiaoFightConsts.bny";
/*     */     try
/*     */     {
/* 157 */       File file = new File(path);
/* 158 */       if (file.exists())
/*     */       {
/* 160 */         byte[] bytes = new byte['Ѐ'];
/* 161 */         FileInputStream fis = new FileInputStream(file);
/* 162 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 163 */         int len = 0;
/* 164 */         while ((len = fis.read(bytes)) > 0)
/* 165 */           baos.write(bytes, 0, len);
/* 166 */         fis.close();
/* 167 */         bytes = baos.toByteArray();
/* 168 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 169 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 170 */         this.VISIBLE_MONSTER_ID1 = _os_.unmarshal_int();
/* 171 */         this.AWARD_ID1 = _os_.unmarshal_int();
/* 172 */         this.VISIBLE_MONSTER_ID2 = _os_.unmarshal_int();
/* 173 */         this.AWARD_ID2 = _os_.unmarshal_int();
/* 174 */         this.REWARD_LIMIT = _os_.unmarshal_int();
/* 175 */         this.CONTROLLERID = _os_.unmarshal_int();
/* 176 */         this.REFRESH_TIME_CFG = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 181 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SShengXiaoFightConsts newInstance)
/*     */   {
/* 187 */     oldInstance = instance;
/* 188 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 193 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\confbean\SShengXiaoFightConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */