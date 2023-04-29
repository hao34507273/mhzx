/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoamMatchContextRsp
/*    */   implements Marshal, Comparable<RoamMatchContextRsp>
/*    */ {
/*    */   public int roam_zoneid;
/*    */   public long roam_room_instanceid;
/*    */   
/*    */   public RoamMatchContextRsp()
/*    */   {
/* 15 */     this.roam_zoneid = 0;
/* 16 */     this.roam_room_instanceid = 0L;
/*    */   }
/*    */   
/*    */   public RoamMatchContextRsp(int _roam_zoneid_, long _roam_room_instanceid_) {
/* 20 */     this.roam_zoneid = _roam_zoneid_;
/* 21 */     this.roam_room_instanceid = _roam_room_instanceid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.roam_zoneid);
/* 30 */     _os_.marshal(this.roam_room_instanceid);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.roam_zoneid = _os_.unmarshal_int();
/* 36 */     this.roam_room_instanceid = _os_.unmarshal_long();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof RoamMatchContextRsp)) {
/* 43 */       RoamMatchContextRsp _o_ = (RoamMatchContextRsp)_o1_;
/* 44 */       if (this.roam_zoneid != _o_.roam_zoneid) return false;
/* 45 */       if (this.roam_room_instanceid != _o_.roam_room_instanceid) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.roam_zoneid;
/* 54 */     _h_ += (int)this.roam_room_instanceid;
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.roam_zoneid).append(",");
/* 62 */     _sb_.append(this.roam_room_instanceid).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RoamMatchContextRsp _o_) {
/* 68 */     if (_o_ == this) return 0;
/* 69 */     int _c_ = 0;
/* 70 */     _c_ = this.roam_zoneid - _o_.roam_zoneid;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     _c_ = Long.signum(this.roam_room_instanceid - _o_.roam_room_instanceid);
/* 73 */     if (0 != _c_) return _c_;
/* 74 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoamMatchContextRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */