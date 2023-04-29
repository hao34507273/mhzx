/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import gnet.link.Onlines;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.SRoleInCrossServerRes;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LocalCrossToken;
/*    */ import xtable.User2localcrossstoken;
/*    */ 
/*    */ public class PGM_SetCrossServer extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int zoneid;
/*    */   
/*    */   public PGM_SetCrossServer(long gmRoleid, long roleid, int zoneid, ArrayList<String> token)
/*    */   {
/* 20 */     this.gmRoleid = gmRoleid;
/* 21 */     this.roleid = roleid;
/* 22 */     this.zoneid = zoneid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 29 */     LocalCrossToken xLocalCrossToken = User2localcrossstoken.get(userid);
/* 30 */     if (xLocalCrossToken == null) {
/* 31 */       xLocalCrossToken = xbean.Pod.newLocalCrossToken();
/* 32 */       User2localcrossstoken.insert(userid, xLocalCrossToken);
/*    */     }
/* 34 */     xLocalCrossToken.setZoneid(this.zoneid);
/* 35 */     xLocalCrossToken.setRoleid(this.roleid);
/* 36 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("set crossServer status success|zoneid=%d", new Object[] { Integer.valueOf(this.zoneid) }));
/*    */     
/* 38 */     SRoleInCrossServerRes roleInCrossServerRes = new SRoleInCrossServerRes();
/* 39 */     LoginManager.getInstance().fillRoleInCrossMsg(new SRoleInCrossServerRes(), xLocalCrossToken);
/* 40 */     OnlineManager.getInstance().send(this.roleid, roleInCrossServerRes);
/* 41 */     Onlines.getInstance().kick(Long.valueOf(this.roleid), 2056);
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_SetCrossServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */