/*    */ package mzm.gsp.foolsday;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMakeChestFail
/*    */   extends __SMakeChestFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612874;
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int DB_ERROR = -4;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*    */   public static final int MAKE_CHEST_TIME_TO_LIMIT = 2;
/*    */   public static final int BUFF_CFG_ID_ERROR = 3;
/*    */   public static final int VIGOR_NOT_ENOUGH = 4;
/*    */   public static final int BAG_FULL = 5;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12612874;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMakeChestFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMakeChestFail(int _res_)
/*    */   {
/* 46 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.res);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.res = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SMakeChestFail)) {
/* 69 */       SMakeChestFail _o_ = (SMakeChestFail)_o1_;
/* 70 */       if (this.res != _o_.res) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.res;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.res).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMakeChestFail _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.res - _o_.res;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\SMakeChestFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */