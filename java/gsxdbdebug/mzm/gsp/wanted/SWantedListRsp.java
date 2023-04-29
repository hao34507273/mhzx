/*     */ package mzm.gsp.wanted;
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
/*     */ public class SWantedListRsp
/*     */   extends __SWantedListRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620294;
/*     */   public int pageno;
/*     */   public int pagetotal;
/*     */   public ArrayList<WantedRoleInfo> wantedlist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620294;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SWantedListRsp()
/*     */   {
/*  35 */     this.wantedlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SWantedListRsp(int _pageno_, int _pagetotal_, ArrayList<WantedRoleInfo> _wantedlist_) {
/*  39 */     this.pageno = _pageno_;
/*  40 */     this.pagetotal = _pagetotal_;
/*  41 */     this.wantedlist = _wantedlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (WantedRoleInfo _v_ : this.wantedlist)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.pageno);
/*  52 */     _os_.marshal(this.pagetotal);
/*  53 */     _os_.compact_uint32(this.wantedlist.size());
/*  54 */     for (WantedRoleInfo _v_ : this.wantedlist) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.pageno = _os_.unmarshal_int();
/*  62 */     this.pagetotal = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       WantedRoleInfo _v_ = new WantedRoleInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.wantedlist.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SWantedListRsp)) {
/*  77 */       SWantedListRsp _o_ = (SWantedListRsp)_o1_;
/*  78 */       if (this.pageno != _o_.pageno) return false;
/*  79 */       if (this.pagetotal != _o_.pagetotal) return false;
/*  80 */       if (!this.wantedlist.equals(_o_.wantedlist)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.pageno;
/*  89 */     _h_ += this.pagetotal;
/*  90 */     _h_ += this.wantedlist.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.pageno).append(",");
/*  98 */     _sb_.append(this.pagetotal).append(",");
/*  99 */     _sb_.append(this.wantedlist).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\SWantedListRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */