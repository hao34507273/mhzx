/*    */ package mzm.gsp.genius;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetGeninusSeriesSuccess
/*    */   extends __SGetGeninusSeriesSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613889;
/*    */   public HashMap<Integer, GeniusSeriesInfo> series;
/*    */   public int cur_series;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613889;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetGeninusSeriesSuccess()
/*    */   {
/* 34 */     this.series = new HashMap();
/*    */   }
/*    */   
/*    */   public SGetGeninusSeriesSuccess(HashMap<Integer, GeniusSeriesInfo> _series_, int _cur_series_) {
/* 38 */     this.series = _series_;
/* 39 */     this.cur_series = _cur_series_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Map.Entry<Integer, GeniusSeriesInfo> _e_ : this.series.entrySet()) {
/* 44 */       if (!((GeniusSeriesInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.compact_uint32(this.series.size());
/* 51 */     for (Map.Entry<Integer, GeniusSeriesInfo> _e_ : this.series.entrySet()) {
/* 52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 53 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 55 */     _os_.marshal(this.cur_series);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 62 */       int _k_ = _os_.unmarshal_int();
/* 63 */       GeniusSeriesInfo _v_ = new GeniusSeriesInfo();
/* 64 */       _v_.unmarshal(_os_);
/* 65 */       this.series.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 67 */     this.cur_series = _os_.unmarshal_int();
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SGetGeninusSeriesSuccess)) {
/* 77 */       SGetGeninusSeriesSuccess _o_ = (SGetGeninusSeriesSuccess)_o1_;
/* 78 */       if (!this.series.equals(_o_.series)) return false;
/* 79 */       if (this.cur_series != _o_.cur_series) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.series.hashCode();
/* 88 */     _h_ += this.cur_series;
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.series).append(",");
/* 96 */     _sb_.append(this.cur_series).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\SGetGeninusSeriesSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */