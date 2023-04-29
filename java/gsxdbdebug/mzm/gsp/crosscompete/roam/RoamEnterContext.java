/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import hub.CrossCompeteEnterRole;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.crosscompete.team.PDesignTeam;
/*     */ import mzm.gsp.crosscompete.team.RTryRestoreTeam;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoamEnterContext
/*     */ {
/*     */   public final long factionid;
/*  24 */   private final List<RoamEnterRole> enterRoles = new ArrayList();
/*     */   public final boolean isTeam;
/*     */   private volatile long contextid;
/*     */   private volatile long sessionid;
/*     */   
/*     */   public RoamEnterContext(long factionid, List<CrossCompeteEnterRole> roles, boolean isTeam)
/*     */   {
/*  31 */     this.factionid = factionid;
/*  32 */     for (CrossCompeteEnterRole role : roles) {
/*  33 */       this.enterRoles.add(new RoamEnterRole(role.roleid, role.userid));
/*     */     }
/*  35 */     this.isTeam = isTeam;
/*     */   }
/*     */   
/*     */   void setContextid(long contextid) {
/*  39 */     this.contextid = contextid;
/*     */   }
/*     */   
/*     */   long getContextid() {
/*  43 */     return this.contextid;
/*     */   }
/*     */   
/*     */   public long getSessionid() {
/*  47 */     return this.sessionid;
/*     */   }
/*     */   
/*     */   public void setSessionid(long sessionid) {
/*  51 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */   public List<Long> getRoleidList() {
/*  55 */     List<Long> roleidList = new ArrayList();
/*  56 */     for (RoamEnterRole role : this.enterRoles) {
/*  57 */       roleidList.add(Long.valueOf(role.roleid));
/*     */     }
/*  59 */     return roleidList;
/*     */   }
/*     */   
/*     */   public boolean isDataPrepared() {
/*  63 */     for (RoamEnterRole role : this.enterRoles) {
/*  64 */       if (!role.isDataPrepared()) {
/*  65 */         return false;
/*     */       }
/*     */     }
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public boolean setDataPrepared(long roleid) {
/*  72 */     for (RoamEnterRole enterRole : this.enterRoles) {
/*  73 */       if (enterRole.roleid == roleid) {
/*  74 */         return enterRole.setDataPrepared();
/*     */       }
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public boolean setLogin(long roleid) {
/*  81 */     for (RoamEnterRole enterRole : this.enterRoles) {
/*  82 */       if (enterRole.roleid == roleid) {
/*  83 */         return enterRole.setLogin();
/*     */       }
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isRoleLogin(long roleid) {
/*  90 */     for (RoamEnterRole enterRole : this.enterRoles) {
/*  91 */       if (enterRole.roleid == roleid) {
/*  92 */         return enterRole.isLogin();
/*     */       }
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public boolean setRoleTeamRestore(long roleid) {
/*  99 */     for (RoamEnterRole enterRole : this.enterRoles) {
/* 100 */       if (enterRole.roleid == roleid) {
/* 101 */         return enterRole.setTeamRestore();
/*     */       }
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isTeamRestore() {
/* 108 */     for (RoamEnterRole enterRole : this.enterRoles) {
/* 109 */       if (!enterRole.isTeamRestore()) {
/* 110 */         return false;
/*     */       }
/*     */     }
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   RoamEnterRole getRoamRole(long roleid) {
/* 117 */     for (RoamEnterRole r : this.enterRoles) {
/* 118 */       if (r.roleid == roleid) {
/* 119 */         return r;
/*     */       }
/*     */     }
/* 122 */     return null;
/*     */   }
/*     */   
/*     */   public boolean needRestoreTeam() {
/* 126 */     if (!this.isTeam) {
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     for (RoamEnterRole r : this.enterRoles) {
/* 131 */       if (r.isKicked()) {
/* 132 */         return false;
/*     */       }
/*     */     }
/* 135 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void tryRestoreTeam(long loginRoleid)
/*     */   {
/* 144 */     boolean ret = setRoleTeamRestore(loginRoleid);
/* 145 */     if (ret) {
/* 146 */       new RTryRestoreTeam(loginRoleid, getRoleidList()).run();
/*     */     }
/*     */     else {
/* 149 */       CrossCompeteManager.logWarn("RoamEnterContext.tryRestoreTeam@no need to try restore team|login_roleid=%d", new Object[] { Long.valueOf(loginRoleid) });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   void stopSession()
/*     */   {
/* 156 */     Session.removeSession(this.sessionid);
/* 157 */     this.sessionid = -1L;
/*     */   }
/*     */   
/*     */   public void onAllRoleReady() {
/* 161 */     for (RoamEnterRole enterRole : this.enterRoles)
/*     */     {
/* 163 */       new POnAllRoleReady(enterRole.roleid, enterRole.userid, this).call();
/*     */       
/* 165 */       if (!enterRole.isLogin())
/*     */       {
/* 167 */         if (enterRole.setKicked())
/*     */         {
/* 169 */           new PReturnOriginalServer(enterRole.roleid, enterRole.userid).call();
/*     */           
/* 171 */           TeamInterface.leaveTeam(enterRole.roleid);
/*     */           
/* 173 */           CrossCompeteManager.logInfo("RoamEnterContext.onAllRoleReady@kick original server|roleid=%d|userid=%s|contextid=%d", new Object[] { Long.valueOf(enterRole.roleid), enterRole.userid, Long.valueOf(this.contextid) });
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onAllRoleLogined()
/*     */   {
/* 182 */     if (!RoamEnterContextManager.getInstance().removeContext(this.contextid)) {
/* 183 */       return;
/*     */     }
/*     */     
/*     */ 
/* 187 */     stopSession();
/*     */     
/*     */ 
/* 190 */     if (needRestoreTeam()) {
/* 191 */       List<Long> roleList = getRoleidList();
/* 192 */       new PDesignTeam(roleList).call();
/*     */     }
/*     */     
/* 195 */     onAllRoleReady();
/*     */   }
/*     */   
/*     */   public void returnOriginalServer() {
/* 199 */     for (RoamEnterRole role : this.enterRoles) {
/* 200 */       new PReturnOriginalServer(role.roleid, role.userid).call();
/*     */     }
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 206 */     return String.format("(factionid=%d;roles=%s;contextid=%d)", new Object[] { Long.valueOf(this.factionid), getRoleidList(), Long.valueOf(this.contextid) });
/*     */   }
/*     */   
/*     */   static class POnAllRoleReady
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final String userid;
/*     */     private final RoamEnterContext context;
/*     */     
/*     */     POnAllRoleReady(long roleid, String userid, RoamEnterContext context)
/*     */     {
/* 218 */       this.roleid = roleid;
/* 219 */       this.userid = userid;
/* 220 */       this.context = context;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 226 */       lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/*     */       
/* 228 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */       
/* 230 */       CrossServerInterface.removeUserRoamedInfo(this.userid, RoamType.CROSS_COMPETE, this.context.contextid);
/*     */       
/* 232 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RoamEnterContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */