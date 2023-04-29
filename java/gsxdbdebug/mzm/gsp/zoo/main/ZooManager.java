/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.homeland.confbean.SAnimalCfg;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.homeland.confbean.SAnimalRandomCfg;
/*     */ import mzm.gsp.homeland.confbean.SAnimalWightInfo;
/*     */ import mzm.gsp.homeland.confbean.SCourtYardBeautifulCfg;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SEmbryoCfg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.zoo.SyncRemoveAnimal;
/*     */ import mzm.gsp.zoo.event.AnimalCreate;
/*     */ import mzm.gsp.zoo.event.AnimalCreateArg;
/*     */ import mzm.gsp.zoo.event.AnimalDisappear;
/*     */ import mzm.gsp.zoo.event.AnimalDisappearArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.ZooInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Animal;
/*     */ import xtable.Animallifeobservers;
/*     */ import xtable.Role2zooinfo;
/*     */ 
/*     */ 
/*     */ public class ZooManager
/*     */ {
/*     */   public static final String ENCODING = "UTF-8";
/*     */   
/*     */   static void init() {}
/*     */   
/*     */   private static void checkCleanInit()
/*     */   {
/*  65 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  67 */       return;
/*     */     }
/*     */     
/*  70 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  71 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(SAnimalConst.getInstance().CHECK_YARD_CLEAN_TIME);
/*  72 */     long todayResetTime = DateTimeUtils.getDailyResetTime(now, timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/*     */     
/*  74 */     long nextUpdateTime = now < todayResetTime ? todayResetTime : todayResetTime + 86400000L;
/*  75 */     long delaySeconds = TimeUnit.MILLISECONDS.toSeconds(nextUpdateTime - now);
/*  76 */     new CheckCleanObserver(delaySeconds + 1L, 86400L);
/*     */   }
/*     */   
/*     */   static boolean canDoAction(long roleid, int action)
/*     */   {
/*  81 */     return RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*     */   }
/*     */   
/*     */   static boolean isFunOpen()
/*     */   {
/*  86 */     if (!OpenInterface.getOpenStatus(338))
/*     */     {
/*  88 */       GameServer.logger().error("[zoo]ZooManager.isFunOpen@fun not open");
/*  89 */       return false;
/*     */     }
/*  91 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isFunOpen(long roleid)
/*     */   {
/*  96 */     if (!OpenInterface.getOpenStatus(338))
/*     */     {
/*  98 */       GameServer.logger().error("[zoo]ZooManager.isFunOpen@fun not open");
/*  99 */       return false;
/*     */     }
/* 101 */     if (OpenInterface.isBanPlay(roleid, 338))
/*     */     {
/* 103 */       GameServer.logger().error(String.format("[zoo]ZooManager.isFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 104 */       OpenInterface.sendBanPlayMsg(roleid, 309);
/* 105 */       return false;
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */   
/*     */   static ZooInfo initZooInfo(long roleid)
/*     */   {
/* 112 */     ZooInfo xZooInfo = Pod.newZooInfo();
/* 113 */     xZooInfo.setClean_check_time(DateTimeUtils.getCurrTimeInMillis());
/* 114 */     Role2zooinfo.insert(Long.valueOf(roleid), xZooInfo);
/* 115 */     return xZooInfo;
/*     */   }
/*     */   
/*     */   static AddAnimalResult addAnimal(long roleid, int embryoCfgid)
/*     */   {
/* 120 */     AddAnimalResult result = new AddAnimalResult();
/*     */     
/* 122 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(roleid));
/* 123 */     if (xZooInfo == null)
/*     */     {
/* 125 */       xZooInfo = initZooInfo(roleid);
/*     */     }
/*     */     
/* 128 */     int maxSize = getAnimalMaxSize(roleid);
/* 129 */     if (maxSize < 0)
/*     */     {
/* 131 */       result.setReason(AddAnimalResult.Reason.CFG_ERROR);
/* 132 */       return result;
/*     */     }
/*     */     
/* 135 */     int size = xZooInfo.getAnimals().size();
/* 136 */     if (size >= maxSize)
/*     */     {
/* 138 */       result.setReason(AddAnimalResult.Reason.ANIMAL_FULL);
/* 139 */       return result;
/*     */     }
/*     */     
/* 142 */     SEmbryoCfg embryoCfg = SEmbryoCfg.get(embryoCfgid);
/* 143 */     if (embryoCfg == null)
/*     */     {
/* 145 */       result.setReason(AddAnimalResult.Reason.ANIMAL_FULL);
/* 146 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 150 */     xbean.AnimalInfo xAnimalInfo = Pod.newAnimalInfo();
/* 151 */     xAnimalInfo.setOwner(roleid);
/* 152 */     xAnimalInfo.setStage(0);
/* 153 */     xAnimalInfo.getEmbryo_info().setEmbryo_cfgid(embryoCfgid);
/* 154 */     xAnimalInfo.setName(embryoCfg.name);
/*     */     
/* 156 */     Long animalid = Animal.insert(xAnimalInfo);
/* 157 */     xZooInfo.getAnimals().add(animalid);
/*     */     
/* 159 */     result.setAnimalid(animalid.longValue());
/* 160 */     result.setReason(AddAnimalResult.Reason.SUCCESS);
/*     */     
/*     */ 
/* 163 */     AnimalCreateArg arg = new AnimalCreateArg(roleid, animalid.longValue());
/* 164 */     AnimalCreate event = new AnimalCreate();
/* 165 */     TriggerEventsManger.getInstance().triggerEventAtOnce(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */     
/*     */ 
/* 168 */     return result;
/*     */   }
/*     */   
/*     */   static xbean.AnimalInfo getAnimalInfo(long roleid, long animalid)
/*     */   {
/* 173 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(roleid));
/* 174 */     if (xZooInfo == null)
/*     */     {
/* 176 */       return null;
/*     */     }
/*     */     
/* 179 */     if (!xZooInfo.getAnimals().contains(Long.valueOf(animalid)))
/*     */     {
/* 181 */       return null;
/*     */     }
/*     */     
/* 184 */     return Animal.get(Long.valueOf(animalid));
/*     */   }
/*     */   
/*     */   static void displayAllAtYard(long roleid, long marriageRoleid, long worldid, int mapCfgid)
/*     */   {
/* 189 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(roleid));
/* 190 */     if ((marriageRoleid <= 0L) && (xZooInfo == null))
/*     */     {
/* 192 */       return;
/*     */     }
/*     */     
/* 195 */     ZooInfo xMarriageZooInfo = null;
/* 196 */     if (marriageRoleid > 0L)
/*     */     {
/* 198 */       xMarriageZooInfo = Role2zooinfo.get(Long.valueOf(marriageRoleid));
/*     */     }
/*     */     
/* 201 */     List<Long> animals = new ArrayList();
/* 202 */     if (xZooInfo != null)
/*     */     {
/* 204 */       animals.addAll(xZooInfo.getAnimals());
/*     */     }
/* 206 */     if (xMarriageZooInfo != null)
/*     */     {
/* 208 */       animals.addAll(xMarriageZooInfo.getAnimals());
/*     */     }
/*     */     
/* 211 */     if (animals.isEmpty())
/*     */     {
/* 213 */       return;
/*     */     }
/*     */     
/*     */ 
/* 217 */     Lockeys.lock(Lockeys.get(Animal.getTable(), animals));
/*     */     
/*     */ 
/* 220 */     checkAnimalLife(roleid, xZooInfo);
/* 221 */     if (marriageRoleid > 0L)
/*     */     {
/* 223 */       checkAnimalLife(marriageRoleid, xMarriageZooInfo);
/*     */     }
/*     */     
/*     */ 
/* 227 */     SCourtyardCfg courtyardCfg = HomelandInterface.getCourtyardCfg(mapCfgid);
/* 228 */     if (courtyardCfg == null)
/*     */     {
/* 230 */       GameServer.logger().error(String.format("[zoo]ZooManager.displayAllAtYard@courtyard cfg is null|role_id=%d|world_id=%d|map_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid) }));
/*     */       
/*     */ 
/* 233 */       return;
/*     */     }
/* 235 */     int x = courtyardCfg.animal_give_birth_x;
/* 236 */     int y = courtyardCfg.aninal_give_birth_y;
/*     */     
/* 238 */     for (Long xAnimalid : animals)
/*     */     {
/* 240 */       xbean.AnimalInfo xAnimalInfo = Animal.get(xAnimalid);
/* 241 */       if (xAnimalInfo != null)
/*     */       {
/*     */ 
/*     */ 
/* 245 */         addMapEntity(xAnimalInfo.getOwner(), xAnimalid.longValue(), xAnimalInfo, worldid, mapCfgid, x, y);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void displayAtYard(long roleid, long animalid, long worldid, int mapCfgid)
/*     */   {
/* 252 */     SCourtyardCfg courtyardCfg = HomelandInterface.getCourtyardCfg(mapCfgid);
/* 253 */     if (courtyardCfg == null)
/*     */     {
/* 255 */       GameServer.logger().error(String.format("[zoo]ZooManager.displayAtYard@courtyard cfg is null|role_id=%d|animal_id=%d|world_id=%d|map_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(animalid), Long.valueOf(worldid), Integer.valueOf(mapCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 259 */       return;
/*     */     }
/* 261 */     int x = courtyardCfg.animal_give_birth_x;
/* 262 */     int y = courtyardCfg.aninal_give_birth_y;
/*     */     
/* 264 */     xbean.AnimalInfo xAnimalInfo = getAnimalInfo(roleid, animalid);
/* 265 */     if (xAnimalInfo == null)
/*     */     {
/* 267 */       GameServer.logger().error(String.format("[zoo]ZooManager.displayAtYard@xbean animal info is null|role_id=%d|animal_id=%d|world_id=%d|map_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(animalid), Long.valueOf(worldid), Integer.valueOf(mapCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 271 */       return;
/*     */     }
/* 273 */     addMapEntity(roleid, animalid, xAnimalInfo, worldid, mapCfgid, x, y);
/*     */   }
/*     */   
/*     */ 
/*     */   private static void addMapEntity(long roleid, long animalid, xbean.AnimalInfo xAnimalInfo, long worldid, int mapCfgid, int x, int y)
/*     */   {
/* 279 */     int stage = xAnimalInfo.getStage();
/*     */     
/* 281 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 282 */     intExtraInfoEntries.put(Integer.valueOf(801), Integer.valueOf(stage));
/*     */     
/* 284 */     Map<Integer, String> stringExtraInfoEntries = new HashMap();
/* 285 */     stringExtraInfoEntries.put(Integer.valueOf(808), RoleInterface.getName(roleid));
/*     */     
/* 287 */     if (stage == 0)
/*     */     {
/* 289 */       xbean.EmbryoStageInfo xEmbryoStageInfo = xAnimalInfo.getEmbryo_info();
/* 290 */       int embryoCfgid = xEmbryoStageInfo.getEmbryo_cfgid();
/*     */       
/* 292 */       intExtraInfoEntries.put(Integer.valueOf(803), Integer.valueOf(xEmbryoStageInfo.getHatch_days()));
/* 293 */       intExtraInfoEntries.put(Integer.valueOf(802), Integer.valueOf(embryoCfgid));
/*     */       
/* 295 */       MapInterface.addMapEntity(MapEntityType.MET_ANIMAL, animalid, worldid, mapCfgid, x, y, embryoCfgid, intExtraInfoEntries, null, stringExtraInfoEntries, null);
/*     */ 
/*     */     }
/* 298 */     else if (stage == 1)
/*     */     {
/* 300 */       xbean.AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/* 301 */       int animalCfgid = xAdultStageInfo.getAnimal_cfgid();
/* 302 */       int lastMateTime = (int)TimeUnit.MILLISECONDS.toSeconds(xAdultStageInfo.getLast_mate_time());
/*     */       
/* 304 */       intExtraInfoEntries.put(Integer.valueOf(804), Integer.valueOf(animalCfgid));
/* 305 */       intExtraInfoEntries.put(Integer.valueOf(805), Integer.valueOf(lastMateTime));
/* 306 */       intExtraInfoEntries.put(Integer.valueOf(807), Integer.valueOf(xAdultStageInfo.getAward_cfgid()));
/*     */       
/* 308 */       stringExtraInfoEntries.put(Integer.valueOf(806), xAnimalInfo.getName());
/*     */       
/* 310 */       MapInterface.addMapEntity(MapEntityType.MET_ANIMAL, animalid, worldid, mapCfgid, x, y, animalCfgid, intExtraInfoEntries, null, stringExtraInfoEntries, null);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 315 */       GameServer.logger().error(String.format("[zoo]ZooManager.addMapEntity@animal stage error|role_id=%d|animal_id=%d|world_id=%d|map_cfgid=%d|stage=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(animalid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(stage) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int randomAnimalCfgid(int randomGroup)
/*     */   {
/* 324 */     SAnimalRandomCfg animalRandomCfg = SAnimalRandomCfg.get(randomGroup);
/* 325 */     if (animalRandomCfg == null)
/*     */     {
/* 327 */       return -1;
/*     */     }
/*     */     
/* 330 */     int weightSum = animalRandomCfg.weightSum;
/*     */     
/* 332 */     Random random = Xdb.random();
/* 333 */     int num = random.nextInt(weightSum) + 1;
/*     */     
/* 335 */     for (SAnimalWightInfo weightInfo : animalRandomCfg.animals)
/*     */     {
/* 337 */       int weight = weightInfo.weight;
/* 338 */       if (num <= weight)
/*     */       {
/* 340 */         return weightInfo.animalCfgid;
/*     */       }
/* 342 */       num -= weight;
/*     */     }
/*     */     
/* 345 */     return -1;
/*     */   }
/*     */   
/*     */   static mzm.gsp.zoo.AnimalInfo transToAnimalInfo(long animalid, xbean.AnimalInfo xAnimalInfo)
/*     */   {
/* 350 */     mzm.gsp.zoo.AnimalInfo animalInfo = new mzm.gsp.zoo.AnimalInfo();
/* 351 */     animalInfo.animalid = animalid;
/* 352 */     int stage = xAnimalInfo.getStage();
/* 353 */     animalInfo.stage = stage;
/*     */     try
/*     */     {
/* 356 */       animalInfo.name.setString(xAnimalInfo.getName(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 362 */     if (stage == 0)
/*     */     {
/* 364 */       xbean.EmbryoStageInfo xEmbryoStageInfo = xAnimalInfo.getEmbryo_info();
/*     */       
/* 366 */       mzm.gsp.zoo.EmbryoStageInfo embryoStageInfo = new mzm.gsp.zoo.EmbryoStageInfo();
/* 367 */       embryoStageInfo.embryo_cfgid = xEmbryoStageInfo.getEmbryo_cfgid();
/* 368 */       embryoStageInfo.hatch_days = xEmbryoStageInfo.getHatch_days();
/* 369 */       embryoStageInfo.last_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xEmbryoStageInfo.getLast_hatch_time()));
/*     */       
/* 371 */       OctetsStream os = new OctetsStream();
/* 372 */       embryoStageInfo.marshal(os);
/* 373 */       animalInfo.stage_info = os;
/*     */     }
/*     */     else
/*     */     {
/* 377 */       xbean.AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/*     */       
/* 379 */       mzm.gsp.zoo.AdultStageInfo adultStageInfo = new mzm.gsp.zoo.AdultStageInfo();
/* 380 */       adultStageInfo.animal_cfgid = xAdultStageInfo.getAnimal_cfgid();
/* 381 */       adultStageInfo.award_cfgid = xAdultStageInfo.getAward_cfgid();
/* 382 */       adultStageInfo.last_mate_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xAdultStageInfo.getLast_mate_time()));
/* 383 */       adultStageInfo.birth_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xAdultStageInfo.getBirth_time()));
/*     */       
/* 385 */       OctetsStream os = new OctetsStream();
/* 386 */       adultStageInfo.marshal(os);
/* 387 */       animalInfo.stage_info = os;
/*     */     }
/* 389 */     return animalInfo;
/*     */   }
/*     */   
/*     */   static void onEmbryoHatchDayChange(long roleid, long animalid, int days)
/*     */   {
/* 394 */     Map<Integer, Integer> replaceIntExtraInfoEntries = new HashMap();
/* 395 */     replaceIntExtraInfoEntries.put(Integer.valueOf(803), Integer.valueOf(days));
/* 396 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_ANIMAL, animalid, replaceIntExtraInfoEntries, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */   static void onAnimalStageChange(long roleid, long animalid, long worldid, int mapCfgid)
/*     */   {
/* 402 */     MapInterface.removeMapEntity(MapEntityType.MET_ANIMAL, animalid, new AnimalStageChangeCallback(roleid, animalid, worldid, mapCfgid));
/*     */   }
/*     */   
/*     */ 
/*     */   static void onAnimalMate(long roleid, long animalid, long lastMateTime, int awardCfgid)
/*     */   {
/* 408 */     Map<Integer, Integer> replaceIntExtraInfoEntries = new HashMap();
/* 409 */     replaceIntExtraInfoEntries.put(Integer.valueOf(805), Integer.valueOf((int)TimeUnit.MILLISECONDS.toSeconds(lastMateTime)));
/*     */     
/* 411 */     replaceIntExtraInfoEntries.put(Integer.valueOf(807), Integer.valueOf(awardCfgid));
/* 412 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_ANIMAL, animalid, replaceIntExtraInfoEntries, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */   static void onAnimalGetAward(long roleid, long animalid, int awardCfgid)
/*     */   {
/* 418 */     Map<Integer, Integer> replaceIntExtraInfoEntries = new HashMap();
/* 419 */     replaceIntExtraInfoEntries.put(Integer.valueOf(807), Integer.valueOf(0));
/* 420 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_ANIMAL, animalid, replaceIntExtraInfoEntries, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */   static void onAnimalRename(long roleid, long animalid, String oldName, String name)
/*     */   {
/* 426 */     Map<Integer, String> replaceStringExtraInfoEntries = new HashMap();
/* 427 */     replaceStringExtraInfoEntries.put(Integer.valueOf(806), name);
/* 428 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_ANIMAL, animalid, null, null, replaceStringExtraInfoEntries, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */   static void onDivorce(long roleid)
/*     */   {
/* 434 */     int level = RoleInterface.getLevel(roleid);
/* 435 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/* 437 */       return;
/*     */     }
/*     */     
/* 440 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(roleid));
/* 441 */     if (xZooInfo == null)
/*     */     {
/* 443 */       return;
/*     */     }
/*     */     
/* 446 */     List<Long> xList = xZooInfo.getAnimals();
/* 447 */     if (xList.isEmpty())
/*     */     {
/* 449 */       return;
/*     */     }
/*     */     
/* 452 */     for (Long animalid : xList)
/*     */     {
/* 454 */       MapInterface.removeMapEntity(MapEntityType.MET_ANIMAL, animalid.longValue(), null);
/*     */     }
/*     */   }
/*     */   
/*     */   static void onMarraried(long roleid, long worldid, int mapCfgid)
/*     */   {
/* 460 */     int level = RoleInterface.getLevel(roleid);
/* 461 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/* 463 */       return;
/*     */     }
/*     */     
/* 466 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(roleid));
/* 467 */     if (xZooInfo == null)
/*     */     {
/* 469 */       return;
/*     */     }
/*     */     
/* 472 */     List<Long> xList = xZooInfo.getAnimals();
/* 473 */     if (xList.isEmpty())
/*     */     {
/* 475 */       return;
/*     */     }
/*     */     
/* 478 */     for (Long animalid : xList)
/*     */     {
/* 480 */       displayAtYard(roleid, animalid.longValue(), worldid, mapCfgid);
/*     */     }
/*     */   }
/*     */   
/*     */   static void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 486 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 487 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 488 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 490 */     StringBuilder logStr = new StringBuilder();
/* 491 */     logStr.append(vGameIp);
/* 492 */     logStr.append("|").append(userid);
/* 493 */     logStr.append("|").append(roleid);
/* 494 */     logStr.append("|").append(roleLevel);
/*     */     
/* 496 */     for (Object colum : logColumns)
/*     */     {
/* 498 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 501 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */   
/*     */   static void checkCleanForEscape(long roleid)
/*     */   {
/* 506 */     int clean = HomelandInterface.getCourtYardCleanliness(roleid);
/* 507 */     if (clean < 0)
/*     */     {
/* 509 */       return;
/*     */     }
/*     */     
/* 512 */     SCourtyardCfg courtyardCfg = HomelandInterface.getCurrentCourtyardCfg(roleid);
/* 513 */     int dayCutClean = courtyardCfg.day_cut_cleanliness;
/*     */     
/* 515 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(roleid));
/* 516 */     if (xZooInfo == null)
/*     */     {
/* 518 */       return;
/*     */     }
/*     */     
/* 521 */     long cleanCheckTime = xZooInfo.getClean_check_time();
/* 522 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 523 */     xZooInfo.setClean_check_time(now);
/*     */     
/*     */ 
/* 526 */     if (!isFunOpen())
/*     */     {
/* 528 */       return;
/*     */     }
/*     */     
/* 531 */     int minClean = SAnimalConst.getInstance().YARD_MIN_CLEAN;
/* 532 */     if (clean >= minClean)
/*     */     {
/* 534 */       return;
/*     */     }
/*     */     
/* 537 */     List<Long> xList = xZooInfo.getAnimals();
/* 538 */     if (xList.isEmpty())
/*     */     {
/* 540 */       return;
/*     */     }
/*     */     
/* 543 */     int num = getEscapeNum(clean, now, cleanCheckTime, dayCutClean);
/* 544 */     if (num <= 0)
/*     */     {
/* 546 */       return;
/*     */     }
/*     */     
/*     */ 
/* 550 */     Lockeys.lock(Lockeys.get(Animal.getTable(), xList));
/*     */     
/* 552 */     List<Long> result = getEscapeAnimals(num, xList);
/* 553 */     for (Long animalid : result)
/*     */     {
/* 555 */       xList.remove(animalid);
/*     */       
/* 557 */       xbean.AnimalInfo xAnimalInfo = Animal.get(animalid);
/* 558 */       Animal.remove(animalid);
/* 559 */       if (xAnimalInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 565 */         syncSendEscapeMail(roleid, SAnimalConst.getInstance().ANIMAL_GONE_MAIL_CFG_ID, xAnimalInfo.getName());
/*     */         
/*     */ 
/* 568 */         SyncRemoveAnimal msg = new SyncRemoveAnimal(animalid.longValue());
/* 569 */         OnlineManager.getInstance().send(roleid, msg);
/*     */         
/*     */ 
/* 572 */         triggerAnimalDisappearEvent(roleid, animalid.longValue(), 2);
/*     */         
/*     */ 
/* 575 */         goneTlog(roleid, animalid.longValue(), xAnimalInfo, 2);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static int getEscapeNum(int curClean, long now, long cleanCheckTime, int dayCutClean)
/*     */   {
/* 582 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(SAnimalConst.getInstance().CHECK_YARD_CLEAN_TIME);
/* 583 */     if (timeCommonCfg == null)
/*     */     {
/* 585 */       GameServer.logger().error(String.format("[zoo]ZooManager.getEscapeNum@cfg is null|time_common_cfg=%d", new Object[] { Integer.valueOf(SAnimalConst.getInstance().CHECK_YARD_CLEAN_TIME) }));
/*     */       
/*     */ 
/* 588 */       return 0;
/*     */     }
/*     */     
/* 591 */     long delay = TimeUnit.HOURS.toMillis(timeCommonCfg.activeHour) + TimeUnit.MINUTES.toMillis(timeCommonCfg.activeMinute);
/*     */     
/* 593 */     int diffDays = DateTimeUtils.diffDays(now - delay, cleanCheckTime - delay);
/* 594 */     if (diffDays <= 0)
/*     */     {
/* 596 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 600 */     int minClean = SAnimalConst.getInstance().YARD_MIN_CLEAN;
/* 601 */     int num = 0;
/* 602 */     for (int i = 0; i < diffDays; i++)
/*     */     {
/* 604 */       if (curClean + i * dayCutClean >= minClean) {
/*     */         break;
/*     */       }
/*     */       
/* 608 */       num++;
/*     */     }
/* 610 */     return num;
/*     */   }
/*     */   
/*     */ 
/*     */   private static List<Long> getEscapeAnimals(int num, List<Long> xList)
/*     */   {
/* 616 */     List<Long> result = new ArrayList();
/*     */     
/* 618 */     if (num >= xList.size())
/*     */     {
/*     */ 
/* 621 */       result.addAll(xList);
/* 622 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 626 */     List<EscapeInfo> escapeInfos = new ArrayList();
/* 627 */     for (Iterator i$ = xList.iterator(); i$.hasNext();) { long animalid = ((Long)i$.next()).longValue();
/*     */       
/* 629 */       xbean.AnimalInfo xAnimalInfo = Animal.get(Long.valueOf(animalid));
/* 630 */       if (xAnimalInfo != null)
/*     */       {
/*     */ 
/*     */ 
/* 634 */         escapeInfos.add(tranEscapeInfo(animalid, xAnimalInfo)); }
/*     */     }
/* 636 */     Collections.sort(escapeInfos);
/*     */     
/* 638 */     for (int i = 0; i < num; i++)
/*     */     {
/* 640 */       result.add(Long.valueOf(((EscapeInfo)escapeInfos.get(i)).animalid));
/*     */     }
/* 642 */     return result;
/*     */   }
/*     */   
/*     */   static void syncSendEscapeMail(long roleid, int mailCfgid, String name)
/*     */   {
/* 647 */     TLogArg tLogArg = new TLogArg(LogReason.ANIMAL_GONE_MAIL);
/* 648 */     List<String> contentArgs = new ArrayList();
/* 649 */     contentArgs.add(name);
/*     */     
/* 651 */     MailInterface.synBuildAndSendMail(roleid, mailCfgid, null, contentArgs, tLogArg);
/*     */   }
/*     */   
/*     */   static void goneTlog(long roleid, long animalid, xbean.AnimalInfo xAnimalInfo, int type)
/*     */   {
/* 656 */     int stage = xAnimalInfo.getStage();
/* 657 */     if (stage == 0)
/*     */     {
/* 659 */       xbean.EmbryoStageInfo xEmbryoStageInfo = xAnimalInfo.getEmbryo_info();
/* 660 */       addTLog(roleid, "AniamlFreeForServer", new Object[] { Long.valueOf(animalid), Integer.valueOf(stage), Integer.valueOf(xEmbryoStageInfo.getEmbryo_cfgid()), Integer.valueOf(xEmbryoStageInfo.getHatch_days()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(type) });
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 665 */       xbean.EmbryoStageInfo xEmbryoStageInfo = xAnimalInfo.getEmbryo_info();
/* 666 */       xbean.AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/* 667 */       addTLog(roleid, "AniamlFreeForServer", new Object[] { Long.valueOf(animalid), Integer.valueOf(stage), Integer.valueOf(xEmbryoStageInfo.getEmbryo_cfgid()), Integer.valueOf(xEmbryoStageInfo.getHatch_days()), Integer.valueOf(xAdultStageInfo.getAnimal_cfgid()), Integer.valueOf(xAdultStageInfo.getAward_cfgid()), Integer.valueOf(type) });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static EscapeInfo tranEscapeInfo(long animalid, xbean.AnimalInfo xAnimalInfo)
/*     */   {
/* 674 */     int stage = xAnimalInfo.getStage();
/* 675 */     if (stage == 0)
/*     */     {
/* 677 */       xbean.EmbryoStageInfo xEmbryoStageInfo = xAnimalInfo.getEmbryo_info();
/* 678 */       int hatchDays = xEmbryoStageInfo.getHatch_days();
/* 679 */       return new EscapeInfo(animalid, stage, hatchDays, 0L, 0, 0);
/*     */     }
/*     */     
/*     */ 
/* 683 */     xbean.AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/* 684 */     int animalCfgid = xAdultStageInfo.getAnimal_cfgid();
/* 685 */     SAnimalCfg animalCfg = SAnimalCfg.get(animalCfgid);
/* 686 */     int starType = 0;
/* 687 */     if (animalCfg != null)
/*     */     {
/* 689 */       starType = animalCfg.starType;
/*     */     }
/* 691 */     int awardCfgid = xAdultStageInfo.getAward_cfgid();
/* 692 */     return new EscapeInfo(animalid, stage, 0, xAdultStageInfo.getBirth_time(), starType, awardCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */   static int getAnimalMaxSize(long roleid)
/*     */   {
/* 698 */     int beautiful = HomelandInterface.getCourtYardBeautiful(roleid);
/* 699 */     TreeMap<Integer, SCourtYardBeautifulCfg> treeMap = (TreeMap)SCourtYardBeautifulCfg.getAll();
/* 700 */     Map.Entry<Integer, SCourtYardBeautifulCfg> entry = treeMap.floorEntry(Integer.valueOf(beautiful));
/* 701 */     if (entry == null)
/*     */     {
/* 703 */       return -1;
/*     */     }
/* 705 */     return ((SCourtYardBeautifulCfg)entry.getValue()).every_people_feed_small_animals;
/*     */   }
/*     */   
/*     */   static void checkAnimalLife(long roleid, ZooInfo xZooInfo)
/*     */   {
/* 710 */     if (xZooInfo == null)
/*     */     {
/* 712 */       return;
/*     */     }
/* 714 */     List<Long> xList = xZooInfo.getAnimals();
/* 715 */     if (xList.isEmpty())
/*     */     {
/* 717 */       return;
/*     */     }
/*     */     
/* 720 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 721 */     Iterator<Long> xIt = xList.iterator();
/* 722 */     while (xIt.hasNext())
/*     */     {
/* 724 */       Long animalid = (Long)xIt.next();
/* 725 */       xbean.AnimalInfo xAnimalInfo = Animal.get(animalid);
/* 726 */       if ((xAnimalInfo != null) && 
/*     */       
/*     */ 
/*     */ 
/* 730 */         (xAnimalInfo.getStage() == 1))
/*     */       {
/*     */ 
/*     */ 
/* 734 */         xbean.AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/* 735 */         int animalCfgid = xAdultStageInfo.getAnimal_cfgid();
/* 736 */         SAnimalCfg animalCfg = SAnimalCfg.get(animalCfgid);
/* 737 */         if (animalCfg != null)
/*     */         {
/*     */ 
/*     */ 
/* 741 */           int hours = animalCfg.life;
/* 742 */           if (hours > 0)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 747 */             long birthTime = xAdultStageInfo.getBirth_time();
/* 748 */             long endTime = birthTime + TimeUnit.HOURS.toMillis(hours);
/* 749 */             long delaySecond = TimeUnit.MILLISECONDS.toSeconds(endTime - now);
/* 750 */             if (delaySecond > 0L)
/*     */             {
/*     */ 
/* 753 */               startAnimalLifeObserver(roleid, animalid.longValue(), delaySecond);
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/* 758 */             else if (isFunOpen())
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 764 */               xIt.remove();
/* 765 */               Animal.remove(animalid);
/*     */               
/*     */ 
/* 768 */               syncSendEscapeMail(roleid, SAnimalConst.getInstance().ANIMAL_LIFE_END_MAIL_CFG_ID, xAnimalInfo.getName());
/*     */               
/*     */ 
/* 771 */               SyncRemoveAnimal msg = new SyncRemoveAnimal(animalid.longValue());
/* 772 */               OnlineManager.getInstance().send(roleid, msg);
/*     */               
/*     */ 
/* 775 */               triggerAnimalDisappearEvent(roleid, animalid.longValue(), 3);
/*     */               
/*     */ 
/* 778 */               goneTlog(roleid, animalid.longValue(), xAnimalInfo, 3);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     } }
/*     */   
/* 785 */   static void startAnimalLifeObserver(long roleid, long animalid, long delaySecond) { xbean.AnimalLifeObserver xAnimalLifeObserver = Animallifeobservers.get(Long.valueOf(animalid));
/* 786 */     if (xAnimalLifeObserver == null)
/*     */     {
/* 788 */       xAnimalLifeObserver = Pod.newAnimalLifeObserver();
/* 789 */       Animallifeobservers.insert(Long.valueOf(animalid), xAnimalLifeObserver);
/*     */     }
/* 791 */     if (xAnimalLifeObserver.getObserver() != null)
/*     */     {
/* 793 */       return;
/*     */     }
/* 795 */     AnimalLifeObserver observer = new AnimalLifeObserver(delaySecond, roleid, animalid);
/* 796 */     xAnimalLifeObserver.setObserver(observer);
/*     */   }
/*     */   
/*     */   static void cancelAnimalLifeObserver(long animalid)
/*     */   {
/* 801 */     xbean.AnimalLifeObserver xAnimalLifeObserver = Animallifeobservers.get(Long.valueOf(animalid));
/* 802 */     if (xAnimalLifeObserver == null)
/*     */     {
/* 804 */       return;
/*     */     }
/* 806 */     if (xAnimalLifeObserver.getObserver() != null)
/*     */     {
/* 808 */       xAnimalLifeObserver.getObserver().stopTimer();
/*     */     }
/* 810 */     Animallifeobservers.remove(Long.valueOf(animalid));
/*     */   }
/*     */   
/*     */   static void triggerAnimalDisappearEvent(long roleid, long animalid, int reason)
/*     */   {
/* 815 */     AnimalDisappearArg arg = new AnimalDisappearArg(roleid, animalid, reason);
/* 816 */     AnimalDisappear event = new AnimalDisappear();
/* 817 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */   }
/*     */   
/*     */   static void onHomeWorldDestory(List<Long> roles)
/*     */   {
/* 822 */     List<Long> animals = new ArrayList();
/*     */     
/* 824 */     for (Long roleid : roles)
/*     */     {
/* 826 */       if (!OnlineManager.getInstance().isOnline(roleid.longValue()))
/*     */       {
/*     */ 
/*     */ 
/* 830 */         ZooInfo xZooInfo = Role2zooinfo.get(roleid);
/* 831 */         if ((xZooInfo != null) && 
/*     */         
/*     */ 
/*     */ 
/* 835 */           (!xZooInfo.getAnimals().isEmpty()))
/*     */         {
/*     */ 
/*     */ 
/* 839 */           animals.addAll(xZooInfo.getAnimals()); }
/*     */       }
/*     */     }
/* 842 */     if (animals.isEmpty())
/*     */     {
/* 844 */       return;
/*     */     }
/*     */     
/*     */ 
/* 848 */     Lockeys.lock(Lockeys.get(Animal.getTable(), animals));
/* 849 */     for (Iterator i$ = animals.iterator(); i$.hasNext();) { long xAnimalid = ((Long)i$.next()).longValue();
/*     */       
/* 851 */       cancelAnimalLifeObserver(xAnimalid);
/*     */     }
/*     */   }
/*     */   
/*     */   static int getAnimalNum(long roleid, int star)
/*     */   {
/* 857 */     if (!HomelandInterface.hasHome(roleid))
/*     */     {
/* 859 */       return 0;
/*     */     }
/* 861 */     ZooInfo xZooInfo = Role2zooinfo.select(Long.valueOf(roleid));
/* 862 */     if (xZooInfo == null)
/*     */     {
/* 864 */       return 0;
/*     */     }
/*     */     
/* 867 */     int num = 0;
/* 868 */     for (Long xAnimalid : xZooInfo.getAnimals())
/*     */     {
/* 870 */       xbean.AnimalInfo xAnimalInfo = Animal.select(xAnimalid);
/* 871 */       if ((xAnimalInfo != null) && 
/*     */       
/*     */ 
/*     */ 
/* 875 */         (xAnimalInfo.getStage() == 1))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 880 */         if (star == -1)
/*     */         {
/* 882 */           num++;
/*     */         }
/*     */         else
/*     */         {
/* 886 */           int animalCfgid = xAnimalInfo.getAdult_info().getAnimal_cfgid();
/* 887 */           SAnimalCfg animalCfg = SAnimalCfg.get(animalCfgid);
/* 888 */           if (animalCfg != null)
/*     */           {
/*     */ 
/*     */ 
/* 892 */             if (animalCfg.starType == star)
/*     */             {
/* 894 */               num++; } }
/*     */         } }
/*     */     }
/* 897 */     return num;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\ZooManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */