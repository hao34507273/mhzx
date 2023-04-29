/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class PointRaceCorpsCVCInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public HashMap<Long, HubCorpsCVCInfo> cvc_infos;
/*    */   
/*    */   public PointRaceCorpsCVCInfo()
/*    */   {
/* 12 */     this.cvc_infos = new HashMap();
/*    */   }
/*    */   
/*    */   public PointRaceCorpsCVCInfo(HashMap<Long, HubCorpsCVCInfo> _cvc_infos_) {
/* 16 */     this.cvc_infos = _cvc_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     for (java.util.Map.Entry<Long, HubCorpsCVCInfo> _e_ : this.cvc_infos.entrySet()) {
/* 21 */       if (!((HubCorpsCVCInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.compact_uint32(this.cvc_infos.size());
/* 28 */     for (java.util.Map.Entry<Long, HubCorpsCVCInfo> _e_ : this.cvc_infos.entrySet()) {
/* 29 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 30 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 36 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 38 */       long _k_ = _os_.unmarshal_long();
/* 39 */       HubCorpsCVCInfo _v_ = new HubCorpsCVCInfo();
/* 40 */       _v_.unmarshal(_os_);
/* 41 */       this.cvc_infos.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof PointRaceCorpsCVCInfo)) {
/* 49 */       PointRaceCorpsCVCInfo _o_ = (PointRaceCorpsCVCInfo)_o1_;
/* 50 */       if (!this.cvc_infos.equals(_o_.cvc_infos)) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.cvc_infos.hashCode();
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.cvc_infos).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PointRaceCorpsCVCInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */