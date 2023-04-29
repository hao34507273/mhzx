/*     */ package mzm.gsp.group;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SQuitGroupSuccessBrd
/*     */   extends __SQuitGroupSuccessBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605199;
/*     */   public long groupid;
/*     */   public long memberid;
/*     */   public long info_version;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605199;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SQuitGroupSuccessBrd() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SQuitGroupSuccessBrd(long _groupid_, long _memberid_, long _info_version_)
/*     */   {
/*  38 */     this.groupid = _groupid_;
/*  39 */     this.memberid = _memberid_;
/*  40 */     this.info_version = _info_version_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.groupid);
/*  49 */     _os_.marshal(this.memberid);
/*  50 */     _os_.marshal(this.info_version);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.groupid = _os_.unmarshal_long();
/*  56 */     this.memberid = _os_.unmarshal_long();
/*  57 */     this.info_version = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SQuitGroupSuccessBrd)) {
/*  67 */       SQuitGroupSuccessBrd _o_ = (SQuitGroupSuccessBrd)_o1_;
/*  68 */       if (this.groupid != _o_.groupid) return false;
/*  69 */       if (this.memberid != _o_.memberid) return false;
/*  70 */       if (this.info_version != _o_.info_version) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.groupid;
/*  79 */     _h_ += (int)this.memberid;
/*  80 */     _h_ += (int)this.info_version;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.groupid).append(",");
/*  88 */     _sb_.append(this.memberid).append(",");
/*  89 */     _sb_.append(this.info_version).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SQuitGroupSuccessBrd _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.groupid - _o_.groupid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.memberid - _o_.memberid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.info_version - _o_.info_version);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SQuitGroupSuccessBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */