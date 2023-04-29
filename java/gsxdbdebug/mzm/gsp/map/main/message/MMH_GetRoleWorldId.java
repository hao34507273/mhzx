/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ public class MMH_GetRoleWorldId
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/* 10 */   private long worldInstanceId = -1L;
/*    */   
/*    */   public MMH_GetRoleWorldId(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public long getWorldInstanceId()
/*    */   {
/* 19 */     return this.worldInstanceId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 25 */     WorldInstance worldInstance = WorldManager.getInstance().getRoleWorldInstanceFromStack(this.roleid);
/* 26 */     if (worldInstance == null)
/*    */     {
/* 28 */       return;
/*    */     }
/* 30 */     this.worldInstanceId = worldInstance.getId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetRoleWorldId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */