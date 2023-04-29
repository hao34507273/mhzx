/*     */ package mzm.gsp.auction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetAuctionInfoError
/*     */   extends __SGetAuctionInfoError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627212;
/*     */   public static final int SERVER_LEVEL_LOW = 1;
/*     */   public static final int ACTIVITY_CLOSE = 2;
/*     */   public static final int NO_ITEM = 3;
/*     */   public int activityid;
/*     */   public int turnindex;
/*     */   public int errorcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12627212;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetAuctionInfoError() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetAuctionInfoError(int _activityid_, int _turnindex_, int _errorcode_)
/*     */   {
/*  40 */     this.activityid = _activityid_;
/*  41 */     this.turnindex = _turnindex_;
/*  42 */     this.errorcode = _errorcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.activityid);
/*  51 */     _os_.marshal(this.turnindex);
/*  52 */     _os_.marshal(this.errorcode);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.activityid = _os_.unmarshal_int();
/*  58 */     this.turnindex = _os_.unmarshal_int();
/*  59 */     this.errorcode = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SGetAuctionInfoError)) {
/*  69 */       SGetAuctionInfoError _o_ = (SGetAuctionInfoError)_o1_;
/*  70 */       if (this.activityid != _o_.activityid) return false;
/*  71 */       if (this.turnindex != _o_.turnindex) return false;
/*  72 */       if (this.errorcode != _o_.errorcode) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.activityid;
/*  81 */     _h_ += this.turnindex;
/*  82 */     _h_ += this.errorcode;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.activityid).append(",");
/*  90 */     _sb_.append(this.turnindex).append(",");
/*  91 */     _sb_.append(this.errorcode).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetAuctionInfoError _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.activityid - _o_.activityid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.turnindex - _o_.turnindex;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.errorcode - _o_.errorcode;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\SGetAuctionInfoError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */