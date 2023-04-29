/*    */ package mzm.gsp.qingyunzhi.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.Pod;
/*    */ import xbean.Progress;
/*    */ import xbean.QingData;
/*    */ import xtable.Role2qingyun;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     QingData xQingData = Role2qingyun.get((Long)this.arg);
/* 17 */     if (xQingData == null)
/*    */     {
/* 19 */       xQingData = Pod.newQingData();
/* 20 */       Role2qingyun.add((Long)this.arg, xQingData);
/*    */     }
/* 22 */     createQingData(xQingData);
/* 23 */     RoleQingManager.synQingDataToClient(((Long)this.arg).longValue(), xQingData);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void createQingData(QingData xQingData)
/*    */   {
/* 34 */     createXProgress(xQingData, 1);
/* 35 */     createXProgress(xQingData, 2);
/* 36 */     createXProgress(xQingData, 3);
/*    */   }
/*    */   
/*    */   private void createXProgress(QingData xQingData, int type)
/*    */   {
/* 41 */     Progress xProgress = (Progress)xQingData.getType2progress().get(Integer.valueOf(type));
/* 42 */     if (xProgress == null)
/*    */     {
/* 44 */       xProgress = Pod.newProgress();
/* 45 */       xQingData.getType2progress().put(Integer.valueOf(type), xProgress);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */