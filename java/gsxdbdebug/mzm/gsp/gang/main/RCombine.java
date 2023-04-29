/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.event.GangCombineArg;
/*     */ import mzm.gsp.gang.event.RoleChangeGangByCombine;
/*     */ import mzm.gsp.gang.event.RoleChangeGangByCombineArg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CombiningGangsKey;
/*     */ import xbean.GangGlobal;
/*     */ import xbean.GangMember;
/*     */ import xbean.GangMemoryBean;
/*     */ import xbean.GangTeam;
/*     */ import xtable.Basic;
/*     */ import xtable.Gangcombine;
/*     */ import xtable.Gangmemory;
/*     */ 
/*     */ class RCombine extends mzm.gsp.util.LogicRunnable
/*     */ {
/*     */   private final CombiningGangsKey cCombineKey;
/*     */   
/*     */   RCombine(CombiningGangsKey cCombineKey)
/*     */   {
/*  41 */     this.cCombineKey = cCombineKey;
/*     */   }
/*     */   
/*     */   public void process() throws Exception
/*     */   {
/*  46 */     long mainGangid = this.cCombineKey.getFront();
/*  47 */     long viceGangid = this.cCombineKey.getBehind();
/*     */     
/*     */ 
/*  50 */     xbean.Gang xMainGang = GangManager.getXGang(mainGangid, false);
/*  51 */     xbean.Gang xViceGang = GangManager.getXGang(viceGangid, false);
/*     */     
/*  53 */     if ((xMainGang == null) || (xViceGang == null)) {
/*  54 */       return;
/*     */     }
/*     */     
/*  57 */     long mainDisplayid = xMainGang.getDisplayid();
/*  58 */     long viceDisplayid = xViceGang.getDisplayid();
/*     */     
/*     */ 
/*  61 */     LinkedList<Long> mainValidMembers = new LinkedList();
/*  62 */     LinkedList<Long> mainInvalidMembers = new LinkedList();
/*  63 */     LinkedList<Long> viceValidMembers = new LinkedList();
/*  64 */     LinkedList<Long> viceInvalidMembers = new LinkedList();
/*  65 */     int mainNormalCount = GangManager.fillCombineMembers(xMainGang, mainValidMembers, mainInvalidMembers, true);
/*  66 */     GangManager.fillCombineMembers(xViceGang, viceValidMembers, viceInvalidMembers, false);
/*  67 */     int mainCapacity = GangManager.getNormalMemberCapacity(xMainGang);
/*     */     
/*  69 */     int mainInactiveCount = mainInvalidMembers.size();
/*  70 */     int viceInactiveCount = viceInvalidMembers.size();
/*     */     
/*  72 */     if (mainNormalCount + viceValidMembers.size() > mainCapacity)
/*     */     {
/*  74 */       new POnCombineFailed(this.cCombineKey).call();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  79 */       Iterator<Long> iter = mainInvalidMembers.iterator();
/*  80 */       while (iter.hasNext()) {
/*  81 */         long r = ((Long)iter.next()).longValue();
/*  82 */         new PForceKickMember(r, mainGangid).call();
/*  83 */         iter.remove();
/*     */       }
/*     */       
/*  86 */       iter = viceInvalidMembers.iterator();
/*  87 */       while (iter.hasNext()) {
/*  88 */         long r = ((Long)iter.next()).longValue();
/*  89 */         new PForceKickMember(r, viceGangid).call();
/*  90 */         iter.remove();
/*     */       }
/*     */       
/*  93 */       Iterator<Map.Entry<Long, GangTeam>> teamIter = xViceGang.getTeams().entrySet().iterator();
/*  94 */       while (teamIter.hasNext()) {
/*  95 */         Map.Entry<Long, GangTeam> entry = (Map.Entry)teamIter.next();
/*  96 */         long gangTeamid = ((Long)entry.getKey()).longValue();
/*  97 */         GangTeam xViceTeam = (GangTeam)entry.getValue();
/*     */         
/*  99 */         for (int i = 0; i < 3; i++) {
/* 100 */           PMoveGangTeam pMoveTeam = new PMoveGangTeam(gangTeamid, xViceTeam.getMembers().keySet(), viceGangid, mainGangid);
/*     */           
/* 102 */           if ((!pMoveTeam.call()) && (pMoveTeam.needRetry())) {
/* 103 */             xViceGang = GangManager.getXGang(viceGangid, false);
/* 104 */             xViceTeam = (GangTeam)xViceGang.getTeams().get(Long.valueOf(gangTeamid));
/* 105 */             if (xViceTeam == null) {
/*     */               break;
/*     */             }
/*     */           }
/*     */           else {
/* 110 */             viceValidMembers.removeAll(pMoveTeam.members);
/* 111 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 116 */       iter = viceValidMembers.iterator();
/* 117 */       while (iter.hasNext()) {
/* 118 */         long r = ((Long)iter.next()).longValue();
/* 119 */         new PMoveMember(r, viceGangid, mainGangid).call();
/*     */       }
/*     */       
/* 122 */       boolean ret = new POnCombineSucceed(this.cCombineKey).call();
/* 123 */       if (!ret) {
/* 124 */         GangManager.logError("RCombine.process@combine error|main_gangid=%d|main_displayid=%d|vice_gangid=%d|vice_displayid=%d", new Object[] { Long.valueOf(mainGangid), Long.valueOf(mainDisplayid), Long.valueOf(viceGangid), Long.valueOf(viceDisplayid) });
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 129 */       new PSyncGangToAll(mainGangid).call();
/*     */       
/*     */ 
/* 132 */       GangManager.broadcastCombine(mainGangid, xMainGang.getName(), viceGangid, xViceGang.getName(), false, viceValidMembers, 0);
/*     */       
/*     */ 
/* 135 */       GangManager.broadcastCombine(mainGangid, xMainGang.getName(), viceGangid, xViceGang.getName(), true, mainValidMembers, 0);
/*     */       
/*     */ 
/* 138 */       TLogManager.getInstance().addLogAtOnce(xMainGang.getBangzhuid(), "GangCombine", new Object[] { Long.valueOf(mainGangid), Integer.valueOf(mainInactiveCount), Long.valueOf(viceGangid), Integer.valueOf(viceInactiveCount), Long.valueOf(mainDisplayid), Long.valueOf(viceDisplayid) });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class POnCombineFailed
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final CombiningGangsKey cCombineKey;
/*     */     
/*     */ 
/*     */     POnCombineFailed(CombiningGangsKey cCombineKey)
/*     */     {
/* 152 */       this.cCombineKey = cCombineKey;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 157 */       long mainGangid = this.cCombineKey.getFront();
/* 158 */       long viceGangid = this.cCombineKey.getBehind();
/*     */       
/*     */ 
/* 161 */       lock(Gangcombine.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainGangid), Long.valueOf(viceGangid) }));
/*     */       
/*     */ 
/* 164 */       xbean.GangCombine xMainCombine = GangManager.getXCombine(mainGangid, true);
/* 165 */       xbean.GangCombine xViceCombine = GangManager.getXCombine(viceGangid, true);
/*     */       
/* 167 */       if ((xMainCombine == null) || (xViceCombine == null)) {
/* 168 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 172 */       GangGlobal xGlobal = GangManager.getXGlobal(true);
/* 173 */       boolean ret = GangManager.cancelCombine(xMainCombine, xViceCombine, this.cCombineKey, xGlobal);
/*     */       
/* 175 */       if (ret)
/*     */       {
/* 177 */         xbean.Gang xMainGang = GangManager.getXGang(this.cCombineKey.getFront(), true);
/* 178 */         xbean.Gang xViceGang = GangManager.getXGang(this.cCombineKey.getBehind(), true);
/*     */         
/*     */ 
/* 181 */         if (xMainGang != null) {
/* 182 */           GangManager.broadcastCombine(mainGangid, xMainGang.getName(), viceGangid, xViceGang.getName(), true, Arrays.asList(new Long[] { Long.valueOf(xMainGang.getBangzhuid()) }), 1);
/*     */         }
/*     */         
/* 185 */         if (xViceGang != null) {
/* 186 */           GangManager.broadcastCombine(mainGangid, xMainGang.getName(), viceGangid, xViceGang.getName(), false, Arrays.asList(new Long[] { Long.valueOf(xViceGang.getBangzhuid()) }), 1);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 191 */         TLogArg tlogArg = new TLogArg(LogReason.GANG_COMBINE_FAIL_MAIL);
/* 192 */         GangManager.sendMail(xMainGang, SGangConst.getInstance().COMBINE_FAIL_MAIL, tlogArg, new String[0]);
/* 193 */         GangManager.sendMail(xViceGang, SGangConst.getInstance().COMBINE_FAIL_MAIL, tlogArg, new String[0]);
/*     */       }
/*     */       
/* 196 */       return ret;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class POnCombineSucceed
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final CombiningGangsKey cCombineKey;
/*     */     
/*     */     POnCombineSucceed(CombiningGangsKey cCombineKey)
/*     */     {
/* 207 */       this.cCombineKey = cCombineKey;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 213 */       lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.cCombineKey.getFront()), Long.valueOf(this.cCombineKey.getBehind()) }));
/*     */       
/* 215 */       long mainGangid = this.cCombineKey.getFront();
/* 216 */       long viceGangid = this.cCombineKey.getBehind();
/*     */       
/* 218 */       xbean.Gang xMainGang = GangManager.getXGang(mainGangid, true);
/* 219 */       if (xMainGang == null) {
/* 220 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 226 */       xMainGang.setVitality(SGangConst.getInstance().GANG_LIVELY_MAX_LIMIT);
/*     */       
/* 228 */       xbean.Gang xViceGang = GangManager.getXGang(viceGangid, true);
/* 229 */       GangMemoryBean xViceGangMemory = GangManager.getXGangMemory(viceGangid, true);
/*     */       
/*     */ 
/* 232 */       GangGlobal xGlobal = GangManager.getXGlobal(true);
/*     */       
/* 234 */       if (xViceGang != null) {
/* 235 */         GangManager.deleteGang(viceGangid, xViceGang, xViceGangMemory, xGlobal);
/*     */         
/*     */ 
/* 238 */         TLogArg tlogArg = new TLogArg(LogReason.GANG_COMBINE_SUCCEED_MAIL);
/* 239 */         GangManager.sendMail(xMainGang, SGangConst.getInstance().COMBINE_SUCCEED_MAIL, tlogArg, new String[] { xMainGang.getName(), xViceGang.getName() });
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 244 */       xbean.GangCombine xMainCombine = GangManager.getXCombine(mainGangid, true);
/* 245 */       xbean.GangCombine xViceCombine = GangManager.getXCombine(viceGangid, true);
/*     */       
/* 247 */       if (xMainCombine != null) {
/* 248 */         xMainCombine.setGangid(-1L);
/* 249 */         xMainCombine.getApplicants().remove(Long.valueOf(viceGangid));
/*     */       }
/*     */       
/* 252 */       Gangcombine.remove(Long.valueOf(viceGangid));
/*     */       
/* 254 */       xGlobal.getCombine().remove(this.cCombineKey);
/*     */       
/*     */ 
/* 257 */       GangCombineArg arg = new GangCombineArg(mainGangid, viceGangid);
/* 258 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.GangCombine(), arg);
/*     */       
/* 260 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PMoveGangTeam
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long viceGangTeamid;
/* 268 */     private final List<Long> lockRoles = new ArrayList();
/*     */     
/*     */     private final long viceGangid;
/*     */     private final long mainGangid;
/* 272 */     private boolean bNeedRetry = false;
/* 273 */     private Set<Long> members = new java.util.HashSet();
/*     */     
/*     */     PMoveGangTeam(long viceGangTeamid, Collection<Long> roles, long viceGangid, long mainGangid) {
/* 276 */       this.viceGangTeamid = viceGangTeamid;
/* 277 */       this.lockRoles.addAll(roles);
/* 278 */       this.viceGangid = viceGangid;
/* 279 */       this.mainGangid = mainGangid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 285 */       lock(Basic.getTable(), this.lockRoles);
/*     */       
/* 287 */       lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.mainGangid), Long.valueOf(this.viceGangid) }));
/*     */       
/* 289 */       xbean.Gang xViceGang = GangManager.getXGang(this.viceGangid, true);
/* 290 */       GangMemoryBean xViceGangMemory = GangManager.getXGangMemory(this.viceGangid, true);
/* 291 */       xbean.Gang xMainGang = GangManager.getXGang(this.mainGangid, true);
/*     */       
/* 293 */       if ((xViceGang == null) || (xMainGang == null)) {
/* 294 */         return false;
/*     */       }
/*     */       
/* 297 */       GangTeam xGangTeam = (GangTeam)xViceGang.getTeams().get(Long.valueOf(this.viceGangTeamid));
/* 298 */       if (xGangTeam == null) {
/* 299 */         return false;
/*     */       }
/*     */       
/* 302 */       this.members.addAll(xGangTeam.getMembers().keySet());
/*     */       
/*     */ 
/* 305 */       if (!this.lockRoles.containsAll(this.members)) {
/* 306 */         this.bNeedRetry = true;
/* 307 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 311 */       for (Iterator i$ = this.members.iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*     */         
/* 313 */         Role role = RoleInterface.getRole(memberid, true);
/* 314 */         int avatarid = AvatarInterface.getCurrentAvatar(memberid);
/* 315 */         int avatarFrame = AvatarFrameInterface.getCurrentAvatarFrameId(memberid, false);
/* 316 */         int fightValue = RoleInterface.getRoleMFValue(memberid);
/* 317 */         GangMember xMember = GangManager.getXGangMember(memberid, true);
/* 318 */         if (role == null) {
/* 319 */           GangManager.logError("PMoveGangTeam.processImp@role null|gang_teamid=%d|vice_gangid=%d|main_gangid=%d|memberid=%d", new Object[] { Long.valueOf(this.viceGangTeamid), Long.valueOf(this.viceGangid), Long.valueOf(this.mainGangid), Long.valueOf(memberid) });
/*     */           
/*     */ 
/* 322 */           return false;
/*     */         }
/*     */         
/* 325 */         GangManager.moveBetweenGangs(role, avatarid, avatarFrame, fightValue, xMember, this.viceGangid, xViceGang, xViceGangMemory, this.mainGangid, xMainGang);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 330 */       long mainGangTeamid = GangManager.moveGangTeamBetweenGangs(this.viceGangTeamid, this.viceGangid, xViceGang, this.mainGangid, xMainGang);
/*     */       
/*     */ 
/* 333 */       GangManager.logInfo("PMoveGangTeam.processImp@move gang team succeed|vice_gangid=%d|vice_teamid=%d|main_gangid=%d|main_teamid|members=%s", new Object[] { Long.valueOf(this.viceGangid), Long.valueOf(this.viceGangTeamid), Long.valueOf(this.mainGangid), Long.valueOf(mainGangTeamid), this.members });
/*     */       
/*     */ 
/*     */ 
/* 337 */       return true;
/*     */     }
/*     */     
/*     */     boolean needRetry() {
/* 341 */       return this.bNeedRetry;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PMoveMember
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final long viceGangid;
/*     */     private final long mainGangid;
/*     */     
/*     */     PMoveMember(long roleid, long viceGangid, long mainGangid)
/*     */     {
/* 354 */       this.roleid = roleid;
/* 355 */       this.viceGangid = viceGangid;
/* 356 */       this.mainGangid = mainGangid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 362 */       GangMember xMember = GangManager.getXGangMember(this.roleid, true);
/* 363 */       if (xMember == null) {
/* 364 */         return false;
/*     */       }
/*     */       
/* 367 */       if (xMember.getGangid() != this.viceGangid) {
/* 368 */         return false;
/*     */       }
/*     */       
/* 371 */       int oldDuty = xMember.getDuty();
/*     */       
/*     */ 
/* 374 */       lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.mainGangid), Long.valueOf(this.viceGangid) }));
/*     */       
/* 376 */       xbean.Gang xViceGang = GangManager.getXGang(this.viceGangid, true);
/* 377 */       xbean.Gang xMainGang = GangManager.getXGang(this.mainGangid, true);
/* 378 */       GangMemoryBean xViceGangMemory = GangManager.getXGangMemory(this.viceGangid, true);
/*     */       
/* 380 */       if ((xViceGang == null) || (xMainGang == null)) {
/* 381 */         return false;
/*     */       }
/*     */       
/* 384 */       long mainDisplayid = xMainGang.getDisplayid();
/* 385 */       long viceDisplayid = xViceGang.getDisplayid();
/*     */       
/*     */ 
/* 388 */       Role role = RoleInterface.getRole(this.roleid, true);
/* 389 */       int avatarid = AvatarInterface.getCurrentAvatar(this.roleid, true);
/* 390 */       int avatarFrame = AvatarFrameInterface.getCurrentAvatarFrameId(this.roleid, true);
/* 391 */       int fightValue = RoleInterface.getRoleMFValue(this.roleid);
/*     */       
/*     */ 
/* 394 */       boolean ret = GangManager.moveBetweenGangs(role, avatarid, avatarFrame, fightValue, xMember, this.viceGangid, xViceGang, xViceGangMemory, this.mainGangid, xMainGang);
/*     */       
/*     */ 
/* 397 */       if (ret) {
/* 398 */         GangManager.logInfo("PMoveMember.processImp@move member succeed|roleid=%d|vice_gangid=%d|vice_displayid=%d|main_gangid=%d|main_displayid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.viceGangid), Long.valueOf(viceDisplayid), Long.valueOf(this.mainGangid), Long.valueOf(mainDisplayid) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 403 */         RoleChangeGangByCombineArg arg = new RoleChangeGangByCombineArg(this.roleid, this.viceGangid, this.mainGangid, oldDuty);
/* 404 */         TriggerEventsManger.getInstance().triggerEvent(new RoleChangeGangByCombine(), arg);
/*     */       }
/*     */       else {
/* 407 */         GangManager.logError("PMoveMember.processImp@move member error|roleid=%d|vice_gangid=%d|vice_displayid=%d|main_gangid=%d|main_displayid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.viceGangid), Long.valueOf(viceDisplayid), Long.valueOf(this.mainGangid), Long.valueOf(mainDisplayid) });
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 412 */       return ret;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PForceKickMember
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final long gangid;
/*     */     
/*     */     PForceKickMember(long roleid, long gangid)
/*     */     {
/* 424 */       this.roleid = roleid;
/* 425 */       this.gangid = gangid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 431 */       GangMember xMember = xtable.Role2gangmember.get(Long.valueOf(this.roleid));
/* 432 */       if (xMember == null) {
/* 433 */         return false;
/*     */       }
/*     */       
/* 436 */       if (xMember.getGangid() != this.gangid) {
/* 437 */         return false;
/*     */       }
/*     */       
/* 440 */       xbean.Gang xGang = xtable.Gang.get(Long.valueOf(this.gangid));
/* 441 */       if (xGang == null) {
/* 442 */         return false;
/*     */       }
/* 444 */       GangMemoryBean xGangMemory = GangManager.getXGangMemory(this.gangid, true);
/*     */       
/* 446 */       long displayid = xGang.getDisplayid();
/*     */       
/*     */ 
/* 449 */       if (!GangManager.removeMember(this.gangid, xGang, xGangMemory, this.roleid, xMember, true)) {
/* 450 */         GangManager.logError("PForceKickMember.processImp@kick member in combine error|roleid=%d|gangid=%d|displayid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangid), Long.valueOf(displayid) });
/*     */         
/*     */ 
/* 453 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 457 */       ForbidTalkObserver.stopObserver(this.roleid);
/*     */       
/*     */ 
/* 460 */       GangManager.triggerLeaveGangEvent(this.roleid, this.gangid, mzm.gsp.gang.event.LeaveGangArg.LeaveType.KickedOutByCombine);
/*     */       
/*     */ 
/* 463 */       TLogArg tLogArg = new TLogArg(LogReason.GANG_COMBINE_KICK_MAIL);
/* 464 */       MailInterface.synBuildAndSendMail(this.roleid, SGangConst.getInstance().COMBINE_KICK_MAIL, null, null, tLogArg);
/*     */       
/*     */ 
/* 467 */       GangManager.notifyKickByCombine(this.roleid, this.gangid);
/*     */       
/*     */ 
/* 470 */       GangManager.logInfo("PForceKickMember.processImp@kick member by combine|roleid=%d|gangid=%d|displayid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangid), Long.valueOf(displayid) });
/*     */       
/*     */ 
/*     */ 
/* 474 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PForceDismissGang
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long gangid;
/*     */     
/*     */     PForceDismissGang(long gangid)
/*     */     {
/* 485 */       this.gangid = gangid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 491 */       xbean.Gang xGang = GangManager.getXGang(this.gangid, true);
/* 492 */       GangMemoryBean xGangMemory = GangManager.getXGangMemory(this.gangid, true);
/*     */       
/*     */ 
/* 495 */       GangGlobal xGlobal = GangManager.getXGlobal(true);
/*     */       
/* 497 */       GangManager.deleteGang(this.gangid, xGang, xGangMemory, xGlobal);
/*     */       
/* 499 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PSyncGangToAll
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long gangid;
/*     */     
/*     */     PSyncGangToAll(long gangid)
/*     */     {
/* 510 */       this.gangid = gangid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 516 */       xbean.Gang xGang = GangManager.getXGang(this.gangid, false);
/* 517 */       if (xGang == null) {
/* 518 */         return false;
/*     */       }
/*     */       
/* 521 */       GangMemoryBean xMemoryBean = Gangmemory.select(Long.valueOf(this.gangid));
/*     */       
/* 523 */       xio.Protocol syncPro = GangManager.getSyncGangInfoProtocol(this.gangid, xGang, xMemoryBean);
/*     */       
/* 525 */       GangManager.broadcast(xGang, syncPro);
/*     */       
/* 527 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */