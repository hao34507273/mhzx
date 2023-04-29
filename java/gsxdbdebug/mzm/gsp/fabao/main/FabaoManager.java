/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fabao.FaBaoChangeInfo;
/*     */ import mzm.gsp.fabao.LongJingChangeInfo;
/*     */ import mzm.gsp.fabao.LongJingTotalChangeInfo;
/*     */ import mzm.gsp.fabao.SChangeDisPlayFabaoRes;
/*     */ import mzm.gsp.fabao.SSynFaBaoChangeInfo;
/*     */ import mzm.gsp.fabao.SSynLongJingChangeInfo;
/*     */ import mzm.gsp.fabao.confbean.ProType2Value;
/*     */ import mzm.gsp.fabao.confbean.SFaBaoAutoRankUpCfg;
/*     */ import mzm.gsp.fabao.confbean.SFabaoConstants;
/*     */ import mzm.gsp.fabao.confbean.SFabaoExtraEffectCfg;
/*     */ import mzm.gsp.fabao.confbean.SFabaoNextSkillCfg;
/*     */ import mzm.gsp.fabao.confbean.SFabaoRankCfg;
/*     */ import mzm.gsp.fabao.confbean.SFabaoSkillCfg;
/*     */ import mzm.gsp.fabao.confbean.SkillProbs;
/*     */ import mzm.gsp.fabao.event.FabaoDisplay;
/*     */ import mzm.gsp.fabao.event.FabaoDisplayArg;
/*     */ import mzm.gsp.fabao.event.FabaoSysChange;
/*     */ import mzm.gsp.fabao.event.FabaoSysChangeArg;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.confbean.SFabaoFragmentItem;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.FabaoItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.Item;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2fabaosys;
/*     */ 
/*     */ public class FabaoManager
/*     */ {
/*     */   private static final int TEN_THOUSAND = 10000;
/*     */   static final int WASH_OPER_WASH = 1;
/*     */   static final int WASH_OPER_CHOISE = 2;
/*     */   
/*     */   static RoleFabaoSysInfo getRoleFabaoSysInfo(long roleId, boolean retainLock)
/*     */   {
/*  62 */     RoleFabaoSysInfo xRoleFabaoSysInfo = null;
/*  63 */     if (retainLock) {
/*  64 */       xRoleFabaoSysInfo = Role2fabaosys.get(Long.valueOf(roleId));
/*     */     } else {
/*  66 */       xRoleFabaoSysInfo = Role2fabaosys.select(Long.valueOf(roleId));
/*     */     }
/*  68 */     return xRoleFabaoSysInfo;
/*     */   }
/*     */   
/*     */   static int getRandomRankSkillid(SFabaoItem sFabaoItem) {
/*  72 */     SFabaoRankCfg fabaoRankCfg = SFabaoRankCfg.get(sFabaoItem.rankId);
/*  73 */     SFabaoSkillCfg fabaoSkillCfg = SFabaoSkillCfg.get(fabaoRankCfg.skillLibId);
/*  74 */     return randomSkill(fabaoSkillCfg);
/*     */   }
/*     */   
/*     */   static int getRandomWashSkillid(SFabaoItem sFabaoItem) {
/*  78 */     SFabaoRankCfg fabaoRankCfg = SFabaoRankCfg.get(sFabaoItem.rankId);
/*  79 */     SFabaoSkillCfg fabaoSkillCfg = SFabaoSkillCfg.get(fabaoRankCfg.randomLibId);
/*  80 */     return randomSkill(fabaoSkillCfg);
/*     */   }
/*     */   
/*     */   static int randomSkill(SFabaoSkillCfg fabaoSkillCfg) {
/*  84 */     int random = Xdb.random().nextInt(10000);
/*  85 */     for (SkillProbs skillProb : fabaoSkillCfg.probs) {
/*  86 */       if (skillProb.prob > random) {
/*  87 */         return skillProb.skillid;
/*     */       }
/*     */     }
/*  90 */     return 0;
/*     */   }
/*     */   
/*     */   static int randomSkill(SFabaoSkillCfg fabaoSkillCfg, List<Integer> skillids) {
/*  94 */     TreeMap<Integer, Integer> rate2Skill = new TreeMap();
/*  95 */     int beforeNum = 0;
/*  96 */     int skillRate = 0;
/*  97 */     for (SkillProbs skillProb : fabaoSkillCfg.probs) {
/*  98 */       if (skillids.contains(Integer.valueOf(skillProb.skillid))) {
/*  99 */         skillRate += skillProb.prob - beforeNum;
/*     */       } else {
/* 101 */         rate2Skill.put(Integer.valueOf(skillProb.prob - skillRate), Integer.valueOf(skillProb.skillid));
/*     */       }
/* 103 */       beforeNum = skillProb.prob;
/*     */     }
/* 105 */     int randomValue = 10000 - skillRate;
/* 106 */     if (randomValue <= 0) {
/* 107 */       return 0;
/*     */     }
/* 109 */     int random = Xdb.random().nextInt(randomValue);
/* 110 */     NavigableMap<Integer, Integer> navigableMap = rate2Skill.tailMap(Integer.valueOf(random), false);
/* 111 */     Map.Entry<Integer, Integer> firstEntry = navigableMap.firstEntry();
/* 112 */     if (firstEntry != null) {
/* 113 */       return ((Integer)firstEntry.getValue()).intValue();
/*     */     }
/* 115 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleFabaoSysInfo createIfNotExist(long roleid)
/*     */   {
/* 125 */     RoleFabaoSysInfo xRoleFabaoSysInfo = Role2fabaosys.get(Long.valueOf(roleid));
/* 126 */     if (xRoleFabaoSysInfo == null) {
/* 127 */       xRoleFabaoSysInfo = Pod.newRoleFabaoSysInfo();
/* 128 */       Role2fabaosys.insert(Long.valueOf(roleid), xRoleFabaoSysInfo);
/*     */     }
/* 130 */     return xRoleFabaoSysInfo;
/*     */   }
/*     */   
/*     */   static void onFaBaoDisplayChange(long roleid, RoleFabaoSysInfo xRoleFabaoSysInfo, int fabaoCfgid, int fabaoType)
/*     */   {
/* 135 */     xRoleFabaoSysInfo.setDisfabaotype(fabaoType);
/* 136 */     FabaoDisplay fabaoDisplay = new FabaoDisplay();
/* 137 */     TriggerEventsManger.getInstance().triggerEvent(fabaoDisplay, new FabaoDisplayArg(roleid, fabaoCfgid));
/*     */     
/*     */ 
/* 140 */     SChangeDisPlayFabaoRes sChangeDisPlayFabaoRes = new SChangeDisPlayFabaoRes();
/* 141 */     sChangeDisPlayFabaoRes.faobaotype = fabaoType;
/* 142 */     OnlineManager.getInstance().send(roleid, sChangeDisPlayFabaoRes);
/*     */     
/*     */ 
/* 145 */     tlogFabaoDisplay(roleid, fabaoCfgid);
/*     */   }
/*     */   
/*     */   static int getLongjingMaxLevel(int roleLv) {
/* 149 */     return roleLv / 10;
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogFabao(long roleid, int operatetype, long fabaoId, int fabaoCfgId, int beforegrade, int aftergrade, int num, int beforeExp, int afterExp)
/*     */   {
/* 155 */     String logname = "Fabao";
/* 156 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 157 */     String userid = RoleInterface.getUserId(roleid);
/* 158 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 160 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(fabaoCfgId), Long.valueOf(fabaoId), Integer.valueOf(operatetype), Integer.valueOf(beforegrade), Integer.valueOf(aftergrade), Integer.valueOf(num), Integer.valueOf(beforeExp), Integer.valueOf(afterExp) });
/*     */     
/* 162 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */   
/*     */   static void tlogFabaoWash(long roleid, int washOperType, long fabaoId, int fabaoCfgId, int useYuanbao, int washSkill, int replaceSkill)
/*     */   {
/* 167 */     String logname = "FabaoWash";
/* 168 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 169 */     String userid = RoleInterface.getUserId(roleid);
/* 170 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 172 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(washOperType), Integer.valueOf(fabaoCfgId), Long.valueOf(fabaoId), Integer.valueOf(useYuanbao), Integer.valueOf(washSkill), Integer.valueOf(replaceSkill) });
/*     */     
/* 174 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */   
/*     */   static void tlogEquipFabao(long roleid, int operType, int fabaocfgid, long fabaoUuid, int fabaoType) {
/* 178 */     String logname = "FabaoEquip";
/* 179 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 180 */     String userid = RoleInterface.getUserId(roleid);
/* 181 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 183 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(operType), Integer.valueOf(fabaocfgid), Long.valueOf(fabaoUuid), Integer.valueOf(fabaoType) });
/*     */     
/* 185 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */   
/*     */   static void tlogEquipLongJing(long roleid, int operType, int longjingCfgid, long longjingUuid, int pos, int longjingType, int longjingLv)
/*     */   {
/* 190 */     String logname = "FabaoLongJingEquip";
/* 191 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 192 */     String userid = RoleInterface.getUserId(roleid);
/* 193 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 195 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(operType), Integer.valueOf(longjingCfgid), Long.valueOf(longjingUuid), Integer.valueOf(pos), Integer.valueOf(longjingType), Integer.valueOf(longjingLv) });
/*     */     
/* 197 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */   
/*     */   static void tlogEquipLongJingUpLevel(long roleid, long longjingUuid, int beforeLongjingid, int afterLongjingid) {
/* 201 */     String logname = "FabaoLongJingUpLevel";
/* 202 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 203 */     String userid = RoleInterface.getUserId(roleid);
/* 204 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 206 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Long.valueOf(longjingUuid), Integer.valueOf(beforeLongjingid), Integer.valueOf(afterLongjingid) });
/*     */     
/* 208 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogItemFabao(long roleid, long fabaoId, int reason, int changenum, int leftnum, int param, int rank, String itemUUids)
/*     */   {
/* 214 */     String logname = "Itemfabao";
/* 215 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 216 */     String userid = RoleInterface.getUserId(roleid);
/* 217 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 219 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Long.valueOf(fabaoId), Integer.valueOf(reason), Integer.valueOf(changenum), Integer.valueOf(leftnum), Integer.valueOf(param), Integer.valueOf(rank), itemUUids });
/*     */     
/* 221 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */   
/*     */   static void tlogFabaoDisplay(long roleid, long fabaoId)
/*     */   {
/* 226 */     String logname = "FabaoDisplay";
/* 227 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 228 */     String userid = RoleInterface.getUserId(roleid);
/* 229 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 231 */     String logStr = String.format("%s|%s|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Long.valueOf(fabaoId) });
/* 232 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void tlogFaBaoAutoRankUp(long roleid, long fabaoId, int fabaoCfgId, int beforerank, int uptorank, int beforeExp, int useyuanbaonum, Map<Integer, Integer> itemCfg2num)
/*     */   {
/* 239 */     String logname = "FaBaoAutoRankUp";
/* 240 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 241 */     String userid = RoleInterface.getUserId(roleid);
/* 242 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 243 */     StringBuffer sb = new StringBuffer();
/* 244 */     for (Map.Entry<Integer, Integer> entry : itemCfg2num.entrySet())
/*     */     {
/* 246 */       sb.append("{");
/* 247 */       sb.append("itemCfgId=").append(entry.getKey());
/* 248 */       sb.append(",count=").append(entry.getValue());
/* 249 */       sb.append("}");
/*     */     }
/*     */     
/* 252 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(fabaoCfgId), Long.valueOf(fabaoId), Integer.valueOf(beforerank), Integer.valueOf(uptorank), Integer.valueOf(beforeExp), Integer.valueOf(useyuanbaonum), sb.toString() });
/*     */     
/* 254 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */   
/*     */   static void onEquipFabaoChanged(long roleid, FabaoItem fabaoItem, SFabaoItem sFabaoItem)
/*     */   {
/* 259 */     Set<Integer> changePos = new HashSet();
/* 260 */     changePos.add(Integer.valueOf(sFabaoItem.faobaoType));
/* 261 */     FabaoSysChangeArg fabaoSysChangeArg = new FabaoSysChangeArg(roleid, changePos);
/* 262 */     TriggerEventsManger.getInstance().triggerEvent(new FabaoSysChange(), fabaoSysChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */     
/*     */ 
/* 265 */     ItemInfo itemInfo = new ItemInfo();
/* 266 */     ItemInterface.fillInItemInfoBean(itemInfo, fabaoItem.getItem());
/* 267 */     SSynFaBaoChangeInfo synFaBaoChangeInfo = new SSynFaBaoChangeInfo();
/* 268 */     synFaBaoChangeInfo.fabaochangeinfo.changed.put(Integer.valueOf(sFabaoItem.faobaoType), itemInfo);
/* 269 */     OnlineManager.getInstance().send(roleid, synFaBaoChangeInfo);
/*     */   }
/*     */   
/*     */   static void onEquipLongjingChanged(long roleid, int fabaoType, int pos, BasicItem basicItem)
/*     */   {
/* 274 */     Map<Integer, List<Integer>> fabaoTypeToPos = new HashMap();
/* 275 */     List<Integer> posList = new ArrayList();
/* 276 */     posList.add(Integer.valueOf(pos));
/* 277 */     fabaoTypeToPos.put(Integer.valueOf(fabaoType), posList);
/* 278 */     FabaoSysChangeArg fabaoSysChangeArg = new FabaoSysChangeArg(roleid, fabaoTypeToPos);
/* 279 */     TriggerEventsManger.getInstance().triggerEvent(new FabaoSysChange(), fabaoSysChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */     
/*     */ 
/* 282 */     ItemInfo itemInfo = new ItemInfo();
/* 283 */     ItemInterface.fillInItemInfoBean(itemInfo, basicItem.getItem());
/* 284 */     LongJingChangeInfo longJingChangeInfo = new LongJingChangeInfo();
/* 285 */     longJingChangeInfo.changed.put(Integer.valueOf(pos), itemInfo);
/*     */     
/* 287 */     SSynLongJingChangeInfo synLongJingChangeInfo = new SSynLongJingChangeInfo();
/* 288 */     synLongJingChangeInfo.longjingchangeinfo.changed.put(Integer.valueOf(fabaoType), longJingChangeInfo);
/* 289 */     OnlineManager.getInstance().send(roleid, synLongJingChangeInfo);
/*     */   }
/*     */   
/*     */   static void addAllMap(Map<Integer, Integer> finalMap, Map<Integer, Integer> addMap) {
/* 293 */     for (Map.Entry<Integer, Integer> entry : addMap.entrySet()) {
/* 294 */       int key = ((Integer)entry.getKey()).intValue();
/* 295 */       Integer value = (Integer)finalMap.get(Integer.valueOf(key));
/* 296 */       if (value == null) {
/* 297 */         finalMap.put(Integer.valueOf(key), entry.getValue());
/*     */       } else {
/* 299 */         finalMap.put(Integer.valueOf(key), Integer.valueOf(((Integer)entry.getValue()).intValue() + value.intValue()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static Map<Integer, Integer> getExtraProMap(long roleid, RoleFabaoSysInfo xRoleFabaoSysInfo)
/*     */   {
/* 306 */     int lowRank = getExtraLowRank(xRoleFabaoSysInfo);
/* 307 */     if (lowRank < 0) {
/* 308 */       return Collections.EMPTY_MAP;
/*     */     }
/* 310 */     int rolelv = RoleInterface.getLevel(roleid);
/* 311 */     SFabaoExtraEffectCfg retEffectCfg = null;
/* 312 */     for (SFabaoExtraEffectCfg sFabaoExtraEffectCfg : SFabaoExtraEffectCfg.getAll().values()) {
/* 313 */       if (sFabaoExtraEffectCfg.fabaoMinRankLv > lowRank) break;
/* 314 */       retEffectCfg = sFabaoExtraEffectCfg;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 319 */     if (retEffectCfg == null) {
/* 320 */       return Collections.EMPTY_MAP;
/*     */     }
/* 322 */     ProType2Value extraType2Value = (ProType2Value)retEffectCfg.rolelv2proMap.get(Integer.valueOf(rolelv));
/* 323 */     if (extraType2Value == null) {
/* 324 */       return Collections.EMPTY_MAP;
/*     */     }
/* 326 */     return extraType2Value.pro2ValueMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getExtraLowRank(RoleFabaoSysInfo xRoleFabaoSysInfo)
/*     */   {
/* 339 */     if (xRoleFabaoSysInfo == null) {
/* 340 */       return -1;
/*     */     }
/* 342 */     if (xRoleFabaoSysInfo.getFabaomap().size() < SFabaoConstants.getInstance().FABAO_MAX) {
/* 343 */       return -1;
/*     */     }
/* 345 */     int lowRank = -1;
/* 346 */     for (Item xItem : xRoleFabaoSysInfo.getFabaomap().values()) {
/* 347 */       FabaoItem fabaoItem = new FabaoItem(xItem);
/* 348 */       SFabaoItem sFabaoItem = SFabaoItem.get(fabaoItem.getCfgId());
/* 349 */       if (lowRank < 0) {
/* 350 */         lowRank = sFabaoItem.rank;
/* 351 */       } else if (sFabaoItem.rank < lowRank) {
/* 352 */         lowRank = sFabaoItem.rank;
/*     */       }
/*     */     }
/* 355 */     return lowRank;
/*     */   }
/*     */   
/*     */   static String getComplexStrByComma(Collection<Long> collection) {
/* 359 */     if ((collection == null) || (collection.size() <= 0)) {
/* 360 */       return "";
/*     */     }
/* 362 */     StringBuilder stringBuilder = new StringBuilder();
/* 363 */     String splitString = ",";
/* 364 */     boolean first = true;
/* 365 */     for (Iterator i$ = collection.iterator(); i$.hasNext();) { long element = ((Long)i$.next()).longValue();
/* 366 */       if (!first) {
/* 367 */         stringBuilder.append(splitString);
/*     */       } else {
/* 369 */         first = false;
/*     */       }
/* 371 */       stringBuilder.append(String.valueOf(element));
/*     */     }
/* 373 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkInCross(long roleid)
/*     */   {
/* 383 */     if (RoleStatusInterface.containsStatus(roleid, 41)) {
/* 384 */       return true;
/*     */     }
/* 386 */     if (RoleStatusInterface.containsStatus(roleid, 44)) {
/* 387 */       return true;
/*     */     }
/* 389 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkWashSkillId(FabaoItem fabaoItem)
/*     */   {
/* 399 */     SFabaoNextSkillCfg fabaoNextSkillCfg = SFabaoNextSkillCfg.get(fabaoItem.getWashSkillId());
/* 400 */     if (fabaoNextSkillCfg == null)
/*     */     {
/* 402 */       return;
/*     */     }
/* 404 */     SFabaoItem fabao = SFabaoItem.get(fabaoItem.getCfgId());
/* 405 */     if (fabao == null)
/*     */     {
/* 407 */       return;
/*     */     }
/*     */     
/* 410 */     int washSkillRank = fabaoNextSkillCfg.skillidRank;
/*     */     
/* 412 */     int fabaoRank = fabao.rank;
/* 413 */     for (int i = 0; i < fabaoRank - washSkillRank; i++)
/*     */     {
/* 415 */       fabaoNextSkillCfg = SFabaoNextSkillCfg.get(fabaoItem.getWashSkillId());
/* 416 */       if ((fabaoNextSkillCfg == null) || (fabaoNextSkillCfg.nextRankSkillid <= 0))
/*     */         break;
/* 418 */       fabaoItem.setWashSkillId(fabaoNextSkillCfg.nextRankSkillid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkAutoRankUpCost(long roleId, FabaoItem fabaoItem, int targetFabaoCfgid, int costYuanBao, Map<Integer, Map<Integer, Integer>> costkey2num, Map<Integer, Integer> itemCfg2num)
/*     */   {
/* 441 */     SFaBaoAutoRankUpCfg targetCfg = SFaBaoAutoRankUpCfg.get(targetFabaoCfgid);
/* 442 */     SFabaoItem sFabaoItem = SFabaoItem.get(fabaoItem.getCfgId());
/* 443 */     SFabaoItem targetFabaoItem = SFabaoItem.get(targetFabaoCfgid);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 452 */     if (targetCfg == null)
/*     */     {
/* 454 */       return false;
/*     */     }
/*     */     
/* 457 */     Map<Integer, Integer> decomposeItemMap = new HashMap();
/*     */     
/* 459 */     for (Iterator i$ = costkey2num.entrySet().iterator(); i$.hasNext();) { costEntry = (Map.Entry)i$.next();
/*     */       
/*     */ 
/* 462 */       for (Map.Entry<Integer, Integer> entry : ((Map)costEntry.getValue()).entrySet())
/*     */       {
/*     */ 
/* 465 */         BasicItem basicItem = ItemInterface.getItem(roleId, ((Integer)costEntry.getKey()).intValue(), ((Integer)entry.getKey()).intValue());
/* 466 */         if (basicItem == null)
/*     */         {
/* 468 */           return false;
/*     */         }
/*     */         
/* 471 */         int num = basicItem.getNumber();
/* 472 */         if ((((Integer)entry.getValue()).intValue() <= 0) || (num < ((Integer)entry.getValue()).intValue()))
/*     */         {
/* 474 */           return false;
/*     */         }
/*     */         
/* 477 */         int itemCfgId = basicItem.getCfgId();
/*     */         
/*     */ 
/* 480 */         Integer oldNum = (Integer)itemCfg2num.get(Integer.valueOf(itemCfgId));
/* 481 */         itemCfg2num.put(Integer.valueOf(itemCfgId), Integer.valueOf((oldNum == null ? 0 : oldNum.intValue()) + ((Integer)entry.getValue()).intValue()));
/*     */         
/* 483 */         SItemCfg sItemCfg = SItemCfg.get(itemCfgId);
/*     */         
/* 485 */         if (sItemCfg.type == 42)
/*     */         {
/* 487 */           SFabaoFragmentItem costFragmentItem = SFabaoFragmentItem.get(itemCfgId);
/* 488 */           if (costFragmentItem.fabaoType != sFabaoItem.faobaoType)
/*     */           {
/* 490 */             return false;
/*     */           }
/* 492 */           oldNum = (Integer)decomposeItemMap.get(Integer.valueOf(itemCfgId));
/* 493 */           decomposeItemMap.put(Integer.valueOf(itemCfgId), Integer.valueOf((oldNum == null ? 0 : oldNum.intValue()) + ((Integer)entry.getValue()).intValue()));
/*     */ 
/*     */         }
/* 496 */         else if (sItemCfg.type == 44)
/*     */         {
/* 498 */           SFabaoItem costFabaoItem = SFabaoItem.get(itemCfgId);
/* 499 */           if (costFabaoItem.faobaoType != sFabaoItem.faobaoType)
/*     */           {
/* 501 */             return false;
/*     */           }
/* 503 */           if (basicItem.getUuid().contains(fabaoItem.getUuid()))
/*     */           {
/* 505 */             return false;
/*     */           }
/* 507 */           if (costFabaoItem.rank >= targetFabaoItem.rank)
/*     */           {
/* 509 */             return false;
/*     */           }
/* 511 */           SFaBaoAutoRankUpCfg costCfg = SFaBaoAutoRankUpCfg.get(itemCfgId);
/* 512 */           if (costCfg == null)
/*     */           {
/* 514 */             return false;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 519 */           for (Map.Entry<Integer, Integer> decomposeEntry : costCfg.itemMap.entrySet())
/*     */           {
/* 521 */             if (((Integer)decomposeEntry.getKey()).intValue() > 0)
/*     */             {
/*     */ 
/*     */ 
/* 525 */               oldNum = (Integer)decomposeItemMap.get(decomposeEntry.getKey());
/* 526 */               decomposeItemMap.put(decomposeEntry.getKey(), Integer.valueOf((oldNum == null ? 0 : oldNum.intValue()) + ((Integer)decomposeEntry.getValue()).intValue() * ((Integer)entry.getValue()).intValue()));
/*     */             }
/*     */           }
/*     */           
/* 530 */           oldNum = (Integer)decomposeItemMap.get(Integer.valueOf(costCfg.fabaoFragmentCfgid));
/* 531 */           decomposeItemMap.put(Integer.valueOf(costCfg.fabaoFragmentCfgid), Integer.valueOf((oldNum == null ? 0 : oldNum.intValue()) + costCfg.fabaoFragmentNum * ((Integer)entry.getValue()).intValue()));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 538 */           oldNum = (Integer)decomposeItemMap.get(Integer.valueOf(itemCfgId));
/* 539 */           decomposeItemMap.put(Integer.valueOf(itemCfgId), Integer.valueOf((oldNum == null ? 0 : oldNum.intValue()) + ((Integer)entry.getValue()).intValue()));
/*     */         }
/*     */       }
/*     */     }
/*     */     Map.Entry<Integer, Map<Integer, Integer>> costEntry;
/* 544 */     SFaBaoAutoRankUpCfg costCfg = SFaBaoAutoRankUpCfg.get(fabaoItem.getCfgId());
/* 545 */     if (costCfg == null)
/*     */     {
/* 547 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 552 */     for (Map.Entry<Integer, Integer> decomposeEntry : costCfg.itemMap.entrySet())
/*     */     {
/* 554 */       if (((Integer)decomposeEntry.getKey()).intValue() > 0)
/*     */       {
/*     */ 
/*     */ 
/* 558 */         Integer oldNum = (Integer)decomposeItemMap.get(decomposeEntry.getKey());
/* 559 */         decomposeItemMap.put(decomposeEntry.getKey(), Integer.valueOf((oldNum == null ? 0 : oldNum.intValue()) + ((Integer)decomposeEntry.getValue()).intValue()));
/*     */       }
/*     */     }
/* 562 */     Integer oldNum = (Integer)decomposeItemMap.get(Integer.valueOf(costCfg.fabaoFragmentCfgid));
/* 563 */     decomposeItemMap.put(Integer.valueOf(costCfg.fabaoFragmentCfgid), Integer.valueOf((oldNum == null ? 0 : oldNum.intValue()) + costCfg.fabaoFragmentNum));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 571 */     int needYuanBao = 0;
/*     */     
/* 573 */     for (Map.Entry<Integer, Integer> targetEntry : targetCfg.itemMap.entrySet())
/*     */     {
/* 575 */       if (((Integer)targetEntry.getKey()).intValue() > 0)
/*     */       {
/*     */ 
/*     */ 
/* 579 */         oldNum = (Integer)decomposeItemMap.get(targetEntry.getKey());
/* 580 */         int lessNum = ((Integer)targetEntry.getValue()).intValue() - (oldNum == null ? 0 : oldNum.intValue());
/* 581 */         if (lessNum > 0)
/*     */         {
/* 583 */           int price = ItemInterface.getItemYuanBaoPrice(((Integer)targetEntry.getKey()).intValue());
/*     */           
/* 585 */           if (price <= 0)
/*     */           {
/* 587 */             return false;
/*     */           }
/* 589 */           needYuanBao += price * lessNum;
/*     */         }
/*     */       }
/*     */     }
/* 593 */     oldNum = (Integer)decomposeItemMap.get(Integer.valueOf(targetCfg.fabaoFragmentCfgid));
/* 594 */     int lessNum = targetCfg.fabaoFragmentNum - (oldNum == null ? 0 : oldNum.intValue());
/* 595 */     if (lessNum > 0)
/*     */     {
/* 597 */       int price = ItemInterface.getItemYuanBaoPrice(targetCfg.fabaoFragmentCfgid);
/*     */       
/* 599 */       if (price <= 0)
/*     */       {
/* 601 */         return false;
/*     */       }
/* 603 */       needYuanBao += price * lessNum;
/*     */     }
/*     */     
/* 606 */     return needYuanBao == costYuanBao;
/*     */   }
/*     */   
/*     */   static List<Integer> getLongJingCfgIdList(Map<Integer, Item> slot2longJingItem)
/*     */   {
/* 611 */     List<Integer> result = new ArrayList();
/* 612 */     for (Map.Entry<Integer, Item> entry : slot2longJingItem.entrySet())
/*     */     {
/* 614 */       result.add(Integer.valueOf(((Item)entry.getValue()).getCfgid()));
/*     */     }
/* 616 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\FabaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */