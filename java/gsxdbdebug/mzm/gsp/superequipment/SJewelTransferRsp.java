/*     */ package mzm.gsp.superequipment;
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
/*     */ public class SJewelTransferRsp
/*     */   extends __SJewelTransferRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618786;
/*     */   public int fromjewelbagid;
/*     */   public int fromjewelgridno;
/*     */   public int tojewelcfgid;
/*     */   public int availabletransfercount;
/*     */   public int moneycount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12618786;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SJewelTransferRsp() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SJewelTransferRsp(int _fromjewelbagid_, int _fromjewelgridno_, int _tojewelcfgid_, int _availabletransfercount_, int _moneycount_)
/*     */   {
/*  40 */     this.fromjewelbagid = _fromjewelbagid_;
/*  41 */     this.fromjewelgridno = _fromjewelgridno_;
/*  42 */     this.tojewelcfgid = _tojewelcfgid_;
/*  43 */     this.availabletransfercount = _availabletransfercount_;
/*  44 */     this.moneycount = _moneycount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.fromjewelbagid);
/*  53 */     _os_.marshal(this.fromjewelgridno);
/*  54 */     _os_.marshal(this.tojewelcfgid);
/*  55 */     _os_.marshal(this.availabletransfercount);
/*  56 */     _os_.marshal(this.moneycount);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.fromjewelbagid = _os_.unmarshal_int();
/*  62 */     this.fromjewelgridno = _os_.unmarshal_int();
/*  63 */     this.tojewelcfgid = _os_.unmarshal_int();
/*  64 */     this.availabletransfercount = _os_.unmarshal_int();
/*  65 */     this.moneycount = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SJewelTransferRsp)) {
/*  75 */       SJewelTransferRsp _o_ = (SJewelTransferRsp)_o1_;
/*  76 */       if (this.fromjewelbagid != _o_.fromjewelbagid) return false;
/*  77 */       if (this.fromjewelgridno != _o_.fromjewelgridno) return false;
/*  78 */       if (this.tojewelcfgid != _o_.tojewelcfgid) return false;
/*  79 */       if (this.availabletransfercount != _o_.availabletransfercount) return false;
/*  80 */       if (this.moneycount != _o_.moneycount) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.fromjewelbagid;
/*  89 */     _h_ += this.fromjewelgridno;
/*  90 */     _h_ += this.tojewelcfgid;
/*  91 */     _h_ += this.availabletransfercount;
/*  92 */     _h_ += this.moneycount;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.fromjewelbagid).append(",");
/* 100 */     _sb_.append(this.fromjewelgridno).append(",");
/* 101 */     _sb_.append(this.tojewelcfgid).append(",");
/* 102 */     _sb_.append(this.availabletransfercount).append(",");
/* 103 */     _sb_.append(this.moneycount).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SJewelTransferRsp _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.fromjewelbagid - _o_.fromjewelbagid;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.fromjewelgridno - _o_.fromjewelgridno;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.tojewelcfgid - _o_.tojewelcfgid;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.availabletransfercount - _o_.availabletransfercount;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.moneycount - _o_.moneycount;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\SJewelTransferRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */