/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.partner.confbean.SPartnerGuideCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskFinishHandler;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnTaskFinish implements TaskFinishHandler
/*    */ {
/*    */   public boolean actionOnTaskFinish(long roleId, int graphId, int taskId)
/*    */   {
/* 16 */     NoneRealTimeTaskManager.getInstance().addTask(new TaskFinishPro(roleId, graphId, taskId));
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   class TaskFinishPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     private final int graphId;
/*    */     private final int taskId;
/*    */     
/*    */     public TaskFinishPro(long roleId, int graphId, int taskId)
/*    */     {
/* 29 */       this.roleId = roleId;
/* 30 */       this.graphId = graphId;
/* 31 */       this.taskId = taskId;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 38 */       String userid = RoleInterface.getUserId(this.roleId);
/* 39 */       lock(Lockeys.get(User.getTable(), userid));
/*    */       
/* 41 */       for (SPartnerGuideCfg sCfg : SPartnerGuideCfg.getAll().values())
/*    */       {
/*    */ 
/* 44 */         if ((sCfg.graphId == this.graphId) && (sCfg.taskId == this.taskId))
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 49 */           if (!PartnerManager.isInOwnPartnerList(this.roleId, sCfg.partnerId))
/*    */           {
/* 51 */             if (!PartnerManager.onActivePartnerRep(userid, this.roleId, sCfg.partnerId))
/*    */             {
/* 53 */               return false;
/*    */             }
/*    */           }
/* 56 */           int lineUpNum = PartnerManager.getDefLineUp(this.roleId, false);
/* 57 */           if (lineUpNum < 0)
/*    */           {
/* 59 */             return false;
/*    */           }
/*    */           
/* 62 */           if (!PartnerManager.onAddLineUpPartner(this.roleId, sCfg.partnerId, lineUpNum))
/*    */           {
/* 64 */             return false;
/*    */           }
/*    */         }
/*    */       }
/* 68 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\POnTaskFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */