/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sworn.SAddNewMemberRes;
/*     */ import mzm.gsp.sworn.SNewMemberConfirmSworn;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import xtable.Role2swornmember;
/*     */ 
/*     */ public class PAddNewMemberReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PAddNewMemberReq(long _roleid)
/*     */   {
/*  20 */     this.roleid = _roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  25 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  27 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  28 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  32 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*     */     {
/*  34 */       SwornManager.logInfo("PAddNewMemberReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*  40 */     if (teamid == null)
/*     */     {
/*  42 */       sendResult(4);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     long teamLeaderid = TeamInterface.getTeamLeaderByTeamid(teamid.longValue(), false);
/*  47 */     if (teamLeaderid != this.roleid)
/*     */     {
/*  49 */       sendResult(5);
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     List<Long> roleids = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/*  55 */     if (roleids.size() != 2) {
/*  56 */       sendResult(6);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     long newMemeberId = 0L;
/*     */     
/*  62 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*  63 */       if (id != this.roleid)
/*  64 */         newMemeberId = id;
/*     */     }
/*  66 */     if (newMemeberId == 0L) {
/*  67 */       sendResult(1);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (RoleInterface.getLevel(newMemeberId) < SwornConsts.getInstance().MIN_PLAYER_LV) {
/*  73 */       sendResult(11);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     xbean.SwornMember swornMember = Role2swornmember.select(Long.valueOf(this.roleid));
/*  79 */     if (swornMember == null) {
/*  80 */       sendResult(7);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     long swornid = swornMember.getSwornid();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  89 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/*  90 */     if ((sworn == null) || (!sworn.getMembers().contains(Long.valueOf(this.roleid)))) {
/*  91 */       sendResult(1);
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     if (sworn.getMembers().contains(Long.valueOf(newMemeberId))) {
/*  97 */       sendResult(8);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     roleids.clear();
/* 103 */     roleids.addAll(sworn.getMembers());
/* 104 */     roleids.add(Long.valueOf(newMemeberId));
/* 105 */     lock(Role2swornmember.getTable(), roleids);
/*     */     
/*     */ 
/* 108 */     String roleName = RoleInterface.getName(this.roleid);
/* 109 */     String memberName = RoleInterface.getName(newMemeberId);
/*     */     
/*     */ 
/* 112 */     if (Role2swornmember.get(Long.valueOf(newMemeberId)) != null) {
/* 113 */       sendResult(8);
/* 114 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 118 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/* 119 */     if ((sworn == null) || (!sworn.getMembers().contains(Long.valueOf(this.roleid)))) {
/* 120 */       sendResult(1);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     if (SwornManager.checkSwornVote(sworn) != 0) {
/* 125 */       sendResult(12);
/* 126 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 130 */     if (sworn.getMembers().size() >= SwornConsts.getInstance().MAX_MEMBER_COUNT) {
/* 131 */       sendResult(2);
/* 132 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 136 */     for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*     */       
/* 138 */       if (!mzm.gsp.friend.main.FriendInterface.isFriend(newMemeberId, id, false)) {
/* 139 */         sendResult(9, memberName, RoleInterface.getName(id));
/* 140 */         return false;
/*     */       }
/*     */       
/* 143 */       if (mzm.gsp.friend.main.FriendInterface.getRelationValue(newMemeberId, id, false) < SwornConsts.getInstance().MIN_FRIEND_VALUE) {
/* 144 */         sendResult(10, memberName, RoleInterface.getName(id));
/* 145 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 150 */     SNewMemberConfirmSworn res = new SNewMemberConfirmSworn();
/* 151 */     res.rolename = roleName;
/* 152 */     if (!SwornManager.getSwornInfo(swornid, sworn, res.info))
/* 153 */       return false;
/* 154 */     OnlineManager.getInstance().send(newMemeberId, res);
/*     */     
/* 156 */     return true;
/*     */   }
/*     */   
/*     */   void sendResult(int _code) {
/* 160 */     SAddNewMemberRes res = new SAddNewMemberRes();
/* 161 */     res.resultcode = _code;
/* 162 */     OnlineManager.getInstance().sendAtOnce(this.roleid, res);
/*     */   }
/*     */   
/*     */   void sendResult(int _code, String _name1, String _name2) {
/* 166 */     SAddNewMemberRes res = new SAddNewMemberRes();
/* 167 */     res.resultcode = _code;
/* 168 */     if (_name1 != null)
/* 169 */       res.args.add(_name1);
/* 170 */     if (_name2 != null)
/* 171 */       res.args.add(_name2);
/* 172 */     OnlineManager.getInstance().sendAtOnce(this.roleid, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PAddNewMemberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */