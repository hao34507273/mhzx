/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class RoamRoleDataReq implements Marshal
/*    */ {
/*    */   public Octets userid;
/*    */   public long roleid;
/*    */   public int roam_type;
/*    */   public long roam_room_instanceid;
/*    */   public ArrayList<Octets> xtables;
/*    */   
/*    */   public RoamRoleDataReq()
/*    */   {
/* 18 */     this.userid = new Octets();
/* 19 */     this.roleid = 0L;
/* 20 */     this.roam_type = 0;
/* 21 */     this.roam_room_instanceid = 0L;
/* 22 */     this.xtables = new ArrayList();
/*    */   }
/*    */   
/*    */   public RoamRoleDataReq(Octets _userid_, long _roleid_, int _roam_type_, long _roam_room_instanceid_, ArrayList<Octets> _xtables_) {
/* 26 */     this.userid = _userid_;
/* 27 */     this.roleid = _roleid_;
/* 28 */     this.roam_type = _roam_type_;
/* 29 */     this.roam_room_instanceid = _roam_room_instanceid_;
/* 30 */     this.xtables = _xtables_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.userid);
/* 39 */     _os_.marshal(this.roleid);
/* 40 */     _os_.marshal(this.roam_type);
/* 41 */     _os_.marshal(this.roam_room_instanceid);
/* 42 */     _os_.compact_uint32(this.xtables.size());
/* 43 */     for (Octets _v_ : this.xtables) {
/* 44 */       _os_.marshal(_v_);
/*    */     }
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 50 */     this.userid = _os_.unmarshal_Octets();
/* 51 */     this.roleid = _os_.unmarshal_long();
/* 52 */     this.roam_type = _os_.unmarshal_int();
/* 53 */     this.roam_room_instanceid = _os_.unmarshal_long();
/* 54 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 56 */       Octets _v_ = _os_.unmarshal_Octets();
/* 57 */       this.xtables.add(_v_);
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof RoamRoleDataReq)) {
/* 65 */       RoamRoleDataReq _o_ = (RoamRoleDataReq)_o1_;
/* 66 */       if (!this.userid.equals(_o_.userid)) return false;
/* 67 */       if (this.roleid != _o_.roleid) return false;
/* 68 */       if (this.roam_type != _o_.roam_type) return false;
/* 69 */       if (this.roam_room_instanceid != _o_.roam_room_instanceid) return false;
/* 70 */       if (!this.xtables.equals(_o_.xtables)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.userid.hashCode();
/* 79 */     _h_ += (int)this.roleid;
/* 80 */     _h_ += this.roam_type;
/* 81 */     _h_ += (int)this.roam_room_instanceid;
/* 82 */     _h_ += this.xtables.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 90 */     _sb_.append(this.roleid).append(",");
/* 91 */     _sb_.append(this.roam_type).append(",");
/* 92 */     _sb_.append(this.roam_room_instanceid).append(",");
/* 93 */     _sb_.append(this.xtables).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoamRoleDataReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */