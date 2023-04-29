/*    */ package mzm.gsp.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
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
/*    */ public class SIdipAddZeroProfit
/*    */   extends __SIdipAddZeroProfit__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601091;
/*    */   public long unbantime;
/*    */   public Octets reason;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601091;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SIdipAddZeroProfit()
/*    */   {
/* 34 */     this.reason = new Octets();
/*    */   }
/*    */   
/*    */   public SIdipAddZeroProfit(long _unbantime_, Octets _reason_) {
/* 38 */     this.unbantime = _unbantime_;
/* 39 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.unbantime);
/* 48 */     _os_.marshal(this.reason);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.unbantime = _os_.unmarshal_long();
/* 54 */     this.reason = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SIdipAddZeroProfit)) {
/* 64 */       SIdipAddZeroProfit _o_ = (SIdipAddZeroProfit)_o1_;
/* 65 */       if (this.unbantime != _o_.unbantime) return false;
/* 66 */       if (!this.reason.equals(_o_.reason)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.unbantime;
/* 75 */     _h_ += this.reason.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.unbantime).append(",");
/* 83 */     _sb_.append("B").append(this.reason.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\SIdipAddZeroProfit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */