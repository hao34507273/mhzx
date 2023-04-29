/*    */ package mzm.gsp.bigboss;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GetRoleBigBossRemoteRank_ClientReq implements Marshal, Comparable<GetRoleBigBossRemoteRank_ClientReq>
/*    */ {
/*    */   public long roleid;
/*    */   
/*    */   public GetRoleBigBossRemoteRank_ClientReq() {}
/*    */   
/*    */   public GetRoleBigBossRemoteRank_ClientReq(long _roleid_)
/*    */   {
/* 15 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 23 */     _os_.marshal(this.roleid);
/* 24 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 28 */     this.roleid = _os_.unmarshal_long();
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 33 */     if (_o1_ == this) return true;
/* 34 */     if ((_o1_ instanceof GetRoleBigBossRemoteRank_ClientReq)) {
/* 35 */       GetRoleBigBossRemoteRank_ClientReq _o_ = (GetRoleBigBossRemoteRank_ClientReq)_o1_;
/* 36 */       if (this.roleid != _o_.roleid) return false;
/* 37 */       return true;
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 43 */     int _h_ = 0;
/* 44 */     _h_ += (int)this.roleid;
/* 45 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 49 */     StringBuilder _sb_ = new StringBuilder();
/* 50 */     _sb_.append("(");
/* 51 */     _sb_.append(this.roleid).append(",");
/* 52 */     _sb_.append(")");
/* 53 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetRoleBigBossRemoteRank_ClientReq _o_) {
/* 57 */     if (_o_ == this) return 0;
/* 58 */     int _c_ = 0;
/* 59 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 60 */     if (0 != _c_) return _c_;
/* 61 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\GetRoleBigBossRemoteRank_ClientReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */