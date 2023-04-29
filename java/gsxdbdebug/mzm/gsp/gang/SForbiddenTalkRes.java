/*    */ package mzm.gsp.gang;
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
/*    */ public class SForbiddenTalkRes
/*    */   extends __SForbiddenTalkRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589859;
/*    */   public int costvigor;
/*    */   public int lefttime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589859;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SForbiddenTalkRes() {}
/*    */   
/*    */ 
/*    */   public SForbiddenTalkRes(int _costvigor_, int _lefttime_)
/*    */   {
/* 37 */     this.costvigor = _costvigor_;
/* 38 */     this.lefttime = _lefttime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.costvigor);
/* 47 */     _os_.marshal(this.lefttime);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.costvigor = _os_.unmarshal_int();
/* 53 */     this.lefttime = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SForbiddenTalkRes)) {
/* 63 */       SForbiddenTalkRes _o_ = (SForbiddenTalkRes)_o1_;
/* 64 */       if (this.costvigor != _o_.costvigor) return false;
/* 65 */       if (this.lefttime != _o_.lefttime) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.costvigor;
/* 74 */     _h_ += this.lefttime;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.costvigor).append(",");
/* 82 */     _sb_.append(this.lefttime).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SForbiddenTalkRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.costvigor - _o_.costvigor;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.lefttime - _o_.lefttime;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SForbiddenTalkRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */