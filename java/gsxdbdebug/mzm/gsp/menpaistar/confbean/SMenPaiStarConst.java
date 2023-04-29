/*     */ package mzm.gsp.menpaistar.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMenPaiStarConst
/*     */ {
/*  13 */   private static volatile SMenPaiStarConst oldInstance = null;
/*     */   
/*  15 */   private static SMenPaiStarConst instance = new SMenPaiStarConst();
/*     */   public int CAMPAIGN_MIN_LEVEL;
/*     */   public int CAMPAIGN_NOT_LESS_SERVER_LEVEL;
/*     */   public int VOTE_MIN_LEVEL;
/*     */   public int VOTE_NOT_LESS_SERVER_LEVEL;
/*     */   public int CAMPAIGN_BATTLE_END_TIME;
/*     */   
/*     */   public static SMenPaiStarConst getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SMenPaiStarConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int VOTE_BATTLE_END_TIME;
/*     */   
/*     */   public int VOTE_NUM;
/*     */   
/*     */   public int WORLD_CHANNEL_CD;
/*     */   
/*     */   public int GANG_CHANNEL_CD;
/*     */   
/*     */   public int CAMPAIGN_SUCCESS_MIN_POINT;
/*     */   
/*     */   public int DAILY_CAMPAIGN_BATTLE_NUM;
/*     */   public int DAILY_VOTE_BATTLE_NUM;
/*     */   public int VOTE_AWARD_CFG_ID;
/*     */   public int ACTIVITY_CFG_ID;
/*     */   public int PAGE_SIZE;
/*     */   public int SUPPLY_VOTE_AWARD_MAIL_CFG_ID;
/*     */   public int STAR_BADGE;
/*     */   public int STAR_TITLE;
/*     */   public int RETURN_VOTE_COST_MAIL_CFG_ID;
/*     */   public int CAMPAIGN_CHART_SIZE;
/*     */   public int TRUMPET_CFG_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  55 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  60 */     String path = dir + "mzm.gsp.menpaistar.confbean.SMenPaiStarConst.xml";
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
/*  80 */       this.CAMPAIGN_MIN_LEVEL = Integer.valueOf(((Element)data.get("CAMPAIGN_MIN_LEVEL")).attributeValue("value")).intValue();
/*  81 */       this.CAMPAIGN_NOT_LESS_SERVER_LEVEL = Integer.valueOf(((Element)data.get("CAMPAIGN_NOT_LESS_SERVER_LEVEL")).attributeValue("value")).intValue();
/*  82 */       this.VOTE_MIN_LEVEL = Integer.valueOf(((Element)data.get("VOTE_MIN_LEVEL")).attributeValue("value")).intValue();
/*  83 */       this.VOTE_NOT_LESS_SERVER_LEVEL = Integer.valueOf(((Element)data.get("VOTE_NOT_LESS_SERVER_LEVEL")).attributeValue("value")).intValue();
/*  84 */       this.CAMPAIGN_BATTLE_END_TIME = Integer.valueOf(((Element)data.get("CAMPAIGN_BATTLE_END_TIME")).attributeValue("value")).intValue();
/*  85 */       this.VOTE_BATTLE_END_TIME = Integer.valueOf(((Element)data.get("VOTE_BATTLE_END_TIME")).attributeValue("value")).intValue();
/*  86 */       this.VOTE_NUM = Integer.valueOf(((Element)data.get("VOTE_NUM")).attributeValue("value")).intValue();
/*  87 */       this.WORLD_CHANNEL_CD = Integer.valueOf(((Element)data.get("WORLD_CHANNEL_CD")).attributeValue("value")).intValue();
/*  88 */       this.GANG_CHANNEL_CD = Integer.valueOf(((Element)data.get("GANG_CHANNEL_CD")).attributeValue("value")).intValue();
/*  89 */       this.CAMPAIGN_SUCCESS_MIN_POINT = Integer.valueOf(((Element)data.get("CAMPAIGN_SUCCESS_MIN_POINT")).attributeValue("value")).intValue();
/*  90 */       this.DAILY_CAMPAIGN_BATTLE_NUM = Integer.valueOf(((Element)data.get("DAILY_CAMPAIGN_BATTLE_NUM")).attributeValue("value")).intValue();
/*  91 */       this.DAILY_VOTE_BATTLE_NUM = Integer.valueOf(((Element)data.get("DAILY_VOTE_BATTLE_NUM")).attributeValue("value")).intValue();
/*  92 */       this.VOTE_AWARD_CFG_ID = Integer.valueOf(((Element)data.get("VOTE_AWARD_CFG_ID")).attributeValue("value")).intValue();
/*  93 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  94 */       this.PAGE_SIZE = Integer.valueOf(((Element)data.get("PAGE_SIZE")).attributeValue("value")).intValue();
/*  95 */       this.SUPPLY_VOTE_AWARD_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("SUPPLY_VOTE_AWARD_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  96 */       this.STAR_BADGE = Integer.valueOf(((Element)data.get("STAR_BADGE")).attributeValue("value")).intValue();
/*  97 */       this.STAR_TITLE = Integer.valueOf(((Element)data.get("STAR_TITLE")).attributeValue("value")).intValue();
/*  98 */       this.RETURN_VOTE_COST_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("RETURN_VOTE_COST_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  99 */       this.CAMPAIGN_CHART_SIZE = Integer.valueOf(((Element)data.get("CAMPAIGN_CHART_SIZE")).attributeValue("value")).intValue();
/* 100 */       this.TRUMPET_CFG_ID = Integer.valueOf(((Element)data.get("TRUMPET_CFG_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 109 */     String path = dir + "mzm.gsp.menpaistar.confbean.SMenPaiStarConst.xml";
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
/* 129 */       this.CAMPAIGN_MIN_LEVEL = Integer.valueOf(((Element)data.get("CAMPAIGN_MIN_LEVEL")).attributeValue("value")).intValue();
/* 130 */       this.CAMPAIGN_NOT_LESS_SERVER_LEVEL = Integer.valueOf(((Element)data.get("CAMPAIGN_NOT_LESS_SERVER_LEVEL")).attributeValue("value")).intValue();
/* 131 */       this.VOTE_MIN_LEVEL = Integer.valueOf(((Element)data.get("VOTE_MIN_LEVEL")).attributeValue("value")).intValue();
/* 132 */       this.VOTE_NOT_LESS_SERVER_LEVEL = Integer.valueOf(((Element)data.get("VOTE_NOT_LESS_SERVER_LEVEL")).attributeValue("value")).intValue();
/* 133 */       this.CAMPAIGN_BATTLE_END_TIME = Integer.valueOf(((Element)data.get("CAMPAIGN_BATTLE_END_TIME")).attributeValue("value")).intValue();
/* 134 */       this.VOTE_BATTLE_END_TIME = Integer.valueOf(((Element)data.get("VOTE_BATTLE_END_TIME")).attributeValue("value")).intValue();
/* 135 */       this.VOTE_NUM = Integer.valueOf(((Element)data.get("VOTE_NUM")).attributeValue("value")).intValue();
/* 136 */       this.WORLD_CHANNEL_CD = Integer.valueOf(((Element)data.get("WORLD_CHANNEL_CD")).attributeValue("value")).intValue();
/* 137 */       this.GANG_CHANNEL_CD = Integer.valueOf(((Element)data.get("GANG_CHANNEL_CD")).attributeValue("value")).intValue();
/* 138 */       this.CAMPAIGN_SUCCESS_MIN_POINT = Integer.valueOf(((Element)data.get("CAMPAIGN_SUCCESS_MIN_POINT")).attributeValue("value")).intValue();
/* 139 */       this.DAILY_CAMPAIGN_BATTLE_NUM = Integer.valueOf(((Element)data.get("DAILY_CAMPAIGN_BATTLE_NUM")).attributeValue("value")).intValue();
/* 140 */       this.DAILY_VOTE_BATTLE_NUM = Integer.valueOf(((Element)data.get("DAILY_VOTE_BATTLE_NUM")).attributeValue("value")).intValue();
/* 141 */       this.VOTE_AWARD_CFG_ID = Integer.valueOf(((Element)data.get("VOTE_AWARD_CFG_ID")).attributeValue("value")).intValue();
/* 142 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 143 */       this.PAGE_SIZE = Integer.valueOf(((Element)data.get("PAGE_SIZE")).attributeValue("value")).intValue();
/* 144 */       this.SUPPLY_VOTE_AWARD_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("SUPPLY_VOTE_AWARD_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 145 */       this.STAR_BADGE = Integer.valueOf(((Element)data.get("STAR_BADGE")).attributeValue("value")).intValue();
/* 146 */       this.STAR_TITLE = Integer.valueOf(((Element)data.get("STAR_TITLE")).attributeValue("value")).intValue();
/* 147 */       this.RETURN_VOTE_COST_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("RETURN_VOTE_COST_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 148 */       this.CAMPAIGN_CHART_SIZE = Integer.valueOf(((Element)data.get("CAMPAIGN_CHART_SIZE")).attributeValue("value")).intValue();
/* 149 */       this.TRUMPET_CFG_ID = Integer.valueOf(((Element)data.get("TRUMPET_CFG_ID")).attributeValue("value")).intValue();
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
/* 160 */     String path = dir + "mzm.gsp.menpaistar.confbean.SMenPaiStarConst.bny";
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
/* 175 */         this.CAMPAIGN_MIN_LEVEL = _os_.unmarshal_int();
/* 176 */         this.CAMPAIGN_NOT_LESS_SERVER_LEVEL = _os_.unmarshal_int();
/* 177 */         this.VOTE_MIN_LEVEL = _os_.unmarshal_int();
/* 178 */         this.VOTE_NOT_LESS_SERVER_LEVEL = _os_.unmarshal_int();
/* 179 */         this.CAMPAIGN_BATTLE_END_TIME = _os_.unmarshal_int();
/* 180 */         this.VOTE_BATTLE_END_TIME = _os_.unmarshal_int();
/* 181 */         this.VOTE_NUM = _os_.unmarshal_int();
/* 182 */         this.WORLD_CHANNEL_CD = _os_.unmarshal_int();
/* 183 */         this.GANG_CHANNEL_CD = _os_.unmarshal_int();
/* 184 */         this.CAMPAIGN_SUCCESS_MIN_POINT = _os_.unmarshal_int();
/* 185 */         this.DAILY_CAMPAIGN_BATTLE_NUM = _os_.unmarshal_int();
/* 186 */         this.DAILY_VOTE_BATTLE_NUM = _os_.unmarshal_int();
/* 187 */         this.VOTE_AWARD_CFG_ID = _os_.unmarshal_int();
/* 188 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 189 */         this.PAGE_SIZE = _os_.unmarshal_int();
/* 190 */         this.SUPPLY_VOTE_AWARD_MAIL_CFG_ID = _os_.unmarshal_int();
/* 191 */         this.STAR_BADGE = _os_.unmarshal_int();
/* 192 */         this.STAR_TITLE = _os_.unmarshal_int();
/* 193 */         this.RETURN_VOTE_COST_MAIL_CFG_ID = _os_.unmarshal_int();
/* 194 */         this.CAMPAIGN_CHART_SIZE = _os_.unmarshal_int();
/* 195 */         this.TRUMPET_CFG_ID = _os_.unmarshal_int();
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
/* 206 */     String path = dir + "mzm.gsp.menpaistar.confbean.SMenPaiStarConst.bny";
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
/* 221 */         this.CAMPAIGN_MIN_LEVEL = _os_.unmarshal_int();
/* 222 */         this.CAMPAIGN_NOT_LESS_SERVER_LEVEL = _os_.unmarshal_int();
/* 223 */         this.VOTE_MIN_LEVEL = _os_.unmarshal_int();
/* 224 */         this.VOTE_NOT_LESS_SERVER_LEVEL = _os_.unmarshal_int();
/* 225 */         this.CAMPAIGN_BATTLE_END_TIME = _os_.unmarshal_int();
/* 226 */         this.VOTE_BATTLE_END_TIME = _os_.unmarshal_int();
/* 227 */         this.VOTE_NUM = _os_.unmarshal_int();
/* 228 */         this.WORLD_CHANNEL_CD = _os_.unmarshal_int();
/* 229 */         this.GANG_CHANNEL_CD = _os_.unmarshal_int();
/* 230 */         this.CAMPAIGN_SUCCESS_MIN_POINT = _os_.unmarshal_int();
/* 231 */         this.DAILY_CAMPAIGN_BATTLE_NUM = _os_.unmarshal_int();
/* 232 */         this.DAILY_VOTE_BATTLE_NUM = _os_.unmarshal_int();
/* 233 */         this.VOTE_AWARD_CFG_ID = _os_.unmarshal_int();
/* 234 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 235 */         this.PAGE_SIZE = _os_.unmarshal_int();
/* 236 */         this.SUPPLY_VOTE_AWARD_MAIL_CFG_ID = _os_.unmarshal_int();
/* 237 */         this.STAR_BADGE = _os_.unmarshal_int();
/* 238 */         this.STAR_TITLE = _os_.unmarshal_int();
/* 239 */         this.RETURN_VOTE_COST_MAIL_CFG_ID = _os_.unmarshal_int();
/* 240 */         this.CAMPAIGN_CHART_SIZE = _os_.unmarshal_int();
/* 241 */         this.TRUMPET_CFG_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMenPaiStarConst newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\confbean\SMenPaiStarConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */