/*     */ package mzm.gsp.qingfu.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SQingfuCfgConsts
/*     */ {
/*  13 */   private static volatile SQingfuCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SQingfuCfgConsts instance = new SQingfuCfgConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SQingfuCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SQingfuCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int FIRST_RECHARGE_AWARD_ID = 4406;
/*  32 */   public int LEVEL_GROWTH_FUND_ENABLE_NEED_ROLE_LEVEL = 25;
/*  33 */   public int FIRST_RECHARGE_MAIL_ID = 340000000;
/*  34 */   public int FIRST_RECHARGE_MAIL_LEVEL = 13;
/*  35 */   public int RECHARGE_TIMES_MAIL_ID = 340000000;
/*  36 */   public int RECHARGE_TIMES_MAIL_LEVEL = 30;
/*  37 */   public int RECENT_SAVE_AMT_RECORD_DAYS = 30;
/*  38 */   public int SAVE_AMT_ACTIVITY_CFG_ID = 0;
/*  39 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_1 = 0;
/*  40 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_2 = 0;
/*  41 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_3 = 0;
/*  42 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_4 = 0;
/*  43 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_5 = 0;
/*  44 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_6 = 0;
/*  45 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_7 = 0;
/*  46 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_8 = 0;
/*  47 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_9 = 0;
/*  48 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_10 = 0;
/*  49 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_11 = 0;
/*  50 */   public int TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_12 = 0;
/*  51 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_1 = 0;
/*  52 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_2 = 0;
/*  53 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_3 = 0;
/*  54 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_4 = 0;
/*  55 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_5 = 0;
/*  56 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_6 = 0;
/*  57 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_7 = 0;
/*  58 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_8 = 0;
/*  59 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_9 = 0;
/*  60 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_10 = 0;
/*  61 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_11 = 0;
/*  62 */   public int TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_12 = 0;
/*  63 */   public int RECHARGE_TIMES_ACTIVITY_CFG_ID = 0;
/*  64 */   public int RMB_GIFT_BAG_ACTIVITY_CFG_ID = 0;
/*  65 */   public int LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID1 = 0;
/*  66 */   public int LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID2 = 0;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  70 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  75 */     String path = dir + "mzm.gsp.qingfu.confbean.SQingfuCfgConsts.xml";
/*     */     try
/*     */     {
/*  78 */       SAXReader reader = new SAXReader();
/*  79 */       org.dom4j.Document doc = reader.read(new File(path));
/*  80 */       Element root = doc.getRootElement();
/*  81 */       Map<String, Element> data = new java.util.HashMap();
/*  82 */       java.util.List<?> nodeList = root.elements();
/*  83 */       int len = nodeList.size();
/*  84 */       for (int i = 0; i < len; i++)
/*     */       {
/*  86 */         Element element = (Element)nodeList.get(i);
/*  87 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  90 */           String name = element.attributeValue("name");
/*  91 */           if (data.put(name, element) != null)
/*  92 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  95 */       this.FIRST_RECHARGE_AWARD_ID = Integer.valueOf(((Element)data.get("FIRST_RECHARGE_AWARD_ID")).attributeValue("value")).intValue();
/*  96 */       this.LEVEL_GROWTH_FUND_ENABLE_NEED_ROLE_LEVEL = Integer.valueOf(((Element)data.get("LEVEL_GROWTH_FUND_ENABLE_NEED_ROLE_LEVEL")).attributeValue("value")).intValue();
/*  97 */       this.FIRST_RECHARGE_MAIL_ID = Integer.valueOf(((Element)data.get("FIRST_RECHARGE_MAIL_ID")).attributeValue("value")).intValue();
/*  98 */       this.FIRST_RECHARGE_MAIL_LEVEL = Integer.valueOf(((Element)data.get("FIRST_RECHARGE_MAIL_LEVEL")).attributeValue("value")).intValue();
/*  99 */       this.RECHARGE_TIMES_MAIL_ID = Integer.valueOf(((Element)data.get("RECHARGE_TIMES_MAIL_ID")).attributeValue("value")).intValue();
/* 100 */       this.RECHARGE_TIMES_MAIL_LEVEL = Integer.valueOf(((Element)data.get("RECHARGE_TIMES_MAIL_LEVEL")).attributeValue("value")).intValue();
/* 101 */       this.RECENT_SAVE_AMT_RECORD_DAYS = Integer.valueOf(((Element)data.get("RECENT_SAVE_AMT_RECORD_DAYS")).attributeValue("value")).intValue();
/* 102 */       this.SAVE_AMT_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("SAVE_AMT_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 103 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_1 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_1")).attributeValue("value")).intValue();
/* 104 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_2 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_2")).attributeValue("value")).intValue();
/* 105 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_3 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_3")).attributeValue("value")).intValue();
/* 106 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_4 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_4")).attributeValue("value")).intValue();
/* 107 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_5 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_5")).attributeValue("value")).intValue();
/* 108 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_6 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_6")).attributeValue("value")).intValue();
/* 109 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_7 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_7")).attributeValue("value")).intValue();
/* 110 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_8 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_8")).attributeValue("value")).intValue();
/* 111 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_9 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_9")).attributeValue("value")).intValue();
/* 112 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_10 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_10")).attributeValue("value")).intValue();
/* 113 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_11 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_11")).attributeValue("value")).intValue();
/* 114 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_12 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_12")).attributeValue("value")).intValue();
/* 115 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_1 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_1")).attributeValue("value")).intValue();
/* 116 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_2 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_2")).attributeValue("value")).intValue();
/* 117 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_3 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_3")).attributeValue("value")).intValue();
/* 118 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_4 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_4")).attributeValue("value")).intValue();
/* 119 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_5 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_5")).attributeValue("value")).intValue();
/* 120 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_6 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_6")).attributeValue("value")).intValue();
/* 121 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_7 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_7")).attributeValue("value")).intValue();
/* 122 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_8 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_8")).attributeValue("value")).intValue();
/* 123 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_9 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_9")).attributeValue("value")).intValue();
/* 124 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_10 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_10")).attributeValue("value")).intValue();
/* 125 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_11 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_11")).attributeValue("value")).intValue();
/* 126 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_12 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_12")).attributeValue("value")).intValue();
/* 127 */       this.RECHARGE_TIMES_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("RECHARGE_TIMES_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 128 */       this.RMB_GIFT_BAG_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("RMB_GIFT_BAG_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 129 */       this.LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID1 = Integer.valueOf(((Element)data.get("LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID1")).attributeValue("value")).intValue();
/* 130 */       this.LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID2 = Integer.valueOf(((Element)data.get("LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID2")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 134 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 139 */     String path = dir + "mzm.gsp.qingfu.confbean.SQingfuCfgConsts.xml";
/*     */     try
/*     */     {
/* 142 */       SAXReader reader = new SAXReader();
/* 143 */       org.dom4j.Document doc = reader.read(new File(path));
/* 144 */       Element root = doc.getRootElement();
/* 145 */       Map<String, Element> data = new java.util.HashMap();
/* 146 */       java.util.List<?> nodeList = root.elements();
/* 147 */       int len = nodeList.size();
/* 148 */       for (int i = 0; i < len; i++)
/*     */       {
/* 150 */         Element element = (Element)nodeList.get(i);
/* 151 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 154 */           String name = element.attributeValue("name");
/* 155 */           if (data.put(name, element) != null)
/* 156 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 159 */       this.FIRST_RECHARGE_AWARD_ID = Integer.valueOf(((Element)data.get("FIRST_RECHARGE_AWARD_ID")).attributeValue("value")).intValue();
/* 160 */       this.LEVEL_GROWTH_FUND_ENABLE_NEED_ROLE_LEVEL = Integer.valueOf(((Element)data.get("LEVEL_GROWTH_FUND_ENABLE_NEED_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 161 */       this.FIRST_RECHARGE_MAIL_ID = Integer.valueOf(((Element)data.get("FIRST_RECHARGE_MAIL_ID")).attributeValue("value")).intValue();
/* 162 */       this.FIRST_RECHARGE_MAIL_LEVEL = Integer.valueOf(((Element)data.get("FIRST_RECHARGE_MAIL_LEVEL")).attributeValue("value")).intValue();
/* 163 */       this.RECHARGE_TIMES_MAIL_ID = Integer.valueOf(((Element)data.get("RECHARGE_TIMES_MAIL_ID")).attributeValue("value")).intValue();
/* 164 */       this.RECHARGE_TIMES_MAIL_LEVEL = Integer.valueOf(((Element)data.get("RECHARGE_TIMES_MAIL_LEVEL")).attributeValue("value")).intValue();
/* 165 */       this.RECENT_SAVE_AMT_RECORD_DAYS = Integer.valueOf(((Element)data.get("RECENT_SAVE_AMT_RECORD_DAYS")).attributeValue("value")).intValue();
/* 166 */       this.SAVE_AMT_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("SAVE_AMT_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 167 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_1 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_1")).attributeValue("value")).intValue();
/* 168 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_2 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_2")).attributeValue("value")).intValue();
/* 169 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_3 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_3")).attributeValue("value")).intValue();
/* 170 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_4 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_4")).attributeValue("value")).intValue();
/* 171 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_5 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_5")).attributeValue("value")).intValue();
/* 172 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_6 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_6")).attributeValue("value")).intValue();
/* 173 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_7 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_7")).attributeValue("value")).intValue();
/* 174 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_8 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_8")).attributeValue("value")).intValue();
/* 175 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_9 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_9")).attributeValue("value")).intValue();
/* 176 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_10 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_10")).attributeValue("value")).intValue();
/* 177 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_11 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_11")).attributeValue("value")).intValue();
/* 178 */       this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_12 = Integer.valueOf(((Element)data.get("TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_12")).attributeValue("value")).intValue();
/* 179 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_1 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_1")).attributeValue("value")).intValue();
/* 180 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_2 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_2")).attributeValue("value")).intValue();
/* 181 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_3 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_3")).attributeValue("value")).intValue();
/* 182 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_4 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_4")).attributeValue("value")).intValue();
/* 183 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_5 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_5")).attributeValue("value")).intValue();
/* 184 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_6 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_6")).attributeValue("value")).intValue();
/* 185 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_7 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_7")).attributeValue("value")).intValue();
/* 186 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_8 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_8")).attributeValue("value")).intValue();
/* 187 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_9 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_9")).attributeValue("value")).intValue();
/* 188 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_10 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_10")).attributeValue("value")).intValue();
/* 189 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_11 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_11")).attributeValue("value")).intValue();
/* 190 */       this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_12 = Integer.valueOf(((Element)data.get("TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_12")).attributeValue("value")).intValue();
/* 191 */       this.RECHARGE_TIMES_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("RECHARGE_TIMES_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 192 */       this.RMB_GIFT_BAG_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("RMB_GIFT_BAG_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 193 */       this.LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID1 = Integer.valueOf(((Element)data.get("LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID1")).attributeValue("value")).intValue();
/* 194 */       this.LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID2 = Integer.valueOf(((Element)data.get("LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID2")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 198 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 202 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 205 */     String path = dir + "mzm.gsp.qingfu.confbean.SQingfuCfgConsts.bny";
/*     */     try
/*     */     {
/* 208 */       File file = new File(path);
/* 209 */       if (file.exists())
/*     */       {
/* 211 */         byte[] bytes = new byte['Ѐ'];
/* 212 */         FileInputStream fis = new FileInputStream(file);
/* 213 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 214 */         int len = 0;
/* 215 */         while ((len = fis.read(bytes)) > 0)
/* 216 */           baos.write(bytes, 0, len);
/* 217 */         fis.close();
/* 218 */         bytes = baos.toByteArray();
/* 219 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 220 */         this.FIRST_RECHARGE_AWARD_ID = _os_.unmarshal_int();
/* 221 */         this.LEVEL_GROWTH_FUND_ENABLE_NEED_ROLE_LEVEL = _os_.unmarshal_int();
/* 222 */         this.FIRST_RECHARGE_MAIL_ID = _os_.unmarshal_int();
/* 223 */         this.FIRST_RECHARGE_MAIL_LEVEL = _os_.unmarshal_int();
/* 224 */         this.RECHARGE_TIMES_MAIL_ID = _os_.unmarshal_int();
/* 225 */         this.RECHARGE_TIMES_MAIL_LEVEL = _os_.unmarshal_int();
/* 226 */         this.RECENT_SAVE_AMT_RECORD_DAYS = _os_.unmarshal_int();
/* 227 */         this.SAVE_AMT_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 228 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_1 = _os_.unmarshal_int();
/* 229 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_2 = _os_.unmarshal_int();
/* 230 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_3 = _os_.unmarshal_int();
/* 231 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_4 = _os_.unmarshal_int();
/* 232 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_5 = _os_.unmarshal_int();
/* 233 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_6 = _os_.unmarshal_int();
/* 234 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_7 = _os_.unmarshal_int();
/* 235 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_8 = _os_.unmarshal_int();
/* 236 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_9 = _os_.unmarshal_int();
/* 237 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_10 = _os_.unmarshal_int();
/* 238 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_11 = _os_.unmarshal_int();
/* 239 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_12 = _os_.unmarshal_int();
/* 240 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_1 = _os_.unmarshal_int();
/* 241 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_2 = _os_.unmarshal_int();
/* 242 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_3 = _os_.unmarshal_int();
/* 243 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_4 = _os_.unmarshal_int();
/* 244 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_5 = _os_.unmarshal_int();
/* 245 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_6 = _os_.unmarshal_int();
/* 246 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_7 = _os_.unmarshal_int();
/* 247 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_8 = _os_.unmarshal_int();
/* 248 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_9 = _os_.unmarshal_int();
/* 249 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_10 = _os_.unmarshal_int();
/* 250 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_11 = _os_.unmarshal_int();
/* 251 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_12 = _os_.unmarshal_int();
/* 252 */         this.RECHARGE_TIMES_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 253 */         this.RMB_GIFT_BAG_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 254 */         this.LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID1 = _os_.unmarshal_int();
/* 255 */         this.LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID2 = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 260 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 266 */     String path = dir + "mzm.gsp.qingfu.confbean.SQingfuCfgConsts.bny";
/*     */     try
/*     */     {
/* 269 */       File file = new File(path);
/* 270 */       if (file.exists())
/*     */       {
/* 272 */         byte[] bytes = new byte['Ѐ'];
/* 273 */         FileInputStream fis = new FileInputStream(file);
/* 274 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 275 */         int len = 0;
/* 276 */         while ((len = fis.read(bytes)) > 0)
/* 277 */           baos.write(bytes, 0, len);
/* 278 */         fis.close();
/* 279 */         bytes = baos.toByteArray();
/* 280 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 281 */         this.FIRST_RECHARGE_AWARD_ID = _os_.unmarshal_int();
/* 282 */         this.LEVEL_GROWTH_FUND_ENABLE_NEED_ROLE_LEVEL = _os_.unmarshal_int();
/* 283 */         this.FIRST_RECHARGE_MAIL_ID = _os_.unmarshal_int();
/* 284 */         this.FIRST_RECHARGE_MAIL_LEVEL = _os_.unmarshal_int();
/* 285 */         this.RECHARGE_TIMES_MAIL_ID = _os_.unmarshal_int();
/* 286 */         this.RECHARGE_TIMES_MAIL_LEVEL = _os_.unmarshal_int();
/* 287 */         this.RECENT_SAVE_AMT_RECORD_DAYS = _os_.unmarshal_int();
/* 288 */         this.SAVE_AMT_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 289 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_1 = _os_.unmarshal_int();
/* 290 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_2 = _os_.unmarshal_int();
/* 291 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_3 = _os_.unmarshal_int();
/* 292 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_4 = _os_.unmarshal_int();
/* 293 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_5 = _os_.unmarshal_int();
/* 294 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_6 = _os_.unmarshal_int();
/* 295 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_7 = _os_.unmarshal_int();
/* 296 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_8 = _os_.unmarshal_int();
/* 297 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_9 = _os_.unmarshal_int();
/* 298 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_10 = _os_.unmarshal_int();
/* 299 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_11 = _os_.unmarshal_int();
/* 300 */         this.TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_12 = _os_.unmarshal_int();
/* 301 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_1 = _os_.unmarshal_int();
/* 302 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_2 = _os_.unmarshal_int();
/* 303 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_3 = _os_.unmarshal_int();
/* 304 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_4 = _os_.unmarshal_int();
/* 305 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_5 = _os_.unmarshal_int();
/* 306 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_6 = _os_.unmarshal_int();
/* 307 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_7 = _os_.unmarshal_int();
/* 308 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_8 = _os_.unmarshal_int();
/* 309 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_9 = _os_.unmarshal_int();
/* 310 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_10 = _os_.unmarshal_int();
/* 311 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_11 = _os_.unmarshal_int();
/* 312 */         this.TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_12 = _os_.unmarshal_int();
/* 313 */         this.RECHARGE_TIMES_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 314 */         this.RMB_GIFT_BAG_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 315 */         this.LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID1 = _os_.unmarshal_int();
/* 316 */         this.LEVEL_GROWTH_FUN_ACTIVITY_CFG_ID2 = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 321 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SQingfuCfgConsts newInstance)
/*     */   {
/* 327 */     oldInstance = instance;
/* 328 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 333 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\confbean\SQingfuCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */