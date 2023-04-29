/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RDeleteCampaign extends LogicRunnable
/*    */ {
/*    */   private final int ocpid;
/*    */   private final long roleid;
/*    */   
/*    */   public RDeleteCampaign(int ocpid, long roleid)
/*    */   {
/* 13 */     this.ocpid = ocpid;
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!CampaignChartManager.canJoin(this.ocpid))
/*    */     {
/* 22 */       GameServer.logger().error(String.format("[menpaistar]RDeleteCampaign.process@can not join|roleid=%d|ocpid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocpid) }));
/*    */       
/*    */ 
/* 25 */       return;
/*    */     }
/* 27 */     CampaignChartManager.delete(this.ocpid, this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\RDeleteCampaign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */