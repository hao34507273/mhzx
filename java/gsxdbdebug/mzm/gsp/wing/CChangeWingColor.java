/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.wing.main2.PCChangeWingColor;
/*     */ 
/*     */ public class CChangeWingColor extends __CChangeWingColor__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596525;
/*     */   public int cfgid;
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
/*  24 */     Role.addRoleProcedure(roleId, new PCChangeWingColor(roleId, this.cfgid, this.uuid, this.num, this.curyuanbao, this.useyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12596525;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChangeWingColor() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChangeWingColor(int _cfgid_, long _uuid_, int _num_, byte _useyuanbao_, long _curyuanbao_)
/*     */   {
/*  45 */     this.cfgid = _cfgid_;
/*  46 */     this.uuid = _uuid_;
/*  47 */     this.num = _num_;
/*  48 */     this.useyuanbao = _useyuanbao_;
/*  49 */     this.curyuanbao = _curyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.cfgid);
/*  58 */     _os_.marshal(this.uuid);
/*  59 */     _os_.marshal(this.num);
/*  60 */     _os_.marshal(this.useyuanbao);
/*  61 */     _os_.marshal(this.curyuanbao);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.cfgid = _os_.unmarshal_int();
/*  67 */     this.uuid = _os_.unmarshal_long();
/*  68 */     this.num = _os_.unmarshal_int();
/*  69 */     this.useyuanbao = _os_.unmarshal_byte();
/*  70 */     this.curyuanbao = _os_.unmarshal_long();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof CChangeWingColor)) {
/*  80 */       CChangeWingColor _o_ = (CChangeWingColor)_o1_;
/*  81 */       if (this.cfgid != _o_.cfgid) return false;
/*  82 */       if (this.uuid != _o_.uuid) return false;
/*  83 */       if (this.num != _o_.num) return false;
/*  84 */       if (this.useyuanbao != _o_.useyuanbao) return false;
/*  85 */       if (this.curyuanbao != _o_.curyuanbao) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.cfgid;
/*  94 */     _h_ += (int)this.uuid;
/*  95 */     _h_ += this.num;
/*  96 */     _h_ += this.useyuanbao;
/*  97 */     _h_ += (int)this.curyuanbao;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.cfgid).append(",");
/* 105 */     _sb_.append(this.uuid).append(",");
/* 106 */     _sb_.append(this.num).append(",");
/* 107 */     _sb_.append(this.useyuanbao).append(",");
/* 108 */     _sb_.append(this.curyuanbao).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChangeWingColor _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = this.cfgid - _o_.cfgid;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.num - _o_.num;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.useyuanbao - _o_.useyuanbao;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = Long.signum(this.curyuanbao - _o_.curyuanbao);
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CChangeWingColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */