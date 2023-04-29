/*     */ package mzm.gsp.xiaohuikuaipao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.xiaohuikuaipao.main.PCOuterDrawReq;
/*     */ 
/*     */ public class COuterDrawReq extends __COuterDrawReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622862;
/*     */   public int activityid;
/*     */   public int count;
/*     */   public byte isuseyuanbao;
/*     */   public long clientyuanbao;
/*     */   public long needyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCOuterDrawReq(roleId, this.activityid, this.count, this.isuseyuanbao, this.clientyuanbao, this.needyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12622862;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public COuterDrawReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public COuterDrawReq(int _activityid_, int _count_, byte _isuseyuanbao_, long _clientyuanbao_, long _needyuanbao_)
/*     */   {
/*  47 */     this.activityid = _activityid_;
/*  48 */     this.count = _count_;
/*  49 */     this.isuseyuanbao = _isuseyuanbao_;
/*  50 */     this.clientyuanbao = _clientyuanbao_;
/*  51 */     this.needyuanbao = _needyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.activityid);
/*  60 */     _os_.marshal(this.count);
/*  61 */     _os_.marshal(this.isuseyuanbao);
/*  62 */     _os_.marshal(this.clientyuanbao);
/*  63 */     _os_.marshal(this.needyuanbao);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.activityid = _os_.unmarshal_int();
/*  69 */     this.count = _os_.unmarshal_int();
/*  70 */     this.isuseyuanbao = _os_.unmarshal_byte();
/*  71 */     this.clientyuanbao = _os_.unmarshal_long();
/*  72 */     this.needyuanbao = _os_.unmarshal_long();
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof COuterDrawReq)) {
/*  82 */       COuterDrawReq _o_ = (COuterDrawReq)_o1_;
/*  83 */       if (this.activityid != _o_.activityid) return false;
/*  84 */       if (this.count != _o_.count) return false;
/*  85 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  86 */       if (this.clientyuanbao != _o_.clientyuanbao) return false;
/*  87 */       if (this.needyuanbao != _o_.needyuanbao) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.activityid;
/*  96 */     _h_ += this.count;
/*  97 */     _h_ += this.isuseyuanbao;
/*  98 */     _h_ += (int)this.clientyuanbao;
/*  99 */     _h_ += (int)this.needyuanbao;
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.activityid).append(",");
/* 107 */     _sb_.append(this.count).append(",");
/* 108 */     _sb_.append(this.isuseyuanbao).append(",");
/* 109 */     _sb_.append(this.clientyuanbao).append(",");
/* 110 */     _sb_.append(this.needyuanbao).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(COuterDrawReq _o_) {
/* 116 */     if (_o_ == this) return 0;
/* 117 */     int _c_ = 0;
/* 118 */     _c_ = this.activityid - _o_.activityid;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.count - _o_.count;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = Long.signum(this.clientyuanbao - _o_.clientyuanbao);
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = Long.signum(this.needyuanbao - _o_.needyuanbao);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\COuterDrawReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */