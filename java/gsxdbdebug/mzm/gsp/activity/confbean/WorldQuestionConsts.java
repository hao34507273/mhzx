/*     */ package mzm.gsp.activity.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class WorldQuestionConsts
/*     */ {
/*  13 */   private static volatile WorldQuestionConsts oldInstance = null;
/*     */   
/*  15 */   private static WorldQuestionConsts instance = new WorldQuestionConsts();
/*     */   public int ACTIVITYID;
/*     */   public int RAN_TIME_HIGH;
/*     */   public int RAN_TIME_LOW;
/*     */   public int NOTIC_QUESTION_INTERVAL;
/*     */   public int ANSWER_TIME;
/*     */   
/*     */   public static WorldQuestionConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static WorldQuestionConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int NORMAL_AWARD_ID;
/*     */   
/*     */   public int NORMAL_AWARD_ROLE_NUM;
/*     */   
/*     */   public int NB_AWARD_ID;
/*     */   
/*     */   public int NB_AWARD_ROLE_NUM;
/*     */   
/*     */   public int MASTER_PIC_ID;
/*     */   
/*     */   public int BULLETIN_TIME_BEF_QU;
/*     */   public int BULLETIN_TIME_AFT_RS;
/*     */   public int MINI_TILE_COLOR_CFG;
/*     */   public int MINI_QUSTION_COLOR_CFG;
/*     */   public int BIG_TITLE_COLOR_CFG;
/*     */   public int BIG_QUESTION_COLOR_CFG;
/*     */   public int BULLETIN_COLOR_CFG;
/*     */   public int ON_TOP_TIME;
/*     */   public int TURN_DOWN__TIME;
/*     */   public int RANDOM_AWARD_GUY_NUM;
/*     */   public int NB_AWARD_MAX_PER_DAY;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  55 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  60 */     String path = dir + "mzm.gsp.activity.confbean.WorldQuestionConsts.xml";
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
/*  80 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  81 */       this.RAN_TIME_HIGH = Integer.valueOf(((Element)data.get("RAN_TIME_HIGH")).attributeValue("value")).intValue();
/*  82 */       this.RAN_TIME_LOW = Integer.valueOf(((Element)data.get("RAN_TIME_LOW")).attributeValue("value")).intValue();
/*  83 */       this.NOTIC_QUESTION_INTERVAL = Integer.valueOf(((Element)data.get("NOTIC_QUESTION_INTERVAL")).attributeValue("value")).intValue();
/*  84 */       this.ANSWER_TIME = Integer.valueOf(((Element)data.get("ANSWER_TIME")).attributeValue("value")).intValue();
/*  85 */       this.NORMAL_AWARD_ID = Integer.valueOf(((Element)data.get("NORMAL_AWARD_ID")).attributeValue("value")).intValue();
/*  86 */       this.NORMAL_AWARD_ROLE_NUM = Integer.valueOf(((Element)data.get("NORMAL_AWARD_ROLE_NUM")).attributeValue("value")).intValue();
/*  87 */       this.NB_AWARD_ID = Integer.valueOf(((Element)data.get("NB_AWARD_ID")).attributeValue("value")).intValue();
/*  88 */       this.NB_AWARD_ROLE_NUM = Integer.valueOf(((Element)data.get("NB_AWARD_ROLE_NUM")).attributeValue("value")).intValue();
/*  89 */       this.MASTER_PIC_ID = Integer.valueOf(((Element)data.get("MASTER_PIC_ID")).attributeValue("value")).intValue();
/*  90 */       this.BULLETIN_TIME_BEF_QU = Integer.valueOf(((Element)data.get("BULLETIN_TIME_BEF_QU")).attributeValue("value")).intValue();
/*  91 */       this.BULLETIN_TIME_AFT_RS = Integer.valueOf(((Element)data.get("BULLETIN_TIME_AFT_RS")).attributeValue("value")).intValue();
/*  92 */       this.MINI_TILE_COLOR_CFG = Integer.valueOf(((Element)data.get("MINI_TILE_COLOR_CFG")).attributeValue("value")).intValue();
/*  93 */       this.MINI_QUSTION_COLOR_CFG = Integer.valueOf(((Element)data.get("MINI_QUSTION_COLOR_CFG")).attributeValue("value")).intValue();
/*  94 */       this.BIG_TITLE_COLOR_CFG = Integer.valueOf(((Element)data.get("BIG_TITLE_COLOR_CFG")).attributeValue("value")).intValue();
/*  95 */       this.BIG_QUESTION_COLOR_CFG = Integer.valueOf(((Element)data.get("BIG_QUESTION_COLOR_CFG")).attributeValue("value")).intValue();
/*  96 */       this.BULLETIN_COLOR_CFG = Integer.valueOf(((Element)data.get("BULLETIN_COLOR_CFG")).attributeValue("value")).intValue();
/*  97 */       this.ON_TOP_TIME = Integer.valueOf(((Element)data.get("ON_TOP_TIME")).attributeValue("value")).intValue();
/*  98 */       this.TURN_DOWN__TIME = Integer.valueOf(((Element)data.get("TURN_DOWN__TIME")).attributeValue("value")).intValue();
/*  99 */       this.RANDOM_AWARD_GUY_NUM = Integer.valueOf(((Element)data.get("RANDOM_AWARD_GUY_NUM")).attributeValue("value")).intValue();
/* 100 */       this.NB_AWARD_MAX_PER_DAY = Integer.valueOf(((Element)data.get("NB_AWARD_MAX_PER_DAY")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 109 */     String path = dir + "mzm.gsp.activity.confbean.WorldQuestionConsts.xml";
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
/* 129 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 130 */       this.RAN_TIME_HIGH = Integer.valueOf(((Element)data.get("RAN_TIME_HIGH")).attributeValue("value")).intValue();
/* 131 */       this.RAN_TIME_LOW = Integer.valueOf(((Element)data.get("RAN_TIME_LOW")).attributeValue("value")).intValue();
/* 132 */       this.NOTIC_QUESTION_INTERVAL = Integer.valueOf(((Element)data.get("NOTIC_QUESTION_INTERVAL")).attributeValue("value")).intValue();
/* 133 */       this.ANSWER_TIME = Integer.valueOf(((Element)data.get("ANSWER_TIME")).attributeValue("value")).intValue();
/* 134 */       this.NORMAL_AWARD_ID = Integer.valueOf(((Element)data.get("NORMAL_AWARD_ID")).attributeValue("value")).intValue();
/* 135 */       this.NORMAL_AWARD_ROLE_NUM = Integer.valueOf(((Element)data.get("NORMAL_AWARD_ROLE_NUM")).attributeValue("value")).intValue();
/* 136 */       this.NB_AWARD_ID = Integer.valueOf(((Element)data.get("NB_AWARD_ID")).attributeValue("value")).intValue();
/* 137 */       this.NB_AWARD_ROLE_NUM = Integer.valueOf(((Element)data.get("NB_AWARD_ROLE_NUM")).attributeValue("value")).intValue();
/* 138 */       this.MASTER_PIC_ID = Integer.valueOf(((Element)data.get("MASTER_PIC_ID")).attributeValue("value")).intValue();
/* 139 */       this.BULLETIN_TIME_BEF_QU = Integer.valueOf(((Element)data.get("BULLETIN_TIME_BEF_QU")).attributeValue("value")).intValue();
/* 140 */       this.BULLETIN_TIME_AFT_RS = Integer.valueOf(((Element)data.get("BULLETIN_TIME_AFT_RS")).attributeValue("value")).intValue();
/* 141 */       this.MINI_TILE_COLOR_CFG = Integer.valueOf(((Element)data.get("MINI_TILE_COLOR_CFG")).attributeValue("value")).intValue();
/* 142 */       this.MINI_QUSTION_COLOR_CFG = Integer.valueOf(((Element)data.get("MINI_QUSTION_COLOR_CFG")).attributeValue("value")).intValue();
/* 143 */       this.BIG_TITLE_COLOR_CFG = Integer.valueOf(((Element)data.get("BIG_TITLE_COLOR_CFG")).attributeValue("value")).intValue();
/* 144 */       this.BIG_QUESTION_COLOR_CFG = Integer.valueOf(((Element)data.get("BIG_QUESTION_COLOR_CFG")).attributeValue("value")).intValue();
/* 145 */       this.BULLETIN_COLOR_CFG = Integer.valueOf(((Element)data.get("BULLETIN_COLOR_CFG")).attributeValue("value")).intValue();
/* 146 */       this.ON_TOP_TIME = Integer.valueOf(((Element)data.get("ON_TOP_TIME")).attributeValue("value")).intValue();
/* 147 */       this.TURN_DOWN__TIME = Integer.valueOf(((Element)data.get("TURN_DOWN__TIME")).attributeValue("value")).intValue();
/* 148 */       this.RANDOM_AWARD_GUY_NUM = Integer.valueOf(((Element)data.get("RANDOM_AWARD_GUY_NUM")).attributeValue("value")).intValue();
/* 149 */       this.NB_AWARD_MAX_PER_DAY = Integer.valueOf(((Element)data.get("NB_AWARD_MAX_PER_DAY")).attributeValue("value")).intValue();
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
/* 160 */     String path = dir + "mzm.gsp.activity.confbean.WorldQuestionConsts.bny";
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
/* 175 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 176 */         this.RAN_TIME_HIGH = _os_.unmarshal_int();
/* 177 */         this.RAN_TIME_LOW = _os_.unmarshal_int();
/* 178 */         this.NOTIC_QUESTION_INTERVAL = _os_.unmarshal_int();
/* 179 */         this.ANSWER_TIME = _os_.unmarshal_int();
/* 180 */         this.NORMAL_AWARD_ID = _os_.unmarshal_int();
/* 181 */         this.NORMAL_AWARD_ROLE_NUM = _os_.unmarshal_int();
/* 182 */         this.NB_AWARD_ID = _os_.unmarshal_int();
/* 183 */         this.NB_AWARD_ROLE_NUM = _os_.unmarshal_int();
/* 184 */         this.MASTER_PIC_ID = _os_.unmarshal_int();
/* 185 */         this.BULLETIN_TIME_BEF_QU = _os_.unmarshal_int();
/* 186 */         this.BULLETIN_TIME_AFT_RS = _os_.unmarshal_int();
/* 187 */         this.MINI_TILE_COLOR_CFG = _os_.unmarshal_int();
/* 188 */         this.MINI_QUSTION_COLOR_CFG = _os_.unmarshal_int();
/* 189 */         this.BIG_TITLE_COLOR_CFG = _os_.unmarshal_int();
/* 190 */         this.BIG_QUESTION_COLOR_CFG = _os_.unmarshal_int();
/* 191 */         this.BULLETIN_COLOR_CFG = _os_.unmarshal_int();
/* 192 */         this.ON_TOP_TIME = _os_.unmarshal_int();
/* 193 */         this.TURN_DOWN__TIME = _os_.unmarshal_int();
/* 194 */         this.RANDOM_AWARD_GUY_NUM = _os_.unmarshal_int();
/* 195 */         this.NB_AWARD_MAX_PER_DAY = _os_.unmarshal_int();
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
/* 206 */     String path = dir + "mzm.gsp.activity.confbean.WorldQuestionConsts.bny";
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
/* 221 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 222 */         this.RAN_TIME_HIGH = _os_.unmarshal_int();
/* 223 */         this.RAN_TIME_LOW = _os_.unmarshal_int();
/* 224 */         this.NOTIC_QUESTION_INTERVAL = _os_.unmarshal_int();
/* 225 */         this.ANSWER_TIME = _os_.unmarshal_int();
/* 226 */         this.NORMAL_AWARD_ID = _os_.unmarshal_int();
/* 227 */         this.NORMAL_AWARD_ROLE_NUM = _os_.unmarshal_int();
/* 228 */         this.NB_AWARD_ID = _os_.unmarshal_int();
/* 229 */         this.NB_AWARD_ROLE_NUM = _os_.unmarshal_int();
/* 230 */         this.MASTER_PIC_ID = _os_.unmarshal_int();
/* 231 */         this.BULLETIN_TIME_BEF_QU = _os_.unmarshal_int();
/* 232 */         this.BULLETIN_TIME_AFT_RS = _os_.unmarshal_int();
/* 233 */         this.MINI_TILE_COLOR_CFG = _os_.unmarshal_int();
/* 234 */         this.MINI_QUSTION_COLOR_CFG = _os_.unmarshal_int();
/* 235 */         this.BIG_TITLE_COLOR_CFG = _os_.unmarshal_int();
/* 236 */         this.BIG_QUESTION_COLOR_CFG = _os_.unmarshal_int();
/* 237 */         this.BULLETIN_COLOR_CFG = _os_.unmarshal_int();
/* 238 */         this.ON_TOP_TIME = _os_.unmarshal_int();
/* 239 */         this.TURN_DOWN__TIME = _os_.unmarshal_int();
/* 240 */         this.RANDOM_AWARD_GUY_NUM = _os_.unmarshal_int();
/* 241 */         this.NB_AWARD_MAX_PER_DAY = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(WorldQuestionConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\WorldQuestionConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */