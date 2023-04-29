/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.menpaistar.SCampaignChart;
/*     */ import mzm.gsp.menpaistar.SGetCampaignChartFailed;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Campaign;
/*     */ import xbean.MenPaiStarCampaignInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2menpaistarcampaign;
/*     */ 
/*     */ public class PCGetCampaignChart extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetRoleid;
/*     */   
/*     */   public PCGetCampaignChart(long roleid, long targetRoleid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.targetRoleid = targetRoleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (this.targetRoleid <= 0L)
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1008))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!RoleInterface.isRoleExist(this.targetRoleid, false))
/*     */     {
/*  49 */       GameServer.logger().error(String.format("[menpaistar]PCGetCampaignChart.processImp@target role not exist|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */       
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     int ocpid = RoleInterface.getOccupationId(this.targetRoleid);
/*  57 */     CampaignChartObj chartObj = CampaignChartManager.getChartObjByRoleid(ocpid, this.targetRoleid);
/*  58 */     if (chartObj == null)
/*     */     {
/*  60 */       onFailed(-2);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     lock(xdb.Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     
/*     */ 
/*  67 */     MenPaiStarCampaignInfo xCampaignInfo = Role2menpaistarcampaign.get(Long.valueOf(this.targetRoleid));
/*  68 */     if (xCampaignInfo == null)
/*     */     {
/*  70 */       onFailed(-1);
/*  71 */       return false;
/*     */     }
/*  73 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(ocpid));
/*  74 */     if (xCampaign == null)
/*     */     {
/*  76 */       Map<String, Object> extras = new HashMap();
/*  77 */       extras.put("occcupationid", Integer.valueOf(ocpid));
/*  78 */       onFailed(-1, extras);
/*  79 */       return false;
/*     */     }
/*  81 */     if (xCampaign.getCampaign() != 1)
/*     */     {
/*  83 */       Map<String, Object> extras = new HashMap();
/*  84 */       extras.put("occcupationid", Integer.valueOf(ocpid));
/*  85 */       extras.put("campaign", Integer.valueOf(xCampaign.getCampaign()));
/*  86 */       onFailed(-1, extras);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     int serverPage = CampaignChartManager.getPage(this.targetRoleid, ocpid);
/*  91 */     if (serverPage < 0)
/*     */     {
/*  93 */       Map<String, Object> extras = new HashMap();
/*  94 */       extras.put("occcupationid", Integer.valueOf(ocpid));
/*  95 */       onFailed(1, extras);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     java.util.List<CampaignChartObj> ranks = CampaignChartManager.getRanks(ocpid, serverPage);
/* 100 */     if (ranks == null)
/*     */     {
/* 102 */       Map<String, Object> extras = new HashMap();
/* 103 */       extras.put("occcupationid", Integer.valueOf(ocpid));
/* 104 */       extras.put("server_page", Integer.valueOf(serverPage));
/* 105 */       onFailed(1, extras);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     int size = CampaignChartManager.size(ocpid);
/* 110 */     int totalPage = (int)Math.ceil(size * 1.0D / SMenPaiStarConst.getInstance().PAGE_SIZE);
/*     */     
/* 112 */     SCampaignChart rsp = new SCampaignChart();
/* 113 */     rsp.occupationid = ocpid;
/* 114 */     rsp.page = (serverPage + 1);
/* 115 */     rsp.total_page = (totalPage > 0 ? totalPage : 1);
/* 116 */     rsp.ranks = CampaignChartManager.trans(serverPage, ranks);
/* 117 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 119 */     GameServer.logger().info(String.format("[menpaistar]PCGetCampaignChart.processImp@query success|roleid=%d|occupationid=%d|page=%d|total_page=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(ocpid), Integer.valueOf(serverPage), Integer.valueOf(totalPage) }));
/*     */     
/*     */ 
/*     */ 
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 128 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 133 */     SGetCampaignChartFailed resp = new SGetCampaignChartFailed();
/* 134 */     resp.target_roleid = this.targetRoleid;
/* 135 */     resp.retcode = retcode;
/* 136 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     
/* 138 */     StringBuffer logBuilder = new StringBuffer();
/* 139 */     logBuilder.append("[menpaistar]PCGetCampaignChart.onFailed@operate failed");
/* 140 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 141 */     logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 142 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 144 */     if (extraParams != null)
/*     */     {
/* 146 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 148 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 152 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCGetCampaignChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */