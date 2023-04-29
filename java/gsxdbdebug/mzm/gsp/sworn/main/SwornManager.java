/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.sworn.SRoleJoin;
/*     */ import mzm.gsp.sworn.SRoleLeave;
/*     */ import mzm.gsp.sworn.SRoleSwornId;
/*     */ import mzm.gsp.sworn.sworninfo;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.confbean.SNumberCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Sworn;
/*     */ import xbean.SwornBuilder;
/*     */ import xbean.SwornKickOut;
/*     */ import xbean.SwornMember;
/*     */ import xbean.SwornNewMember;
/*     */ import xbean.SwornNewName;
/*     */ import xdb.util.UniqName;
/*     */ import xtable.Role2swornmember;
/*     */ import xtable.Swornbuilder;
/*     */ 
/*     */ public class SwornManager
/*     */ {
/*  46 */   private static final Logger logger = Logger.getLogger(SwornManager.class);
/*     */   
/*     */   public static final int SWORN_VOTE_NORMAL = 0;
/*     */   
/*     */   public static final int SWORN_VOTE_NEWMEMBER = 1;
/*     */   
/*     */   public static final int SWORN_VOTE_NEWNAME = 2;
/*     */   
/*     */   public static final int SWORN_VOTE_KICKOUT = 3;
/*     */   public static final int SWORN_TITLE_LENGTH = 3;
/*     */   public static final int SWORN_NAME_LENGTH = 2;
/*     */   public static final long SWORN_CREATE_OVER_SECOND = 2000L;
/*  58 */   private static List<String> numberCfg = new ArrayList();
/*  59 */   private static Map<Long, Session> voteSesson = new HashMap();
/*     */   
/*     */ 
/*     */   static void init() {}
/*     */   
/*     */ 
/*     */   static void postInit() {}
/*     */   
/*     */   private static void initNumberCfg()
/*     */   {
/*  69 */     int max = SwornConsts.getInstance().MAX_MEMBER_COUNT;
/*  70 */     for (int i = 0; i <= max; i++) {
/*  71 */       numberCfg.add("");
/*     */     }
/*     */     
/*  74 */     for (SNumberCfg cfg : SNumberCfg.getAll().values()) {
/*  75 */       int num = cfg.number;
/*  76 */       if ((1 < num) && (num <= max)) {
/*  77 */         numberCfg.set(num, cfg.name);
/*     */       }
/*     */     }
/*     */     
/*  81 */     for (int i = 0; i <= max; i++) {
/*  82 */       logger.info(String.format("sworn number: %d = %s", new Object[] { Integer.valueOf(i), numberCfg.get(i) }));
/*     */     }
/*     */   }
/*     */   
/*     */   static void logDebug(String _msg)
/*     */   {
/*  88 */     if (logger.isDebugEnabled())
/*  89 */       logger.debug(_msg);
/*     */   }
/*     */   
/*     */   static void logInfo(String format, Object... args) {
/*  93 */     logger.info(String.format(format, args));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanSworn(long roleid)
/*     */   {
/* 104 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, 95, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean isRoleSworn(long roleId)
/*     */   {
/* 111 */     SwornMember swornMember1 = Role2swornmember.select(Long.valueOf(roleId));
/* 112 */     return swornMember1 != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean isSameSworn(long roleId0, long roleId1)
/*     */   {
/* 119 */     SwornMember swornMember1 = Role2swornmember.select(Long.valueOf(roleId0));
/* 120 */     if (swornMember1 == null)
/* 121 */       return false;
/* 122 */     SwornMember swornMember2 = Role2swornmember.select(Long.valueOf(roleId1));
/* 123 */     if (swornMember2 == null) {
/* 124 */       return false;
/*     */     }
/* 126 */     return swornMember1.getSwornid() == swornMember2.getSwornid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void swornBuffForTeamChange(long teamid)
/*     */   {
/* 135 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid, false);
/* 136 */     if (teamInfo == null) {
/* 137 */       return;
/*     */     }
/* 139 */     List<Long> teamRoleIds = teamInfo.getTeamMemberList();
/* 140 */     int roleCount = teamRoleIds.size();
/* 141 */     if (roleCount < 2) {
/* 142 */       if (roleCount == 1)
/* 143 */         delSwornBuff(((Long)teamRoleIds.get(0)).longValue());
/* 144 */       return;
/*     */     }
/*     */     
/* 147 */     Map<Long, Integer> swornIdCounter = new HashMap();
/*     */     
/* 149 */     List<Long> swornIds = new ArrayList();
/* 150 */     for (int i = 0; i < roleCount; i++) {
/* 151 */       swornIds.add(Long.valueOf(0L));
/* 152 */       long roleid = ((Long)teamRoleIds.get(i)).longValue();
/* 153 */       int roleTeamStatus = teamInfo.getMemberStatus(roleid);
/* 154 */       if ((roleTeamStatus != 2) && (roleTeamStatus != 1))
/*     */       {
/*     */ 
/* 157 */         SwornMember swornMember = Role2swornmember.select(Long.valueOf(roleid));
/* 158 */         if (swornMember != null)
/*     */         {
/*     */ 
/* 161 */           long swornid = swornMember.getSwornid();
/* 162 */           swornIds.set(i, Long.valueOf(swornid));
/* 163 */           Integer count = (Integer)swornIdCounter.get(Long.valueOf(swornid));
/* 164 */           if (count == null) {
/* 165 */             swornIdCounter.put(Long.valueOf(swornid), Integer.valueOf(1));
/*     */           } else
/* 167 */             swornIdCounter.put(Long.valueOf(swornid), Integer.valueOf(count.intValue() + 1));
/*     */         }
/*     */       } }
/* 170 */     for (int i = 0; i < roleCount; i++) {
/* 171 */       long swornid = ((Long)swornIds.get(i)).longValue();
/* 172 */       long roleid = ((Long)teamRoleIds.get(i)).longValue();
/* 173 */       if ((swornid > 0L) && (((Integer)swornIdCounter.get(Long.valueOf(swornid))).intValue() > 1)) {
/* 174 */         addSwornBuff(roleid);
/*     */       } else
/* 176 */         delSwornBuff(roleid);
/*     */     }
/*     */   }
/*     */   
/*     */   static void addSwornBuff(long roleid) {
/* 181 */     if (!BuffInterface.isContainBuff(roleid, SwornConsts.getInstance().SWORN_BUFFER_CFGID)) {
/* 182 */       logger.info("add sworn buff roleid=" + roleid);
/* 183 */       BuffInterface.installBuffAsyc(roleid, SwornConsts.getInstance().SWORN_BUFFER_CFGID);
/*     */     }
/*     */   }
/*     */   
/*     */   static void delSwornBuff(long roleid) {
/* 188 */     if (BuffInterface.isContainBuff(roleid, SwornConsts.getInstance().SWORN_BUFFER_CFGID)) {
/* 189 */       logger.info("del sworn buff, roleid=" + roleid);
/* 190 */       BuffInterface.uninstallBufAsyc(roleid, SwornConsts.getInstance().SWORN_BUFFER_CFGID);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void swornBuffForTeamDissolve(List<Long> teamRoleIds)
/*     */   {
/* 200 */     for (Iterator i$ = teamRoleIds.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 202 */       if (BuffInterface.isContainBuff(roleid, SwornConsts.getInstance().SWORN_BUFFER_CFGID)) {
/* 203 */         BuffInterface.uninstallBufAsyc(roleid, SwornConsts.getInstance().SWORN_BUFFER_CFGID);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean swornBuilderTeamChange(long swornid)
/*     */   {
/* 212 */     SwornBuilder swornBuilder = Swornbuilder.get(Long.valueOf(swornid));
/* 213 */     if (swornBuilder == null) {
/* 214 */       return false;
/*     */     }
/*     */     
/* 217 */     for (Iterator i$ = swornBuilder.getRoleids().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 218 */       sendCreateSwornFail(roleid, 10);
/*     */     }
/*     */     
/*     */ 
/* 222 */     return removeSwornBuilder(swornid);
/*     */   }
/*     */   
/*     */   static boolean removeSwornBuilder(long swornid)
/*     */   {
/* 227 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception {
/* 230 */         SwornBuilder swornBuilder = Swornbuilder.get(Long.valueOf(this.val$swornid));
/*     */         
/* 232 */         if (swornBuilder == null)
/* 233 */           return false;
/* 234 */         if (swornBuilder.getStatus() >= 2) {
/* 235 */           SwornManager.releaseSwornName(swornBuilder.getName1(), swornBuilder.getName2());
/*     */         }
/*     */         
/* 238 */         swornBuilder = null;
/* 239 */         if (!Swornbuilder.remove(Long.valueOf(this.val$swornid)))
/* 240 */           return false;
/* 241 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int checkSwornVote(Sworn _sworn)
/*     */   {
/* 252 */     if (!_sworn.getNewmember().isEmpty()) {
/* 253 */       return 1;
/*     */     }
/* 255 */     if (_sworn.getNewname().getVerifytime() > 0L) {
/* 256 */       return 2;
/*     */     }
/* 258 */     if (_sworn.getKickoutmember().getVerifytime() > 0L) {
/* 259 */       return 3;
/*     */     }
/* 261 */     return 0;
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
/*     */   static boolean getSwornInfo(long swornid, Sworn sworn, sworninfo info)
/*     */   {
/* 311 */     info.swornid = swornid;
/* 312 */     info.name1 = sworn.getName1();
/* 313 */     info.name2 = sworn.getName2();
/* 314 */     for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*     */       
/* 316 */       SwornMember swornMember = Role2swornmember.select(Long.valueOf(id));
/* 317 */       if ((swornMember == null) || (swornMember.getSwornid() != swornid)) {
/* 318 */         return false;
/*     */       }
/*     */       
/* 321 */       Role role = RoleInterface.getRole(id, false);
/* 322 */       info.members.add(new mzm.gsp.sworn.memberinfo(id, role.getLevel(), role.getGender(), role.getOccupationId(), role.getName(), swornMember.getTitle()));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 327 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean cutFriendValue(long _roleid, long _friendid)
/*     */   {
/* 334 */     boolean isMarriageRelation = mzm.gsp.marriage.main.MarriageInterface.isMarriageRelation(_roleid, _friendid);
/*     */     
/* 336 */     if (FriendInterface.isFriend(_roleid, _friendid, true)) {
/* 337 */       int friendValue = FriendInterface.getRelationValue(_roleid, _friendid, true);
/*     */       
/* 339 */       int value = friendValue - friendValue / 2;
/*     */       
/* 341 */       if (isMarriageRelation) {
/* 342 */         if (friendValue > SMarriageConsts.getInstance().friendValue) {
/* 343 */           if (value < SMarriageConsts.getInstance().friendValue)
/* 344 */             value = SMarriageConsts.getInstance().friendValue;
/*     */         } else {
/* 346 */           value = friendValue;
/*     */         }
/*     */       }
/* 349 */       FriendInterface.cutFriendValue(_roleid, _friendid, friendValue - value);
/*     */     }
/* 351 */     return true;
/*     */   }
/*     */   
/*     */   static boolean checkSornTitle(String _title) {
/* 355 */     if (_title == null) {
/* 356 */       return false;
/*     */     }
/* 358 */     if ((SensitiveInterface.isNameSensitive(_title)) || (!AvailableStringArgs.getInstance().isStringUsable(_title)) || (_title.matches("\\d+")) || (Math.ceil(CommonUtils.getUTF16Length(_title) / 2.0D) > 3.0D))
/*     */     {
/*     */ 
/*     */ 
/* 362 */       return false;
/*     */     }
/* 364 */     return true;
/*     */   }
/*     */   
/*     */   static int checkSornName(String _name1, String _name2)
/*     */   {
/* 369 */     if ((_name1 == null) || (_name1.isEmpty()))
/* 370 */       return 1;
/* 371 */     if ((_name2 == null) || (_name2.isEmpty())) {
/* 372 */       return 2;
/*     */     }
/* 374 */     if ((SensitiveInterface.isNameSensitive(_name1)) || (!AvailableStringArgs.getInstance().isStringUsable(_name1)) || (_name1.matches("\\d+")) || (Math.ceil(CommonUtils.getUTF16Length(_name1) / 2.0D) > 2.0D))
/*     */     {
/*     */ 
/*     */ 
/* 378 */       return 1;
/*     */     }
/* 380 */     if ((SensitiveInterface.isNameSensitive(_name2)) || (!AvailableStringArgs.getInstance().isStringUsable(_name2)) || (_name2.matches("\\d+")) || (Math.ceil(CommonUtils.getUTF16Length(_name2) / 2.0D) > 2.0D))
/*     */     {
/*     */ 
/*     */ 
/* 384 */       return 2;
/*     */     }
/* 386 */     return 0;
/*     */   }
/*     */   
/*     */   static boolean allocateSwornName(String _name1, String _name2) {
/* 390 */     if ((_name1 == null) || (_name1.isEmpty()))
/* 391 */       return false;
/* 392 */     if ((_name2 == null) || (_name2.isEmpty())) {
/* 393 */       return false;
/*     */     }
/* 395 */     String name = _name1 + "壹" + _name2;
/* 396 */     return UniqName.allocate("sworn", name);
/*     */   }
/*     */   
/*     */   static void releaseSwornName(String _name1, String _name2) {
/* 400 */     String name = _name1 + "壹" + _name2;
/* 401 */     UniqName.release("sworn", name);
/*     */   }
/*     */   
/*     */   static String BuildSwornName(int _count, String _name1, String _name2) {
/* 405 */     String numString = (String)numberCfg.get(_count);
/* 406 */     if (numString == null)
/* 407 */       numString = "";
/* 408 */     return String.format("%s%s%s", new Object[] { _name1, numString, _name2 });
/*     */   }
/*     */   
/*     */   static String getSwornNameNumber(int _memberCount) {
/* 412 */     String ret = (String)numberCfg.get(_memberCount);
/* 413 */     if (ret == null)
/* 414 */       ret = "";
/* 415 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   static void changeSwornBuilderStatus(SwornBuilder _swornBuilder, int _status) {}
/*     */   
/*     */   static void sendCreateSwornFail(long roleid, int code)
/*     */   {
/* 423 */     sendCreateSwornFail(roleid, code, "", "");
/*     */   }
/*     */   
/*     */   static void sendCreateSwornFail(long roleid, int code, String name1) {
/* 427 */     sendCreateSwornFail(roleid, code, name1, "");
/*     */   }
/*     */   
/*     */   static void sendCreateSwornFail(long roleid, int code, String name1, String name2)
/*     */   {
/* 432 */     OnlineManager.getInstance().sendAtOnce(roleid, new mzm.gsp.sworn.SCreateSwornFailRes(code, name1, name2));
/*     */   }
/*     */   
/*     */   static boolean isSwornVoteSession(long _swornid)
/*     */   {
/* 437 */     return voteSesson.keySet().contains(Long.valueOf(_swornid));
/*     */   }
/*     */   
/*     */   static void addSwornVoteSession(long _swornid, long _overTime, int _type)
/*     */   {
/* 442 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L;
/* 443 */     long time = _overTime - curTime;
/* 444 */     addSwornVoteSession(_swornid, new SwornVoteSession(_swornid, time, _overTime, _type));
/*     */   }
/*     */   
/*     */ 
/*     */   private static void addSwornVoteSession(long _swornid, Session _session)
/*     */   {
/* 450 */     delSwornVoteSession(_swornid);
/* 451 */     voteSesson.put(Long.valueOf(_swornid), _session);
/*     */   }
/*     */   
/*     */   static void delSwornVoteSession(long _swornid) {
/* 455 */     if (voteSesson.keySet().contains(Long.valueOf(_swornid))) {
/* 456 */       Session session = (Session)voteSesson.get(Long.valueOf(_swornid));
/* 457 */       if (session != null)
/* 458 */         session.stopTimer();
/* 459 */       voteSesson.remove(Long.valueOf(_swornid));
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean addNewMember(long _swornid, Sworn _sworn)
/*     */   {
/* 465 */     if (_sworn.getNewmember().isEmpty()) {
/* 466 */       return false;
/*     */     }
/*     */     
/* 469 */     SwornNewMember newMemberInfo = (SwornNewMember)((Map.Entry)_sworn.getNewmember().entrySet().iterator().next()).getValue();
/*     */     
/* 471 */     long newMemberId = newMemberInfo.getNewmemberid();
/* 472 */     if (Role2swornmember.get(Long.valueOf(newMemberId)) != null)
/*     */     {
/* 474 */       clearSwornNewMember(_swornid, _sworn);
/* 475 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 479 */     if (_sworn.getMembers().size() < SwornConsts.getInstance().MAX_MEMBER_COUNT) {
/* 480 */       SwornMember swornMember = xbean.Pod.newSwornMember();
/* 481 */       swornMember.setSwornid(_swornid);
/* 482 */       swornMember.setTitle(newMemberInfo.getNewmembertitle());
/* 483 */       Role2swornmember.insert(Long.valueOf(newMemberId), swornMember);
/*     */       
/*     */ 
/* 486 */       Role roleInfo = RoleInterface.getRole(newMemberId, false);
/* 487 */       SRoleJoin roleJion = new SRoleJoin();
/* 488 */       roleJion.swornid = _swornid;
/* 489 */       roleJion.newmemberinfo.roleid = newMemberId;
/* 490 */       roleJion.newmemberinfo.name = roleInfo.getName();
/* 491 */       roleJion.newmemberinfo.gender = roleInfo.getGender();
/* 492 */       roleJion.newmemberinfo.level = roleInfo.getLevel();
/* 493 */       roleJion.newmemberinfo.menpai = roleInfo.getOccupationId();
/* 494 */       roleJion.newmemberinfo.title = swornMember.getTitle();
/* 495 */       OnlineManager.getInstance().sendMulti(roleJion, _sworn.getMembers());
/*     */       
/*     */ 
/* 498 */       _sworn.getMembers().add(Long.valueOf(newMemberId));
/*     */       
/* 500 */       OnlineManager.getInstance().send(newMemberId, new SRoleSwornId(_swornid));
/*     */       
/*     */ 
/* 503 */       int curMemberCount = _sworn.getMembers().size();
/*     */       
/* 505 */       List<String> contextArg = new ArrayList();
/* 506 */       contextArg.add(roleInfo.getName());
/* 507 */       contextArg.add(BuildSwornName(curMemberCount, _sworn.getName1(), _sworn.getName2()));
/*     */       
/* 509 */       for (Iterator i$ = _sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*     */         
/* 511 */         MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().NEW_MEMBER_MAILID, null, contextArg, null, new TLogArg(LogReason.SWORN_MAIL_NEW_MEMBER));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 517 */       String name1 = _sworn.getName1();
/* 518 */       String name2 = _sworn.getName2();
/* 519 */       String number = getSwornNameNumber(curMemberCount);
/*     */       
/* 521 */       int titleCfgId = SwornConsts.getInstance().SWORN_TITLE_CFGID;
/* 522 */       swornMember = null;
/* 523 */       for (Iterator i$ = _sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 524 */         swornMember = Role2swornmember.select(Long.valueOf(id));
/* 525 */         if (swornMember != null)
/*     */         {
/* 527 */           List<String> args = new ArrayList();
/* 528 */           args.add(name1);
/* 529 */           args.add(number);
/* 530 */           args.add(name2);
/* 531 */           args.add(swornMember.getTitle());
/* 532 */           if (TitleInterface.isRoleHaveAppellationId(id, titleCfgId)) {
/* 533 */             TitleInterface.replaceAppellationArgsNoneRealTime(id, titleCfgId, args);
/*     */           }
/*     */           else {
/* 536 */             TitleInterface.addAppellationNoneRealTime(id, titleCfgId, args, true);
/*     */           }
/*     */         }
/*     */       }
/* 540 */       tlogSworn(newMemberId, _swornid, SwornOperateEnum.JOIN.value, name1, name2, swornMember.getTitle(), _sworn.getNewmember().size(), 2, 0);
/*     */     }
/*     */     
/* 543 */     if (!clearSwornNewMember(_swornid, _sworn)) {
/* 544 */       return false;
/*     */     }
/* 546 */     return true;
/*     */   }
/*     */   
/*     */   static boolean clearSwornNewMember(long _swornid, Sworn _sworn)
/*     */   {
/* 551 */     _sworn.getNewmember().clear();
/* 552 */     delSwornVoteSession(_swornid);
/* 553 */     return true;
/*     */   }
/*     */   
/*     */   static boolean changeSwornNewName(long _swornid, Sworn _sworn)
/*     */   {
/* 558 */     SwornNewName newName = _sworn.getNewname();
/* 559 */     if (newName.getVerifytime() <= 0L) {
/* 560 */       return false;
/*     */     }
/* 562 */     String oldName1 = _sworn.getName1();
/* 563 */     String oldName2 = _sworn.getName2();
/* 564 */     _sworn.setName1(newName.getName1());
/* 565 */     _sworn.setName2(newName.getName2());
/*     */     
/* 567 */     String name1 = _sworn.getName1();
/* 568 */     String name2 = _sworn.getName2();
/* 569 */     OnlineManager.getInstance().sendMulti(new mzm.gsp.sworn.SSwornNameChange(_swornid, name1, name2), _sworn.getMembers());
/*     */     
/*     */ 
/*     */ 
/* 573 */     int memberCount = _sworn.getMembers().size();
/* 574 */     List<String> contextArg = new ArrayList();
/* 575 */     contextArg.add(BuildSwornName(memberCount, name1, name2));
/* 576 */     for (Iterator i$ = _sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 577 */       MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().CHANGE_SWORNNAME_SUCCESS_MAILID, null, contextArg, null, new TLogArg(LogReason.SWORN_MAIL_CHANG_NAME_VOTE_S));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 583 */     String number = getSwornNameNumber(memberCount);
/* 584 */     int titleCfgId = SwornConsts.getInstance().SWORN_TITLE_CFGID;
/* 585 */     for (Iterator i$ = _sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 586 */       SwornMember swornMember = Role2swornmember.select(Long.valueOf(id));
/* 587 */       if (swornMember != null)
/*     */       {
/* 589 */         List<String> args = new ArrayList();
/* 590 */         args.add(name1);
/* 591 */         args.add(number);
/* 592 */         args.add(name2);
/* 593 */         args.add(swornMember.getTitle());
/* 594 */         if (TitleInterface.isRoleHaveAppellationId(id, titleCfgId)) {
/* 595 */           TitleInterface.replaceAppellationArgsNoneRealTime(id, titleCfgId, args);
/*     */         }
/*     */         else {
/* 598 */           TitleInterface.addAppellationNoneRealTime(id, titleCfgId, args, true);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 603 */     tlogSworn(newName.getRoleid(), _swornid, SwornOperateEnum.CHANGENAME.value, name1, name2, "", _sworn.getNewmember().size(), 0, 0);
/*     */     
/* 605 */     releaseSwornName(oldName1, oldName2);
/* 606 */     return clearSwornNewNameInfo(_swornid, _sworn);
/*     */   }
/*     */   
/*     */   static boolean clearSwornNewNameInfo(long _swornid, Sworn _sworn)
/*     */   {
/* 611 */     SwornNewName newName = _sworn.getNewname();
/* 612 */     newName.getVerifyids().clear();
/* 613 */     newName.getVoteids().clear();
/* 614 */     newName.setRoleid(0L);
/* 615 */     newName.setVerifytime(0L);
/* 616 */     delSwornVoteSession(_swornid);
/* 617 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean kickOutSwornMemberOverTime(long _swornid, Sworn _sworn)
/*     */   {
/* 623 */     SwornKickOut kickOut = _sworn.getKickoutmember();
/* 624 */     long verifyTime = kickOut.getVerifytime();
/* 625 */     if (verifyTime <= 0L) {
/* 626 */       return false;
/*     */     }
/* 628 */     int agreeCount = kickOut.getAgreevoteids().size();
/* 629 */     int allCount = kickOut.getVerifyids().size();
/*     */     
/* 631 */     int value = agreeCount * 10000 / allCount;
/* 632 */     if (value >= SwornConsts.getInstance().KICK_OUT_NEED_MEMBER_PER) {
/* 633 */       return kickOutSwornMember(_swornid, _sworn);
/*     */     }
/*     */     
/* 636 */     long kickoutid = kickOut.getKickoutid();
/* 637 */     String roleName = RoleInterface.getName(kickoutid);
/* 638 */     List<String> contextArg = new ArrayList();
/* 639 */     contextArg.add(roleName);
/* 640 */     for (Iterator i$ = kickOut.getVerifyids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 641 */       MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().KICK_OUT_FAILED_MAILID, null, contextArg, null, new TLogArg(LogReason.SWORN_MAIL_KICKOUT_FAILED));
/*     */     }
/*     */     
/*     */ 
/* 645 */     return clearSwornKickoutInfo(_swornid, _sworn);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean kickOutSwornMember(long _swornid, Sworn _sworn)
/*     */   {
/* 651 */     SwornKickOut kickOut = _sworn.getKickoutmember();
/* 652 */     if (kickOut.getVerifytime() <= 0L) {
/* 653 */       return false;
/*     */     }
/* 655 */     long kickoutid = kickOut.getKickoutid();
/* 656 */     if ((!_sworn.getMembers().contains(Long.valueOf(kickoutid))) || (Role2swornmember.get(Long.valueOf(kickoutid)) == null))
/*     */     {
/* 658 */       return false;
/*     */     }
/* 660 */     if (!Role2swornmember.remove(Long.valueOf(kickoutid)))
/* 661 */       return false;
/* 662 */     if (!_sworn.getMembers().remove(Long.valueOf(kickoutid))) {
/* 663 */       return false;
/*     */     }
/*     */     
/* 666 */     OnlineManager.getInstance().send(kickoutid, new SRoleSwornId(0L));
/*     */     
/* 668 */     SRoleLeave res = new SRoleLeave(_swornid, kickoutid);
/* 669 */     OnlineManager.getInstance().sendMulti(res, _sworn.getMembers());
/*     */     
/*     */ 
/* 672 */     List<String> contextArg = new ArrayList();
/* 673 */     String roleName = RoleInterface.getName(kickoutid);
/* 674 */     contextArg.add(roleName);
/* 675 */     contextArg.add(BuildSwornName(_sworn.getMembers().size(), _sworn.getName1(), _sworn.getName2()));
/*     */     
/* 677 */     for (Iterator i$ = kickOut.getVerifyids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 678 */       MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().KICK_OUT_SUCCESS_MAILID, null, contextArg, null, new TLogArg(LogReason.SWORN_MAIL_KICKOUT_SUCCESS));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 683 */     MailInterface.asynBuildAndSendMail(kickoutid, SwornConsts.getInstance().KICK_OUT_MEMBER_MAILID, null, null, new TLogArg(LogReason.SWORN_MAIL_KICKOUT));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 688 */     for (Iterator i$ = _sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 689 */       cutFriendValue(kickoutid, id);
/*     */     }
/*     */     
/*     */ 
/* 693 */     String name1 = _sworn.getName1();
/* 694 */     String name2 = _sworn.getName2();
/* 695 */     String number = getSwornNameNumber(_sworn.getMembers().size());
/*     */     
/* 697 */     int titleCfgId = SwornConsts.getInstance().SWORN_TITLE_CFGID;
/* 698 */     for (Iterator i$ = _sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 699 */       SwornMember swornMember = Role2swornmember.select(Long.valueOf(id));
/* 700 */       if (swornMember != null)
/*     */       {
/* 702 */         List<String> args = new ArrayList();
/* 703 */         args.add(name1);
/* 704 */         args.add(number);
/* 705 */         args.add(name2);
/* 706 */         args.add(swornMember.getTitle());
/* 707 */         if (TitleInterface.isRoleHaveAppellationId(id, titleCfgId)) {
/* 708 */           TitleInterface.replaceAppellationArgsNoneRealTime(id, titleCfgId, args);
/*     */         }
/*     */         else {
/* 711 */           TitleInterface.addAppellationNoneRealTime(id, titleCfgId, args, true);
/*     */         }
/*     */       }
/*     */     }
/* 715 */     TitleInterface.removeAppllation(kickoutid, titleCfgId);
/*     */     
/*     */ 
/* 718 */     tlogSworn(kickoutid, _swornid, SwornOperateEnum.LEAVE.value, _sworn.getName1(), _sworn.getName2(), "", _sworn.getNewmember().size(), 0, 2);
/*     */     
/* 720 */     return clearSwornKickoutInfo(_swornid, _sworn);
/*     */   }
/*     */   
/*     */   static boolean clearSwornKickoutInfo(long _swornid, Sworn _sworn)
/*     */   {
/* 725 */     SwornKickOut kickOut = _sworn.getKickoutmember();
/* 726 */     kickOut.getAgreevoteids().clear();
/* 727 */     kickOut.getNotagreevoteids().clear();
/* 728 */     kickOut.getVerifyids().clear();
/* 729 */     kickOut.setVerifytime(0L);
/* 730 */     kickOut.setRoleid(0L);
/* 731 */     kickOut.setKickoutid(0L);
/* 732 */     delSwornVoteSession(_swornid);
/* 733 */     return true;
/*     */   }
/*     */   
/*     */   static void tlogSworn(long roleid, long swornId, int operatetype, String name1, String name2, String title, int num, int enterReason, int leaveReason)
/*     */   {
/* 738 */     String logname = "Sworn";
/* 739 */     String vGameIP = mzm.gsp.GameServerInfoManager.getHostIP();
/* 740 */     String userid = RoleInterface.getUserId(roleid);
/* 741 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 743 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%s_%s|%s|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Long.valueOf(swornId), Integer.valueOf(operatetype), name1, name2, title, Integer.valueOf(num), Integer.valueOf(enterReason), Integer.valueOf(leaveReason) });
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
/* 758 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\SwornManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */