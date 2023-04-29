/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class NotifyCrossCompeteResultReq
/*    */   implements Marshal, Comparable<NotifyCrossCompeteResultReq>
/*    */ {
/*    */   public long win_factionid;
/*    */   public long lose_factionid;
/*    */   
/*    */   public NotifyCrossCompeteResultReq() {}
/*    */   
/*    */   public NotifyCrossCompeteResultReq(long _win_factionid_, long _lose_factionid_)
/*    */   {
/* 18 */     this.win_factionid = _win_factionid_;
/* 19 */     this.lose_factionid = _lose_factionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.win_factionid);
/* 28 */     _os_.marshal(this.lose_factionid);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.win_factionid = _os_.unmarshal_long();
/* 34 */     this.lose_factionid = _os_.unmarshal_long();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof NotifyCrossCompeteResultReq)) {
/* 41 */       NotifyCrossCompeteResultReq _o_ = (NotifyCrossCompeteResultReq)_o1_;
/* 42 */       if (this.win_factionid != _o_.win_factionid) return false;
/* 43 */       if (this.lose_factionid != _o_.lose_factionid) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += (int)this.win_factionid;
/* 52 */     _h_ += (int)this.lose_factionid;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.win_factionid).append(",");
/* 60 */     _sb_.append(this.lose_factionid).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(NotifyCrossCompeteResultReq _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = Long.signum(this.win_factionid - _o_.win_factionid);
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = Long.signum(this.lose_factionid - _o_.lose_factionid);
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyCrossCompeteResultReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */