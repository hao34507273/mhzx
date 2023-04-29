/*     */ package mzm.gsp.factionpve.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SFactionPVEConsts
/*     */ {
/*  13 */   private static volatile SFactionPVEConsts oldInstance = null;
/*     */   
/*  15 */   private static SFactionPVEConsts instance = new SFactionPVEConsts();
/*     */   public int Activityid;
/*     */   public int EnterNpc;
/*     */   public int EnterService;
/*     */   public int ControllerIn;
/*     */   
/*     */   public static SFactionPVEConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SFactionPVEConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int PrepareMap;
/*     */   
/*     */   public int FightMap;
/*     */   
/*     */   public int ActivityMinutes;
/*     */   
/*     */   public int ForbidActivateBeforeEndMinutes;
/*     */   public int ChangeBeforeStartMinutes;
/*     */   public int PrepareMinutes;
/*     */   public int BossCountDownSeconds;
/*     */   public int BossExistSeconds;
/*     */   public int WaitLeaveSeconds;
/*     */   public int NeedJoinHours;
/*     */   public int CostFactionMoney;
/*     */   public int ActivateValidHourMin;
/*     */   public int ActivateValidHourMax;
/*  48 */   public java.util.ArrayList<Integer> ActivateValidMinutes = new java.util.ArrayList();
/*     */   public int ActivateTimes;
/*     */   public int ModifyTimes;
/*     */   public int ParticipateTimes;
/*     */   public int SetTimeMail;
/*     */   public int ModifyTimeMail;
/*     */   public int CancelMail;
/*     */   public int WeekBeginTime;
/*     */   public int WeekBeginMail;
/*     */   public int WeekEndTime;
/*     */   public int WeekEndMail;
/*     */   public int FightTypeID;
/*     */   public int MonsterController;
/*     */   public int MonsterRefreshSeconds;
/*     */   public int BossController;
/*     */   public int PersonGoalCount;
/*     */   public int PersonGoalAward;
/*     */   public int FactionGoalAward;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  69 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  74 */     String path = dir + "mzm.gsp.factionpve.confbean.SFactionPVEConsts.xml";
/*     */     try
/*     */     {
/*  77 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  78 */       org.dom4j.Document doc = reader.read(new File(path));
/*  79 */       Element root = doc.getRootElement();
/*  80 */       Map<String, Element> data = new java.util.HashMap();
/*  81 */       List<?> nodeList = root.elements();
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
/*  94 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/*  95 */       this.EnterNpc = Integer.valueOf(((Element)data.get("EnterNpc")).attributeValue("value")).intValue();
/*  96 */       this.EnterService = Integer.valueOf(((Element)data.get("EnterService")).attributeValue("value")).intValue();
/*  97 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/*  98 */       this.PrepareMap = Integer.valueOf(((Element)data.get("PrepareMap")).attributeValue("value")).intValue();
/*  99 */       this.FightMap = Integer.valueOf(((Element)data.get("FightMap")).attributeValue("value")).intValue();
/* 100 */       this.ActivityMinutes = Integer.valueOf(((Element)data.get("ActivityMinutes")).attributeValue("value")).intValue();
/* 101 */       this.ForbidActivateBeforeEndMinutes = Integer.valueOf(((Element)data.get("ForbidActivateBeforeEndMinutes")).attributeValue("value")).intValue();
/* 102 */       this.ChangeBeforeStartMinutes = Integer.valueOf(((Element)data.get("ChangeBeforeStartMinutes")).attributeValue("value")).intValue();
/* 103 */       this.PrepareMinutes = Integer.valueOf(((Element)data.get("PrepareMinutes")).attributeValue("value")).intValue();
/* 104 */       this.BossCountDownSeconds = Integer.valueOf(((Element)data.get("BossCountDownSeconds")).attributeValue("value")).intValue();
/* 105 */       this.BossExistSeconds = Integer.valueOf(((Element)data.get("BossExistSeconds")).attributeValue("value")).intValue();
/* 106 */       this.WaitLeaveSeconds = Integer.valueOf(((Element)data.get("WaitLeaveSeconds")).attributeValue("value")).intValue();
/* 107 */       this.NeedJoinHours = Integer.valueOf(((Element)data.get("NeedJoinHours")).attributeValue("value")).intValue();
/* 108 */       this.CostFactionMoney = Integer.valueOf(((Element)data.get("CostFactionMoney")).attributeValue("value")).intValue();
/* 109 */       this.ActivateValidHourMin = Integer.valueOf(((Element)data.get("ActivateValidHourMin")).attributeValue("value")).intValue();
/* 110 */       this.ActivateValidHourMax = Integer.valueOf(((Element)data.get("ActivateValidHourMax")).attributeValue("value")).intValue();
/*     */       
/* 112 */       Element collectionElement = (Element)data.get("ActivateValidMinutes");
/* 113 */       if (collectionElement == null)
/*     */       {
/* 115 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 118 */       List<?> _nodeList = collectionElement.elements();
/* 119 */       int _len = _nodeList.size();
/* 120 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 122 */         Element elem = (Element)_nodeList.get(i);
/* 123 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 130 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 137 */           this.ActivateValidMinutes.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 140 */       this.ActivateTimes = Integer.valueOf(((Element)data.get("ActivateTimes")).attributeValue("value")).intValue();
/* 141 */       this.ModifyTimes = Integer.valueOf(((Element)data.get("ModifyTimes")).attributeValue("value")).intValue();
/* 142 */       this.ParticipateTimes = Integer.valueOf(((Element)data.get("ParticipateTimes")).attributeValue("value")).intValue();
/* 143 */       this.SetTimeMail = Integer.valueOf(((Element)data.get("SetTimeMail")).attributeValue("value")).intValue();
/* 144 */       this.ModifyTimeMail = Integer.valueOf(((Element)data.get("ModifyTimeMail")).attributeValue("value")).intValue();
/* 145 */       this.CancelMail = Integer.valueOf(((Element)data.get("CancelMail")).attributeValue("value")).intValue();
/* 146 */       this.WeekBeginTime = Integer.valueOf(((Element)data.get("WeekBeginTime")).attributeValue("value")).intValue();
/* 147 */       this.WeekBeginMail = Integer.valueOf(((Element)data.get("WeekBeginMail")).attributeValue("value")).intValue();
/* 148 */       this.WeekEndTime = Integer.valueOf(((Element)data.get("WeekEndTime")).attributeValue("value")).intValue();
/* 149 */       this.WeekEndMail = Integer.valueOf(((Element)data.get("WeekEndMail")).attributeValue("value")).intValue();
/* 150 */       this.FightTypeID = Integer.valueOf(((Element)data.get("FightTypeID")).attributeValue("value")).intValue();
/* 151 */       this.MonsterController = Integer.valueOf(((Element)data.get("MonsterController")).attributeValue("value")).intValue();
/* 152 */       this.MonsterRefreshSeconds = Integer.valueOf(((Element)data.get("MonsterRefreshSeconds")).attributeValue("value")).intValue();
/* 153 */       this.BossController = Integer.valueOf(((Element)data.get("BossController")).attributeValue("value")).intValue();
/* 154 */       this.PersonGoalCount = Integer.valueOf(((Element)data.get("PersonGoalCount")).attributeValue("value")).intValue();
/* 155 */       this.PersonGoalAward = Integer.valueOf(((Element)data.get("PersonGoalAward")).attributeValue("value")).intValue();
/* 156 */       this.FactionGoalAward = Integer.valueOf(((Element)data.get("FactionGoalAward")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 165 */     String path = dir + "mzm.gsp.factionpve.confbean.SFactionPVEConsts.xml";
/*     */     try
/*     */     {
/* 168 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 169 */       org.dom4j.Document doc = reader.read(new File(path));
/* 170 */       Element root = doc.getRootElement();
/* 171 */       Map<String, Element> data = new java.util.HashMap();
/* 172 */       List<?> nodeList = root.elements();
/* 173 */       int len = nodeList.size();
/* 174 */       for (int i = 0; i < len; i++)
/*     */       {
/* 176 */         Element element = (Element)nodeList.get(i);
/* 177 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 180 */           String name = element.attributeValue("name");
/* 181 */           if (data.put(name, element) != null)
/* 182 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 185 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/* 186 */       this.EnterNpc = Integer.valueOf(((Element)data.get("EnterNpc")).attributeValue("value")).intValue();
/* 187 */       this.EnterService = Integer.valueOf(((Element)data.get("EnterService")).attributeValue("value")).intValue();
/* 188 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/* 189 */       this.PrepareMap = Integer.valueOf(((Element)data.get("PrepareMap")).attributeValue("value")).intValue();
/* 190 */       this.FightMap = Integer.valueOf(((Element)data.get("FightMap")).attributeValue("value")).intValue();
/* 191 */       this.ActivityMinutes = Integer.valueOf(((Element)data.get("ActivityMinutes")).attributeValue("value")).intValue();
/* 192 */       this.ForbidActivateBeforeEndMinutes = Integer.valueOf(((Element)data.get("ForbidActivateBeforeEndMinutes")).attributeValue("value")).intValue();
/* 193 */       this.ChangeBeforeStartMinutes = Integer.valueOf(((Element)data.get("ChangeBeforeStartMinutes")).attributeValue("value")).intValue();
/* 194 */       this.PrepareMinutes = Integer.valueOf(((Element)data.get("PrepareMinutes")).attributeValue("value")).intValue();
/* 195 */       this.BossCountDownSeconds = Integer.valueOf(((Element)data.get("BossCountDownSeconds")).attributeValue("value")).intValue();
/* 196 */       this.BossExistSeconds = Integer.valueOf(((Element)data.get("BossExistSeconds")).attributeValue("value")).intValue();
/* 197 */       this.WaitLeaveSeconds = Integer.valueOf(((Element)data.get("WaitLeaveSeconds")).attributeValue("value")).intValue();
/* 198 */       this.NeedJoinHours = Integer.valueOf(((Element)data.get("NeedJoinHours")).attributeValue("value")).intValue();
/* 199 */       this.CostFactionMoney = Integer.valueOf(((Element)data.get("CostFactionMoney")).attributeValue("value")).intValue();
/* 200 */       this.ActivateValidHourMin = Integer.valueOf(((Element)data.get("ActivateValidHourMin")).attributeValue("value")).intValue();
/* 201 */       this.ActivateValidHourMax = Integer.valueOf(((Element)data.get("ActivateValidHourMax")).attributeValue("value")).intValue();
/*     */       
/* 203 */       Element collectionElement = (Element)data.get("ActivateValidMinutes");
/* 204 */       if (collectionElement == null)
/*     */       {
/* 206 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 209 */       List<?> _nodeList = collectionElement.elements();
/* 210 */       int _len = _nodeList.size();
/* 211 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 213 */         Element elem = (Element)_nodeList.get(i);
/* 214 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 221 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 228 */           this.ActivateValidMinutes.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 231 */       this.ActivateTimes = Integer.valueOf(((Element)data.get("ActivateTimes")).attributeValue("value")).intValue();
/* 232 */       this.ModifyTimes = Integer.valueOf(((Element)data.get("ModifyTimes")).attributeValue("value")).intValue();
/* 233 */       this.ParticipateTimes = Integer.valueOf(((Element)data.get("ParticipateTimes")).attributeValue("value")).intValue();
/* 234 */       this.SetTimeMail = Integer.valueOf(((Element)data.get("SetTimeMail")).attributeValue("value")).intValue();
/* 235 */       this.ModifyTimeMail = Integer.valueOf(((Element)data.get("ModifyTimeMail")).attributeValue("value")).intValue();
/* 236 */       this.CancelMail = Integer.valueOf(((Element)data.get("CancelMail")).attributeValue("value")).intValue();
/* 237 */       this.WeekBeginTime = Integer.valueOf(((Element)data.get("WeekBeginTime")).attributeValue("value")).intValue();
/* 238 */       this.WeekBeginMail = Integer.valueOf(((Element)data.get("WeekBeginMail")).attributeValue("value")).intValue();
/* 239 */       this.WeekEndTime = Integer.valueOf(((Element)data.get("WeekEndTime")).attributeValue("value")).intValue();
/* 240 */       this.WeekEndMail = Integer.valueOf(((Element)data.get("WeekEndMail")).attributeValue("value")).intValue();
/* 241 */       this.FightTypeID = Integer.valueOf(((Element)data.get("FightTypeID")).attributeValue("value")).intValue();
/* 242 */       this.MonsterController = Integer.valueOf(((Element)data.get("MonsterController")).attributeValue("value")).intValue();
/* 243 */       this.MonsterRefreshSeconds = Integer.valueOf(((Element)data.get("MonsterRefreshSeconds")).attributeValue("value")).intValue();
/* 244 */       this.BossController = Integer.valueOf(((Element)data.get("BossController")).attributeValue("value")).intValue();
/* 245 */       this.PersonGoalCount = Integer.valueOf(((Element)data.get("PersonGoalCount")).attributeValue("value")).intValue();
/* 246 */       this.PersonGoalAward = Integer.valueOf(((Element)data.get("PersonGoalAward")).attributeValue("value")).intValue();
/* 247 */       this.FactionGoalAward = Integer.valueOf(((Element)data.get("FactionGoalAward")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 255 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 258 */     String path = dir + "mzm.gsp.factionpve.confbean.SFactionPVEConsts.bny";
/*     */     try
/*     */     {
/* 261 */       File file = new File(path);
/* 262 */       if (file.exists())
/*     */       {
/* 264 */         byte[] bytes = new byte['Ѐ'];
/* 265 */         FileInputStream fis = new FileInputStream(file);
/* 266 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 267 */         int len = 0;
/* 268 */         while ((len = fis.read(bytes)) > 0)
/* 269 */           baos.write(bytes, 0, len);
/* 270 */         fis.close();
/* 271 */         bytes = baos.toByteArray();
/* 272 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 273 */         this.Activityid = _os_.unmarshal_int();
/* 274 */         this.EnterNpc = _os_.unmarshal_int();
/* 275 */         this.EnterService = _os_.unmarshal_int();
/* 276 */         this.ControllerIn = _os_.unmarshal_int();
/* 277 */         this.PrepareMap = _os_.unmarshal_int();
/* 278 */         this.FightMap = _os_.unmarshal_int();
/* 279 */         this.ActivityMinutes = _os_.unmarshal_int();
/* 280 */         this.ForbidActivateBeforeEndMinutes = _os_.unmarshal_int();
/* 281 */         this.ChangeBeforeStartMinutes = _os_.unmarshal_int();
/* 282 */         this.PrepareMinutes = _os_.unmarshal_int();
/* 283 */         this.BossCountDownSeconds = _os_.unmarshal_int();
/* 284 */         this.BossExistSeconds = _os_.unmarshal_int();
/* 285 */         this.WaitLeaveSeconds = _os_.unmarshal_int();
/* 286 */         this.NeedJoinHours = _os_.unmarshal_int();
/* 287 */         this.CostFactionMoney = _os_.unmarshal_int();
/* 288 */         this.ActivateValidHourMin = _os_.unmarshal_int();
/* 289 */         this.ActivateValidHourMax = _os_.unmarshal_int();
/* 290 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 293 */           int _v_ = _os_.unmarshal_int();
/* 294 */           this.ActivateValidMinutes.add(Integer.valueOf(_v_));
/*     */         }
/* 296 */         this.ActivateTimes = _os_.unmarshal_int();
/* 297 */         this.ModifyTimes = _os_.unmarshal_int();
/* 298 */         this.ParticipateTimes = _os_.unmarshal_int();
/* 299 */         this.SetTimeMail = _os_.unmarshal_int();
/* 300 */         this.ModifyTimeMail = _os_.unmarshal_int();
/* 301 */         this.CancelMail = _os_.unmarshal_int();
/* 302 */         this.WeekBeginTime = _os_.unmarshal_int();
/* 303 */         this.WeekBeginMail = _os_.unmarshal_int();
/* 304 */         this.WeekEndTime = _os_.unmarshal_int();
/* 305 */         this.WeekEndMail = _os_.unmarshal_int();
/* 306 */         this.FightTypeID = _os_.unmarshal_int();
/* 307 */         this.MonsterController = _os_.unmarshal_int();
/* 308 */         this.MonsterRefreshSeconds = _os_.unmarshal_int();
/* 309 */         this.BossController = _os_.unmarshal_int();
/* 310 */         this.PersonGoalCount = _os_.unmarshal_int();
/* 311 */         this.PersonGoalAward = _os_.unmarshal_int();
/* 312 */         this.FactionGoalAward = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 317 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 323 */     String path = dir + "mzm.gsp.factionpve.confbean.SFactionPVEConsts.bny";
/*     */     try
/*     */     {
/* 326 */       File file = new File(path);
/* 327 */       if (file.exists())
/*     */       {
/* 329 */         byte[] bytes = new byte['Ѐ'];
/* 330 */         FileInputStream fis = new FileInputStream(file);
/* 331 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 332 */         int len = 0;
/* 333 */         while ((len = fis.read(bytes)) > 0)
/* 334 */           baos.write(bytes, 0, len);
/* 335 */         fis.close();
/* 336 */         bytes = baos.toByteArray();
/* 337 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 338 */         this.Activityid = _os_.unmarshal_int();
/* 339 */         this.EnterNpc = _os_.unmarshal_int();
/* 340 */         this.EnterService = _os_.unmarshal_int();
/* 341 */         this.ControllerIn = _os_.unmarshal_int();
/* 342 */         this.PrepareMap = _os_.unmarshal_int();
/* 343 */         this.FightMap = _os_.unmarshal_int();
/* 344 */         this.ActivityMinutes = _os_.unmarshal_int();
/* 345 */         this.ForbidActivateBeforeEndMinutes = _os_.unmarshal_int();
/* 346 */         this.ChangeBeforeStartMinutes = _os_.unmarshal_int();
/* 347 */         this.PrepareMinutes = _os_.unmarshal_int();
/* 348 */         this.BossCountDownSeconds = _os_.unmarshal_int();
/* 349 */         this.BossExistSeconds = _os_.unmarshal_int();
/* 350 */         this.WaitLeaveSeconds = _os_.unmarshal_int();
/* 351 */         this.NeedJoinHours = _os_.unmarshal_int();
/* 352 */         this.CostFactionMoney = _os_.unmarshal_int();
/* 353 */         this.ActivateValidHourMin = _os_.unmarshal_int();
/* 354 */         this.ActivateValidHourMax = _os_.unmarshal_int();
/* 355 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 358 */           int _v_ = _os_.unmarshal_int();
/* 359 */           this.ActivateValidMinutes.add(Integer.valueOf(_v_));
/*     */         }
/* 361 */         this.ActivateTimes = _os_.unmarshal_int();
/* 362 */         this.ModifyTimes = _os_.unmarshal_int();
/* 363 */         this.ParticipateTimes = _os_.unmarshal_int();
/* 364 */         this.SetTimeMail = _os_.unmarshal_int();
/* 365 */         this.ModifyTimeMail = _os_.unmarshal_int();
/* 366 */         this.CancelMail = _os_.unmarshal_int();
/* 367 */         this.WeekBeginTime = _os_.unmarshal_int();
/* 368 */         this.WeekBeginMail = _os_.unmarshal_int();
/* 369 */         this.WeekEndTime = _os_.unmarshal_int();
/* 370 */         this.WeekEndMail = _os_.unmarshal_int();
/* 371 */         this.FightTypeID = _os_.unmarshal_int();
/* 372 */         this.MonsterController = _os_.unmarshal_int();
/* 373 */         this.MonsterRefreshSeconds = _os_.unmarshal_int();
/* 374 */         this.BossController = _os_.unmarshal_int();
/* 375 */         this.PersonGoalCount = _os_.unmarshal_int();
/* 376 */         this.PersonGoalAward = _os_.unmarshal_int();
/* 377 */         this.FactionGoalAward = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 382 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SFactionPVEConsts newInstance)
/*     */   {
/* 388 */     oldInstance = instance;
/* 389 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 394 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\confbean\SFactionPVEConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */