/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class ReportPointRaceCorpsCVCReq implements Marshal
/*    */ {
/*    */   public int activity_cfgid;
/*    */   public int zone;
/*    */   public int time_point_cfgid;
/*    */   public HashMap<Long, PointRaceCorpsCVCInfo> corps_cvc_infos;
/*    */   
/*    */   public ReportPointRaceCorpsCVCReq()
/*    */   {
/* 17 */     this.corps_cvc_infos = new HashMap();
/*    */   }
/*    */   
/*    */   public ReportPointRaceCorpsCVCReq(int _activity_cfgid_, int _zone_, int _time_point_cfgid_, HashMap<Long, PointRaceCorpsCVCInfo> _corps_cvc_infos_) {
/* 21 */     this.activity_cfgid = _activity_cfgid_;
/* 22 */     this.zone = _zone_;
/* 23 */     this.time_point_cfgid = _time_point_cfgid_;
/* 24 */     this.corps_cvc_infos = _corps_cvc_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     for (Map.Entry<Long, PointRaceCorpsCVCInfo> _e_ : this.corps_cvc_infos.entrySet()) {
/* 29 */       if (!((PointRaceCorpsCVCInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.activity_cfgid);
/* 36 */     _os_.marshal(this.zone);
/* 37 */     _os_.marshal(this.time_point_cfgid);
/* 38 */     _os_.compact_uint32(this.corps_cvc_infos.size());
/* 39 */     for (Map.Entry<Long, PointRaceCorpsCVCInfo> _e_ : this.corps_cvc_infos.entrySet()) {
/* 40 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 41 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 47 */     this.activity_cfgid = _os_.unmarshal_int();
/* 48 */     this.zone = _os_.unmarshal_int();
/* 49 */     this.time_point_cfgid = _os_.unmarshal_int();
/* 50 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 52 */       long _k_ = _os_.unmarshal_long();
/* 53 */       PointRaceCorpsCVCInfo _v_ = new PointRaceCorpsCVCInfo();
/* 54 */       _v_.unmarshal(_os_);
/* 55 */       this.corps_cvc_infos.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof ReportPointRaceCorpsCVCReq)) {
/* 63 */       ReportPointRaceCorpsCVCReq _o_ = (ReportPointRaceCorpsCVCReq)_o1_;
/* 64 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 65 */       if (this.zone != _o_.zone) return false;
/* 66 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/* 67 */       if (!this.corps_cvc_infos.equals(_o_.corps_cvc_infos)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activity_cfgid;
/* 76 */     _h_ += this.zone;
/* 77 */     _h_ += this.time_point_cfgid;
/* 78 */     _h_ += this.corps_cvc_infos.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.activity_cfgid).append(",");
/* 86 */     _sb_.append(this.zone).append(",");
/* 87 */     _sb_.append(this.time_point_cfgid).append(",");
/* 88 */     _sb_.append(this.corps_cvc_infos).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ReportPointRaceCorpsCVCReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */