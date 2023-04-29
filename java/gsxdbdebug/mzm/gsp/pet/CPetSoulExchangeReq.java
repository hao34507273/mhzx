/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PCPetSoulExchangeReq;
/*     */ 
/*     */ public class CPetSoulExchangeReq extends __CPetSoulExchangeReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590671;
/*     */   public long petid1;
/*     */   public long petid2;
/*     */   public int isuseyuanbao;
/*     */   public int useyuanbaonum;
/*     */   public long totalyuanbaonum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCPetSoulExchangeReq(roleId, this.petid1, this.petid2, this.isuseyuanbao, this.useyuanbaonum, this.totalyuanbaonum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590671;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CPetSoulExchangeReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CPetSoulExchangeReq(long _petid1_, long _petid2_, int _isuseyuanbao_, int _useyuanbaonum_, long _totalyuanbaonum_)
/*     */   {
/*  44 */     this.petid1 = _petid1_;
/*  45 */     this.petid2 = _petid2_;
/*  46 */     this.isuseyuanbao = _isuseyuanbao_;
/*  47 */     this.useyuanbaonum = _useyuanbaonum_;
/*  48 */     this.totalyuanbaonum = _totalyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.petid1);
/*  57 */     _os_.marshal(this.petid2);
/*  58 */     _os_.marshal(this.isuseyuanbao);
/*  59 */     _os_.marshal(this.useyuanbaonum);
/*  60 */     _os_.marshal(this.totalyuanbaonum);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.petid1 = _os_.unmarshal_long();
/*  66 */     this.petid2 = _os_.unmarshal_long();
/*  67 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  68 */     this.useyuanbaonum = _os_.unmarshal_int();
/*  69 */     this.totalyuanbaonum = _os_.unmarshal_long();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CPetSoulExchangeReq)) {
/*  79 */       CPetSoulExchangeReq _o_ = (CPetSoulExchangeReq)_o1_;
/*  80 */       if (this.petid1 != _o_.petid1) return false;
/*  81 */       if (this.petid2 != _o_.petid2) return false;
/*  82 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  83 */       if (this.useyuanbaonum != _o_.useyuanbaonum) return false;
/*  84 */       if (this.totalyuanbaonum != _o_.totalyuanbaonum) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += (int)this.petid1;
/*  93 */     _h_ += (int)this.petid2;
/*  94 */     _h_ += this.isuseyuanbao;
/*  95 */     _h_ += this.useyuanbaonum;
/*  96 */     _h_ += (int)this.totalyuanbaonum;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.petid1).append(",");
/* 104 */     _sb_.append(this.petid2).append(",");
/* 105 */     _sb_.append(this.isuseyuanbao).append(",");
/* 106 */     _sb_.append(this.useyuanbaonum).append(",");
/* 107 */     _sb_.append(this.totalyuanbaonum).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPetSoulExchangeReq _o_) {
/* 113 */     if (_o_ == this) return 0;
/* 114 */     int _c_ = 0;
/* 115 */     _c_ = Long.signum(this.petid1 - _o_.petid1);
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = Long.signum(this.petid2 - _o_.petid2);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.useyuanbaonum - _o_.useyuanbaonum;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = Long.signum(this.totalyuanbaonum - _o_.totalyuanbaonum);
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CPetSoulExchangeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */