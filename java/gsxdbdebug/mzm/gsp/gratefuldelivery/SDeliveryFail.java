/*     */ package mzm.gsp.gratefuldelivery;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SDeliveryFail
/*     */   extends __SDeliveryFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12615694;
/*     */   public static final int NO_ITEM = 1;
/*     */   public static final int ALREADY_DELIVERED = 2;
/*     */   public static final int NOT_ONLINE = 3;
/*     */   public int retcode;
/*     */   public long target_id;
/*     */   public int activity_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12615694;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SDeliveryFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SDeliveryFail(int _retcode_, long _target_id_, int _activity_id_)
/*     */   {
/*  42 */     this.retcode = _retcode_;
/*  43 */     this.target_id = _target_id_;
/*  44 */     this.activity_id = _activity_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.retcode);
/*  53 */     _os_.marshal(this.target_id);
/*  54 */     _os_.marshal(this.activity_id);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.retcode = _os_.unmarshal_int();
/*  60 */     this.target_id = _os_.unmarshal_long();
/*  61 */     this.activity_id = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SDeliveryFail)) {
/*  71 */       SDeliveryFail _o_ = (SDeliveryFail)_o1_;
/*  72 */       if (this.retcode != _o_.retcode) return false;
/*  73 */       if (this.target_id != _o_.target_id) return false;
/*  74 */       if (this.activity_id != _o_.activity_id) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.retcode;
/*  83 */     _h_ += (int)this.target_id;
/*  84 */     _h_ += this.activity_id;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.retcode).append(",");
/*  92 */     _sb_.append(this.target_id).append(",");
/*  93 */     _sb_.append(this.activity_id).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SDeliveryFail _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.retcode - _o_.retcode;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = Long.signum(this.target_id - _o_.target_id);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.activity_id - _o_.activity_id;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\SDeliveryFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */