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
/*     */ public class FetusEducationMusicConsts
/*     */ {
/*  13 */   private static volatile FetusEducationMusicConsts oldInstance = null;
/*     */   
/*  15 */   private static FetusEducationMusicConsts instance = new FetusEducationMusicConsts();
/*     */   
/*     */   public int ACTIVITY_CFG_ID;
/*     */   
/*     */   public int MUSIC_GAME_ID;
/*     */   
/*     */   public static FetusEducationMusicConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static FetusEducationMusicConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void loadXml(String dir)
/*     */   {
/*  36 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  41 */     String path = dir + "mzm.gsp.children.confbean.FetusEducationMusicConsts.xml";
/*     */     try
/*     */     {
/*  44 */       SAXReader reader = new SAXReader();
/*  45 */       org.dom4j.Document doc = reader.read(new File(path));
/*  46 */       Element root = doc.getRootElement();
/*  47 */       Map<String, Element> data = new java.util.HashMap();
/*  48 */       java.util.List<?> nodeList = root.elements();
/*  49 */       int len = nodeList.size();
/*  50 */       for (int i = 0; i < len; i++)
/*     */       {
/*  52 */         Element element = (Element)nodeList.get(i);
/*  53 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  56 */           String name = element.attributeValue("name");
/*  57 */           if (data.put(name, element) != null)
/*  58 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  61 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  62 */       this.MUSIC_GAME_ID = Integer.valueOf(((Element)data.get("MUSIC_GAME_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  66 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  71 */     String path = dir + "mzm.gsp.children.confbean.FetusEducationMusicConsts.xml";
/*     */     try
/*     */     {
/*  74 */       SAXReader reader = new SAXReader();
/*  75 */       org.dom4j.Document doc = reader.read(new File(path));
/*  76 */       Element root = doc.getRootElement();
/*  77 */       Map<String, Element> data = new java.util.HashMap();
/*  78 */       java.util.List<?> nodeList = root.elements();
/*  79 */       int len = nodeList.size();
/*  80 */       for (int i = 0; i < len; i++)
/*     */       {
/*  82 */         Element element = (Element)nodeList.get(i);
/*  83 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  86 */           String name = element.attributeValue("name");
/*  87 */           if (data.put(name, element) != null)
/*  88 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  91 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  92 */       this.MUSIC_GAME_ID = Integer.valueOf(((Element)data.get("MUSIC_GAME_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  96 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 100 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 103 */     String path = dir + "mzm.gsp.children.confbean.FetusEducationMusicConsts.bny";
/*     */     try
/*     */     {
/* 106 */       File file = new File(path);
/* 107 */       if (file.exists())
/*     */       {
/* 109 */         byte[] bytes = new byte['Ѐ'];
/* 110 */         FileInputStream fis = new FileInputStream(file);
/* 111 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 112 */         int len = 0;
/* 113 */         while ((len = fis.read(bytes)) > 0)
/* 114 */           baos.write(bytes, 0, len);
/* 115 */         fis.close();
/* 116 */         bytes = baos.toByteArray();
/* 117 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 118 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 119 */         this.MUSIC_GAME_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 130 */     String path = dir + "mzm.gsp.children.confbean.FetusEducationMusicConsts.bny";
/*     */     try
/*     */     {
/* 133 */       File file = new File(path);
/* 134 */       if (file.exists())
/*     */       {
/* 136 */         byte[] bytes = new byte['Ѐ'];
/* 137 */         FileInputStream fis = new FileInputStream(file);
/* 138 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 139 */         int len = 0;
/* 140 */         while ((len = fis.read(bytes)) > 0)
/* 141 */           baos.write(bytes, 0, len);
/* 142 */         fis.close();
/* 143 */         bytes = baos.toByteArray();
/* 144 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 145 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 146 */         this.MUSIC_GAME_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 151 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(FetusEducationMusicConsts newInstance)
/*     */   {
/* 157 */     oldInstance = instance;
/* 158 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 163 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\FetusEducationMusicConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */