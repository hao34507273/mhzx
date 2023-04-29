/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class CHuaShengReq extends __CHuaShengReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590647;
/*     */   public static final int NO_USE_HUA_SHENG_MIMMUM_GUARANTEE = 0;
/*     */   public static final int USE_LOW_HUA_SHENG_MIMMUM_GUARANTEE = 1;
/*     */   public static final int USE_HIGH_HUA_SHENG_MIMMUM_GUARANTEE = 2;
/*     */   public long mainpetid;
/*     */   public long fupetid;
/*     */   public int costtype;
/*     */   public long yuanbaonum;
/*     */   public int minimum_guarantee_type;
/*     */   public int need_yuan_bao;
/*     */   
/*     */   protected void process() {
/*  19 */     long roleId = mzm.gsp.Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     mzm.gsp.Role.addRoleProcedure(roleId, new mzm.gsp.pet.main.PHuaShengReq(roleId, this.mainpetid, this.fupetid, this.yuanbaonum, this.costtype, this.minimum_guarantee_type, this.need_yuan_bao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590647;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CHuaShengReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CHuaShengReq(long _mainpetid_, long _fupetid_, int _costtype_, long _yuanbaonum_, int _minimum_guarantee_type_, int _need_yuan_bao_)
/*     */   {
/*  49 */     this.mainpetid = _mainpetid_;
/*  50 */     this.fupetid = _fupetid_;
/*  51 */     this.costtype = _costtype_;
/*  52 */     this.yuanbaonum = _yuanbaonum_;
/*  53 */     this.minimum_guarantee_type = _minimum_guarantee_type_;
/*  54 */     this.need_yuan_bao = _need_yuan_bao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.mainpetid);
/*  63 */     _os_.marshal(this.fupetid);
/*  64 */     _os_.marshal(this.costtype);
/*  65 */     _os_.marshal(this.yuanbaonum);
/*  66 */     _os_.marshal(this.minimum_guarantee_type);
/*  67 */     _os_.marshal(this.need_yuan_bao);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  72 */     this.mainpetid = _os_.unmarshal_long();
/*  73 */     this.fupetid = _os_.unmarshal_long();
/*  74 */     this.costtype = _os_.unmarshal_int();
/*  75 */     this.yuanbaonum = _os_.unmarshal_long();
/*  76 */     this.minimum_guarantee_type = _os_.unmarshal_int();
/*  77 */     this.need_yuan_bao = _os_.unmarshal_int();
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof CHuaShengReq)) {
/*  87 */       CHuaShengReq _o_ = (CHuaShengReq)_o1_;
/*  88 */       if (this.mainpetid != _o_.mainpetid) return false;
/*  89 */       if (this.fupetid != _o_.fupetid) return false;
/*  90 */       if (this.costtype != _o_.costtype) return false;
/*  91 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/*  92 */       if (this.minimum_guarantee_type != _o_.minimum_guarantee_type) return false;
/*  93 */       if (this.need_yuan_bao != _o_.need_yuan_bao) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += (int)this.mainpetid;
/* 102 */     _h_ += (int)this.fupetid;
/* 103 */     _h_ += this.costtype;
/* 104 */     _h_ += (int)this.yuanbaonum;
/* 105 */     _h_ += this.minimum_guarantee_type;
/* 106 */     _h_ += this.need_yuan_bao;
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.mainpetid).append(",");
/* 114 */     _sb_.append(this.fupetid).append(",");
/* 115 */     _sb_.append(this.costtype).append(",");
/* 116 */     _sb_.append(this.yuanbaonum).append(",");
/* 117 */     _sb_.append(this.minimum_guarantee_type).append(",");
/* 118 */     _sb_.append(this.need_yuan_bao).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CHuaShengReq _o_) {
/* 124 */     if (_o_ == this) return 0;
/* 125 */     int _c_ = 0;
/* 126 */     _c_ = Long.signum(this.mainpetid - _o_.mainpetid);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = Long.signum(this.fupetid - _o_.fupetid);
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     _c_ = this.costtype - _o_.costtype;
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     _c_ = Long.signum(this.yuanbaonum - _o_.yuanbaonum);
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     _c_ = this.minimum_guarantee_type - _o_.minimum_guarantee_type;
/* 135 */     if (0 != _c_) return _c_;
/* 136 */     _c_ = this.need_yuan_bao - _o_.need_yuan_bao;
/* 137 */     if (0 != _c_) return _c_;
/* 138 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CHuaShengReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */