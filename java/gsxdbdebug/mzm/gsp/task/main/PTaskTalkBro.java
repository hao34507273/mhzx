/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.task.STaskTalk;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PTaskTalkBro
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int tasktid;
/*    */   private int graphid;
/*    */   private int talktype;
/*    */   private int talkindex;
/*    */   
/*    */   public PTaskTalkBro(long roleId, int tasktid, int graphid, int talktype, int talkindex)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.tasktid = tasktid;
/* 22 */     this.graphid = graphid;
/* 23 */     this.talktype = talktype;
/* 24 */     this.talkindex = talkindex;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     List<Long> normalMemberList = TeamInterface.getNormalRoleList(this.roleId);
/* 32 */     if (normalMemberList.size() == 0)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     normalMemberList.remove(Long.valueOf(this.roleId));
/* 37 */     if (normalMemberList.size() == 0)
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     STaskTalk sTaskTalk = new STaskTalk();
/* 42 */     sTaskTalk.taskid = this.tasktid;
/* 43 */     sTaskTalk.graphid = this.graphid;
/* 44 */     sTaskTalk.talktype = this.talktype;
/* 45 */     sTaskTalk.talkindex = this.talkindex;
/*    */     
/* 47 */     OnlineManager.getInstance().sendMulti(sTaskTalk, normalMemberList);
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PTaskTalkBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */