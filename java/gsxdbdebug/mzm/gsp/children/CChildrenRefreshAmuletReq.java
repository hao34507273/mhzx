/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.main.PCChildrenRefreshAmuletReq;
/*     */ 
/*     */ public class CChildrenRefreshAmuletReq extends __CChildrenRefreshAmuletReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609416;
/*     */   public static final int USE = 1;
/*     */   public static final int UNUSE = 2;
/*     */   public int costtype;
/*     */   public int costyuanbao;
/*     */   public long yuanbaonum;
/*     */   public long childrenid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PCChildrenRefreshAmuletReq(roleid, this.costtype, this.costyuanbao, this.yuanbaonum, this.childrenid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12609416;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChildrenRefreshAmuletReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChildrenRefreshAmuletReq(int _costtype_, int _costyuanbao_, long _yuanbaonum_, long _childrenid_)
/*     */   {
/*  44 */     this.costtype = _costtype_;
/*  45 */     this.costyuanbao = _costyuanbao_;
/*  46 */     this.yuanbaonum = _yuanbaonum_;
/*  47 */     this.childrenid = _childrenid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.costtype);
/*  56 */     _os_.marshal(this.costyuanbao);
/*  57 */     _os_.marshal(this.yuanbaonum);
/*  58 */     _os_.marshal(this.childrenid);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.costtype = _os_.unmarshal_int();
/*  64 */     this.costyuanbao = _os_.unmarshal_int();
/*  65 */     this.yuanbaonum = _os_.unmarshal_long();
/*  66 */     this.childrenid = _os_.unmarshal_long();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CChildrenRefreshAmuletReq)) {
/*  76 */       CChildrenRefreshAmuletReq _o_ = (CChildrenRefreshAmuletReq)_o1_;
/*  77 */       if (this.costtype != _o_.costtype) return false;
/*  78 */       if (this.costyuanbao != _o_.costyuanbao) return false;
/*  79 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/*  80 */       if (this.childrenid != _o_.childrenid) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.costtype;
/*  89 */     _h_ += this.costyuanbao;
/*  90 */     _h_ += (int)this.yuanbaonum;
/*  91 */     _h_ += (int)this.childrenid;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.costtype).append(",");
/*  99 */     _sb_.append(this.costyuanbao).append(",");
/* 100 */     _sb_.append(this.yuanbaonum).append(",");
/* 101 */     _sb_.append(this.childrenid).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChildrenRefreshAmuletReq _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.costtype - _o_.costtype;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.costyuanbao - _o_.costyuanbao;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = Long.signum(this.yuanbaonum - _o_.yuanbaonum);
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CChildrenRefreshAmuletReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */