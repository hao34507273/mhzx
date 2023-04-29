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
/*     */ public class SBeginGrapPositionBro
/*     */   extends __SBeginGrapPositionBro__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621582;
/*     */   public int positionid;
/*     */   public long roleid;
/*     */   public int endtime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12621582;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SBeginGrapPositionBro() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SBeginGrapPositionBro(int _positionid_, long _roleid_, int _endtime_)
/*     */   {
/*  38 */     this.positionid = _positionid_;
/*  39 */     this.roleid = _roleid_;
/*  40 */     this.endtime = _endtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.positionid);
/*  49 */     _os_.marshal(this.roleid);
/*  50 */     _os_.marshal(this.endtime);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.positionid = _os_.unmarshal_int();
/*  56 */     this.roleid = _os_.unmarshal_long();
/*  57 */     this.endtime = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SBeginGrapPositionBro)) {
/*  67 */       SBeginGrapPositionBro _o_ = (SBeginGrapPositionBro)_o1_;
/*  68 */       if (this.positionid != _o_.positionid) return false;
/*  69 */       if (this.roleid != _o_.roleid) return false;
/*  70 */       if (this.endtime != _o_.endtime) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.positionid;
/*  79 */     _h_ += (int)this.roleid;
/*  80 */     _h_ += this.endtime;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.positionid).append(",");
/*  88 */     _sb_.append(this.roleid).append(",");
/*  89 */     _sb_.append(this.endtime).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBeginGrapPositionBro _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.positionid - _o_.positionid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.endtime - _o_.endtime;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SBeginGrapPositionBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */