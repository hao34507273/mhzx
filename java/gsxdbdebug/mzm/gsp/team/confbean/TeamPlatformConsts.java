/*     */ package mzm.gsp.team.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class TeamPlatformConsts
/*     */ {
/*  13 */   private static volatile TeamPlatformConsts oldInstance = null;
/*     */   
/*  15 */   private static TeamPlatformConsts instance = new TeamPlatformConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TeamPlatformConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static TeamPlatformConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int SLECET_NEW__LEVEL = 30;
/*  32 */   public int SLECET_NEW__CHANGE_LEVEL = 0;
/*  33 */   public int TEAM_SHOW__NUM = 5;
/*  34 */   public int LEVEL_LITTLE_FLOOR = -5;
/*  35 */   public int LEVEL_LITTLE_TOP = 5;
/*  36 */   public int LEVEL_BIG_FLOOR = -10;
/*  37 */   public int LEVEL_BIG_TOP = 10;
/*  38 */   public int ACTIV_COUNT = 5;
/*  39 */   public int IGNORE_OCCUPATION_SEC = 30;
/*  40 */   public int EXPAND_LEVEL_SEC = 10;
/*  41 */   public int HINT_BE_LEADER_SEC = 30;
/*  42 */   public int HINT_ROLE_REIN_SEC = 300;
/*  43 */   public int HINT_LEADER_REIN_SEC = 300;
/*  44 */   public int MSG_IN_SEC = 10;
/*  45 */   public int LET_GO_SEC = 600;
/*  46 */   public int BE_NORMAL_SEC = 30;
/*  47 */   public int NEW_GUY_SERVER_LEVEL_LOW = 5;
/*  48 */   public int ZHEN_YAO_MATCH_ID = 341900001;
/*  49 */   public int MATCH_INTERVAL = 3;
/*  50 */   public int NEW_GUY_LEVEL__DIFF = 10;
/*  51 */   public int BRO_2_ALL__BAN_INTERVAL = 10;
/*  52 */   public int EASY_BRO_TIME_INTERVAL = 30;
/*  53 */   public int EASY_BRO_VIGOUR_COST = 10;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  57 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  62 */     String path = dir + "mzm.gsp.team.confbean.TeamPlatformConsts.xml";
/*     */     try
/*     */     {
/*  65 */       SAXReader reader = new SAXReader();
/*  66 */       org.dom4j.Document doc = reader.read(new File(path));
/*  67 */       Element root = doc.getRootElement();
/*  68 */       Map<String, Element> data = new java.util.HashMap();
/*  69 */       java.util.List<?> nodeList = root.elements();
/*  70 */       int len = nodeList.size();
/*  71 */       for (int i = 0; i < len; i++)
/*     */       {
/*  73 */         Element element = (Element)nodeList.get(i);
/*  74 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  77 */           String name = element.attributeValue("name");
/*  78 */           if (data.put(name, element) != null)
/*  79 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  82 */       this.SLECET_NEW__LEVEL = Integer.valueOf(((Element)data.get("SLECET_NEW__LEVEL")).attributeValue("value")).intValue();
/*  83 */       this.SLECET_NEW__CHANGE_LEVEL = Integer.valueOf(((Element)data.get("SLECET_NEW__CHANGE_LEVEL")).attributeValue("value")).intValue();
/*  84 */       this.TEAM_SHOW__NUM = Integer.valueOf(((Element)data.get("TEAM_SHOW__NUM")).attributeValue("value")).intValue();
/*  85 */       this.LEVEL_LITTLE_FLOOR = Integer.valueOf(((Element)data.get("LEVEL_LITTLE_FLOOR")).attributeValue("value")).intValue();
/*  86 */       this.LEVEL_LITTLE_TOP = Integer.valueOf(((Element)data.get("LEVEL_LITTLE_TOP")).attributeValue("value")).intValue();
/*  87 */       this.LEVEL_BIG_FLOOR = Integer.valueOf(((Element)data.get("LEVEL_BIG_FLOOR")).attributeValue("value")).intValue();
/*  88 */       this.LEVEL_BIG_TOP = Integer.valueOf(((Element)data.get("LEVEL_BIG_TOP")).attributeValue("value")).intValue();
/*  89 */       this.ACTIV_COUNT = Integer.valueOf(((Element)data.get("ACTIV_COUNT")).attributeValue("value")).intValue();
/*  90 */       this.IGNORE_OCCUPATION_SEC = Integer.valueOf(((Element)data.get("IGNORE_OCCUPATION_SEC")).attributeValue("value")).intValue();
/*  91 */       this.EXPAND_LEVEL_SEC = Integer.valueOf(((Element)data.get("EXPAND_LEVEL_SEC")).attributeValue("value")).intValue();
/*  92 */       this.HINT_BE_LEADER_SEC = Integer.valueOf(((Element)data.get("HINT_BE_LEADER_SEC")).attributeValue("value")).intValue();
/*  93 */       this.HINT_ROLE_REIN_SEC = Integer.valueOf(((Element)data.get("HINT_ROLE_REIN_SEC")).attributeValue("value")).intValue();
/*  94 */       this.HINT_LEADER_REIN_SEC = Integer.valueOf(((Element)data.get("HINT_LEADER_REIN_SEC")).attributeValue("value")).intValue();
/*  95 */       this.MSG_IN_SEC = Integer.valueOf(((Element)data.get("MSG_IN_SEC")).attributeValue("value")).intValue();
/*  96 */       this.LET_GO_SEC = Integer.valueOf(((Element)data.get("LET_GO_SEC")).attributeValue("value")).intValue();
/*  97 */       this.BE_NORMAL_SEC = Integer.valueOf(((Element)data.get("BE_NORMAL_SEC")).attributeValue("value")).intValue();
/*  98 */       this.NEW_GUY_SERVER_LEVEL_LOW = Integer.valueOf(((Element)data.get("NEW_GUY_SERVER_LEVEL_LOW")).attributeValue("value")).intValue();
/*  99 */       this.ZHEN_YAO_MATCH_ID = Integer.valueOf(((Element)data.get("ZHEN_YAO_MATCH_ID")).attributeValue("value")).intValue();
/* 100 */       this.MATCH_INTERVAL = Integer.valueOf(((Element)data.get("MATCH_INTERVAL")).attributeValue("value")).intValue();
/* 101 */       this.NEW_GUY_LEVEL__DIFF = Integer.valueOf(((Element)data.get("NEW_GUY_LEVEL__DIFF")).attributeValue("value")).intValue();
/* 102 */       this.BRO_2_ALL__BAN_INTERVAL = Integer.valueOf(((Element)data.get("BRO_2_ALL__BAN_INTERVAL")).attributeValue("value")).intValue();
/* 103 */       this.EASY_BRO_TIME_INTERVAL = Integer.valueOf(((Element)data.get("EASY_BRO_TIME_INTERVAL")).attributeValue("value")).intValue();
/* 104 */       this.EASY_BRO_VIGOUR_COST = Integer.valueOf(((Element)data.get("EASY_BRO_VIGOUR_COST")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 113 */     String path = dir + "mzm.gsp.team.confbean.TeamPlatformConsts.xml";
/*     */     try
/*     */     {
/* 116 */       SAXReader reader = new SAXReader();
/* 117 */       org.dom4j.Document doc = reader.read(new File(path));
/* 118 */       Element root = doc.getRootElement();
/* 119 */       Map<String, Element> data = new java.util.HashMap();
/* 120 */       java.util.List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element element = (Element)nodeList.get(i);
/* 125 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 128 */           String name = element.attributeValue("name");
/* 129 */           if (data.put(name, element) != null)
/* 130 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 133 */       this.SLECET_NEW__LEVEL = Integer.valueOf(((Element)data.get("SLECET_NEW__LEVEL")).attributeValue("value")).intValue();
/* 134 */       this.SLECET_NEW__CHANGE_LEVEL = Integer.valueOf(((Element)data.get("SLECET_NEW__CHANGE_LEVEL")).attributeValue("value")).intValue();
/* 135 */       this.TEAM_SHOW__NUM = Integer.valueOf(((Element)data.get("TEAM_SHOW__NUM")).attributeValue("value")).intValue();
/* 136 */       this.LEVEL_LITTLE_FLOOR = Integer.valueOf(((Element)data.get("LEVEL_LITTLE_FLOOR")).attributeValue("value")).intValue();
/* 137 */       this.LEVEL_LITTLE_TOP = Integer.valueOf(((Element)data.get("LEVEL_LITTLE_TOP")).attributeValue("value")).intValue();
/* 138 */       this.LEVEL_BIG_FLOOR = Integer.valueOf(((Element)data.get("LEVEL_BIG_FLOOR")).attributeValue("value")).intValue();
/* 139 */       this.LEVEL_BIG_TOP = Integer.valueOf(((Element)data.get("LEVEL_BIG_TOP")).attributeValue("value")).intValue();
/* 140 */       this.ACTIV_COUNT = Integer.valueOf(((Element)data.get("ACTIV_COUNT")).attributeValue("value")).intValue();
/* 141 */       this.IGNORE_OCCUPATION_SEC = Integer.valueOf(((Element)data.get("IGNORE_OCCUPATION_SEC")).attributeValue("value")).intValue();
/* 142 */       this.EXPAND_LEVEL_SEC = Integer.valueOf(((Element)data.get("EXPAND_LEVEL_SEC")).attributeValue("value")).intValue();
/* 143 */       this.HINT_BE_LEADER_SEC = Integer.valueOf(((Element)data.get("HINT_BE_LEADER_SEC")).attributeValue("value")).intValue();
/* 144 */       this.HINT_ROLE_REIN_SEC = Integer.valueOf(((Element)data.get("HINT_ROLE_REIN_SEC")).attributeValue("value")).intValue();
/* 145 */       this.HINT_LEADER_REIN_SEC = Integer.valueOf(((Element)data.get("HINT_LEADER_REIN_SEC")).attributeValue("value")).intValue();
/* 146 */       this.MSG_IN_SEC = Integer.valueOf(((Element)data.get("MSG_IN_SEC")).attributeValue("value")).intValue();
/* 147 */       this.LET_GO_SEC = Integer.valueOf(((Element)data.get("LET_GO_SEC")).attributeValue("value")).intValue();
/* 148 */       this.BE_NORMAL_SEC = Integer.valueOf(((Element)data.get("BE_NORMAL_SEC")).attributeValue("value")).intValue();
/* 149 */       this.NEW_GUY_SERVER_LEVEL_LOW = Integer.valueOf(((Element)data.get("NEW_GUY_SERVER_LEVEL_LOW")).attributeValue("value")).intValue();
/* 150 */       this.ZHEN_YAO_MATCH_ID = Integer.valueOf(((Element)data.get("ZHEN_YAO_MATCH_ID")).attributeValue("value")).intValue();
/* 151 */       this.MATCH_INTERVAL = Integer.valueOf(((Element)data.get("MATCH_INTERVAL")).attributeValue("value")).intValue();
/* 152 */       this.NEW_GUY_LEVEL__DIFF = Integer.valueOf(((Element)data.get("NEW_GUY_LEVEL__DIFF")).attributeValue("value")).intValue();
/* 153 */       this.BRO_2_ALL__BAN_INTERVAL = Integer.valueOf(((Element)data.get("BRO_2_ALL__BAN_INTERVAL")).attributeValue("value")).intValue();
/* 154 */       this.EASY_BRO_TIME_INTERVAL = Integer.valueOf(((Element)data.get("EASY_BRO_TIME_INTERVAL")).attributeValue("value")).intValue();
/* 155 */       this.EASY_BRO_VIGOUR_COST = Integer.valueOf(((Element)data.get("EASY_BRO_VIGOUR_COST")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 159 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 163 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 166 */     String path = dir + "mzm.gsp.team.confbean.TeamPlatformConsts.bny";
/*     */     try
/*     */     {
/* 169 */       File file = new File(path);
/* 170 */       if (file.exists())
/*     */       {
/* 172 */         byte[] bytes = new byte['Ѐ'];
/* 173 */         FileInputStream fis = new FileInputStream(file);
/* 174 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 175 */         int len = 0;
/* 176 */         while ((len = fis.read(bytes)) > 0)
/* 177 */           baos.write(bytes, 0, len);
/* 178 */         fis.close();
/* 179 */         bytes = baos.toByteArray();
/* 180 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 181 */         this.SLECET_NEW__LEVEL = _os_.unmarshal_int();
/* 182 */         this.SLECET_NEW__CHANGE_LEVEL = _os_.unmarshal_int();
/* 183 */         this.TEAM_SHOW__NUM = _os_.unmarshal_int();
/* 184 */         this.LEVEL_LITTLE_FLOOR = _os_.unmarshal_int();
/* 185 */         this.LEVEL_LITTLE_TOP = _os_.unmarshal_int();
/* 186 */         this.LEVEL_BIG_FLOOR = _os_.unmarshal_int();
/* 187 */         this.LEVEL_BIG_TOP = _os_.unmarshal_int();
/* 188 */         this.ACTIV_COUNT = _os_.unmarshal_int();
/* 189 */         this.IGNORE_OCCUPATION_SEC = _os_.unmarshal_int();
/* 190 */         this.EXPAND_LEVEL_SEC = _os_.unmarshal_int();
/* 191 */         this.HINT_BE_LEADER_SEC = _os_.unmarshal_int();
/* 192 */         this.HINT_ROLE_REIN_SEC = _os_.unmarshal_int();
/* 193 */         this.HINT_LEADER_REIN_SEC = _os_.unmarshal_int();
/* 194 */         this.MSG_IN_SEC = _os_.unmarshal_int();
/* 195 */         this.LET_GO_SEC = _os_.unmarshal_int();
/* 196 */         this.BE_NORMAL_SEC = _os_.unmarshal_int();
/* 197 */         this.NEW_GUY_SERVER_LEVEL_LOW = _os_.unmarshal_int();
/* 198 */         this.ZHEN_YAO_MATCH_ID = _os_.unmarshal_int();
/* 199 */         this.MATCH_INTERVAL = _os_.unmarshal_int();
/* 200 */         this.NEW_GUY_LEVEL__DIFF = _os_.unmarshal_int();
/* 201 */         this.BRO_2_ALL__BAN_INTERVAL = _os_.unmarshal_int();
/* 202 */         this.EASY_BRO_TIME_INTERVAL = _os_.unmarshal_int();
/* 203 */         this.EASY_BRO_VIGOUR_COST = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 214 */     String path = dir + "mzm.gsp.team.confbean.TeamPlatformConsts.bny";
/*     */     try
/*     */     {
/* 217 */       File file = new File(path);
/* 218 */       if (file.exists())
/*     */       {
/* 220 */         byte[] bytes = new byte['Ѐ'];
/* 221 */         FileInputStream fis = new FileInputStream(file);
/* 222 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 223 */         int len = 0;
/* 224 */         while ((len = fis.read(bytes)) > 0)
/* 225 */           baos.write(bytes, 0, len);
/* 226 */         fis.close();
/* 227 */         bytes = baos.toByteArray();
/* 228 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 229 */         this.SLECET_NEW__LEVEL = _os_.unmarshal_int();
/* 230 */         this.SLECET_NEW__CHANGE_LEVEL = _os_.unmarshal_int();
/* 231 */         this.TEAM_SHOW__NUM = _os_.unmarshal_int();
/* 232 */         this.LEVEL_LITTLE_FLOOR = _os_.unmarshal_int();
/* 233 */         this.LEVEL_LITTLE_TOP = _os_.unmarshal_int();
/* 234 */         this.LEVEL_BIG_FLOOR = _os_.unmarshal_int();
/* 235 */         this.LEVEL_BIG_TOP = _os_.unmarshal_int();
/* 236 */         this.ACTIV_COUNT = _os_.unmarshal_int();
/* 237 */         this.IGNORE_OCCUPATION_SEC = _os_.unmarshal_int();
/* 238 */         this.EXPAND_LEVEL_SEC = _os_.unmarshal_int();
/* 239 */         this.HINT_BE_LEADER_SEC = _os_.unmarshal_int();
/* 240 */         this.HINT_ROLE_REIN_SEC = _os_.unmarshal_int();
/* 241 */         this.HINT_LEADER_REIN_SEC = _os_.unmarshal_int();
/* 242 */         this.MSG_IN_SEC = _os_.unmarshal_int();
/* 243 */         this.LET_GO_SEC = _os_.unmarshal_int();
/* 244 */         this.BE_NORMAL_SEC = _os_.unmarshal_int();
/* 245 */         this.NEW_GUY_SERVER_LEVEL_LOW = _os_.unmarshal_int();
/* 246 */         this.ZHEN_YAO_MATCH_ID = _os_.unmarshal_int();
/* 247 */         this.MATCH_INTERVAL = _os_.unmarshal_int();
/* 248 */         this.NEW_GUY_LEVEL__DIFF = _os_.unmarshal_int();
/* 249 */         this.BRO_2_ALL__BAN_INTERVAL = _os_.unmarshal_int();
/* 250 */         this.EASY_BRO_TIME_INTERVAL = _os_.unmarshal_int();
/* 251 */         this.EASY_BRO_VIGOUR_COST = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(TeamPlatformConsts newInstance)
/*     */   {
/* 262 */     oldInstance = instance;
/* 263 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 268 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\confbean\TeamPlatformConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */