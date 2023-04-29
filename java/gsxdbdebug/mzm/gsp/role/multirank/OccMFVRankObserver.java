/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OccMFVRankObserver
/*    */   extends Observer
/*    */ {
/*    */   public OccMFVRankObserver(long intervalSeconds)
/*    */   {
/* 21 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 27 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*    */     {
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {}
/*    */ 
/*    */ 
/* 35 */     });
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   class PRankOccMFV1 extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     private int multiFightValue;
/*    */     private final int occId;
/*    */     
/*    */     public PRankOccMFV1(long roleId, int multiFightValue, int occId)
/*    */     {
/* 47 */       this.roleId = roleId;
/* 48 */       this.multiFightValue = multiFightValue;
/* 49 */       this.occId = occId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 55 */       if (this.multiFightValue < 0)
/*    */       {
/* 57 */         GameServer.logger().error(String.format("[occMFV]PRankOccMFV.processImp@ multiFightValue is illegal!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 58 */         this.multiFightValue = MultiRankManager.getRoleMFValue(this.roleId);
/*    */       }
/* 60 */       RoleMultiFightValueChart roleFightValueChart = new RoleMultiFightValueChart(this.roleId, this.multiFightValue, this.occId);
/* 61 */       AbsOMFVRankManager rankManager = AbsOMFVRankManager.getAbsOMFVRankManagerByOccId(this.occId);
/* 62 */       if (rankManager == null)
/*    */       {
/* 64 */         GameServer.logger().error(String.format("[MFV]OccMFVRankObserver.PRankOccMFV.processImp@ no rankManager!|roleId=%d|MFV=%d|occupationId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.multiFightValue), Integer.valueOf(this.occId) }));
/*    */         
/*    */ 
/*    */ 
/* 68 */         return false;
/*    */       }
/* 70 */       rankManager.rank(roleFightValueChart);
/* 71 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\OccMFVRankObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */