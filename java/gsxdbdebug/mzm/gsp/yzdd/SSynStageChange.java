/*    */ package mzm.gsp.yzdd;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SSynStageChange extends __SSynStageChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12637757;
/*    */   public int stage;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 14 */     return 12637757;
/*    */   }
/*    */   
/*    */   public SSynStageChange() {}
/*    */   
/*    */   public SSynStageChange(int _stage_)
/*    */   {
/* 21 */     this.stage = _stage_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.stage);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 34 */     this.stage = _os_.unmarshal_int();
/* 35 */     if (_validator_()) {
/* 36 */       return _os_;
/*    */     }
/* 38 */     throw new VerifyError("validator failed");
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) {
/* 43 */       return true;
/*    */     }
/* 45 */     return ((_o1_ instanceof SSynStageChange)) && (this.stage == ((SSynStageChange)_o1_).stage);
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     return 0 + this.stage;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 53 */     StringBuilder _sb_ = new StringBuilder();
/* 54 */     _sb_.append("(");
/* 55 */     _sb_.append(this.stage).append(",");
/* 56 */     _sb_.append(")");
/* 57 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynStageChange _o_) {
/* 61 */     if (_o_ == this) {
/* 62 */       return 0;
/*    */     }
/* 64 */     int _c_ = this.stage - _o_.stage;
/* 65 */     return 0 != _c_ ? _c_ : _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yzdd\SSynStageChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */