/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.idip.SSyncNoticeContent;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PCQueryNoticeContent extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long noticeId;
/*    */   
/*    */   public PCQueryNoticeContent(long roleId, long noticeId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.noticeId = noticeId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     NoticeDataInfo notice = NoticeManager.getNotice(this.noticeId);
/* 24 */     if (notice == null)
/*    */     {
/* 26 */       GameServer.logger().error(String.format("[idip]PCQueryNoticeContent.processImp@notice not exist|roleId=%d|noticeId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.noticeId) }));
/*    */       
/*    */ 
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     SSyncNoticeContent rsp = new SSyncNoticeContent();
/* 33 */     rsp.noticeid = this.noticeId;
/* 34 */     rsp.noticecontent.setString(notice.noticeContent, "UTF-8");
/* 35 */     OnlineManager.getInstance().send(this.roleId, rsp);
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PCQueryNoticeContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */