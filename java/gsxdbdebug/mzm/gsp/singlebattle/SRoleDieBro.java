/*     */ package mzm.gsp.singlebattle;
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
/*     */ public class SRoleDieBro
/*     */   extends __SRoleDieBro__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621576;
/*     */   public long dieroleid;
/*     */   public long killerid;
/*     */   public int revivetime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12621576;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SRoleDieBro() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SRoleDieBro(long _dieroleid_, long _killerid_, int _revivetime_)
/*     */   {
/*  38 */     this.dieroleid = _dieroleid_;
/*  39 */     this.killerid = _killerid_;
/*  40 */     this.revivetime = _revivetime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.dieroleid);
/*  49 */     _os_.marshal(this.killerid);
/*  50 */     _os_.marshal(this.revivetime);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.dieroleid = _os_.unmarshal_long();
/*  56 */     this.killerid = _os_.unmarshal_long();
/*  57 */     this.revivetime = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SRoleDieBro)) {
/*  67 */       SRoleDieBro _o_ = (SRoleDieBro)_o1_;
/*  68 */       if (this.dieroleid != _o_.dieroleid) return false;
/*  69 */       if (this.killerid != _o_.killerid) return false;
/*  70 */       if (this.revivetime != _o_.revivetime) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.dieroleid;
/*  79 */     _h_ += (int)this.killerid;
/*  80 */     _h_ += this.revivetime;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.dieroleid).append(",");
/*  88 */     _sb_.append(this.killerid).append(",");
/*  89 */     _sb_.append(this.revivetime).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SRoleDieBro _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.dieroleid - _o_.dieroleid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.killerid - _o_.killerid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.revivetime - _o_.revivetime;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SRoleDieBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */