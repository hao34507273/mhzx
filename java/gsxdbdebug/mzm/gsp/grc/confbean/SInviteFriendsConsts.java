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
/*     */ public class SInviteFriendsConsts
/*     */ {
/*  13 */   private static volatile SInviteFriendsConsts oldInstance = null;
/*     */   
/*  15 */   private static SInviteFriendsConsts instance = new SInviteFriendsConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SInviteFriendsConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SInviteFriendsConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int OPEN_NEED_ROLE_LEVEL = 40;
/*  32 */   public int INVITER_MIN_ROLE_LEVEL = 40;
/*  33 */   public int AWARD_INVITER_NEED_INVITEE_ROLE_LEVEL = 60;
/*  34 */   public int AWARD_INVITER_INVITEE_USER_CREATE_MAX_DAYS = 10;
/*  35 */   public int AWARD_INVITER_INVITEE_DONE_SHIMEN_TOTAL_DAYS = 10;
/*  36 */   public int AWARD_INVITER_INVITEE_DONE_SHIMEN_RING_NUM = 20;
/*  37 */   public int AWARD_INVITER_GIFT_MAX_TIMES = 10;
/*  38 */   public int AWARD_INVITER_CFG_ID = 0;
/*  39 */   public int AWARD_INVITEE_CFG_ID = 0;
/*  40 */   public int AWARD_INVITEE_MAIL_CFG_ID = 0;
/*  41 */   public int PRESENT_BIND_YUANBAO_DAYS_ON_INVITEE_CASH = 30;
/*  42 */   public int PRESENT_BIND_YUANBAO_RATIO_ON_INVITEE_CASH = 500;
/*  43 */   public int WITHDRAW_BIND_YUANBAO_DAILY_MAX_NUM = 1000;
/*  44 */   public int INVITEE_PRESENT_BIND_YUANBAO_MAX_NUM = Integer.MAX_VALUE;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  48 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  53 */     String path = dir + "mzm.gsp.grc.confbean.SInviteFriendsConsts.xml";
/*     */     try
/*     */     {
/*  56 */       SAXReader reader = new SAXReader();
/*  57 */       org.dom4j.Document doc = reader.read(new File(path));
/*  58 */       Element root = doc.getRootElement();
/*  59 */       Map<String, Element> data = new java.util.HashMap();
/*  60 */       java.util.List<?> nodeList = root.elements();
/*  61 */       int len = nodeList.size();
/*  62 */       for (int i = 0; i < len; i++)
/*     */       {
/*  64 */         Element element = (Element)nodeList.get(i);
/*  65 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  68 */           String name = element.attributeValue("name");
/*  69 */           if (data.put(name, element) != null)
/*  70 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  73 */       this.OPEN_NEED_ROLE_LEVEL = Integer.valueOf(((Element)data.get("OPEN_NEED_ROLE_LEVEL")).attributeValue("value")).intValue();
/*  74 */       this.INVITER_MIN_ROLE_LEVEL = Integer.valueOf(((Element)data.get("INVITER_MIN_ROLE_LEVEL")).attributeValue("value")).intValue();
/*  75 */       this.AWARD_INVITER_NEED_INVITEE_ROLE_LEVEL = Integer.valueOf(((Element)data.get("AWARD_INVITER_NEED_INVITEE_ROLE_LEVEL")).attributeValue("value")).intValue();
/*  76 */       this.AWARD_INVITER_INVITEE_USER_CREATE_MAX_DAYS = Integer.valueOf(((Element)data.get("AWARD_INVITER_INVITEE_USER_CREATE_MAX_DAYS")).attributeValue("value")).intValue();
/*  77 */       this.AWARD_INVITER_INVITEE_DONE_SHIMEN_TOTAL_DAYS = Integer.valueOf(((Element)data.get("AWARD_INVITER_INVITEE_DONE_SHIMEN_TOTAL_DAYS")).attributeValue("value")).intValue();
/*  78 */       this.AWARD_INVITER_INVITEE_DONE_SHIMEN_RING_NUM = Integer.valueOf(((Element)data.get("AWARD_INVITER_INVITEE_DONE_SHIMEN_RING_NUM")).attributeValue("value")).intValue();
/*  79 */       this.AWARD_INVITER_GIFT_MAX_TIMES = Integer.valueOf(((Element)data.get("AWARD_INVITER_GIFT_MAX_TIMES")).attributeValue("value")).intValue();
/*  80 */       this.AWARD_INVITER_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_INVITER_CFG_ID")).attributeValue("value")).intValue();
/*  81 */       this.AWARD_INVITEE_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_INVITEE_CFG_ID")).attributeValue("value")).intValue();
/*  82 */       this.AWARD_INVITEE_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_INVITEE_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  83 */       this.PRESENT_BIND_YUANBAO_DAYS_ON_INVITEE_CASH = Integer.valueOf(((Element)data.get("PRESENT_BIND_YUANBAO_DAYS_ON_INVITEE_CASH")).attributeValue("value")).intValue();
/*  84 */       this.PRESENT_BIND_YUANBAO_RATIO_ON_INVITEE_CASH = Integer.valueOf(((Element)data.get("PRESENT_BIND_YUANBAO_RATIO_ON_INVITEE_CASH")).attributeValue("value")).intValue();
/*  85 */       this.WITHDRAW_BIND_YUANBAO_DAILY_MAX_NUM = Integer.valueOf(((Element)data.get("WITHDRAW_BIND_YUANBAO_DAILY_MAX_NUM")).attributeValue("value")).intValue();
/*  86 */       this.INVITEE_PRESENT_BIND_YUANBAO_MAX_NUM = Integer.valueOf(((Element)data.get("INVITEE_PRESENT_BIND_YUANBAO_MAX_NUM")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  90 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  95 */     String path = dir + "mzm.gsp.grc.confbean.SInviteFriendsConsts.xml";
/*     */     try
/*     */     {
/*  98 */       SAXReader reader = new SAXReader();
/*  99 */       org.dom4j.Document doc = reader.read(new File(path));
/* 100 */       Element root = doc.getRootElement();
/* 101 */       Map<String, Element> data = new java.util.HashMap();
/* 102 */       java.util.List<?> nodeList = root.elements();
/* 103 */       int len = nodeList.size();
/* 104 */       for (int i = 0; i < len; i++)
/*     */       {
/* 106 */         Element element = (Element)nodeList.get(i);
/* 107 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 110 */           String name = element.attributeValue("name");
/* 111 */           if (data.put(name, element) != null)
/* 112 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 115 */       this.OPEN_NEED_ROLE_LEVEL = Integer.valueOf(((Element)data.get("OPEN_NEED_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 116 */       this.INVITER_MIN_ROLE_LEVEL = Integer.valueOf(((Element)data.get("INVITER_MIN_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 117 */       this.AWARD_INVITER_NEED_INVITEE_ROLE_LEVEL = Integer.valueOf(((Element)data.get("AWARD_INVITER_NEED_INVITEE_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 118 */       this.AWARD_INVITER_INVITEE_USER_CREATE_MAX_DAYS = Integer.valueOf(((Element)data.get("AWARD_INVITER_INVITEE_USER_CREATE_MAX_DAYS")).attributeValue("value")).intValue();
/* 119 */       this.AWARD_INVITER_INVITEE_DONE_SHIMEN_TOTAL_DAYS = Integer.valueOf(((Element)data.get("AWARD_INVITER_INVITEE_DONE_SHIMEN_TOTAL_DAYS")).attributeValue("value")).intValue();
/* 120 */       this.AWARD_INVITER_INVITEE_DONE_SHIMEN_RING_NUM = Integer.valueOf(((Element)data.get("AWARD_INVITER_INVITEE_DONE_SHIMEN_RING_NUM")).attributeValue("value")).intValue();
/* 121 */       this.AWARD_INVITER_GIFT_MAX_TIMES = Integer.valueOf(((Element)data.get("AWARD_INVITER_GIFT_MAX_TIMES")).attributeValue("value")).intValue();
/* 122 */       this.AWARD_INVITER_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_INVITER_CFG_ID")).attributeValue("value")).intValue();
/* 123 */       this.AWARD_INVITEE_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_INVITEE_CFG_ID")).attributeValue("value")).intValue();
/* 124 */       this.AWARD_INVITEE_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_INVITEE_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 125 */       this.PRESENT_BIND_YUANBAO_DAYS_ON_INVITEE_CASH = Integer.valueOf(((Element)data.get("PRESENT_BIND_YUANBAO_DAYS_ON_INVITEE_CASH")).attributeValue("value")).intValue();
/* 126 */       this.PRESENT_BIND_YUANBAO_RATIO_ON_INVITEE_CASH = Integer.valueOf(((Element)data.get("PRESENT_BIND_YUANBAO_RATIO_ON_INVITEE_CASH")).attributeValue("value")).intValue();
/* 127 */       this.WITHDRAW_BIND_YUANBAO_DAILY_MAX_NUM = Integer.valueOf(((Element)data.get("WITHDRAW_BIND_YUANBAO_DAILY_MAX_NUM")).attributeValue("value")).intValue();
/* 128 */       this.INVITEE_PRESENT_BIND_YUANBAO_MAX_NUM = Integer.valueOf(((Element)data.get("INVITEE_PRESENT_BIND_YUANBAO_MAX_NUM")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 136 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 139 */     String path = dir + "mzm.gsp.grc.confbean.SInviteFriendsConsts.bny";
/*     */     try
/*     */     {
/* 142 */       File file = new File(path);
/* 143 */       if (file.exists())
/*     */       {
/* 145 */         byte[] bytes = new byte['Ѐ'];
/* 146 */         FileInputStream fis = new FileInputStream(file);
/* 147 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 148 */         int len = 0;
/* 149 */         while ((len = fis.read(bytes)) > 0)
/* 150 */           baos.write(bytes, 0, len);
/* 151 */         fis.close();
/* 152 */         bytes = baos.toByteArray();
/* 153 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 154 */         this.OPEN_NEED_ROLE_LEVEL = _os_.unmarshal_int();
/* 155 */         this.INVITER_MIN_ROLE_LEVEL = _os_.unmarshal_int();
/* 156 */         this.AWARD_INVITER_NEED_INVITEE_ROLE_LEVEL = _os_.unmarshal_int();
/* 157 */         this.AWARD_INVITER_INVITEE_USER_CREATE_MAX_DAYS = _os_.unmarshal_int();
/* 158 */         this.AWARD_INVITER_INVITEE_DONE_SHIMEN_TOTAL_DAYS = _os_.unmarshal_int();
/* 159 */         this.AWARD_INVITER_INVITEE_DONE_SHIMEN_RING_NUM = _os_.unmarshal_int();
/* 160 */         this.AWARD_INVITER_GIFT_MAX_TIMES = _os_.unmarshal_int();
/* 161 */         this.AWARD_INVITER_CFG_ID = _os_.unmarshal_int();
/* 162 */         this.AWARD_INVITEE_CFG_ID = _os_.unmarshal_int();
/* 163 */         this.AWARD_INVITEE_MAIL_CFG_ID = _os_.unmarshal_int();
/* 164 */         this.PRESENT_BIND_YUANBAO_DAYS_ON_INVITEE_CASH = _os_.unmarshal_int();
/* 165 */         this.PRESENT_BIND_YUANBAO_RATIO_ON_INVITEE_CASH = _os_.unmarshal_int();
/* 166 */         this.WITHDRAW_BIND_YUANBAO_DAILY_MAX_NUM = _os_.unmarshal_int();
/* 167 */         this.INVITEE_PRESENT_BIND_YUANBAO_MAX_NUM = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.grc.confbean.SInviteFriendsConsts.bny";
/*     */     try
/*     */     {
/* 181 */       File file = new File(path);
/* 182 */       if (file.exists())
/*     */       {
/* 184 */         byte[] bytes = new byte['Ѐ'];
/* 185 */         FileInputStream fis = new FileInputStream(file);
/* 186 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 187 */         int len = 0;
/* 188 */         while ((len = fis.read(bytes)) > 0)
/* 189 */           baos.write(bytes, 0, len);
/* 190 */         fis.close();
/* 191 */         bytes = baos.toByteArray();
/* 192 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 193 */         this.OPEN_NEED_ROLE_LEVEL = _os_.unmarshal_int();
/* 194 */         this.INVITER_MIN_ROLE_LEVEL = _os_.unmarshal_int();
/* 195 */         this.AWARD_INVITER_NEED_INVITEE_ROLE_LEVEL = _os_.unmarshal_int();
/* 196 */         this.AWARD_INVITER_INVITEE_USER_CREATE_MAX_DAYS = _os_.unmarshal_int();
/* 197 */         this.AWARD_INVITER_INVITEE_DONE_SHIMEN_TOTAL_DAYS = _os_.unmarshal_int();
/* 198 */         this.AWARD_INVITER_INVITEE_DONE_SHIMEN_RING_NUM = _os_.unmarshal_int();
/* 199 */         this.AWARD_INVITER_GIFT_MAX_TIMES = _os_.unmarshal_int();
/* 200 */         this.AWARD_INVITER_CFG_ID = _os_.unmarshal_int();
/* 201 */         this.AWARD_INVITEE_CFG_ID = _os_.unmarshal_int();
/* 202 */         this.AWARD_INVITEE_MAIL_CFG_ID = _os_.unmarshal_int();
/* 203 */         this.PRESENT_BIND_YUANBAO_DAYS_ON_INVITEE_CASH = _os_.unmarshal_int();
/* 204 */         this.PRESENT_BIND_YUANBAO_RATIO_ON_INVITEE_CASH = _os_.unmarshal_int();
/* 205 */         this.WITHDRAW_BIND_YUANBAO_DAILY_MAX_NUM = _os_.unmarshal_int();
/* 206 */         this.INVITEE_PRESENT_BIND_YUANBAO_MAX_NUM = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SInviteFriendsConsts newInstance)
/*     */   {
/* 217 */     oldInstance = instance;
/* 218 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 223 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\confbean\SInviteFriendsConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */