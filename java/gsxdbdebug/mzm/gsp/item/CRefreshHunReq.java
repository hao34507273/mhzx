/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CRefreshHunReq extends __CRefreshHunReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584818;
/*     */   public int bagid;
/*     */   public long uuid;
/*     */   public int isuseyuanbao;
/*     */   public long clientyuanbaonum;
/*     */   public int clientneedyuanbaonum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     long roleid = Role.getRoleId(this);
/*  18 */     Role.addRoleProcedure(roleid, new mzm.gsp.item.main.PRefreshHunReq(roleid, this.bagid, this.uuid, this.isuseyuanbao, this.clientyuanbaonum, this.clientneedyuanbaonum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  26 */     return 12584818;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CRefreshHunReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CRefreshHunReq(int _bagid_, long _uuid_, int _isuseyuanbao_, long _clientyuanbaonum_, int _clientneedyuanbaonum_)
/*     */   {
/*  39 */     this.bagid = _bagid_;
/*  40 */     this.uuid = _uuid_;
/*  41 */     this.isuseyuanbao = _isuseyuanbao_;
/*  42 */     this.clientyuanbaonum = _clientyuanbaonum_;
/*  43 */     this.clientneedyuanbaonum = _clientneedyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.bagid);
/*  52 */     _os_.marshal(this.uuid);
/*  53 */     _os_.marshal(this.isuseyuanbao);
/*  54 */     _os_.marshal(this.clientyuanbaonum);
/*  55 */     _os_.marshal(this.clientneedyuanbaonum);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  60 */     this.bagid = _os_.unmarshal_int();
/*  61 */     this.uuid = _os_.unmarshal_long();
/*  62 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  63 */     this.clientyuanbaonum = _os_.unmarshal_long();
/*  64 */     this.clientneedyuanbaonum = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CRefreshHunReq)) {
/*  74 */       CRefreshHunReq _o_ = (CRefreshHunReq)_o1_;
/*  75 */       if (this.bagid != _o_.bagid) return false;
/*  76 */       if (this.uuid != _o_.uuid) return false;
/*  77 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  78 */       if (this.clientyuanbaonum != _o_.clientyuanbaonum) return false;
/*  79 */       if (this.clientneedyuanbaonum != _o_.clientneedyuanbaonum) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.bagid;
/*  88 */     _h_ += (int)this.uuid;
/*  89 */     _h_ += this.isuseyuanbao;
/*  90 */     _h_ += (int)this.clientyuanbaonum;
/*  91 */     _h_ += this.clientneedyuanbaonum;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.bagid).append(",");
/*  99 */     _sb_.append(this.uuid).append(",");
/* 100 */     _sb_.append(this.isuseyuanbao).append(",");
/* 101 */     _sb_.append(this.clientyuanbaonum).append(",");
/* 102 */     _sb_.append(this.clientneedyuanbaonum).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CRefreshHunReq _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = this.bagid - _o_.bagid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = Long.signum(this.clientyuanbaonum - _o_.clientyuanbaonum);
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.clientneedyuanbaonum - _o_.clientneedyuanbaonum;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CRefreshHunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */