/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sworn.SCreateSwornSuccessRes;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import xbean.Pod;
/*     */ import xbean.SwornBuilder;
/*     */ import xbean.SwornMember;
/*     */ import xtable.Role2swornmember;
/*     */ import xtable.Swornbuilder;
/*     */ 
/*     */ public class PConfirmCreateSwornReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long swornid;
/*     */   
/*     */   public PConfirmCreateSwornReq(long _roleid, long _swornid)
/*     */   {
/*  26 */     this.roleid = _roleid;
/*  27 */     this.swornid = _swornid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  34 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*  39 */     if ((teamid == null) || (teamid.longValue() != this.swornid))
/*     */     {
/*  41 */       SwornManager.sendCreateSwornFail(this.roleid, 1);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     long teamLeaderid = TeamInterface.getTeamLeaderByTeamid(teamid.longValue(), false);
/*  46 */     if (teamLeaderid != this.roleid)
/*     */     {
/*  48 */       SwornManager.sendCreateSwornFail(this.roleid, 11);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     List<Long> teamRoleids = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/*     */     
/*     */ 
/*  55 */     for (Iterator i$ = teamRoleids.iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*  56 */       if (Role2swornmember.select(Long.valueOf(id)) != null) {
/*  57 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  61 */     xdb.Lockeys.lock(Role2swornmember.getTable(), teamRoleids);
/*     */     
/*     */ 
/*  64 */     int needSilver = SwornConsts.getInstance().SWORN_NEED_SILVER;
/*  65 */     if (needSilver > 0)
/*     */     {
/*  67 */       if (!RoleInterface.cutSilver(this.roleid, needSilver, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.SWORN_CREATE_SWORN)))
/*     */       {
/*  69 */         SwornManager.sendCreateSwornFail(this.roleid, 8);
/*  70 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  75 */     SwornBuilder swornBuilder = Swornbuilder.get(Long.valueOf(this.swornid));
/*  76 */     if ((swornBuilder == null) || (swornBuilder.getLeaderid() != this.roleid))
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     if ((teamRoleids.size() != swornBuilder.getRoleids().size()) || (!swornBuilder.getRoleids().containsAll(teamRoleids))) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (swornBuilder.getStatus() != 4)
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     String name1 = swornBuilder.getName1();
/*  92 */     String name2 = swornBuilder.getName2();
/*     */     
/*     */ 
/*  95 */     xbean.Sworn sworn = Pod.newSworn();
/*  96 */     sworn.setName1(name1);
/*  97 */     sworn.setName2(name2);
/*  98 */     sworn.setCreaterid(swornBuilder.getLeaderid());
/*  99 */     sworn.getMembers().addAll(swornBuilder.getRoleids());
/* 100 */     sworn.getNewname().setVerifytime(0L);
/* 101 */     sworn.getKickoutmember().setVerifytime(0L);
/* 102 */     long newSwornid = xtable.Sworn.insert(sworn).longValue();
/*     */     
/*     */ 
/* 105 */     ArrayList<String> memberNames = new ArrayList();
/* 106 */     String number = SwornManager.getSwornNameNumber(sworn.getMembers().size());
/* 107 */     for (Iterator i$ = teamRoleids.iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 108 */       SwornMember swornMember = Pod.newSwornMember();
/* 109 */       swornMember.setSwornid(newSwornid);
/* 110 */       swornMember.setTitle((String)swornBuilder.getTitles().get(Long.valueOf(id)));
/* 111 */       Role2swornmember.insert(Long.valueOf(id), swornMember);
/*     */       
/*     */ 
/* 114 */       memberNames.add(RoleInterface.getName(id));
/*     */       
/*     */ 
/* 117 */       List<String> args = new ArrayList();
/* 118 */       args.add(name1);
/* 119 */       args.add(number);
/* 120 */       args.add(name2);
/* 121 */       args.add(swornMember.getTitle());
/* 122 */       mzm.gsp.title.main.TitleInterface.addAppellationNoneRealTime(id, SwornConsts.getInstance().SWORN_TITLE_CFGID, args, true);
/*     */       
/*     */ 
/* 125 */       SwornManager.addSwornBuff(id);
/*     */       
/* 127 */       SwornManager.tlogSworn(id, newSwornid, SwornOperateEnum.JOIN.value, name1, name2, swornMember.getTitle(), sworn.getNewmember().size(), 1, 0);
/*     */     }
/*     */     
/*     */ 
/* 131 */     if (!Swornbuilder.remove(Long.valueOf(this.swornid))) {
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     SCreateSwornSuccessRes res = new SCreateSwornSuccessRes(newSwornid);
/* 136 */     OnlineManager.getInstance().sendMulti(res, sworn.getMembers());
/*     */     
/* 138 */     OnlineManager.getInstance().sendAll(new mzm.gsp.sworn.SSwornCreateNotify(teamRoleids.size(), name1, name2, memberNames));
/*     */     
/*     */ 
/* 141 */     SwornManager.tlogSworn(this.roleid, newSwornid, SwornOperateEnum.CREATE.value, name1, name2, "", sworn.getNewmember().size(), 0, 0);
/*     */     
/* 143 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PConfirmCreateSwornReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */