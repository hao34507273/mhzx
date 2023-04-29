/*     */ package mzm.gsp.corps;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.corps.main.PCGetCorpsHistoryReq;
/*     */ 
/*     */ 
/*     */ public class CGetCorpsHistoryReq
/*     */   extends __CGetCorpsHistoryReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617518;
/*     */   public long corpsid;
/*     */   public int start;
/*     */   public int step;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCGetCorpsHistoryReq(roleId, this.corpsid, this.start, this.step));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12617518;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetCorpsHistoryReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetCorpsHistoryReq(long _corpsid_, int _start_, int _step_)
/*     */   {
/*  42 */     this.corpsid = _corpsid_;
/*  43 */     this.start = _start_;
/*  44 */     this.step = _step_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.corpsid);
/*  53 */     _os_.marshal(this.start);
/*  54 */     _os_.marshal(this.step);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.corpsid = _os_.unmarshal_long();
/*  60 */     this.start = _os_.unmarshal_int();
/*  61 */     this.step = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CGetCorpsHistoryReq)) {
/*  71 */       CGetCorpsHistoryReq _o_ = (CGetCorpsHistoryReq)_o1_;
/*  72 */       if (this.corpsid != _o_.corpsid) return false;
/*  73 */       if (this.start != _o_.start) return false;
/*  74 */       if (this.step != _o_.step) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += (int)this.corpsid;
/*  83 */     _h_ += this.start;
/*  84 */     _h_ += this.step;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.corpsid).append(",");
/*  92 */     _sb_.append(this.start).append(",");
/*  93 */     _sb_.append(this.step).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetCorpsHistoryReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = Long.signum(this.corpsid - _o_.corpsid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.start - _o_.start;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.step - _o_.step;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CGetCorpsHistoryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */