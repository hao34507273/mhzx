/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PClearGiftData
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int type;
/*    */   private final int awardXId;
/*    */   
/*    */   public PClearGiftData(long roleId, int type, int awardXId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.type = type;
/* 23 */     this.awardXId = awardXId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     RoleGiftInfo roleGiftInfo = new RoleGiftInfo(this.roleId, true);
/* 30 */     if (this.type == -1)
/*    */     {
/* 32 */       return rmAll(roleGiftInfo);
/*    */     }
/* 34 */     if (this.type > 0)
/*    */     {
/* 36 */       if (this.awardXId == -1)
/*    */       {
/* 38 */         return rmTypeXData(roleGiftInfo);
/*    */       }
/* 40 */       if (this.awardXId > 0)
/*    */       {
/* 42 */         return rmAwardXData(roleGiftInfo);
/*    */       }
/*    */     }
/* 45 */     GameServer.logger().error(String.format("[gift]PClearGiftData.processImp@ param illegal!|roleId=%d|type=%d|awardXId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.awardXId) }));
/*    */     
/*    */ 
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   private boolean rmAwardXData(RoleGiftInfo roleGiftInfo)
/*    */   {
/* 53 */     int rmAwardXDataRes = roleGiftInfo.rmAwardXIdNum(this.type, this.awardXId);
/* 54 */     if (rmAwardXDataRes == 0)
/*    */     {
/* 56 */       return true;
/*    */     }
/* 58 */     GameServer.logger().error(String.format("[gift]PClearGiftData.rmAwardXData@ rm awardXData all error!|roleId=%d|type=%d|awardXId=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.awardXId), Integer.valueOf(rmAwardXDataRes) }));
/*    */     
/*    */ 
/*    */ 
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   private boolean rmTypeXData(RoleGiftInfo roleGiftInfo)
/*    */   {
/* 67 */     int rmTypeAllRes = roleGiftInfo.rmAwardXIdNum(this.type);
/* 68 */     if (rmTypeAllRes == 0)
/*    */     {
/* 70 */       return true;
/*    */     }
/* 72 */     GameServer.logger().error(String.format("[gift]PClearGiftData.rmTypeData@ rm type all error!|roleId=%d|type=%d|awardXId=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.awardXId), Integer.valueOf(rmTypeAllRes) }));
/*    */     
/*    */ 
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   private boolean rmAll(RoleGiftInfo roleGiftInfo)
/*    */   {
/* 80 */     int rmAllRes = roleGiftInfo.rmAll();
/* 81 */     if (rmAllRes == 0)
/*    */     {
/* 83 */       return true;
/*    */     }
/* 85 */     GameServer.logger().error(String.format("[gift]PClearGiftData.rmAll@ rm all error!|roleId=%d|type=%d|awardXId=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.awardXId), Integer.valueOf(rmAllRes) }));
/*    */     
/*    */ 
/* 88 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\PClearGiftData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */