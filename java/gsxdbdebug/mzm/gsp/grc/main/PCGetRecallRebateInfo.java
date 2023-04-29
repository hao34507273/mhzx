/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCGetRecallRebateInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetRecallRebateInfo(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!RecallFriendManager.canDoAction(this.roleid, 1936))
/*    */     {
/* 25 */       GameServer.logger().error(String.format("[recall]PCGetRecallRebateInfo.processImp@status|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 26 */       return false;
/*    */     }
/* 28 */     if (!RecallFriendManager.isRebateFunOpen(this.roleid, true))
/*    */     {
/* 30 */       GameServer.logger().error(String.format("[recall]PCGetRecallRebateInfo.processImp@fun not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     String userid = RoleInterface.getUserId(this.roleid);
/* 36 */     String openid = CommonUtils.getOpenId(userid);
/*    */     
/* 38 */     GetRecallRebateInfoContext context = new GetRecallRebateInfoContext();
/* 39 */     context.count = 1;
/* 40 */     context.roleid = this.roleid;
/* 41 */     OctetsStream osContext = new OctetsStream();
/* 42 */     context.marshal(osContext);
/*    */     
/* 44 */     if (!GrcManager.getRecallRebateInfo(openid, osContext))
/*    */     {
/* 46 */       GameServer.logger().error(String.format("[recall]PCGetRecallRebateInfo.processImp@send msg failed|roleid=%d|userid=%s|openid=%s", new Object[] { Long.valueOf(this.roleid), userid, openid }));
/*    */       
/*    */ 
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     GameServer.logger().info(String.format("[recall]PCGetRecallRebateInfo.processImp@send msg success|roleid=%d|userid=%s|openid=%s", new Object[] { Long.valueOf(this.roleid), userid, openid }));
/*    */     
/*    */ 
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetRecallRebateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */