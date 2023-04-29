/*     */ package mzm.gsp.prison;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPrisonListRsp
/*     */   extends __SPrisonListRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620037;
/*     */   public int pageno;
/*     */   public int pagetotal;
/*     */   public ArrayList<PrisonRoleInfo> prisonlist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620037;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPrisonListRsp()
/*     */   {
/*  35 */     this.prisonlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SPrisonListRsp(int _pageno_, int _pagetotal_, ArrayList<PrisonRoleInfo> _prisonlist_) {
/*  39 */     this.pageno = _pageno_;
/*  40 */     this.pagetotal = _pagetotal_;
/*  41 */     this.prisonlist = _prisonlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (PrisonRoleInfo _v_ : this.prisonlist)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.pageno);
/*  52 */     _os_.marshal(this.pagetotal);
/*  53 */     _os_.compact_uint32(this.prisonlist.size());
/*  54 */     for (PrisonRoleInfo _v_ : this.prisonlist) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.pageno = _os_.unmarshal_int();
/*  62 */     this.pagetotal = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       PrisonRoleInfo _v_ = new PrisonRoleInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.prisonlist.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SPrisonListRsp)) {
/*  77 */       SPrisonListRsp _o_ = (SPrisonListRsp)_o1_;
/*  78 */       if (this.pageno != _o_.pageno) return false;
/*  79 */       if (this.pagetotal != _o_.pagetotal) return false;
/*  80 */       if (!this.prisonlist.equals(_o_.prisonlist)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.pageno;
/*  89 */     _h_ += this.pagetotal;
/*  90 */     _h_ += this.prisonlist.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.pageno).append(",");
/*  98 */     _sb_.append(this.pagetotal).append(",");
/*  99 */     _sb_.append(this.prisonlist).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\SPrisonListRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */