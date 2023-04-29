/*    */ package mzm.gsp.christmasstocking;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*    */ public class SHangStockingSuccess
/*    */   extends __SHangStockingSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12629508;
/*    */   public long target_role_id;
/*    */   public int position;
/*    */   public HangStockingHistory new_history;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12629508;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SHangStockingSuccess()
/*    */   {
/* 35 */     this.new_history = new HangStockingHistory();
/*    */   }
/*    */   
/*    */   public SHangStockingSuccess(long _target_role_id_, int _position_, HangStockingHistory _new_history_) {
/* 39 */     this.target_role_id = _target_role_id_;
/* 40 */     this.position = _position_;
/* 41 */     this.new_history = _new_history_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.new_history._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.target_role_id);
/* 51 */     _os_.marshal(this.position);
/* 52 */     _os_.marshal(this.new_history);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.target_role_id = _os_.unmarshal_long();
/* 58 */     this.position = _os_.unmarshal_int();
/* 59 */     this.new_history.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SHangStockingSuccess)) {
/* 69 */       SHangStockingSuccess _o_ = (SHangStockingSuccess)_o1_;
/* 70 */       if (this.target_role_id != _o_.target_role_id) return false;
/* 71 */       if (this.position != _o_.position) return false;
/* 72 */       if (!this.new_history.equals(_o_.new_history)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += (int)this.target_role_id;
/* 81 */     _h_ += this.position;
/* 82 */     _h_ += this.new_history.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.target_role_id).append(",");
/* 90 */     _sb_.append(this.position).append(",");
/* 91 */     _sb_.append(this.new_history).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\SHangStockingSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */