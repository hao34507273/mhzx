/*     */ package mzm.gsp.guide.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.guide.SSynNewGuideIds;
/*     */ import mzm.gsp.guide.SSynUserGuideType;
/*     */ import mzm.gsp.guide.confbean.GuideCfgConsts;
/*     */ import mzm.gsp.guide.confbean.Param2guideids;
/*     */ import mzm.gsp.guide.confbean.SActivity2ParamGuide;
/*     */ import mzm.gsp.guide.confbean.SCreateHomeGuide;
/*     */ import mzm.gsp.guide.confbean.SEndfightId2Guide;
/*     */ import mzm.gsp.guide.confbean.SGainItem2Guide;
/*     */ import mzm.gsp.guide.confbean.SGuide;
/*     */ import mzm.gsp.guide.confbean.SGuideEffect;
/*     */ import mzm.gsp.guide.confbean.SGuideId2Guide;
/*     */ import mzm.gsp.guide.confbean.SInfightId2Guide;
/*     */ import mzm.gsp.guide.confbean.SJoinGangGuide;
/*     */ import mzm.gsp.guide.confbean.SMenpai2Guide;
/*     */ import mzm.gsp.guide.confbean.SNonConGuide;
/*     */ import mzm.gsp.guide.confbean.SPetLevel2Guide;
/*     */ import mzm.gsp.guide.confbean.SRoleLevel2Guide;
/*     */ import mzm.gsp.guide.confbean.SShiTuBaiShiGuide;
/*     */ import mzm.gsp.guide.confbean.SShiTuTaskGuide;
/*     */ import mzm.gsp.guide.confbean.STaskid2Guide;
/*     */ import mzm.gsp.guide.confbean.STransferOcp2Guide;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GuideState;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2guidestate;
/*     */ 
/*     */ 
/*     */ class GuideManager
/*     */ {
/*  46 */   static final Logger logger = Logger.getLogger("Guide");
/*     */   
/*     */ 
/*     */ 
/*     */   static void postInit() {}
/*     */   
/*     */ 
/*     */   static Set<Integer> getGuideIdsByRoleLevel(int rolelevel)
/*     */   {
/*  55 */     Set<Integer> guideList = new HashSet();
/*  56 */     if (SRoleLevel2Guide.get(rolelevel) == null)
/*     */     {
/*  58 */       return guideList;
/*     */     }
/*  60 */     guideList.addAll(SRoleLevel2Guide.get(rolelevel).guideids);
/*  61 */     return guideList;
/*     */   }
/*     */   
/*     */   static Set<Integer> getGuideIdsByPetLevel(int petlevel)
/*     */   {
/*  66 */     Set<Integer> guideList = new HashSet();
/*  67 */     if (SPetLevel2Guide.get(petlevel) == null)
/*     */     {
/*  69 */       return guideList;
/*     */     }
/*  71 */     guideList.addAll(SPetLevel2Guide.get(petlevel).guideids);
/*  72 */     return guideList;
/*     */   }
/*     */   
/*     */   static Set<Integer> getGuideIdsByTaskid(int taskid)
/*     */   {
/*  77 */     Set<Integer> guideList = new HashSet();
/*  78 */     if (STaskid2Guide.get(taskid) == null)
/*     */     {
/*  80 */       return guideList;
/*     */     }
/*  82 */     guideList.addAll(STaskid2Guide.get(taskid).guideids);
/*  83 */     return guideList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getGuideIdsByInFightid(int fightid)
/*     */   {
/*  94 */     Set<Integer> guideList = new HashSet();
/*  95 */     if (SInfightId2Guide.get(fightid) == null)
/*     */     {
/*  97 */       return guideList;
/*     */     }
/*  99 */     guideList.addAll(SInfightId2Guide.get(fightid).guideids);
/* 100 */     return guideList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getGuideIdsByEndFightid(int fightid)
/*     */   {
/* 112 */     Set<Integer> guideList = new HashSet();
/*     */     
/* 114 */     if (SEndfightId2Guide.get(fightid) == null)
/*     */     {
/* 116 */       return guideList;
/*     */     }
/*     */     
/* 119 */     guideList.addAll(SEndfightId2Guide.get(fightid).guideids);
/* 120 */     return guideList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getNoConGuideids()
/*     */   {
/* 130 */     Set<Integer> guideList = new HashSet();
/* 131 */     guideList.addAll(SNonConGuide.getAll().keySet());
/* 132 */     return guideList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getJoinGangGuideids()
/*     */   {
/* 142 */     Set<Integer> copyIntegers = new HashSet();
/* 143 */     copyIntegers.addAll(SJoinGangGuide.getAll().keySet());
/* 144 */     return copyIntegers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getGuideIdsByGainItemid(int itemid)
/*     */   {
/* 155 */     List<Integer> guideList = new ArrayList();
/*     */     
/* 157 */     if (SGainItem2Guide.get(itemid) == null)
/*     */     {
/* 159 */       return guideList;
/*     */     }
/*     */     
/* 162 */     guideList.addAll(SGainItem2Guide.get(itemid).guideids);
/* 163 */     return guideList;
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
/*     */   static Set<Integer> getGuideIdsByActivityCount(int activityid, int count)
/*     */   {
/* 176 */     Set<Integer> guideList = new HashSet();
/* 177 */     SActivity2ParamGuide activity2ParamGuide = SActivity2ParamGuide.get(activityid);
/*     */     
/* 179 */     if (activity2ParamGuide == null)
/*     */     {
/* 181 */       return guideList;
/*     */     }
/* 183 */     Param2guideids param2guideids = (Param2guideids)activity2ParamGuide.param2guideids.get(Integer.valueOf(count));
/* 184 */     if (param2guideids == null)
/*     */     {
/* 186 */       return guideList;
/*     */     }
/* 188 */     guideList.addAll(param2guideids.guideids);
/* 189 */     return guideList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getGuideIdsByGuideid(int guideid)
/*     */   {
/* 200 */     Set<Integer> guideList = new HashSet();
/* 201 */     if (SGuideId2Guide.get(guideid) == null)
/*     */     {
/* 203 */       return guideList;
/*     */     }
/* 205 */     guideList.addAll(SGuideId2Guide.get(guideid).guideids);
/* 206 */     return guideList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isGuided(long roleid, int guideid)
/*     */   {
/* 218 */     GuideState guideState = Role2guidestate.get(Long.valueOf(roleid));
/* 219 */     if (guideState == null)
/*     */     {
/* 221 */       return false;
/*     */     }
/* 223 */     Integer state = (Integer)guideState.getGuideid2state().get(Integer.valueOf(guideid));
/* 224 */     if (state == null)
/*     */     {
/* 226 */       return false;
/*     */     }
/* 228 */     return state.intValue() == 1;
/*     */   }
/*     */   
/*     */ 
/*     */   static Integer getGuideParam(long roleid, int guideid)
/*     */   {
/* 234 */     GuideState guideState = Role2guidestate.get(Long.valueOf(roleid));
/* 235 */     if (guideState == null)
/*     */     {
/* 237 */       return null;
/*     */     }
/* 239 */     return (Integer)guideState.getGuideid2param().get(Integer.valueOf(guideid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean setGuidedState(long roleid, int guideid, int param)
/*     */   {
/* 251 */     GuideState guideState = Role2guidestate.get(Long.valueOf(roleid));
/* 252 */     if (guideState == null)
/*     */     {
/* 254 */       guideState = Pod.newGuideState();
/* 255 */       Role2guidestate.insert(Long.valueOf(roleid), guideState);
/*     */     }
/* 257 */     Integer guide = (Integer)guideState.getGuideid2state().get(Integer.valueOf(guideid));
/* 258 */     if ((guide != null) && (guide.intValue() == 1))
/*     */     {
/* 260 */       return false;
/*     */     }
/* 262 */     guideState.getGuideid2state().put(Integer.valueOf(guideid), Integer.valueOf(1));
/* 263 */     guideState.getGuideid2param().put(Integer.valueOf(guideid), Integer.valueOf(param));
/* 264 */     tlogGuide(roleid, guideid, param, 1);
/* 265 */     logGuide(roleid, guideid, 1);
/* 266 */     return true;
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
/*     */   static boolean setUnGuidedState(long roleid, int guideid)
/*     */   {
/* 280 */     GuideState guideState = Role2guidestate.get(Long.valueOf(roleid));
/* 281 */     if (guideState == null)
/*     */     {
/* 283 */       guideState = Pod.newGuideState();
/* 284 */       Role2guidestate.insert(Long.valueOf(roleid), guideState);
/*     */     }
/* 286 */     guideState.getGuideid2state().put(Integer.valueOf(guideid), Integer.valueOf(0));
/* 287 */     SGuide guideSGuide = SGuide.get(guideid);
/* 288 */     int guideEffectid = 0;
/* 289 */     boolean isNew = isNewer(roleid);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 297 */     if (isNew)
/*     */     {
/* 299 */       guideEffectid = guideSGuide.effect;
/*     */     }
/*     */     else
/*     */     {
/* 303 */       guideEffectid = guideSGuide.olderEffect;
/*     */     }
/* 305 */     SGuideEffect guideEffect = SGuideEffect.get(guideEffectid);
/*     */     
/* 307 */     if ((guideEffect != null) && (guideEffect.guidetype == 9))
/*     */     {
/* 309 */       new GivePetSession(GuideCfgConsts.getInstance().WATI_SECOND_FORCE_FINISH, roleid, guideid, ((Integer)guideEffect.effectParamList.get(0)).intValue());
/*     */     }
/*     */     
/* 312 */     tlogGuide(roleid, guideid, 0, 0);
/* 313 */     logGuide(roleid, guideid, 0);
/* 314 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getUnguidedids(long roleid)
/*     */   {
/* 326 */     List<Integer> unguidedids = new ArrayList();
/* 327 */     GuideState guideState = Role2guidestate.get(Long.valueOf(roleid));
/* 328 */     if (guideState == null)
/*     */     {
/* 330 */       return unguidedids;
/*     */     }
/* 332 */     for (Iterator i$ = guideState.getGuideid2state().keySet().iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/*     */       
/* 334 */       if (((Integer)guideState.getGuideid2state().get(Integer.valueOf(guideid))).intValue() == 0)
/*     */       {
/* 336 */         unguidedids.add(Integer.valueOf(guideid));
/*     */       }
/*     */     }
/* 339 */     return unguidedids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getShimenGuideid(int ocp)
/*     */   {
/* 351 */     if (SMenpai2Guide.get(ocp) == null)
/*     */     {
/* 353 */       return -1;
/*     */     }
/* 355 */     return SMenpai2Guide.get(ocp).guide;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getOtherShimenGuideid(int ocp)
/*     */   {
/* 366 */     Set<Integer> allguideids = new HashSet();
/* 367 */     for (SMenpai2Guide menpai2Guide : SMenpai2Guide.getAll().values())
/*     */     {
/* 369 */       allguideids.add(Integer.valueOf(menpai2Guide.guide));
/*     */     }
/*     */     
/* 372 */     allguideids.remove(Integer.valueOf(getShimenGuideid(ocp)));
/* 373 */     return allguideids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendCanGuideids(long roleid, Set<Integer> guideids)
/*     */   {
/* 385 */     if (!isRoleStateCanGuide(roleid, false))
/*     */     {
/* 387 */       return;
/*     */     }
/* 389 */     if ((guideids == null) || (guideids.size() == 0))
/*     */     {
/* 391 */       return;
/*     */     }
/* 393 */     SSynNewGuideIds res = new SSynNewGuideIds();
/* 394 */     res.guideids.addAll(guideids);
/* 395 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogGuide(long roleid, int guideid, int param, int state)
/*     */   {
/* 406 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 407 */     String userid = RoleInterface.getUserId(roleid);
/* 408 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 410 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(guideid), Integer.valueOf(param), Integer.valueOf(state) });
/* 411 */     TLogManager.getInstance().addLog(roleid, "Guide", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void logGuide(long roleid, int guideid, int state)
/*     */   {
/* 423 */     int platform = RoleInterface.getPlatform(roleid);
/* 424 */     String channel = RoleInterface.getChannel(roleid);
/* 425 */     String mac = RoleInterface.getMac(roleid);
/*     */     
/* 427 */     String userid = RoleInterface.getUserId(roleid);
/* 428 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 430 */     Object[] columnns = { Integer.valueOf(platform), channel, mac, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(guideid), Integer.valueOf(state) };
/* 431 */     LogManager.getInstance().addLog("newstages", columnns);
/*     */   }
/*     */   
/*     */   static void activityGuideDeal(long roleid, int activityid, int count)
/*     */   {
/* 436 */     Set<Integer> guideids = getGuideIdsByActivityCount(activityid, count);
/*     */     
/* 438 */     if ((guideids == null) || (guideids.isEmpty()))
/*     */     {
/* 440 */       return;
/*     */     }
/* 442 */     List<Integer> toremove = new ArrayList();
/* 443 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/*     */       
/* 445 */       if (isGuided(roleid, guideid))
/*     */       {
/* 447 */         toremove.add(Integer.valueOf(guideid));
/*     */       }
/*     */       else
/* 450 */         setUnGuidedState(roleid, guideid);
/*     */     }
/* 452 */     guideids.removeAll(toremove);
/* 453 */     if (guideids.size() > 0)
/*     */     {
/* 455 */       sendCanGuideids(roleid, guideids);
/* 456 */       String logstr = String.format("[guide]GuideManager.activityGuideDeal@send can guideid success roleid=%d|activityid=%d|guideids=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid), guideids.toString() });
/*     */       
/*     */ 
/* 459 */       logger.info(logstr);
/*     */     }
/*     */   }
/*     */   
/*     */   static void filterMenpaiGuide(long roleid, Set<Integer> guideids)
/*     */   {
/* 465 */     int ocp = RoleInterface.getOccupationId(roleid);
/*     */     
/* 467 */     int shimenguideid = getShimenGuideid(ocp);
/* 468 */     Set<Integer> othershimenguides = new HashSet();
/* 469 */     if (shimenguideid != -1)
/*     */     {
/* 471 */       othershimenguides = getOtherShimenGuideid(ocp);
/*     */     }
/* 473 */     if ((shimenguideid != -1) && (guideids.contains(Integer.valueOf(shimenguideid))))
/*     */     {
/* 475 */       guideids.removeAll(othershimenguides);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isNewer(long roleid)
/*     */   {
/* 484 */     Integer newParam = getGuideParam(roleid, GuideCfgConsts.getInstance().NEWER_OR_OLDER_GUIDEID);
/* 485 */     if ((newParam == null) || (newParam.intValue() == 0))
/*     */     {
/* 487 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 491 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synIsNewOrOld(long roleid, int param)
/*     */   {
/* 499 */     SSynUserGuideType synUserGuideType = new SSynUserGuideType();
/* 500 */     synUserGuideType.guidetype = param;
/* 501 */     OnlineManager.getInstance().send(roleid, synUserGuideType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isGuideSwitchOpenForRole(long roleid)
/*     */   {
/* 512 */     if (!OpenInterface.getOpenStatus(30))
/*     */     {
/* 514 */       return false;
/*     */     }
/* 516 */     if (OpenInterface.isBanPlay(roleid, 30))
/*     */     {
/* 518 */       OpenInterface.sendBanPlayMsg(roleid, 30);
/* 519 */       return false;
/*     */     }
/* 521 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getCreateHomeGuideids()
/*     */   {
/* 532 */     Set<Integer> copyIntegers = new HashSet();
/* 533 */     copyIntegers.addAll(SCreateHomeGuide.getAll().keySet());
/* 534 */     return copyIntegers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanGuide(long roleid, boolean active)
/*     */   {
/* 544 */     return RoleStatusInterface.checkCanSetStatus(roleid, 131, active);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getTransferOcpGuideids()
/*     */   {
/* 554 */     Set<Integer> copyIntegers = new HashSet();
/* 555 */     copyIntegers.addAll(STransferOcp2Guide.getAll().keySet());
/* 556 */     return copyIntegers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getShiTuBaiShiGuideids()
/*     */   {
/* 567 */     Set<Integer> copyIntegers = new HashSet();
/* 568 */     copyIntegers.addAll(SShiTuBaiShiGuide.getAll().keySet());
/* 569 */     return copyIntegers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getShiTuTaskGuideids()
/*     */   {
/* 579 */     Set<Integer> copyIntegers = new HashSet();
/* 580 */     copyIntegers.addAll(SShiTuTaskGuide.getAll().keySet());
/* 581 */     return copyIntegers;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\GuideManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */