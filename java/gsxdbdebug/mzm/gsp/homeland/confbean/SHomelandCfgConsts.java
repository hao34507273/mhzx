/*     */ package mzm.gsp.homeland.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SHomelandCfgConsts
/*     */ {
/*  13 */   private static volatile SHomelandCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SHomelandCfgConsts instance = new SHomelandCfgConsts();
/*     */   public int CREATE_HOMELAND_NPC;
/*     */   public int CREATE_HOMELAND_NPC_SERVICE;
/*     */   public int MIN_ROLE_LEVEL;
/*     */   public int IN_HOME_MAIDID;
/*     */   
/*     */   public static SHomelandCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SHomelandCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int INIT_HOMELAND_LEVEL;
/*     */   
/*     */   public int INIT_PETROOM_LEVEL;
/*     */   
/*     */   public int INIT_BEDROOM_LEVEL;
/*     */   
/*     */   public int INIT_DRUGROOM_LEVEL;
/*     */   
/*     */   public int INIT_KITCHEN_LEVEL;
/*     */   public int INIT_MAIDROOM_LEVEL;
/*     */   public int INIT_HOMELAND_CLEANLINESS;
/*     */   public int INIT_HOMELAND_FENGSHUI;
/*     */   public int TIME_ID;
/*     */   public int CLEAN_HOMELAND_NPC_SERVICE;
/*     */   public int HOMELAND_FUNCTIOn_NPC_SERVICE;
/*     */   public int HOMELAND_LEVEL_UP_NPC_SERVICE;
/*     */   public int BUY_FURNITURE_NPC_SERVICE;
/*     */   public int recall_child_npc_service;
/*     */   public int FRESH_FURNITURE_MAX_COUNT;
/*     */   public int FRESH_FURNITURE_NEED_MONEY_TYPE;
/*     */   public int FRESH_FURNITURE_NEED_MONEY_NUM;
/*     */   public int FRESH_FURNITURE_NUM;
/*     */   public int SHOW_FENGSHUI_NPC_SERVICE;
/*     */   public int MAID_RENAME_NPC_SERVICE;
/*     */   public int INIT_COURTYARD_LEVEL;
/*     */   public int FLOOR_TILE_ITEM_ID;
/*     */   public int WALL_ITEM_ID;
/*     */   public int init_homeland_beautiful;
/*     */   public int init_court_yard_cleanliness;
/*     */   public int init_court_yard_terrain_item_cfg_id;
/*     */   public int init_court_yard_road_item_cfg_id;
/*     */   public int init_court_yard_fence_item_cfg_id;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  66 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  71 */     String path = dir + "mzm.gsp.homeland.confbean.SHomelandCfgConsts.xml";
/*     */     try
/*     */     {
/*  74 */       SAXReader reader = new SAXReader();
/*  75 */       org.dom4j.Document doc = reader.read(new File(path));
/*  76 */       Element root = doc.getRootElement();
/*  77 */       Map<String, Element> data = new java.util.HashMap();
/*  78 */       java.util.List<?> nodeList = root.elements();
/*  79 */       int len = nodeList.size();
/*  80 */       for (int i = 0; i < len; i++)
/*     */       {
/*  82 */         Element element = (Element)nodeList.get(i);
/*  83 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  86 */           String name = element.attributeValue("name");
/*  87 */           if (data.put(name, element) != null)
/*  88 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  91 */       this.CREATE_HOMELAND_NPC = Integer.valueOf(((Element)data.get("CREATE_HOMELAND_NPC")).attributeValue("value")).intValue();
/*  92 */       this.CREATE_HOMELAND_NPC_SERVICE = Integer.valueOf(((Element)data.get("CREATE_HOMELAND_NPC_SERVICE")).attributeValue("value")).intValue();
/*  93 */       this.MIN_ROLE_LEVEL = Integer.valueOf(((Element)data.get("MIN_ROLE_LEVEL")).attributeValue("value")).intValue();
/*  94 */       this.IN_HOME_MAIDID = Integer.valueOf(((Element)data.get("IN_HOME_MAIDID")).attributeValue("value")).intValue();
/*  95 */       this.INIT_HOMELAND_LEVEL = Integer.valueOf(((Element)data.get("INIT_HOMELAND_LEVEL")).attributeValue("value")).intValue();
/*  96 */       this.INIT_PETROOM_LEVEL = Integer.valueOf(((Element)data.get("INIT_PETROOM_LEVEL")).attributeValue("value")).intValue();
/*  97 */       this.INIT_BEDROOM_LEVEL = Integer.valueOf(((Element)data.get("INIT_BEDROOM_LEVEL")).attributeValue("value")).intValue();
/*  98 */       this.INIT_DRUGROOM_LEVEL = Integer.valueOf(((Element)data.get("INIT_DRUGROOM_LEVEL")).attributeValue("value")).intValue();
/*  99 */       this.INIT_KITCHEN_LEVEL = Integer.valueOf(((Element)data.get("INIT_KITCHEN_LEVEL")).attributeValue("value")).intValue();
/* 100 */       this.INIT_MAIDROOM_LEVEL = Integer.valueOf(((Element)data.get("INIT_MAIDROOM_LEVEL")).attributeValue("value")).intValue();
/* 101 */       this.INIT_HOMELAND_CLEANLINESS = Integer.valueOf(((Element)data.get("INIT_HOMELAND_CLEANLINESS")).attributeValue("value")).intValue();
/* 102 */       this.INIT_HOMELAND_FENGSHUI = Integer.valueOf(((Element)data.get("INIT_HOMELAND_FENGSHUI")).attributeValue("value")).intValue();
/* 103 */       this.TIME_ID = Integer.valueOf(((Element)data.get("TIME_ID")).attributeValue("value")).intValue();
/* 104 */       this.CLEAN_HOMELAND_NPC_SERVICE = Integer.valueOf(((Element)data.get("CLEAN_HOMELAND_NPC_SERVICE")).attributeValue("value")).intValue();
/* 105 */       this.HOMELAND_FUNCTIOn_NPC_SERVICE = Integer.valueOf(((Element)data.get("HOMELAND_FUNCTIOn_NPC_SERVICE")).attributeValue("value")).intValue();
/* 106 */       this.HOMELAND_LEVEL_UP_NPC_SERVICE = Integer.valueOf(((Element)data.get("HOMELAND_LEVEL_UP_NPC_SERVICE")).attributeValue("value")).intValue();
/* 107 */       this.BUY_FURNITURE_NPC_SERVICE = Integer.valueOf(((Element)data.get("BUY_FURNITURE_NPC_SERVICE")).attributeValue("value")).intValue();
/* 108 */       this.recall_child_npc_service = Integer.valueOf(((Element)data.get("recall_child_npc_service")).attributeValue("value")).intValue();
/* 109 */       this.FRESH_FURNITURE_MAX_COUNT = Integer.valueOf(((Element)data.get("FRESH_FURNITURE_MAX_COUNT")).attributeValue("value")).intValue();
/* 110 */       this.FRESH_FURNITURE_NEED_MONEY_TYPE = Integer.valueOf(((Element)data.get("FRESH_FURNITURE_NEED_MONEY_TYPE")).attributeValue("value")).intValue();
/* 111 */       this.FRESH_FURNITURE_NEED_MONEY_NUM = Integer.valueOf(((Element)data.get("FRESH_FURNITURE_NEED_MONEY_NUM")).attributeValue("value")).intValue();
/* 112 */       this.FRESH_FURNITURE_NUM = Integer.valueOf(((Element)data.get("FRESH_FURNITURE_NUM")).attributeValue("value")).intValue();
/* 113 */       this.SHOW_FENGSHUI_NPC_SERVICE = Integer.valueOf(((Element)data.get("SHOW_FENGSHUI_NPC_SERVICE")).attributeValue("value")).intValue();
/* 114 */       this.MAID_RENAME_NPC_SERVICE = Integer.valueOf(((Element)data.get("MAID_RENAME_NPC_SERVICE")).attributeValue("value")).intValue();
/* 115 */       this.INIT_COURTYARD_LEVEL = Integer.valueOf(((Element)data.get("INIT_COURTYARD_LEVEL")).attributeValue("value")).intValue();
/* 116 */       this.FLOOR_TILE_ITEM_ID = Integer.valueOf(((Element)data.get("FLOOR_TILE_ITEM_ID")).attributeValue("value")).intValue();
/* 117 */       this.WALL_ITEM_ID = Integer.valueOf(((Element)data.get("WALL_ITEM_ID")).attributeValue("value")).intValue();
/* 118 */       this.init_homeland_beautiful = Integer.valueOf(((Element)data.get("init_homeland_beautiful")).attributeValue("value")).intValue();
/* 119 */       this.init_court_yard_cleanliness = Integer.valueOf(((Element)data.get("init_court_yard_cleanliness")).attributeValue("value")).intValue();
/* 120 */       this.init_court_yard_terrain_item_cfg_id = Integer.valueOf(((Element)data.get("init_court_yard_terrain_item_cfg_id")).attributeValue("value")).intValue();
/* 121 */       this.init_court_yard_road_item_cfg_id = Integer.valueOf(((Element)data.get("init_court_yard_road_item_cfg_id")).attributeValue("value")).intValue();
/* 122 */       this.init_court_yard_fence_item_cfg_id = Integer.valueOf(((Element)data.get("init_court_yard_fence_item_cfg_id")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 126 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 131 */     String path = dir + "mzm.gsp.homeland.confbean.SHomelandCfgConsts.xml";
/*     */     try
/*     */     {
/* 134 */       SAXReader reader = new SAXReader();
/* 135 */       org.dom4j.Document doc = reader.read(new File(path));
/* 136 */       Element root = doc.getRootElement();
/* 137 */       Map<String, Element> data = new java.util.HashMap();
/* 138 */       java.util.List<?> nodeList = root.elements();
/* 139 */       int len = nodeList.size();
/* 140 */       for (int i = 0; i < len; i++)
/*     */       {
/* 142 */         Element element = (Element)nodeList.get(i);
/* 143 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 146 */           String name = element.attributeValue("name");
/* 147 */           if (data.put(name, element) != null)
/* 148 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 151 */       this.CREATE_HOMELAND_NPC = Integer.valueOf(((Element)data.get("CREATE_HOMELAND_NPC")).attributeValue("value")).intValue();
/* 152 */       this.CREATE_HOMELAND_NPC_SERVICE = Integer.valueOf(((Element)data.get("CREATE_HOMELAND_NPC_SERVICE")).attributeValue("value")).intValue();
/* 153 */       this.MIN_ROLE_LEVEL = Integer.valueOf(((Element)data.get("MIN_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 154 */       this.IN_HOME_MAIDID = Integer.valueOf(((Element)data.get("IN_HOME_MAIDID")).attributeValue("value")).intValue();
/* 155 */       this.INIT_HOMELAND_LEVEL = Integer.valueOf(((Element)data.get("INIT_HOMELAND_LEVEL")).attributeValue("value")).intValue();
/* 156 */       this.INIT_PETROOM_LEVEL = Integer.valueOf(((Element)data.get("INIT_PETROOM_LEVEL")).attributeValue("value")).intValue();
/* 157 */       this.INIT_BEDROOM_LEVEL = Integer.valueOf(((Element)data.get("INIT_BEDROOM_LEVEL")).attributeValue("value")).intValue();
/* 158 */       this.INIT_DRUGROOM_LEVEL = Integer.valueOf(((Element)data.get("INIT_DRUGROOM_LEVEL")).attributeValue("value")).intValue();
/* 159 */       this.INIT_KITCHEN_LEVEL = Integer.valueOf(((Element)data.get("INIT_KITCHEN_LEVEL")).attributeValue("value")).intValue();
/* 160 */       this.INIT_MAIDROOM_LEVEL = Integer.valueOf(((Element)data.get("INIT_MAIDROOM_LEVEL")).attributeValue("value")).intValue();
/* 161 */       this.INIT_HOMELAND_CLEANLINESS = Integer.valueOf(((Element)data.get("INIT_HOMELAND_CLEANLINESS")).attributeValue("value")).intValue();
/* 162 */       this.INIT_HOMELAND_FENGSHUI = Integer.valueOf(((Element)data.get("INIT_HOMELAND_FENGSHUI")).attributeValue("value")).intValue();
/* 163 */       this.TIME_ID = Integer.valueOf(((Element)data.get("TIME_ID")).attributeValue("value")).intValue();
/* 164 */       this.CLEAN_HOMELAND_NPC_SERVICE = Integer.valueOf(((Element)data.get("CLEAN_HOMELAND_NPC_SERVICE")).attributeValue("value")).intValue();
/* 165 */       this.HOMELAND_FUNCTIOn_NPC_SERVICE = Integer.valueOf(((Element)data.get("HOMELAND_FUNCTIOn_NPC_SERVICE")).attributeValue("value")).intValue();
/* 166 */       this.HOMELAND_LEVEL_UP_NPC_SERVICE = Integer.valueOf(((Element)data.get("HOMELAND_LEVEL_UP_NPC_SERVICE")).attributeValue("value")).intValue();
/* 167 */       this.BUY_FURNITURE_NPC_SERVICE = Integer.valueOf(((Element)data.get("BUY_FURNITURE_NPC_SERVICE")).attributeValue("value")).intValue();
/* 168 */       this.recall_child_npc_service = Integer.valueOf(((Element)data.get("recall_child_npc_service")).attributeValue("value")).intValue();
/* 169 */       this.FRESH_FURNITURE_MAX_COUNT = Integer.valueOf(((Element)data.get("FRESH_FURNITURE_MAX_COUNT")).attributeValue("value")).intValue();
/* 170 */       this.FRESH_FURNITURE_NEED_MONEY_TYPE = Integer.valueOf(((Element)data.get("FRESH_FURNITURE_NEED_MONEY_TYPE")).attributeValue("value")).intValue();
/* 171 */       this.FRESH_FURNITURE_NEED_MONEY_NUM = Integer.valueOf(((Element)data.get("FRESH_FURNITURE_NEED_MONEY_NUM")).attributeValue("value")).intValue();
/* 172 */       this.FRESH_FURNITURE_NUM = Integer.valueOf(((Element)data.get("FRESH_FURNITURE_NUM")).attributeValue("value")).intValue();
/* 173 */       this.SHOW_FENGSHUI_NPC_SERVICE = Integer.valueOf(((Element)data.get("SHOW_FENGSHUI_NPC_SERVICE")).attributeValue("value")).intValue();
/* 174 */       this.MAID_RENAME_NPC_SERVICE = Integer.valueOf(((Element)data.get("MAID_RENAME_NPC_SERVICE")).attributeValue("value")).intValue();
/* 175 */       this.INIT_COURTYARD_LEVEL = Integer.valueOf(((Element)data.get("INIT_COURTYARD_LEVEL")).attributeValue("value")).intValue();
/* 176 */       this.FLOOR_TILE_ITEM_ID = Integer.valueOf(((Element)data.get("FLOOR_TILE_ITEM_ID")).attributeValue("value")).intValue();
/* 177 */       this.WALL_ITEM_ID = Integer.valueOf(((Element)data.get("WALL_ITEM_ID")).attributeValue("value")).intValue();
/* 178 */       this.init_homeland_beautiful = Integer.valueOf(((Element)data.get("init_homeland_beautiful")).attributeValue("value")).intValue();
/* 179 */       this.init_court_yard_cleanliness = Integer.valueOf(((Element)data.get("init_court_yard_cleanliness")).attributeValue("value")).intValue();
/* 180 */       this.init_court_yard_terrain_item_cfg_id = Integer.valueOf(((Element)data.get("init_court_yard_terrain_item_cfg_id")).attributeValue("value")).intValue();
/* 181 */       this.init_court_yard_road_item_cfg_id = Integer.valueOf(((Element)data.get("init_court_yard_road_item_cfg_id")).attributeValue("value")).intValue();
/* 182 */       this.init_court_yard_fence_item_cfg_id = Integer.valueOf(((Element)data.get("init_court_yard_fence_item_cfg_id")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 190 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 193 */     String path = dir + "mzm.gsp.homeland.confbean.SHomelandCfgConsts.bny";
/*     */     try
/*     */     {
/* 196 */       File file = new File(path);
/* 197 */       if (file.exists())
/*     */       {
/* 199 */         byte[] bytes = new byte['Ѐ'];
/* 200 */         FileInputStream fis = new FileInputStream(file);
/* 201 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 202 */         int len = 0;
/* 203 */         while ((len = fis.read(bytes)) > 0)
/* 204 */           baos.write(bytes, 0, len);
/* 205 */         fis.close();
/* 206 */         bytes = baos.toByteArray();
/* 207 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 208 */         this.CREATE_HOMELAND_NPC = _os_.unmarshal_int();
/* 209 */         this.CREATE_HOMELAND_NPC_SERVICE = _os_.unmarshal_int();
/* 210 */         this.MIN_ROLE_LEVEL = _os_.unmarshal_int();
/* 211 */         this.IN_HOME_MAIDID = _os_.unmarshal_int();
/* 212 */         this.INIT_HOMELAND_LEVEL = _os_.unmarshal_int();
/* 213 */         this.INIT_PETROOM_LEVEL = _os_.unmarshal_int();
/* 214 */         this.INIT_BEDROOM_LEVEL = _os_.unmarshal_int();
/* 215 */         this.INIT_DRUGROOM_LEVEL = _os_.unmarshal_int();
/* 216 */         this.INIT_KITCHEN_LEVEL = _os_.unmarshal_int();
/* 217 */         this.INIT_MAIDROOM_LEVEL = _os_.unmarshal_int();
/* 218 */         this.INIT_HOMELAND_CLEANLINESS = _os_.unmarshal_int();
/* 219 */         this.INIT_HOMELAND_FENGSHUI = _os_.unmarshal_int();
/* 220 */         this.TIME_ID = _os_.unmarshal_int();
/* 221 */         this.CLEAN_HOMELAND_NPC_SERVICE = _os_.unmarshal_int();
/* 222 */         this.HOMELAND_FUNCTIOn_NPC_SERVICE = _os_.unmarshal_int();
/* 223 */         this.HOMELAND_LEVEL_UP_NPC_SERVICE = _os_.unmarshal_int();
/* 224 */         this.BUY_FURNITURE_NPC_SERVICE = _os_.unmarshal_int();
/* 225 */         this.recall_child_npc_service = _os_.unmarshal_int();
/* 226 */         this.FRESH_FURNITURE_MAX_COUNT = _os_.unmarshal_int();
/* 227 */         this.FRESH_FURNITURE_NEED_MONEY_TYPE = _os_.unmarshal_int();
/* 228 */         this.FRESH_FURNITURE_NEED_MONEY_NUM = _os_.unmarshal_int();
/* 229 */         this.FRESH_FURNITURE_NUM = _os_.unmarshal_int();
/* 230 */         this.SHOW_FENGSHUI_NPC_SERVICE = _os_.unmarshal_int();
/* 231 */         this.MAID_RENAME_NPC_SERVICE = _os_.unmarshal_int();
/* 232 */         this.INIT_COURTYARD_LEVEL = _os_.unmarshal_int();
/* 233 */         this.FLOOR_TILE_ITEM_ID = _os_.unmarshal_int();
/* 234 */         this.WALL_ITEM_ID = _os_.unmarshal_int();
/* 235 */         this.init_homeland_beautiful = _os_.unmarshal_int();
/* 236 */         this.init_court_yard_cleanliness = _os_.unmarshal_int();
/* 237 */         this.init_court_yard_terrain_item_cfg_id = _os_.unmarshal_int();
/* 238 */         this.init_court_yard_road_item_cfg_id = _os_.unmarshal_int();
/* 239 */         this.init_court_yard_fence_item_cfg_id = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 244 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 250 */     String path = dir + "mzm.gsp.homeland.confbean.SHomelandCfgConsts.bny";
/*     */     try
/*     */     {
/* 253 */       File file = new File(path);
/* 254 */       if (file.exists())
/*     */       {
/* 256 */         byte[] bytes = new byte['Ѐ'];
/* 257 */         FileInputStream fis = new FileInputStream(file);
/* 258 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 259 */         int len = 0;
/* 260 */         while ((len = fis.read(bytes)) > 0)
/* 261 */           baos.write(bytes, 0, len);
/* 262 */         fis.close();
/* 263 */         bytes = baos.toByteArray();
/* 264 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 265 */         this.CREATE_HOMELAND_NPC = _os_.unmarshal_int();
/* 266 */         this.CREATE_HOMELAND_NPC_SERVICE = _os_.unmarshal_int();
/* 267 */         this.MIN_ROLE_LEVEL = _os_.unmarshal_int();
/* 268 */         this.IN_HOME_MAIDID = _os_.unmarshal_int();
/* 269 */         this.INIT_HOMELAND_LEVEL = _os_.unmarshal_int();
/* 270 */         this.INIT_PETROOM_LEVEL = _os_.unmarshal_int();
/* 271 */         this.INIT_BEDROOM_LEVEL = _os_.unmarshal_int();
/* 272 */         this.INIT_DRUGROOM_LEVEL = _os_.unmarshal_int();
/* 273 */         this.INIT_KITCHEN_LEVEL = _os_.unmarshal_int();
/* 274 */         this.INIT_MAIDROOM_LEVEL = _os_.unmarshal_int();
/* 275 */         this.INIT_HOMELAND_CLEANLINESS = _os_.unmarshal_int();
/* 276 */         this.INIT_HOMELAND_FENGSHUI = _os_.unmarshal_int();
/* 277 */         this.TIME_ID = _os_.unmarshal_int();
/* 278 */         this.CLEAN_HOMELAND_NPC_SERVICE = _os_.unmarshal_int();
/* 279 */         this.HOMELAND_FUNCTIOn_NPC_SERVICE = _os_.unmarshal_int();
/* 280 */         this.HOMELAND_LEVEL_UP_NPC_SERVICE = _os_.unmarshal_int();
/* 281 */         this.BUY_FURNITURE_NPC_SERVICE = _os_.unmarshal_int();
/* 282 */         this.recall_child_npc_service = _os_.unmarshal_int();
/* 283 */         this.FRESH_FURNITURE_MAX_COUNT = _os_.unmarshal_int();
/* 284 */         this.FRESH_FURNITURE_NEED_MONEY_TYPE = _os_.unmarshal_int();
/* 285 */         this.FRESH_FURNITURE_NEED_MONEY_NUM = _os_.unmarshal_int();
/* 286 */         this.FRESH_FURNITURE_NUM = _os_.unmarshal_int();
/* 287 */         this.SHOW_FENGSHUI_NPC_SERVICE = _os_.unmarshal_int();
/* 288 */         this.MAID_RENAME_NPC_SERVICE = _os_.unmarshal_int();
/* 289 */         this.INIT_COURTYARD_LEVEL = _os_.unmarshal_int();
/* 290 */         this.FLOOR_TILE_ITEM_ID = _os_.unmarshal_int();
/* 291 */         this.WALL_ITEM_ID = _os_.unmarshal_int();
/* 292 */         this.init_homeland_beautiful = _os_.unmarshal_int();
/* 293 */         this.init_court_yard_cleanliness = _os_.unmarshal_int();
/* 294 */         this.init_court_yard_terrain_item_cfg_id = _os_.unmarshal_int();
/* 295 */         this.init_court_yard_road_item_cfg_id = _os_.unmarshal_int();
/* 296 */         this.init_court_yard_fence_item_cfg_id = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 301 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SHomelandCfgConsts newInstance)
/*     */   {
/* 307 */     oldInstance = instance;
/* 308 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 313 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SHomelandCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */