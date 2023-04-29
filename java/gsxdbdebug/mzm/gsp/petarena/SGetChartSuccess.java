/*     */ package mzm.gsp.petarena;
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
/*     */ public class SGetChartSuccess
/*     */   extends __SGetChartSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628241;
/*     */   public int my_rank;
/*     */   public int my_point;
/*     */   public ArrayList<PetArenaChartData> rank_datas;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628241;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetChartSuccess()
/*     */   {
/*  35 */     this.rank_datas = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetChartSuccess(int _my_rank_, int _my_point_, ArrayList<PetArenaChartData> _rank_datas_) {
/*  39 */     this.my_rank = _my_rank_;
/*  40 */     this.my_point = _my_point_;
/*  41 */     this.rank_datas = _rank_datas_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (PetArenaChartData _v_ : this.rank_datas)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.my_rank);
/*  52 */     _os_.marshal(this.my_point);
/*  53 */     _os_.compact_uint32(this.rank_datas.size());
/*  54 */     for (PetArenaChartData _v_ : this.rank_datas) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.my_rank = _os_.unmarshal_int();
/*  62 */     this.my_point = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       PetArenaChartData _v_ = new PetArenaChartData();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.rank_datas.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SGetChartSuccess)) {
/*  77 */       SGetChartSuccess _o_ = (SGetChartSuccess)_o1_;
/*  78 */       if (this.my_rank != _o_.my_rank) return false;
/*  79 */       if (this.my_point != _o_.my_point) return false;
/*  80 */       if (!this.rank_datas.equals(_o_.rank_datas)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.my_rank;
/*  89 */     _h_ += this.my_point;
/*  90 */     _h_ += this.rank_datas.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.my_rank).append(",");
/*  98 */     _sb_.append(this.my_point).append(",");
/*  99 */     _sb_.append(this.rank_datas).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SGetChartSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */