/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class HubCorpsCVCInfo
/*    */   implements Marshal, Comparable<HubCorpsCVCInfo>
/*    */ {
/*    */   public int win;
/*    */   public int lose;
/*    */   
/*    */   public HubCorpsCVCInfo() {}
/*    */   
/*    */   public HubCorpsCVCInfo(int _win_, int _lose_)
/*    */   {
/* 18 */     this.win = _win_;
/* 19 */     this.lose = _lose_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.win);
/* 28 */     _os_.marshal(this.lose);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.win = _os_.unmarshal_int();
/* 34 */     this.lose = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof HubCorpsCVCInfo)) {
/* 41 */       HubCorpsCVCInfo _o_ = (HubCorpsCVCInfo)_o1_;
/* 42 */       if (this.win != _o_.win) return false;
/* 43 */       if (this.lose != _o_.lose) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.win;
/* 52 */     _h_ += this.lose;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.win).append(",");
/* 60 */     _sb_.append(this.lose).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(HubCorpsCVCInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.win - _o_.win;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.lose - _o_.lose;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\HubCorpsCVCInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */