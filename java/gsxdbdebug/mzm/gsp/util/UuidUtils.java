/*    */ package mzm.gsp.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Uuid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UuidUtils
/*    */ {
/*    */   public static enum UuidType
/*    */   {
/* 22 */     Pet(0), 
/* 23 */     Item(1), 
/* 24 */     BaiTanShopItem(2), 
/* 25 */     TLOG_SEQUENCE(3), 
/* 26 */     MOUNTS(4), 
/* 27 */     HOME_MAID(5), 
/* 28 */     CHATGIFT(6);
/*    */     
/*    */     private final int idType;
/*    */     
/*    */     private UuidType(int idType)
/*    */     {
/* 34 */       this.idType = idType;
/*    */     }
/*    */     
/*    */     private int getIdType() {
/* 38 */       return this.idType;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static long generateUuid(UuidType type)
/*    */   {
/* 50 */     long uuid = Uuid.nextKey().longValue();
/* 51 */     if (GameServer.logger().isDebugEnabled()) {
/* 52 */       GameServer.logger().debug("Generate Uuid (type=" + type.getIdType() + ") : " + uuid);
/*    */     }
/* 54 */     return uuid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static List<Long> generateUuids(UuidType type, int number)
/*    */   {
/* 66 */     List<Long> uuids = new ArrayList();
/* 67 */     for (int i = 0; i < number; i++) {
/* 68 */       long uuid = generateUuid(type);
/* 69 */       uuids.add(Long.valueOf(uuid));
/*    */     }
/* 71 */     return uuids;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\UuidUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */