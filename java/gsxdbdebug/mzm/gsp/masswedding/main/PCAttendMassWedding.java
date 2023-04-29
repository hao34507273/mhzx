/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.masswedding.SAttendMassWeddingErrorRes;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassWedding;
/*     */ 
/*     */ public class PCAttendMassWedding extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCAttendMassWedding(long roleid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     List<Long> normalRoles = mzm.gsp.team.main.TeamInterface.getNormalRoleList(this.roleid);
/*  31 */     if (!normalRoles.contains(Long.valueOf(this.roleid))) {
/*  32 */       normalRoles.clear();
/*  33 */       normalRoles.add(Long.valueOf(this.roleid));
/*     */     }
/*  35 */     if (((Long)normalRoles.get(0)).longValue() != this.roleid) {
/*  36 */       GameServer.logger().info(String.format("[MassWedding]PCAttendMassWedding.processImp@role is not leader|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  38 */       return false;
/*     */     }
/*  40 */     for (Iterator i$ = normalRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  41 */       if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(roleid, 164)))
/*     */       {
/*  43 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 164);
/*     */         
/*  45 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  49 */     Map<Long, String> role2UseridMap = new HashMap();
/*  50 */     for (Iterator i$ = normalRoles.iterator(); i$.hasNext();) { long tempRoleid = ((Long)i$.next()).longValue();
/*  51 */       role2UseridMap.put(Long.valueOf(tempRoleid), RoleInterface.getUserId(tempRoleid));
/*     */     }
/*     */     
/*  54 */     lock(xtable.User.getTable(), role2UseridMap.values());
/*     */     
/*  56 */     lock(xtable.Role2properties.getTable(), role2UseridMap.keySet());
/*  57 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(role2UseridMap, normalRoles, SMassWeddingConsts.getInstance().activityid);
/*     */     
/*     */ 
/*  60 */     if (!activityJoinResult.isCanJoin()) {
/*  61 */       if (activityJoinResult.isActivityNotOpen()) {
/*  62 */         sendErrorRes(1, new String[0]);
/*     */       }
/*  64 */       GameServer.logger().info(String.format("[MassWedding]PCAttendMassWedding.processImp@can not attend activity|reason=%d|roleid=%d", new Object[] { Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     boolean ret = mzm.gsp.status.main.RoleStatusInterface.setStatus(normalRoles, 39, true);
/*  72 */     if (!ret) {
/*  73 */       GameServer.logger().info(String.format("[MassWedding]PCAttendMassWedding.processImp@can not set massWeddingStatus|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  77 */       return false;
/*     */     }
/*  79 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/*  80 */     if (xMassWedding == null) {
/*  81 */       sendErrorRes(1, new String[0]);
/*  82 */       return false;
/*     */     }
/*  84 */     if (xMassWedding.getEndearlier() == 1) {
/*  85 */       sendErrorRes(2, new String[0]);
/*  86 */       return false;
/*     */     }
/*  88 */     long worldid = xMassWedding.getWorldid();
/*  89 */     MapInterface.transferToScene(this.roleid, worldid, SMassWeddingConsts.getInstance().mapid);
/*  90 */     GameServer.logger().info(String.format("[MassWedding]PCAttendMassWedding.processImp@transfor to world|world=%d|mapid=%d|roleid=%d", new Object[] { Long.valueOf(worldid), Integer.valueOf(SMassWeddingConsts.getInstance().mapid), Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*     */ 
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRes(int result, String... args) {
/*  98 */     SAttendMassWeddingErrorRes attendMassWeddingErrorRes = new SAttendMassWeddingErrorRes();
/*  99 */     attendMassWeddingErrorRes.result = result;
/* 100 */     for (String arg : args) {
/* 101 */       attendMassWeddingErrorRes.args.add(arg);
/*     */     }
/* 103 */     OnlineManager.getInstance().sendAtOnce(this.roleid, attendMassWeddingErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCAttendMassWedding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */