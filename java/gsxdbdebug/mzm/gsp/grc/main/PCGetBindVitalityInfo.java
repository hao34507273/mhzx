/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCGetBindVitalityInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetBindVitalityInfo(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!RecallFriendManager.canDoAction(this.roleid, 1934))
/*    */     {
/* 25 */       GameServer.logger().error(String.format("[recall]PCGetBindVitalityInfo.processImp@status|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     if (!RecallFriendManager.isBindFriendFunOpen(this.roleid, true))
/*    */     {
/* 31 */       GameServer.logger().error(String.format("[recall]PCGetBindVitalityInfo.processImp@fun not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 38 */     String userid = RoleInterface.getUserId(this.roleid);
/* 39 */     String openid = CommonUtils.getOpenId(userid);
/* 40 */     GetBindVitalityInfoContext context = new GetBindVitalityInfoContext();
/* 41 */     context.count = 1;
/* 42 */     context.roleid = this.roleid;
/* 43 */     OctetsStream osContext = new OctetsStream();
/* 44 */     context.marshal(osContext);
/* 45 */     if (!GrcManager.getBindVitalityInfo(openid, osContext))
/*    */     {
/* 47 */       GameServer.logger().error(String.format("[recall]PCGetBindVitalityInfo.processImp@send msg failed|roleid=%d|userid=%s|openid=%s", new Object[] { Long.valueOf(this.roleid), userid, openid }));
/*    */       
/*    */ 
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     GameServer.logger().info(String.format("[recall]PCGetBindVitalityInfo.processImp@send msg success|roleid=%d|userid=%s|openid=%s", new Object[] { Long.valueOf(this.roleid), userid, openid }));
/*    */     
/*    */ 
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetBindVitalityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */