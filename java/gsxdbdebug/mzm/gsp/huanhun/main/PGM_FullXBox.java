/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*    */ import mzm.gsp.huanhun.SAddXItemInfoRep;
/*    */ import mzm.gsp.huanhun.event.FinishHuanHun;
/*    */ import mzm.gsp.huanhun.event.FinishHuanHunArg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import xbean.HanhunInfo;
/*    */ import xbean.ItemInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2huanhun;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_FullXBox extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int index;
/*    */   
/*    */   public PGM_FullXBox(long roleId, int index)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.index = index;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     String userid = RoleInterface.getUserId(this.roleId);
/* 34 */     lock(Lockeys.get(User.getTable(), userid));
/* 35 */     HanhunInfo xHunInfo = Role2huanhun.get(Long.valueOf(this.roleId));
/* 36 */     if (xHunInfo == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     ItemInfo xInfo = (ItemInfo)xHunInfo.getIteminfos().get(Integer.valueOf(this.index));
/*    */     
/* 43 */     if (xInfo.getTaskstate())
/*    */     {
/*    */ 
/* 46 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 50 */     xInfo.setTaskstate(true);
/*    */     
/* 52 */     SAddXItemInfoRep sAddXItemInfoRep = new SAddXItemInfoRep();
/* 53 */     sAddXItemInfoRep.itemindex = this.index;
/* 54 */     sAddXItemInfoRep.roleidseekhelp = this.roleId;
/*    */     
/*    */ 
/*    */ 
/* 58 */     sAddXItemInfoRep.iteminfo.itemcfgid = xInfo.getItemcfgid();
/* 59 */     sAddXItemInfoRep.iteminfo.itemnum = xInfo.getItemnum();
/* 60 */     sAddXItemInfoRep.iteminfo.taskstate = 1;
/*    */     
/*    */ 
/* 63 */     sAddXItemInfoRep.iteminfo.ganghelpstate = 0;
/* 64 */     sAddXItemInfoRep.iteminfo.friendhelpstate = 0;
/* 65 */     OnlineManager.getInstance().send(this.roleId, sAddXItemInfoRep);
/*    */     
/*    */ 
/*    */ 
/* 69 */     if (HuanhunManager.isAllBoxFull(xHunInfo))
/*    */     {
/* 71 */       xHunInfo.setStatus(2);
/* 72 */       HuanhunManager.synHunStatus(this.roleId, xHunInfo.getStatus());
/*    */       
/* 74 */       int graphId = HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID;
/* 75 */       int taskId = TaskInterface.findTaskInGraph(this.roleId, graphId);
/* 76 */       TaskInterface.changeTaskFinish(this.roleId, graphId, taskId);
/*    */       
/*    */ 
/* 79 */       FinishHuanHunArg arg = new FinishHuanHunArg();
/* 80 */       arg.setRoleId(this.roleId);
/* 81 */       TriggerEventsManger.getInstance().triggerEvent(new FinishHuanHun(), arg);
/*    */     }
/*    */     
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PGM_FullXBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */