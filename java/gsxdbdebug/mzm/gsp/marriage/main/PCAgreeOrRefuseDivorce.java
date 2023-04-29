/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.marriage.SAgreeOrRefuseDivorce;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2marriage;
/*     */ 
/*     */ public class PCAgreeOrRefuseDivorce extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long sessionid;
/*     */   private final int operator;
/*     */   
/*     */   public PCAgreeOrRefuseDivorce(long roleid, long sessionid, int operator)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.sessionid = sessionid;
/*  29 */     this.operator = operator;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  34 */     Session session = DivorceReqSession.getSession(this.sessionid);
/*  35 */     if (session == null) {
/*  36 */       GameServer.logger().info(String.format("[Marriage]PCAgreeOrRefuseDivorce.processImp@session not exist|sessionid=%d", new Object[] { Long.valueOf(this.sessionid) }));
/*     */       
/*     */ 
/*  39 */       return false;
/*     */     }
/*  41 */     DivorceReqSession divorceReqSession = null;
/*  42 */     if ((session instanceof DivorceReqSession)) {
/*  43 */       divorceReqSession = (DivorceReqSession)session;
/*     */     }
/*  45 */     if (divorceReqSession == null) {
/*  46 */       GameServer.logger().info(String.format("[Marriage]PCAgreeOrRefuseDivorce.processImp@session is not DivorceReqSession|sessionid=%d", new Object[] { Long.valueOf(this.sessionid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (divorceReqSession.containsAgreeRole(this.roleid)) {
/*  55 */       GameServer.logger().info(String.format("[Marriage]PCAgreeOrRefuseDivorce.processImp@role has already operated|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     Long marriageId = Role2marriage.select(Long.valueOf(this.roleid));
/*  62 */     if (marriageId == null) {
/*  63 */       GameServer.logger().info(String.format("PCAgreeOrRefuseDivorce.processImp@player is not married|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  65 */       return false;
/*     */     }
/*  67 */     xbean.Marriage xMarriage = xtable.Marriage.select(marriageId);
/*  68 */     if (xMarriage == null) {
/*  69 */       GameServer.logger().error(String.format("[Marriage]PCAgreeOrRefuseDivorce.processImp@marriage data is wrong|roleid=%d|marriageid=%d", new Object[] { Long.valueOf(this.roleid), marriageId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*  76 */     Set<Long> roleids = new HashSet();
/*  77 */     roleids.add(Long.valueOf(xMarriage.getRoleida()));
/*  78 */     roleids.add(Long.valueOf(xMarriage.getRoleidb()));
/*  79 */     long otherRoleid = xMarriage.getRoleida();
/*  80 */     if (otherRoleid == this.roleid) {
/*  81 */       otherRoleid = xMarriage.getRoleidb();
/*     */     }
/*  83 */     if (!roleids.contains(Long.valueOf(divorceReqSession.getOwerId()))) {
/*  84 */       GameServer.logger().info(String.format("[Marriage]PCAgreeOrRefuseDivorce.processImp@player divorce sessionid wrong|roleid=%d|sessionid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.sessionid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*  91 */     if (this.operator == 0) {
/*  92 */       divorceReqSession.stopTimer();
/*  93 */       SAgreeOrRefuseDivorce agreeOrRefuseDivorce = new SAgreeOrRefuseDivorce();
/*  94 */       agreeOrRefuseDivorce.operator = this.operator;
/*  95 */       agreeOrRefuseDivorce.roleid = this.roleid;
/*  96 */       OnlineManager.getInstance().sendMulti(agreeOrRefuseDivorce, roleids);
/*  97 */       return true;
/*     */     }
/*  99 */     divorceReqSession.addAgreeRole(this.roleid);
/* 100 */     if (divorceReqSession.containsAllRole(roleids)) {
/* 101 */       divorceReqSession.stopTimer();
/*     */       
/*     */ 
/* 104 */       lock(Role2marriage.getTable(), roleids);
/* 105 */       for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 106 */         long silver = RoleInterface.getSilver(roleid);
/* 107 */         if (silver < SMarriageConsts.getInstance().divorceSilver) {
/* 108 */           MarriageManager.sendNormalResult(roleids, 40, new String[] { RoleInterface.getName(roleid) });
/*     */           
/* 110 */           return false;
/*     */         }
/* 112 */         RoleInterface.cutSilver(roleid, SMarriageConsts.getInstance().divorceSilver, new TLogArg(LogReason.DIVORCE_COST));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 117 */       for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 118 */         Role2marriage.remove(Long.valueOf(roleid));
/*     */       }
/* 120 */       boolean ret = xtable.Marriage.remove(marriageId);
/* 121 */       if (!ret) {
/* 122 */         GameServer.logger().info(String.format("[Marriage]PCAgreeOrRefuseDivorce.processImp@player has already divorced|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 127 */         return false;
/*     */       }
/*     */       
/* 130 */       int relationValue = FriendInterface.getRelationValue(xMarriage.getRoleida(), xMarriage.getRoleidb(), true);
/*     */       
/* 132 */       if (relationValue > SMarriageConsts.getInstance().divorceFriendValue) {
/* 133 */         int cutValue = relationValue - SMarriageConsts.getInstance().divorceFriendValue;
/* 134 */         FriendInterface.cutFriendValue(xMarriage.getRoleida(), xMarriage.getRoleidb(), cutValue);
/*     */       }
/*     */       
/* 137 */       MarriageManager.afterDivorce(marriageId.longValue(), xMarriage);
/* 138 */       long marriageTime = xMarriage.getMarrytime();
/* 139 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 140 */       int intervalMill = (int)(curTime - marriageTime);
/* 141 */       MarriageManager.tlogDivorce(this.roleid, otherRoleid, 0, intervalMill);
/* 142 */       MarriageManager.tlogDivorce(otherRoleid, this.roleid, 0, intervalMill);
/*     */       
/* 144 */       SAgreeOrRefuseDivorce agreeOrRefuseDivorce = new SAgreeOrRefuseDivorce();
/* 145 */       agreeOrRefuseDivorce.operator = this.operator;
/* 146 */       agreeOrRefuseDivorce.roleid = this.roleid;
/* 147 */       OnlineManager.getInstance().sendMulti(agreeOrRefuseDivorce, roleids);
/* 148 */       GameServer.logger().info(String.format("[Marriage]PCAgreeOrRefuseDivorce.processImp@divorce success!|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 153 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCAgreeOrRefuseDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */