/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class RoamPointRaceDataReq implements Marshal
/*    */ {
/*    */   public long roam_room_instanceid;
/*    */   public ArrayList<RolePointRaceMarkingInfo> role_infos;
/*    */   public PointRaceCorpsInfo corps_info;
/*    */   
/*    */   public RoamPointRaceDataReq()
/*    */   {
/* 16 */     this.roam_room_instanceid = 0L;
/* 17 */     this.role_infos = new ArrayList();
/* 18 */     this.corps_info = new PointRaceCorpsInfo();
/*    */   }
/*    */   
/*    */   public RoamPointRaceDataReq(long _roam_room_instanceid_, ArrayList<RolePointRaceMarkingInfo> _role_infos_, PointRaceCorpsInfo _corps_info_) {
/* 22 */     this.roam_room_instanceid = _roam_room_instanceid_;
/* 23 */     this.role_infos = _role_infos_;
/* 24 */     this.corps_info = _corps_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     for (RolePointRaceMarkingInfo _v_ : this.role_infos)
/* 29 */       if (!_v_._validator_()) return false;
/* 30 */     if (!this.corps_info._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.roam_room_instanceid);
/* 36 */     _os_.compact_uint32(this.role_infos.size());
/* 37 */     for (RolePointRaceMarkingInfo _v_ : this.role_infos) {
/* 38 */       _os_.marshal(_v_);
/*    */     }
/* 40 */     _os_.marshal(this.corps_info);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.roam_room_instanceid = _os_.unmarshal_long();
/* 46 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 47 */       RolePointRaceMarkingInfo _v_ = new RolePointRaceMarkingInfo();
/* 48 */       _v_.unmarshal(_os_);
/* 49 */       this.role_infos.add(_v_);
/*    */     }
/* 51 */     this.corps_info.unmarshal(_os_);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof RoamPointRaceDataReq)) {
/* 58 */       RoamPointRaceDataReq _o_ = (RoamPointRaceDataReq)_o1_;
/* 59 */       if (this.roam_room_instanceid != _o_.roam_room_instanceid) return false;
/* 60 */       if (!this.role_infos.equals(_o_.role_infos)) return false;
/* 61 */       if (!this.corps_info.equals(_o_.corps_info)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += (int)this.roam_room_instanceid;
/* 70 */     _h_ += this.role_infos.hashCode();
/* 71 */     _h_ += this.corps_info.hashCode();
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.roam_room_instanceid).append(",");
/* 79 */     _sb_.append(this.role_infos).append(",");
/* 80 */     _sb_.append(this.corps_info).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoamPointRaceDataReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */