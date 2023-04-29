/*    */ package mzm.gsp.ladder;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleLadderLoginInfo implements Marshal, Comparable<RoleLadderLoginInfo>
/*    */ {
/*    */   public static final int NOMAL_STAGE = 0;
/*    */   public static final int READY_STAGE = 1;
/*    */   public static final int MATCH_STAGE = 2;
/*    */   public RoleLadderInfo roleladderinfo;
/*    */   public int matchstage;
/*    */   
/*    */   public RoleLadderLoginInfo()
/*    */   {
/* 17 */     this.roleladderinfo = new RoleLadderInfo();
/*    */   }
/*    */   
/*    */   public RoleLadderLoginInfo(RoleLadderInfo _roleladderinfo_, int _matchstage_) {
/* 21 */     this.roleladderinfo = _roleladderinfo_;
/* 22 */     this.matchstage = _matchstage_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     if (!this.roleladderinfo._validator_()) return false;
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.roleladderinfo);
/* 32 */     _os_.marshal(this.matchstage);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.roleladderinfo.unmarshal(_os_);
/* 38 */     this.matchstage = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof RoleLadderLoginInfo)) {
/* 45 */       RoleLadderLoginInfo _o_ = (RoleLadderLoginInfo)_o1_;
/* 46 */       if (!this.roleladderinfo.equals(_o_.roleladderinfo)) return false;
/* 47 */       if (this.matchstage != _o_.matchstage) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += this.roleladderinfo.hashCode();
/* 56 */     _h_ += this.matchstage;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.roleladderinfo).append(",");
/* 64 */     _sb_.append(this.matchstage).append(",");
/* 65 */     _sb_.append(")");
/* 66 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RoleLadderLoginInfo _o_) {
/* 70 */     if (_o_ == this) return 0;
/* 71 */     int _c_ = 0;
/* 72 */     _c_ = this.roleladderinfo.compareTo(_o_.roleladderinfo);
/* 73 */     if (0 != _c_) return _c_;
/* 74 */     _c_ = this.matchstage - _o_.matchstage;
/* 75 */     if (0 != _c_) return _c_;
/* 76 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\RoleLadderLoginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */