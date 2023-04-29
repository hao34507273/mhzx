/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import gnet.link.Onlines;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCReturnOriginalServer extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCReturnOriginalServer(long roleid)
/*    */   {
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     String userid = RoleInterface.getUserId(this.roleid);
/* 22 */     Octets token = LoginManager.getRoamToken(userid);
/* 23 */     if (token == null) {
/* 24 */       Onlines.getInstance().kick(Long.valueOf(this.roleid), 2057);
/*    */     } else {
/* 26 */       GameServer.logger().info("[Online]PCReturnOriginalServer.processImp@player has token now,remove token first!!");
/*    */     }
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PCReturnOriginalServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */