/*     */ package mzm.gsp.question.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class KeJuQuestionConsts
/*     */ {
/*  13 */   private static volatile KeJuQuestionConsts oldInstance = null;
/*     */   
/*  15 */   private static KeJuQuestionConsts instance = new KeJuQuestionConsts();
/*     */   public int ACTIVITY_ID;
/*     */   public int XIANGSHI_NPC_ID;
/*     */   public int HUISHI_NPC_ID;
/*     */   public int DIANSHI_NPC_ID;
/*     */   public int NOTIFY_COUNTDOWN_MINUTE;
/*     */   
/*     */   public static KeJuQuestionConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static KeJuQuestionConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int DIANSHI_ROLE_NUM;
/*     */   
/*     */   public int JINSHI_MIN_MINGCI;
/*     */   
/*     */   public int HUISHI_NEED_RIGHTANSWER_NUM;
/*     */   
/*     */   public int HUISHI_WRONG_ANSWER_ADD_SECNOD;
/*     */   
/*     */   public int DIANSHI_WRONG_ANSWER_DECREASE_SECOND;
/*     */   
/*     */   public int DIANSHI_TOTOAL_NEED_SECOND;
/*     */   public int XIANGSHI_PERSIST_MINUTE;
/*     */   public int HUISHI_PERSIST_MINUTE;
/*     */   public int HUISHI_REST_MINUTE;
/*     */   public int DIANSHI_SERVICE_PERSIST_SECOND;
/*     */   public int DIANSHI_PERSIST_MINUTE;
/*     */   public int DIANSHI_ENTER_MAIL_ID;
/*     */   public int ZHUANGYUAN_MAIL_ID;
/*     */   public int BANGYAN_MAIL_ID;
/*     */   public int TANHUA_MAIL_ID;
/*     */   public int JINSHI_MAIL_ID;
/*     */   public int XIANGSHI_QUESTION_NUM;
/*     */   public int HUIGSHI_QUESTION_NUM;
/*     */   public int DIANSHI_QUESTION_NUM;
/*     */   public int DIANSHI_NEW_QUESTION_NUM;
/*     */   public int XIANGSHI_RIGHT_AWARD;
/*     */   public int XIANGSHI_WRONG_AWARD;
/*     */   public int HUISHI_RIGHT_AWARD;
/*     */   public int HUISHI_WRONG_AWARD;
/*     */   public int DIANSHI_RIGHT_AWARD;
/*     */   public int DIANSHI_WRONG_AWARD;
/*     */   public int XIANGSHI_TIPS;
/*     */   public int HUISHI_TIPS;
/*     */   public int DIANSHI_TIPS;
/*     */   public int DIANSHI_MAP_ID;
/*     */   public int DIANSHI_ENTER_NPC_ID;
/*     */   public int XIANGSHI_NPC_CONTROLLER_ID;
/*     */   public int HUISHI_NPC_CONTROLLER_ID;
/*     */   public int DIANSHI_NPC_CONTROLLER_ID;
/*     */   public int EXP_REWARD_ID;
/*     */   public int AWARD_INTERVAL;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  75 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  80 */     String path = dir + "mzm.gsp.question.confbean.KeJuQuestionConsts.xml";
/*     */     try
/*     */     {
/*  83 */       SAXReader reader = new SAXReader();
/*  84 */       org.dom4j.Document doc = reader.read(new File(path));
/*  85 */       Element root = doc.getRootElement();
/*  86 */       Map<String, Element> data = new java.util.HashMap();
/*  87 */       java.util.List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element element = (Element)nodeList.get(i);
/*  92 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  95 */           String name = element.attributeValue("name");
/*  96 */           if (data.put(name, element) != null)
/*  97 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 100 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/* 101 */       this.XIANGSHI_NPC_ID = Integer.valueOf(((Element)data.get("XIANGSHI_NPC_ID")).attributeValue("value")).intValue();
/* 102 */       this.HUISHI_NPC_ID = Integer.valueOf(((Element)data.get("HUISHI_NPC_ID")).attributeValue("value")).intValue();
/* 103 */       this.DIANSHI_NPC_ID = Integer.valueOf(((Element)data.get("DIANSHI_NPC_ID")).attributeValue("value")).intValue();
/* 104 */       this.NOTIFY_COUNTDOWN_MINUTE = Integer.valueOf(((Element)data.get("NOTIFY_COUNTDOWN_MINUTE")).attributeValue("value")).intValue();
/* 105 */       this.DIANSHI_ROLE_NUM = Integer.valueOf(((Element)data.get("DIANSHI_ROLE_NUM")).attributeValue("value")).intValue();
/* 106 */       this.JINSHI_MIN_MINGCI = Integer.valueOf(((Element)data.get("JINSHI_MIN_MINGCI")).attributeValue("value")).intValue();
/* 107 */       this.HUISHI_NEED_RIGHTANSWER_NUM = Integer.valueOf(((Element)data.get("HUISHI_NEED_RIGHTANSWER_NUM")).attributeValue("value")).intValue();
/* 108 */       this.HUISHI_WRONG_ANSWER_ADD_SECNOD = Integer.valueOf(((Element)data.get("HUISHI_WRONG_ANSWER_ADD_SECNOD")).attributeValue("value")).intValue();
/* 109 */       this.DIANSHI_WRONG_ANSWER_DECREASE_SECOND = Integer.valueOf(((Element)data.get("DIANSHI_WRONG_ANSWER_DECREASE_SECOND")).attributeValue("value")).intValue();
/* 110 */       this.DIANSHI_TOTOAL_NEED_SECOND = Integer.valueOf(((Element)data.get("DIANSHI_TOTOAL_NEED_SECOND")).attributeValue("value")).intValue();
/* 111 */       this.XIANGSHI_PERSIST_MINUTE = Integer.valueOf(((Element)data.get("XIANGSHI_PERSIST_MINUTE")).attributeValue("value")).intValue();
/* 112 */       this.HUISHI_PERSIST_MINUTE = Integer.valueOf(((Element)data.get("HUISHI_PERSIST_MINUTE")).attributeValue("value")).intValue();
/* 113 */       this.HUISHI_REST_MINUTE = Integer.valueOf(((Element)data.get("HUISHI_REST_MINUTE")).attributeValue("value")).intValue();
/* 114 */       this.DIANSHI_SERVICE_PERSIST_SECOND = Integer.valueOf(((Element)data.get("DIANSHI_SERVICE_PERSIST_SECOND")).attributeValue("value")).intValue();
/* 115 */       this.DIANSHI_PERSIST_MINUTE = Integer.valueOf(((Element)data.get("DIANSHI_PERSIST_MINUTE")).attributeValue("value")).intValue();
/* 116 */       this.DIANSHI_ENTER_MAIL_ID = Integer.valueOf(((Element)data.get("DIANSHI_ENTER_MAIL_ID")).attributeValue("value")).intValue();
/* 117 */       this.ZHUANGYUAN_MAIL_ID = Integer.valueOf(((Element)data.get("ZHUANGYUAN_MAIL_ID")).attributeValue("value")).intValue();
/* 118 */       this.BANGYAN_MAIL_ID = Integer.valueOf(((Element)data.get("BANGYAN_MAIL_ID")).attributeValue("value")).intValue();
/* 119 */       this.TANHUA_MAIL_ID = Integer.valueOf(((Element)data.get("TANHUA_MAIL_ID")).attributeValue("value")).intValue();
/* 120 */       this.JINSHI_MAIL_ID = Integer.valueOf(((Element)data.get("JINSHI_MAIL_ID")).attributeValue("value")).intValue();
/* 121 */       this.XIANGSHI_QUESTION_NUM = Integer.valueOf(((Element)data.get("XIANGSHI_QUESTION_NUM")).attributeValue("value")).intValue();
/* 122 */       this.HUIGSHI_QUESTION_NUM = Integer.valueOf(((Element)data.get("HUIGSHI_QUESTION_NUM")).attributeValue("value")).intValue();
/* 123 */       this.DIANSHI_QUESTION_NUM = Integer.valueOf(((Element)data.get("DIANSHI_QUESTION_NUM")).attributeValue("value")).intValue();
/* 124 */       this.DIANSHI_NEW_QUESTION_NUM = Integer.valueOf(((Element)data.get("DIANSHI_NEW_QUESTION_NUM")).attributeValue("value")).intValue();
/* 125 */       this.XIANGSHI_RIGHT_AWARD = Integer.valueOf(((Element)data.get("XIANGSHI_RIGHT_AWARD")).attributeValue("value")).intValue();
/* 126 */       this.XIANGSHI_WRONG_AWARD = Integer.valueOf(((Element)data.get("XIANGSHI_WRONG_AWARD")).attributeValue("value")).intValue();
/* 127 */       this.HUISHI_RIGHT_AWARD = Integer.valueOf(((Element)data.get("HUISHI_RIGHT_AWARD")).attributeValue("value")).intValue();
/* 128 */       this.HUISHI_WRONG_AWARD = Integer.valueOf(((Element)data.get("HUISHI_WRONG_AWARD")).attributeValue("value")).intValue();
/* 129 */       this.DIANSHI_RIGHT_AWARD = Integer.valueOf(((Element)data.get("DIANSHI_RIGHT_AWARD")).attributeValue("value")).intValue();
/* 130 */       this.DIANSHI_WRONG_AWARD = Integer.valueOf(((Element)data.get("DIANSHI_WRONG_AWARD")).attributeValue("value")).intValue();
/* 131 */       this.XIANGSHI_TIPS = Integer.valueOf(((Element)data.get("XIANGSHI_TIPS")).attributeValue("value")).intValue();
/* 132 */       this.HUISHI_TIPS = Integer.valueOf(((Element)data.get("HUISHI_TIPS")).attributeValue("value")).intValue();
/* 133 */       this.DIANSHI_TIPS = Integer.valueOf(((Element)data.get("DIANSHI_TIPS")).attributeValue("value")).intValue();
/* 134 */       this.DIANSHI_MAP_ID = Integer.valueOf(((Element)data.get("DIANSHI_MAP_ID")).attributeValue("value")).intValue();
/* 135 */       this.DIANSHI_ENTER_NPC_ID = Integer.valueOf(((Element)data.get("DIANSHI_ENTER_NPC_ID")).attributeValue("value")).intValue();
/* 136 */       this.XIANGSHI_NPC_CONTROLLER_ID = Integer.valueOf(((Element)data.get("XIANGSHI_NPC_CONTROLLER_ID")).attributeValue("value")).intValue();
/* 137 */       this.HUISHI_NPC_CONTROLLER_ID = Integer.valueOf(((Element)data.get("HUISHI_NPC_CONTROLLER_ID")).attributeValue("value")).intValue();
/* 138 */       this.DIANSHI_NPC_CONTROLLER_ID = Integer.valueOf(((Element)data.get("DIANSHI_NPC_CONTROLLER_ID")).attributeValue("value")).intValue();
/* 139 */       this.EXP_REWARD_ID = Integer.valueOf(((Element)data.get("EXP_REWARD_ID")).attributeValue("value")).intValue();
/* 140 */       this.AWARD_INTERVAL = Integer.valueOf(((Element)data.get("AWARD_INTERVAL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 149 */     String path = dir + "mzm.gsp.question.confbean.KeJuQuestionConsts.xml";
/*     */     try
/*     */     {
/* 152 */       SAXReader reader = new SAXReader();
/* 153 */       org.dom4j.Document doc = reader.read(new File(path));
/* 154 */       Element root = doc.getRootElement();
/* 155 */       Map<String, Element> data = new java.util.HashMap();
/* 156 */       java.util.List<?> nodeList = root.elements();
/* 157 */       int len = nodeList.size();
/* 158 */       for (int i = 0; i < len; i++)
/*     */       {
/* 160 */         Element element = (Element)nodeList.get(i);
/* 161 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 164 */           String name = element.attributeValue("name");
/* 165 */           if (data.put(name, element) != null)
/* 166 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 169 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/* 170 */       this.XIANGSHI_NPC_ID = Integer.valueOf(((Element)data.get("XIANGSHI_NPC_ID")).attributeValue("value")).intValue();
/* 171 */       this.HUISHI_NPC_ID = Integer.valueOf(((Element)data.get("HUISHI_NPC_ID")).attributeValue("value")).intValue();
/* 172 */       this.DIANSHI_NPC_ID = Integer.valueOf(((Element)data.get("DIANSHI_NPC_ID")).attributeValue("value")).intValue();
/* 173 */       this.NOTIFY_COUNTDOWN_MINUTE = Integer.valueOf(((Element)data.get("NOTIFY_COUNTDOWN_MINUTE")).attributeValue("value")).intValue();
/* 174 */       this.DIANSHI_ROLE_NUM = Integer.valueOf(((Element)data.get("DIANSHI_ROLE_NUM")).attributeValue("value")).intValue();
/* 175 */       this.JINSHI_MIN_MINGCI = Integer.valueOf(((Element)data.get("JINSHI_MIN_MINGCI")).attributeValue("value")).intValue();
/* 176 */       this.HUISHI_NEED_RIGHTANSWER_NUM = Integer.valueOf(((Element)data.get("HUISHI_NEED_RIGHTANSWER_NUM")).attributeValue("value")).intValue();
/* 177 */       this.HUISHI_WRONG_ANSWER_ADD_SECNOD = Integer.valueOf(((Element)data.get("HUISHI_WRONG_ANSWER_ADD_SECNOD")).attributeValue("value")).intValue();
/* 178 */       this.DIANSHI_WRONG_ANSWER_DECREASE_SECOND = Integer.valueOf(((Element)data.get("DIANSHI_WRONG_ANSWER_DECREASE_SECOND")).attributeValue("value")).intValue();
/* 179 */       this.DIANSHI_TOTOAL_NEED_SECOND = Integer.valueOf(((Element)data.get("DIANSHI_TOTOAL_NEED_SECOND")).attributeValue("value")).intValue();
/* 180 */       this.XIANGSHI_PERSIST_MINUTE = Integer.valueOf(((Element)data.get("XIANGSHI_PERSIST_MINUTE")).attributeValue("value")).intValue();
/* 181 */       this.HUISHI_PERSIST_MINUTE = Integer.valueOf(((Element)data.get("HUISHI_PERSIST_MINUTE")).attributeValue("value")).intValue();
/* 182 */       this.HUISHI_REST_MINUTE = Integer.valueOf(((Element)data.get("HUISHI_REST_MINUTE")).attributeValue("value")).intValue();
/* 183 */       this.DIANSHI_SERVICE_PERSIST_SECOND = Integer.valueOf(((Element)data.get("DIANSHI_SERVICE_PERSIST_SECOND")).attributeValue("value")).intValue();
/* 184 */       this.DIANSHI_PERSIST_MINUTE = Integer.valueOf(((Element)data.get("DIANSHI_PERSIST_MINUTE")).attributeValue("value")).intValue();
/* 185 */       this.DIANSHI_ENTER_MAIL_ID = Integer.valueOf(((Element)data.get("DIANSHI_ENTER_MAIL_ID")).attributeValue("value")).intValue();
/* 186 */       this.ZHUANGYUAN_MAIL_ID = Integer.valueOf(((Element)data.get("ZHUANGYUAN_MAIL_ID")).attributeValue("value")).intValue();
/* 187 */       this.BANGYAN_MAIL_ID = Integer.valueOf(((Element)data.get("BANGYAN_MAIL_ID")).attributeValue("value")).intValue();
/* 188 */       this.TANHUA_MAIL_ID = Integer.valueOf(((Element)data.get("TANHUA_MAIL_ID")).attributeValue("value")).intValue();
/* 189 */       this.JINSHI_MAIL_ID = Integer.valueOf(((Element)data.get("JINSHI_MAIL_ID")).attributeValue("value")).intValue();
/* 190 */       this.XIANGSHI_QUESTION_NUM = Integer.valueOf(((Element)data.get("XIANGSHI_QUESTION_NUM")).attributeValue("value")).intValue();
/* 191 */       this.HUIGSHI_QUESTION_NUM = Integer.valueOf(((Element)data.get("HUIGSHI_QUESTION_NUM")).attributeValue("value")).intValue();
/* 192 */       this.DIANSHI_QUESTION_NUM = Integer.valueOf(((Element)data.get("DIANSHI_QUESTION_NUM")).attributeValue("value")).intValue();
/* 193 */       this.DIANSHI_NEW_QUESTION_NUM = Integer.valueOf(((Element)data.get("DIANSHI_NEW_QUESTION_NUM")).attributeValue("value")).intValue();
/* 194 */       this.XIANGSHI_RIGHT_AWARD = Integer.valueOf(((Element)data.get("XIANGSHI_RIGHT_AWARD")).attributeValue("value")).intValue();
/* 195 */       this.XIANGSHI_WRONG_AWARD = Integer.valueOf(((Element)data.get("XIANGSHI_WRONG_AWARD")).attributeValue("value")).intValue();
/* 196 */       this.HUISHI_RIGHT_AWARD = Integer.valueOf(((Element)data.get("HUISHI_RIGHT_AWARD")).attributeValue("value")).intValue();
/* 197 */       this.HUISHI_WRONG_AWARD = Integer.valueOf(((Element)data.get("HUISHI_WRONG_AWARD")).attributeValue("value")).intValue();
/* 198 */       this.DIANSHI_RIGHT_AWARD = Integer.valueOf(((Element)data.get("DIANSHI_RIGHT_AWARD")).attributeValue("value")).intValue();
/* 199 */       this.DIANSHI_WRONG_AWARD = Integer.valueOf(((Element)data.get("DIANSHI_WRONG_AWARD")).attributeValue("value")).intValue();
/* 200 */       this.XIANGSHI_TIPS = Integer.valueOf(((Element)data.get("XIANGSHI_TIPS")).attributeValue("value")).intValue();
/* 201 */       this.HUISHI_TIPS = Integer.valueOf(((Element)data.get("HUISHI_TIPS")).attributeValue("value")).intValue();
/* 202 */       this.DIANSHI_TIPS = Integer.valueOf(((Element)data.get("DIANSHI_TIPS")).attributeValue("value")).intValue();
/* 203 */       this.DIANSHI_MAP_ID = Integer.valueOf(((Element)data.get("DIANSHI_MAP_ID")).attributeValue("value")).intValue();
/* 204 */       this.DIANSHI_ENTER_NPC_ID = Integer.valueOf(((Element)data.get("DIANSHI_ENTER_NPC_ID")).attributeValue("value")).intValue();
/* 205 */       this.XIANGSHI_NPC_CONTROLLER_ID = Integer.valueOf(((Element)data.get("XIANGSHI_NPC_CONTROLLER_ID")).attributeValue("value")).intValue();
/* 206 */       this.HUISHI_NPC_CONTROLLER_ID = Integer.valueOf(((Element)data.get("HUISHI_NPC_CONTROLLER_ID")).attributeValue("value")).intValue();
/* 207 */       this.DIANSHI_NPC_CONTROLLER_ID = Integer.valueOf(((Element)data.get("DIANSHI_NPC_CONTROLLER_ID")).attributeValue("value")).intValue();
/* 208 */       this.EXP_REWARD_ID = Integer.valueOf(((Element)data.get("EXP_REWARD_ID")).attributeValue("value")).intValue();
/* 209 */       this.AWARD_INTERVAL = Integer.valueOf(((Element)data.get("AWARD_INTERVAL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 213 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 217 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 220 */     String path = dir + "mzm.gsp.question.confbean.KeJuQuestionConsts.bny";
/*     */     try
/*     */     {
/* 223 */       File file = new File(path);
/* 224 */       if (file.exists())
/*     */       {
/* 226 */         byte[] bytes = new byte['Ѐ'];
/* 227 */         FileInputStream fis = new FileInputStream(file);
/* 228 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 229 */         int len = 0;
/* 230 */         while ((len = fis.read(bytes)) > 0)
/* 231 */           baos.write(bytes, 0, len);
/* 232 */         fis.close();
/* 233 */         bytes = baos.toByteArray();
/* 234 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 235 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 236 */         this.XIANGSHI_NPC_ID = _os_.unmarshal_int();
/* 237 */         this.HUISHI_NPC_ID = _os_.unmarshal_int();
/* 238 */         this.DIANSHI_NPC_ID = _os_.unmarshal_int();
/* 239 */         this.NOTIFY_COUNTDOWN_MINUTE = _os_.unmarshal_int();
/* 240 */         this.DIANSHI_ROLE_NUM = _os_.unmarshal_int();
/* 241 */         this.JINSHI_MIN_MINGCI = _os_.unmarshal_int();
/* 242 */         this.HUISHI_NEED_RIGHTANSWER_NUM = _os_.unmarshal_int();
/* 243 */         this.HUISHI_WRONG_ANSWER_ADD_SECNOD = _os_.unmarshal_int();
/* 244 */         this.DIANSHI_WRONG_ANSWER_DECREASE_SECOND = _os_.unmarshal_int();
/* 245 */         this.DIANSHI_TOTOAL_NEED_SECOND = _os_.unmarshal_int();
/* 246 */         this.XIANGSHI_PERSIST_MINUTE = _os_.unmarshal_int();
/* 247 */         this.HUISHI_PERSIST_MINUTE = _os_.unmarshal_int();
/* 248 */         this.HUISHI_REST_MINUTE = _os_.unmarshal_int();
/* 249 */         this.DIANSHI_SERVICE_PERSIST_SECOND = _os_.unmarshal_int();
/* 250 */         this.DIANSHI_PERSIST_MINUTE = _os_.unmarshal_int();
/* 251 */         this.DIANSHI_ENTER_MAIL_ID = _os_.unmarshal_int();
/* 252 */         this.ZHUANGYUAN_MAIL_ID = _os_.unmarshal_int();
/* 253 */         this.BANGYAN_MAIL_ID = _os_.unmarshal_int();
/* 254 */         this.TANHUA_MAIL_ID = _os_.unmarshal_int();
/* 255 */         this.JINSHI_MAIL_ID = _os_.unmarshal_int();
/* 256 */         this.XIANGSHI_QUESTION_NUM = _os_.unmarshal_int();
/* 257 */         this.HUIGSHI_QUESTION_NUM = _os_.unmarshal_int();
/* 258 */         this.DIANSHI_QUESTION_NUM = _os_.unmarshal_int();
/* 259 */         this.DIANSHI_NEW_QUESTION_NUM = _os_.unmarshal_int();
/* 260 */         this.XIANGSHI_RIGHT_AWARD = _os_.unmarshal_int();
/* 261 */         this.XIANGSHI_WRONG_AWARD = _os_.unmarshal_int();
/* 262 */         this.HUISHI_RIGHT_AWARD = _os_.unmarshal_int();
/* 263 */         this.HUISHI_WRONG_AWARD = _os_.unmarshal_int();
/* 264 */         this.DIANSHI_RIGHT_AWARD = _os_.unmarshal_int();
/* 265 */         this.DIANSHI_WRONG_AWARD = _os_.unmarshal_int();
/* 266 */         this.XIANGSHI_TIPS = _os_.unmarshal_int();
/* 267 */         this.HUISHI_TIPS = _os_.unmarshal_int();
/* 268 */         this.DIANSHI_TIPS = _os_.unmarshal_int();
/* 269 */         this.DIANSHI_MAP_ID = _os_.unmarshal_int();
/* 270 */         this.DIANSHI_ENTER_NPC_ID = _os_.unmarshal_int();
/* 271 */         this.XIANGSHI_NPC_CONTROLLER_ID = _os_.unmarshal_int();
/* 272 */         this.HUISHI_NPC_CONTROLLER_ID = _os_.unmarshal_int();
/* 273 */         this.DIANSHI_NPC_CONTROLLER_ID = _os_.unmarshal_int();
/* 274 */         this.EXP_REWARD_ID = _os_.unmarshal_int();
/* 275 */         this.AWARD_INTERVAL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 280 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 286 */     String path = dir + "mzm.gsp.question.confbean.KeJuQuestionConsts.bny";
/*     */     try
/*     */     {
/* 289 */       File file = new File(path);
/* 290 */       if (file.exists())
/*     */       {
/* 292 */         byte[] bytes = new byte['Ѐ'];
/* 293 */         FileInputStream fis = new FileInputStream(file);
/* 294 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 295 */         int len = 0;
/* 296 */         while ((len = fis.read(bytes)) > 0)
/* 297 */           baos.write(bytes, 0, len);
/* 298 */         fis.close();
/* 299 */         bytes = baos.toByteArray();
/* 300 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 301 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 302 */         this.XIANGSHI_NPC_ID = _os_.unmarshal_int();
/* 303 */         this.HUISHI_NPC_ID = _os_.unmarshal_int();
/* 304 */         this.DIANSHI_NPC_ID = _os_.unmarshal_int();
/* 305 */         this.NOTIFY_COUNTDOWN_MINUTE = _os_.unmarshal_int();
/* 306 */         this.DIANSHI_ROLE_NUM = _os_.unmarshal_int();
/* 307 */         this.JINSHI_MIN_MINGCI = _os_.unmarshal_int();
/* 308 */         this.HUISHI_NEED_RIGHTANSWER_NUM = _os_.unmarshal_int();
/* 309 */         this.HUISHI_WRONG_ANSWER_ADD_SECNOD = _os_.unmarshal_int();
/* 310 */         this.DIANSHI_WRONG_ANSWER_DECREASE_SECOND = _os_.unmarshal_int();
/* 311 */         this.DIANSHI_TOTOAL_NEED_SECOND = _os_.unmarshal_int();
/* 312 */         this.XIANGSHI_PERSIST_MINUTE = _os_.unmarshal_int();
/* 313 */         this.HUISHI_PERSIST_MINUTE = _os_.unmarshal_int();
/* 314 */         this.HUISHI_REST_MINUTE = _os_.unmarshal_int();
/* 315 */         this.DIANSHI_SERVICE_PERSIST_SECOND = _os_.unmarshal_int();
/* 316 */         this.DIANSHI_PERSIST_MINUTE = _os_.unmarshal_int();
/* 317 */         this.DIANSHI_ENTER_MAIL_ID = _os_.unmarshal_int();
/* 318 */         this.ZHUANGYUAN_MAIL_ID = _os_.unmarshal_int();
/* 319 */         this.BANGYAN_MAIL_ID = _os_.unmarshal_int();
/* 320 */         this.TANHUA_MAIL_ID = _os_.unmarshal_int();
/* 321 */         this.JINSHI_MAIL_ID = _os_.unmarshal_int();
/* 322 */         this.XIANGSHI_QUESTION_NUM = _os_.unmarshal_int();
/* 323 */         this.HUIGSHI_QUESTION_NUM = _os_.unmarshal_int();
/* 324 */         this.DIANSHI_QUESTION_NUM = _os_.unmarshal_int();
/* 325 */         this.DIANSHI_NEW_QUESTION_NUM = _os_.unmarshal_int();
/* 326 */         this.XIANGSHI_RIGHT_AWARD = _os_.unmarshal_int();
/* 327 */         this.XIANGSHI_WRONG_AWARD = _os_.unmarshal_int();
/* 328 */         this.HUISHI_RIGHT_AWARD = _os_.unmarshal_int();
/* 329 */         this.HUISHI_WRONG_AWARD = _os_.unmarshal_int();
/* 330 */         this.DIANSHI_RIGHT_AWARD = _os_.unmarshal_int();
/* 331 */         this.DIANSHI_WRONG_AWARD = _os_.unmarshal_int();
/* 332 */         this.XIANGSHI_TIPS = _os_.unmarshal_int();
/* 333 */         this.HUISHI_TIPS = _os_.unmarshal_int();
/* 334 */         this.DIANSHI_TIPS = _os_.unmarshal_int();
/* 335 */         this.DIANSHI_MAP_ID = _os_.unmarshal_int();
/* 336 */         this.DIANSHI_ENTER_NPC_ID = _os_.unmarshal_int();
/* 337 */         this.XIANGSHI_NPC_CONTROLLER_ID = _os_.unmarshal_int();
/* 338 */         this.HUISHI_NPC_CONTROLLER_ID = _os_.unmarshal_int();
/* 339 */         this.DIANSHI_NPC_CONTROLLER_ID = _os_.unmarshal_int();
/* 340 */         this.EXP_REWARD_ID = _os_.unmarshal_int();
/* 341 */         this.AWARD_INTERVAL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 346 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(KeJuQuestionConsts newInstance)
/*     */   {
/* 352 */     oldInstance = instance;
/* 353 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 358 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\confbean\KeJuQuestionConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */