/*     */ package mzm.gsp.friendscircle;
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
/*     */ public class SWeekPopularityChartRes
/*     */   extends __SWeekPopularityChartRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625416;
/*     */   public int current_week_popularity_value;
/*     */   public int my_rank;
/*     */   public ArrayList<PopularityRankData> rank_list;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625416;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SWeekPopularityChartRes()
/*     */   {
/*  35 */     this.rank_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SWeekPopularityChartRes(int _current_week_popularity_value_, int _my_rank_, ArrayList<PopularityRankData> _rank_list_) {
/*  39 */     this.current_week_popularity_value = _current_week_popularity_value_;
/*  40 */     this.my_rank = _my_rank_;
/*  41 */     this.rank_list = _rank_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (PopularityRankData _v_ : this.rank_list)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.current_week_popularity_value);
/*  52 */     _os_.marshal(this.my_rank);
/*  53 */     _os_.compact_uint32(this.rank_list.size());
/*  54 */     for (PopularityRankData _v_ : this.rank_list) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.current_week_popularity_value = _os_.unmarshal_int();
/*  62 */     this.my_rank = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       PopularityRankData _v_ = new PopularityRankData();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.rank_list.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SWeekPopularityChartRes)) {
/*  77 */       SWeekPopularityChartRes _o_ = (SWeekPopularityChartRes)_o1_;
/*  78 */       if (this.current_week_popularity_value != _o_.current_week_popularity_value) return false;
/*  79 */       if (this.my_rank != _o_.my_rank) return false;
/*  80 */       if (!this.rank_list.equals(_o_.rank_list)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.current_week_popularity_value;
/*  89 */     _h_ += this.my_rank;
/*  90 */     _h_ += this.rank_list.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.current_week_popularity_value).append(",");
/*  98 */     _sb_.append(this.my_rank).append(",");
/*  99 */     _sb_.append(this.rank_list).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\SWeekPopularityChartRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */