/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossserver.event.ReceiveIndianaAwardRoleInfoArg;
/*     */ import mzm.gsp.crossserver.event.ReceiveIndianaAwardRoleInfoProcedure;
/*     */ import mzm.gsp.indiana.SRoleGetIndianaAwardBrd;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Indiana_infos;
/*     */ 
/*     */ public class POnReceiveIndianaAwardRoleInfo extends ReceiveIndianaAwardRoleInfoProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     SIndianaCfg cfg = SIndianaCfg.get(((ReceiveIndianaAwardRoleInfoArg)this.arg).getActivityCfgid());
/*  27 */     if (cfg == null)
/*     */     {
/*     */ 
/*  30 */       onFail(-3, null);
/*  31 */       return false;
/*     */     }
/*  33 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getTurn()));
/*  34 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  37 */       onFail(-3, null);
/*  38 */       return false;
/*     */     }
/*  40 */     SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getSortid()));
/*  41 */     if (awardInfo == null)
/*     */     {
/*     */ 
/*  44 */       onFail(-3, null);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(((ReceiveIndianaAwardRoleInfoArg)this.arg).getActivityCfgid());
/*  49 */     lock(Indiana_infos.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*  50 */     IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/*  51 */     if (xIndianaInfo == null)
/*     */     {
/*  53 */       xIndianaInfo = Pod.newIndianaInfo();
/*  54 */       Indiana_infos.insert(Long.valueOf(globalActivityCfgid), xIndianaInfo);
/*     */     }
/*  56 */     IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getTurn()));
/*  57 */     if (xIndianaTurnInfo == null)
/*     */     {
/*  59 */       xIndianaTurnInfo = Pod.newIndianaTurnInfo();
/*  60 */       xIndianaInfo.getTurn_infos().put(Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getTurn()), xIndianaTurnInfo);
/*     */     }
/*  62 */     IndianaAwardInfo xIndianaAwardInfo = (IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getSortid()));
/*  63 */     if (xIndianaAwardInfo == null)
/*     */     {
/*  65 */       xIndianaAwardInfo = Pod.newIndianaAwardInfo();
/*  66 */       xIndianaTurnInfo.getAward_infos().put(Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getSortid()), xIndianaAwardInfo);
/*     */     }
/*  68 */     for (Map.Entry<Integer, hub.IndianaAwardRoleInfo> entry : ((ReceiveIndianaAwardRoleInfoArg)this.arg).getAwardRoleInfos().entrySet())
/*     */     {
/*  70 */       int number = ((Integer)entry.getKey()).intValue();
/*  71 */       hub.IndianaAwardRoleInfo awardRoleInfo = (hub.IndianaAwardRoleInfo)entry.getValue();
/*  72 */       xbean.IndianaAwardRoleInfo xIndianaAwardRoleInfo = (xbean.IndianaAwardRoleInfo)xIndianaAwardInfo.getAward_number_infos().get(Integer.valueOf(number));
/*  73 */       if (xIndianaAwardRoleInfo == null)
/*     */       {
/*  75 */         xIndianaAwardRoleInfo = Pod.newIndianaAwardRoleInfo();
/*  76 */         xIndianaAwardInfo.getAward_number_infos().put(Integer.valueOf(number), xIndianaAwardRoleInfo);
/*     */       }
/*  78 */       if ((xIndianaAwardRoleInfo.getRoleid() > 0L) && (xIndianaAwardRoleInfo.getRoleid() != awardRoleInfo.roleid))
/*     */       {
/*  80 */         GameServer.logger().error(String.format("[indiana]POnReceiveIndianaAwardRoleInfo.processImp@roleid not match|activity_cfg_id=%d|turn=%d|sortid=%d|db_roleid=%d|protocol_roleid=%d", new Object[] { Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getActivityCfgid()), Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getTurn()), Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getSortid()), Long.valueOf(xIndianaAwardRoleInfo.getRoleid()), Long.valueOf(awardRoleInfo.roleid) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  86 */       xIndianaAwardRoleInfo.setRoleid(awardRoleInfo.roleid);
/*  87 */       xIndianaAwardRoleInfo.setRole_name(awardRoleInfo.role_name.getString("UTF-8"));
/*  88 */       xIndianaAwardRoleInfo.setAward_state(2);
/*  89 */       if ((IndianaManager.isIndianaSwitchOpen()) && (awardInfo.need_bulletin))
/*     */       {
/*  91 */         SRoleGetIndianaAwardBrd protocol = new SRoleGetIndianaAwardBrd();
/*  92 */         protocol.activity_cfg_id = ((ReceiveIndianaAwardRoleInfoArg)this.arg).getActivityCfgid();
/*  93 */         protocol.turn = ((ReceiveIndianaAwardRoleInfoArg)this.arg).getTurn();
/*  94 */         protocol.sortid = ((ReceiveIndianaAwardRoleInfoArg)this.arg).getSortid();
/*  95 */         protocol.roleid = xIndianaAwardRoleInfo.getRoleid();
/*  96 */         protocol.role_name.setString(xIndianaAwardRoleInfo.getRole_name(), "UTF-8");
/*  97 */         OnlineManager.getInstance().sendAll(protocol);
/*     */       }
/*     */     }
/*     */     
/* 101 */     GameServer.logger().info(String.format("[indiana]POnReceiveIndianaAwardRoleInfo.processImp@receive indiana award role info process success|src_zoneid=%d|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getSrcZoneid()), Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getActivityCfgid()), Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getTurn()), Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getSortid()) }));
/*     */     
/*     */ 
/*     */ 
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 110 */     StringBuilder sb = new StringBuilder();
/* 111 */     sb.append(String.format("[indiana]POnReceiveIndianaAwardRoleInfo.processImp@receive indiana award role info process fail|src_zoneid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|res=%d", new Object[] { Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getSrcZoneid()), Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getActivityCfgid()), Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getTurn()), Integer.valueOf(((ReceiveIndianaAwardRoleInfoArg)this.arg).getSortid()), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 114 */     if (extraInfo != null)
/*     */     {
/* 116 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 118 */         sb.append("|").append((String)entry.getKey());
/* 119 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 122 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\POnReceiveIndianaAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */