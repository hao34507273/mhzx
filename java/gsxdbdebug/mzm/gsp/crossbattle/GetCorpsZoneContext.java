/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GetCorpsZoneContext implements Marshal, Comparable<GetCorpsZoneContext>
/*    */ {
/*    */   public int count;
/*    */   public long roleid;
/*    */   public long corpsid;
/*    */   
/*    */   public GetCorpsZoneContext() {}
/*    */   
/*    */   public GetCorpsZoneContext(int _count_, long _roleid_, long _corpsid_)
/*    */   {
/* 17 */     this.count = _count_;
/* 18 */     this.roleid = _roleid_;
/* 19 */     this.corpsid = _corpsid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.count);
/* 28 */     _os_.marshal(this.roleid);
/* 29 */     _os_.marshal(this.corpsid);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.count = _os_.unmarshal_int();
/* 35 */     this.roleid = _os_.unmarshal_long();
/* 36 */     this.corpsid = _os_.unmarshal_long();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof GetCorpsZoneContext)) {
/* 43 */       GetCorpsZoneContext _o_ = (GetCorpsZoneContext)_o1_;
/* 44 */       if (this.count != _o_.count) return false;
/* 45 */       if (this.roleid != _o_.roleid) return false;
/* 46 */       if (this.corpsid != _o_.corpsid) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.count;
/* 55 */     _h_ += (int)this.roleid;
/* 56 */     _h_ += (int)this.corpsid;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.count).append(",");
/* 64 */     _sb_.append(this.roleid).append(",");
/* 65 */     _sb_.append(this.corpsid).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetCorpsZoneContext _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.count - _o_.count;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = Long.signum(this.corpsid - _o_.corpsid);
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetCorpsZoneContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */