/*    */ package mzm.gsp.status;
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
/*    */ public class SStatusTipRes
/*    */   extends __SStatusTipRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592388;
/*    */   public int ret;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12592388;
/*    */   }
/*    */   
/*    */ 
/*    */   public SStatusTipRes() {}
/*    */   
/*    */ 
/*    */   public SStatusTipRes(int _ret_)
/*    */   {
/* 34 */     this.ret = _ret_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 42 */     _os_.marshal(this.ret);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     this.ret = _os_.unmarshal_int();
/* 48 */     if (!_validator_()) {
/* 49 */       throw new VerifyError("validator failed");
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof SStatusTipRes)) {
/* 57 */       SStatusTipRes _o_ = (SStatusTipRes)_o1_;
/* 58 */       if (this.ret != _o_.ret) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.ret;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.ret).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SStatusTipRes _o_) {
/* 79 */     if (_o_ == this) return 0;
/* 80 */     int _c_ = 0;
/* 81 */     _c_ = this.ret - _o_.ret;
/* 82 */     if (0 != _c_) return _c_;
/* 83 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\SStatusTipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */