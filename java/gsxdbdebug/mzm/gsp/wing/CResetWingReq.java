/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CResetWingReq extends __CResetWingReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596536;
/*     */   public int cfgid;
/*     */   public byte resettype;
/*     */   public long uuid;
/*     */   public int num;
/*     */   public byte useyuanbao;
/*     */   public long curyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new mzm.gsp.wing.main2.PCResetWingReq(roleId, this.cfgid, this.resettype, this.uuid, this.num, this.curyuanbao, this.useyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12596536;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CResetWingReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CResetWingReq(int _cfgid_, byte _resettype_, long _uuid_, int _num_, byte _useyuanbao_, long _curyuanbao_)
/*     */   {
/*  46 */     this.cfgid = _cfgid_;
/*  47 */     this.resettype = _resettype_;
/*  48 */     this.uuid = _uuid_;
/*  49 */     this.num = _num_;
/*  50 */     this.useyuanbao = _useyuanbao_;
/*  51 */     this.curyuanbao = _curyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.cfgid);
/*  60 */     _os_.marshal(this.resettype);
/*  61 */     _os_.marshal(this.uuid);
/*  62 */     _os_.marshal(this.num);
/*  63 */     _os_.marshal(this.useyuanbao);
/*  64 */     _os_.marshal(this.curyuanbao);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.cfgid = _os_.unmarshal_int();
/*  70 */     this.resettype = _os_.unmarshal_byte();
/*  71 */     this.uuid = _os_.unmarshal_long();
/*  72 */     this.num = _os_.unmarshal_int();
/*  73 */     this.useyuanbao = _os_.unmarshal_byte();
/*  74 */     this.curyuanbao = _os_.unmarshal_long();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof CResetWingReq)) {
/*  84 */       CResetWingReq _o_ = (CResetWingReq)_o1_;
/*  85 */       if (this.cfgid != _o_.cfgid) return false;
/*  86 */       if (this.resettype != _o_.resettype) return false;
/*  87 */       if (this.uuid != _o_.uuid) return false;
/*  88 */       if (this.num != _o_.num) return false;
/*  89 */       if (this.useyuanbao != _o_.useyuanbao) return false;
/*  90 */       if (this.curyuanbao != _o_.curyuanbao) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.cfgid;
/*  99 */     _h_ += this.resettype;
/* 100 */     _h_ += (int)this.uuid;
/* 101 */     _h_ += this.num;
/* 102 */     _h_ += this.useyuanbao;
/* 103 */     _h_ += (int)this.curyuanbao;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.cfgid).append(",");
/* 111 */     _sb_.append(this.resettype).append(",");
/* 112 */     _sb_.append(this.uuid).append(",");
/* 113 */     _sb_.append(this.num).append(",");
/* 114 */     _sb_.append(this.useyuanbao).append(",");
/* 115 */     _sb_.append(this.curyuanbao).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CResetWingReq _o_) {
/* 121 */     if (_o_ == this) return 0;
/* 122 */     int _c_ = 0;
/* 123 */     _c_ = this.cfgid - _o_.cfgid;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = this.resettype - _o_.resettype;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     _c_ = this.num - _o_.num;
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     _c_ = this.useyuanbao - _o_.useyuanbao;
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     _c_ = Long.signum(this.curyuanbao - _o_.curyuanbao);
/* 134 */     if (0 != _c_) return _c_;
/* 135 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CResetWingReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */