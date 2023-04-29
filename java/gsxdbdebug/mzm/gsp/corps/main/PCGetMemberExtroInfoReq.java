/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.SSynMemberExtroInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CorpsMember;
/*    */ import xtable.Role2corps;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetMemberExtroInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long memberId;
/*    */   
/*    */   public PCGetMemberExtroInfoReq(long roleId, long memberId)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.memberId = memberId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     CorpsMember xCorpsMember_0 = Role2corps.select(Long.valueOf(this.roleId));
/* 31 */     if (xCorpsMember_0 == null)
/*    */     {
/* 33 */       GameServer.logger().error(String.format("[corps]PCGetMemberExtroInfoReq.processImp@ role not own corps!|roleId=%d|memberId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId) }));
/*    */       
/*    */ 
/* 36 */       return false;
/*    */     }
/* 38 */     CorpsMember xCorpsMember_1 = Role2corps.select(Long.valueOf(this.memberId));
/* 39 */     if (xCorpsMember_1 == null)
/*    */     {
/* 41 */       GameServer.logger().error(String.format("[corps]PCGetMemberExtroInfoReq.processImp@ member not own corps!|roleId=%d|memberId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId) }));
/*    */       
/*    */ 
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     if (xCorpsMember_0.getCorpsid() != xCorpsMember_1.getCorpsid())
/*    */     {
/* 49 */       GameServer.logger().error(String.format("[corps]PCGetMemberExtroInfoReq.processImp@ not in same corps!|roleId=%d|memberId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId) }));
/*    */       
/*    */ 
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     SSynMemberExtroInfo p = new SSynMemberExtroInfo();
/* 56 */     p.member = this.memberId;
/* 57 */     CorpsManager.fillCorpsMemberExtroInfo(this.memberId, p.extroinfo);
/* 58 */     OnlineManager.getInstance().send(this.roleId, p);
/*    */     
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCGetMemberExtroInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */