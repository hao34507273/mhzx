/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.qmhw.confbean.SQMHWRoleNpcCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QMHWInterface
/*    */ {
/*    */   public static void setScoreForIDIP(long roleid, int score)
/*    */   {
/* 17 */     QMHWChart.getInstance().setScore(roleid, score);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getScore(long roleid)
/*    */   {
/* 26 */     return QMHWManager.getScore(roleid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static List<Integer> getQMHWRoleNpcList()
/*    */   {
/* 35 */     List<Integer> npcIds = new ArrayList();
/* 36 */     for (SQMHWRoleNpcCfg qmhwRoleNpcCfg : SQMHWRoleNpcCfg.getAll().values()) {
/* 37 */       npcIds.add(Integer.valueOf(qmhwRoleNpcCfg.npcid));
/*    */     }
/* 39 */     return npcIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\QMHWInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */