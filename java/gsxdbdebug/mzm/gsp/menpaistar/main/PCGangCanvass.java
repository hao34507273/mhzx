/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.menpaistar.SGangCanvassFailed;
/*     */ import mzm.gsp.menpaistar.SGangCanvassSuccess;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Campaign;
/*     */ import xbean.MenPaiStarCampaignInfo;
/*     */ import xbean.MenPaiStarVoteInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGangCanvass extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetRoleid;
/*     */   private final Octets text;
/*     */   
/*     */   public PCGangCanvass(long roleid, long targetRoleid, Octets text)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.targetRoleid = targetRoleid;
/*  34 */     this.text = text;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (this.targetRoleid <= 0L)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1010))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     long endTime = MenPaiStarConfigManager.voteEndTime();
/*  57 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  58 */     if (now >= endTime)
/*     */     {
/*     */ 
/*  61 */       Map<String, Object> extras = new HashMap();
/*  62 */       extras.put("end_time", Long.valueOf(endTime));
/*  63 */       onFailed(16, extras);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     int ocpid = RoleInterface.getOccupationId(this.targetRoleid);
/*  69 */     if (!CampaignChartManager.canJoin(ocpid))
/*     */     {
/*  71 */       Map<String, Object> extras = new HashMap();
/*  72 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  73 */       onFailed(-3, extras);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     CampaignChartObj chartObj = CampaignChartManager.getChartObjByRoleid(ocpid, this.targetRoleid);
/*  79 */     if (chartObj == null)
/*     */     {
/*  81 */       onFailed(-4);
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     long gangid = GangInterface.getGangId(this.roleid);
/*  87 */     if (gangid == 0L)
/*     */     {
/*  89 */       Map<String, Object> extras = new HashMap();
/*  90 */       extras.put("gangid", Long.valueOf(gangid));
/*  91 */       onFailed(10, extras);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     String userid = RoleInterface.getUserId(this.roleid);
/*  96 */     if (userid == null)
/*     */     {
/*  98 */       onFailed(2);
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 103 */     lock(Lockeys.get(User.getTable(), userid));
/* 104 */     lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     
/*     */ 
/* 107 */     MenPaiStarCampaignInfo xCampaignInfo = xtable.Role2menpaistarcampaign.get(Long.valueOf(this.targetRoleid));
/* 108 */     if (xCampaignInfo == null)
/*     */     {
/* 110 */       onFailed(-1);
/* 111 */       return false;
/*     */     }
/* 113 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(ocpid));
/* 114 */     if (xCampaign == null)
/*     */     {
/* 116 */       Map<String, Object> extras = new HashMap();
/* 117 */       extras.put("occupationid", Integer.valueOf(ocpid));
/* 118 */       onFailed(-1, extras);
/* 119 */       return false;
/*     */     }
/* 121 */     if (xCampaign.getCampaign() != 1)
/*     */     {
/* 123 */       Map<String, Object> extras = new HashMap();
/* 124 */       extras.put("occupationid", Integer.valueOf(ocpid));
/* 125 */       extras.put("campaign", Integer.valueOf(xCampaign.getCampaign()));
/* 126 */       onFailed(-1, extras);
/* 127 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 131 */     MenPaiStarVoteInfo xVoteInfo = MenPaiStarManager.getAndInitXVoteInfo(this.roleid);
/* 132 */     Long lastCanvassTime = (Long)xVoteInfo.getGang_canvass().get(Long.valueOf(this.targetRoleid));
/* 133 */     long period = TimeUnit.MINUTES.toMillis(SMenPaiStarConst.getInstance().GANG_CHANNEL_CD);
/* 134 */     if ((lastCanvassTime != null) && (lastCanvassTime.longValue() + period > now))
/*     */     {
/* 136 */       Map<String, Object> extras = new HashMap();
/* 137 */       extras.put("last_canvass_time", lastCanvassTime);
/* 138 */       onFailed(-2, extras);
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     if (!ChatInterface.chatInFaction(this.roleid, 2, this.text))
/*     */     {
/* 144 */       Map<String, Object> extras = new HashMap();
/* 145 */       String text = this.text.getString("UTF-8");
/* 146 */       extras.put("text", text);
/* 147 */       onFailed(12, extras);
/* 148 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 152 */     xVoteInfo.getGang_canvass().put(Long.valueOf(this.targetRoleid), Long.valueOf(now));
/*     */     
/*     */ 
/* 155 */     MenPaiStarManager.addTLog(this.roleid, "MenPaiStarGangCanvassForServer", new Object[] { Long.valueOf(gangid), Integer.valueOf(ocpid), Long.valueOf(this.targetRoleid) });
/*     */     
/* 157 */     SGangCanvassSuccess rsp = new SGangCanvassSuccess();
/* 158 */     rsp.target_roleid = this.targetRoleid;
/* 159 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 161 */     GameServer.logger().info(String.format("[menpaistar]PCGangCanvass.processImp@gang canvass success|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     
/*     */ 
/* 164 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 169 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 174 */     SGangCanvassFailed rsp = new SGangCanvassFailed();
/* 175 */     rsp.target_roleid = this.targetRoleid;
/* 176 */     rsp.text = this.text;
/* 177 */     rsp.retcode = retcode;
/* 178 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 180 */     StringBuffer logBuilder = new StringBuffer();
/* 181 */     logBuilder.append("[menpaistar]PCGangCanvass.onFailed@gang canvass failed");
/* 182 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 183 */     logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 184 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 186 */     if (extraParams != null)
/*     */     {
/* 188 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 190 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 194 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCGangCanvass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */