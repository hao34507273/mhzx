/*    */ package mzm.gsp.xiaohuikuaipao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SOuterDrawError
/*    */   extends __SOuterDrawError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622861;
/*    */   public static final int YUAN_BAO_NOT_ENOUGH = 1;
/*    */   public static final int ITEM_NOT_ENOUGH = 2;
/*    */   public static final int BAG_CAPACITY_NOT_ENOUGH = 3;
/*    */   public static final int LAST_AWARD_NOT_RECEIVED = 4;
/*    */   public int errorcode;
/*    */   public int activityid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12622861;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SOuterDrawError() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SOuterDrawError(int _errorcode_, int _activityid_)
/*    */   {
/* 40 */     this.errorcode = _errorcode_;
/* 41 */     this.activityid = _activityid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.errorcode);
/* 50 */     _os_.marshal(this.activityid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.errorcode = _os_.unmarshal_int();
/* 56 */     this.activityid = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SOuterDrawError)) {
/* 66 */       SOuterDrawError _o_ = (SOuterDrawError)_o1_;
/* 67 */       if (this.errorcode != _o_.errorcode) return false;
/* 68 */       if (this.activityid != _o_.activityid) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.errorcode;
/* 77 */     _h_ += this.activityid;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.errorcode).append(",");
/* 85 */     _sb_.append(this.activityid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SOuterDrawError _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.errorcode - _o_.errorcode;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.activityid - _o_.activityid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\SOuterDrawError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */