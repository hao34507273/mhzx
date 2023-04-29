/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.CPublicAnnouncementReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SPublicAnnouncementRes;
/*    */ import mzm.gsp.gang.SSyncAnnouncement;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.GangAnnouncement;
/*    */ import xbean.GangMember;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PPublishAnnouncementReq extends GangProcedure<CPublicAnnouncementReq>
/*    */ {
/*    */   public PPublishAnnouncementReq(CPublicAnnouncementReq protocol)
/*    */   {
/* 25 */     super(protocol);
/*    */   }
/*    */   
/*    */   protected boolean doProcess(long roleId, CPublicAnnouncementReq protocol)
/*    */   {
/* 30 */     if (Math.ceil(CommonUtils.getUTF16Length(protocol.announcement) / 2.0D) > SGangConst.getInstance().ANNOUNCEMENT_MAX_LENGTH) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 35 */     if (xGangMember == null) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 40 */     if (xGang == null) {
/* 41 */       return false;
/*    */     }
/* 43 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 44 */       return false;
/*    */     }
/* 46 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/* 47 */     if (!dutyCfg.isCanPublishAnnouncement) {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     if (xGang.getPublishtime() >= SGangConst.getInstance().ANNOUMCEMENT_LIMIT_PER_DAY) {
/* 52 */       SGangNormalResult sGangNormalResult = new SGangNormalResult();
/* 53 */       sGangNormalResult.result = 29;
/* 54 */       OnlineManager.getInstance().sendAtOnce(roleId, sGangNormalResult);
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     TLogArg logArg = new TLogArg(LogReason.GANG_PUB_ANNOUNCE_REM);
/*    */     
/* 60 */     if (!RoleInterface.cutVigor(roleId, SGangConst.getInstance().PUBLISH_ANNOUNCEMENT_COST_VIGOR, logArg)) {
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     GangAnnouncement xGangAnnouncement = Pod.newGangAnnouncement();
/* 65 */     xGangAnnouncement.setAnnouncement(protocol.announcement);
/* 66 */     xGangAnnouncement.setModifierid(roleId);
/* 67 */     xGangAnnouncement.setModifytime(DateTimeUtils.getCurrTimeInMillis());
/* 68 */     List<GangAnnouncement> xList = xGang.getAnnouncementhistorylist();
/* 69 */     if (xList.size() > SGangConst.getInstance().ANNOUNCEMENT_NUM_LIMIT) {
/* 70 */       xList.remove(0);
/*    */     }
/* 72 */     xList.add(xGangAnnouncement);
/* 73 */     xGang.setPublishtime(xGang.getPublishtime() + 1);
/* 74 */     SSyncAnnouncement sSyncAnnouncement = new SSyncAnnouncement();
/* 75 */     GangManager.fillGangAnnouncement(xGangAnnouncement, sSyncAnnouncement.announcement);
/* 76 */     GangManager.broadcast(xGang, sSyncAnnouncement);
/*    */     
/* 78 */     SPublicAnnouncementRes res = new SPublicAnnouncementRes();
/* 79 */     res.costvigor = SGangConst.getInstance().PUBLISH_ANNOUNCEMENT_COST_VIGOR;
/* 80 */     OnlineManager.getInstance().send(roleId, res);
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PPublishAnnouncementReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */