/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.bigboss.GetRoleBigBossRemoteRankContext;
/*     */ import mzm.gsp.bigboss.GetRoleBigBossRemoteRank_ClientReq;
/*     */ import mzm.gsp.bigboss.SGetRoleBigBossRemoteRankFail;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossRemoteChartTypeCfg;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetRoleBigBossRemoteRank
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int occupation;
/*     */   
/*     */   public PCGetRoleBigBossRemoteRank(long roleid, int occupation)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.occupation = occupation;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!BigbossManager.isBigBossSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  40 */       onFail(-1, null);
/*  41 */       return false;
/*     */     }
/*  43 */     if (!BigbossManager.isBigBossRemoteChartSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  46 */       onFail(-1, null);
/*  47 */       return false;
/*     */     }
/*  49 */     if (!BigbossManager.isRoleStateCanJoinBigbossActivity(this.roleid))
/*     */     {
/*     */ 
/*  52 */       onFail(-2, null);
/*  53 */       return false;
/*     */     }
/*  55 */     if (SBigbossRemoteChartTypeCfg.get(this.occupation) == null)
/*     */     {
/*     */ 
/*  58 */       onFail(-3, null);
/*  59 */       return false;
/*     */     }
/*  61 */     long startTimestamp = BigbossManager.getActivityStarttime();
/*  62 */     if (startTimestamp <= 0L)
/*     */     {
/*  64 */       startTimestamp = BigbossManager.getNextActivityStartTime() - 604800000L;
/*     */     }
/*  66 */     if (startTimestamp <= 0L)
/*     */     {
/*     */ 
/*  69 */       onFail(-6, null);
/*  70 */       return false;
/*     */     }
/*  72 */     GetRoleBigBossRemoteRankContext context = new GetRoleBigBossRemoteRankContext();
/*  73 */     context.oper_type = 0;
/*  74 */     context.count = 1;
/*  75 */     context.extra_info.replace(new GetRoleBigBossRemoteRank_ClientReq(this.roleid).marshal(new OctetsStream()));
/*  76 */     if (!CrossServerInterface.getRoleBigBossRankInfo(CommonUtils.getLong(this.occupation, (int)(startTimestamp / 1000L)), this.roleid, context.marshal(new OctetsStream())))
/*     */     {
/*     */ 
/*     */ 
/*  80 */       onFail(1, null);
/*  81 */       return false;
/*     */     }
/*  83 */     GameServer.logger().info(String.format("[bigboss]PCGetRoleBigBossRemoteRank.processImp@get role big boss remote rank from grc|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */     
/*     */ 
/*     */ 
/*  87 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  92 */     StringBuilder sb = new StringBuilder();
/*  93 */     sb.append(String.format("[bigboss]PCGetRoleBigBossRemoteRank.processImp@get role big boss remote rank fail|roleid=%d|occupation=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.occupation), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  96 */     if (extraInfo != null)
/*     */     {
/*  98 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 100 */         sb.append("|").append((String)entry.getKey());
/* 101 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 104 */     GameServer.logger().info(sb.toString());
/* 105 */     if (res > 0)
/*     */     {
/* 107 */       SGetRoleBigBossRemoteRankFail protocol = new SGetRoleBigBossRemoteRankFail();
/* 108 */       protocol.res = res;
/* 109 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\PCGetRoleBigBossRemoteRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */