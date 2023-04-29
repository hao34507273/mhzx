/*     */ package mzm.gsp.title.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SwornConsts
/*     */ {
/*  13 */   private static volatile SwornConsts oldInstance = null;
/*     */   
/*  15 */   private static SwornConsts instance = new SwornConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SwornConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SwornConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int MIN_MEMBER_COUNT = 2;
/*  32 */   public int MAX_MEMBER_COUNT = 8;
/*  33 */   public int MIN_PLAYER_LV = 50;
/*  34 */   public int MIN_FRIEND_VALUE = 1000;
/*  35 */   public int SWORN_NEED_SILVER = 500000;
/*  36 */   public int SWORN_WAIT_TIME = 30;
/*  37 */   public int SET_TITLE_WAIT_TIME = 120;
/*  38 */   public int PAY_SILVER_WAIT_TIME = 30;
/*  39 */   public int NEW_MEMBER_VOTE_TIME = 24;
/*  40 */   public int MEMBER_EXIT_DEL_FRIEND_VALUE = 5000;
/*  41 */   public int KICK_OUT_DEL_FRIEND_VALUE = 5000;
/*  42 */   public int KICK_OUT_NEED_MEMBER_COUNT = 3;
/*  43 */   public int KICK_OUT_NEED_MEMBER_PER = 6000;
/*  44 */   public int KICK_OUT_NEED_SILVER = 200000;
/*  45 */   public int KICK_OUT_WAIT_TIME = 72;
/*  46 */   public int CHANGE_SWORNNAME_NEED_GOLD = 1000;
/*  47 */   public int CHANGE_SWORNNAME_NEED_MEMBER_PER = 10000;
/*  48 */   public int CHANGE_SWORNNAME_NEED_TIME = 300;
/*  49 */   public int CHANGE_SWORNNAME_VOTE_TIME = 24;
/*  50 */   public int CHANGE_TITLE_NEED_GOLD = 1000;
/*  51 */   public int NEW_MEMBER_VOTE_MAILID = 340000000;
/*  52 */   public int NEW_MEMBER_MAILID = 340000000;
/*  53 */   public int EXIT_SWORN_SUCCESS_MAILID = 340000000;
/*  54 */   public int KICK_OUT_SUCCESS_MAILID = 340000000;
/*  55 */   public int KICK_OUT_MEMBER_MAILID = 340000000;
/*  56 */   public int CHANGE_SWORNNAME_VOTE_MAILID = 340000000;
/*  57 */   public int SWORN_NPC_ID = 150111300;
/*  58 */   public int NEW_MEMBER_FAILED_MAILID = 340000000;
/*  59 */   public int KICK_OUT_VOTE_MAILID = 340000000;
/*  60 */   public int KICK_OUT_FAILED_MAILID = 340000000;
/*  61 */   public int CHANGE_SWORNNAME_SUCCESS_MAILID = 340000000;
/*  62 */   public int CHANGE_SWORNNAME_FAILED_MAILID = 340000000;
/*  63 */   public int SWORN_TITLE_CFGID = 490100001;
/*  64 */   public int SWORN_DESC_CFGID = 701605001;
/*  65 */   public int SWORN_BUFFER_CFGID = 701203120;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  69 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  74 */     String path = dir + "mzm.gsp.title.confbean.SwornConsts.xml";
/*     */     try
/*     */     {
/*  77 */       SAXReader reader = new SAXReader();
/*  78 */       org.dom4j.Document doc = reader.read(new File(path));
/*  79 */       Element root = doc.getRootElement();
/*  80 */       Map<String, Element> data = new java.util.HashMap();
/*  81 */       java.util.List<?> nodeList = root.elements();
/*  82 */       int len = nodeList.size();
/*  83 */       for (int i = 0; i < len; i++)
/*     */       {
/*  85 */         Element element = (Element)nodeList.get(i);
/*  86 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  89 */           String name = element.attributeValue("name");
/*  90 */           if (data.put(name, element) != null)
/*  91 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  94 */       this.MIN_MEMBER_COUNT = Integer.valueOf(((Element)data.get("MIN_MEMBER_COUNT")).attributeValue("value")).intValue();
/*  95 */       this.MAX_MEMBER_COUNT = Integer.valueOf(((Element)data.get("MAX_MEMBER_COUNT")).attributeValue("value")).intValue();
/*  96 */       this.MIN_PLAYER_LV = Integer.valueOf(((Element)data.get("MIN_PLAYER_LV")).attributeValue("value")).intValue();
/*  97 */       this.MIN_FRIEND_VALUE = Integer.valueOf(((Element)data.get("MIN_FRIEND_VALUE")).attributeValue("value")).intValue();
/*  98 */       this.SWORN_NEED_SILVER = Integer.valueOf(((Element)data.get("SWORN_NEED_SILVER")).attributeValue("value")).intValue();
/*  99 */       this.SWORN_WAIT_TIME = Integer.valueOf(((Element)data.get("SWORN_WAIT_TIME")).attributeValue("value")).intValue();
/* 100 */       this.SET_TITLE_WAIT_TIME = Integer.valueOf(((Element)data.get("SET_TITLE_WAIT_TIME")).attributeValue("value")).intValue();
/* 101 */       this.PAY_SILVER_WAIT_TIME = Integer.valueOf(((Element)data.get("PAY_SILVER_WAIT_TIME")).attributeValue("value")).intValue();
/* 102 */       this.NEW_MEMBER_VOTE_TIME = Integer.valueOf(((Element)data.get("NEW_MEMBER_VOTE_TIME")).attributeValue("value")).intValue();
/* 103 */       this.MEMBER_EXIT_DEL_FRIEND_VALUE = Integer.valueOf(((Element)data.get("MEMBER_EXIT_DEL_FRIEND_VALUE")).attributeValue("value")).intValue();
/* 104 */       this.KICK_OUT_DEL_FRIEND_VALUE = Integer.valueOf(((Element)data.get("KICK_OUT_DEL_FRIEND_VALUE")).attributeValue("value")).intValue();
/* 105 */       this.KICK_OUT_NEED_MEMBER_COUNT = Integer.valueOf(((Element)data.get("KICK_OUT_NEED_MEMBER_COUNT")).attributeValue("value")).intValue();
/* 106 */       this.KICK_OUT_NEED_MEMBER_PER = Integer.valueOf(((Element)data.get("KICK_OUT_NEED_MEMBER_PER")).attributeValue("value")).intValue();
/* 107 */       this.KICK_OUT_NEED_SILVER = Integer.valueOf(((Element)data.get("KICK_OUT_NEED_SILVER")).attributeValue("value")).intValue();
/* 108 */       this.KICK_OUT_WAIT_TIME = Integer.valueOf(((Element)data.get("KICK_OUT_WAIT_TIME")).attributeValue("value")).intValue();
/* 109 */       this.CHANGE_SWORNNAME_NEED_GOLD = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_NEED_GOLD")).attributeValue("value")).intValue();
/* 110 */       this.CHANGE_SWORNNAME_NEED_MEMBER_PER = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_NEED_MEMBER_PER")).attributeValue("value")).intValue();
/* 111 */       this.CHANGE_SWORNNAME_NEED_TIME = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_NEED_TIME")).attributeValue("value")).intValue();
/* 112 */       this.CHANGE_SWORNNAME_VOTE_TIME = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_VOTE_TIME")).attributeValue("value")).intValue();
/* 113 */       this.CHANGE_TITLE_NEED_GOLD = Integer.valueOf(((Element)data.get("CHANGE_TITLE_NEED_GOLD")).attributeValue("value")).intValue();
/* 114 */       this.NEW_MEMBER_VOTE_MAILID = Integer.valueOf(((Element)data.get("NEW_MEMBER_VOTE_MAILID")).attributeValue("value")).intValue();
/* 115 */       this.NEW_MEMBER_MAILID = Integer.valueOf(((Element)data.get("NEW_MEMBER_MAILID")).attributeValue("value")).intValue();
/* 116 */       this.EXIT_SWORN_SUCCESS_MAILID = Integer.valueOf(((Element)data.get("EXIT_SWORN_SUCCESS_MAILID")).attributeValue("value")).intValue();
/* 117 */       this.KICK_OUT_SUCCESS_MAILID = Integer.valueOf(((Element)data.get("KICK_OUT_SUCCESS_MAILID")).attributeValue("value")).intValue();
/* 118 */       this.KICK_OUT_MEMBER_MAILID = Integer.valueOf(((Element)data.get("KICK_OUT_MEMBER_MAILID")).attributeValue("value")).intValue();
/* 119 */       this.CHANGE_SWORNNAME_VOTE_MAILID = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_VOTE_MAILID")).attributeValue("value")).intValue();
/* 120 */       this.SWORN_NPC_ID = Integer.valueOf(((Element)data.get("SWORN_NPC_ID")).attributeValue("value")).intValue();
/* 121 */       this.NEW_MEMBER_FAILED_MAILID = Integer.valueOf(((Element)data.get("NEW_MEMBER_FAILED_MAILID")).attributeValue("value")).intValue();
/* 122 */       this.KICK_OUT_VOTE_MAILID = Integer.valueOf(((Element)data.get("KICK_OUT_VOTE_MAILID")).attributeValue("value")).intValue();
/* 123 */       this.KICK_OUT_FAILED_MAILID = Integer.valueOf(((Element)data.get("KICK_OUT_FAILED_MAILID")).attributeValue("value")).intValue();
/* 124 */       this.CHANGE_SWORNNAME_SUCCESS_MAILID = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_SUCCESS_MAILID")).attributeValue("value")).intValue();
/* 125 */       this.CHANGE_SWORNNAME_FAILED_MAILID = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_FAILED_MAILID")).attributeValue("value")).intValue();
/* 126 */       this.SWORN_TITLE_CFGID = Integer.valueOf(((Element)data.get("SWORN_TITLE_CFGID")).attributeValue("value")).intValue();
/* 127 */       this.SWORN_DESC_CFGID = Integer.valueOf(((Element)data.get("SWORN_DESC_CFGID")).attributeValue("value")).intValue();
/* 128 */       this.SWORN_BUFFER_CFGID = Integer.valueOf(((Element)data.get("SWORN_BUFFER_CFGID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 137 */     String path = dir + "mzm.gsp.title.confbean.SwornConsts.xml";
/*     */     try
/*     */     {
/* 140 */       SAXReader reader = new SAXReader();
/* 141 */       org.dom4j.Document doc = reader.read(new File(path));
/* 142 */       Element root = doc.getRootElement();
/* 143 */       Map<String, Element> data = new java.util.HashMap();
/* 144 */       java.util.List<?> nodeList = root.elements();
/* 145 */       int len = nodeList.size();
/* 146 */       for (int i = 0; i < len; i++)
/*     */       {
/* 148 */         Element element = (Element)nodeList.get(i);
/* 149 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 152 */           String name = element.attributeValue("name");
/* 153 */           if (data.put(name, element) != null)
/* 154 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 157 */       this.MIN_MEMBER_COUNT = Integer.valueOf(((Element)data.get("MIN_MEMBER_COUNT")).attributeValue("value")).intValue();
/* 158 */       this.MAX_MEMBER_COUNT = Integer.valueOf(((Element)data.get("MAX_MEMBER_COUNT")).attributeValue("value")).intValue();
/* 159 */       this.MIN_PLAYER_LV = Integer.valueOf(((Element)data.get("MIN_PLAYER_LV")).attributeValue("value")).intValue();
/* 160 */       this.MIN_FRIEND_VALUE = Integer.valueOf(((Element)data.get("MIN_FRIEND_VALUE")).attributeValue("value")).intValue();
/* 161 */       this.SWORN_NEED_SILVER = Integer.valueOf(((Element)data.get("SWORN_NEED_SILVER")).attributeValue("value")).intValue();
/* 162 */       this.SWORN_WAIT_TIME = Integer.valueOf(((Element)data.get("SWORN_WAIT_TIME")).attributeValue("value")).intValue();
/* 163 */       this.SET_TITLE_WAIT_TIME = Integer.valueOf(((Element)data.get("SET_TITLE_WAIT_TIME")).attributeValue("value")).intValue();
/* 164 */       this.PAY_SILVER_WAIT_TIME = Integer.valueOf(((Element)data.get("PAY_SILVER_WAIT_TIME")).attributeValue("value")).intValue();
/* 165 */       this.NEW_MEMBER_VOTE_TIME = Integer.valueOf(((Element)data.get("NEW_MEMBER_VOTE_TIME")).attributeValue("value")).intValue();
/* 166 */       this.MEMBER_EXIT_DEL_FRIEND_VALUE = Integer.valueOf(((Element)data.get("MEMBER_EXIT_DEL_FRIEND_VALUE")).attributeValue("value")).intValue();
/* 167 */       this.KICK_OUT_DEL_FRIEND_VALUE = Integer.valueOf(((Element)data.get("KICK_OUT_DEL_FRIEND_VALUE")).attributeValue("value")).intValue();
/* 168 */       this.KICK_OUT_NEED_MEMBER_COUNT = Integer.valueOf(((Element)data.get("KICK_OUT_NEED_MEMBER_COUNT")).attributeValue("value")).intValue();
/* 169 */       this.KICK_OUT_NEED_MEMBER_PER = Integer.valueOf(((Element)data.get("KICK_OUT_NEED_MEMBER_PER")).attributeValue("value")).intValue();
/* 170 */       this.KICK_OUT_NEED_SILVER = Integer.valueOf(((Element)data.get("KICK_OUT_NEED_SILVER")).attributeValue("value")).intValue();
/* 171 */       this.KICK_OUT_WAIT_TIME = Integer.valueOf(((Element)data.get("KICK_OUT_WAIT_TIME")).attributeValue("value")).intValue();
/* 172 */       this.CHANGE_SWORNNAME_NEED_GOLD = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_NEED_GOLD")).attributeValue("value")).intValue();
/* 173 */       this.CHANGE_SWORNNAME_NEED_MEMBER_PER = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_NEED_MEMBER_PER")).attributeValue("value")).intValue();
/* 174 */       this.CHANGE_SWORNNAME_NEED_TIME = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_NEED_TIME")).attributeValue("value")).intValue();
/* 175 */       this.CHANGE_SWORNNAME_VOTE_TIME = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_VOTE_TIME")).attributeValue("value")).intValue();
/* 176 */       this.CHANGE_TITLE_NEED_GOLD = Integer.valueOf(((Element)data.get("CHANGE_TITLE_NEED_GOLD")).attributeValue("value")).intValue();
/* 177 */       this.NEW_MEMBER_VOTE_MAILID = Integer.valueOf(((Element)data.get("NEW_MEMBER_VOTE_MAILID")).attributeValue("value")).intValue();
/* 178 */       this.NEW_MEMBER_MAILID = Integer.valueOf(((Element)data.get("NEW_MEMBER_MAILID")).attributeValue("value")).intValue();
/* 179 */       this.EXIT_SWORN_SUCCESS_MAILID = Integer.valueOf(((Element)data.get("EXIT_SWORN_SUCCESS_MAILID")).attributeValue("value")).intValue();
/* 180 */       this.KICK_OUT_SUCCESS_MAILID = Integer.valueOf(((Element)data.get("KICK_OUT_SUCCESS_MAILID")).attributeValue("value")).intValue();
/* 181 */       this.KICK_OUT_MEMBER_MAILID = Integer.valueOf(((Element)data.get("KICK_OUT_MEMBER_MAILID")).attributeValue("value")).intValue();
/* 182 */       this.CHANGE_SWORNNAME_VOTE_MAILID = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_VOTE_MAILID")).attributeValue("value")).intValue();
/* 183 */       this.SWORN_NPC_ID = Integer.valueOf(((Element)data.get("SWORN_NPC_ID")).attributeValue("value")).intValue();
/* 184 */       this.NEW_MEMBER_FAILED_MAILID = Integer.valueOf(((Element)data.get("NEW_MEMBER_FAILED_MAILID")).attributeValue("value")).intValue();
/* 185 */       this.KICK_OUT_VOTE_MAILID = Integer.valueOf(((Element)data.get("KICK_OUT_VOTE_MAILID")).attributeValue("value")).intValue();
/* 186 */       this.KICK_OUT_FAILED_MAILID = Integer.valueOf(((Element)data.get("KICK_OUT_FAILED_MAILID")).attributeValue("value")).intValue();
/* 187 */       this.CHANGE_SWORNNAME_SUCCESS_MAILID = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_SUCCESS_MAILID")).attributeValue("value")).intValue();
/* 188 */       this.CHANGE_SWORNNAME_FAILED_MAILID = Integer.valueOf(((Element)data.get("CHANGE_SWORNNAME_FAILED_MAILID")).attributeValue("value")).intValue();
/* 189 */       this.SWORN_TITLE_CFGID = Integer.valueOf(((Element)data.get("SWORN_TITLE_CFGID")).attributeValue("value")).intValue();
/* 190 */       this.SWORN_DESC_CFGID = Integer.valueOf(((Element)data.get("SWORN_DESC_CFGID")).attributeValue("value")).intValue();
/* 191 */       this.SWORN_BUFFER_CFGID = Integer.valueOf(((Element)data.get("SWORN_BUFFER_CFGID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 195 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 199 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 202 */     String path = dir + "mzm.gsp.title.confbean.SwornConsts.bny";
/*     */     try
/*     */     {
/* 205 */       File file = new File(path);
/* 206 */       if (file.exists())
/*     */       {
/* 208 */         byte[] bytes = new byte['Ѐ'];
/* 209 */         FileInputStream fis = new FileInputStream(file);
/* 210 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 211 */         int len = 0;
/* 212 */         while ((len = fis.read(bytes)) > 0)
/* 213 */           baos.write(bytes, 0, len);
/* 214 */         fis.close();
/* 215 */         bytes = baos.toByteArray();
/* 216 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 217 */         this.MIN_MEMBER_COUNT = _os_.unmarshal_int();
/* 218 */         this.MAX_MEMBER_COUNT = _os_.unmarshal_int();
/* 219 */         this.MIN_PLAYER_LV = _os_.unmarshal_int();
/* 220 */         this.MIN_FRIEND_VALUE = _os_.unmarshal_int();
/* 221 */         this.SWORN_NEED_SILVER = _os_.unmarshal_int();
/* 222 */         this.SWORN_WAIT_TIME = _os_.unmarshal_int();
/* 223 */         this.SET_TITLE_WAIT_TIME = _os_.unmarshal_int();
/* 224 */         this.PAY_SILVER_WAIT_TIME = _os_.unmarshal_int();
/* 225 */         this.NEW_MEMBER_VOTE_TIME = _os_.unmarshal_int();
/* 226 */         this.MEMBER_EXIT_DEL_FRIEND_VALUE = _os_.unmarshal_int();
/* 227 */         this.KICK_OUT_DEL_FRIEND_VALUE = _os_.unmarshal_int();
/* 228 */         this.KICK_OUT_NEED_MEMBER_COUNT = _os_.unmarshal_int();
/* 229 */         this.KICK_OUT_NEED_MEMBER_PER = _os_.unmarshal_int();
/* 230 */         this.KICK_OUT_NEED_SILVER = _os_.unmarshal_int();
/* 231 */         this.KICK_OUT_WAIT_TIME = _os_.unmarshal_int();
/* 232 */         this.CHANGE_SWORNNAME_NEED_GOLD = _os_.unmarshal_int();
/* 233 */         this.CHANGE_SWORNNAME_NEED_MEMBER_PER = _os_.unmarshal_int();
/* 234 */         this.CHANGE_SWORNNAME_NEED_TIME = _os_.unmarshal_int();
/* 235 */         this.CHANGE_SWORNNAME_VOTE_TIME = _os_.unmarshal_int();
/* 236 */         this.CHANGE_TITLE_NEED_GOLD = _os_.unmarshal_int();
/* 237 */         this.NEW_MEMBER_VOTE_MAILID = _os_.unmarshal_int();
/* 238 */         this.NEW_MEMBER_MAILID = _os_.unmarshal_int();
/* 239 */         this.EXIT_SWORN_SUCCESS_MAILID = _os_.unmarshal_int();
/* 240 */         this.KICK_OUT_SUCCESS_MAILID = _os_.unmarshal_int();
/* 241 */         this.KICK_OUT_MEMBER_MAILID = _os_.unmarshal_int();
/* 242 */         this.CHANGE_SWORNNAME_VOTE_MAILID = _os_.unmarshal_int();
/* 243 */         this.SWORN_NPC_ID = _os_.unmarshal_int();
/* 244 */         this.NEW_MEMBER_FAILED_MAILID = _os_.unmarshal_int();
/* 245 */         this.KICK_OUT_VOTE_MAILID = _os_.unmarshal_int();
/* 246 */         this.KICK_OUT_FAILED_MAILID = _os_.unmarshal_int();
/* 247 */         this.CHANGE_SWORNNAME_SUCCESS_MAILID = _os_.unmarshal_int();
/* 248 */         this.CHANGE_SWORNNAME_FAILED_MAILID = _os_.unmarshal_int();
/* 249 */         this.SWORN_TITLE_CFGID = _os_.unmarshal_int();
/* 250 */         this.SWORN_DESC_CFGID = _os_.unmarshal_int();
/* 251 */         this.SWORN_BUFFER_CFGID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 262 */     String path = dir + "mzm.gsp.title.confbean.SwornConsts.bny";
/*     */     try
/*     */     {
/* 265 */       File file = new File(path);
/* 266 */       if (file.exists())
/*     */       {
/* 268 */         byte[] bytes = new byte['Ѐ'];
/* 269 */         FileInputStream fis = new FileInputStream(file);
/* 270 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 271 */         int len = 0;
/* 272 */         while ((len = fis.read(bytes)) > 0)
/* 273 */           baos.write(bytes, 0, len);
/* 274 */         fis.close();
/* 275 */         bytes = baos.toByteArray();
/* 276 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 277 */         this.MIN_MEMBER_COUNT = _os_.unmarshal_int();
/* 278 */         this.MAX_MEMBER_COUNT = _os_.unmarshal_int();
/* 279 */         this.MIN_PLAYER_LV = _os_.unmarshal_int();
/* 280 */         this.MIN_FRIEND_VALUE = _os_.unmarshal_int();
/* 281 */         this.SWORN_NEED_SILVER = _os_.unmarshal_int();
/* 282 */         this.SWORN_WAIT_TIME = _os_.unmarshal_int();
/* 283 */         this.SET_TITLE_WAIT_TIME = _os_.unmarshal_int();
/* 284 */         this.PAY_SILVER_WAIT_TIME = _os_.unmarshal_int();
/* 285 */         this.NEW_MEMBER_VOTE_TIME = _os_.unmarshal_int();
/* 286 */         this.MEMBER_EXIT_DEL_FRIEND_VALUE = _os_.unmarshal_int();
/* 287 */         this.KICK_OUT_DEL_FRIEND_VALUE = _os_.unmarshal_int();
/* 288 */         this.KICK_OUT_NEED_MEMBER_COUNT = _os_.unmarshal_int();
/* 289 */         this.KICK_OUT_NEED_MEMBER_PER = _os_.unmarshal_int();
/* 290 */         this.KICK_OUT_NEED_SILVER = _os_.unmarshal_int();
/* 291 */         this.KICK_OUT_WAIT_TIME = _os_.unmarshal_int();
/* 292 */         this.CHANGE_SWORNNAME_NEED_GOLD = _os_.unmarshal_int();
/* 293 */         this.CHANGE_SWORNNAME_NEED_MEMBER_PER = _os_.unmarshal_int();
/* 294 */         this.CHANGE_SWORNNAME_NEED_TIME = _os_.unmarshal_int();
/* 295 */         this.CHANGE_SWORNNAME_VOTE_TIME = _os_.unmarshal_int();
/* 296 */         this.CHANGE_TITLE_NEED_GOLD = _os_.unmarshal_int();
/* 297 */         this.NEW_MEMBER_VOTE_MAILID = _os_.unmarshal_int();
/* 298 */         this.NEW_MEMBER_MAILID = _os_.unmarshal_int();
/* 299 */         this.EXIT_SWORN_SUCCESS_MAILID = _os_.unmarshal_int();
/* 300 */         this.KICK_OUT_SUCCESS_MAILID = _os_.unmarshal_int();
/* 301 */         this.KICK_OUT_MEMBER_MAILID = _os_.unmarshal_int();
/* 302 */         this.CHANGE_SWORNNAME_VOTE_MAILID = _os_.unmarshal_int();
/* 303 */         this.SWORN_NPC_ID = _os_.unmarshal_int();
/* 304 */         this.NEW_MEMBER_FAILED_MAILID = _os_.unmarshal_int();
/* 305 */         this.KICK_OUT_VOTE_MAILID = _os_.unmarshal_int();
/* 306 */         this.KICK_OUT_FAILED_MAILID = _os_.unmarshal_int();
/* 307 */         this.CHANGE_SWORNNAME_SUCCESS_MAILID = _os_.unmarshal_int();
/* 308 */         this.CHANGE_SWORNNAME_FAILED_MAILID = _os_.unmarshal_int();
/* 309 */         this.SWORN_TITLE_CFGID = _os_.unmarshal_int();
/* 310 */         this.SWORN_DESC_CFGID = _os_.unmarshal_int();
/* 311 */         this.SWORN_BUFFER_CFGID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 316 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SwornConsts newInstance)
/*     */   {
/* 322 */     oldInstance = instance;
/* 323 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 328 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\confbean\SwornConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */