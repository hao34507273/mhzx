/*     */ package mzm.gsp.ballbattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SBallBattleActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBallBattleActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBallBattleActivityCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int collisionCheckMilliseconds;
/*     */   public int totalRounds;
/*     */   public int firstPrepareMinutes;
/*     */   public int prepareMinutes;
/*     */   public int roundMinutes;
/*     */   public int prepareMapId;
/*     */   public int gameMapId;
/*     */   public int exitMapId;
/*     */   public int activityNpcId;
/*     */   public int prepareNpcId;
/*     */   public int circleCfgId;
/*     */   public int defaultPlayerNumber;
/*     */   public int minPlayerNumber;
/*     */   public int levelCfgId;
/*     */   public int alertRadius;
/*     */   public int alertCoolDownSeconds;
/*     */   public int playerLifeNumber;
/*     */   public int gamePrepareBuff;
/*     */   public int deathBuff;
/*     */   public int respawnSeconds;
/*     */   public int gamePrepareSeconds;
/*     */   public int gameSeconds;
/*     */   public int initProtectSeconds;
/*     */   public int maxLevelResetSeconds;
/*     */   public int gameEndForceLeaveSeconds;
/*     */   public int maxRandomDelayInitMilliseconds;
/*     */   public int groundItemCheckRadius;
/*     */   public int minItemSpawnPositionCfgId;
/*     */   public int maxItemSpawnPositionCfgId;
/*     */   public int geneItemRespawnSeconds;
/*     */   public int geneItemCfgId;
/*     */   public int buffItemRespawnSeconds;
/*     */   public int buffItemDisappearSeconds;
/*     */   public int minBuffItemCfgId;
/*     */   public int maxBuffItemCfgId;
/*     */   public int awardMailId;
/*     */   public int minAwardCfgId;
/*     */   public int maxAwardCfgId;
/*     */   public int playerRespawnRegionCfgId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  61 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  62 */     this.collisionCheckMilliseconds = Integer.valueOf(rootElement.attributeValue("collisionCheckMilliseconds")).intValue();
/*  63 */     this.totalRounds = Integer.valueOf(rootElement.attributeValue("totalRounds")).intValue();
/*  64 */     this.firstPrepareMinutes = Integer.valueOf(rootElement.attributeValue("firstPrepareMinutes")).intValue();
/*  65 */     this.prepareMinutes = Integer.valueOf(rootElement.attributeValue("prepareMinutes")).intValue();
/*  66 */     this.roundMinutes = Integer.valueOf(rootElement.attributeValue("roundMinutes")).intValue();
/*  67 */     this.prepareMapId = Integer.valueOf(rootElement.attributeValue("prepareMapId")).intValue();
/*  68 */     this.gameMapId = Integer.valueOf(rootElement.attributeValue("gameMapId")).intValue();
/*  69 */     this.exitMapId = Integer.valueOf(rootElement.attributeValue("exitMapId")).intValue();
/*  70 */     this.activityNpcId = Integer.valueOf(rootElement.attributeValue("activityNpcId")).intValue();
/*  71 */     this.prepareNpcId = Integer.valueOf(rootElement.attributeValue("prepareNpcId")).intValue();
/*  72 */     this.circleCfgId = Integer.valueOf(rootElement.attributeValue("circleCfgId")).intValue();
/*  73 */     this.defaultPlayerNumber = Integer.valueOf(rootElement.attributeValue("defaultPlayerNumber")).intValue();
/*  74 */     this.minPlayerNumber = Integer.valueOf(rootElement.attributeValue("minPlayerNumber")).intValue();
/*  75 */     this.levelCfgId = Integer.valueOf(rootElement.attributeValue("levelCfgId")).intValue();
/*  76 */     this.alertRadius = Integer.valueOf(rootElement.attributeValue("alertRadius")).intValue();
/*  77 */     this.alertCoolDownSeconds = Integer.valueOf(rootElement.attributeValue("alertCoolDownSeconds")).intValue();
/*  78 */     this.playerLifeNumber = Integer.valueOf(rootElement.attributeValue("playerLifeNumber")).intValue();
/*  79 */     this.gamePrepareBuff = Integer.valueOf(rootElement.attributeValue("gamePrepareBuff")).intValue();
/*  80 */     this.deathBuff = Integer.valueOf(rootElement.attributeValue("deathBuff")).intValue();
/*  81 */     this.respawnSeconds = Integer.valueOf(rootElement.attributeValue("respawnSeconds")).intValue();
/*  82 */     this.gamePrepareSeconds = Integer.valueOf(rootElement.attributeValue("gamePrepareSeconds")).intValue();
/*  83 */     this.gameSeconds = Integer.valueOf(rootElement.attributeValue("gameSeconds")).intValue();
/*  84 */     this.initProtectSeconds = Integer.valueOf(rootElement.attributeValue("initProtectSeconds")).intValue();
/*  85 */     this.maxLevelResetSeconds = Integer.valueOf(rootElement.attributeValue("maxLevelResetSeconds")).intValue();
/*  86 */     this.gameEndForceLeaveSeconds = Integer.valueOf(rootElement.attributeValue("gameEndForceLeaveSeconds")).intValue();
/*  87 */     this.maxRandomDelayInitMilliseconds = Integer.valueOf(rootElement.attributeValue("maxRandomDelayInitMilliseconds")).intValue();
/*  88 */     this.groundItemCheckRadius = Integer.valueOf(rootElement.attributeValue("groundItemCheckRadius")).intValue();
/*  89 */     this.minItemSpawnPositionCfgId = Integer.valueOf(rootElement.attributeValue("minItemSpawnPositionCfgId")).intValue();
/*  90 */     this.maxItemSpawnPositionCfgId = Integer.valueOf(rootElement.attributeValue("maxItemSpawnPositionCfgId")).intValue();
/*  91 */     this.geneItemRespawnSeconds = Integer.valueOf(rootElement.attributeValue("geneItemRespawnSeconds")).intValue();
/*  92 */     this.geneItemCfgId = Integer.valueOf(rootElement.attributeValue("geneItemCfgId")).intValue();
/*  93 */     this.buffItemRespawnSeconds = Integer.valueOf(rootElement.attributeValue("buffItemRespawnSeconds")).intValue();
/*  94 */     this.buffItemDisappearSeconds = Integer.valueOf(rootElement.attributeValue("buffItemDisappearSeconds")).intValue();
/*  95 */     this.minBuffItemCfgId = Integer.valueOf(rootElement.attributeValue("minBuffItemCfgId")).intValue();
/*  96 */     this.maxBuffItemCfgId = Integer.valueOf(rootElement.attributeValue("maxBuffItemCfgId")).intValue();
/*  97 */     this.awardMailId = Integer.valueOf(rootElement.attributeValue("awardMailId")).intValue();
/*  98 */     this.minAwardCfgId = Integer.valueOf(rootElement.attributeValue("minAwardCfgId")).intValue();
/*  99 */     this.maxAwardCfgId = Integer.valueOf(rootElement.attributeValue("maxAwardCfgId")).intValue();
/* 100 */     this.playerRespawnRegionCfgId = Integer.valueOf(rootElement.attributeValue("playerRespawnRegionCfgId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 105 */     _os_.marshal(this.activityId);
/* 106 */     _os_.marshal(this.collisionCheckMilliseconds);
/* 107 */     _os_.marshal(this.totalRounds);
/* 108 */     _os_.marshal(this.firstPrepareMinutes);
/* 109 */     _os_.marshal(this.prepareMinutes);
/* 110 */     _os_.marshal(this.roundMinutes);
/* 111 */     _os_.marshal(this.prepareMapId);
/* 112 */     _os_.marshal(this.gameMapId);
/* 113 */     _os_.marshal(this.exitMapId);
/* 114 */     _os_.marshal(this.activityNpcId);
/* 115 */     _os_.marshal(this.prepareNpcId);
/* 116 */     _os_.marshal(this.circleCfgId);
/* 117 */     _os_.marshal(this.defaultPlayerNumber);
/* 118 */     _os_.marshal(this.minPlayerNumber);
/* 119 */     _os_.marshal(this.levelCfgId);
/* 120 */     _os_.marshal(this.alertRadius);
/* 121 */     _os_.marshal(this.alertCoolDownSeconds);
/* 122 */     _os_.marshal(this.playerLifeNumber);
/* 123 */     _os_.marshal(this.gamePrepareBuff);
/* 124 */     _os_.marshal(this.deathBuff);
/* 125 */     _os_.marshal(this.respawnSeconds);
/* 126 */     _os_.marshal(this.gamePrepareSeconds);
/* 127 */     _os_.marshal(this.gameSeconds);
/* 128 */     _os_.marshal(this.initProtectSeconds);
/* 129 */     _os_.marshal(this.maxLevelResetSeconds);
/* 130 */     _os_.marshal(this.gameEndForceLeaveSeconds);
/* 131 */     _os_.marshal(this.maxRandomDelayInitMilliseconds);
/* 132 */     _os_.marshal(this.groundItemCheckRadius);
/* 133 */     _os_.marshal(this.minItemSpawnPositionCfgId);
/* 134 */     _os_.marshal(this.maxItemSpawnPositionCfgId);
/* 135 */     _os_.marshal(this.geneItemRespawnSeconds);
/* 136 */     _os_.marshal(this.geneItemCfgId);
/* 137 */     _os_.marshal(this.buffItemRespawnSeconds);
/* 138 */     _os_.marshal(this.buffItemDisappearSeconds);
/* 139 */     _os_.marshal(this.minBuffItemCfgId);
/* 140 */     _os_.marshal(this.maxBuffItemCfgId);
/* 141 */     _os_.marshal(this.awardMailId);
/* 142 */     _os_.marshal(this.minAwardCfgId);
/* 143 */     _os_.marshal(this.maxAwardCfgId);
/* 144 */     _os_.marshal(this.playerRespawnRegionCfgId);
/* 145 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 150 */     this.activityId = _os_.unmarshal_int();
/* 151 */     this.collisionCheckMilliseconds = _os_.unmarshal_int();
/* 152 */     this.totalRounds = _os_.unmarshal_int();
/* 153 */     this.firstPrepareMinutes = _os_.unmarshal_int();
/* 154 */     this.prepareMinutes = _os_.unmarshal_int();
/* 155 */     this.roundMinutes = _os_.unmarshal_int();
/* 156 */     this.prepareMapId = _os_.unmarshal_int();
/* 157 */     this.gameMapId = _os_.unmarshal_int();
/* 158 */     this.exitMapId = _os_.unmarshal_int();
/* 159 */     this.activityNpcId = _os_.unmarshal_int();
/* 160 */     this.prepareNpcId = _os_.unmarshal_int();
/* 161 */     this.circleCfgId = _os_.unmarshal_int();
/* 162 */     this.defaultPlayerNumber = _os_.unmarshal_int();
/* 163 */     this.minPlayerNumber = _os_.unmarshal_int();
/* 164 */     this.levelCfgId = _os_.unmarshal_int();
/* 165 */     this.alertRadius = _os_.unmarshal_int();
/* 166 */     this.alertCoolDownSeconds = _os_.unmarshal_int();
/* 167 */     this.playerLifeNumber = _os_.unmarshal_int();
/* 168 */     this.gamePrepareBuff = _os_.unmarshal_int();
/* 169 */     this.deathBuff = _os_.unmarshal_int();
/* 170 */     this.respawnSeconds = _os_.unmarshal_int();
/* 171 */     this.gamePrepareSeconds = _os_.unmarshal_int();
/* 172 */     this.gameSeconds = _os_.unmarshal_int();
/* 173 */     this.initProtectSeconds = _os_.unmarshal_int();
/* 174 */     this.maxLevelResetSeconds = _os_.unmarshal_int();
/* 175 */     this.gameEndForceLeaveSeconds = _os_.unmarshal_int();
/* 176 */     this.maxRandomDelayInitMilliseconds = _os_.unmarshal_int();
/* 177 */     this.groundItemCheckRadius = _os_.unmarshal_int();
/* 178 */     this.minItemSpawnPositionCfgId = _os_.unmarshal_int();
/* 179 */     this.maxItemSpawnPositionCfgId = _os_.unmarshal_int();
/* 180 */     this.geneItemRespawnSeconds = _os_.unmarshal_int();
/* 181 */     this.geneItemCfgId = _os_.unmarshal_int();
/* 182 */     this.buffItemRespawnSeconds = _os_.unmarshal_int();
/* 183 */     this.buffItemDisappearSeconds = _os_.unmarshal_int();
/* 184 */     this.minBuffItemCfgId = _os_.unmarshal_int();
/* 185 */     this.maxBuffItemCfgId = _os_.unmarshal_int();
/* 186 */     this.awardMailId = _os_.unmarshal_int();
/* 187 */     this.minAwardCfgId = _os_.unmarshal_int();
/* 188 */     this.maxAwardCfgId = _os_.unmarshal_int();
/* 189 */     this.playerRespawnRegionCfgId = _os_.unmarshal_int();
/* 190 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 199 */       all = new java.util.HashMap();
/* 200 */       SAXReader reader = new SAXReader();
/* 201 */       org.dom4j.Document doc = reader.read(new File(path));
/* 202 */       Element root = doc.getRootElement();
/* 203 */       List<?> nodeList = root.elements();
/* 204 */       int len = nodeList.size();
/* 205 */       for (int i = 0; i < len; i++)
/*     */       {
/* 207 */         Element elem = (Element)nodeList.get(i);
/* 208 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg"))
/*     */         {
/*     */ 
/* 211 */           SBallBattleActivityCfg obj = new SBallBattleActivityCfg();
/* 212 */           obj.loadFromXml(elem);
/* 213 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBallBattleActivityCfg> all)
/*     */   {
/* 225 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 229 */       SAXReader reader = new SAXReader();
/* 230 */       org.dom4j.Document doc = reader.read(new File(path));
/* 231 */       Element root = doc.getRootElement();
/* 232 */       List<?> nodeList = root.elements();
/* 233 */       int len = nodeList.size();
/* 234 */       for (int i = 0; i < len; i++)
/*     */       {
/* 236 */         Element elem = (Element)nodeList.get(i);
/* 237 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg"))
/*     */         {
/*     */ 
/* 240 */           SBallBattleActivityCfg obj = new SBallBattleActivityCfg();
/* 241 */           obj.loadFromXml(elem);
/* 242 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 243 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 248 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 254 */     all = new java.util.HashMap();
/*     */     
/* 256 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg.bny";
/*     */     try
/*     */     {
/* 259 */       File file = new File(path);
/* 260 */       if (file.exists())
/*     */       {
/* 262 */         byte[] bytes = new byte['Ѐ'];
/* 263 */         FileInputStream fis = new FileInputStream(file);
/* 264 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 265 */         int len = 0;
/* 266 */         while ((len = fis.read(bytes)) > 0)
/* 267 */           baos.write(bytes, 0, len);
/* 268 */         fis.close();
/* 269 */         bytes = baos.toByteArray();
/* 270 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 271 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 273 */           _os_.unmarshal_int();
/* 274 */           _os_.unmarshal_int();
/* 275 */           _os_.unmarshal_int();
/*     */         }
/* 277 */         _os_.unmarshal_int();
/* 278 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 281 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 283 */           SBallBattleActivityCfg _v_ = new SBallBattleActivityCfg();
/* 284 */           _v_.unmarshal(_os_);
/* 285 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 286 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 291 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 296 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBallBattleActivityCfg> all)
/*     */   {
/* 303 */     String path = dir + "mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg.bny";
/*     */     try
/*     */     {
/* 306 */       File file = new File(path);
/* 307 */       if (file.exists())
/*     */       {
/* 309 */         byte[] bytes = new byte['Ѐ'];
/* 310 */         FileInputStream fis = new FileInputStream(file);
/* 311 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 312 */         int len = 0;
/* 313 */         while ((len = fis.read(bytes)) > 0)
/* 314 */           baos.write(bytes, 0, len);
/* 315 */         fis.close();
/* 316 */         bytes = baos.toByteArray();
/* 317 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 318 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 320 */           _os_.unmarshal_int();
/* 321 */           _os_.unmarshal_int();
/* 322 */           _os_.unmarshal_int();
/*     */         }
/* 324 */         _os_.unmarshal_int();
/* 325 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 328 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 330 */           SBallBattleActivityCfg _v_ = new SBallBattleActivityCfg();
/* 331 */           _v_.unmarshal(_os_);
/* 332 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 333 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 338 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 343 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBallBattleActivityCfg getOld(int key)
/*     */   {
/* 351 */     return (SBallBattleActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBallBattleActivityCfg get(int key)
/*     */   {
/* 356 */     return (SBallBattleActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBallBattleActivityCfg> getOldAll()
/*     */   {
/* 361 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBallBattleActivityCfg> getAll()
/*     */   {
/* 366 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBallBattleActivityCfg> newAll)
/*     */   {
/* 371 */     oldAll = all;
/* 372 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 377 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\confbean\SBallBattleActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */