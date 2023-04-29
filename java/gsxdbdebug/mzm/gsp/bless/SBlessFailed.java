/*    */ package mzm.gsp.bless;
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
/*    */ public class SBlessFailed
/*    */   extends __SBlessFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12614657;
/*    */   public static final int ERROR_ITEM_NOT_ENOUGH = -1;
/*    */   public static final int ERROR_BAG_FULL = -2;
/*    */   public static final int ERROR_MAX_NUM = -3;
/*    */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = -4;
/*    */   public int activity_cfgid;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12614657;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBlessFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBlessFailed(int _activity_cfgid_, int _retcode_)
/*    */   {
/* 42 */     this.activity_cfgid = _activity_cfgid_;
/* 43 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activity_cfgid);
/* 52 */     _os_.marshal(this.retcode);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activity_cfgid = _os_.unmarshal_int();
/* 58 */     this.retcode = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SBlessFailed)) {
/* 68 */       SBlessFailed _o_ = (SBlessFailed)_o1_;
/* 69 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 70 */       if (this.retcode != _o_.retcode) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activity_cfgid;
/* 79 */     _h_ += this.retcode;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activity_cfgid).append(",");
/* 87 */     _sb_.append(this.retcode).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBlessFailed _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.retcode - _o_.retcode;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bless\SBlessFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */