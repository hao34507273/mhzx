/*    */ package mzm.gsp.qiuqian;
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
/*    */ public class SStartQiuQian
/*    */   extends __SStartQiuQian__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12610817;
/*    */   public int qiuqian_id;
/*    */   public long sessionid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12610817;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SStartQiuQian() {}
/*    */   
/*    */ 
/*    */   public SStartQiuQian(int _qiuqian_id_, long _sessionid_)
/*    */   {
/* 37 */     this.qiuqian_id = _qiuqian_id_;
/* 38 */     this.sessionid = _sessionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.qiuqian_id);
/* 47 */     _os_.marshal(this.sessionid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.qiuqian_id = _os_.unmarshal_int();
/* 53 */     this.sessionid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SStartQiuQian)) {
/* 63 */       SStartQiuQian _o_ = (SStartQiuQian)_o1_;
/* 64 */       if (this.qiuqian_id != _o_.qiuqian_id) return false;
/* 65 */       if (this.sessionid != _o_.sessionid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.qiuqian_id;
/* 74 */     _h_ += (int)this.sessionid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.qiuqian_id).append(",");
/* 82 */     _sb_.append(this.sessionid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SStartQiuQian _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.qiuqian_id - _o_.qiuqian_id;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\SStartQiuQian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */