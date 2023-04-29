/*    */ package mzm.gsp.activitypointexchange;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class ManualRefreshCountInfo
/*    */   implements Marshal, Comparable<ManualRefreshCountInfo>
/*    */ {
/*    */   public int manualrefreshcount;
/*    */   public long manualrefreshcountresettimestamp;
/*    */   
/*    */   public ManualRefreshCountInfo() {}
/*    */   
/*    */   public ManualRefreshCountInfo(int _manualrefreshcount_, long _manualrefreshcountresettimestamp_)
/*    */   {
/* 18 */     this.manualrefreshcount = _manualrefreshcount_;
/* 19 */     this.manualrefreshcountresettimestamp = _manualrefreshcountresettimestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.manualrefreshcount);
/* 28 */     _os_.marshal(this.manualrefreshcountresettimestamp);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.manualrefreshcount = _os_.unmarshal_int();
/* 34 */     this.manualrefreshcountresettimestamp = _os_.unmarshal_long();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof ManualRefreshCountInfo)) {
/* 41 */       ManualRefreshCountInfo _o_ = (ManualRefreshCountInfo)_o1_;
/* 42 */       if (this.manualrefreshcount != _o_.manualrefreshcount) return false;
/* 43 */       if (this.manualrefreshcountresettimestamp != _o_.manualrefreshcountresettimestamp) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.manualrefreshcount;
/* 52 */     _h_ += (int)this.manualrefreshcountresettimestamp;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.manualrefreshcount).append(",");
/* 60 */     _sb_.append(this.manualrefreshcountresettimestamp).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ManualRefreshCountInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.manualrefreshcount - _o_.manualrefreshcount;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = Long.signum(this.manualrefreshcountresettimestamp - _o_.manualrefreshcountresettimestamp);
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\ManualRefreshCountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */