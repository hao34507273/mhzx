/*    */ package mzm.gsp.activity;
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
/*    */ public class STakeCareActivityRes
/*    */   extends __STakeCareActivityRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587565;
/*    */   public static final int SUCCESS = 0;
/*    */   public static final int FAIL = 1;
/*    */   public int result;
/*    */   public int activitycfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587565;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public STakeCareActivityRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public STakeCareActivityRes(int _result_, int _activitycfgid_)
/*    */   {
/* 40 */     this.result = _result_;
/* 41 */     this.activitycfgid = _activitycfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.result);
/* 50 */     _os_.marshal(this.activitycfgid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.result = _os_.unmarshal_int();
/* 56 */     this.activitycfgid = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof STakeCareActivityRes)) {
/* 66 */       STakeCareActivityRes _o_ = (STakeCareActivityRes)_o1_;
/* 67 */       if (this.result != _o_.result) return false;
/* 68 */       if (this.activitycfgid != _o_.activitycfgid) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.result;
/* 77 */     _h_ += this.activitycfgid;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.result).append(",");
/* 85 */     _sb_.append(this.activitycfgid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(STakeCareActivityRes _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.result - _o_.result;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.activitycfgid - _o_.activitycfgid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\STakeCareActivityRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */