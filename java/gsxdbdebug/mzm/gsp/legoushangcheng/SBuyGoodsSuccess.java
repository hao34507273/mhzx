/*    */ package mzm.gsp.legoushangcheng;
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
/*    */ public class SBuyGoodsSuccess
/*    */   extends __SBuyGoodsSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621316;
/*    */   public int cfgid;
/*    */   public int buycount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621316;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SBuyGoodsSuccess() {}
/*    */   
/*    */ 
/*    */   public SBuyGoodsSuccess(int _cfgid_, int _buycount_)
/*    */   {
/* 37 */     this.cfgid = _cfgid_;
/* 38 */     this.buycount = _buycount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.cfgid);
/* 47 */     _os_.marshal(this.buycount);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.cfgid = _os_.unmarshal_int();
/* 53 */     this.buycount = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SBuyGoodsSuccess)) {
/* 63 */       SBuyGoodsSuccess _o_ = (SBuyGoodsSuccess)_o1_;
/* 64 */       if (this.cfgid != _o_.cfgid) return false;
/* 65 */       if (this.buycount != _o_.buycount) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.cfgid;
/* 74 */     _h_ += this.buycount;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.cfgid).append(",");
/* 82 */     _sb_.append(this.buycount).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBuyGoodsSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.cfgid - _o_.cfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.buycount - _o_.buycount;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\legoushangcheng\SBuyGoodsSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */