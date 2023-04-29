/*     */ package mzm.gsp.competition.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SCompetitionMercenaryConsts
/*     */ {
/*  13 */   private static volatile SCompetitionMercenaryConsts oldInstance = null;
/*     */   
/*  15 */   private static SCompetitionMercenaryConsts instance = new SCompetitionMercenaryConsts();
/*     */   public double CountDiffRate;
/*     */   public int CountDiff;
/*     */   public int MercenaryController;
/*     */   public int MercenaryIntervalSeconds;
/*     */   
/*     */   public static SCompetitionMercenaryConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SCompetitionMercenaryConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int RecallMercenaryMaxTimes;
/*     */   
/*     */   public int MercenaryAward;
/*     */   
/*     */   public int MercenaryScore;
/*     */   
/*     */   public int MercenaryScoreMinutes;
/*     */   
/*     */   public int MonsterTypeID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  43 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  48 */     String path = dir + "mzm.gsp.competition.confbean.SCompetitionMercenaryConsts.xml";
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
/*  68 */       this.CountDiffRate = Double.valueOf(((Element)data.get("CountDiffRate")).attributeValue("value")).doubleValue();
/*  69 */       this.CountDiff = Integer.valueOf(((Element)data.get("CountDiff")).attributeValue("value")).intValue();
/*  70 */       this.MercenaryController = Integer.valueOf(((Element)data.get("MercenaryController")).attributeValue("value")).intValue();
/*  71 */       this.MercenaryIntervalSeconds = Integer.valueOf(((Element)data.get("MercenaryIntervalSeconds")).attributeValue("value")).intValue();
/*  72 */       this.RecallMercenaryMaxTimes = Integer.valueOf(((Element)data.get("RecallMercenaryMaxTimes")).attributeValue("value")).intValue();
/*  73 */       this.MercenaryAward = Integer.valueOf(((Element)data.get("MercenaryAward")).attributeValue("value")).intValue();
/*  74 */       this.MercenaryScore = Integer.valueOf(((Element)data.get("MercenaryScore")).attributeValue("value")).intValue();
/*  75 */       this.MercenaryScoreMinutes = Integer.valueOf(((Element)data.get("MercenaryScoreMinutes")).attributeValue("value")).intValue();
/*  76 */       this.MonsterTypeID = Integer.valueOf(((Element)data.get("MonsterTypeID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  80 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  85 */     String path = dir + "mzm.gsp.competition.confbean.SCompetitionMercenaryConsts.xml";
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
/* 105 */       this.CountDiffRate = Double.valueOf(((Element)data.get("CountDiffRate")).attributeValue("value")).doubleValue();
/* 106 */       this.CountDiff = Integer.valueOf(((Element)data.get("CountDiff")).attributeValue("value")).intValue();
/* 107 */       this.MercenaryController = Integer.valueOf(((Element)data.get("MercenaryController")).attributeValue("value")).intValue();
/* 108 */       this.MercenaryIntervalSeconds = Integer.valueOf(((Element)data.get("MercenaryIntervalSeconds")).attributeValue("value")).intValue();
/* 109 */       this.RecallMercenaryMaxTimes = Integer.valueOf(((Element)data.get("RecallMercenaryMaxTimes")).attributeValue("value")).intValue();
/* 110 */       this.MercenaryAward = Integer.valueOf(((Element)data.get("MercenaryAward")).attributeValue("value")).intValue();
/* 111 */       this.MercenaryScore = Integer.valueOf(((Element)data.get("MercenaryScore")).attributeValue("value")).intValue();
/* 112 */       this.MercenaryScoreMinutes = Integer.valueOf(((Element)data.get("MercenaryScoreMinutes")).attributeValue("value")).intValue();
/* 113 */       this.MonsterTypeID = Integer.valueOf(((Element)data.get("MonsterTypeID")).attributeValue("value")).intValue();
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
/* 124 */     String path = dir + "mzm.gsp.competition.confbean.SCompetitionMercenaryConsts.bny";
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
/* 139 */         this.CountDiffRate = _os_.unmarshal_float();
/* 140 */         this.CountDiff = _os_.unmarshal_int();
/* 141 */         this.MercenaryController = _os_.unmarshal_int();
/* 142 */         this.MercenaryIntervalSeconds = _os_.unmarshal_int();
/* 143 */         this.RecallMercenaryMaxTimes = _os_.unmarshal_int();
/* 144 */         this.MercenaryAward = _os_.unmarshal_int();
/* 145 */         this.MercenaryScore = _os_.unmarshal_int();
/* 146 */         this.MercenaryScoreMinutes = _os_.unmarshal_int();
/* 147 */         this.MonsterTypeID = _os_.unmarshal_int();
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
/* 158 */     String path = dir + "mzm.gsp.competition.confbean.SCompetitionMercenaryConsts.bny";
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
/* 173 */         this.CountDiffRate = _os_.unmarshal_float();
/* 174 */         this.CountDiff = _os_.unmarshal_int();
/* 175 */         this.MercenaryController = _os_.unmarshal_int();
/* 176 */         this.MercenaryIntervalSeconds = _os_.unmarshal_int();
/* 177 */         this.RecallMercenaryMaxTimes = _os_.unmarshal_int();
/* 178 */         this.MercenaryAward = _os_.unmarshal_int();
/* 179 */         this.MercenaryScore = _os_.unmarshal_int();
/* 180 */         this.MercenaryScoreMinutes = _os_.unmarshal_int();
/* 181 */         this.MonsterTypeID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SCompetitionMercenaryConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\confbean\SCompetitionMercenaryConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */