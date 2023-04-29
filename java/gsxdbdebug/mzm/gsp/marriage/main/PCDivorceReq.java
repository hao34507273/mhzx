/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.SDivorceRes;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2marriage;
/*     */ 
/*     */ public class PCDivorceReq extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   
/*     */   public PCDivorceReq(long roleid)
/*     */   {
/*  21 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     List<Long> teamMembers = TeamInterface.getTeamMembersDispositionByLeaderId(this.roleid);
/*  27 */     if (teamMembers.size() != 2) {
/*  28 */       GameServer.logger().info(String.format("[Marriage]PCDivorceReq.processImp@team member number is not 2|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  30 */       return false;
/*     */     }
/*     */     
/*  33 */     if (((Long)teamMembers.get(0)).longValue() != this.roleid) {
/*  34 */       GameServer.logger().info(String.format("[Marriage]PCDivorceReq.processImp@player is not team leader|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!MapInterface.isNearByNPC(this.roleid, SMarriageConsts.getInstance().marriageNPC)) {
/*  40 */       GameServer.logger().info(String.format("[Marriage]PCDivorceReq.processImp@player is not near npc|roleid=%d|NPCid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SMarriageConsts.getInstance().marriageNPC) }));
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     long silver = RoleInterface.getSilver(this.roleid);
/*  47 */     if (silver < SMarriageConsts.getInstance().divorceSilver) {
/*  48 */       GameServer.logger().info(String.format("[Marriage]PCDivorceReq.processImp@player do not has enough silver|roleid=%d|needsilver=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SMarriageConsts.getInstance().divorceSilver) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*  57 */     long otherRoleid = ((Long)teamMembers.get(1)).longValue();
/*  58 */     Long marriageId = Role2marriage.select(Long.valueOf(this.roleid));
/*  59 */     if (marriageId == null) {
/*  60 */       GameServer.logger().info(String.format("[Marriage]PCDivorceReq.processImp@player is not married|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  62 */       return false;
/*     */     }
/*  64 */     xbean.Marriage xMarriage = xtable.Marriage.select(marriageId);
/*  65 */     if (xMarriage == null) {
/*  66 */       GameServer.logger().error(String.format("[Marriage]PCDivorceReq.processImp@marriage data is wrong|roleid=%d|marriageid=%d", new Object[] { Long.valueOf(this.roleid), marriageId }));
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*  71 */     if ((xMarriage.getRoleida() != otherRoleid) && (xMarriage.getRoleidb() != otherRoleid)) {
/*  72 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@team member and leader are not a couple|roleid=%d|marriageid=%d", new Object[] { Long.valueOf(this.roleid), marriageId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     long marryTime = xMarriage.getMarrytime();
/*  84 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  85 */     double hour = (curTime - marryTime) * 1.0D / 3600000.0D;
/*  86 */     if (hour < SMarriageConsts.getInstance().canDivorceAfterMarriageHour) {
/*  87 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@Marriage time not enough|hour=%f", new Object[] { Double.valueOf(hour) }));
/*     */       
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     DivorceReqSession divorceReqSession = new DivorceReqSession(SMarriageConsts.getInstance().refuseMarriageSec, this.roleid);
/*     */     
/*  95 */     divorceReqSession.addAgreeRole(this.roleid);
/*     */     
/*  97 */     SDivorceRes sDivorceRes = new SDivorceRes();
/*  98 */     sDivorceRes.sessionid = divorceReqSession.getSessionId();
/*  99 */     OnlineManager.getInstance().send(((Long)teamMembers.get(1)).longValue(), sDivorceRes);
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCDivorceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */