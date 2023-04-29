/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.chat.SChatNormalResult;
/*    */ import mzm.gsp.fabaolingqi.FabaoArtifactInfo;
/*    */ import mzm.gsp.fabaolingqi.SGetArtifactInfoRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.FabaoArtifactRecord;
/*    */ import xbean.FabaoArtifactRecords;
/*    */ 
/*    */ public class PGetArtifactInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long targetRoleId;
/*    */   private final int artifactClassId;
/*    */   
/*    */   public PGetArtifactInfo(long roleId, long targetRoleId, int artifactClassId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.targetRoleId = targetRoleId;
/* 23 */     this.artifactClassId = artifactClassId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!FabaoArtifactManager.isEnable()) {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 35 */       if (!OnlineManager.getInstance().isOnline(this.targetRoleId))
/*    */       {
/* 37 */         notifyArtifactNotFound();
/* 38 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 43 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(this.targetRoleId, false);
/* 44 */     if (xRecords == null)
/*    */     {
/* 46 */       notifyArtifactNotFound();
/* 47 */       return false;
/*    */     }
/* 49 */     FabaoArtifactRecord xRecord = (FabaoArtifactRecord)xRecords.getRecords().get(Integer.valueOf(this.artifactClassId));
/* 50 */     if (xRecord == null)
/*    */     {
/* 52 */       notifyArtifactNotFound();
/* 53 */       return false;
/*    */     }
/* 55 */     response(xRecord);
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   private void response(FabaoArtifactRecord xRecord)
/*    */   {
/* 61 */     FabaoArtifactInfo artifactInfo = new FabaoArtifactInfo();
/* 62 */     artifactInfo.level = xRecord.getLevel();
/* 63 */     artifactInfo.properties.putAll(xRecord.getProperties());
/* 64 */     SGetArtifactInfoRes res = new SGetArtifactInfoRes();
/* 65 */     res.role_id = this.targetRoleId;
/* 66 */     res.class_id = this.artifactClassId;
/* 67 */     res.info = artifactInfo;
/* 68 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */   }
/*    */   
/*    */   private void notifyArtifactNotFound()
/*    */   {
/* 73 */     SChatNormalResult r = new SChatNormalResult();
/* 74 */     r.result = 10;
/* 75 */     OnlineManager.getInstance().sendAtOnce(this.roleId, r);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\PGetArtifactInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */