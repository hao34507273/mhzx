/*     */ package mzm.gsp.zhenfa.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.common.PropertyRandomUtil.KeyValuePair;
/*     */ import mzm.gsp.item.confbean.SZhenfaBookItem;
/*     */ import mzm.gsp.item.confbean.SZhenfaFragmentItem;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import mzm.gsp.zhenfa.confbean.PosAttriBean;
/*     */ import mzm.gsp.zhenfa.confbean.RestrictZhenfaBean;
/*     */ import mzm.gsp.zhenfa.confbean.SZhenfa;
/*     */ import mzm.gsp.zhenfa.confbean.SZhenfaCfgConsts;
/*     */ import mzm.gsp.zhenfa.confbean.SZhenfaLevelUp2expnum;
/*     */ import mzm.gsp.zhenfa.confbean.SZhenfaid2Bookitemid;
/*     */ import xbean.Pod;
/*     */ import xbean.ZhenfaBean;
/*     */ import xbean.ZhenfaInfo;
/*     */ import xtable.Role2zhenfa;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ZhenfaManager
/*     */ {
/*     */   private static final String LOG_LEVELUP = "arraylevelup";
/*     */   private static final String LOG_LEARN = "arraylearn";
/*     */   private static final String TLOG_LEVELUP = "Arraylevelup";
/*     */   private static final String TLOG_LEARN = "Arraylearn";
/*     */   
/*     */   static void init() {}
/*     */   
/*     */   private static boolean containsZhenfa(List<RestrictZhenfaBean> restrictZhenfaBeans, int zhenfaId)
/*     */   {
/*  41 */     for (RestrictZhenfaBean res : restrictZhenfaBeans)
/*     */     {
/*  43 */       if (res.zhenfaId == zhenfaId)
/*     */       {
/*  45 */         return true;
/*     */       }
/*     */     }
/*  48 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean studyZhenfa(long roleId, int zhenfaId)
/*     */   {
/*  60 */     if (hasZhenfa(roleId, zhenfaId))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     ZhenfaInfo zhenfaInfo = Role2zhenfa.get(Long.valueOf(roleId));
/*     */     
/*  67 */     ZhenfaBean zhenfaBean = Pod.newZhenfaBean();
/*  68 */     zhenfaBean.setZhenfaid(zhenfaId);
/*  69 */     zhenfaBean.setZhenfaexp(0);
/*  70 */     zhenfaBean.setZhenfalevel(SZhenfaCfgConsts.getInstance().INIT_LEVEL);
/*  71 */     zhenfaInfo.getZhenfas().add(zhenfaBean);
/*  72 */     return true;
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
/*     */   static boolean addZhenfaExp(long roleId, int zhenfaId, int expNum)
/*     */   {
/*  85 */     ZhenfaBean zhenfaBean = getZhenfaBean(roleId, zhenfaId);
/*  86 */     if (zhenfaBean == null)
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     int totalExp = expNum + zhenfaBean.getZhenfaexp();
/*  91 */     int currentLevel = zhenfaBean.getZhenfalevel();
/*  92 */     if (currentLevel >= SZhenfaCfgConsts.getInstance().MAX_LEVEL)
/*     */     {
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     while ((currentLevel < SZhenfaCfgConsts.getInstance().MAX_LEVEL) && (totalExp >= SZhenfaLevelUp2expnum.get(currentLevel + 1).expnum))
/*     */     {
/*  99 */       totalExp -= SZhenfaLevelUp2expnum.get(currentLevel + 1).expnum;
/* 100 */       currentLevel++;
/*     */     }
/*     */     
/* 103 */     zhenfaBean.setZhenfalevel(currentLevel);
/* 104 */     if (currentLevel == SZhenfaCfgConsts.getInstance().MAX_LEVEL)
/*     */     {
/* 106 */       zhenfaBean.setZhenfaexp(0);
/*     */     }
/*     */     else
/*     */     {
/* 110 */       zhenfaBean.setZhenfaexp(totalExp);
/*     */     }
/*     */     
/* 113 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static ZhenfaInfo getZhenfaInfo(long roleId)
/*     */   {
/* 124 */     ZhenfaInfo zhenfaInfo = Role2zhenfa.get(Long.valueOf(roleId));
/* 125 */     if (zhenfaInfo == null)
/*     */     {
/* 127 */       zhenfaInfo = Pod.newZhenfaInfo();
/* 128 */       Role2zhenfa.insert(Long.valueOf(roleId), zhenfaInfo);
/*     */     }
/* 130 */     return zhenfaInfo;
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
/*     */   static ZhenfaBean getZhenfaBean(long roleId, int zhenfaId)
/*     */   {
/* 143 */     ZhenfaInfo zhenfaInfo = getZhenfaInfo(roleId);
/* 144 */     for (ZhenfaBean zhenfaBean : zhenfaInfo.getZhenfas())
/*     */     {
/* 146 */       if (zhenfaId == zhenfaBean.getZhenfaid())
/*     */       {
/* 148 */         return zhenfaBean;
/*     */       }
/*     */     }
/* 151 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getZhenfaExp(long roleId, int zhenfaId)
/*     */   {
/* 157 */     ZhenfaBean zhenfaBean = getZhenfaBean(roleId, zhenfaId);
/* 158 */     return zhenfaBean.getZhenfaexp();
/*     */   }
/*     */   
/*     */ 
/*     */   static int getZhenfaLevel(long roleId, int zhenfaId)
/*     */   {
/* 164 */     ZhenfaInfo zhenfaInfo = Role2zhenfa.select(Long.valueOf(roleId));
/* 165 */     if (zhenfaInfo == null)
/*     */     {
/* 167 */       return 0;
/*     */     }
/* 169 */     for (ZhenfaBean zhenfaBean : zhenfaInfo.getZhenfas())
/*     */     {
/* 171 */       if (zhenfaId == zhenfaBean.getZhenfaid())
/*     */       {
/* 173 */         return zhenfaBean.getZhenfalevel();
/*     */       }
/*     */     }
/* 176 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean hasZhenfa(long roleId, int zhenfaId)
/*     */   {
/* 188 */     return getZhenfaBean(roleId, zhenfaId) != null;
/*     */   }
/*     */   
/*     */   static int getZhenfaBookExp(int zhenfaBookId)
/*     */   {
/* 193 */     SZhenfaBookItem s = SZhenfaBookItem.get(zhenfaBookId);
/* 194 */     if (s == null)
/*     */     {
/* 196 */       return -1;
/*     */     }
/* 198 */     return s.addExpNum;
/*     */   }
/*     */   
/*     */   static int getZhenfaBookExtraExp(int zhenfaBookId)
/*     */   {
/* 203 */     SZhenfaBookItem s = SZhenfaBookItem.get(zhenfaBookId);
/* 204 */     if (s == null)
/*     */     {
/* 206 */       return -1;
/*     */     }
/*     */     
/* 209 */     return s.extraAddExpNum;
/*     */   }
/*     */   
/*     */   static boolean isZhenfaBookSuitZhenfa(int zhenfaId, int zhenfaBookId)
/*     */   {
/* 214 */     if (SZhenfaid2Bookitemid.get(zhenfaId) == null)
/*     */     {
/* 216 */       return false;
/*     */     }
/* 218 */     return SZhenfaid2Bookitemid.get(zhenfaId).bookitemid == zhenfaBookId;
/*     */   }
/*     */   
/*     */   static int getZhenfaFragmentExp(int zhenfaFragId)
/*     */   {
/* 223 */     SZhenfaFragmentItem s = SZhenfaFragmentItem.get(zhenfaFragId);
/* 224 */     if (s == null)
/*     */     {
/* 226 */       return -1;
/*     */     }
/*     */     
/* 229 */     return s.addExpNum;
/*     */   }
/*     */   
/*     */   static int getZhenfaBookId(int zhenfaId)
/*     */   {
/* 234 */     SZhenfaid2Bookitemid s = SZhenfaid2Bookitemid.get(zhenfaId);
/*     */     
/* 236 */     if (s == null)
/*     */     {
/* 238 */       return -1;
/*     */     }
/* 240 */     return s.bookitemid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, List<PropertyRandomUtil.KeyValuePair>> getZhenfaPosAttributes(int zhenfaId, int zhenfaLevel)
/*     */   {
/* 252 */     Map<Integer, List<PropertyRandomUtil.KeyValuePair>> posAttriMap = new HashMap();
/* 253 */     List<PosAttriBean> posAttriBeans = SZhenfa.get(zhenfaId).posAttriList;
/* 254 */     for (int i = 0; i < posAttriBeans.size(); i++)
/*     */     {
/* 256 */       List<PropertyRandomUtil.KeyValuePair> kps = new ArrayList();
/* 257 */       posAttriMap.put(Integer.valueOf(i + 1), kps);
/*     */       
/* 259 */       int typeA = ((PosAttriBean)posAttriBeans.get(i)).posAEffect;
/* 260 */       int valueA = ((PosAttriBean)posAttriBeans.get(i)).posAInitValue + ((PosAttriBean)posAttriBeans.get(i)).posAGrowValue * (zhenfaLevel - 1);
/* 261 */       PropertyRandomUtil.KeyValuePair keyValuePairA = new PropertyRandomUtil.KeyValuePair(typeA, valueA);
/* 262 */       int typeB = ((PosAttriBean)posAttriBeans.get(i)).posBEffect;
/* 263 */       int valueB = ((PosAttriBean)posAttriBeans.get(i)).posBInitValue + ((PosAttriBean)posAttriBeans.get(i)).posBGrowValue * (zhenfaLevel - 1);
/* 264 */       PropertyRandomUtil.KeyValuePair keyValuePairB = new PropertyRandomUtil.KeyValuePair(typeB, valueB);
/*     */       
/* 266 */       kps.add(keyValuePairA);
/* 267 */       kps.add(keyValuePairB);
/*     */     }
/*     */     
/* 270 */     return posAttriMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int zhenfaRestrictRelation(int zhenfaId1, int zhenfaId2)
/*     */   {
/* 282 */     if (containsZhenfa(SZhenfa.get(zhenfaId1).restrictZhenfaList, zhenfaId2))
/*     */     {
/* 284 */       return 1;
/*     */     }
/* 286 */     if (containsZhenfa(SZhenfa.get(zhenfaId2).restrictZhenfaList, zhenfaId1))
/*     */     {
/* 288 */       return -1;
/*     */     }
/* 290 */     return 0;
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
/*     */   static PropertyRandomUtil.KeyValuePair getRestZhenfaAttribute(int zhenfaId, int beRestZhenfaId)
/*     */   {
/* 303 */     for (RestrictZhenfaBean res : SZhenfa.get(zhenfaId).restrictZhenfaList)
/*     */     {
/* 305 */       if (res.zhenfaId == beRestZhenfaId)
/*     */       {
/*     */ 
/* 308 */         int type = res.effectId;
/* 309 */         int value = res.restValue;
/* 310 */         PropertyRandomUtil.KeyValuePair keyValuePair = new PropertyRandomUtil.KeyValuePair(type, value);
/* 311 */         return keyValuePair;
/*     */       }
/*     */     }
/* 314 */     return null;
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
/*     */   static void logZhenfaLevelup(long roleid, int zhenfaid, int beforelevel, int afterlevel)
/*     */   {
/* 327 */     Object[] args = new Object[9];
/*     */     
/* 329 */     int platform = RoleInterface.getPlatform(roleid);
/* 330 */     String channel = RoleInterface.getChannel(roleid);
/* 331 */     String mac = RoleInterface.getMac(roleid);
/* 332 */     String userid = RoleInterface.getUserId(roleid);
/* 333 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 335 */     args[0] = Integer.valueOf(platform);
/* 336 */     args[1] = channel;
/* 337 */     args[2] = mac;
/* 338 */     args[3] = userid;
/* 339 */     args[4] = Long.valueOf(roleid);
/* 340 */     args[5] = Integer.valueOf(rolelevel);
/* 341 */     args[6] = Integer.valueOf(zhenfaid);
/* 342 */     args[7] = Integer.valueOf(beforelevel);
/* 343 */     args[8] = Integer.valueOf(afterlevel);
/*     */     
/* 345 */     StringBuffer sb = new StringBuffer("%d|%s|%s|%s|%d|%d|%d|%d|%s");
/*     */     
/* 347 */     String logStr = String.format(sb.toString(), args);
/* 348 */     LogManager.getInstance().addLog("arraylevelup", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void logZhenfaLearn(long roleid, int zhenfaid)
/*     */   {
/* 359 */     Object[] args = new Object[7];
/*     */     
/* 361 */     int platform = RoleInterface.getPlatform(roleid);
/* 362 */     String channel = RoleInterface.getChannel(roleid);
/* 363 */     String mac = RoleInterface.getMac(roleid);
/* 364 */     String userid = RoleInterface.getUserId(roleid);
/* 365 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 367 */     args[0] = Integer.valueOf(platform);
/* 368 */     args[1] = channel;
/* 369 */     args[2] = mac;
/* 370 */     args[3] = userid;
/* 371 */     args[4] = Long.valueOf(roleid);
/* 372 */     args[5] = Integer.valueOf(rolelevel);
/* 373 */     args[6] = Integer.valueOf(zhenfaid);
/*     */     
/* 375 */     StringBuffer sb = new StringBuffer("%d|%s|%s|%s|%d|%d|%d");
/*     */     
/* 377 */     String logStr = String.format(sb.toString(), args);
/* 378 */     LogManager.getInstance().addLog("arraylearn", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tLogZhenfaLearn(long roleid, int zhenfaid)
/*     */   {
/* 389 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 390 */     String userid = RoleInterface.getUserId(roleid);
/* 391 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 393 */     String logStr = String.format("%s|%s|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(zhenfaid) });
/* 394 */     TLogManager.getInstance().addLog(roleid, "Arraylearn", logStr);
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
/*     */   static void tLogZhenfaLevelup(long roleid, int zhenfaid, int beforelevel, int afterlevel, int beforeexp, int afterexp)
/*     */   {
/* 407 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 408 */     String userid = RoleInterface.getUserId(roleid);
/* 409 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 411 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(zhenfaid), Integer.valueOf(beforelevel), Integer.valueOf(afterlevel), Integer.valueOf(beforeexp), Integer.valueOf(afterexp) });
/*     */     
/* 413 */     TLogManager.getInstance().addLog(roleid, "Arraylevelup", logStr);
/*     */   }
/*     */   
/*     */   static boolean isZhenfaExists(int zhenfaId)
/*     */   {
/* 418 */     return SZhenfa.get(zhenfaId) != null;
/*     */   }
/*     */   
/*     */   static boolean isZhenfaSwitchOpenForRole(long roleid)
/*     */   {
/* 423 */     if (!OpenInterface.getOpenStatus(50))
/*     */     {
/* 425 */       OpenInterface.sendCloseProtocol(roleid, 50, null);
/*     */       
/* 427 */       return false;
/*     */     }
/* 429 */     if (OpenInterface.isBanPlay(roleid, 50))
/*     */     {
/* 431 */       OpenInterface.sendBanPlayMsg(roleid, 50);
/* 432 */       return false;
/*     */     }
/* 434 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanOperateZhenfa(long roleid)
/*     */   {
/* 446 */     return RoleStatusInterface.checkCanSetStatus(roleid, 140, true);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\main\ZhenfaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */