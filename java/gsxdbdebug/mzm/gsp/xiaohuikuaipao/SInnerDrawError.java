/*    */ package mzm.gsp.xiaohuikuaipao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SInnerDrawError
/*    */   extends __SInnerDrawError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622849;
/*    */   public static final int TICKET_NOT_ENOUGH = 1;
/*    */   public static final int BAG_CAPACITY_NOT_ENOUGH = 2;
/*    */   public static final int LAST_AWARD_NOT_RECEIVED = 3;
/*    */   public int activityid;
/*    */   public int errorcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12622849;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SInnerDrawError() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SInnerDrawError(int _activityid_, int _errorcode_)
/*    */   {
/* 39 */     this.activityid = _activityid_;
/* 40 */     this.errorcode = _errorcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activityid);
/* 49 */     _os_.marshal(this.errorcode);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.activityid = _os_.unmarshal_int();
/* 55 */     this.errorcode = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SInnerDrawError)) {
/* 65 */       SInnerDrawError _o_ = (SInnerDrawError)_o1_;
/* 66 */       if (this.activityid != _o_.activityid) return false;
/* 67 */       if (this.errorcode != _o_.errorcode) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activityid;
/* 76 */     _h_ += this.errorcode;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.activityid).append(",");
/* 84 */     _sb_.append(this.errorcode).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SInnerDrawError _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.activityid - _o_.activityid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.errorcode - _o_.errorcode;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\SInnerDrawError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */