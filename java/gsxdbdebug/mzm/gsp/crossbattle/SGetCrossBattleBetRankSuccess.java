/*     */ package mzm.gsp.crossbattle;
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
/*     */ public class SGetCrossBattleBetRankSuccess
/*     */   extends __SGetCrossBattleBetRankSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617097;
/*     */   public int rank_type;
/*     */   public int activity_cfg_id;
/*     */   public ArrayList<CrossBattleBetRankData> rank_list;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617097;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetCrossBattleBetRankSuccess()
/*     */   {
/*  35 */     this.rank_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetCrossBattleBetRankSuccess(int _rank_type_, int _activity_cfg_id_, ArrayList<CrossBattleBetRankData> _rank_list_) {
/*  39 */     this.rank_type = _rank_type_;
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.rank_list = _rank_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (CrossBattleBetRankData _v_ : this.rank_list)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.rank_type);
/*  52 */     _os_.marshal(this.activity_cfg_id);
/*  53 */     _os_.compact_uint32(this.rank_list.size());
/*  54 */     for (CrossBattleBetRankData _v_ : this.rank_list) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.rank_type = _os_.unmarshal_int();
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       CrossBattleBetRankData _v_ = new CrossBattleBetRankData();
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
/*  76 */     if ((_o1_ instanceof SGetCrossBattleBetRankSuccess)) {
/*  77 */       SGetCrossBattleBetRankSuccess _o_ = (SGetCrossBattleBetRankSuccess)_o1_;
/*  78 */       if (this.rank_type != _o_.rank_type) return false;
/*  79 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  80 */       if (!this.rank_list.equals(_o_.rank_list)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.rank_type;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.rank_list.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.rank_type).append(",");
/*  98 */     _sb_.append(this.activity_cfg_id).append(",");
/*  99 */     _sb_.append(this.rank_list).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetCrossBattleBetRankSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */