/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class RoamPointRaceContextReq implements Marshal
/*    */ {
/*    */   public PointRaceInfo point_race_info;
/*    */   public ArrayList<PointRaceCorpsBaseInfo> corps_base_infos;
/*    */   
/*    */   public RoamPointRaceContextReq()
/*    */   {
/* 15 */     this.point_race_info = new PointRaceInfo();
/* 16 */     this.corps_base_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public RoamPointRaceContextReq(PointRaceInfo _point_race_info_, ArrayList<PointRaceCorpsBaseInfo> _corps_base_infos_) {
/* 20 */     this.point_race_info = _point_race_info_;
/* 21 */     this.corps_base_infos = _corps_base_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     if (!this.point_race_info._validator_()) return false;
/* 26 */     for (PointRaceCorpsBaseInfo _v_ : this.corps_base_infos)
/* 27 */       if (!_v_._validator_()) return false;
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.point_race_info);
/* 33 */     _os_.compact_uint32(this.corps_base_infos.size());
/* 34 */     for (PointRaceCorpsBaseInfo _v_ : this.corps_base_infos) {
/* 35 */       _os_.marshal(_v_);
/*    */     }
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     this.point_race_info.unmarshal(_os_);
/* 42 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 43 */       PointRaceCorpsBaseInfo _v_ = new PointRaceCorpsBaseInfo();
/* 44 */       _v_.unmarshal(_os_);
/* 45 */       this.corps_base_infos.add(_v_);
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof RoamPointRaceContextReq)) {
/* 53 */       RoamPointRaceContextReq _o_ = (RoamPointRaceContextReq)_o1_;
/* 54 */       if (!this.point_race_info.equals(_o_.point_race_info)) return false;
/* 55 */       if (!this.corps_base_infos.equals(_o_.corps_base_infos)) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.point_race_info.hashCode();
/* 64 */     _h_ += this.corps_base_infos.hashCode();
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.point_race_info).append(",");
/* 72 */     _sb_.append(this.corps_base_infos).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoamPointRaceContextReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */