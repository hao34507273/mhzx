/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.crossbattle.knockout.PCGetCrossBattleFinalHistoryFightReq;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetCrossBattleTopThreeInfo
/*    */   extends __CGetCrossBattleTopThreeInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617084;
/*    */   public int session;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new PCGetCrossBattleFinalHistoryFightReq(roleId, this.session, 2));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12617084;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetCrossBattleTopThreeInfo() {}
/*    */   
/*    */ 
/*    */   public CGetCrossBattleTopThreeInfo(int _session_)
/*    */   {
/* 43 */     this.session = _session_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.session);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.session = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CGetCrossBattleTopThreeInfo)) {
/* 66 */       CGetCrossBattleTopThreeInfo _o_ = (CGetCrossBattleTopThreeInfo)_o1_;
/* 67 */       if (this.session != _o_.session) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.session;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.session).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetCrossBattleTopThreeInfo _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.session - _o_.session;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetCrossBattleTopThreeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */