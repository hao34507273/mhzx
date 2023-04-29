/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ class PChange2BangZhong extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PChange2BangZhong(long roleid)
/*    */   {
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleid));
/* 23 */     if (xGangMember == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     long gangid = xGangMember.getGangid();
/*    */     
/* 28 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangid));
/* 29 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     int oldDuty = xGangMember.getDuty();
/* 34 */     if (oldDuty == SGangConst.getInstance().BANGZHONG_ID) {
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     GangManager.changeDutyRelation(this.roleid, xGangMember, gangid, xGang, SGangConst.getInstance().BANGZHONG_ID, GangSystemChangeDutyActionLogEnum.LEVELDOWN_BANGZHONG.value, 0);
/*    */     
/* 41 */     SGangDutyCfg bangZhongCfg = GangManager.getDutyCfg(SGangConst.getInstance().BANGZHONG_ID);
/* 42 */     SGangDutyCfg oldDutyCfg = GangManager.getDutyCfg(oldDuty);
/*    */     
/* 44 */     Map<Integer, String> nameMap = GangManager.getDutyNameByLevel(xGang, new int[] { SGangConst.getInstance().BANGZHONG_ID, oldDuty });
/* 45 */     GangManager.sendMail(this.roleid, SGangConst.getInstance().CHANGE_DUTY_MAIL_ID, new mzm.gsp.tlog.TLogArg(LogReason.GANG_XUETU_CHANGETO_BANGZHONG_MAIL, SGangConst.getInstance().CHANGE_DUTY_MAIL_ID), new String[] { (String)nameMap.get(Integer.valueOf(oldDutyCfg.dutyLevel)), (String)nameMap.get(Integer.valueOf(bangZhongCfg.dutyLevel)) });
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PChange2BangZhong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */