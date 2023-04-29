/*    */ package mzm.gsp.alllotto;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AllLottoLog
/*    */   implements Marshal
/*    */ {
/*    */   public int turn;
/*    */   public RoleInfo role_info;
/*    */   
/*    */   public AllLottoLog()
/*    */   {
/* 15 */     this.role_info = new RoleInfo();
/*    */   }
/*    */   
/*    */   public AllLottoLog(int _turn_, RoleInfo _role_info_) {
/* 19 */     this.turn = _turn_;
/* 20 */     this.role_info = _role_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     if (!this.role_info._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.turn);
/* 30 */     _os_.marshal(this.role_info);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.turn = _os_.unmarshal_int();
/* 36 */     this.role_info.unmarshal(_os_);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof AllLottoLog)) {
/* 43 */       AllLottoLog _o_ = (AllLottoLog)_o1_;
/* 44 */       if (this.turn != _o_.turn) return false;
/* 45 */       if (!this.role_info.equals(_o_.role_info)) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.turn;
/* 54 */     _h_ += this.role_info.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.turn).append(",");
/* 62 */     _sb_.append(this.role_info).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\AllLottoLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */