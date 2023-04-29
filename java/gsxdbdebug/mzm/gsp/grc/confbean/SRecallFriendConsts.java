/*     */ package mzm.gsp.grc.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SRecallFriendConsts
/*     */ {
/*  13 */   private static volatile SRecallFriendConsts oldInstance = null;
/*     */   
/*  15 */   private static SRecallFriendConsts instance = new SRecallFriendConsts();
/*     */   public int RECALL_MIN_OffLINE_TIME;
/*     */   public int RECALL_MIN_ROLE_LEVEL;
/*     */   public int PERIOD_TIME;
/*     */   public int RECALL_PERIOD_TIME;
/*     */   public int ONE_PERIOD_BE_RECALL_TIMES;
/*     */   public int MAX_RECALL_TIMES_EVERY_DAY;
/*     */   
/*  23 */   public static SRecallFriendConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static SRecallFriendConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int BIG_GIFT_RECALL_AWARD_ID;
/*     */   
/*     */   public int RECALL_FRIEND_DESCRIPTION;
/*     */   
/*     */   public int RECALL_FRIEND_BACK_NOTIFY_MAIL_ID;
/*     */   
/*     */   public int RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL_ID;
/*     */   
/*     */   public int RECALL_FRIEND_FIX_AWARD_ID;
/*     */   
/*     */   public int BACK_BIND_FRIEND_NOTIFY_MAIL_CFG_ID;
/*     */   
/*     */   public int RECALL_BIND_FRIEND_NOTIFY_MAIL_CFG_ID;
/*     */   public int BIND_VITALITY;
/*     */   public int BIND_PERIOD_IN_HOUR;
/*     */   public int BIND_FRIEND_NUM;
/*     */   public int REBATE_PERIOD;
/*     */   public int YUAN_BAO_POLL_MAX;
/*     */   public int YUAN_BAO_DRAW;
/*     */   public int YUAN_BAO_MIN_LEVEL;
/*     */   public int RECHARGE_REBATE_PERCENT;
/*     */   public int BE_BIND_FRIEND_NUM;
/*     */   public int BINDED_MAX_NUM;
/*     */   public int RECHARGE_REBATE_MAX;
/*     */   public int BIND_FRIEND_AWARD_CFG_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  59 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  64 */     String path = dir + "mzm.gsp.grc.confbean.SRecallFriendConsts.xml";
/*     */     try
/*     */     {
/*  67 */       SAXReader reader = new SAXReader();
/*  68 */       org.dom4j.Document doc = reader.read(new File(path));
/*  69 */       Element root = doc.getRootElement();
/*  70 */       Map<String, Element> data = new java.util.HashMap();
/*  71 */       java.util.List<?> nodeList = root.elements();
/*  72 */       int len = nodeList.size();
/*  73 */       for (int i = 0; i < len; i++)
/*     */       {
/*  75 */         Element element = (Element)nodeList.get(i);
/*  76 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  79 */           String name = element.attributeValue("name");
/*  80 */           if (data.put(name, element) != null)
/*  81 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  84 */       this.RECALL_MIN_OffLINE_TIME = Integer.valueOf(((Element)data.get("RECALL_MIN_OffLINE_TIME")).attributeValue("value")).intValue();
/*  85 */       this.RECALL_MIN_ROLE_LEVEL = Integer.valueOf(((Element)data.get("RECALL_MIN_ROLE_LEVEL")).attributeValue("value")).intValue();
/*  86 */       this.PERIOD_TIME = Integer.valueOf(((Element)data.get("PERIOD_TIME")).attributeValue("value")).intValue();
/*  87 */       this.RECALL_PERIOD_TIME = Integer.valueOf(((Element)data.get("RECALL_PERIOD_TIME")).attributeValue("value")).intValue();
/*  88 */       this.ONE_PERIOD_BE_RECALL_TIMES = Integer.valueOf(((Element)data.get("ONE_PERIOD_BE_RECALL_TIMES")).attributeValue("value")).intValue();
/*  89 */       this.MAX_RECALL_TIMES_EVERY_DAY = Integer.valueOf(((Element)data.get("MAX_RECALL_TIMES_EVERY_DAY")).attributeValue("value")).intValue();
/*  90 */       this.BIG_GIFT_RECALL_AWARD_ID = Integer.valueOf(((Element)data.get("BIG_GIFT_RECALL_AWARD_ID")).attributeValue("value")).intValue();
/*  91 */       this.RECALL_FRIEND_DESCRIPTION = Integer.valueOf(((Element)data.get("RECALL_FRIEND_DESCRIPTION")).attributeValue("value")).intValue();
/*  92 */       this.RECALL_FRIEND_BACK_NOTIFY_MAIL_ID = Integer.valueOf(((Element)data.get("RECALL_FRIEND_BACK_NOTIFY_MAIL_ID")).attributeValue("value")).intValue();
/*  93 */       this.RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL_ID = Integer.valueOf(((Element)data.get("RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL_ID")).attributeValue("value")).intValue();
/*  94 */       this.RECALL_FRIEND_FIX_AWARD_ID = Integer.valueOf(((Element)data.get("RECALL_FRIEND_FIX_AWARD_ID")).attributeValue("value")).intValue();
/*  95 */       this.BACK_BIND_FRIEND_NOTIFY_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("BACK_BIND_FRIEND_NOTIFY_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  96 */       this.RECALL_BIND_FRIEND_NOTIFY_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("RECALL_BIND_FRIEND_NOTIFY_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  97 */       this.BIND_VITALITY = Integer.valueOf(((Element)data.get("BIND_VITALITY")).attributeValue("value")).intValue();
/*  98 */       this.BIND_PERIOD_IN_HOUR = Integer.valueOf(((Element)data.get("BIND_PERIOD_IN_HOUR")).attributeValue("value")).intValue();
/*  99 */       this.BIND_FRIEND_NUM = Integer.valueOf(((Element)data.get("BIND_FRIEND_NUM")).attributeValue("value")).intValue();
/* 100 */       this.REBATE_PERIOD = Integer.valueOf(((Element)data.get("REBATE_PERIOD")).attributeValue("value")).intValue();
/* 101 */       this.YUAN_BAO_POLL_MAX = Integer.valueOf(((Element)data.get("YUAN_BAO_POLL_MAX")).attributeValue("value")).intValue();
/* 102 */       this.YUAN_BAO_DRAW = Integer.valueOf(((Element)data.get("YUAN_BAO_DRAW")).attributeValue("value")).intValue();
/* 103 */       this.YUAN_BAO_MIN_LEVEL = Integer.valueOf(((Element)data.get("YUAN_BAO_MIN_LEVEL")).attributeValue("value")).intValue();
/* 104 */       this.RECHARGE_REBATE_PERCENT = Integer.valueOf(((Element)data.get("RECHARGE_REBATE_PERCENT")).attributeValue("value")).intValue();
/* 105 */       this.BE_BIND_FRIEND_NUM = Integer.valueOf(((Element)data.get("BE_BIND_FRIEND_NUM")).attributeValue("value")).intValue();
/* 106 */       this.BINDED_MAX_NUM = Integer.valueOf(((Element)data.get("BINDED_MAX_NUM")).attributeValue("value")).intValue();
/* 107 */       this.RECHARGE_REBATE_MAX = Integer.valueOf(((Element)data.get("RECHARGE_REBATE_MAX")).attributeValue("value")).intValue();
/* 108 */       this.BIND_FRIEND_AWARD_CFG_ID = Integer.valueOf(((Element)data.get("BIND_FRIEND_AWARD_CFG_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 112 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 117 */     String path = dir + "mzm.gsp.grc.confbean.SRecallFriendConsts.xml";
/*     */     try
/*     */     {
/* 120 */       SAXReader reader = new SAXReader();
/* 121 */       org.dom4j.Document doc = reader.read(new File(path));
/* 122 */       Element root = doc.getRootElement();
/* 123 */       Map<String, Element> data = new java.util.HashMap();
/* 124 */       java.util.List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element element = (Element)nodeList.get(i);
/* 129 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 132 */           String name = element.attributeValue("name");
/* 133 */           if (data.put(name, element) != null)
/* 134 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 137 */       this.RECALL_MIN_OffLINE_TIME = Integer.valueOf(((Element)data.get("RECALL_MIN_OffLINE_TIME")).attributeValue("value")).intValue();
/* 138 */       this.RECALL_MIN_ROLE_LEVEL = Integer.valueOf(((Element)data.get("RECALL_MIN_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 139 */       this.PERIOD_TIME = Integer.valueOf(((Element)data.get("PERIOD_TIME")).attributeValue("value")).intValue();
/* 140 */       this.RECALL_PERIOD_TIME = Integer.valueOf(((Element)data.get("RECALL_PERIOD_TIME")).attributeValue("value")).intValue();
/* 141 */       this.ONE_PERIOD_BE_RECALL_TIMES = Integer.valueOf(((Element)data.get("ONE_PERIOD_BE_RECALL_TIMES")).attributeValue("value")).intValue();
/* 142 */       this.MAX_RECALL_TIMES_EVERY_DAY = Integer.valueOf(((Element)data.get("MAX_RECALL_TIMES_EVERY_DAY")).attributeValue("value")).intValue();
/* 143 */       this.BIG_GIFT_RECALL_AWARD_ID = Integer.valueOf(((Element)data.get("BIG_GIFT_RECALL_AWARD_ID")).attributeValue("value")).intValue();
/* 144 */       this.RECALL_FRIEND_DESCRIPTION = Integer.valueOf(((Element)data.get("RECALL_FRIEND_DESCRIPTION")).attributeValue("value")).intValue();
/* 145 */       this.RECALL_FRIEND_BACK_NOTIFY_MAIL_ID = Integer.valueOf(((Element)data.get("RECALL_FRIEND_BACK_NOTIFY_MAIL_ID")).attributeValue("value")).intValue();
/* 146 */       this.RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL_ID = Integer.valueOf(((Element)data.get("RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL_ID")).attributeValue("value")).intValue();
/* 147 */       this.RECALL_FRIEND_FIX_AWARD_ID = Integer.valueOf(((Element)data.get("RECALL_FRIEND_FIX_AWARD_ID")).attributeValue("value")).intValue();
/* 148 */       this.BACK_BIND_FRIEND_NOTIFY_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("BACK_BIND_FRIEND_NOTIFY_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 149 */       this.RECALL_BIND_FRIEND_NOTIFY_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("RECALL_BIND_FRIEND_NOTIFY_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 150 */       this.BIND_VITALITY = Integer.valueOf(((Element)data.get("BIND_VITALITY")).attributeValue("value")).intValue();
/* 151 */       this.BIND_PERIOD_IN_HOUR = Integer.valueOf(((Element)data.get("BIND_PERIOD_IN_HOUR")).attributeValue("value")).intValue();
/* 152 */       this.BIND_FRIEND_NUM = Integer.valueOf(((Element)data.get("BIND_FRIEND_NUM")).attributeValue("value")).intValue();
/* 153 */       this.REBATE_PERIOD = Integer.valueOf(((Element)data.get("REBATE_PERIOD")).attributeValue("value")).intValue();
/* 154 */       this.YUAN_BAO_POLL_MAX = Integer.valueOf(((Element)data.get("YUAN_BAO_POLL_MAX")).attributeValue("value")).intValue();
/* 155 */       this.YUAN_BAO_DRAW = Integer.valueOf(((Element)data.get("YUAN_BAO_DRAW")).attributeValue("value")).intValue();
/* 156 */       this.YUAN_BAO_MIN_LEVEL = Integer.valueOf(((Element)data.get("YUAN_BAO_MIN_LEVEL")).attributeValue("value")).intValue();
/* 157 */       this.RECHARGE_REBATE_PERCENT = Integer.valueOf(((Element)data.get("RECHARGE_REBATE_PERCENT")).attributeValue("value")).intValue();
/* 158 */       this.BE_BIND_FRIEND_NUM = Integer.valueOf(((Element)data.get("BE_BIND_FRIEND_NUM")).attributeValue("value")).intValue();
/* 159 */       this.BINDED_MAX_NUM = Integer.valueOf(((Element)data.get("BINDED_MAX_NUM")).attributeValue("value")).intValue();
/* 160 */       this.RECHARGE_REBATE_MAX = Integer.valueOf(((Element)data.get("RECHARGE_REBATE_MAX")).attributeValue("value")).intValue();
/* 161 */       this.BIND_FRIEND_AWARD_CFG_ID = Integer.valueOf(((Element)data.get("BIND_FRIEND_AWARD_CFG_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 165 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 169 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 172 */     String path = dir + "mzm.gsp.grc.confbean.SRecallFriendConsts.bny";
/*     */     try
/*     */     {
/* 175 */       File file = new File(path);
/* 176 */       if (file.exists())
/*     */       {
/* 178 */         byte[] bytes = new byte['Ѐ'];
/* 179 */         FileInputStream fis = new FileInputStream(file);
/* 180 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 181 */         int len = 0;
/* 182 */         while ((len = fis.read(bytes)) > 0)
/* 183 */           baos.write(bytes, 0, len);
/* 184 */         fis.close();
/* 185 */         bytes = baos.toByteArray();
/* 186 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 187 */         this.RECALL_MIN_OffLINE_TIME = _os_.unmarshal_int();
/* 188 */         this.RECALL_MIN_ROLE_LEVEL = _os_.unmarshal_int();
/* 189 */         this.PERIOD_TIME = _os_.unmarshal_int();
/* 190 */         this.RECALL_PERIOD_TIME = _os_.unmarshal_int();
/* 191 */         this.ONE_PERIOD_BE_RECALL_TIMES = _os_.unmarshal_int();
/* 192 */         this.MAX_RECALL_TIMES_EVERY_DAY = _os_.unmarshal_int();
/* 193 */         this.BIG_GIFT_RECALL_AWARD_ID = _os_.unmarshal_int();
/* 194 */         this.RECALL_FRIEND_DESCRIPTION = _os_.unmarshal_int();
/* 195 */         this.RECALL_FRIEND_BACK_NOTIFY_MAIL_ID = _os_.unmarshal_int();
/* 196 */         this.RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL_ID = _os_.unmarshal_int();
/* 197 */         this.RECALL_FRIEND_FIX_AWARD_ID = _os_.unmarshal_int();
/* 198 */         this.BACK_BIND_FRIEND_NOTIFY_MAIL_CFG_ID = _os_.unmarshal_int();
/* 199 */         this.RECALL_BIND_FRIEND_NOTIFY_MAIL_CFG_ID = _os_.unmarshal_int();
/* 200 */         this.BIND_VITALITY = _os_.unmarshal_int();
/* 201 */         this.BIND_PERIOD_IN_HOUR = _os_.unmarshal_int();
/* 202 */         this.BIND_FRIEND_NUM = _os_.unmarshal_int();
/* 203 */         this.REBATE_PERIOD = _os_.unmarshal_int();
/* 204 */         this.YUAN_BAO_POLL_MAX = _os_.unmarshal_int();
/* 205 */         this.YUAN_BAO_DRAW = _os_.unmarshal_int();
/* 206 */         this.YUAN_BAO_MIN_LEVEL = _os_.unmarshal_int();
/* 207 */         this.RECHARGE_REBATE_PERCENT = _os_.unmarshal_int();
/* 208 */         this.BE_BIND_FRIEND_NUM = _os_.unmarshal_int();
/* 209 */         this.BINDED_MAX_NUM = _os_.unmarshal_int();
/* 210 */         this.RECHARGE_REBATE_MAX = _os_.unmarshal_int();
/* 211 */         this.BIND_FRIEND_AWARD_CFG_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 222 */     String path = dir + "mzm.gsp.grc.confbean.SRecallFriendConsts.bny";
/*     */     try
/*     */     {
/* 225 */       File file = new File(path);
/* 226 */       if (file.exists())
/*     */       {
/* 228 */         byte[] bytes = new byte['Ѐ'];
/* 229 */         FileInputStream fis = new FileInputStream(file);
/* 230 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 231 */         int len = 0;
/* 232 */         while ((len = fis.read(bytes)) > 0)
/* 233 */           baos.write(bytes, 0, len);
/* 234 */         fis.close();
/* 235 */         bytes = baos.toByteArray();
/* 236 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 237 */         this.RECALL_MIN_OffLINE_TIME = _os_.unmarshal_int();
/* 238 */         this.RECALL_MIN_ROLE_LEVEL = _os_.unmarshal_int();
/* 239 */         this.PERIOD_TIME = _os_.unmarshal_int();
/* 240 */         this.RECALL_PERIOD_TIME = _os_.unmarshal_int();
/* 241 */         this.ONE_PERIOD_BE_RECALL_TIMES = _os_.unmarshal_int();
/* 242 */         this.MAX_RECALL_TIMES_EVERY_DAY = _os_.unmarshal_int();
/* 243 */         this.BIG_GIFT_RECALL_AWARD_ID = _os_.unmarshal_int();
/* 244 */         this.RECALL_FRIEND_DESCRIPTION = _os_.unmarshal_int();
/* 245 */         this.RECALL_FRIEND_BACK_NOTIFY_MAIL_ID = _os_.unmarshal_int();
/* 246 */         this.RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL_ID = _os_.unmarshal_int();
/* 247 */         this.RECALL_FRIEND_FIX_AWARD_ID = _os_.unmarshal_int();
/* 248 */         this.BACK_BIND_FRIEND_NOTIFY_MAIL_CFG_ID = _os_.unmarshal_int();
/* 249 */         this.RECALL_BIND_FRIEND_NOTIFY_MAIL_CFG_ID = _os_.unmarshal_int();
/* 250 */         this.BIND_VITALITY = _os_.unmarshal_int();
/* 251 */         this.BIND_PERIOD_IN_HOUR = _os_.unmarshal_int();
/* 252 */         this.BIND_FRIEND_NUM = _os_.unmarshal_int();
/* 253 */         this.REBATE_PERIOD = _os_.unmarshal_int();
/* 254 */         this.YUAN_BAO_POLL_MAX = _os_.unmarshal_int();
/* 255 */         this.YUAN_BAO_DRAW = _os_.unmarshal_int();
/* 256 */         this.YUAN_BAO_MIN_LEVEL = _os_.unmarshal_int();
/* 257 */         this.RECHARGE_REBATE_PERCENT = _os_.unmarshal_int();
/* 258 */         this.BE_BIND_FRIEND_NUM = _os_.unmarshal_int();
/* 259 */         this.BINDED_MAX_NUM = _os_.unmarshal_int();
/* 260 */         this.RECHARGE_REBATE_MAX = _os_.unmarshal_int();
/* 261 */         this.BIND_FRIEND_AWARD_CFG_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 266 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SRecallFriendConsts newInstance)
/*     */   {
/* 272 */     oldInstance = instance;
/* 273 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 278 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\confbean\SRecallFriendConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */