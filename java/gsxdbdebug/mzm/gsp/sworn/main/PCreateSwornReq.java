/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import xbean.SwornBuilder;
/*     */ import xtable.Role2swornmember;
/*     */ import xtable.Swornbuilder;
/*     */ 
/*     */ public class PCreateSwornReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCreateSwornReq(long _roleid)
/*     */   {
/*  22 */     this.roleid = _roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  27 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  29 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  30 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  34 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*     */     {
/*  36 */       SwornManager.logInfo("PCreateSwornReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*  42 */     if (teamid == null)
/*     */     {
/*  44 */       SwornManager.sendCreateSwornFail(this.roleid, 1);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     long teamLeaderid = TeamInterface.getTeamLeaderByTeamid(teamid.longValue(), false);
/*  49 */     if (teamLeaderid != this.roleid)
/*     */     {
/*  51 */       SwornManager.sendCreateSwornFail(this.roleid, 11);
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     List<Long> roleids = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/*  57 */     if (roleids.size() < SwornConsts.getInstance().MIN_MEMBER_COUNT) {
/*  58 */       SwornManager.sendCreateSwornFail(this.roleid, 3);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  64 */     xdb.Lockeys.lock(Role2swornmember.getTable(), roleids);
/*     */     
/*     */ 
/*  67 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*  68 */       int status = TeamInterface.getTeamMemberStatus(id);
/*  69 */       if (status != 0) {
/*  70 */         SwornManager.sendCreateSwornFail(this.roleid, 15, RoleInterface.getName(id));
/*  71 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  76 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*  77 */       Role role = RoleInterface.getRole(id, false);
/*  78 */       if (role.getLevel() < SwornConsts.getInstance().MIN_PLAYER_LV)
/*     */       {
/*  80 */         SwornManager.sendCreateSwornFail(this.roleid, 13, role.getName());
/*  81 */         return false;
/*     */       }
/*  83 */       if (Role2swornmember.get(Long.valueOf(id)) != null)
/*     */       {
/*  85 */         SwornManager.sendCreateSwornFail(this.roleid, 2, role.getName());
/*  86 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  91 */     for (int i = roleids.size() - 1; i > 0; i--) {
/*  92 */       long curid = ((Long)roleids.get(i)).longValue();
/*  93 */       for (int j = 0; j < i; j++) {
/*  94 */         long nextid = ((Long)roleids.get(j)).longValue();
/*     */         
/*  96 */         if (!FriendInterface.isFriend(curid, nextid, false)) {
/*  97 */           SwornManager.sendCreateSwornFail(this.roleid, 4, RoleInterface.getRole(curid, false).getName(), RoleInterface.getRole(nextid, false).getName());
/*     */           
/*     */ 
/* 100 */           return false;
/*     */         }
/*     */         
/* 103 */         if (FriendInterface.getRelationValue(curid, nextid, false) < SwornConsts.getInstance().MIN_FRIEND_VALUE) {
/* 104 */           SwornManager.sendCreateSwornFail(this.roleid, 5, RoleInterface.getRole(curid, false).getName(), RoleInterface.getRole(nextid, false).getName());
/*     */           
/*     */ 
/* 107 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 113 */     SwornBuilder swornBuilder = Swornbuilder.get(teamid);
/* 114 */     if (swornBuilder != null)
/*     */     {
/* 116 */       SwornManager.sendCreateSwornFail(this.roleid, 12);
/* 117 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 121 */     long time = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 122 */     time += SwornConsts.getInstance().SWORN_WAIT_TIME * 1000;
/* 123 */     swornBuilder = xbean.Pod.newSwornBuilder();
/* 124 */     swornBuilder.setLeaderid(this.roleid);
/* 125 */     swornBuilder.setStatus(0);
/* 126 */     swornBuilder.getRoleids().addAll(roleids);
/* 127 */     swornBuilder.setConfirmtime(time);
/*     */     
/* 129 */     Swornbuilder.add(teamid, swornBuilder);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 134 */     OnlineManager.getInstance().sendMulti(new mzm.gsp.sworn.SCreateSwornRes(teamid.longValue()), roleids);
/* 135 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PCreateSwornReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */