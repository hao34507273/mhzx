/*     */ package mzm.gsp.role;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.role.multirank.PGetOccupationMFVRankReq;
/*     */ 
/*     */ 
/*     */ public class CGetOccupationMFVRankReq
/*     */   extends __CGetOccupationMFVRankReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586029;
/*     */   public int occupationid;
/*     */   public int fromno;
/*     */   public int tono;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleid, new PGetOccupationMFVRankReq(roleid, this.fromno, this.tono, this.occupationid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12586029;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetOccupationMFVRankReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetOccupationMFVRankReq(int _occupationid_, int _fromno_, int _tono_)
/*     */   {
/*  42 */     this.occupationid = _occupationid_;
/*  43 */     this.fromno = _fromno_;
/*  44 */     this.tono = _tono_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.occupationid);
/*  53 */     _os_.marshal(this.fromno);
/*  54 */     _os_.marshal(this.tono);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.occupationid = _os_.unmarshal_int();
/*  60 */     this.fromno = _os_.unmarshal_int();
/*  61 */     this.tono = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CGetOccupationMFVRankReq)) {
/*  71 */       CGetOccupationMFVRankReq _o_ = (CGetOccupationMFVRankReq)_o1_;
/*  72 */       if (this.occupationid != _o_.occupationid) return false;
/*  73 */       if (this.fromno != _o_.fromno) return false;
/*  74 */       if (this.tono != _o_.tono) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.occupationid;
/*  83 */     _h_ += this.fromno;
/*  84 */     _h_ += this.tono;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.occupationid).append(",");
/*  92 */     _sb_.append(this.fromno).append(",");
/*  93 */     _sb_.append(this.tono).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetOccupationMFVRankReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.occupationid - _o_.occupationid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.fromno - _o_.fromno;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.tono - _o_.tono;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CGetOccupationMFVRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */