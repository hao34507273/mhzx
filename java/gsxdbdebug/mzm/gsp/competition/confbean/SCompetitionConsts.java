/*     */ package mzm.gsp.competition.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SCompetitionConsts
/*     */ {
/*  13 */   private static volatile SCompetitionConsts oldInstance = null;
/*     */   
/*  15 */   private static SCompetitionConsts instance = new SCompetitionConsts();
/*     */   public int Activityid;
/*     */   public int CreateDays;
/*     */   public int Scale;
/*     */   public int MemberNumber;
/*     */   
/*     */   public static SCompetitionConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SCompetitionConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int Liveness;
/*     */   
/*     */   public int PlayerNumberOfQualifiedLevel;
/*     */   
/*     */   public int JoinDays;
/*     */   
/*     */   public int ControllerIn;
/*     */   public int PrepareMap;
/*     */   public int FightMap;
/*     */   public int Faction1EnterX;
/*     */   public int Faction1EnterY;
/*     */   public int Faction2EnterX;
/*     */   public int Faction2EnterY;
/*     */   public int PrepareBrdMinutes;
/*     */   public int PrepareAward;
/*     */   public int PrepareAwardMinutes;
/*     */   public int InitActionPoint;
/*     */   public int DeductActionPointWhenEnterLate;
/*     */   public int DeductActionPointWhenLose;
/*     */   public int DeductActionPointWhenPK;
/*     */   public int WinFightAward;
/*     */   public int LoseFightAward;
/*     */   public int WinnerAward;
/*     */   public int LeaveAward;
/*     */   public int WinStreakTimes;
/*     */   public int WinStreakMail;
/*     */   public int AgainstBeforeHours;
/*     */   public int PrepareStageMinutes;
/*     */   public int CompeteWaitStageMinutes;
/*     */   public int CompeteNormalStageMinutes;
/*     */   public int ShutdownCompeteBeforeEndMinutes;
/*     */   public int TriggerMapItemSeconds;
/*     */   public int FactionAgainstMail;
/*     */   public int MatchTimes;
/*  66 */   public java.util.ArrayList<ItemController> ItemControllers = new java.util.ArrayList();
/*     */   public int CopperTreasureMapItem;
/*     */   public int SilverTreasureMapItem;
/*     */   public int GoldTreasureMapItem;
/*     */   public int ELO_K;
/*     */   public int NeedRoleActivePoint;
/*     */   public double Activeness_A;
/*     */   public double Activeness_B;
/*     */   public int Max_GD;
/*     */   public int WinnerFactionMoney;
/*     */   public int LoserFactionMoney;
/*     */   public int WinnerFactionGift;
/*     */   public int LoserFactionGift;
/*     */   public int WinFightExploit;
/*     */   public int LoseFightExploit;
/*     */   public int ParticipateExploit;
/*     */   public int PkScoreA;
/*     */   public int PkScoreB;
/*     */   public int PlayerScoreA;
/*     */   public int PlayerScoreMinutes;
/*     */   public int ProtectedBuff;
/*     */   public int MaxTreasureNum;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  96 */     String path = dir + "mzm.gsp.competition.confbean.SCompetitionConsts.xml";
/*     */     try
/*     */     {
/*  99 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 100 */       org.dom4j.Document doc = reader.read(new File(path));
/* 101 */       Element root = doc.getRootElement();
/* 102 */       Map<String, Element> data = new java.util.HashMap();
/* 103 */       List<?> nodeList = root.elements();
/* 104 */       int len = nodeList.size();
/* 105 */       for (int i = 0; i < len; i++)
/*     */       {
/* 107 */         Element element = (Element)nodeList.get(i);
/* 108 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 111 */           String name = element.attributeValue("name");
/* 112 */           if (data.put(name, element) != null)
/* 113 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 116 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/* 117 */       this.CreateDays = Integer.valueOf(((Element)data.get("CreateDays")).attributeValue("value")).intValue();
/* 118 */       this.Scale = Integer.valueOf(((Element)data.get("Scale")).attributeValue("value")).intValue();
/* 119 */       this.MemberNumber = Integer.valueOf(((Element)data.get("MemberNumber")).attributeValue("value")).intValue();
/* 120 */       this.Liveness = Integer.valueOf(((Element)data.get("Liveness")).attributeValue("value")).intValue();
/* 121 */       this.PlayerNumberOfQualifiedLevel = Integer.valueOf(((Element)data.get("PlayerNumberOfQualifiedLevel")).attributeValue("value")).intValue();
/* 122 */       this.JoinDays = Integer.valueOf(((Element)data.get("JoinDays")).attributeValue("value")).intValue();
/* 123 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/* 124 */       this.PrepareMap = Integer.valueOf(((Element)data.get("PrepareMap")).attributeValue("value")).intValue();
/* 125 */       this.FightMap = Integer.valueOf(((Element)data.get("FightMap")).attributeValue("value")).intValue();
/* 126 */       this.Faction1EnterX = Integer.valueOf(((Element)data.get("Faction1EnterX")).attributeValue("value")).intValue();
/* 127 */       this.Faction1EnterY = Integer.valueOf(((Element)data.get("Faction1EnterY")).attributeValue("value")).intValue();
/* 128 */       this.Faction2EnterX = Integer.valueOf(((Element)data.get("Faction2EnterX")).attributeValue("value")).intValue();
/* 129 */       this.Faction2EnterY = Integer.valueOf(((Element)data.get("Faction2EnterY")).attributeValue("value")).intValue();
/* 130 */       this.PrepareBrdMinutes = Integer.valueOf(((Element)data.get("PrepareBrdMinutes")).attributeValue("value")).intValue();
/* 131 */       this.PrepareAward = Integer.valueOf(((Element)data.get("PrepareAward")).attributeValue("value")).intValue();
/* 132 */       this.PrepareAwardMinutes = Integer.valueOf(((Element)data.get("PrepareAwardMinutes")).attributeValue("value")).intValue();
/* 133 */       this.InitActionPoint = Integer.valueOf(((Element)data.get("InitActionPoint")).attributeValue("value")).intValue();
/* 134 */       this.DeductActionPointWhenEnterLate = Integer.valueOf(((Element)data.get("DeductActionPointWhenEnterLate")).attributeValue("value")).intValue();
/* 135 */       this.DeductActionPointWhenLose = Integer.valueOf(((Element)data.get("DeductActionPointWhenLose")).attributeValue("value")).intValue();
/* 136 */       this.DeductActionPointWhenPK = Integer.valueOf(((Element)data.get("DeductActionPointWhenPK")).attributeValue("value")).intValue();
/* 137 */       this.WinFightAward = Integer.valueOf(((Element)data.get("WinFightAward")).attributeValue("value")).intValue();
/* 138 */       this.LoseFightAward = Integer.valueOf(((Element)data.get("LoseFightAward")).attributeValue("value")).intValue();
/* 139 */       this.WinnerAward = Integer.valueOf(((Element)data.get("WinnerAward")).attributeValue("value")).intValue();
/* 140 */       this.LeaveAward = Integer.valueOf(((Element)data.get("LeaveAward")).attributeValue("value")).intValue();
/* 141 */       this.WinStreakTimes = Integer.valueOf(((Element)data.get("WinStreakTimes")).attributeValue("value")).intValue();
/* 142 */       this.WinStreakMail = Integer.valueOf(((Element)data.get("WinStreakMail")).attributeValue("value")).intValue();
/* 143 */       this.AgainstBeforeHours = Integer.valueOf(((Element)data.get("AgainstBeforeHours")).attributeValue("value")).intValue();
/* 144 */       this.PrepareStageMinutes = Integer.valueOf(((Element)data.get("PrepareStageMinutes")).attributeValue("value")).intValue();
/* 145 */       this.CompeteWaitStageMinutes = Integer.valueOf(((Element)data.get("CompeteWaitStageMinutes")).attributeValue("value")).intValue();
/* 146 */       this.CompeteNormalStageMinutes = Integer.valueOf(((Element)data.get("CompeteNormalStageMinutes")).attributeValue("value")).intValue();
/* 147 */       this.ShutdownCompeteBeforeEndMinutes = Integer.valueOf(((Element)data.get("ShutdownCompeteBeforeEndMinutes")).attributeValue("value")).intValue();
/* 148 */       this.TriggerMapItemSeconds = Integer.valueOf(((Element)data.get("TriggerMapItemSeconds")).attributeValue("value")).intValue();
/* 149 */       this.FactionAgainstMail = Integer.valueOf(((Element)data.get("FactionAgainstMail")).attributeValue("value")).intValue();
/* 150 */       this.MatchTimes = Integer.valueOf(((Element)data.get("MatchTimes")).attributeValue("value")).intValue();
/*     */       
/* 152 */       Element collectionElement = (Element)data.get("ItemControllers");
/* 153 */       if (collectionElement == null)
/*     */       {
/* 155 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 158 */       List<?> _nodeList = collectionElement.elements();
/* 159 */       int _len = _nodeList.size();
/* 160 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 162 */         Element elem = (Element)_nodeList.get(i);
/* 163 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.competition.confbean.ItemController"))
/*     */         {
/*     */           ItemController _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 170 */             _v_ = new ItemController();
/* 171 */             _v_.loadFromXml(elem);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 178 */           this.ItemControllers.add(_v_);
/*     */         }
/*     */       }
/* 181 */       this.CopperTreasureMapItem = Integer.valueOf(((Element)data.get("CopperTreasureMapItem")).attributeValue("value")).intValue();
/* 182 */       this.SilverTreasureMapItem = Integer.valueOf(((Element)data.get("SilverTreasureMapItem")).attributeValue("value")).intValue();
/* 183 */       this.GoldTreasureMapItem = Integer.valueOf(((Element)data.get("GoldTreasureMapItem")).attributeValue("value")).intValue();
/* 184 */       this.ELO_K = Integer.valueOf(((Element)data.get("ELO_K")).attributeValue("value")).intValue();
/* 185 */       this.NeedRoleActivePoint = Integer.valueOf(((Element)data.get("NeedRoleActivePoint")).attributeValue("value")).intValue();
/* 186 */       this.Activeness_A = Double.valueOf(((Element)data.get("Activeness_A")).attributeValue("value")).doubleValue();
/* 187 */       this.Activeness_B = Double.valueOf(((Element)data.get("Activeness_B")).attributeValue("value")).doubleValue();
/* 188 */       this.Max_GD = Integer.valueOf(((Element)data.get("Max_GD")).attributeValue("value")).intValue();
/* 189 */       this.WinnerFactionMoney = Integer.valueOf(((Element)data.get("WinnerFactionMoney")).attributeValue("value")).intValue();
/* 190 */       this.LoserFactionMoney = Integer.valueOf(((Element)data.get("LoserFactionMoney")).attributeValue("value")).intValue();
/* 191 */       this.WinnerFactionGift = Integer.valueOf(((Element)data.get("WinnerFactionGift")).attributeValue("value")).intValue();
/* 192 */       this.LoserFactionGift = Integer.valueOf(((Element)data.get("LoserFactionGift")).attributeValue("value")).intValue();
/* 193 */       this.WinFightExploit = Integer.valueOf(((Element)data.get("WinFightExploit")).attributeValue("value")).intValue();
/* 194 */       this.LoseFightExploit = Integer.valueOf(((Element)data.get("LoseFightExploit")).attributeValue("value")).intValue();
/* 195 */       this.ParticipateExploit = Integer.valueOf(((Element)data.get("ParticipateExploit")).attributeValue("value")).intValue();
/* 196 */       this.PkScoreA = Integer.valueOf(((Element)data.get("PkScoreA")).attributeValue("value")).intValue();
/* 197 */       this.PkScoreB = Integer.valueOf(((Element)data.get("PkScoreB")).attributeValue("value")).intValue();
/* 198 */       this.PlayerScoreA = Integer.valueOf(((Element)data.get("PlayerScoreA")).attributeValue("value")).intValue();
/* 199 */       this.PlayerScoreMinutes = Integer.valueOf(((Element)data.get("PlayerScoreMinutes")).attributeValue("value")).intValue();
/* 200 */       this.ProtectedBuff = Integer.valueOf(((Element)data.get("ProtectedBuff")).attributeValue("value")).intValue();
/* 201 */       this.MaxTreasureNum = Integer.valueOf(((Element)data.get("MaxTreasureNum")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 205 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 210 */     String path = dir + "mzm.gsp.competition.confbean.SCompetitionConsts.xml";
/*     */     try
/*     */     {
/* 213 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 214 */       org.dom4j.Document doc = reader.read(new File(path));
/* 215 */       Element root = doc.getRootElement();
/* 216 */       Map<String, Element> data = new java.util.HashMap();
/* 217 */       List<?> nodeList = root.elements();
/* 218 */       int len = nodeList.size();
/* 219 */       for (int i = 0; i < len; i++)
/*     */       {
/* 221 */         Element element = (Element)nodeList.get(i);
/* 222 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 225 */           String name = element.attributeValue("name");
/* 226 */           if (data.put(name, element) != null)
/* 227 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 230 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/* 231 */       this.CreateDays = Integer.valueOf(((Element)data.get("CreateDays")).attributeValue("value")).intValue();
/* 232 */       this.Scale = Integer.valueOf(((Element)data.get("Scale")).attributeValue("value")).intValue();
/* 233 */       this.MemberNumber = Integer.valueOf(((Element)data.get("MemberNumber")).attributeValue("value")).intValue();
/* 234 */       this.Liveness = Integer.valueOf(((Element)data.get("Liveness")).attributeValue("value")).intValue();
/* 235 */       this.PlayerNumberOfQualifiedLevel = Integer.valueOf(((Element)data.get("PlayerNumberOfQualifiedLevel")).attributeValue("value")).intValue();
/* 236 */       this.JoinDays = Integer.valueOf(((Element)data.get("JoinDays")).attributeValue("value")).intValue();
/* 237 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/* 238 */       this.PrepareMap = Integer.valueOf(((Element)data.get("PrepareMap")).attributeValue("value")).intValue();
/* 239 */       this.FightMap = Integer.valueOf(((Element)data.get("FightMap")).attributeValue("value")).intValue();
/* 240 */       this.Faction1EnterX = Integer.valueOf(((Element)data.get("Faction1EnterX")).attributeValue("value")).intValue();
/* 241 */       this.Faction1EnterY = Integer.valueOf(((Element)data.get("Faction1EnterY")).attributeValue("value")).intValue();
/* 242 */       this.Faction2EnterX = Integer.valueOf(((Element)data.get("Faction2EnterX")).attributeValue("value")).intValue();
/* 243 */       this.Faction2EnterY = Integer.valueOf(((Element)data.get("Faction2EnterY")).attributeValue("value")).intValue();
/* 244 */       this.PrepareBrdMinutes = Integer.valueOf(((Element)data.get("PrepareBrdMinutes")).attributeValue("value")).intValue();
/* 245 */       this.PrepareAward = Integer.valueOf(((Element)data.get("PrepareAward")).attributeValue("value")).intValue();
/* 246 */       this.PrepareAwardMinutes = Integer.valueOf(((Element)data.get("PrepareAwardMinutes")).attributeValue("value")).intValue();
/* 247 */       this.InitActionPoint = Integer.valueOf(((Element)data.get("InitActionPoint")).attributeValue("value")).intValue();
/* 248 */       this.DeductActionPointWhenEnterLate = Integer.valueOf(((Element)data.get("DeductActionPointWhenEnterLate")).attributeValue("value")).intValue();
/* 249 */       this.DeductActionPointWhenLose = Integer.valueOf(((Element)data.get("DeductActionPointWhenLose")).attributeValue("value")).intValue();
/* 250 */       this.DeductActionPointWhenPK = Integer.valueOf(((Element)data.get("DeductActionPointWhenPK")).attributeValue("value")).intValue();
/* 251 */       this.WinFightAward = Integer.valueOf(((Element)data.get("WinFightAward")).attributeValue("value")).intValue();
/* 252 */       this.LoseFightAward = Integer.valueOf(((Element)data.get("LoseFightAward")).attributeValue("value")).intValue();
/* 253 */       this.WinnerAward = Integer.valueOf(((Element)data.get("WinnerAward")).attributeValue("value")).intValue();
/* 254 */       this.LeaveAward = Integer.valueOf(((Element)data.get("LeaveAward")).attributeValue("value")).intValue();
/* 255 */       this.WinStreakTimes = Integer.valueOf(((Element)data.get("WinStreakTimes")).attributeValue("value")).intValue();
/* 256 */       this.WinStreakMail = Integer.valueOf(((Element)data.get("WinStreakMail")).attributeValue("value")).intValue();
/* 257 */       this.AgainstBeforeHours = Integer.valueOf(((Element)data.get("AgainstBeforeHours")).attributeValue("value")).intValue();
/* 258 */       this.PrepareStageMinutes = Integer.valueOf(((Element)data.get("PrepareStageMinutes")).attributeValue("value")).intValue();
/* 259 */       this.CompeteWaitStageMinutes = Integer.valueOf(((Element)data.get("CompeteWaitStageMinutes")).attributeValue("value")).intValue();
/* 260 */       this.CompeteNormalStageMinutes = Integer.valueOf(((Element)data.get("CompeteNormalStageMinutes")).attributeValue("value")).intValue();
/* 261 */       this.ShutdownCompeteBeforeEndMinutes = Integer.valueOf(((Element)data.get("ShutdownCompeteBeforeEndMinutes")).attributeValue("value")).intValue();
/* 262 */       this.TriggerMapItemSeconds = Integer.valueOf(((Element)data.get("TriggerMapItemSeconds")).attributeValue("value")).intValue();
/* 263 */       this.FactionAgainstMail = Integer.valueOf(((Element)data.get("FactionAgainstMail")).attributeValue("value")).intValue();
/* 264 */       this.MatchTimes = Integer.valueOf(((Element)data.get("MatchTimes")).attributeValue("value")).intValue();
/*     */       
/* 266 */       Element collectionElement = (Element)data.get("ItemControllers");
/* 267 */       if (collectionElement == null)
/*     */       {
/* 269 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 272 */       List<?> _nodeList = collectionElement.elements();
/* 273 */       int _len = _nodeList.size();
/* 274 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 276 */         Element elem = (Element)_nodeList.get(i);
/* 277 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.competition.confbean.ItemController"))
/*     */         {
/*     */           ItemController _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 284 */             _v_ = new ItemController();
/* 285 */             _v_.loadFromXml(elem);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 292 */           this.ItemControllers.add(_v_);
/*     */         }
/*     */       }
/* 295 */       this.CopperTreasureMapItem = Integer.valueOf(((Element)data.get("CopperTreasureMapItem")).attributeValue("value")).intValue();
/* 296 */       this.SilverTreasureMapItem = Integer.valueOf(((Element)data.get("SilverTreasureMapItem")).attributeValue("value")).intValue();
/* 297 */       this.GoldTreasureMapItem = Integer.valueOf(((Element)data.get("GoldTreasureMapItem")).attributeValue("value")).intValue();
/* 298 */       this.ELO_K = Integer.valueOf(((Element)data.get("ELO_K")).attributeValue("value")).intValue();
/* 299 */       this.NeedRoleActivePoint = Integer.valueOf(((Element)data.get("NeedRoleActivePoint")).attributeValue("value")).intValue();
/* 300 */       this.Activeness_A = Double.valueOf(((Element)data.get("Activeness_A")).attributeValue("value")).doubleValue();
/* 301 */       this.Activeness_B = Double.valueOf(((Element)data.get("Activeness_B")).attributeValue("value")).doubleValue();
/* 302 */       this.Max_GD = Integer.valueOf(((Element)data.get("Max_GD")).attributeValue("value")).intValue();
/* 303 */       this.WinnerFactionMoney = Integer.valueOf(((Element)data.get("WinnerFactionMoney")).attributeValue("value")).intValue();
/* 304 */       this.LoserFactionMoney = Integer.valueOf(((Element)data.get("LoserFactionMoney")).attributeValue("value")).intValue();
/* 305 */       this.WinnerFactionGift = Integer.valueOf(((Element)data.get("WinnerFactionGift")).attributeValue("value")).intValue();
/* 306 */       this.LoserFactionGift = Integer.valueOf(((Element)data.get("LoserFactionGift")).attributeValue("value")).intValue();
/* 307 */       this.WinFightExploit = Integer.valueOf(((Element)data.get("WinFightExploit")).attributeValue("value")).intValue();
/* 308 */       this.LoseFightExploit = Integer.valueOf(((Element)data.get("LoseFightExploit")).attributeValue("value")).intValue();
/* 309 */       this.ParticipateExploit = Integer.valueOf(((Element)data.get("ParticipateExploit")).attributeValue("value")).intValue();
/* 310 */       this.PkScoreA = Integer.valueOf(((Element)data.get("PkScoreA")).attributeValue("value")).intValue();
/* 311 */       this.PkScoreB = Integer.valueOf(((Element)data.get("PkScoreB")).attributeValue("value")).intValue();
/* 312 */       this.PlayerScoreA = Integer.valueOf(((Element)data.get("PlayerScoreA")).attributeValue("value")).intValue();
/* 313 */       this.PlayerScoreMinutes = Integer.valueOf(((Element)data.get("PlayerScoreMinutes")).attributeValue("value")).intValue();
/* 314 */       this.ProtectedBuff = Integer.valueOf(((Element)data.get("ProtectedBuff")).attributeValue("value")).intValue();
/* 315 */       this.MaxTreasureNum = Integer.valueOf(((Element)data.get("MaxTreasureNum")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 319 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 323 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 326 */     String path = dir + "mzm.gsp.competition.confbean.SCompetitionConsts.bny";
/*     */     try
/*     */     {
/* 329 */       File file = new File(path);
/* 330 */       if (file.exists())
/*     */       {
/* 332 */         byte[] bytes = new byte['Ѐ'];
/* 333 */         FileInputStream fis = new FileInputStream(file);
/* 334 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 335 */         int len = 0;
/* 336 */         while ((len = fis.read(bytes)) > 0)
/* 337 */           baos.write(bytes, 0, len);
/* 338 */         fis.close();
/* 339 */         bytes = baos.toByteArray();
/* 340 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 341 */         this.Activityid = _os_.unmarshal_int();
/* 342 */         this.CreateDays = _os_.unmarshal_int();
/* 343 */         this.Scale = _os_.unmarshal_int();
/* 344 */         this.MemberNumber = _os_.unmarshal_int();
/* 345 */         this.Liveness = _os_.unmarshal_int();
/* 346 */         this.PlayerNumberOfQualifiedLevel = _os_.unmarshal_int();
/* 347 */         this.JoinDays = _os_.unmarshal_int();
/* 348 */         this.ControllerIn = _os_.unmarshal_int();
/* 349 */         this.PrepareMap = _os_.unmarshal_int();
/* 350 */         this.FightMap = _os_.unmarshal_int();
/* 351 */         this.Faction1EnterX = _os_.unmarshal_int();
/* 352 */         this.Faction1EnterY = _os_.unmarshal_int();
/* 353 */         this.Faction2EnterX = _os_.unmarshal_int();
/* 354 */         this.Faction2EnterY = _os_.unmarshal_int();
/* 355 */         this.PrepareBrdMinutes = _os_.unmarshal_int();
/* 356 */         this.PrepareAward = _os_.unmarshal_int();
/* 357 */         this.PrepareAwardMinutes = _os_.unmarshal_int();
/* 358 */         this.InitActionPoint = _os_.unmarshal_int();
/* 359 */         this.DeductActionPointWhenEnterLate = _os_.unmarshal_int();
/* 360 */         this.DeductActionPointWhenLose = _os_.unmarshal_int();
/* 361 */         this.DeductActionPointWhenPK = _os_.unmarshal_int();
/* 362 */         this.WinFightAward = _os_.unmarshal_int();
/* 363 */         this.LoseFightAward = _os_.unmarshal_int();
/* 364 */         this.WinnerAward = _os_.unmarshal_int();
/* 365 */         this.LeaveAward = _os_.unmarshal_int();
/* 366 */         this.WinStreakTimes = _os_.unmarshal_int();
/* 367 */         this.WinStreakMail = _os_.unmarshal_int();
/* 368 */         this.AgainstBeforeHours = _os_.unmarshal_int();
/* 369 */         this.PrepareStageMinutes = _os_.unmarshal_int();
/* 370 */         this.CompeteWaitStageMinutes = _os_.unmarshal_int();
/* 371 */         this.CompeteNormalStageMinutes = _os_.unmarshal_int();
/* 372 */         this.ShutdownCompeteBeforeEndMinutes = _os_.unmarshal_int();
/* 373 */         this.TriggerMapItemSeconds = _os_.unmarshal_int();
/* 374 */         this.FactionAgainstMail = _os_.unmarshal_int();
/* 375 */         this.MatchTimes = _os_.unmarshal_int();
/* 376 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 379 */           ItemController _v_ = new ItemController();
/* 380 */           _v_.unmarshal(_os_);
/* 381 */           this.ItemControllers.add(_v_);
/*     */         }
/* 383 */         this.CopperTreasureMapItem = _os_.unmarshal_int();
/* 384 */         this.SilverTreasureMapItem = _os_.unmarshal_int();
/* 385 */         this.GoldTreasureMapItem = _os_.unmarshal_int();
/* 386 */         this.ELO_K = _os_.unmarshal_int();
/* 387 */         this.NeedRoleActivePoint = _os_.unmarshal_int();
/* 388 */         this.Activeness_A = _os_.unmarshal_float();
/* 389 */         this.Activeness_B = _os_.unmarshal_float();
/* 390 */         this.Max_GD = _os_.unmarshal_int();
/* 391 */         this.WinnerFactionMoney = _os_.unmarshal_int();
/* 392 */         this.LoserFactionMoney = _os_.unmarshal_int();
/* 393 */         this.WinnerFactionGift = _os_.unmarshal_int();
/* 394 */         this.LoserFactionGift = _os_.unmarshal_int();
/* 395 */         this.WinFightExploit = _os_.unmarshal_int();
/* 396 */         this.LoseFightExploit = _os_.unmarshal_int();
/* 397 */         this.ParticipateExploit = _os_.unmarshal_int();
/* 398 */         this.PkScoreA = _os_.unmarshal_int();
/* 399 */         this.PkScoreB = _os_.unmarshal_int();
/* 400 */         this.PlayerScoreA = _os_.unmarshal_int();
/* 401 */         this.PlayerScoreMinutes = _os_.unmarshal_int();
/* 402 */         this.ProtectedBuff = _os_.unmarshal_int();
/* 403 */         this.MaxTreasureNum = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 408 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 414 */     String path = dir + "mzm.gsp.competition.confbean.SCompetitionConsts.bny";
/*     */     try
/*     */     {
/* 417 */       File file = new File(path);
/* 418 */       if (file.exists())
/*     */       {
/* 420 */         byte[] bytes = new byte['Ѐ'];
/* 421 */         FileInputStream fis = new FileInputStream(file);
/* 422 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 423 */         int len = 0;
/* 424 */         while ((len = fis.read(bytes)) > 0)
/* 425 */           baos.write(bytes, 0, len);
/* 426 */         fis.close();
/* 427 */         bytes = baos.toByteArray();
/* 428 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 429 */         this.Activityid = _os_.unmarshal_int();
/* 430 */         this.CreateDays = _os_.unmarshal_int();
/* 431 */         this.Scale = _os_.unmarshal_int();
/* 432 */         this.MemberNumber = _os_.unmarshal_int();
/* 433 */         this.Liveness = _os_.unmarshal_int();
/* 434 */         this.PlayerNumberOfQualifiedLevel = _os_.unmarshal_int();
/* 435 */         this.JoinDays = _os_.unmarshal_int();
/* 436 */         this.ControllerIn = _os_.unmarshal_int();
/* 437 */         this.PrepareMap = _os_.unmarshal_int();
/* 438 */         this.FightMap = _os_.unmarshal_int();
/* 439 */         this.Faction1EnterX = _os_.unmarshal_int();
/* 440 */         this.Faction1EnterY = _os_.unmarshal_int();
/* 441 */         this.Faction2EnterX = _os_.unmarshal_int();
/* 442 */         this.Faction2EnterY = _os_.unmarshal_int();
/* 443 */         this.PrepareBrdMinutes = _os_.unmarshal_int();
/* 444 */         this.PrepareAward = _os_.unmarshal_int();
/* 445 */         this.PrepareAwardMinutes = _os_.unmarshal_int();
/* 446 */         this.InitActionPoint = _os_.unmarshal_int();
/* 447 */         this.DeductActionPointWhenEnterLate = _os_.unmarshal_int();
/* 448 */         this.DeductActionPointWhenLose = _os_.unmarshal_int();
/* 449 */         this.DeductActionPointWhenPK = _os_.unmarshal_int();
/* 450 */         this.WinFightAward = _os_.unmarshal_int();
/* 451 */         this.LoseFightAward = _os_.unmarshal_int();
/* 452 */         this.WinnerAward = _os_.unmarshal_int();
/* 453 */         this.LeaveAward = _os_.unmarshal_int();
/* 454 */         this.WinStreakTimes = _os_.unmarshal_int();
/* 455 */         this.WinStreakMail = _os_.unmarshal_int();
/* 456 */         this.AgainstBeforeHours = _os_.unmarshal_int();
/* 457 */         this.PrepareStageMinutes = _os_.unmarshal_int();
/* 458 */         this.CompeteWaitStageMinutes = _os_.unmarshal_int();
/* 459 */         this.CompeteNormalStageMinutes = _os_.unmarshal_int();
/* 460 */         this.ShutdownCompeteBeforeEndMinutes = _os_.unmarshal_int();
/* 461 */         this.TriggerMapItemSeconds = _os_.unmarshal_int();
/* 462 */         this.FactionAgainstMail = _os_.unmarshal_int();
/* 463 */         this.MatchTimes = _os_.unmarshal_int();
/* 464 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 467 */           ItemController _v_ = new ItemController();
/* 468 */           _v_.unmarshal(_os_);
/* 469 */           this.ItemControllers.add(_v_);
/*     */         }
/* 471 */         this.CopperTreasureMapItem = _os_.unmarshal_int();
/* 472 */         this.SilverTreasureMapItem = _os_.unmarshal_int();
/* 473 */         this.GoldTreasureMapItem = _os_.unmarshal_int();
/* 474 */         this.ELO_K = _os_.unmarshal_int();
/* 475 */         this.NeedRoleActivePoint = _os_.unmarshal_int();
/* 476 */         this.Activeness_A = _os_.unmarshal_float();
/* 477 */         this.Activeness_B = _os_.unmarshal_float();
/* 478 */         this.Max_GD = _os_.unmarshal_int();
/* 479 */         this.WinnerFactionMoney = _os_.unmarshal_int();
/* 480 */         this.LoserFactionMoney = _os_.unmarshal_int();
/* 481 */         this.WinnerFactionGift = _os_.unmarshal_int();
/* 482 */         this.LoserFactionGift = _os_.unmarshal_int();
/* 483 */         this.WinFightExploit = _os_.unmarshal_int();
/* 484 */         this.LoseFightExploit = _os_.unmarshal_int();
/* 485 */         this.ParticipateExploit = _os_.unmarshal_int();
/* 486 */         this.PkScoreA = _os_.unmarshal_int();
/* 487 */         this.PkScoreB = _os_.unmarshal_int();
/* 488 */         this.PlayerScoreA = _os_.unmarshal_int();
/* 489 */         this.PlayerScoreMinutes = _os_.unmarshal_int();
/* 490 */         this.ProtectedBuff = _os_.unmarshal_int();
/* 491 */         this.MaxTreasureNum = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 496 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SCompetitionConsts newInstance)
/*     */   {
/* 502 */     oldInstance = instance;
/* 503 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 508 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\confbean\SCompetitionConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */