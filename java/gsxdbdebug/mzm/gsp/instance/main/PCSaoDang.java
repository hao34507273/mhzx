/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.instance.confbean.SInstanceConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.InstanceBean;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2instance;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCSaoDang extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int instanceid;
/*    */   private final int toProcessid;
/*    */   private final int costItemNum;
/*    */   private final int costYuanBaoNum;
/*    */   
/*    */   public PCSaoDang(long roleid, int instanceid, int toProcessid, int costItemNum, int costYuanBaoNum)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.instanceid = instanceid;
/* 25 */     this.toProcessid = toProcessid;
/* 26 */     this.costItemNum = costItemNum;
/* 27 */     this.costYuanBaoNum = costYuanBaoNum;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if ((!OpenInterface.getOpenStatus(4)) || (OpenInterface.isBanPlay(this.roleid, 4)))
/*    */     {
/*    */ 
/* 37 */       OpenInterface.sendBanPlayMsg(this.roleid, 4);
/* 38 */       return false;
/*    */     }
/* 40 */     if ((!OpenInterface.getOpenStatus(446)) || (OpenInterface.isBanPlay(this.roleid, 446)))
/*    */     {
/*    */ 
/* 43 */       OpenInterface.sendBanPlayMsg(this.roleid, 446);
/* 44 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 48 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 49 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 51 */     InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(this.roleid));
/*    */     
/* 53 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, SInstanceConsts.getInstance().SINGLE_INSTANCE_ACTIVITY_TYPE_ID);
/*    */     
/* 55 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/* 57 */       GameServer.logger().info(String.format("[SingleInstance]PCSaoDang.processImp@can not join single instance|roleid=%d|instanceid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.instanceid), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*    */       
/*    */ 
/*    */ 
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     if (!SingleInstance.reqSaoDang(userid, this.roleid, this.instanceid, this.toProcessid, this.costItemNum, this.costYuanBaoNum, xInstanceBean))
/*    */     {
/*    */ 
/* 67 */       GameServer.logger().info(String.format("[SingleInstance]PCSaoDang.processImp@sao dang fail|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.instanceid), Integer.valueOf(this.toProcessid), Integer.valueOf(this.costItemNum), Integer.valueOf(this.costYuanBaoNum) }));
/*    */       
/*    */ 
/*    */ 
/* 71 */       return false;
/*    */     }
/* 73 */     GameServer.logger().info(String.format("[SingleInstance]PCSaoDang.processImp@sao dang success|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.instanceid), Integer.valueOf(this.toProcessid), Integer.valueOf(this.costItemNum), Integer.valueOf(this.costYuanBaoNum) }));
/*    */     
/*    */ 
/*    */ 
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PCSaoDang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */