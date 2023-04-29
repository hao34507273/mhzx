/*    */ package mzm.gsp.ladder;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleEndRetInfo implements Marshal, Comparable<RoleEndRetInfo>
/*    */ {
/*    */   public long roleid;
/*    */   public int fightscore;
/*    */   
/*    */   public RoleEndRetInfo() {}
/*    */   
/*    */   public RoleEndRetInfo(long _roleid_, int _fightscore_)
/*    */   {
/* 16 */     this.roleid = _roleid_;
/* 17 */     this.fightscore = _fightscore_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.roleid);
/* 26 */     _os_.marshal(this.fightscore);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.roleid = _os_.unmarshal_long();
/* 32 */     this.fightscore = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof RoleEndRetInfo)) {
/* 39 */       RoleEndRetInfo _o_ = (RoleEndRetInfo)_o1_;
/* 40 */       if (this.roleid != _o_.roleid) return false;
/* 41 */       if (this.fightscore != _o_.fightscore) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += (int)this.roleid;
/* 50 */     _h_ += this.fightscore;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.roleid).append(",");
/* 58 */     _sb_.append(this.fightscore).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RoleEndRetInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.fightscore - _o_.fightscore;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\RoleEndRetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */