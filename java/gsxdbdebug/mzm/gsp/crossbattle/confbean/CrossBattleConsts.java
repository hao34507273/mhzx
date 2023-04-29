/*     */ package mzm.gsp.crossbattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class CrossBattleConsts
/*     */ {
/*  13 */   private static volatile CrossBattleConsts oldInstance = null;
/*     */   
/*  15 */   private static CrossBattleConsts instance = new CrossBattleConsts();
/*     */   public int CURRENT_ACTIVITY_CFG_ID;
/*     */   public int ENTER_ROUND_ROBIN_MAP_TEAM_MEMBER_NUM;
/*     */   public int CANVASS_COOLDOWN_TIME_IN_SECOND;
/*     */   public int REGISTER_SUCCESS_EFFECT_ID;
/*     */   public int ROUND_ROBIN_WIN_EFFECT_ID;
/*     */   
/*     */   public static CrossBattleConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static CrossBattleConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int ROUND_ROBIN_LOSE_EFFECT_ID;
/*     */   
/*     */   public int OWN_CORPS_TITLE_COLOR_ID;
/*     */   
/*     */   public int OTHER_CORPS_TITLE_COLOR_ID;
/*     */   
/*     */   public String cross_battle_session;
/*     */   
/*     */   public int cross_battle_session_num;
/*     */   
/*     */   public int cross_battle_selection_win_effect_id;
/*     */   public int cross_battle_selection_lose_effect_id;
/*     */   public int cross_battle_final_win_effect_id;
/*     */   public int cross_battle_final_lose_effect_id;
/*     */   public int cross_battle_match_wait_effect_id;
/*     */   public int cross_battle_register_tips;
/*     */   public int cross_battle_vote_tips;
/*     */   public int cross_battle_round_tips;
/*     */   public int cross_battle_divide_tips;
/*     */   public int cross_battle_point_tips;
/*     */   public int cross_battle_selection_tips;
/*     */   public int cross_battle_final_tips;
/*     */   public int DAILY_BET_TIMES_UPPER_LIMIT;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  57 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  62 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleConsts.xml";
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
/*  82 */       this.CURRENT_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("CURRENT_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  83 */       this.ENTER_ROUND_ROBIN_MAP_TEAM_MEMBER_NUM = Integer.valueOf(((Element)data.get("ENTER_ROUND_ROBIN_MAP_TEAM_MEMBER_NUM")).attributeValue("value")).intValue();
/*  84 */       this.CANVASS_COOLDOWN_TIME_IN_SECOND = Integer.valueOf(((Element)data.get("CANVASS_COOLDOWN_TIME_IN_SECOND")).attributeValue("value")).intValue();
/*  85 */       this.REGISTER_SUCCESS_EFFECT_ID = Integer.valueOf(((Element)data.get("REGISTER_SUCCESS_EFFECT_ID")).attributeValue("value")).intValue();
/*  86 */       this.ROUND_ROBIN_WIN_EFFECT_ID = Integer.valueOf(((Element)data.get("ROUND_ROBIN_WIN_EFFECT_ID")).attributeValue("value")).intValue();
/*  87 */       this.ROUND_ROBIN_LOSE_EFFECT_ID = Integer.valueOf(((Element)data.get("ROUND_ROBIN_LOSE_EFFECT_ID")).attributeValue("value")).intValue();
/*  88 */       this.OWN_CORPS_TITLE_COLOR_ID = Integer.valueOf(((Element)data.get("OWN_CORPS_TITLE_COLOR_ID")).attributeValue("value")).intValue();
/*  89 */       this.OTHER_CORPS_TITLE_COLOR_ID = Integer.valueOf(((Element)data.get("OTHER_CORPS_TITLE_COLOR_ID")).attributeValue("value")).intValue();
/*  90 */       this.cross_battle_session = String.valueOf(((Element)data.get("cross_battle_session")).attributeValue("value"));
/*  91 */       this.cross_battle_session_num = Integer.valueOf(((Element)data.get("cross_battle_session_num")).attributeValue("value")).intValue();
/*  92 */       this.cross_battle_selection_win_effect_id = Integer.valueOf(((Element)data.get("cross_battle_selection_win_effect_id")).attributeValue("value")).intValue();
/*  93 */       this.cross_battle_selection_lose_effect_id = Integer.valueOf(((Element)data.get("cross_battle_selection_lose_effect_id")).attributeValue("value")).intValue();
/*  94 */       this.cross_battle_final_win_effect_id = Integer.valueOf(((Element)data.get("cross_battle_final_win_effect_id")).attributeValue("value")).intValue();
/*  95 */       this.cross_battle_final_lose_effect_id = Integer.valueOf(((Element)data.get("cross_battle_final_lose_effect_id")).attributeValue("value")).intValue();
/*  96 */       this.cross_battle_match_wait_effect_id = Integer.valueOf(((Element)data.get("cross_battle_match_wait_effect_id")).attributeValue("value")).intValue();
/*  97 */       this.cross_battle_register_tips = Integer.valueOf(((Element)data.get("cross_battle_register_tips")).attributeValue("value")).intValue();
/*  98 */       this.cross_battle_vote_tips = Integer.valueOf(((Element)data.get("cross_battle_vote_tips")).attributeValue("value")).intValue();
/*  99 */       this.cross_battle_round_tips = Integer.valueOf(((Element)data.get("cross_battle_round_tips")).attributeValue("value")).intValue();
/* 100 */       this.cross_battle_divide_tips = Integer.valueOf(((Element)data.get("cross_battle_divide_tips")).attributeValue("value")).intValue();
/* 101 */       this.cross_battle_point_tips = Integer.valueOf(((Element)data.get("cross_battle_point_tips")).attributeValue("value")).intValue();
/* 102 */       this.cross_battle_selection_tips = Integer.valueOf(((Element)data.get("cross_battle_selection_tips")).attributeValue("value")).intValue();
/* 103 */       this.cross_battle_final_tips = Integer.valueOf(((Element)data.get("cross_battle_final_tips")).attributeValue("value")).intValue();
/* 104 */       this.DAILY_BET_TIMES_UPPER_LIMIT = Integer.valueOf(((Element)data.get("DAILY_BET_TIMES_UPPER_LIMIT")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 113 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleConsts.xml";
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
/* 133 */       this.CURRENT_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("CURRENT_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 134 */       this.ENTER_ROUND_ROBIN_MAP_TEAM_MEMBER_NUM = Integer.valueOf(((Element)data.get("ENTER_ROUND_ROBIN_MAP_TEAM_MEMBER_NUM")).attributeValue("value")).intValue();
/* 135 */       this.CANVASS_COOLDOWN_TIME_IN_SECOND = Integer.valueOf(((Element)data.get("CANVASS_COOLDOWN_TIME_IN_SECOND")).attributeValue("value")).intValue();
/* 136 */       this.REGISTER_SUCCESS_EFFECT_ID = Integer.valueOf(((Element)data.get("REGISTER_SUCCESS_EFFECT_ID")).attributeValue("value")).intValue();
/* 137 */       this.ROUND_ROBIN_WIN_EFFECT_ID = Integer.valueOf(((Element)data.get("ROUND_ROBIN_WIN_EFFECT_ID")).attributeValue("value")).intValue();
/* 138 */       this.ROUND_ROBIN_LOSE_EFFECT_ID = Integer.valueOf(((Element)data.get("ROUND_ROBIN_LOSE_EFFECT_ID")).attributeValue("value")).intValue();
/* 139 */       this.OWN_CORPS_TITLE_COLOR_ID = Integer.valueOf(((Element)data.get("OWN_CORPS_TITLE_COLOR_ID")).attributeValue("value")).intValue();
/* 140 */       this.OTHER_CORPS_TITLE_COLOR_ID = Integer.valueOf(((Element)data.get("OTHER_CORPS_TITLE_COLOR_ID")).attributeValue("value")).intValue();
/* 141 */       this.cross_battle_session = String.valueOf(((Element)data.get("cross_battle_session")).attributeValue("value"));
/* 142 */       this.cross_battle_session_num = Integer.valueOf(((Element)data.get("cross_battle_session_num")).attributeValue("value")).intValue();
/* 143 */       this.cross_battle_selection_win_effect_id = Integer.valueOf(((Element)data.get("cross_battle_selection_win_effect_id")).attributeValue("value")).intValue();
/* 144 */       this.cross_battle_selection_lose_effect_id = Integer.valueOf(((Element)data.get("cross_battle_selection_lose_effect_id")).attributeValue("value")).intValue();
/* 145 */       this.cross_battle_final_win_effect_id = Integer.valueOf(((Element)data.get("cross_battle_final_win_effect_id")).attributeValue("value")).intValue();
/* 146 */       this.cross_battle_final_lose_effect_id = Integer.valueOf(((Element)data.get("cross_battle_final_lose_effect_id")).attributeValue("value")).intValue();
/* 147 */       this.cross_battle_match_wait_effect_id = Integer.valueOf(((Element)data.get("cross_battle_match_wait_effect_id")).attributeValue("value")).intValue();
/* 148 */       this.cross_battle_register_tips = Integer.valueOf(((Element)data.get("cross_battle_register_tips")).attributeValue("value")).intValue();
/* 149 */       this.cross_battle_vote_tips = Integer.valueOf(((Element)data.get("cross_battle_vote_tips")).attributeValue("value")).intValue();
/* 150 */       this.cross_battle_round_tips = Integer.valueOf(((Element)data.get("cross_battle_round_tips")).attributeValue("value")).intValue();
/* 151 */       this.cross_battle_divide_tips = Integer.valueOf(((Element)data.get("cross_battle_divide_tips")).attributeValue("value")).intValue();
/* 152 */       this.cross_battle_point_tips = Integer.valueOf(((Element)data.get("cross_battle_point_tips")).attributeValue("value")).intValue();
/* 153 */       this.cross_battle_selection_tips = Integer.valueOf(((Element)data.get("cross_battle_selection_tips")).attributeValue("value")).intValue();
/* 154 */       this.cross_battle_final_tips = Integer.valueOf(((Element)data.get("cross_battle_final_tips")).attributeValue("value")).intValue();
/* 155 */       this.DAILY_BET_TIMES_UPPER_LIMIT = Integer.valueOf(((Element)data.get("DAILY_BET_TIMES_UPPER_LIMIT")).attributeValue("value")).intValue();
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
/* 166 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleConsts.bny";
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
/* 181 */         this.CURRENT_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 182 */         this.ENTER_ROUND_ROBIN_MAP_TEAM_MEMBER_NUM = _os_.unmarshal_int();
/* 183 */         this.CANVASS_COOLDOWN_TIME_IN_SECOND = _os_.unmarshal_int();
/* 184 */         this.REGISTER_SUCCESS_EFFECT_ID = _os_.unmarshal_int();
/* 185 */         this.ROUND_ROBIN_WIN_EFFECT_ID = _os_.unmarshal_int();
/* 186 */         this.ROUND_ROBIN_LOSE_EFFECT_ID = _os_.unmarshal_int();
/* 187 */         this.OWN_CORPS_TITLE_COLOR_ID = _os_.unmarshal_int();
/* 188 */         this.OTHER_CORPS_TITLE_COLOR_ID = _os_.unmarshal_int();
/* 189 */         this.cross_battle_session = _os_.unmarshal_String("UTF-8");
/* 190 */         this.cross_battle_session_num = _os_.unmarshal_int();
/* 191 */         this.cross_battle_selection_win_effect_id = _os_.unmarshal_int();
/* 192 */         this.cross_battle_selection_lose_effect_id = _os_.unmarshal_int();
/* 193 */         this.cross_battle_final_win_effect_id = _os_.unmarshal_int();
/* 194 */         this.cross_battle_final_lose_effect_id = _os_.unmarshal_int();
/* 195 */         this.cross_battle_match_wait_effect_id = _os_.unmarshal_int();
/* 196 */         this.cross_battle_register_tips = _os_.unmarshal_int();
/* 197 */         this.cross_battle_vote_tips = _os_.unmarshal_int();
/* 198 */         this.cross_battle_round_tips = _os_.unmarshal_int();
/* 199 */         this.cross_battle_divide_tips = _os_.unmarshal_int();
/* 200 */         this.cross_battle_point_tips = _os_.unmarshal_int();
/* 201 */         this.cross_battle_selection_tips = _os_.unmarshal_int();
/* 202 */         this.cross_battle_final_tips = _os_.unmarshal_int();
/* 203 */         this.DAILY_BET_TIMES_UPPER_LIMIT = _os_.unmarshal_int();
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
/* 214 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleConsts.bny";
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
/* 229 */         this.CURRENT_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 230 */         this.ENTER_ROUND_ROBIN_MAP_TEAM_MEMBER_NUM = _os_.unmarshal_int();
/* 231 */         this.CANVASS_COOLDOWN_TIME_IN_SECOND = _os_.unmarshal_int();
/* 232 */         this.REGISTER_SUCCESS_EFFECT_ID = _os_.unmarshal_int();
/* 233 */         this.ROUND_ROBIN_WIN_EFFECT_ID = _os_.unmarshal_int();
/* 234 */         this.ROUND_ROBIN_LOSE_EFFECT_ID = _os_.unmarshal_int();
/* 235 */         this.OWN_CORPS_TITLE_COLOR_ID = _os_.unmarshal_int();
/* 236 */         this.OTHER_CORPS_TITLE_COLOR_ID = _os_.unmarshal_int();
/* 237 */         this.cross_battle_session = _os_.unmarshal_String("UTF-8");
/* 238 */         this.cross_battle_session_num = _os_.unmarshal_int();
/* 239 */         this.cross_battle_selection_win_effect_id = _os_.unmarshal_int();
/* 240 */         this.cross_battle_selection_lose_effect_id = _os_.unmarshal_int();
/* 241 */         this.cross_battle_final_win_effect_id = _os_.unmarshal_int();
/* 242 */         this.cross_battle_final_lose_effect_id = _os_.unmarshal_int();
/* 243 */         this.cross_battle_match_wait_effect_id = _os_.unmarshal_int();
/* 244 */         this.cross_battle_register_tips = _os_.unmarshal_int();
/* 245 */         this.cross_battle_vote_tips = _os_.unmarshal_int();
/* 246 */         this.cross_battle_round_tips = _os_.unmarshal_int();
/* 247 */         this.cross_battle_divide_tips = _os_.unmarshal_int();
/* 248 */         this.cross_battle_point_tips = _os_.unmarshal_int();
/* 249 */         this.cross_battle_selection_tips = _os_.unmarshal_int();
/* 250 */         this.cross_battle_final_tips = _os_.unmarshal_int();
/* 251 */         this.DAILY_BET_TIMES_UPPER_LIMIT = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(CrossBattleConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\CrossBattleConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */