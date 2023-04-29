/*    */ package mzm.gsp.qingfu;
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
/*    */ public class SGetMonthCardActivityAwardFailed
/*    */   extends __SGetMonthCardActivityAwardFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588818;
/*    */   public static final int ERROR_NOT_PURCHASE = -1;
/*    */   public static final int ERROR_REMAIN_DAYS = -2;
/*    */   public static final int ERROR_ALREADY_GET_AWARD = -3;
/*    */   public int activity_id;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588818;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetMonthCardActivityAwardFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetMonthCardActivityAwardFailed(int _activity_id_, int _retcode_)
/*    */   {
/* 41 */     this.activity_id = _activity_id_;
/* 42 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activity_id);
/* 51 */     _os_.marshal(this.retcode);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activity_id = _os_.unmarshal_int();
/* 57 */     this.retcode = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SGetMonthCardActivityAwardFailed)) {
/* 67 */       SGetMonthCardActivityAwardFailed _o_ = (SGetMonthCardActivityAwardFailed)_o1_;
/* 68 */       if (this.activity_id != _o_.activity_id) return false;
/* 69 */       if (this.retcode != _o_.retcode) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.activity_id;
/* 78 */     _h_ += this.retcode;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.activity_id).append(",");
/* 86 */     _sb_.append(this.retcode).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetMonthCardActivityAwardFailed _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.activity_id - _o_.activity_id;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.retcode - _o_.retcode;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGetMonthCardActivityAwardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */