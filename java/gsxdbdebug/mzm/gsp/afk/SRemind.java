/*    */ package mzm.gsp.afk;
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
/*    */ public class SRemind
/*    */   extends __SRemind__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622337;
/*    */   public int afk_detect_cfg_id;
/*    */   public int confirm_timestamp;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12622337;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRemind() {}
/*    */   
/*    */ 
/*    */   public SRemind(int _afk_detect_cfg_id_, int _confirm_timestamp_)
/*    */   {
/* 37 */     this.afk_detect_cfg_id = _afk_detect_cfg_id_;
/* 38 */     this.confirm_timestamp = _confirm_timestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.afk_detect_cfg_id);
/* 47 */     _os_.marshal(this.confirm_timestamp);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.afk_detect_cfg_id = _os_.unmarshal_int();
/* 53 */     this.confirm_timestamp = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SRemind)) {
/* 63 */       SRemind _o_ = (SRemind)_o1_;
/* 64 */       if (this.afk_detect_cfg_id != _o_.afk_detect_cfg_id) return false;
/* 65 */       if (this.confirm_timestamp != _o_.confirm_timestamp) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.afk_detect_cfg_id;
/* 74 */     _h_ += this.confirm_timestamp;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.afk_detect_cfg_id).append(",");
/* 82 */     _sb_.append(this.confirm_timestamp).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRemind _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.afk_detect_cfg_id - _o_.afk_detect_cfg_id;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.confirm_timestamp - _o_.confirm_timestamp;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\afk\SRemind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */