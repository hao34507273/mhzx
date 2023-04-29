/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRankOccMFV
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private int multiFightValue;
/*    */   private final int occId;
/*    */   
/*    */   public PRankOccMFV(long roleId, int multiFightValue, int occId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.multiFightValue = multiFightValue;
/* 22 */     this.occId = occId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!RoleInterface.isOccupationOpen(this.occId))
/*    */     {
/* 30 */       GameServer.logger().error(String.format("[occMFV]PRankOccMFV.processImp@ occupation not open!|roleId=%d|occId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.occId) }));
/*    */       
/* 32 */       return false;
/*    */     }
/* 34 */     if (this.multiFightValue < 0)
/*    */     {
/* 36 */       GameServer.logger().error(String.format("[occMFV]PRankOccMFV.processImp@ multiFightValue is illegal!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 38 */       this.multiFightValue = MultiRankManager.getRoleMFValue(this.roleId);
/*    */     }
/* 40 */     RoleMultiFightValueChart roleFightValueChart = new RoleMultiFightValueChart(this.roleId, this.multiFightValue, this.occId);
/* 41 */     AbsOMFVRankManager rankManager = AbsOMFVRankManager.getAbsOMFVRankManagerByOccId(this.occId);
/* 42 */     if (rankManager == null)
/*    */     {
/* 44 */       GameServer.logger().error(String.format("[MFV]OccMFVRankObserver.PRankOccMFV.processImp@ no rankManager!|roleId=%d|MFV=%d|occupationId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.multiFightValue), Integer.valueOf(this.occId) }));
/*    */       
/*    */ 
/*    */ 
/* 48 */       return false;
/*    */     }
/* 50 */     rankManager.rank(roleFightValueChart);
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\PRankOccMFV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */