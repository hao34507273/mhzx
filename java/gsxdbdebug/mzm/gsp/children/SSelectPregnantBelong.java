/*    */ package mzm.gsp.children;
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
/*    */ public class SSelectPregnantBelong
/*    */   extends __SSelectPregnantBelong__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609327;
/*    */   public long belong_role_id;
/*    */   public long session_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609327;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSelectPregnantBelong() {}
/*    */   
/*    */ 
/*    */   public SSelectPregnantBelong(long _belong_role_id_, long _session_id_)
/*    */   {
/* 37 */     this.belong_role_id = _belong_role_id_;
/* 38 */     this.session_id = _session_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.belong_role_id);
/* 47 */     _os_.marshal(this.session_id);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.belong_role_id = _os_.unmarshal_long();
/* 53 */     this.session_id = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSelectPregnantBelong)) {
/* 63 */       SSelectPregnantBelong _o_ = (SSelectPregnantBelong)_o1_;
/* 64 */       if (this.belong_role_id != _o_.belong_role_id) return false;
/* 65 */       if (this.session_id != _o_.session_id) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.belong_role_id;
/* 74 */     _h_ += (int)this.session_id;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.belong_role_id).append(",");
/* 82 */     _sb_.append(this.session_id).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSelectPregnantBelong _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.belong_role_id - _o_.belong_role_id);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.session_id - _o_.session_id);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SSelectPregnantBelong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */