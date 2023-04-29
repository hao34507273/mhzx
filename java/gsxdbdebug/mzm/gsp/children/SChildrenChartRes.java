/*     */ package mzm.gsp.children;
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
/*     */ public class SChildrenChartRes
/*     */   extends __SChildrenChartRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609433;
/*     */   public ArrayList<ChildrenChartData> rank_list;
/*     */   public int my_rank;
/*     */   public int my_rating;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609433;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChildrenChartRes()
/*     */   {
/*  35 */     this.rank_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SChildrenChartRes(ArrayList<ChildrenChartData> _rank_list_, int _my_rank_, int _my_rating_) {
/*  39 */     this.rank_list = _rank_list_;
/*  40 */     this.my_rank = _my_rank_;
/*  41 */     this.my_rating = _my_rating_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (ChildrenChartData _v_ : this.rank_list)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.compact_uint32(this.rank_list.size());
/*  52 */     for (ChildrenChartData _v_ : this.rank_list) {
/*  53 */       _os_.marshal(_v_);
/*     */     }
/*  55 */     _os_.marshal(this.my_rank);
/*  56 */     _os_.marshal(this.my_rating);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  62 */       ChildrenChartData _v_ = new ChildrenChartData();
/*  63 */       _v_.unmarshal(_os_);
/*  64 */       this.rank_list.add(_v_);
/*     */     }
/*  66 */     this.my_rank = _os_.unmarshal_int();
/*  67 */     this.my_rating = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SChildrenChartRes)) {
/*  77 */       SChildrenChartRes _o_ = (SChildrenChartRes)_o1_;
/*  78 */       if (!this.rank_list.equals(_o_.rank_list)) return false;
/*  79 */       if (this.my_rank != _o_.my_rank) return false;
/*  80 */       if (this.my_rating != _o_.my_rating) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.rank_list.hashCode();
/*  89 */     _h_ += this.my_rank;
/*  90 */     _h_ += this.my_rating;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.rank_list).append(",");
/*  98 */     _sb_.append(this.my_rank).append(",");
/*  99 */     _sb_.append(this.my_rating).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChildrenChartRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */