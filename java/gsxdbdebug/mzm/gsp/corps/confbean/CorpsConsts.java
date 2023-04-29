/*     */ package mzm.gsp.corps.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class CorpsConsts
/*     */ {
/*  13 */   private static volatile CorpsConsts oldInstance = null;
/*     */   
/*  15 */   private static CorpsConsts instance = new CorpsConsts();
/*     */   public int NPC_ID;
/*     */   public int SERVICE_ID;
/*     */   public int OPEN_CORPS_SERVICE_ID;
/*     */   public int CAPACITY;
/*     */   public int SAFE_CAPACITY;
/*     */   public int MIN_GUY_NUM;
/*     */   
/*  23 */   public static CorpsConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static CorpsConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int MIN_LEVEL;
/*     */   
/*     */   public int CORPS_NAME_MAX_LENGTH;
/*     */   
/*     */   public int CORPS_NAME_MIN_LENGTH;
/*     */   
/*     */   public int CORPS_DECLARATION_MAX_LENGTH;
/*     */   
/*     */   public int CORPS_DECLARATION_MIN_LENGTH;
/*     */   
/*     */   public int CREATE_CORPS_COST_GOLD_NUM;
/*     */   
/*     */   public int CORPS_APPELLATION_ID;
/*     */   public int INVITE_INTERVAL;
/*     */   public int CREATE_CONFIRM_INTERVAL;
/*     */   public int HISTORY_MAX;
/*     */   public int RENAME_CORPS_COST_GOLD_NUM;
/*     */   public int REPLACE_BADGE_COST_GOLD_NUM;
/*     */   public int CREATE_MAIL_ID;
/*     */   public int NEW_JOIN_TO_ORG_MEMBER_MAIL_ID;
/*     */   public int NEW_JOIN_TO_NEW_MEMBER_MAIL_ID;
/*     */   public int CHANGE_LEADER_TO_MEMBER_MAIL_ID;
/*     */   public int CHANGE_LEADER_TO_NEW_LEADER_MAIL_ID;
/*     */   public int FIRE_TO_MEMBER_MAIL_ID;
/*     */   public int FIRE_TO_ACCUSED_MAIL_ID;
/*     */   public int ACTIVE_LEAVE_TO_MEMBERS_MAIL_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  60 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  65 */     String path = dir + "mzm.gsp.corps.confbean.CorpsConsts.xml";
/*     */     try
/*     */     {
/*  68 */       SAXReader reader = new SAXReader();
/*  69 */       org.dom4j.Document doc = reader.read(new File(path));
/*  70 */       Element root = doc.getRootElement();
/*  71 */       Map<String, Element> data = new java.util.HashMap();
/*  72 */       java.util.List<?> nodeList = root.elements();
/*  73 */       int len = nodeList.size();
/*  74 */       for (int i = 0; i < len; i++)
/*     */       {
/*  76 */         Element element = (Element)nodeList.get(i);
/*  77 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  80 */           String name = element.attributeValue("name");
/*  81 */           if (data.put(name, element) != null)
/*  82 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  85 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  86 */       this.SERVICE_ID = Integer.valueOf(((Element)data.get("SERVICE_ID")).attributeValue("value")).intValue();
/*  87 */       this.OPEN_CORPS_SERVICE_ID = Integer.valueOf(((Element)data.get("OPEN_CORPS_SERVICE_ID")).attributeValue("value")).intValue();
/*  88 */       this.CAPACITY = Integer.valueOf(((Element)data.get("CAPACITY")).attributeValue("value")).intValue();
/*  89 */       this.SAFE_CAPACITY = Integer.valueOf(((Element)data.get("SAFE_CAPACITY")).attributeValue("value")).intValue();
/*  90 */       this.MIN_GUY_NUM = Integer.valueOf(((Element)data.get("MIN_GUY_NUM")).attributeValue("value")).intValue();
/*  91 */       this.MIN_LEVEL = Integer.valueOf(((Element)data.get("MIN_LEVEL")).attributeValue("value")).intValue();
/*  92 */       this.CORPS_NAME_MAX_LENGTH = Integer.valueOf(((Element)data.get("CORPS_NAME_MAX_LENGTH")).attributeValue("value")).intValue();
/*  93 */       this.CORPS_NAME_MIN_LENGTH = Integer.valueOf(((Element)data.get("CORPS_NAME_MIN_LENGTH")).attributeValue("value")).intValue();
/*  94 */       this.CORPS_DECLARATION_MAX_LENGTH = Integer.valueOf(((Element)data.get("CORPS_DECLARATION_MAX_LENGTH")).attributeValue("value")).intValue();
/*  95 */       this.CORPS_DECLARATION_MIN_LENGTH = Integer.valueOf(((Element)data.get("CORPS_DECLARATION_MIN_LENGTH")).attributeValue("value")).intValue();
/*  96 */       this.CREATE_CORPS_COST_GOLD_NUM = Integer.valueOf(((Element)data.get("CREATE_CORPS_COST_GOLD_NUM")).attributeValue("value")).intValue();
/*  97 */       this.CORPS_APPELLATION_ID = Integer.valueOf(((Element)data.get("CORPS_APPELLATION_ID")).attributeValue("value")).intValue();
/*  98 */       this.INVITE_INTERVAL = Integer.valueOf(((Element)data.get("INVITE_INTERVAL")).attributeValue("value")).intValue();
/*  99 */       this.CREATE_CONFIRM_INTERVAL = Integer.valueOf(((Element)data.get("CREATE_CONFIRM_INTERVAL")).attributeValue("value")).intValue();
/* 100 */       this.HISTORY_MAX = Integer.valueOf(((Element)data.get("HISTORY_MAX")).attributeValue("value")).intValue();
/* 101 */       this.RENAME_CORPS_COST_GOLD_NUM = Integer.valueOf(((Element)data.get("RENAME_CORPS_COST_GOLD_NUM")).attributeValue("value")).intValue();
/* 102 */       this.REPLACE_BADGE_COST_GOLD_NUM = Integer.valueOf(((Element)data.get("REPLACE_BADGE_COST_GOLD_NUM")).attributeValue("value")).intValue();
/* 103 */       this.CREATE_MAIL_ID = Integer.valueOf(((Element)data.get("CREATE_MAIL_ID")).attributeValue("value")).intValue();
/* 104 */       this.NEW_JOIN_TO_ORG_MEMBER_MAIL_ID = Integer.valueOf(((Element)data.get("NEW_JOIN_TO_ORG_MEMBER_MAIL_ID")).attributeValue("value")).intValue();
/* 105 */       this.NEW_JOIN_TO_NEW_MEMBER_MAIL_ID = Integer.valueOf(((Element)data.get("NEW_JOIN_TO_NEW_MEMBER_MAIL_ID")).attributeValue("value")).intValue();
/* 106 */       this.CHANGE_LEADER_TO_MEMBER_MAIL_ID = Integer.valueOf(((Element)data.get("CHANGE_LEADER_TO_MEMBER_MAIL_ID")).attributeValue("value")).intValue();
/* 107 */       this.CHANGE_LEADER_TO_NEW_LEADER_MAIL_ID = Integer.valueOf(((Element)data.get("CHANGE_LEADER_TO_NEW_LEADER_MAIL_ID")).attributeValue("value")).intValue();
/* 108 */       this.FIRE_TO_MEMBER_MAIL_ID = Integer.valueOf(((Element)data.get("FIRE_TO_MEMBER_MAIL_ID")).attributeValue("value")).intValue();
/* 109 */       this.FIRE_TO_ACCUSED_MAIL_ID = Integer.valueOf(((Element)data.get("FIRE_TO_ACCUSED_MAIL_ID")).attributeValue("value")).intValue();
/* 110 */       this.ACTIVE_LEAVE_TO_MEMBERS_MAIL_ID = Integer.valueOf(((Element)data.get("ACTIVE_LEAVE_TO_MEMBERS_MAIL_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 114 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 119 */     String path = dir + "mzm.gsp.corps.confbean.CorpsConsts.xml";
/*     */     try
/*     */     {
/* 122 */       SAXReader reader = new SAXReader();
/* 123 */       org.dom4j.Document doc = reader.read(new File(path));
/* 124 */       Element root = doc.getRootElement();
/* 125 */       Map<String, Element> data = new java.util.HashMap();
/* 126 */       java.util.List<?> nodeList = root.elements();
/* 127 */       int len = nodeList.size();
/* 128 */       for (int i = 0; i < len; i++)
/*     */       {
/* 130 */         Element element = (Element)nodeList.get(i);
/* 131 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 134 */           String name = element.attributeValue("name");
/* 135 */           if (data.put(name, element) != null)
/* 136 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 139 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 140 */       this.SERVICE_ID = Integer.valueOf(((Element)data.get("SERVICE_ID")).attributeValue("value")).intValue();
/* 141 */       this.OPEN_CORPS_SERVICE_ID = Integer.valueOf(((Element)data.get("OPEN_CORPS_SERVICE_ID")).attributeValue("value")).intValue();
/* 142 */       this.CAPACITY = Integer.valueOf(((Element)data.get("CAPACITY")).attributeValue("value")).intValue();
/* 143 */       this.SAFE_CAPACITY = Integer.valueOf(((Element)data.get("SAFE_CAPACITY")).attributeValue("value")).intValue();
/* 144 */       this.MIN_GUY_NUM = Integer.valueOf(((Element)data.get("MIN_GUY_NUM")).attributeValue("value")).intValue();
/* 145 */       this.MIN_LEVEL = Integer.valueOf(((Element)data.get("MIN_LEVEL")).attributeValue("value")).intValue();
/* 146 */       this.CORPS_NAME_MAX_LENGTH = Integer.valueOf(((Element)data.get("CORPS_NAME_MAX_LENGTH")).attributeValue("value")).intValue();
/* 147 */       this.CORPS_NAME_MIN_LENGTH = Integer.valueOf(((Element)data.get("CORPS_NAME_MIN_LENGTH")).attributeValue("value")).intValue();
/* 148 */       this.CORPS_DECLARATION_MAX_LENGTH = Integer.valueOf(((Element)data.get("CORPS_DECLARATION_MAX_LENGTH")).attributeValue("value")).intValue();
/* 149 */       this.CORPS_DECLARATION_MIN_LENGTH = Integer.valueOf(((Element)data.get("CORPS_DECLARATION_MIN_LENGTH")).attributeValue("value")).intValue();
/* 150 */       this.CREATE_CORPS_COST_GOLD_NUM = Integer.valueOf(((Element)data.get("CREATE_CORPS_COST_GOLD_NUM")).attributeValue("value")).intValue();
/* 151 */       this.CORPS_APPELLATION_ID = Integer.valueOf(((Element)data.get("CORPS_APPELLATION_ID")).attributeValue("value")).intValue();
/* 152 */       this.INVITE_INTERVAL = Integer.valueOf(((Element)data.get("INVITE_INTERVAL")).attributeValue("value")).intValue();
/* 153 */       this.CREATE_CONFIRM_INTERVAL = Integer.valueOf(((Element)data.get("CREATE_CONFIRM_INTERVAL")).attributeValue("value")).intValue();
/* 154 */       this.HISTORY_MAX = Integer.valueOf(((Element)data.get("HISTORY_MAX")).attributeValue("value")).intValue();
/* 155 */       this.RENAME_CORPS_COST_GOLD_NUM = Integer.valueOf(((Element)data.get("RENAME_CORPS_COST_GOLD_NUM")).attributeValue("value")).intValue();
/* 156 */       this.REPLACE_BADGE_COST_GOLD_NUM = Integer.valueOf(((Element)data.get("REPLACE_BADGE_COST_GOLD_NUM")).attributeValue("value")).intValue();
/* 157 */       this.CREATE_MAIL_ID = Integer.valueOf(((Element)data.get("CREATE_MAIL_ID")).attributeValue("value")).intValue();
/* 158 */       this.NEW_JOIN_TO_ORG_MEMBER_MAIL_ID = Integer.valueOf(((Element)data.get("NEW_JOIN_TO_ORG_MEMBER_MAIL_ID")).attributeValue("value")).intValue();
/* 159 */       this.NEW_JOIN_TO_NEW_MEMBER_MAIL_ID = Integer.valueOf(((Element)data.get("NEW_JOIN_TO_NEW_MEMBER_MAIL_ID")).attributeValue("value")).intValue();
/* 160 */       this.CHANGE_LEADER_TO_MEMBER_MAIL_ID = Integer.valueOf(((Element)data.get("CHANGE_LEADER_TO_MEMBER_MAIL_ID")).attributeValue("value")).intValue();
/* 161 */       this.CHANGE_LEADER_TO_NEW_LEADER_MAIL_ID = Integer.valueOf(((Element)data.get("CHANGE_LEADER_TO_NEW_LEADER_MAIL_ID")).attributeValue("value")).intValue();
/* 162 */       this.FIRE_TO_MEMBER_MAIL_ID = Integer.valueOf(((Element)data.get("FIRE_TO_MEMBER_MAIL_ID")).attributeValue("value")).intValue();
/* 163 */       this.FIRE_TO_ACCUSED_MAIL_ID = Integer.valueOf(((Element)data.get("FIRE_TO_ACCUSED_MAIL_ID")).attributeValue("value")).intValue();
/* 164 */       this.ACTIVE_LEAVE_TO_MEMBERS_MAIL_ID = Integer.valueOf(((Element)data.get("ACTIVE_LEAVE_TO_MEMBERS_MAIL_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 168 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 172 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 175 */     String path = dir + "mzm.gsp.corps.confbean.CorpsConsts.bny";
/*     */     try
/*     */     {
/* 178 */       File file = new File(path);
/* 179 */       if (file.exists())
/*     */       {
/* 181 */         byte[] bytes = new byte['Ѐ'];
/* 182 */         FileInputStream fis = new FileInputStream(file);
/* 183 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 184 */         int len = 0;
/* 185 */         while ((len = fis.read(bytes)) > 0)
/* 186 */           baos.write(bytes, 0, len);
/* 187 */         fis.close();
/* 188 */         bytes = baos.toByteArray();
/* 189 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 190 */         this.NPC_ID = _os_.unmarshal_int();
/* 191 */         this.SERVICE_ID = _os_.unmarshal_int();
/* 192 */         this.OPEN_CORPS_SERVICE_ID = _os_.unmarshal_int();
/* 193 */         this.CAPACITY = _os_.unmarshal_int();
/* 194 */         this.SAFE_CAPACITY = _os_.unmarshal_int();
/* 195 */         this.MIN_GUY_NUM = _os_.unmarshal_int();
/* 196 */         this.MIN_LEVEL = _os_.unmarshal_int();
/* 197 */         this.CORPS_NAME_MAX_LENGTH = _os_.unmarshal_int();
/* 198 */         this.CORPS_NAME_MIN_LENGTH = _os_.unmarshal_int();
/* 199 */         this.CORPS_DECLARATION_MAX_LENGTH = _os_.unmarshal_int();
/* 200 */         this.CORPS_DECLARATION_MIN_LENGTH = _os_.unmarshal_int();
/* 201 */         this.CREATE_CORPS_COST_GOLD_NUM = _os_.unmarshal_int();
/* 202 */         this.CORPS_APPELLATION_ID = _os_.unmarshal_int();
/* 203 */         this.INVITE_INTERVAL = _os_.unmarshal_int();
/* 204 */         this.CREATE_CONFIRM_INTERVAL = _os_.unmarshal_int();
/* 205 */         this.HISTORY_MAX = _os_.unmarshal_int();
/* 206 */         this.RENAME_CORPS_COST_GOLD_NUM = _os_.unmarshal_int();
/* 207 */         this.REPLACE_BADGE_COST_GOLD_NUM = _os_.unmarshal_int();
/* 208 */         this.CREATE_MAIL_ID = _os_.unmarshal_int();
/* 209 */         this.NEW_JOIN_TO_ORG_MEMBER_MAIL_ID = _os_.unmarshal_int();
/* 210 */         this.NEW_JOIN_TO_NEW_MEMBER_MAIL_ID = _os_.unmarshal_int();
/* 211 */         this.CHANGE_LEADER_TO_MEMBER_MAIL_ID = _os_.unmarshal_int();
/* 212 */         this.CHANGE_LEADER_TO_NEW_LEADER_MAIL_ID = _os_.unmarshal_int();
/* 213 */         this.FIRE_TO_MEMBER_MAIL_ID = _os_.unmarshal_int();
/* 214 */         this.FIRE_TO_ACCUSED_MAIL_ID = _os_.unmarshal_int();
/* 215 */         this.ACTIVE_LEAVE_TO_MEMBERS_MAIL_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 220 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 226 */     String path = dir + "mzm.gsp.corps.confbean.CorpsConsts.bny";
/*     */     try
/*     */     {
/* 229 */       File file = new File(path);
/* 230 */       if (file.exists())
/*     */       {
/* 232 */         byte[] bytes = new byte['Ѐ'];
/* 233 */         FileInputStream fis = new FileInputStream(file);
/* 234 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 235 */         int len = 0;
/* 236 */         while ((len = fis.read(bytes)) > 0)
/* 237 */           baos.write(bytes, 0, len);
/* 238 */         fis.close();
/* 239 */         bytes = baos.toByteArray();
/* 240 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 241 */         this.NPC_ID = _os_.unmarshal_int();
/* 242 */         this.SERVICE_ID = _os_.unmarshal_int();
/* 243 */         this.OPEN_CORPS_SERVICE_ID = _os_.unmarshal_int();
/* 244 */         this.CAPACITY = _os_.unmarshal_int();
/* 245 */         this.SAFE_CAPACITY = _os_.unmarshal_int();
/* 246 */         this.MIN_GUY_NUM = _os_.unmarshal_int();
/* 247 */         this.MIN_LEVEL = _os_.unmarshal_int();
/* 248 */         this.CORPS_NAME_MAX_LENGTH = _os_.unmarshal_int();
/* 249 */         this.CORPS_NAME_MIN_LENGTH = _os_.unmarshal_int();
/* 250 */         this.CORPS_DECLARATION_MAX_LENGTH = _os_.unmarshal_int();
/* 251 */         this.CORPS_DECLARATION_MIN_LENGTH = _os_.unmarshal_int();
/* 252 */         this.CREATE_CORPS_COST_GOLD_NUM = _os_.unmarshal_int();
/* 253 */         this.CORPS_APPELLATION_ID = _os_.unmarshal_int();
/* 254 */         this.INVITE_INTERVAL = _os_.unmarshal_int();
/* 255 */         this.CREATE_CONFIRM_INTERVAL = _os_.unmarshal_int();
/* 256 */         this.HISTORY_MAX = _os_.unmarshal_int();
/* 257 */         this.RENAME_CORPS_COST_GOLD_NUM = _os_.unmarshal_int();
/* 258 */         this.REPLACE_BADGE_COST_GOLD_NUM = _os_.unmarshal_int();
/* 259 */         this.CREATE_MAIL_ID = _os_.unmarshal_int();
/* 260 */         this.NEW_JOIN_TO_ORG_MEMBER_MAIL_ID = _os_.unmarshal_int();
/* 261 */         this.NEW_JOIN_TO_NEW_MEMBER_MAIL_ID = _os_.unmarshal_int();
/* 262 */         this.CHANGE_LEADER_TO_MEMBER_MAIL_ID = _os_.unmarshal_int();
/* 263 */         this.CHANGE_LEADER_TO_NEW_LEADER_MAIL_ID = _os_.unmarshal_int();
/* 264 */         this.FIRE_TO_MEMBER_MAIL_ID = _os_.unmarshal_int();
/* 265 */         this.FIRE_TO_ACCUSED_MAIL_ID = _os_.unmarshal_int();
/* 266 */         this.ACTIVE_LEAVE_TO_MEMBERS_MAIL_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 271 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(CorpsConsts newInstance)
/*     */   {
/* 277 */     oldInstance = instance;
/* 278 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 283 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\confbean\CorpsConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */