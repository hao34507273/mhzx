/*      */ package mzm.gsp.fight.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.Marshal;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.common.PropertyRandomUtil.KeyValuePair;
/*      */ import mzm.gsp.effect.main.EffectInterface;
/*      */ import mzm.gsp.effect.main.FighterEffectGroup;
/*      */ import mzm.gsp.fight.Buff;
/*      */ import mzm.gsp.fight.FighterStatus;
/*      */ import mzm.gsp.fight.FighterStatuses;
/*      */ import mzm.gsp.fight.Observer;
/*      */ import mzm.gsp.fight.Play;
/*      */ import mzm.gsp.fight.PlayChangeFightMap;
/*      */ import mzm.gsp.fight.PlayFighterStatus;
/*      */ import mzm.gsp.fight.PlaySkill;
/*      */ import mzm.gsp.fight.SEnterFightBrd;
/*      */ import mzm.gsp.fight.SFightEndBrd;
/*      */ import mzm.gsp.fight.SNextRoundBrd;
/*      */ import mzm.gsp.fight.SPetFightCVCStart;
/*      */ import mzm.gsp.fight.SRoundPlayBrd;
/*      */ import mzm.gsp.fight.SSynAddObserver;
/*      */ import mzm.gsp.fight.SSynObserveEnd;
/*      */ import mzm.gsp.fight.SSynRoleObserveType;
/*      */ import mzm.gsp.fight.confbean.SFightCfg;
/*      */ import mzm.gsp.fight.confbean.SFightConsts;
/*      */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*      */ import mzm.gsp.fight.fighter.selector.FighterSelector;
/*      */ import mzm.gsp.fight.fighter.selector.OperableFighterSelector;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.skill.main.Skill;
/*      */ import mzm.gsp.skill.main.SkillInterface;
/*      */ import mzm.gsp.timer.main.MilliSession;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.XdbUtils;
/*      */ import mzm.gsp.zhenfa.main.ZhenfaInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FightCmd;
/*      */ import xbean.Pod;
/*      */ import xdb.Procedure;
/*      */ import xio.Protocol;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ abstract class Fight
/*      */ {
/*      */   protected static final int CHANGE_MODEL_CARD_CLASS_EFFECT = 1;
/*      */   protected static final int CHANGE_MODEL_CARD_CLASS_EFFECT_NONE = 0;
/*      */   protected long fightid;
/*      */   private xbean.Fight xFight;
/*   69 */   private HashMap<Integer, FighterStatuses> fighterStatusMap = new HashMap();
/*   70 */   private HashMap<Integer, List<Buff>> fighterStatusBuffs = new HashMap();
/*      */   
/*   72 */   private SRoundPlayBrd activePlayBrd = new SRoundPlayBrd();
/*      */   
/*   74 */   private SRoundPlayBrd passivePlayBrd = new SRoundPlayBrd();
/*      */   
/*      */ 
/*   77 */   private SRoundPlayBrd recordPlayBrd = null;
/*      */   
/*      */   private int playTime;
/*      */   
/*      */   private Set<Integer> cmdedFighters;
/*      */   
/*      */ 
/*      */   Fight(long fightid, xbean.Fight xFight)
/*      */   {
/*   86 */     this.fightid = fightid;
/*   87 */     this.xFight = xFight;
/*      */     
/*   89 */     if (isRecordEnable()) {
/*   90 */       this.recordPlayBrd = new SRoundPlayBrd();
/*      */     }
/*      */   }
/*      */   
/*      */   protected FightTeam getActiveTeam() {
/*   95 */     return new FightTeam(true, this.xFight.getActive(), this);
/*      */   }
/*      */   
/*      */   protected FightTeam getPassiveTeam() {
/*   99 */     return new FightTeam(false, this.xFight.getPassive(), this);
/*      */   }
/*      */   
/*      */   protected FightGroupRole getGroupRole(long roleid) {
/*  103 */     FightGroupRole groupRole = getActiveTeam().getGroupRole(roleid);
/*  104 */     if (groupRole == null) {
/*  105 */       groupRole = getPassiveTeam().getGroupRole(roleid);
/*      */     }
/*  107 */     return groupRole;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final int getNextID()
/*      */   {
/*  116 */     int id = this.xFight.getNextid();
/*  117 */     if (id >= Integer.MAX_VALUE) {
/*  118 */       id = 0;
/*      */     }
/*  120 */     this.xFight.setNextid(++id);
/*  121 */     return id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final Set<Long> getBroadcastRoles()
/*      */   {
/*  130 */     Set<Long> roles = new HashSet();
/*  131 */     roles.addAll(getActiveTeam().getBroadcastRoles());
/*  132 */     roles.addAll(getPassiveTeam().getBroadcastRoles());
/*  133 */     roles.addAll(this.xFight.getObservers().keySet());
/*  134 */     return roles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final Set<Long> getLockRoles()
/*      */   {
/*  143 */     Set<Long> roles = new HashSet();
/*  144 */     roles.addAll(getActiveTeam().getLockRoles());
/*  145 */     roles.addAll(getPassiveTeam().getLockRoles());
/*  146 */     return roles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final Set<Long> getFightRoles()
/*      */   {
/*  156 */     Set<Long> roles = new HashSet();
/*  157 */     roles.addAll(getActiveTeam().getFightRoles());
/*  158 */     roles.addAll(getPassiveTeam().getFightRoles());
/*  159 */     return roles;
/*      */   }
/*      */   
/*      */   protected final Set<Long> getOperatorRoles() {
/*  163 */     Set<Long> roles = new HashSet();
/*  164 */     roles.addAll(getActiveTeam().getOperatorRoles());
/*  165 */     roles.addAll(getPassiveTeam().getOperatorRoles());
/*  166 */     return roles;
/*      */   }
/*      */   
/*      */   protected final List<Integer> getAllMonsters() {
/*  170 */     List<Integer> monsters = new ArrayList();
/*  171 */     monsters.addAll(getActiveTeam().getAllMonsters());
/*  172 */     monsters.addAll(getPassiveTeam().getAllMonsters());
/*  173 */     return monsters;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final void broadcast(Protocol p)
/*      */   {
/*  183 */     OnlineManager.getInstance().sendMulti(p, getBroadcastRoles());
/*      */   }
/*      */   
/*      */   protected final void broadcastToActive(Protocol p) {
/*  187 */     OnlineManager.getInstance().sendMulti(p, getActiveTeam().getBroadcastRoles());
/*      */   }
/*      */   
/*      */   protected final void broadcastToPassive(Protocol p) {
/*  191 */     OnlineManager.getInstance().sendMulti(p, getPassiveTeam().getBroadcastRoles());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final void broadcastToObserver(Protocol p)
/*      */   {
/*  204 */     OnlineManager.getInstance().sendMulti(p, this.xFight.getObservers().keySet());
/*      */   }
/*      */   
/*      */   protected final void broadcastToObserverByType(Protocol p, int observerType) {
/*  208 */     for (Map.Entry<Long, Integer> entry : this.xFight.getObservers().entrySet()) {
/*  209 */       if (((Integer)entry.getValue()).intValue() == observerType) {
/*  210 */         OnlineManager.getInstance().send(((Long)entry.getKey()).longValue(), p);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected final void zhenfaRestrict()
/*      */   {
/*  219 */     int activeZhenfaid = getActiveTeam().getZhenFaid();
/*  220 */     int passiveZhenfaid = getPassiveTeam().getZhenFaid();
/*  221 */     if ((activeZhenfaid == 0) || (passiveZhenfaid == 0)) {
/*  222 */       return;
/*      */     }
/*  224 */     int ret = ZhenfaInterface.zhenfaRestrictRelation(activeZhenfaid, passiveZhenfaid);
/*  225 */     PropertyRandomUtil.KeyValuePair keyValuePair; PropertyRandomUtil.KeyValuePair keyValuePair; if (ret > 0) {
/*  226 */       keyValuePair = ZhenfaInterface.getRestZhenfaAttribute(activeZhenfaid, passiveZhenfaid);
/*  227 */       Map<Integer, Fighter> zhenFaPosFighters = getActiveTeam().getZhenFaPosFighter();
/*  228 */       for (Fighter fighter : zhenFaPosFighters.values()) {
/*  229 */         int key = keyValuePair.getKey();
/*  230 */         fighter.addAttriChangeProperty(key, keyValuePair.getValue());
/*  231 */         if ((GameServer.logger().isDebugEnabled()) && (
/*  232 */           (key == 24) || (key == 47))) {
/*      */           try {
/*  234 */             if (fighter.isRole()) {
/*  235 */               GameServer.logger().debug(String.format("[FightSpeedLogDump]Fight zhenfaRestrict|name=%s|key=%d|value=%d|round=%d|activeZhenfaid=%d|passiveZhenfaid=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(key), Integer.valueOf(keyValuePair.getValue()), Integer.valueOf(fighter.getRound()), Integer.valueOf(activeZhenfaid), Integer.valueOf(passiveZhenfaid), Long.valueOf(this.fightid) }));
/*      */ 
/*      */             }
/*      */             
/*      */ 
/*      */           }
/*      */           catch (Exception e) {}
/*      */         }
/*      */         
/*      */       }
/*      */       
/*      */ 
/*      */     }
/*  248 */     else if (ret < 0) {
/*  249 */       keyValuePair = ZhenfaInterface.getRestZhenfaAttribute(passiveZhenfaid, activeZhenfaid);
/*  250 */       Map<Integer, Fighter> zhenFaPosFighters = getPassiveTeam().getZhenFaPosFighter();
/*  251 */       for (Fighter fighter : zhenFaPosFighters.values()) {
/*  252 */         int key = keyValuePair.getKey();
/*  253 */         fighter.addAttriChangeProperty(key, keyValuePair.getValue());
/*  254 */         if ((GameServer.logger().isDebugEnabled()) && (
/*  255 */           (key == 24) || (key == 47))) {
/*      */           try {
/*  257 */             if (fighter.isRole()) {
/*  258 */               GameServer.logger().debug(String.format("[FightSpeedLogDump]Fight zhenfaRestrict|name=%s|key=%d|value=%d|round=%d|activeZhenfaid=%d|passiveZhenfaid=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(key), Integer.valueOf(keyValuePair.getValue()), Integer.valueOf(fighter.getRound()), Integer.valueOf(activeZhenfaid), Integer.valueOf(passiveZhenfaid), Long.valueOf(this.fightid) }));
/*      */             }
/*      */           }
/*      */           catch (Exception e) {}
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isChangeModelCardClassOpen()
/*      */   {
/*  274 */     int switchId = 511;
/*  275 */     if (!OpenInterface.getOpenStatus(511)) {
/*  276 */       return false;
/*      */     }
/*      */     
/*  279 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final void start()
/*      */   {
/*  287 */     FightManager.initSkillLog(this.xFight);
/*      */     
/*  289 */     getActiveTeam().onEnterFight();
/*  290 */     getPassiveTeam().onEnterFight();
/*      */     
/*      */ 
/*  293 */     if (isChangeModelCardClassOpen()) {
/*  294 */       setExtra(FightExtra.CHANGE_MODEL_CARD_ENABLE, 1);
/*      */     } else {
/*  296 */       setExtra(FightExtra.CHANGE_MODEL_CARD_ENABLE, 0);
/*      */     }
/*      */     
/*  299 */     onFightStart();
/*      */     
/*      */ 
/*  302 */     broadcastEnterFight();
/*      */     
/*  304 */     setFlow(0);
/*      */     
/*      */ 
/*  307 */     if (isGenResultAtOnce()) {
/*  308 */       onNextRound();
/*      */     }
/*      */     else {
/*  311 */       new FightStartSession(this.fightid, FightArgs.getInstance().beforeFightMillis);
/*      */       
/*      */ 
/*  314 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  315 */       this.xFight.setNexttimermillsec(curTime + FightArgs.getInstance().beforeFightMillis);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onFightStart()
/*      */   {
/*  324 */     onFightStartAddMonsterBuff();
/*      */   }
/*      */   
/*      */   protected void onFightStartAddMonsterBuff() {
/*  328 */     FightParam fightParam = getFightParam();
/*  329 */     if (fightParam == null) {
/*  330 */       return;
/*      */     }
/*      */     
/*  333 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/*  334 */       for (Fighter fighter : fightGroup.getExistedFighters()) {
/*  335 */         if ((fighter instanceof FighterMonster)) {
/*  336 */           fighterMonster = (FighterMonster)fighter;
/*  337 */           int monsterid = fighterMonster.getMonsterid();
/*  338 */           List<Integer> buffids = fightParam.getMonsterBuffid(monsterid);
/*  339 */           if (buffids != null)
/*      */           {
/*      */ 
/*  342 */             for (i$ = buffids.iterator(); i$.hasNext();) { int buffid = ((Integer)i$.next()).intValue();
/*  343 */               FighterEffectGroup fighterEffectGroup = EffectInterface.getEffectGroup(buffid);
/*  344 */               if (fighterEffectGroup == null) {
/*  345 */                 GameServer.logger().info(String.format("[Fight]Fight.onFightStartAddMonsterBuff@不存在的效果组配置|buffid=%d", new Object[] { Integer.valueOf(buffid) }));
/*      */ 
/*      */               }
/*      */               else
/*      */               {
/*  350 */                 fighterEffectGroup.run(fighterMonster.getLevel(), fighterMonster, fighterMonster, fighterMonster.fighterid); }
/*      */             } }
/*      */         }
/*      */       }
/*      */     }
/*      */     FighterMonster fighterMonster;
/*      */     Iterator i$;
/*      */   }
/*      */   
/*      */   protected final void onNextRound() {
/*  360 */     this.xFight.setRound(this.xFight.getRound() + 1);
/*  361 */     onRoundBefore();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   abstract void fightEndOnForceEnd(int paramInt);
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   abstract void fightEndOnTeamWin(boolean paramBoolean);
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isToMaxRound()
/*      */   {
/*  382 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(getCfgType());
/*  383 */     return getRound() >= fightTypeCfg.maxRound;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected SFightTypeCfg getFightTypeCfg()
/*      */   {
/*  392 */     return FightConfigManager.getInstance().getFightTypeCfg(getCfgType());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onRoundBefore()
/*      */   {
/*  400 */     this.xFight.setIscurroundend(false);
/*  401 */     this.xFight.getCurroundendroles().clear();
/*      */     
/*  403 */     setFlow(1);
/*      */     
/*      */ 
/*  406 */     this.activePlayBrd = new SRoundPlayBrd();
/*  407 */     this.passivePlayBrd = new SRoundPlayBrd();
/*      */     
/*  409 */     if (isRecordEnable()) {
/*  410 */       this.recordPlayBrd = new SRoundPlayBrd();
/*      */     }
/*      */     
/*  413 */     getActiveTeam().onRoundBefore();
/*  414 */     getPassiveTeam().onRoundBefore();
/*      */     
/*      */ 
/*  417 */     broadcastNextRound();
/*      */     
/*  419 */     onRoundPrapare1();
/*      */   }
/*      */   
/*      */   public static FighterStatus copyFighterStatusIgnoreHpMpAnger(FighterStatus fighterStatus) {
/*  423 */     FighterStatus copyFighterStatus = new FighterStatus(fighterStatus.hpchange, fighterStatus.mpchange, fighterStatus.angerchange, fighterStatus.status_set, fighterStatus.buff_status_set, fighterStatus.buffs, 0, 0, 0, 0, 0, 0, fighterStatus.curenergy, fighterStatus.changemodels, fighterStatus.triggerpassiveskills);
/*      */     
/*      */ 
/*      */ 
/*  427 */     return copyFighterStatus;
/*      */   }
/*      */   
/*      */   protected boolean isInActiveTime(int fighterid) {
/*  431 */     xbean.FightTeam xFightTeam = this.xFight.getActive();
/*  432 */     for (xbean.FightGroup xFightGroup : xFightTeam.getGroups().values()) {
/*  433 */       if (xFightGroup.getMembers().containsKey(Integer.valueOf(fighterid))) {
/*  434 */         return true;
/*      */       }
/*  436 */       for (Fighter fighter : xFightGroup.getLeavefighters()) {
/*  437 */         if (fighter.fighterid == fighterid) {
/*  438 */           return true;
/*      */         }
/*      */       }
/*      */     }
/*  442 */     return false;
/*      */   }
/*      */   
/*      */   protected Play getFighterStatusPlay() {
/*  446 */     Play play = new Play();
/*  447 */     play.play_type = 8;
/*  448 */     PlayFighterStatus playFighterStatus = new PlayFighterStatus();
/*  449 */     playFighterStatus.fightermap = this.fighterStatusMap;
/*  450 */     play.content = playFighterStatus.marshal(new OctetsStream());
/*  451 */     return play;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Play getFighterStatusPlay(boolean active)
/*      */   {
/*  460 */     Play play = new Play();
/*  461 */     play.play_type = 8;
/*  462 */     PlayFighterStatus playFighterStatus = new PlayFighterStatus();
/*  463 */     for (Map.Entry<Integer, FighterStatuses> entry : this.fighterStatusMap.entrySet()) {
/*  464 */       int fighterid = ((Integer)entry.getKey()).intValue();
/*  465 */       FighterStatuses fighterStatuses = (FighterStatuses)entry.getValue();
/*  466 */       if ((active ^ isInActiveTime(fighterid))) {
/*  467 */         FighterStatuses copyFighterStatuses = new FighterStatuses();
/*  468 */         for (FighterStatus fighterStatus : fighterStatuses.statuses) {
/*  469 */           FighterStatus copyFighterStatus = new FighterStatus(fighterStatus.hpchange, fighterStatus.mpchange, fighterStatus.angerchange, fighterStatus.status_set, fighterStatus.buff_status_set, fighterStatus.buffs, 0, 0, 0, 0, 0, 0, fighterStatus.curenergy, fighterStatus.changemodels, fighterStatus.triggerpassiveskills);
/*      */           
/*      */ 
/*      */ 
/*  473 */           copyFighterStatuses.statuses.add(copyFighterStatus);
/*      */         }
/*  475 */         playFighterStatus.fightermap.put(Integer.valueOf(fighterid), copyFighterStatuses);
/*      */       } else {
/*  477 */         playFighterStatus.fightermap.put(Integer.valueOf(fighterid), fighterStatuses);
/*      */       }
/*      */     }
/*  480 */     play.content = playFighterStatus.marshal(new OctetsStream());
/*  481 */     return play;
/*      */   }
/*      */   
/*      */   protected Play getObserverFighterStatusPlay() {
/*  485 */     Play play = new Play();
/*  486 */     play.play_type = 8;
/*  487 */     PlayFighterStatus playFighterStatus = new PlayFighterStatus();
/*  488 */     for (Map.Entry<Integer, FighterStatuses> entry : this.fighterStatusMap.entrySet()) {
/*  489 */       int fighterid = ((Integer)entry.getKey()).intValue();
/*  490 */       FighterStatuses fighterStatuses = (FighterStatuses)entry.getValue();
/*  491 */       FighterStatuses copyFighterStatuses = new FighterStatuses();
/*  492 */       for (FighterStatus fighterStatus : fighterStatuses.statuses) {
/*  493 */         FighterStatus copyFighterStatus = new FighterStatus(fighterStatus.hpchange, fighterStatus.mpchange, fighterStatus.angerchange, fighterStatus.status_set, fighterStatus.buff_status_set, fighterStatus.buffs, 0, 0, 0, 0, 0, 0, fighterStatus.curenergy, fighterStatus.changemodels, fighterStatus.triggerpassiveskills);
/*      */         
/*      */ 
/*      */ 
/*  497 */         copyFighterStatuses.statuses.add(copyFighterStatus);
/*      */       }
/*  499 */       playFighterStatus.fightermap.put(Integer.valueOf(fighterid), copyFighterStatuses);
/*      */     }
/*  501 */     play.content = playFighterStatus.marshal(new OctetsStream());
/*  502 */     return play;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onRoundPrapare1()
/*      */   {
/*  510 */     setFlow(2);
/*      */     
/*  512 */     int prepare1Mill = getRoundPrepare1Mills();
/*  513 */     getActiveTeam().onRoundPrapare1();
/*  514 */     getPassiveTeam().onRoundPrapare1();
/*      */     
/*  516 */     if (isGenResultAtOnce()) {
/*  517 */       onRoundPrapare2();
/*      */     }
/*      */     else {
/*  520 */       new RoundPrepare1Session(this.fightid, prepare1Mill);
/*      */       
/*      */ 
/*  523 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  524 */       this.xFight.setNexttimermillsec(curTime + prepare1Mill);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onRoundPrapare2()
/*      */   {
/*  533 */     if (this.xFight.getFlow() >= 3) {
/*  534 */       return;
/*      */     }
/*      */     
/*      */ 
/*  538 */     setFlow(3);
/*      */     
/*  540 */     getActiveTeam().onRoundPrapare2();
/*  541 */     getPassiveTeam().onRoundPrapare2();
/*      */     
/*      */ 
/*  544 */     if (canEndRoundPrepare2Earlier())
/*      */     {
/*  546 */       onPlayBefore();
/*  547 */       return;
/*      */     }
/*      */     
/*  550 */     if (isGenResultAtOnce()) {
/*  551 */       onPlayBefore();
/*      */     } else {
/*  553 */       int roundPrepare2Mills = getRoundPrepare2Mills();
/*      */       
/*  555 */       FightSession session = new RoundPrapare2Session(this.fightid, roundPrepare2Mills);
/*      */       
/*      */ 
/*  558 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  559 */       this.xFight.setNexttimermillsec(curTime + roundPrepare2Mills);
/*      */       
/*  561 */       long sessionid = session.getSessionId();
/*  562 */       this.xFight.getExtra().put(Integer.valueOf(FightExtra.PRAPARE2_SESSIONID_HIGH.ordinal()), Integer.valueOf(CommonUtils.getLongHigh(sessionid)));
/*  563 */       this.xFight.getExtra().put(Integer.valueOf(FightExtra.PRAPARE2_SESSIONID_LOW.ordinal()), Integer.valueOf(CommonUtils.getLongLow(sessionid)));
/*      */     }
/*      */   }
/*      */   
/*      */   int getRoundPrepare1Mills()
/*      */   {
/*  569 */     int round = this.xFight.getRound();
/*  570 */     if (round > 1) {
/*  571 */       return SFightConsts.getInstance().OTHER_ROUND_AUTO__WAIT_TIME * 1000;
/*      */     }
/*  573 */     return SFightConsts.getInstance().AUTO_WAIT_TIME * 1000;
/*      */   }
/*      */   
/*      */   int getRoundPrepare2Mills()
/*      */   {
/*  578 */     return SFightConsts.getInstance().WAIT_CMD_TIME * 1000 - getRoundPrepare1Mills();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected void cancelRoundPrapare2Session()
/*      */   {
/*  585 */     if ((this.xFight.getExtra().containsKey(Integer.valueOf(FightExtra.PRAPARE2_SESSIONID_HIGH.ordinal()))) && (this.xFight.getExtra().containsKey(Integer.valueOf(FightExtra.PRAPARE2_SESSIONID_LOW.ordinal()))))
/*      */     {
/*  587 */       int high = ((Integer)this.xFight.getExtra().get(Integer.valueOf(FightExtra.PRAPARE2_SESSIONID_HIGH.ordinal()))).intValue();
/*  588 */       int low = ((Integer)this.xFight.getExtra().get(Integer.valueOf(FightExtra.PRAPARE2_SESSIONID_LOW.ordinal()))).intValue();
/*  589 */       long sessionid = CommonUtils.getLong(high, low);
/*  590 */       MilliSession.removeSession(sessionid);
/*  591 */       clearRoundPrapare2Data();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected void clearRoundPrapare2Data()
/*      */   {
/*  599 */     this.xFight.getExtra().remove(Integer.valueOf(FightExtra.PRAPARE2_SESSIONID_HIGH.ordinal()));
/*  600 */     this.xFight.getExtra().remove(Integer.valueOf(FightExtra.PRAPARE2_SESSIONID_LOW.ordinal()));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean canEndRoundPrepare2Earlier()
/*      */   {
/*  609 */     if (!isInPrepare2Flow()) {
/*  610 */       return false;
/*      */     }
/*  612 */     return allHasCmdOrAuto();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean allHasCmdOrAuto()
/*      */   {
/*  621 */     for (Fighter fighter : getActiveTeam().getExistedFighters()) {
/*  622 */       if ((!fighter.isAuto()) && 
/*      */       
/*      */ 
/*  625 */         (!hasFightCmd(fighter.getid())))
/*      */       {
/*      */ 
/*      */ 
/*  629 */         return false; }
/*      */     }
/*  631 */     for (Fighter fighter : getPassiveTeam().getExistedFighters()) {
/*  632 */       if ((!fighter.isAuto()) && 
/*      */       
/*      */ 
/*  635 */         (!hasFightCmd(fighter.fighterid)))
/*      */       {
/*      */ 
/*  638 */         return false; }
/*      */     }
/*  640 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onPlayBefore()
/*      */   {
/*  648 */     setFlow(4);
/*      */     
/*  650 */     this.fighterStatusMap = new HashMap();
/*      */     
/*  652 */     for (Fighter fighter : getActiveTeam().getExistedFighters()) {
/*  653 */       FighterStatuses fighterstatuses = new FighterStatuses();
/*  654 */       this.fighterStatusMap.put(Integer.valueOf(fighter.getid()), fighterstatuses);
/*      */     }
/*  656 */     for (Fighter fighter : getPassiveTeam().getExistedFighters()) {
/*  657 */       FighterStatuses fighterstatuses = new FighterStatuses();
/*  658 */       this.fighterStatusMap.put(Integer.valueOf(fighter.getid()), fighterstatuses);
/*      */     }
/*      */     
/*      */ 
/*  662 */     getActiveTeam().onPlayBefore();
/*  663 */     getPassiveTeam().onPlayBefore();
/*      */     
/*  665 */     for (Fighter fighter : getActiveTeam().getExistedFighters()) {
/*  666 */       int fighterid = fighter.getid();
/*  667 */       if (this.fighterStatusMap.containsKey(Integer.valueOf(fighterid))) {
/*  668 */         FighterStatus fighterStatus = getLatestRoundStatusCreateIfNotExist(fighterid);
/*  669 */         if (fighterStatus == null) {
/*  670 */           fighterStatus = getAndAddRoundStatus(fighterid);
/*      */         }
/*  672 */         fighter.fillFighterStatus(fighterStatus);
/*      */         
/*  674 */         List<Buff> buffs = getFighterStatusBuffs(fighterid);
/*  675 */         if (buffs != null) {
/*  676 */           fighterStatus.buffs.addAll(buffs);
/*      */         }
/*      */       }
/*      */     }
/*  680 */     for (Fighter fighter : getPassiveTeam().getExistedFighters()) {
/*  681 */       int fighterid = fighter.getid();
/*  682 */       if (this.fighterStatusMap.containsKey(Integer.valueOf(fighter.getid()))) {
/*  683 */         FighterStatus fighterStatus = getLatestRoundStatusCreateIfNotExist(fighterid);
/*  684 */         if (fighterStatus != null)
/*      */         {
/*      */ 
/*  687 */           fighter.fillFighterStatus(fighterStatus);
/*      */           
/*  689 */           List<Buff> buffs = getFighterStatusBuffs(fighterid);
/*  690 */           if (buffs != null) {
/*  691 */             fighterStatus.buffs.addAll(buffs);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  697 */     clearFighterStatusBuffs();
/*      */     
/*      */ 
/*  700 */     if (canSeeOppsiteHpProp()) {
/*  701 */       Play statusPlay = getFighterStatusPlay();
/*  702 */       this.activePlayBrd.playlist.add(0, statusPlay);
/*  703 */       this.passivePlayBrd.playlist.add(0, statusPlay);
/*  704 */       if (isRecordEnable()) {
/*  705 */         this.recordPlayBrd.playlist.add(0, statusPlay);
/*      */       }
/*      */     } else {
/*  708 */       Play activePlay = getFighterStatusPlay(true);
/*  709 */       this.activePlayBrd.playlist.add(0, activePlay);
/*  710 */       Play passivePlay = getFighterStatusPlay(false);
/*  711 */       this.passivePlayBrd.playlist.add(0, passivePlay);
/*  712 */       if (isRecordEnable()) {
/*  713 */         Play statusPlay = getFighterStatusPlay();
/*  714 */         this.recordPlayBrd.playlist.add(0, statusPlay);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  719 */     onPlay();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addPreCmdResultRelieveTime(Fighter preReleaser, ExcuteCmdResult preCmdResult, Fighter currentReleaser, ExcuteCmdResult currentCmdResult)
/*      */   {
/*  733 */     if ((preCmdResult == null) || (preCmdResult.skill == null)) {
/*  734 */       return;
/*      */     }
/*      */     
/*  737 */     int preCmdResultPlaySize = preCmdResult.getPlayList(true).size();
/*  738 */     if (preCmdResultPlaySize > 1) {
/*  739 */       return;
/*      */     }
/*      */     
/*  742 */     if (currentCmdResult.skill == null) {
/*  743 */       int duration = preCmdResult.skill.getLastAttackReliveTime(preReleaser);
/*  744 */       if (GameServer.logger().isInfoEnabled()) {
/*  745 */         GameServer.logger().info(String.format("[fight]Fight.addPreCmdResultRelieveTime@current cmdresult skill is null duration|duration=%d", new Object[] { Integer.valueOf(duration) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  751 */       addPlayTime(duration);
/*      */     }
/*      */     else {
/*  754 */       int time = preCmdResult.skill.calSkillReliveTimeBetweenSkills(preReleaser, currentCmdResult.skill, currentReleaser);
/*      */       
/*  756 */       if (GameServer.logger().isInfoEnabled()) {
/*  757 */         GameServer.logger().info(String.format("[fight]Fight.addPreCmdResultRelieveTime@current cmdresult skill is not null duration|time=%d", new Object[] { Integer.valueOf(time) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  763 */       addPlayTime(time);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onPlay()
/*      */   {
/*  772 */     setFlow(5);
/*  773 */     if (GameServer.logger().isDebugEnabled()) {
/*  774 */       GameServer.logger().debug(String.format("[FightSpeedLogDump]before sort|desc=%s|fightUuid=%d", new Object[] { this.xFight.getCmds(), Long.valueOf(this.fightid) }));
/*      */     }
/*      */     
/*      */ 
/*  778 */     sortFightCmds();
/*  779 */     if (GameServer.logger().isDebugEnabled()) {
/*  780 */       GameServer.logger().debug(String.format("[FightSpeedLogDump]after sort|desc=%s|fightUuid=%d", new Object[] { this.xFight.getCmds(), Long.valueOf(this.fightid) }));
/*      */     }
/*      */     
/*  783 */     this.playTime = 0;
/*      */     
/*  785 */     this.cmdedFighters = new HashSet();
/*      */     
/*  787 */     for (FightGroup fightGroup : getActiveTeam().getGroups()) {
/*  788 */       GroupAI groupAi = fightGroup.getGroupAI();
/*  789 */       if (groupAi != null) {
/*  790 */         groupAi.runUnRoundOperator(this);
/*      */       }
/*      */     }
/*      */     
/*  794 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/*  795 */       GroupAI groupAi = fightGroup.getGroupAI();
/*  796 */       if (groupAi != null) {
/*  797 */         groupAi.runUnRoundOperator(this);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  802 */     List<Fighter> reexcutecmdFighters = new ArrayList();
/*  803 */     ExcuteCmdResult preCmdResult = null;
/*  804 */     Fighter preCmdFighter = null;
/*  805 */     for (FightCmd cmd : this.xFight.getCmds()) {
/*  806 */       int fighterid = cmd.getFighterid();
/*  807 */       Fighter fighter = getFighter(fighterid);
/*  808 */       if (fighter != null)
/*      */       {
/*  810 */         ExcuteCmdResult excuteCmdResult = fighter.excuteCmd(cmd);
/*  811 */         if (excuteCmdResult.isNeedReexcute()) {
/*  812 */           reexcutecmdFighters.add(fighter);
/*      */         } else {
/*  814 */           addCmdResult(excuteCmdResult);
/*  815 */           this.cmdedFighters.add(Integer.valueOf(fighterid));
/*      */           
/*  817 */           if (GameServer.logger().isDebugEnabled())
/*  818 */             printTime(fighterid, excuteCmdResult.getPlayTime());
/*  819 */           addPreCmdResultRelieveTime(preCmdFighter, preCmdResult, fighter, excuteCmdResult);
/*  820 */           fighter.excuteCmdEnd(cmd);
/*  821 */           preCmdResult = excuteCmdResult;
/*  822 */           preCmdFighter = fighter;
/*      */         }
/*  824 */         if (isFightEnd()) {
/*  825 */           reexcutecmdFighters.clear();
/*  826 */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  831 */     int sign = reexcutecmdFighters.size();
/*      */     
/*  833 */     boolean needCheck = false;
/*  834 */     for (int index = 0; index < reexcutecmdFighters.size(); index++)
/*      */     {
/*  836 */       if (sign == index) {
/*  837 */         if (needCheck) {
/*  838 */           needCheck = false;
/*  839 */           sign = reexcutecmdFighters.size();
/*      */         } else {
/*  841 */           for (int k = sign; k < reexcutecmdFighters.size(); k++) {
/*  842 */             Fighter fighter = (Fighter)reexcutecmdFighters.get(k);
/*  843 */             FightCmd cmd = getFightCmd(fighter.getid());
/*  844 */             fighter.excuteCmdEnd(cmd);
/*      */           }
/*  846 */           break;
/*      */         }
/*      */       }
/*      */       
/*  850 */       Fighter fighter = (Fighter)reexcutecmdFighters.get(index);
/*  851 */       FightCmd cmd = getFightCmd(fighter.getid());
/*      */       
/*  853 */       ExcuteCmdResult excuteCmdResult = fighter.excuteCmd(cmd);
/*      */       
/*  855 */       if (excuteCmdResult.isNeedReexcute()) {
/*  856 */         reexcutecmdFighters.add(fighter);
/*      */       }
/*      */       else {
/*  859 */         needCheck = true;
/*      */         
/*  861 */         this.playTime += excuteCmdResult.getPlayTime();
/*  862 */         this.activePlayBrd.playlist.addAll(excuteCmdResult.getPlayList(true));
/*  863 */         this.passivePlayBrd.playlist.addAll(excuteCmdResult.getPlayList(false));
/*  864 */         if (isRecordEnable()) {
/*  865 */           this.recordPlayBrd.playlist.addAll(excuteCmdResult.getPlayList());
/*      */         }
/*  867 */         this.cmdedFighters.add(Integer.valueOf(fighter.getid()));
/*  868 */         if (GameServer.logger().isDebugEnabled())
/*  869 */           printTime(fighter.getid(), excuteCmdResult.getPlayTime());
/*  870 */         addPreCmdResultRelieveTime(preCmdFighter, preCmdResult, fighter, excuteCmdResult);
/*      */         
/*  872 */         fighter.excuteCmdEnd(cmd);
/*  873 */         preCmdResult = excuteCmdResult;
/*  874 */         preCmdFighter = fighter;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  880 */     int size = this.activePlayBrd.playlist.size();
/*  881 */     if (size > 0) {
/*  882 */       Play play = (Play)this.activePlayBrd.playlist.get(size - 1);
/*  883 */       if (play.play_type == 0) {
/*  884 */         PlaySkill playSkill = new PlaySkill();
/*      */         try {
/*  886 */           playSkill.unmarshal(new OctetsStream(play.content));
/*  887 */           Fighter releaser = getFighter(playSkill.fighterid);
/*  888 */           if (releaser != null) {
/*  889 */             Skill skill = SkillInterface.getSkill(playSkill.skill, 1);
/*  890 */             if (skill != null) {
/*  891 */               int fixTime = skill.calFixTime(releaser, playSkill);
/*  892 */               this.playTime += fixTime;
/*  893 */               if (GameServer.logger().isDebugEnabled())
/*  894 */                 printTime(playSkill.fighterid, fixTime);
/*      */             }
/*      */           }
/*      */         } catch (Exception e) {
/*  898 */           GameServer.logger().error("Fight.onPlay()执行出错!!", e);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  903 */     this.playTime += Math.max(0, (this.activePlayBrd.playlist.size() - 1) * SFightConsts.getInstance().CLIENT_CALLBACK_EXTRA_TIME);
/*      */     
/*      */ 
/*  906 */     onBeforeRoundEnd();
/*      */     
/*      */ 
/*  909 */     if (canSeeOppsiteHpProp()) {
/*  910 */       Play statusPlay = getFighterStatusPlay();
/*  911 */       this.activePlayBrd.playlist.add(statusPlay);
/*  912 */       this.passivePlayBrd.playlist.add(statusPlay);
/*  913 */       if (isRecordEnable()) {
/*  914 */         this.recordPlayBrd.playlist.add(statusPlay);
/*      */       }
/*      */     } else {
/*  917 */       Play activePlay = getFighterStatusPlay(true);
/*  918 */       this.activePlayBrd.playlist.add(activePlay);
/*  919 */       Play passivePlay = getFighterStatusPlay(false);
/*  920 */       this.passivePlayBrd.playlist.add(passivePlay);
/*  921 */       if (isRecordEnable()) {
/*  922 */         Play statusPlay = getFighterStatusPlay();
/*  923 */         this.recordPlayBrd.playlist.add(statusPlay);
/*      */       }
/*      */     }
/*      */     
/*  927 */     this.activePlayBrd.fight_uuid = this.fightid;
/*  928 */     this.passivePlayBrd.fight_uuid = this.fightid;
/*  929 */     if (isRecordEnable()) {
/*  930 */       this.recordPlayBrd.fight_uuid = this.fightid;
/*      */       
/*  932 */       this.xFight.getFight_recorder().addRoundPlayBrd(this.recordPlayBrd);
/*      */     }
/*      */     
/*  935 */     if (isGenResultAtOnce()) {
/*  936 */       onRoundEnd();
/*      */     }
/*      */     else {
/*  939 */       broadcastToActive(this.activePlayBrd);
/*  940 */       broadcastToPassive(this.passivePlayBrd);
/*      */       
/*  942 */       broadcastToObserverByType(this.activePlayBrd, 0);
/*  943 */       broadcastToObserverByType(this.passivePlayBrd, 1);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  948 */       if (this.playTime < 500) {
/*  949 */         this.playTime = 500;
/*      */       }
/*  951 */       new RoundPlaySession(this.fightid, this.playTime);
/*      */       
/*      */ 
/*  954 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  955 */       this.xFight.setNexttimermillsec(curTime + this.playTime);
/*  956 */       if (GameServer.logger().isDebugEnabled()) {
/*  957 */         GameServer.logger().debug("round:" + getRound() + " 播放的时间为:" + this.playTime + " 播放结束时间为:" + this.xFight.getNexttimermillsec());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void printTime(int fighterid, int playTime) {}
/*      */   
/*      */ 
/*      */ 
/*      */   private void onBeforeRoundEnd()
/*      */   {
/*  971 */     this.fighterStatusMap = new HashMap();
/*  972 */     Set<Fighter> allRoundEndFighters = new HashSet();
/*  973 */     for (Fighter fighter : getActiveTeam().getExistedFighters()) {
/*  974 */       FighterStatuses fighterstatuses = new FighterStatuses();
/*  975 */       this.fighterStatusMap.put(Integer.valueOf(fighter.getid()), fighterstatuses);
/*  976 */       allRoundEndFighters.add(fighter);
/*      */     }
/*  978 */     for (Fighter fighter : getPassiveTeam().getExistedFighters()) {
/*  979 */       FighterStatuses fighterstatuses = new FighterStatuses();
/*  980 */       this.fighterStatusMap.put(Integer.valueOf(fighter.getid()), fighterstatuses);
/*  981 */       allRoundEndFighters.add(fighter);
/*      */     }
/*      */     
/*      */ 
/*  985 */     getActiveTeam().onRoundEnd();
/*  986 */     getPassiveTeam().onRoundEnd();
/*      */     
/*      */ 
/*  989 */     for (Fighter fighter : allRoundEndFighters) {
/*  990 */       if (fighter.isEscaped()) {
/*  991 */         this.fighterStatusMap.remove(Integer.valueOf(fighter.getid()));
/*      */       }
/*      */       else
/*      */       {
/*  995 */         FighterStatus fighterStatus = getLatestRoundStatusCreateIfNotExist(fighter.getid());
/*  996 */         if (fighterStatus != null) {
/*  997 */           fighter.fillFighterStatus(fighterStatus);
/*      */           
/*      */ 
/* 1000 */           List<Buff> buffs = getFighterStatusBuffs(fighter.getid());
/* 1001 */           if (buffs != null) {
/* 1002 */             fighterStatus.buffs.addAll(buffs);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1008 */     clearFighterStatusBuffs();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void addPlayTime(int millSec)
/*      */   {
/* 1017 */     this.playTime += millSec;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void addCmdResult(ExcuteCmdResult excuteCmdResult)
/*      */   {
/* 1026 */     this.playTime += excuteCmdResult.getPlayTime();
/* 1027 */     this.activePlayBrd.playlist.addAll(excuteCmdResult.getPlayList(true));
/* 1028 */     this.passivePlayBrd.playlist.addAll(excuteCmdResult.getPlayList(false));
/* 1029 */     if (isRecordEnable()) {
/* 1030 */       this.recordPlayBrd.playlist.addAll(excuteCmdResult.getPlayList());
/*      */     }
/*      */   }
/*      */   
/*      */   protected List<Play> getPlayList(boolean active) {
/* 1035 */     List<Play> list = new ArrayList();
/* 1036 */     SRoundPlayBrd roundPlayBrd = null;
/* 1037 */     if (active) {
/* 1038 */       roundPlayBrd = this.activePlayBrd;
/*      */     } else {
/* 1040 */       roundPlayBrd = this.passivePlayBrd;
/*      */     }
/* 1042 */     if (roundPlayBrd != null) {
/* 1043 */       list.addAll(roundPlayBrd.playlist);
/*      */     }
/* 1045 */     return list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public FighterStatus getAndAddRoundStatus(int fighterid)
/*      */   {
/* 1054 */     FighterStatuses fighterStatuses = (FighterStatuses)this.fighterStatusMap.get(Integer.valueOf(fighterid));
/* 1055 */     if (fighterStatuses == null) {
/* 1056 */       GameServer.logger().info(String.format("[Fight]Fight.getAndAddRoundStatus@do not has fighterid data|fighterid=%d|fightid=%d", new Object[] { Integer.valueOf(fighterid), Long.valueOf(this.fightid) }));
/*      */       
/*      */ 
/*      */ 
/* 1060 */       return new FighterStatus();
/*      */     }
/* 1062 */     FighterStatus fighterStatus = new FighterStatus();
/* 1063 */     fighterStatuses.statuses.add(fighterStatus);
/* 1064 */     return fighterStatus;
/*      */   }
/*      */   
/*      */   public FighterStatus getLatestRoundStatusCreateIfNotExist(int fighterid)
/*      */   {
/* 1069 */     FighterStatuses fighterStatuses = (FighterStatuses)this.fighterStatusMap.get(Integer.valueOf(fighterid));
/* 1070 */     if (fighterStatuses == null) {
/* 1071 */       fighterStatuses = new FighterStatuses();
/* 1072 */       this.fighterStatusMap.put(Integer.valueOf(fighterid), fighterStatuses);
/*      */     }
/*      */     
/* 1075 */     int size = fighterStatuses.statuses.size();
/* 1076 */     if (size <= 0) {
/* 1077 */       FighterStatus fighterStatus = new FighterStatus();
/* 1078 */       fighterStatuses.statuses.add(fighterStatus);
/* 1079 */       return fighterStatus;
/*      */     }
/* 1081 */     return (FighterStatus)fighterStatuses.statuses.get(size - 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isCmdedInRound(int fid)
/*      */   {
/* 1093 */     if (this.cmdedFighters == null) {
/* 1094 */       return false;
/*      */     }
/* 1096 */     return this.cmdedFighters.contains(Integer.valueOf(fid));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected void onRoundEnd()
/*      */   {
/* 1103 */     setFlow(6);
/*      */     
/* 1105 */     if (isFightEnd()) {
/* 1106 */       if (getActiveTeam().getAliveFighters().size() == 0) {
/* 1107 */         fightEndOnTeamWin(false);
/* 1108 */         return;
/*      */       }
/* 1110 */       if (getPassiveTeam().getAliveFighters().size() == 0) {
/* 1111 */         fightEndOnTeamWin(true);
/* 1112 */         return;
/*      */       }
/*      */     }
/*      */     
/* 1116 */     if (isToMaxRound()) {
/* 1117 */       fightEndOnForceEnd(100);
/* 1118 */       return;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1125 */     Iterator<FightCmd> iterator = this.xFight.getCmds().iterator();
/* 1126 */     while (iterator.hasNext()) {
/* 1127 */       FightCmd fightCmd = (FightCmd)iterator.next();
/* 1128 */       int fighterid = fightCmd.getFighterid();
/* 1129 */       Fighter fighter = getFighter(fighterid);
/* 1130 */       if ((fighter == null) || 
/*      */       
/* 1132 */         (!fighter.isHouFa()))
/*      */       {
/*      */ 
/*      */ 
/* 1136 */         iterator.remove();
/*      */       }
/*      */     }
/* 1139 */     this.xFight.setActioncountcurround(0);
/*      */     
/* 1141 */     onNextRound();
/*      */   }
/*      */   
/*      */   protected boolean isFightEnd()
/*      */   {
/* 1146 */     if (getActiveTeam().getAliveFighters().size() == 0) {
/* 1147 */       return true;
/*      */     }
/* 1149 */     if (getPassiveTeam().getAliveFighters().size() == 0) {
/* 1150 */       return true;
/*      */     }
/* 1152 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onFighterDie(int fid)
/*      */   {
/* 1161 */     getActiveTeam().onFighterDie(fid);
/* 1162 */     getPassiveTeam().onFighterDie(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onFighterRelive(int fid)
/*      */   {
/* 1171 */     getActiveTeam().onFighterRelive(fid);
/* 1172 */     getPassiveTeam().onFighterRelive(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onFightEnd(boolean activeWin, int reason)
/*      */   {
/*      */     try
/*      */     {
/* 1183 */       getActiveTeam().onFightEnd();
/* 1184 */       getPassiveTeam().onFightEnd();
/* 1185 */       FightTimer fightTimer = this.xFight.getTimer();
/* 1186 */       if (fightTimer != null) {
/* 1187 */         fightTimer.stopTimer();
/*      */       }
/* 1189 */       if (this.xFight.getUpdatetimer() != null) {
/* 1190 */         this.xFight.getUpdatetimer().stopTimer();
/*      */       }
/*      */     } catch (Exception e) {
/* 1193 */       GameServer.logger().error("战斗结束后结算发生异常", e);
/*      */     }
/*      */     
/* 1196 */     Set<Long> observerSet = new HashSet();
/* 1197 */     observerSet.addAll(this.xFight.getObservers().keySet());
/*      */     
/* 1199 */     if (observerSet.size() > 0) {
/* 1200 */       Procedure.execute(new ClearObserverProcedure(observerSet));
/*      */     }
/* 1202 */     broadCastBattleEnd(activeWin, reason);
/*      */     
/* 1204 */     FightManager.removeFight(this);
/*      */     
/*      */ 
/* 1207 */     if (isRecordEnable()) {
/* 1208 */       this.xFight.getFight_recorder().insertRecord();
/*      */     }
/*      */     
/* 1211 */     sendEndEvent(activeWin, reason);
/*      */     long recordid;
/* 1213 */     if (isGenResultAtOnce()) {
/* 1214 */       recordid = this.xFight.getFight_recorder().getRecordid();
/* 1215 */       Set<FightGroupRole> groupRoles = getActiveTeam().getGroupRoles();
/* 1216 */       for (FightGroupRole groupRole : groupRoles) {
/* 1217 */         SPetFightCVCStart spetcvc = new SPetFightCVCStart();
/* 1218 */         spetcvc.recordid = recordid;
/* 1219 */         OnlineManager.getInstance().send(groupRole.getRoleid(), spetcvc);
/*      */         
/* 1221 */         FightInterface.watchFightRecord(groupRole.getRoleid(), recordid);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected abstract void sendEndEvent(boolean paramBoolean, int paramInt);
/*      */   
/*      */ 
/*      */ 
/*      */   protected final FightContext getFightContext()
/*      */   {
/* 1234 */     return this.xFight.getContext();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final FightParam getFightParam()
/*      */   {
/* 1243 */     return this.xFight.getFightparams();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final int getType()
/*      */   {
/* 1252 */     return this.xFight.getType();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final int getCfgType()
/*      */   {
/* 1261 */     return this.xFight.getCfgtype();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final int getRound()
/*      */   {
/* 1270 */     return this.xFight.getRound();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFightReason()
/*      */   {
/* 1279 */     return this.xFight.getFightreason();
/*      */   }
/*      */   
/*      */   protected void fillFightBean(mzm.gsp.fight.Fight fightBean) {
/* 1283 */     fightBean.fight_type = getType();
/* 1284 */     fightBean.fight_uuid = this.fightid;
/* 1285 */     fightBean.fight_dis_type = getCfgType();
/* 1286 */     fightBean.round = getRound();
/* 1287 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1288 */     if (isInPrepare1Flow()) {
/* 1289 */       fightBean.operendtime = (this.xFight.getNexttimermillsec() + getRoundPrepare2Mills());
/* 1290 */     } else if (isInPrepare2Flow()) {
/* 1291 */       fightBean.operendtime = this.xFight.getNexttimermillsec();
/*      */     }
/* 1293 */     if (GameServer.logger().isDebugEnabled()) {
/* 1294 */       GameServer.logger().debug("curTime:" + curTime + " endTime:" + this.xFight.getNexttimermillsec() + " leftTime:" + fightBean.operendtime);
/*      */     }
/*      */     
/*      */ 
/* 1298 */     fightBean.fight_cfg_id = getFightCfgid();
/* 1299 */     List<Long> disObservers = getDisObservers();
/* 1300 */     for (Iterator i$ = disObservers.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 1301 */       Observer observer = new Observer();
/* 1302 */       fillObserverBean(observer, roleid);
/* 1303 */       fightBean.observers.add(observer);
/*      */     }
/* 1305 */     getActiveTeam().fillFightTeamBean(fightBean.active_team);
/* 1306 */     getPassiveTeam().fillFightTeamBean(fightBean.passive_team);
/*      */   }
/*      */   
/*      */   protected final void fillPlayChangeFightMap(Play play, int mapResouce) {
/* 1310 */     play.play_type = 7;
/* 1311 */     PlayChangeFightMap playChangeFightMap = new PlayChangeFightMap();
/* 1312 */     playChangeFightMap.mapsource = mapResouce;
/* 1313 */     play.content = playChangeFightMap.marshal(new OctetsStream());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private final void broadcastEnterFight()
/*      */   {
/* 1321 */     SEnterFightBrd brd = new SEnterFightBrd();
/* 1322 */     fillFightBean(brd.fight);
/*      */     
/* 1324 */     if (!isGenResultAtOnce()) {
/* 1325 */       broadcast(brd);
/*      */     }
/*      */     
/* 1328 */     if (isRecordEnable()) {
/* 1329 */       this.xFight.getFight_recorder().setEnterFightBrd(brd);
/*      */     }
/*      */   }
/*      */   
/*      */   protected final void broadcastNextRound() {
/* 1334 */     if (!isGenResultAtOnce()) {
/* 1335 */       SNextRoundBrd nextRoundBrd = new SNextRoundBrd();
/* 1336 */       nextRoundBrd.round = getRound();
/* 1337 */       broadcast(nextRoundBrd);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final void broadCastBattleEnd(boolean activeWin, int reason)
/*      */   {
/* 1357 */     SFightEndBrd fightEndBrd = new SFightEndBrd();
/* 1358 */     if (activeWin) {
/* 1359 */       fightEndBrd.result = 1;
/*      */     } else {
/* 1361 */       fightEndBrd.result = 2;
/*      */     }
/* 1363 */     fightEndBrd.reason = reason;
/* 1364 */     fightEndBrd.fight_uuid = this.fightid;
/*      */     
/* 1366 */     if (!isGenResultAtOnce()) {
/* 1367 */       broadcast(fightEndBrd);
/*      */     }
/*      */     
/* 1370 */     if (isRecordEnable()) {
/* 1371 */       this.xFight.getFight_recorder().setFightEndBrd(fightEndBrd);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final void setFlow(int flow)
/*      */   {
/* 1381 */     this.xFight.setFlow(flow);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final boolean isInPrepare1Flow()
/*      */   {
/* 1390 */     return this.xFight.getFlow() == 2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final boolean isInPrepare2Flow()
/*      */   {
/* 1399 */     return this.xFight.getFlow() == 3;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final void addFightCmd(int fighterid, int opType, Marshal content)
/*      */   {
/* 1413 */     if (hasFightCmd(fighterid)) {
/* 1414 */       return;
/*      */     }
/* 1416 */     FightCmd xCmd = Pod.newFightCmd();
/* 1417 */     xCmd.setFighterid(fighterid);
/* 1418 */     xCmd.setOp_type(opType);
/* 1419 */     if (content != null) {
/* 1420 */       xCmd.setContent(content);
/*      */     }
/* 1422 */     this.xFight.getCmds().add(xCmd);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final boolean hasFightCmd(int fighterid)
/*      */   {
/* 1433 */     for (FightCmd xCmd : this.xFight.getCmds()) {
/* 1434 */       if (xCmd.getFighterid() == fighterid) {
/* 1435 */         return true;
/*      */       }
/*      */     }
/* 1438 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final FightCmd getFightCmd(int fighterid)
/*      */   {
/* 1448 */     for (FightCmd xCmd : this.xFight.getCmds()) {
/* 1449 */       if (xCmd.getFighterid() == fighterid) {
/* 1450 */         return xCmd;
/*      */       }
/*      */     }
/* 1453 */     return null;
/*      */   }
/*      */   
/*      */   protected final Set<Fighter> getSelectedFighters(FighterSelector selector) {
/* 1457 */     Set<Fighter> fighters = new HashSet();
/* 1458 */     fighters.addAll(getActiveTeam().getSelectedFighters(selector));
/* 1459 */     fighters.addAll(getPassiveTeam().getSelectedFighters(selector));
/* 1460 */     return fighters;
/*      */   }
/*      */   
/*      */   protected final Fighter getFighter(int fighterid) {
/* 1464 */     Fighter fighter = getActiveTeam().getFighter(fighterid);
/* 1465 */     if (fighter == null) {
/* 1466 */       fighter = getPassiveTeam().getFighter(fighterid);
/*      */     }
/* 1468 */     return fighter;
/*      */   }
/*      */   
/*      */   protected final Fighter getFighterByRoleId(long roleId) {
/* 1472 */     FightGroupRole groupRole = getActiveTeam().getGroupRole(roleId);
/* 1473 */     if (groupRole == null) {
/* 1474 */       groupRole = getPassiveTeam().getGroupRole(roleId);
/*      */     }
/* 1476 */     if (groupRole != null) {
/* 1477 */       return groupRole.getFighterRole();
/*      */     }
/* 1479 */     return null;
/*      */   }
/*      */   
/*      */   protected final Fighter getFighterLeaved(int fighterId) {
/* 1483 */     Fighter fighter = getActiveTeam().getFighterLeaved(fighterId);
/* 1484 */     if (fighter == null) {
/* 1485 */       fighter = getPassiveTeam().getFighterLeaved(fighterId);
/*      */     }
/* 1487 */     return fighter;
/*      */   }
/*      */   
/*      */   protected final Set<Fighter> getOperableFighters() {
/* 1491 */     return getSelectedFighters(new OperableFighterSelector());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected final void sortFightCmds()
/*      */   {
/* 1498 */     XdbUtils.sortXBean(this.xFight.getCmds(), new XFightCmdComparator(this));
/*      */   }
/*      */   
/*      */   protected final int getExtra(FightExtra extraType) {
/* 1502 */     Integer value = (Integer)this.xFight.getExtra().get(Integer.valueOf(extraType.ordinal()));
/* 1503 */     if (value == null) {
/* 1504 */       return 0;
/*      */     }
/* 1506 */     return value.intValue();
/*      */   }
/*      */   
/*      */   protected final void setExtra(FightExtra extraType, int value)
/*      */   {
/* 1511 */     if (value == 0) {
/* 1512 */       this.xFight.getExtra().remove(Integer.valueOf(extraType.ordinal()));
/*      */     } else {
/* 1514 */       this.xFight.getExtra().put(Integer.valueOf(extraType.ordinal()), Integer.valueOf(value));
/*      */     }
/*      */   }
/*      */   
/*      */   protected Set<Fighter> getOccupationFighters(int occupation) {
/* 1519 */     Set<Fighter> fighters = new HashSet();
/* 1520 */     fighters.addAll(getActiveTeam().getOccupationFighters(occupation));
/* 1521 */     fighters.addAll(getPassiveTeam().getOccupationFighters(occupation));
/* 1522 */     return fighters;
/*      */   }
/*      */   
/*      */   protected long getFightStartTime() {
/* 1526 */     return this.xFight.getStarttime();
/*      */   }
/*      */   
/*      */   protected boolean containsObserver(long roleid) {
/* 1530 */     return this.xFight.getObservers().containsKey(Long.valueOf(roleid));
/*      */   }
/*      */   
/*      */   protected Integer getObsverTeam(long roleid) {
/* 1534 */     return (Integer)this.xFight.getObservers().get(Long.valueOf(roleid));
/*      */   }
/*      */   
/*      */   protected void addObserver(long roleid, int teamType) {
/* 1538 */     this.xFight.getObservers().put(Long.valueOf(roleid), Integer.valueOf(teamType));
/* 1539 */     onAddedObserver(roleid);
/*      */     
/* 1541 */     SSynRoleObserveType synRoleObserveType = new SSynRoleObserveType();
/* 1542 */     synRoleObserveType.fight_uuid = this.fightid;
/* 1543 */     synRoleObserveType.teamtype = teamType;
/* 1544 */     OnlineManager.getInstance().send(roleid, synRoleObserveType);
/*      */   }
/*      */   
/*      */   protected Integer getObserverTeamType(long roleid) {
/* 1548 */     if (this.xFight.getObservers().containsKey(Long.valueOf(roleid))) {
/* 1549 */       return (Integer)this.xFight.getObservers().get(Long.valueOf(roleid));
/*      */     }
/* 1551 */     return null;
/*      */   }
/*      */   
/*      */   protected void remObserver(List<Long> roleids, boolean sendSelf)
/*      */   {
/* 1556 */     onBeforeRemdObserver(roleids, sendSelf);
/*      */   }
/*      */   
/*      */   protected List<Long> getDisObservers() {
/* 1560 */     List<Long> list = new LinkedList();
/* 1561 */     Set<Long> set = this.xFight.getObservers().keySet();
/* 1562 */     int i = 0;
/* 1563 */     for (Iterator i$ = set.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 1564 */       if (i++ >= SFightConsts.getInstance().OBSERVER_DIS_NUM) break;
/* 1565 */       list.add(Long.valueOf(roleid));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1570 */     return list;
/*      */   }
/*      */   
/*      */   protected boolean isObserverToLimit() {
/* 1574 */     return this.xFight.getObservers().size() >= SFightConsts.getInstance().OBSERVER_NUM_LIMIT;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onAddedObserver(long addedRoleid)
/*      */   {
/* 1583 */     if (this.xFight.getObservers().size() <= SFightConsts.getInstance().OBSERVER_DIS_NUM) {
/* 1584 */       long fightid = this.fightid;
/* 1585 */       aynNotifyAddObsever(addedRoleid, fightid);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void aynNotifyAddObsever(long addedRoleid, final long fightid)
/*      */   {
/* 1597 */     Procedure.execute(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/* 1601 */         Fight fight = FightManager.getFight(fightid);
/* 1602 */         if (fight == null) {
/* 1603 */           return false;
/*      */         }
/* 1605 */         if (!fight.containsObserver(this.val$addedRoleid)) {
/* 1606 */           return false;
/*      */         }
/* 1608 */         SSynAddObserver synAddObserver = new SSynAddObserver();
/* 1609 */         Fight.this.fillObserverBean(synAddObserver.observer, this.val$addedRoleid);
/* 1610 */         OnlineManager.getInstance().sendMulti(synAddObserver, fight.getBroadcastRoles());
/* 1611 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */   protected void fillObserverBean(Observer observer, long roleid) {
/* 1617 */     observer.gender = RoleInterface.getGender(roleid);
/* 1618 */     observer.level = RoleInterface.getLevel(roleid);
/* 1619 */     observer.name = RoleInterface.getName(roleid);
/* 1620 */     observer.observerid = roleid;
/* 1621 */     observer.occupation = RoleInterface.getOccupationId(roleid);
/* 1622 */     RoleInterface.fillModelInfo(roleid, observer.model);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onBeforeRemdObserver(List<Long> roleids, boolean sendSelf)
/*      */   {
/* 1632 */     List<Long> disObservers = getDisObservers();
/* 1633 */     List<Long> notifyRemNum = new ArrayList();
/* 1634 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 1635 */       if (disObservers.contains(Long.valueOf(roleid))) {
/* 1636 */         notifyRemNum.add(Long.valueOf(roleid));
/*      */       }
/*      */     }
/*      */     
/* 1640 */     if (notifyRemNum.size() > 0)
/*      */     {
/* 1642 */       SSynObserveEnd synObserveEnd = new SSynObserveEnd();
/* 1643 */       synObserveEnd.roleids.addAll(notifyRemNum);
/* 1644 */       Set<Long> roleSet = getBroadcastRoles();
/* 1645 */       roleSet.removeAll(roleids);
/* 1646 */       OnlineManager.getInstance().sendMulti(synObserveEnd, roleSet);
/*      */     }
/*      */     
/* 1649 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1651 */       this.xFight.getObservers().remove(Long.valueOf(roleid));
/* 1652 */       if (sendSelf)
/*      */       {
/* 1654 */         SSynObserveEnd synObserveEnd = new SSynObserveEnd();
/* 1655 */         synObserveEnd.roleids.add(Long.valueOf(roleid));
/* 1656 */         OnlineManager.getInstance().send(roleid, synObserveEnd);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1661 */     int size = notifyRemNum.size();
/* 1662 */     int from = SFightConsts.getInstance().OBSERVER_DIS_NUM - size + 1;
/* 1663 */     if (size > 0) {
/* 1664 */       Set<Long> allObsevers = this.xFight.getObservers().keySet();
/* 1665 */       int counter = 1;
/* 1666 */       for (Iterator i$ = allObsevers.iterator(); i$.hasNext(); 
/*      */           
/*      */ 
/*      */ 
/* 1670 */           counter > SFightConsts.getInstance().OBSERVER_DIS_NUM)
/*      */       {
/* 1666 */         long roleid = ((Long)i$.next()).longValue();
/* 1667 */         if (counter >= from) {
/* 1668 */           aynNotifyAddObsever(roleid, this.fightid);
/*      */         }
/* 1670 */         counter++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isPVP()
/*      */   {
/* 1684 */     return this.xFight.getType() == 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isPVE()
/*      */   {
/* 1693 */     return this.xFight.getType() == 0;
/*      */   }
/*      */   
/*      */   public boolean canSeeOppsiteHpProp() {
/* 1697 */     SFightTypeCfg sFightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.xFight.getCfgtype());
/* 1698 */     if ((sFightTypeCfg == null) || (sFightTypeCfg.battleType == 1)) {
/* 1699 */       return childCanSeeOppsiteHpProp();
/*      */     }
/* 1701 */     return sFightTypeCfg.displayHp;
/*      */   }
/*      */   
/*      */   protected abstract boolean childCanSeeOppsiteHpProp();
/*      */   
/*      */   public boolean isRecordEnable()
/*      */   {
/* 1708 */     return this.xFight.getFight_recorder() != null;
/*      */   }
/*      */   
/*      */   public long getRecordid() {
/* 1712 */     FightRecorder fightRecorder = this.xFight.getFight_recorder();
/* 1713 */     if (fightRecorder == null) {
/* 1714 */       return -1L;
/*      */     }
/*      */     
/* 1717 */     return fightRecorder.getRecordid();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   long getNextTimerMillSec()
/*      */   {
/* 1726 */     return this.xFight.getNexttimermillsec();
/*      */   }
/*      */   
/*      */ 
/*      */   protected abstract int getFightCfgid();
/*      */   
/*      */ 
/*      */   public int getDiffcultType()
/*      */   {
/* 1735 */     SFightCfg fightCfg = SFightCfg.get(getFightCfgid());
/* 1736 */     if (fightCfg == null) {
/* 1737 */       return -1;
/*      */     }
/* 1739 */     return fightCfg.difficult;
/*      */   }
/*      */   
/*      */   public int getDisType() {
/* 1743 */     return this.xFight.getCfgtype();
/*      */   }
/*      */   
/*      */   void setCurRoundPlayEnd() {
/* 1747 */     this.xFight.setIscurroundend(true);
/*      */   }
/*      */   
/*      */   void onRoleRoundEnd(long roleid) {
/* 1751 */     if (this.xFight.getFlow() >= 5) {
/* 1752 */       this.xFight.getCurroundendroles().add(Long.valueOf(roleid));
/* 1753 */       if ((this.xFight.getIscurroundend()) && 
/* 1754 */         (isAllSendRoundEnd()))
/*      */       {
/* 1756 */         onRoundEnd();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean isAllSendRoundEnd()
/*      */   {
/* 1768 */     Set<Long> allRoles = getOperatorRoles();
/* 1769 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long operatorRoleid = ((Long)i$.next()).longValue();
/* 1770 */       if ((!this.xFight.getCurroundendroles().contains(Long.valueOf(operatorRoleid))) && (OnlineManager.getInstance().isOnline(operatorRoleid)))
/*      */       {
/*      */ 
/*      */ 
/* 1774 */         return false;
/*      */       }
/*      */     }
/* 1777 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean isCurRoundEnd()
/*      */   {
/* 1786 */     return this.xFight.getIscurroundend();
/*      */   }
/*      */   
/*      */   public void addActionCount() {
/* 1790 */     int actionCount = this.xFight.getActioncountcurround() + 1;
/* 1791 */     this.xFight.setActioncountcurround(actionCount);
/* 1792 */     this.xFight.setActiontotalcount(this.xFight.getActiontotalcount() + 1);
/* 1793 */     if (actionCount > this.xFight.getActionroundmaxcount()) {
/* 1794 */       this.xFight.setActionroundmaxcount(actionCount);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getActionTotalCount()
/*      */   {
/* 1804 */     return this.xFight.getActiontotalcount();
/*      */   }
/*      */   
/*      */   public int getActionMaxCurRound() {
/* 1808 */     return this.xFight.getActionroundmaxcount();
/*      */   }
/*      */   
/*      */   public Set<Integer> getFriendAiOperateFighters(int tfid) {
/* 1812 */     Set<Integer> retSet = new HashSet();
/*      */     
/* 1814 */     Fighter fighter = getPassiveTeam().getFighter(tfid);
/* 1815 */     if (fighter != null) {
/* 1816 */       for (Fighter tempFighter : getPassiveTeam().getFighters()) {
/* 1817 */         if (!tempFighter.canPlayerOperate()) {
/* 1818 */           retSet.add(Integer.valueOf(tempFighter.getid()));
/*      */         }
/*      */       }
/* 1821 */       return retSet;
/*      */     }
/*      */     
/* 1824 */     fighter = getActiveTeam().getFighter(tfid);
/* 1825 */     if (fighter != null) {
/* 1826 */       for (Fighter tempFighter : getActiveTeam().getFighters()) {
/* 1827 */         if (!tempFighter.canPlayerOperate()) {
/* 1828 */           retSet.add(Integer.valueOf(tempFighter.getid()));
/*      */         }
/*      */       }
/* 1831 */       return retSet;
/*      */     }
/* 1833 */     return retSet;
/*      */   }
/*      */   
/*      */   public Set<SkillResultHandle> getSkillResultHandles() {
/* 1837 */     return this.xFight.getSkillresulthandles();
/*      */   }
/*      */   
/*      */   public void addFighterStatusBuff(int fighterId, Buff buff) {
/* 1841 */     List<Buff> buffList = (List)this.fighterStatusBuffs.get(Integer.valueOf(fighterId));
/* 1842 */     if (buffList == null) {
/* 1843 */       buffList = new ArrayList();
/* 1844 */       this.fighterStatusBuffs.put(Integer.valueOf(fighterId), buffList);
/*      */     }
/* 1846 */     buffList.add(buff);
/*      */   }
/*      */   
/*      */   public void clearFighterStatusBuffs() {
/* 1850 */     this.fighterStatusBuffs.clear();
/*      */   }
/*      */   
/*      */   public List<Buff> getFighterStatusBuffs(int fighterId) {
/* 1854 */     return (List)this.fighterStatusBuffs.get(Integer.valueOf(fighterId));
/*      */   }
/*      */   
/*      */   public boolean isGenResultAtOnce() {
/* 1858 */     return this.xFight.getGenresultatonce();
/*      */   }
/*      */   
/*      */   public void setGenResultAtOnce(boolean atonce) {
/* 1862 */     this.xFight.setGenresultatonce(atonce);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Fight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */