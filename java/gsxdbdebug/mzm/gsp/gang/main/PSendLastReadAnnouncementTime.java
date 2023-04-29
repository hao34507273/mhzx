/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CSendLastAnnouncementTime;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PSendLastReadAnnouncementTime extends GangProcedure<CSendLastAnnouncementTime>
/*    */ {
/*    */   public PSendLastReadAnnouncementTime(CSendLastAnnouncementTime protocol)
/*    */   {
/* 11 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CSendLastAnnouncementTime protocol)
/*    */   {
/* 17 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 18 */     if (xGangMember == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     xGangMember.setLastreadannouncementtimestamp(protocol.timestamp);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSendLastReadAnnouncementTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */