/*    */ package mzm.gsp.item;
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
/*    */ public class SSynMoshouExchangeCountRes
/*    */   extends __SSynMoshouExchangeCountRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584846;
/*    */   public int exchangecount;
/*    */   public int canexchangemoshou;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584846;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynMoshouExchangeCountRes() {}
/*    */   
/*    */ 
/*    */   public SSynMoshouExchangeCountRes(int _exchangecount_, int _canexchangemoshou_)
/*    */   {
/* 35 */     this.exchangecount = _exchangecount_;
/* 36 */     this.canexchangemoshou = _canexchangemoshou_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.exchangecount);
/* 45 */     _os_.marshal(this.canexchangemoshou);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.exchangecount = _os_.unmarshal_int();
/* 51 */     this.canexchangemoshou = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SSynMoshouExchangeCountRes)) {
/* 61 */       SSynMoshouExchangeCountRes _o_ = (SSynMoshouExchangeCountRes)_o1_;
/* 62 */       if (this.exchangecount != _o_.exchangecount) return false;
/* 63 */       if (this.canexchangemoshou != _o_.canexchangemoshou) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.exchangecount;
/* 72 */     _h_ += this.canexchangemoshou;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.exchangecount).append(",");
/* 80 */     _sb_.append(this.canexchangemoshou).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynMoshouExchangeCountRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.exchangecount - _o_.exchangecount;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.canexchangemoshou - _o_.canexchangemoshou;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SSynMoshouExchangeCountRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */