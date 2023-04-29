/*     */ package mzm.gsp.menpaistar;
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
/*     */ public class SCampaignChart
/*     */   extends __SCampaignChart__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612365;
/*     */   public int occupationid;
/*     */   public ArrayList<CampaignChartInfo> ranks;
/*     */   public int page;
/*     */   public int total_page;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612365;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCampaignChart()
/*     */   {
/*  36 */     this.ranks = new ArrayList();
/*     */   }
/*     */   
/*     */   public SCampaignChart(int _occupationid_, ArrayList<CampaignChartInfo> _ranks_, int _page_, int _total_page_) {
/*  40 */     this.occupationid = _occupationid_;
/*  41 */     this.ranks = _ranks_;
/*  42 */     this.page = _page_;
/*  43 */     this.total_page = _total_page_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (CampaignChartInfo _v_ : this.ranks)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.occupationid);
/*  54 */     _os_.compact_uint32(this.ranks.size());
/*  55 */     for (CampaignChartInfo _v_ : this.ranks) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     _os_.marshal(this.page);
/*  59 */     _os_.marshal(this.total_page);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.occupationid = _os_.unmarshal_int();
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  66 */       CampaignChartInfo _v_ = new CampaignChartInfo();
/*  67 */       _v_.unmarshal(_os_);
/*  68 */       this.ranks.add(_v_);
/*     */     }
/*  70 */     this.page = _os_.unmarshal_int();
/*  71 */     this.total_page = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SCampaignChart)) {
/*  81 */       SCampaignChart _o_ = (SCampaignChart)_o1_;
/*  82 */       if (this.occupationid != _o_.occupationid) return false;
/*  83 */       if (!this.ranks.equals(_o_.ranks)) return false;
/*  84 */       if (this.page != _o_.page) return false;
/*  85 */       if (this.total_page != _o_.total_page) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.occupationid;
/*  94 */     _h_ += this.ranks.hashCode();
/*  95 */     _h_ += this.page;
/*  96 */     _h_ += this.total_page;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.occupationid).append(",");
/* 104 */     _sb_.append(this.ranks).append(",");
/* 105 */     _sb_.append(this.page).append(",");
/* 106 */     _sb_.append(this.total_page).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\SCampaignChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */