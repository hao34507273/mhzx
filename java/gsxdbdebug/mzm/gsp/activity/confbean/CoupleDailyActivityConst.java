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
/*     */ public class CoupleDailyActivityConst
/*     */ {
/*  13 */   private static volatile CoupleDailyActivityConst oldInstance = null;
/*     */   
/*  15 */   private static CoupleDailyActivityConst instance = new CoupleDailyActivityConst();
/*     */   public int COUPLE_DAILY_ACTIVITY_ID;
/*     */   public int NPC_ID;
/*     */   public int NPC_SERVER_ID;
/*     */   public int QUESTION_NUM;
/*     */   public int WAIT_COUPLE_ANSWER_TIME;
/*     */   public int WAIT_COUPLE_QUESTION_CONFIRM_TIME;
/*     */   
/*  23 */   public static CoupleDailyActivityConst getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static CoupleDailyActivityConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int WAIT_COUPLE_PINTU_CONFIRM_TIME;
/*     */   
/*     */   public int AWARD_ITEM_ID_1;
/*     */   
/*     */   public int AWARD_ITEM_ID_2;
/*     */   
/*     */   public int AWARD_ITEM_ID_3;
/*     */   
/*     */   public int RANDOM_TASK_NUM;
/*     */   
/*     */   public int FINISH_ALL_TASK_AWARD_ID;
/*     */   
/*     */   public int ANSWER_QUESTION_INTERVAL;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  47 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  52 */     String path = dir + "mzm.gsp.activity.confbean.CoupleDailyActivityConst.xml";
/*     */     try
/*     */     {
/*  55 */       SAXReader reader = new SAXReader();
/*  56 */       org.dom4j.Document doc = reader.read(new File(path));
/*  57 */       Element root = doc.getRootElement();
/*  58 */       Map<String, Element> data = new java.util.HashMap();
/*  59 */       java.util.List<?> nodeList = root.elements();
/*  60 */       int len = nodeList.size();
/*  61 */       for (int i = 0; i < len; i++)
/*     */       {
/*  63 */         Element element = (Element)nodeList.get(i);
/*  64 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  67 */           String name = element.attributeValue("name");
/*  68 */           if (data.put(name, element) != null)
/*  69 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  72 */       this.COUPLE_DAILY_ACTIVITY_ID = Integer.valueOf(((Element)data.get("COUPLE_DAILY_ACTIVITY_ID")).attributeValue("value")).intValue();
/*  73 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  74 */       this.NPC_SERVER_ID = Integer.valueOf(((Element)data.get("NPC_SERVER_ID")).attributeValue("value")).intValue();
/*  75 */       this.QUESTION_NUM = Integer.valueOf(((Element)data.get("QUESTION_NUM")).attributeValue("value")).intValue();
/*  76 */       this.WAIT_COUPLE_ANSWER_TIME = Integer.valueOf(((Element)data.get("WAIT_COUPLE_ANSWER_TIME")).attributeValue("value")).intValue();
/*  77 */       this.WAIT_COUPLE_QUESTION_CONFIRM_TIME = Integer.valueOf(((Element)data.get("WAIT_COUPLE_QUESTION_CONFIRM_TIME")).attributeValue("value")).intValue();
/*  78 */       this.WAIT_COUPLE_PINTU_CONFIRM_TIME = Integer.valueOf(((Element)data.get("WAIT_COUPLE_PINTU_CONFIRM_TIME")).attributeValue("value")).intValue();
/*  79 */       this.AWARD_ITEM_ID_1 = Integer.valueOf(((Element)data.get("AWARD_ITEM_ID_1")).attributeValue("value")).intValue();
/*  80 */       this.AWARD_ITEM_ID_2 = Integer.valueOf(((Element)data.get("AWARD_ITEM_ID_2")).attributeValue("value")).intValue();
/*  81 */       this.AWARD_ITEM_ID_3 = Integer.valueOf(((Element)data.get("AWARD_ITEM_ID_3")).attributeValue("value")).intValue();
/*  82 */       this.RANDOM_TASK_NUM = Integer.valueOf(((Element)data.get("RANDOM_TASK_NUM")).attributeValue("value")).intValue();
/*  83 */       this.FINISH_ALL_TASK_AWARD_ID = Integer.valueOf(((Element)data.get("FINISH_ALL_TASK_AWARD_ID")).attributeValue("value")).intValue();
/*  84 */       this.ANSWER_QUESTION_INTERVAL = Integer.valueOf(((Element)data.get("ANSWER_QUESTION_INTERVAL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  88 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  93 */     String path = dir + "mzm.gsp.activity.confbean.CoupleDailyActivityConst.xml";
/*     */     try
/*     */     {
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       Map<String, Element> data = new java.util.HashMap();
/* 100 */       java.util.List<?> nodeList = root.elements();
/* 101 */       int len = nodeList.size();
/* 102 */       for (int i = 0; i < len; i++)
/*     */       {
/* 104 */         Element element = (Element)nodeList.get(i);
/* 105 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 108 */           String name = element.attributeValue("name");
/* 109 */           if (data.put(name, element) != null)
/* 110 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 113 */       this.COUPLE_DAILY_ACTIVITY_ID = Integer.valueOf(((Element)data.get("COUPLE_DAILY_ACTIVITY_ID")).attributeValue("value")).intValue();
/* 114 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 115 */       this.NPC_SERVER_ID = Integer.valueOf(((Element)data.get("NPC_SERVER_ID")).attributeValue("value")).intValue();
/* 116 */       this.QUESTION_NUM = Integer.valueOf(((Element)data.get("QUESTION_NUM")).attributeValue("value")).intValue();
/* 117 */       this.WAIT_COUPLE_ANSWER_TIME = Integer.valueOf(((Element)data.get("WAIT_COUPLE_ANSWER_TIME")).attributeValue("value")).intValue();
/* 118 */       this.WAIT_COUPLE_QUESTION_CONFIRM_TIME = Integer.valueOf(((Element)data.get("WAIT_COUPLE_QUESTION_CONFIRM_TIME")).attributeValue("value")).intValue();
/* 119 */       this.WAIT_COUPLE_PINTU_CONFIRM_TIME = Integer.valueOf(((Element)data.get("WAIT_COUPLE_PINTU_CONFIRM_TIME")).attributeValue("value")).intValue();
/* 120 */       this.AWARD_ITEM_ID_1 = Integer.valueOf(((Element)data.get("AWARD_ITEM_ID_1")).attributeValue("value")).intValue();
/* 121 */       this.AWARD_ITEM_ID_2 = Integer.valueOf(((Element)data.get("AWARD_ITEM_ID_2")).attributeValue("value")).intValue();
/* 122 */       this.AWARD_ITEM_ID_3 = Integer.valueOf(((Element)data.get("AWARD_ITEM_ID_3")).attributeValue("value")).intValue();
/* 123 */       this.RANDOM_TASK_NUM = Integer.valueOf(((Element)data.get("RANDOM_TASK_NUM")).attributeValue("value")).intValue();
/* 124 */       this.FINISH_ALL_TASK_AWARD_ID = Integer.valueOf(((Element)data.get("FINISH_ALL_TASK_AWARD_ID")).attributeValue("value")).intValue();
/* 125 */       this.ANSWER_QUESTION_INTERVAL = Integer.valueOf(((Element)data.get("ANSWER_QUESTION_INTERVAL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 129 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 133 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 136 */     String path = dir + "mzm.gsp.activity.confbean.CoupleDailyActivityConst.bny";
/*     */     try
/*     */     {
/* 139 */       File file = new File(path);
/* 140 */       if (file.exists())
/*     */       {
/* 142 */         byte[] bytes = new byte['Ѐ'];
/* 143 */         FileInputStream fis = new FileInputStream(file);
/* 144 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 145 */         int len = 0;
/* 146 */         while ((len = fis.read(bytes)) > 0)
/* 147 */           baos.write(bytes, 0, len);
/* 148 */         fis.close();
/* 149 */         bytes = baos.toByteArray();
/* 150 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 151 */         this.COUPLE_DAILY_ACTIVITY_ID = _os_.unmarshal_int();
/* 152 */         this.NPC_ID = _os_.unmarshal_int();
/* 153 */         this.NPC_SERVER_ID = _os_.unmarshal_int();
/* 154 */         this.QUESTION_NUM = _os_.unmarshal_int();
/* 155 */         this.WAIT_COUPLE_ANSWER_TIME = _os_.unmarshal_int();
/* 156 */         this.WAIT_COUPLE_QUESTION_CONFIRM_TIME = _os_.unmarshal_int();
/* 157 */         this.WAIT_COUPLE_PINTU_CONFIRM_TIME = _os_.unmarshal_int();
/* 158 */         this.AWARD_ITEM_ID_1 = _os_.unmarshal_int();
/* 159 */         this.AWARD_ITEM_ID_2 = _os_.unmarshal_int();
/* 160 */         this.AWARD_ITEM_ID_3 = _os_.unmarshal_int();
/* 161 */         this.RANDOM_TASK_NUM = _os_.unmarshal_int();
/* 162 */         this.FINISH_ALL_TASK_AWARD_ID = _os_.unmarshal_int();
/* 163 */         this.ANSWER_QUESTION_INTERVAL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 168 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 174 */     String path = dir + "mzm.gsp.activity.confbean.CoupleDailyActivityConst.bny";
/*     */     try
/*     */     {
/* 177 */       File file = new File(path);
/* 178 */       if (file.exists())
/*     */       {
/* 180 */         byte[] bytes = new byte['Ѐ'];
/* 181 */         FileInputStream fis = new FileInputStream(file);
/* 182 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 183 */         int len = 0;
/* 184 */         while ((len = fis.read(bytes)) > 0)
/* 185 */           baos.write(bytes, 0, len);
/* 186 */         fis.close();
/* 187 */         bytes = baos.toByteArray();
/* 188 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 189 */         this.COUPLE_DAILY_ACTIVITY_ID = _os_.unmarshal_int();
/* 190 */         this.NPC_ID = _os_.unmarshal_int();
/* 191 */         this.NPC_SERVER_ID = _os_.unmarshal_int();
/* 192 */         this.QUESTION_NUM = _os_.unmarshal_int();
/* 193 */         this.WAIT_COUPLE_ANSWER_TIME = _os_.unmarshal_int();
/* 194 */         this.WAIT_COUPLE_QUESTION_CONFIRM_TIME = _os_.unmarshal_int();
/* 195 */         this.WAIT_COUPLE_PINTU_CONFIRM_TIME = _os_.unmarshal_int();
/* 196 */         this.AWARD_ITEM_ID_1 = _os_.unmarshal_int();
/* 197 */         this.AWARD_ITEM_ID_2 = _os_.unmarshal_int();
/* 198 */         this.AWARD_ITEM_ID_3 = _os_.unmarshal_int();
/* 199 */         this.RANDOM_TASK_NUM = _os_.unmarshal_int();
/* 200 */         this.FINISH_ALL_TASK_AWARD_ID = _os_.unmarshal_int();
/* 201 */         this.ANSWER_QUESTION_INTERVAL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 206 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(CoupleDailyActivityConst newInstance)
/*     */   {
/* 212 */     oldInstance = instance;
/* 213 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 218 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\CoupleDailyActivityConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */