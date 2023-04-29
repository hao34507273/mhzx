/*    */ package mzm.gsp.group;
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
/*    */ 
/*    */ public class SSetMessageStateSuccess
/*    */   extends __SSetMessageStateSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605198;
/*    */   public long groupid;
/*    */   public byte message_state;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605198;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSetMessageStateSuccess() {}
/*    */   
/*    */ 
/*    */   public SSetMessageStateSuccess(long _groupid_, byte _message_state_)
/*    */   {
/* 37 */     this.groupid = _groupid_;
/* 38 */     this.message_state = _message_state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.groupid);
/* 47 */     _os_.marshal(this.message_state);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.groupid = _os_.unmarshal_long();
/* 53 */     this.message_state = _os_.unmarshal_byte();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSetMessageStateSuccess)) {
/* 63 */       SSetMessageStateSuccess _o_ = (SSetMessageStateSuccess)_o1_;
/* 64 */       if (this.groupid != _o_.groupid) return false;
/* 65 */       if (this.message_state != _o_.message_state) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.groupid;
/* 74 */     _h_ += this.message_state;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.groupid).append(",");
/* 82 */     _sb_.append(this.message_state).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSetMessageStateSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.groupid - _o_.groupid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.message_state - _o_.message_state;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SSetMessageStateSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */