/*    */ package mzm.gsp.singlebattle;
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
/*    */ public class SGrapPositionFail
/*    */   extends __SGrapPositionFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621587;
/*    */   public static final int FAIL_FIGHT = 1;
/*    */   public static final int FAIL_MOVE = 2;
/*    */   public static final int FAIL_BATTLE_END = 3;
/*    */   public int positionid;
/*    */   public int reason;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621587;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGrapPositionFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGrapPositionFail(int _positionid_, int _reason_)
/*    */   {
/* 41 */     this.positionid = _positionid_;
/* 42 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.positionid);
/* 51 */     _os_.marshal(this.reason);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.positionid = _os_.unmarshal_int();
/* 57 */     this.reason = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SGrapPositionFail)) {
/* 67 */       SGrapPositionFail _o_ = (SGrapPositionFail)_o1_;
/* 68 */       if (this.positionid != _o_.positionid) return false;
/* 69 */       if (this.reason != _o_.reason) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.positionid;
/* 78 */     _h_ += this.reason;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.positionid).append(",");
/* 86 */     _sb_.append(this.reason).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGrapPositionFail _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.positionid - _o_.positionid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.reason - _o_.reason;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SGrapPositionFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */