/*    */ package mzm.gsp.aircraft;
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
/*    */ public class SSyncAircraftInfo
/*    */   extends __SSyncAircraftInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624648;
/*    */   public HashMap<Integer, AircraftInfo> own_aircraft_map;
/*    */   public int current_aircraft_cfg_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12624648;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncAircraftInfo()
/*    */   {
/* 34 */     this.own_aircraft_map = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncAircraftInfo(HashMap<Integer, AircraftInfo> _own_aircraft_map_, int _current_aircraft_cfg_id_) {
/* 38 */     this.own_aircraft_map = _own_aircraft_map_;
/* 39 */     this.current_aircraft_cfg_id = _current_aircraft_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Map.Entry<Integer, AircraftInfo> _e_ : this.own_aircraft_map.entrySet()) {
/* 44 */       if (!((AircraftInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.compact_uint32(this.own_aircraft_map.size());
/* 51 */     for (Map.Entry<Integer, AircraftInfo> _e_ : this.own_aircraft_map.entrySet()) {
/* 52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 53 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 55 */     _os_.marshal(this.current_aircraft_cfg_id);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 62 */       int _k_ = _os_.unmarshal_int();
/* 63 */       AircraftInfo _v_ = new AircraftInfo();
/* 64 */       _v_.unmarshal(_os_);
/* 65 */       this.own_aircraft_map.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 67 */     this.current_aircraft_cfg_id = _os_.unmarshal_int();
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SSyncAircraftInfo)) {
/* 77 */       SSyncAircraftInfo _o_ = (SSyncAircraftInfo)_o1_;
/* 78 */       if (!this.own_aircraft_map.equals(_o_.own_aircraft_map)) return false;
/* 79 */       if (this.current_aircraft_cfg_id != _o_.current_aircraft_cfg_id) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.own_aircraft_map.hashCode();
/* 88 */     _h_ += this.current_aircraft_cfg_id;
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.own_aircraft_map).append(",");
/* 96 */     _sb_.append(this.current_aircraft_cfg_id).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\SSyncAircraftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */