/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PCPetSoulRandomPropReq;
/*     */ 
/*     */ public class CPetSoulRandomPropReq
/*     */   extends __CPetSoulRandomPropReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590667;
/*     */   public long petid;
/*     */   public int pos;
/*     */   public int isuseyuanbao;
/*     */   public int useyuanbaonum;
/*     */   public long totalyuanbaonum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCPetSoulRandomPropReq(roleId, this.petid, this.pos, this.isuseyuanbao, this.useyuanbaonum, this.totalyuanbaonum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12590667;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CPetSoulRandomPropReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CPetSoulRandomPropReq(long _petid_, int _pos_, int _isuseyuanbao_, int _useyuanbaonum_, long _totalyuanbaonum_)
/*     */   {
/*  46 */     this.petid = _petid_;
/*  47 */     this.pos = _pos_;
/*  48 */     this.isuseyuanbao = _isuseyuanbao_;
/*  49 */     this.useyuanbaonum = _useyuanbaonum_;
/*  50 */     this.totalyuanbaonum = _totalyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.petid);
/*  59 */     _os_.marshal(this.pos);
/*  60 */     _os_.marshal(this.isuseyuanbao);
/*  61 */     _os_.marshal(this.useyuanbaonum);
/*  62 */     _os_.marshal(this.totalyuanbaonum);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.petid = _os_.unmarshal_long();
/*  68 */     this.pos = _os_.unmarshal_int();
/*  69 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  70 */     this.useyuanbaonum = _os_.unmarshal_int();
/*  71 */     this.totalyuanbaonum = _os_.unmarshal_long();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof CPetSoulRandomPropReq)) {
/*  81 */       CPetSoulRandomPropReq _o_ = (CPetSoulRandomPropReq)_o1_;
/*  82 */       if (this.petid != _o_.petid) return false;
/*  83 */       if (this.pos != _o_.pos) return false;
/*  84 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  85 */       if (this.useyuanbaonum != _o_.useyuanbaonum) return false;
/*  86 */       if (this.totalyuanbaonum != _o_.totalyuanbaonum) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += (int)this.petid;
/*  95 */     _h_ += this.pos;
/*  96 */     _h_ += this.isuseyuanbao;
/*  97 */     _h_ += this.useyuanbaonum;
/*  98 */     _h_ += (int)this.totalyuanbaonum;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.petid).append(",");
/* 106 */     _sb_.append(this.pos).append(",");
/* 107 */     _sb_.append(this.isuseyuanbao).append(",");
/* 108 */     _sb_.append(this.useyuanbaonum).append(",");
/* 109 */     _sb_.append(this.totalyuanbaonum).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPetSoulRandomPropReq _o_) {
/* 115 */     if (_o_ == this) return 0;
/* 116 */     int _c_ = 0;
/* 117 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.pos - _o_.pos;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.useyuanbaonum - _o_.useyuanbaonum;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = Long.signum(this.totalyuanbaonum - _o_.totalyuanbaonum);
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CPetSoulRandomPropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */