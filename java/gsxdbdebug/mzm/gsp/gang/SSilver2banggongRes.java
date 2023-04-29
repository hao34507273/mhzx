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
/*    */ public class SSilver2banggongRes
/*    */   extends __SSilver2banggongRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589911;
/*    */   public int level;
/*    */   public int silver2banggonghistory;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589911;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSilver2banggongRes() {}
/*    */   
/*    */ 
/*    */   public SSilver2banggongRes(int _level_, int _silver2banggonghistory_)
/*    */   {
/* 37 */     this.level = _level_;
/* 38 */     this.silver2banggonghistory = _silver2banggonghistory_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.level);
/* 47 */     _os_.marshal(this.silver2banggonghistory);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.level = _os_.unmarshal_int();
/* 53 */     this.silver2banggonghistory = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSilver2banggongRes)) {
/* 63 */       SSilver2banggongRes _o_ = (SSilver2banggongRes)_o1_;
/* 64 */       if (this.level != _o_.level) return false;
/* 65 */       if (this.silver2banggonghistory != _o_.silver2banggonghistory) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.level;
/* 74 */     _h_ += this.silver2banggonghistory;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.level).append(",");
/* 82 */     _sb_.append(this.silver2banggonghistory).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSilver2banggongRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.level - _o_.level;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.silver2banggonghistory - _o_.silver2banggonghistory;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSilver2banggongRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */