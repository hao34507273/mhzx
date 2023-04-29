/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingyuan.SQingYuanRelationPromotion;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.Role2QingYuanInfo;
/*    */ import xtable.Role2qingyuan;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QingYuanInterface
/*    */ {
/*    */   public static void clearQingYuanRelation(long roleIdA, long roleIdB)
/*    */   {
/* 23 */     Role2QingYuanInfo xRoleIdAQingYuanInfo = Role2qingyuan.get(Long.valueOf(roleIdA));
/* 24 */     if (xRoleIdAQingYuanInfo == null)
/*    */     {
/* 26 */       return;
/*    */     }
/* 28 */     List<Long> xRoleIdAQingYuanList = xRoleIdAQingYuanInfo.getQing_yuan_role_list();
/* 29 */     if (!xRoleIdAQingYuanList.contains(Long.valueOf(roleIdB)))
/*    */     {
/* 31 */       return;
/*    */     }
/* 33 */     Role2QingYuanInfo xRoleIdBQingYuanInfo = Role2qingyuan.get(Long.valueOf(roleIdB));
/* 34 */     if (xRoleIdBQingYuanInfo == null)
/*    */     {
/* 36 */       return;
/*    */     }
/* 38 */     List<Long> xRoleIdBQingYuanList = xRoleIdBQingYuanInfo.getQing_yuan_role_list();
/* 39 */     if (!xRoleIdBQingYuanList.contains(Long.valueOf(roleIdA)))
/*    */     {
/* 41 */       return;
/*    */     }
/*    */     
/* 44 */     QingYuanManager.clearQingYuanRelation(roleIdA, roleIdB, xRoleIdAQingYuanList, xRoleIdBQingYuanList, xRoleIdAQingYuanInfo, xRoleIdBQingYuanInfo);
/*    */     
/*    */ 
/* 47 */     SQingYuanRelationPromotion sQingYuanRelationPromotion = new SQingYuanRelationPromotion();
/* 48 */     sQingYuanRelationPromotion.role_id_a = roleIdA;
/* 49 */     sQingYuanRelationPromotion.role_id_b = roleIdB;
/*    */     
/* 51 */     OnlineManager.getInstance().sendMulti(sQingYuanRelationPromotion, Arrays.asList(new Long[] { Long.valueOf(roleIdA), Long.valueOf(roleIdB) }));
/*    */     
/* 53 */     String userIdA = RoleInterface.getUserId(roleIdA);
/* 54 */     String userIdB = RoleInterface.getUserId(roleIdB);
/*    */     
/* 56 */     QingYuanManager.tlogQingYuanRelation(roleIdA, roleIdB, userIdA, userIdB, QingYuanRelationTLogEnum.QING_YUAN_PROMOTION);
/* 57 */     QingYuanManager.tlogQingYuanRelation(roleIdB, roleIdA, userIdB, userIdA, QingYuanRelationTLogEnum.QING_YUAN_PROMOTION);
/*    */   }
/*    */   
/*    */   public static boolean isExistQingYuanRelation(long roleIdA, long roleIdB)
/*    */   {
/* 62 */     Role2QingYuanInfo xRoleIdA2QingYuanInfo = Role2qingyuan.get(Long.valueOf(roleIdA));
/* 63 */     if (xRoleIdA2QingYuanInfo == null)
/*    */     {
/* 65 */       return false;
/*    */     }
/*    */     
/* 68 */     Role2QingYuanInfo xRoleIdB2QingYuanInfo = Role2qingyuan.get(Long.valueOf(roleIdB));
/* 69 */     if (xRoleIdB2QingYuanInfo == null)
/*    */     {
/* 71 */       return false;
/*    */     }
/*    */     
/* 74 */     if ((xRoleIdA2QingYuanInfo.getQing_yuan_role_list().contains(Long.valueOf(roleIdB))) && (xRoleIdB2QingYuanInfo.getQing_yuan_role_list().contains(Long.valueOf(roleIdA))))
/*    */     {
/*    */ 
/* 77 */       return true;
/*    */     }
/*    */     
/* 80 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\QingYuanInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */