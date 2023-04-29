/*    */ package mzm.gsp.planttree;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetPlantTreeDetailInfoFail
/*    */   extends __SGetPlantTreeDetailInfoFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12611585;
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int DB_ERROR = -4;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*    */   public static final int RELATIONSHIP_ERROR = 2;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12611585;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetPlantTreeDetailInfoFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetPlantTreeDetailInfoFail(int _res_)
/*    */   {
/* 43 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.res);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.res = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SGetPlantTreeDetailInfoFail)) {
/* 66 */       SGetPlantTreeDetailInfoFail _o_ = (SGetPlantTreeDetailInfoFail)_o1_;
/* 67 */       if (this.res != _o_.res) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.res;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.res).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetPlantTreeDetailInfoFail _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.res - _o_.res;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\SGetPlantTreeDetailInfoFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */