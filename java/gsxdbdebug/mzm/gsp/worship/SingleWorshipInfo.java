/*    */ package mzm.gsp.worship;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class SingleWorshipInfo
/*    */   implements Marshal, Comparable<SingleWorshipInfo>
/*    */ {
/*    */   public long roleid;
/*    */   public int worshipid;
/*    */   public int contentindex;
/*    */   
/*    */   public SingleWorshipInfo() {}
/*    */   
/*    */   public SingleWorshipInfo(long _roleid_, int _worshipid_, int _contentindex_)
/*    */   {
/* 19 */     this.roleid = _roleid_;
/* 20 */     this.worshipid = _worshipid_;
/* 21 */     this.contentindex = _contentindex_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.roleid);
/* 30 */     _os_.marshal(this.worshipid);
/* 31 */     _os_.marshal(this.contentindex);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.roleid = _os_.unmarshal_long();
/* 37 */     this.worshipid = _os_.unmarshal_int();
/* 38 */     this.contentindex = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof SingleWorshipInfo)) {
/* 45 */       SingleWorshipInfo _o_ = (SingleWorshipInfo)_o1_;
/* 46 */       if (this.roleid != _o_.roleid) return false;
/* 47 */       if (this.worshipid != _o_.worshipid) return false;
/* 48 */       if (this.contentindex != _o_.contentindex) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += (int)this.roleid;
/* 57 */     _h_ += this.worshipid;
/* 58 */     _h_ += this.contentindex;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.roleid).append(",");
/* 66 */     _sb_.append(this.worshipid).append(",");
/* 67 */     _sb_.append(this.contentindex).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SingleWorshipInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.worshipid - _o_.worshipid;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.contentindex - _o_.contentindex;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\SingleWorshipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */