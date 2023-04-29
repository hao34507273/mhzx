/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.SForceDivorceRes;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ForcedDivorceTimer;
/*     */ import xtable.Role2marriage;
/*     */ 
/*     */ public class PCForceDivorce extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCForceDivorce(long roleid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     Long marriageId = Role2marriage.select(Long.valueOf(this.roleid));
/*  31 */     if (marriageId == null) {
/*  32 */       GameServer.logger().info(String.format("[Marriage]PCForceDivorce.processImp@player is not married|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     if (!MapInterface.isNearByNPC(this.roleid, SMarriageConsts.getInstance().marriageNPC)) {
/*  38 */       GameServer.logger().info(String.format("[Marriage]PCForceDivorce.processImp@player is not near npc|roleid=%d|NPCid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SMarriageConsts.getInstance().marriageNPC) }));
/*     */       
/*     */ 
/*  41 */       return false;
/*     */     }
/*  43 */     xbean.Marriage xSelectMarriage = xtable.Marriage.select(marriageId);
/*  44 */     if (xSelectMarriage == null) {
/*  45 */       GameServer.logger().error(String.format("[Marriage]PCForceDivorce.processImp@marriage data is wrong|roleid=%d|marriageid=%d", new Object[] { Long.valueOf(this.roleid), marriageId }));
/*     */       
/*     */ 
/*  48 */       return false;
/*     */     }
/*  50 */     if (xSelectMarriage.getParammap().containsKey(Integer.valueOf(2))) {
/*  51 */       MarriageManager.sendNormalResult(this.roleid, 100, new String[0]);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     long marryTime = xSelectMarriage.getMarrytime();
/*  56 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  57 */     double hour = (curTime - marryTime) * 1.0D / 3600000.0D;
/*  58 */     if (hour < SMarriageConsts.getInstance().canDivorceAfterMarriageHour) {
/*  59 */       GameServer.logger().info(String.format("[Marriage]PCForceDivorce.processImp@Marriage time not enough|hour=%f", new Object[] { Double.valueOf(hour) }));
/*     */       
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     long otherRoleid = xSelectMarriage.getRoleida();
/*  65 */     if (otherRoleid == this.roleid) {
/*  66 */       otherRoleid = xSelectMarriage.getRoleidb();
/*     */     }
/*     */     
/*     */ 
/*  70 */     lock(Role2marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(otherRoleid) }));
/*  71 */     long silver = RoleInterface.getSilver(this.roleid);
/*     */     
/*  73 */     if (silver < SMarriageConsts.getInstance().forceDivorceSilver) {
/*  74 */       GameServer.logger().info(String.format("[Marriage]PCForceDivorce.processImp@do not has enough silver|roleid=%d|silver=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(silver) }));
/*     */       
/*     */ 
/*  77 */       return false;
/*     */     }
/*  79 */     RoleInterface.cutSilver(this.roleid, SMarriageConsts.getInstance().forceDivorceSilver, new TLogArg(LogReason.FORCE_DIVORCE_COST));
/*     */     
/*  81 */     xbean.Marriage xMarriage = xtable.Marriage.get(marriageId);
/*  82 */     if (xMarriage == null) {
/*  83 */       GameServer.logger().info(String.format("[Marriage]PCForceDivorce.processImp@marriage date not exist,multi threads problem|marriageId=%d", new Object[] { marriageId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  90 */       return false;
/*     */     }
/*  92 */     int forceDivorceTimeSec = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  93 */     xMarriage.getParammap().put(Integer.valueOf(1), Integer.valueOf(forceDivorceTimeSec));
/*  94 */     if (this.roleid == xMarriage.getRoleida()) {
/*  95 */       xMarriage.getParammap().put(Integer.valueOf(2), Integer.valueOf(1));
/*     */     }
/*     */     else {
/*  98 */       xMarriage.getParammap().put(Integer.valueOf(2), Integer.valueOf(2));
/*     */     }
/*     */     
/* 101 */     xMarriage.getParammap().put(Integer.valueOf(3), Integer.valueOf(SMarriageConsts.getInstance().forceDivorceSilver));
/*     */     
/*     */ 
/* 104 */     mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(otherRoleid, SMarriageConsts.getInstance().forceDivorceMail, new ArrayList(), Arrays.asList(new String[] { RoleInterface.getName(this.roleid) }), new TLogArg(LogReason.MARRIAGE_FORCE_DIVORCE_NOTIFY));
/*     */     
/*     */ 
/* 107 */     ForceDivorceSession forceDivorceSession = new ForceDivorceSession(SMarriageConsts.getInstance().forceDivorceHour * 3600, this.roleid);
/*     */     
/* 109 */     ForcedDivorceTimer xForcedDivorceTimer = xbean.Pod.newForcedDivorceTimer();
/* 110 */     xForcedDivorceTimer.setForcedivorcetimer(forceDivorceSession);
/* 111 */     xtable.Role2forcedivorcetimer.insert(Long.valueOf(this.roleid), xForcedDivorceTimer);
/* 112 */     SForceDivorceRes forceDivorceRes = new SForceDivorceRes();
/* 113 */     OnlineManager.getInstance().send(this.roleid, forceDivorceRes);
/* 114 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCForceDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */