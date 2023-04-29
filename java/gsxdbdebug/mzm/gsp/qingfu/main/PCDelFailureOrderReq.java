/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import gnet.GDeliveryManager;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import openau.DelFailureOrder;
/*    */ import openau.DelFailureOrderArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCDelFailureOrderReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final Octets gameOrderId;
/*    */   
/*    */   public PCDelFailureOrderReq(long roleId, Octets gameOrderId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.gameOrderId = gameOrderId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!QingfuManager.canDoAction(this.roleId, 312))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     String userId = RoleInterface.getUserId(this.roleId);
/* 35 */     if (userId == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     DelFailureOrderArg arg = new DelFailureOrderArg();
/* 41 */     arg.account = Octets.wrap(userId, "UTF-8");
/* 42 */     arg.zoneid = CommonUtils.getZoneId(userId);
/* 43 */     arg.orderid = this.gameOrderId;
/* 44 */     OctetsStream os = new OctetsStream();
/* 45 */     os.marshal(this.roleId);
/* 46 */     arg.reserved2 = os;
/* 47 */     DelFailureOrder rpc = new DelFailureOrder(arg);
/* 48 */     boolean result = GDeliveryManager.getInstance().send(rpc);
/* 49 */     if (!result)
/*    */     {
/* 51 */       GameServer.logger().error(String.format("PCDelFailureOrderReq@send rpc to auany failure|roleid=%d|game_order_id=%s", new Object[] { Long.valueOf(this.roleId), this.gameOrderId.getString("UTF-8") }));
/*    */       
/*    */ 
/*    */ 
/* 55 */       QingfuManager.onDelFailtureOrderTimeout(arg);
/*    */     }
/*    */     
/* 58 */     GameServer.logger().info(String.format("PCDelFailureOrderReq@send rpc to auany success|roleid=%d|game_order_id=%s", new Object[] { Long.valueOf(this.roleId), this.gameOrderId.getString("UTF-8") }));
/*    */     
/*    */ 
/*    */ 
/* 62 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCDelFailureOrderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */