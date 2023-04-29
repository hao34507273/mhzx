/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class ReportCorpsFightValueReq implements Marshal
/*    */ {
/*    */   public int activity_cfgid;
/*    */   public int zone_num;
/*    */   public int force;
/*    */   public HashMap<Long, Float> corps;
/*    */   
/*    */   public ReportCorpsFightValueReq()
/*    */   {
/* 17 */     this.corps = new HashMap();
/*    */   }
/*    */   
/*    */   public ReportCorpsFightValueReq(int _activity_cfgid_, int _zone_num_, int _force_, HashMap<Long, Float> _corps_) {
/* 21 */     this.activity_cfgid = _activity_cfgid_;
/* 22 */     this.zone_num = _zone_num_;
/* 23 */     this.force = _force_;
/* 24 */     this.corps = _corps_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.activity_cfgid);
/* 33 */     _os_.marshal(this.zone_num);
/* 34 */     _os_.marshal(this.force);
/* 35 */     _os_.compact_uint32(this.corps.size());
/* 36 */     for (Map.Entry<Long, Float> _e_ : this.corps.entrySet()) {
/* 37 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 38 */       _os_.marshal(((Float)_e_.getValue()).floatValue());
/*    */     }
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.activity_cfgid = _os_.unmarshal_int();
/* 45 */     this.zone_num = _os_.unmarshal_int();
/* 46 */     this.force = _os_.unmarshal_int();
/* 47 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 49 */       long _k_ = _os_.unmarshal_long();
/*    */       
/* 51 */       float _v_ = _os_.unmarshal_float();
/* 52 */       this.corps.put(Long.valueOf(_k_), Float.valueOf(_v_));
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof ReportCorpsFightValueReq)) {
/* 60 */       ReportCorpsFightValueReq _o_ = (ReportCorpsFightValueReq)_o1_;
/* 61 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 62 */       if (this.zone_num != _o_.zone_num) return false;
/* 63 */       if (this.force != _o_.force) return false;
/* 64 */       if (!this.corps.equals(_o_.corps)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.activity_cfgid;
/* 73 */     _h_ += this.zone_num;
/* 74 */     _h_ += this.force;
/* 75 */     _h_ += this.corps.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.activity_cfgid).append(",");
/* 83 */     _sb_.append(this.zone_num).append(",");
/* 84 */     _sb_.append(this.force).append(",");
/* 85 */     _sb_.append(this.corps).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ReportCorpsFightValueReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */