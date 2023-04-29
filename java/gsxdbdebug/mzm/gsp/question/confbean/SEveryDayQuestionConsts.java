/*     */ package mzm.gsp.question.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SEveryDayQuestionConsts
/*     */ {
/*  13 */   private static volatile SEveryDayQuestionConsts oldInstance = null;
/*     */   
/*  15 */   private static SEveryDayQuestionConsts instance = new SEveryDayQuestionConsts();
/*     */   public int AWARD_VIGOR_TYPE;
/*     */   public int AWARD_VIGOR_LIMIT_PERDAY;
/*     */   public int STORAGE_EXP_RATE;
/*     */   public int PICTURE_QUESTION_TIME;
/*     */   public int ANSWER_SIZE;
/*     */   public int RETURN_BACK_EXP_CHANGE_RATE;
/*     */   
/*  23 */   public static SEveryDayQuestionConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static SEveryDayQuestionConsts getInstance()
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
/*  45 */     String path = dir + "mzm.gsp.question.confbean.SEveryDayQuestionConsts.xml";
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
/*  65 */       this.AWARD_VIGOR_TYPE = Integer.valueOf(((Element)data.get("AWARD_VIGOR_TYPE")).attributeValue("value")).intValue();
/*  66 */       this.AWARD_VIGOR_LIMIT_PERDAY = Integer.valueOf(((Element)data.get("AWARD_VIGOR_LIMIT_PERDAY")).attributeValue("value")).intValue();
/*  67 */       this.STORAGE_EXP_RATE = Integer.valueOf(((Element)data.get("STORAGE_EXP_RATE")).attributeValue("value")).intValue();
/*  68 */       this.PICTURE_QUESTION_TIME = Integer.valueOf(((Element)data.get("PICTURE_QUESTION_TIME")).attributeValue("value")).intValue();
/*  69 */       this.ANSWER_SIZE = Integer.valueOf(((Element)data.get("ANSWER_SIZE")).attributeValue("value")).intValue();
/*  70 */       this.RETURN_BACK_EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("RETURN_BACK_EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  74 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  79 */     String path = dir + "mzm.gsp.question.confbean.SEveryDayQuestionConsts.xml";
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
/*  99 */       this.AWARD_VIGOR_TYPE = Integer.valueOf(((Element)data.get("AWARD_VIGOR_TYPE")).attributeValue("value")).intValue();
/* 100 */       this.AWARD_VIGOR_LIMIT_PERDAY = Integer.valueOf(((Element)data.get("AWARD_VIGOR_LIMIT_PERDAY")).attributeValue("value")).intValue();
/* 101 */       this.STORAGE_EXP_RATE = Integer.valueOf(((Element)data.get("STORAGE_EXP_RATE")).attributeValue("value")).intValue();
/* 102 */       this.PICTURE_QUESTION_TIME = Integer.valueOf(((Element)data.get("PICTURE_QUESTION_TIME")).attributeValue("value")).intValue();
/* 103 */       this.ANSWER_SIZE = Integer.valueOf(((Element)data.get("ANSWER_SIZE")).attributeValue("value")).intValue();
/* 104 */       this.RETURN_BACK_EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("RETURN_BACK_EXP_CHANGE_RATE")).attributeValue("value")).intValue();
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
/* 115 */     String path = dir + "mzm.gsp.question.confbean.SEveryDayQuestionConsts.bny";
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
/* 130 */         this.AWARD_VIGOR_TYPE = _os_.unmarshal_int();
/* 131 */         this.AWARD_VIGOR_LIMIT_PERDAY = _os_.unmarshal_int();
/* 132 */         this.STORAGE_EXP_RATE = _os_.unmarshal_int();
/* 133 */         this.PICTURE_QUESTION_TIME = _os_.unmarshal_int();
/* 134 */         this.ANSWER_SIZE = _os_.unmarshal_int();
/* 135 */         this.RETURN_BACK_EXP_CHANGE_RATE = _os_.unmarshal_int();
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
/* 146 */     String path = dir + "mzm.gsp.question.confbean.SEveryDayQuestionConsts.bny";
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
/* 161 */         this.AWARD_VIGOR_TYPE = _os_.unmarshal_int();
/* 162 */         this.AWARD_VIGOR_LIMIT_PERDAY = _os_.unmarshal_int();
/* 163 */         this.STORAGE_EXP_RATE = _os_.unmarshal_int();
/* 164 */         this.PICTURE_QUESTION_TIME = _os_.unmarshal_int();
/* 165 */         this.ANSWER_SIZE = _os_.unmarshal_int();
/* 166 */         this.RETURN_BACK_EXP_CHANGE_RATE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 171 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SEveryDayQuestionConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\confbean\SEveryDayQuestionConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */