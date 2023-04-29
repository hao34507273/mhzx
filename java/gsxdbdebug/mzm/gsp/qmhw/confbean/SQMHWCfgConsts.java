/*     */ package mzm.gsp.qmhw.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SQMHWCfgConsts
/*     */ {
/*  13 */   private static volatile SQMHWCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SQMHWCfgConsts instance = new SQMHWCfgConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SQMHWCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SQMHWCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int ACTIVITY_ID = 350000000;
/*  32 */   public int NPC_ID = 150100000;
/*  33 */   public int START_CONTROL_ID = 701100007;
/*  34 */   public int LAST_MATH_TO_END_MIN = 10;
/*  35 */   public int COMMON_AWARD_ID = 0;
/*  36 */   public int COMMON_AWARD_INTERVAL_MIN = 2;
/*  37 */   public int MATCH_INTERVAL_SEC = 90;
/*  38 */   public int PREPARE_TIME_MIN = 15;
/*  39 */   public int ACTIVITY_MAP_ID = 330000001;
/*  40 */   public int OUT_MAP_ID = 330000001;
/*  41 */   public int FIRST_WIN_AWARDID = 0;
/*  42 */   public int FIGHT_COUNT = 5;
/*  43 */   public int FIGHT_COUNT_AWARDID = 0;
/*  44 */   public int WIN_AWARDID = 0;
/*  45 */   public int LOSE_AWARDID = 0;
/*  46 */   public int INI_SCORE = 1000;
/*  47 */   public int K = 200;
/*  48 */   public int CONTINU_WIN_COUNT = 5;
/*  49 */   public int NOTIFY_MAIL_ID = 340000000;
/*  50 */   public int MATCH_SCORE_INTERVAL = 800;
/*     */   public int MATCH_FAIL_EXTEND_SCORE;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  55 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  60 */     String path = dir + "mzm.gsp.qmhw.confbean.SQMHWCfgConsts.xml";
/*     */     try
/*     */     {
/*  63 */       SAXReader reader = new SAXReader();
/*  64 */       org.dom4j.Document doc = reader.read(new File(path));
/*  65 */       Element root = doc.getRootElement();
/*  66 */       Map<String, Element> data = new java.util.HashMap();
/*  67 */       java.util.List<?> nodeList = root.elements();
/*  68 */       int len = nodeList.size();
/*  69 */       for (int i = 0; i < len; i++)
/*     */       {
/*  71 */         Element element = (Element)nodeList.get(i);
/*  72 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  75 */           String name = element.attributeValue("name");
/*  76 */           if (data.put(name, element) != null)
/*  77 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  80 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/*  81 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  82 */       this.START_CONTROL_ID = Integer.valueOf(((Element)data.get("START_CONTROL_ID")).attributeValue("value")).intValue();
/*  83 */       this.LAST_MATH_TO_END_MIN = Integer.valueOf(((Element)data.get("LAST_MATH_TO_END_MIN")).attributeValue("value")).intValue();
/*  84 */       this.COMMON_AWARD_ID = Integer.valueOf(((Element)data.get("COMMON_AWARD_ID")).attributeValue("value")).intValue();
/*  85 */       this.COMMON_AWARD_INTERVAL_MIN = Integer.valueOf(((Element)data.get("COMMON_AWARD_INTERVAL_MIN")).attributeValue("value")).intValue();
/*  86 */       this.MATCH_INTERVAL_SEC = Integer.valueOf(((Element)data.get("MATCH_INTERVAL_SEC")).attributeValue("value")).intValue();
/*  87 */       this.PREPARE_TIME_MIN = Integer.valueOf(((Element)data.get("PREPARE_TIME_MIN")).attributeValue("value")).intValue();
/*  88 */       this.ACTIVITY_MAP_ID = Integer.valueOf(((Element)data.get("ACTIVITY_MAP_ID")).attributeValue("value")).intValue();
/*  89 */       this.OUT_MAP_ID = Integer.valueOf(((Element)data.get("OUT_MAP_ID")).attributeValue("value")).intValue();
/*  90 */       this.FIRST_WIN_AWARDID = Integer.valueOf(((Element)data.get("FIRST_WIN_AWARDID")).attributeValue("value")).intValue();
/*  91 */       this.FIGHT_COUNT = Integer.valueOf(((Element)data.get("FIGHT_COUNT")).attributeValue("value")).intValue();
/*  92 */       this.FIGHT_COUNT_AWARDID = Integer.valueOf(((Element)data.get("FIGHT_COUNT_AWARDID")).attributeValue("value")).intValue();
/*  93 */       this.WIN_AWARDID = Integer.valueOf(((Element)data.get("WIN_AWARDID")).attributeValue("value")).intValue();
/*  94 */       this.LOSE_AWARDID = Integer.valueOf(((Element)data.get("LOSE_AWARDID")).attributeValue("value")).intValue();
/*  95 */       this.INI_SCORE = Integer.valueOf(((Element)data.get("INI_SCORE")).attributeValue("value")).intValue();
/*  96 */       this.K = Integer.valueOf(((Element)data.get("K")).attributeValue("value")).intValue();
/*  97 */       this.CONTINU_WIN_COUNT = Integer.valueOf(((Element)data.get("CONTINU_WIN_COUNT")).attributeValue("value")).intValue();
/*  98 */       this.NOTIFY_MAIL_ID = Integer.valueOf(((Element)data.get("NOTIFY_MAIL_ID")).attributeValue("value")).intValue();
/*  99 */       this.MATCH_SCORE_INTERVAL = Integer.valueOf(((Element)data.get("MATCH_SCORE_INTERVAL")).attributeValue("value")).intValue();
/* 100 */       this.MATCH_FAIL_EXTEND_SCORE = Integer.valueOf(((Element)data.get("MATCH_FAIL_EXTEND_SCORE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 109 */     String path = dir + "mzm.gsp.qmhw.confbean.SQMHWCfgConsts.xml";
/*     */     try
/*     */     {
/* 112 */       SAXReader reader = new SAXReader();
/* 113 */       org.dom4j.Document doc = reader.read(new File(path));
/* 114 */       Element root = doc.getRootElement();
/* 115 */       Map<String, Element> data = new java.util.HashMap();
/* 116 */       java.util.List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element element = (Element)nodeList.get(i);
/* 121 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 124 */           String name = element.attributeValue("name");
/* 125 */           if (data.put(name, element) != null)
/* 126 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 129 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/* 130 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 131 */       this.START_CONTROL_ID = Integer.valueOf(((Element)data.get("START_CONTROL_ID")).attributeValue("value")).intValue();
/* 132 */       this.LAST_MATH_TO_END_MIN = Integer.valueOf(((Element)data.get("LAST_MATH_TO_END_MIN")).attributeValue("value")).intValue();
/* 133 */       this.COMMON_AWARD_ID = Integer.valueOf(((Element)data.get("COMMON_AWARD_ID")).attributeValue("value")).intValue();
/* 134 */       this.COMMON_AWARD_INTERVAL_MIN = Integer.valueOf(((Element)data.get("COMMON_AWARD_INTERVAL_MIN")).attributeValue("value")).intValue();
/* 135 */       this.MATCH_INTERVAL_SEC = Integer.valueOf(((Element)data.get("MATCH_INTERVAL_SEC")).attributeValue("value")).intValue();
/* 136 */       this.PREPARE_TIME_MIN = Integer.valueOf(((Element)data.get("PREPARE_TIME_MIN")).attributeValue("value")).intValue();
/* 137 */       this.ACTIVITY_MAP_ID = Integer.valueOf(((Element)data.get("ACTIVITY_MAP_ID")).attributeValue("value")).intValue();
/* 138 */       this.OUT_MAP_ID = Integer.valueOf(((Element)data.get("OUT_MAP_ID")).attributeValue("value")).intValue();
/* 139 */       this.FIRST_WIN_AWARDID = Integer.valueOf(((Element)data.get("FIRST_WIN_AWARDID")).attributeValue("value")).intValue();
/* 140 */       this.FIGHT_COUNT = Integer.valueOf(((Element)data.get("FIGHT_COUNT")).attributeValue("value")).intValue();
/* 141 */       this.FIGHT_COUNT_AWARDID = Integer.valueOf(((Element)data.get("FIGHT_COUNT_AWARDID")).attributeValue("value")).intValue();
/* 142 */       this.WIN_AWARDID = Integer.valueOf(((Element)data.get("WIN_AWARDID")).attributeValue("value")).intValue();
/* 143 */       this.LOSE_AWARDID = Integer.valueOf(((Element)data.get("LOSE_AWARDID")).attributeValue("value")).intValue();
/* 144 */       this.INI_SCORE = Integer.valueOf(((Element)data.get("INI_SCORE")).attributeValue("value")).intValue();
/* 145 */       this.K = Integer.valueOf(((Element)data.get("K")).attributeValue("value")).intValue();
/* 146 */       this.CONTINU_WIN_COUNT = Integer.valueOf(((Element)data.get("CONTINU_WIN_COUNT")).attributeValue("value")).intValue();
/* 147 */       this.NOTIFY_MAIL_ID = Integer.valueOf(((Element)data.get("NOTIFY_MAIL_ID")).attributeValue("value")).intValue();
/* 148 */       this.MATCH_SCORE_INTERVAL = Integer.valueOf(((Element)data.get("MATCH_SCORE_INTERVAL")).attributeValue("value")).intValue();
/* 149 */       this.MATCH_FAIL_EXTEND_SCORE = Integer.valueOf(((Element)data.get("MATCH_FAIL_EXTEND_SCORE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 157 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 160 */     String path = dir + "mzm.gsp.qmhw.confbean.SQMHWCfgConsts.bny";
/*     */     try
/*     */     {
/* 163 */       File file = new File(path);
/* 164 */       if (file.exists())
/*     */       {
/* 166 */         byte[] bytes = new byte['Ѐ'];
/* 167 */         FileInputStream fis = new FileInputStream(file);
/* 168 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 169 */         int len = 0;
/* 170 */         while ((len = fis.read(bytes)) > 0)
/* 171 */           baos.write(bytes, 0, len);
/* 172 */         fis.close();
/* 173 */         bytes = baos.toByteArray();
/* 174 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 175 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 176 */         this.NPC_ID = _os_.unmarshal_int();
/* 177 */         this.START_CONTROL_ID = _os_.unmarshal_int();
/* 178 */         this.LAST_MATH_TO_END_MIN = _os_.unmarshal_int();
/* 179 */         this.COMMON_AWARD_ID = _os_.unmarshal_int();
/* 180 */         this.COMMON_AWARD_INTERVAL_MIN = _os_.unmarshal_int();
/* 181 */         this.MATCH_INTERVAL_SEC = _os_.unmarshal_int();
/* 182 */         this.PREPARE_TIME_MIN = _os_.unmarshal_int();
/* 183 */         this.ACTIVITY_MAP_ID = _os_.unmarshal_int();
/* 184 */         this.OUT_MAP_ID = _os_.unmarshal_int();
/* 185 */         this.FIRST_WIN_AWARDID = _os_.unmarshal_int();
/* 186 */         this.FIGHT_COUNT = _os_.unmarshal_int();
/* 187 */         this.FIGHT_COUNT_AWARDID = _os_.unmarshal_int();
/* 188 */         this.WIN_AWARDID = _os_.unmarshal_int();
/* 189 */         this.LOSE_AWARDID = _os_.unmarshal_int();
/* 190 */         this.INI_SCORE = _os_.unmarshal_int();
/* 191 */         this.K = _os_.unmarshal_int();
/* 192 */         this.CONTINU_WIN_COUNT = _os_.unmarshal_int();
/* 193 */         this.NOTIFY_MAIL_ID = _os_.unmarshal_int();
/* 194 */         this.MATCH_SCORE_INTERVAL = _os_.unmarshal_int();
/* 195 */         this.MATCH_FAIL_EXTEND_SCORE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 200 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 206 */     String path = dir + "mzm.gsp.qmhw.confbean.SQMHWCfgConsts.bny";
/*     */     try
/*     */     {
/* 209 */       File file = new File(path);
/* 210 */       if (file.exists())
/*     */       {
/* 212 */         byte[] bytes = new byte['Ѐ'];
/* 213 */         FileInputStream fis = new FileInputStream(file);
/* 214 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 215 */         int len = 0;
/* 216 */         while ((len = fis.read(bytes)) > 0)
/* 217 */           baos.write(bytes, 0, len);
/* 218 */         fis.close();
/* 219 */         bytes = baos.toByteArray();
/* 220 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 221 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 222 */         this.NPC_ID = _os_.unmarshal_int();
/* 223 */         this.START_CONTROL_ID = _os_.unmarshal_int();
/* 224 */         this.LAST_MATH_TO_END_MIN = _os_.unmarshal_int();
/* 225 */         this.COMMON_AWARD_ID = _os_.unmarshal_int();
/* 226 */         this.COMMON_AWARD_INTERVAL_MIN = _os_.unmarshal_int();
/* 227 */         this.MATCH_INTERVAL_SEC = _os_.unmarshal_int();
/* 228 */         this.PREPARE_TIME_MIN = _os_.unmarshal_int();
/* 229 */         this.ACTIVITY_MAP_ID = _os_.unmarshal_int();
/* 230 */         this.OUT_MAP_ID = _os_.unmarshal_int();
/* 231 */         this.FIRST_WIN_AWARDID = _os_.unmarshal_int();
/* 232 */         this.FIGHT_COUNT = _os_.unmarshal_int();
/* 233 */         this.FIGHT_COUNT_AWARDID = _os_.unmarshal_int();
/* 234 */         this.WIN_AWARDID = _os_.unmarshal_int();
/* 235 */         this.LOSE_AWARDID = _os_.unmarshal_int();
/* 236 */         this.INI_SCORE = _os_.unmarshal_int();
/* 237 */         this.K = _os_.unmarshal_int();
/* 238 */         this.CONTINU_WIN_COUNT = _os_.unmarshal_int();
/* 239 */         this.NOTIFY_MAIL_ID = _os_.unmarshal_int();
/* 240 */         this.MATCH_SCORE_INTERVAL = _os_.unmarshal_int();
/* 241 */         this.MATCH_FAIL_EXTEND_SCORE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SQMHWCfgConsts newInstance)
/*     */   {
/* 252 */     oldInstance = instance;
/* 253 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 258 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\confbean\SQMHWCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */