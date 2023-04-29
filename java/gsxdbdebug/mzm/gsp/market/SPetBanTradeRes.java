/*    */ package mzm.gsp.market;
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
/*    */ public class SPetBanTradeRes
/*    */   extends __SPetBanTradeRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601456;
/*    */   public int petcfgid;
/*    */   public int state;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601456;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SPetBanTradeRes() {}
/*    */   
/*    */ 
/*    */   public SPetBanTradeRes(int _petcfgid_, int _state_)
/*    */   {
/* 35 */     this.petcfgid = _petcfgid_;
/* 36 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.petcfgid);
/* 45 */     _os_.marshal(this.state);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.petcfgid = _os_.unmarshal_int();
/* 51 */     this.state = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SPetBanTradeRes)) {
/* 61 */       SPetBanTradeRes _o_ = (SPetBanTradeRes)_o1_;
/* 62 */       if (this.petcfgid != _o_.petcfgid) return false;
/* 63 */       if (this.state != _o_.state) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.petcfgid;
/* 72 */     _h_ += this.state;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.petcfgid).append(",");
/* 80 */     _sb_.append(this.state).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPetBanTradeRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.state - _o_.state;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SPetBanTradeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */