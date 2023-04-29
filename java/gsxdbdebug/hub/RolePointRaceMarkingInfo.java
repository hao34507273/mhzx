/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class RolePointRaceMarkingInfo implements Marshal
/*    */ {
/*    */   public int phys_zoneid;
/*    */   public Octets userid;
/*    */   public long roleid;
/*    */   
/*    */   public RolePointRaceMarkingInfo()
/*    */   {
/* 16 */     this.phys_zoneid = 0;
/* 17 */     this.userid = new Octets();
/* 18 */     this.roleid = 0L;
/*    */   }
/*    */   
/*    */   public RolePointRaceMarkingInfo(int _phys_zoneid_, Octets _userid_, long _roleid_) {
/* 22 */     this.phys_zoneid = _phys_zoneid_;
/* 23 */     this.userid = _userid_;
/* 24 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.phys_zoneid);
/* 33 */     _os_.marshal(this.userid);
/* 34 */     _os_.marshal(this.roleid);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.phys_zoneid = _os_.unmarshal_int();
/* 40 */     this.userid = _os_.unmarshal_Octets();
/* 41 */     this.roleid = _os_.unmarshal_long();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof RolePointRaceMarkingInfo)) {
/* 48 */       RolePointRaceMarkingInfo _o_ = (RolePointRaceMarkingInfo)_o1_;
/* 49 */       if (this.phys_zoneid != _o_.phys_zoneid) return false;
/* 50 */       if (!this.userid.equals(_o_.userid)) return false;
/* 51 */       if (this.roleid != _o_.roleid) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.phys_zoneid;
/* 60 */     _h_ += this.userid.hashCode();
/* 61 */     _h_ += (int)this.roleid;
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(this.phys_zoneid).append(",");
/* 69 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 70 */     _sb_.append(this.roleid).append(",");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RolePointRaceMarkingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */