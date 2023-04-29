/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.indiana.SGetRoleAttendIndianaInfoSuccess;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleIndianaActivityInfo;
/*     */ import xbean.RoleIndianaInfo;
/*     */ import xbean.RoleIndianaTurnInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_indiana_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetRoleAttendIndianaInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int turn;
/*     */   
/*     */   public PCGetRoleAttendIndianaInfo(long roleid, int activityCfgid, int turn)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.activityCfgid = activityCfgid;
/*  31 */     this.turn = turn;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     SIndianaCfg cfg = SIndianaCfg.get(this.activityCfgid);
/*  38 */     if (cfg == null)
/*     */     {
/*     */ 
/*  41 */       onFail(-3, null);
/*  42 */       return false;
/*     */     }
/*  44 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(this.turn));
/*  45 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  48 */       onFail(-3, null);
/*  49 */       return false;
/*     */     }
/*  51 */     if (!IndianaManager.isIndianaSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  54 */       onFail(-1, null);
/*  55 */       return false;
/*     */     }
/*  57 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1995, true))
/*     */     {
/*     */ 
/*  60 */       onFail(-2, null);
/*  61 */       return false;
/*     */     }
/*  63 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  65 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  67 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  68 */     SGetRoleAttendIndianaInfoSuccess protocol = new SGetRoleAttendIndianaInfoSuccess();
/*  69 */     protocol.activity_cfg_id = this.activityCfgid;
/*  70 */     protocol.turn = this.turn;
/*  71 */     RoleIndianaInfo xRoleIndianaInfo = Role_indiana_infos.get(Long.valueOf(this.roleid));
/*  72 */     if (xRoleIndianaInfo != null)
/*     */     {
/*  74 */       RoleIndianaActivityInfo xRoleIndianaActivityInfo = (RoleIndianaActivityInfo)xRoleIndianaInfo.getActivity_infos().get(Integer.valueOf(this.activityCfgid));
/*     */       
/*  76 */       if (xRoleIndianaActivityInfo != null)
/*     */       {
/*  78 */         RoleIndianaTurnInfo xRoleIndianaTurnInfo = (RoleIndianaTurnInfo)xRoleIndianaActivityInfo.getTurn_infos().get(Integer.valueOf(this.turn));
/*  79 */         if (xRoleIndianaTurnInfo != null)
/*     */         {
/*  81 */           protocol.attend_sortids.addAll(xRoleIndianaTurnInfo.getNumber_infos().keySet());
/*     */         }
/*     */       }
/*     */     }
/*  85 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*  86 */     GameServer.logger().info(String.format("[indiana]PCGetRoleAttendIndianaInfo.processImp@get role attend indiana info success|roleid=%d|activity_cfg_id=%d|turn=%d|attend_sortids=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), protocol.attend_sortids.toString() }));
/*     */     
/*     */ 
/*     */ 
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  95 */     StringBuilder sb = new StringBuilder();
/*  96 */     sb.append(String.format("[indiana]PCGetRoleAttendIndianaInfo.processImp@get role attend indiana info fail|roleid=%d|activity_cfg_id=%d|turn=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  99 */     if (extraInfo != null)
/*     */     {
/* 101 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 103 */         sb.append("|").append((String)entry.getKey());
/* 104 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 107 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\PCGetRoleAttendIndianaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */