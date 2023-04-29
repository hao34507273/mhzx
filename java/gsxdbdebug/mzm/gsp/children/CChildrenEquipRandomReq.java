/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CChildrenEquipRandomReq extends __CChildrenEquipRandomReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609427;
/*     */   public static final int USE = 1;
/*     */   public static final int UNUSE = 2;
/*     */   public long childrenid;
/*     */   public int pos;
/*     */   public int useyuanbao;
/*     */   public int useyuanbaonum;
/*     */   public long totalyuanbaonum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new mzm.gsp.children.main.PCChildrenEquipRandomReq(roleid, this.childrenid, this.pos, this.useyuanbao, this.useyuanbaonum, this.totalyuanbaonum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12609427;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChildrenEquipRandomReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChildrenEquipRandomReq(long _childrenid_, int _pos_, int _useyuanbao_, int _useyuanbaonum_, long _totalyuanbaonum_)
/*     */   {
/*  45 */     this.childrenid = _childrenid_;
/*  46 */     this.pos = _pos_;
/*  47 */     this.useyuanbao = _useyuanbao_;
/*  48 */     this.useyuanbaonum = _useyuanbaonum_;
/*  49 */     this.totalyuanbaonum = _totalyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.childrenid);
/*  58 */     _os_.marshal(this.pos);
/*  59 */     _os_.marshal(this.useyuanbao);
/*  60 */     _os_.marshal(this.useyuanbaonum);
/*  61 */     _os_.marshal(this.totalyuanbaonum);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.childrenid = _os_.unmarshal_long();
/*  67 */     this.pos = _os_.unmarshal_int();
/*  68 */     this.useyuanbao = _os_.unmarshal_int();
/*  69 */     this.useyuanbaonum = _os_.unmarshal_int();
/*  70 */     this.totalyuanbaonum = _os_.unmarshal_long();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof CChildrenEquipRandomReq)) {
/*  80 */       CChildrenEquipRandomReq _o_ = (CChildrenEquipRandomReq)_o1_;
/*  81 */       if (this.childrenid != _o_.childrenid) return false;
/*  82 */       if (this.pos != _o_.pos) return false;
/*  83 */       if (this.useyuanbao != _o_.useyuanbao) return false;
/*  84 */       if (this.useyuanbaonum != _o_.useyuanbaonum) return false;
/*  85 */       if (this.totalyuanbaonum != _o_.totalyuanbaonum) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += (int)this.childrenid;
/*  94 */     _h_ += this.pos;
/*  95 */     _h_ += this.useyuanbao;
/*  96 */     _h_ += this.useyuanbaonum;
/*  97 */     _h_ += (int)this.totalyuanbaonum;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.childrenid).append(",");
/* 105 */     _sb_.append(this.pos).append(",");
/* 106 */     _sb_.append(this.useyuanbao).append(",");
/* 107 */     _sb_.append(this.useyuanbaonum).append(",");
/* 108 */     _sb_.append(this.totalyuanbaonum).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChildrenEquipRandomReq _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.pos - _o_.pos;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.useyuanbao - _o_.useyuanbao;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.useyuanbaonum - _o_.useyuanbaonum;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = Long.signum(this.totalyuanbaonum - _o_.totalyuanbaonum);
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CChildrenEquipRandomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */