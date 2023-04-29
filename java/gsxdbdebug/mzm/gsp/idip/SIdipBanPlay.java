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
/*    */ public class SIdipBanPlay
/*    */   extends __SIdipBanPlay__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601094;
/*    */   public long unbantime;
/*    */   public Octets reason;
/*    */   public int playtype;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601094;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SIdipBanPlay()
/*    */   {
/* 35 */     this.reason = new Octets();
/*    */   }
/*    */   
/*    */   public SIdipBanPlay(long _unbantime_, Octets _reason_, int _playtype_) {
/* 39 */     this.unbantime = _unbantime_;
/* 40 */     this.reason = _reason_;
/* 41 */     this.playtype = _playtype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.unbantime);
/* 50 */     _os_.marshal(this.reason);
/* 51 */     _os_.marshal(this.playtype);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.unbantime = _os_.unmarshal_long();
/* 57 */     this.reason = _os_.unmarshal_Octets();
/* 58 */     this.playtype = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SIdipBanPlay)) {
/* 68 */       SIdipBanPlay _o_ = (SIdipBanPlay)_o1_;
/* 69 */       if (this.unbantime != _o_.unbantime) return false;
/* 70 */       if (!this.reason.equals(_o_.reason)) return false;
/* 71 */       if (this.playtype != _o_.playtype) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.unbantime;
/* 80 */     _h_ += this.reason.hashCode();
/* 81 */     _h_ += this.playtype;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.unbantime).append(",");
/* 89 */     _sb_.append("B").append(this.reason.size()).append(",");
/* 90 */     _sb_.append(this.playtype).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\SIdipBanPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */