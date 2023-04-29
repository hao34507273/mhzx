/*     */ package mzm.gsp.crosscompete.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SCrossCompeteConsts
/*     */ {
/*  13 */   private static volatile SCrossCompeteConsts oldInstance = null;
/*     */   
/*  15 */   private static SCrossCompeteConsts instance = new SCrossCompeteConsts();
/*     */   public int Activityid;
/*     */   public int CreateDays;
/*     */   public int Scale;
/*     */   public int Liveness;
/*     */   public int MinusSeverLevel;
/*     */   
/*     */   public static SCrossCompeteConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SCrossCompeteConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int PlayerNumberOfQualifiedLevel;
/*     */   
/*     */   public int SignUpMail;
/*     */   
/*     */   public int ScaleFailMail;
/*     */   
/*     */   public int LivenessFailMail;
/*     */   
/*     */   public int PlayerNumberFailMail;
/*     */   public int MatchMail;
/*     */   public int RemindMail;
/*     */   public int MissTurnMail;
/*     */   public int JoinDays;
/*     */   public int ControllerIn;
/*     */   public int PrepareMap;
/*     */   public int FightMap;
/*     */   public int Faction1EnterX;
/*     */   public int Faction1EnterY;
/*     */   public int Faction2EnterX;
/*     */   public int Faction2EnterY;
/*     */   public int PrepareBrdMinutes;
/*     */   public int InitActionPoint;
/*     */   public int DeductActionPointWhenLose;
/*     */   public int DeductActionPointWhenPK;
/*     */   public int WinnerAwardMail;
/*     */   public int LeaveAwardMail;
/*     */   public int WinStreakTimes;
/*     */   public int WinStreakMail;
/*     */   public int FightAwardMail;
/*     */   public int WinStreakAward;
/*     */   public int WinFightAward;
/*     */   public int LoseFightAward;
/*     */   public int SignUpDays;
/*     */   public int MatchHours;
/*     */   public int MailRemindHours;
/*     */   public int WaitMinutes;
/*     */   public int PrepareMinutes;
/*     */   public int ProtectedMinutes;
/*     */   public int FightMinutes;
/*     */   public int WaitForceEndMinutes;
/*     */   public int TriggerMapItemSeconds;
/*     */   public int RestMinutes;
/*     */   public int MaxCompeteCountOfOneTime;
/*     */   public int EarlyCreateFactionMinutes;
/*  76 */   public java.util.ArrayList<ItemController> ItemControllers = new java.util.ArrayList();
/*     */   public int FactionAgainstMail;
/*     */   public int MatchTimes;
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
/*  99 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/* 104 */     String path = dir + "mzm.gsp.crosscompete.confbean.SCrossCompeteConsts.xml";
/*     */     try
/*     */     {
/* 107 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 108 */       org.dom4j.Document doc = reader.read(new File(path));
/* 109 */       Element root = doc.getRootElement();
/* 110 */       Map<String, Element> data = new java.util.HashMap();
/* 111 */       List<?> nodeList = root.elements();
/* 112 */       int len = nodeList.size();
/* 113 */       for (int i = 0; i < len; i++)
/*     */       {
/* 115 */         Element element = (Element)nodeList.get(i);
/* 116 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 119 */           String name = element.attributeValue("name");
/* 120 */           if (data.put(name, element) != null)
/* 121 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 124 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/* 125 */       this.CreateDays = Integer.valueOf(((Element)data.get("CreateDays")).attributeValue("value")).intValue();
/* 126 */       this.Scale = Integer.valueOf(((Element)data.get("Scale")).attributeValue("value")).intValue();
/* 127 */       this.Liveness = Integer.valueOf(((Element)data.get("Liveness")).attributeValue("value")).intValue();
/* 128 */       this.MinusSeverLevel = Integer.valueOf(((Element)data.get("MinusSeverLevel")).attributeValue("value")).intValue();
/* 129 */       this.PlayerNumberOfQualifiedLevel = Integer.valueOf(((Element)data.get("PlayerNumberOfQualifiedLevel")).attributeValue("value")).intValue();
/* 130 */       this.SignUpMail = Integer.valueOf(((Element)data.get("SignUpMail")).attributeValue("value")).intValue();
/* 131 */       this.ScaleFailMail = Integer.valueOf(((Element)data.get("ScaleFailMail")).attributeValue("value")).intValue();
/* 132 */       this.LivenessFailMail = Integer.valueOf(((Element)data.get("LivenessFailMail")).attributeValue("value")).intValue();
/* 133 */       this.PlayerNumberFailMail = Integer.valueOf(((Element)data.get("PlayerNumberFailMail")).attributeValue("value")).intValue();
/* 134 */       this.MatchMail = Integer.valueOf(((Element)data.get("MatchMail")).attributeValue("value")).intValue();
/* 135 */       this.RemindMail = Integer.valueOf(((Element)data.get("RemindMail")).attributeValue("value")).intValue();
/* 136 */       this.MissTurnMail = Integer.valueOf(((Element)data.get("MissTurnMail")).attributeValue("value")).intValue();
/* 137 */       this.JoinDays = Integer.valueOf(((Element)data.get("JoinDays")).attributeValue("value")).intValue();
/* 138 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/* 139 */       this.PrepareMap = Integer.valueOf(((Element)data.get("PrepareMap")).attributeValue("value")).intValue();
/* 140 */       this.FightMap = Integer.valueOf(((Element)data.get("FightMap")).attributeValue("value")).intValue();
/* 141 */       this.Faction1EnterX = Integer.valueOf(((Element)data.get("Faction1EnterX")).attributeValue("value")).intValue();
/* 142 */       this.Faction1EnterY = Integer.valueOf(((Element)data.get("Faction1EnterY")).attributeValue("value")).intValue();
/* 143 */       this.Faction2EnterX = Integer.valueOf(((Element)data.get("Faction2EnterX")).attributeValue("value")).intValue();
/* 144 */       this.Faction2EnterY = Integer.valueOf(((Element)data.get("Faction2EnterY")).attributeValue("value")).intValue();
/* 145 */       this.PrepareBrdMinutes = Integer.valueOf(((Element)data.get("PrepareBrdMinutes")).attributeValue("value")).intValue();
/* 146 */       this.InitActionPoint = Integer.valueOf(((Element)data.get("InitActionPoint")).attributeValue("value")).intValue();
/* 147 */       this.DeductActionPointWhenLose = Integer.valueOf(((Element)data.get("DeductActionPointWhenLose")).attributeValue("value")).intValue();
/* 148 */       this.DeductActionPointWhenPK = Integer.valueOf(((Element)data.get("DeductActionPointWhenPK")).attributeValue("value")).intValue();
/* 149 */       this.WinnerAwardMail = Integer.valueOf(((Element)data.get("WinnerAwardMail")).attributeValue("value")).intValue();
/* 150 */       this.LeaveAwardMail = Integer.valueOf(((Element)data.get("LeaveAwardMail")).attributeValue("value")).intValue();
/* 151 */       this.WinStreakTimes = Integer.valueOf(((Element)data.get("WinStreakTimes")).attributeValue("value")).intValue();
/* 152 */       this.WinStreakMail = Integer.valueOf(((Element)data.get("WinStreakMail")).attributeValue("value")).intValue();
/* 153 */       this.FightAwardMail = Integer.valueOf(((Element)data.get("FightAwardMail")).attributeValue("value")).intValue();
/* 154 */       this.WinStreakAward = Integer.valueOf(((Element)data.get("WinStreakAward")).attributeValue("value")).intValue();
/* 155 */       this.WinFightAward = Integer.valueOf(((Element)data.get("WinFightAward")).attributeValue("value")).intValue();
/* 156 */       this.LoseFightAward = Integer.valueOf(((Element)data.get("LoseFightAward")).attributeValue("value")).intValue();
/* 157 */       this.SignUpDays = Integer.valueOf(((Element)data.get("SignUpDays")).attributeValue("value")).intValue();
/* 158 */       this.MatchHours = Integer.valueOf(((Element)data.get("MatchHours")).attributeValue("value")).intValue();
/* 159 */       this.MailRemindHours = Integer.valueOf(((Element)data.get("MailRemindHours")).attributeValue("value")).intValue();
/* 160 */       this.WaitMinutes = Integer.valueOf(((Element)data.get("WaitMinutes")).attributeValue("value")).intValue();
/* 161 */       this.PrepareMinutes = Integer.valueOf(((Element)data.get("PrepareMinutes")).attributeValue("value")).intValue();
/* 162 */       this.ProtectedMinutes = Integer.valueOf(((Element)data.get("ProtectedMinutes")).attributeValue("value")).intValue();
/* 163 */       this.FightMinutes = Integer.valueOf(((Element)data.get("FightMinutes")).attributeValue("value")).intValue();
/* 164 */       this.WaitForceEndMinutes = Integer.valueOf(((Element)data.get("WaitForceEndMinutes")).attributeValue("value")).intValue();
/* 165 */       this.TriggerMapItemSeconds = Integer.valueOf(((Element)data.get("TriggerMapItemSeconds")).attributeValue("value")).intValue();
/* 166 */       this.RestMinutes = Integer.valueOf(((Element)data.get("RestMinutes")).attributeValue("value")).intValue();
/* 167 */       this.MaxCompeteCountOfOneTime = Integer.valueOf(((Element)data.get("MaxCompeteCountOfOneTime")).attributeValue("value")).intValue();
/* 168 */       this.EarlyCreateFactionMinutes = Integer.valueOf(((Element)data.get("EarlyCreateFactionMinutes")).attributeValue("value")).intValue();
/*     */       
/* 170 */       Element collectionElement = (Element)data.get("ItemControllers");
/* 171 */       if (collectionElement == null)
/*     */       {
/* 173 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 176 */       List<?> _nodeList = collectionElement.elements();
/* 177 */       int _len = _nodeList.size();
/* 178 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 180 */         Element elem = (Element)_nodeList.get(i);
/* 181 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crosscompete.confbean.ItemController"))
/*     */         {
/*     */           ItemController _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 188 */             _v_ = new ItemController();
/* 189 */             _v_.loadFromXml(elem);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 196 */           this.ItemControllers.add(_v_);
/*     */         }
/*     */       }
/* 199 */       this.FactionAgainstMail = Integer.valueOf(((Element)data.get("FactionAgainstMail")).attributeValue("value")).intValue();
/* 200 */       this.MatchTimes = Integer.valueOf(((Element)data.get("MatchTimes")).attributeValue("value")).intValue();
/* 201 */       this.NeedRoleActivePoint = Integer.valueOf(((Element)data.get("NeedRoleActivePoint")).attributeValue("value")).intValue();
/* 202 */       this.Activeness_A = Double.valueOf(((Element)data.get("Activeness_A")).attributeValue("value")).doubleValue();
/* 203 */       this.Activeness_B = Double.valueOf(((Element)data.get("Activeness_B")).attributeValue("value")).doubleValue();
/* 204 */       this.Max_GD = Integer.valueOf(((Element)data.get("Max_GD")).attributeValue("value")).intValue();
/* 205 */       this.WinnerFactionMoney = Integer.valueOf(((Element)data.get("WinnerFactionMoney")).attributeValue("value")).intValue();
/* 206 */       this.LoserFactionMoney = Integer.valueOf(((Element)data.get("LoserFactionMoney")).attributeValue("value")).intValue();
/* 207 */       this.WinnerFactionGift = Integer.valueOf(((Element)data.get("WinnerFactionGift")).attributeValue("value")).intValue();
/* 208 */       this.LoserFactionGift = Integer.valueOf(((Element)data.get("LoserFactionGift")).attributeValue("value")).intValue();
/* 209 */       this.WinFightExploit = Integer.valueOf(((Element)data.get("WinFightExploit")).attributeValue("value")).intValue();
/* 210 */       this.LoseFightExploit = Integer.valueOf(((Element)data.get("LoseFightExploit")).attributeValue("value")).intValue();
/* 211 */       this.ParticipateExploit = Integer.valueOf(((Element)data.get("ParticipateExploit")).attributeValue("value")).intValue();
/* 212 */       this.PkScoreA = Integer.valueOf(((Element)data.get("PkScoreA")).attributeValue("value")).intValue();
/* 213 */       this.PkScoreB = Integer.valueOf(((Element)data.get("PkScoreB")).attributeValue("value")).intValue();
/* 214 */       this.PlayerScoreA = Integer.valueOf(((Element)data.get("PlayerScoreA")).attributeValue("value")).intValue();
/* 215 */       this.PlayerScoreMinutes = Integer.valueOf(((Element)data.get("PlayerScoreMinutes")).attributeValue("value")).intValue();
/* 216 */       this.ProtectedBuff = Integer.valueOf(((Element)data.get("ProtectedBuff")).attributeValue("value")).intValue();
/* 217 */       this.MaxTreasureNum = Integer.valueOf(((Element)data.get("MaxTreasureNum")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 221 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 226 */     String path = dir + "mzm.gsp.crosscompete.confbean.SCrossCompeteConsts.xml";
/*     */     try
/*     */     {
/* 229 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 230 */       org.dom4j.Document doc = reader.read(new File(path));
/* 231 */       Element root = doc.getRootElement();
/* 232 */       Map<String, Element> data = new java.util.HashMap();
/* 233 */       List<?> nodeList = root.elements();
/* 234 */       int len = nodeList.size();
/* 235 */       for (int i = 0; i < len; i++)
/*     */       {
/* 237 */         Element element = (Element)nodeList.get(i);
/* 238 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 241 */           String name = element.attributeValue("name");
/* 242 */           if (data.put(name, element) != null)
/* 243 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 246 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/* 247 */       this.CreateDays = Integer.valueOf(((Element)data.get("CreateDays")).attributeValue("value")).intValue();
/* 248 */       this.Scale = Integer.valueOf(((Element)data.get("Scale")).attributeValue("value")).intValue();
/* 249 */       this.Liveness = Integer.valueOf(((Element)data.get("Liveness")).attributeValue("value")).intValue();
/* 250 */       this.MinusSeverLevel = Integer.valueOf(((Element)data.get("MinusSeverLevel")).attributeValue("value")).intValue();
/* 251 */       this.PlayerNumberOfQualifiedLevel = Integer.valueOf(((Element)data.get("PlayerNumberOfQualifiedLevel")).attributeValue("value")).intValue();
/* 252 */       this.SignUpMail = Integer.valueOf(((Element)data.get("SignUpMail")).attributeValue("value")).intValue();
/* 253 */       this.ScaleFailMail = Integer.valueOf(((Element)data.get("ScaleFailMail")).attributeValue("value")).intValue();
/* 254 */       this.LivenessFailMail = Integer.valueOf(((Element)data.get("LivenessFailMail")).attributeValue("value")).intValue();
/* 255 */       this.PlayerNumberFailMail = Integer.valueOf(((Element)data.get("PlayerNumberFailMail")).attributeValue("value")).intValue();
/* 256 */       this.MatchMail = Integer.valueOf(((Element)data.get("MatchMail")).attributeValue("value")).intValue();
/* 257 */       this.RemindMail = Integer.valueOf(((Element)data.get("RemindMail")).attributeValue("value")).intValue();
/* 258 */       this.MissTurnMail = Integer.valueOf(((Element)data.get("MissTurnMail")).attributeValue("value")).intValue();
/* 259 */       this.JoinDays = Integer.valueOf(((Element)data.get("JoinDays")).attributeValue("value")).intValue();
/* 260 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/* 261 */       this.PrepareMap = Integer.valueOf(((Element)data.get("PrepareMap")).attributeValue("value")).intValue();
/* 262 */       this.FightMap = Integer.valueOf(((Element)data.get("FightMap")).attributeValue("value")).intValue();
/* 263 */       this.Faction1EnterX = Integer.valueOf(((Element)data.get("Faction1EnterX")).attributeValue("value")).intValue();
/* 264 */       this.Faction1EnterY = Integer.valueOf(((Element)data.get("Faction1EnterY")).attributeValue("value")).intValue();
/* 265 */       this.Faction2EnterX = Integer.valueOf(((Element)data.get("Faction2EnterX")).attributeValue("value")).intValue();
/* 266 */       this.Faction2EnterY = Integer.valueOf(((Element)data.get("Faction2EnterY")).attributeValue("value")).intValue();
/* 267 */       this.PrepareBrdMinutes = Integer.valueOf(((Element)data.get("PrepareBrdMinutes")).attributeValue("value")).intValue();
/* 268 */       this.InitActionPoint = Integer.valueOf(((Element)data.get("InitActionPoint")).attributeValue("value")).intValue();
/* 269 */       this.DeductActionPointWhenLose = Integer.valueOf(((Element)data.get("DeductActionPointWhenLose")).attributeValue("value")).intValue();
/* 270 */       this.DeductActionPointWhenPK = Integer.valueOf(((Element)data.get("DeductActionPointWhenPK")).attributeValue("value")).intValue();
/* 271 */       this.WinnerAwardMail = Integer.valueOf(((Element)data.get("WinnerAwardMail")).attributeValue("value")).intValue();
/* 272 */       this.LeaveAwardMail = Integer.valueOf(((Element)data.get("LeaveAwardMail")).attributeValue("value")).intValue();
/* 273 */       this.WinStreakTimes = Integer.valueOf(((Element)data.get("WinStreakTimes")).attributeValue("value")).intValue();
/* 274 */       this.WinStreakMail = Integer.valueOf(((Element)data.get("WinStreakMail")).attributeValue("value")).intValue();
/* 275 */       this.FightAwardMail = Integer.valueOf(((Element)data.get("FightAwardMail")).attributeValue("value")).intValue();
/* 276 */       this.WinStreakAward = Integer.valueOf(((Element)data.get("WinStreakAward")).attributeValue("value")).intValue();
/* 277 */       this.WinFightAward = Integer.valueOf(((Element)data.get("WinFightAward")).attributeValue("value")).intValue();
/* 278 */       this.LoseFightAward = Integer.valueOf(((Element)data.get("LoseFightAward")).attributeValue("value")).intValue();
/* 279 */       this.SignUpDays = Integer.valueOf(((Element)data.get("SignUpDays")).attributeValue("value")).intValue();
/* 280 */       this.MatchHours = Integer.valueOf(((Element)data.get("MatchHours")).attributeValue("value")).intValue();
/* 281 */       this.MailRemindHours = Integer.valueOf(((Element)data.get("MailRemindHours")).attributeValue("value")).intValue();
/* 282 */       this.WaitMinutes = Integer.valueOf(((Element)data.get("WaitMinutes")).attributeValue("value")).intValue();
/* 283 */       this.PrepareMinutes = Integer.valueOf(((Element)data.get("PrepareMinutes")).attributeValue("value")).intValue();
/* 284 */       this.ProtectedMinutes = Integer.valueOf(((Element)data.get("ProtectedMinutes")).attributeValue("value")).intValue();
/* 285 */       this.FightMinutes = Integer.valueOf(((Element)data.get("FightMinutes")).attributeValue("value")).intValue();
/* 286 */       this.WaitForceEndMinutes = Integer.valueOf(((Element)data.get("WaitForceEndMinutes")).attributeValue("value")).intValue();
/* 287 */       this.TriggerMapItemSeconds = Integer.valueOf(((Element)data.get("TriggerMapItemSeconds")).attributeValue("value")).intValue();
/* 288 */       this.RestMinutes = Integer.valueOf(((Element)data.get("RestMinutes")).attributeValue("value")).intValue();
/* 289 */       this.MaxCompeteCountOfOneTime = Integer.valueOf(((Element)data.get("MaxCompeteCountOfOneTime")).attributeValue("value")).intValue();
/* 290 */       this.EarlyCreateFactionMinutes = Integer.valueOf(((Element)data.get("EarlyCreateFactionMinutes")).attributeValue("value")).intValue();
/*     */       
/* 292 */       Element collectionElement = (Element)data.get("ItemControllers");
/* 293 */       if (collectionElement == null)
/*     */       {
/* 295 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 298 */       List<?> _nodeList = collectionElement.elements();
/* 299 */       int _len = _nodeList.size();
/* 300 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 302 */         Element elem = (Element)_nodeList.get(i);
/* 303 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crosscompete.confbean.ItemController"))
/*     */         {
/*     */           ItemController _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 310 */             _v_ = new ItemController();
/* 311 */             _v_.loadFromXml(elem);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 318 */           this.ItemControllers.add(_v_);
/*     */         }
/*     */       }
/* 321 */       this.FactionAgainstMail = Integer.valueOf(((Element)data.get("FactionAgainstMail")).attributeValue("value")).intValue();
/* 322 */       this.MatchTimes = Integer.valueOf(((Element)data.get("MatchTimes")).attributeValue("value")).intValue();
/* 323 */       this.NeedRoleActivePoint = Integer.valueOf(((Element)data.get("NeedRoleActivePoint")).attributeValue("value")).intValue();
/* 324 */       this.Activeness_A = Double.valueOf(((Element)data.get("Activeness_A")).attributeValue("value")).doubleValue();
/* 325 */       this.Activeness_B = Double.valueOf(((Element)data.get("Activeness_B")).attributeValue("value")).doubleValue();
/* 326 */       this.Max_GD = Integer.valueOf(((Element)data.get("Max_GD")).attributeValue("value")).intValue();
/* 327 */       this.WinnerFactionMoney = Integer.valueOf(((Element)data.get("WinnerFactionMoney")).attributeValue("value")).intValue();
/* 328 */       this.LoserFactionMoney = Integer.valueOf(((Element)data.get("LoserFactionMoney")).attributeValue("value")).intValue();
/* 329 */       this.WinnerFactionGift = Integer.valueOf(((Element)data.get("WinnerFactionGift")).attributeValue("value")).intValue();
/* 330 */       this.LoserFactionGift = Integer.valueOf(((Element)data.get("LoserFactionGift")).attributeValue("value")).intValue();
/* 331 */       this.WinFightExploit = Integer.valueOf(((Element)data.get("WinFightExploit")).attributeValue("value")).intValue();
/* 332 */       this.LoseFightExploit = Integer.valueOf(((Element)data.get("LoseFightExploit")).attributeValue("value")).intValue();
/* 333 */       this.ParticipateExploit = Integer.valueOf(((Element)data.get("ParticipateExploit")).attributeValue("value")).intValue();
/* 334 */       this.PkScoreA = Integer.valueOf(((Element)data.get("PkScoreA")).attributeValue("value")).intValue();
/* 335 */       this.PkScoreB = Integer.valueOf(((Element)data.get("PkScoreB")).attributeValue("value")).intValue();
/* 336 */       this.PlayerScoreA = Integer.valueOf(((Element)data.get("PlayerScoreA")).attributeValue("value")).intValue();
/* 337 */       this.PlayerScoreMinutes = Integer.valueOf(((Element)data.get("PlayerScoreMinutes")).attributeValue("value")).intValue();
/* 338 */       this.ProtectedBuff = Integer.valueOf(((Element)data.get("ProtectedBuff")).attributeValue("value")).intValue();
/* 339 */       this.MaxTreasureNum = Integer.valueOf(((Element)data.get("MaxTreasureNum")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 343 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 347 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 350 */     String path = dir + "mzm.gsp.crosscompete.confbean.SCrossCompeteConsts.bny";
/*     */     try
/*     */     {
/* 353 */       File file = new File(path);
/* 354 */       if (file.exists())
/*     */       {
/* 356 */         byte[] bytes = new byte['Ѐ'];
/* 357 */         FileInputStream fis = new FileInputStream(file);
/* 358 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 359 */         int len = 0;
/* 360 */         while ((len = fis.read(bytes)) > 0)
/* 361 */           baos.write(bytes, 0, len);
/* 362 */         fis.close();
/* 363 */         bytes = baos.toByteArray();
/* 364 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 365 */         this.Activityid = _os_.unmarshal_int();
/* 366 */         this.CreateDays = _os_.unmarshal_int();
/* 367 */         this.Scale = _os_.unmarshal_int();
/* 368 */         this.Liveness = _os_.unmarshal_int();
/* 369 */         this.MinusSeverLevel = _os_.unmarshal_int();
/* 370 */         this.PlayerNumberOfQualifiedLevel = _os_.unmarshal_int();
/* 371 */         this.SignUpMail = _os_.unmarshal_int();
/* 372 */         this.ScaleFailMail = _os_.unmarshal_int();
/* 373 */         this.LivenessFailMail = _os_.unmarshal_int();
/* 374 */         this.PlayerNumberFailMail = _os_.unmarshal_int();
/* 375 */         this.MatchMail = _os_.unmarshal_int();
/* 376 */         this.RemindMail = _os_.unmarshal_int();
/* 377 */         this.MissTurnMail = _os_.unmarshal_int();
/* 378 */         this.JoinDays = _os_.unmarshal_int();
/* 379 */         this.ControllerIn = _os_.unmarshal_int();
/* 380 */         this.PrepareMap = _os_.unmarshal_int();
/* 381 */         this.FightMap = _os_.unmarshal_int();
/* 382 */         this.Faction1EnterX = _os_.unmarshal_int();
/* 383 */         this.Faction1EnterY = _os_.unmarshal_int();
/* 384 */         this.Faction2EnterX = _os_.unmarshal_int();
/* 385 */         this.Faction2EnterY = _os_.unmarshal_int();
/* 386 */         this.PrepareBrdMinutes = _os_.unmarshal_int();
/* 387 */         this.InitActionPoint = _os_.unmarshal_int();
/* 388 */         this.DeductActionPointWhenLose = _os_.unmarshal_int();
/* 389 */         this.DeductActionPointWhenPK = _os_.unmarshal_int();
/* 390 */         this.WinnerAwardMail = _os_.unmarshal_int();
/* 391 */         this.LeaveAwardMail = _os_.unmarshal_int();
/* 392 */         this.WinStreakTimes = _os_.unmarshal_int();
/* 393 */         this.WinStreakMail = _os_.unmarshal_int();
/* 394 */         this.FightAwardMail = _os_.unmarshal_int();
/* 395 */         this.WinStreakAward = _os_.unmarshal_int();
/* 396 */         this.WinFightAward = _os_.unmarshal_int();
/* 397 */         this.LoseFightAward = _os_.unmarshal_int();
/* 398 */         this.SignUpDays = _os_.unmarshal_int();
/* 399 */         this.MatchHours = _os_.unmarshal_int();
/* 400 */         this.MailRemindHours = _os_.unmarshal_int();
/* 401 */         this.WaitMinutes = _os_.unmarshal_int();
/* 402 */         this.PrepareMinutes = _os_.unmarshal_int();
/* 403 */         this.ProtectedMinutes = _os_.unmarshal_int();
/* 404 */         this.FightMinutes = _os_.unmarshal_int();
/* 405 */         this.WaitForceEndMinutes = _os_.unmarshal_int();
/* 406 */         this.TriggerMapItemSeconds = _os_.unmarshal_int();
/* 407 */         this.RestMinutes = _os_.unmarshal_int();
/* 408 */         this.MaxCompeteCountOfOneTime = _os_.unmarshal_int();
/* 409 */         this.EarlyCreateFactionMinutes = _os_.unmarshal_int();
/* 410 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 413 */           ItemController _v_ = new ItemController();
/* 414 */           _v_.unmarshal(_os_);
/* 415 */           this.ItemControllers.add(_v_);
/*     */         }
/* 417 */         this.FactionAgainstMail = _os_.unmarshal_int();
/* 418 */         this.MatchTimes = _os_.unmarshal_int();
/* 419 */         this.NeedRoleActivePoint = _os_.unmarshal_int();
/* 420 */         this.Activeness_A = _os_.unmarshal_float();
/* 421 */         this.Activeness_B = _os_.unmarshal_float();
/* 422 */         this.Max_GD = _os_.unmarshal_int();
/* 423 */         this.WinnerFactionMoney = _os_.unmarshal_int();
/* 424 */         this.LoserFactionMoney = _os_.unmarshal_int();
/* 425 */         this.WinnerFactionGift = _os_.unmarshal_int();
/* 426 */         this.LoserFactionGift = _os_.unmarshal_int();
/* 427 */         this.WinFightExploit = _os_.unmarshal_int();
/* 428 */         this.LoseFightExploit = _os_.unmarshal_int();
/* 429 */         this.ParticipateExploit = _os_.unmarshal_int();
/* 430 */         this.PkScoreA = _os_.unmarshal_int();
/* 431 */         this.PkScoreB = _os_.unmarshal_int();
/* 432 */         this.PlayerScoreA = _os_.unmarshal_int();
/* 433 */         this.PlayerScoreMinutes = _os_.unmarshal_int();
/* 434 */         this.ProtectedBuff = _os_.unmarshal_int();
/* 435 */         this.MaxTreasureNum = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 440 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 446 */     String path = dir + "mzm.gsp.crosscompete.confbean.SCrossCompeteConsts.bny";
/*     */     try
/*     */     {
/* 449 */       File file = new File(path);
/* 450 */       if (file.exists())
/*     */       {
/* 452 */         byte[] bytes = new byte['Ѐ'];
/* 453 */         FileInputStream fis = new FileInputStream(file);
/* 454 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 455 */         int len = 0;
/* 456 */         while ((len = fis.read(bytes)) > 0)
/* 457 */           baos.write(bytes, 0, len);
/* 458 */         fis.close();
/* 459 */         bytes = baos.toByteArray();
/* 460 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 461 */         this.Activityid = _os_.unmarshal_int();
/* 462 */         this.CreateDays = _os_.unmarshal_int();
/* 463 */         this.Scale = _os_.unmarshal_int();
/* 464 */         this.Liveness = _os_.unmarshal_int();
/* 465 */         this.MinusSeverLevel = _os_.unmarshal_int();
/* 466 */         this.PlayerNumberOfQualifiedLevel = _os_.unmarshal_int();
/* 467 */         this.SignUpMail = _os_.unmarshal_int();
/* 468 */         this.ScaleFailMail = _os_.unmarshal_int();
/* 469 */         this.LivenessFailMail = _os_.unmarshal_int();
/* 470 */         this.PlayerNumberFailMail = _os_.unmarshal_int();
/* 471 */         this.MatchMail = _os_.unmarshal_int();
/* 472 */         this.RemindMail = _os_.unmarshal_int();
/* 473 */         this.MissTurnMail = _os_.unmarshal_int();
/* 474 */         this.JoinDays = _os_.unmarshal_int();
/* 475 */         this.ControllerIn = _os_.unmarshal_int();
/* 476 */         this.PrepareMap = _os_.unmarshal_int();
/* 477 */         this.FightMap = _os_.unmarshal_int();
/* 478 */         this.Faction1EnterX = _os_.unmarshal_int();
/* 479 */         this.Faction1EnterY = _os_.unmarshal_int();
/* 480 */         this.Faction2EnterX = _os_.unmarshal_int();
/* 481 */         this.Faction2EnterY = _os_.unmarshal_int();
/* 482 */         this.PrepareBrdMinutes = _os_.unmarshal_int();
/* 483 */         this.InitActionPoint = _os_.unmarshal_int();
/* 484 */         this.DeductActionPointWhenLose = _os_.unmarshal_int();
/* 485 */         this.DeductActionPointWhenPK = _os_.unmarshal_int();
/* 486 */         this.WinnerAwardMail = _os_.unmarshal_int();
/* 487 */         this.LeaveAwardMail = _os_.unmarshal_int();
/* 488 */         this.WinStreakTimes = _os_.unmarshal_int();
/* 489 */         this.WinStreakMail = _os_.unmarshal_int();
/* 490 */         this.FightAwardMail = _os_.unmarshal_int();
/* 491 */         this.WinStreakAward = _os_.unmarshal_int();
/* 492 */         this.WinFightAward = _os_.unmarshal_int();
/* 493 */         this.LoseFightAward = _os_.unmarshal_int();
/* 494 */         this.SignUpDays = _os_.unmarshal_int();
/* 495 */         this.MatchHours = _os_.unmarshal_int();
/* 496 */         this.MailRemindHours = _os_.unmarshal_int();
/* 497 */         this.WaitMinutes = _os_.unmarshal_int();
/* 498 */         this.PrepareMinutes = _os_.unmarshal_int();
/* 499 */         this.ProtectedMinutes = _os_.unmarshal_int();
/* 500 */         this.FightMinutes = _os_.unmarshal_int();
/* 501 */         this.WaitForceEndMinutes = _os_.unmarshal_int();
/* 502 */         this.TriggerMapItemSeconds = _os_.unmarshal_int();
/* 503 */         this.RestMinutes = _os_.unmarshal_int();
/* 504 */         this.MaxCompeteCountOfOneTime = _os_.unmarshal_int();
/* 505 */         this.EarlyCreateFactionMinutes = _os_.unmarshal_int();
/* 506 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 509 */           ItemController _v_ = new ItemController();
/* 510 */           _v_.unmarshal(_os_);
/* 511 */           this.ItemControllers.add(_v_);
/*     */         }
/* 513 */         this.FactionAgainstMail = _os_.unmarshal_int();
/* 514 */         this.MatchTimes = _os_.unmarshal_int();
/* 515 */         this.NeedRoleActivePoint = _os_.unmarshal_int();
/* 516 */         this.Activeness_A = _os_.unmarshal_float();
/* 517 */         this.Activeness_B = _os_.unmarshal_float();
/* 518 */         this.Max_GD = _os_.unmarshal_int();
/* 519 */         this.WinnerFactionMoney = _os_.unmarshal_int();
/* 520 */         this.LoserFactionMoney = _os_.unmarshal_int();
/* 521 */         this.WinnerFactionGift = _os_.unmarshal_int();
/* 522 */         this.LoserFactionGift = _os_.unmarshal_int();
/* 523 */         this.WinFightExploit = _os_.unmarshal_int();
/* 524 */         this.LoseFightExploit = _os_.unmarshal_int();
/* 525 */         this.ParticipateExploit = _os_.unmarshal_int();
/* 526 */         this.PkScoreA = _os_.unmarshal_int();
/* 527 */         this.PkScoreB = _os_.unmarshal_int();
/* 528 */         this.PlayerScoreA = _os_.unmarshal_int();
/* 529 */         this.PlayerScoreMinutes = _os_.unmarshal_int();
/* 530 */         this.ProtectedBuff = _os_.unmarshal_int();
/* 531 */         this.MaxTreasureNum = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 536 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SCrossCompeteConsts newInstance)
/*     */   {
/* 542 */     oldInstance = instance;
/* 543 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 548 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\confbean\SCrossCompeteConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */