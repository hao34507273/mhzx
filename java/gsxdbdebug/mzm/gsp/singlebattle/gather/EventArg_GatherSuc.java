/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ 
/*    */ public class EventArg_GatherSuc
/*    */ {
/*    */   private final long roleId;
/*    */   private final int totalSource;
/*    */   private final int totalPoint;
/*    */   private final long instanceId;
/*    */   private final int gatherItemCfgId;
/*    */   private final int addSource;
/*    */   private final int addPoint;
/*    */   
/*    */   public EventArg_GatherSuc(long roleId, int totalSource, int totalPoint, long instanceId, int gatherItemCfgId, int addSource, int addPoint)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.totalSource = totalSource;
/* 18 */     this.totalPoint = totalPoint;
/* 19 */     this.instanceId = instanceId;
/* 20 */     this.gatherItemCfgId = gatherItemCfgId;
/* 21 */     this.addSource = addSource;
/* 22 */     this.addPoint = addPoint;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 27 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getTotalSource()
/*    */   {
/* 32 */     return this.totalSource;
/*    */   }
/*    */   
/*    */   public int getTotalPoint()
/*    */   {
/* 37 */     return this.totalPoint;
/*    */   }
/*    */   
/*    */   public long getInstanceId()
/*    */   {
/* 42 */     return this.instanceId;
/*    */   }
/*    */   
/*    */   public int getGatherItemCfgId()
/*    */   {
/* 47 */     return this.gatherItemCfgId;
/*    */   }
/*    */   
/*    */   public int getAddSource()
/*    */   {
/* 52 */     return this.addSource;
/*    */   }
/*    */   
/*    */   public int getAddPoint()
/*    */   {
/* 57 */     return this.addPoint;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\EventArg_GatherSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */