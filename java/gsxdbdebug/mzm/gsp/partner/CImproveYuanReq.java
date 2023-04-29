/*     */ package mzm.gsp.partner;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.partner.main.PCImproveYuanShenReq;
/*     */ 
/*     */ 
/*     */ public class CImproveYuanReq
/*     */   extends __CImproveYuanReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588057;
/*     */   public int partnerid;
/*     */   public int index;
/*     */   public int tolevel;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCImproveYuanShenReq(roleId, this.partnerid, this.index, this.tolevel));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12588057;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CImproveYuanReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CImproveYuanReq(int _partnerid_, int _index_, int _tolevel_)
/*     */   {
/*  42 */     this.partnerid = _partnerid_;
/*  43 */     this.index = _index_;
/*  44 */     this.tolevel = _tolevel_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.partnerid);
/*  53 */     _os_.marshal(this.index);
/*  54 */     _os_.marshal(this.tolevel);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.partnerid = _os_.unmarshal_int();
/*  60 */     this.index = _os_.unmarshal_int();
/*  61 */     this.tolevel = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CImproveYuanReq)) {
/*  71 */       CImproveYuanReq _o_ = (CImproveYuanReq)_o1_;
/*  72 */       if (this.partnerid != _o_.partnerid) return false;
/*  73 */       if (this.index != _o_.index) return false;
/*  74 */       if (this.tolevel != _o_.tolevel) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.partnerid;
/*  83 */     _h_ += this.index;
/*  84 */     _h_ += this.tolevel;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.partnerid).append(",");
/*  92 */     _sb_.append(this.index).append(",");
/*  93 */     _sb_.append(this.tolevel).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CImproveYuanReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.partnerid - _o_.partnerid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.index - _o_.index;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.tolevel - _o_.tolevel;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\CImproveYuanReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */