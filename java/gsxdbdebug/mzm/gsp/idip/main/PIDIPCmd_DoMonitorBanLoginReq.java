/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import gnet.link.Onlines;
/*    */ import idip.DoMonitorBanLoginReq;
/*    */ import idip.IDIPCmd_DoMonitorBanLoginReq;
/*    */ import idip.IDIPPacket_DoMonitorBanLoginReq;
/*    */ 
/*    */ public class PIDIPCmd_DoMonitorBanLoginReq extends PIDIPCmd<IDIPCmd_DoMonitorBanLoginReq>
/*    */ {
/*    */   public PIDIPCmd_DoMonitorBanLoginReq(IDIPCmd_DoMonitorBanLoginReq cmd)
/*    */   {
/* 12 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean handle()
/*    */     throws Exception
/*    */   {
/* 18 */     String openId = ((DoMonitorBanLoginReq)((IDIPPacket_DoMonitorBanLoginReq)((IDIPCmd_DoMonitorBanLoginReq)this.cmd).req).body).OpenId;
/* 19 */     int areaId = ((DoMonitorBanLoginReq)((IDIPPacket_DoMonitorBanLoginReq)((IDIPCmd_DoMonitorBanLoginReq)this.cmd).req).body).AreaId;
/* 20 */     int partition = ((DoMonitorBanLoginReq)((IDIPPacket_DoMonitorBanLoginReq)((IDIPCmd_DoMonitorBanLoginReq)this.cmd).req).body).Partition;
/*    */     
/* 22 */     String userid = idip.core.Utils.getUserId(openId, areaId, partition);
/* 23 */     xbean.User xUser = xtable.User.get(userid);
/* 24 */     if (null == xUser)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     Long roleid = Onlines.getInstance().getRoleid(userid);
/* 29 */     if (roleid == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     mzm.gsp.idip.SIdipBanRole core = new mzm.gsp.idip.SIdipBanRole();
/* 35 */     core.reason.setString(idip.core.Utils.urlDecode(((DoMonitorBanLoginReq)((IDIPPacket_DoMonitorBanLoginReq)((IDIPCmd_DoMonitorBanLoginReq)this.cmd).req).body).Msg, "UTF-8"), "UTF-8");
/* 36 */     core.unbantime = ((DoMonitorBanLoginReq)((IDIPPacket_DoMonitorBanLoginReq)((IDIPCmd_DoMonitorBanLoginReq)this.cmd).req).body).EndTime;
/* 37 */     mzm.gsp.online.main.OnlineManager.getInstance().sendAtOnce(roleid.longValue(), core);
/*    */     
/* 39 */     Onlines.getInstance().kick(roleid, 2055);
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoMonitorBanLoginReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */