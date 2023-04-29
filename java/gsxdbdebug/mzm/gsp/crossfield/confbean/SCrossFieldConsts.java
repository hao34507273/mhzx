/*     */ package mzm.gsp.crossfield.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SCrossFieldConsts
/*     */ {
/*  13 */   private static volatile SCrossFieldConsts oldInstance = null;
/*     */   
/*  15 */   private static SCrossFieldConsts instance = new SCrossFieldConsts();
/*     */   public int ACTIVITY_CFG_ID;
/*     */   public int NPC_ID;
/*     */   public int ATTEND_ACTIVITY_NPC_SERVICE_ID;
/*     */   public int POINT_EXCHANGE_NPC_SERVICE_ID;
/*     */   
/*     */   public static SCrossFieldConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SCrossFieldConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int GRADE_INSTRUCTION_NPC_SERVICE_ID;
/*     */   
/*     */   public int CROSS_SERVER_PROTECT_DURATION_IN_SECOND;
/*     */   
/*     */   public int RETURN_ORIGINAL_SERVER_PROTECT_DURATION_IN_SECOND;
/*     */   
/*     */   public int ACTIVE_LEAVE_FIELD_PUNISH_DURATION_IN_SECOND;
/*     */   
/*     */   public int WIN_POINT_NUM_UPPER_LIMIT;
/*     */   public int MVP_GET_WIN_POINT_NUM;
/*     */   public int STRAIGHT_WIN_GET_WIN_POINT_NUM;
/*     */   public int STRAIGHT_WIN_NUM;
/*     */   public int WEEKLY_POINT_UPPER_LIMIT;
/*     */   public int TRIGGER_BAODI_STAR_NUM;
/*     */   public int DAILY_AWARD_TIMES;
/*     */   public int DAILY_AWARD_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  50 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  55 */     String path = dir + "mzm.gsp.crossfield.confbean.SCrossFieldConsts.xml";
/*     */     try
/*     */     {
/*  58 */       SAXReader reader = new SAXReader();
/*  59 */       org.dom4j.Document doc = reader.read(new File(path));
/*  60 */       Element root = doc.getRootElement();
/*  61 */       Map<String, Element> data = new java.util.HashMap();
/*  62 */       java.util.List<?> nodeList = root.elements();
/*  63 */       int len = nodeList.size();
/*  64 */       for (int i = 0; i < len; i++)
/*     */       {
/*  66 */         Element element = (Element)nodeList.get(i);
/*  67 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  70 */           String name = element.attributeValue("name");
/*  71 */           if (data.put(name, element) != null)
/*  72 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  75 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  76 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  77 */       this.ATTEND_ACTIVITY_NPC_SERVICE_ID = Integer.valueOf(((Element)data.get("ATTEND_ACTIVITY_NPC_SERVICE_ID")).attributeValue("value")).intValue();
/*  78 */       this.POINT_EXCHANGE_NPC_SERVICE_ID = Integer.valueOf(((Element)data.get("POINT_EXCHANGE_NPC_SERVICE_ID")).attributeValue("value")).intValue();
/*  79 */       this.GRADE_INSTRUCTION_NPC_SERVICE_ID = Integer.valueOf(((Element)data.get("GRADE_INSTRUCTION_NPC_SERVICE_ID")).attributeValue("value")).intValue();
/*  80 */       this.CROSS_SERVER_PROTECT_DURATION_IN_SECOND = Integer.valueOf(((Element)data.get("CROSS_SERVER_PROTECT_DURATION_IN_SECOND")).attributeValue("value")).intValue();
/*  81 */       this.RETURN_ORIGINAL_SERVER_PROTECT_DURATION_IN_SECOND = Integer.valueOf(((Element)data.get("RETURN_ORIGINAL_SERVER_PROTECT_DURATION_IN_SECOND")).attributeValue("value")).intValue();
/*  82 */       this.ACTIVE_LEAVE_FIELD_PUNISH_DURATION_IN_SECOND = Integer.valueOf(((Element)data.get("ACTIVE_LEAVE_FIELD_PUNISH_DURATION_IN_SECOND")).attributeValue("value")).intValue();
/*  83 */       this.WIN_POINT_NUM_UPPER_LIMIT = Integer.valueOf(((Element)data.get("WIN_POINT_NUM_UPPER_LIMIT")).attributeValue("value")).intValue();
/*  84 */       this.MVP_GET_WIN_POINT_NUM = Integer.valueOf(((Element)data.get("MVP_GET_WIN_POINT_NUM")).attributeValue("value")).intValue();
/*  85 */       this.STRAIGHT_WIN_GET_WIN_POINT_NUM = Integer.valueOf(((Element)data.get("STRAIGHT_WIN_GET_WIN_POINT_NUM")).attributeValue("value")).intValue();
/*  86 */       this.STRAIGHT_WIN_NUM = Integer.valueOf(((Element)data.get("STRAIGHT_WIN_NUM")).attributeValue("value")).intValue();
/*  87 */       this.WEEKLY_POINT_UPPER_LIMIT = Integer.valueOf(((Element)data.get("WEEKLY_POINT_UPPER_LIMIT")).attributeValue("value")).intValue();
/*  88 */       this.TRIGGER_BAODI_STAR_NUM = Integer.valueOf(((Element)data.get("TRIGGER_BAODI_STAR_NUM")).attributeValue("value")).intValue();
/*  89 */       this.DAILY_AWARD_TIMES = Integer.valueOf(((Element)data.get("DAILY_AWARD_TIMES")).attributeValue("value")).intValue();
/*  90 */       this.DAILY_AWARD_ID = Integer.valueOf(((Element)data.get("DAILY_AWARD_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  94 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  99 */     String path = dir + "mzm.gsp.crossfield.confbean.SCrossFieldConsts.xml";
/*     */     try
/*     */     {
/* 102 */       SAXReader reader = new SAXReader();
/* 103 */       org.dom4j.Document doc = reader.read(new File(path));
/* 104 */       Element root = doc.getRootElement();
/* 105 */       Map<String, Element> data = new java.util.HashMap();
/* 106 */       java.util.List<?> nodeList = root.elements();
/* 107 */       int len = nodeList.size();
/* 108 */       for (int i = 0; i < len; i++)
/*     */       {
/* 110 */         Element element = (Element)nodeList.get(i);
/* 111 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 114 */           String name = element.attributeValue("name");
/* 115 */           if (data.put(name, element) != null)
/* 116 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 119 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 120 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 121 */       this.ATTEND_ACTIVITY_NPC_SERVICE_ID = Integer.valueOf(((Element)data.get("ATTEND_ACTIVITY_NPC_SERVICE_ID")).attributeValue("value")).intValue();
/* 122 */       this.POINT_EXCHANGE_NPC_SERVICE_ID = Integer.valueOf(((Element)data.get("POINT_EXCHANGE_NPC_SERVICE_ID")).attributeValue("value")).intValue();
/* 123 */       this.GRADE_INSTRUCTION_NPC_SERVICE_ID = Integer.valueOf(((Element)data.get("GRADE_INSTRUCTION_NPC_SERVICE_ID")).attributeValue("value")).intValue();
/* 124 */       this.CROSS_SERVER_PROTECT_DURATION_IN_SECOND = Integer.valueOf(((Element)data.get("CROSS_SERVER_PROTECT_DURATION_IN_SECOND")).attributeValue("value")).intValue();
/* 125 */       this.RETURN_ORIGINAL_SERVER_PROTECT_DURATION_IN_SECOND = Integer.valueOf(((Element)data.get("RETURN_ORIGINAL_SERVER_PROTECT_DURATION_IN_SECOND")).attributeValue("value")).intValue();
/* 126 */       this.ACTIVE_LEAVE_FIELD_PUNISH_DURATION_IN_SECOND = Integer.valueOf(((Element)data.get("ACTIVE_LEAVE_FIELD_PUNISH_DURATION_IN_SECOND")).attributeValue("value")).intValue();
/* 127 */       this.WIN_POINT_NUM_UPPER_LIMIT = Integer.valueOf(((Element)data.get("WIN_POINT_NUM_UPPER_LIMIT")).attributeValue("value")).intValue();
/* 128 */       this.MVP_GET_WIN_POINT_NUM = Integer.valueOf(((Element)data.get("MVP_GET_WIN_POINT_NUM")).attributeValue("value")).intValue();
/* 129 */       this.STRAIGHT_WIN_GET_WIN_POINT_NUM = Integer.valueOf(((Element)data.get("STRAIGHT_WIN_GET_WIN_POINT_NUM")).attributeValue("value")).intValue();
/* 130 */       this.STRAIGHT_WIN_NUM = Integer.valueOf(((Element)data.get("STRAIGHT_WIN_NUM")).attributeValue("value")).intValue();
/* 131 */       this.WEEKLY_POINT_UPPER_LIMIT = Integer.valueOf(((Element)data.get("WEEKLY_POINT_UPPER_LIMIT")).attributeValue("value")).intValue();
/* 132 */       this.TRIGGER_BAODI_STAR_NUM = Integer.valueOf(((Element)data.get("TRIGGER_BAODI_STAR_NUM")).attributeValue("value")).intValue();
/* 133 */       this.DAILY_AWARD_TIMES = Integer.valueOf(((Element)data.get("DAILY_AWARD_TIMES")).attributeValue("value")).intValue();
/* 134 */       this.DAILY_AWARD_ID = Integer.valueOf(((Element)data.get("DAILY_AWARD_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 138 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 142 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 145 */     String path = dir + "mzm.gsp.crossfield.confbean.SCrossFieldConsts.bny";
/*     */     try
/*     */     {
/* 148 */       File file = new File(path);
/* 149 */       if (file.exists())
/*     */       {
/* 151 */         byte[] bytes = new byte['Ѐ'];
/* 152 */         FileInputStream fis = new FileInputStream(file);
/* 153 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 154 */         int len = 0;
/* 155 */         while ((len = fis.read(bytes)) > 0)
/* 156 */           baos.write(bytes, 0, len);
/* 157 */         fis.close();
/* 158 */         bytes = baos.toByteArray();
/* 159 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 160 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 161 */         this.NPC_ID = _os_.unmarshal_int();
/* 162 */         this.ATTEND_ACTIVITY_NPC_SERVICE_ID = _os_.unmarshal_int();
/* 163 */         this.POINT_EXCHANGE_NPC_SERVICE_ID = _os_.unmarshal_int();
/* 164 */         this.GRADE_INSTRUCTION_NPC_SERVICE_ID = _os_.unmarshal_int();
/* 165 */         this.CROSS_SERVER_PROTECT_DURATION_IN_SECOND = _os_.unmarshal_int();
/* 166 */         this.RETURN_ORIGINAL_SERVER_PROTECT_DURATION_IN_SECOND = _os_.unmarshal_int();
/* 167 */         this.ACTIVE_LEAVE_FIELD_PUNISH_DURATION_IN_SECOND = _os_.unmarshal_int();
/* 168 */         this.WIN_POINT_NUM_UPPER_LIMIT = _os_.unmarshal_int();
/* 169 */         this.MVP_GET_WIN_POINT_NUM = _os_.unmarshal_int();
/* 170 */         this.STRAIGHT_WIN_GET_WIN_POINT_NUM = _os_.unmarshal_int();
/* 171 */         this.STRAIGHT_WIN_NUM = _os_.unmarshal_int();
/* 172 */         this.WEEKLY_POINT_UPPER_LIMIT = _os_.unmarshal_int();
/* 173 */         this.TRIGGER_BAODI_STAR_NUM = _os_.unmarshal_int();
/* 174 */         this.DAILY_AWARD_TIMES = _os_.unmarshal_int();
/* 175 */         this.DAILY_AWARD_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 186 */     String path = dir + "mzm.gsp.crossfield.confbean.SCrossFieldConsts.bny";
/*     */     try
/*     */     {
/* 189 */       File file = new File(path);
/* 190 */       if (file.exists())
/*     */       {
/* 192 */         byte[] bytes = new byte['Ѐ'];
/* 193 */         FileInputStream fis = new FileInputStream(file);
/* 194 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 195 */         int len = 0;
/* 196 */         while ((len = fis.read(bytes)) > 0)
/* 197 */           baos.write(bytes, 0, len);
/* 198 */         fis.close();
/* 199 */         bytes = baos.toByteArray();
/* 200 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 201 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 202 */         this.NPC_ID = _os_.unmarshal_int();
/* 203 */         this.ATTEND_ACTIVITY_NPC_SERVICE_ID = _os_.unmarshal_int();
/* 204 */         this.POINT_EXCHANGE_NPC_SERVICE_ID = _os_.unmarshal_int();
/* 205 */         this.GRADE_INSTRUCTION_NPC_SERVICE_ID = _os_.unmarshal_int();
/* 206 */         this.CROSS_SERVER_PROTECT_DURATION_IN_SECOND = _os_.unmarshal_int();
/* 207 */         this.RETURN_ORIGINAL_SERVER_PROTECT_DURATION_IN_SECOND = _os_.unmarshal_int();
/* 208 */         this.ACTIVE_LEAVE_FIELD_PUNISH_DURATION_IN_SECOND = _os_.unmarshal_int();
/* 209 */         this.WIN_POINT_NUM_UPPER_LIMIT = _os_.unmarshal_int();
/* 210 */         this.MVP_GET_WIN_POINT_NUM = _os_.unmarshal_int();
/* 211 */         this.STRAIGHT_WIN_GET_WIN_POINT_NUM = _os_.unmarshal_int();
/* 212 */         this.STRAIGHT_WIN_NUM = _os_.unmarshal_int();
/* 213 */         this.WEEKLY_POINT_UPPER_LIMIT = _os_.unmarshal_int();
/* 214 */         this.TRIGGER_BAODI_STAR_NUM = _os_.unmarshal_int();
/* 215 */         this.DAILY_AWARD_TIMES = _os_.unmarshal_int();
/* 216 */         this.DAILY_AWARD_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 221 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SCrossFieldConsts newInstance)
/*     */   {
/* 227 */     oldInstance = instance;
/* 228 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 233 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\confbean\SCrossFieldConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */