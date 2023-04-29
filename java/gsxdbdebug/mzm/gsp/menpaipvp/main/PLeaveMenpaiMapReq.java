/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.menpaipvp.confbean.SMenpaiPVPConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MenpaiPVP;
/*    */ import xbean.MenpaiPVPScore;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PLeaveMenpaiMapReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PLeaveMenpaiMapReq(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     MenpaiPVPScore xScore = MenpaiPVPManager.getXScoreIfNotExist(this.roleid);
/*    */     
/*    */ 
/* 29 */     if (ActivityInterface.isActivityOpen(MenpaiPVPConfigManager.getInstance().getActivityID()))
/*    */     {
/*    */ 
/* 32 */       MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVP(true);
/*    */       
/* 34 */       int menpai = RoleInterface.getOccupationId(this.roleid);
/* 35 */       long roleWorld = MapInterface.getRoleWorldInstanceId(this.roleid);
/*    */       
/* 37 */       if (MenpaiPVPManager.isInMenpaiPVPWorld(this.roleid, menpai, roleWorld, xMenpaiPVP))
/*    */       {
/* 39 */         int stage = ActivityInterface.getActivityStage(SMenpaiPVPConsts.getInstance().Activityid);
/* 40 */         if (stage <= 0)
/*    */         {
/* 42 */           MenpaiPVPManager.leave(this.roleid, true);
/*    */         }
/*    */         else
/*    */         {
/* 46 */           MenpaiPVPManager.leave(this.roleid, xScore, true);
/*    */         }
/*    */         
/* 49 */         MenpaiPVPManager.logInfo("PLeaveMenpaiMapReq.processImp@active leave|roleid=%d|world=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(roleWorld) });
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 54 */         MenpaiPVPManager.logError("PLeaveMenpaiMapReq.processImp@in activity time, not in map|roleid=%d|world=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(roleWorld) });
/*    */       }
/*    */       
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 61 */       MenpaiPVPManager.logError("PLeaveMenpaiMapReq.processImp@not in activity time|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\PLeaveMenpaiMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */