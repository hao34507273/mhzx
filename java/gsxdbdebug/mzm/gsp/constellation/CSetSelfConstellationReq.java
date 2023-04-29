/*     */ package mzm.gsp.constellation;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.constellation.main.PSetSelfConstellationReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CSetSelfConstellationReq
/*     */   extends __CSetSelfConstellationReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612101;
/*     */   public int constellation;
/*     */   public int set_times;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleid, new PSetSelfConstellationReq(roleid, this.constellation, this.set_times));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12612101;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CSetSelfConstellationReq() {}
/*     */   
/*     */ 
/*     */   public CSetSelfConstellationReq(int _constellation_, int _set_times_)
/*     */   {
/*  43 */     this.constellation = _constellation_;
/*  44 */     this.set_times = _set_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.constellation);
/*  53 */     _os_.marshal(this.set_times);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.constellation = _os_.unmarshal_int();
/*  59 */     this.set_times = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CSetSelfConstellationReq)) {
/*  69 */       CSetSelfConstellationReq _o_ = (CSetSelfConstellationReq)_o1_;
/*  70 */       if (this.constellation != _o_.constellation) return false;
/*  71 */       if (this.set_times != _o_.set_times) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.constellation;
/*  80 */     _h_ += this.set_times;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.constellation).append(",");
/*  88 */     _sb_.append(this.set_times).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSetSelfConstellationReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.constellation - _o_.constellation;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.set_times - _o_.set_times;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\CSetSelfConstellationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */