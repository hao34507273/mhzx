/*    */ package mzm.gsp.zhenyao.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZhenyaoInterface
/*    */ {
/*    */   public static boolean isZhenyaoGraph(int graphid)
/*    */   {
/* 14 */     return graphid == ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID;
/*    */   }
/*    */   
/*    */   public static int getZhenYaoActivityId()
/*    */   {
/* 19 */     return ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isRoleStateCanJoinZhenyao(List<Long> roleids)
/*    */   {
/* 30 */     return RoleStatusInterface.checkCansetStatus(roleids, 146, true);
/*    */   }
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
/*    */   public static int getCanGetStorageExp(long roleid, int finishCount)
/*    */   {
/* 44 */     return (int)(ZhenyaoManager.getZhenyaoRestExp(roleid, finishCount) * ZhenyaoManager.getRate());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getZhenyaoExpByRing(long roleid, int ring)
/*    */   {
/* 56 */     return (int)(ZhenyaoManager.getZhenyaoExpByRing(roleid, ring) * ZhenyaoManager.getRate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\ZhenyaoInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */