/*     */ package mzm.gsp.shitu.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMasterRecommendConsts
/*     */ {
/*  13 */   private static volatile SMasterRecommendConsts oldInstance = null;
/*     */   
/*  15 */   private static SMasterRecommendConsts instance = new SMasterRecommendConsts();
/*     */   public int APPRENTICE_MIN_LEVEL;
/*     */   public int RECOMMEND_INTERVAL_LEVEL;
/*     */   public int APPRENTICE_MAX_LEVEL;
/*     */   public int MASTER_SERVER_DIVERSITY_LEVEL;
/*     */   public int MASTER_MIN_LEVEL;
/*     */   
/*     */   public static SMasterRecommendConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SMasterRecommendConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int OPEN_SERVER_LEVEL;
/*     */   
/*     */   public int MIN_MASTER_RECOMMEND_NUM;
/*     */   
/*     */   public int YOUYUAN_MASTER_RECOMMEND_NUM;
/*     */   
/*     */   public int RECOMMEND_MASTER_COUNTDOWN_TIME;
/*     */   
/*     */   public int RECOMMEND_APPRENTICE_COUNTDOWN_TIME;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  44 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  49 */     String path = dir + "mzm.gsp.shitu.confbean.SMasterRecommendConsts.xml";
/*     */     try
/*     */     {
/*  52 */       SAXReader reader = new SAXReader();
/*  53 */       org.dom4j.Document doc = reader.read(new File(path));
/*  54 */       Element root = doc.getRootElement();
/*  55 */       Map<String, Element> data = new java.util.HashMap();
/*  56 */       java.util.List<?> nodeList = root.elements();
/*  57 */       int len = nodeList.size();
/*  58 */       for (int i = 0; i < len; i++)
/*     */       {
/*  60 */         Element element = (Element)nodeList.get(i);
/*  61 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  64 */           String name = element.attributeValue("name");
/*  65 */           if (data.put(name, element) != null)
/*  66 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  69 */       this.APPRENTICE_MIN_LEVEL = Integer.valueOf(((Element)data.get("APPRENTICE_MIN_LEVEL")).attributeValue("value")).intValue();
/*  70 */       this.RECOMMEND_INTERVAL_LEVEL = Integer.valueOf(((Element)data.get("RECOMMEND_INTERVAL_LEVEL")).attributeValue("value")).intValue();
/*  71 */       this.APPRENTICE_MAX_LEVEL = Integer.valueOf(((Element)data.get("APPRENTICE_MAX_LEVEL")).attributeValue("value")).intValue();
/*  72 */       this.MASTER_SERVER_DIVERSITY_LEVEL = Integer.valueOf(((Element)data.get("MASTER_SERVER_DIVERSITY_LEVEL")).attributeValue("value")).intValue();
/*  73 */       this.MASTER_MIN_LEVEL = Integer.valueOf(((Element)data.get("MASTER_MIN_LEVEL")).attributeValue("value")).intValue();
/*  74 */       this.OPEN_SERVER_LEVEL = Integer.valueOf(((Element)data.get("OPEN_SERVER_LEVEL")).attributeValue("value")).intValue();
/*  75 */       this.MIN_MASTER_RECOMMEND_NUM = Integer.valueOf(((Element)data.get("MIN_MASTER_RECOMMEND_NUM")).attributeValue("value")).intValue();
/*  76 */       this.YOUYUAN_MASTER_RECOMMEND_NUM = Integer.valueOf(((Element)data.get("YOUYUAN_MASTER_RECOMMEND_NUM")).attributeValue("value")).intValue();
/*  77 */       this.RECOMMEND_MASTER_COUNTDOWN_TIME = Integer.valueOf(((Element)data.get("RECOMMEND_MASTER_COUNTDOWN_TIME")).attributeValue("value")).intValue();
/*  78 */       this.RECOMMEND_APPRENTICE_COUNTDOWN_TIME = Integer.valueOf(((Element)data.get("RECOMMEND_APPRENTICE_COUNTDOWN_TIME")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  82 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  87 */     String path = dir + "mzm.gsp.shitu.confbean.SMasterRecommendConsts.xml";
/*     */     try
/*     */     {
/*  90 */       SAXReader reader = new SAXReader();
/*  91 */       org.dom4j.Document doc = reader.read(new File(path));
/*  92 */       Element root = doc.getRootElement();
/*  93 */       Map<String, Element> data = new java.util.HashMap();
/*  94 */       java.util.List<?> nodeList = root.elements();
/*  95 */       int len = nodeList.size();
/*  96 */       for (int i = 0; i < len; i++)
/*     */       {
/*  98 */         Element element = (Element)nodeList.get(i);
/*  99 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 102 */           String name = element.attributeValue("name");
/* 103 */           if (data.put(name, element) != null)
/* 104 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 107 */       this.APPRENTICE_MIN_LEVEL = Integer.valueOf(((Element)data.get("APPRENTICE_MIN_LEVEL")).attributeValue("value")).intValue();
/* 108 */       this.RECOMMEND_INTERVAL_LEVEL = Integer.valueOf(((Element)data.get("RECOMMEND_INTERVAL_LEVEL")).attributeValue("value")).intValue();
/* 109 */       this.APPRENTICE_MAX_LEVEL = Integer.valueOf(((Element)data.get("APPRENTICE_MAX_LEVEL")).attributeValue("value")).intValue();
/* 110 */       this.MASTER_SERVER_DIVERSITY_LEVEL = Integer.valueOf(((Element)data.get("MASTER_SERVER_DIVERSITY_LEVEL")).attributeValue("value")).intValue();
/* 111 */       this.MASTER_MIN_LEVEL = Integer.valueOf(((Element)data.get("MASTER_MIN_LEVEL")).attributeValue("value")).intValue();
/* 112 */       this.OPEN_SERVER_LEVEL = Integer.valueOf(((Element)data.get("OPEN_SERVER_LEVEL")).attributeValue("value")).intValue();
/* 113 */       this.MIN_MASTER_RECOMMEND_NUM = Integer.valueOf(((Element)data.get("MIN_MASTER_RECOMMEND_NUM")).attributeValue("value")).intValue();
/* 114 */       this.YOUYUAN_MASTER_RECOMMEND_NUM = Integer.valueOf(((Element)data.get("YOUYUAN_MASTER_RECOMMEND_NUM")).attributeValue("value")).intValue();
/* 115 */       this.RECOMMEND_MASTER_COUNTDOWN_TIME = Integer.valueOf(((Element)data.get("RECOMMEND_MASTER_COUNTDOWN_TIME")).attributeValue("value")).intValue();
/* 116 */       this.RECOMMEND_APPRENTICE_COUNTDOWN_TIME = Integer.valueOf(((Element)data.get("RECOMMEND_APPRENTICE_COUNTDOWN_TIME")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 120 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 124 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 127 */     String path = dir + "mzm.gsp.shitu.confbean.SMasterRecommendConsts.bny";
/*     */     try
/*     */     {
/* 130 */       File file = new File(path);
/* 131 */       if (file.exists())
/*     */       {
/* 133 */         byte[] bytes = new byte['Ѐ'];
/* 134 */         FileInputStream fis = new FileInputStream(file);
/* 135 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 136 */         int len = 0;
/* 137 */         while ((len = fis.read(bytes)) > 0)
/* 138 */           baos.write(bytes, 0, len);
/* 139 */         fis.close();
/* 140 */         bytes = baos.toByteArray();
/* 141 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 142 */         this.APPRENTICE_MIN_LEVEL = _os_.unmarshal_int();
/* 143 */         this.RECOMMEND_INTERVAL_LEVEL = _os_.unmarshal_int();
/* 144 */         this.APPRENTICE_MAX_LEVEL = _os_.unmarshal_int();
/* 145 */         this.MASTER_SERVER_DIVERSITY_LEVEL = _os_.unmarshal_int();
/* 146 */         this.MASTER_MIN_LEVEL = _os_.unmarshal_int();
/* 147 */         this.OPEN_SERVER_LEVEL = _os_.unmarshal_int();
/* 148 */         this.MIN_MASTER_RECOMMEND_NUM = _os_.unmarshal_int();
/* 149 */         this.YOUYUAN_MASTER_RECOMMEND_NUM = _os_.unmarshal_int();
/* 150 */         this.RECOMMEND_MASTER_COUNTDOWN_TIME = _os_.unmarshal_int();
/* 151 */         this.RECOMMEND_APPRENTICE_COUNTDOWN_TIME = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 162 */     String path = dir + "mzm.gsp.shitu.confbean.SMasterRecommendConsts.bny";
/*     */     try
/*     */     {
/* 165 */       File file = new File(path);
/* 166 */       if (file.exists())
/*     */       {
/* 168 */         byte[] bytes = new byte['Ѐ'];
/* 169 */         FileInputStream fis = new FileInputStream(file);
/* 170 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 171 */         int len = 0;
/* 172 */         while ((len = fis.read(bytes)) > 0)
/* 173 */           baos.write(bytes, 0, len);
/* 174 */         fis.close();
/* 175 */         bytes = baos.toByteArray();
/* 176 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 177 */         this.APPRENTICE_MIN_LEVEL = _os_.unmarshal_int();
/* 178 */         this.RECOMMEND_INTERVAL_LEVEL = _os_.unmarshal_int();
/* 179 */         this.APPRENTICE_MAX_LEVEL = _os_.unmarshal_int();
/* 180 */         this.MASTER_SERVER_DIVERSITY_LEVEL = _os_.unmarshal_int();
/* 181 */         this.MASTER_MIN_LEVEL = _os_.unmarshal_int();
/* 182 */         this.OPEN_SERVER_LEVEL = _os_.unmarshal_int();
/* 183 */         this.MIN_MASTER_RECOMMEND_NUM = _os_.unmarshal_int();
/* 184 */         this.YOUYUAN_MASTER_RECOMMEND_NUM = _os_.unmarshal_int();
/* 185 */         this.RECOMMEND_MASTER_COUNTDOWN_TIME = _os_.unmarshal_int();
/* 186 */         this.RECOMMEND_APPRENTICE_COUNTDOWN_TIME = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 191 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMasterRecommendConsts newInstance)
/*     */   {
/* 197 */     oldInstance = instance;
/* 198 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 203 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\confbean\SMasterRecommendConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */