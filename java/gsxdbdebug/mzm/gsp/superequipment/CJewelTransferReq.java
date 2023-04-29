/*     */ package mzm.gsp.superequipment;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.superequipment.jewel.main.PCJewelTransferReq;
/*     */ 
/*     */ 
/*     */ public class CJewelTransferReq
/*     */   extends __CJewelTransferReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618783;
/*     */   public int fromjewelbagid;
/*     */   public int fromjewelgridno;
/*     */   public int tojewelcfgid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCJewelTransferReq(roleId, this.fromjewelbagid, this.fromjewelgridno, this.tojewelcfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12618783;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CJewelTransferReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CJewelTransferReq(int _fromjewelbagid_, int _fromjewelgridno_, int _tojewelcfgid_)
/*     */   {
/*  45 */     this.fromjewelbagid = _fromjewelbagid_;
/*  46 */     this.fromjewelgridno = _fromjewelgridno_;
/*  47 */     this.tojewelcfgid = _tojewelcfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.fromjewelbagid);
/*  56 */     _os_.marshal(this.fromjewelgridno);
/*  57 */     _os_.marshal(this.tojewelcfgid);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.fromjewelbagid = _os_.unmarshal_int();
/*  63 */     this.fromjewelgridno = _os_.unmarshal_int();
/*  64 */     this.tojewelcfgid = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CJewelTransferReq)) {
/*  74 */       CJewelTransferReq _o_ = (CJewelTransferReq)_o1_;
/*  75 */       if (this.fromjewelbagid != _o_.fromjewelbagid) return false;
/*  76 */       if (this.fromjewelgridno != _o_.fromjewelgridno) return false;
/*  77 */       if (this.tojewelcfgid != _o_.tojewelcfgid) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.fromjewelbagid;
/*  86 */     _h_ += this.fromjewelgridno;
/*  87 */     _h_ += this.tojewelcfgid;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.fromjewelbagid).append(",");
/*  95 */     _sb_.append(this.fromjewelgridno).append(",");
/*  96 */     _sb_.append(this.tojewelcfgid).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CJewelTransferReq _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.fromjewelbagid - _o_.fromjewelbagid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.fromjewelgridno - _o_.fromjewelgridno;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.tojewelcfgid - _o_.tojewelcfgid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\CJewelTransferReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */