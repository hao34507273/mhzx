/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SSyncBangGongChange;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PBangGongChanged
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   PBangGongChanged(long roleId)
/*    */   {
/* 34 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 39 */     GangMember xGangMember = Role2gangmember.select(Long.valueOf(this.roleId));
/* 40 */     if (xGangMember == null) {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/* 45 */     if (xGang == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     SSyncBangGongChange sync = new SSyncBangGongChange();
/* 49 */     sync.banggong = ((int)xGangMember.getBanggong());
/* 50 */     sync.historybanggong = ((int)xGangMember.getHistorybanggong());
/* 51 */     sync.weekbanggong = xGangMember.getWeekbanggong();
/* 52 */     sync.add_banggong_time = xGangMember.getAddbanggong_time();
/* 53 */     sync.weekitem_banggong_count = xGangMember.getWeekitem_banggong_count();
/* 54 */     sync.item_banggong_time = xGangMember.getItem_banggong_time();
/* 55 */     sync.roleid = this.roleId;
/* 56 */     OnlineManager.getInstance().sendMulti(sync, GangManager.getMembers(xGang));
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PBangGongChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */