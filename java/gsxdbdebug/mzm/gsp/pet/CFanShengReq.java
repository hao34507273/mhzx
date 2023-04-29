/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CFanShengReq extends __CFanShengReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590619;
/*     */   public static final int GAOJI_FANSHENG = 0;
/*     */   public static final int PUTONG_FANSHENG = 1;
/*     */   public long petid;
/*     */   public int fanshengtype;
/*     */   public int costtype;
/*     */   public long yuanbaonum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new mzm.gsp.pet.main.PFanShengReq(roleId, this.petid, this.yuanbaonum, this.fanshengtype, this.costtype));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590619;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CFanShengReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CFanShengReq(long _petid_, int _fanshengtype_, int _costtype_, long _yuanbaonum_)
/*     */   {
/*  46 */     this.petid = _petid_;
/*  47 */     this.fanshengtype = _fanshengtype_;
/*  48 */     this.costtype = _costtype_;
/*  49 */     this.yuanbaonum = _yuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.petid);
/*  58 */     _os_.marshal(this.fanshengtype);
/*  59 */     _os_.marshal(this.costtype);
/*  60 */     _os_.marshal(this.yuanbaonum);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.petid = _os_.unmarshal_long();
/*  66 */     this.fanshengtype = _os_.unmarshal_int();
/*  67 */     this.costtype = _os_.unmarshal_int();
/*  68 */     this.yuanbaonum = _os_.unmarshal_long();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CFanShengReq)) {
/*  78 */       CFanShengReq _o_ = (CFanShengReq)_o1_;
/*  79 */       if (this.petid != _o_.petid) return false;
/*  80 */       if (this.fanshengtype != _o_.fanshengtype) return false;
/*  81 */       if (this.costtype != _o_.costtype) return false;
/*  82 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.petid;
/*  91 */     _h_ += this.fanshengtype;
/*  92 */     _h_ += this.costtype;
/*  93 */     _h_ += (int)this.yuanbaonum;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.petid).append(",");
/* 101 */     _sb_.append(this.fanshengtype).append(",");
/* 102 */     _sb_.append(this.costtype).append(",");
/* 103 */     _sb_.append(this.yuanbaonum).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CFanShengReq _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.fanshengtype - _o_.fanshengtype;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.costtype - _o_.costtype;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = Long.signum(this.yuanbaonum - _o_.yuanbaonum);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CFanShengReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */