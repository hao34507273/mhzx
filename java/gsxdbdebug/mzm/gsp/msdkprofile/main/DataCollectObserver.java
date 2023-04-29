/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ 
/*    */ class DataCollectObserver extends Observer
/*    */ {
/*    */   private static final int INTERVAL = 600;
/*    */   
/*    */   public DataCollectObserver()
/*    */   {
/* 18 */     super(600L);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 24 */     Executor.getInstance().execute(new RDataCollect(null));
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   private class RDataCollect extends LogicRunnable
/*    */   {
/*    */     private RDataCollect() {}
/*    */     
/*    */     public void process() throws Exception
/*    */     {
/* 34 */       List<Long> roles = OnlineManager.getInstance().getAllRolesInWorld();
/* 35 */       for (Long roleId : roles)
/*    */       {
/* 37 */         new DataCollectObserver.PCollectGangMemberAbility(DataCollectObserver.this, roleId.longValue()).execute();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private class PCollectGangMemberAbility
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     
/*    */     public PCollectGangMemberAbility(long roleid)
/*    */     {
/* 50 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 56 */       long gangId = GangInterface.getGangId(this.roleid);
/* 57 */       if (gangId == 0L)
/*    */       {
/* 59 */         return false;
/*    */       }
/* 61 */       String userid = RoleInterface.getUserId(this.roleid);
/*    */       
/* 63 */       int multiFightValue = RoleInterface.getRoleMFValue(this.roleid);
/* 64 */       return MSDKProfileManager.reportGangMemberAbility(userid, this.roleid, gangId, multiFightValue);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\DataCollectObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */