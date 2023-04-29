/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MassWeddingRedgift;
/*    */ 
/*    */ public class PCClientTakeRedGift extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCClientTakeRedGift(long roleid)
/*    */   {
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(this.roleid, 164)))
/*    */     {
/* 22 */       OpenInterface.sendBanPlayMsg(this.roleid, this.roleid, RoleInterface.getName(this.roleid), 164);
/*    */       
/* 24 */       return false;
/*    */     }
/* 26 */     String userid = RoleInterface.getUserId(this.roleid);
/* 27 */     lock(xtable.User.getTable(), java.util.Arrays.asList(new String[] { userid }));
/* 28 */     MassWeddingRedgift xMassWeddingRedgift = xtable.Role2massweddingredgift.get(Long.valueOf(this.roleid));
/* 29 */     if (xMassWeddingRedgift == null) {
/* 30 */       GameServer.logger().info("[MassWedding]PCClientTakeRedGift.processImp@xMassWeddingRedgift is null");
/* 31 */       return false;
/*    */     }
/* 33 */     return MassWeddingManager.checkAndAwardRedGift(this.roleid, userid, xMassWeddingRedgift.getRedgiftcfgid(), xMassWeddingRedgift);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCClientTakeRedGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */