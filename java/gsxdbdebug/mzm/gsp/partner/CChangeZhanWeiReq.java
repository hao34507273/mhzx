/*     */ package mzm.gsp.partner;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.partner.main.PChangeZhanWeiReq;
/*     */ 
/*     */ 
/*     */ public class CChangeZhanWeiReq
/*     */   extends __CChangeZhanWeiReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588040;
/*     */   public int lineupnum;
/*     */   public int srcpos;
/*     */   public int dstpos;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PChangeZhanWeiReq(roleId, this.lineupnum, this.srcpos, this.dstpos));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12588040;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CChangeZhanWeiReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CChangeZhanWeiReq(int _lineupnum_, int _srcpos_, int _dstpos_)
/*     */   {
/*  42 */     this.lineupnum = _lineupnum_;
/*  43 */     this.srcpos = _srcpos_;
/*  44 */     this.dstpos = _dstpos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.lineupnum);
/*  53 */     _os_.marshal(this.srcpos);
/*  54 */     _os_.marshal(this.dstpos);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.lineupnum = _os_.unmarshal_int();
/*  60 */     this.srcpos = _os_.unmarshal_int();
/*  61 */     this.dstpos = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CChangeZhanWeiReq)) {
/*  71 */       CChangeZhanWeiReq _o_ = (CChangeZhanWeiReq)_o1_;
/*  72 */       if (this.lineupnum != _o_.lineupnum) return false;
/*  73 */       if (this.srcpos != _o_.srcpos) return false;
/*  74 */       if (this.dstpos != _o_.dstpos) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.lineupnum;
/*  83 */     _h_ += this.srcpos;
/*  84 */     _h_ += this.dstpos;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.lineupnum).append(",");
/*  92 */     _sb_.append(this.srcpos).append(",");
/*  93 */     _sb_.append(this.dstpos).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChangeZhanWeiReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.lineupnum - _o_.lineupnum;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.srcpos - _o_.srcpos;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.dstpos - _o_.dstpos;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\CChangeZhanWeiReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */