/*     */ package mzm.gsp.achievement.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class DouDouSongLiConsts
/*     */ {
/*  13 */   private static volatile DouDouSongLiConsts oldInstance = null;
/*     */   
/*  15 */   private static DouDouSongLiConsts instance = new DouDouSongLiConsts();
/*     */   public int activityId;
/*     */   public int maxScoreNum;
/*     */   public int roleMinLevel;
/*     */   public int dayCount;
/*     */   public int mailId;
/*     */   public int tipsId1;
/*     */   
/*  23 */   public static DouDouSongLiConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static DouDouSongLiConsts getInstance()
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
/*  45 */     String path = dir + "mzm.gsp.achievement.confbean.DouDouSongLiConsts.xml";
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
/*  65 */       this.activityId = Integer.valueOf(((Element)data.get("activityId")).attributeValue("value")).intValue();
/*  66 */       this.maxScoreNum = Integer.valueOf(((Element)data.get("maxScoreNum")).attributeValue("value")).intValue();
/*  67 */       this.roleMinLevel = Integer.valueOf(((Element)data.get("roleMinLevel")).attributeValue("value")).intValue();
/*  68 */       this.dayCount = Integer.valueOf(((Element)data.get("dayCount")).attributeValue("value")).intValue();
/*  69 */       this.mailId = Integer.valueOf(((Element)data.get("mailId")).attributeValue("value")).intValue();
/*  70 */       this.tipsId1 = Integer.valueOf(((Element)data.get("tipsId1")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  74 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  79 */     String path = dir + "mzm.gsp.achievement.confbean.DouDouSongLiConsts.xml";
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
/*  99 */       this.activityId = Integer.valueOf(((Element)data.get("activityId")).attributeValue("value")).intValue();
/* 100 */       this.maxScoreNum = Integer.valueOf(((Element)data.get("maxScoreNum")).attributeValue("value")).intValue();
/* 101 */       this.roleMinLevel = Integer.valueOf(((Element)data.get("roleMinLevel")).attributeValue("value")).intValue();
/* 102 */       this.dayCount = Integer.valueOf(((Element)data.get("dayCount")).attributeValue("value")).intValue();
/* 103 */       this.mailId = Integer.valueOf(((Element)data.get("mailId")).attributeValue("value")).intValue();
/* 104 */       this.tipsId1 = Integer.valueOf(((Element)data.get("tipsId1")).attributeValue("value")).intValue();
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
/* 115 */     String path = dir + "mzm.gsp.achievement.confbean.DouDouSongLiConsts.bny";
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
/* 130 */         this.activityId = _os_.unmarshal_int();
/* 131 */         this.maxScoreNum = _os_.unmarshal_int();
/* 132 */         this.roleMinLevel = _os_.unmarshal_int();
/* 133 */         this.dayCount = _os_.unmarshal_int();
/* 134 */         this.mailId = _os_.unmarshal_int();
/* 135 */         this.tipsId1 = _os_.unmarshal_int();
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
/* 146 */     String path = dir + "mzm.gsp.achievement.confbean.DouDouSongLiConsts.bny";
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
/* 161 */         this.activityId = _os_.unmarshal_int();
/* 162 */         this.maxScoreNum = _os_.unmarshal_int();
/* 163 */         this.roleMinLevel = _os_.unmarshal_int();
/* 164 */         this.dayCount = _os_.unmarshal_int();
/* 165 */         this.mailId = _os_.unmarshal_int();
/* 166 */         this.tipsId1 = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 171 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(DouDouSongLiConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\confbean\DouDouSongLiConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */